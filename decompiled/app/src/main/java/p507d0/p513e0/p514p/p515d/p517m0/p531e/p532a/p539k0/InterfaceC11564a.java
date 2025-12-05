package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: javaElements.kt */
/* renamed from: d0.e0.p.d.m0.e.a.k0.a */
/* loaded from: classes3.dex */
public interface InterfaceC11564a extends InterfaceC11579l {

    /* compiled from: javaElements.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.k0.a$a */
    public static final class a {
        public static boolean isFreshlySupportedTypeUseAnnotation(InterfaceC11564a interfaceC11564a) {
            Intrinsics3.checkNotNullParameter(interfaceC11564a, "this");
            return false;
        }

        public static boolean isIdeExternalAnnotation(InterfaceC11564a interfaceC11564a) {
            Intrinsics3.checkNotNullParameter(interfaceC11564a, "this");
            return false;
        }
    }

    Collection<annotationArguments> getArguments();

    ClassId getClassId();

    boolean isFreshlySupportedTypeUseAnnotation();

    boolean isIdeExternalAnnotation();

    InterfaceC11574g resolve();
}
