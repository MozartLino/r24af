package br.com.fourdata.serialization;

import java.lang.reflect.Type;

import org.joda.time.LocalDateTime;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

//@Component
public class LocalDateTimeConverter implements JsonSerializer<LocalDateTime> {

	@Override
	public JsonElement serialize(LocalDateTime calendar, Type typeOfSrc, JsonSerializationContext context) {
		String json = "{}";

		return new JsonParser().parse(json).getAsJsonObject();
	}
}
