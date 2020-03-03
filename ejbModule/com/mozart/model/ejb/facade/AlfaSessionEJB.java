package com.mozart.model.ejb.facade;

import com.mozart.model.ejb.entity.AlfaArquivoEJB;
import com.mozart.model.exception.MozartSessionException;
import com.mozart.model.vo.ApoliceAlfa;
import com.mozart.model.vo.HospedeSegurado;
import com.mozart.model.vo.HotelConsolidadoAlfa;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface AlfaSessionEJB {

    String QUERY_HOSPEDE_SEGURADO = 
    "select "+
    "rede.nome_fantasia redeHotel, h.nome_fantasia hotel, apto.num_apartamento apto, hos.nome_hospede || ' '|| hos.sobrenome_hospede nomeHospede, "+ 
    "hos.Nascimento, hos.cpf, hos.passaporte, origem.cidade origem, destino.cidade destino, rl.data_entrada dataEntrada, nvl(rl.data_saida, c.data_saida + 0.5) dataSaida, "+ 
    "decode( decode(greatest(nvl(trunc(rl.data_saida), c.data_saida),ctldata.front_office), nvl(trunc(rl.data_saida), c.data_saida), ctldata.front_office, nvl(trunc(rl.data_saida), c.data_saida)) - trunc(rl.data_entrada),0,1, "+ 
    "decode(greatest(nvl(trunc(rl.data_saida), c.data_saida),ctldata.front_office), nvl(trunc(rl.data_saida), c.data_saida), ctldata.front_office, nvl(trunc(rl.data_saida), c.data_saida)) - trunc( rl.data_entrada )) qtdeDiaria, "+  
    "es.vl_seguro valorSeguro, "+  
    "decode(decode(decode(greatest(nvl(trunc(rl.data_saida), c.data_saida),ctldata.front_office), nvl(trunc(rl.data_saida), c.data_saida), ctldata.front_office, nvl(trunc(rl.data_saida), c.data_saida)) - trunc(c.data_real_entrada),0,1,decode(greatest(c.data_saida,ctldata.front_office), c.data_saida, ctldata.front_office, c.data_saida) - trunc(rl.data_entrada)),0,1, "+
    "decode(decode(greatest(nvl(trunc(rl.data_saida), c.data_saida),ctldata.front_office), nvl(trunc(rl.data_saida), c.data_saida), ctldata.front_office, nvl(trunc(rl.data_saida), c.data_saida)) - trunc(c.data_real_entrada),0,1,decode(greatest(c.data_saida,ctldata.front_office), c.data_saida, ctldata.front_office, c.data_saida) - trunc(rl.data_entrada))) "+
    "* es.vl_seguro valorTotal, "+
    "local_hotel.cidade local, "+ 
    "rl.cod_certificado||'' certificado, rl.DATA_CERTIFICADO, hos.sexo, estado_origem.uf, hos.email, rl.id_room_list, es.NUM_CONTRATO_APOLICE, es.ID_HOTEL_SEGURADO, ES.NUM_PLANO_APOLICE, rl.cod_nosso_numero "+ 
    "from empresa_seguradora es, \n" + 
    "	 rede_hotel rede, \n" + 
    "	 hotel h, \n" + 
    "	 controla_data ctldata, \n" + 
    "	 checkin c, \n" + 
    "	 room_list rl,\n" + 
    "	 hospede hos, \n" + 
    "	 apartamento apto,\n" + 
    "	 cidade origem,\n" + 
    "    estado estado_origem,\n" + 
    "    cidade local_hotel,\n" + 
    "	 cidade destino\n" + 
    "where es.id_hotel_segurado = h.id_hotel\n" + 
    "and ctldata.id_hotel = h.id_hotel\n" + 
    "and es.id_hotel_segurado = c.id_hotel\n" + 
    "and TRUNC(c.data_entrada) >= es.dt_inicio_seguro\n" + 
    "and TRUNC(c.data_saida) <= nvl(es.dt_fim_seguro, TRUNC(c.data_saida))\n" + 
    "and c.id_checkin = rl.id_checkin\n" + 
    "and rl.chegou = 'S'\n" +
    "and apto.cofan = 'N'\n" +
    "and c.id_apartamento = apto.id_apartamento\n" + 
    "and c.id_cidade_procedencia = origem.id_cidade(+)\n" + 
    "and origem.id_estado = estado_origem.id_estado(+)\n" + 
    "and c.id_cidade_destino = destino.id_cidade(+)\n" + 
    "and h.id_cidade = local_hotel.id_cidade(+) \n" + 
    "and rl.id_hospede = hos.id_hospede\n" + 
    "and h.id_rede_hotel = rede.id_rede_hotel(+)\n" + 
    "and es.id_seguradora = ?1 ";
    //"order by c.data_entrada, apto.num_apartamento\n";
    
    String QUERY_CONSOLIDADO_HOTEL_ALFA = 
    "select rh.nome_fantasia rede,  h.nome_fantasia hotel, \n" + 
    "       to_char(grupo.vigencia,'mm/yyyy') vigencia, grupo.qtdeDiaria,\n" + 
    "       es.VL_SEGURO, \n" + 
    "       es.valor_manutencao, \n" + 
    "       qtde_apto.qtde_apto, \n" + 
    "       (es.valor_manutencao) *\n" + 
    "       qtde_apto.qtde_apto total_manutencao,\n" + 
    "       es.valor_datacenter,\n" + 
    "       (es.valor_datacenter) *\n" + 
    "       qtde_apto.qtde_apto total_datacenter,        \n" + 
    "       (es.valor_manutencao *qtde_apto.qtde_apto ) + \n" + 
    "       (es.valor_datacenter * qtde_apto.qtde_apto) total_apagar,      \n" + 
    "       (grupo.qtdeDiaria * es.VL_SEGURO) vlTotalSeguro   "+
    "from hotel h, rede_hotel rh, empresa_seguradora es, \n" + 
    "(select \n " + 
    " h.id_hotel, " +
    " es.id_seguradora," + 
    " trunc(decode(greatest(nvl(trunc(rl.data_saida), c.data_saida),ctldata.front_office), nvl(trunc(rl.data_saida), c.data_saida), ctldata.front_office, nvl(trunc(rl.data_saida), c.data_saida)),'month') vigencia," + 
    " sum(decode(decode(greatest(nvl(trunc(rl.data_saida), c.data_saida),ctldata.front_office), nvl(trunc(rl.data_saida), c.data_saida), ctldata.front_office, nvl(trunc(rl.data_saida), c.data_saida)) - trunc(rl.data_entrada),0,1, " +  
    " decode(greatest(nvl(trunc(rl.data_saida), c.data_saida),ctldata.front_office), nvl(trunc(rl.data_saida), c.data_saida), ctldata.front_office, nvl(trunc(rl.data_saida), c.data_saida)) - trunc(rl.data_entrada))) qtdeDiaria " + 
    "    from \n" + 
    "       empresa_seguradora es,  \n" + 
    "    	 hotel h,  \n" + 
    "    	 controla_data ctldata,  \n" + 
    "    	 checkin c, apartamento a, room_list rl  \n" + 
    "    where c.id_checkin = rl.id_checkin \n" +
    "    and es.id_hotel_segurado = h.id_hotel \n" + 
    "    and ctldata.id_hotel = h.id_hotel \n" + 
    "    and es.id_hotel_segurado = c.id_hotel \n" + 
    "	 and rl.chegou = 'S'\n" +
    "    and rl.data_saida is not null \n"+ 
    "	 and a.cofan = 'N'\n" +
    "	 and c.id_apartamento = a.id_apartamento\n" + 
    "    and c.data_entrada >= es.dt_inicio_seguro \n" + 
    "    and c.data_saida <= nvl(es.dt_fim_seguro, c.data_saida) \n" + 
    "    and es.id_seguradora = ?1\n" + 
    "    and instr(NVL(?2,';'||h.id_hotel||';'), ';'||h.id_hotel||';' ) >= 1\n" + 
    "    group by h.id_hotel, es.id_seguradora,  trunc(decode(greatest(nvl(trunc(rl.data_saida), c.data_saida),ctldata.front_office), nvl(trunc(rl.data_saida), c.data_saida), ctldata.front_office, nvl(trunc(rl.data_saida), c.data_saida)),'month')) grupo,\n" + 
    "    (select id_hotel, count(*) qtde_apto from apartamento where cofan='N' group by id_hotel) qtde_apto\n" + 
    "where h.id_rede_hotel = rh.id_rede_hotel(+)\n" + 
    "and   h.id_hotel = es.ID_HOTEL_SEGURADO\n" + 
    "and   h.id_hotel = qtde_apto.id_hotel\n" + 
    "and es.ID_HOTEL_SEGURADO = grupo.id_hotel\n" + 
    "and es.id_seguradora = grupo.id_seguradora\n";
    
    String QUERY_APOLICE_ALFA = 
    "select \n" + 
    "'02.982.856' numApolice,\n" + 
    "cod_certificado||'',\n" + 
    "hotel.razao_social, \n" + 
    "hotel.cgc,\n" + 
    "h.nome_hospede||' '||h.sobrenome_hospede,\n" + 
    "to_char(h.NASCIMENTO,'dd/mm/yyyy'),\n" + 
    "nvl(h.cpf,h.passaporte),\n" + 
    "decode(h.sexo,'M','Masculino','F','Feminino'),\n" + 
    "to_char(rl.data_entrada,'dd/mm/yyyy HH24:mi:ss'),\n" + 
    "nvl(to_char(rl.data_saida,'dd/mm/yyyy HH24:mi:ss'),ck.data_saida||' 12:00:00'),\n" +
    "'614598' numContrato\n" +
    "from room_list rl, hospede h, checkin ck, hotel\n" + 
    "where rl.id_hospede = h.id_hospede\n" + 
    "and rl.id_checkin = ck.id_checkin\n" + 
    "and ck.id_hotel = hotel.id_hotel\n" + 
    "and rl.cod_certificado = ?1";
    
    List<HospedeSegurado> pesquisarHospedeSegurado(HospedeSegurado pHospedeSegurado) throws MozartSessionException;
    List<HotelConsolidadoAlfa> pesquisarHotelConsolidadoAlfa(HotelConsolidadoAlfa pHotelConsolidadoAlfa) throws MozartSessionException;
    ApoliceAlfa opterApoliceAlfa(ApoliceAlfa pApoliceAlfa) throws MozartSessionException;
    void gravarArquivo(AlfaArquivoEJB arquivoEJB)  throws MozartSessionException;
    void gerarArquivo01PorHotel(HospedeSegurado pHospedeSegurado)  throws MozartSessionException;
    Long obterNextSequence(String seqName) throws MozartSessionException;
}
