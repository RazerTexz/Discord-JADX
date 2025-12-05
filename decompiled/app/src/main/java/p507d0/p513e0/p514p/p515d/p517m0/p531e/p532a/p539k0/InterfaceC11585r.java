package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0;

import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: javaElements.kt */
/* renamed from: d0.e0.p.d.m0.e.a.k0.r */
/* loaded from: classes3.dex */
public interface InterfaceC11585r extends InterfaceC11584q, InterfaceC11593z {

    /* compiled from: javaElements.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.k0.r$a */
    public static final class a {
        public static boolean getHasAnnotationParameterDefaultValue(InterfaceC11585r interfaceC11585r) {
            Intrinsics3.checkNotNullParameter(interfaceC11585r, "this");
            return interfaceC11585r.getAnnotationParameterDefaultValue() != null;
        }
    }

    annotationArguments getAnnotationParameterDefaultValue();

    boolean getHasAnnotationParameterDefaultValue();

    javaTypes5 getReturnType();

    List<InterfaceC11565a0> getValueParameters();
}
