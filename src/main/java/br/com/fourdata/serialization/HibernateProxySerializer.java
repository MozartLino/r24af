package br.com.fourdata.serialization;

import java.lang.reflect.Type;

import org.hibernate.proxy.HibernateProxy;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class HibernateProxySerializer implements JsonSerializer<HibernateProxy> {

	private Gson gson;

	public HibernateProxySerializer(Gson gson) {
		this.gson = gson;
	}

	@Override
	public JsonElement serialize(HibernateProxy proxyObj, Type arg1, JsonSerializationContext arg2) {
		Object deProxied = proxyObj.getHibernateLazyInitializer().getImplementation();
		return gson.toJsonTree(deProxied);
	}
}