package com.chrisjhkim.util;

import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

import com.chrisjhkim.config.LocalDateSerializer;
import com.chrisjhkim.config.LocalDateTimeSerializer;
import com.chrisjhkim.config.YearMonthSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

public class GsonUtil {
	
	@Expose
	public static final Gson gson =  new GsonBuilder()
			.enableComplexMapKeySerialization()
			.excludeFieldsWithModifiers(Modifier.FINAL|Modifier.TRANSIENT)
			.registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
			.registerTypeAdapter(YearMonth.class, new YearMonthSerializer())
			.disableHtmlEscaping()
			.create();

	

}
