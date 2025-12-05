package p007b.p225i.p226a.p242c.p245b3.p253u;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;

/* compiled from: Tx3gSubtitle.java */
/* renamed from: b.i.a.c.b3.u.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Tx3gSubtitle implements Subtitle {

    /* renamed from: j */
    public static final Tx3gSubtitle f6104j = new Tx3gSubtitle();

    /* renamed from: k */
    public final List<Cue> f6105k;

    public Tx3gSubtitle(Cue cue) {
        this.f6105k = Collections.singletonList(cue);
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
        return j >= 0 ? this.f6105k : Collections.emptyList();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: i */
    public int mo2615i() {
        return 1;
    }

    public Tx3gSubtitle() {
        this.f6105k = Collections.emptyList();
    }
}
