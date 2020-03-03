package com.mozart.model.vo;

import com.mozart.model.ejb.entity.MovimentoApartamentoEJB;
import com.mozart.model.vo.filtro.FiltroWeb;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.List;

@SuppressWarnings("serial")
public class ReservaVO extends MozartVO{

    
    
    private FiltroWeb dataEntrada;
    private FiltroWeb dataSaida;
    private FiltroWeb nomeHospede;
    private FiltroWeb contato;
    private FiltroWeb nomeGrupo;
    private FiltroWeb dataReserva;
    private FiltroWeb empresa;
    private FiltroWeb apagada;
    private FiltroWeb formaReserva;
    private FiltroWeb numBloqueio;
    private FiltroWeb confirmada;
    private FiltroWeb siglaHotel;
    private FiltroWeb idReserva;
    private FiltroWeb apartamento;
    private FiltroWeb tipoHospede;
    private FiltroWeb idCrs;
    private FiltroWeb idGds;
    private FiltroWeb prazoCancelamento;
    private FiltroWeb reservaTravada;
    private FiltroWeb empresagds;
    /* Variaveis que vão ser usada no resultado do grid e no action
     * grac -> gr: grid | ac: action 
     * */
    
    private Long gracIdReservaApartamento; 
    private String gracIdApagada;
    private Long gracIdReserva;
    private Long gracIdReservaBloqueio;
    private Long gracIdRoomList;
    private Long gracIdTipoApartamento;
    private Long gracQtdCriancas;
    private Long gracAdicional;
    private String gracNomeHospede;
    private Timestamp gracDataEntrada;
    private Timestamp gracDataSaida;
    private String gracBloqueio;
    private Long gracQtdePax;
    private Long gracQtdeApartamento;
    private String gracNomeEmpresa;
    private String gracContato;
    private String gracConfirmada;
    private String gracObservacao;
    private String gracFormaReserva;
    private String gracTelefoneContato;
    private Long gracQtdeCheckin;
    private String gracFantasia;
    private String gracTipoPensao;
    
    private Double gracTarifa;
    private String gracTipoHospede;
    private Double gracValorTotal;
    private Long gracIdEmpresa;
    private String gracCheckin;
    private String gracCheckinSimNao;
    private String gracSigla;
    private String gracNumApartamento;
    private Long gracIdPermuta;
    private String gracNomeGrupo;
    private Timestamp gracDataReserva;
    private String gracCampoWeb;
    private String gracNomeCentralReservas;
    private String gracReservaJava;
    private String gracNoshow;
    private String gracCheckout;
    private String gracCaracteristica;
    private String gracIdReservaIdReservaApartamento;
    private Long gracIdGds;
    private String gracEmpresaGds;
    private Double gracTotalTarifa;
    
    private Long[] idHoteis;    
    
    /* Campos espelho do banco  bc - banco*/
    
    private Long bcIdReserva;
    private Long bcIdEmpresa;
    private Long bcIdCentralReservas;
    private Long bcIdReservaBloqueio;
    private Long bcIdHotel;
    private Timestamp bcDataEntrada;
    private Timestamp bcDataSaida;
    private Timestamp bcDataReserva;
    private Timestamp bcHoraReserva;
    private Timestamp bcDataConfirmaBloqueio;
    private String bcBloqueio;
    private Long bcDeadLine;
    private String bcCalculaIss;
    private String bcCalculaTaxa;
    private String bcCalculaRoomTax;
    private String bcFormaReserva;
    private String bcContato;
    private Long bcIdCidadeContato;
    private String bcTelefoneContato;
    private String bcFaxContato;
    private String bcEmailContato;
    private String bcObservacao;
    private String bcNomeGrupo;
    private String bcCheckin;
    private String bcTipoPensao;
    private String bcCortesia;
    private String bcGrupo;
    private Double bcValorTotal;
    private String bcApagada;
    private String bcConfirma;
    private String bcFlgAlcoolica;
    private Long bcIdReservaMida;
    private String bcPermuta;
    private Long bcIdCorporate;
    private Long bcIdUsuarioWeb;
    private Long bcIdPermuta;
    private String bcGaranteNoShow;
    private String bcFidelidade;
    private String bcFormaPg;
    private String bcReservaJava;
    private String bcAlterando;
    private Double bcComissao;
    private String bcCalculaSeguro;
    private Double bcValorPensao;    
    private String bcObservacaoVoucher;
    private Long bcIdGds;
    private Long bcIdReservaGds;
    /* Fim Campos espelho do banco */
    
    
    /*Auxiliares para gravacao*/
    private EmpresaHotelVO empresaHotelVO;
    private List<PagamentoReservaVO> listPagamento;
    private List<ReservaApartamentoVO> listReservaApartamento;
    private List<ReservaGrupoLancamentoVO> listReservaGrupoLancamento;
    private List<MovimentoApartamentoEJB> listMovimentoApartamento;
    
    /*Auxliares para calulo*/
    private Double percentualIss;
    private Double percentualRoomTax;
    private Double percentualTaxaServico;
    
    /*Auxliares tela*/
    private Long ocupacaoDisponibilidade;
    
    private String bloqueio;
    
	public void setaDados(Object[] pLinha) {
        
        setLinha(pLinha);                
                
        gracIdReservaApartamento = getLong();
        gracIdApagada = getString();
        gracIdReserva = getLong();        
        gracIdReservaBloqueio = getLong();
        gracIdRoomList = getLong();                    
        gracIdTipoApartamento = getLong();
        gracQtdCriancas = getLong();
        gracAdicional = getLong();
        gracNomeHospede = getString();
        gracDataEntrada = getTimestamp();
        gracDataSaida = getTimestamp();
        gracBloqueio = getString();
        gracQtdePax = getLong();
        gracQtdeApartamento = getLong();
        gracNomeEmpresa = getString();
        gracContato = getString();
        gracConfirmada = getString();
        gracObservacao = getString();                         
        gracFormaReserva = getString();
        gracTelefoneContato = getString();
        gracQtdeCheckin = getLong();            
        gracFantasia = getString();
        gracTipoPensao = getString();
        gracQtdeApartamento = getLong();
        gracTarifa = getDouble();
        gracTipoHospede = getString();
        gracValorTotal  = getDouble(); 
        gracIdEmpresa = getLong(); 
        gracCheckin = getString();      
        gracCheckinSimNao = getString();      
        gracSigla = getString();      
        gracNumApartamento = getString();      
        gracNomeGrupo = getString();      
        gracIdPermuta = getLong();      
        gracDataReserva = getTimestamp();      
        gracCampoWeb = getString();      
        gracNomeCentralReservas  = getString();
        gracReservaJava = getString();      
        gracNoshow  = getString();      
        gracCheckout = getString();      
        gracCaracteristica = getString();                        
        gracIdReservaIdReservaApartamento = getString();
        gracIdGds = getLong();
        gracEmpresaGds = getString();
        gracTotalTarifa = getDouble();
    }
    
    
	public void setaDadosAlteracaoReserva(Object[] pLinha) {
        
        setLinha(pLinha);
        bcIdReserva = getLong();
        bcIdEmpresa = getLong();
        bcIdCentralReservas = getLong();
        bcIdReservaBloqueio = getLong();
        bcIdHotel = getLong();
        bcDataEntrada = getTimestamp();
        bcDataSaida = getTimestamp();
        bcDataReserva = getTimestamp();
        bcHoraReserva = getTimestamp();
        bcDataConfirmaBloqueio = getTimestamp();
        bcBloqueio = getString();
        bcDeadLine = getLong();
        bcCalculaIss = getString();
        bcCalculaTaxa = getString();
        bcCalculaRoomTax = getString();
        bcFormaReserva = getString();
        bcContato = getString();
        bcIdCidadeContato = getLong();
        bcTelefoneContato = getString();
        bcFaxContato = getString();
        bcEmailContato = getString();
        bcObservacao = getString();
        bcNomeGrupo = getString();
        bcCheckin = getString();
        bcTipoPensao = getString();
        bcCortesia = getString();
        bcGrupo = getString();
        bcValorTotal = getDouble();
        bcApagada = getString();
        bcConfirma = getString();
        bcFlgAlcoolica = getString();
        bcIdReservaMida = getLong();
        bcPermuta = getString();
        bcIdCorporate = getLong();
        bcIdUsuarioWeb = getLong();
        bcIdPermuta = getLong();
        bcGaranteNoShow = getString();
        bcFidelidade = getString();
        bcFormaPg = getString();
        bcReservaJava = getString();
        bcAlterando = getString();
        bcComissao = getDouble();
        bcCalculaSeguro = getString();
        bcValorPensao = getDouble();
        bcObservacaoVoucher = getString();
    }
    
    public ReservaVO() {
        dataEntrada = new FiltroWeb();;
        dataSaida = new FiltroWeb();
        nomeHospede = new FiltroWeb();
        contato = new FiltroWeb();
        nomeGrupo = new FiltroWeb();
        dataReserva = new FiltroWeb();
        empresa = new FiltroWeb();
        apagada = new FiltroWeb();
        formaReserva = new FiltroWeb();
        numBloqueio = new FiltroWeb();
        confirmada = new FiltroWeb();
        siglaHotel = new FiltroWeb();
        idReserva = new FiltroWeb();
        apartamento= new FiltroWeb();
        tipoHospede= new FiltroWeb();
        idCrs= new FiltroWeb();
        prazoCancelamento = new FiltroWeb(); 
        reservaTravada = new FiltroWeb();
        empresagds = new FiltroWeb();
        
        
        empresaHotelVO = new EmpresaHotelVO();
        listPagamento = new ArrayList<PagamentoReservaVO>();
        listReservaApartamento = new ArrayList<ReservaApartamentoVO>();
        listReservaGrupoLancamento = new ArrayList<ReservaGrupoLancamentoVO>();
    }
    
    public void setDataEntrada(FiltroWeb dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public FiltroWeb getDataEntrada() {
        return dataEntrada;
    }

    public Long getGracIdGds() {
		return gracIdGds;
	}


	public void setGracIdGds(Long gracIdGds) {
		this.gracIdGds = gracIdGds;
	}


	public void setDataSaida(FiltroWeb dataSaida) {
        this.dataSaida = dataSaida;
    }

    public FiltroWeb getDataSaida() {
        return dataSaida;
    }

    public void setNomeHospede(FiltroWeb nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public FiltroWeb getNomeHospede() {
        return nomeHospede;
    }

    public void setContato(FiltroWeb contato) {
        this.contato = contato;
    }

    public FiltroWeb getContato() {
        return contato;
    }

    public void setNomeGrupo(FiltroWeb nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public FiltroWeb getNomeGrupo() {
        return nomeGrupo;
    }

    public void setDataReserva(FiltroWeb dataReserva) {
        this.dataReserva = dataReserva;
    }

    public FiltroWeb getDataReserva() {
        return dataReserva;
    }

    public void setEmpresa(FiltroWeb empresa) {
        this.empresa = empresa;
    }

    public FiltroWeb getEmpresa() {
        return empresa;
    }

    public void setApagada(FiltroWeb apagada) {
        this.apagada = apagada;
    }

    public FiltroWeb getApagada() {
        return apagada;
    }

    public void setFormaReserva(FiltroWeb formaReserva) {
        this.formaReserva = formaReserva;
    }

    public FiltroWeb getFormaReserva() {
        return formaReserva;
    }

    public void setNumBloqueio(FiltroWeb numBloqueio) {
        this.numBloqueio = numBloqueio;
    }

    public FiltroWeb getNumBloqueio() {
        return numBloqueio;
    }

    public void setConfirmada(FiltroWeb confirmada) {
        this.confirmada = confirmada;
    }

    public FiltroWeb getConfirmada() {
        return confirmada;
    }

    public void setSiglaHotel(FiltroWeb siglaHotel) {
        this.siglaHotel = siglaHotel;
    }

    public FiltroWeb getSiglaHotel() {
        return siglaHotel;
    }

    public void setIdReserva(FiltroWeb idReserva) {
        this.idReserva = idReserva;
    }

    public FiltroWeb getIdReserva() {
        return idReserva;
    }

    public void setApartamento(FiltroWeb apartamento) {
        this.apartamento = apartamento;
    }

    public FiltroWeb getApartamento() {
        return apartamento;
    }

    public void setTipoHospede(FiltroWeb tipoHospede) {
        this.tipoHospede = tipoHospede;
    }

    public FiltroWeb getTipoHospede() {
        return tipoHospede;
    }

    public void setIdHoteis(Long[] idHoteis) {
        this.idHoteis = idHoteis;
    }

    public Long[] getIdHoteis() {
        return idHoteis;
    }

    public void setGracIdReservaApartamento(Long gracIdReservaApartamento) {
        this.gracIdReservaApartamento = gracIdReservaApartamento;
    }

    public Long getGracIdReservaApartamento() {
        return gracIdReservaApartamento;
    }

    public void setGracIdApagada(String gracIdApagada) {
        this.gracIdApagada = gracIdApagada;
    }

    public String getGracIdApagada() {
        return gracIdApagada;
    }

    public void setGracIdReserva(Long gracIdReserva) {
        this.gracIdReserva = gracIdReserva;
    }

    public Long getGracIdReserva() {
        return gracIdReserva;
    }

    public void setGracIdReservaBloqueio(Long gracIdReservaBloqueio) {
        this.gracIdReservaBloqueio = gracIdReservaBloqueio;
    }

    public Long getGracIdReservaBloqueio() {
        return gracIdReservaBloqueio;
    }

    public void setGracIdRoomList(Long gracIdRoomList) {
        this.gracIdRoomList = gracIdRoomList;
    }

    public Long getGracIdRoomList() {
        return gracIdRoomList;
    }

    public void setGracIdTipoApartamento(Long gracIdTipoApartamento) {
        this.gracIdTipoApartamento = gracIdTipoApartamento;
    }

    public Long getGracIdTipoApartamento() {
        return gracIdTipoApartamento;
    }

    public void setGracQtdCriancas(Long gracQtdCriancas) {
        this.gracQtdCriancas = gracQtdCriancas;
    }

    public Long getGracQtdCriancas() {
        return gracQtdCriancas;
    }

    public void setGracAdicional(Long gracAdicional) {
        this.gracAdicional = gracAdicional;
    }

    public Long getGracAdicional() {
        return gracAdicional;
    }

    public void setGracNomeHospede(String gracNomeHospede) {
        this.gracNomeHospede = gracNomeHospede;
    }

    public String getGracNomeHospede() {
        return gracNomeHospede;
    }

    public void setGracDataEntrada(Timestamp gracDataEntrada) {
        this.gracDataEntrada = gracDataEntrada;
    }

    public Timestamp getGracDataEntrada() {
        return gracDataEntrada;
    }

    public void setGracDataSaida(Timestamp gracDataSaida) {
        this.gracDataSaida = gracDataSaida;
    }

    public Timestamp getGracDataSaida() {
        return gracDataSaida;
    }

    public void setGracBloqueio(String gracBloqueio) {
        this.gracBloqueio = gracBloqueio;
    }

    public String getGracBloqueio() {
        return gracBloqueio;
    }

    public void setGracQtdePax(Long gracQtdePax) {
        this.gracQtdePax = gracQtdePax;
    }

    public Long getGracQtdePax() {
        return gracQtdePax;
    }

    public void setGracQtdeApartamento(Long gracQtdeApartamento) {
        this.gracQtdeApartamento = gracQtdeApartamento;
    }

    public Long getGracQtdeApartamento() {
        return gracQtdeApartamento;
    }

    public void setGracNomeEmpresa(String gracNomeEmpresa) {
        this.gracNomeEmpresa = gracNomeEmpresa;
    }

    public String getGracNomeEmpresa() {
        return gracNomeEmpresa;
    }

    public void setGracContato(String gracContato) {
        this.gracContato = gracContato;
    }

    public String getGracContato() {
        return gracContato;
    }

    public void setGracConfirmada(String gracConfirmada) {
        this.gracConfirmada = gracConfirmada;
    }

    public String getGracConfirmada() {
        return gracConfirmada;
    }

    public void setGracObservacao(String gracObservacao) {
        this.gracObservacao = gracObservacao;
    }

    public String getGracObservacao() {
        return gracObservacao;
    }

    public void setGracFormaReserva(String gracFormaReserva) {
        this.gracFormaReserva = gracFormaReserva;
    }

    public String getGracFormaReserva() {
        return gracFormaReserva;
    }

    public void setGracTelefoneContato(String gracTelefoneContato) {
        this.gracTelefoneContato = gracTelefoneContato;
    }

    public String getGracTelefoneContato() {
        return gracTelefoneContato;
    }

    public void setGracQtdeCheckin(Long gracQtdeCheckin) {
        this.gracQtdeCheckin = gracQtdeCheckin;
    }

    public Long getGracQtdeCheckin() {
        return gracQtdeCheckin;
    }

    public void setGracFantasia(String gracFantasia) {
        this.gracFantasia = gracFantasia;
    }

    public String getGracFantasia() {
        return gracFantasia;
    }

    public void setGracTipoPensao(String gracTipoPensao) {
        this.gracTipoPensao = gracTipoPensao;
    }

    public String getGracTipoPensao() {
        return gracTipoPensao;
    }

    public void setGracTarifa(Double gracTarifa) {
        this.gracTarifa = gracTarifa;
    }

    public Double getGracTarifa() {
        return gracTarifa;
    }

    public void setGracTipoHospede(String gracTipoHospede) {
        this.gracTipoHospede = gracTipoHospede;
    }

    public String getGracTipoHospede() {
        return gracTipoHospede;
    }

    public void setGracValorTotal(Double gracValorTotal) {
        this.gracValorTotal = gracValorTotal;
    }

    public Double getGracValorTotal() {
        return gracValorTotal;
    }

    public void setGracIdEmpresa(Long gracIdEmpresa) {
        this.gracIdEmpresa = gracIdEmpresa;
    }

    public Long getGracIdEmpresa() {
        return gracIdEmpresa;
    }

    public void setGracCheckin(String gracCheckin) {
        this.gracCheckin = gracCheckin;
    }

    public String getGracCheckin() {
        return gracCheckin;
    }

    public void setGracCheckinSimNao(String gracCheckinSimNao) {
        this.gracCheckinSimNao = gracCheckinSimNao;
    }

    public String getGracCheckinSimNao() {
        return gracCheckinSimNao;
    }

    public void setGracSigla(String gracSigla) {
        this.gracSigla = gracSigla;
    }

    public String getGracSigla() {
        return gracSigla;
    }

    public void setGracNumApartamento(String gracNumApartamento) {
        this.gracNumApartamento = gracNumApartamento;
    }

    public String getGracNumApartamento() {
        return gracNumApartamento;
    }

    public void setGracIdPermuta(Long gracIdPermuta) {
        this.gracIdPermuta = gracIdPermuta;
    }

    public Long getGracIdPermuta() {
        return gracIdPermuta;
    }

    public void setGracNomeGrupo(String gracNomeGrupo) {
        this.gracNomeGrupo = gracNomeGrupo;
    }

    public String getGracNomeGrupo() {
        return gracNomeGrupo;
    }

    public void setGracDataReserva(Timestamp gracDataReserva) {
        this.gracDataReserva = gracDataReserva;
    }

    public Timestamp getGracDataReserva() {
        return gracDataReserva;
    }

    public void setGracCampoWeb(String gracCampoWeb) {
        this.gracCampoWeb = gracCampoWeb;
    }

    public String getGracCampoWeb() {
        return gracCampoWeb;
    }

    public void setGracNomeCentralReservas(String gracNomeCentralReservas) {
        this.gracNomeCentralReservas = gracNomeCentralReservas;
    }

    public String getGracNomeCentralReservas() {
        return gracNomeCentralReservas;
    }

    public void setGracReservaJava(String gracReservaJava) {
        this.gracReservaJava = gracReservaJava;
    }

    public String getGracReservaJava() {
        return gracReservaJava;
    }

    public void setGracNoshow(String gracNoshow) {
        this.gracNoshow = gracNoshow;
    }

    public String getGracNoshow() {
        return gracNoshow;
    }

    public void setGracCheckout(String gracCheckout) {
        this.gracCheckout = gracCheckout;
    }

    public String getGracCheckout() {
        return gracCheckout;
    }

    public void setGracCaracteristica(String gracCaracteristica) {
        this.gracCaracteristica = gracCaracteristica;
    }

    public String getGracCaracteristica() {
        return gracCaracteristica;
    }

    public void setGracIdReservaIdReservaApartamento(String gracIdReservaIdReservaApartamento) {
        this.gracIdReservaIdReservaApartamento = gracIdReservaIdReservaApartamento;
    }

    public String getGracIdReservaIdReservaApartamento() {
        return gracIdReservaIdReservaApartamento;//gracIdReserva+"#"+gracIdReservaApartamento ;
    }

    public String get_gracIdReservaIdReservaApartamento() {
        return gracIdReservaIdReservaApartamento;
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

    public void setBcIdCentralReservas(Long bcIdCentralReservas) {
        this.bcIdCentralReservas = bcIdCentralReservas;
    }

    public Long getBcIdCentralReservas() {
        return bcIdCentralReservas;
    }

    public void setBcIdReservaBloqueio(Long bcIdReservaBloqueio) {
        this.bcIdReservaBloqueio = bcIdReservaBloqueio;
    }

    public Long getBcIdReservaBloqueio() {
        return bcIdReservaBloqueio;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
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

    public void setBcDataReserva(Timestamp bcDataReserva) {
        this.bcDataReserva = bcDataReserva;
    }

    public Timestamp getBcDataReserva() {
        return bcDataReserva;
    }

    public void setBcHoraReserva(Timestamp bcHoraReserva) {
        this.bcHoraReserva = bcHoraReserva;
    }

    public Timestamp getBcHoraReserva() {
        return bcHoraReserva;
    }

    public void setBcDataConfirmaBloqueio(Timestamp bcDataConfirmaBloqueio) {
        this.bcDataConfirmaBloqueio = bcDataConfirmaBloqueio;
    }

    public Timestamp getBcDataConfirmaBloqueio() {
        return bcDataConfirmaBloqueio;
    }

    public void setBcBloqueio(String bcBloqueio) {
        this.bcBloqueio = bcBloqueio;
    }

    public String getBcBloqueio() {
        return bcBloqueio;
    }

    public void setBcDeadLine(Long bcDeadLine) {
        this.bcDeadLine = bcDeadLine;
    }

    public Long getBcDeadLine() {
        return bcDeadLine;
    }

    public void setBcCalculaIss(String bcCalculaIss) {
        this.bcCalculaIss = bcCalculaIss;
    }

    public String getBcCalculaIss() {
        return bcCalculaIss;
    }

    public void setBcCalculaTaxa(String bcCalculaTaxa) {
        this.bcCalculaTaxa = bcCalculaTaxa;
    }

    public String getBcCalculaTaxa() {
        return bcCalculaTaxa;
    }

    public void setBcCalculaRoomTax(String bcCalculaRoomTax) {
        this.bcCalculaRoomTax = bcCalculaRoomTax;
    }

    public String getBcCalculaRoomTax() {
        return bcCalculaRoomTax;
    }

    public void setBcFormaReserva(String bcFormaReserva) {
        this.bcFormaReserva = bcFormaReserva;
    }

    public String getBcFormaReserva() {
        return bcFormaReserva;
    }

    public void setBcContato(String bcContato) {
        this.bcContato = bcContato;
    }

    public String getBcContato() {
        return bcContato;
    }

    public void setBcIdCidadeContato(Long bcIdCidadeContato) {
        this.bcIdCidadeContato = bcIdCidadeContato;
    }

    public Long getBcIdCidadeContato() {
        return bcIdCidadeContato;
    }

    public void setBcTelefoneContato(String bcTelefoneContato) {
        this.bcTelefoneContato = bcTelefoneContato;
    }

    public String getBcTelefoneContato() {
        return bcTelefoneContato;
    }

    public void setBcFaxContato(String bcFaxContato) {
        this.bcFaxContato = bcFaxContato;
    }

    public String getBcFaxContato() {
        return bcFaxContato;
    }

    public void setBcEmailContato(String bcEmailContato) {
        this.bcEmailContato = bcEmailContato;
    }

    public String getBcEmailContato() {
        return bcEmailContato;
    }

    public void setBcObservacao(String bcObservacao) {
        this.bcObservacao = bcObservacao;
    }

    public String getBcObservacao() {
        return bcObservacao;
    }

    public void setBcNomeGrupo(String bcNomeGrupo) {
        this.bcNomeGrupo = bcNomeGrupo;
    }

    public String getBcNomeGrupo() {
        return bcNomeGrupo;
    }

    public void setBcCheckin(String bcCheckin) {
        this.bcCheckin = bcCheckin;
    }

    public String getBcCheckin() {
        return bcCheckin;
    }

    public void setBcTipoPensao(String bcTipoPensao) {
        this.bcTipoPensao = bcTipoPensao;
    }

    public String getBcTipoPensao() {
        return bcTipoPensao;
    }

    public void setBcCortesia(String bcCortesia) {
        this.bcCortesia = bcCortesia;
    }

    public String getBcCortesia() {
        return bcCortesia;
    }

    public void setBcGrupo(String bcGrupo) {
        this.bcGrupo = bcGrupo;
    }

    public String getBcGrupo() {
        return bcGrupo;
    }

    public void setBcValorTotal(Double bcValorTotal) {
        this.bcValorTotal = bcValorTotal;
    }

    public Double getBcValorTotal() {
        return bcValorTotal;
    }

    public void setBcApagada(String bcApagada) {
        this.bcApagada = bcApagada;
    }

    public String getBcApagada() {
        return bcApagada;
    }

    public void setBcConfirma(String bcConfirma) {
        this.bcConfirma = bcConfirma;
    }

    public String getBcConfirma() {
        return bcConfirma;
    }

    public void setBcFlgAlcoolica(String bcFlgAlcoolica) {
        this.bcFlgAlcoolica = bcFlgAlcoolica;
    }

    public String getBcFlgAlcoolica() {
        return bcFlgAlcoolica;
    }

    public void setBcIdReservaMida(Long bcIdReservaMida) {
        this.bcIdReservaMida = bcIdReservaMida;
    }

    public Long getBcIdReservaMida() {
        return bcIdReservaMida;
    }

    public void setBcPermuta(String bcPermuta) {
        this.bcPermuta = bcPermuta;
    }

    public String getBcPermuta() {
        return bcPermuta;
    }

    public void setBcIdCorporate(Long bcIdCorporate) {
        this.bcIdCorporate = bcIdCorporate;
    }

    public Long getBcIdCorporate() {
        return bcIdCorporate;
    }

    public void setBcIdUsuarioWeb(Long bcIdUsuarioWeb) {
        this.bcIdUsuarioWeb = bcIdUsuarioWeb;
    }

    public Long getBcIdUsuarioWeb() {
        return bcIdUsuarioWeb;
    }

    public void setBcIdPermuta(Long bcIdPermuta) {
        this.bcIdPermuta = bcIdPermuta;
    }

    public Long getBcIdPermuta() {
        return bcIdPermuta;
    }

    public void setBcGaranteNoShow(String bcGaranteNoShow) {
        this.bcGaranteNoShow = bcGaranteNoShow;
    }

    public String getBcGaranteNoShow() {
        return bcGaranteNoShow;
    }

    public void setBcFidelidade(String bcFidelidade) {
        this.bcFidelidade = bcFidelidade;
    }

    public String getBcFidelidade() {
        return bcFidelidade;
    }

    public void setBcFormaPg(String bcFormaPg) {
        this.bcFormaPg = bcFormaPg;
    }

    public String getBcFormaPg() {
        return bcFormaPg;
    }

    public void setBcReservaJava(String bcReservaJava) {
        this.bcReservaJava = bcReservaJava;
    }

    public String getBcReservaJava() {
        return bcReservaJava;
    }

    public void setBcAlterando(String bcAlterando) {
        this.bcAlterando = bcAlterando;
    }

    public String getBcAlterando() {
        return bcAlterando;
    }

    public void setBcComissao(Double bcComissao) {
        this.bcComissao = bcComissao;
    }

    public Double getBcComissao() {
        return bcComissao;
    }

    public void setBcCalculaSeguro(String bcCalculaSeguro) {
        this.bcCalculaSeguro = bcCalculaSeguro;
    }

    public String getBcCalculaSeguro() {
        return bcCalculaSeguro;
    }

    public void setBcValorPensao(Double bcValorPensao) {
        this.bcValorPensao = bcValorPensao;
    }

    public Double getBcValorPensao() {
        return bcValorPensao;
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

	public FiltroWeb getIdCrs() {
		return idCrs;
	}


	public void setIdCrs(FiltroWeb idCrs) {
		this.idCrs = idCrs;
	}


	public FiltroWeb getPrazoCancelamento() {
		return prazoCancelamento;
	}


	public void setPrazoCancelamento(FiltroWeb prazoCancelamento) {
		this.prazoCancelamento = prazoCancelamento;
	}


	public FiltroWeb getReservaTravada() {
		return reservaTravada;
	}


	public void setReservaTravada(FiltroWeb reservaTravada) {
		this.reservaTravada = reservaTravada;
	}


	public String getBcObservacaoVoucher() {
		return bcObservacaoVoucher;
	}


	public void setBcObservacaoVoucher(String bcObservacaoVoucher) {
		this.bcObservacaoVoucher = bcObservacaoVoucher;
	}

	public String getBloqueio() {
		return bloqueio;
	}
	
	public void setBloqueio(String bloqueio) {
		this.bloqueio = bloqueio;
	}


	public FiltroWeb getIdGds() {
		return idGds;
	}


	public void setIdGds(FiltroWeb idGds) {
		this.idGds = idGds;
	}


	public Long getBcIdGds() {
		return bcIdGds;
	}


	public void setBcIdGds(Long bcIdGds) {
		this.bcIdGds = bcIdGds;
	}
	
	public Long getBcIdReservaGds() {
		return bcIdReservaGds;
	}

	public void setBcIdReservaGds(Long bcIdReservaGds) {
		this.bcIdReservaGds = bcIdReservaGds;
	}
	
	public FiltroWeb getEmpresagds() {
		return empresagds;
	}


	public void setEmpresagds(FiltroWeb empresagds) {
		this.empresagds = empresagds;
	}
	
	public String getGracEmpresaGds() {
		return gracEmpresaGds;
	}


	public void setGracEmpresaGds(String gracEmpresaGds) {
		this.gracEmpresaGds = gracEmpresaGds;
	}


	public List<MovimentoApartamentoEJB> getListMovimentoApartamento() {
		return listMovimentoApartamento;
	}


	public void setListMovimentoApartamento(
			List<MovimentoApartamentoEJB> listMovimentoApartamento) {
		this.listMovimentoApartamento = listMovimentoApartamento;
	}
	
	public Double getGracTotalTarifa() {
		return gracTotalTarifa;
	}

	public void setGracTotalTarifa(Double gracTotalTarifa) {
		this.gracTotalTarifa = gracTotalTarifa;
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

	
}