package com.mozart.model.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

    private static final String hexDigits = "0123456789abcdef";
    private static final String PRE = "PRE_";
    private static final String POS = "_POS";
    private static Criptografia instance;
        
        
        public static void main(String[] s){
        
            //70f420fbc8542b393bd2081f69f9b1c9
        	
        	String valor = Criptografia.instance().crypto("1234");
        	System.out.println(valor);
        	valor = Criptografia.instance().crypto("contact");
        	System.out.println(valor);
        	
        }
        
        
        private Criptografia() {
        }
        
        public static Criptografia instance(){
            return  instance==null?instance=new Criptografia():instance;
        }    
                
        
        public String crypto(String _valor){
            try {
                String valor = byteArrayToHexString(digest((PRE+_valor+POS).getBytes()));
                return valor;
            } catch (NoSuchAlgorithmException e) {
                return "";
            }
        }

        public String decrypto(String _valor){
                String valor = new String(hexStringToByteArray(_valor));
                return valor;
        }
        
        
        private byte[] digest(byte[] input) throws NoSuchAlgorithmException {
                 MessageDigest md = MessageDigest.getInstance("MD5");
                 md.reset();
                 return md.digest(input);
        }
             
        
        private String byteArrayToHexString(byte[] b) {
            StringBuffer buf = new StringBuffer();
        
            for (int i = 0; i < b.length; i++) {
                int j = ((int) b[i]) & 0xFF; 
                buf.append(hexDigits.charAt(j / 16)); 
                buf.append(hexDigits.charAt(j % 16)); 
            }
            
            return buf.toString();
        }
        
        private byte[] hexStringToByteArray(String hexa) {
          
          
            byte[] b = new byte[hexa.length() / 2];
          
            for (int i = 0; i < hexa.length(); i+=2) {
                b[i / 2] = (byte) ((hexDigits.indexOf(hexa.charAt(i)) << 4) |
                    (hexDigits.indexOf(hexa.charAt(i + 1))));          
            }
            return b;
        }
        
       

    
}
