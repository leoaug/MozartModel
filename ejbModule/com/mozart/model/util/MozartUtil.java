package com.mozart.model.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import com.mozart.model.ejb.entity.UsuarioEJB;


@SuppressWarnings("unchecked")
public class MozartUtil {
	public static final String FMT_MES_ANO = "MM/yyyy";
	public static final String FMT_HORA = "HH:mm";
	public static final String FMT_DATE_TIME = "dd/MM/yyyy HH:mm:ss";
	public static final String FMT_DATE_US = "yyyy-MM-dd";
	public static final String FMT_DATE = "dd/MM/yyyy";
	public static final String FMT_CEP = "########";
	public static final String FMT_FONE = "####-####";
	public static final String FMT_CPF = "###.###.###-##";
	public static final String FMT_CNPJ = "##.###.###/####-##";
	private static final int LEFT = 0;
	private static final int RIGHT = 1;

   public static String convertToUTF8(String value) throws UnsupportedEncodingException {
        return value == null ? "Não Informado" : new String(value.getBytes("ISO-8859-1"), "UTF-8");
    }

	public static Timestamp now() {
		return new Timestamp(new Date().getTime());
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		if ((obj instanceof String)) {
			return ((String) obj).trim().length() == 0;
		}
		if ((obj instanceof List)) {
			return ((List) obj).isEmpty();
		}
		return false;
	}

	public static String trim(String obj) {
		if (obj == null) {
			return null;
		}
		return obj.trim();
	}

	public static String format(Date data, String formato) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(formato);
			return df.format(data);
		} catch (Exception ex) {
		}
		return null;
	}
	
	public static String format(Calendar data, String formato) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(formato);
			return df.format(data);
		} catch (Exception ex) {
		}
		return null;
	}

	public static String format(Date data) {
		return format(data, "dd/MM/yyyy");
	}
	
	public static String formatHour(Date data){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			return sdf.format(data);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static Date toDate(String valor) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			return df.parse(valor);
		} catch (Exception ex) {
		}
		return null;
	}

	public static Date toDate(String valor, String formato) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(formato);
			return df.parse(valor.trim());
		} catch (Exception ex) {
		}
		return null;
	}

	public static Timestamp toTimestamp(String valor) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(
					valor.length() > 10 ? "dd/MM/yyyy HH:mm:ss" : "dd/MM/yyyy");
			return new Timestamp(df.parse(valor).getTime());
		} catch (Exception ex) {
		}
		return null;
	}

	public static Timestamp toTimestamp(String valor, String formato) {
		try {
			return new Timestamp(toDate(valor, formato).getTime());
		} catch (Exception ex) {
		}
		return null;
	}

	public static Double toDouble(String string) {
		try {
			return new Double(string.trim().replaceAll("[.]", "")
					.replaceAll(",", "."));
		} catch (Exception ex) {
		}
		return null;
	}

	public static Long toLong(String string) {
		try {
			return new Long(string);
		} catch (Exception ex) {
		}
		return null;
	}

	public static Double round(Double double1) {
		try {
			return new Double(
					Math.round(double1.doubleValue() * 100.0D) / 100.0D);
		} catch (Exception e) {
		}
		return null;
	}

	public static String format(Double double1) {
		try {
			DecimalFormat df = (DecimalFormat) DecimalFormat
					.getCurrencyInstance(new Locale("pt", "BR"));
			df.setDecimalSeparatorAlwaysShown(true);
			df.setMinimumFractionDigits(2);
			df.setPositivePrefix("");
			df.setNegativePrefix("-");
			return df.format(round(double1));
		} catch (Exception e) {
		}
		return null;
	}

	public static String formatDecimal(Double double1, int casasDecimais) {
		try {
			DecimalFormat df = (DecimalFormat) DecimalFormat
					.getCurrencyInstance(new Locale("pt", "BR"));
			df.setDecimalSeparatorAlwaysShown(true);
			df.setMinimumFractionDigits(casasDecimais);
			df.setPositivePrefix("");
			df.setNegativePrefix("-");
			return df.format(double1);
		} catch (Exception e) {
		}
		return null;
	}
	public static String formatDecimal(Double double1) {
		try {
			return formatDecimal(double1, 3) ;
		} catch (Exception e) {
		}
		return null;
	}

	public static int getDiferencaDia(Date dataInicio, Date dataFim) {
		return (int) ((getDateAsTime(dataFim) - getDateAsTime(dataInicio)) / 1000L / 60L / 60L / 24L);
	}

	private static long getDateAsTime(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		return cal.getTimeInMillis();
	}

	public static Date incrementarMes(Date dt, int qtde) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(2, cal.get(2) + qtde);
		return cal.getTime();
	}

	public static Timestamp incrementarMes(Timestamp dt, int qtde) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(2, cal.get(2) + qtde);
		return new Timestamp(cal.getTime().getTime());
	}

	public static Date incrementarDia(Date dt, int qtde) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(5, cal.get(5) + qtde);
		return cal.getTime();
	}

	public static Timestamp incrementarDia(Timestamp dt, int qtde) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(5, cal.get(5) + qtde);
		return new Timestamp(cal.getTime().getTime());
	}

	public static Date decrementarDia(Date dt, int qtde) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(5, cal.get(5) - qtde);
		return cal.getTime();
	}
	
	public static Calendar stringToCalendar(String strDate) throws ParseException {
		if(MozartUtil.isNull(strDate)) 
			return Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(strDate);
		Calendar cal = Calendar. getInstance();
		cal.setTime(date);
		
		return cal;
	} 

	public static Date decrementarDia(Date dt) {
		return decrementarDia(dt, 1);
	}

	public static Date incrementarDia(Date dt) {
		return incrementarDia(dt, 1);
	}

	public static Timestamp incrementarDia(Timestamp dt) {
		return incrementarDia(dt, 1);
	}

	public static int getDiaDoMes(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(5);
	}

	public static int getMes(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(2) + 1;
	}

	public static int getAno(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		return cal.get(1);
	}

	public static Date primeiroDiaAno(Date data) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			cal.set(5, 1);
			cal.set(2, 0);
			return cal.getTime();
		} catch (Exception e) {
		}
		return null;
	}
	
	public static Date primeiroDiaMes(Date data) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			cal.set(5, 1);
			return cal.getTime();
		} catch (Exception e) {
		}
		return null;
	}

	public static Date ultimoDiaMes(Date data) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(data);
			cal.set(5, cal.getActualMaximum(5));
			return cal.getTime();
		} catch (Exception e) {
		}
		return null;
	}

	public static String lpad(String campo, String complemento, int ateFicarCom) {
		return pad(campo, complemento, ateFicarCom, LEFT);
	}

	public static String rpad(String campo, String complemento, int ateFicarCom) {
		return pad(campo, complemento, ateFicarCom, RIGHT);
	}

	private static String pad(String campo, String complemento,
			int ateFicarCom, int tipo) {
		if (campo == null) {
			campo = " ";
		}
		while (campo.length() < ateFicarCom) {
			if (tipo == 0) {
				campo = complemento + campo;
			} else {
				campo = campo + complemento;
			}
		}
		return campo;
	}

	public static boolean isTurnoValido(UsuarioEJB usuario) {
		try {
			if (usuario == null) {
				return false;
			}
			if ("I".equals(usuario.getTurno())) {
				return true;
			}
			Calendar c = Calendar.getInstance();
			Date dataAtual = c.getTime();

			c.set(11, 0);
			c.set(12, 0);
			c.set(13, 0);
			Date inicioDataManha = c.getTime();

			c.set(11, 12);
			c.set(12, 0);
			c.set(13, 0);
			Date inicioDataTarde = c.getTime();

			c.set(11, 18);
			c.set(12, 0);
			c.set(13, 0);
			Date inicioDataNoite = c.getTime();

			c.set(11, 23);
			c.set(12, 59);
			c.set(13, 59);
			Date fimDataNoite = c.getTime();
			if ((usuario.getTurno().indexOf("M") >= 0)
					&& (dataAtual.before(inicioDataTarde))
					&& (dataAtual.after(inicioDataManha))) {
				return true;
			}
			if ((usuario.getTurno().indexOf("T") >= 0)
					&& (dataAtual.after(inicioDataTarde))
					&& (dataAtual.before(inicioDataNoite))) {
				return true;
			}
			if ((usuario.getTurno().indexOf("N") >= 0)
					&& (dataAtual.after(inicioDataNoite))
					&& (dataAtual.before(fimDataNoite))) {
				return true;
			}
			return false;
		} catch (Exception ex) {
		}
		return false;
	}

	private static String formatString(String value, String pattern) {
		try {
			MaskFormatter mf = new MaskFormatter(pattern);
			mf.setValueContainsLiteralCharacters(false);
			return mf.valueToString(value);
		} catch (Exception ex) {
		}
		return value;
	}

	public static String formatCEP(String value) {
		value = removerNaoNumericos(value);
		return formatString(lpad(value, "0", 8), "#####-###");
	}

	public static String formatCNPJ(String value) {
		return formatString(lpad(value, "0", 14), "##.###.###/####-##");
	}

	public static String formatCPF(String value) {
		return formatString(lpad(value, "0", 11), "###.###.###-##");
	}

	public static String formatFone(String value) {
		return formatString(lpad(value, "0", 8), "####-####");
	}

	public static boolean isUltimoDiaSemana(Date dia) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dia);
		return 7 == cal.get(7);
	}

	public static boolean isFinalSemana(Date dia) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dia);
		int diaDaSemana = cal.get(7);
		return (7 == diaDaSemana) || (1 == diaDaSemana);
	}

	public static byte toByte(int i){
		return (byte) i;
	}
	
	public static byte toByte(String s){
		return Byte.parseByte(s);
	}
	
	public static byte toByte(BigDecimal bd){
		return bd == null? (byte) 0:(byte) bd.intValue();
	}
	public static String getTextoEntreCaracter(String texto, String caracter){
		return caracter + texto + caracter;
	}

	public static String getTextoSemCaracterEspecial(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll(
				"[^\\p{ASCII}]", "");

	}

	public static boolean validarCEP(String cep) {
		return validarCEP(cep, "^\\d{8}$");
	}

	public static boolean validarCEP(String cep, String pattern) {
		Pattern p = Pattern.compile(pattern);
		return validarCEP(cep, p);
	}

	public static boolean validarCEP(String cep, Pattern pattern) {
		Matcher m = pattern.matcher(cep);
		return m.matches();
	}
	
	public static String removerNaoNumericos(String string) {
		return string.replaceAll("[^\\d]", "");
	}
	
	public static boolean isNumber(String string) {
		return string.matches("^[0-9]*$");
	}
	
	public static String replaceAcentosJavaScript(String mensagem)
    {
	    mensagem = mensagem.replace("á", "\u00e1");
	    mensagem = mensagem.replace("à", "\u00e0");
	    mensagem = mensagem.replace("â", "\u00e2");
	    mensagem = mensagem.replace("ã", "\u00e3");
	    mensagem = mensagem.replace("ä", "\u00e4");
	    mensagem = mensagem.replace("Á", "\u00c1");
	    mensagem = mensagem.replace("À", "\u00c0");
	    mensagem = mensagem.replace("Â", "\u00c2");
	    mensagem = mensagem.replace("Ã", "\u00c3");
	    mensagem = mensagem.replace("Ä", "\u00c4");
	    mensagem = mensagem.replace("é", "\u00e9");
	    mensagem = mensagem.replace("è", "\u00e8");
	    mensagem = mensagem.replace("ê", "\u00ea");
	    mensagem = mensagem.replace("ê", "\u00ea");
	    mensagem = mensagem.replace("É", "\u00c9");
	    mensagem = mensagem.replace("È", "\u00c8");
	    mensagem = mensagem.replace("Ê", "\u00ca");
	    mensagem = mensagem.replace("Ë", "\u00cb");
	    mensagem = mensagem.replace("í", "\u00ed");
	    mensagem = mensagem.replace("ì", "\u00ec");
	    mensagem = mensagem.replace("î", "\u00ee");
	    mensagem = mensagem.replace("ï", "\u00ef");
	    mensagem = mensagem.replace("Í", "\u00cd");
	    mensagem = mensagem.replace("Ì", "\u00cc");
	    mensagem = mensagem.replace("Î", "\u00ce");
	    mensagem = mensagem.replace("Ï", "\u00cf");
	    mensagem = mensagem.replace("ó", "\u00f3");
	    mensagem = mensagem.replace("ò", "\u00f2");
	    mensagem = mensagem.replace("ô", "\u00f4");
	    mensagem = mensagem.replace("õ", "\u00f5");
	    mensagem = mensagem.replace("ö", "\u00f6");
	    mensagem = mensagem.replace("Ó", "\u00d3");
	    mensagem = mensagem.replace("Ò", "\u00d2");
	    mensagem = mensagem.replace("Ô", "\u00d4");
	    mensagem = mensagem.replace("Õ", "\u00d5");
	    mensagem = mensagem.replace("Ö", "\u00d6");
	    mensagem = mensagem.replace("ú", "\u00fa");
	    mensagem = mensagem.replace("ù", "\u00f9");
	    mensagem = mensagem.replace("û", "\u00fb");
	    mensagem = mensagem.replace("ü", "\u00fc");
	    mensagem = mensagem.replace("Ú", "\u00da");
	    mensagem = mensagem.replace("Ù", "\u00d9");
	    mensagem = mensagem.replace("Û", "\u00db");
	    mensagem = mensagem.replace("ç", "\u00e7");
	    mensagem = mensagem.replace("Ç", "\u00c7");
	    mensagem = mensagem.replace("ñ", "\u00f1");
	    mensagem = mensagem.replace("Ñ", "\u00d1");
	    mensagem = mensagem.replace("&", "\u0026");
	
	    return mensagem;
    }
}