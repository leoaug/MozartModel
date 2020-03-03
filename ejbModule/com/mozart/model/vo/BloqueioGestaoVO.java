package com.mozart.model.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class BloqueioGestaoVO extends MozartVO{
    
    
    private Long[] idHoteis;    
    
    /* Campos espelho do banco  bc - banco*/
    
    private Long bcIdReserva;
    private Long bcIdEmpresa;
    private Long bcDeadLine;
    private Double iss;
    private Double taxaServico;
    private Double roomTax;
    private Double seguro;
    private String descricaoCompleta;
    private String nomeFantasia;
    private Long bcIdHotel;
    private Date bcDataEntrada;
    private Date bcDataSaida;
    private Date bcDataReserva;
    private Date bcDataCancelamento;
    /* Fim Campos espelho do banco */
    
    
    /*Auxiliares para gravacao*/
    private EmpresaHotelVO empresaHotelVO;
    private List<PagamentoReservaVO> listPagamento;
    private List<ReservaApartamentoVO> listReservaApartamento;
    private List<ReservaGrupoLancamentoVO> listReservaGrupoLancamento;
    
    /*Auxliares para calulo*/
    private Double percentualIss;
    private Double percentualRoomTax;
    private Double percentualTaxaServico;
    
    /*Auxliares tela*/
    private Long ocupacaoDisponibilidade;
    
    private String bloqueio;
    
	public void setaDados(Object[] pLinha) {
        
		setLinha(pLinha);                
		descricaoCompleta = getString();
		bcIdEmpresa = getLong();
		nomeFantasia = getString();
		bcIdReserva = getLong();
		bcDataEntrada = getDate();
		bcDataSaida = getDate();
    }
    
    
	public void setaDadosGestaoBloqueio(Object[] pLinha) {
        
        setLinha(pLinha);
        bcIdReserva = getLong();
        bcDataReserva = getTimestamp();
        bcDeadLine = getLong();
        bcDataCancelamento = getTimestamp();
        iss = getDouble();
        taxaServico = getDouble();
        roomTax = getDouble();
        seguro = getDouble();
        
    }
    
    public BloqueioGestaoVO() {

    	empresaHotelVO = new EmpresaHotelVO();
        listPagamento = new ArrayList<PagamentoReservaVO>();
        listReservaApartamento = new ArrayList<ReservaApartamentoVO>();
        listReservaGrupoLancamento = new ArrayList<ReservaGrupoLancamentoVO>();
    }
    

    public void setIdHoteis(Long[] idHoteis) {
        this.idHoteis = idHoteis;
    }

    public Long[] getIdHoteis() {
        return idHoteis;
    }


    public void setBcIdReserva(Long bcIdReserva) {
        this.bcIdReserva = bcIdReserva;
    }

    public Long getBcIdReserva() {
        return bcIdReserva;
    }

    public void setBcIdEmpresa(Long bcIdEmpresa) {
        this.bcIdEmpresa = bcIdEmpresa;
    }

    public Long getBcIdEmpresa() {
        return bcIdEmpresa;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }

    public void setBcDataEntrada(Date bcDataEntrada) {
        this.bcDataEntrada = bcDataEntrada;
    }

    public Date getBcDataEntrada() {
        return bcDataEntrada;
    }

    public void setBcDataSaida(Date bcDataSaida) {
        this.bcDataSaida = bcDataSaida;
    }

    public Date getBcDataSaida() {
        return bcDataSaida;
    }


    public void setEmpresaHotelVO(EmpresaHotelVO empresaHotelVO) {
        this.empresaHotelVO = empresaHotelVO;
    }

    public EmpresaHotelVO getEmpresaHotelVO() {
        return empresaHotelVO;
    }

    public void setListPagamento(List<PagamentoReservaVO> listPagamento) {
        this.listPagamento = listPagamento;
    }

    public List<PagamentoReservaVO> getListPagamento() {
        return listPagamento;
    }

    public void setListReservaApartamento(List<ReservaApartamentoVO> listReservaApartamento) {
        this.listReservaApartamento = listReservaApartamento;
    }

    public List<ReservaApartamentoVO> getListReservaApartamento() {
        return listReservaApartamento;
    }

    public void setListReservaGrupoLancamento(List<ReservaGrupoLancamentoVO> listReservaGrupoLancamento) {
        this.listReservaGrupoLancamento = listReservaGrupoLancamento;
    }

    public List<ReservaGrupoLancamentoVO> getListReservaGrupoLancamento() {
        return listReservaGrupoLancamento;
    }
        

    public void setPercentualIss(Double percentualIss) {
        this.percentualIss = percentualIss;
    }

    public Double getPercentualIss() {
        return percentualIss;
    }

    public void setPercentualRoomTax(Double percentualRoomTax) {
        this.percentualRoomTax = percentualRoomTax;
    }

    public Double getPercentualRoomTax() {
        return percentualRoomTax;
    }

    public void setPercentualTaxaServico(Double percentualTaxaServico) {
        this.percentualTaxaServico = percentualTaxaServico;
    }

    public Double getPercentualTaxaServico() {
        return percentualTaxaServico;
    }
    
    public Double getValorTotalReservaSemIssTaxaRoom(){
        double result = new Double(0);        
        for (ReservaApartamentoVO obj: listReservaApartamento ){            
            result += obj.getBcTotalTarifa();
        }    
        return result;
    }   
    
    public Double getValorIss() {
        if (percentualIss==null) {
            return new Double(0);
        }
        else {
            if (percentualIss==null)
                percentualIss = new Double(0);
            return (getValorTotalReservaSemIssTaxaRoom() / 100) * percentualIss;
        }
    }

    public Double getValorRoomTax() {
        Long qtdDiaria = new Long(0);
        if (percentualRoomTax==null) {
            return new Double(0);
        }
        else {
            //Apesar do nome do campo estar pecentual, é cobrado o valor * qtd de diarias! 
            //Não é um percentual do valor total da reserva!            
                
            for (ReservaApartamentoVO obj: listReservaApartamento)                
                qtdDiaria += new Long(obj.getListReservaApartamentoDiaria().size());            
            return (percentualRoomTax * qtdDiaria );
        }
    }

    
    public Double getValorTaxaServico() {        
        if (percentualTaxaServico==null) {
            return new Double(0);
        }
        else {
            if (percentualTaxaServico==null)
                percentualTaxaServico = new Double(0);
            return (getValorTotalReservaSemIssTaxaRoom()/ 100) * percentualTaxaServico;
        }        
    }
    

    public Double getValorTotalReserva(){
        return (getValorTotalReservaSemIssTaxaRoom() + getValorIss() + getValorRoomTax() + getValorTaxaServico() );
    }


    public void setOcupacaoDisponibilidade(Long ocupacaoDisponibilidade) {
        this.ocupacaoDisponibilidade = ocupacaoDisponibilidade;
    }

    public Long getOcupacaoDisponibilidade() {
        return ocupacaoDisponibilidade;
    }


	public String getBloqueio() {
		return bloqueio;
	}
	
	public void setBloqueio(String bloqueio) {
		this.bloqueio = bloqueio;
	}


	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}


	public void setDescricaoCompleta(String descricaoCompleta) {
		this.descricaoCompleta = descricaoCompleta;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public Long getBcDeadLine() {
		return bcDeadLine;
	}


	public void setBcDeadLine(Long bcDeadLine) {
		this.bcDeadLine = bcDeadLine;
	}


	public Double getIss() {
		return iss;
	}


	public void setIss(Double iss) {
		this.iss = iss;
	}


	public Double getTaxaServico() {
		return taxaServico;
	}


	public void setTaxaServico(Double taxaServico) {
		this.taxaServico = taxaServico;
	}


	public Double getRoomTax() {
		return roomTax;
	}


	public void setRoomTax(Double roomTax) {
		this.roomTax = roomTax;
	}


	public Double getSeguro() {
		return seguro;
	}


	public void setSeguro(Double seguro) {
		this.seguro = seguro;
	}


	public Date getBcDataReserva() {
		return bcDataReserva;
	}


	public void setBcDataReserva(Date bcDataReserva) {
		this.bcDataReserva = bcDataReserva;
	}


	public Date getBcDataCancelamento() {
		return bcDataCancelamento;
	}


	public void setBcDataCancelamento(Date bcDataCancelamento) {
		this.bcDataCancelamento = bcDataCancelamento;
	}
	
	
}