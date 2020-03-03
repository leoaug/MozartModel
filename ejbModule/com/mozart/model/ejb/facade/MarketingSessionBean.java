package com.mozart.model.ejb.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.MarketingPorEmpresaVO;


@Stateless(name="MarketingSession")
public class MarketingSessionBean implements MarketingSession{
	
	@PersistenceContext(unitName="MozartModel")
	private EntityManager manager;


	
	@SuppressWarnings("unchecked")
	@TransactionAttribute( value = TransactionAttributeType.SUPPORTS )    
	public List<MarketingPorEmpresaVO> pesquisarReservasPorEmpreasa(
			MarketingPorEmpresaVO pFiltro) throws MozartSessionException {

		if (pFiltro.getIdHoteis() == null|| pFiltro.getIdHoteis()[0]==null){
			throw new MozartValidateException("O campo 'Hotel' é obrigatório.");
		}

		if (pFiltro.getFiltroPeriodo() == null|| pFiltro.getFiltroPeriodo().getValorInicial()==null|| pFiltro.getFiltroPeriodo().getValorFinal()==null){
			throw new MozartValidateException("O campo 'Período' é obrigatório.");
		}
		
		try{
			String qry = QRY_POR_EMPRESA;
			
			if (!MozartUtil.isNull( pFiltro.getFiltroCidade().getTipoIntervalo())){
				qry += " AND CIDADE " + pFiltro.getFiltroCidade().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroCrs().getTipoIntervalo())){
				qry += " AND CRS " + pFiltro.getFiltroCrs().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroDiariaMedia().getTipoIntervalo())){
				qry += " AND DIARIA_MEDIA " + pFiltro.getFiltroDiariaMedia().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroEstado().getTipoIntervalo())){
				qry += " AND ESTADO " + pFiltro.getFiltroEstado().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroFormaReserva().getTipoIntervalo())){
				qry += " AND FORMA_RESERVA " + pFiltro.getFiltroFormaReserva().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroNomeEmpresa().getTipoIntervalo())){
				qry += " AND NOME_FANTASIA " + pFiltro.getFiltroNomeEmpresa().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroPromotor().getTipoIntervalo())){
				qry += " AND PROMOTOR " + pFiltro.getFiltroPromotor().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroRoomNight().getTipoIntervalo())){
				qry += " AND RN " + pFiltro.getFiltroRoomNight().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroTicketMedio().getTipoIntervalo())){
				qry += " AND TICKET_MEDIO " + pFiltro.getFiltroTicketMedio().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroTipoEmpresa().getTipoIntervalo())){
				qry += " AND TIPO_EMPRESA " + pFiltro.getFiltroTipoEmpresa().toString();
			}
			if (!MozartUtil.isNull( pFiltro.getFiltroValorConsumoMedio().getTipoIntervalo())){
				qry += " AND DIARIA_MEDIA " + pFiltro.getFiltroValorConsumoMedio().toString();
			}

			if (!MozartUtil.isNull( pFiltro.getFiltroCidadeOrigem().getTipoIntervalo())){
				qry += " AND upper(CIDADE_ORIGEM) " + pFiltro.getFiltroCidadeOrigem().toString();
			}

			if (!MozartUtil.isNull( pFiltro.getFiltroCidadeDestino().getTipoIntervalo())){
				qry += " AND upper(CIDADE_DESTINO) " + pFiltro.getFiltroCidadeDestino().toString();
			}
			
			int x = 1;
			List<Object[]> resultArray = manager.createNativeQuery(qry).
							setParameter(x++, pFiltro.getIdHoteisSQL()).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorInicial())).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorFinal())).
							setParameter(x++, pFiltro.getIdHoteisSQL()).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorInicial())).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorFinal())).
							setParameter(x++, pFiltro.getIdHoteisSQL()).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorInicial())).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorFinal())).
							setParameter(x++, pFiltro.getIdHoteisSQL()).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorInicial())).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorFinal())).
							setParameter(x++, pFiltro.getIdHoteisSQL()).
							setParameter(x++, pFiltro.getIdHoteisSQL()).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorInicial())).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorFinal())).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorInicial())).
							setParameter(x++, MozartUtil.toTimestamp(pFiltro.getFiltroPeriodo().getValorFinal())).
							getResultList();
			
			List<MarketingPorEmpresaVO> result = new ArrayList<MarketingPorEmpresaVO>();
			for(Object[] linha: resultArray){
				result.add( new MarketingPorEmpresaVO( linha ));
			}
			return result;
		}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
			
		}
	}


	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void executarRDSAnual(Long idHotel, String ateDia, String ateMes, String anoInicial, String anoFinal) throws MozartSessionException {

		try{
			manager.createNativeQuery( "{call RDS_ANUAL(?1, ?2, ?3, ?4, ?5)}").
				setParameter(1, idHotel).
				setParameter(2, Integer.parseInt(ateDia)).
				setParameter(3, Integer.parseInt(ateMes)).
				setParameter(4, Integer.parseInt(anoInicial)).
				setParameter(5, Integer.parseInt(anoFinal)).
				executeUpdate();
		}catch(Exception ex){
			throw new MozartValidateException(ex.getMessage());
		}

		
		
	}
}
