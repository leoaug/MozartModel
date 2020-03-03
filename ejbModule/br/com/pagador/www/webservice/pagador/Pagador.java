/**
 * Pagador.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.pagador.www.webservice.pagador;

public interface Pagador extends javax.xml.rpc.Service {

/**
 * This webservice authorizes PAGADOR orders
 */
    public java.lang.String getPagadorSoap12Address();

    public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap12() throws javax.xml.rpc.ServiceException;

    public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getPagadorSoapAddress();

    public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap() throws javax.xml.rpc.ServiceException;

    public br.com.pagador.www.webservice.pagador.PagadorSoap getPagadorSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
