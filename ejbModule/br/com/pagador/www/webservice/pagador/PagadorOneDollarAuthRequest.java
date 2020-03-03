/**
 * PagadorOneDollarAuthRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

@SuppressWarnings("unchecked")
public class PagadorOneDollarAuthRequest implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String merchantId;

	private java.lang.String orderId;

	private int amount;

	private short paymentMethod;

	private java.lang.String cardHolder;

	private java.lang.String cardNumber;

	private java.lang.String cardExpirationDate;

	private java.lang.String cardSecurityCode;

	private boolean useAvs;

	private java.lang.String cpf;

	private java.lang.String address;

	private java.lang.String addressNumber;

	private java.lang.String addressComplement;

	private java.lang.String zipCode1;

	private java.lang.String zipCode2;

	private java.lang.String city;

	private java.lang.String state;

	private java.lang.String country;

	public PagadorOneDollarAuthRequest() {
	}

	public PagadorOneDollarAuthRequest(java.lang.String merchantId,
			java.lang.String orderId, int amount, short paymentMethod,
			java.lang.String cardHolder, java.lang.String cardNumber,
			java.lang.String cardExpirationDate,
			java.lang.String cardSecurityCode, boolean useAvs,
			java.lang.String cpf, java.lang.String address,
			java.lang.String addressNumber, java.lang.String addressComplement,
			java.lang.String zipCode1, java.lang.String zipCode2,
			java.lang.String city, java.lang.String state,
			java.lang.String country) {
		this.merchantId = merchantId;
		this.orderId = orderId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		this.cardExpirationDate = cardExpirationDate;
		this.cardSecurityCode = cardSecurityCode;
		this.useAvs = useAvs;
		this.cpf = cpf;
		this.address = address;
		this.addressNumber = addressNumber;
		this.addressComplement = addressComplement;
		this.zipCode1 = zipCode1;
		this.zipCode2 = zipCode2;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	/**
	 * Gets the merchantId value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return merchantId
	 */
	public java.lang.String getMerchantId() {
		return merchantId;
	}

	/**
	 * Sets the merchantId value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param merchantId
	 */
	public void setMerchantId(java.lang.String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * Gets the orderId value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return orderId
	 */
	public java.lang.String getOrderId() {
		return orderId;
	}

	/**
	 * Sets the orderId value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param orderId
	 */
	public void setOrderId(java.lang.String orderId) {
		this.orderId = orderId;
	}

	/**
	 * Gets the amount value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Sets the amount value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * Gets the paymentMethod value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return paymentMethod
	 */
	public short getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Sets the paymentMethod value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param paymentMethod
	 */
	public void setPaymentMethod(short paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * Gets the cardHolder value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return cardHolder
	 */
	public java.lang.String getCardHolder() {
		return cardHolder;
	}

	/**
	 * Sets the cardHolder value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param cardHolder
	 */
	public void setCardHolder(java.lang.String cardHolder) {
		this.cardHolder = cardHolder;
	}

	/**
	 * Gets the cardNumber value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return cardNumber
	 */
	public java.lang.String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Sets the cardNumber value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param cardNumber
	 */
	public void setCardNumber(java.lang.String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * Gets the cardExpirationDate value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return cardExpirationDate
	 */
	public java.lang.String getCardExpirationDate() {
		return cardExpirationDate;
	}

	/**
	 * Sets the cardExpirationDate value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param cardExpirationDate
	 */
	public void setCardExpirationDate(java.lang.String cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
	}

	/**
	 * Gets the cardSecurityCode value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return cardSecurityCode
	 */
	public java.lang.String getCardSecurityCode() {
		return cardSecurityCode;
	}

	/**
	 * Sets the cardSecurityCode value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param cardSecurityCode
	 */
	public void setCardSecurityCode(java.lang.String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

	/**
	 * Gets the useAvs value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return useAvs
	 */
	public boolean isUseAvs() {
		return useAvs;
	}

	/**
	 * Sets the useAvs value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param useAvs
	 */
	public void setUseAvs(boolean useAvs) {
		this.useAvs = useAvs;
	}

	/**
	 * Gets the cpf value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return cpf
	 */
	public java.lang.String getCpf() {
		return cpf;
	}

	/**
	 * Sets the cpf value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param cpf
	 */
	public void setCpf(java.lang.String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Gets the address value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return address
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * Sets the address value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param address
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * Gets the addressNumber value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return addressNumber
	 */
	public java.lang.String getAddressNumber() {
		return addressNumber;
	}

	/**
	 * Sets the addressNumber value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param addressNumber
	 */
	public void setAddressNumber(java.lang.String addressNumber) {
		this.addressNumber = addressNumber;
	}

	/**
	 * Gets the addressComplement value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return addressComplement
	 */
	public java.lang.String getAddressComplement() {
		return addressComplement;
	}

	/**
	 * Sets the addressComplement value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param addressComplement
	 */
	public void setAddressComplement(java.lang.String addressComplement) {
		this.addressComplement = addressComplement;
	}

	/**
	 * Gets the zipCode1 value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return zipCode1
	 */
	public java.lang.String getZipCode1() {
		return zipCode1;
	}

	/**
	 * Sets the zipCode1 value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param zipCode1
	 */
	public void setZipCode1(java.lang.String zipCode1) {
		this.zipCode1 = zipCode1;
	}

	/**
	 * Gets the zipCode2 value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return zipCode2
	 */
	public java.lang.String getZipCode2() {
		return zipCode2;
	}

	/**
	 * Sets the zipCode2 value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param zipCode2
	 */
	public void setZipCode2(java.lang.String zipCode2) {
		this.zipCode2 = zipCode2;
	}

	/**
	 * Gets the city value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return city
	 */
	public java.lang.String getCity() {
		return city;
	}

	/**
	 * Sets the city value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param city
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * Gets the state value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return state
	 */
	public java.lang.String getState() {
		return state;
	}

	/**
	 * Sets the state value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param state
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}

	/**
	 * Gets the country value for this PagadorOneDollarAuthRequest.
	 * 
	 * @return country
	 */
	public java.lang.String getCountry() {
		return country;
	}

	/**
	 * Sets the country value for this PagadorOneDollarAuthRequest.
	 * 
	 * @param country
	 */
	public void setCountry(java.lang.String country) {
		this.country = country;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof PagadorOneDollarAuthRequest))
			return false;
		PagadorOneDollarAuthRequest other = (PagadorOneDollarAuthRequest) obj;
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
				&& ((this.merchantId == null && other.getMerchantId() == null) || (this.merchantId != null && this.merchantId
						.equals(other.getMerchantId())))
				&& ((this.orderId == null && other.getOrderId() == null) || (this.orderId != null && this.orderId
						.equals(other.getOrderId())))
				&& this.amount == other.getAmount()
				&& this.paymentMethod == other.getPaymentMethod()
				&& ((this.cardHolder == null && other.getCardHolder() == null) || (this.cardHolder != null && this.cardHolder
						.equals(other.getCardHolder())))
				&& ((this.cardNumber == null && other.getCardNumber() == null) || (this.cardNumber != null && this.cardNumber
						.equals(other.getCardNumber())))
				&& ((this.cardExpirationDate == null && other
						.getCardExpirationDate() == null) || (this.cardExpirationDate != null && this.cardExpirationDate
						.equals(other.getCardExpirationDate())))
				&& ((this.cardSecurityCode == null && other
						.getCardSecurityCode() == null) || (this.cardSecurityCode != null && this.cardSecurityCode
						.equals(other.getCardSecurityCode())))
				&& this.useAvs == other.isUseAvs()
				&& ((this.cpf == null && other.getCpf() == null) || (this.cpf != null && this.cpf
						.equals(other.getCpf())))
				&& ((this.address == null && other.getAddress() == null) || (this.address != null && this.address
						.equals(other.getAddress())))
				&& ((this.addressNumber == null && other.getAddressNumber() == null) || (this.addressNumber != null && this.addressNumber
						.equals(other.getAddressNumber())))
				&& ((this.addressComplement == null && other
						.getAddressComplement() == null) || (this.addressComplement != null && this.addressComplement
						.equals(other.getAddressComplement())))
				&& ((this.zipCode1 == null && other.getZipCode1() == null) || (this.zipCode1 != null && this.zipCode1
						.equals(other.getZipCode1())))
				&& ((this.zipCode2 == null && other.getZipCode2() == null) || (this.zipCode2 != null && this.zipCode2
						.equals(other.getZipCode2())))
				&& ((this.city == null && other.getCity() == null) || (this.city != null && this.city
						.equals(other.getCity())))
				&& ((this.state == null && other.getState() == null) || (this.state != null && this.state
						.equals(other.getState())))
				&& ((this.country == null && other.getCountry() == null) || (this.country != null && this.country
						.equals(other.getCountry())));
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
		if (getMerchantId() != null) {
			_hashCode += getMerchantId().hashCode();
		}
		if (getOrderId() != null) {
			_hashCode += getOrderId().hashCode();
		}
		_hashCode += getAmount();
		_hashCode += getPaymentMethod();
		if (getCardHolder() != null) {
			_hashCode += getCardHolder().hashCode();
		}
		if (getCardNumber() != null) {
			_hashCode += getCardNumber().hashCode();
		}
		if (getCardExpirationDate() != null) {
			_hashCode += getCardExpirationDate().hashCode();
		}
		if (getCardSecurityCode() != null) {
			_hashCode += getCardSecurityCode().hashCode();
		}
		_hashCode += (isUseAvs() ? Boolean.TRUE : Boolean.FALSE).hashCode();
		if (getCpf() != null) {
			_hashCode += getCpf().hashCode();
		}
		if (getAddress() != null) {
			_hashCode += getAddress().hashCode();
		}
		if (getAddressNumber() != null) {
			_hashCode += getAddressNumber().hashCode();
		}
		if (getAddressComplement() != null) {
			_hashCode += getAddressComplement().hashCode();
		}
		if (getZipCode1() != null) {
			_hashCode += getZipCode1().hashCode();
		}
		if (getZipCode2() != null) {
			_hashCode += getZipCode2().hashCode();
		}
		if (getCity() != null) {
			_hashCode += getCity().hashCode();
		}
		if (getState() != null) {
			_hashCode += getState().hashCode();
		}
		if (getCountry() != null) {
			_hashCode += getCountry().hashCode();
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			PagadorOneDollarAuthRequest.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PagadorOneDollarAuthRequest"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("merchantId");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "MerchantId"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("orderId");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "OrderId"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("amount");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Amount"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "int"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("paymentMethod");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"PaymentMethod"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "short"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cardHolder");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "CardHolder"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cardNumber");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "CardNumber"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cardExpirationDate");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CardExpirationDate"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cardSecurityCode");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"CardSecurityCode"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("useAvs");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "UseAvs"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "boolean"));
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("cpf");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Cpf"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("address");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Address"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("addressNumber");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AddressNumber"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("addressComplement");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador",
				"AddressComplement"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("zipCode1");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "ZipCode1"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("zipCode2");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "ZipCode2"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("city");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "City"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("state");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "State"));
		elemField.setXmlType(new javax.xml.namespace.QName(
				"http://www.w3.org/2001/XMLSchema", "string"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		typeDesc.addFieldDesc(elemField);
		elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("country");
		elemField.setXmlName(new javax.xml.namespace.QName(
				"https://www.pagador.com.br/webservice/pagador", "Country"));
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
