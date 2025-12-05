package p007b.p225i.p226a.p242c.p245b3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p265v2.DecoderOutputBuffer;

/* compiled from: SubtitleOutputBuffer.java */
/* renamed from: b.i.a.c.b3.k, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SubtitleOutputBuffer extends DecoderOutputBuffer implements Subtitle {

    /* renamed from: l */
    @Nullable
    public Subtitle f5801l;

    /* renamed from: m */
    public long f5802m;

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: f */
    public int mo2612f(long j) {
        Subtitle subtitle = this.f5801l;
        Objects.requireNonNull(subtitle);
        return subtitle.mo2612f(j - this.f5802m);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: g */
    public long mo2613g(int i) {
        Subtitle subtitle = this.f5801l;
        Objects.requireNonNull(subtitle);
        return subtitle.mo2613g(i) + this.f5802m;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: h */
    public List<Cue> mo2614h(long j) {
        Subtitle subtitle = this.f5801l;
        Objects.requireNonNull(subtitle);
        return subtitle.mo2614h(j - this.f5802m);
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.Subtitle
    /* renamed from: i */
    public int mo2615i() {
        Subtitle subtitle = this.f5801l;
        Objects.requireNonNull(subtitle);
        return subtitle.mo2615i();
    }

    /* renamed from: q */
    public void m2618q() {
        this.f7901j = 0;
        this.f5801l = null;
    }

    /* renamed from: r */
    public void m2619r(long j, Subtitle subtitle, long j2) {
        this.f7925k = j;
        this.f5801l = subtitle;
        if (j2 != RecyclerView.FOREVER_NS) {
            j = j2;
        }
        this.f5802m = j;
    }
}
