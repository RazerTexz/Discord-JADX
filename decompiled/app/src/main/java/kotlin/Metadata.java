package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Metadata.kt */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface Metadata {
    /* renamed from: bv */
    int[] m10882bv() default {1, 0, 3};

    /* renamed from: d1 */
    String[] m10883d1() default {};

    /* renamed from: d2 */
    String[] m10884d2() default {};

    /* renamed from: k */
    int m10885k() default 1;

    /* renamed from: mv */
    int[] m10886mv() default {};

    /* renamed from: pn */
    String m10887pn() default "";

    /* renamed from: xi */
    int m10888xi() default 0;

    /* renamed from: xs */
    String m10889xs() default "";
}
