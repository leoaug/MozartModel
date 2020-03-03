package com.mozart.model.delegate;

import javax.naming.Context;
import javax.naming.InitialContext;

public class MozartDelegate {

    protected Object getLookup(String facade) throws Exception{
    	Context contexto = new InitialContext();
    	return contexto.lookup("java:app/MozartModel/"+facade); 
    }

    protected Object getLookup(String app, String facade) throws Exception{
    	Context contexto = new InitialContext();
    	try {
    		return contexto.lookup("java:app/"+ app+"/" +facade);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return contexto.lookup(app + "/"+facade+"/remote"); 
    }
}