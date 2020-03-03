package com.mozart.model.ejb.facade;

import java.util.List;

import javax.ejb.Remote;

import com.mozart.model.ejb.entity.ScmMudancaEJB;
import com.mozart.model.ejb.entity.ScmSistemaEJB;
import com.mozart.model.ejb.entity.ScmStatusEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ScmMudancaVO;

@Remote
public interface MudancaSession {
	
	
	String QRY_MUDANCA = 
		" SELECT ID_MUDANCA, DS_SISTEMA, DS_TITULO, DS_CAMINHO, DS_PRIORIDADE, DS_STATUS, DATA, CRIADO_POR, RESPONSAVEL FROM (" +
		" SELECT SM.ID_MUDANCA, SS.DS_SISTEMA, SM.DS_TITULO, SM.DS_CAMINHO, DECODE(SM.NM_PRIORIDADE,1,'Alta',2,'Média',3,'Baixa') DS_PRIORIDADE, "+ 
		" ST.DS_STATUS, SMC.DT_DATA_CRIACAO DATA, SUBSTR(UC.NICK,8) CRIADO_POR, SUBSTR(UD.NICK,8) RESPONSAVEL, UC.ID_USUARIO, UD.ID_USUARIO ID_USUARIO_RESP "+
		" FROM SCM_MUDANCA SM, SCM_MUDANCA_COMPLEMENTO SMC, SCM_SISTEMA SS, SCM_STATUS ST, USUARIO UC, USUARIO UD "+
		" WHERE SM.ID_MUDANCA = SMC.ID_MUDANCA "+
		" AND SM.ID_USUARIO = UC.ID_USUARIO "+
		" AND SM.ID_SISTEMA = SS.ID_SISTEMA "+
		" AND SMC.ID_USUARIO = UD.ID_USUARIO AND SMC.ID_STATUS = ST.ID_STATUS  AND (SM.ID_MUDANCA, SMC.DT_DATA_CRIACAO) IN (SELECT ID_MUDANCA, MAX(DT_DATA_CRIACAO) FROM SCM_MUDANCA_COMPLEMENTO GROUP BY ID_MUDANCA) " +
		") WHERE (ID_USUARIO = ?1 OR ID_USUARIO_RESP = ?2)"; 
		

	
	
	List<ScmMudancaVO> pesquisarMudanca(ScmMudancaVO pFiltro) throws MozartSessionException;
	List<ScmSistemaEJB> pesquisarSistema()throws MozartSessionException;
	List<ScmStatusEJB> pesquisarStatus(ScmMudancaEJB filtro)throws MozartSessionException;
	
}
