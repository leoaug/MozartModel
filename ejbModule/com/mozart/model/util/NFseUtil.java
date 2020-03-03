package com.mozart.model.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.mozart.model.nfe.tipos.MozartNFseResponse;
import com.mozart.model.nfse.builder.RpsCaboFrioImpl;
import com.mozart.model.nfse.builder.RpsNfseNacionalImpl;
import com.mozart.model.nfsecabofrio.tipos.EnviarLoteRpsEnvio;
import com.mozart.model.nfsecabofrio.tipos.TcDeclaracaoPrestacaoServico;
import com.mozart.model.nfsecabofrio.tipos.TcLoteRps;
import com.mozart.model.nfsecabofrio.tipos.TcLoteRps.ListaRps;
import com.mozart.model.nfsecarioca.tipos.INFseType;
import com.mozart.model.nfsecarioca.tipos.TcRps;
import com.sun.xml.bind.marshaller.CharacterEscapeHandler;
import com.sun.xml.bind.marshaller.DataWriter;

public class NFseUtil {
	public static XMLGregorianCalendar toXMLGregorianCalendarDateOnly(Calendar c) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(c.getTimeInMillis());
		XMLGregorianCalendar xc = null;
		try {
			xc = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(gc.get(Calendar.YEAR), Calendar.MONTH,
					Calendar.DAY_OF_MONTH, DatatypeConstants.FIELD_UNDEFINED);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xc;
	}
	
	public static String marshal(INFseType type) {
		String returnStr = "";
		StringWriter stringWriter = new StringWriter();
		DataWriter dataWriter = new DataWriter(new PrintWriter(stringWriter), "UTF-8", new CharacterEscapeHandler() {
			public void escape(char[] buf, int start, int len, boolean isAttValue, Writer out) throws IOException {

				for (int i = start; i < start + len; i++) {
					char ch = buf[i];
					out.write(ch);
				}
			}
		});
		try {
			JAXBContext context = null;

			if(type.getClass().isInstance(EnviarLoteRpsEnvio.class)){
				context = JAXBContext.newInstance(ListaRps.class, RpsCaboFrioImpl.class, TcLoteRps.class,
						TcDeclaracaoPrestacaoServico.class, type.getClass());				
			}
			else{
				context = JAXBContext.newInstance(com.mozart.model.nfsecarioca.tipos.TcLoteRps.ListaRps.class, RpsNfseNacionalImpl.class, com.mozart.model.nfsecarioca.tipos.TcLoteRps.class,
						TcRps.class, type.getClass());				
			}
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(type, dataWriter);

			returnStr = stringWriter.toString().replace(" standalone=\"yes\"", "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnStr;
	}

	public static INFseType unmarshal(Class<?> type, String xml) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(type);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (INFseType) unmarshaller.unmarshal(new StringReader(xml));
	}

	public static INFseType obterEnviarLoteRpsEnvio(INFseType type, Class<?> klass) throws JAXBException {
		return NFseUtil.unmarshal(klass, ((MozartNFseResponse) type).getOutputXML());
	}
}
