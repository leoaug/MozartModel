/**
 * PagadorSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

@SuppressWarnings("unchecked")
public class PagadorSoapStub extends org.apache.axis.client.Stub implements
		br.com.pagador.www.webservice.pagador.PagadorSoap {
	private java.util.Vector cachedSerClasses = new java.util.Vector();
	private java.util.Vector cachedSerQNames = new java.util.Vector();
	private java.util.Vector cachedSerFactories = new java.util.Vector();
	private java.util.Vector cachedDeserFactories = new java.util.Vector();

	static org.apache.axis.description.OperationDesc[] _operations;

	static {
		_operations = new org.apache.axis.description.OperationDesc[13];
		_initOperationDesc1();
		_initOperationDesc2();
	}

	private static void _initOperationDesc1() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("Authorize");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"orderId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"customerName"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"amount"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"paymentMethod"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"holder"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"cardNumber"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"expiration"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"securityCode"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"numberPayments"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"typePayment"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[0] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("AuthorizeWithDateFirstInstallment");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"authorizeWithDateFirstInstallmentRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"AuthorizeWithDateFirstInstallmentRequest"),
				br.com.pagador.www.webservice.pagador.AuthorizeWithDateFirstInstallmentRequest.class,
				false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeWithDateFirstInstallmentResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[1] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("AuthorizeMobile");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"orderId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"customerName"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"customerMobile"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"amount"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"paymentMethod"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"numberPayments"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"typePayment"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeMobileResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[2] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("AuthorizeMobilePartial");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"transactionId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"mobile"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"typePayment"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeMobilePartialResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[3] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("AuthorizeWithServiceTax");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"orderId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"customerName"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"amount"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"serviceTax"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"paymentMethod"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"holder"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"cardNumber"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"expiration"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"securityCode"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"numberPayments"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"typePayment"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeWithServiceTaxResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[4] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("AuthorizeAvs");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"orderId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"customerName"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"amount"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"paymentMethod"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"holder"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"cardNumber"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"expiration"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"securityCode"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"numberPayments"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"typePayment"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador", "cpf"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"address"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"addressNumber"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"addressComplement"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"zipCode1"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"zipCode2"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador", "city"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"state"), org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"country"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorAvsReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorAvsReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeAvsResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[5] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("AuthorizeAvsStatus");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"orderId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"customerName"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"amount"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"paymentMethod"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"holder"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"cardNumber"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"expiration"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"securityCode"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"numberPayments"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"typePayment"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador", "cpf"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"address"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"addressNumber"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"addressComplement"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"zipCode1"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"zipCode2"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador", "city"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"state"), org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"country"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"avsStatus"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorAvsReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorAvsReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeAvsStatusResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[6] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("VoidTransaction");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"order"), org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorVoidReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorVoidReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"VoidTransactionResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[7] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("VoidPartial");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"order"), org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"amount"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorVoidReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorVoidReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"VoidPartialResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[8] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("OneDollarAuth");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"PagadorOneDollarAuthRequest"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"PagadorOneDollarAuthRequest"),
				br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthRequest.class,
				false, false);
		param.setNillable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorOneDollarAuthResponse"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthResponse.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorOneDollarAuthResponse"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[9] = oper;

	}

	private static void _initOperationDesc2() {
		org.apache.axis.description.OperationDesc oper;
		org.apache.axis.description.ParameterDesc param;
		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("AuthorizeExistingAvsStatusWithService");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"transId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"holder"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"cardNumber"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"expiration"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"securityCode"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"numberPayments"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"typePayment"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador", "cpf"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"address"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"addressNumber"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"addressComplement"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"zipCode1"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"zipCode2"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador", "city"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"state"), org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"country"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"avsStatus"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador", "avs"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "boolean"),
				boolean.class, false, false);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"serviceAmount"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturnWithService"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorReturnWithService.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeExistingAvsStatusWithServiceResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[10] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("Capture");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"orderId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CaptureResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[11] = oper;

		oper = new org.apache.axis.description.OperationDesc();
		oper.setName("CapturePartial");
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"merchantId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"orderId"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		param = new org.apache.axis.description.ParameterDesc(
				new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"captureAmount"),
				org.apache.axis.description.ParameterDesc.IN,
				new javax.xml.namespace.QName(
						"http://www.w3.org/2001/XMLSchema", "string"),
				java.lang.String.class, false, false);
		param.setOmittable(true);
		oper.addParameter(param);
		oper.setReturnType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		oper
				.setReturnClass(br.com.pagador.www.webservice.pagador.PagadorReturn.class);
		oper.setReturnQName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CapturePartialResult"));
		oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
		oper.setUse(org.apache.axis.constants.Use.LITERAL);
		_operations[12] = oper;

	}

	public PagadorSoapStub() throws org.apache.axis.AxisFault {
		this(null);
	}

	public PagadorSoapStub(java.net.URL endpointURL,
			javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
		this(service);
		super.cachedEndpoint = endpointURL;
	}

	public PagadorSoapStub(javax.xml.rpc.Service service)
			throws org.apache.axis.AxisFault {
		if (service == null) {
			super.service = new org.apache.axis.client.Service();
		} else {
			super.service = service;
		}
		((org.apache.axis.client.Service) super.service)
				.setTypeMappingVersion("1.2");
		java.lang.Class cls;
		javax.xml.namespace.QName qName;
		java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
		java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
		qName = new javax.xml.namespace.QName(
				"http://microsoft.com/wsdl/types/", "guid");
		cachedSerQNames.add(qName);
		cls = java.lang.String.class;
		cachedSerClasses.add(cls);
		cachedSerFactories
				.add(org.apache.axis.encoding.ser.BaseSerializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleSerializerFactory.class,
								cls, qName));
		cachedDeserFactories
				.add(org.apache.axis.encoding.ser.BaseDeserializerFactory
						.createFactory(
								org.apache.axis.encoding.ser.SimpleDeserializerFactory.class,
								cls, qName));

		qName = new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeWithDateFirstInstallmentRequest");
		cachedSerQNames.add(qName);
		cls = br.com.pagador.www.webservice.pagador.AuthorizeWithDateFirstInstallmentRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorAvsReturn");
		cachedSerQNames.add(qName);
		cls = br.com.pagador.www.webservice.pagador.PagadorAvsReturn.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorOneDollarAuthRequest");
		cachedSerQNames.add(qName);
		cls = br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthRequest.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorOneDollarAuthResponse");
		cachedSerQNames.add(qName);
		cls = br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthResponse.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn");
		cachedSerQNames.add(qName);
		cls = br.com.pagador.www.webservice.pagador.PagadorReturn.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturnWithService");
		cachedSerQNames.add(qName);
		cls = br.com.pagador.www.webservice.pagador.PagadorReturnWithService.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

		qName = new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorVoidReturn");
		cachedSerQNames.add(qName);
		cls = br.com.pagador.www.webservice.pagador.PagadorVoidReturn.class;
		cachedSerClasses.add(cls);
		cachedSerFactories.add(beansf);
		cachedDeserFactories.add(beandf);

	}

	protected org.apache.axis.client.Call createCall()
			throws java.rmi.RemoteException {
		try {
			org.apache.axis.client.Call _call = super._createCall();
			if (super.maintainSessionSet) {
				_call.setMaintainSession(super.maintainSession);
			}
			if (super.cachedUsername != null) {
				_call.setUsername(super.cachedUsername);
			}
			if (super.cachedPassword != null) {
				_call.setPassword(super.cachedPassword);
			}
			if (super.cachedEndpoint != null) {
				_call.setTargetEndpointAddress(super.cachedEndpoint);
			}
			if (super.cachedTimeout != null) {
				_call.setTimeout(super.cachedTimeout);
			}
			if (super.cachedPortName != null) {
				_call.setPortName(super.cachedPortName);
			}
			java.util.Enumeration keys = super.cachedProperties.keys();
			while (keys.hasMoreElements()) {
				java.lang.String key = (java.lang.String) keys.nextElement();
				_call.setProperty(key, super.cachedProperties.get(key));
			}
			// All the type mapping information is registered
			// when the first call is made.
			// The type mapping information is actually registered in
			// the TypeMappingRegistry of the service, which
			// is the reason why registration is only needed for the first call.
			synchronized (this) {
				if (firstCall()) {
					// must set encoding style before registering serializers
					_call.setEncodingStyle(null);
					for (int i = 0; i < cachedSerFactories.size(); ++i) {
						java.lang.Class cls = (java.lang.Class) cachedSerClasses
								.get(i);
						javax.xml.namespace.QName qName = (javax.xml.namespace.QName) cachedSerQNames
								.get(i);
						java.lang.Object x = cachedSerFactories.get(i);
						if (x instanceof Class) {
							java.lang.Class sf = (java.lang.Class) cachedSerFactories
									.get(i);
							java.lang.Class df = (java.lang.Class) cachedDeserFactories
									.get(i);
							_call
									.registerTypeMapping(cls, qName, sf, df,
											false);
						} else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
							org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory) cachedSerFactories
									.get(i);
							org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory) cachedDeserFactories
									.get(i);
							_call
									.registerTypeMapping(cls, qName, sf, df,
											false);
						}
					}
				}
			}
			return _call;
		} catch (java.lang.Throwable _t) {
			throw new org.apache.axis.AxisFault(
					"Failure trying to get the Call object", _t);
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorReturn authorize(
			java.lang.String merchantId, java.lang.String orderId,
			java.lang.String customerName, java.lang.String amount,
			java.lang.String paymentMethod, java.lang.String holder,
			java.lang.String cardNumber, java.lang.String expiration,
			java.lang.String securityCode, java.lang.String numberPayments,
			java.lang.String typePayment) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[0]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/Authorize");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Authorize"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					merchantId, orderId, customerName, amount, paymentMethod,
					holder, cardNumber, expiration, securityCode,
					numberPayments, typePayment });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeWithDateFirstInstallment(
			br.com.pagador.www.webservice.pagador.AuthorizeWithDateFirstInstallmentRequest authorizeWithDateFirstInstallmentRequest)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[1]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/AuthorizeWithDateFirstInstallment");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeWithDateFirstInstallment"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { authorizeWithDateFirstInstallmentRequest });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeMobile(
			java.lang.String merchantId, java.lang.String orderId,
			java.lang.String customerName, java.lang.String customerMobile,
			java.lang.String amount, java.lang.String paymentMethod,
			java.lang.String numberPayments, java.lang.String typePayment)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[2]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/AuthorizeMobile");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeMobile"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					merchantId, orderId, customerName, customerMobile, amount,
					paymentMethod, numberPayments, typePayment });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeMobilePartial(
			java.lang.String transactionId, java.lang.String mobile,
			java.lang.String typePayment) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[3]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/AuthorizeMobilePartial");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeMobilePartial"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					transactionId, mobile, typePayment });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorReturn authorizeWithServiceTax(
			java.lang.String merchantId, java.lang.String orderId,
			java.lang.String customerName, java.lang.String amount,
			java.lang.String serviceTax, java.lang.String paymentMethod,
			java.lang.String holder, java.lang.String cardNumber,
			java.lang.String expiration, java.lang.String securityCode,
			java.lang.String numberPayments, java.lang.String typePayment)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[4]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/AuthorizeWithServiceTax");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeWithServiceTax"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					merchantId, orderId, customerName, amount, serviceTax,
					paymentMethod, holder, cardNumber, expiration,
					securityCode, numberPayments, typePayment });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorAvsReturn authorizeAvs(
			java.lang.String merchantId, java.lang.String orderId,
			java.lang.String customerName, java.lang.String amount,
			java.lang.String paymentMethod, java.lang.String holder,
			java.lang.String cardNumber, java.lang.String expiration,
			java.lang.String securityCode, java.lang.String numberPayments,
			java.lang.String typePayment, java.lang.String cpf,
			java.lang.String address, java.lang.String addressNumber,
			java.lang.String addressComplement, java.lang.String zipCode1,
			java.lang.String zipCode2, java.lang.String city,
			java.lang.String state, java.lang.String country)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[5]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/AuthorizeAvs");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call
				.setOperationName(new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"AuthorizeAvs"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { merchantId, orderId,
							customerName, amount, paymentMethod, holder,
							cardNumber, expiration, securityCode,
							numberPayments, typePayment, cpf, address,
							addressNumber, addressComplement, zipCode1,
							zipCode2, city, state, country });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorAvsReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorAvsReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorAvsReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorAvsReturn authorizeAvsStatus(
			java.lang.String merchantId, java.lang.String orderId,
			java.lang.String customerName, java.lang.String amount,
			java.lang.String paymentMethod, java.lang.String holder,
			java.lang.String cardNumber, java.lang.String expiration,
			java.lang.String securityCode, java.lang.String numberPayments,
			java.lang.String typePayment, java.lang.String cpf,
			java.lang.String address, java.lang.String addressNumber,
			java.lang.String addressComplement, java.lang.String zipCode1,
			java.lang.String zipCode2, java.lang.String city,
			java.lang.String state, java.lang.String country,
			java.lang.String avsStatus) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[6]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/AuthorizeAvsStatus");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeAvsStatus"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					merchantId, orderId, customerName, amount, paymentMethod,
					holder, cardNumber, expiration, securityCode,
					numberPayments, typePayment, cpf, address, addressNumber,
					addressComplement, zipCode1, zipCode2, city, state,
					country, avsStatus });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorAvsReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorAvsReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorAvsReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorVoidReturn voidTransaction(
			java.lang.String merchantId, java.lang.String order)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[7]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/VoidTransaction");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"VoidTransaction"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					merchantId, order });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorVoidReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorVoidReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorVoidReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorVoidReturn voidPartial(
			java.lang.String merchantId, java.lang.String order,
			java.lang.String amount) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[8]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/VoidPartial");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call
				.setOperationName(new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"VoidPartial"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					merchantId, order, amount });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorVoidReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorVoidReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorVoidReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthResponse oneDollarAuth(
			br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthRequest pagadorOneDollarAuthRequest)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[9]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/OneDollarAuth");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"OneDollarAuth"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call
					.invoke(new java.lang.Object[] { pagadorOneDollarAuthRequest });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthResponse) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthResponse) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorOneDollarAuthResponse.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorReturnWithService authorizeExistingAvsStatusWithService(
			java.lang.String transId, java.lang.String holder,
			java.lang.String cardNumber, java.lang.String expiration,
			java.lang.String securityCode, java.lang.String numberPayments,
			java.lang.String typePayment, java.lang.String cpf,
			java.lang.String address, java.lang.String addressNumber,
			java.lang.String addressComplement, java.lang.String zipCode1,
			java.lang.String zipCode2, java.lang.String city,
			java.lang.String state, java.lang.String country,
			java.lang.String avsStatus, boolean avs,
			java.lang.String serviceAmount) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[10]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/AuthorizeExistingAvsStatusWithService");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizeExistingAvsStatusWithService"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					transId, holder, cardNumber, expiration, securityCode,
					numberPayments, typePayment, cpf, address, addressNumber,
					addressComplement, zipCode1, zipCode2, city, state,
					country, avsStatus, new java.lang.Boolean(avs),
					serviceAmount });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorReturnWithService) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorReturnWithService) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorReturnWithService.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorReturn capture(
			java.lang.String merchantId, java.lang.String orderId)
			throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[11]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/Capture");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Capture"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					merchantId, orderId });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

	public br.com.pagador.www.webservice.pagador.PagadorReturn capturePartial(
			java.lang.String merchantId, java.lang.String orderId,
			java.lang.String captureAmount) throws java.rmi.RemoteException {
		if (super.cachedEndpoint == null) {
			throw new org.apache.axis.NoEndPointException();
		}
		org.apache.axis.client.Call _call = createCall();
		_call.setOperation(_operations[12]);
		_call.setUseSOAPAction(true);
		_call
				.setSOAPActionURI("https://www.pagador.com.br/webservice/pagador/CapturePartial");
		_call.setEncodingStyle(null);
		_call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR,
				Boolean.FALSE);
		_call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS,
				Boolean.FALSE);
		_call
				.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
		_call.setOperationName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CapturePartial"));

		setRequestHeaders(_call);
		setAttachments(_call);
		try {
			java.lang.Object _resp = _call.invoke(new java.lang.Object[] {
					merchantId, orderId, captureAmount });

			if (_resp instanceof java.rmi.RemoteException) {
				throw (java.rmi.RemoteException) _resp;
			} else {
				extractAttachments(_call);
				try {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) _resp;
				} catch (java.lang.Exception _exception) {
					return (br.com.pagador.www.webservice.pagador.PagadorReturn) org.apache.axis.utils.JavaUtils
							.convert(
									_resp,
									br.com.pagador.www.webservice.pagador.PagadorReturn.class);
				}
			}
		} catch (org.apache.axis.AxisFault axisFaultException) {
			throw axisFaultException;
		}
	}

}
