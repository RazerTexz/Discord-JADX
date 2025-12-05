package p007b.p225i.p226a.p242c.p259f3;

import java.util.Arrays;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: LongArray.java */
/* renamed from: b.i.a.c.f3.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class LongArray {

    /* renamed from: a */
    public int f6747a;

    /* renamed from: b */
    public long[] f6748b = new long[32];

    /* renamed from: a */
    public void m3041a(long j) {
        int i = this.f6747a;
        long[] jArr = this.f6748b;
        if (i == jArr.length) {
            this.f6748b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f6748b;
        int i2 = this.f6747a;
        this.f6747a = i2 + 1;
        jArr2[i2] = j;
    }

    /* renamed from: b */
    public long m3042b(int i) {
        if (i < 0 || i >= this.f6747a) {
            throw new IndexOutOfBoundsException(outline.m853h(46, "Invalid index ", i, ", size is ", this.f6747a));
        }
        return this.f6748b[i];
    }
}
