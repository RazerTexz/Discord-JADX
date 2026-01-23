package p007b.p195g.p196a.p205c.p219i0;

import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.g.a.c.i0.m, reason: use source file name */
/* JADX INFO: compiled from: NameTransformer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class NameTransformer3 extends NameTransformer4 {

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f4960k;

    public NameTransformer3(String str) {
        this.f4960k = str;
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.NameTransformer4
    /* JADX INFO: renamed from: a */
    public String mo2202a(String str) {
        StringBuilder sbM833U = outline.m833U(str);
        sbM833U.append(this.f4960k);
        return sbM833U.toString();
    }

    public String toString() {
        return outline.m822J(outline.m833U("[SuffixTransformer('"), this.f4960k, "')]");
    }
}
