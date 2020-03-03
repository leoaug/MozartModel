package com.mozart.model.exception;

public class MozartSessionFilterException extends MozartSessionException {
	
	public static final MozartExceptionMessage PARAMETRO_OBRIGATORIO = new MozartExceptionMessage("O par�metro %s � obrigat�rio para esta opera��o.");
	public static final MozartExceptionMessage PARAMETRO_INVALIDO = new MozartExceptionMessage("O par�metro %s com valor %s � inv�lido para esta opera��o.");
	
	public MozartSessionFilterException(MozartExceptionMessage mensagem, Object[] parametros) {
		super(String.format(mensagem.getMensagem(), parametros));
	}
	
	private static final long serialVersionUID = 4208750596650451571L;
}
