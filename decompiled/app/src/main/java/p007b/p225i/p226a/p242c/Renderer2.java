package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;
import p007b.p225i.p226a.p242c.PlayerMessage;
import p007b.p225i.p226a.p242c.p243a3.SampleStream;
import p007b.p225i.p226a.p242c.p259f3.MediaClock;

/* compiled from: Renderer.java */
/* renamed from: b.i.a.c.f2, reason: use source file name */
/* loaded from: classes3.dex */
public interface Renderer2 extends PlayerMessage.b {

    /* compiled from: Renderer.java */
    /* renamed from: b.i.a.c.f2$a */
    public interface a {
        /* renamed from: a */
        void mo2947a();

        /* renamed from: b */
        void mo2948b(long j);
    }

    /* renamed from: b */
    boolean mo2631b();

    /* renamed from: d */
    boolean mo2632d();

    /* renamed from: f */
    void mo2932f(int i);

    /* renamed from: g */
    void mo2933g();

    String getName();

    int getState();

    @Nullable
    /* renamed from: h */
    SampleStream mo2934h();

    /* renamed from: j */
    boolean mo2935j();

    /* renamed from: k */
    void mo2936k(Format2[] format2Arr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException;

    /* renamed from: l */
    void mo2937l();

    /* renamed from: m */
    RendererCapabilities mo2938m();

    /* renamed from: n */
    void mo2939n(float f, float f2) throws ExoPlaybackException;

    /* renamed from: o */
    void mo2940o(RendererConfiguration rendererConfiguration, Format2[] format2Arr, SampleStream sampleStream, long j, boolean z2, boolean z3, long j2, long j3) throws ExoPlaybackException;

    /* renamed from: q */
    void mo2633q(long j, long j2) throws ExoPlaybackException;

    void reset();

    /* renamed from: s */
    void mo2941s() throws IOException;

    void start() throws ExoPlaybackException;

    void stop();

    /* renamed from: t */
    long mo2942t();

    /* renamed from: u */
    void mo2943u(long j) throws ExoPlaybackException;

    /* renamed from: v */
    boolean mo2944v();

    @Nullable
    /* renamed from: w */
    MediaClock mo2945w();

    /* renamed from: x */
    int mo2946x();
}
