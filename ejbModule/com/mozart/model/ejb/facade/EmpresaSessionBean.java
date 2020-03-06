package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.EmpresaEJB;
import com.mozart.model.ejb.entity.EmpresaGrupoLancamentoEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJBPK;
import com.mozart.model.ejb.entity.EmpresaRedeEJB;
import com.mozart.model.ejb.entity.EmpresaTarifaEJB;
import com.mozart.model.ejb.entity.GrupoEconomicoEJB;
import com.mozart.model.ejb.entity.IdentificaLancamentoEJB;
import com.mozart.model.ejb.entity.PromotorEJB;
import com.mozart.model.ejb.entity.RepresentanteRedeEJB;
import com.mozart.model.ejb.entity.TarifaEJB;
import com.mozart.model.ejb.entity.TarifaGrupoEJB;
import com.mozart.model.ejb.entity.TipoEmpresaEJB;
import com.mozart.model.ejb.entity.VendedorRedeEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartSessionFilterException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.EmpresaHotelVO;
import com.mozart.model.vo.EmpresaVO;
import com.mozart.model.vo.TipoEmpresaVO;

@Stateless(name = "EmpresaSession")
@SuppressWarnings({"unchecked", "rawtypes"})
public class EmpresaSessionBean implements EmpresaSession {
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EmpresaHotelVO> obterEmpresaLookup(
			EmpresaHotelEJB pEmpresaHotelEJB) {
		try {
			String sql = "select e.id_empresa, "
					+ " eh.id_hotel, "
					+ " eh.id_rede_hotel, "
					+ " er.nome_fantasia, "
					+ " e.cgc, er.credito, "
					+ " eh.comissao, "
					+ " eh.calcula_taxa, "
					+ " eh.calcula_roomtax, "
					+ " eh.calcula_iss "
					+ " from empresa e, "
					+ " empresa_hotel eh, "
					+ " empresa_rede er "
					+ " where e.id_empresa = er.id_empresa "
					+ " and eh.id_empresa = er.id_empresa "
					+ " and eh.id_rede_hotel = er.id_rede_hotel "
					+ " and eh.id_hotel = ?1"
					+ " and (er.nome_fantasia like ?2 or e.cgc like ?3) ";

			if( ! MozartUtil.isNull(pEmpresaHotelEJB.getEmpresaRedeEJB()) &&
					! MozartUtil.isNull(pEmpresaHotelEJB.getEmpresaRedeEJB().getEmpresaEJB()) && 
					! MozartUtil.isNull(pEmpresaHotelEJB.getEmpresaRedeEJB().getEmpresaEJB().getCartaoCredito())){
				sql = sql + " and e.CARTAO_CREDITO=" + MozartUtil.getTextoEntreCaracter(pEmpresaHotelEJB.getEmpresaRedeEJB().getEmpresaEJB().getCartaoCredito(), "'");
			}
			List<Object[]> lista = null;
			lista = this.entityManager.createNativeQuery(sql).setParameter(1,
					pEmpresaHotelEJB.getIdHotel()).setParameter(2,
					"%" + pEmpresaHotelEJB.getNomeFantasia() + "%")
					.setParameter(3,
							"%" + pEmpresaHotelEJB.getNomeFantasia() + "%")
					.getResultList();

			List<EmpresaHotelVO> resultado = new ArrayList<EmpresaHotelVO>();
			for (Object[] l : lista) {
				resultado.add(new EmpresaHotelVO(l));
			}
			return resultado;
		} catch (Exception ex) {
		}
		return Collections.EMPTY_LIST;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EmpresaGrupoLancamentoEJB> obterGrupoLancamentoByEmpresa(
			EmpresaHotelEJB pEmpresaHotelEJB) throws MozartValidateException {
		if (pEmpresaHotelEJB == null) {
			throw new MozartValidateException("Empresa hotel é obrigatório");
		}
		if (pEmpresaHotelEJB.getIdHotel() == null) {
			throw new MozartValidateException("Id hotel é obrigatório");
		}
		if (pEmpresaHotelEJB.getIdEmpresa() == null) {
			throw new MozartValidateException("Id Empresa hotel é obrigatório");
		}
		try {
			return

			this.entityManager
					.createQuery(
							"select o from EmpresaGrupoLancamentoEJB o where o.idEmpresa = ?1 and o.idHotel = ?2")
					.setParameter(1, pEmpresaHotelEJB.getIdEmpresa())
					.setParameter(2, pEmpresaHotelEJB.getIdHotel())
					.getResultList();
		} catch (Exception ex) {
		}
		return Collections.emptyList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EmpresaHotelEJB obterEmpresaHotelByPK(EmpresaHotelEJBPK ehpk)
			throws MozartValidateException {
		try {
			EmpresaHotelEJB em = (EmpresaHotelEJB) this.entityManager.find(
					EmpresaHotelEJB.class, ehpk);
			this.entityManager.refresh(em);
			return em;
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}
	
	// TODO: (ID) Definição de método ruim. Aceita uma EmpresaVO como filtro, porém é impossível para o cliente
	// saber que o IdRedeHotel é obrigatório.
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EmpresaVO> pesquisarEmpresa(EmpresaVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_EMPRESA;
			if (!MozartUtil.isNull(filtro.getFiltroBairro().getTipoIntervalo())) {
				sql = sql + " and EM.BAIRRO " + filtro.getFiltroBairro();
			}
			if (!MozartUtil.isNull(filtro.getFiltroCidade().getTipoIntervalo())) {
				sql = sql + " and UPPER(CIDADE)  " + filtro.getFiltroCidade();
			}
			if (!MozartUtil.isNull(filtro.getFiltroCNPJ().getTipoIntervalo())) {
				sql = sql + " and EM.CGC " + filtro.getFiltroCNPJ();
			}
			if (!MozartUtil.isNull(filtro.getFiltroEstado().getTipoIntervalo())) {
				sql = sql + " and ESTADO " + filtro.getFiltroEstado();
			}
			if (!MozartUtil.isNull(filtro.getFiltroFantasia()
					.getTipoIntervalo())) {
				sql = sql + " and Er.NOME_FANTASIA "
						+ filtro.getFiltroFantasia();
			}
			if (!MozartUtil.isNull(filtro.getFiltroRazaoSocial()
					.getTipoIntervalo())) {
				sql = sql + " and EM.RAZAO_SOCIAL "
						+ filtro.getFiltroRazaoSocial();
			}
			if (!MozartUtil.isNull(filtro.getFiltroUF().getTipoIntervalo())) {
				sql = sql + " and es.uf " + filtro.getFiltroUF();
			}
			if (!MozartUtil
					.isNull(filtro.getFiltroCredito().getTipoIntervalo())) {
				sql = sql + " and ER.CREDITO " + filtro.getFiltroCredito();
			}
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql + " and instr('" + filtro.getIdHoteisSQL()
						+ "', ';'||eh.id_hotel||';') >= 1 ";
			}
			sql = sql + " ORDER BY Nome_Fantasia ";

			List lista = null;
			lista = this.entityManager.createNativeQuery(sql).setParameter(1,
					filtro.getIdRedeHotel()).getResultList();

			List<EmpresaVO> resultado = new ArrayList<EmpresaVO>();
			for (Object l : lista) {
				resultado.add(new EmpresaVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<GrupoEconomicoEJB> obterGrupoEconomico(GrupoEconomicoEJB filtro)
			throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getIdHotel()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select o from GrupoEconomicoEJB o where o.idRedeHotel = ?1 order by o.nomeGrupo";
		return this.entityManager.createQuery(sql).setHint("eclipselink.refresh",
				"TRUE").setParameter(1, filtro.getIdRedeHotel())
				.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<PromotorEJB> obterPromotor(PromotorEJB filtro)
			throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getIdRedeHotel()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select o from PromotorEJB o where o.idRedeHotel = ?1 order by o.promotor";
		return this.entityManager.createQuery(sql).setHint("eclipselink.refresh",
				"TRUE").setParameter(1, filtro.getIdRedeHotel())
				.getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<VendedorRedeEJB> obterVendedor(VendedorRedeEJB filtro)
			throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getIdRedeHotel()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select o from VendedorRedeEJB o where o.idRedeHotel = ?1 order by o.nomeFantasia";
		return this.entityManager.createQuery(sql).setHint("eclipselink.refresh",
				"TRUE").setParameter(1, filtro.getIdRedeHotel())
				.getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<RepresentanteRedeEJB> obterRepresentante(RepresentanteRedeEJB filtro)
			throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getIdRedeHotel()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select o from RepresentanteRedeEJB o where o.idRedeHotel = ?1 order by o.nomeFantasia";
		return this.entityManager.createQuery(sql).setHint("eclipselink.refresh",
				"TRUE").setParameter(1, filtro.getIdRedeHotel())
				.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoEmpresaEJB> obterTipoEmpresa(TipoEmpresaEJB filtro)
			throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getIdRedeHotel()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select o from TipoEmpresaEJB o where o.idRedeHotel = ?1 order by o.tipoEmpresa";
		return this.entityManager.createQuery(sql).setHint("eclipselink.refresh",
				"TRUE").setParameter(1, filtro.getIdRedeHotel())
				.getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<IdentificaLancamentoEJB> obterIdentificaLancamento(
			IdentificaLancamentoEJB filtro) throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getAtividade()))
				|| (MozartUtil.isNull(filtro.getGrupoDespesa()))
				|| (MozartUtil.isNull(filtro.getGrupoSub()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select o from IdentificaLancamentoEJB o where o.grupoSub = ?1 and o.atividade=?2 and o.grupoDespesa =?3 order by o.descricaoLancamento";
		return this.entityManager.createQuery(sql).setHint("eclipselink.refresh",
				"TRUE").setParameter(1, filtro.getGrupoSub()).setParameter(2,
				filtro.getAtividade())
				.setParameter(3, filtro.getGrupoDespesa()).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TarifaGrupoEJB> obterTarifaGrupo(TarifaGrupoEJB filtro)
			throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getIdHotel()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select o from TarifaGrupoEJB o where o.idHotel = ?1 order by o.descricao";
		return this.entityManager.createQuery(sql).setHint("eclipselink.refresh",
				"TRUE").setParameter(1, filtro.getIdHotel()).getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TarifaEJB> obterTarifa(TarifaEJB filtro)
			throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getIdHotel()))
				|| (MozartUtil.isNull(filtro.getAtivo()))
				|| (MozartUtil.isNull(filtro.getTipo()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select t.id_tarifa, t.descricao, t.data_entrada, t.data_saida, t.id_tarifa_grupo from tarifa t, controla_data c where t.id_hotel = ?1 and t.id_hotel = c.id_hotel and t.ativo = ?2 and t.tipo = ?3 and c.front_office <= t.data_saida order by t.data_entrada ";

		return this.entityManager.createNativeQuery(sql, TarifaEJB.class).setHint(
				"eclipselink.refresh", "TRUE").setParameter(1,
				filtro.getIdHotel()).setParameter(2, filtro.getAtivo())
				.setParameter(3, filtro.getTipo()).getResultList();
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EmpresaEJB gravarEmpresa(EmpresaEJB entidade)
			throws MozartSessionException {
		validarEmpresa(entidade);
		try {
			if (MozartUtil.isNull(((EmpresaRedeEJB) entidade
					.getEmpresaRedeEJBList().get(0)).getDataCadastro())) {
				((EmpresaRedeEJB) entidade.getEmpresaRedeEJBList().get(0))
						.setDataCadastro(new Timestamp(new Date().getTime()));
			}
			if (MozartUtil.isNull(entidade.getIdEmpresa())) {
				this.entityManager.setFlushMode(FlushModeType.COMMIT);

				entidade.setDataCadastro(new Timestamp(new Date().getTime()));

				this.entityManager.persist(entidade);
			} else {
				Long idHotel = ((EmpresaHotelEJB) ((EmpresaRedeEJB) entidade
						.getEmpresaRedeEJBList().get(0))
						.getEmpresaHotelEJBList().get(0)).getIdHotel();

				this.entityManager
						.createNativeQuery(
								"delete empresa_tarifa where id_empresa = ?1 and id_hotel = ?2")
						.setParameter(1, entidade.getIdEmpresa()).setParameter(
								2, idHotel).executeUpdate();
				if (!MozartUtil
						.isNull(((EmpresaHotelEJB) ((EmpresaRedeEJB) entidade
								.getEmpresaRedeEJBList().get(0))
								.getEmpresaHotelEJBList().get(0))
								.getEmpresaTarifaEJBList())) {
					for (EmpresaTarifaEJB empresaTarifa : ((EmpresaHotelEJB) ((EmpresaRedeEJB) entidade
							.getEmpresaRedeEJBList().get(0))
							.getEmpresaHotelEJBList().get(0))
							.getEmpresaTarifaEJBList()) {
						this.entityManager.persist(empresaTarifa);
					}
				}
				this.entityManager.merge(entidade);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new MozartSessionException(ex.getMessage());
		}
		return entidade;
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void replicarEmpresaRede(EmpresaEJB idEmpresa, Long idRedeHotel)
			throws MozartSessionException {
		try {
			this.entityManager.createNativeQuery(
					"{call PROC_CAD_EMPRESA_HOTEL(?1,?2)}").setParameter(1,
					idEmpresa.getIdEmpresa()).setParameter(2, idRedeHotel)
					.executeUpdate();
		} catch (Exception ex) {
			throw new MozartValidateException(
					"Não foi possível replicar os dados para os hotéis da rede");
		}
	}

	private void validarEmpresa(EmpresaEJB entidade)
			throws MozartValidateException {
		if (MozartUtil.isNull(entidade)) {
			throw new MozartValidateException("Empresa inválida");
		}
	}
	
	// TODO: (ID) Método mal escrito, refatorar. 
	// Fail fast, não tratar nulo.
	// A pesquisa é feita apenas pelo CNPJ (CGC) porém a leitura do nome do método não identifica facilmente sua utilidade. (Clean Code)
	// Obtém uma lista e retorna apenas o primeiro. Só pode existir uma empresa com mesmo CNPJ, portanto se retornar mais de um o banco está inconsistente.
	public EmpresaEJB obterEmpresa(EmpresaEJB entidade)
			throws MozartSessionException {
		if ((MozartUtil.isNull(entidade))
				|| (MozartUtil.isNull(entidade.getCgc()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "select o from EmpresaEJB o \twhere o.cgc = ?1 ";

		List<EmpresaEJB> lista = this.entityManager.createQuery(sql).setHint(
				"eclipselink.refresh", "TRUE").setParameter(1,
				entidade.getCgc()).getResultList();
		if (MozartUtil.isNull(lista)) {
			return null;
		}
		return (EmpresaEJB) lista.get(0);
	}

	public List<TipoEmpresaVO> pesquisarTipoEmpresa(TipoEmpresaVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_TIPO_EMPRESA;
			if (!MozartUtil.isNull(filtro.getFiltroTipoEmpresa()
					.getTipoIntervalo())) {
				sql = sql + " AND TIPO_EMPRESA "
						+ filtro.getFiltroTipoEmpresa();
			}
			sql = sql + " ORDER BY TIPO_EMPRESA ";

			List lista = this.entityManager.createNativeQuery(sql).setParameter(1,
					filtro.getIdHoteis()[0]).getResultList();
			List<TipoEmpresaVO> resultado = new ArrayList<TipoEmpresaVO>();
			for (Object l : lista) {
				resultado.add(new TipoEmpresaVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	public List<EmpresaVO> obterFornecedoresHotelPorNomeOuCNPJ(EmpresaVO filtro) throws MozartSessionFilterException {
		if (MozartUtil.isNull(filtro.getIdHotel()))
			throw new MozartSessionFilterException(
					MozartSessionFilterException.PARAMETRO_OBRIGATORIO, 
					new Object[] {"identificador do hotel"});
		
		StringBuilder sql = new StringBuilder(QRY_FORNECEDORES_HOTEL);
		
		if (!MozartUtil.isNull(filtro.getFiltroNomeFantasiaCNPJ())) {
			sql.append(" AND ( E.CGC ")
				.append(filtro.getFiltroNomeFantasiaCNPJ())
				.append(" OR FR.NOME_FANTASIA ")
				.append(filtro.getFiltroNomeFantasiaCNPJ())
				.append(") ");
		} 
		
		sql.append(" ORDER BY FR.NOME_FANTASIA ASC ");
		
		// TODO: (ID) Criar objeto para realizar o cast?
		List<Object[]> resultado = this.entityManager.createNativeQuery(sql.toString())
				.setParameter(1, filtro.getIdHotel())
				.getResultList();
		
		ArrayList<EmpresaVO> retorno = new ArrayList<EmpresaVO>();
		for (Object[] colunas : resultado) {
			EmpresaVO empresa = new EmpresaVO();
			empresa.setIdEmpresa(Long.parseLong(colunas[0].toString())); 
			empresa.setCnpj((String) colunas[1]);
			empresa.setNomeFantasia((String) colunas[2]);
			empresa.setPrazoPagamento(Long.parseLong(colunas[3].toString()));
			retorno.add(empresa);
		}
		
		return retorno;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public EmpresaHotelVO obterEmpresaPorIdEmpresa(
			EmpresaHotelVO filtro) {
		EmpresaHotelVO empresaVO = null;
		try {
			String sql = "select e.id_empresa, "
					+ " eh.id_hotel, "
					+ " eh.id_rede_hotel, "
					+ " er.nome_fantasia, "
					+ " e.cgc, er.credito, "
					+ " eh.comissao, "
					+ " eh.calcula_taxa, "
					+ " eh.calcula_roomtax, "
					+ " eh.calcula_iss "
					+ " from empresa e, "
					+ " empresa_hotel eh, "
					+ " empresa_rede er "
					+ " where e.id_empresa = er.id_empresa "
					+ " and eh.id_empresa = er.id_empresa "
					+ " and eh.id_rede_hotel = er.id_rede_hotel "
					+ " and eh.id_hotel = ?1 "
					+ " and e.id_empresa = ?2 ";
			
			empresaVO = new EmpresaHotelVO((Object[]) this.entityManager.createNativeQuery(sql)
					.setParameter(1,filtro.getBcIdHotel())
					.setParameter(2,filtro.getBcIdEmpresa())
					.getSingleResult());

			return empresaVO;
			
		} catch (Exception ex) {
		}
		return empresaVO;
	}
	
	
	public EmpresaEJB obterEmpresaPorNomeCnpj(EmpresaVO filtro)
			throws MozartSessionException {
		if ((MozartUtil.isNull(filtro))
				|| (MozartUtil.isNull(filtro.getRazaoSocial()))) {
			throw new MozartValidateException("Filtro inválido");
		}
		String sql = "SELECT ID_EMPRESA, "
				+ "			 CGC, "
				+ "NOME_FANTASIA, "
				+ "RAZAO_SOCIAL, "
				+ "ENDERECO, "
				+ "BAIRRO, "
				+ "CEP, "
				+ "ID_CIDADE, "
				+ "ADATA_CADASTRO, "
				+ "INSC_MUNICIPAL, "
				+ "INSC_ESTADUAL, "
				+ "INSC_EMBRATUR, "
				+ "INSC_IATA, "
				+ "CARTAO_CREDITO, "
				+ "NACIONAL, "
				+ "CODIGO, CLIENTE, "
				+ "FORNECEDOR, "
				+ "TERCEIRIZADA, "
				+ "TIPO, NUMERO, C"
				+ "OMPLEMENTO \n" + 
				"FROM MOZART.EMPRESA EMP WHERE CGC = '"+filtro.getCnpj().trim()+"' AND RAZAO_SOCIAL ='"+filtro.getRazaoSocial().trim()+"'";
		
		List<EmpresaEJB> lista = new ArrayList<EmpresaEJB>();
		
		List<Object[]> resultado = this.entityManager.createNativeQuery(sql).getResultList();
		for (Object[] colunas : resultado) {
		
			BigDecimal id = (BigDecimal) colunas[0];
			
			lista.add(this.entityManager.find(EmpresaEJB.class, Long.parseLong(id.toString()))); 
				
		}
		
		if (MozartUtil.isNull(lista)) {
			return null;
		}
		return (EmpresaEJB) lista.get(0);
	}
	
	public List <EmpresaEJB> consultarEmpresaPorRazaoSocialLike(EmpresaEJB filtro){
		
		List <EmpresaEJB> lista = new ArrayList<EmpresaEJB>();
		
		String sql = " SELECT CGC||' - '||RAZAO_SOCIAL, \n" + 
				"	  MIN(ID_EMPRESA)  \n" + 
				"FROM EMPRESA \r\n" + 
				"WHERE (LENGTH(CGC) = 11 OR LENGTH(CGC) = 14)   \r\n" + 
				"AND (UPPER(TRIM(RAZAO_SOCIAL)) LIKE '%' || '"+filtro.getRazaoSocial().toUpperCase()+"' ||'%'  OR UPPER(TRIM(CGC))LIKE '%'  || '"+filtro.getRazaoSocial()+"'  ||'%')  \r\n" + 
				"    GROUP BY CGC, RAZAO_SOCIAL";
		
		List<Object[]> resultado = this.entityManager.createNativeQuery(sql).getResultList();
		for (Object[] colunas : resultado) {
			
			BigDecimal id = (BigDecimal) colunas[1];
			//EmpresaEJB ejb = this.entityManager.find(EmpresaEJB.class, Long.parseLong(id.toString()));		
			EmpresaEJB ejb = new EmpresaEJB();
			ejb.setIdEmpresa(Long.parseLong(id.toString()));
			ejb.setRazaoSocialCGC((String) colunas[0]);
		
			
			lista.add(ejb);
		}
		
		return lista;
	}
}