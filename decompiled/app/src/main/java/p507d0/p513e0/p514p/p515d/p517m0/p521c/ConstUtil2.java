package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.UnsignedType3;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k, reason: use source file name */
/* JADX INFO: compiled from: ConstUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstUtil2 {
    /* JADX WARN: Removed duplicated region for block: B:6:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean canBeUsedForConstVal(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        if (!KotlinBuiltIns.isPrimitiveType(kotlinType)) {
            UnsignedType3 unsignedType3 = UnsignedType3.f22584a;
            if (UnsignedType3.isUnsignedType(kotlinType)) {
                if (TypeUtils.isNullableType(kotlinType)) {
                    if (!KotlinBuiltIns.isString(kotlinType)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
