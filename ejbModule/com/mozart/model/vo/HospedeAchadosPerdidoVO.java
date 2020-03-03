package com.mozart.model.vo;




public class HospedeAchadosPerdidoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long   idHotel;
	private Long   idHospede;
	private Long   idRoomList;
	private String numApartamento;
	private Long   idCheckin;
	private String nomeHospede;
	private String celular;
	
	
		
	public HospedeAchadosPerdidoVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idHotel = getLong();
			idHospede = getLong();
			idRoomList = getLong();
			numApartamento = getString();
			idCheckin = getLong();
			nomeHospede = getString();
			celular = getString();
			
			
		
		}
		
	}



	public HospedeAchadosPerdidoVO() {

		
	}



	public Long getIdHospede() {
		return idHospede;
	}



	public void setIdHospede(Long idHospede) {
		this.idHospede = idHospede;
	}



	public Long getIdRoomList() {
		return idRoomList;
	}



	public void setIdRoomList(Long idRoomList) {
		this.idRoomList = idRoomList;
	}



	public String getNumApartamento() {
		return numApartamento;
	}



	public void setNumApartamento(String numApartamento) {
		this.numApartamento = numApartamento;
	}



	public Long getIdCheckin() {
		return idCheckin;
	}



	public void setIdCheckin(Long idCheckin) {
		this.idCheckin = idCheckin;
	}



	public String getNomeHospede() {
		return nomeHospede;
	}



	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}



	public String getCelular() {
		return celular;
	}



	public void setCelular(String celular) {
		this.celular = celular;
	}



	public Long getIdHotel() {
		return idHotel;
	}



	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
