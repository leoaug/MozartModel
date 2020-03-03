/**
 * AuthorizeWithDateFirstInstallmentRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

@SuppressWarnings("unchecked")
public class AuthorizeWithDateFirstInstallmentRequest  implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String merchantId;

    private java.lang.String orderId;

    private java.lang.String customerName;

    private java.lang.String amount;

    private int paymentMethod;

    private java.lang.String holder;

    private java.lang.String cardNumber;

    private java.lang.String expiration;

    private int securityCode;

    private int numberPayments;

    private int typePayment;

    private java.util.Calendar dateFirstInstallment;

    public AuthorizeWithDateFirstInstallmentRequest() {
    }

    public AuthorizeWithDateFirstInstallmentRequest(
           java.lang.String merchantId,
           java.lang.String orderId,
           java.lang.String customerName,
           java.lang.String amount,
           int paymentMethod,
           java.lang.String holder,
           java.lang.String cardNumber,
           java.lang.String expiration,
           int securityCode,
           int numberPayments,
           int typePayment,
           java.util.Calendar dateFirstInstallment) {
           this.merchantId = merchantId;
           this.orderId = orderId;
           this.customerName = customerName;
           this.amount = amount;
           this.paymentMethod = paymentMethod;
           this.holder = holder;
           this.cardNumber = cardNumber;
           this.expiration = expiration;
           this.securityCode = securityCode;
           this.numberPayments = numberPayments;
           this.typePayment = typePayment;
           this.dateFirstInstallment = dateFirstInstallment;
    }


    /**
     * Gets the merchantId value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return merchantId
     */
    public java.lang.String getMerchantId() {
        return merchantId;
    }


    /**
     * Sets the merchantId value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param merchantId
     */
    public void setMerchantId(java.lang.String merchantId) {
        this.merchantId = merchantId;
    }


    /**
     * Gets the orderId value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return orderId
     */
    public java.lang.String getOrderId() {
        return orderId;
    }


    /**
     * Sets the orderId value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param orderId
     */
    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }


    /**
     * Gets the customerName value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return customerName
     */
    public java.lang.String getCustomerName() {
        return customerName;
    }


    /**
     * Sets the customerName value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param customerName
     */
    public void setCustomerName(java.lang.String customerName) {
        this.customerName = customerName;
    }


    /**
     * Gets the amount value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return amount
     */
    public java.lang.String getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param amount
     */
    public void setAmount(java.lang.String amount) {
        this.amount = amount;
    }


    /**
     * Gets the paymentMethod value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return paymentMethod
     */
    public int getPaymentMethod() {
        return paymentMethod;
    }


    /**
     * Sets the paymentMethod value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param paymentMethod
     */
    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    /**
     * Gets the holder value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return holder
     */
    public java.lang.String getHolder() {
        return holder;
    }


    /**
     * Sets the holder value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param holder
     */
    public void setHolder(java.lang.String holder) {
        this.holder = holder;
    }


    /**
     * Gets the cardNumber value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return cardNumber
     */
    public java.lang.String getCardNumber() {
        return cardNumber;
    }


    /**
     * Sets the cardNumber value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param cardNumber
     */
    public void setCardNumber(java.lang.String cardNumber) {
        this.cardNumber = cardNumber;
    }


    /**
     * Gets the expiration value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return expiration
     */
    public java.lang.String getExpiration() {
        return expiration;
    }


    /**
     * Sets the expiration value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param expiration
     */
    public void setExpiration(java.lang.String expiration) {
        this.expiration = expiration;
    }


    /**
     * Gets the securityCode value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return securityCode
     */
    public int getSecurityCode() {
        return securityCode;
    }


    /**
     * Sets the securityCode value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param securityCode
     */
    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }


    /**
     * Gets the numberPayments value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return numberPayments
     */
    public int getNumberPayments() {
        return numberPayments;
    }


    /**
     * Sets the numberPayments value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param numberPayments
     */
    public void setNumberPayments(int numberPayments) {
        this.numberPayments = numberPayments;
    }


    /**
     * Gets the typePayment value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return typePayment
     */
    public int getTypePayment() {
        return typePayment;
    }


    /**
     * Sets the typePayment value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param typePayment
     */
    public void setTypePayment(int typePayment) {
        this.typePayment = typePayment;
    }


    /**
     * Gets the dateFirstInstallment value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @return dateFirstInstallment
     */
    public java.util.Calendar getDateFirstInstallment() {
        return dateFirstInstallment;
    }


    /**
     * Sets the dateFirstInstallment value for this AuthorizeWithDateFirstInstallmentRequest.
     * 
     * @param dateFirstInstallment
     */
    public void setDateFirstInstallment(java.util.Calendar dateFirstInstallment) {
        this.dateFirstInstallment = dateFirstInstallment;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AuthorizeWithDateFirstInstallmentRequest)) return false;
        AuthorizeWithDateFirstInstallmentRequest other = (AuthorizeWithDateFirstInstallmentRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.merchantId==null && other.getMerchantId()==null) || 
             (this.merchantId!=null &&
              this.merchantId.equals(other.getMerchantId()))) &&
            ((this.orderId==null && other.getOrderId()==null) || 
             (this.orderId!=null &&
              this.orderId.equals(other.getOrderId()))) &&
            ((this.customerName==null && other.getCustomerName()==null) || 
             (this.customerName!=null &&
              this.customerName.equals(other.getCustomerName()))) &&
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            this.paymentMethod == other.getPaymentMethod() &&
            ((this.holder==null && other.getHolder()==null) || 
             (this.holder!=null &&
              this.holder.equals(other.getHolder()))) &&
            this.cardNumber == other.getCardNumber() &&
            ((this.expiration==null && other.getExpiration()==null) || 
             (this.expiration!=null &&
              this.expiration.equals(other.getExpiration()))) &&
            this.securityCode == other.getSecurityCode() &&
            this.numberPayments == other.getNumberPayments() &&
            this.typePayment == other.getTypePayment() &&
            ((this.dateFirstInstallment==null && other.getDateFirstInstallment()==null) || 
             (this.dateFirstInstallment!=null &&
              this.dateFirstInstallment.equals(other.getDateFirstInstallment())));
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
        if (getCustomerName() != null) {
            _hashCode += getCustomerName().hashCode();
        }
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        _hashCode += getPaymentMethod();
        if (getHolder() != null) {
            _hashCode += getHolder().hashCode();
        }
        _hashCode += new Long(getCardNumber()).hashCode();
        if (getExpiration() != null) {
            _hashCode += getExpiration().hashCode();
        }
        _hashCode += getSecurityCode();
        _hashCode += getNumberPayments();
        _hashCode += getTypePayment();
        if (getDateFirstInstallment() != null) {
            _hashCode += getDateFirstInstallment().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AuthorizeWithDateFirstInstallmentRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "AuthorizeWithDateFirstInstallmentRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("merchantId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "MerchantId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orderId");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "OrderId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("customerName");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "CustomerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "Amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "PaymentMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("holder");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "Holder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "CardNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expiration");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "Expiration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityCode");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "SecurityCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberPayments");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "NumberPayments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typePayment");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "TypePayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateFirstInstallment");
        elemField.setXmlName(new javax.xml.namespace.QName("https://www.pagador.com.br/webservice/pagador", "DateFirstInstallment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
