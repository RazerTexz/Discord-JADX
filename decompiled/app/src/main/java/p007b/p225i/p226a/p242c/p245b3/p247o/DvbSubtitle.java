package p007b.p225i.p226a.p242c.p245b3.p247o;

import java.util.List;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;

/* JADX INFO: renamed from: b.i.a.c.b3.o.c, reason: use source file name */
/* JADX INFO: compiled from: DvbSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DvbSubtitle implements Subtitle {

    /* JADX INFO: renamed from: j */
    public final List<Cue> f5966j;

    public DvbSubtitle(List<Cue> list) {
        this.f5966j = list;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        return 0L;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: h */
    public List<Cue> mo2614h(long j) {
        return this.f5966j;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return 1;
    }
}
