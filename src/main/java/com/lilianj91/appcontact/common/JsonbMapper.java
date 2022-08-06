package com.lilianj91.appcontact.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.JSONB;
import org.springframework.stereotype.Component;

@Component
public class JsonbMapper {

    private final ObjectMapper objectMapper;

    public JsonbMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public JSONB map(Object object) throws JsonProcessingException {
        return JSONB.jsonb(objectMapper.writeValueAsString(object));
    }

    public <T> T map(JSONB jsonb, Class<T> tclass) throws JsonProcessingException {
        return objectMapper.readValue(jsonb.data(), tclass);
    }
}