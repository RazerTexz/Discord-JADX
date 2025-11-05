package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.f.c;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.n.j1;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: ProtoEnumFlags.kt */
/* loaded from: classes3.dex */
public final class z {
    public static final z a = new z();

    /* compiled from: ProtoEnumFlags.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3511b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;

        static {
            d0.e0.p.d.m0.f.k.values();
            a = new int[]{1, 2, 3, 4};
            d0.e0.p.d.m0.c.z.valuesCustom();
            d0.e0.p.d.m0.c.z zVar = d0.e0.p.d.m0.c.z.FINAL;
            d0.e0.p.d.m0.c.z zVar2 = d0.e0.p.d.m0.c.z.OPEN;
            d0.e0.p.d.m0.c.z zVar3 = d0.e0.p.d.m0.c.z.ABSTRACT;
            d0.e0.p.d.m0.c.z zVar4 = d0.e0.p.d.m0.c.z.SEALED;
            d0.e0.p.d.m0.f.x.values();
            c.EnumC0550c.values();
            f3511b = new int[]{1, 2, 3, 4, 5, 6, 7};
            d0.e0.p.d.m0.c.f.values();
            s.c.values();
            c = new int[]{1, 2, 3};
            q.b.c.values();
            d = new int[]{1, 2, 3, 4};
            j1.valuesCustom();
        }
    }

    public final d0.e0.p.d.m0.c.f classKind(c.EnumC0550c enumC0550c) {
        d0.e0.p.d.m0.c.f fVar = d0.e0.p.d.m0.c.f.CLASS;
        switch (enumC0550c == null ? -1 : a.f3511b[enumC0550c.ordinal()]) {
            case 1:
            default:
                return fVar;
            case 2:
                return d0.e0.p.d.m0.c.f.INTERFACE;
            case 3:
                return d0.e0.p.d.m0.c.f.ENUM_CLASS;
            case 4:
                return d0.e0.p.d.m0.c.f.ENUM_ENTRY;
            case 5:
                return d0.e0.p.d.m0.c.f.ANNOTATION_CLASS;
            case 6:
            case 7:
                return d0.e0.p.d.m0.c.f.OBJECT;
        }
    }

    public final d0.e0.p.d.m0.c.z modality(d0.e0.p.d.m0.f.k kVar) {
        int i = kVar == null ? -1 : a.a[kVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? d0.e0.p.d.m0.c.z.FINAL : d0.e0.p.d.m0.c.z.SEALED : d0.e0.p.d.m0.c.z.ABSTRACT : d0.e0.p.d.m0.c.z.OPEN : d0.e0.p.d.m0.c.z.FINAL;
    }

    public final j1 variance(s.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "variance");
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return j1.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return j1.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return j1.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final j1 variance(q.b.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "projection");
        int iOrdinal = cVar.ordinal();
        if (iOrdinal == 0) {
            return j1.IN_VARIANCE;
        }
        if (iOrdinal == 1) {
            return j1.OUT_VARIANCE;
        }
        if (iOrdinal == 2) {
            return j1.INVARIANT;
        }
        if (iOrdinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException(d0.z.d.m.stringPlus("Only IN, OUT and INV are supported. Actual argument: ", cVar));
    }
}
