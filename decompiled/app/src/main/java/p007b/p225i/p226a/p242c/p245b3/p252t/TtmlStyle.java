package p007b.p225i.p226a.p242c.p245b3.p252t;

import android.text.Layout;
import androidx.annotation.Nullable;

/* compiled from: TtmlStyle.java */
/* renamed from: b.i.a.c.b3.t.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class TtmlStyle {

    /* renamed from: a */
    @Nullable
    public String f6073a;

    /* renamed from: b */
    public int f6074b;

    /* renamed from: c */
    public boolean f6075c;

    /* renamed from: d */
    public int f6076d;

    /* renamed from: e */
    public boolean f6077e;

    /* renamed from: k */
    public float f6083k;

    /* renamed from: l */
    @Nullable
    public String f6084l;

    /* renamed from: o */
    @Nullable
    public Layout.Alignment f6087o;

    /* renamed from: p */
    @Nullable
    public Layout.Alignment f6088p;

    /* renamed from: r */
    @Nullable
    public TextEmphasis f6090r;

    /* renamed from: f */
    public int f6078f = -1;

    /* renamed from: g */
    public int f6079g = -1;

    /* renamed from: h */
    public int f6080h = -1;

    /* renamed from: i */
    public int f6081i = -1;

    /* renamed from: j */
    public int f6082j = -1;

    /* renamed from: m */
    public int f6085m = -1;

    /* renamed from: n */
    public int f6086n = -1;

    /* renamed from: q */
    public int f6089q = -1;

    /* renamed from: s */
    public float f6091s = Float.MAX_VALUE;

    /* renamed from: a */
    public TtmlStyle m2701a(@Nullable TtmlStyle ttmlStyle) {
        int i;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (ttmlStyle != null) {
            if (!this.f6075c && ttmlStyle.f6075c) {
                this.f6074b = ttmlStyle.f6074b;
                this.f6075c = true;
            }
            if (this.f6080h == -1) {
                this.f6080h = ttmlStyle.f6080h;
            }
            if (this.f6081i == -1) {
                this.f6081i = ttmlStyle.f6081i;
            }
            if (this.f6073a == null && (str = ttmlStyle.f6073a) != null) {
                this.f6073a = str;
            }
            if (this.f6078f == -1) {
                this.f6078f = ttmlStyle.f6078f;
            }
            if (this.f6079g == -1) {
                this.f6079g = ttmlStyle.f6079g;
            }
            if (this.f6086n == -1) {
                this.f6086n = ttmlStyle.f6086n;
            }
            if (this.f6087o == null && (alignment2 = ttmlStyle.f6087o) != null) {
                this.f6087o = alignment2;
            }
            if (this.f6088p == null && (alignment = ttmlStyle.f6088p) != null) {
                this.f6088p = alignment;
            }
            if (this.f6089q == -1) {
                this.f6089q = ttmlStyle.f6089q;
            }
            if (this.f6082j == -1) {
                this.f6082j = ttmlStyle.f6082j;
                this.f6083k = ttmlStyle.f6083k;
            }
            if (this.f6090r == null) {
                this.f6090r = ttmlStyle.f6090r;
            }
            if (this.f6091s == Float.MAX_VALUE) {
                this.f6091s = ttmlStyle.f6091s;
            }
            if (!this.f6077e && ttmlStyle.f6077e) {
                this.f6076d = ttmlStyle.f6076d;
                this.f6077e = true;
            }
            if (this.f6085m == -1 && (i = ttmlStyle.f6085m) != -1) {
                this.f6085m = i;
            }
        }
        return this;
    }

    /* renamed from: b */
    public int m2702b() {
        int i = this.f6080h;
        if (i == -1 && this.f6081i == -1) {
            return -1;
        }
        return (i == 1 ? 1 : 0) | (this.f6081i == 1 ? 2 : 0);
    }
}
