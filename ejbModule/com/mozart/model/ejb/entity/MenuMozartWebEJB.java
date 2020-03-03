package com.mozart.model.ejb.entity;

import com.mozart.model.util.MozartUtil;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQueries({														
@NamedQuery(name = "MenuMozartWebEJB.findAllByPrograma", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
                    query = "select o from MenuMozartWebEJB o where o.idMenuItem > 1500 and o.menuMozartWeb is null and (o.idPrograma = ?1 or o.idPrograma = ?2) order by o.numOrdem, o.seqMenu ")
            
    
})
@Table(name = "MENU_MOZART_WEB")
public class MenuMozartWebEJB extends MozartEntity {
    @Column(name="DS_ACAO")
    private String dsAcao;
    @Column(name="DS_IMAGEM")
    private String dsImagem;
    @Column(name="DS_MENU", nullable = false)
    private String dsMenu;
    @Id
    @Column(name="ID_MENU_ITEM", nullable = false)
    private Long idMenuItem;
    
    @Column(name="NUM_ORDEM", nullable = false)
    private Long numOrdem;
    @Column(name="NUM_ORDEM_SUBMENU")
    private Long numOrdemSubmenu;
    @Column(name="ROLE_NAME")
    private String roleName;
    @Column(name="TIPO_MENU")
    private String tipoMenu;
    @Column(name="SEQ_MENU")
    private Long seqMenu;
    
    @Column(name="ID_PROGRAMA")
    private Long idPrograma;
    
    @ManyToOne
	@JoinColumn(name = "ID_MENU_PAI", referencedColumnName = "ID_MENU_ITEM")
    private MenuMozartWebEJB menuMozartWeb;
    
    @OneToMany(mappedBy = "menuMozartWeb", fetch=FetchType.EAGER)
    private List<MenuMozartWebEJB> menuMozartWebEJBList;
    

    public MenuMozartWebEJB() {
    }
    
    public MenuMozartWebEJB(Long id) {
        idMenuItem = id;
    }

    public MenuMozartWebEJB(Long idMenu, String texto, Long ordem, Long submenuOrdem, String imagemSrc, String acao)
      {
        this.idMenuItem = idMenu;
        this.dsMenu = texto;
        this.numOrdem = ordem;
        this.numOrdemSubmenu = submenuOrdem;
        this.dsImagem = imagemSrc;
        this.dsAcao = acao;
      }
    public String toString() {
      StringBuilder linha = new StringBuilder();
      linha.append("aI('");
//      if (!MozartUtil.isNull(this.dsImagem))
//        linha.append("image=" + (MozartUtil.isNull(this.dsImagem)?"":dsImagem) + ";");

      linha.append("text=" + (MozartUtil.isNull(this.dsMenu)?"":dsMenu) + ";");
      
      if   (!MozartUtil.isNull(this.numOrdemSubmenu))
        linha.append("showmenu=" + (MozartUtil.isNull(this.numOrdemSubmenu)?"":""+numOrdemSubmenu) + ";");
        
      if (!MozartUtil.isNull(this.dsAcao))  
        linha.append("url=" + (MozartUtil.isNull(this.dsAcao)? "" : this.dsAcao) + ";");
      else
    	linha.append("url=javascript:return noPage();clickfunction=return noPage();");   
      linha.append("');"); 
           
      return linha.toString();
    }


    public String getDsAcao() {
        return dsAcao;
    }

    public void setDsAcao(String dsAcao) {
        this.dsAcao = dsAcao;
    }

    public String getDsImagem() {
        return dsImagem;
    }

    public void setDsImagem(String dsImagem) {
        this.dsImagem = dsImagem;
    }

    public String getDsMenu() {
        return dsMenu;
    }

    public void setDsMenu(String dsMenu) {
        this.dsMenu = dsMenu;
    }

    public Long getIdMenuItem() {
        return idMenuItem;
    }

    public void setIdMenuItem(Long idMenuItem) {
        this.idMenuItem = idMenuItem;
    }

    public Long getNumOrdem() {
        return numOrdem;
    }

    public void setNumOrdem(Long numOrdem) {
        this.numOrdem = numOrdem;
    }

    public Long getNumOrdemSubmenu() {
        return numOrdemSubmenu;
    }

    public void setNumOrdemSubmenu(Long numOrdemSubmenu) {
        this.numOrdemSubmenu = numOrdemSubmenu;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

 
  
    public void setMenuMozartWeb(MenuMozartWebEJB menuMozartWeb) {
        this.menuMozartWeb = menuMozartWeb;
    }

    public MenuMozartWebEJB getMenuMozartWeb() {
        return menuMozartWeb;
    }

    public void setMenuMozartWebEJBList(List<MenuMozartWebEJB> menuMozartWebEJBList) {
        this.menuMozartWebEJBList = menuMozartWebEJBList;
    }

    public List<MenuMozartWebEJB> getMenuMozartWebEJBList() {
        return menuMozartWebEJBList;
    }

	public Long getSeqMenu() {
		return seqMenu;
	}

	public void setSeqMenu(Long seqMenu) {
		this.seqMenu = seqMenu;
	}

	public Long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}
}
