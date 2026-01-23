package p007b.p225i.p226a.p242c.p245b3.p254v;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.Subtitle;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.b3.v.k, reason: use source file name */
/* JADX INFO: compiled from: WebvttSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttSubtitle implements Subtitle {

    /* JADX INFO: renamed from: j */
    public final List<WebvttCueInfo> f6160j;

    /* JADX INFO: renamed from: k */
    public final long[] f6161k;

    /* JADX INFO: renamed from: l */
    public final long[] f6162l;

    public WebvttSubtitle(List<WebvttCueInfo> list) {
        this.f6160j = Collections.unmodifiableList(new ArrayList(list));
        this.f6161k = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            WebvttCueInfo webvttCueInfo = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.f6161k;
            jArr[i2] = webvttCueInfo.f6132b;
            jArr[i2 + 1] = webvttCueInfo.f6133c;
        }
        long[] jArr2 = this.f6161k;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f6162l = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        int iM2994b = Util2.m2994b(this.f6162l, j, false, false);
        if (iM2994b < this.f6162l.length) {
            return iM2994b;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        AnimatableValueParser.m531j(i >= 0);
        AnimatableValueParser.m531j(i < this.f6162l.length);
        return this.f6162l[i];
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: h */
    public List<Cue> mo2614h(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.f6160j.size(); i++) {
            long[] jArr = this.f6161k;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                WebvttCueInfo webvttCueInfo = this.f6160j.get(i);
                Cue cue = webvttCueInfo.f6131a;
                if (cue.f5762p == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        Collections.sort(arrayList2, C2621b.f6107j);
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            Cue.b bVarM2605a = ((WebvttCueInfo) arrayList2.get(i3)).f6131a.m2605a();
            bVarM2605a.f5777e = (-1) - i3;
            bVarM2605a.f5778f = 1;
            arrayList.add(bVarM2605a.m2606a());
        }
        return arrayList;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        return this.f6162l.length;
    }
}
