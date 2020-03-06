package com.mozart.model.delegate;

import com.mozart.model.ejb.entity.EmpresaEJB;
import com.mozart.model.ejb.entity.EmpresaGrupoLancamentoEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJBPK;
import com.mozart.model.ejb.entity.EmpresaRedeEJB;
import com.mozart.model.ejb.entity.GrupoEconomicoEJB;
import com.mozart.model.ejb.entity.IdentificaLancamentoEJB;
import com.mozart.model.ejb.entity.PromotorEJB;
import com.mozart.model.ejb.entity.RepresentanteRedeEJB;
import com.mozart.model.ejb.entity.TarifaEJB;
import com.mozart.model.ejb.entity.TarifaGrupoEJB;
import com.mozart.model.ejb.entity.TipoEmpresaEJB;
import com.mozart.model.ejb.entity.VendedorRedeEJB;
import com.mozart.model.ejb.facade.EmpresaSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.vo.EmpresaHotelVO;
import com.mozart.model.vo.EmpresaVO;
import com.mozart.model.vo.TipoEmpresaVO;

import java.util.List;

public class EmpresaDelegate extends MozartDelegate {
	private static EmpresaDelegate instance;
	private static EmpresaSession session;

	private EmpresaDelegate() throws MozartSessionException {
		try {
			session = (EmpresaSession) getLookup("EmpresaSession");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: EmpresaSession");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static EmpresaDelegate instance() throws MozartSessionException {
		return instance == null ? (EmpresaDelegate.instance = new EmpresaDelegate())
				: instance;
	}

	public List<EmpresaHotelVO> obterEmpresaLookup(
			EmpresaHotelEJB pEmpresaHotelEJB) throws MozartSessionException {
		return session.obterEmpresaLookup(pEmpresaHotelEJB);
	}

	public List<EmpresaGrupoLancamentoEJB> obterGrupoLancamentoByEmpresa(
			EmpresaHotelEJB pEmpresaHotelEJB) throws MozartValidateException {
		return session.obterGrupoLancamentoByEmpresa(pEmpresaHotelEJB);
	}

	public EmpresaHotelEJB obterEmpresaHotelByPK(EmpresaHotelEJBPK ehpk)
			throws MozartValidateException {
		return session.obterEmpresaHotelByPK(ehpk);
	}

	public List<EmpresaVO> pesquisarEmpresa(EmpresaVO filtro)
			throws MozartSessionException {
		return session.pesquisarEmpresa(filtro);
	}

	public List<GrupoEconomicoEJB> obterGrupoEconomico(GrupoEconomicoEJB filtro)
			throws MozartSessionException {
		return session.obterGrupoEconomico(filtro);
	}

	public List<TipoEmpresaEJB> obterTipoEmpresa(TipoEmpresaEJB filtro)
			throws MozartSessionException {
		return session.obterTipoEmpresa(filtro);
	}

	public List<PromotorEJB> obterPromotor(PromotorEJB filtro)
			throws MozartSessionException {
		return session.obterPromotor(filtro);
	}

	public List<IdentificaLancamentoEJB> obterIdentificaLancamento(
			IdentificaLancamentoEJB filtro) throws MozartSessionException {
		return session.obterIdentificaLancamento(filtro);
	}

	public List<TarifaGrupoEJB> obterTarifaGrupo(TarifaGrupoEJB filtroGT)
			throws MozartSessionException {
		return session.obterTarifaGrupo(filtroGT);
	}

	public List<TarifaEJB> obterTarifa(TarifaEJB filtro)
			throws MozartSessionException {
		return session.obterTarifa(filtro);
	}

	public EmpresaEJB gravarEmpresa(EmpresaEJB entidade)
			throws MozartSessionException {
		EmpresaEJB grav = session.gravarEmpresa(entidade);
		grav.setUsuario(entidade.getUsuario());
		session.replicarEmpresaRede(grav, ((EmpresaRedeEJB) grav
				.getEmpresaRedeEJBList().get(0)).getIdRedeHotel());
		return grav;
	}

	public EmpresaEJB obterEmpresa(EmpresaEJB entidade)
			throws MozartSessionException {
		return session.obterEmpresa(entidade);
	}

	public List<TipoEmpresaVO> pesquisarTipoEmpresa(TipoEmpresaVO filtro)
			throws MozartSessionException {
		return session.pesquisarTipoEmpresa(filtro);
	}
	
	public List<EmpresaVO> obterFornecedoresHotelPorNomeOuCNPJ(EmpresaVO filtro) throws MozartSessionException {
		return session.obterFornecedoresHotelPorNomeOuCNPJ(filtro);
	}
	
	public EmpresaHotelVO obterEmpresaPorIdEmpresa(EmpresaHotelVO filtro){
		return session.obterEmpresaPorIdEmpresa(filtro);
	}
	
	public List<RepresentanteRedeEJB> obterRepresentante(RepresentanteRedeEJB filtro)
			throws MozartSessionException {
		return session.obterRepresentante(filtro);
	}
	
	public List<VendedorRedeEJB> obterVendedor(VendedorRedeEJB filtro)
			throws MozartSessionException {
		return session.obterVendedor(filtro);
	}
	
	public EmpresaEJB obterEmpresaPorNomeCnpj(EmpresaVO filtro) throws MozartSessionException {
		return session.obterEmpresaPorNomeCnpj(filtro);
	}
	
	public  List <EmpresaEJB> consultarEmpresaPorRazaoSocialLike(EmpresaEJB filtro) throws MozartSessionException {
		return session.consultarEmpresaPorRazaoSocialLike(filtro);
	}
	
}