package com.mozart.model.delegate;

import java.util.Date;
import java.util.List;

import com.mozart.model.ejb.entity.ClassificacaoContabilEJB;
import com.mozart.model.ejb.entity.ContaCorrenteEJB;
import com.mozart.model.ejb.entity.ContasPagarEJB;
import com.mozart.model.ejb.entity.DuplicataEJB;
import com.mozart.model.ejb.entity.DuplicataHistoricoEJB;
import com.mozart.model.ejb.entity.FornecedorHotelEJB;
import com.mozart.model.ejb.entity.HistoricoContabilEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoContabilEJB;
import com.mozart.model.ejb.entity.PlanoContaEJB;
import com.mozart.model.ejb.entity.TesourariaEJB;
import com.mozart.model.ejb.facade.FinanceiroSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.nfe.tipos.MozartNFseResponse;
import com.mozart.model.nfse.client.MozartNFseClient;
import com.mozart.model.vo.ClassificacaoContabilVO;
import com.mozart.model.vo.ContasPagarComissaoVO;
import com.mozart.model.vo.ContasPagarVO;
import com.mozart.model.vo.DuplicataVO;
import com.mozart.model.vo.RpsVO;
import com.mozart.model.vo.TesourariaVO;

public class FinanceiroDelegate extends MozartDelegate{
	
	
	
    private static FinanceiroDelegate instance;
    private static FinanceiroSession session;

    private FinanceiroDelegate() throws MozartSessionException {
    
        try{
        
            session = (FinanceiroSession) getLookup("FinanceiroSession");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: FinanceiroSession");            
            }
        }catch(Exception ex){
        
            throw new MozartSessionException(ex.getMessage());             
        
        }
    
    }
	private FinanceiroDelegate(String name) throws MozartSessionException {

		try {
            session = (FinanceiroSession) getLookup(name, "FinanceiroSession");
			if (session == null) {
				throw new MozartSessionException("Não foi possivel localizar: FinanceiroSessionEJB");
			}
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	public static FinanceiroDelegate instance(String name) throws MozartSessionException {
		return instance == null ? instance = new FinanceiroDelegate(name) : instance;
	}

    public static FinanceiroDelegate instance() throws MozartSessionException{
    
        return instance==null?instance = new FinanceiroDelegate() : instance;
    
    }


    
    public List<DuplicataVO> pesquisarDuplicata(DuplicataVO filtro) throws MozartSessionException{
    	
    	return session.pesquisarDuplicata(filtro);
    	
    }

	public void unificarDuplicata(HotelEJB hotel, Long[] idDuplicata) throws MozartSessionException{
		try{
			session.gerarUnificarDuplicata(hotel, idDuplicata, "UNIFICAR");
    	}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
		
	}

	public void gerarDuplicata(HotelEJB hotel, Long[] idDuplicata) throws MozartSessionException{
		try{
			session.gerarUnificarDuplicata(hotel, idDuplicata, "GERAR");
    	}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}

	public void gravarParcelamento(DuplicataEJB entidade, List<DuplicataEJB> parcelas)  throws MozartSessionException{
		
		try{
			session.gravarParcelamento(entidade, parcelas);
    	}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
		
	}

	public void encerrarFaturamento(HotelEJB hotel)  throws MozartSessionException{
		try{
			session.encerrarFaturamento(hotel);
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
	
	@SuppressWarnings("unchecked")
	public List obterValidacao(Long idHotel)  throws MozartSessionException{
		return session.obterValidacao(idHotel);
	}

	
	/*Contas a receber*/
	public List<DuplicataVO> pesquisarContasReceber(DuplicataVO filtro) throws MozartSessionException{
		return session.pesquisarContasReceber(filtro);
	}

	public void receberDuplicatas(DuplicataVO rec,List<DuplicataVO> listaRecebimento) throws MozartSessionException{
		session.receberDuplicatas(rec, listaRecebimento);
		
	}

	public void descontarDuplicatas(DuplicataVO rec,
			List<DuplicataVO> listaDesconto) throws MozartSessionException{
		
		session.descontarDuplicatas(rec, listaDesconto);
		
	}

	public void encerrarContasReceber(HotelEJB hotel) throws MozartSessionException{
		try{
			session.encerrarContasReceber(hotel);
    	}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
		
	}

	public List<ContasPagarVO> pesquisarContasPagar(ContasPagarVO filtro) throws MozartSessionException{
		return session.pesquisarContasPagar(filtro);
	}
	
	public List<ContasPagarComissaoVO> pesquisarContasPagarComissao(ContasPagarComissaoVO filtro) throws MozartSessionException{
		return session.pesquisarContasPagarComissao(filtro);
	}

	public List<FornecedorHotelEJB> obterFornecedorLookup(
			FornecedorHotelEJB pFiltro) throws MozartSessionException{

		return session.obterFornecedorLookup(pFiltro);
	}

	
	public List<HistoricoContabilEJB> obterHistoricoContabil(HistoricoContabilEJB filtro) throws MozartSessionException {
		return session.obterHistoricoContabil( filtro );
	}
    
	public List<ClassificacaoContabilVO> obterClassificacaoContabil(ClassificacaoContabilVO filtro)throws MozartSessionException {
		return session.obterClassificacaoContabil(filtro);
	}

	public void gravarContasPagar(ContasPagarEJB entidadeCP,
			DuplicataHistoricoEJB entidadeHistorico) throws MozartSessionException {

		session.gravarContasPagar(entidadeCP,entidadeHistorico);
		
	}

	public ContasPagarEJB obterContasPagar(ContasPagarEJB entidadeCP) throws MozartSessionException {

		return session.obterContasPagar( entidadeCP );
	}

	public String obterProximoContasPagar(HotelEJB hotel)  throws MozartSessionException{

		return session.obterProximoContasPagar(hotel);
	}

	public void pagarTitulos(ContasPagarVO rec,
			List<ContasPagarVO> listaPagamento) throws MozartSessionException{
		session.pagarTitulos(rec, listaPagamento);
		
	}

	public void gravarParcelamento(ContasPagarEJB entidadeCP,	List<ContasPagarEJB> parcelasCP) throws MozartSessionException{
		
		try{
			session.gravarParcelamento(entidadeCP, parcelasCP);
    	}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}

	public void encerrarContasPagar(HotelEJB hotel)   throws MozartSessionException{
		try{
			session.encerrarContasPagar(hotel);
    	}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
		
	}

	@SuppressWarnings("unchecked")
	public List obterValidacaoEncerramentoContasPagar(Long idHotel) throws MozartSessionException{
		return session.obterValidacaoEncerramentoContasPagar( idHotel );
	}

	public List<TesourariaVO> pesquisarTesouraria(TesourariaVO filtro) throws MozartSessionException{
		return session.pesquisarTesouraria(filtro);
	}

	public List<ContaCorrenteEJB> obterContaCorrentePorPlanoContas(PlanoContaEJB filtro) throws MozartSessionException{
		return session.obterContaCorrentePorPlanoContas(filtro);
	}

	public void gravarTesouraria(HotelEJB hotel,
			List<TesourariaEJB> tesourariaList,
			List<MovimentoContabilEJB> movimentoSemTesourariaList, String origemMovimento) throws MozartSessionException{
		try{	
			session.gravarTesouraria(hotel, tesourariaList, movimentoSemTesourariaList, origemMovimento);
		}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}

	public List<ClassificacaoContabilEJB> obterClassificacaoContabilPadrao(
			ClassificacaoContabilEJB filtro) throws MozartSessionException{

		return session.obterClassificacaoContabilPadrao(filtro);
	}

	public void conciliarTesouraria(TesourariaVO filtro,
			List<TesourariaVO> listaConciliacao)  throws MozartSessionException{

		session.conciliarTesouraria(filtro, listaConciliacao);
	}

	public void encerrarTesouraria(HotelEJB hotel)  throws MozartSessionException{
		try{
			session.encerrarTesouraria(hotel);
    	}catch(MozartValidateException ex){
    		throw ex;
    	}catch(Exception ex){
			String msg = ex.getCause().getCause().getMessage();
			if (msg.indexOf("-2000") >= 0){
				throw new MozartValidateException(msg.substring( msg.indexOf("ORA-20000:")+11, msg.indexOf("ORA-065") ));
			}else{
				throw new MozartSessionException(ex.getMessage());
			}
		}
	}
	
	public List<RpsVO> obterListaDeRps(int idHotel, Date data) throws MozartSessionException {
		return session.obterListaDeRps(idHotel, data);
	}
	
	public List<RpsVO> obterListaDeRps(List<String> rps) throws MozartSessionException{
		return session.obterListaDeRps(rps);
	}
	
	public String gerarXmlNotaFiscalLote(List<String> idsRpsLote, String cnpj, String inscricaoMunicipal, String numeroLote, String uf) throws Exception{
		
		try{
			MozartNFseClient client = new MozartNFseClient();
			
			// Chamada ao webservice.
//			MozartNFseResponse type = client.gerarNFse(Arrays.asList(new String[] {"34272639", "34272675"}), 
//					"21996540000147", "1/0035892",
//					"3", "3300704");
			MozartNFseResponse type = client.gerarNFse(idsRpsLote, cnpj, inscricaoMunicipal,
					numeroLote, uf);
//			NFseUtil.obterEnviarLoteRpsEnvio(type);
//			NFseUtil.obterEnviarLoteRpsEnvio(type, EnviarLoteRpsEnvio.class);
			return type.getOutputXML();
			
    	}catch(Exception ex){
			throw new MozartSessionException(ex.getMessage());
		}
	}
}
