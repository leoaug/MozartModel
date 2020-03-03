/**
 * PagadorReturnWithService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

@SuppressWarnings("unchecked")
public class PagadorReturnWithService implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private br.com.pagador.www.webservice.pagador.PagadorReturn mainReturn;

	private br.com.pagador.www.webservice.pagador.PagadorReturn serviceReturn;

	public PagadorReturnWithService() {
	}

	public PagadorReturnWithService(
			br.com.pagador.www.webservice.pagador.PagadorReturn mainReturn,
			br.com.pagador.www.webservice.pagador.PagadorReturn serviceReturn) {
		this.mainReturn = mainReturn;
		this.serviceReturn = serviceReturn;
	}

	/**
	 * Gets the mainReturn value for this PagadorReturnWithService.
	 * 
	 * @return mainReturn
	 */
	public br.com.pagador.www.webservice.pagador.PagadorReturn getMainReturn() {
		return mainReturn;
	}

	/**
	 * Sets the mainReturn value for this PagadorReturnWithService.
	 * 
	 * @param mainReturn
	 */
	public void setMainReturn(
			br.com.pagador.www.webservice.pagador.PagadorReturn mainReturn) {
		this.mainReturn = mainReturn;
	}

	/**
	 * Gets the serviceReturn value for this PagadorReturnWithService.
	 * 
	 * @return serviceReturn
	 */
	public br.com.pagador.www.webservice.pagador.PagadorReturn getServiceReturn() {
		return serviceReturn;
	}

	/**
	 * Sets the serviceReturn value for this PagadorReturnWithService.
	 * 
	 * @param serviceReturn
	 */
	public void setServiceReturn(
			br.com.pagador.www.webservice.pagador.PagadorReturn serviceReturn) {
		this.serviceReturn = serviceReturn;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof PagadorReturnWithService))
			return false;
		PagadorReturnWithService other = (PagadorReturnWithService) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true
				&& ((this.mainReturn == null && other.getMainReturn() == null) || (this.mainReturn != null && this.mainReturn
						.equals(other.getMainReturn())))
				&& ((this.serviceReturn == null && other.getServiceReturn() == null) || (this.serviceReturn != null && this.serviceReturn
						.equals(other.getServiceReturn())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getMainReturn() != null) {
			_hashCode += getMainReturn().hashCode();
		}
		if (getServiceReturn() != null) {
			_hashCode += getServiceReturn().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			PagadorReturnWithService.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturnWithService"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("mainReturn");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "MainReturn"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("serviceReturn");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"ServiceReturn"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorReturn"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType,
				_xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(
			java.lang.String mechType, java.lang.Class _javaType,
			javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType,
				_xmlType, typeDesc);
	}

}
