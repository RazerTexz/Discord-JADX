package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;

/* compiled from: Size.java */
/* renamed from: b.o.a.x.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Size3 implements Comparable<Size3> {

    /* renamed from: j */
    public final int f14251j;

    /* renamed from: k */
    public final int f14252k;

    public Size3(int i, int i2) {
        this.f14251j = i;
        this.f14252k = i2;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Size3 size3) {
        Size3 size32 = size3;
        return (this.f14251j * this.f14252k) - (size32.f14251j * size32.f14252k);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size3)) {
            return false;
        }
        Size3 size3 = (Size3) obj;
        return this.f14251j == size3.f14251j && this.f14252k == size3.f14252k;
    }

    /* renamed from: f */
    public Size3 m7451f() {
        return new Size3(this.f14252k, this.f14251j);
    }

    public int hashCode() {
        int i = this.f14252k;
        int i2 = this.f14251j;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    @NonNull
    public String toString() {
        return this.f14251j + "x" + this.f14252k;
    }
}
