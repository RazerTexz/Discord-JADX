package p007b.p195g.p196a.p205c.p220y;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p007b.p195g.p196a.p205c.PropertyNamingStrategy;

/* JADX INFO: renamed from: b.g.a.c.y.d, reason: use source file name */
/* JADX INFO: compiled from: JsonNaming.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonNaming {
    Class<? extends PropertyNamingStrategy> value() default PropertyNamingStrategy.class;
}
