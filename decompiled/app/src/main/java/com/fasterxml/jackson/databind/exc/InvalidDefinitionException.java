package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.databind.JsonMappingException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonParser;
import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidDefinitionException extends JsonMappingException {
    public final JavaType _type;

    public InvalidDefinitionException(JsonParser jsonParser, String str, JavaType javaType) {
        super(jsonParser, str);
        this._type = javaType;
    }

    public InvalidDefinitionException(JsonGenerator jsonGenerator, String str, JavaType javaType) {
        super(jsonGenerator, str);
        this._type = javaType;
    }

    public InvalidDefinitionException(JsonGenerator jsonGenerator, String str, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition) {
        super(jsonGenerator, str);
        this._type = beanDescription == null ? null : beanDescription.f4626a;
    }
}
