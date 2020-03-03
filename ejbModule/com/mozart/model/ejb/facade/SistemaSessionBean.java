package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mozart.model.ejb.entity.ControlaDataEJB;
import com.mozart.model.ejb.entity.EstadoEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MensagemWebEJB;
import com.mozart.model.ejb.entity.MensagemWebUsuarioEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.UsuarioEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.AchadosPerdidoVO;
import com.mozart.model.vo.BancoVO;
import com.mozart.model.vo.CidadeVO;
import com.mozart.model.vo.ConfiguracaoTributarioVO;
import com.mozart.model.vo.ControlaDataVO;
import com.mozart.model.vo.EmpresaVO;
import com.mozart.model.vo.ExigibilidadeVO;
import com.mozart.model.vo.HospedeAchadosPerdidoVO;
import com.mozart.model.vo.HotelVO;
//import com.mozart.model.vo.ListaFiscalServicoVO;
import com.mozart.model.vo.MensagemWebUsuarioVO;
import com.mozart.model.vo.MensagemWebVO;
import com.mozart.model.vo.NotaFiscalVO;
import com.mozart.model.vo.NotaFiscalVO.TypeOfNotaFiscal;
import com.mozart.model.vo.PlanoContaVO;
import com.mozart.model.vo.RedeHotelVO;
import com.mozart.model.vo.RegimeTributarioVO;
import com.mozart.model.vo.UsuarioVO;
import com.mozart.model.vo.PlanoContaVO.TypeOfPlanoConta;

@Stateless(name = "SistemaSession")
@SuppressWarnings("unchecked")
public class SistemaSessionBean implements SistemaSession {
	
	@PersistenceContext(unitName = "MozartModel")
	private EntityManager manager;

	public List<CidadeVO> pesquisarCidade(CidadeVO filtro)
			throws MozartSessionException {
		try {
			String sql = " SELECT ID_CIDADE, CIDADE, ESTADO, UF, PAIS, DESCRICAO, DDI, DDD FROM V_CIDADE WHERE 1=1 ";
			if (!MozartUtil.isNull(filtro.getFiltroCidade().getTipoIntervalo())) {
				sql = sql + " AND CIDADE " + filtro.getFiltroCidade();
			}
			if (!MozartUtil.isNull(filtro.getFiltroEstado().getTipoIntervalo())) {
				sql = sql + " AND ESTADO " + filtro.getFiltroEstado();
			}
			sql = sql + " ORDER BY DESCRICAO, PAIS, ESTADO, CIDADE ";

			List lista = this.manager.createNativeQuery(sql).getResultList();
			List<CidadeVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new CidadeVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<EstadoEJB> pesquisarEstado() throws MozartSessionException {
		try {
			return

			this.manager.createQuery(
					"select o from EstadoEJB o order by o.estado").setHint(
					"eclipselink.refresh", "TRUE").getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<BancoVO> pesquisarBanco(BancoVO filtro)
			throws MozartSessionException {
		try {
			String sql = " SELECT ID_BANCO, NUMERO_BANCO, BANCO, NOME_FANTASIA FROM BANCO WHERE 1=1 ";
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql
						// TODO: (ID/Conta Corrente) 
//						+ " and id_banco in (select id_banco from conta_corrente where instr('"
						+ " and id_banco in (select id_banco from conta_corrente_X where instr('"
						+ filtro.getIdHoteisSQL()
						+ "', ';'||id_hotel||';') >= 1) ";
			}
			if (!MozartUtil.isNull(filtro.getFiltroNumero().getTipoIntervalo())) {
				sql = sql + " AND NUMERO_BANCO " + filtro.getFiltroNumero();
			}
			if (!MozartUtil.isNull(filtro.getFiltroBanco().getTipoIntervalo())) {
				sql = sql + " AND BANCO " + filtro.getFiltroBanco();
			}
			sql = sql + " ORDER BY BANCO ";

			List lista = this.manager.createNativeQuery(sql).getResultList();
			List<BancoVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new BancoVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	public List<BancoVO> pesquisarBancoCombo(BancoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_COMBO_BANCO;
			if (!MozartUtil.isNull(filtro.getIdHoteis())) {
				sql = sql
//						+ " and id_banco in (select id_banco from conta_corrente where instr('"
						+ " and id_banco in (select id_banco from conta_corrente_X where instr('"
						+ filtro.getIdHoteisSQL()
						+ "', ';'||id_hotel||';') >= 1) ";
			}
			if (!MozartUtil.isNull(filtro.getFiltroNumero().getTipoIntervalo())) {
				sql = sql + " AND NUMERO_BANCO " + filtro.getFiltroNumero();
			}
			if (!MozartUtil.isNull(filtro.getFiltroBanco().getTipoIntervalo())) {
				sql = sql + " AND BANCO " + filtro.getFiltroBanco();
			}
			sql = sql + " ORDER BY BANCO ";
			
			List lista = this.manager.createNativeQuery(sql).getResultList();
			List<BancoVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new BancoVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	public List<BancoVO> pesquisarBancoComboAutoComplete(BancoVO filtro)
			throws MozartSessionException {
		try {
			String sql = QRY_COMBO_BANCO;
			String sqlFiltro = "";
			String sqlConector = "";
			
			sql= " SELECT * FROM ( " + sql + ")";
			
			if (!MozartUtil.isNull(filtro.getFiltroBanco().getTipoIntervalo())) {
				sqlFiltro = sqlFiltro + sqlConector + " BANCO " + filtro.getFiltroBanco();
				sqlConector = " AND ";
			}
			
			if( ! MozartUtil.isNull(sqlFiltro)){
				sql = sql+ " WHERE " + sqlFiltro;
			}
			sql = sql + " ORDER BY BANCO ";
			
			List lista = this.manager.createNativeQuery(sql.toUpperCase()).getResultList();
			List<BancoVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new BancoVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<MensagemWebUsuarioEJB> pesquisarMensagens(UsuarioEJB usuarioEJB)
			throws MozartSessionException {
		try {
			return

			this.manager
					.createNamedQuery("MensagemWebUsuarioEJB.findAllUnread")
					.setHint("eclipselink.refresh", "TRUE").setParameter(1,
							usuarioEJB.getIdUsuario()).getResultList();
		} catch (Exception ex) {
		}
		return Collections.emptyList();
	}

	public List<MensagemWebVO> pesquisarMensagens(MensagemWebVO filtro)
			throws MozartSessionException {
		try {
			String sql = "SELECT M.ID_MENSAGEM, M.TITULO, M.DATA_CRIACAO, DECODE(M.NIVEL, 1, 'Normal', 2, 'Médio', 3, 'Urgente')NIVEL, null NOME_USUARIO, NULL DATA_RESPOSTA, NULL NOME_HOTEL, NULL RESPOSTA, SUBSTR(UC.NICK,8) CRIACAO FROM MENSAGEM_WEB M, USUARIO UC WHERE M.ID_USUARIO = UC.ID_USUARIO AND UC.ID_USUARIO = NVL(?1,UC.ID_USUARIO) ";
			if ("S".equals(filtro.getFiltroUsuario().getTipoIntervalo())) {
				sql = " SELECT M.ID_MENSAGEM, M.TITULO, M.DATA_CRIACAO, DECODE(M.NIVEL, 1, 'Normal', 2, 'Médio', 3, 'Urgente')NIVEL, SUBSTR(U.NICK,8) NICK, MU.DATA_RESPOSTA, H.NOME_FANTASIA, MU.RESPOSTA, SUBSTR(UC.NICK,8) CRIACAO  FROM MENSAGEM_WEB M, MENSAGEM_WEB_USUARIO MU, USUARIO U, HOTEL H, USUARIO UC  WHERE UC.ID_USUARIO = NVL(?1, UC.ID_USUARIO) AND M.ID_MENSAGEM = MU.ID_MENSAGEM AND M.ID_USUARIO = UC.ID_USUARIO  AND MU.ID_USUARIO = U.ID_USUARIO  AND U.ID_HOTEL = H.ID_HOTEL(+) ";
				if (!MozartUtil.isNull(filtro.getFiltroHotel()
						.getTipoIntervalo())) {
					sql = sql + " AND H.NOME_FANTASIA "
							+ filtro.getFiltroHotel();
				}
				if (!MozartUtil.isNull(filtro.getFiltroNickUsuario()
						.getTipoIntervalo())) {
					sql = sql + " AND U.NICK " + filtro.getFiltroNickUsuario();
				}
				if (!MozartUtil.isNull(filtro.getFiltroRespondeu()
						.getTipoIntervalo())) {
					if ("S".equals(filtro.getFiltroRespondeu()
							.getTipoIntervalo())) {
						sql = sql + " AND MU.DATA_RESPOSTA IS NOT NULL ";
					} else if ("N".equals(filtro.getFiltroRespondeu()
							.getTipoIntervalo())) {
						sql = sql + " AND MU.DATA_RESPOSTA IS NULL ";
					}
				}
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataCriacao()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC(M.DATA_CRIACAO) "
						+ filtro.getFiltroDataCriacao();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDescricao()
					.getTipoIntervalo())) {
				sql = sql + " AND UPPER(M.DESCRICAO) "
						+ filtro.getFiltroDescricao();
			}
			if (!MozartUtil.isNull(filtro.getFiltroTitulo().getTipoIntervalo())) {
				sql = sql + " AND UPPER(M.TITULO) " + filtro.getFiltroTitulo();
			}
			sql = sql + " ORDER BY M.DATA_CRIACAO DESC ";

			List lista = this.manager.createNativeQuery(sql)
					.setParameter(
							1,
							filtro.getUsuario().getIdUsuario().equals(
									new Long(2L)) ? null : filtro.getUsuario()
									.getIdUsuario()).getResultList();

			List<MensagemWebVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new MensagemWebVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<HotelVO> pesquisarHotel(HotelVO hotelVO)
			throws MozartSessionException {
		try {
			String sql = " SELECT ID_HOTEL, NOME_FANTASIA, RAZAO_SOCIAL, ENDERECO, CEP, BAIRRO, TELEFONE, EMAIL, FAX, CGC  FROM HOTEL  WHERE ATIVO = 'S'  AND ID_HOTEL = NVL(?1, ID_HOTEL)  AND ID_REDE_HOTEL = NVL(?2, ID_REDE_HOTEL) ";
			sql = sql + " ORDER BY NOME_FANTASIA ";

			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					hotelVO.getIdHotel()).setParameter(2,
					hotelVO.getIdRedeHotel()).getResultList();

			List<HotelVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new HotelVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<RedeHotelVO> pesquisarRedeHotel(RedeHotelVO redeHotelVO)
			throws MozartSessionException {
		try {
			String sql = " SELECT ID_REDE_HOTEL, NOME_FANTASIA, RAZAO_SOCIAL, ENDERECO, CEP, BAIRRO, TELEFONE, EMAIL, FAX, CGC,  INSC_ESTADUAL, INSC_MUNICIPAL, INSC_EMBRATUR, TELEX, AUTOMATICO, VALOR_INSCRICAO, QTD_VALOR, EXPIRAR, FORA_ANO, SIGLA,  ENDERECO_LOGOTIPO, LINK_VOUCHER, FORMATO_CONTA FROM REDE_HOTEL WHERE ATIVO = 'S' AND ID_REDE_HOTEL = NVL(?1, ID_REDE_HOTEL) ";
			sql = sql + " ORDER BY NOME_FANTASIA ";

			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					redeHotelVO.getIdRedeHotel()).getResultList();

			List<RedeHotelVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new RedeHotelVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<UsuarioVO> pesquisarUsuario(Long idRedeHotel, Long idHotel,
			String usuarioAdm, String suporteMozart)
			throws MozartSessionException {
		try {
			String sql = "SELECT ID_USUARIO, INITCAP(NOME)||' - ['||SUBSTR(NICK,8)||']' NOME FROM USUARIO WHERE ATIVO = 'S' AND SENHA IS NOT NULL AND DATA_VALIDADE > SYSDATE ";
			boolean entrou = false;
			if (!MozartUtil.isNull(idRedeHotel)) {
				entrou = true;
				sql = sql
						+ " AND( (ID_HOTEL IN (SELECT ID_HOTEL FROM CONTROLA_DATA WHERE ID_REDE_HOTEL = "
						+ idRedeHotel + ") OR ID_REDE_HOTEL = " + idRedeHotel
						+ ")";
			}
			if (!MozartUtil.isNull(idHotel)) {
				sql = sql + (entrou ? " OR " : " AND( ") + " ID_HOTEL = "
						+ idHotel;
				entrou = true;
			}
			if (!MozartUtil.isNull(usuarioAdm)) {
				sql = sql
						+ (entrou ? " OR " : " AND( ")
						+ " ID_USUARIO  "
						+ ("S".equals(usuarioAdm) ? " in " : " not in ")
						+ " (SELECT ID_USUARIO FROM MENU_MOZART_WEB_USUARIO WHERE ID_MENU_ITEM IN (2510)) ";
				entrou = true;
			}
			if ("S".equals(suporteMozart)) {
				sql = sql + (entrou ? " OR " : " AND( ") + " ID_USUARIO = 2 ";
				entrou = true;
			}
			sql = sql + (entrou ? " ) " : " ") + " ORDER BY NOME ";

			List lista = this.manager.createNativeQuery(sql).getResultList();

			List<UsuarioVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new UsuarioVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void gravarMensagem(MensagemWebEJB entidade)
			throws MozartSessionException {
		try {
			List<MensagemWebUsuarioEJB> listaPermissoes = entidade
					.getMensagemWebUsuarioEJBList();
			if (entidade.getIdMensagem() == null) {
				this.manager.persist(entidade);
			} else {
				this.manager.merge(entidade);
			}
			for (MensagemWebUsuarioEJB user : listaPermissoes) {
				user.getId().setIdMensagem(entidade.getIdMensagem());
				if (this.manager
						.find(MensagemWebUsuarioEJB.class, user.getId()) == null) {
					user.setUsuarioEJB(null);
					this.manager.persist(user);
				}
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<MensagemWebUsuarioVO> pesquisarMensagensWebUsuario(
			MensagemWebUsuarioVO filtro) throws MozartSessionException {
		try {
			String sql = " SELECT M.ID_MENSAGEM, M.TITULO, M.DESCRICAO, M.DATA_CRIACAO,  DECODE(M.NIVEL, 1, 'Normal', 2, 'Médio', 3, 'Urgente')NIVEL, DATA_RESPOSTA, RESPOSTA, SUBSTR(U.NICK, 8)NICK  FROM MENSAGEM_WEB M, MENSAGEM_WEB_USUARIO MU, USUARIO U  WHERE U.ID_USUARIO = M.ID_USUARIO AND M.ID_MENSAGEM = MU.ID_MENSAGEM  AND MU.ID_USUARIO = ?1 ";
			if (!MozartUtil.isNull(filtro.getFiltroTitulo().getTipoIntervalo())) {
				sql = sql + " AND TITULO " + filtro.getFiltroTitulo();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDescricao()
					.getTipoIntervalo())) {
				sql = sql + " AND DESCRICAO " + filtro.getFiltroDescricao();
			}
			if (!MozartUtil.isNull(filtro.getFiltroDataCriacao()
					.getTipoIntervalo())) {
				sql = sql + " AND TRUNC (DATA_CRIACAO) "
						+ filtro.getFiltroDataCriacao();
			}
			sql = sql + " ORDER BY DATA_CRIACAO DESC ";

			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					filtro.getIdUsuario()).getResultList();
			List<MensagemWebUsuarioVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new MensagemWebUsuarioVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<BancoVO> pesquisarBancoUsadoNoHotel(Long idHotel)
			throws MozartSessionException {
		try {
			// TODO: (ID/Conta Corrente)
//			String sql = " SELECT B.ID_BANCO, B.NUMERO_BANCO, B.BANCO, B.NOME_FANTASIA FROM BANCO B, CONTA_CORRENTE C WHERE B.ID_BANCO = C.ID_BANCO AND C.ID_HOTEL = ?1 ORDER BY B.BANCO ";
			String sql = " SELECT B.ID_BANCO, B.NUMERO_BANCO, B.BANCO, B.NOME_FANTASIA FROM BANCO B, CONTA_CORRENTE_X C WHERE B.ID_BANCO = C.ID_BANCO AND C.ID_HOTEL = ?1 ORDER BY B.BANCO ";
			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					idHotel).getResultList();
			List<BancoVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new BancoVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<RedeHotelEJB> pesquisarRedeHotel()
			throws MozartSessionException {
		try {
			return

			this.manager.createQuery(
					"select o from RedeHotelEJB o order by o.nomeFantasia")
					.setHint("eclipselink.refresh", "TRUE").getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<HotelEJB> pesquisarHotelEJB(HotelVO filtro)
			throws MozartSessionException {
		try {
			String sql = " SELECT ID_HOTEL, NOME_FANTASIA, RAZAO_SOCIAL, ENDERECO, CEP, BAIRRO, TELEFONE, EMAIL, FAX, CGC  FROM HOTEL  WHERE ATIVO = 'S'  AND ID_HOTEL = NVL(?1, ID_HOTEL)  AND ID_REDE_HOTEL = NVL(?2, ID_REDE_HOTEL) ";
			if (!MozartUtil
					.isNull(filtro.getFiltroIdHotel().getTipoIntervalo())) {
				sql = sql + " AND ID_HOTEL " + filtro.getFiltroIdHotel();
			}
			if (!MozartUtil.isNull(filtro.getFiltroNomeFantasia()
					.getTipoIntervalo())) {
				sql = sql + " AND NOME_FANTASIA "
						+ filtro.getFiltroNomeFantasia();
			}
			return

			this.manager.createNativeQuery(sql, HotelEJB.class).setParameter(1,
					null).setParameter(2, null).setHint("eclipselink.refresh",
					"TRUE").getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<ControlaDataEJB> pesquisarControlaData(ControlaDataVO filtro)
			throws MozartSessionException {
		try {
			String sql = " SELECT ID_HOTEL, FRONT_OFFICE, FATURAMENTO_CONTAS_RECEBER, CONTABILIDADE,  CONTAS_PAGAR, TESOURARIA, ESTOQUE, ULTIMA_NOTA_HOSPEDAGEM,  ULTIMO_NUM_DUPLICATA, ULTIMO_NUM_COTACAO, ULTIMO_NUM_PEDIDO, ULTIMO_NUM_CONTAS_PAGAR,  TELEFONIA, CONTAS_RECEBER, ID_REDE_HOTEL, SALDO_ELEVADO, FECHADURA, ULTIMA_REQUISICAO,  CENTRAL_ADVISER, AUD_ENCERRA, ULTIMA_NFS, ULTIMA_CNFS, ULTIMA_SEQ_BANCARIA, ULTIMA_NR   FROM CONTROLA_DATA  WHERE 1 = 1 ";
			if (!MozartUtil
					.isNull(filtro.getFiltroIdHotel().getTipoIntervalo())) {
				sql = sql + " AND ID_HOTEL " + filtro.getFiltroIdHotel();
			}
			return

			this.manager.createNativeQuery(sql, ControlaDataEJB.class).setHint(
					"eclipselink.refresh", "TRUE").getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<RedeHotelEJB> pesquisarRedeHotelEJB(RedeHotelVO filtro)
			throws MozartSessionException {
		try {
			String sql = " SELECT ID_REDE_HOTEL, NOME_FANTASIA, RAZAO_SOCIAL, ENDERECO, CEP, BAIRRO, TELEFONE, EMAIL, FAX, CGC,  INSC_ESTADUAL, INSC_MUNICIPAL, INSC_EMBRATUR, TELEX, AUTOMATICO, VALOR_INSCRICAO, QTD_VALOR, EXPIRAR, FORA_ANO, SIGLA,  ENDERECO_LOGOTIPO, LINK_VOUCHER, FORMATO_CONTA FROM REDE_HOTEL WHERE ATIVO = 'S' AND ID_REDE_HOTEL = NVL(?1, ID_REDE_HOTEL) ";
			if (!MozartUtil.isNull(filtro.getFiltroNomeFantasia()
					.getTipoIntervalo())) {
				sql = sql + " AND NOME_FANTASIA "
						+ filtro.getFiltroNomeFantasia();
			}
			return

			this.manager.createNativeQuery(sql, RedeHotelEJB.class)
					.setParameter(1, null).setHint("eclipselink.refresh",
							"TRUE").getResultList();
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EmpresaVO> pesquisarEmpresa(EmpresaVO filtro)
			throws MozartSessionException {
		try {
			String sql = " SELECT UNIQUE EM.ID_EMPRESA, null ID_REDE_HOTEL, null ID_HOTEL, null NOME_FANTASIA,EM.RAZAO_SOCIAL,  null TELEFONE, null FAX, null TELEX, null CONTATO, EM.CGC, null EMAIL, null CREDITO, null TIPO_EMPRESA,  CIDADE,ESTADO,PAIS, null COMISSAO_CRS, EM.NACIONAL,EM.ENDERECO, EM.BAIRRO, null SIGLA, null VALOR_CREDITO,  null COMISSAO, null PRAZO_PAGAMENTO, em.numero, em.complemento  FROM EMPRESA EM, CIDADE CI, ESTADO ES, PAIS PA  WHERE EM.ID_CIDADE = CI.ID_CIDADE  AND CI.ID_ESTADO = ES.ID_ESTADO  AND ES.CODPAIS = PA.CODPAIS ";
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
			if (!MozartUtil.isNull(filtro.getFiltroRazaoSocial()
					.getTipoIntervalo())) {
				sql = sql + " and EM.RAZAO_SOCIAL "
						+ filtro.getFiltroRazaoSocial();
			}
			if (!MozartUtil.isNull(filtro.getFiltroUF().getTipoIntervalo())) {
				sql = sql + " and es.uf " + filtro.getFiltroUF();
			}
			List lista = null;
			lista = this.manager.createNativeQuery(sql).getResultList();

			List<EmpresaVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new EmpresaVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<AchadosPerdidoVO> pesquisarAchadosPerdido(
			AchadosPerdidoVO filtro) throws MozartSessionException {
		try {
			String sql = " SELECT AP.ID_ACHADOS_PERDIDOS, AP.OBJETO, AP.PERIODO, AP.LOCAL, AP.DATA, AP.FUNCIONARIO_ACHOU, H.ID_HOSPEDE, AP.DATA_DEVOLUCAO,  AP.FUNCIONARIO_RECEBE, AP.DOCUMENTO, AP.ID_HOTEL,   AP.RECEBEDOR, AP.DOC_RECEBEDOR, H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE HOSPEDE, H.CELULAR  FROM ACHADOS_PERDIDOS AP  LEFT JOIN HOSPEDE H ON(AP.ID_HOSPEDE = H.ID_HOSPEDE)  WHERE AP.ID_HOTEL IN (?1) ";
			if (!MozartUtil.isNull(filtro.getFiltroData().getTipoIntervalo())) {
				sql = sql + " AND AP.DATA " + filtro.getFiltroData();
			}
			if (!MozartUtil.isNull(filtro.getFiltroLocal().getTipoIntervalo())) {
				sql = sql + " AND AP.LOCAL " + filtro.getFiltroLocal();
			}
			if (!MozartUtil.isNull(filtro.getFiltroObjeto().getTipoIntervalo())) {
				sql = sql + " AND AP.OBJETO " + filtro.getFiltroObjeto();
			}
			sql = sql + " ORDER BY DATA";

			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					filtro.getIdHotel()).getResultList();
			List<AchadosPerdidoVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new AchadosPerdidoVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<HospedeAchadosPerdidoVO> pesquisarHospedeAP(
			HospedeAchadosPerdidoVO ap) throws MozartSessionException {
		try {
			String sql = " SELECT rl.ID_HOTEL, H.ID_HOSPEDE, RL.ID_ROOM_LIST, A.NUM_APARTAMENTO, C.ID_CHECKIN, H.NOME_HOSPEDE||' '||H.SOBRENOME_HOSPEDE NOME_HOSPEDE, H.CELULAR  FROM APARTAMENTO A, CHECKIN C, HOSPEDE H, ROOM_LIST RL  WHERE A.ID_APARTAMENTO = C.ID_APARTAMENTO  AND C.ID_CHECKIN = RL.ID_CHECKIN  AND RL.ID_HOSPEDE = H.ID_HOSPEDE  AND C.ID_HOTEL = ?1 ";
			sql = sql + " ORDER BY H.NOME_HOSPEDE, H.SOBRENOME_HOSPEDE ";

			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					ap.getIdHotel()).getResultList();

			List<HospedeAchadosPerdidoVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new HospedeAchadosPerdidoVO((Object[]) l));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public List<NotaFiscalVO> pesquisarNotaFiscal(NotaFiscalVO filtro)
			throws MozartSessionException {
			String sql = QRY_NOTA_FISCAL;
		
			String filtroSql = " AND SN.ID_HOTEL =?1  AND TIPO_NOTA = ?2 AND SN.NOTA_INICIAL IS NOT NULL";
			String orderBy = " ORDER BY NOTA_INICIAL " ;
			
			if (!MozartUtil.isNull(filtro.getData().getTipoIntervalo())) {
				filtroSql = filtroSql + " AND trunc(SN.DATA) " + filtro.getData();
			}
			if (!MozartUtil.isNull(filtro.getNotaInicial().getTipoIntervalo())) {
				filtroSql = filtroSql + " AND NOTA_INICIAL " + filtro.getNotaInicial();
			}
			if (!MozartUtil.isNull(filtro.getGracStatusRPS())) {
				filtroSql = filtroSql + " AND (SN.RPS_STATUS is null or SN.RPS_STATUS <> '" + filtro.getGracStatusRPS() + "')";
			}
			else if (!MozartUtil.isNull(filtro.getRpsstatus().getValorInicial())) {
				filtroSql = filtroSql + " AND SN.RPS_STATUS " + filtro.getRpsstatus();
			}
			
			sql = sql + filtroSql + orderBy;
			
			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					filtro.getBcIdHotel()).setParameter(2,
							filtro.getBcTipoNota()).getResultList();

			List<NotaFiscalVO> resultado = new ArrayList();
			for (Object l : lista) {
				resultado.add(new NotaFiscalVO((Object[]) l, TypeOfNotaFiscal.MUNICIPAL));
			}
					
		return resultado;
	}
	
	public List<String> pesquisarUltimaNotaFiscalEnviada(NotaFiscalVO filtro)
			throws MozartSessionException {
			String sql = QRY_ULTIMO_RPS_NOTA_FISCAL;
		
			String filtroSql = " AND SN.ID_HOTEL =?1  AND TIPO_NOTA = ?2 AND SN.NOTA_INICIAL IS NOT NULL";
			String orderBy = " ORDER BY NUM_NOTA " ;
			
			if (!MozartUtil.isNull(filtro.getData().getTipoIntervalo())) {
				filtroSql = filtroSql + " AND trunc(SN.DATA) " + filtro.getData();
			}
			if (!MozartUtil.isNull(filtro.getNotaInicial().getTipoIntervalo())) {
				filtroSql = filtroSql + " AND NOTA_INICIAL " + filtro.getNotaInicial();
			}
			if (!MozartUtil.isNull(filtro.getGracStatusRPS())) {
				filtroSql = filtroSql + " AND SN.RPS_STATUS = '" + filtro.getGracStatusRPS() + "'";
			}
		
			sql = sql + filtroSql + orderBy;
			
			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					filtro.getBcIdHotel()).setParameter(2,
							filtro.getBcTipoNota()).getResultList();

			List<String> resultado = new ArrayList();
			for (Object l : lista) {
				if(!MozartUtil.isNull(l))
					resultado.add(String.valueOf((BigDecimal) l));
			}
					
		return resultado;
	}
	
	public ConfiguracaoTributarioVO pesquisarConfiguracaoTributaria(ConfiguracaoTributarioVO filtro)
			throws MozartSessionException {
			String sql = QRY_CONFIGURACAO_TRIBUTARIA;
			
			List lista = this.manager.createNativeQuery(sql).setParameter(1,
					filtro.getIdHotel()).getResultList();

			List<ConfiguracaoTributarioVO> resultado = new ArrayList();
			for (Object l : lista) {
				if(!MozartUtil.isNull(l))
					resultado.add(new ConfiguracaoTributarioVO((Object[]) l));
			}
					
		return resultado.size() > 0 ? resultado.get(0) : new ConfiguracaoTributarioVO();
	}
	
	public List<ExigibilidadeVO>  obterExigibilidade()
			throws MozartSessionException {
			String sql = QRY_EXIBILIDADE;
			
			List lista = this.manager.createNativeQuery(sql).getResultList();

			List<ExigibilidadeVO> resultado = new ArrayList();
			for (Object l : lista) {
				if(!MozartUtil.isNull(l))
					resultado.add(new ExigibilidadeVO((Object[]) l));
			}
					
		return resultado;
	}
	
	public List<RegimeTributarioVO>  obterRegimeTributario() throws MozartSessionException {
			String sql = QRY_REGIME_TRIBUTARIO;
			
			List lista = this.manager.createNativeQuery(sql).getResultList();

			List<RegimeTributarioVO> resultado = new ArrayList();
			for (Object l : lista) {
				if(!MozartUtil.isNull(l))
					resultado.add(new RegimeTributarioVO((Object[]) l));
			}
					
		return resultado;
	}
	
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public List<UsuarioVO> obterComboUsuarios(UsuarioVO filtro)
			throws MozartSessionException {
		try {

			StringBuilder sql = new StringBuilder(QRY_PESQUISAR_USUARIO);

			if (!MozartUtil.isNull(
					filtro.getFiltroAjax().getTipoIntervalo())){
				sql.append(" AND ( ")
					.append(" UPPER(TRIM(U.NICK)) ")
					.append(filtro.getFiltroAjax())
					.append(" OR ")
					.append(" UPPER(TRIM(U.NOME)) ")
					.append(filtro.getFiltroAjax())
					.append(") ");
			}
				
			Query query = manager.createNativeQuery(sql.toString());
			query.setParameter(1, filtro.getIdHotel());

			Logger log = Logger.getLogger(this.getClass());
			log.info(query.toString());

			List<Object[]> lista = query.getResultList();

			List<UsuarioVO> resultado = new ArrayList<UsuarioVO>();
			for (Object[] linha : lista) {
				resultado.add(new UsuarioVO(linha));
			}
			return resultado;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	
	
//	public List<ListaFiscalServicoVO> pesquisarListaServicoFiscal(ListaFiscalServicoVO filtro)
//			throws MozartSessionException {
//			String sql = QRY_FISCAL_LISTA_SERVICO;
//			
//			String filtroSql = " AND ((UPPER(TRIM (CODIGO))) LIKE '%'" + filtro.getDescricao() + "'%' " +
//							   " OR (UPPER(TRIM (DESCRICAO))) LIKE '%'" + filtro.getDescricao() + "'%') ";
//			String orderBy = " ORDER BY NUM_NOTA " ;
//			
//			sql = sql + filtroSql + orderBy;
//			
//			List lista = this.manager.createNativeQuery(sql).getResultList();
//
//			List<ListaFiscalServicoVO> resultado = new ArrayList();
//			
//			for (Object l : lista) {
//				if(!MozartUtil.isNull(l))
//					resultado.add(new ListaFiscalServicoVO((Object[]) l));
//			}
//					
//		return resultado;
//	}
	
}