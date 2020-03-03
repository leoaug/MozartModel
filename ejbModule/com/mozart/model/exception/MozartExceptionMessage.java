package com.mozart.model.exception;

class MozartExceptionMessage {
	private String mensagem;
	
	public MozartExceptionMessage(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
}
