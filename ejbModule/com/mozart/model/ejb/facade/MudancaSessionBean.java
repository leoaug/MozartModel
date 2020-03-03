package com.mozart.model.ejb.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.ScmMudancaComplementoEJB;
import com.mozart.model.ejb.entity.ScmMudancaEJB;
import com.mozart.model.ejb.entity.ScmSistemaEJB;
import com.mozart.model.ejb.entity.ScmStatusEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ScmMudancaVO;

@Stateless(name="MudancaSession")
public class MudancaSessionBean implements MudancaSession{

	@PersistenceContext(unitName="MozartModel")
	private EntityManager manager;
	
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute( value = TransactionAttributeType.SUPPORTS )    
	public List<ScmMudancaVO> pesquisarMudanca(ScmMudancaVO pFiltro) throws MozartSessionException {

		if (pFiltro.getIdHoteis() == null|| pFiltro.getIdHoteis()[0]==null){
			throw new MozartValidateException("O campo 'Hotel' é obrigatório.");
		}

		try{
			String qry = QRY_MUDANCA;
			String orderBy = " ORDER BY ID_MUDANCA, DATA DESC ";
			qry += orderBy;
			
			List<Object[]> resultArray = manager.createNativeQuery(qry)
							.setParameter(1, pFiltro.getUsuario().getIdUsuario())
							.setParameter(2, pFiltro.getUsuario().getIdUsuario())
							.getResultList();
			
			List<ScmMudancaVO> result = new ArrayList<ScmMudancaVO>();
			for(Object[] linha: resultArray){
				result.add( new ScmMudancaVO( linha ));
			}
			return result;
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
			
		}
	}


	@SuppressWarnings("unchecked")
	public List<ScmSistemaEJB> pesquisarSistema() throws MozartSessionException {
		try{
			List<ScmSistemaEJB> result = manager.createNamedQuery("ScmSistemaEJB.findAll").
							getResultList();
			return result;
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
			
		}	
	}


	@SuppressWarnings("unchecked")
	public List<ScmStatusEJB> pesquisarStatus(ScmMudancaEJB filtro)
			throws MozartSessionException {
		try{

			ScmMudancaComplementoEJB ultimoComplemento = null;
			if (!MozartUtil.isNull( filtro.getScmMudancaComplementos())){
				ultimoComplemento = filtro.getScmMudancaComplementos().get( filtro.getScmMudancaComplementos().size()-1 );
			}
			
			if (MozartUtil.isNull(filtro.getIdMudanca())){
				return manager.createNamedQuery("ScmStatusEJB.findInicialPara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 1){
				return manager.createNamedQuery("ScmStatusEJB.findAbertoPara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 3){
				return manager.createNamedQuery("ScmStatusEJB.findPendentePara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 2){
				return manager.createNamedQuery("ScmStatusEJB.findRecebidoPara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 5){
				return manager.createNamedQuery("ScmStatusEJB.findAnalisadoPara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 4){
				return manager.createNamedQuery("ScmStatusEJB.findRejeitadoPara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 7){
				return manager.createNamedQuery("ScmStatusEJB.findDesenvolvidoPara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 6){
				return manager.createNamedQuery("ScmStatusEJB.findSuspensoPara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 8){
				return manager.createNamedQuery("ScmStatusEJB.findTestadoPara").
				getResultList();
			}else if (ultimoComplemento.getScmStatusEJB().getIdStatus().intValue() == 9){
				return manager.createNamedQuery("ScmStatusEJB.findHomologadoPara").
				getResultList();
			}else{
				return manager.createNamedQuery("ScmStatusEJB.findAll").
				getResultList();
				
			}
			
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
			
		}	
	}

	
	
	
}
