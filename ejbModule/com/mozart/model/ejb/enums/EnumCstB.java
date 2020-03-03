package com.mozart.model.ejb.enums;

import java.util.HashMap;


public enum EnumCstB {
	B_00("00","Tributada integralmente"), 
	B_10("10","Tributada e com cobran�a do ICMS por substitui��o tribut�ria"), 
	B_20("20","Com redu��o de base de c�lculo"),
	B_30("30","Isenta ou n�o tributada e com cobran�a do ICMS por substitui��o tribut�ria"),
	B_40("40","Isenta"),
	B_41("41","N�o tributada"),
	B_50("50","Suspens�o"),
	B_51("51","Diferimento"),
	B_60("60","ICMS cobrado anteriormente por substitui��o tribut�ria"),
	B_70("70","Com redu��o de base de c�lculo e cobran�a do ICMS por substitui��o tribut�ria"),
	B_90("90","Outras");

	private EnumCstB(String cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	private static HashMap<String, EnumCstB> valores  = new HashMap<String, EnumCstB>();
	static{
		for(EnumCstB b: values()){
			valores.put(b.cod, b);
		}
	}
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public EnumCstB fromValue(String value){
		return valores.get(value);
	}
	
	public String value(){
		return this.cod;
	}
	
	private    String cod;
	private    String descricao;
}
