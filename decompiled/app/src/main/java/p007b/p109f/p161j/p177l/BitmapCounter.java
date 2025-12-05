package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p123h.ResourceReleaser;
import p007b.p109f.p186k.BitmapUtil;

/* compiled from: BitmapCounter.java */
/* renamed from: b.f.j.l.b, reason: use source file name */
/* loaded from: classes3.dex */
public class BitmapCounter {

    /* renamed from: a */
    public int f3917a;

    /* renamed from: b */
    public long f3918b;

    /* renamed from: c */
    public final int f3919c;

    /* renamed from: d */
    public final int f3920d;

    /* renamed from: e */
    public final ResourceReleaser<Bitmap> f3921e;

    /* compiled from: BitmapCounter.java */
    /* renamed from: b.f.j.l.b$a */
    public class a implements ResourceReleaser<Bitmap> {
        public a() {
        }

        @Override // p007b.p109f.p115d.p123h.ResourceReleaser
        public void release(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            try {
                BitmapCounter.this.m1371a(bitmap2);
            } finally {
                bitmap2.recycle();
            }
        }
    }

    public BitmapCounter(int i, int i2) {
        AnimatableValueParser.m527i(Boolean.valueOf(i > 0));
        AnimatableValueParser.m527i(Boolean.valueOf(i2 > 0));
        this.f3919c = i;
        this.f3920d = i2;
        this.f3921e = new a();
    }

    /* renamed from: a */
    public synchronized void m1371a(Bitmap bitmap) {
        int iM1541d = BitmapUtil.m1541d(bitmap);
        AnimatableValueParser.m535k(this.f3917a > 0, "No bitmaps registered.");
        long j = iM1541d;
        boolean z2 = j <= this.f3918b;
        Object[] objArr = {Integer.valueOf(iM1541d), Long.valueOf(this.f3918b)};
        if (!z2) {
            throw new IllegalArgumentException(AnimatableValueParser.m536k0("Bitmap size bigger than the total registered size: %d, %d", objArr));
        }
        this.f3918b -= j;
        this.f3917a--;
    }

    /* renamed from: b */
    public synchronized int m1372b() {
        return this.f3920d;
    }
}
