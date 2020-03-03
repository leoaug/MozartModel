package com.mozart.model.exception;

public class MozartValidateException extends MozartSessionException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3615063207707707798L;
	public MozartValidateException() {
        super();
    }
    public MozartValidateException(String mensagem) {
        super(mensagem.replaceAll("\n", ""));
    }
}
