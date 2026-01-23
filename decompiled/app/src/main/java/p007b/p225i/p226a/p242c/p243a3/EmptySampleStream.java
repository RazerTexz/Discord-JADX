package p007b.p225i.p226a.p242c.p243a3;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import p007b.p225i.p226a.p242c.FormatHolder;

/* JADX INFO: renamed from: b.i.a.c.a3.q, reason: use source file name */
/* JADX INFO: compiled from: EmptySampleStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
    /* JADX INFO: renamed from: a */
    public int mo2505a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.f7901j = 4;
        return -4;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
    /* JADX INFO: renamed from: b */
    public void mo2506b() {
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
    /* JADX INFO: renamed from: c */
    public int mo2507c(long j) {
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
    /* JADX INFO: renamed from: d */
    public boolean mo2508d() {
        return true;
    }
}
