package com.mozart.model.ejb.facade;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.delegate.CheckinDelegate;
import com.mozart.model.delegate.ContabilidadeDelegate;
import com.mozart.model.ejb.entity.ClassificacaoContabilEJB;
import com.mozart.model.ejb.entity.ContaCorrenteEJB;
import com.mozart.model.ejb.entity.ContasPagarEJB;
import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.DuplicataDescontadaEJB;
import com.mozart.model.ejb.entity.DuplicataEJB;
import com.mozart.model.ejb.entity.DuplicataHistoricoEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJBPK;
import com.mozart.model.ejb.entity.FornecedorHotelEJB;
import com.mozart.model.ejb.entity.FornecedorHotelEJBPK;
import com.mozart.model.ejb.entity.HistoricoContabilEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoContabilEJB;
import com.mozart.model.ejb.entity.PlanoContaEJB;
import com.mozart.model.ejb.entity.TesourariaEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ClassificacaoContabilVO;
import com.mozart.model.vo.ContasPagarComissaoVO;
import com.mozart.model.vo.ContasPagarVO;
import com.mozart.model.vo.DuplicataVO;
import com.mozart.model.vo.MovimentoContabilVO;
import com.mozart.model.vo.RpsVO;
import com.mozart.model.vo.TesourariaVO;

@Stateless(name = "FinanceiroSession")
@SuppressWarnings("unchecked")
public class FinanceiroSessionBean implements FinanceiroSession {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DuplicataVO> pesquisarDuplicata(DuplicataVO filtro)
			throws MozartSessionException {
		try {
			String sql = "";
			String orderBy = " ORDER BY EM.NOME_FANTASIA, STATUS_NOTA.NUM_NOTA,  DU.DATA_VENCIMENTO";
			if ("1".equals(filtro.getFiltroTipoPesquisa())) {
				sql = QRY_DUPLICATA_TEMP;
			} else if ("2".equals(filtro.getFiltroTipoPesquisa())) {
				sql = QRY_DUPLICATA;
			} else {
				sql = QRY_DUPLICATA_COMBO;
				orderBy = " ORDER BY EM.NOME_FANTASIA, STATUS_NOTA.NUM_NOTA, NUM_DUPLICATA, NUM_PARCELAS, DU.DATA_VENCIMENTO ";
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataLancamento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(DU.DATA_LANCAMENTO) "
						+ filtro.getFiltroDataLancamento();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataVencimento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(DU.DATA_VENCIMENTO) "
						+ filtro.getFiltroDataVencimento();
			}
			if (!MozartUtil
					.isNull(filtro.getFiltroEmpresa().getTipoIntervalo())) {
				sql = sql + " AND UPPER(EM.NOME_FANTASIA)  "
						+ filtro.getFiltroEmpresa();
			}
			if (!MozartUtil.isNull(filtro.getFiltroNumDuplicata()
					.getTipoIntervalo())) {
				sql =

				sql
						+ ("1".equals(filtro.getFiltroTipoPesquisa()) ? " AND DU.ID_DUPLICATA_TEMP "
								: " AND NUM_DUPLICATA ")
						+ filtro.getFiltroNumDuplicata();
			}
			if (!MozartUtil
					.isNull(filtro.getFiltroNumNota().getTipoIntervalo())) {
				sql = sql + " AND STATUS_NOTA.NUM_NOTA "
						+ filtro.getFiltroNumDuplicata();
			}
			if (!MozartUtil.isNull(filtro.getFiltroValorDuplicata()
					.getTipoIntervalo())) {
				sql = sql + " AND VALOR_DUPLICATA "
						+ filtro.getFiltroValorDuplicata();
			}
			if (!MozartUtil.isNull(filtro.getFiltroBanco().getTipoIntervalo())) {
				sql = sql + " AND B.ID_BANCO " + filtro.getFiltroBanco();
			}
			if (!MozartUtil.isNull(filtro.getFiltroContaCorrente()
					.getTipoIntervalo())) {
				// TODO: (ID/Conta Corrente) 
//				sql = sql + " AND du.CONTA_CORRENTE "
				sql = sql + " AND du.ID_CONTA_CORRENTE "
						+ filtro.getFiltroContaCorrente();
			}
			if (!MozartUtil.isNull(filtro.getFiltroIds()) && !filtro.getFiltroIds().equalsIgnoreCase("-1")) {
				sql = sql + " and instr('," + filtro.getFiltroIds()
						+ ",', ','||du.id_duplicata||',') >= 1 ";
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||du.id_hotel||';') >= 1 ";
			}
			sql = sql + orderBy;

			List lista = null;
			lista = this.manager.createNativeQuery(sql).getResultList();

			List<DuplicataVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new DuplicataVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gerarUnificarDuplicata(HotelEJB hotel, Long[] idDuplicata,
			String tipo) throws MozartSessionException {
		if (MozartUtil.isNull(idDuplicata)) {
			throw new MozartValidateException("Informe as duplicatas");
		}
		try {
			String idDuplicataStr = "";
			for (Long id : idDuplicata) {
				idDuplicataStr = idDuplicataStr.concat(id.toString()).concat(
						",");
			}
			idDuplicataStr = idDuplicataStr.substring(0, idDuplicataStr
					.length() - 1);
			if ("UNIFICAR".equals(tipo)) {
				this.manager.createNativeQuery(
						"{call PROC_UNIFICAR_DUPLICATA_WEB(?1, ?2)}")
						.setParameter(1, hotel.getIdHotel()).setParameter(2,
								idDuplicataStr).executeUpdate();
			} else if ("GERAR".equals(tipo)) {
				this.manager.createNativeQuery(
						"{call PROC_GERAR_DUPLICATA_WEB(?1, ?2)}")
						.setParameter(1, hotel.getIdHotel()).setParameter(2,
								idDuplicataStr).executeUpdate();
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarParcelamento(DuplicataEJB entidade,
			List<DuplicataEJB> parcelas) throws MozartSessionException {
		validarParcelamento(entidade, parcelas);
		try {
			int x = 1;
			int parcelaOriginal = ((DuplicataEJB) parcelas.get(0))
					.getNumParcelas().intValue();
			for (DuplicataEJB parcela : parcelas) {
				DuplicataEJB par = entidade.clone();
				par.setNumDuplicata(par.getNumDuplicata().trim() + "-"
						+ String.valueOf(parcelaOriginal));
				par.setNumParcelas(new Long(x));
				par.setComissao(parcela.getComissao());
				par.setEncargos(parcela.getEncargos());
				par.setAjustes(parcela.getAjustes());
				par.setIr(parcela.getIr());
				par.setValorDuplicata(parcela.getValorDuplicata());
				par.setDataVencimento(parcela.getDataVencimento());
				if (x > 1) {
					par.setIdDuplicata(null);
					this.manager.persist(par);
				} else {
					this.manager.merge(par);
				}
				x++;
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	private void validarParcelamento(DuplicataEJB entidade,
			List<DuplicataEJB> parcelas) throws MozartValidateException {
		if (MozartUtil.isNull(entidade)) {
			throw new MozartValidateException(
					"O campo 'Duplicata' é obrigatório.");
		}
		if (MozartUtil.isNull(parcelas)) {
			throw new MozartValidateException(
					"O campo 'Parcela' é obrigatório.");
		}
		Double totalComissao = Double.valueOf(0.0D);
		Double totalEncargos = Double.valueOf(0.0D);
		Double totalAjustes = Double.valueOf(0.0D);
		Double totalIR = Double.valueOf(0.0D);
		Double totalParcela = Double.valueOf(0.0D);
		for (DuplicataEJB parcela : parcelas) {
			totalComissao = Double.valueOf(totalComissao.doubleValue()
					+ MozartUtil.round(parcela.getComissao()).doubleValue());
			totalEncargos = Double.valueOf(totalEncargos.doubleValue()
					+ MozartUtil.round(parcela.getEncargos()).doubleValue());
			totalAjustes = Double.valueOf(totalAjustes.doubleValue()
					+ MozartUtil.round(parcela.getAjustes()).doubleValue());
			totalIR = Double.valueOf(totalIR.doubleValue()
					+ MozartUtil.round(parcela.getIr()).doubleValue());
			totalParcela = Double.valueOf(totalParcela.doubleValue()
					+ MozartUtil.round(parcela.getValorDuplicata())
							.doubleValue());
		}
		if (MozartUtil.round(Double.valueOf(totalComissao.doubleValue()))
				.doubleValue() != entidade.getComissao().doubleValue()) {
			throw new MozartValidateException(
					"Os valores das comissões não conferem.");
		}
		if (MozartUtil.round(Double.valueOf(totalEncargos.doubleValue()))
				.doubleValue() != entidade.getEncargos().doubleValue()) {
			throw new MozartValidateException(
					"Os valores dos encargos não conferem.");
		}
		if (MozartUtil.round(Double.valueOf(totalAjustes.doubleValue()))
				.doubleValue() != entidade.getAjustes().doubleValue()) {
			throw new MozartValidateException(
					"Os valores dos ajustes não conferem.");
		}
		if (MozartUtil.round(Double.valueOf(totalIR.doubleValue()))
				.doubleValue() != entidade.getIr().doubleValue()) {
			throw new MozartValidateException(
					"Os valores dos IRs não conferem.");
		}
		if (MozartUtil.round(Double.valueOf(totalParcela.doubleValue()))
				.doubleValue() != entidade.getValorDuplicata().doubleValue()) {
			throw new MozartValidateException(
					"Os valores das parcelas não conferem.");
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrarFaturamento(HotelEJB hotel)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call PROC_ENCERRA_FATURAMENTO_WEB(?1)}").setParameter(1,
					hotel.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}

	public List obterValidacao(Long pIdHotel) throws MozartSessionException {
		try {
			String qry = " SELECT trunc(FRONT_OFFICE) - trunc(FATURAMENTO_CONTAS_RECEBER) VAL  FROM CONTROLA_DATA WHERE ID_HOTEL = ?1  UNION ALL  SELECT COUNT(*) FROM DUPLICATA_TEMP DT, CONTROLA_DATA CD WHERE CD.ID_HOTEL = ?2 AND CD.ID_HOTEL = DT.ID_HOTEL AND TRUNC(DATA_LANCAMENTO) = TRUNC(FATURAMENTO_CONTAS_RECEBER)  UNION ALL  SELECT COUNT(*) FROM CLASSIFICACAO_CONTABIL WHERE ID_HOTEL = ?3 AND DESCRICAO LIKE 'FAT%' ";

			return this.manager.createNativeQuery(qry)
					.setParameter(1, pIdHotel).setParameter(2, pIdHotel)
					.setParameter(3, pIdHotel).getResultList();
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}

	public List<DuplicataVO> pesquisarContasReceber(DuplicataVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_CONTAS_RECEBER;
			String orderBy = " ORDER BY DU.DATA_VENCIMENTO ";
			if (!MozartUtil.isNull(filtro.getFiltroDataDesconto()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(DU.DATA_DESCONTO) "
						+ filtro.getFiltroDataDesconto();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataLancamento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(DU.DATA_LANCAMENTO) "
						+ filtro.getFiltroDataLancamento();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataProrrogacao()
					.getTipoIntervalo())) {
				sql = sql + " AND DU.PRORROGADO "
						+ filtro.getFiltroDataProrrogacao();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataRecebimento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(DU.DATA_RECEBIMENTO) "
						+ filtro.getFiltroDataRecebimento();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataRecompra()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(DU.DATA_RECOMPRA) "
						+ filtro.getFiltroDataRecompra();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataVencimento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(DU.DATA_VENCIMENTO) "
						+ filtro.getFiltroDataVencimento();
			}
			if (!MozartUtil
					.isNull(filtro.getFiltroEmpresa().getTipoIntervalo())) {
				sql = sql + " AND UPPER(Er.NOME_FANTASIA)  "
						+ filtro.getFiltroEmpresa();
			}
			if (!MozartUtil.isNull(filtro.getFiltroNumDuplicata()
					.getTipoIntervalo())) {
				sql = sql + " AND NUM_DUPLICATA "
						+ filtro.getFiltroNumDuplicata();
			}
			if (!MozartUtil
					.isNull(filtro.getFiltroNumLote().getTipoIntervalo())) {
				sql = sql + " AND DU.ID_DUPLICATA_DESCONTADA "
						+ filtro.getFiltroNumLote();
			}
			if (!MozartUtil.isNull(filtro.getFiltroValorDuplicata()
					.getTipoIntervalo())) {
				sql = sql + " AND VALOR_DUPLICATA "
						+ filtro.getFiltroValorDuplicata();
			}
			if (!MozartUtil.isNull(filtro.getFiltroBanco().getTipoIntervalo())) {
				sql = sql + " AND B.ID_BANCO " + filtro.getFiltroBanco();
			}
			if ("3".equals(filtro.getFiltroTipoPesquisa())) {
				sql = sql
						+ " AND DATA_DESCONTO IS NOT NULL AND DATA_RECEBIMENTO IS NULL AND DATA_RECOMPRA IS NULL ";
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||CD.id_hotel||';') >= 1 ";
			}
			sql = sql + orderBy;

			List lista = null;
			lista = this.manager
					.createNativeQuery(sql)
					.setParameter(
							1,

							"2".equals(filtro.getFiltroTipoPesquisa()) ? "R"
									: "1"
											.equals(filtro
													.getFiltroTipoPesquisa()) ? "A"
											: "%").getResultList();

			List<DuplicataVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new DuplicataVO((Object[]) l, 1));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void receberDuplicatas(DuplicataVO rec,
			List<DuplicataVO> listaRecebimento) throws MozartSessionException {
		try {
			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, rec.getIdHoteis()[0]);
			for (DuplicataVO dup : listaRecebimento) {
				DuplicataEJB dupRec = (DuplicataEJB) this.manager.find(
						DuplicataEJB.class, dup.getIdDuplicata());
				if (!"A".equals(dupRec.getSituacao())) {
					throw new MozartValidateException("A duplicata: "
							+ dup.getNumDuplicata() + " não está mais aberta.");
				}
				dupRec.setSituacao("R");
				dupRec.setDataRecebimento(controlaData.getContasReceber());
				EmpresaHotelEJBPK idEmpresa = new EmpresaHotelEJBPK();
				idEmpresa.idHotel = rec.getIdHoteis()[0];
				idEmpresa.idEmpresa = dup.getIdEmpresa();
				dupRec.setEmpresaHotelEJB((EmpresaHotelEJB) CheckinDelegate
						.instance().obter(EmpresaHotelEJB.class, idEmpresa));

				dupRec.setContaCorrente((ContaCorrenteEJB) CheckinDelegate
						.instance().obter(ContaCorrenteEJB.class, dup.getIdContaCorrente()));
				dupRec.setJurosRecebimento(dup.getJuros());
				dupRec.setDescontoRecebimento(dup.getDescontoRecebimento());
				dupRec.setIrRetencao(dup.getRetencao());
				dupRec.setCofins(dup.getCofins());
				dupRec.setPis(dup.getPis());
				dupRec.setCssl(dup.getCssl());
				dupRec.setIss(dup.getIss());
				dupRec.setIdPlanoContas(dup.getIdPlanoContas());
				dupRec.setIdCentroCustoContabil(dup.getIdCentroCusto());
				dupRec.setHistoricoComplementar(dup.getJustificativa());
				dupRec.setValorRecebido(dup.getValorRecebidoCalculado());
				dupRec.setRecebimento("T");
				dupRec.setAgrupar(dup.getAgrupar());
				dupRec.setNumDocumento(rec.getNumDocTesouraria());
				if (!MozartUtil.isNull(dup.getDataProrrogado())) {
					dupRec.setProrrogado(new Timestamp(dup.getDataProrrogado()
							.getTime()));
				}else{
					dupRec.setProrrogado(new Timestamp(dup.getDataVencimento()
							.getTime()));
				}
				this.manager.merge(dupRec);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void descontarDuplicatas(DuplicataVO rec,
			List<DuplicataVO> listaDesconto) throws MozartSessionException {
		try {
			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, rec.getIdHoteis()[0]);
			for (DuplicataVO dup : listaDesconto) {
				DuplicataEJB dupDesc = (DuplicataEJB) this.manager.find(
						DuplicataEJB.class, dup.getIdDuplicata());
				if (!"A".equals(dupDesc.getSituacao())) {
					throw new MozartValidateException("A duplicata: "
							+ dup.getNumDuplicata() + " não está mais aberta.");
				}
				dupDesc.setSituacao("D");
				dupDesc.setDataDesconto(controlaData.getContasReceber());

				EmpresaHotelEJBPK idEmpresa = new EmpresaHotelEJBPK();
				idEmpresa.idHotel = rec.getIdHoteis()[0];
				idEmpresa.idEmpresa = dup.getIdEmpresa();
				dupDesc.setEmpresaHotelEJB((EmpresaHotelEJB) CheckinDelegate
						.instance().obter(EmpresaHotelEJB.class, idEmpresa));

				dupDesc.setContaCorrente((ContaCorrenteEJB) CheckinDelegate
						.instance().obter(ContaCorrenteEJB.class, dup.getIdContaCorrente()));
				dupDesc.setJurosRecebimento(dup.getJuros());
				dupDesc.setDescontoRecebimento(dup.getDescontoRecebimento());
				dupDesc.setIrRetencao(dup.getRetencao());
				dupDesc.setCofins(dup.getCofins());
				dupDesc.setPis(dup.getPis());
				dupDesc.setCssl(dup.getCssl());
				dupDesc.setIss(dup.getIss());
				dupDesc.setIdPlanoContas(dup.getIdPlanoContas());
				dupDesc.setIdCentroCustoContabil(dup.getIdCentroCusto());
				dupDesc.setHistoricoComplementar(dup.getJustificativa());
				dupDesc.setRecebimento("T");
				dupDesc.setAgrupar(dup.getAgrupar());

				this.manager.merge(dupDesc);
				
				DuplicataDescontadaEJB dupDescontada = new DuplicataDescontadaEJB();
				dupDescontada.setContaCorrente(dupDesc.getContaCorrente().getId());
				dupDescontada.setDataDesconto(dupDesc.getDataDesconto());
				dupDescontada.setIdCentroCusto(dupDesc
						.getIdCentroCustoContabil());
				dupDescontada.setIdDuplicataDescontada(dupDesc.getIdDuplicata()
						.longValue());
				dupDescontada.setIdHotel(rec.getIdHoteis()[0]);
				dupDescontada.setValor(dupDesc.getValorLiquido());				
				
				this.manager.persist(dupDescontada);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrarContasReceber(HotelEJB hotel)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call PROC_ENCERRA_CON_REC_WEB(?1)}").setParameter(1,
					hotel.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}

	public List<ContasPagarVO> pesquisarContasPagar(ContasPagarVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_CONTAS_PAGAR;

			String orderBy = " ORDER BY CP.DATA_VENCIMENTO ";
			if (!MozartUtil.isNull(filtro.getFiltroDataLancamento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(CP.DATA_LANCAMENTO) "
						+ filtro.getFiltroDataLancamento();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataPagamento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(CP.DATA_PAGAMENTO) "
						+ filtro.getFiltroDataPagamento();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataProrrogacao()
					.getTipoIntervalo())) {
				sql = sql + " AND CP.PRORROGACAO "
						+ filtro.getFiltroDataProrrogacao();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataVencimento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(CP.DATA_VENCIMENTO) "
						+ filtro.getFiltroDataVencimento();
			}
			if (!MozartUtil
					.isNull(filtro.getFiltroEmpresa().getTipoIntervalo())) {
				sql = sql + " AND UPPER(FR.NOME_FANTASIA)  "
						+ filtro.getFiltroEmpresa();
			}
			if (!MozartUtil.isNull(filtro.getFiltroValorDuplicata()
					.getTipoIntervalo())) {
				sql = sql + " AND VALOR_PAGAMENTO "
						+ filtro.getFiltroValorDuplicata();
			}
			if (!MozartUtil.isNull(filtro.getFiltroSituacao()
					.getTipoIntervalo())) {
				sql = sql + " AND SITUACAO " + filtro.getFiltroSituacao();
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||CP.id_hotel||';') >= 1 ";
			}
			sql = sql + orderBy;

			List<?> lista = null;
			lista = this.manager
					.createNativeQuery(sql)
					.setParameter(
							1,

							"2".equals(filtro.getFiltroTipoPesquisa()) ? "S"
									: "1"
											.equals(filtro
													.getFiltroTipoPesquisa()) ? "N"
											: "%").getResultList();

			List<ContasPagarVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new ContasPagarVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<ContasPagarComissaoVO> pesquisarContasPagarComissao(ContasPagarComissaoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_CONTAS_PAGAR_COMISSAO;
			
			if (!MozartUtil.isNull(filtro.getFiltroNomeHospede()
					.getTipoIntervalo())) {
				sql = sql + " AND RL.NOME_HOSPEDE "
						+ filtro.getFiltroNomeHospede();
			}
			
			sql = sql.concat(
					" GROUP BY EH.PRAZO_PAGAMENTO,MA.ID_MOVIMENTO_APARTAMENTO, MA.DATA_LANCAMENTO, MA.ID_CONTAS_PAGAR, ER.NOME_FANTASIA, ER.ID_EMPRESA,  " +
					" EH.COMISSAO, MA.ID_NOTA, RL.NOME_HOSPEDE, SN.NUM_NOTA, TL.DESCRICAO_LANCAMENTO,  " +
					" CC.ID_CONTA_CORRENTE, HO.SIGLA, CB_C.ID_PLANO_CONTAS_CREDITO, CB_C.ID_CENTRO_CUSTO_CREDITO,  " +
					" CB_D.ID_PLANO_CONTAS_DEBITO, CB_D.ID_CENTRO_CUSTO_DEBITO, PC_C.ID_HISTORICO_CREDITO,  " +
					" PC_D.ID_HISTORICO_DEBITO, ch.id_checkin, CB_C.ID_PLANO_CONTAS_FINANCEIRO        " +
					" ORDER BY MA.DATA_LANCAMENTO, ER.NOME_FANTASIA) TBL ");
			
			String queryInicio = sql.substring(0, sql.indexOf("TBL.ID_CONTAS_PAGAR, "));
			String queryFim = sql.substring(sql.indexOf("TBL.ID_CONTAS_PAGAR, "), sql.length() - 1);
			
			if(filtro.getFiltroTipoPesquisa().equals("1")){//a gerar
				sql = queryInicio.concat(
						" null, "
						);
				sql = sql.concat(queryFim);
				
				sql = sql.concat(" WHERE TBL.ID_CONTAS_PAGAR IS NULL");
				if(!MozartUtil.isNull(filtro.getFiltroNomeFantasia()
						.getTipoIntervalo())){
					sql = sql + " AND TBL.NOME_FANTASIA "
							+ filtro.getFiltroNomeFantasia();		
				}				
			}else if(filtro.getFiltroTipoPesquisa().equals("2")){//gerado
				sql = queryInicio.concat(
						" CP.DATA_LANCAMENTO, "
						);
				sql = sql.concat(queryFim);
				
				sql = sql.concat(
				    " JOIN CONTAS_PAGAR CP ON (CP.ID_CONTAS_PAGAR = TBL.ID_CONTAS_PAGAR)" + 
				    " JOIN FORNECEDOR_REDE FR ON (CP.ID_FORNECEDOR = FR.ID_FORNECEDOR)" +
					" WHERE TBL.ID_CONTAS_PAGAR IS NOT NULL"
				);
				
				if (!MozartUtil.isNull(filtro.getFiltroData()
						.getTipoIntervalo())) {
					sql = sql + " AND TRUNC(CP.DATA_LANCAMENTO) "
							+ filtro.getFiltroData();
				}	
				
				if(!MozartUtil.isNull(filtro.getFiltroNomeFantasia()
						.getTipoIntervalo())){
					sql = sql + " AND FR.NOME_FANTASIA "
							+ filtro.getFiltroNomeFantasia();
				}
				
				if (!MozartUtil.isNull(filtro.getFiltroNumNota()
						.getTipoIntervalo())) {
					sql = sql + " AND TBL.NUM_NOTA "
							+ filtro.getFiltroNumNota();
				}
			}
			
			if (!MozartUtil.isNull(filtro.getFiltroDataSaida()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(TBL.DATA_LANCAMENTO) "
						+ filtro.getFiltroDataSaida();
			}
			
			if (!MozartUtil.isNull(filtro.getFiltroValor()
					.getTipoIntervalo())) {
				sql = sql + " AND TBL.VALOR_LANCAMENTO "
						+ filtro.getFiltroValor();
			}
			
			sql = sql.concat(
				" GROUP BY  TBL.PRAZO_PAGAMENTO,TBL.DATA_LANCAMENTO, TBL.VALOR_LANCAMENTO, TBL.ID_CONTAS_PAGAR, TBL.NOME_FANTASIA, TBL.ID_EMPRESA, " +
				" TBL.COMISSAO, TBL.ID_NOTA, TBL.NOME_HOSPEDE, TBL.NUM_NOTA, TBL.ID_CONTA_CORRENTE, TBL.SIGLA, TBL.ID_PLANO_CONTAS_CREDITO,  " +
				" TBL.ID_CENTRO_CUSTO_CREDITO, TBL.ID_PLANO_CONTAS_DEBITO, TBL.ID_CENTRO_CUSTO_DEBITO, TBL.ID_HISTORICO_CREDITO," + 
	            " TBL.ID_HISTORICO_DEBITO, TBL.ID_PLANO_CONTAS_FINANCEIRO"); 
				
			if(filtro.getFiltroTipoPesquisa().equals("2")){//gerado
				sql = sql.concat(", CP.DATA_LANCAMENTO ");
			}
			
			sql = sql.concat(" ORDER BY TBL.DATA_LANCAMENTO, TBL.NOME_FANTASIA");
			
			String idHoteis = "";
			
			for(Long idHotel : filtro.getIdHoteis()){
				idHoteis = idHoteis.concat(String.valueOf(idHotel)).concat(", ");
			}
			idHoteis = idHoteis.substring(0, idHoteis.length() - 2);
			
			List<?> lista = this.manager.createNativeQuery(sql)
				.setParameter(1, idHoteis)
				.setParameter(2, idHoteis)
				.setParameter(3, idHoteis)
				.getResultList();
			
			List<ContasPagarComissaoVO> resultado = new ArrayList<ContasPagarComissaoVO>();
					
			for (Object l : lista) {
				resultado.add(new ContasPagarComissaoVO((Object[]) l));
			}

			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<FornecedorHotelEJB> obterFornecedorLookup(
			FornecedorHotelEJB pFiltro) throws MozartSessionException {
		try {
			

			return this.manager
					.createNamedQuery("FornecedorHotelEJB.findPorIdhoteANDLikeNomeFantasiaFornecedorRede")
					.setParameter("idHotel", pFiltro.getIdHotel())
					.setParameter("likeNomeFantasia", "%"+pFiltro.getFornecedorRedeEJB().getNomeFantasia()+"%")
					.getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<HistoricoContabilEJB> obterHistoricoContabil(
			HistoricoContabilEJB filtro) throws MozartSessionException {
		try {
			String sql = "select o from HistoricoContabilEJB o where o.idRedeHotel = ?1 order by o.historico";

			return this.manager.createQuery(sql).setHint("eclipselink.refresh",
					"TRUE").setParameter(1, filtro.getIdRedeHotel())
					.getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ClassificacaoContabilVO> obterClassificacaoContabil(
			ClassificacaoContabilVO filtro) throws MozartSessionException {
		try {
			String sql = "select * from (SELECT MIN(ID_CLASSIFICACAO_CONTABIL)ID_CLASSIFICACAO_CONTABIL, SUBSTR(DESCRICAO, 4) DESCRICAO, null ID_PLANO_CONTAS_FINANCEIRO FROM CLASSIFICACAO_CONTABIL WHERE ID_HOTEL = ?1 AND DESCRICAO LIKE 'LP%' GROUP BY SUBSTR(DESCRICAO, 4), NULL) order by DESCRICAO";

			List<Object[]> lista = this.manager.createNativeQuery(sql)
					.setParameter(1, filtro.getIdHoteis()[0]).getResultList();

			List<ClassificacaoContabilVO> resultList = new ArrayList();
			for (Object[] linha : lista) {
				resultList.add(new ClassificacaoContabilVO(linha));
			}
			return resultList;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarContasPagar(ContasPagarEJB entidadeCP,
			DuplicataHistoricoEJB entidadeHistorico)
			throws MozartSessionException {
		try {
			if (entidadeCP.getIdContasPagar() == null) {
				entidadeCP.getFornecedorHotelEJB().setIdFornecedor(entidadeCP.getFornecedorHotelEJB().getFornecedorRedeEJB().getIdFornecedor());
				this.manager.persist(entidadeCP);
			} else {
				this.manager.merge(entidadeCP);
			}
			if (!MozartUtil.isNull(entidadeHistorico.getNumeroForma())) {
				String sqlInsert = " INSERT INTO HISTORICO_TITULOS (ID_HISTORICO_TITULOS, ID_HOTEL, ID_TITULO, DATA, FORMA, NUMERO_FORMA, CONTATO, OBSERVACOES)  VALUES (ID.NEXTVAL, ?1, ?2, ?3, ?4, ?5, ?6, ?7)";

				this.manager.createNativeQuery(sqlInsert).setParameter(1,
						entidadeCP.getFornecedorHotelEJB().getIdHotel())
						.setParameter(2, entidadeCP.getIdContasPagar())
						.setParameter(3, entidadeHistorico.getData())
						.setParameter(4, entidadeHistorico.getForma())
						.setParameter(5, entidadeHistorico.getNumeroForma())
						.setParameter(6, entidadeHistorico.getContato())
						.setParameter(7, entidadeHistorico.getObservacoes())
						.executeUpdate();
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContasPagarEJB obterContasPagar(ContasPagarEJB entidadeCP)
			throws MozartSessionException {
		try {
			entidadeCP = (ContasPagarEJB) this.manager.find(
					ContasPagarEJB.class, entidadeCP.getIdContasPagar());
			this.manager.refresh(entidadeCP);

			String sqlHistorico = "SELECT ID_HISTORICO_TITULOS, ID_HOTEL, ID_TITULO, DATA, FORMA, NUMERO_FORMA, CONTATO, OBSERVACOES FROM HISTORICO_TITULOS  WHERE ID_TITULO = ?1";

			List<DuplicataHistoricoEJB> listaHistorico = this.manager
					.createNativeQuery(sqlHistorico,
							DuplicataHistoricoEJB.class).setParameter(1,
							entidadeCP.getIdContasPagar()).getResultList();

			entidadeCP.setHistoricoList(listaHistorico);

			return entidadeCP;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String obterProximoContasPagar(HotelEJB pHotel)
			throws MozartSessionException {
		if ((MozartUtil.isNull(pHotel))
				|| (MozartUtil.isNull(pHotel.getIdHotel()))) {
			throw new MozartValidateException(
					"obterProximoContasPagar:Informe o hotel");
		}
		try {
			Long pIdHotel = pHotel.getIdHotel();
			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, pIdHotel);
			Long numCP = controlaData.getUltimoNumContasPagar();
			controlaData.setUltimoNumContasPagar(Long
					.valueOf(numCP.longValue() + 1L));
			this.manager.merge(controlaData);
			return String.valueOf(numCP);
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void pagarTitulos(ContasPagarVO rec,
			List<ContasPagarVO> listaPagamento) throws MozartSessionException {
		try {
			ControlaDataEJB controlaData = (ControlaDataEJB) this.manager.find(
					ControlaDataEJB.class, rec.getIdHoteis()[0]);
			for (ContasPagarVO linha : listaPagamento) {
				ContasPagarEJB entidade = (ContasPagarEJB) this.manager.find(
						ContasPagarEJB.class, linha.getIdContasPagar());
				if ("S".equals(entidade.getPago())) {
					throw new MozartValidateException("O título: "
							+ linha.getDocumento() + " não está mais aberta.");
				}
				entidade.setSituacao("A");
				entidade.setPago("S");
				entidade.setDataPagamento(controlaData.getContasPagar());

				FornecedorHotelEJBPK idForn = new FornecedorHotelEJBPK();
				idForn.idHotel = rec.getIdHoteis()[0];
				idForn.idFornecedor = linha.getIdFornecedor();
				entidade
						.setFornecedorHotelEJB((FornecedorHotelEJB) CheckinDelegate
								.instance().obter(FornecedorHotelEJB.class,
										idForn));

				if (!MozartUtil.isNull(linha.getIdContaCorrente())) {
					entidade.setContaCorrente(linha.getIdContaCorrente());
				}
				
				entidade.setJuros(linha.getJuros());
				entidade.setDesconto(linha.getDesconto());
				entidade.setIdPlanoContasDebitoDesc(linha
						.getIdPlanoContasDesc());
				entidade.setIdCentroCustoContabilDesc(linha
						.getIdCentroCustoDesc());
				entidade.setJustificativaDesc(linha.getJustificativaDesc());
				entidade.setValorPagamento(linha.getValorLiquido().doubleValue());
				if (!MozartUtil.isNull(linha.getNumCheque())) {
					entidade.setNumCheque(linha.getNumCheque());
				}
				if (!MozartUtil.isNull(linha.getNomePortador())) {
					entidade.setPortador(linha.getNomePortador());
				}
				this.manager.merge(entidade);
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	private void validarParcelamento(ContasPagarEJB entidadeCP,
			List<ContasPagarEJB> parcelasCP) throws MozartValidateException {
		if (MozartUtil.isNull(entidadeCP)) {
			throw new MozartValidateException("O campo 'Título' é obrigatório.");
		}
		if (MozartUtil.isNull(parcelasCP)) {
			throw new MozartValidateException(
					"O campo 'Parcela' é obrigatório.");
		}
		Double totalAjustes = Double.valueOf(0.0D);
		Double totalParcela = Double.valueOf(0.0D);
		Double totalJuros = Double.valueOf(0.0D);
		for (ContasPagarEJB parcela : parcelasCP) {
			totalAjustes = Double.valueOf(totalAjustes.doubleValue()
					+ parcela.getDesconto().doubleValue());
			totalParcela = Double.valueOf(totalParcela.doubleValue()
					+ parcela.getValorBruto().doubleValue());
			totalJuros = Double.valueOf(totalJuros.doubleValue()
					+ parcela.getJuros().doubleValue());
		}
		if (MozartUtil.round(Double.valueOf(totalAjustes.doubleValue()))
				.doubleValue() != entidadeCP.getDesconto().doubleValue()) {
			throw new MozartValidateException(
					"Os valores dos descontos não conferem.");
		}
		if (MozartUtil.round(Double.valueOf(totalParcela.doubleValue()))
				.doubleValue() != entidadeCP.getValorBruto().doubleValue()) {
			throw new MozartValidateException(
					"Os valores das parcelas não conferem.");
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarParcelamento(ContasPagarEJB entidadeCP,
			List<ContasPagarEJB> parcelasCP) throws MozartSessionException {
		validarParcelamento(entidadeCP, parcelasCP);
		try {
			int x = 1;
			int parcelaOriginal = ((ContasPagarEJB) parcelasCP.get(0))
					.getNumParcelas().intValue();
			for (ContasPagarEJB parcela : parcelasCP) {
				ContasPagarEJB par = entidadeCP.clone();
				par.setNumDocumento(par.getNumDocumento().trim() + "-"
						+ String.valueOf(parcelaOriginal));
				par.setNumParcelas(new Long(x));
				par.setDesconto(parcela.getDesconto());
				par.setValorBruto(parcela.getValorBruto());
				par.setDataVencimento(parcela.getDataVencimento());
				par.setJuros(parcela.getJuros());
				if (x > 1) {
					par.setIdContasPagar(null);
					this.manager.persist(par);
				} else {
					this.manager.merge(par);
				}
				x++;
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrarContasPagar(HotelEJB hotel)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call PROC_ENCERRA_CONTAS_PAGAR_WEB(?1)}").setParameter(1,
					hotel.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List obterValidacaoEncerramentoContasPagar(Long idHotel)
			throws MozartSessionException {
		try {
			String qry = "SELECT COUNT(*) FROM CLASSIFICACAO_CONTABIL WHERE ID_HOTEL = "
					+ idHotel + " AND DESCRICAO LIKE 'PAG%' ";
			return this.manager.createNativeQuery(qry).getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TesourariaVO> pesquisarTesouraria(TesourariaVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_TESOURARIA;
			// TODO: (ID/Conta Corrente) 
//			String orderBy = " ORDER BY NOME_CONTA, TESOURARIA.CONTA_CORRENTE,DATA_LANCAMENTO ";
			String orderBy = " ORDER BY NOME_CONTA, TESOURARIA.ID_CONTA_CORRENTE, DATA_LANCAMENTO ";
			if (!MozartUtil.isNull(filtro.getFiltroComplementoHistorico()
					.getTipoIntervalo())) {
				sql = sql + " AND TESOURARIA.COMPLEMENTO_HISTORICO "
						+ filtro.getFiltroComplementoHistorico();
			}
			if (!MozartUtil.isNull(filtro.getFiltroConciliado()
					.getTipoIntervalo())) {
				sql = sql + " AND TESOURARIA.CONCILIADO "
						+ filtro.getFiltroConciliado();
			}
			if (!MozartUtil.isNull(filtro.getFiltroContaCorrente()
					.getTipoIntervalo())) {
				// TODO: (ID/Conta Corrente) 
//				sql = sql + " AND TESOURARIA.CONTA_CORRENTE "
				sql = sql + " AND TESOURARIA.ID_CONTA_CORRENTE "
						+ filtro.getFiltroContaCorrente();
			}
			if (!MozartUtil.isNull(filtro.getFiltroContaReduzida()
					.getTipoIntervalo())) {
				sql = sql + " AND PLANO_CONTAS.CONTA_REDUZIDA "
						+ filtro.getFiltroContaReduzida();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataConciliado()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(TESOURARIA.DATA_CONCILIADO) "
						+ filtro.getFiltroDataConciliado();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataLancamento()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(TESOURARIA.DATA_LANCAMENTO) "
						+ filtro.getFiltroDataLancamento();
			}
			if (!MozartUtil.isNull(filtro.getFiltroNomeConta()
					.getTipoIntervalo())) {
				sql = sql + " AND PLANO_CONTAS.NOME_CONTA "
						+ filtro.getFiltroNomeConta();
			}
			if (!MozartUtil.isNull(filtro.getFiltroValor().getTipoIntervalo())) {
				sql = sql + " AND TESOURARIA.VALOR  " + filtro.getFiltroValor();
			}
			sql = sql + " AND INSTR('" + filtro.getIdHoteisSQL()
					+ "', ';'||HOTEL.ID_HOTEL||';') >= 1 ";

			sql = sql + orderBy;

			List lista = null;
			lista = this.manager.createNativeQuery(sql).getResultList();

			List<TesourariaVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new TesourariaVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ContaCorrenteEJB> obterContaCorrentePorPlanoContas(
			PlanoContaEJB filtro) throws MozartSessionException {
		try {
			return

			this.manager
					.createQuery(
							"select o from ContaCorrenteEJB o where o.idHotel = ?1 and o.idContabilRec = ?2")
					.setParameter(1, filtro.getIdHotel()).setParameter(2,
							filtro.getIdPlanoContas()).getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarTesouraria(HotelEJB hotel,
			List<TesourariaEJB> tesourariaList,
			List<MovimentoContabilEJB> movimentoSemTesourariaList,
			String origemMovimento) throws MozartSessionException {
		double valorD = 0.0D;
		double valorC = 0.0D;
		boolean alteracao = false;
		try {
			if ("CONTABILIDADE".equals(origemMovimento)) {
				MovimentoContabilVO saldoMovimento = ContabilidadeDelegate
						.instance().obterSaldoMovimentoContabil(hotel);
				valorC += saldoMovimento.getTotalCredito().doubleValue();
				valorD += saldoMovimento.getTotalDebito().doubleValue();
			} else {
				for (TesourariaEJB tes : tesourariaList) {
					if ("D".equals(tes.getDebitoCredito())) {
						valorD += tes.getValor().doubleValue();
					} else {
						valorC += tes.getValor().doubleValue();
					}
				}
			}
			for (MovimentoContabilEJB mov : movimentoSemTesourariaList) {
				if (mov.getIdMovimentoContabil() != null) {
					alteracao = true;
				}
				if ("D".equals(mov.getDebitoCredito())) {
					valorD += mov.getValor().doubleValue();
				} else {
					valorC += mov.getValor().doubleValue();
				}
				if (("S".equals(mov.getPlanoContaEJB().getTipoConta()))
						&& (hotel.getUsuario().getNivel().intValue() != 5)) {
					throw new MozartValidateException(
							"Usuário sem permissão para fazer esse lançamento.");
				}
			}
			if ((!alteracao)
					&& (MozartUtil.round(Double.valueOf(valorD)).doubleValue() != MozartUtil
							.round(Double.valueOf(valorC)).doubleValue())) {
				throw new MozartValidateException(
						"Os valores de Débito e Crédito não conferem");
			}
			for (TesourariaEJB tes : tesourariaList) {
				this.manager.persist(tes);
			}
			for (MovimentoContabilEJB mov : movimentoSemTesourariaList) {
				if (mov.getIdMovimentoContabil() == null) {
					this.manager.persist(mov);
				} else {
					this.manager.merge(mov);
				}
			}
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ClassificacaoContabilEJB> obterClassificacaoContabilPadrao(
			ClassificacaoContabilEJB filtro) throws MozartSessionException {
		return

		this.manager
				.createQuery(
						"select o from ClassificacaoContabilEJB o where o.idHotel = ?1 and o.idRedeHotel = ?2 and o.descricao = ?3")
				.setParameter(1, filtro.getIdHotel()).setParameter(2,
						filtro.getIdRedeHotel()).setParameter(3,
						"LP_" + filtro.getDescricao()).getResultList();
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void conciliarTesouraria(TesourariaVO filtro,
			List<TesourariaVO> listaConciliacao) throws MozartSessionException {
		try {
			for (TesourariaVO linha : listaConciliacao) {
				TesourariaEJB entidade = (TesourariaEJB) this.manager.find(
						TesourariaEJB.class, linha.getIdTesouraria());
				if (!MozartUtil.isNull(entidade.getDataConciliado())) {
					throw new MozartValidateException("O título: "
							+ linha.getContaCorrente() + ", "
							+ MozartUtil.format(linha.getDataLancamento())
							+ ", " + MozartUtil.format(linha.getValor())
							+ " já está conciliado.");
				}
				if (MozartUtil.isNull(linha.getDataConciliado())) {
					throw new MozartValidateException("O título: "
							+ linha.getDocumento()
							+ " está com sem a data de conciliação.");
				}
				entidade.setConciliado("S");
				entidade.setDataConciliado(linha.getDataConciliado());
				this.manager.merge(entidade);
			}
		} catch (MozartValidateException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrarTesouraria(HotelEJB hotel)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call PROC_ENCERRA_TESOURARIA_WEB(?1)}").setParameter(1,
					hotel.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}
	
	public List<RpsVO> obterListaDeRps(int idHotel, Date data) throws MozartSessionException {
		List<RpsVO> rpsList = new ArrayList<RpsVO>();
		try {
			String dtQuery = "2012-05-25";// MozartUtil.format(data, "yyyy-MM-dd");

			List lista = this.manager.createNativeQuery(QRY_STATUS_NOTA)
					.setParameter(1, idHotel)
					.setParameter(2, dtQuery)
					.getResultList();
			RpsVO nfse = null;
			int param = 0;
			for (Object linhas : lista) {
				Object[] linha = (Object[]) linhas;
				nfse = new RpsVO(linha);


				rpsList.add(nfse);
			}

		} catch (Exception ex) {ex.printStackTrace();
			throw new MozartSessionException(ex.getMessage());
		}
		return rpsList;
	}
	public List<RpsVO> obterListaDeRps(List<String> rps) throws MozartSessionException{
		List<RpsVO> rpsList = new ArrayList<RpsVO>();
		try {
			Iterator<String> it = rps.iterator();
			StringBuilder sb = new StringBuilder();
			sb.append(QRY_STATUS_NOTA_POR_ID);
			
			sb.append(" AND  SN.id_nota in(");
			while(it.hasNext()){
				sb.append((String)it.next());
				if(it.hasNext()){
					sb.append(",");
				}
			}
			sb.append(")  ORDER  BY num_nota ");
			
			List lista = this.manager.createNativeQuery(sb.toString())
					.getResultList();
			RpsVO nfse = null;
			int param = 0;
			for (Object linhas : lista) {
				Object[] linha = (Object[]) linhas;
				nfse = new RpsVO(linha);
				rpsList.add(nfse);
			}

		} catch (Exception ex) {ex.printStackTrace();
			throw new MozartSessionException(ex.getMessage());
		}
		return rpsList;
	}	
}