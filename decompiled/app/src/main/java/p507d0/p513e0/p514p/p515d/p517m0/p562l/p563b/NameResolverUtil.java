package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NameResolverUtil.kt */
/* renamed from: d0.e0.p.d.m0.l.b.w, reason: use source file name */
/* loaded from: classes3.dex */
public final class NameResolverUtil {
    public static final ClassId getClassId(NameResolver nameResolver, int i) {
        Intrinsics3.checkNotNullParameter(nameResolver, "<this>");
        ClassId classIdFromString = ClassId.fromString(nameResolver.getQualifiedClassName(i), nameResolver.isLocalClassName(i));
        Intrinsics3.checkNotNullExpressionValue(classIdFromString, "fromString(getQualifiedClassName(index), isLocalClassName(index))");
        return classIdFromString;
    }

    public static final Name getName(NameResolver nameResolver, int i) {
        Intrinsics3.checkNotNullParameter(nameResolver, "<this>");
        Name nameGuessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(i));
        Intrinsics3.checkNotNullExpressionValue(nameGuessByFirstCharacter, "guessByFirstCharacter(getString(index))");
        return nameGuessByFirstCharacter;
    }
}
