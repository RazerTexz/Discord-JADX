package p007b.p195g.p196a.p198b.p200p;

import p007b.p195g.p196a.p198b.p204t.BufferRecycler;

/* compiled from: IOContext.java */
/* renamed from: b.g.a.b.p.c, reason: use source file name */
/* loaded from: classes3.dex */
public class IOContext {

    /* renamed from: a */
    public final Object f4545a;

    /* renamed from: b */
    public final boolean f4546b;

    /* renamed from: c */
    public final BufferRecycler f4547c;

    /* renamed from: d */
    public byte[] f4548d;

    /* renamed from: e */
    public char[] f4549e;

    public IOContext(BufferRecycler bufferRecycler, Object obj, boolean z2) {
        this.f4547c = bufferRecycler;
        this.f4545a = obj;
        this.f4546b = z2;
    }

    /* renamed from: a */
    public void m1695a(byte[] bArr) {
        byte[] bArr2 = this.f4548d;
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw new IllegalArgumentException("Trying to release buffer smaller than original");
        }
        this.f4548d = null;
        this.f4547c.f4593c.set(3, bArr);
    }
}
