/**
 * PagadorAvsReturn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

@SuppressWarnings("unchecked")
public class PagadorAvsReturn extends
		br.com.pagador.www.webservice.pagador.PagadorReturn implements
		java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String avsReturnCode;

	private java.lang.String avsMessage;

	private org.apache.axis.types.UnsignedByte avsStatus;

	public PagadorAvsReturn() {
	}

	public PagadorAvsReturn(java.math.BigDecimal amount,
			java.lang.String authorisationNumber, java.lang.String message,
			java.lang.String returnCode,
			org.apache.axis.types.UnsignedByte status,
			java.lang.String transactionId, java.lang.String avsReturnCode,
			java.lang.String avsMessage,
			org.apache.axis.types.UnsignedByte avsStatus) {
		super(amount, authorisationNumber, message, returnCode, status,
				transactionId);
		this.avsReturnCode = avsReturnCode;
		this.avsMessage = avsMessage;
		this.avsStatus = avsStatus;
	}

	/**
	 * Gets the avsReturnCode value for this PagadorAvsReturn.
	 * 
	 * @return avsReturnCode
	 */
	public java.lang.String getAvsReturnCode() {
		return avsReturnCode;
	}

	/**
	 * Sets the avsReturnCode value for this PagadorAvsReturn.
	 * 
	 * @param avsReturnCode
	 */
	public void setAvsReturnCode(java.lang.String avsReturnCode) {
		this.avsReturnCode = avsReturnCode;
	}

	/**
	 * Gets the avsMessage value for this PagadorAvsReturn.
	 * 
	 * @return avsMessage
	 */
	public java.lang.String getAvsMessage() {
		return avsMessage;
	}

	/**
	 * Sets the avsMessage value for this PagadorAvsReturn.
	 * 
	 * @param avsMessage
	 */
	public void setAvsMessage(java.lang.String avsMessage) {
		this.avsMessage = avsMessage;
	}

	/**
	 * Gets the avsStatus value for this PagadorAvsReturn.
	 * 
	 * @return avsStatus
	 */
	public org.apache.axis.types.UnsignedByte getAvsStatus() {
		return avsStatus;
	}

	/**
	 * Sets the avsStatus value for this PagadorAvsReturn.
	 * 
	 * @param avsStatus
	 */
	public void setAvsStatus(org.apache.axis.types.UnsignedByte avsStatus) {
		this.avsStatus = avsStatus;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof PagadorAvsReturn))
			return false;
		PagadorAvsReturn other = (PagadorAvsReturn) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = super.equals(obj)
				&& ((this.avsReturnCode == null && other.getAvsReturnCode() == null) || (this.avsReturnCode != null && this.avsReturnCode
						.equals(other.getAvsReturnCode())))
				&& ((this.avsMessage == null && other.getAvsMessage() == null) || (this.avsMessage != null && this.avsMessage
						.equals(other.getAvsMessage())))
				&& ((this.avsStatus == null && other.getAvsStatus() == null) || (this.avsStatus != null && this.avsStatus
						.equals(other.getAvsStatus())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = super.hashCode();
		if (getAvsReturnCode() != null) {
			_hashCode += getAvsReturnCode().hashCode();
		}
		if (getAvsMessage() != null) {
			_hashCode += getAvsMessage().hashCode();
		}
		if (getAvsStatus() != null) {
			_hashCode += getAvsStatus().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			PagadorAvsReturn.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorAvsReturn"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("avsReturnCode");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"avsReturnCode"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("avsMessage");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "avsMessage"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("avsStatus");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "avsStatus"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "unsignedByte"));
		elemField.setNillable(true);
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
