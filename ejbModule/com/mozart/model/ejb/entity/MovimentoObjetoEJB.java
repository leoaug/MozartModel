package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@NamedQuery(name = "MovimentoObjetoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from MovimentoObjetoEJB o")
@Table(name = "MOVIMENTO_OBJETO")
public class MovimentoObjetoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -6331378621805242585L;
	
	@Column(nullable = false)
    private Timestamp data;
    @Column(name="ID_CHECKIN", nullable = false)
    private Long idCheckin;
    @Column(name="ID_HOTEL")
    private Long idHotel;
    @Column(name="ID_MOVIMENTO_APARTAMENTO")
    private Long idMovimentoApartamento;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqObj")
    @SequenceGenerator(name="idSeqObj", sequenceName="id", allocationSize=1)
    @Column(name="ID_MOVIMENTO_OBJETO", nullable = false)
    private Long idMovimentoObjeto;
    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_ROOM_LIST", referencedColumnName = "ID_ROOM_LIST")
    private RoomListEJB roomListEJB;
    private String observacao;
    private Long qtde;
    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_OBJETO", referencedColumnName = "ID_OBJETO")
    private ObjetoEJB objetoEJB;

    public MovimentoObjetoEJB() {
    }


    public boolean equals(Object obj){
        
        if (obj == null || idMovimentoObjeto == null)
            return false;
            
        return  idMovimentoObjeto.equals( ((MovimentoObjetoEJB)obj).getIdMovimentoObjeto());    
    }
    
    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public Long getIdCheckin() {
        return idCheckin;
    }

    public void setIdCheckin(Long idCheckin) {
        this.idCheckin = idCheckin;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdMovimentoApartamento() {
        return idMovimentoApartamento;
    }

    public void setIdMovimentoApartamento(Long idMovimentoApartamento) {
        this.idMovimentoApartamento = idMovimentoApartamento;
    }

    public Long getIdMovimentoObjeto() {
        return idMovimentoObjeto;
    }

    public void setIdMovimentoObjeto(Long idMovimentoObjeto) {
        this.idMovimentoObjeto = idMovimentoObjeto;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getQtde() {
        return qtde;
    }

    public void setQtde(Long qtde) {
        this.qtde = qtde;
    }

    public ObjetoEJB getObjetoEJB() {
        return objetoEJB;
    }

    public void setObjetoEJB(ObjetoEJB objetoEJB) {
        this.objetoEJB = objetoEJB;
    }

    public void setRoomListEJB(RoomListEJB roomListEJB) {
        this.roomListEJB = roomListEJB;
    }

    public RoomListEJB getRoomListEJB() {
        return roomListEJB;
    }

}
