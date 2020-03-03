package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class HospedeVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6056974516655424899L;
	
	private FiltroWeb filtroNome;
	private FiltroWeb filtroSobrenome;
	private FiltroWeb filtroCpf;
	private FiltroWeb filtroIdentidade;
	private FiltroWeb filtroPassaporte;
	private FiltroWeb filtroTelefone;
	
	
	private Long bcIdHospede;
    private String bcNomeHospede;
    private String bcSobrenomeHospede;
    private String bcCpf;
    private Date bcNascimento;
    private String bcPassaporte;
    private String bcIdentidade;
    private Long bcIdHotel;
    private String bcTelefone;
    private String bcFax;
    private String bcTelex;
    private String bcCelular;
    private String bcEmail;
    
      
    public void setaDados(Object[] pLinha) {        
        setLinha(pLinha);
        bcIdHospede = getLong();
        bcNomeHospede = getString();
        bcCpf = getString();
        bcNascimento = getDate();
        bcPassaporte = getString();
    }
    
    public HospedeVO() {
    }

    public HospedeVO(Object[] pLinha) {
    	setLinha(pLinha);
        bcIdHospede 	= getLong();
        bcNomeHospede 	= getString();
        bcCpf 			= getString();
        bcNascimento 	= getDate();
        bcPassaporte 	= getString();
        bcIdentidade 	= getString();
        bcTelefone 		= getString();
        bcFax 			= getString();
        bcTelex 		= getString();
        bcCelular 		= getString();
        bcEmail 		= getString();
    }

    public void setBcIdHospede(Long bcIdHospede) {
        this.bcIdHospede = bcIdHospede;
    }

    public Long getBcIdHospede() {
        return bcIdHospede;
    }

    public void setBcNomeHospede(String bcNomeHospede) {
        this.bcNomeHospede = bcNomeHospede;
    }

    public String getBcNomeHospede() {
        return bcNomeHospede;
    }

    public void setBcSobrenomeHospede(String bcSobrenomeHospede) {
        this.bcSobrenomeHospede = bcSobrenomeHospede;
    }

    public String getBcSobrenomeHospede() {
        return bcSobrenomeHospede;
    }

    public void setBcCpf(String bcCpf) {
        this.bcCpf = bcCpf;
    }

    public String getBcCpf() {
        return bcCpf;
    }

    public void setBcNascimento(Date bcNascimento) {
        this.bcNascimento = bcNascimento;
    }

    public Date getBcNascimento() {
        return bcNascimento;
    }

    public void setBcPassaporte(String bcPassaporte) {
        this.bcPassaporte = bcPassaporte;
    }

    public String getBcPassaporte() {
        return bcPassaporte;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }

	public FiltroWeb getFiltroNome() {
		return filtroNome;
	}

	public void setFiltroNome(FiltroWeb filtroNome) {
		this.filtroNome = filtroNome;
	}

	public FiltroWeb getFiltroSobrenome() {
		return filtroSobrenome;
	}

	public void setFiltroSobrenome(FiltroWeb filtroSobrenome) {
		this.filtroSobrenome = filtroSobrenome;
	}

	public FiltroWeb getFiltroCpf() {
		return filtroCpf;
	}

	public void setFiltroCpf(FiltroWeb filtroCpf) {
		this.filtroCpf = filtroCpf;
	}

	public FiltroWeb getFiltroIdentidade() {
		return filtroIdentidade;
	}

	public void setFiltroIdentidade(FiltroWeb filtroIdentidade) {
		this.filtroIdentidade = filtroIdentidade;
	}

	public FiltroWeb getFiltroPassaporte() {
		return filtroPassaporte;
	}

	public void setFiltroPassaporte(FiltroWeb filtroPassaporte) {
		this.filtroPassaporte = filtroPassaporte;
	}

	public FiltroWeb getFiltroTelefone() {
		return filtroTelefone;
	}

	public void setFiltroTelefone(FiltroWeb filtroTelefone) {
		this.filtroTelefone = filtroTelefone;
	}

	public String getBcTelefone() {
		return bcTelefone;
	}

	public void setBcTelefone(String bcTelefone) {
		this.bcTelefone = bcTelefone;
	}

	public String getBcFax() {
		return bcFax;
	}

	public void setBcFax(String bcFax) {
		this.bcFax = bcFax;
	}

	public String getBcTelex() {
		return bcTelex;
	}

	public void setBcTelex(String bcTelex) {
		this.bcTelex = bcTelex;
	}

	public String getBcCelular() {
		return bcCelular;
	}

	public void setBcCelular(String bcCelular) {
		this.bcCelular = bcCelular;
	}

	public String getBcEmail() {
		return bcEmail;
	}

	public void setBcEmail(String bcEmail) {
		this.bcEmail = bcEmail;
	}

	public String getBcIdentidade() {
		return bcIdentidade;
	}

	public void setBcIdentidade(String bcIdentidade) {
		this.bcIdentidade = bcIdentidade;
	}
}
