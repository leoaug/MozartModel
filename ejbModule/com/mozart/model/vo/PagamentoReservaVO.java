package com.mozart.model.vo;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
;

public class PagamentoReservaVO extends MozartVO{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -353184014119024874L;
	/*espelho banco*/
    private Long bcIdPagamentoReserva;
    private Long bcIdCartaoCredito;
    private Long bcIdTipoLancamento;
    private Long bcIdReserva;
    private Double bcValor;
    private String bcConfirma;
    private Date bcDataConfirma;
    private String bcNumDocumento;
    private String bcValidadeCartao;
    private Long bcIdHotel;
    private Long bcIdCentralReservas;
    private String bcFormaPg;
    private String bcCodigoSeguranca;
    /*auxiliares*/
    private String bcTipoLancamento;
    private String bcBandeira;
    private String bcNomeCartao;
    private String dsAptoCofan;
    private Long bcIdApartamento;
    private String bcCheckin;
    private Long bcIdIdentificaLancamento;
    private Long bcIdMovimentoApartamento;
    
	public String getDsAptoCofan() {
		return dsAptoCofan;
	}


	public void setDsAptoCofan(String dsAptoCofan) {
		this.dsAptoCofan = dsAptoCofan;
	}


	public void setaDadosObterTiposDePagamentoReserva(Object[] pLinha) {        
        setLinha(pLinha);
        bcIdIdentificaLancamento = getLong();
        bcIdTipoLancamento = getLong();
        bcFormaPg = getString();        
    }    
    
    
	public void setaDados(Object[] pLinha) {    
        setLinha(pLinha);
        bcIdPagamentoReserva = getLong();
        bcIdCartaoCredito = getLong();
        bcIdTipoLancamento = getLong();
        bcIdReserva = getLong();
        bcValor = getDouble();
        bcConfirma = getString();
        bcDataConfirma = getDate();
        bcNumDocumento = getString();
        bcValidadeCartao = getString();
        bcIdHotel = getLong();
        bcIdCentralReservas = getLong();
        bcFormaPg = getString();
        bcNomeCartao = getString();
        bcCodigoSeguranca = getString();
        bcBandeira = getString();
        bcCheckin = getString();
        bcIdMovimentoApartamento = getLong();        
    }
    
    public PagamentoReservaVO() {
    }

    public void setBcIdPagamentoReserva(Long bcIdPagamentoReserva) {
        this.bcIdPagamentoReserva = bcIdPagamentoReserva;
    }

    public Long getBcIdPagamentoReserva() {
        return bcIdPagamentoReserva;
    }

    public void setBcIdCartaoCredito(Long bcIdCartaoCredito) {
        this.bcIdCartaoCredito = bcIdCartaoCredito;
    }

    public Long getBcIdCartaoCredito() {
        return bcIdCartaoCredito;
    }

    public void setBcIdTipoLancamento(Long bcIdTipoLancamento) {
        this.bcIdTipoLancamento = bcIdTipoLancamento;
    }

    public Long getBcIdTipoLancamento() {
        return bcIdTipoLancamento;
    }

    public void setBcIdReserva(Long bcIdReserva) {
        this.bcIdReserva = bcIdReserva;
    }

    public Long getBcIdReserva() {
        return bcIdReserva;
    }

    public void setBcValor(Double bcValor) {
        this.bcValor = bcValor;
    }

    public Double getBcValor() {
        return bcValor;
    }

    public void setBcConfirma(String bcConfirma) {
        this.bcConfirma = bcConfirma;
    }

    public String getBcConfirma() {
        return bcConfirma;
    }

    public void setBcDataConfirma(Date bcDataConfirma) {
        this.bcDataConfirma = bcDataConfirma;
    }

    public Date getBcDataConfirma() {
        return bcDataConfirma;
    }

    public void setBcNumDocumento(String bcNumDocumento) {
        this.bcNumDocumento = bcNumDocumento;
    }

    public String getBcNumDocumento() {
        return bcNumDocumento;
    }

    public void setBcValidadeCartao(String bcValidadeCartao) {
        this.bcValidadeCartao = bcValidadeCartao;
    }

    public String getBcValidadeCartao() {
        return bcValidadeCartao;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }

    public void setBcIdCentralReservas(Long bcIdCentralReservas) {
        this.bcIdCentralReservas = bcIdCentralReservas;
    }

    public Long getBcIdCentralReservas() {
        return bcIdCentralReservas;
    }

    public void setBcFormaPg(String bcFormaPg) {
        this.bcFormaPg = bcFormaPg;
    }

    public String getBcFormaPg() {
        return bcFormaPg;
    }

    public String getBcFormaPgDesc() {
        if ("D".equals(bcFormaPg))
            return "Direto";
        else if ("F".equals(bcFormaPg))
            return "Faturado";
        else if ("A".equals(bcFormaPg))
            return "Antecipado";
        else
            return "";        
    }
        
    public String getBcConfirmaDesc() {
        if ("S".equals(bcConfirma))
            return "Sim";
        else if ("N".equals(bcConfirma))
            return "Não";    
        else
            return "";
    }

    public void setBcTipoLancamento(String bcTipoLancamento) {
        this.bcTipoLancamento = bcTipoLancamento;
    }

    public String getBcTipoLancamento() {
        return bcTipoLancamento;
    }


	public String getBcCodigoSeguranca() {
		return bcCodigoSeguranca;
	}

	public void setBcCodigoSeguranca(String bcCodigoSeguranca) {
		this.bcCodigoSeguranca = bcCodigoSeguranca;
	}


	public String getBcBandeira() {
		return bcBandeira;
	}


	public void setBcBandeira(String bcBandeira) {
		this.bcBandeira = bcBandeira;
	}
	
	
	
	public String getBcNomeCartao() {
		return bcNomeCartao;
	}


	public void setBcNomeCartao(String bcNomeCartao) {
		this.bcNomeCartao = bcNomeCartao;
	}


	public String toAllString() {
	    StringBuilder result = new StringBuilder();
	    String newLine = System.getProperty("line.separator");

	    result.append(this.getClass().getName());
	    result.append(" Object {");
	    result.append(newLine);

	    //determine fields declared in this class only (no fields of superclass)
	    Field[] fields = this.getClass().getDeclaredFields();

	    //print field names paired with their values
	    for (Field field : fields) {
	      result.append("  ");
	      try {
	        result.append(field.getName());
	        result.append(": ");
	        //requires access to private field:
	        result.append(field.get(this));
	      }
	      catch (IllegalAccessException ex) {
	        System.out.println(ex);
	      }
	      result.append(newLine);
	    }
	    result.append("}");

	    return result.toString();
	  }


	public Long getBcIdApartamento() {
		return bcIdApartamento;
	}


	public void setBcIdApartamento(Long bcIdApartamento) {
		this.bcIdApartamento = bcIdApartamento;
	}


	public String getBcCheckin() {
		return bcCheckin;
	}


	public void setBcCheckin(String bcCheckin) {
		this.bcCheckin = bcCheckin;
	}


	public Long getBcIdIdentificaLancamento() {
		return bcIdIdentificaLancamento;
	}


	public void setBcIdIdentificaLancamento(Long bcIdIdentificaLancamento) {
		this.bcIdIdentificaLancamento = bcIdIdentificaLancamento;
	}


	public Long getBcIdMovimentoApartamento() {
		return bcIdMovimentoApartamento;
	}


	public void setBcIdMovimentoApartamento(Long bcIdMovimentoApartamento) {
		this.bcIdMovimentoApartamento = bcIdMovimentoApartamento;
	}
	
	

}
