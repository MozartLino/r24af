package br.com.fourdata.serialization;

import br.com.caelum.vraptor.ioc.Component;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

@Component
public class CircularReferencePrevention implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(JsonExclude.class) != null;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}

}