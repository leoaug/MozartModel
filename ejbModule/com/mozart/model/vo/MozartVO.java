package com.mozart.model.vo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.mozart.model.ejb.entity.UsuarioEJB;

public class MozartVO implements Serializable {
    
	private static final long serialVersionUID = -4188442396887870896L;
	
    private static final Integer LONG  = 1;
    private static final Integer DATA = 2;
    private static final Integer STRING = 3;
    private static final Integer DOUBLE = 4;
    private static final Integer TIMESTAMP = 5;
    private static final Integer BIGDECIMAL = 6;
    private static final Integer BYTES = 7;
	
    protected UsuarioEJB usuario;
    private Long idRedeHotel;
    private Long[] idHoteis;
    protected String sigla;
    
    // Montagem dinamica de objetos a partir de ResultSets
    private int __ix;    
    private Object[] __valoresEJB; 
    
    public MozartVO() {
    }
    public MozartVO(Object[] linha) {
    	this.setLinha(linha);
    }
    
    public void setIdRedeHotel(Long idRedeHotel) {
        this.idRedeHotel = idRedeHotel;
    }
    public Long getIdRedeHotel() {
        return idRedeHotel;
    }
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public UsuarioEJB getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEJB usuario) {
		this.usuario = usuario;
	}
	
	public Long[] getIdHoteis() {
		return idHoteis;
	}
	
	public void setIdHoteis(Long[] idHoteis) {
		this.idHoteis = idHoteis;
	}
	
	public String getIdHoteisSQL() {
	    String hoteis = ";";
	    for (Long id: getIdHoteis()){
	        hoteis += id+";";
	    }
	    return hoteis;
	}    
	
	public String getIdHoteisSQLOr(Object[] idHoteis, String prefixoColuna) {
		if (idHoteis == null)
			idHoteis = this.idHoteis;
	    String hoteis = "(";
	    for (int x=0;x<idHoteis.length;x++){
	        hoteis += prefixoColuna+"id_hotel = "+idHoteis[x];
	        if (x < idHoteis.length-1){
	        	hoteis += " or ";
	        }        
	    }
	    return hoteis+") ";
	}    
	
	public String getString(){
        return (String) getValorCampo( STRING);
    }
    public Double getDouble(){
        return (Double) getValorCampo( DOUBLE );
    }
    public Long getLong(){
        return (Long) getValorCampo( LONG );
    }
    public BigDecimal getBigDecimal(){
    	return (BigDecimal) getValorCampo( BIGDECIMAL );
    }
    public Date getDate(){
        return (Date) getValorCampo( DATA );
    }
    public Timestamp getTimestamp(){
        return (Timestamp) getValorCampo( TIMESTAMP );
    }
    public byte[] getBytes(){
        return (byte[]) getValorCampo( BYTES );
    }
    
    protected void setLinha(Object[] v) {
        __ix = 0;
        __valoresEJB = null;
        if (v!=null)
            __valoresEJB = v;
    }
    
    private Object getValorCampo(Integer tipoObj) {        
        Object campo = null;
        if (__valoresEJB!=null && __valoresEJB[__ix]!=null) {            
            if (tipoObj.equals(DOUBLE) ) 
                campo = new Double ( ((BigDecimal)__valoresEJB[__ix]).doubleValue() );
            else if (tipoObj.equals(LONG) ) 
                campo = new Long( ((BigDecimal)__valoresEJB[__ix]).longValue() );                                                                                         
            else if (tipoObj.equals(BIGDECIMAL) ) 
            	campo =  ((BigDecimal)__valoresEJB[__ix]) ;                                                                                         
            else if (tipoObj.equals(DATA) )             
                campo = new Date ( ((Timestamp)__valoresEJB[__ix]).getTime() );            
            else if (tipoObj.equals(STRING))
                campo = (String)__valoresEJB[__ix].toString();
            else if (tipoObj.equals(TIMESTAMP))
                campo = (Timestamp)__valoresEJB[__ix];
            else if (tipoObj.equals(BYTES))
                campo = (byte[])__valoresEJB[__ix];
        }
        __ix++;
        return campo;
    }
	
	public Object clone(Object obj) {
        FileOutputStream serializadoSaida;
        FileInputStream serializadoEntrada;
        ObjectOutputStream serializador;
        ObjectInputStream deserializador;
        Object objRetorno = null;
        try {
            serializadoSaida = new FileOutputStream("/opt/wildfly/standalone/tmp/objSer");
            serializador = new ObjectOutputStream(serializadoSaida);            
            serializador.writeObject(obj);
            serializador.close();
            serializadoEntrada = new FileInputStream("/opt/wildfly/standalone/tmp/objSer");
            deserializador = new ObjectInputStream(serializadoEntrada);
            objRetorno = deserializador.readObject();            
            deserializador.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return objRetorno;
    }
}