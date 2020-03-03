package com.mozart.model.util;


public class MozartFuncoesWeb {
    public MozartFuncoesWeb() {
    }
    
    public static Boolean isNull(Object object){
 
        if (object == null){
            return true;
        }
        
        if (object instanceof String){
            return ((String)object).trim().length() == 0;
        }
        
        return false;
    
    }
}
