package p617h0.p618a.p619a;

import java.util.Arrays;

/* JADX INFO: renamed from: h0.a.a.g, reason: use source file name */
/* JADX INFO: compiled from: ConstantDynamic.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ConstantDynamic2 {

    /* JADX INFO: renamed from: a */
    public final String f26190a;

    /* JADX INFO: renamed from: b */
    public final String f26191b;

    /* JADX INFO: renamed from: c */
    public final Handle2 f26192c;

    /* JADX INFO: renamed from: d */
    public final Object[] f26193d;

    public ConstantDynamic2(String str, String str2, Handle2 handle2, Object... objArr) {
        this.f26190a = str;
        this.f26191b = str2;
        this.f26192c = handle2;
        this.f26193d = objArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConstantDynamic2)) {
            return false;
        }
        ConstantDynamic2 constantDynamic2 = (ConstantDynamic2) obj;
        return this.f26190a.equals(constantDynamic2.f26190a) && this.f26191b.equals(constantDynamic2.f26191b) && this.f26192c.equals(constantDynamic2.f26192c) && Arrays.equals(this.f26193d, constantDynamic2.f26193d);
    }

    public int hashCode() {
        return ((this.f26190a.hashCode() ^ Integer.rotateLeft(this.f26191b.hashCode(), 8)) ^ Integer.rotateLeft(this.f26192c.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.f26193d), 24);
    }

    public String toString() {
        return this.f26190a + " : " + this.f26191b + ' ' + this.f26192c + ' ' + Arrays.toString(this.f26193d);
    }
}
