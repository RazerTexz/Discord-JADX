package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.z, reason: use source file name */
/* JADX INFO: compiled from: Modality.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum Modality {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;


    /* JADX INFO: renamed from: j */
    public static final a f23104j = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.z$a */
    /* JADX INFO: compiled from: Modality.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Modality convertFromFlags(boolean z2, boolean z3, boolean z4) {
            return z2 ? Modality.SEALED : z3 ? Modality.ABSTRACT : z4 ? Modality.OPEN : Modality.FINAL;
        }
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static Modality[] valuesCustom() {
        Modality[] modalityArrValuesCustom = values();
        Modality[] modalityArr = new Modality[modalityArrValuesCustom.length];
        System.arraycopy(modalityArrValuesCustom, 0, modalityArr, 0, modalityArrValuesCustom.length);
        return modalityArr;
    }
}
