package d0.e0.p.d.m0.c;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Modality.kt */
/* loaded from: classes3.dex */
public enum z {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;

    public static final a j = new a(null);

    /* compiled from: Modality.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final z convertFromFlags(boolean z2, boolean z3, boolean z4) {
            return z2 ? z.SEALED : z3 ? z.ABSTRACT : z4 ? z.OPEN : z.FINAL;
        }
    }

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static z[] valuesCustom() {
        z[] zVarArrValuesCustom = values();
        z[] zVarArr = new z[zVarArrValuesCustom.length];
        System.arraycopy(zVarArrValuesCustom, 0, zVarArr, 0, zVarArrValuesCustom.length);
        return zVarArr;
    }
}
