package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import java.util.Date;

public class CheckinVO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 566543783221609431L;
	private FiltroWeb filtroApto;
    private FiltroWeb filtroHospede;
    private FiltroWeb filtroCheckin;
    private FiltroWeb filtroReserva;
    private FiltroWeb filtroConfirmada;
    private FiltroWeb filtroDataEntrada;
    private FiltroWeb filtroDataSaida;
    private FiltroWeb filtroEmpresa;
    private FiltroWeb filtroGrupo;
    private FiltroWeb filtroObs;
    private FiltroWeb filtroPensao;
    private FiltroWeb filtroQtdeApto;
    private FiltroWeb filtroQtdePax;
    private FiltroWeb filtroCofan;
    private FiltroWeb filtroCheckinIncompleto;
    private String filtroTipoPesquisa;
    private Long[] idHoteis;
    
    
    private Long idReserva;
    private Long idReservaApartamento;
    private Long idCheckin;
    private Long idCentralReservas;
    private Long idRoomList;
    private Long idCorporate;
    private Long idHospede;
    private String nomeHospede;
    private Long numApartamento;
    private Date dataEntrada;
    private Date dataSaida;
    private String bloqueio;
    private Long disponivel;
    private Long qtdeApto;
    private Long qtdeCheckin;
    private Long qtdePax;
    private String nomeFantasia;
    private String grupo;
    private String cortesia;
    private String observacao;
    private String credito;
    private String calculaTaxa;
    private String calculaIss;
    private String calculaRoomTax;
    private String calculaSeguro;
    private String tipoPensao;
    private String nomeGrupo;
    private String confirmada;
    private String tipoHospede;
    private Double valorPensao;
    private String master;
    private String noShow;
    private String saidaDia;
    private String cofan;
    private Long qtdeAdultos;
    private Long qtdeCriancas;
    private Long adicional;
    private Long qtdeCafe;
    private Long codCertificado;
    
    public CheckinVO() {
        filtroApto = new FiltroWeb();
        filtroHospede = new FiltroWeb();
        filtroCheckin = new FiltroWeb();
        filtroReserva = new FiltroWeb();
        filtroConfirmada = new FiltroWeb();
        filtroDataEntrada = new FiltroWeb();
        filtroDataSaida = new FiltroWeb();
        filtroEmpresa = new FiltroWeb();
        filtroGrupo = new FiltroWeb();
        filtroObs = new FiltroWeb();
        filtroPensao = new FiltroWeb();
        filtroQtdeApto = new FiltroWeb();
        filtroQtdePax = new FiltroWeb();
        filtroCofan = new FiltroWeb();
        filtroCheckinIncompleto = new FiltroWeb();
    }
    
    
    
	public CheckinVO( Object[] vet ) {
    
        if (vet != null){        
            Object[] linha = vet;
            int id = 0;                    
            if (linha[ id ] != null)
                idReserva           = ((BigDecimal)linha[ id ]).longValue();
            id++;
            
            if (linha[ id ] != null)
                idReservaApartamento    = ((BigDecimal)linha[ id ]).longValue();
            id++;
            
            if (linha[ id ] != null)
                idCheckin           = ((BigDecimal)linha[ id ]).longValue();
            id++;
            if (linha[ id ] != null)
                idCentralReservas   = ((BigDecimal)linha[ id ]).longValue();
            id++;
            if (linha[ id ] != null)
                idRoomList          = ((BigDecimal)linha[ id ]).longValue();
            id++;
            if (linha[ id ] != null)
                idCorporate         = ((BigDecimal)linha[ id ]).longValue();
            id++;
            if (linha[ id ] != null)
                idHospede           = ((BigDecimal)linha[ id ]).longValue();
            id++;
            
            nomeHospede         = (String) linha[ id++ ];
            
            if (linha[ id ] != null)
                numApartamento      = ((BigDecimal)linha[ id ]).longValue();
            id++;
            
            if (linha[ id ] !=null)
                dataEntrada     = new Date ( ((Timestamp)linha[ id ]).getTime() );
            id++;
            if (linha[ id ] !=null)
                dataSaida       = new Date ( ((Timestamp)linha[ id ]).getTime() );
            id++;
            
            bloqueio            = (String) linha[ id++ ];
            
            if (linha[ id ] !=null)
                disponivel          = ((BigDecimal)linha[ id ]).longValue();
            id++;
            
            if (linha[ id ] !=null)
                qtdeApto            = ((BigDecimal)linha[ id ]).longValue();   
            id++;
            
            if (linha[ id ] !=null)
                qtdeCheckin         = ((BigDecimal)linha[ id ]).longValue();
            id++;
            
            if (linha[ id ] !=null)
                qtdePax             = ((BigDecimal)linha[ id ]).longValue();
            id++;
            
            
            nomeFantasia        = (String) linha[ id++ ];
            
            grupo               = (String) linha[ id++ ];
            cortesia            = (String) linha[ id++ ];
            observacao          = (String) linha[ id++ ];
            credito             = (String) linha[ id++ ];
            calculaTaxa         = (String) linha[ id++ ];
            calculaIss          = (String) linha[ id++ ];
            calculaRoomTax      = (String) linha[ id++ ];
            calculaSeguro       = (String) linha[ id++ ];
            tipoPensao          = (String) linha[ id++ ];
            nomeGrupo           = (String) linha[ id++ ];
            confirmada          = (String) linha[ id++ ];
            tipoHospede         = (String) linha[ id++ ];
            if (linha[ id ] !=null)
                valorPensao         = ((BigDecimal)linha[ id ]).doubleValue();
            id++;
            master              = (String) linha[ id++ ];
            noShow              = (String) linha[ id++ ];
            cofan				= (String) linha[ id++ ];
            if (linha[ id ] !=null)
            	qtdeAdultos = ((BigDecimal)linha[ id ]).longValue();
            id++;
            if (linha[ id ] !=null)
            	qtdeCriancas = ((BigDecimal)linha[ id ]).longValue();
            id++;
            if (linha[ id ] !=null)
            	adicional = ((BigDecimal)linha[ id ]).longValue();
            id++;
            if (linha[ id ] !=null)
            	qtdeCafe = ((BigDecimal)linha[ id ]).longValue();
            id++;

            if (linha[ id ] !=null)
            	codCertificado = ((BigDecimal)linha[ id ]).longValue();
            id++;
        }
    }
    

    public void setFiltroApto(FiltroWeb filtroApto) {
        this.filtroApto = filtroApto;
    }

    public FiltroWeb getFiltroApto() {
        return filtroApto;
    }

    public void setFiltroHospede(FiltroWeb filtroHospede) {
        this.filtroHospede = filtroHospede;
    }

    public FiltroWeb getFiltroHospede() {
        return filtroHospede;
    }

    public void setFiltroCheckin(FiltroWeb filtroCheckin) {
        this.filtroCheckin = filtroCheckin;
    }

    public FiltroWeb getFiltroCheckin() {
        return filtroCheckin;
    }

    public void setFiltroReserva(FiltroWeb filtroReserva) {
        this.filtroReserva = filtroReserva;
    }

    public FiltroWeb getFiltroReserva() {
        return filtroReserva;
    }

    public void setFiltroConfirmada(FiltroWeb filtroConfirmada) {
        this.filtroConfirmada = filtroConfirmada;
    }

    public FiltroWeb getFiltroConfirmada() {
        return filtroConfirmada;
    }

    public void setFiltroDataEntrada(FiltroWeb filtroDataEntrada) {
        this.filtroDataEntrada = filtroDataEntrada;
    }

    public FiltroWeb getFiltroDataEntrada() {
        return filtroDataEntrada;
    }

    public void setFiltroDataSaida(FiltroWeb filtroDataSaida) {
        this.filtroDataSaida = filtroDataSaida;
    }

    public FiltroWeb getFiltroDataSaida() {
        return filtroDataSaida;
    }

    public void setFiltroEmpresa(FiltroWeb filtroEmpresa) {
        this.filtroEmpresa = filtroEmpresa;
    }

    public FiltroWeb getFiltroEmpresa() {
        return filtroEmpresa;
    }

    public void setFiltroGrupo(FiltroWeb filtroGrupo) {
        this.filtroGrupo = filtroGrupo;
    }

    public FiltroWeb getFiltroGrupo() {
        return filtroGrupo;
    }

    public void setFiltroObs(FiltroWeb filtroObs) {
        this.filtroObs = filtroObs;
    }

    public FiltroWeb getFiltroObs() {
        return filtroObs;
    }

    public void setFiltroPensao(FiltroWeb filtroPensao) {
        this.filtroPensao = filtroPensao;
    }

    public FiltroWeb getFiltroPensao() {
        return filtroPensao;
    }

    public void setFiltroQtdeApto(FiltroWeb filtroQtdeApto) {
        this.filtroQtdeApto = filtroQtdeApto;
    }

    public FiltroWeb getFiltroQtdeApto() {
        return filtroQtdeApto;
    }

    public void setFiltroQtdePax(FiltroWeb filtroQtdePax) {
        this.filtroQtdePax = filtroQtdePax;
    }

    public FiltroWeb getFiltroQtdePax() {
        return filtroQtdePax;
    }

    public void setIdHoteis(Long[] idHoteis) {
        this.idHoteis = idHoteis;
    }

    public Long[] getIdHoteis() {
        return idHoteis;
    }

    public void setFiltroTipoPesquisa(String filtroTipoPesquisa) {
        this.filtroTipoPesquisa = filtroTipoPesquisa;
    }

    public String getFiltroTipoPesquisa() {
        return filtroTipoPesquisa;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdCheckin(Long idCheckin) {
        this.idCheckin = idCheckin;
    }

    public Long getIdCheckin() {
        return idCheckin;
    }

    public void setIdCentralReservas(Long idCentralReservas) {
        this.idCentralReservas = idCentralReservas;
    }

    public Long getIdCentralReservas() {
        return idCentralReservas;
    }

    public void setIdRoomList(Long idRoomList) {
        this.idRoomList = idRoomList;
    }

    public Long getIdRoomList() {
        return idRoomList;
    }

    public void setIdCorporate(Long idCorporate) {
        this.idCorporate = idCorporate;
    }

    public Long getIdCorporate() {
        return idCorporate;
    }

    public void setIdHospede(Long idHospede) {
        this.idHospede = idHospede;
    }

    public Long getIdHospede() {
        return idHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNumApartamento(Long numApartamento) {
        this.numApartamento = numApartamento;
    }

    public Long getNumApartamento() {
        return numApartamento;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setBloqueio(String bloqueio) {
        this.bloqueio = bloqueio;
    }

    public String getBloqueio() {
        return bloqueio;
    }

    public void setDisponivel(Long disponivel) {
        this.disponivel = disponivel;
    }

    public Long getDisponivel() {
        return disponivel;
    }

    public void setQtdeApto(Long qtdeApto) {
        this.qtdeApto = qtdeApto;
    }

    public Long getQtdeApto() {
        return qtdeApto;
    }

    public void setQtdeCheckin(Long qtdeCheckin) {
        this.qtdeCheckin = qtdeCheckin;
    }

    public Long getQtdeCheckin() {
        return qtdeCheckin;
    }

    public void setQtdePax(Long qtdePax) {
        this.qtdePax = qtdePax;
    }

    public Long getQtdePax() {
        return qtdePax;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setCortesia(String cortesia) {
        this.cortesia = cortesia;
    }

    public String getCortesia() {
        return cortesia;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getCredito() {
        return credito;
    }

    public void setCalculaTaxa(String calculaTaxa) {
        this.calculaTaxa = calculaTaxa;
    }

    public String getCalculaTaxa() {
        return calculaTaxa;
    }

    public void setCalculaIss(String calculaIss) {
        this.calculaIss = calculaIss;
    }

    public String getCalculaIss() {
        return calculaIss;
    }

    public void setCalculaRoomTax(String calculaRoomTax) {
        this.calculaRoomTax = calculaRoomTax;
    }

    public String getCalculaRoomTax() {
        return calculaRoomTax;
    }

    public void setCalculaSeguro(String calculaSeguro) {
        this.calculaSeguro = calculaSeguro;
    }

    public String getCalculaSeguro() {
        return calculaSeguro;
    }

    public void setTipoPensao(String tipoPensao) {
        this.tipoPensao = tipoPensao;
    }

    public String getTipoPensao() {
        return tipoPensao;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setConfirmada(String confirmada) {
        this.confirmada = confirmada;
    }

    public String getConfirmada() {
        return confirmada;
    }

    public void setTipoHospede(String tipoHospede) {
        this.tipoHospede = tipoHospede;
    }

    public String getTipoHospede() {
        return tipoHospede;
    }

    public void setValorPensao(Double valorPensao) {
        this.valorPensao = valorPensao;
    }

    public Double getValorPensao() {
        return valorPensao;
    }

    public void setIdReservaApartamento(Long idReservaApartamento) {
        this.idReservaApartamento = idReservaApartamento;
    }

    public Long getIdReservaApartamento() {
        return idReservaApartamento;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getMaster() {
        return master;
    }

    public void setNoShow(String noShow) {
        this.noShow = noShow;
    }

    public String getNoShow() {
        return noShow;
    }

    public void setSaidaDia(String saidaDia) {
        this.saidaDia = saidaDia;
    }

    public String getSaidaDia() {
        return saidaDia;
    }



	public FiltroWeb getFiltroCofan() {
		return filtroCofan;
	}



	public void setFiltroCofan(FiltroWeb filtroCofan) {
		this.filtroCofan = filtroCofan;
	}



	public Long getQtdeAdultos() {
		return qtdeAdultos;
	}



	public void setQtdeAdultos(Long qtdeAdultos) {
		this.qtdeAdultos = qtdeAdultos;
	}



	public Long getQtdeCriancas() {
		return qtdeCriancas;
	}



	public void setQtdeCriancas(Long qtdeCriancas) {
		this.qtdeCriancas = qtdeCriancas;
	}



	public Long getAdicional() {
		return adicional;
	}



	public void setAdicional(Long adicional) {
		this.adicional = adicional;
	}



	public Long getQtdeCafe() {
		return qtdeCafe;
	}



	public void setQtdeCafe(Long qtdeCafe) {
		this.qtdeCafe = qtdeCafe;
	}



	public String getCofan() {
		return cofan;
	}



	public void setCofan(String cofan) {
		this.cofan = cofan;
	}



	public Long getCodCertificado() {
		return codCertificado;
	}



	public void setCodCertificado(Long codCertificado) {
		this.codCertificado = codCertificado;
	}



	public FiltroWeb getFiltroCheckinIncompleto() {
		return filtroCheckinIncompleto;
	}



	public void setFiltroCheckinIncompleto(FiltroWeb filtroCheckinIncompleto) {
		this.filtroCheckinIncompleto = filtroCheckinIncompleto;
	}
}
