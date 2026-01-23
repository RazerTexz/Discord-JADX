package p007b.p195g.p196a.p198b.p200p;

import p007b.p195g.p196a.p198b.p204t.BufferRecycler;

/* JADX INFO: renamed from: b.g.a.b.p.c, reason: use source file name */
/* JADX INFO: compiled from: IOContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class IOContext {

    /* JADX INFO: renamed from: a */
    public final Object f4545a;

    /* JADX INFO: renamed from: b */
    public final boolean f4546b;

    /* JADX INFO: renamed from: c */
    public final BufferRecycler f4547c;

    /* JADX INFO: renamed from: d */
    public byte[] f4548d;

    /* JADX INFO: renamed from: e */
    public char[] f4549e;

    public IOContext(BufferRecycler bufferRecycler, Object obj, boolean z2) {
        this.f4547c = bufferRecycler;
        this.f4545a = obj;
        this.f4546b = z2;
    }

    /* JADX INFO: renamed from: a */
    public void m1695a(byte[] bArr) {
        byte[] bArr2 = this.f4548d;
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw new IllegalArgumentException("Trying to release buffer smaller than original");
        }
        this.f4548d = null;
        this.f4547c.f4593c.set(3, bArr);
    }
}
