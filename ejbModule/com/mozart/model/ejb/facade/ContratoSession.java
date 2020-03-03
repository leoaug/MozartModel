package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.ServicosContratoEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ContratoVO;

@Remote
public interface ContratoSession {
	
	String QRY_PES_CONTRATO = "SELECT "
			+ " ID_CONTRATO," 
			+ " CANCELADO," 
			+ " ER.NOME_FANTASIA," 
			+ " DATA_INI, "
			+ " DATA_FIM, "
			+ " DIA_FATURAMENTO, "
			+ " TL.DESCRICAO_LANCAMENTO," 
			+ " DESCRICAO_SERVICO," 
			+ " QUANTIDADE, "
			+ " VALOR_UNITARIO, "
			+ " (QUANTIDADE * VALOR_UNITARIO) VALOR_TOTAL," 
			+ " SC.ISS, "
			+ " SC.TAXA_SERVICO," 
			+ " H.SIGLA "
			+ " FROM SERVICOS_CONTRATO SC" 
			+ " JOIN HOTEL H "
			+ " ON (SC.ID_HOTEL = H.ID_HOTEL)" 
			+ " JOIN EMPRESA_REDE ER "
			+ " ON (H.ID_REDE_HOTEL = ER.ID_REDE_HOTEL "
            + " AND SC.ID_EMPRESA = ER.ID_EMPRESA)" 
            + " JOIN TIPO_LANCAMENTO TL "
            + " ON (SC.ID_TIPO_LANCAMENTO = TL.ID_TIPO_LANCAMENTO) ";
            
	
	List<ContratoVO> obterListaContratos(ContratoVO filtro) throws MozartSessionException;
	
	ServicosContratoEJB gravarContrato(ServicosContratoEJB entidade) throws MozartSessionException;
}