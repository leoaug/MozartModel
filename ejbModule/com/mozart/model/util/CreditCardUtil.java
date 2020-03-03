package com.mozart.model.util;

import java.util.HashMap;
import java.util.Map;

import com.mozart.model.delegate.UsuarioDelegate;
import com.mozart.model.ejb.entity.UsuarioEJB;

public class CreditCardUtil {

	private static final String AMEXPattern = "^3[47][0-9]{13}$";
	private static final String MasterCardPattern = "^5[1-5][0-9]{14}$";
	private static final String VisaCardPattern = "^4[0-9]{12}(?:[0-9]{3})?$";
	private static final String DinersClubCardPattern = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$";
	private static final String enRouteCardPattern = "^(2014|2149)";
	private static final String DiscoverCardPattern = "^6(?:011|5[0-9]{2})[0-9]{12}$";
	private static final String JCBCardPattern = "^(?:2131|1800|35\\d{3})\\d{11}$";  
	private static Map<String, String> creditCardPatterns = null;
	
	static{
		creditCardPatterns = new HashMap<String, String>();
		creditCardPatterns.put("AMEX", AMEXPattern);
		creditCardPatterns.put("MasterCard", MasterCardPattern);
		creditCardPatterns.put("Visa", VisaCardPattern);
		creditCardPatterns.put("DinersClub", DinersClubCardPattern);
		creditCardPatterns.put("enRoute", enRouteCardPattern);
		creditCardPatterns.put("Discover", DiscoverCardPattern);
		creditCardPatterns.put("JCB", JCBCardPattern);
	}

	public CreditCardUtil() {
	}

	public static String GetCardType(String cardNumber) {
		String cardType = null;
		try {
			String cardNum = cardNumber.replace(" ", "").replace("-", "");
			for (String cardTypeName : creditCardPatterns.keySet()) {
				if (cardNum.matches(creditCardPatterns.get(cardTypeName))) {
					cardType = cardTypeName;
					break;
				}
			}
		} catch (Exception ex) {
		}
		return cardType;	
	}
	
	public static void main(String[] args) {
		try {

			String s = Criptografia.instance().crypto("Mozart1234");
			s = Criptografia.instance().crypto("");
			UsuarioEJB usuario = new UsuarioEJB();
			usuario.setNick("MOZART_WEB");
			usuario.setSenha(null);
			
			UsuarioEJB autenticado = UsuarioDelegate.instance().autenticar(usuario);
			CreditCardUtil util = new CreditCardUtil();
			
			System.out.println(util.GetCardType("30261500371960"));
			System.out.println(util.GetCardType("378282246310005"));
			System.out.println(util.GetCardType("5105105105105100"));
			System.out.println(util.GetCardType("4012888888881881"));
			System.out.println(util.GetCardType("378282246310005"));
			System.out.println(util.GetCardType("4711932129735003"));
			System.out.println(util.GetCardType("6011701609638611"));
			System.out.println(util.GetCardType("374534789862493"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
