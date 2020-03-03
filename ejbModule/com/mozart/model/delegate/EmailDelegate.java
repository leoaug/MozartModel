package com.mozart.model.delegate;

import com.mozart.model.util.MozartEmailUtil;
import com.mozart.model.util.MozartUtil;

public class EmailDelegate extends MozartDelegate {

    private static EmailDelegate instance;
    private MozartEmailUtil mailManager = null;

    private EmailDelegate() {
        mailManager = new MozartEmailUtil("", "", "",  "mozart@mozart.com.br", "", "", "", "Teste email", "teste email corpo");
    }
    
    public static EmailDelegate instance(){
        return instance == null ? instance = new EmailDelegate() : instance;
    }
    
    public boolean send(String de, String para, String comcopia, String assunto, String corpo, byte[] anexo, String anexoName){
    	if (!MozartUtil.isNull(de)){
    		mailManager.setFrom( de );
    	}else{
    		mailManager.setFrom("mozart@mozart.com.br");
    	}
        mailManager.setTo( para );
        mailManager.setCc( comcopia );
        mailManager.setSubject( assunto );
        mailManager.setMessage( corpo );
      	mailManager.setAnexo( anexo );
      	mailManager.setAnexoName( anexoName );
        return mailManager.send();
    }
    
    public boolean send(String para, String comcopia, String assunto, String corpo, byte[] anexo, String anexoName){
        return send(null, para, comcopia, assunto, corpo, anexo, anexoName);
    }

    public boolean send(String de, String para, String comcopia, String assunto, String corpo){
        return send(de, para, comcopia, assunto, corpo, null, null);
    }

    public boolean send(String para, String comcopia, String assunto, String corpo){
        return send(null, para, comcopia, assunto, corpo, null, null);
    }

    
}
