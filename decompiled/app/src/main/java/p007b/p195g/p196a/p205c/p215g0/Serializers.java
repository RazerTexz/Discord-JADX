package p007b.p195g.p196a.p205c.p215g0;

import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p218h0.ArrayType;
import p007b.p195g.p196a.p205c.p218h0.CollectionLikeType;
import p007b.p195g.p196a.p205c.p218h0.CollectionType;
import p007b.p195g.p196a.p205c.p218h0.MapLikeType;
import p007b.p195g.p196a.p205c.p218h0.MapType;
import p007b.p195g.p196a.p205c.p218h0.ReferenceType;

/* JADX INFO: renamed from: b.g.a.c.g0.r, reason: use source file name */
/* JADX INFO: compiled from: Serializers.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Serializers {
    /* JADX INFO: renamed from: a */
    JsonSerializer<?> m2010a(SerializationConfig serializationConfig, ReferenceType referenceType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer);

    /* JADX INFO: renamed from: b */
    JsonSerializer<?> m2011b(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription);

    /* JADX INFO: renamed from: c */
    JsonSerializer<?> m2012c(SerializationConfig serializationConfig, MapType mapType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2);

    /* JADX INFO: renamed from: d */
    JsonSerializer<?> m2013d(SerializationConfig serializationConfig, CollectionLikeType collectionLikeType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer);

    /* JADX INFO: renamed from: e */
    JsonSerializer<?> m2014e(SerializationConfig serializationConfig, ArrayType arrayType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer);

    /* JADX INFO: renamed from: f */
    JsonSerializer<?> m2015f(SerializationConfig serializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2);

    /* JADX INFO: renamed from: g */
    JsonSerializer<?> m2016g(SerializationConfig serializationConfig, CollectionType collectionType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer);
}
