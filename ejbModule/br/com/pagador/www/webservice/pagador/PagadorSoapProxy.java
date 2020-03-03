package br.com.pagador.www.webservice.pagador;

public class PagadorSoapProxy implements br.com.pagador.www.webservice.pagador.PagadorSoap {
  private String _endpoint = null;
  private br.com.pagador.www.webservice.pagador.PagadorSoap pagadorSoap = null;
  
  public PagadorSoapProxy() {
    _initPagadorSoapProxy();
  }
  
  public PagadorSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initPagadorSoapProxy();
  }
  
  private void _initPagadorSoapProxy() {
    try {
      pagadorSoap = (new br.com.pagador.www.webservice.pagador.PagadorLocator()).getPagadorSoap();
      if (pagadorSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)pagadorSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)pagadorSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (pagadorSoap != null)
      ((javax.xml.rpc.Stub)pagadorSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap() {
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap;
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorReturn authorize(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String amount, java.lang.String paymentMethod, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.authorize(merchantId, orderId, customerName, amount, paymentMethod, holder, cardNumber, expiration, securityCode, numberPayments, typePayment);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeWithDateFirstInstallment(br.com.pagador.www.webservice.pagador.AuthorizeWithDateFirstInstallmentRequest authorizeWithDateFirstInstallmentRequest) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.authorizeWithDateFirstInstallment(authorizeWithDateFirstInstallmentRequest);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeMobile(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String customerMobile, java.lang.String amount, java.lang.String paymentMethod, java.lang.String numberPayments, java.lang.String typePayment) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.authorizeMobile(merchantId, orderId, customerName, customerMobile, amount, paymentMethod, numberPayments, typePayment);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeMobilePartial(java.lang.String transactionId, java.lang.String mobile, java.lang.String typePayment) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.authorizeMobilePartial(transactionId, mobile, typePayment);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeWithServiceTax(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String amount, java.lang.String serviceTax, java.lang.String paymentMethod, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.authorizeWithServiceTax(merchantId, orderId, customerName, amount, serviceTax, paymentMethod, holder, cardNumber, expiration, securityCode, numberPayments, typePayment);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorAvsReturn authorizeAvs(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String amount, java.lang.String paymentMethod, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment, java.lang.String cpf, java.lang.String address, java.lang.String addressNumber, java.lang.String addressComplement, java.lang.String zipCode1, java.lang.String zipCode2, java.lang.String city, java.lang.String state, java.lang.String country) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.authorizeAvs(merchantId, orderId, customerName, amount, paymentMethod, holder, cardNumber, expiration, securityCode, numberPayments, typePayment, cpf, address, addressNumber, addressComplement, zipCode1, zipCode2, city, state, country);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorAvsReturn authorizeAvsStatus(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String amount, java.lang.String paymentMethod, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment, java.lang.String cpf, java.lang.String address, java.lang.String addressNumber, java.lang.String addressComplement, java.lang.String zipCode1, java.lang.String zipCode2, java.lang.String city, java.lang.String state, java.lang.String country, java.lang.String avsStatus) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.authorizeAvsStatus(merchantId, orderId, customerName, amount, paymentMethod, holder, cardNumber, expiration, securityCode, numberPayments, typePayment, cpf, address, addressNumber, addressComplement, zipCode1, zipCode2, city, state, country, avsStatus);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorVoidReturn voidTransaction(java.lang.String merchantId, java.lang.String order) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.voidTransaction(merchantId, order);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorVoidReturn voidPartial(java.lang.String merchantId, java.lang.String order, java.lang.String amount) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.voidPartial(merchantId, order, amount);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthResponse oneDollarAuth(br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthRequest pagadorOneDollarAuthRequest) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.oneDollarAuth(pagadorOneDollarAuthRequest);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorReturnWithService authorizeExistingAvsStatusWithService(java.lang.String transId, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment, java.lang.String cpf, java.lang.String address, java.lang.String addressNumber, java.lang.String addressComplement, java.lang.String zipCode1, java.lang.String zipCode2, java.lang.String city, java.lang.String state, java.lang.String country, java.lang.String avsStatus, boolean avs, java.lang.String serviceAmount) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.authorizeExistingAvsStatusWithService(transId, holder, cardNumber, expiration, securityCode, numberPayments, typePayment, cpf, address, addressNumber, addressComplement, zipCode1, zipCode2, city, state, country, avsStatus, avs, serviceAmount);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorReturn capture(java.lang.String merchantId, java.lang.String orderId) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.capture(merchantId, orderId);
  }
  
  public br.com.pagador.www.webservice.pagador.PagadorReturn capturePartial(java.lang.String merchantId, java.lang.String orderId, java.lang.String captureAmount) throws java.rmi.RemoteException{
    if (pagadorSoap == null)
      _initPagadorSoapProxy();
    return pagadorSoap.capturePartial(merchantId, orderId, captureAmount);
  }
  
  
}