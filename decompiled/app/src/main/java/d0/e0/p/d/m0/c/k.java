package d0.e0.p.d.m0.c;

/* compiled from: ConstUtil.kt */
/* loaded from: classes3.dex */
public final class k {
    /* JADX WARN: Removed duplicated region for block: B:6:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean canBeUsedForConstVal(d0.e0.p.d.m0.n.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        if (!d0.e0.p.d.m0.b.h.isPrimitiveType(c0Var)) {
            d0.e0.p.d.m0.b.o oVar = d0.e0.p.d.m0.b.o.a;
            if (d0.e0.p.d.m0.b.o.isUnsignedType(c0Var)) {
                if (d0.e0.p.d.m0.n.e1.isNullableType(c0Var)) {
                    if (!d0.e0.p.d.m0.b.h.isString(c0Var)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
