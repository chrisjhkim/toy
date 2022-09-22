package com.chrisjhkim.config;

import java.lang.reflect.Type;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


/**
 * com.google.gson.Gson stringify 지원가능하게
 */
public class YearMonthSerializer implements JsonSerializer<YearMonth> {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
	
	@Override
	public JsonElement serialize(YearMonth yearMonth, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(formatter.format(yearMonth));
	}

}
