package p007b.p225i.p226a.p242c.p245b3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p265v2.DecoderOutputBuffer;

/* JADX INFO: renamed from: b.i.a.c.b3.k, reason: use source file name */
/* JADX INFO: compiled from: SubtitleOutputBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    /* JADX INFO: renamed from: l */
    @Nullable
    public Subtitle f5801l;

    /* JADX INFO: renamed from: m */
    public long f5802m;

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: f */
    public int mo2612f(long j) {
        Subtitle subtitle = this.f5801l;
        Objects.requireNonNull(subtitle);
        return subtitle.mo2612f(j - this.f5802m);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: g */
    public long mo2613g(int i) {
        Subtitle subtitle = this.f5801l;
        Objects.requireNonNull(subtitle);
        return subtitle.mo2613g(i) + this.f5802m;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: h */
    public List<Cue> mo2614h(long j) {
        Subtitle subtitle = this.f5801l;
        Objects.requireNonNull(subtitle);
        return subtitle.mo2614h(j - this.f5802m);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* JADX INFO: renamed from: i */
    public int mo2615i() {
        Subtitle subtitle = this.f5801l;
        Objects.requireNonNull(subtitle);
        return subtitle.mo2615i();
    }

    /* JADX INFO: renamed from: q */
    public void m2618q() {
        this.f7901j = 0;
        this.f5801l = null;
    }

    /* JADX INFO: renamed from: r */
    public void m2619r(long j, Subtitle subtitle, long j2) {
        this.f7925k = j;
        this.f5801l = subtitle;
        if (j2 != RecyclerView.FOREVER_NS) {
            j = j2;
        }
        this.f5802m = j;
    }
}
