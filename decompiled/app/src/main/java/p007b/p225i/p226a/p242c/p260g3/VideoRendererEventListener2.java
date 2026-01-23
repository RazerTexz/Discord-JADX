package p007b.p225i.p226a.p242c.p260g3;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;

/* JADX INFO: renamed from: b.i.a.c.g3.x, reason: use source file name */
/* JADX INFO: compiled from: VideoRendererEventListener.java */
/* JADX INFO: loaded from: classes3.dex */
public interface VideoRendererEventListener2 {

    /* JADX INFO: renamed from: b.i.a.c.g3.x$a */
    /* JADX INFO: compiled from: VideoRendererEventListener.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        @Nullable
        public final Handler f6952a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public final VideoRendererEventListener2 f6953b;

        public a(@Nullable Handler handler, @Nullable VideoRendererEventListener2 videoRendererEventListener2) {
            if (videoRendererEventListener2 != null) {
                Objects.requireNonNull(handler);
            } else {
                handler = null;
            }
            this.f6952a = handler;
            this.f6953b = videoRendererEventListener2;
        }
    }

    /* JADX INFO: renamed from: F */
    void mo3185F(int i, long j);

    /* JADX INFO: renamed from: K */
    void mo3186K(Object obj, long j);

    @Deprecated
    /* JADX INFO: renamed from: O */
    void mo3187O(Format2 format2);

    /* JADX INFO: renamed from: P */
    void mo3188P(DecoderCounters decoderCounters);

    /* JADX INFO: renamed from: Q */
    void mo3189Q(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    /* JADX INFO: renamed from: V */
    void mo3190V(Exception exc);

    /* JADX INFO: renamed from: Z */
    void mo3191Z(DecoderCounters decoderCounters);

    /* JADX INFO: renamed from: f */
    void mo3192f(VideoSize videoSize);

    /* JADX INFO: renamed from: h0 */
    void mo3193h0(long j, int i);

    /* JADX INFO: renamed from: l */
    void mo3194l(String str);

    /* JADX INFO: renamed from: n */
    void mo3195n(String str, long j, long j2);
}
