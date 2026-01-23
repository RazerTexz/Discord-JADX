package p007b.p195g.p196a.p205c.p220y;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder;

/* JADX INFO: renamed from: b.g.a.c.y.g, reason: use source file name */
/* JADX INFO: compiled from: JsonTypeResolver.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonTypeResolver {
    Class<? extends TypeResolverBuilder<?>> value();
}
