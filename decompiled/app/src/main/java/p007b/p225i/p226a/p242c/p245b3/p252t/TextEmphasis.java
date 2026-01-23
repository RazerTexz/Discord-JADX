package p007b.p225i.p226a.p242c.p245b3.p252t;

import java.util.regex.Pattern;
import p007b.p225i.p355b.p357b.ImmutableSet2;

/* JADX INFO: renamed from: b.i.a.c.b3.t.b, reason: use source file name */
/* JADX INFO: compiled from: TextEmphasis.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TextEmphasis {

    /* JADX INFO: renamed from: a */
    public static final Pattern f6026a = Pattern.compile("\\s+");

    /* JADX INFO: renamed from: b */
    public static final ImmutableSet2<String> f6027b;

    /* JADX INFO: renamed from: c */
    public static final ImmutableSet2<String> f6028c;

    /* JADX INFO: renamed from: d */
    public static final ImmutableSet2<String> f6029d;

    /* JADX INFO: renamed from: e */
    public static final ImmutableSet2<String> f6030e;

    /* JADX INFO: renamed from: f */
    public final int f6031f;

    /* JADX INFO: renamed from: g */
    public final int f6032g;

    /* JADX INFO: renamed from: h */
    public final int f6033h;

    static {
        int i = ImmutableSet2.f12057k;
        f6027b = ImmutableSet2.m6280l(2, "auto", "none");
        f6028c = ImmutableSet2.m6283r("dot", "sesame", "circle");
        f6029d = ImmutableSet2.m6280l(2, "filled", "open");
        f6030e = ImmutableSet2.m6283r("after", "before", "outside");
    }

    public TextEmphasis(int i, int i2, int i3) {
        this.f6031f = i;
        this.f6032g = i2;
        this.f6033h = i3;
    }
}
