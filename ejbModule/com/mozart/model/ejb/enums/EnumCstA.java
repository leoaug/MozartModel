package com.mozart.model.ejb.enums;

import java.util.HashMap;

public enum EnumCstA {
	A_0("0","Nacional"), 
	A_1("1","Importação Direta"), 
	A_2("2","Estrangeira Adquirida no Mercado Interno");

	
	private    String cod;
	private    String descricao;
	
	private EnumCstA(String cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	private static HashMap<String, EnumCstA> valores  = new HashMap<String, EnumCstA>();
	static{
		for(EnumCstA b: values()){
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
	
	
	public EnumCstA fromValue(String value){
		return valores.get(value);
	}
	
	public String value(){
		return this.cod;
	}
}
