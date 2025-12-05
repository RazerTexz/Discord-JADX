package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: KotlinClassFinder.kt */
/* renamed from: d0.e0.p.d.m0.e.b.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class KotlinClassFinder2 {
    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, ClassId classId) {
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics3.checkNotNullParameter(classId, "classId");
        KotlinClassFinder.a aVarFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(classId);
        if (aVarFindKotlinClassOrContent == null) {
            return null;
        }
        return aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }

    public static final KotlinJvmBinaryClass findKotlinClass(KotlinClassFinder kotlinClassFinder, InterfaceC11574g interfaceC11574g) {
        Intrinsics3.checkNotNullParameter(kotlinClassFinder, "<this>");
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "javaClass");
        KotlinClassFinder.a aVarFindKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(interfaceC11574g);
        if (aVarFindKotlinClassOrContent == null) {
            return null;
        }
        return aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }
}
