package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.q, reason: use source file name */
/* JADX INFO: compiled from: SerializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SerializerFactory2 {
    /* JADX INFO: renamed from: a */
    public abstract JsonSerializer<Object> mo1971a(SerializerProvider serializerProvider, JavaType javaType, JsonSerializer<Object> jsonSerializer) throws JsonMappingException;

    /* JADX INFO: renamed from: b */
    public abstract JsonSerializer<Object> mo1991b(SerializerProvider serializerProvider, JavaType javaType) throws JsonMappingException;

    /* JADX INFO: renamed from: c */
    public abstract TypeSerializer mo1972c(SerializationConfig serializationConfig, JavaType javaType) throws JsonMappingException;
}
