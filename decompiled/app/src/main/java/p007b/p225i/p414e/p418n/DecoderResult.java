package p007b.p225i.p414e.p418n;

import java.util.List;

/* compiled from: DecoderResult.java */
/* renamed from: b.i.e.n.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class DecoderResult {

    /* renamed from: a */
    public final byte[] f13266a;

    /* renamed from: b */
    public int f13267b;

    /* renamed from: c */
    public final String f13268c;

    /* renamed from: d */
    public final List<byte[]> f13269d;

    /* renamed from: e */
    public final String f13270e;

    /* renamed from: f */
    public Object f13271f;

    /* renamed from: g */
    public final int f13272g;

    /* renamed from: h */
    public final int f13273h;

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public DecoderResult(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.f13266a = bArr;
        this.f13267b = bArr == null ? 0 : bArr.length * 8;
        this.f13268c = str;
        this.f13269d = list;
        this.f13270e = str2;
        this.f13272g = i2;
        this.f13273h = i;
    }
}
