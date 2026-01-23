package p007b.p225i.p226a.p242c.p245b3.p250r;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.b3.r.d, reason: use source file name */
/* JADX INFO: compiled from: SsaSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SsaSubtitle implements Subtitle {

    /* JADX INFO: renamed from: j */
    public final List<List<Cue>> f6018j;

    /* JADX INFO: renamed from: k */
    public final List<Long> f6019k;

    public SsaSubtitle(List<List<Cue>> list, List<Long> list2) {
        this.f6018j = list;
        this.f6019k = list2;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        int i;
        List<Long> list = this.f6019k;
        Long lValueOf = Long.valueOf(j);
        int i2 = Util2.f6708a;
        int iBinarySearch = Collections.binarySearch(list, lValueOf);
        if (iBinarySearch < 0) {
            i = ~iBinarySearch;
        } else {
            int size = list.size();
            do {
                iBinarySearch++;
                if (iBinarySearch >= size) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(lValueOf) == 0);
            i = iBinarySearch;
        }
        if (i < this.f6019k.size()) {
            return i;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        AnimatableValueParser.m531j(i >= 0);
        AnimatableValueParser.m531j(i < this.f6019k.size());
        return this.f6019k.get(i).longValue();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: h */
    public List<Cue> mo2614h(long j) {
        int i;
        List<Long> list = this.f6019k;
        Long lValueOf = Long.valueOf(j);
        int i2 = Util2.f6708a;
        int iBinarySearch = Collections.binarySearch(list, lValueOf);
        if (iBinarySearch < 0) {
            i = -(iBinarySearch + 2);
        } else {
            do {
                iBinarySearch--;
                if (iBinarySearch < 0) {
                    break;
                }
            } while (list.get(iBinarySearch).compareTo(lValueOf) == 0);
            i = iBinarySearch + 1;
        }
        return i == -1 ? Collections.emptyList() : this.f6018j.get(i);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return this.f6019k.size();
    }
}
