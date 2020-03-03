package com.mozart.model.nfse.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.mozart.model.nfe.tipos.MozartNFseResponse;
import com.mozart.model.nfsecabofrio.tipos.EnviarLoteRpsEnvio;
import com.mozart.model.util.NFseUtil;

public class MozartNFseClient {
	private int port = 8080;
	private String host = "54.94.198.192";
	private String endpointAddress = "MozartWebServices/NFseService/NFseService/gerarNfse";
	private URL url = null;
	private HttpURLConnection conn = null;
	private Map<String, String> parameters = new HashMap<String, String>();
	private Map<String, List<String>> listParameters = new HashMap<String, List<String>>();
	protected Logger log = Logger.getLogger(this.getClass());

	public MozartNFseClient() throws MalformedURLException {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String buildParameterString() {
		Iterator it = parameters.entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			sb.append(String.format("%s=%s", entry.getKey(), entry.getValue()));
			sb.append("&");
		}

		Set<String> keys = listParameters.keySet();
		
		for (String key : keys) {
			List<String> list = listParameters.get(key);
			Iterator<String> itList = list.iterator();
			while (itList.hasNext()) {
				String value = itList.next();
				sb.append(String.format("%s=%s", key, value));
				if (itList.hasNext()) {
					sb.append("&");
				}
			}
		}

		return sb.toString();
	}

	private void connect() throws ProtocolException, IOException {
		url = new URL(String.format("http://%s:%d/%s?%s", host, port, endpointAddress, buildParameterString()));
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/xml");
	}

	private void disconnect() throws IOException {
		conn.disconnect();
		conn = null;
		url = null;
	}

	public MozartNFseResponse gerarNFse(List<String> rps, String cnpj, String inscricaoMunicipal, String numeroLote, String municipio) {
		MozartNFseResponse response = null;
		try {
			parameters.clear();

			addSingleParameter("cnpj", cnpj);
			addSingleParameter("inscricaoMunicipal", inscricaoMunicipal);
			addSingleParameter("numeroLote", numeroLote);
			addSingleParameter("municipio", municipio);
			addListParameter("listaRps", rps);

			connect();
			log.info(conn);
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder sb = new StringBuilder();
			String apiOutput = null;
			while ((apiOutput = br.readLine()) != null) {
				sb.append(apiOutput);
			}
			System.out.println(sb.toString());
			disconnect();

			response = (MozartNFseResponse)NFseUtil.unmarshal(MozartNFseResponse.class, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public void addSingleParameter(String name, String value) {
		parameters.put(name, value);
	}

	public void addListParameter(String name, List<String> list) {
		listParameters.put(name, list);
	}

	public static void main(String[] args) {
		try {
			MozartNFseClient client = new MozartNFseClient();
			// Chamada ao webservice.
			MozartNFseResponse type = client.gerarNFse(Arrays.asList(new String[] {"34272639", "34272675"}), 
					"21996540000147", "1/0035892",
					"3", "3300704");
			EnviarLoteRpsEnvio envio = (EnviarLoteRpsEnvio)NFseUtil.obterEnviarLoteRpsEnvio(type, EnviarLoteRpsEnvio.class);
			// XML
			System.out.println(type.getOutputXML());
			// Umarshalled para EnvioLoteRpsEnvio
			System.out.println(envio.getLoteRps().getCpfCnpj().getCnpj());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
