package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11979h;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.t0, reason: use source file name */
/* JADX INFO: compiled from: TypeCapabilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeCapabilities2 {
    public static final TypeCapabilities getCustomTypeVariable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        InterfaceC11979h interfaceC11979hUnwrap = kotlinType.unwrap();
        TypeCapabilities typeCapabilities = interfaceC11979hUnwrap instanceof TypeCapabilities ? (TypeCapabilities) interfaceC11979hUnwrap : null;
        if (typeCapabilities != null && typeCapabilities.isTypeVariable()) {
            return typeCapabilities;
        }
        return null;
    }

    public static final boolean isCustomTypeVariable(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        InterfaceC11979h interfaceC11979hUnwrap = kotlinType.unwrap();
        TypeCapabilities typeCapabilities = interfaceC11979hUnwrap instanceof TypeCapabilities ? (TypeCapabilities) interfaceC11979hUnwrap : null;
        if (typeCapabilities == null) {
            return false;
        }
        return typeCapabilities.isTypeVariable();
    }
}
