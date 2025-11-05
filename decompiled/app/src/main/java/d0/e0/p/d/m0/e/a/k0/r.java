package d0.e0.p.d.m0.e.a.k0;

import java.util.List;

/* compiled from: javaElements.kt */
/* loaded from: classes3.dex */
public interface r extends q, z {

    /* compiled from: javaElements.kt */
    public static final class a {
        public static boolean getHasAnnotationParameterDefaultValue(r rVar) {
            d0.z.d.m.checkNotNullParameter(rVar, "this");
            return rVar.getAnnotationParameterDefaultValue() != null;
        }
    }

    b getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    x getReturnType();

    List<a0> getValueParameters();
}
