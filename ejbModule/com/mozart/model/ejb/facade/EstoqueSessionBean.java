package com.mozart.model.ejb.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mozart.model.ejb.entity.HotelEJB;
import com.mozart.model.ejb.entity.MovimentoEstoqueEJB;
import com.mozart.model.ejb.facade.interceptor.UsuarioSessionInfoInterceptor;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.exception.MozartValidateException;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ItemEstoqueVO;
import com.mozart.model.vo.MovimentoEstoqueVO;

@Stateless(name="EstoqueSession")
public class EstoqueSessionBean implements EstoqueSession{
	
	@PersistenceContext(unitName="MozartModel")
	private EntityManager manager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object obter(Class class1, Object pk) throws MozartSessionException {
		try {
			Object obj = this.manager.find(class1, pk);
			if (!MozartUtil.isNull(obj)) {
				this.manager.refresh(obj);
			}
			return obj;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Object persist(Object newEntity) throws MozartSessionException {
		this.manager.persist(newEntity);
		//this.manager.flush();
		return newEntity;
	}
	
	public Object refresh(Class entity, Object pk)
			throws MozartSessionException {
		Object result = this.manager.getReference(entity, pk);
		this.manager.refresh(result);
		return result;
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object alterar(Object entity) throws MozartSessionException {
		try {
			this.manager.merge(entity);
			return entity;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
	
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void excluir(Object entity) throws MozartSessionException {
		try {
			entity = this.manager.merge(entity);
			this.manager.remove(entity);
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ItemEstoqueVO> pesquisarValorUnitarioItem(ItemEstoqueVO itemEstoque)
			throws MozartSessionException {

		String SQL = QUERY_PESQUISAR_VALOR_UNITARIO_ITEM;
		
		
		Query qryValorUnt = manager.createNativeQuery( SQL );
				
		List lista = qryValorUnt 
		.setParameter(1, itemEstoque.getIdHotel())
		.setParameter(2, itemEstoque.getIdHotel())
		.setParameter(3, itemEstoque.getIdHotel())
		.setParameter(4, itemEstoque.getIdHotel())
		.setParameter(5, itemEstoque.getIdHotel())
		.setParameter(6, itemEstoque.getIdHotel())
		.setParameter(7, itemEstoque.getIdHotel())
		.setParameter(8, itemEstoque.getIdItem())
		.getResultList();
		
		List<ItemEstoqueVO> resultado = new ArrayList<ItemEstoqueVO>();                     
		for (Object l: lista){
			resultado.add( new ItemEstoqueVO( (Object[])l, ItemEstoqueVO.TypeOfItemEstoque.SAIDA) );
		}          
		
		return resultado;
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ItemEstoqueVO> pesquisarValorUnitarioDevolucaoItem(ItemEstoqueVO itemEstoque)
			throws MozartSessionException {

		String SQL = QUERY_PESQUISAR_VALOR_UNITARIO_DEVOLUCAO_ITEM;
		
		Query qryValorUnt = manager.createNativeQuery( SQL );
				
		List lista = qryValorUnt 
		.setParameter(1, itemEstoque.getIdItem())
		.setParameter(2, itemEstoque.getIdHotel())
		.setParameter(3, itemEstoque.getIdCentroCusto())
		.getResultList();
		
		List<ItemEstoqueVO> resultado = new ArrayList<ItemEstoqueVO>();                     
		for (Object l: lista){
			resultado.add( new ItemEstoqueVO( (Object[])l, ItemEstoqueVO.TypeOfItemEstoque.DEVOLUCAO) );
		}          
		
		return resultado;
	}

	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<MovimentoEstoqueVO> pesquisarMovimentoEstoque(MovimentoEstoqueVO movimentoEstoqueVO)
			throws MozartSessionException {

		String SQL = QUERY_PESQUISAR_MOVIMENTO_ESTOQUE;
		
		String conectorSQL="\t", filtroSQL="";
		
		if(!MozartUtil.isNull(movimentoEstoqueVO.getLancamento().getValorInicial())){
			filtroSQL = filtroSQL + conectorSQL + " TRUNC(ME.DATA_MOVIMENTO) " 
							+ movimentoEstoqueVO.getLancamento();
			conectorSQL = " \n\t AND ";
		}

		if(!MozartUtil.isNull(movimentoEstoqueVO.getMovimento().getValorInicial())){
			filtroSQL = filtroSQL + conectorSQL + " ME.TIPO_MOVIMENTO "
							+ movimentoEstoqueVO.getMovimento();
			conectorSQL = " \n\t AND ";
		}
		if(!MozartUtil.isNull(movimentoEstoqueVO.getFornecedor().getValorInicial())){
			filtroSQL = filtroSQL + conectorSQL + " FR.NOME_FANTASIA " 
					+ movimentoEstoqueVO.getFornecedor();
			conectorSQL = " \n\t AND ";
		}
		
		if(!MozartUtil.isNull(movimentoEstoqueVO.getDocumento().getValorInicial())){
			filtroSQL = filtroSQL + conectorSQL + " ME.NUM_DOCUMENTO "
					+ movimentoEstoqueVO.getDocumento();
			conectorSQL = " \n\t AND ";
		}
		if(!MozartUtil.isNull(movimentoEstoqueVO.getCentroCusto().getValorInicial())){
			filtroSQL = filtroSQL + conectorSQL + " CCC.DESCRICAO_CENTRO_CUSTO " 
					+ movimentoEstoqueVO.getCentroCusto();
			conectorSQL = " \n\t AND ";
		}
		if(!MozartUtil.isNull(movimentoEstoqueVO.getItem().getValorInicial())){
			filtroSQL = filtroSQL + conectorSQL + " IE.NOME_ITEM " 
					+ movimentoEstoqueVO.getItem();
			conectorSQL = " \n\t AND ";
		}
		
		if(!MozartUtil.isNull(movimentoEstoqueVO.getTipoItem().getValorInicial())){
			filtroSQL = filtroSQL + conectorSQL + " TI.NOME_TIPO "
					+ movimentoEstoqueVO.getTipoItem();
			conectorSQL = " \n\t AND ";
		}
		
		filtroSQL = filtroSQL + conectorSQL + " ME.ID_HOTEL = " + movimentoEstoqueVO.getIdHotel();
		
		
		if(!MozartUtil.isNull(filtroSQL)){
			SQL = SQL + "\n WHERE " + filtroSQL;
		}
		
		SQL = SQL + " ORDER BY ME.DATA_MOVIMENTO, ME.ID_FORNECEDOR, FR.NOME_FANTASIA, "
				  + " ME.ID_CENTRO_CUSTO, CCC.DESCRICAO_CENTRO_CUSTO, "
				  + " ME.NUM_DOCUMENTO, ME.TIPO_MOVIMENTO";
		
		List lista = manager.createNativeQuery( SQL ).getResultList();
		List<MovimentoEstoqueVO> resultado = new ArrayList<MovimentoEstoqueVO>();                     
		for (Object l: lista){
			resultado.add( new MovimentoEstoqueVO( (Object[])l, false) );
		}          
		
		return resultado;
	}

	
	public void salvarMovimentoEstoque(MovimentoEstoqueEJB movimentoEstoque) throws MozartSessionException{
		try {
			String sql = " Insert into MOVIMENTO_ESTOQUE "
					+ " (ID_REDE_HOTEL, "
					+ " ID_HOTEL, "
					+ " TIPO_MOVIMENTO, "
					+ " ID_FORNECEDOR, "
					+ " NUM_DOCUMENTO, "
					+ " TIPO_DOCUMENTO, "
					+ " SERIE_DOCUMENTO, "
					+ " DATA_DOCUMENTO, "
					+ " ID_CENTRO_CUSTO_ACESSOR, "
					+ " CONTA_CORRENTE, "
					+ " DATA_VENCIMENTO,"
					+ " ID_ITEM,"
					+ " ID_UNIDADE_ESTOQUE,"
					+ " QUANTIDADE,"
					+ " VALOR_UNITARIO,"
					+ " VALOR_TOTAL, "
					+ " ID_CENTRO_CUSTO, "
					+ " ID_FISCAL_INCIDENCIA, "
					+ " BASE_CALCULO, "
					+ " ID_COD_FISCAL, "
					+ " ID_ALIQUOTAS, "
					+ " ICMS_VALOR, "
					+ " ID_MOVIMENTO_ESTOQUE,"
					+ " DATA_MOVIMENTO, "
					+ " ID_CONTA_CORRENTE, "
					+ " CHAVE_ACESSO) "
					+ " Values "
					+ " (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9,?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17, ?18, ?19, ?20, ?21, ?22, ?23, ?24, ?25, ?26) ";

			if (!MozartUtil.isNull(movimentoEstoque)) {
				Query qryDemoPlanoConta = manager.createNativeQuery(sql);
				qryDemoPlanoConta
						.setParameter(1, movimentoEstoque.getRedeHotel().getIdRedeHotel())
						.setParameter(2, movimentoEstoque.getHotel().getIdHotel())
						.setParameter(3, movimentoEstoque.getTipoMovimento())
						.setParameter(4, movimentoEstoque.getFornecedorHotelEJB().getIdFornecedor())
						.setParameter(5, movimentoEstoque.getNumDocumento())
						.setParameter(6, movimentoEstoque.getTipoDocumento())
						.setParameter(7, movimentoEstoque.getSerieDocumento())
						.setParameter(8, movimentoEstoque.getDataDocumento())
						.setParameter(9, !MozartUtil.isNull(movimentoEstoque.getCentroCustoContabilAcessor()) ? movimentoEstoque.getCentroCustoContabilAcessor().getIdCentroCustoContabil() : null)
						.setParameter(10, null)
						.setParameter(11, movimentoEstoque.getDataVencimento())
						.setParameter(12, movimentoEstoque.getItem().getId().getIdItem())
						.setParameter(13, movimentoEstoque.getItem().getIdUnidadeEstoque())
						.setParameter(14, movimentoEstoque.getQuantidade())
						.setParameter(15, movimentoEstoque.getValorUnitario())
						.setParameter(16, movimentoEstoque.getValorTotal())
						.setParameter(17, null)
						.setParameter(18, !MozartUtil.isNull(movimentoEstoque.getFiscalIncidencia()) ? movimentoEstoque.getFiscalIncidencia().getIdFiscalIncidencia() : null)
						.setParameter(19, movimentoEstoque.getBaseCalculo())
						.setParameter(20, !MozartUtil.isNull(movimentoEstoque.getFiscalCodigo()) ? movimentoEstoque.getFiscalCodigo().getIdCodigoFiscal() : null)
						.setParameter(21, !MozartUtil.isNull(movimentoEstoque.getAliquotas()) ? movimentoEstoque.getAliquotas().getIdAliquotas() : null)
						.setParameter(22, movimentoEstoque.getIcmsValor())
						.setParameter(23, movimentoEstoque.getIdMovimentoEstoque())
						.setParameter(24, movimentoEstoque.getDataMovimento())
						.setParameter(25, movimentoEstoque.getContaCorrente())
						.setParameter(26, movimentoEstoque.getChaveAcesso())
						.executeUpdate();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}
	
	public void salvarMovimentoEstoqueReduzido(MovimentoEstoqueEJB movimentoEstoque) throws MozartSessionException{
		try {
			String sql = " Insert into MOVIMENTO_ESTOQUE "
					+ " (ID_REDE_HOTEL, "
					+ " ID_HOTEL, "
					+ " TIPO_MOVIMENTO, "
					+ " NUM_DOCUMENTO, "
					+ " TIPO_DOCUMENTO, "
					+ " SERIE_DOCUMENTO, "
					+ " DATA_DOCUMENTO, "
					+ " ID_ITEM,"
					+ " ID_UNIDADE_ESTOQUE,"
					+ " QUANTIDADE,"
					+ " VALOR_UNITARIO,"
					+ " VALOR_TOTAL, "
					+ " ID_ALIQUOTAS, "
					+ " ID_MOVIMENTO_ESTOQUE,"
					+ " DATA_MOVIMENTO, "
					+ "	ID_CENTRO_CUSTO, "
					+ "	CONTROLE_ATIVO_FIXO) "
					+ " Values "
					+ " (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9,?10, ?11, ?12, ?13, ?14, ?15, ?16, ?17) ";

			if (!MozartUtil.isNull(movimentoEstoque)) {
				Query qryDemoPlanoConta = manager.createNativeQuery(sql);
				qryDemoPlanoConta
						.setParameter(1, movimentoEstoque.getRedeHotel().getIdRedeHotel())
						.setParameter(2, movimentoEstoque.getHotel().getIdHotel())
						.setParameter(3, movimentoEstoque.getTipoMovimento())
						.setParameter(4, movimentoEstoque.getNumDocumento())
						.setParameter(5, movimentoEstoque.getTipoDocumento())
						.setParameter(6, movimentoEstoque.getSerieDocumento())
						.setParameter(7, movimentoEstoque.getDataDocumento())
						.setParameter(8, movimentoEstoque.getItem().getId().getIdItem())
						.setParameter(9, movimentoEstoque.getItem().getIdUnidadeEstoque())
						.setParameter(10, movimentoEstoque.getQuantidade())
						.setParameter(11, movimentoEstoque.getValorUnitario())
						.setParameter(12, movimentoEstoque.getValorTotal())
						.setParameter(13, !MozartUtil.isNull(movimentoEstoque.getAliquotas()) ? movimentoEstoque.getAliquotas().getIdAliquotas() : null)
						.setParameter(14, movimentoEstoque.getIdMovimentoEstoque())
						.setParameter(15, movimentoEstoque.getDataMovimento())
						.setParameter(16, !MozartUtil.isNull(movimentoEstoque.getCentroCustoContabil()) ? movimentoEstoque.getCentroCustoContabil().getIdCentroCustoContabil() : null)
						.setParameter(17, movimentoEstoque.getControleAtivoFixo())
						.executeUpdate();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}
	
	public void salvarSaidaMovimentoEstoque(MovimentoEstoqueEJB movimentoEstoque) throws MozartSessionException{
		try {
			String sql = " Insert into MOVIMENTO_ESTOQUE "
					+ " (ID_REDE_HOTEL, "
					+ " ID_HOTEL, "
					+ " TIPO_MOVIMENTO, "
					+ " NUM_DOCUMENTO, "
					+ " TIPO_DOCUMENTO, "
					+ " SERIE_DOCUMENTO, "
					+ " DATA_DOCUMENTO, "
					+ " ID_ITEM,"
					+ " ID_UNIDADE_ESTOQUE,"
					+ " QUANTIDADE,"
					+ " VALOR_UNITARIO,"
					+ " VALOR_TOTAL, "
					+ " ID_MOVIMENTO_ESTOQUE,"
					+ " DATA_MOVIMENTO, "
					+ "	ID_CENTRO_CUSTO, "
					+ "	CONTROLE_ATIVO_FIXO) "
					+ " Values "
					+ " (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9,?10, ?11, ?12, ?13, ?14, ?15, ?16) ";

			if (!MozartUtil.isNull(movimentoEstoque)) {
				Query qryDemoPlanoConta = manager.createNativeQuery(sql);
				qryDemoPlanoConta
						.setParameter(1, movimentoEstoque.getRedeHotel().getIdRedeHotel())
						.setParameter(2, movimentoEstoque.getHotel().getIdHotel())
						.setParameter(3, movimentoEstoque.getTipoMovimento())
						.setParameter(4, movimentoEstoque.getNumDocumento())
						.setParameter(5, movimentoEstoque.getTipoDocumento())
						.setParameter(6, movimentoEstoque.getSerieDocumento())
						.setParameter(7, movimentoEstoque.getDataDocumento())
						.setParameter(8, movimentoEstoque.getItem().getId().getIdItem())
						.setParameter(9, movimentoEstoque.getItem().getIdUnidadeEstoque())
						.setParameter(10, movimentoEstoque.getQuantidade())
						.setParameter(11, movimentoEstoque.getValorUnitario())
						.setParameter(12, movimentoEstoque.getValorTotal())
						.setParameter(13, movimentoEstoque.getIdMovimentoEstoque())
						.setParameter(14, movimentoEstoque.getDataMovimento())
						.setParameter(15, !MozartUtil.isNull(movimentoEstoque.getCentroCustoContabil()) ? movimentoEstoque.getCentroCustoContabil().getIdCentroCustoContabil() : null)
						.setParameter(16, movimentoEstoque.getControleAtivoFixo())
						.executeUpdate();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}

	public Long obterNextVal() throws MozartSessionException {
		try {
			String SQL = "SELECT MOZART.SEQ_MOVIMENTO_ESTOQUE.NEXTVAL FROM DUAL";
			BigDecimal vec = (BigDecimal) this.manager.createNativeQuery(SQL)
					.getSingleResult();
			Long retorno = Long.valueOf(vec.longValue());
			return retorno;
		} catch (Exception ex) {
			throw new MozartSessionException(ex.getMessage());
		}
	}
		
	@Interceptors( { UsuarioSessionInfoInterceptor.class })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void encerrar(HotelEJB hotel)
			throws MozartSessionException {
		try {
			this.manager.createNativeQuery(
					"{call MOZART.PROC_ENCERRA_ESTOQUE_WEB(?1)}").setParameter(1,
					hotel.getIdHotel()).executeUpdate();
		} catch (Exception ex) {
			throw new MozartValidateException(ex.getMessage());
		}
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public MovimentoEstoqueVO pesquisarMovimentoEstoqueFechamento(MovimentoEstoqueVO movimentoEstoqueVO)
			throws MozartSessionException {

		String SQL = QUERY_MOVIMENTO_ESTOQUE_INSERIR_FECHAMENTO;
		
		List lista = manager.createNativeQuery( SQL ).setParameter(1, movimentoEstoqueVO.getIdHotel())
				.setParameter(2, movimentoEstoqueVO.getIdPontoVenda())
				.setParameter(3, movimentoEstoqueVO.getNumNota())
				.getResultList();
		
		MovimentoEstoqueVO resultado = new MovimentoEstoqueVO();                     
		for (Object l: lista){
			resultado = new MovimentoEstoqueVO( (Object[])l, true);
		}          
		
		return resultado;
	}
	
	public void salvarFechamentoMovimentoEstoque(MovimentoEstoqueVO movimentoEstoque) throws MozartSessionException{
		try {
			String sql = " Insert into MOVIMENTO_ESTOQUE "
					+ " (ID_MOVIMENTO_ESTOQUE, "
					+ " ID_ITEM, "
					+ " ID_HOTEL, "
					+ " ID_CENTRO_CUSTO, "
					+ " DATA_MOVIMENTO, "
					+ " TIPO_MOVIMENTO, "
					+ " DATA_DOCUMENTO, "
					+ " NUM_DOCUMENTO,"
					+ " QUANTIDADE,"
					+ " ID_REDE_HOTEL) "
					+ " Values "
					+ " (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8, ?9,?10) ";

			if (!MozartUtil.isNull(movimentoEstoque)) {
				Query qryDemoPlanoConta = manager.createNativeQuery(sql);
				qryDemoPlanoConta
						.setParameter(1, movimentoEstoque.getIdMovEstoque())
						.setParameter(2, movimentoEstoque.getIdItem())
						.setParameter(3, movimentoEstoque.getIdHotel())
						.setParameter(4, movimentoEstoque.getIdCentroCusto())
						.setParameter(5, movimentoEstoque.getDtMovimento())
						.setParameter(6, movimentoEstoque.getDsTipoMovimento())
						.setParameter(7, movimentoEstoque.getDtDocumento())
						.setParameter(8, movimentoEstoque.getNumDocumento())
						.setParameter(9, movimentoEstoque.getVlQuantidade())
						.setParameter(10, movimentoEstoque.getIdRedeHotel())
						.executeUpdate();
			}

		} catch (Exception e) {
			throw new MozartSessionException(e.getMessage());
		}
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ItemEstoqueVO> pesquisarValorUnitarioTransferenciaCusto(ItemEstoqueVO itemEstoque)
			throws MozartSessionException {

		String SQL = QUERY_PESQUISAR_VALOR_UNITARIO_TRANSFERENCIA_CUSTO;
		
		Query qryValorUnt = manager.createNativeQuery( SQL );
				
		List lista = qryValorUnt 
		.setParameter(1, itemEstoque.getIdItem())
		.setParameter(2, itemEstoque.getIdCentroCusto())
		.setParameter(3, itemEstoque.getIdItem())
		.setParameter(4, itemEstoque.getIdCentroCusto())
		.setParameter(5, itemEstoque.getIdHotel())
		.getResultList();
		
		List<ItemEstoqueVO> resultado = new ArrayList<ItemEstoqueVO>();                     
		for (Object l: lista){
			resultado.add( new ItemEstoqueVO( (Object[])l, ItemEstoqueVO.TypeOfItemEstoque.DEVOLUCAO) );
		}          
		
		return resultado;
	}
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
	public List<ItemEstoqueVO> pesquisarQuantidadeTransferenciaCusto(ItemEstoqueVO itemEstoque)
			throws MozartSessionException {

		String SQL = QUERY_PESQUISAR_QUANTIDADE_TRANSFERENCIA_CUSTO;
		
		Query qryValorUnt = manager.createNativeQuery( SQL );
				
		List lista = qryValorUnt 
		.setParameter(1, itemEstoque.getIdHotel())
		.setParameter(2, itemEstoque.getIdItem())
		.setParameter(3, itemEstoque.getIdCentroCusto())
		.getResultList();
		
		List<ItemEstoqueVO> resultado = new ArrayList<ItemEstoqueVO>();                     
		for (Object l: lista){
			resultado.add( new ItemEstoqueVO( (Object[])l, ItemEstoqueVO.TypeOfItemEstoque.TRANSFERENCIA) );
		}          
		
		return resultado;
	}
	
}