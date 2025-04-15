package com.trangile.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

//Global configuration
@Configuration
public class DateTimeConfig {
 @Bean
 public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
     return builder -> {
         builder.serializerByType(LocalDateTime.class, 
                  new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
         builder.deserializerByType(LocalDateTime.class, 
                  new LocalDateTimeDeserializer(DateTimeFormatter.ISO_DATE_TIME));
         builder.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
     };
 }
}
