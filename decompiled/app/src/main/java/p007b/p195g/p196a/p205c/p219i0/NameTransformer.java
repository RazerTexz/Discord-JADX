package p007b.p195g.p196a.p205c.p219i0;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: NameTransformer.java */
/* renamed from: b.g.a.c.i0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class NameTransformer extends NameTransformer4 {

    /* renamed from: k */
    public final /* synthetic */ String f4957k;

    /* renamed from: l */
    public final /* synthetic */ String f4958l;

    public NameTransformer(String str, String str2) {
        this.f4957k = str;
        this.f4958l = str2;
    }

    @Override // p007b.p195g.p196a.p205c.p219i0.NameTransformer4
    /* renamed from: a */
    public String mo2202a(String str) {
        return this.f4957k + str + this.f4958l;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[PreAndSuffixTransformer('");
        sbM833U.append(this.f4957k);
        sbM833U.append("','");
        return outline.m822J(sbM833U, this.f4958l, "')]");
    }
}
