package p007b.p225i.p226a.p242c.p263t2;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;

/* compiled from: AudioRendererEventListener.java */
/* renamed from: b.i.a.c.t2.r, reason: use source file name */
/* loaded from: classes3.dex */
public interface AudioRendererEventListener2 {

    /* compiled from: AudioRendererEventListener.java */
    /* renamed from: b.i.a.c.t2.r$a */
    public static final class a {

        /* renamed from: a */
        @Nullable
        public final Handler f7790a;

        /* renamed from: b */
        @Nullable
        public final AudioRendererEventListener2 f7791b;

        public a(@Nullable Handler handler, @Nullable AudioRendererEventListener2 audioRendererEventListener2) {
            if (audioRendererEventListener2 != null) {
                Objects.requireNonNull(handler);
            } else {
                handler = null;
            }
            this.f7790a = handler;
            this.f7791b = audioRendererEventListener2;
        }

        /* renamed from: a */
        public void m3498a(DecoderCounters decoderCounters) {
            synchronized (decoderCounters) {
            }
            Handler handler = this.f7790a;
            if (handler != null) {
                handler.post(new RunnableC2913b(this, decoderCounters));
            }
        }
    }

    /* renamed from: B */
    void mo3291B(String str);

    /* renamed from: C */
    void mo3292C(String str, long j, long j2);

    /* renamed from: I */
    void mo3293I(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    /* renamed from: N */
    void mo3294N(Exception exc);

    /* renamed from: R */
    void mo3295R(long j);

    /* renamed from: T */
    void mo3296T(Exception exc);

    @Deprecated
    /* renamed from: U */
    void mo3297U(Format2 format2);

    /* renamed from: d */
    void mo3299d(boolean z2);

    /* renamed from: e0 */
    void mo3300e0(int i, long j, long j2);

    /* renamed from: k */
    void mo3301k(DecoderCounters decoderCounters);

    /* renamed from: m */
    void mo3302m(DecoderCounters decoderCounters);
}
