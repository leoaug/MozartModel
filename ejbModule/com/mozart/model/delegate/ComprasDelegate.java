package com.mozart.model.delegate;

import java.util.List;

import com.mozart.model.ejb.entity.FornecedorGrupoEJB;
import com.mozart.model.ejb.entity.FornecedorRedeEJB;
import com.mozart.model.ejb.entity.ItemRedeEJB;
import com.mozart.model.ejb.entity.RedeHotelEJB;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.UnidadeEstoqueEJB;
import com.mozart.model.ejb.facade.ComprasSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.EstoqueItemVO;
import com.mozart.model.vo.FornecedorVO;

public class ComprasDelegate extends MozartDelegate {
	
	private static ComprasDelegate instance;
    private static ComprasSession session;

    private ComprasDelegate() throws MozartSessionException {
        try{
            session = (ComprasSession) getLookup("ComprasSession");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: ComprasSession");            
            }
            
        } catch (Exception ex) {
            throw new MozartSessionException(ex.getMessage());             
        }
    }
    
    public static ComprasDelegate instance() throws MozartSessionException {
    	if (instance == null) 
    		instance = new ComprasDelegate();
        return instance;
    }

    public List<FornecedorVO> pesquisarFornecedor(FornecedorVO filtro) throws MozartSessionException {
		return session.pesquisarFornecedor(filtro);
	}

	public List<FornecedorGrupoEJB> pesquisarFornecedorGrupo(FornecedorGrupoEJB fornecedor) throws MozartSessionException {
		return session.pesquisarFornecedorGrupo(fornecedor);
	}
	
	public void gravarFornecedor(FornecedorRedeEJB fornecedor) throws MozartSessionException {
		session.gravarFornecedor(fornecedor);
	}

	public List<EstoqueItemVO> pesquisarEstoqueItem(EstoqueItemVO filtro) throws MozartSessionException {
		return session.pesquisarEstoqueItem(filtro);
	}

	public List<UnidadeEstoqueEJB> pesquisarUnidadeEstoque(RedeHotelEJB redeHotel) throws MozartSessionException {
		return session.pesquisarUnidadeEstoque(redeHotel);
	}

	public List<ItemRedeEJB> pesquisarItemRede(ItemRedeEJB itemRede) throws MozartSessionException {
		return session.pesquisarItemRede(itemRede);
	}

	public List<ItemRedeEJB> pesquisarItemRedeLikeNome(ItemRedeEJB itemRede, String nomeItem) throws MozartSessionException {
		
		return session.pesquisarItemRedeLikeNome(itemRede, nomeItem);
	}
	public List<TipoItemEJB> pesquisarTipoItemLikeNome(TipoItemEJB tipoItem, String nomeTipo) throws MozartSessionException {
		
		return session.pesquisarTipoItemLikeNome(tipoItem, nomeTipo);
	}
}
