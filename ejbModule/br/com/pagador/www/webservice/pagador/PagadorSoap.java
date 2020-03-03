/**
 * PagadorSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

public interface PagadorSoap extends java.rmi.Remote {

    /**
     * Authorize an order
     */
    public br.com.pagador.www.webservice.pagador.PagadorReturn authorize(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String amount, java.lang.String paymentMethod, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment) throws java.rmi.RemoteException;

    /**
     * Authorize an order with DateFirstInstallment
     */
    public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeWithDateFirstInstallment(br.com.pagador.www.webservice.pagador.AuthorizeWithDateFirstInstallmentRequest authorizeWithDateFirstInstallmentRequest) throws java.rmi.RemoteException;

    /**
     * Authorize a Mobile order
     */
    public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeMobile(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String customerMobile, java.lang.String amount, java.lang.String paymentMethod, java.lang.String numberPayments, java.lang.String typePayment) throws java.rmi.RemoteException;

    /**
     * Authorize a Mobile order (Partial, Internal)
     */
    public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeMobilePartial(java.lang.String transactionId, java.lang.String mobile, java.lang.String typePayment) throws java.rmi.RemoteException;

    /**
     * Authorize an order with service tax
     */
    public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeWithServiceTax(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String amount, java.lang.String serviceTax, java.lang.String paymentMethod, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment) throws java.rmi.RemoteException;

    /**
     * Authorize an order using AVS
     */
    public br.com.pagador.www.webservice.pagador.PagadorAvsReturn authorizeAvs(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String amount, java.lang.String paymentMethod, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment, java.lang.String cpf, java.lang.String address, java.lang.String addressNumber, java.lang.String addressComplement, java.lang.String zipCode1, java.lang.String zipCode2, java.lang.String city, java.lang.String state, java.lang.String country) throws java.rmi.RemoteException;

    /**
     * Authorize an order using AVS
     */
    public br.com.pagador.www.webservice.pagador.PagadorAvsReturn authorizeAvsStatus(java.lang.String merchantId, java.lang.String orderId, java.lang.String customerName, java.lang.String amount, java.lang.String paymentMethod, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment, java.lang.String cpf, java.lang.String address, java.lang.String addressNumber, java.lang.String addressComplement, java.lang.String zipCode1, java.lang.String zipCode2, java.lang.String city, java.lang.String state, java.lang.String country, java.lang.String avsStatus) throws java.rmi.RemoteException;

    /**
     * Cancel an order
     */
    public br.com.pagador.www.webservice.pagador.PagadorVoidReturn voidTransaction(java.lang.String merchantId, java.lang.String order) throws java.rmi.RemoteException;

    /**
     * Cancel Part of an order
     */
    public br.com.pagador.www.webservice.pagador.PagadorVoidReturn voidPartial(java.lang.String merchantId, java.lang.String order, java.lang.String amount) throws java.rmi.RemoteException;

    /**
     * Authorize a credit card order and cancel the order right after
     * confirmation
     */
    public br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthResponse oneDollarAuth(br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthRequest pagadorOneDollarAuthRequest) throws java.rmi.RemoteException;

    /**
     * Authorize an existing order using the transId
     */
    public br.com.pagador.www.webservice.pagador.PagadorReturnWithService authorizeExistingAvsStatusWithService(java.lang.String transId, java.lang.String holder, java.lang.String cardNumber, java.lang.String expiration, java.lang.String securityCode, java.lang.String numberPayments, java.lang.String typePayment, java.lang.String cpf, java.lang.String address, java.lang.String addressNumber, java.lang.String addressComplement, java.lang.String zipCode1, java.lang.String zipCode2, java.lang.String city, java.lang.String state, java.lang.String country, java.lang.String avsStatus, boolean avs, java.lang.String serviceAmount) throws java.rmi.RemoteException;

    /**
     * Capture an order
     */
    public br.com.pagador.www.webservice.pagador.PagadorReturn capture(java.lang.String merchantId, java.lang.String orderId) throws java.rmi.RemoteException;

    /**
     * Capture Part of an order
     */
    public br.com.pagador.www.webservice.pagador.PagadorReturn capturePartial(java.lang.String merchantId, java.lang.String orderId, java.lang.String captureAmount) throws java.rmi.RemoteException;
}
