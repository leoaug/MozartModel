package com.mozart.model.ejb.entity;

import com.mozart.model.helper.MenuHelper;
import com.mozart.model.util.MozartUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.QueryHint;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
		@NamedQuery(name = "UsuarioEJB.findAll", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE"), query = "select o from UsuarioEJB o"),
		@NamedQuery(name = "UsuarioEJB.findByNick", query = "select o from UsuarioEJB o where o.nick=?1 and o.senha=?2", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE")),
		@NamedQuery(name = "UsuarioEJB.findByHotel", query = "select o from UsuarioEJB o where o.hotelEJB.idHotel=?1 and o.ativo = 'S' order by o.nome", hints = @QueryHint(name = "eclipselink.refresh", value = "TRUE")) })
@Table(name = "USUARIO")
public class UsuarioEJB extends MozartEntity {
	@Column(name = "ALTERAR_SENHA")
	private String alterarSenha;
	@Column(nullable = false)
	private String ativo;
	@Column(name = "DATA_VALIDADE", nullable = false)
	private Timestamp dataValidade;
	@Column(name = "DOWNLOAD_SISTEMA")
	private String downloadSistema;
	private String email;
	@Column(name = "EMAIL_MESSENGER")
	private String emailMessenger;
	private String funcao;
	private String genero;
	@Id
	@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	@Column(name = "ID_USUARIO", nullable = false)
	private Long idUsuario;
	@Column(nullable = false)
	private String nick;
	@Column(nullable = false)
	private Long nivel;
	private String nome;
	private String senha;
	@Column(name = "SETOR_DEPARTAMENTO")
	private String setorDepartamento;
	@Column(name = "TELEFONE_HOTEL")
	private String telefoneHotel;
	@Column(name = "TELEFONE_HOTEL_RAMAL")
	private String telefoneHotelRamal;
	@Column(name = "TELEFONE_MOVEL")
	private String telefoneMovel;
	@Column(name = "TIPO_USUARIO")
	private String tipoUsuario;
	@Column(name = "TURNO")
	private String turno;
	
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="ARQUIVO_IMAGEM", length=4000)
	private byte[] fotografia;
	
	@Column(name="ARQUIVO_NOME")
	private String nomeFotografia;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "ID_HOTEL")
	private com.mozart.model.ejb.entity.HotelEJB hotelEJB;

	@OneToOne(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_REDE_HOTEL")
	private RedeHotelEJB redeHotelEJB;

	@OneToMany(mappedBy = "usuarioEJB", fetch = FetchType.LAZY, cascade = {
			CascadeType.REFRESH, CascadeType.PERSIST })
	private List<MenuMozartWebUsuarioEJB> menuMozartWebUsuarioEJBList;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ID_CENTRAL_RESERVAS")
	private CentralReservaEJB crsEJB;

	public UsuarioEJB() {
	}

	public String toString() {
		return nome
				+ " - ["
				+ nick.substring(7)
				+ "]["
				+ (crsEJB != null ? "CRS" : redeHotelEJB != null ? "REDE"
						: "UND") + "]";
	}

	@Transient
	private String menustr = null;
	@Transient
	private List<MenuMozartWebEJB> menuIcone;

	public String getPrintMenu(List<Long> idProgramas) {
			menuIcone = new ArrayList<MenuMozartWebEJB>();
			List<MenuHelper> menus = new ArrayList<MenuHelper>();
			menus.add(MenuHelper.INICIO);
			MenuHelper menu = null;
			for (MenuMozartWebUsuarioEJB item : menuMozartWebUsuarioEJBList) {
				MenuMozartWebEJB itemMenu = item.getMenuMozartWebEJB();
				if ( (!MozartUtil.isNull(idProgramas)) && idProgramas.contains(itemMenu.getIdPrograma())) {
					menu = new MenuHelper(itemMenu.getNumOrdem().toString());
					if (menus.contains(menu)) {
						menu = menus.get(menus.indexOf(menu));
					} else {
						menus.add(menu);
					}

					if ("M".equals(itemMenu.getTipoMenu())) {
						menu.getMenuItem().add(itemMenu);
					} else {
						menuIcone.add(itemMenu);
					}
				}
			}

			StringBuilder result = new StringBuilder();
			for (MenuHelper m : menus) {
				result.append(m);
			}
			menustr = result.toString();

		return menustr;
	}

	public String getPrintMenu() {
		if (menustr == null) {
			menuIcone = new ArrayList<MenuMozartWebEJB>();
			List<MenuHelper> menus = new ArrayList<MenuHelper>();
			menus.add(MenuHelper.INICIO);
			MenuHelper menu = null;
			for (MenuMozartWebUsuarioEJB item : menuMozartWebUsuarioEJBList) {
				MenuMozartWebEJB itemMenu = item.getMenuMozartWebEJB();
				menu = new MenuHelper(itemMenu.getNumOrdem().toString());
				if (menus.contains(menu)) {
					menu = menus.get(menus.indexOf(menu));
				} else {
					menus.add(menu);
				}

				if ("M".equals(itemMenu.getTipoMenu())) {
					menu.getMenuItem().add(itemMenu);
				} else {
					menuIcone.add(itemMenu);
				}
			}

			StringBuilder result = new StringBuilder();
			for (MenuHelper m : menus) {
				result.append(m);
			}
			menustr = result.toString();
		}

		return menustr;
	}

	public boolean equals(Object other) {
		if (other instanceof UsuarioEJB) {
			final UsuarioEJB otherUsuario = (UsuarioEJB) other;
			final boolean areEqual = (otherUsuario.getIdUsuario()
					.equals(idUsuario));
			return areEqual;
		}
		return false;
	}

	public String getAlterarSenha() {
		return alterarSenha;
	}

	public void setAlterarSenha(String alterarSenha) {
		this.alterarSenha = alterarSenha;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Timestamp getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Timestamp dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getDownloadSistema() {
		return downloadSistema;
	}

	public void setDownloadSistema(String downloadSistema) {
		this.downloadSistema = downloadSistema;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailMessenger() {
		return emailMessenger;
	}

	public void setEmailMessenger(String emailMessenger) {
		this.emailMessenger = emailMessenger;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Long getNivel() {
		return nivel;
	}

	public void setNivel(Long nivel) {
		this.nivel = nivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSetorDepartamento() {
		return setorDepartamento;
	}

	public void setSetorDepartamento(String setorDepartamento) {
		this.setorDepartamento = setorDepartamento;
	}

	public String getTelefoneHotel() {
		return telefoneHotel;
	}

	public void setTelefoneHotel(String telefoneHotel) {
		this.telefoneHotel = telefoneHotel;
	}

	public String getTelefoneHotelRamal() {
		return telefoneHotelRamal;
	}

	public void setTelefoneHotelRamal(String telefoneHotelRamal) {
		this.telefoneHotelRamal = telefoneHotelRamal;
	}

	public String getTelefoneMovel() {
		return telefoneMovel;
	}

	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void setHotelEJB(com.mozart.model.ejb.entity.HotelEJB hotelEJB) {
		this.hotelEJB = hotelEJB;
	}

	public com.mozart.model.ejb.entity.HotelEJB getHotelEJB() {
		return hotelEJB;
	}

	public void setRedeHotelEJB(RedeHotelEJB redeHotelEJB) {
		this.redeHotelEJB = redeHotelEJB;
	}

	public RedeHotelEJB getRedeHotelEJB() {
		return redeHotelEJB;
	}

	public void setMenuMozartWebUsuarioEJBList(
			List<MenuMozartWebUsuarioEJB> menuMozartWebUsuarioEJBList) {
		this.menuMozartWebUsuarioEJBList = menuMozartWebUsuarioEJBList;
	}

	public List<MenuMozartWebUsuarioEJB> getMenuMozartWebUsuarioEJBList() {
		return menuMozartWebUsuarioEJBList;
	}

	public void setMenuIcone(List<MenuMozartWebEJB> menuIcone) {
		this.menuIcone = menuIcone;
	}

	public List<MenuMozartWebEJB> getMenuIcone() {
		return menuIcone;
	}

	public CentralReservaEJB getCrsEJB() {
		return crsEJB;
	}

	public void setCrsEJB(CentralReservaEJB crsEJB) {
		this.crsEJB = crsEJB;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public byte[] getFotografia() {
		return fotografia;
	}

	public void setFotografia(byte[] fotografia) {
		this.fotografia = fotografia;
	}

	public String getNomeFotografia() {
		return nomeFotografia;
	}

	public void setNomeFotografia(String nomeFotografia) {
		this.nomeFotografia = nomeFotografia;
	}
	
	
}
