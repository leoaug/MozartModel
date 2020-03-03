package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.filtro.FiltroWeb;

public class ApartamentoHospedeVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6056974516655424899L;

	private FiltroWeb filtroNome;
	private FiltroWeb filtroSobrenome;
	private FiltroWeb filtroPrincipal;

	private Long idHotel;
	private Long idCheckin;
	private Long idApartamento;
	private String numApartamento;
	private String bcNomeHospede;
	private String bcSobrenomeHospede;
	private String bcPrincipal;
	private Long bcIdRoomList;

	public void setaDados(Object[] pLinha) {
		setLinha(pLinha);
		numApartamento = getString();
		bcNomeHospede = getString();
		bcSobrenomeHospede = getString();
	}

	public ApartamentoHospedeVO() {
	}

	public ApartamentoHospedeVO(Object[] pLinha) {
		setLinha(pLinha);
		numApartamento = getString();
		bcNomeHospede = getString();
		bcSobrenomeHospede = getString();
		idCheckin = getLong();
		idApartamento = getLong();
		bcPrincipal = getString();
		bcIdRoomList = getLong();
	}

	public String getTexto() {
		StringBuilder s = new StringBuilder();
		s.append(MozartUtil.isNull(numApartamento) ? "" : numApartamento
				+ " - ");
		s.append(MozartUtil.isNull(bcPrincipal) ? "" : "(" + bcPrincipal
				+ ") - ");
		s.append(MozartUtil.isNull(bcNomeHospede) ? "" : bcNomeHospede + " ");
		s.append(MozartUtil.isNull(bcSobrenomeHospede) ? ""
				: bcSobrenomeHospede + " ");

		return s.toString();
	}

	public String getNumApartamento() {
		return numApartamento;
	}

	public void setNumApartamento(String numApartamento) {
		this.numApartamento = numApartamento;
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

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdCheckin() {
		return idCheckin;
	}

	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}

	public String getBcPrincipal() {
		return bcPrincipal;
	}

	public void setBcPrincipal(String bcPrincipal) {
		this.bcPrincipal = bcPrincipal;
	}

	public Long getIdApartamento() {
		return idApartamento;
	}

	public void setIdApartamento(Long idApartamento) {
		this.idApartamento = idApartamento;
	}

	public FiltroWeb getFiltroPrincipal() {
		return filtroPrincipal;
	}

	public void setFiltroPrincipal(FiltroWeb filtroPrincipal) {
		this.filtroPrincipal = filtroPrincipal;
	}

	public Long getBcIdRoomList() {
		return bcIdRoomList;
	}

	public void setBcIdRoomList(Long bcIdRoomList) {
		this.bcIdRoomList = bcIdRoomList;
	}
	
	

}
