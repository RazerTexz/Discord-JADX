package b.g.a.c.y;

import b.g.a.c.i0.e;
import b.g.a.c.n;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonSerialize.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface e {

    /* compiled from: JsonSerialize.java */
    @Deprecated
    public enum a {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT,
        NON_EMPTY,
        DEFAULT_INCLUSION
    }

    /* compiled from: JsonSerialize.java */
    public enum b {
        DYNAMIC,
        STATIC,
        DEFAULT_TYPING
    }

    Class<?> as() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends b.g.a.c.i0.e> contentConverter() default e.a.class;

    Class<? extends n> contentUsing() default n.a.class;

    Class<? extends b.g.a.c.i0.e> converter() default e.a.class;

    @Deprecated
    a include() default a.DEFAULT_INCLUSION;

    Class<?> keyAs() default Void.class;

    Class<? extends n> keyUsing() default n.a.class;

    Class<? extends n> nullsUsing() default n.a.class;

    b typing() default b.DEFAULT_TYPING;

    Class<? extends n> using() default n.a.class;
}
