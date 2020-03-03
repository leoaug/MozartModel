package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.pagador.www.webservice.pagador.PagadorSoapProxy;

import com.mozart.model.ejb.entity.TransacaoWebEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;

@Stateless(name="BraspagSession")
public class BraspagSessionBean implements BraspagSession{

	
	@PersistenceContext(unitName="MozartModel")
    private EntityManager manager;

	
	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TransacaoWebEJB realizarTransacaoWeb(TransacaoWebEJB novaTransacao) throws MozartSessionException {
		
		try{
			PagadorSoapProxy samplePagadorSoapProxyid = new PagadorSoapProxy();
			
			Long idPedido = ((BigDecimal)manager.createNativeQuery("select seq_braspag.nextval from dual").getSingleResult()).longValue();
			
			//Loja
			String merchantId_1idTemp = novaTransacao.getHotelEJB().getCodLoja();
			//idPedido
			String orderId_2idTemp = idPedido.toString();
			//Nome do cliente
			String customerName_3idTemp = novaTransacao.getNomeCartao();
			//valor formato brasileiro
			String amount_4idTemp = MozartUtil.format( novaTransacao.getValorTransacao() );
			//codigo do pagamento, no caso do personal é 41
			String paymentMethod_5idTemp = novaTransacao.getTipoLancamentoEJB().getCodTransacaoWeb();
			// nome do cartao
			String holder_6idTemp = novaTransacao.getNomeCartao();
			
			String cardNumber_7idTemp = novaTransacao.getNumeroCartao();
			String expiration_8idTemp = novaTransacao.getValidade();
			String securityCode_9idTemp = novaTransacao.getCodSeguranca();
			// numeros de parcelas
			String numberPayments_10idTemp = "1";
			//0 - a vista
			String typePayment_11idTemp = "0";

			br.com.pagador.www.webservice.pagador.PagadorReturn authorize13mtemp = null;
			authorize13mtemp = samplePagadorSoapProxyid.authorize(merchantId_1idTemp,orderId_2idTemp,customerName_3idTemp,
			amount_4idTemp,paymentMethod_5idTemp,holder_6idTemp,cardNumber_7idTemp,expiration_8idTemp,securityCode_9idTemp,numberPayments_10idTemp,typePayment_11idTemp);
		
			if (authorize13mtemp == null)
				throw new MozartValidateException("Não foi possível entrar em contato com a operadora");
			
			novaTransacao.setCodRetorno(authorize13mtemp.getReturnCode());
			novaTransacao.setCodAutorizacao( authorize13mtemp.getAuthorisationNumber() );
			novaTransacao.setTxtMensagem( authorize13mtemp.getMessage() );
			novaTransacao.setIdTransacaoWeb(idPedido);
			novaTransacao.setCodTransacao(authorize13mtemp.getTransactionId());
			novaTransacao.setDataTransacao( new Timestamp(new Date().getTime()));
			
			if (!"0".equals( novaTransacao.getCodRetorno())){
				throw new MozartValidateException(novaTransacao.getTxtMensagem());
			}
			manager.persist( novaTransacao );
			return novaTransacao;
		    
		}catch(MozartValidateException ex){	
		    throw ex;
		}catch(Exception ex){
			throw new MozartSessionException( ex.getMessage() );
		}
	}
	
	@Interceptors(value={UsuarioSessionInfoInterceptor.class})
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TransacaoWebEJB estornarTransacaoWeb(TransacaoWebEJB transacao) throws MozartSessionException {
		
		try{
			PagadorSoapProxy samplePagadorSoapProxyid = new PagadorSoapProxy();
			//Loja
			String merchantId_1idTemp = transacao.getHotelEJB().getCodLoja();
			//idPedido
			String orderId_2idTemp = String.valueOf(transacao.getIdTransacaoWeb());

			br.com.pagador.www.webservice.pagador.PagadorVoidReturn authorize13mtemp = null;
			authorize13mtemp = samplePagadorSoapProxyid.voidTransaction(merchantId_1idTemp, orderId_2idTemp);
		
			if (authorize13mtemp == null)
				throw new MozartValidateException("Não foi possível entrar em contato com a operadora");
			

			
			if (authorize13mtemp.getStatus().intValue() > 0){
				throw new MozartValidateException(
						transacao.getTxtMensagem()!=null?transacao.getTxtMensagem():	
						authorize13mtemp.getStatus().intValue()==1?"O pedido não foi cancelado":
						authorize13mtemp.getStatus().intValue()==2?"O pedido não foi encontrado ou já foi cancelado no sistema":""
				);
			}
			
			transacao = manager.find(TransacaoWebEJB.class, transacao.getIdTransacaoWeb());
			transacao.setCodRetorno(authorize13mtemp.getReturnCode());
			transacao.setStatus(authorize13mtemp.getStatus().longValue());
			transacao.setTxtMensagem( authorize13mtemp.getMessage() );
			transacao.setCodTransacao(authorize13mtemp.getTransactionId());
			transacao.setDataTransacao( new Timestamp(new Date().getTime()));
			manager.merge( transacao  );
			return transacao ;
		    
		}catch(MozartValidateException ex){	
		    throw ex;
		}catch(Exception ex){
			throw new MozartSessionException( ex.getMessage() );
		}
	}
	
	
}
