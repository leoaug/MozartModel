package com.mozart.model.ejb.facade;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.TipoLancamentoEJB;
import com.mozart.model.ejb.entity.TipoLancamentoEJBPK;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.HotelVO;
import com.mozart.model.vo.TipoLancamentoVO;

@SuppressWarnings("unchecked")
@Stateless(name="TipoLancamentoSession")
public class TipoLancamentoSessionBean implements TipoLancamentoSession{

	@PersistenceContext(unitName="MozartModel")
	private EntityManager entityManager;

	@Override
	public List<TipoLancamentoVO> consultarTipoLancamentoReceita(HotelVO filtro)
			throws MozartSessionException {
		
		List<TipoLancamentoVO> listaLancamentos = new ArrayList<TipoLancamentoVO> ();
		
		String sql = "SELECT "
						+ " ID_TIPO_LANCAMENTO,"
						+ " DESCRICAO_LANCAMENTO \n" + 
					" FROM "
						+ "TIPO_LANCAMENTO TL \n" + 
					" WHERE "
						+ " ID_HOTEL = " + filtro.getIdHotel() 
						+ " AND ID_IDENTIFICA_LANCAMENTO = 51 \n" 
						+ " ORDER BY DESCRICAO_LANCAMENTO";
		
		
		List <Object[]> listaQuery = this.entityManager.createNativeQuery(sql).getResultList();
		
		for(Object[] obj : listaQuery) {
			Object[] param = (Object[]) obj;
			
			TipoLancamentoVO vo = new TipoLancamentoVO();
			vo.setIdTipoLancamento(Long.parseLong(param[0].toString()));
			vo.setDescricaoLancamento(param[1].toString());
			
			listaLancamentos.add(vo);
			
		}
		
		return listaLancamentos;
	}

	@Override
	public List<TipoLancamentoVO> consultarTipoLancamentoRecebimento(HotelVO filtro)
			throws MozartSessionException {
		
		List<TipoLancamentoVO> listaLancamentos = new ArrayList<TipoLancamentoVO> ();
		
		String sql = "SELECT "
						+ " TL.ID_IDENTIFICA_LANCAMENTO,"
						+ " TL.DESCRICAO_LANCAMENTO \n" + 
					"FROM "
						+ "TIPO_LANCAMENTO TL \n"  
						+ "JOIN IDENTIFICA_LANCAMENTO IL ON (TL.ID_IDENTIFICA_LANCAMENTO = IL.ID_IDENTIFICA_LANCAMENTO) \n" + 
					"WHERE "
						+ " TL.ID_HOTEL = " + filtro.getIdHotel()  
						+ " AND IL.RECEITA_CHECKOUT = 2 \n"  
						+" AND TL.SUB_GRUPO_LANCAMENTO <> 000 \n" + 
					"ORDER BY TL.DESCRICAO_LANCAMENTO";
		
		
		List <Object[]> listaQuery = this.entityManager.createNativeQuery(sql).getResultList();
		
		for(Object[] obj : listaQuery) {
			Object[] param = (Object[]) obj;
			
			TipoLancamentoVO vo = new TipoLancamentoVO();
			
			vo.setIdIdentificaLancamento(Long.parseLong(param[0].toString()));
			vo.setDescricaoLancamento(param[1].toString());
			
			listaLancamentos.add(vo);
			
		}
		
		return listaLancamentos;
	}

	@Override
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public TipoLancamentoEJB consultarTipoLancamentoEJBPK(TipoLancamentoEJBPK tipoLancamentoEJBPK) throws MozartSessionException  {
		// TODO Auto-generated method stub
	
		return  this.entityManager.find(TipoLancamentoEJB.class, tipoLancamentoEJBPK);
	}
	
	
}
	
	
	

