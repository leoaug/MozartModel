package com.mozart.model.helper;

import com.mozart.model.ejb.entity.MenuMozartWebEJB;

import com.mozart.model.util.MozartUtil;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {

    
    
      private String nome;
      private String left;
      private String top;
      private String orientation;
      private String alwaysvisible;
      private List<MenuMozartWebEJB> menuItem;
      public static MenuHelper INICIO = new MenuHelper("InicioMenu");

      static { 
      
        INICIO.setLeft("20");
        INICIO.setTop("70");
        INICIO.setOrientation("vertical");
        INICIO.setAlwaysvisible("1");
        INICIO.getMenuItem().add(new MenuMozartWebEJB(new Long(0), "Iniciar", new Long(0), new Long(1), "", ""));
      }

      public MenuHelper() {
        this.menuItem = new ArrayList<MenuMozartWebEJB>();
      }

      public MenuHelper(String nome)
      {
        this();
        this.nome = nome;
      }

      public String toString() {
        StringBuffer result = new StringBuffer();
        result.append(getCabecalho());
        for (MenuMozartWebEJB menu : this.menuItem) {
          result.append(menu + "\n");
        }
        result.append("}\n");

        return result.toString();
      }

      public void setNome(String nome)
      {
        this.nome = nome;
      }

      public String getNome()
      {
        return this.nome;
      }

      public void setMenuItem(List<MenuMozartWebEJB> menuItem) {
        this.menuItem = menuItem;
      }

      public List<MenuMozartWebEJB> getMenuItem()
      {
        return this.menuItem;
      }



    public boolean equals(Object obj){
        
        if (nome == null || obj ==null)
            return false;
            
        return nome.equals ( ((MenuHelper)obj).getNome() );    
    
    }
    
      private String getCabecalho() {
        StringBuffer result = new StringBuffer();
        result.append("with(marcioMenu=new menuname('");
        result.append(getNome());
        result.append("')){");
        result.append("style=submenuStyle;");
        if (left != null)
            result.append(getLeft());
        if (top != null)
            result.append(getTop());
        if (!MozartUtil.isNull( orientation ))
            result.append(getOrientation());
        if (alwaysvisible != null)
            result.append(getAlwaysvisible());

        return result.toString();
      }

      public void setLeft(String left)
      {
        this.left = left;
      }

      public String getLeft()
      {
        return "left=" + this.left + ";";
      }

      public void setTop(String top) {
        this.top = top;
      }

      public String getTop()
      {
        return "top=" + this.top + ";";
      }

      public void setOrientation(String orientation) {
        this.orientation = orientation;
      }

      public String getOrientation()
      {
        return "orientation='" + this.orientation + "';";
      }

      public void setAlwaysvisible(String alwaysvisible) {
        this.alwaysvisible = alwaysvisible;
      }

      public String getAlwaysvisible()
      {
        return "alwaysvisible=" + this.alwaysvisible + ";";
      }
}