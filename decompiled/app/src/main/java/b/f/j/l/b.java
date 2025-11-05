package b.f.j.l;

import android.graphics.Bitmap;

/* compiled from: BitmapCounter.java */
/* loaded from: classes3.dex */
public class b {
    public int a;

    /* renamed from: b, reason: collision with root package name */
    public long f592b;
    public final int c;
    public final int d;
    public final b.f.d.h.f<Bitmap> e;

    /* compiled from: BitmapCounter.java */
    public class a implements b.f.d.h.f<Bitmap> {
        public a() {
        }

        @Override // b.f.d.h.f
        public void release(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            try {
                b.this.a(bitmap2);
            } finally {
                bitmap2.recycle();
            }
        }
    }

    public b(int i, int i2) {
        b.c.a.a0.d.i(Boolean.valueOf(i > 0));
        b.c.a.a0.d.i(Boolean.valueOf(i2 > 0));
        this.c = i;
        this.d = i2;
        this.e = new a();
    }

    public synchronized void a(Bitmap bitmap) {
        int iD = b.f.k.a.d(bitmap);
        b.c.a.a0.d.k(this.a > 0, "No bitmaps registered.");
        long j = iD;
        boolean z2 = j <= this.f592b;
        Object[] objArr = {Integer.valueOf(iD), Long.valueOf(this.f592b)};
        if (!z2) {
            throw new IllegalArgumentException(b.c.a.a0.d.k0("Bitmap size bigger than the total registered size: %d, %d", objArr));
        }
        this.f592b -= j;
        this.a--;
    }

    public synchronized int b() {
        return this.d;
    }
}
