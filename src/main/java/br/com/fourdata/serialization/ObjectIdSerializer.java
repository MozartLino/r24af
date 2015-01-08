package br.com.fourdata.serialization;

import java.lang.reflect.Type;

import org.bson.types.ObjectId;

import br.com.caelum.vraptor.ioc.Component;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@Component
public class ObjectIdSerializer implements JsonSerializer<ObjectId> {

	@Override
	public JsonElement serialize(ObjectId objectId, Type type, JsonSerializationContext context) {
		return new JsonPrimitive(objectId.toStringMongod());
	}

}