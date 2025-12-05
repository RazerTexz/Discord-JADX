package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ClassLiteralValue.kt */
/* renamed from: d0.e0.p.d.m0.k.v.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class ClassLiteralValue {

    /* renamed from: a */
    public final ClassId f24436a;

    /* renamed from: b */
    public final int f24437b;

    public ClassLiteralValue(ClassId classId, int i) {
        Intrinsics3.checkNotNullParameter(classId, "classId");
        this.f24436a = classId;
        this.f24437b = i;
    }

    public final ClassId component1() {
        return this.f24436a;
    }

    public final int component2() {
        return this.f24437b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassLiteralValue)) {
            return false;
        }
        ClassLiteralValue classLiteralValue = (ClassLiteralValue) obj;
        return Intrinsics3.areEqual(this.f24436a, classLiteralValue.f24436a) && this.f24437b == classLiteralValue.f24437b;
    }

    public final int getArrayNestedness() {
        return this.f24437b;
    }

    public final ClassId getClassId() {
        return this.f24436a;
    }

    public int hashCode() {
        return (this.f24436a.hashCode() * 31) + this.f24437b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int arrayNestedness = getArrayNestedness();
        for (int i = 0; i < arrayNestedness; i++) {
            sb.append("kotlin/Array<");
        }
        sb.append(getClassId());
        int arrayNestedness2 = getArrayNestedness();
        for (int i2 = 0; i2 < arrayNestedness2; i2++) {
            sb.append(">");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
