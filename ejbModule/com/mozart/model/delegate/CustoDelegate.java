package com.mozart.model.delegate;

import java.util.List;











import com.mozart.model.ejb.entity.AliquotaEJB;
import com.mozart.model.ejb.entity.FiscalCodigoEJB;
import com.mozart.model.ejb.entity.FiscalIncidenciaEJB;
import com.mozart.model.ejb.entity.GrupoPratoEJB;
import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoCiEJB;
import com.mozart.model.ejb.entity.PratoEJB;
import com.mozart.model.ejb.entity.TipoItemEJB;
import com.mozart.model.ejb.entity.UsuarioConsumoInternoEJB;
import com.mozart.model.ejb.facade.CustoSession;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.AjustePdvVO;
import com.mozart.model.vo.ConsumoInternoVO;
import com.mozart.model.vo.FiscalCodigoVO;
import com.mozart.model.vo.ItemEstoqueVO;
import com.mozart.model.vo.PratoConsumoInternoVO;
import com.mozart.model.vo.PratoVO;
import com.mozart.model.vo.TransferenciaCentroCustoVO;
import com.mozart.model.vo.UsuarioConsumoInternoVO;

public class CustoDelegate extends MozartDelegate{
    
    private static CustoDelegate instance;
    private static CustoSession session;

    private CustoDelegate() throws MozartSessionException {
    
        try{
        
            session = (CustoSession) getLookup("CustoSession");
            if (session == null){
                throw new MozartSessionException("Não foi possivel localizar: CustoSession");            
            }
        }catch(Exception ex){
        
            throw new MozartSessionException(ex.getMessage());             
        
        }
    
    }
    
    public static CustoDelegate instance() throws MozartSessionException{
    
        return instance==null?instance = new CustoDelegate() : instance;
    
    }
    
    public List<PratoVO> pesquisarPrato(PratoVO filtro) throws MozartSessionException {
		
		return session.pesquisarPrato(filtro);
	}

	public List<GrupoPratoEJB> obterGrupoPrato(HotelEJB hotel) throws MozartSessionException {

		return session.obterGrupoPrato(hotel);
	}

	public List<TipoItemEJB> obterTipoItem(HotelEJB hotel) throws MozartSessionException  {

		return session.obterTipoItem(hotel);
	}

	public List<FiscalCodigoEJB> obterFiscalCodigo(HotelEJB hotel) throws MozartSessionException  {
		return session.obterFiscalCodigo(hotel);
	}
	
	public List<FiscalCodigoEJB> obterFiscalCodigoCompra(HotelEJB hotel) throws MozartSessionException  {
		return session.obterFiscalCodigoCompra(hotel);
	}
	
	public List<FiscalCodigoVO> obterFiscalCodigos(FiscalCodigoVO filtro) throws MozartSessionException  {
		return session.obterFiscalCodigos(filtro);
	}

	public List<FiscalIncidenciaEJB> obterFiscalIncidencias() throws MozartSessionException  {
		return session.obterFiscalIncidencias();
	}

	public List<AliquotaEJB> obterAliquota(HotelEJB hotel) throws MozartSessionException {

		return session.obterAliquota(hotel);
	}
	
	public List<AliquotaEJB> obterAliquota() throws MozartSessionException {
		return session.obterAliquota();
	}
	
	public List<ItemEstoqueVO> pesquisarItemEstoqueFichaTecnica(ItemEstoqueVO filtro)throws MozartSessionException {
		
		return session.pesquisarItemEstoqueFichaTecnica(filtro);
		
	}

	public PratoEJB gravarProduto(PratoEJB entidade)  throws MozartSessionException{
			return session.gravarProduto(entidade);
		}

	public List<TransferenciaCentroCustoVO> pesquisarTransferenciaCentroCusto(TransferenciaCentroCustoVO filtro, HotelEJB hotel)throws MozartSessionException {
		return session.pesquisarTransferenciaCentroCusto(filtro, hotel);
	}

	public List<UsuarioConsumoInternoVO> pesquisarConsumoInternoUsuario(UsuarioConsumoInternoVO filtro, HotelEJB hotel)throws MozartSessionException {
		return session.pesquisarConsumoInternoUsuario(filtro, hotel);
	}
	
	public List<HotelEJB> obterHoteis(HotelEJB hotel) throws MozartSessionException{
		return session.obterHoteis(hotel);
	}
	
	public HotelEJB obterHotelPorId(long idHotel) throws MozartSessionException{
		return session.obterHotelPorId(idHotel);
	}
	
	public void gravarUsuarioConsumo(UsuarioConsumoInternoEJB entidade) throws MozartSessionException{
		session.gravarUsuarioConsumo(entidade);
	}
	
	public List<ConsumoInternoVO> pesquisarConsumoInterno(ConsumoInternoVO filtro)
			throws MozartSessionException {
		return session.pesquisarConsumoInterno(filtro);
	}
	
	public List<ConsumoInternoVO> pesquisarComboUsuarioConsumoInterno(HotelEJB hotel) throws MozartSessionException{
		return session.pesquisarComboUsuarioConsumoInterno(hotel);
	}
	
	public ConsumoInternoVO pesquisarUsuarioConsumoInternoPorId(HotelEJB hotel, long idUsuario, long idPontoVenda) throws MozartSessionException{
		return session.pesquisarUsuarioConsumoInternoPorId(hotel, idUsuario, idPontoVenda);
	}
	
	public List<PratoConsumoInternoVO> pesquisarPratoUsuarioConsumoInterno(PratoConsumoInternoVO filtro) throws MozartSessionException{
		return session.pesquisarPratoUsuarioConsumoInterno(filtro);
	}
	
	public PratoConsumoInternoVO pesquisarPratoValorConsumoInterno(PratoConsumoInternoVO filtro) throws MozartSessionException{
		return session.pesquisarPratoValorConsumoInterno(filtro);
	}
	
	public List<ItemEstoqueVO> pesquisarItemEstoqueConsumoInterno(PratoConsumoInternoVO filtro) throws MozartSessionException{
		return session.pesquisarItemEstoqueConsumoInterno(filtro);
	}
	
	public void salvarMovimentoCi(MovimentoCiEJB movimento) throws MozartSessionException{
		session.salvarMovimentoCi(movimento);
	}
	
	public List<ConsumoInternoVO> pesquisarComboPontoVendaConsumoInterno(HotelEJB hotel) throws MozartSessionException{
		return session.pesquisarComboPontoVendaConsumoInterno(hotel);
	}
	
	public Long obterSeqMovimentoCiNextVal() throws MozartSessionException {
		return session.obterSeqMovimentoCiNextVal();
	}
	
	public List<AjustePdvVO> pesquisarAjustePdv(AjustePdvVO filtro, HotelEJB hotel) throws MozartSessionException
	{
		return session.pesquisarAjustePdv(filtro, hotel);
	}
}
    
    
    
    
    

