package com.mozart.model.exception;

public class MozartSessionException extends Exception {
	public static final String RESERVA_NAO_ENCONTRADA = "Reserva não Encontrada no Sistema";
    /**
	 * 
	 */
	private static final long serialVersionUID = -5991013042174704166L;
	public MozartSessionException() {
        super();
    }
    public MozartSessionException(String mensagem) {
        super(mensagem);
    }
}
