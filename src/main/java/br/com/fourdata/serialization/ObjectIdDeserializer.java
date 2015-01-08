package br.com.fourdata.serialization;

import java.lang.reflect.Type;

import org.bson.types.ObjectId;

import br.com.caelum.vraptor.ioc.Component;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

@Component
public class ObjectIdDeserializer implements JsonDeserializer<ObjectId> {

	@Override
	public ObjectId deserialize(JsonElement json, Type type, JsonDeserializationContext ctx)
			throws JsonParseException {
		return new ObjectId(json.getAsString());
	}

}