package com.mozart.model.vo;

import java.io.Serializable;

public class ApoliceAlfa implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 169551916174778937L;
	private String numApolice;    
    private String currentSessionID;
    private String nomeHotel;
    private String cnpjHotel;
    private String nomeHospede;
    private String dataNascimento;
    private String cpf;
    private String sexo;
    private String dataEntrada;
    private String dataSaida;
    private String numContrato;
    
    
    public ApoliceAlfa() {
    }
    
    
	public ApoliceAlfa(Object[] pLinha) {
        Object[] linha = pLinha;
        if (linha != null){
            int id = 0;                    
            numApolice          = (String)linha[ id++ ];
            currentSessionID    = (String)linha[ id++ ];
            nomeHotel           = (String)linha[ id++ ];
            cnpjHotel           = (String)linha[ id++ ];
            nomeHospede         = (String)linha[ id++ ];
            dataNascimento      = (String)linha[ id++ ];
            cpf                 = (String)linha[ id++ ];
            sexo                = (String)linha[ id++ ];
            dataEntrada         = (String)linha[ id++ ];
            dataSaida           = (String)linha[ id++ ];
            numContrato         = (String)linha[ id++ ];
            
        }
    }
    public void setNumApolice(String numApolice) {
        this.numApolice = numApolice;
    }

    public String getNumApolice() {
        return numApolice;
    }

    public void setCurrentSessionID(String currentSessionID) {
        this.currentSessionID = currentSessionID;
    }

    public String getCurrentSessionID() {
        return currentSessionID;
    }

    public void setNomeHotel(String nomeHotel) {
        this.nomeHotel = nomeHotel;
    }

    public String getNomeHotel() {
        return nomeHotel;
    }

    public void setCnpjHotel(String cnpjHotel) {
        this.cnpjHotel = cnpjHotel;
    }

    public String getCnpjHotel() {
        return cnpjHotel;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }


	public String getNumContrato() {
		return numContrato;
	}


	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
}
