package com.mozart.model.vo.filtro;

import java.io.Serializable;

import com.mozart.model.util.MozartUtil;

public class FiltroWeb implements Serializable {
	private static final long serialVersionUID = 8408336858855677810L;
	private String valorInicial;
    private String valorFinal;
    
    /**
     * C
     * 1-Começado por 
     * 2-Contendo
     * 3-Igual a
     * 
     * D, I, F
     * 1 - Entre
     * 2 - Igual
     * 3 - Maior
     * 4 - Menor
     * */
    private String tipoIntervalo;
    private String tipo;
    
    // TODO: (ID) Refatorar esse lixo. Programação imperativa.
    // Substituir por TipoDado, TipoIntervalo, etc (Implementar Bridge ou Visitor)
    public String toString(){
    
        if ("C".equals( tipo )){
            if ("1".equals( tipoIntervalo )){
                return " like '" + valorInicial + "%'";
            }else if ("2".equals( tipoIntervalo )){
                return " like '%" + valorInicial + "%'";
            }else if ("3".equals( tipoIntervalo )){
                return " = '" + valorInicial + "'";
            }
            
        }else if ("D".equals( tipo )){

            if (!MozartUtil.isNull( valorInicial ) && valorInicial.trim().length() == 7){
            
                if ("1".equals( tipoIntervalo )){
                        return " between to_date('" + valorInicial.trim() + "','mm/yyyy') and to_date('"+ valorFinal.trim()+"','mm/yyyy')";
                }else if ("2".equals( tipoIntervalo )){
                    return " = to_date('" + valorInicial.trim() + "','mm/yyyy') ";
                }else if ("3".equals( tipoIntervalo )){
                    return " > to_date('" + valorInicial.trim() + "','mm/yyyy') ";
                }else{
                    return " < to_date('" + valorInicial.trim() + "','mm/yyyy') ";
                }
            
            
            }else {
                if ("1".equals( tipoIntervalo )){
                        return " between to_date('" + valorInicial + "','dd/mm/yyyy') and to_date('"+ valorFinal+"','dd/mm/yyyy')";
                }else if ("2".equals( tipoIntervalo )){
                    return " = to_date('" + valorInicial + "','dd/mm/yyyy') ";
                }else if ("3".equals( tipoIntervalo )){
                    return " > to_date('" + valorInicial + "','dd/mm/yyyy') ";
                }else{
                    return " < to_date('" + valorInicial + "','dd/mm/yyyy') ";
                }
            }

        } else if ("I".equals( tipo )){
        
            if ("1".equals( tipoIntervalo )){
                return " between " + valorInicial + " and "+ valorFinal;
            }else if ("2".equals( tipoIntervalo )){
                return " = " + valorInicial ;
            }else if ("3".equals( tipoIntervalo )){
                return " > " + valorInicial ;
            }else{
                return " < " + valorInicial ;
            }
            
        } else if ("F".equals( tipo )){
        
        	if ("1".equals( tipoIntervalo )){
        		return " between to_number('" + MozartUtil.toDouble(valorInicial) + "','999999.99') and to_number('"+ MozartUtil.toDouble(valorFinal)+"','999999.99')";
            }else if ("2".equals( tipoIntervalo )){
                return " = to_number('" + MozartUtil.toDouble(valorInicial) + "','999999.99')";
            }else if ("3".equals( tipoIntervalo )){
            	return " > to_number('" + MozartUtil.toDouble(valorInicial) + "','999999.99')";
            }else{
            	return " < to_number('" + MozartUtil.toDouble(valorInicial) + "','999999.99')";
            }
        
    	}else if ("B".equals( tipo )){
            return " = '" + tipoIntervalo + "'";
        }
        return " = ''";
    }

    public FiltroWeb() {
    }
    
    public FiltroWeb(String tipo, String tipoIntervalo) {
    	this.tipo = tipo;
    	this.tipoIntervalo = tipoIntervalo;
    }

    public void setValorInicial(String valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getValorInicial() {
        return valorInicial;
    }

    public void setValorFinal(String valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getValorFinal() {
        return valorFinal;
    }

    public void setTipoIntervalo(String tipoIntervalo) {
        this.tipoIntervalo = tipoIntervalo;
    }

    public String getTipoIntervalo() {
        return tipoIntervalo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
