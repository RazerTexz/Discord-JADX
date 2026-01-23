package p007b.p195g.p196a.p205c.p212e0;

import java.util.Collection;
import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder;

/* JADX INFO: renamed from: b.g.a.c.e0.f, reason: use source file name */
/* JADX INFO: compiled from: TypeResolverBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeResolverBuilder<T extends TypeResolverBuilder<T>> {
    /* JADX INFO: renamed from: a */
    T mo1949a(boolean z2);

    /* JADX INFO: renamed from: b */
    T mo1950b(JsonTypeInfo.b bVar, TypeIdResolver typeIdResolver);

    /* JADX INFO: renamed from: c */
    T mo1951c(String str);

    /* JADX INFO: renamed from: d */
    T mo1952d(Class<?> cls);

    /* JADX INFO: renamed from: e */
    TypeSerializer mo1953e(SerializationConfig serializationConfig, JavaType javaType, Collection<NamedType> collection);

    /* JADX INFO: renamed from: f */
    T mo1954f(JsonTypeInfo.a aVar);
}
