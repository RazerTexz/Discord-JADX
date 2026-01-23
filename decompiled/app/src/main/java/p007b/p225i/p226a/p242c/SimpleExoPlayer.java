package p007b.p225i.p226a.p242c;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import com.discord.utilities.rest.SendUtils;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import org.webrtc.MediaStreamTrack;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.AudioBecomingNoisyManager;
import p007b.p225i.p226a.p242c.AudioFocusManager;
import p007b.p225i.p226a.p242c.ExoPlayer2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.PlayerMessage;
import p007b.p225i.p226a.p242c.StreamVolumeManager;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p245b3.TextOutput;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p259f3.ConditionVariable;
import p007b.p225i.p226a.p242c.p259f3.FlagSet;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.SystemHandlerWrapper;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoDecoderOutputBufferRenderer;
import p007b.p225i.p226a.p242c.p260g3.VideoFrameMetadataListener;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;
import p007b.p225i.p226a.p242c.p260g3.p261z.CameraMotionListener;
import p007b.p225i.p226a.p242c.p260g3.p261z.SphericalGLSurfaceView;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;
import p007b.p225i.p226a.p242c.p262s2.C2884o;
import p007b.p225i.p226a.p242c.p263t2.AudioAttributes;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;
import p007b.p225i.p226a.p242c.p279z2.MetadataOutput;

/* JADX INFO: renamed from: b.i.a.c.k2, reason: use source file name */
/* JADX INFO: compiled from: SimpleExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer2 {

    /* JADX INFO: renamed from: A */
    public AudioAttributes f7197A;

    /* JADX INFO: renamed from: B */
    public float f7198B;

    /* JADX INFO: renamed from: C */
    public boolean f7199C;

    /* JADX INFO: renamed from: D */
    public List<Cue> f7200D;

    /* JADX INFO: renamed from: E */
    public boolean f7201E;

    /* JADX INFO: renamed from: F */
    public boolean f7202F;

    /* JADX INFO: renamed from: G */
    public boolean f7203G;

    /* JADX INFO: renamed from: H */
    public DeviceInfo2 f7204H;

    /* JADX INFO: renamed from: I */
    public VideoSize f7205I;

    /* JADX INFO: renamed from: b */
    public final Renderer2[] f7206b;

    /* JADX INFO: renamed from: c */
    public final ConditionVariable f7207c = new ConditionVariable();

    /* JADX INFO: renamed from: d */
    public final Context f7208d;

    /* JADX INFO: renamed from: e */
    public final ExoPlayerImpl f7209e;

    /* JADX INFO: renamed from: f */
    public final b f7210f;

    /* JADX INFO: renamed from: g */
    public final c f7211g;

    /* JADX INFO: renamed from: h */
    public final CopyOnWriteArraySet<Player2.e> f7212h;

    /* JADX INFO: renamed from: i */
    public final AnalyticsCollector f7213i;

    /* JADX INFO: renamed from: j */
    public final AudioBecomingNoisyManager f7214j;

    /* JADX INFO: renamed from: k */
    public final AudioFocusManager f7215k;

    /* JADX INFO: renamed from: l */
    public final StreamVolumeManager f7216l;

    /* JADX INFO: renamed from: m */
    public final WakeLockManager f7217m;

    /* JADX INFO: renamed from: n */
    public final WifiLockManager f7218n;

    /* JADX INFO: renamed from: o */
    public final long f7219o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public AudioTrack f7220p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public Object f7221q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public Surface f7222r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public SurfaceHolder f7223s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public SphericalGLSurfaceView f7224t;

    /* JADX INFO: renamed from: u */
    public boolean f7225u;

    /* JADX INFO: renamed from: v */
    @Nullable
    public TextureView f7226v;

    /* JADX INFO: renamed from: w */
    public int f7227w;

    /* JADX INFO: renamed from: x */
    public int f7228x;

    /* JADX INFO: renamed from: y */
    public int f7229y;

    /* JADX INFO: renamed from: z */
    public int f7230z;

    /* JADX INFO: renamed from: b.i.a.c.k2$b */
    /* JADX INFO: compiled from: SimpleExoPlayer.java */
    public final class b implements VideoRendererEventListener2, AudioRendererEventListener2, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.b, AudioFocusManager.b, AudioBecomingNoisyManager.b, StreamVolumeManager.b, Player2.c, ExoPlayer2.a {
        public b(a aVar) {
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: A */
        public /* synthetic */ void mo235A(MediaMetadata mediaMetadata) {
            Player3.m3878f(this, mediaMetadata);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: B */
        public void mo3291B(String str) {
            SimpleExoPlayer.this.f7213i.mo3291B(str);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: C */
        public void mo3292C(String str, long j, long j2) {
            SimpleExoPlayer.this.f7213i.mo3292C(str, j, j2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: D */
        public /* synthetic */ void mo236D(boolean z2) {
            Player3.m3888p(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: E */
        public /* synthetic */ void mo237E(Player2 player2, Player2.d dVar) {
            Player3.m3874b(this, player2, dVar);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: F */
        public void mo3185F(int i, long j) {
            SimpleExoPlayer.this.f7213i.mo3185F(i, j);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: H */
        public /* synthetic */ void mo239H(boolean z2, int i) {
            Player3.m3883k(this, z2, i);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: I */
        public void mo3293I(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Objects.requireNonNull(SimpleExoPlayer.this);
            SimpleExoPlayer.this.f7213i.mo3293I(format2, decoderReuseEvaluation);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: K */
        public void mo3186K(Object obj, long j) {
            SimpleExoPlayer.this.f7213i.mo3186K(obj, j);
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.f7221q == obj) {
                Iterator<Player2.e> it = simpleExoPlayer.f7212h.iterator();
                while (it.hasNext()) {
                    it.next().mo248c();
                }
            }
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: L */
        public /* synthetic */ void mo240L(int i) {
            Player3.m3886n(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: M */
        public /* synthetic */ void mo241M(MediaItem2 mediaItem2, int i) {
            Player3.m3877e(this, mediaItem2, i);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: N */
        public void mo3294N(Exception exc) {
            SimpleExoPlayer.this.f7213i.mo3294N(exc);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: O */
        public /* synthetic */ void mo3187O(Format2 format2) {
            VideoRendererEventListener.m3184a(this, format2);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: P */
        public void mo3188P(DecoderCounters decoderCounters) {
            Objects.requireNonNull(SimpleExoPlayer.this);
            SimpleExoPlayer.this.f7213i.mo3188P(decoderCounters);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: Q */
        public void mo3189Q(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Objects.requireNonNull(SimpleExoPlayer.this);
            SimpleExoPlayer.this.f7213i.mo3189Q(format2, decoderReuseEvaluation);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: R */
        public void mo3295R(long j) {
            SimpleExoPlayer.this.f7213i.mo3295R(j);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: T */
        public void mo3296T(Exception exc) {
            SimpleExoPlayer.this.f7213i.mo3296T(exc);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: U */
        public /* synthetic */ void mo3297U(Format2 format2) {
            AudioRendererEventListener.m3497a(this, format2);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: V */
        public void mo3190V(Exception exc) {
            SimpleExoPlayer.this.f7213i.mo3190V(exc);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: W */
        public void mo242W(boolean z2, int i) {
            SimpleExoPlayer.m3280d0(SimpleExoPlayer.this);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: Y */
        public /* synthetic */ void mo243Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player3.m3890r(this, trackGroupArray, trackSelectionArray);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: Z */
        public void mo3191Z(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.f7213i.mo3191Z(decoderCounters);
            Objects.requireNonNull(SimpleExoPlayer.this);
            Objects.requireNonNull(SimpleExoPlayer.this);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: a */
        public /* synthetic */ void mo244a() {
            Player3.m3887o(this);
        }

        @Override // p007b.p225i.p226a.p242c.p279z2.MetadataOutput
        /* JADX INFO: renamed from: b */
        public void mo3298b(Metadata metadata) {
            SimpleExoPlayer.this.f7213i.mo246b(metadata);
            ExoPlayerImpl exoPlayerImpl = SimpleExoPlayer.this.f7209e;
            MediaMetadata.b bVarM3344a = exoPlayerImpl.f6656E.m3344a();
            int i = 0;
            while (true) {
                Metadata.Entry[] entryArr = metadata.f19936j;
                if (i >= entryArr.length) {
                    break;
                }
                entryArr[i].mo8878n(bVarM3344a);
                i++;
            }
            exoPlayerImpl.f6656E = bVarM3344a.m3345a();
            MediaMetadata mediaMetadataM2899e0 = exoPlayerImpl.m2899e0();
            if (!mediaMetadataM2899e0.equals(exoPlayerImpl.f6655D)) {
                exoPlayerImpl.f6655D = mediaMetadataM2899e0;
                ListenerSet<Player2.c> listenerSet = exoPlayerImpl.f6667j;
                listenerSet.m3035b(14, new C2809j(exoPlayerImpl));
                listenerSet.m3034a();
            }
            Iterator<Player2.e> it = SimpleExoPlayer.this.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo246b(metadata);
            }
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: b0 */
        public /* synthetic */ void mo247b0(PlaybackParameters playbackParameters) {
            Player3.m3879g(this, playbackParameters);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: d */
        public void mo3299d(boolean z2) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.f7199C == z2) {
                return;
            }
            simpleExoPlayer.f7199C = z2;
            simpleExoPlayer.f7213i.mo249d(z2);
            Iterator<Player2.e> it = simpleExoPlayer.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo249d(simpleExoPlayer.f7199C);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.TextOutput
        /* JADX INFO: renamed from: e */
        public void mo2620e(List<Cue> list) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.f7200D = list;
            Iterator<Player2.e> it = simpleExoPlayer.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo250e(list);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: e0 */
        public void mo3300e0(int i, long j, long j2) {
            SimpleExoPlayer.this.f7213i.mo3300e0(i, j, j2);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: f */
        public void mo3192f(VideoSize videoSize) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            simpleExoPlayer.f7205I = videoSize;
            simpleExoPlayer.f7213i.mo251f(videoSize);
            Iterator<Player2.e> it = SimpleExoPlayer.this.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo251f(videoSize);
            }
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: f0 */
        public /* synthetic */ void mo252f0(PlaybackException playbackException) {
            Player3.m3882j(this, playbackException);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: g */
        public /* synthetic */ void mo253g(Player2.f fVar, Player2.f fVar2, int i) {
            Player3.m3885m(this, fVar, fVar2, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: h */
        public /* synthetic */ void mo254h(int i) {
            Player3.m3880h(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: h0 */
        public void mo3193h0(long j, int i) {
            SimpleExoPlayer.this.f7213i.mo3193h0(j, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: i */
        public /* synthetic */ void mo255i(boolean z2) {
            Player3.m3876d(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: j */
        public /* synthetic */ void mo256j(int i) {
            Player3.m3884l(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: j0 */
        public /* synthetic */ void mo257j0(boolean z2) {
            Player3.m3875c(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: k */
        public void mo3301k(DecoderCounters decoderCounters) {
            SimpleExoPlayer.this.f7213i.mo3301k(decoderCounters);
            Objects.requireNonNull(SimpleExoPlayer.this);
            Objects.requireNonNull(SimpleExoPlayer.this);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: l */
        public void mo3194l(String str) {
            SimpleExoPlayer.this.f7213i.mo3194l(str);
        }

        @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
        /* JADX INFO: renamed from: m */
        public void mo3302m(DecoderCounters decoderCounters) {
            Objects.requireNonNull(SimpleExoPlayer.this);
            SimpleExoPlayer.this.f7213i.mo3302m(decoderCounters);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
        /* JADX INFO: renamed from: n */
        public void mo3195n(String str, long j, long j2) {
            SimpleExoPlayer.this.f7213i.mo3195n(str, j, j2);
        }

        @Override // p007b.p225i.p226a.p242c.ExoPlayer2.a
        /* JADX INFO: renamed from: o */
        public void mo2770o(boolean z2) {
            SimpleExoPlayer.m3280d0(SimpleExoPlayer.this);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            Objects.requireNonNull(simpleExoPlayer);
            Surface surface = new Surface(surfaceTexture);
            simpleExoPlayer.m3288l0(surface);
            simpleExoPlayer.f7222r = surface;
            SimpleExoPlayer.this.m3284h0(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            SimpleExoPlayer.this.m3288l0(null);
            SimpleExoPlayer.this.m3284h0(0, 0);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            SimpleExoPlayer.this.m3284h0(i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: p */
        public /* synthetic */ void mo258p(TracksInfo tracksInfo) {
            Player3.m3891s(this, tracksInfo);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.SphericalGLSurfaceView.b
        /* JADX INFO: renamed from: q */
        public void mo3204q(Surface surface) {
            SimpleExoPlayer.this.m3288l0(null);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: r */
        public void mo259r(boolean z2) {
            Objects.requireNonNull(SimpleExoPlayer.this);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: s */
        public /* synthetic */ void mo260s(PlaybackException playbackException) {
            Player3.m3881i(this, playbackException);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            SimpleExoPlayer.this.m3284h0(i2, i3);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.f7225u) {
                simpleExoPlayer.m3288l0(surfaceHolder.getSurface());
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SimpleExoPlayer simpleExoPlayer = SimpleExoPlayer.this;
            if (simpleExoPlayer.f7225u) {
                simpleExoPlayer.m3288l0(null);
            }
            SimpleExoPlayer.this.m3284h0(0, 0);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: t */
        public /* synthetic */ void mo261t(Player2.b bVar) {
            Player3.m3873a(this, bVar);
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.SphericalGLSurfaceView.b
        /* JADX INFO: renamed from: u */
        public void mo3205u(Surface surface) {
            SimpleExoPlayer.this.m3288l0(surface);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: v */
        public /* synthetic */ void mo262v(Timeline timeline, int i) {
            Player3.m3889q(this, timeline, i);
        }

        @Override // p007b.p225i.p226a.p242c.ExoPlayer2.a
        /* JADX INFO: renamed from: x */
        public /* synthetic */ void mo2771x(boolean z2) {
            ExoPlayer.m2757a(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* JADX INFO: renamed from: y */
        public void mo264y(int i) {
            SimpleExoPlayer.m3280d0(SimpleExoPlayer.this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.k2$c */
    /* JADX INFO: compiled from: SimpleExoPlayer.java */
    public static final class c implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.b {

        /* JADX INFO: renamed from: j */
        @Nullable
        public VideoFrameMetadataListener f7232j;

        /* JADX INFO: renamed from: k */
        @Nullable
        public CameraMotionListener f7233k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public VideoFrameMetadataListener f7234l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public CameraMotionListener f7235m;

        public c(a aVar) {
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.CameraMotionListener
        /* JADX INFO: renamed from: a */
        public void mo3196a(long j, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.f7235m;
            if (cameraMotionListener != null) {
                cameraMotionListener.mo3196a(j, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.f7233k;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.mo3196a(j, fArr);
            }
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.CameraMotionListener
        /* JADX INFO: renamed from: c */
        public void mo3197c() {
            CameraMotionListener cameraMotionListener = this.f7235m;
            if (cameraMotionListener != null) {
                cameraMotionListener.mo3197c();
            }
            CameraMotionListener cameraMotionListener2 = this.f7233k;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.mo3197c();
            }
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.VideoFrameMetadataListener
        /* JADX INFO: renamed from: e */
        public void mo3177e(long j, long j2, Format2 format2, @Nullable MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.f7234l;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.mo3177e(j, j2, format2, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.f7232j;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.mo3177e(j, j2, format2, mediaFormat);
            }
        }

        @Override // p007b.p225i.p226a.p242c.PlayerMessage.b
        /* JADX INFO: renamed from: r */
        public void mo2603r(int i, @Nullable Object obj) {
            if (i == 7) {
                this.f7232j = (VideoFrameMetadataListener) obj;
                return;
            }
            if (i == 8) {
                this.f7233k = (CameraMotionListener) obj;
                return;
            }
            if (i != 10000) {
                return;
            }
            SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
            if (sphericalGLSurfaceView == null) {
                this.f7234l = null;
                this.f7235m = null;
            } else {
                this.f7234l = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                this.f7235m = sphericalGLSurfaceView.getCameraMotionListener();
            }
        }
    }

    public SimpleExoPlayer(ExoPlayer2.b bVar) throws Throwable {
        SimpleExoPlayer simpleExoPlayer;
        try {
            Context applicationContext = bVar.f6412a.getApplicationContext();
            this.f7208d = applicationContext;
            this.f7213i = bVar.f6419h.get();
            this.f7197A = bVar.f6421j;
            this.f7227w = bVar.f6422k;
            this.f7199C = false;
            this.f7219o = bVar.f6429r;
            b bVar2 = new b(null);
            this.f7210f = bVar2;
            this.f7211g = new c(null);
            this.f7212h = new CopyOnWriteArraySet<>();
            Handler handler = new Handler(bVar.f6420i);
            this.f7206b = bVar.f6414c.get().mo2596a(handler, bVar2, bVar2, bVar2, bVar2);
            this.f7198B = 1.0f;
            if (Util2.f6708a < 21) {
                AudioTrack audioTrack = this.f7220p;
                if (audioTrack != null && audioTrack.getAudioSessionId() != 0) {
                    this.f7220p.release();
                    this.f7220p = null;
                }
                if (this.f7220p == null) {
                    this.f7220p = new AudioTrack(3, SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, 4, 2, 2, 0, 0);
                }
                this.f7230z = this.f7220p.getAudioSessionId();
            } else {
                AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                this.f7230z = audioManager == null ? -1 : audioManager.generateAudioSessionId();
            }
            this.f7200D = Collections.emptyList();
            this.f7201E = true;
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = {21, 22, 23, 24, 25, 26, 27, 28};
            for (int i = 0; i < 8; i++) {
                int i2 = iArr[i];
                AnimatableValueParser.m426D(!false);
                sparseBooleanArray.append(i2, true);
            }
            AnimatableValueParser.m426D(!false);
            try {
                ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(this.f7206b, bVar.f6416e.get(), bVar.f6415d.get(), bVar.f6417f.get(), bVar.f6418g.get(), this.f7213i, bVar.f6423l, bVar.f6424m, bVar.f6425n, bVar.f6426o, bVar.f6427p, bVar.f6428q, false, bVar.f6413b, bVar.f6420i, this, new Player2.b(new FlagSet(sparseBooleanArray, null), null));
                simpleExoPlayer = this;
                try {
                    simpleExoPlayer.f7209e = exoPlayerImpl;
                    exoPlayerImpl.m2898d0(simpleExoPlayer.f7210f);
                    exoPlayerImpl.f6668k.add(simpleExoPlayer.f7210f);
                    AudioBecomingNoisyManager audioBecomingNoisyManager = new AudioBecomingNoisyManager(bVar.f6412a, handler, simpleExoPlayer.f7210f);
                    simpleExoPlayer.f7214j = audioBecomingNoisyManager;
                    audioBecomingNoisyManager.m3363a(false);
                    AudioFocusManager audioFocusManager = new AudioFocusManager(bVar.f6412a, handler, simpleExoPlayer.f7210f);
                    simpleExoPlayer.f7215k = audioFocusManager;
                    audioFocusManager.m3462c(null);
                    StreamVolumeManager streamVolumeManager = new StreamVolumeManager(bVar.f6412a, handler, simpleExoPlayer.f7210f);
                    simpleExoPlayer.f7216l = streamVolumeManager;
                    streamVolumeManager.m3307c(Util2.m3012t(simpleExoPlayer.f7197A.f7782m));
                    WakeLockManager wakeLockManager = new WakeLockManager(bVar.f6412a);
                    simpleExoPlayer.f7217m = wakeLockManager;
                    wakeLockManager.f7459c = false;
                    wakeLockManager.m3357a();
                    WifiLockManager wifiLockManager = new WifiLockManager(bVar.f6412a);
                    simpleExoPlayer.f7218n = wifiLockManager;
                    wifiLockManager.f7476c = false;
                    wifiLockManager.m3362a();
                    simpleExoPlayer.f7204H = m3281f0(streamVolumeManager);
                    simpleExoPlayer.f7205I = VideoSize.f6954j;
                    simpleExoPlayer.m3286j0(1, 10, Integer.valueOf(simpleExoPlayer.f7230z));
                    simpleExoPlayer.m3286j0(2, 10, Integer.valueOf(simpleExoPlayer.f7230z));
                    simpleExoPlayer.m3286j0(1, 3, simpleExoPlayer.f7197A);
                    simpleExoPlayer.m3286j0(2, 4, Integer.valueOf(simpleExoPlayer.f7227w));
                    simpleExoPlayer.m3286j0(2, 5, 0);
                    simpleExoPlayer.m3286j0(1, 9, Boolean.valueOf(simpleExoPlayer.f7199C));
                    simpleExoPlayer.m3286j0(2, 7, simpleExoPlayer.f7211g);
                    simpleExoPlayer.m3286j0(6, 8, simpleExoPlayer.f7211g);
                    simpleExoPlayer.f7207c.m3026b();
                } catch (Throwable th) {
                    th = th;
                    simpleExoPlayer.f7207c.m3026b();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                simpleExoPlayer = this;
            }
        } catch (Throwable th3) {
            th = th3;
            simpleExoPlayer = this;
        }
    }

    /* JADX INFO: renamed from: d0 */
    public static void m3280d0(SimpleExoPlayer simpleExoPlayer) {
        int iMo2930y = simpleExoPlayer.mo2930y();
        if (iMo2930y != 1) {
            if (iMo2930y == 2 || iMo2930y == 3) {
                simpleExoPlayer.m3290n0();
                boolean z2 = simpleExoPlayer.f7209e.f6657F.f7962q;
                WakeLockManager wakeLockManager = simpleExoPlayer.f7217m;
                wakeLockManager.f7460d = simpleExoPlayer.mo2908j() && !z2;
                wakeLockManager.m3357a();
                WifiLockManager wifiLockManager = simpleExoPlayer.f7218n;
                wifiLockManager.f7477d = simpleExoPlayer.mo2908j();
                wifiLockManager.m3362a();
                return;
            }
            if (iMo2930y != 4) {
                throw new IllegalStateException();
            }
        }
        WakeLockManager wakeLockManager2 = simpleExoPlayer.f7217m;
        wakeLockManager2.f7460d = false;
        wakeLockManager2.m3357a();
        WifiLockManager wifiLockManager2 = simpleExoPlayer.f7218n;
        wifiLockManager2.f7477d = false;
        wifiLockManager2.m3362a();
    }

    /* JADX INFO: renamed from: f0 */
    public static DeviceInfo2 m3281f0(StreamVolumeManager streamVolumeManager) {
        Objects.requireNonNull(streamVolumeManager);
        return new DeviceInfo2(0, Util2.f6708a >= 28 ? streamVolumeManager.f7249d.getStreamMinVolume(streamVolumeManager.f7251f) : 0, streamVolumeManager.f7249d.getStreamMaxVolume(streamVolumeManager.f7251f));
    }

    /* JADX INFO: renamed from: g0 */
    public static int m3282g0(boolean z2, int i) {
        return (!z2 || i == 1) ? 1 : 2;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: A */
    public List<Cue> mo2879A() {
        m3290n0();
        return this.f7200D;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: B */
    public int mo2880B() {
        m3290n0();
        return this.f7209e.mo2880B();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: C */
    public int mo2881C() {
        m3290n0();
        return this.f7209e.mo2881C();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: E */
    public void mo2882E(int i) {
        m3290n0();
        this.f7209e.mo2882E(i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: F */
    public void mo2883F(@Nullable SurfaceView surfaceView) {
        m3290n0();
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        m3290n0();
        if (holder == null || holder != this.f7223s) {
            return;
        }
        m3283e0();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: G */
    public int mo2884G() {
        m3290n0();
        return this.f7209e.f6657F.f7959n;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: H */
    public TracksInfo mo2885H() {
        m3290n0();
        return this.f7209e.mo2885H();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: I */
    public int mo2886I() {
        m3290n0();
        return this.f7209e.f6679v;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: J */
    public long mo2887J() {
        m3290n0();
        return this.f7209e.mo2887J();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: K */
    public Timeline mo2888K() {
        m3290n0();
        return this.f7209e.f6657F.f7947b;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: L */
    public Looper mo2889L() {
        return this.f7209e.f6674q;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: M */
    public boolean mo2890M() {
        m3290n0();
        return this.f7209e.f6680w;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: N */
    public long mo2891N() {
        m3290n0();
        return this.f7209e.mo2891N();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: Q */
    public void mo2892Q(@Nullable TextureView textureView) {
        m3290n0();
        if (textureView == null) {
            m3283e0();
            return;
        }
        m3285i0();
        this.f7226v = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.f7210f);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            m3288l0(null);
            m3284h0(0, 0);
        } else {
            Surface surface = new Surface(surfaceTexture);
            m3288l0(surface);
            this.f7222r = surface;
            m3284h0(textureView.getWidth(), textureView.getHeight());
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: S */
    public MediaMetadata mo2893S() {
        return this.f7209e.f6655D;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: T */
    public long mo2894T() {
        m3290n0();
        return this.f7209e.mo2894T();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: U */
    public long mo2895U() {
        m3290n0();
        return this.f7209e.f6676s;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: a */
    public void mo2896a() {
        m3290n0();
        boolean zMo2908j = mo2908j();
        int iM3464e = this.f7215k.m3464e(zMo2908j, 2);
        m3289m0(zMo2908j, iM3464e, m3282g0(zMo2908j, iM3464e));
        this.f7209e.mo2896a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: c */
    public PlaybackParameters mo2897c() {
        m3290n0();
        return this.f7209e.f6657F.f7960o;
    }

    /* JADX INFO: renamed from: e0 */
    public void m3283e0() {
        m3290n0();
        m3285i0();
        m3288l0(null);
        m3284h0(0, 0);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: f */
    public boolean mo2900f() {
        m3290n0();
        return this.f7209e.mo2900f();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: g */
    public long mo2902g() {
        m3290n0();
        return Util2.m2992M(this.f7209e.f6657F.f7964s);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: h */
    public void mo2904h(int i, long j) {
        m3290n0();
        AnalyticsCollector analyticsCollector = this.f7213i;
        if (!analyticsCollector.f7555r) {
            AnalyticsListener.a aVarM3382k0 = analyticsCollector.m3382k0();
            analyticsCollector.f7555r = true;
            C2884o c2884o = new C2884o(aVarM3382k0);
            analyticsCollector.f7551n.put(-1, aVarM3382k0);
            ListenerSet<AnalyticsListener> listenerSet = analyticsCollector.f7552o;
            listenerSet.m3035b(-1, c2884o);
            listenerSet.m3034a();
        }
        this.f7209e.mo2904h(i, j);
    }

    /* JADX INFO: renamed from: h0 */
    public final void m3284h0(int i, int i2) {
        if (i == this.f7228x && i2 == this.f7229y) {
            return;
        }
        this.f7228x = i;
        this.f7229y = i2;
        this.f7213i.mo245a0(i, i2);
        Iterator<Player2.e> it = this.f7212h.iterator();
        while (it.hasNext()) {
            it.next().mo245a0(i, i2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: i */
    public Player2.b mo2906i() {
        m3290n0();
        return this.f7209e.f6654C;
    }

    /* JADX INFO: renamed from: i0 */
    public final void m3285i0() {
        if (this.f7224t != null) {
            PlayerMessage playerMessageM2901f0 = this.f7209e.m2901f0(this.f7211g);
            playerMessageM2901f0.m2602f(10000);
            playerMessageM2901f0.m2601e(null);
            playerMessageM2901f0.m2600d();
            SphericalGLSurfaceView sphericalGLSurfaceView = this.f7224t;
            sphericalGLSurfaceView.f7021j.remove(this.f7210f);
            this.f7224t = null;
        }
        TextureView textureView = this.f7226v;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f7210f) {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.f7226v.setSurfaceTextureListener(null);
            }
            this.f7226v = null;
        }
        SurfaceHolder surfaceHolder = this.f7223s;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f7210f);
            this.f7223s = null;
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: j */
    public boolean mo2908j() {
        m3290n0();
        return this.f7209e.f6657F.f7958m;
    }

    /* JADX INFO: renamed from: j0 */
    public final void m3286j0(int i, int i2, @Nullable Object obj) {
        for (Renderer2 renderer2 : this.f7206b) {
            if (renderer2.mo2946x() == i) {
                PlayerMessage playerMessageM2901f0 = this.f7209e.m2901f0(renderer2);
                AnimatableValueParser.m426D(!playerMessageM2901f0.f5750i);
                playerMessageM2901f0.f5746e = i2;
                AnimatableValueParser.m426D(!playerMessageM2901f0.f5750i);
                playerMessageM2901f0.f5747f = obj;
                playerMessageM2901f0.m2600d();
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: k */
    public void mo2909k(boolean z2) {
        m3290n0();
        this.f7209e.mo2909k(z2);
    }

    /* JADX INFO: renamed from: k0 */
    public final void m3287k0(SurfaceHolder surfaceHolder) {
        this.f7225u = false;
        this.f7223s = surfaceHolder;
        surfaceHolder.addCallback(this.f7210f);
        Surface surface = this.f7223s.getSurface();
        if (surface == null || !surface.isValid()) {
            m3284h0(0, 0);
        } else {
            Rect surfaceFrame = this.f7223s.getSurfaceFrame();
            m3284h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: l */
    public long mo2910l() {
        m3290n0();
        Objects.requireNonNull(this.f7209e);
        return 3000L;
    }

    /* JADX INFO: renamed from: l0 */
    public final void m3288l0(@Nullable Object obj) {
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (Renderer2 renderer2 : this.f7206b) {
            if (renderer2.mo2946x() == 2) {
                PlayerMessage playerMessageM2901f0 = this.f7209e.m2901f0(renderer2);
                playerMessageM2901f0.m2602f(1);
                AnimatableValueParser.m426D(true ^ playerMessageM2901f0.f5750i);
                playerMessageM2901f0.f5747f = obj;
                playerMessageM2901f0.m2600d();
                arrayList.add(playerMessageM2901f0);
            }
        }
        Object obj2 = this.f7221q;
        if (obj2 == null || obj2 == obj) {
            z2 = false;
        } else {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((PlayerMessage) it.next()).m2597a(this.f7219o);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z2 = true;
            }
            z2 = false;
            Object obj3 = this.f7221q;
            Surface surface = this.f7222r;
            if (obj3 == surface) {
                surface.release();
                this.f7222r = null;
            }
        }
        this.f7221q = obj;
        if (z2) {
            ExoPlayerImpl exoPlayerImpl = this.f7209e;
            ExoPlaybackException exoPlaybackExceptionM8753b = ExoPlaybackException.m8753b(new ExoTimeoutException(3), PointerIconCompat.TYPE_HELP);
            PlaybackInfo playbackInfo = exoPlayerImpl.f6657F;
            PlaybackInfo playbackInfoM3562a = playbackInfo.m3562a(playbackInfo.f7948c);
            playbackInfoM3562a.f7963r = playbackInfoM3562a.f7965t;
            playbackInfoM3562a.f7964s = 0L;
            PlaybackInfo playbackInfoM3566e = playbackInfoM3562a.m3567f(1).m3566e(exoPlaybackExceptionM8753b);
            exoPlayerImpl.f6681x++;
            ((SystemHandlerWrapper.b) exoPlayerImpl.f6666i.f7083q.mo2956c(6)).m2965b();
            exoPlayerImpl.m2924s0(playbackInfoM3566e, 0, 1, false, playbackInfoM3566e.f7947b.m3331q() && !exoPlayerImpl.f6657F.f7947b.m3331q(), 4, exoPlayerImpl.m2903g0(playbackInfoM3566e), -1);
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: m */
    public int mo2912m() {
        m3290n0();
        return this.f7209e.mo2912m();
    }

    /* JADX INFO: renamed from: m0 */
    public final void m3289m0(boolean z2, int i, int i2) {
        int i3 = 0;
        boolean z3 = z2 && i != -1;
        if (z3 && i != 1) {
            i3 = 1;
        }
        this.f7209e.m2921q0(z3, i3, i2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: n */
    public void mo2914n(@Nullable TextureView textureView) {
        m3290n0();
        if (textureView == null || textureView != this.f7226v) {
            return;
        }
        m3283e0();
    }

    /* JADX INFO: renamed from: n0 */
    public final void m3290n0() {
        ConditionVariable conditionVariable = this.f7207c;
        synchronized (conditionVariable) {
            boolean z2 = false;
            while (!conditionVariable.f6728b) {
                try {
                    conditionVariable.wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
        if (Thread.currentThread() != this.f7209e.f6674q.getThread()) {
            String strM3003k = Util2.m3003k("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.f7209e.f6674q.getThread().getName());
            if (this.f7201E) {
                throw new IllegalStateException(strM3003k);
            }
            Log2.m3040c("SimpleExoPlayer", strM3003k, this.f7202F ? null : new IllegalStateException());
            this.f7202F = true;
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: o */
    public VideoSize mo2916o() {
        return this.f7205I;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: p */
    public void mo2918p(Player2.e eVar) {
        Objects.requireNonNull(eVar);
        this.f7212h.remove(eVar);
        this.f7209e.m2917o0(eVar);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: q */
    public int mo2920q() {
        m3290n0();
        return this.f7209e.mo2920q();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: r */
    public void mo2922r(@Nullable SurfaceView surfaceView) {
        m3290n0();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            m3285i0();
            m3288l0(surfaceView);
            m3287k0(surfaceView.getHolder());
            return;
        }
        if (surfaceView instanceof SphericalGLSurfaceView) {
            m3285i0();
            this.f7224t = (SphericalGLSurfaceView) surfaceView;
            PlayerMessage playerMessageM2901f0 = this.f7209e.m2901f0(this.f7211g);
            playerMessageM2901f0.m2602f(10000);
            playerMessageM2901f0.m2601e(this.f7224t);
            playerMessageM2901f0.m2600d();
            this.f7224t.f7021j.add(this.f7210f);
            m3288l0(this.f7224t.getVideoSurface());
            m3287k0(surfaceView.getHolder());
            return;
        }
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        m3290n0();
        if (holder == null) {
            m3283e0();
            return;
        }
        m3285i0();
        this.f7225u = true;
        this.f7223s = holder;
        holder.addCallback(this.f7210f);
        Surface surface = holder.getSurface();
        if (surface == null || !surface.isValid()) {
            m3288l0(null);
            m3284h0(0, 0);
        } else {
            m3288l0(surface);
            Rect surfaceFrame = holder.getSurfaceFrame();
            m3284h0(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    @Nullable
    /* JADX INFO: renamed from: t */
    public PlaybackException mo2925t() {
        m3290n0();
        return this.f7209e.f6657F.f7952g;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: u */
    public void mo2926u(boolean z2) {
        m3290n0();
        int iM3464e = this.f7215k.m3464e(z2, mo2930y());
        m3289m0(z2, iM3464e, m3282g0(z2, iM3464e));
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: v */
    public long mo2927v() {
        m3290n0();
        return this.f7209e.f6677t;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: w */
    public long mo2928w() {
        m3290n0();
        return this.f7209e.mo2928w();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: x */
    public void mo2929x(Player2.e eVar) {
        Objects.requireNonNull(eVar);
        this.f7212h.add(eVar);
        this.f7209e.m2898d0(eVar);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: y */
    public int mo2930y() {
        m3290n0();
        return this.f7209e.f6657F.f7951f;
    }
}
