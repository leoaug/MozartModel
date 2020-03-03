package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoEstoqueEJB;
import com.mozart.model.ejb.facade.EstoqueSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.vo.ItemEstoqueVO;
import com.mozart.model.vo.MovimentoEstoqueVO;

public class EstoqueDelegate extends MozartDelegate {

	private static EstoqueDelegate instance;
	private static EstoqueSession session;

	private EstoqueDelegate() throws MozartSessionException {
		try {
			session = (EstoqueSession) getLookup("EstoqueSession");
			if (session == null) {
				throw new MozartSessionException(
						"Não foi possivel localizar: ComprasSession");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static EstoqueDelegate instance() throws MozartSessionException {
		return instance == null ? instance = new EstoqueDelegate() : instance;
	}

	public List<MovimentoEstoqueVO> pesquisarMovimentoEstoque(
			MovimentoEstoqueVO filtro) throws MozartSessionException {
		return session.pesquisarMovimentoEstoque(filtro);
	}
	
	public List<ItemEstoqueVO> pesquisarValorUnitarioItem(ItemEstoqueVO filtro)
			throws MozartSessionException{
		return session.pesquisarValorUnitarioItem(filtro);
	}
	
	public List<ItemEstoqueVO> pesquisarValorUnitarioDevolucaoItem(ItemEstoqueVO filtro)
			throws MozartSessionException{
		return session.pesquisarValorUnitarioDevolucaoItem(filtro);
	}
	
	public void salvarMovimentoEstoque(MovimentoEstoqueEJB movimentoEstoque) throws MozartSessionException{
		session.salvarMovimentoEstoque(movimentoEstoque);
	}
	
	public void salvarMovimentoEstoqueReduzido(MovimentoEstoqueEJB movimentoEstoque) throws MozartSessionException{
		session.salvarMovimentoEstoqueReduzido(movimentoEstoque);
	}
	
	public void salvarSaidaMovimentoEstoque(MovimentoEstoqueEJB movimentoEstoque) throws MozartSessionException{
		session.salvarSaidaMovimentoEstoque(movimentoEstoque);
	}
	
	public Long obterNextVal() throws MozartSessionException{
		return session.obterNextVal();
	}
	
	public void encerrarEstoque(HotelEJB hotel)  throws MozartSessionException{
		try{
			session.encerrar(hotel);
    	}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
		
	}
	
	public MovimentoEstoqueVO pesquisarMovimentoEstoqueFechamento(MovimentoEstoqueVO movimentoEstoqueVO)
			throws MozartSessionException {
		return session.pesquisarMovimentoEstoqueFechamento(movimentoEstoqueVO);
	}
	
	public void salvarFechamentoMovimentoEstoque(MovimentoEstoqueVO movimentoEstoque) throws MozartSessionException{
		session.salvarFechamentoMovimentoEstoque(movimentoEstoque);
	}
	
	public List<ItemEstoqueVO> pesquisarValorUnitarioTransferenciaCusto(ItemEstoqueVO filtro)
			throws MozartSessionException{
		return session.pesquisarValorUnitarioTransferenciaCusto(filtro);
	}
	
	public List<ItemEstoqueVO> pesquisarQuantidadeTransferenciaCusto(ItemEstoqueVO filtro)
			throws MozartSessionException{
		return session.pesquisarQuantidadeTransferenciaCusto(filtro);
	}
}