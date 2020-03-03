/**
 * PagadorLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

@SuppressWarnings("unchecked")
public class PagadorLocator extends org.apache.axis.client.Service implements
		br.com.pagador.www.webservice.pagador.Pagador {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This webservice authorizes PAGADOR orders
	 */

	public PagadorLocator() {
	}

	public PagadorLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public PagadorLocator(java.lang.String wsdlLoc,
			javax.xml.namespace.QName sName)
			throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for PagadorSoap12

	// private java.lang.String PagadorSoap12_address =
	// "https://homologacao.pagador.com.br/webservices/pagador/Pagador.asmx";
	private java.lang.String PagadorSoap12_address = "https://www.pagador.com.br/webservices/pagador/Pagador.asmx";

	public java.lang.String getPagadorSoap12Address() {
		return PagadorSoap12_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String PagadorSoap12WSDDServiceName = "PagadorSoap12";

	public java.lang.String getPagadorSoap12WSDDServiceName() {
		return PagadorSoap12WSDDServiceName;
	}

	public void setPagadorSoap12WSDDServiceName(java.lang.String name) {
		PagadorSoap12WSDDServiceName = name;
	}

	public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap12()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(PagadorSoap12_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getPagadorSoap12(endpoint);
	}

	public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap12(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			br.com.pagador.www.webservice.pagador.PagadorSoap12Stub _stub = new br.com.pagador.www.webservice.pagador.PagadorSoap12Stub(
					portAddress, this);
			_stub.setPortName(getPagadorSoap12WSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setPagadorSoap12EndpointAddress(java.lang.String address) {
		PagadorSoap12_address = address;
	}

	// Use to get a proxy class for PagadorSoap
	// private java.lang.String PagadorSoap_address =
	// "https://homologacao.pagador.com.br/webservices/pagador/Pagador.asmx";
	private java.lang.String PagadorSoap_address = "https://www.pagador.com.br/webservices/pagador/Pagador.asmx";

	public java.lang.String getPagadorSoapAddress() {
		return PagadorSoap_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String PagadorSoapWSDDServiceName = "PagadorSoap";

	public java.lang.String getPagadorSoapWSDDServiceName() {
		return PagadorSoapWSDDServiceName;
	}

	public void setPagadorSoapWSDDServiceName(java.lang.String name) {
		PagadorSoapWSDDServiceName = name;
	}

	public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap()
			throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(PagadorSoap_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getPagadorSoap(endpoint);
	}

	public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap(
			java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			br.com.pagador.www.webservice.pagador.PagadorSoapStub _stub = new br.com.pagador.www.webservice.pagador.PagadorSoapStub(
					portAddress, this);
			_stub.setPortName(getPagadorSoapWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setPagadorSoapEndpointAddress(java.lang.String address) {
		PagadorSoap_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown. This
	 * service has multiple ports for a given interface; the proxy
	 * implementation returned may be indeterminate.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		try {
			if (br.com.pagador.www.webservice.pagador.PagadorSoap.class
					.isAssignableFrom(serviceEndpointInterface)) {
				br.com.pagador.www.webservice.pagador.PagadorSoap12Stub _stub = new br.com.pagador.www.webservice.pagador.PagadorSoap12Stub(
						new java.net.URL(PagadorSoap12_address), this);
				_stub.setPortName(getPagadorSoap12WSDDServiceName());
				return _stub;
			}
			if (br.com.pagador.www.webservice.pagador.PagadorSoap.class
					.isAssignableFrom(serviceEndpointInterface)) {
				br.com.pagador.www.webservice.pagador.PagadorSoapStub _stub = new br.com.pagador.www.webservice.pagador.PagadorSoapStub(
						new java.net.URL(PagadorSoap_address), this);
				_stub.setPortName(getPagadorSoapWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException(
				"There is no stub implementation for the interface:  "
						+ (serviceEndpointInterface == null ? "null"
								: serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName,
			Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("PagadorSoap12".equals(inputPortName)) {
			return getPagadorSoap12();
		} else if ("PagadorSoap".equals(inputPortName)) {
			return getPagadorSoap();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Pagador");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName(
					"https://www.pagador.com.br/webservice/pagador",
					"PagadorSoap12"));
			ports.add(new javax.xml.namespace.QName(
					"https://www.pagador.com.br/webservice/pagador",
					"PagadorSoap"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("PagadorSoap12".equals(portName)) {
			setPagadorSoap12EndpointAddress(address);
		} else if ("PagadorSoap".equals(portName)) {
			setPagadorSoapEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(
					" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName,
			java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
