package br.com.each.util;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import org.joda.time.LocalTime;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;

@Convert(LocalTime.class)
public class MeuLocalTimeConverter implements Converter<LocalTime> {

	public MeuLocalTimeConverter() {
	}

	public LocalTime convert(String value, Class<? extends LocalTime> type, ResourceBundle bundle) {
		try {
			return new LocalTime(new SimpleDateFormat("HH:mm").parse(value));
		} catch (Exception e) {
			throw new ConversionError(MessageFormat.format(bundle.getString("is_not_a_valid_time"), value));
		}
	}
}