package com.mozart.model.vo;

import java.sql.Timestamp;

import com.mozart.model.vo.filtro.FiltroWeb;


public class TarifaVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6778251790608591339L;
	/*Espelho banco*/
    private Long bcIdTarifa;
    private String bcDescricao;
    private Timestamp bcDataEntrada;
    private Timestamp bcDataSaida;
    private String bcTipo;
    private String bcObservacao;
    private Long bcIdHotel;
    private String bcSiglaHotel;
    private String bcAtivo;
    private Long bcIdMoeda;
    private String bcMoeda;
    private Long bcIdTarifaGrupo;
    private String bcTarifaGrupo;
    private String bcUsuario;
    
    /*Auxiliares*/
    private Double bcAdicional;
    private Double bcPax;
    
    
    /*FILTRO DE PESQUISA*/
    
    private FiltroWeb filtroDataEntrada;
    private FiltroWeb filtroDataSaida;
    private FiltroWeb filtroDescricao;
    private FiltroWeb filtroGrupoTarifa;
    private FiltroWeb filtroTipoTarifa;
    private FiltroWeb filtroAtivo;
    private FiltroWeb filtroPassandoPor;
    
    public TarifaVO() {
        filtroDataEntrada = new FiltroWeb();
        filtroDataSaida = new FiltroWeb();
        filtroDescricao = new FiltroWeb();
        filtroGrupoTarifa = new FiltroWeb();
        filtroTipoTarifa = new FiltroWeb();
        filtroAtivo = new FiltroWeb();
        filtroPassandoPor = new FiltroWeb();
    }

    public TarifaVO(Object[] obj) {
    	
    	if (obj != null){
    		setLinha( obj );
    		bcIdTarifa = getLong();
    	    bcDescricao = getString();
    	    bcDataEntrada = getTimestamp();
    	    bcDataSaida = getTimestamp();
    	    bcTipo = getString();
    	    bcObservacao = getString();
    	    bcIdHotel = getLong();
    	    bcSiglaHotel = getString();
    	    bcAtivo = getString();
    	    bcIdMoeda = getLong();
    	    bcMoeda = getString();
    	    bcTarifaGrupo = getString();
    	    bcUsuario = getString();
    	}
    }

    public void setaDados(Object[] pLinha) {        
        setLinha(pLinha);        
        bcIdTarifa = getLong();
        bcDescricao = getString();
        bcAdicional = getDouble();
        bcTipo = getString();
        bcPax = getDouble();
        bcDataEntrada = getTimestamp();                
    }

    public void setBcIdTarifa(Long bcIdTarifa) {
        this.bcIdTarifa = bcIdTarifa;
    }

    public Long getBcIdTarifa() {
        return bcIdTarifa;
    }

    public void setBcDescricao(String bcDescricao) {
        this.bcDescricao = bcDescricao;
    }

    public String getBcDescricao() {
        return bcDescricao;
    }

    public void setBcDataEntrada(Timestamp bcDataEntrada) {
        this.bcDataEntrada = bcDataEntrada;
    }

    public Timestamp getBcDataEntrada() {
        return bcDataEntrada;
    }

    public void setBcDataSaida(Timestamp bcDataSaida) {
        this.bcDataSaida = bcDataSaida;
    }

    public Timestamp getBcDataSaida() {
        return bcDataSaida;
    }

    public void setBcTipo(String bcTipo) {
        this.bcTipo = bcTipo;
    }

    public String getBcTipo() {
        return bcTipo;
    }

    public void setBcObservacao(String bcObservacao) {
        this.bcObservacao = bcObservacao;
    }

    public String getBcObservacao() {
        return bcObservacao;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }

    public void setBcAtivo(String bcAtivo) {
        this.bcAtivo = bcAtivo;
    }

    public String getBcAtivo() {
        return bcAtivo;
    }

    public void setBcIdMoeda(Long bcIdMoeda) {
        this.bcIdMoeda = bcIdMoeda;
    }

    public Long getBcIdMoeda() {
        return bcIdMoeda;
    }

    public void setBcIdTarifaGrupo(Long bcIdTarifaGrupo) {
        this.bcIdTarifaGrupo = bcIdTarifaGrupo;
    }

    public Long getBcIdTarifaGrupo() {
        return bcIdTarifaGrupo;
    }


    public void setBcAdicional(Double bcAdicional) {
        this.bcAdicional = bcAdicional;
    }

    public Double getBcAdicional() {
        return bcAdicional;
    }

    public void setBcPax(Double bcPax) {
        this.bcPax = bcPax;
    }

    public Double getBcPax() {
        return bcPax;
    }

	public String getBcSiglaHotel() {
		return bcSiglaHotel;
	}

	public void setBcSiglaHotel(String bcSiglaHotel) {
		this.bcSiglaHotel = bcSiglaHotel;
	}

	public String getBcTarifaGrupo() {
		return bcTarifaGrupo;
	}

	public void setBcTarifaGrupo(String bcTarifaGrupo) {
		this.bcTarifaGrupo = bcTarifaGrupo;
	}

	public String getBcUsuario() {
		return bcUsuario;
	}

	public void setBcUsuario(String bcUsuario) {
		this.bcUsuario = bcUsuario;
	}

	public FiltroWeb getFiltroDataEntrada() {
		return filtroDataEntrada;
	}

	public void setFiltroDataEntrada(FiltroWeb filtroDataEntrada) {
		this.filtroDataEntrada = filtroDataEntrada;
	}

	public FiltroWeb getFiltroDataSaida() {
		return filtroDataSaida;
	}

	public void setFiltroDataSaida(FiltroWeb filtroDataSaida) {
		this.filtroDataSaida = filtroDataSaida;
	}

	public FiltroWeb getFiltroDescricao() {
		return filtroDescricao;
	}

	public void setFiltroDescricao(FiltroWeb filtroDescricao) {
		this.filtroDescricao = filtroDescricao;
	}

	public FiltroWeb getFiltroGrupoTarifa() {
		return filtroGrupoTarifa;
	}

	public void setFiltroGrupoTarifa(FiltroWeb filtroGrupoTarifa) {
		this.filtroGrupoTarifa = filtroGrupoTarifa;
	}

	

	public FiltroWeb getFiltroAtivo() {
		return filtroAtivo;
	}

	public void setFiltroAtivo(FiltroWeb filtroAtivo) {
		this.filtroAtivo = filtroAtivo;
	}

	public String getBcMoeda() {
		return bcMoeda;
	}

	public void setBcMoeda(String bcMoeda) {
		this.bcMoeda = bcMoeda;
	}

	public FiltroWeb getFiltroTipoTarifa() {
		return filtroTipoTarifa;
	}

	public void setFiltroTipoTarifa(FiltroWeb filtroTipoTarifa) {
		this.filtroTipoTarifa = filtroTipoTarifa;
	}

	public FiltroWeb getFiltroPassandoPor() {
		return filtroPassandoPor;
	}

	public void setFiltroPassandoPor(FiltroWeb filtroPassandoPor) {
		this.filtroPassandoPor = filtroPassandoPor;
	}
}
