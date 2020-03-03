package com.mozart.model.exception;

public class MozartSessionFilterException extends MozartSessionException {
	
	public static final MozartExceptionMessage PARAMETRO_OBRIGATORIO = new MozartExceptionMessage("O parâmetro %s é obrigatório para esta operação.");
	public static final MozartExceptionMessage PARAMETRO_INVALIDO = new MozartExceptionMessage("O parâmetro %s com valor %s é inválido para esta operação.");
	
	public MozartSessionFilterException(MozartExceptionMessage mensagem, Object[] parametros) {
		super(String.format(mensagem.getMensagem(), parametros));
	}
	
	private static final long serialVersionUID = 4208750596650451571L;
}
