package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqNameUnsafe;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.j, reason: use source file name */
/* JADX INFO: compiled from: BuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltinSpecialProperties2 {
    public static final FqName access$child(FqName fqName, String str) {
        FqName fqNameChild = fqName.child(Name.identifier(str));
        Intrinsics3.checkNotNullExpressionValue(fqNameChild, "child(Name.identifier(name))");
        return fqNameChild;
    }

    public static final FqName access$childSafe(FqNameUnsafe fqNameUnsafe, String str) {
        FqName safe = fqNameUnsafe.child(Name.identifier(str)).toSafe();
        Intrinsics3.checkNotNullExpressionValue(safe, "child(Name.identifier(name)).toSafe()");
        return safe;
    }
}
