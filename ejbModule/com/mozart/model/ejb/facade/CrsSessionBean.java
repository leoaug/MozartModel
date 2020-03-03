package com.mozart.model.ejb.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.ejb.entity.CentralReservaEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.CrsVO;
import com.mozart.model.vo.EmpresaRedeVO;
import com.mozart.model.vo.OcupDispVO;


@Stateless(name="CrsSessionEJB")
public class CrsSessionBean implements CrsSession {

	
    @PersistenceContext(unitName="MozartModel")
    private EntityManager manager;

    
    
    @SuppressWarnings("unchecked")
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public HotelEJB pesquisarOcupacao(CrsVO filtro) throws MozartSessionException {
    	try{
        		List result = manager.createNativeQuery(QRY_OCUPACAO_HOTEL).
		        	setParameter(1, filtro.getDataEntrada()).
		        	setParameter(2, filtro.getDataSaida()).
		        	setParameter(3, filtro.getIdHotel()).
		        	setParameter(4, filtro.getBloqueio()).
		        	getResultList();
        		List<OcupDispVO> ocupacao = new ArrayList<OcupDispVO>();	
        		for (Object linha: result){
        			ocupacao.add( new OcupDispVO( (Object[])linha ) );
        		}
        		HotelEJB hotel = new HotelEJB();
        		hotel.setTarifaMedia(Boolean.FALSE);
        		hotel.setDisponibilidade( ocupacao );
			return hotel;
        	
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public HotelEJB pesquisarDisponibilidade(CrsVO filtro) throws MozartSessionException {
    	try{
        		List result = manager.createNativeQuery(QRY_DISPO_HOTEL).
		        	setParameter(1, filtro.getDataEntrada()).
		        	setParameter(2, filtro.getDataSaida()).
		        	setParameter(3, filtro.getIdHotel()).
		        	setParameter(4, filtro.getBloqueio()).
		        	getResultList();
        		List<OcupDispVO> disponibilidade = new ArrayList<OcupDispVO>();	
        		for (Object linha: result){
        			disponibilidade.add( new OcupDispVO( (Object[])linha ) );
        		}
        		
        		HotelEJB hotel = new HotelEJB();
        		hotel.setTarifaMedia(Boolean.FALSE);
        		hotel.setDisponibilidade( disponibilidade );
        		return hotel;
        	
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
    }
    		
	@SuppressWarnings("unchecked")
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<HotelEJB> pesquisarHotel(CrsVO filtro) throws MozartSessionException {
    	try{
            
        	List<HotelEJB> resultList = (List<HotelEJB>)manager.createNativeQuery( QRY_PESQUISA_HOTEL, HotelEJB.class ).
		        	setParameter(1, filtro.getQtdePessoa()).
		        	setParameter(2, filtro.getDataEntrada()).
		        	setParameter(3, filtro.getDataSaida()).
		        	setParameter(4, filtro.getIdCrs()).
		        	setParameter(5, filtro.getIdHotel()).
		        	setParameter(6, filtro.getIdCrs()).
		        	setParameter(7, filtro.getIdHotel()).
		        	setParameter(8, filtro.getBairro()).
		        	setParameter(9, filtro.getTarifaAte()).
		        	setParameter(10, filtro.getIdCidade()).
		        	getResultList();
        	
        	
        	for (HotelEJB hotel: resultList){
        		
        		hotel.setTarifaMedia( MozartUtil.getDiferencaDia(filtro.getDataEntrada(), filtro.getDataSaida()) >= 7 );
        		
        		List result = manager.createNativeQuery(QRY_DISPO_HOTEL).
		        	setParameter(1, filtro.getDataEntrada()).
		        	setParameter(2, filtro.getDataSaida()).
		        	setParameter(3, hotel.getIdHotel()).
		        	setParameter(4, filtro.getBloqueio()).
		        	getResultList();
        		List<OcupDispVO> disponibilidade = new ArrayList<OcupDispVO>();	
        		for (Object linha: result){
        			disponibilidade.add( new OcupDispVO( (Object[])linha ) );
        		}
        		hotel.setDisponibilidade(disponibilidade);
        		
        		EmpresaRedeVO empresaRedeVO = new EmpresaRedeVO();
	    		empresaRedeVO.setIdRedeHotel(hotel.getRedeHotelEJB().getIdRedeHotel());
	    		empresaRedeVO.setBcParticular("S");
//	    		empresaRedeVO = ReservaDelegate.instance().obterEmpresaRedePorIdERede(empresaRedeVO);
        		result = manager.createNativeQuery(QRY_TARIFA_HOTEL).
        						setParameter(1, filtro.getQtdePessoa()).
					        	setParameter(2, filtro.getDataEntrada()).
					        	setParameter(3, filtro.getDataSaida()).
					        	setParameter(4, empresaRedeVO.getBcIdEmpresa()).
					        	setParameter(5, hotel.getIdHotel()).
					        	setParameter(6, hotel.getIdHotel()).
					        	getResultList();

        		List<OcupDispVO> tarifas = new ArrayList<OcupDispVO>();	
        		for (Object linha: result){
        			tarifas.add( new OcupDispVO( (Object[])linha ) );
        		}
        		hotel.setTarifa(tarifas);
        		
        		
        	}
        	
        	
			return resultList;
        	
        }catch(Exception ex){
            throw new MozartSessionException(ex.getMessage());
        }
        
    }

	@SuppressWarnings("unchecked")
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public CentralReservaEJB obterCrsPropria(RedeHotelEJB redeHotelEJB)
			throws MozartSessionException {
	
		try{
	    		List<CentralReservaEJB> result = manager.createNativeQuery(QRY_CRS_PROPRIA, CentralReservaEJB.class).setHint("eclipselink.refresh", "TRUE").
		        	setParameter(1, redeHotelEJB.getIdRedeHotel()).
		        	getResultList();
	    		
	    		if (MozartUtil.isNull( result )){
	    			return null;
	    		}else{
	    			return result.get(0);
	    		}
	    		
	    }catch(Exception ex){
	        throw new MozartSessionException(ex.getMessage());
	    }
	
			
		
	}

    
}
