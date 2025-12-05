package p007b.p225i.p226a.p242c.p245b3.p251s;

import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: SubripSubtitle.java */
/* renamed from: b.i.a.c.b3.s.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class SubripSubtitle implements Subtitle {

    /* renamed from: j */
    public final Cue[] f6024j;

    /* renamed from: k */
    public final long[] f6025k;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.f6024j = cueArr;
        this.f6025k = jArr;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: f */
    public int mo2612f(long j) {
        int iM2994b = Util2.m2994b(this.f6025k, j, false, false);
        if (iM2994b < this.f6025k.length) {
            return iM2994b;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: g */
    public long mo2613g(int i) {
        AnimatableValueParser.m531j(i >= 0);
        AnimatableValueParser.m531j(i < this.f6025k.length);
        return this.f6025k[i];
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: h */
    public List<Cue> mo2614h(long j) {
        int iM2997e = Util2.m2997e(this.f6025k, j, true, false);
        if (iM2997e != -1) {
            Cue[] cueArr = this.f6024j;
            if (cueArr[iM2997e] != Cue.f5754j) {
                return Collections.singletonList(cueArr[iM2997e]);
            }
        }
        return Collections.emptyList();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: i */
    public int mo2615i() {
        return this.f6025k.length;
    }
}
