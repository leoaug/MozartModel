package com.mozart.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;


import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.TinnFolhaVO;

public class TravelInnDAO extends MozartDAO{

	String DELETAR_FOLHA = "DELETE TINN_FOLHA_INTEGRACAO_TMP";
	String INCLUIR_FOLHA = "INSERT INTO TINN_FOLHA_INTEGRACAO_TMP (ID, ID_HOTEL, CONTA_CONTABIL, ID_CENTRO_CUSTO, ID_FORNECEDOR, ID_CONTA_DEBITO, ID_CONTA_CREDITO, DOCUMENTO, DEBITO_CREDITO, DATA_DOCUMENTO, VALOR) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11)";
	String EXECUTAR_PROCEDURE = "{call PROC_LANCA_FOLHA_TINN}";
	
    public void gravarArquivo(List<TinnFolhaVO> lista) throws MozartSessionException{
        Connection conn = null;
        PreparedStatement st = null;
        StringBuilder trace = new StringBuilder();
        try{
               trace.append(" - Iniciando gracacao");
               conn = newConnection();
               trace.append(" - Obteve a conexao: " + conn);
               if (conn == null){
                    throw new MozartSessionException("Não foi possível obter a conexao");
               }
               conn.setAutoCommit( Boolean.FALSE);

               int x = 1; 
               st = conn.prepareStatement( DELETAR_FOLHA );
               x = st.executeUpdate();
               st.close();
           
               st = conn.prepareStatement( INCLUIR_FOLHA );
               for (TinnFolhaVO linha: lista){
                   x = 1;
                   st.setLong       ( x++, linha.getId()    );
                   st.setLong       ( x++, linha.getIdHotel()     );
                   st.setString     ( x++, linha.getContaContabil()  );
                   st.setLong     	( x++, linha.getIdCentroCusto()     );
                   if (linha.getIdFornecedor()!=null)
                	   st.setLong     	( x++, linha.getIdFornecedor() );
                   else
                	   st.setNull(x++, Types.NUMERIC);

                   if (linha.getIdContaDebito()!=null)
                	   st.setLong     	( x++, linha.getIdContaDebito() );
                   else
                	   st.setNull(x++, Types.NUMERIC);

                   if (linha.getIdContaCredito()!=null)
                	   st.setLong     	( x++, linha.getIdContaCredito() );
                   else
                	   st.setNull(x++, Types.NUMERIC);

                   st.setString     ( x++, linha.getDocumento() );
                   st.setString     ( x++, linha.getDebitoCredito());
                   st.setDate     	( x++, new java.sql.Date(linha.getDataDocumento().getTime()) );
                   st.setDouble     ( x++, linha.getValor());
                   st.addBatch();                   
               } 
               st.executeBatch();
                   
               st = conn.prepareCall(EXECUTAR_PROCEDURE );
               st.executeUpdate();
               conn.commit();     
        }catch(Exception ex){
            throw new MozartSessionException("Erro ao importar arquivo: " + trace.toString() + " - " +ex.getMessage());         
        
        }finally{
            fecharRecurso(conn, null, st);
        }    
    }

    
}
