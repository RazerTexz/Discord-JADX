package b.g.a.c.y;

import b.g.a.a.p;
import b.g.a.c.g0.s;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: JsonAppend.java */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface b {

    /* compiled from: JsonAppend.java */
    public @interface a {
        p.a include() default p.a.NON_NULL;

        String propName() default "";

        String propNamespace() default "";

        boolean required() default false;

        String value();
    }

    /* compiled from: JsonAppend.java */
    /* renamed from: b.g.a.c.y.b$b, reason: collision with other inner class name */
    public @interface InterfaceC0084b {
        p.a include() default p.a.NON_NULL;

        String name() default "";

        String namespace() default "";

        boolean required() default false;

        Class<?> type() default Object.class;

        Class<? extends s> value();
    }

    a[] attrs() default {};

    boolean prepend() default false;

    InterfaceC0084b[] props() default {};
}
