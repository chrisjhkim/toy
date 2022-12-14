package com.chrisjhkim.config;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


/**
 * com.google.gson.Gson stringify 지원가능하게
 */
public class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


	@Override
	public JsonElement serialize(LocalDateTime localDateTime, Type srcType, JsonSerializationContext context) {
		return new JsonPrimitive(formatter.format(localDateTime));
	}
}