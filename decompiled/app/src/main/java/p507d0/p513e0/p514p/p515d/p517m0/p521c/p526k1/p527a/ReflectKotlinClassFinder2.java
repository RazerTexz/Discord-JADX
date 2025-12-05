package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectKotlinClassFinder.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.a.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectKotlinClassFinder2 {
    public static final String access$toRuntimeFqName(ClassId classId) {
        String strAsString = classId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "relativeClassName.asString()");
        String strReplace$default = StringsJVM.replace$default(strAsString, '.', '$', false, 4, (Object) null);
        if (classId.getPackageFqName().isRoot()) {
            return strReplace$default;
        }
        return classId.getPackageFqName() + '.' + strReplace$default;
    }
}
