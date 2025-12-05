package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p243a3.SampleStream;
import p007b.p225i.p226a.p242c.p259f3.MediaClock;

/* compiled from: BaseRenderer.java */
/* renamed from: b.i.a.c.v0, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BaseRenderer implements Renderer2, RendererCapabilities {

    /* renamed from: j */
    public final int f7889j;

    /* renamed from: l */
    @Nullable
    public RendererConfiguration f7891l;

    /* renamed from: m */
    public int f7892m;

    /* renamed from: n */
    public int f7893n;

    /* renamed from: o */
    @Nullable
    public SampleStream f7894o;

    /* renamed from: p */
    @Nullable
    public Format2[] f7895p;

    /* renamed from: q */
    public long f7896q;

    /* renamed from: s */
    public boolean f7898s;

    /* renamed from: t */
    public boolean f7899t;

    /* renamed from: k */
    public final FormatHolder f7890k = new FormatHolder();

    /* renamed from: r */
    public long f7897r = Long.MIN_VALUE;

    public BaseRenderer(int i) {
        this.f7889j = i;
    }

    /* renamed from: A */
    public final FormatHolder m3547A() {
        this.f7890k.m3279a();
        return this.f7890k;
    }

    /* renamed from: B */
    public abstract void mo2621B();

    /* renamed from: C */
    public void mo3137C(boolean z2, boolean z3) throws ExoPlaybackException {
    }

    /* renamed from: D */
    public abstract void mo2622D(long j, boolean z2) throws ExoPlaybackException;

    /* renamed from: E */
    public void mo3140E() {
    }

    /* renamed from: F */
    public void mo3141F() throws ExoPlaybackException {
    }

    /* renamed from: G */
    public void mo3142G() {
    }

    /* renamed from: H */
    public abstract void mo2623H(Format2[] format2Arr, long j, long j2) throws ExoPlaybackException;

    /* renamed from: I */
    public final int m3548I(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        SampleStream sampleStream = this.f7894o;
        Objects.requireNonNull(sampleStream);
        int iMo2505a = sampleStream.mo2505a(formatHolder, decoderInputBuffer, i);
        if (iMo2505a == -4) {
            if (decoderInputBuffer.m3555n()) {
                this.f7897r = Long.MIN_VALUE;
                return this.f7898s ? -4 : -3;
            }
            long j = decoderInputBuffer.f19780n + this.f7896q;
            decoderInputBuffer.f19780n = j;
            this.f7897r = Math.max(this.f7897r, j);
        } else if (iMo2505a == -5) {
            Format2 format2 = formatHolder.f7196b;
            Objects.requireNonNull(format2);
            if (format2.f7127A != RecyclerView.FOREVER_NS) {
                Format2.b bVarM3275a = format2.m3275a();
                bVarM3275a.f7177o = format2.f7127A + this.f7896q;
                formatHolder.f7196b = bVarM3275a.m3277a();
            }
        }
        return iMo2505a;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: f */
    public final void mo2932f(int i) {
        this.f7892m = i;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: g */
    public final void mo2933g() {
        AnimatableValueParser.m426D(this.f7893n == 1);
        this.f7890k.m3279a();
        this.f7893n = 0;
        this.f7894o = null;
        this.f7895p = null;
        this.f7898s = false;
        mo2621B();
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    public final int getState() {
        return this.f7893n;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    @Nullable
    /* renamed from: h */
    public final SampleStream mo2934h() {
        return this.f7894o;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: j */
    public final boolean mo2935j() {
        return this.f7897r == Long.MIN_VALUE;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: k */
    public final void mo2936k(Format2[] format2Arr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException {
        AnimatableValueParser.m426D(!this.f7898s);
        this.f7894o = sampleStream;
        if (this.f7897r == Long.MIN_VALUE) {
            this.f7897r = j;
        }
        this.f7895p = format2Arr;
        this.f7896q = j2;
        mo2623H(format2Arr, j, j2);
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: l */
    public final void mo2937l() {
        this.f7898s = true;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: m */
    public final RendererCapabilities mo2938m() {
        return this;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: n */
    public /* synthetic */ void mo2939n(float f, float f2) throws ExoPlaybackException {
        Renderer.m2772a(this, f, f2);
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: o */
    public final void mo2940o(RendererConfiguration rendererConfiguration, Format2[] format2Arr, SampleStream sampleStream, long j, boolean z2, boolean z3, long j2, long j3) throws ExoPlaybackException {
        AnimatableValueParser.m426D(this.f7893n == 0);
        this.f7891l = rendererConfiguration;
        this.f7893n = 1;
        mo3137C(z2, z3);
        mo2936k(format2Arr, sampleStream, j2, j3);
        mo2622D(j, z2);
    }

    @Override // p007b.p225i.p226a.p242c.RendererCapabilities
    /* renamed from: p */
    public int mo3119p() throws ExoPlaybackException {
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.PlayerMessage.b
    /* renamed from: r */
    public void mo2603r(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    public final void reset() {
        AnimatableValueParser.m426D(this.f7893n == 0);
        this.f7890k.m3279a();
        mo3140E();
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: s */
    public final void mo2941s() throws IOException {
        SampleStream sampleStream = this.f7894o;
        Objects.requireNonNull(sampleStream);
        sampleStream.mo2506b();
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    public final void start() throws ExoPlaybackException {
        AnimatableValueParser.m426D(this.f7893n == 1);
        this.f7893n = 2;
        mo3141F();
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    public final void stop() {
        AnimatableValueParser.m426D(this.f7893n == 2);
        this.f7893n = 1;
        mo3142G();
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: t */
    public final long mo2942t() {
        return this.f7897r;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: u */
    public final void mo2943u(long j) throws ExoPlaybackException {
        this.f7898s = false;
        this.f7897r = j;
        mo2622D(j, false);
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: v */
    public final boolean mo2944v() {
        return this.f7898s;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    @Nullable
    /* renamed from: w */
    public MediaClock mo2945w() {
        return null;
    }

    @Override // p007b.p225i.p226a.p242c.Renderer2
    /* renamed from: x */
    public final int mo2946x() {
        return this.f7889j;
    }

    /* renamed from: y */
    public final ExoPlaybackException m3549y(Throwable th, @Nullable Format2 format2, int i) {
        return m3550z(th, format2, false, i);
    }

    /* renamed from: z */
    public final ExoPlaybackException m3550z(Throwable th, @Nullable Format2 format2, boolean z2, int i) {
        int iMo2630a;
        if (format2 == null || this.f7899t) {
            iMo2630a = 4;
        } else {
            this.f7899t = true;
            try {
                iMo2630a = mo2630a(format2) & 7;
            } catch (ExoPlaybackException unused) {
            } finally {
                this.f7899t = false;
            }
        }
        return new ExoPlaybackException(1, th, null, i, getName(), this.f7892m, format2, format2 == null ? 4 : iMo2630a, z2);
    }
}
