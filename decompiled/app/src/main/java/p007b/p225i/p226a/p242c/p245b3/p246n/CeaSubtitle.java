package p007b.p225i.p226a.p242c.p245b3.p246n;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;

/* compiled from: CeaSubtitle.java */
/* renamed from: b.i.a.c.b3.n.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class CeaSubtitle implements Subtitle {

    /* renamed from: j */
    public final List<Cue> f5914j;

    public CeaSubtitle(List<Cue> list) {
        this.f5914j = list;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: f */
    public int mo2612f(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: g */
    public long mo2613g(int i) {
        AnimatableValueParser.m531j(i == 0);
        return 0L;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: h */
    public List<Cue> mo2614h(long j) {
        return j >= 0 ? this.f5914j : Collections.emptyList();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: i */
    public int mo2615i() {
        return 1;
    }
}
