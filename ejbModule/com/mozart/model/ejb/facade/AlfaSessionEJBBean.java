package com.mozart.model.ejb.facade;

import com.mozart.model.dao.AlfaSeguradoraDAO;
import com.mozart.model.ejb.entity.AlfaArquivoEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.util.MozartModelConstantes;
import com.mozart.model.util.MozartUtil;
import com.mozart.model.vo.ApoliceAlfa;
import com.mozart.model.vo.HospedeSegurado;
import com.mozart.model.vo.HotelConsolidadoAlfa;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("unchecked")
@Stateless(name="AlfaSessionEJB")
public class AlfaSessionEJBBean implements AlfaSessionEJB {

    @PersistenceContext(unitName="MozartModel")
    private EntityManager manager;
    
    
    public AlfaSessionEJBBean() {
    }
    
    
	
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<HospedeSegurado> pesquisarHospedeSegurado(HospedeSegurado pHospedeSegurado) throws MozartSessionException{
        try{
            String sql = QUERY_HOSPEDE_SEGURADO;

            
            if  (!MozartUtil.isNull(pHospedeSegurado.getFiltroNome().getTipoIntervalo())){
            	sql += " and hos.nome_hospede || ' '|| hos.sobrenome_hospede " + pHospedeSegurado.getFiltroNome();
            }
            if  (!MozartUtil.isNull(pHospedeSegurado.getFiltroCPF().getTipoIntervalo())){
                sql += " and hos.cpf " + pHospedeSegurado.getFiltroCPF();
            }
            if  (!MozartUtil.isNull(pHospedeSegurado.getFiltroDataNascimento().getTipoIntervalo())){
                sql += " and hos.Nascimento " + pHospedeSegurado.getFiltroDataNascimento();
            }
            if  (!MozartUtil.isNull(pHospedeSegurado.getFiltroCidadeHotel().getTipoIntervalo())){
                sql += " and local_hotel.cidade " + pHospedeSegurado.getFiltroCidadeHotel();
            }
            if  (!MozartUtil.isNull(pHospedeSegurado.getFiltroDataEntrada().getTipoIntervalo())){
                sql += " and trunc(rl.data_entrada) " + pHospedeSegurado.getFiltroDataEntrada();
            }
            if  (!MozartUtil.isNull(pHospedeSegurado.getFiltroDataSaida().getTipoIntervalo())){
                sql += " and trunc(rl.data_saida) " + pHospedeSegurado.getFiltroDataSaida();
            }

            if  (!MozartUtil.isNull(pHospedeSegurado.getIdHoteis())){
                String hoteis = ";";
                for (Long id: pHospedeSegurado.getIdHoteis()){
                    hoteis += id+";";
                }
                sql += " and instr('"+hoteis+"', ';'||h.id_hotel||';') >= 1 ";
            }
            
            sql +=  "order by rl.data_certificado desc\n";
            
            List lista = manager.createNativeQuery( sql ).
                         setParameter(1, pHospedeSegurado.getIdSeguradora() ).
                         getResultList();
            
            List<HospedeSegurado> resultado = new ArrayList<HospedeSegurado>();                     
            for (Object l: lista){
                resultado.add( new HospedeSegurado( (Object[])l ) );
            }           
            return resultado;
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );

        }

    }
    
    
    
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public List<HotelConsolidadoAlfa> pesquisarHotelConsolidadoAlfa(HotelConsolidadoAlfa pHotelConsolidadoAlfa) throws MozartSessionException{
        try{
            String sql = QUERY_CONSOLIDADO_HOTEL_ALFA;

            String hoteis = null;
            if  (!MozartUtil.isNull(pHotelConsolidadoAlfa.getIdHoteis())){
                hoteis = ";";
                for (Long id: pHotelConsolidadoAlfa.getIdHoteis()){
                    hoteis += id+";";
                }
            }            
            //sql += " and h.id_rede_hotel = " + pHotelConsolidadoAlfa.getIdRedeHotel() + " ";

            if  (!MozartUtil.isNull(pHotelConsolidadoAlfa.getFiltroVigencia().getTipoIntervalo())){
                sql += " and grupo.vigencia " + pHotelConsolidadoAlfa.getFiltroVigencia();
            }            
            sql += "order by rh.nome_fantasia,  h.nome_fantasia, grupo.vigencia";

            
            List lista = manager.createNativeQuery( sql ).
                            setParameter(1, pHotelConsolidadoAlfa.getIdSeguradora() ).
                            setParameter(2, hoteis ).
                            getResultList();
            List<HotelConsolidadoAlfa> resultado = new ArrayList<HotelConsolidadoAlfa>();                     
            for (Object l: lista){
                resultado.add( new HotelConsolidadoAlfa( (Object[])l ) );
            }           
            
            
            return resultado;
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );

        }

    }

    
	@TransactionAttribute(value = TransactionAttributeType.SUPPORTS)
    public ApoliceAlfa opterApoliceAlfa(ApoliceAlfa pApoliceAlfa) throws MozartSessionException{
        try{
            String sql = QUERY_APOLICE_ALFA;

            List lista = manager.createNativeQuery( sql ).
                            setParameter(1, pApoliceAlfa.getCurrentSessionID() ).
                            getResultList();
            List<ApoliceAlfa> resultado = new ArrayList<ApoliceAlfa>();                     
            for (Object l: lista){
                resultado.add( new ApoliceAlfa( (Object[])l ) );
            }           
            return resultado.get(0);
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );

        }
    }
    
    public void gravarArquivo(AlfaArquivoEJB arquivoEJB)  throws MozartSessionException{
    
        try{
            
            //manager.persist( arquivoEJB );
            new AlfaSeguradoraDAO().gravarArquivo( arquivoEJB );
        }catch(Exception ex){
            throw new MozartSessionException( ex.getMessage() );

        }
    
    
    }

    @TransactionAttribute(value = TransactionAttributeType.NEVER)
    public void gerarArquivo01PorHotel(HospedeSegurado pHospedeSegurado)   throws MozartSessionException{
    
            try{
               //deve preencher a o periodo e o id hotel, no encerramento
               Long seq = new AlfaSeguradoraDAO().nextFileSeq( "seq_arquivo_alfa" );
               List<HospedeSegurado> listaResult = pesquisarHospedeSegurado( pHospedeSegurado );
               String URL = MozartModelConstantes.URL_ALFA_DIRETORIO;
               String URL_OUTPUT = URL + "/output";
               String dataStr = MozartUtil.format( new Date() ,"ddMMyyyy"); 
               FileOutputStream output = new FileOutputStream ( URL_OUTPUT +"/"+ "01HMOZART"+
                                                                 dataStr +
                                                                 MozartUtil.lpad( seq.toString(), "0", 10) +
                                                                 ".txt");
                                                                 
                String linhas = "H" + MozartUtil.lpad( "1", "0", 10) +
                                "01" + dataStr + 
                                MozartUtil.lpad( seq.toString(), "0", 10) +
                                MozartUtil.rpad("HMOZART"," ",30) +
                                MozartUtil.rpad(" "," ",1439)+"\n";
                                
                output.write(linhas.getBytes());
               for (HospedeSegurado hos: listaResult){
                    
                   linhas = "D" + "IN" + "F" + MozartUtil.lpad(MozartUtil.isNull(hos.getCpf())?"0":hos.getCpf().replaceAll("[.]","").replaceAll("-",""),"0",15) +
                            MozartUtil.rpad(hos.getNomeHospede()," ",40) + MozartUtil.lpad(" "," ",10) + 
                            (MozartUtil.isNull(hos.getDataNascimento())?MozartUtil.lpad(" "," ",8):MozartUtil.format(hos.getDataNascimento(), "ddMMyyyy")) +
                            (MozartUtil.isNull(hos.getSexo())?" ":hos.getSexo()) + MozartUtil.lpad(" "," ",40) + MozartUtil.lpad(" "," ",10) + MozartUtil.lpad("0","0",5) + 
                            MozartUtil.lpad(" "," ",30) + MozartUtil.lpad(" "," ",20) + MozartUtil.lpad(" "," ",20) + MozartUtil.rpad(hos.getOrigem()," ",40) + 
                            MozartUtil.lpad(hos.getUf()," ",2) + MozartUtil.lpad("0","0",8) + 
                            MozartUtil.lpad("0","0",2) + MozartUtil.lpad("0","0",8) + MozartUtil.lpad("0","0",2) + MozartUtil.lpad("0","0",8) + MozartUtil.lpad("0","0",2) + MozartUtil.lpad("0","0",8) +
                            MozartUtil.rpad(hos.getEmail()," ",50) + "VG" + MozartUtil.lpad(" "," ",5) + MozartUtil.lpad("5000000","0",12) + 
                            MozartUtil.lpad(hos.getNumContratoApolice().toString(),"0",20) + MozartUtil.lpad(hos.getNumSubContratoApolice().toString(),"0",20) + MozartUtil.lpad(hos.getNumPlanoApolice().toString(),"0",20) + MozartUtil.lpad("5000000","0",12) + 
                            MozartUtil.format(hos.getDataEntrada(), "ddMMyyyy") + MozartUtil.lpad(" "," ",560) + MozartUtil.lpad(hos.getCertificado()," ",10) +
                            MozartUtil.lpad(" "," ",30) + MozartUtil.lpad("0","0",10) + MozartUtil.lpad("0","0",10) + MozartUtil.lpad(hos.getIdRoomList().toString(),"0",10) + MozartUtil.lpad(" "," ",15) + 
                            MozartUtil.format(hos.getDataEntrada(), "ddMMyyyy") + MozartUtil.format(hos.getDataEntrada(), "ddMMyyyy") + 
                            "N" + MozartUtil.lpad(" "," ",40) + MozartUtil.lpad("0","0",15) + MozartUtil.lpad(" "," ",8) + " " + MozartUtil.lpad(" "," ",40) + MozartUtil.lpad("0","0",5) +
                            MozartUtil.lpad(" "," ",30) + MozartUtil.lpad(" "," ",6) + MozartUtil.lpad(" "," ",15) + MozartUtil.lpad(" "," ",50) + MozartUtil.lpad(" "," ",20) + 
                            MozartUtil.lpad(" "," ",40) + MozartUtil.lpad(" "," ",2) + MozartUtil.lpad("0","0",8) + MozartUtil.format(hos.getDataEntrada(), "ddMMyyyy") + 
                            MozartUtil.format(hos.getDataSaida(), "ddMMyyyy") + 
                            MozartUtil.lpad(hos.getPassaporte()," ",10) + MozartUtil.lpad(" "," ",36) +  
                            MozartUtil.format(hos.getDataEntrada(), "ddMMyyyy") + 
                            MozartUtil.format(hos.getDataSaida(), "ddMMyyyy") +
                            MozartUtil.lpad(hos.getNossoNumero()==null?" ":String.valueOf( hos.getNossoNumero() ),"0",15) + 
                            MozartUtil.lpad(" "," ",33) + "\n";
                            
                   output.write(linhas.getBytes());
                    
               }
                linhas = "T"+ MozartUtil.lpad( (listaResult==null?"0":listaResult.size()+""), "0", 8) +
                         MozartUtil.rpad(" "," ",1491);   
                         
                output.write(linhas.getBytes());
                output.flush();
                output.close();
               
            }catch(Exception ex){
                
                throw new MozartSessionException ("Não foi possível gerar o arquivo:" + ex.getMessage());
            
            }

    }
    
    public Long obterNextSequence(String seqName) throws MozartSessionException{
    	
    	BigDecimal result = (BigDecimal)manager.createNativeQuery("select "+seqName+".nextval from dual").getSingleResult();
    	
    	return new Long(result.longValue());
    }
}
