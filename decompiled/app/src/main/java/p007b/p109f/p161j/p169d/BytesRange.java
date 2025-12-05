package p007b.p109f.p161j.p169d;

import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: BytesRange.java */
/* renamed from: b.f.j.d.a, reason: use source file name */
/* loaded from: classes.dex */
public class BytesRange {

    /* renamed from: a */
    public final int f3704a;

    /* renamed from: b */
    public final int f3705b;

    public BytesRange(int i, int i2) {
        this.f3704a = i;
        this.f3705b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BytesRange)) {
            return false;
        }
        BytesRange bytesRange = (BytesRange) obj;
        return this.f3704a == bytesRange.f3704a && this.f3705b == bytesRange.f3705b;
    }

    public int hashCode() {
        return AnimatableValueParser.m445J0(this.f3704a, this.f3705b);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        int i = this.f3704a;
        objArr[0] = i == Integer.MAX_VALUE ? "" : Integer.toString(i);
        int i2 = this.f3705b;
        objArr[1] = i2 != Integer.MAX_VALUE ? Integer.toString(i2) : "";
        return String.format(null, "%s-%s", objArr);
    }
}
