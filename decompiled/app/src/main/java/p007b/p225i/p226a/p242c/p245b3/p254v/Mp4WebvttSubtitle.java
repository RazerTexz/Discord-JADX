package p007b.p225i.p226a.p242c.p245b3.p254v;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;

/* compiled from: Mp4WebvttSubtitle.java */
/* renamed from: b.i.a.c.b3.v.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Mp4WebvttSubtitle implements Subtitle {

    /* renamed from: j */
    public final List<Cue> f6109j;

    public Mp4WebvttSubtitle(List<Cue> list) {
        this.f6109j = Collections.unmodifiableList(list);
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
        return j >= 0 ? this.f6109j : Collections.emptyList();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: i */
    public int mo2615i() {
        return 1;
    }
}
