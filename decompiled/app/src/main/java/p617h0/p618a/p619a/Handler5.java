package p617h0.p618a.p619a;

/* compiled from: Handler.java */
/* renamed from: h0.a.a.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class Handler5 {

    /* renamed from: a */
    public final Label2 f26242a;

    /* renamed from: b */
    public final Label2 f26243b;

    /* renamed from: c */
    public final Label2 f26244c;

    /* renamed from: d */
    public final int f26245d;

    /* renamed from: e */
    public final String f26246e;

    /* renamed from: f */
    public Handler5 f26247f;

    public Handler5(Label2 label2, Label2 label22, Label2 label23, int i, String str) {
        this.f26242a = label2;
        this.f26243b = label22;
        this.f26244c = label23;
        this.f26245d = i;
        this.f26246e = str;
    }

    /* renamed from: a */
    public static Handler5 m10586a(Handler5 handler5, Label2 label2, Label2 label22) {
        if (handler5 == null) {
            return null;
        }
        Handler5 handler5M10586a = m10586a(handler5.f26247f, label2, label22);
        handler5.f26247f = handler5M10586a;
        Label2 label23 = handler5.f26242a;
        int i = label23.f26252e;
        Label2 label24 = handler5.f26243b;
        int i2 = label24.f26252e;
        int i3 = label2.f26252e;
        int i4 = label22 == null ? Integer.MAX_VALUE : label22.f26252e;
        if (i3 >= i2 || i4 <= i) {
            return handler5;
        }
        if (i3 <= i) {
            return i4 >= i2 ? handler5M10586a : new Handler5(handler5, label22, label24);
        }
        if (i4 >= i2) {
            return new Handler5(handler5, label23, label2);
        }
        handler5.f26247f = new Handler5(handler5, label22, label24);
        return new Handler5(handler5, handler5.f26242a, label2);
    }

    public Handler5(Handler5 handler5, Label2 label2, Label2 label22) {
        Label2 label23 = handler5.f26244c;
        int i = handler5.f26245d;
        String str = handler5.f26246e;
        this.f26242a = label2;
        this.f26243b = label22;
        this.f26244c = label23;
        this.f26245d = i;
        this.f26246e = str;
        this.f26247f = handler5.f26247f;
    }
}
