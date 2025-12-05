package p617h0.p618a.p619a;

/* compiled from: Symbol.java */
/* renamed from: h0.a.a.u, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Symbol2 {

    /* renamed from: a */
    public final int f26340a;

    /* renamed from: b */
    public final int f26341b;

    /* renamed from: c */
    public final String f26342c;

    /* renamed from: d */
    public final String f26343d;

    /* renamed from: e */
    public final String f26344e;

    /* renamed from: f */
    public final long f26345f;

    /* renamed from: g */
    public int f26346g;

    public Symbol2(int i, int i2, String str, String str2, String str3, long j) {
        this.f26340a = i;
        this.f26341b = i2;
        this.f26342c = str;
        this.f26343d = str2;
        this.f26344e = str3;
        this.f26345f = j;
    }

    /* renamed from: a */
    public int m10621a() {
        if (this.f26346g == 0) {
            this.f26346g = Type2.m10645b(this.f26344e);
        }
        return this.f26346g;
    }
}
