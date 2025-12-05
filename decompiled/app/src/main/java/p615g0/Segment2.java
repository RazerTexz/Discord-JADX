package p615g0;

import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Segment.kt */
/* renamed from: g0.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class Segment2 {

    /* renamed from: a */
    public final byte[] f26118a;

    /* renamed from: b */
    public int f26119b;

    /* renamed from: c */
    public int f26120c;

    /* renamed from: d */
    public boolean f26121d;

    /* renamed from: e */
    public boolean f26122e;

    /* renamed from: f */
    public Segment2 f26123f;

    /* renamed from: g */
    public Segment2 f26124g;

    public Segment2() {
        this.f26118a = new byte[8192];
        this.f26122e = true;
        this.f26121d = false;
    }

    /* renamed from: a */
    public final Segment2 m10494a() {
        Segment2 segment2 = this.f26123f;
        if (segment2 == this) {
            segment2 = null;
        }
        Segment2 segment22 = this.f26124g;
        if (segment22 == null) {
            Intrinsics3.throwNpe();
        }
        segment22.f26123f = this.f26123f;
        Segment2 segment23 = this.f26123f;
        if (segment23 == null) {
            Intrinsics3.throwNpe();
        }
        segment23.f26124g = this.f26124g;
        this.f26123f = null;
        this.f26124g = null;
        return segment2;
    }

    /* renamed from: b */
    public final Segment2 m10495b(Segment2 segment2) {
        Intrinsics3.checkParameterIsNotNull(segment2, "segment");
        segment2.f26124g = this;
        segment2.f26123f = this.f26123f;
        Segment2 segment22 = this.f26123f;
        if (segment22 == null) {
            Intrinsics3.throwNpe();
        }
        segment22.f26124g = segment2;
        this.f26123f = segment2;
        return segment2;
    }

    /* renamed from: c */
    public final Segment2 m10496c() {
        this.f26121d = true;
        return new Segment2(this.f26118a, this.f26119b, this.f26120c, true, false);
    }

    /* renamed from: d */
    public final void m10497d(Segment2 segment2, int i) {
        Intrinsics3.checkParameterIsNotNull(segment2, "sink");
        if (!segment2.f26122e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i2 = segment2.f26120c;
        if (i2 + i > 8192) {
            if (segment2.f26121d) {
                throw new IllegalArgumentException();
            }
            int i3 = segment2.f26119b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment2.f26118a;
            _ArraysJvm.copyInto$default(bArr, bArr, 0, i3, i2, 2, (Object) null);
            segment2.f26120c -= segment2.f26119b;
            segment2.f26119b = 0;
        }
        byte[] bArr2 = this.f26118a;
        byte[] bArr3 = segment2.f26118a;
        int i4 = segment2.f26120c;
        int i5 = this.f26119b;
        _ArraysJvm.copyInto(bArr2, bArr3, i4, i5, i5 + i);
        segment2.f26120c += i;
        this.f26119b += i;
    }

    public Segment2(byte[] bArr, int i, int i2, boolean z2, boolean z3) {
        Intrinsics3.checkParameterIsNotNull(bArr, "data");
        this.f26118a = bArr;
        this.f26119b = i;
        this.f26120c = i2;
        this.f26121d = z2;
        this.f26122e = z3;
    }
}
