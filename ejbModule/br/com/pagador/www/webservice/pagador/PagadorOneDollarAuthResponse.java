/**
 * PagadorOneDollarAuthResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

@SuppressWarnings("unchecked")
public class PagadorOneDollarAuthResponse implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.Integer amount;

	private java.lang.String authorizationNumber;

	private java.lang.String message;

	private java.lang.String returnCode;

	private org.apache.axis.types.UnsignedByte status;

	private java.lang.String transactionId;

	private java.lang.String avsMessage;

	private java.lang.String avsReturnCode;

	private org.apache.axis.types.UnsignedByte avsStatus;

	private java.lang.Integer cancelAmount;

	private java.lang.String cancelOrderId;

	private java.lang.String cancelMessage;

	private java.lang.String cancelReturnCode;

	private org.apache.axis.types.UnsignedByte cancelStatus;

	private java.lang.String cancelTransactionId;

	public PagadorOneDollarAuthResponse() {
	}

	public PagadorOneDollarAuthResponse(java.lang.Integer amount,
			java.lang.String authorizationNumber, java.lang.String message,
			java.lang.String returnCode,
			org.apache.axis.types.UnsignedByte status,
			java.lang.String transactionId, java.lang.String avsMessage,
			java.lang.String avsReturnCode,
			org.apache.axis.types.UnsignedByte avsStatus,
			java.lang.Integer cancelAmount, java.lang.String cancelOrderId,
			java.lang.String cancelMessage, java.lang.String cancelReturnCode,
			org.apache.axis.types.UnsignedByte cancelStatus,
			java.lang.String cancelTransactionId) {
		this.amount = amount;
		this.authorizationNumber = authorizationNumber;
		this.message = message;
		this.returnCode = returnCode;
		this.status = status;
		this.transactionId = transactionId;
		this.avsMessage = avsMessage;
		this.avsReturnCode = avsReturnCode;
		this.avsStatus = avsStatus;
		this.cancelAmount = cancelAmount;
		this.cancelOrderId = cancelOrderId;
		this.cancelMessage = cancelMessage;
		this.cancelReturnCode = cancelReturnCode;
		this.cancelStatus = cancelStatus;
		this.cancelTransactionId = cancelTransactionId;
	}

	/**
	 * Gets the amount value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return amount
	 */
	public java.lang.Integer getAmount() {
		return amount;
	}

	/**
	 * Sets the amount value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param amount
	 */
	public void setAmount(java.lang.Integer amount) {
		this.amount = amount;
	}

	/**
	 * Gets the authorizationNumber value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return authorizationNumber
	 */
	public java.lang.String getAuthorizationNumber() {
		return authorizationNumber;
	}

	/**
	 * Sets the authorizationNumber value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param authorizationNumber
	 */
	public void setAuthorizationNumber(java.lang.String authorizationNumber) {
		this.authorizationNumber = authorizationNumber;
	}

	/**
	 * Gets the message value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return message
	 */
	public java.lang.String getMessage() {
		return message;
	}

	/**
	 * Sets the message value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param message
	 */
	public void setMessage(java.lang.String message) {
		this.message = message;
	}

	/**
	 * Gets the returnCode value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return returnCode
	 */
	public java.lang.String getReturnCode() {
		return returnCode;
	}

	/**
	 * Sets the returnCode value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param returnCode
	 */
	public void setReturnCode(java.lang.String returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * Gets the status value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return status
	 */
	public org.apache.axis.types.UnsignedByte getStatus() {
		return status;
	}

	/**
	 * Sets the status value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param status
	 */
	public void setStatus(org.apache.axis.types.UnsignedByte status) {
		this.status = status;
	}

	/**
	 * Gets the transactionId value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return transactionId
	 */
	public java.lang.String getTransactionId() {
		return transactionId;
	}

	/**
	 * Sets the transactionId value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(java.lang.String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * Gets the avsMessage value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return avsMessage
	 */
	public java.lang.String getAvsMessage() {
		return avsMessage;
	}

	/**
	 * Sets the avsMessage value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param avsMessage
	 */
	public void setAvsMessage(java.lang.String avsMessage) {
		this.avsMessage = avsMessage;
	}

	/**
	 * Gets the avsReturnCode value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return avsReturnCode
	 */
	public java.lang.String getAvsReturnCode() {
		return avsReturnCode;
	}

	/**
	 * Sets the avsReturnCode value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param avsReturnCode
	 */
	public void setAvsReturnCode(java.lang.String avsReturnCode) {
		this.avsReturnCode = avsReturnCode;
	}

	/**
	 * Gets the avsStatus value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return avsStatus
	 */
	public org.apache.axis.types.UnsignedByte getAvsStatus() {
		return avsStatus;
	}

	/**
	 * Sets the avsStatus value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param avsStatus
	 */
	public void setAvsStatus(org.apache.axis.types.UnsignedByte avsStatus) {
		this.avsStatus = avsStatus;
	}

	/**
	 * Gets the cancelAmount value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return cancelAmount
	 */
	public java.lang.Integer getCancelAmount() {
		return cancelAmount;
	}

	/**
	 * Sets the cancelAmount value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param cancelAmount
	 */
	public void setCancelAmount(java.lang.Integer cancelAmount) {
		this.cancelAmount = cancelAmount;
	}

	/**
	 * Gets the cancelOrderId value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return cancelOrderId
	 */
	public java.lang.String getCancelOrderId() {
		return cancelOrderId;
	}

	/**
	 * Sets the cancelOrderId value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param cancelOrderId
	 */
	public void setCancelOrderId(java.lang.String cancelOrderId) {
		this.cancelOrderId = cancelOrderId;
	}

	/**
	 * Gets the cancelMessage value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return cancelMessage
	 */
	public java.lang.String getCancelMessage() {
		return cancelMessage;
	}

	/**
	 * Sets the cancelMessage value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param cancelMessage
	 */
	public void setCancelMessage(java.lang.String cancelMessage) {
		this.cancelMessage = cancelMessage;
	}

	/**
	 * Gets the cancelReturnCode value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return cancelReturnCode
	 */
	public java.lang.String getCancelReturnCode() {
		return cancelReturnCode;
	}

	/**
	 * Sets the cancelReturnCode value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param cancelReturnCode
	 */
	public void setCancelReturnCode(java.lang.String cancelReturnCode) {
		this.cancelReturnCode = cancelReturnCode;
	}

	/**
	 * Gets the cancelStatus value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return cancelStatus
	 */
	public org.apache.axis.types.UnsignedByte getCancelStatus() {
		return cancelStatus;
	}

	/**
	 * Sets the cancelStatus value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param cancelStatus
	 */
	public void setCancelStatus(org.apache.axis.types.UnsignedByte cancelStatus) {
		this.cancelStatus = cancelStatus;
	}

	/**
	 * Gets the cancelTransactionId value for this PagadorOneDollarAuthResponse.
	 * 
	 * @return cancelTransactionId
	 */
	public java.lang.String getCancelTransactionId() {
		return cancelTransactionId;
	}

	/**
	 * Sets the cancelTransactionId value for this PagadorOneDollarAuthResponse.
	 * 
	 * @param cancelTransactionId
	 */
	public void setCancelTransactionId(java.lang.String cancelTransactionId) {
		this.cancelTransactionId = cancelTransactionId;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof PagadorOneDollarAuthResponse))
			return false;
		PagadorOneDollarAuthResponse other = (PagadorOneDollarAuthResponse) obj;
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
				&& ((this.amount == null && other.getAmount() == null) || (this.amount != null && this.amount
						.equals(other.getAmount())))
				&& ((this.authorizationNumber == null && other
						.getAuthorizationNumber() == null) || (this.authorizationNumber != null && this.authorizationNumber
						.equals(other.getAuthorizationNumber())))
				&& ((this.message == null && other.getMessage() == null) || (this.message != null && this.message
						.equals(other.getMessage())))
				&& ((this.returnCode == null && other.getReturnCode() == null) || (this.returnCode != null && this.returnCode
						.equals(other.getReturnCode())))
				&& ((this.status == null && other.getStatus() == null) || (this.status != null && this.status
						.equals(other.getStatus())))
				&& ((this.transactionId == null && other.getTransactionId() == null) || (this.transactionId != null && this.transactionId
						.equals(other.getTransactionId())))
				&& ((this.avsMessage == null && other.getAvsMessage() == null) || (this.avsMessage != null && this.avsMessage
						.equals(other.getAvsMessage())))
				&& ((this.avsReturnCode == null && other.getAvsReturnCode() == null) || (this.avsReturnCode != null && this.avsReturnCode
						.equals(other.getAvsReturnCode())))
				&& ((this.avsStatus == null && other.getAvsStatus() == null) || (this.avsStatus != null && this.avsStatus
						.equals(other.getAvsStatus())))
				&& ((this.cancelAmount == null && other.getCancelAmount() == null) || (this.cancelAmount != null && this.cancelAmount
						.equals(other.getCancelAmount())))
				&& ((this.cancelOrderId == null && other.getCancelOrderId() == null) || (this.cancelOrderId != null && this.cancelOrderId
						.equals(other.getCancelOrderId())))
				&& ((this.cancelMessage == null && other.getCancelMessage() == null) || (this.cancelMessage != null && this.cancelMessage
						.equals(other.getCancelMessage())))
				&& ((this.cancelReturnCode == null && other
						.getCancelReturnCode() == null) || (this.cancelReturnCode != null && this.cancelReturnCode
						.equals(other.getCancelReturnCode())))
				&& ((this.cancelStatus == null && other.getCancelStatus() == null) || (this.cancelStatus != null && this.cancelStatus
						.equals(other.getCancelStatus())))
				&& ((this.cancelTransactionId == null && other
						.getCancelTransactionId() == null) || (this.cancelTransactionId != null && this.cancelTransactionId
						.equals(other.getCancelTransactionId())));
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
		if (getAmount() != null) {
			_hashCode += getAmount().hashCode();
		}
		if (getAuthorizationNumber() != null) {
			_hashCode += getAuthorizationNumber().hashCode();
		}
		if (getMessage() != null) {
			_hashCode += getMessage().hashCode();
		}
		if (getReturnCode() != null) {
			_hashCode += getReturnCode().hashCode();
		}
		if (getStatus() != null) {
			_hashCode += getStatus().hashCode();
		}
		if (getTransactionId() != null) {
			_hashCode += getTransactionId().hashCode();
		}
		if (getAvsMessage() != null) {
			_hashCode += getAvsMessage().hashCode();
		}
		if (getAvsReturnCode() != null) {
			_hashCode += getAvsReturnCode().hashCode();
		}
		if (getAvsStatus() != null) {
			_hashCode += getAvsStatus().hashCode();
		}
		if (getCancelAmount() != null) {
			_hashCode += getCancelAmount().hashCode();
		}
		if (getCancelOrderId() != null) {
			_hashCode += getCancelOrderId().hashCode();
		}
		if (getCancelMessage() != null) {
			_hashCode += getCancelMessage().hashCode();
		}
		if (getCancelReturnCode() != null) {
			_hashCode += getCancelReturnCode().hashCode();
		}
		if (getCancelStatus() != null) {
			_hashCode += getCancelStatus().hashCode();
		}
		if (getCancelTransactionId() != null) {
			_hashCode += getCancelTransactionId().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			PagadorOneDollarAuthResponse.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorOneDollarAuthResponse"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("amount");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Amount"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("authorizationNumber");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AuthorizationNumber"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("message");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Message"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("returnCode");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "ReturnCode"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("status");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Status"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "unsignedByte"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("transactionId");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"TransactionId"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("avsMessage");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "AvsMessage"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("avsReturnCode");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AvsReturnCode"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("avsStatus");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "AvsStatus"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "unsignedByte"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cancelAmount");
		elemField
				.setXmlName(new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"CancelAmount"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cancelOrderId");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CancelOrderId"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cancelMessage");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CancelMessage"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cancelReturnCode");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CancelReturnCode"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cancelStatus");
		elemField
				.setXmlName(new javax.xml.namespace.QName(
						"https://www.pagador.com.br/webservice/pagador",
						"CancelStatus"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "unsignedByte"));
		elemField.setNillable(true);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cancelTransactionId");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CancelTransactionId"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
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
