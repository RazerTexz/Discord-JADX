package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: IncompatibleVersionErrorData.kt */
/* renamed from: d0.e0.p.d.m0.l.b.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class IncompatibleVersionErrorData<T> {

    /* renamed from: a */
    public final T f24678a;

    /* renamed from: b */
    public final T f24679b;

    /* renamed from: c */
    public final String f24680c;

    /* renamed from: d */
    public final ClassId f24681d;

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId) {
        Intrinsics3.checkNotNullParameter(str, "filePath");
        Intrinsics3.checkNotNullParameter(classId, "classId");
        this.f24678a = t;
        this.f24679b = t2;
        this.f24680c = str;
        this.f24681d = classId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics3.areEqual(this.f24678a, incompatibleVersionErrorData.f24678a) && Intrinsics3.areEqual(this.f24679b, incompatibleVersionErrorData.f24679b) && Intrinsics3.areEqual(this.f24680c, incompatibleVersionErrorData.f24680c) && Intrinsics3.areEqual(this.f24681d, incompatibleVersionErrorData.f24681d);
    }

    public int hashCode() {
        T t = this.f24678a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.f24679b;
        return this.f24681d.hashCode() + outline.m863m(this.f24680c, (iHashCode + (t2 != null ? t2.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("IncompatibleVersionErrorData(actualVersion=");
        sbM833U.append(this.f24678a);
        sbM833U.append(", expectedVersion=");
        sbM833U.append(this.f24679b);
        sbM833U.append(", filePath=");
        sbM833U.append(this.f24680c);
        sbM833U.append(", classId=");
        sbM833U.append(this.f24681d);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
