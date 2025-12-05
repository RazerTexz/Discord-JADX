package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import kotlin.NoWhenBranchMatchedException;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11686k;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11699x;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.Variance;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ProtoEnumFlags.kt */
/* renamed from: d0.e0.p.d.m0.l.b.z, reason: use source file name */
/* loaded from: classes3.dex */
public final class ProtoEnumFlags {

    /* renamed from: a */
    public static final ProtoEnumFlags f24700a = new ProtoEnumFlags();

    /* compiled from: ProtoEnumFlags.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.z$a */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f24701a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f24702b;

        /* renamed from: c */
        public static final /* synthetic */ int[] f24703c;

        /* renamed from: d */
        public static final /* synthetic */ int[] f24704d;

        static {
            EnumC11686k.values();
            f24701a = new int[]{1, 2, 3, 4};
            Modality.valuesCustom();
            Modality modality = Modality.FINAL;
            Modality modality2 = Modality.OPEN;
            Modality modality3 = Modality.ABSTRACT;
            Modality modality4 = Modality.SEALED;
            EnumC11699x.values();
            C11678c.c.values();
            f24702b = new int[]{1, 2, 3, 4, 5, 6, 7};
            ClassKind.values();
            C11694s.c.values();
            f24703c = new int[]{1, 2, 3};
            C11692q.b.c.values();
            f24704d = new int[]{1, 2, 3, 4};
            Variance.valuesCustom();
        }
    }

    public final ClassKind classKind(C11678c.c cVar) {
        ClassKind classKind = ClassKind.CLASS;
        switch (cVar == null ? -1 : a.f24702b[cVar.ordinal()]) {
            case 1:
            default:
                return classKind;
            case 2:
                return ClassKind.INTERFACE;
            case 3:
                return ClassKind.ENUM_CLASS;
            case 4:
                return ClassKind.ENUM_ENTRY;
            case 5:
                return ClassKind.ANNOTATION_CLASS;
            case 6:
            case 7:
                return ClassKind.OBJECT;
        }
    }

    public final Modality modality(EnumC11686k enumC11686k) {
        int i = enumC11686k == null ? -1 : a.f24701a[enumC11686k.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? Modality.FINAL : Modality.SEALED : Modality.ABSTRACT : Modality.OPEN : Modality.FINAL;
    }

    public final Variance variance(C11694s.c cVar) {
        Intrinsics3.checkNotNullParameter(cVar, "variance");
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return Variance.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return Variance.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return Variance.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Variance variance(C11692q.b.c cVar) {
        Intrinsics3.checkNotNullParameter(cVar, "projection");
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return Variance.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return Variance.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return Variance.INVARIANT;
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException(Intrinsics3.stringPlus("Only IN, OUT and INV are supported. Actual argument: ", cVar));
    }
}
