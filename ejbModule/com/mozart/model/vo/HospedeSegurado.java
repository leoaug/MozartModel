package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

import java.math.BigDecimal;

import java.sql.Timestamp;
import java.util.Date;

public class HospedeSegurado extends MozartVO{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7031988787297821578L;
	private FiltroWeb filtroNome;
    private FiltroWeb filtroCPF;
    private FiltroWeb filtroDataNascimento;
    private FiltroWeb filtroCidadeHotel;
    private FiltroWeb filtroDataEntrada;
    private FiltroWeb filtroDataSaida;
    
    
    private FiltroWeb filtroApto;
    private FiltroWeb filtroHotel;
    private FiltroWeb filtroOrigem;
    
    private Long[] idHoteis;

    private Long idRoomList;
    private Long idSeguradora;
    private String redeHotel;
    private String hotel;
    private Long apto;
    private String nomeHospede;
    private Date dataNascimento;
    private String cpf;
    private String passaporte;
    private String origem;
    private String destino;
    private Date dataEntrada;
    private Date dataSaida;
    private Long qtdeDiaria;
    private Double valorSeguro;
    private Double valorTotal;
    private String local;
    private String certificado;
    private Date dataCertificado;
    
    private String sexo;
    private String uf;
    private String email;
    
    private Long numContratoApolice;
    private Long numSubContratoApolice;
    private Long numPlanoApolice;
    
    private String nossoNumero;

    


    public HospedeSegurado() {    
        filtroNome = new FiltroWeb();
        filtroCPF = new FiltroWeb();
        filtroDataNascimento = new FiltroWeb();
        filtroCidadeHotel = new FiltroWeb();
        filtroDataEntrada = new FiltroWeb();
        filtroDataSaida = new FiltroWeb();
    }

    
	public HospedeSegurado(Object[] pLinha) {
        Object[] linha = pLinha;
    
        if (linha != null && linha.length == 25){
            int id = 0;                    
            redeHotel         = (String)linha[ id++ ];
            hotel             = (String)linha[ id++ ];
            apto              = ((BigDecimal)linha[ id++ ]).longValue();
            nomeHospede       = (String)linha[ id++ ];
            
            if (linha[ id ] !=null)
                dataNascimento    = new Date ( ((Timestamp)linha[ id ]).getTime() );
            id++;
            cpf               = (String)linha[ id++ ];
            passaporte        = (String)linha[ id++ ];
            origem            = (String)linha[ id++ ];
            destino           = (String)linha[ id++ ];

            if (linha[ id ] !=null)
                dataEntrada       = new Date ( ((Timestamp)linha[ id ]).getTime() );
            id++;
            if (linha[ id ] !=null)
                dataSaida         = new Date ( ((Timestamp)linha[ id ]).getTime() );
            id++;
            qtdeDiaria        = ((BigDecimal)linha[ id++ ]).longValue();
            valorSeguro       = ((BigDecimal)linha[ id++ ]).doubleValue();
            valorTotal        = ((BigDecimal)linha[ id++ ]).doubleValue();
            local             = (String) linha[id++];
            certificado       = (String) linha[id++];
            if (linha[ id ] !=null)
                dataCertificado         = new Date ( ((Timestamp)linha[ id ]).getTime() );
            id++;
            sexo       = (String) linha[id++];
            uf         = (String) linha[id++];
            email        = (String) linha[id++];
            idRoomList  = ((BigDecimal)linha[ id++ ]).longValue();
            
            
            numContratoApolice = ((BigDecimal)linha[ id++ ]).longValue();
            numSubContratoApolice = ((BigDecimal)linha[ id++ ]).longValue();
            numPlanoApolice = ((BigDecimal)linha[ id++ ]).longValue();
            if (linha[ id ] !=null)
            	nossoNumero = (String)linha[ id++ ];
        }
    }

    public String getDataEntradaStr(){
        return MozartUtil.format(dataEntrada, MozartUtil.FMT_DATE);
    }

    public void setRedeHotel(String redeHotel) {
        this.redeHotel = redeHotel;
    }

    public String getRedeHotel() {
        return redeHotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getHotel() {
        return hotel;
    }

    public void setApto(Long apto) {
        this.apto = apto;
    }

    public Long getApto() {
        return apto;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
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

    public void setQtdeDiaria(Long qtdeDiaria) {
        this.qtdeDiaria = qtdeDiaria;
    }

    public Long getQtdeDiaria() {
        return qtdeDiaria;
    }

    public void setValorSeguro(Double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public Double getValorSeguro() {
        return valorSeguro;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }


    public void setIdSeguradora(Long idSeguradora) {
        this.idSeguradora = idSeguradora;
    }

    public Long getIdSeguradora() {
        return idSeguradora;
    }

    public void setFiltroNome(FiltroWeb filtroNome) {
        this.filtroNome = filtroNome;
    }

    public FiltroWeb getFiltroNome() {
        return filtroNome;
    }

    public void setFiltroApto(FiltroWeb filtroApto) {
        this.filtroApto = filtroApto;
    }

    public FiltroWeb getFiltroApto() {
        return filtroApto;
    }

    public void setFiltroHotel(FiltroWeb filtroHotel) {
        this.filtroHotel = filtroHotel;
    }

    public FiltroWeb getFiltroHotel() {
        return filtroHotel;
    }

    public void setFiltroOrigem(FiltroWeb filtroOrigem) {
        this.filtroOrigem = filtroOrigem;
    }

    public FiltroWeb getFiltroOrigem() {
        return filtroOrigem;
    }

    public void setFiltroDataEntrada(FiltroWeb filtroDataEntrada) {
        this.filtroDataEntrada = filtroDataEntrada;
    }

    public FiltroWeb getFiltroDataEntrada() {
        return filtroDataEntrada;
    }

    public void setIdHoteis(Long[] idHoteis) {
        this.idHoteis = idHoteis;
    }

    public Long[] getIdHoteis() {
        return idHoteis;
    }

    public void setFiltroCPF(FiltroWeb filtroCPF) {
        this.filtroCPF = filtroCPF;
    }

    public FiltroWeb getFiltroCPF() {
        return filtroCPF;
    }

    public void setFiltroDataNascimento(FiltroWeb filtroDataNascimento) {
        this.filtroDataNascimento = filtroDataNascimento;
    }

    public FiltroWeb getFiltroDataNascimento() {
        return filtroDataNascimento;
    }

    public void setFiltroCidadeHotel(FiltroWeb filtroCidadeHotel) {
        this.filtroCidadeHotel = filtroCidadeHotel;
    }

    public FiltroWeb getFiltroCidadeHotel() {
        return filtroCidadeHotel;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setDataCertificado(Date dataCertificado) {
        this.dataCertificado = dataCertificado;
    }

    public Date getDataCertificado() {
        return dataCertificado;
    }

    public void setFiltroDataSaida(FiltroWeb filtroDataSaida) {
        this.filtroDataSaida = filtroDataSaida;
    }

    public FiltroWeb getFiltroDataSaida() {
        return filtroDataSaida;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUf() {
        return uf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setIdRoomList(Long idRoomList) {
        this.idRoomList = idRoomList;
    }

    public Long getIdRoomList() {
        return idRoomList;
    }

    public void setNumContratoApolice(Long numContratoApolice) {
        this.numContratoApolice = numContratoApolice;
    }

    public Long getNumContratoApolice() {
        return numContratoApolice;
    }

    public void setNumSubContratoApolice(Long numSubContratoApolice) {
        this.numSubContratoApolice = numSubContratoApolice;
    }

    public Long getNumSubContratoApolice() {
        return numSubContratoApolice;
    }

    public void setNumPlanoApolice(Long numPlanoApolice) {
        this.numPlanoApolice = numPlanoApolice;
    }

    public Long getNumPlanoApolice() {
        return numPlanoApolice;
    }


	public String getNossoNumero() {
		return nossoNumero;
	}


	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
}
