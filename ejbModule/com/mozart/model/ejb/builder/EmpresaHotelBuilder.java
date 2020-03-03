package com.mozart.model.ejb.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mozart.model.ejb.entity.EmpresaGrupoLancamentoEJB;
import com.mozart.model.ejb.entity.EmpresaHotelEJB;
import com.mozart.model.ejb.entity.EmpresaRedeEJB;
import com.mozart.model.ejb.entity.EmpresaTarifaEJB;

public class EmpresaHotelBuilder {
	private Long idEmpresa;
	private Long idHotel;
	private String acredito;
	private String calculaIss = "N";
	private String calculaRoomtax = "N";
	private String calculaSeguro;
	private String calculaTaxa = "N";
	private Double comissao;
	private Long contaCorrente;
	private Double desconto;
	private Long idPromotor;
	private Long idTipoEmpresa;
	private String issRetencao = "N";
	private String nomeFantasia;
	private Long prazoPagamento = 10l;
	private String tipoEmpresa;
	private String tipoPensao = "NAO";
	private Double valorCredito;
	private Long idCorporate;
	private List<EmpresaGrupoLancamentoEJB> empresaGrupoLancamentoEJBList;
	private List<EmpresaTarifaEJB> empresaTarifaEJBList;
	private EmpresaRedeEJB empresaRedeEJB;

	public EmpresaHotelEJB build() {
		empresaGrupoLancamentoEJBList = new ArrayList<EmpresaGrupoLancamentoEJB>();
		empresaTarifaEJBList = new ArrayList<EmpresaTarifaEJB>();
		EmpresaHotelEJB retorno = new EmpresaHotelEJB();
		
		retorno.setIdEmpresa(idEmpresa);
		retorno.setIdHotel(idHotel);
		retorno.setAcredito(acredito);
		retorno.setCalculaIss(calculaIss);
		retorno.setCalculaRoomtax(calculaRoomtax);
		retorno.setCalculaSeguro(calculaSeguro);
		retorno.setCalculaTaxa(calculaTaxa);
		retorno.setComissao(comissao);
		retorno.setContaCorrente(contaCorrente);
		retorno.setDesconto(desconto);
		retorno.setIdPromotor(idPromotor);
		retorno.setIdTipoEmpresa(idTipoEmpresa);
		retorno.setIssRetencao(issRetencao);
		retorno.setNomeFantasia(nomeFantasia);
		retorno.setPrazoPagamento(prazoPagamento);
		retorno.setTipoEmpresa(tipoEmpresa);
		retorno.setTipoPensao(tipoPensao);
		retorno.setValorCredito(valorCredito);
		retorno.setIdCorporate(idCorporate);
		retorno.setEmpresaGrupoLancamentoEJBList(empresaGrupoLancamentoEJBList);
		retorno.setEmpresaTarifaEJBList(empresaTarifaEJBList);
		retorno.setEmpresaRedeEJB(empresaRedeEJB);
		

		return retorno;
	}

	public EmpresaHotelBuilder idEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
		return this;
	}

	public EmpresaHotelBuilder idHotel(Long idHotel) {
		this.idHotel = idHotel;
		return this;
	}

	public EmpresaHotelBuilder acredito(String acredito) {
		this.acredito = acredito;
		return this;
	}

	public EmpresaHotelBuilder calculaIss(String calculaIss) {
		this.calculaIss = calculaIss;
		return this;
	}

	public EmpresaHotelBuilder calculaRoomtax(String calculaRoomtax) {
		this.calculaRoomtax = calculaRoomtax;
		return this;
	}

	public EmpresaHotelBuilder calculaSeguro(String calculaSeguro) {
		this.calculaSeguro = calculaSeguro;
		return this;
	}

	public EmpresaHotelBuilder calculaTaxa(String calculaTaxa) {
		this.calculaTaxa = calculaTaxa;
		return this;
	}

	public EmpresaHotelBuilder comissao(Double comissao) {
		this.comissao = comissao;
		return this;
	}

	public EmpresaHotelBuilder contaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}

	public EmpresaHotelBuilder desconto(Double desconto) {
		this.desconto = desconto;
		return this;
	}

	public EmpresaHotelBuilder idPromotor(Long idPromotor) {
		this.idPromotor = idPromotor;
		return this;
	}

	public EmpresaHotelBuilder idTipoEmpresa(Long idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
		return this;
	}

	public EmpresaHotelBuilder issRetencao(String issRetencao) {
		this.issRetencao = issRetencao;
		return this;
	}

	public EmpresaHotelBuilder nomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
		return this;
	}

	public EmpresaHotelBuilder prazoPagamento(Long prazoPagamento) {
		this.prazoPagamento = prazoPagamento;
		return this;
	}

	public EmpresaHotelBuilder tipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
		return this;
	}

	public EmpresaHotelBuilder tipoPensao(String tipoPensao) {
		this.tipoPensao = tipoPensao;
		return this;
	}

	public EmpresaHotelBuilder valorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
		return this;
	}

	public EmpresaHotelBuilder idCorporate(Long idCorporate) {
		this.idCorporate = idCorporate;
		return this;
	}

	public EmpresaHotelBuilder empresaGrupoLancamentoEJBList(
			List<EmpresaGrupoLancamentoEJB> empresaGrupoLancamentoEJBList) {
		this.empresaGrupoLancamentoEJBList = empresaGrupoLancamentoEJBList;
		return this;
	}

	public EmpresaHotelBuilder empresaTarifaEJBList(List<EmpresaTarifaEJB> empresaTarifaEJBList) {
		this.empresaTarifaEJBList = empresaTarifaEJBList;
		return this;
	}

	public EmpresaHotelBuilder empresaRedeEJB(EmpresaRedeEJB empresaRedeEJB) {
		this.empresaRedeEJB = empresaRedeEJB;
		return this;
	}

}
