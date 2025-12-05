package p007b.p225i.p226a.p242c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.DefaultMediaClock;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.MediaSourceList;
import p007b.p225i.p226a.p242c.PlayerMessage;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriod;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.SampleStream;
import p007b.p225i.p226a.p242c.p243a3.SequenceableLoader;
import p007b.p225i.p226a.p242c.p243a3.ShuffleOrder;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p245b3.TextRenderer;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;
import p007b.p225i.p226a.p242c.p255c3.TrackSelector;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectorResult;
import p007b.p225i.p226a.p242c.p257e3.BandwidthMeter;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p257e3.TransferListener;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p226a.p242c.p259f3.HandlerWrapper;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.MediaClock;
import p007b.p225i.p226a.p242c.p259f3.StandaloneMediaClock;
import p007b.p225i.p226a.p242c.p259f3.SystemHandlerWrapper;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.Collections2;
import p007b.p225i.p355b.p357b.ImmutableCollection;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* compiled from: ExoPlayerImplInternal.java */
/* renamed from: b.i.a.c.h1, reason: use source file name */
/* loaded from: classes3.dex */
public final class ExoPlayerImplInternal2 implements Handler.Callback, MediaPeriod.a, MediaSourceList.d, DefaultMediaClock.a, PlayerMessage.a {

    /* renamed from: A */
    public final e f7052A;

    /* renamed from: B */
    public final MediaPeriodQueue f7053B;

    /* renamed from: C */
    public final MediaSourceList f7054C;

    /* renamed from: D */
    public final LivePlaybackSpeedControl f7055D;

    /* renamed from: E */
    public final long f7056E;

    /* renamed from: F */
    public SeekParameters f7057F;

    /* renamed from: G */
    public PlaybackInfo f7058G;

    /* renamed from: H */
    public d f7059H;

    /* renamed from: I */
    public boolean f7060I;

    /* renamed from: J */
    public boolean f7061J;

    /* renamed from: K */
    public boolean f7062K;

    /* renamed from: L */
    public boolean f7063L;

    /* renamed from: M */
    public boolean f7064M;

    /* renamed from: N */
    public int f7065N;

    /* renamed from: O */
    public boolean f7066O;

    /* renamed from: P */
    public boolean f7067P;

    /* renamed from: Q */
    public boolean f7068Q;

    /* renamed from: R */
    public boolean f7069R;

    /* renamed from: S */
    public int f7070S;

    /* renamed from: T */
    @Nullable
    public g f7071T;

    /* renamed from: U */
    public long f7072U;

    /* renamed from: V */
    public int f7073V;

    /* renamed from: W */
    public boolean f7074W;

    /* renamed from: X */
    @Nullable
    public ExoPlaybackException f7075X;

    /* renamed from: j */
    public final Renderer2[] f7076j;

    /* renamed from: k */
    public final Set<Renderer2> f7077k;

    /* renamed from: l */
    public final RendererCapabilities[] f7078l;

    /* renamed from: m */
    public final TrackSelector f7079m;

    /* renamed from: n */
    public final TrackSelectorResult f7080n;

    /* renamed from: o */
    public final LoadControl f7081o;

    /* renamed from: p */
    public final BandwidthMeter f7082p;

    /* renamed from: q */
    public final HandlerWrapper f7083q;

    /* renamed from: r */
    public final HandlerThread f7084r;

    /* renamed from: s */
    public final Looper f7085s;

    /* renamed from: t */
    public final Timeline.c f7086t;

    /* renamed from: u */
    public final Timeline.b f7087u;

    /* renamed from: v */
    public final long f7088v;

    /* renamed from: w */
    public final boolean f7089w;

    /* renamed from: x */
    public final DefaultMediaClock f7090x;

    /* renamed from: y */
    public final ArrayList<c> f7091y;

    /* renamed from: z */
    public final Clock4 f7092z;

    /* compiled from: ExoPlayerImplInternal.java */
    /* renamed from: b.i.a.c.h1$a */
    public static final class a {

        /* renamed from: a */
        public final List<MediaSourceList.c> f7093a;

        /* renamed from: b */
        public final ShuffleOrder f7094b;

        /* renamed from: c */
        public final int f7095c;

        /* renamed from: d */
        public final long f7096d;

        public a(List list, ShuffleOrder shuffleOrder, int i, long j, ExoPlayerImplInternal exoPlayerImplInternal) {
            this.f7093a = list;
            this.f7094b = shuffleOrder;
            this.f7095c = i;
            this.f7096d = j;
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    /* renamed from: b.i.a.c.h1$b */
    public static class b {
    }

    /* compiled from: ExoPlayerImplInternal.java */
    /* renamed from: b.i.a.c.h1$c */
    public static final class c implements Comparable<c> {

        /* renamed from: j */
        public final PlayerMessage f7097j;

        /* renamed from: k */
        public int f7098k;

        /* renamed from: l */
        public long f7099l;

        /* renamed from: m */
        @Nullable
        public Object f7100m;

        /* JADX WARN: Removed duplicated region for block: B:13:0x0017  */
        @Override // java.lang.Comparable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            Object obj = this.f7100m;
            int i = 1;
            if ((obj == null) != (cVar2.f7100m == null)) {
                if (obj != null) {
                    i = -1;
                }
            } else {
                if (obj == null) {
                    return 0;
                }
                int i2 = this.f7098k - cVar2.f7098k;
                if (i2 != 0) {
                    return i2;
                }
                long j = this.f7099l;
                long j2 = cVar2.f7099l;
                int i3 = Util2.f6708a;
                if (j >= j2) {
                    if (j == j2) {
                        i = 0;
                    }
                }
            }
            return i;
        }

        /* renamed from: f */
        public void m3270f(int i, long j, Object obj) {
            this.f7098k = i;
            this.f7099l = j;
            this.f7100m = obj;
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    /* renamed from: b.i.a.c.h1$d */
    public static final class d {

        /* renamed from: a */
        public boolean f7101a;

        /* renamed from: b */
        public PlaybackInfo f7102b;

        /* renamed from: c */
        public int f7103c;

        /* renamed from: d */
        public boolean f7104d;

        /* renamed from: e */
        public int f7105e;

        /* renamed from: f */
        public boolean f7106f;

        /* renamed from: g */
        public int f7107g;

        public d(PlaybackInfo playbackInfo) {
            this.f7102b = playbackInfo;
        }

        /* renamed from: a */
        public void m3271a(int i) {
            this.f7101a |= i > 0;
            this.f7103c += i;
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    /* renamed from: b.i.a.c.h1$e */
    public interface e {
    }

    /* compiled from: ExoPlayerImplInternal.java */
    /* renamed from: b.i.a.c.h1$f */
    public static final class f {

        /* renamed from: a */
        public final MediaSource2.a f7108a;

        /* renamed from: b */
        public final long f7109b;

        /* renamed from: c */
        public final long f7110c;

        /* renamed from: d */
        public final boolean f7111d;

        /* renamed from: e */
        public final boolean f7112e;

        /* renamed from: f */
        public final boolean f7113f;

        public f(MediaSource2.a aVar, long j, long j2, boolean z2, boolean z3, boolean z4) {
            this.f7108a = aVar;
            this.f7109b = j;
            this.f7110c = j2;
            this.f7111d = z2;
            this.f7112e = z3;
            this.f7113f = z4;
        }
    }

    /* compiled from: ExoPlayerImplInternal.java */
    /* renamed from: b.i.a.c.h1$g */
    public static final class g {

        /* renamed from: a */
        public final Timeline f7114a;

        /* renamed from: b */
        public final int f7115b;

        /* renamed from: c */
        public final long f7116c;

        public g(Timeline timeline, int i, long j) {
            this.f7114a = timeline;
            this.f7115b = i;
            this.f7116c = j;
        }
    }

    public ExoPlayerImplInternal2(Renderer2[] renderer2Arr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i, boolean z2, @Nullable AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j, boolean z3, Looper looper, Clock4 clock4, e eVar) {
        this.f7052A = eVar;
        this.f7076j = renderer2Arr;
        this.f7079m = trackSelector;
        this.f7080n = trackSelectorResult;
        this.f7081o = loadControl;
        this.f7082p = bandwidthMeter;
        this.f7065N = i;
        this.f7066O = z2;
        this.f7057F = seekParameters;
        this.f7055D = livePlaybackSpeedControl;
        this.f7056E = j;
        this.f7061J = z3;
        this.f7092z = clock4;
        this.f7088v = loadControl.mo3310b();
        this.f7089w = loadControl.mo3309a();
        PlaybackInfo playbackInfoM3561h = PlaybackInfo.m3561h(trackSelectorResult);
        this.f7058G = playbackInfoM3561h;
        this.f7059H = new d(playbackInfoM3561h);
        this.f7078l = new RendererCapabilities[renderer2Arr.length];
        for (int i2 = 0; i2 < renderer2Arr.length; i2++) {
            renderer2Arr[i2].mo2932f(i2);
            this.f7078l[i2] = renderer2Arr[i2].mo2938m();
        }
        this.f7090x = new DefaultMediaClock(this, clock4);
        this.f7091y = new ArrayList<>();
        this.f7077k = Collections2.m6240c();
        this.f7086t = new Timeline.c();
        this.f7087u = new Timeline.b();
        trackSelector.f6325a = bandwidthMeter;
        this.f7074W = true;
        Handler handler = new Handler(looper);
        this.f7053B = new MediaPeriodQueue(analyticsCollector, handler);
        this.f7054C = new MediaSourceList(this, analyticsCollector, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.f7084r = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f7085s = looper2;
        this.f7083q = clock4.mo2950b(looper2, this);
    }

    /* renamed from: K */
    public static boolean m3206K(c cVar, Timeline timeline, Timeline timeline2, int i, boolean z2, Timeline.c cVar2, Timeline.b bVar) {
        Object obj = cVar.f7100m;
        if (obj == null) {
            Objects.requireNonNull(cVar.f7097j);
            Objects.requireNonNull(cVar.f7097j);
            long jM2981B = Util2.m2981B(-9223372036854775807L);
            PlayerMessage playerMessage = cVar.f7097j;
            Pair<Object, Long> pairM3207M = m3207M(timeline, new g(playerMessage.f5745d, playerMessage.f5749h, jM2981B), false, i, z2, cVar2, bVar);
            if (pairM3207M == null) {
                return false;
            }
            cVar.m3270f(timeline.mo2554b(pairM3207M.first), ((Long) pairM3207M.second).longValue(), pairM3207M.first);
            Objects.requireNonNull(cVar.f7097j);
            return true;
        }
        int iMo2554b = timeline.mo2554b(obj);
        if (iMo2554b == -1) {
            return false;
        }
        Objects.requireNonNull(cVar.f7097j);
        cVar.f7098k = iMo2554b;
        timeline2.mo3327h(cVar.f7100m, bVar);
        if (bVar.f7343o && timeline2.m3330n(bVar.f7340l, cVar2).f7350B == timeline2.mo2554b(cVar.f7100m)) {
            Pair<Object, Long> pairM3328j = timeline.m3328j(cVar2, bVar, timeline.mo3327h(cVar.f7100m, bVar).f7340l, cVar.f7099l + bVar.f7342n);
            cVar.m3270f(timeline.mo2554b(pairM3328j.first), ((Long) pairM3328j.second).longValue(), pairM3328j.first);
        }
        return true;
    }

    @Nullable
    /* renamed from: M */
    public static Pair<Object, Long> m3207M(Timeline timeline, g gVar, boolean z2, int i, boolean z3, Timeline.c cVar, Timeline.b bVar) {
        Pair<Object, Long> pairM3328j;
        Object objM3208N;
        Timeline timeline2 = gVar.f7114a;
        if (timeline.m3331q()) {
            return null;
        }
        Timeline timeline3 = timeline2.m3331q() ? timeline : timeline2;
        try {
            pairM3328j = timeline3.m3328j(cVar, bVar, gVar.f7115b, gVar.f7116c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (timeline.equals(timeline3)) {
            return pairM3328j;
        }
        if (timeline.mo2554b(pairM3328j.first) != -1) {
            return (timeline3.mo3327h(pairM3328j.first, bVar).f7343o && timeline3.m3330n(bVar.f7340l, cVar).f7350B == timeline3.mo2554b(pairM3328j.first)) ? timeline.m3328j(cVar, bVar, timeline.mo3327h(pairM3328j.first, bVar).f7340l, gVar.f7116c) : pairM3328j;
        }
        if (z2 && (objM3208N = m3208N(cVar, bVar, i, z3, pairM3328j.first, timeline3, timeline)) != null) {
            return timeline.m3328j(cVar, bVar, timeline.mo3327h(objM3208N, bVar).f7340l, -9223372036854775807L);
        }
        return null;
    }

    @Nullable
    /* renamed from: N */
    public static Object m3208N(Timeline.c cVar, Timeline.b bVar, int i, boolean z2, Object obj, Timeline timeline, Timeline timeline2) {
        int iMo2554b = timeline.mo2554b(obj);
        int iMo2555i = timeline.mo2555i();
        int iM3325d = iMo2554b;
        int iMo2554b2 = -1;
        for (int i2 = 0; i2 < iMo2555i && iMo2554b2 == -1; i2++) {
            iM3325d = timeline.m3325d(iM3325d, bVar, cVar, i, z2);
            if (iM3325d == -1) {
                break;
            }
            iMo2554b2 = timeline2.mo2554b(timeline.mo2556m(iM3325d));
        }
        if (iMo2554b2 == -1) {
            return null;
        }
        return timeline2.mo2556m(iMo2554b2);
    }

    /* renamed from: i */
    public static Format2[] m3209i(ExoTrackSelection2 exoTrackSelection2) {
        int length = exoTrackSelection2 != null ? exoTrackSelection2.length() : 0;
        Format2[] format2Arr = new Format2[length];
        for (int i = 0; i < length; i++) {
            format2Arr[i] = exoTrackSelection2.mo2729d(i);
        }
        return format2Arr;
    }

    /* renamed from: w */
    public static boolean m3210w(Renderer2 renderer2) {
        return renderer2.getState() != 0;
    }

    /* renamed from: y */
    public static boolean m3211y(PlaybackInfo playbackInfo, Timeline.b bVar) {
        MediaSource2.a aVar = playbackInfo.f7948c;
        Timeline timeline = playbackInfo.f7947b;
        return timeline.m3331q() || timeline.mo3327h(aVar.f5732a, bVar).f7343o;
    }

    /* renamed from: A */
    public final void m3212A() {
        d dVar = this.f7059H;
        PlaybackInfo playbackInfo = this.f7058G;
        boolean z2 = dVar.f7101a | (dVar.f7102b != playbackInfo);
        dVar.f7101a = z2;
        dVar.f7102b = playbackInfo;
        if (z2) {
            ExoPlayerImpl exoPlayerImpl = ((C2962w) this.f7052A).f7945a;
            exoPlayerImpl.f6664g.mo2955b(new RunnableC2632c0(exoPlayerImpl, dVar));
            this.f7059H = new d(this.f7058G);
        }
    }

    /* renamed from: B */
    public final void m3213B() throws Throwable {
        m3263r(this.f7054C.m3537c(), true);
    }

    /* renamed from: C */
    public final void m3214C(b bVar) throws Throwable {
        this.f7059H.m3271a(1);
        MediaSourceList mediaSourceList = this.f7054C;
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(mediaSourceList);
        AnimatableValueParser.m531j(mediaSourceList.m3539e() >= 0);
        mediaSourceList.f7872i = null;
        m3263r(mediaSourceList.m3537c(), false);
    }

    /* renamed from: D */
    public final void m3215D() {
        this.f7059H.m3271a(1);
        m3219H(false, false, false, true);
        this.f7081o.mo3311c();
        m3244f0(this.f7058G.f7947b.m3331q() ? 4 : 2);
        MediaSourceList mediaSourceList = this.f7054C;
        TransferListener transferListenerMo2844c = this.f7082p.mo2844c();
        AnimatableValueParser.m426D(!mediaSourceList.f7873j);
        mediaSourceList.f7874k = transferListenerMo2844c;
        for (int i = 0; i < mediaSourceList.f7864a.size(); i++) {
            MediaSourceList.c cVar = mediaSourceList.f7864a.get(i);
            mediaSourceList.m3541g(cVar);
            mediaSourceList.f7871h.add(cVar);
        }
        mediaSourceList.f7873j = true;
        this.f7083q.mo2959f(2);
    }

    /* renamed from: E */
    public final void m3216E() {
        m3219H(true, false, true, false);
        this.f7081o.mo3313e();
        m3244f0(1);
        this.f7084r.quit();
        synchronized (this) {
            this.f7060I = true;
            notifyAll();
        }
    }

    /* renamed from: F */
    public final void m3217F(int i, int i2, ShuffleOrder shuffleOrder) throws Throwable {
        this.f7059H.m3271a(1);
        MediaSourceList mediaSourceList = this.f7054C;
        Objects.requireNonNull(mediaSourceList);
        AnimatableValueParser.m531j(i >= 0 && i <= i2 && i2 <= mediaSourceList.m3539e());
        mediaSourceList.f7872i = shuffleOrder;
        mediaSourceList.m3543i(i, i2);
        m3263r(mediaSourceList.m3537c(), false);
    }

    /* renamed from: G */
    public final void m3218G() throws ExoPlaybackException {
        boolean z2;
        float f2 = this.f7090x.mo2416c().f8027k;
        MediaPeriodQueue mediaPeriodQueue = this.f7053B;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.f7493h;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.f7494i;
        boolean z3 = true;
        for (MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodHolder; mediaPeriodHolder3 != null && mediaPeriodHolder3.f7445d; mediaPeriodHolder3 = mediaPeriodHolder3.f7453l) {
            TrackSelectorResult trackSelectorResultM3355i = mediaPeriodHolder3.m3355i(f2, this.f7058G.f7947b);
            TrackSelectorResult trackSelectorResult = mediaPeriodHolder3.f7455n;
            if (trackSelectorResult == null || trackSelectorResult.f6328c.length != trackSelectorResultM3355i.f6328c.length) {
                z2 = false;
                break;
            }
            for (int i = 0; i < trackSelectorResultM3355i.f6328c.length; i++) {
                if (!trackSelectorResultM3355i.m2755a(trackSelectorResult, i)) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (!z2) {
                if (z3) {
                    MediaPeriodQueue mediaPeriodQueue2 = this.f7053B;
                    MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodQueue2.f7493h;
                    boolean zM3378n = mediaPeriodQueue2.m3378n(mediaPeriodHolder4);
                    boolean[] zArr = new boolean[this.f7076j.length];
                    long jM3347a = mediaPeriodHolder4.m3347a(trackSelectorResultM3355i, this.f7058G.f7965t, zM3378n, zArr);
                    PlaybackInfo playbackInfo = this.f7058G;
                    boolean z4 = (playbackInfo.f7951f == 4 || jM3347a == playbackInfo.f7965t) ? false : true;
                    PlaybackInfo playbackInfo2 = this.f7058G;
                    this.f7058G = m3266u(playbackInfo2.f7948c, jM3347a, playbackInfo2.f7949d, playbackInfo2.f7950e, z4, 5);
                    if (z4) {
                        m3221J(jM3347a);
                    }
                    boolean[] zArr2 = new boolean[this.f7076j.length];
                    int i2 = 0;
                    while (true) {
                        Renderer2[] renderer2Arr = this.f7076j;
                        if (i2 >= renderer2Arr.length) {
                            break;
                        }
                        Renderer2 renderer2 = renderer2Arr[i2];
                        zArr2[i2] = m3210w(renderer2);
                        SampleStream sampleStream = mediaPeriodHolder4.f7444c[i2];
                        if (zArr2[i2]) {
                            if (sampleStream != renderer2.mo2934h()) {
                                m3241e(renderer2);
                            } else if (zArr[i2]) {
                                renderer2.mo2943u(this.f7072U);
                            }
                        }
                        i2++;
                    }
                    m3247h(zArr2);
                } else {
                    this.f7053B.m3378n(mediaPeriodHolder3);
                    if (mediaPeriodHolder3.f7445d) {
                        mediaPeriodHolder3.m3347a(trackSelectorResultM3355i, Math.max(mediaPeriodHolder3.f7447f.f7466b, this.f7072U - mediaPeriodHolder3.f7456o), false, new boolean[mediaPeriodHolder3.f7450i.length]);
                    }
                }
                m3262q(true);
                if (this.f7058G.f7951f != 4) {
                    m3269z();
                    m3259n0();
                    this.f7083q.mo2959f(2);
                    return;
                }
                return;
            }
            if (mediaPeriodHolder3 == mediaPeriodHolder2) {
                z3 = false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b4 A[PHI: r4 r5 r7
      0x00b4: PHI (r4v4 b.i.a.c.a3.a0$a) = (r4v3 b.i.a.c.a3.a0$a), (r4v10 b.i.a.c.a3.a0$a) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r5v2 long) = (r5v1 long), (r5v7 long) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r7v3 long) = (r7v2 long), (r7v6 long) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3219H(boolean z2, boolean z3, boolean z4, boolean z5) {
        MediaSource2.a aVar;
        long j;
        boolean z6;
        List list;
        this.f7083q.mo2961h(2);
        this.f7075X = null;
        this.f7063L = false;
        DefaultMediaClock defaultMediaClock = this.f7090x;
        defaultMediaClock.f5472o = false;
        StandaloneMediaClock standaloneMediaClock = defaultMediaClock.f5467j;
        if (standaloneMediaClock.f6801k) {
            standaloneMediaClock.m3117a(standaloneMediaClock.mo2417e());
            standaloneMediaClock.f6801k = false;
        }
        this.f7072U = 1000000000000L;
        for (Renderer2 renderer2 : this.f7076j) {
            try {
                m3241e(renderer2);
            } catch (ExoPlaybackException | RuntimeException e2) {
                Log2.m3039b("ExoPlayerImplInternal", "Disable failed.", e2);
            }
        }
        if (z2) {
            for (Renderer2 renderer22 : this.f7076j) {
                if (this.f7077k.remove(renderer22)) {
                    try {
                        renderer22.reset();
                    } catch (RuntimeException e3) {
                        Log2.m3039b("ExoPlayerImplInternal", "Reset failed.", e3);
                    }
                }
            }
        }
        this.f7070S = 0;
        PlaybackInfo playbackInfo = this.f7058G;
        MediaSource2.a aVar2 = playbackInfo.f7948c;
        long jLongValue = playbackInfo.f7965t;
        long j2 = (this.f7058G.f7948c.m2593a() || m3211y(this.f7058G, this.f7087u)) ? this.f7058G.f7949d : this.f7058G.f7965t;
        if (z3) {
            this.f7071T = null;
            Pair<MediaSource2.a, Long> pairM3254l = m3254l(this.f7058G.f7947b);
            aVar2 = (MediaSource2.a) pairM3254l.first;
            jLongValue = ((Long) pairM3254l.second).longValue();
            j2 = -9223372036854775807L;
            if (aVar2.equals(this.f7058G.f7948c)) {
                aVar = aVar2;
                j = jLongValue;
                z6 = false;
            } else {
                z6 = true;
                aVar = aVar2;
                j = jLongValue;
            }
        }
        this.f7053B.m3366b();
        this.f7064M = false;
        PlaybackInfo playbackInfo2 = this.f7058G;
        Timeline timeline = playbackInfo2.f7947b;
        int i = playbackInfo2.f7951f;
        ExoPlaybackException exoPlaybackException = z5 ? null : playbackInfo2.f7952g;
        TrackGroupArray trackGroupArray = z6 ? TrackGroupArray.f5674j : playbackInfo2.f7954i;
        TrackSelectorResult trackSelectorResult = z6 ? this.f7080n : playbackInfo2.f7955j;
        if (z6) {
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
            list = RegularImmutableList.f12012l;
        } else {
            list = playbackInfo2.f7956k;
        }
        this.f7058G = new PlaybackInfo(timeline, aVar, j2, j, i, exoPlaybackException, false, trackGroupArray, trackSelectorResult, list, aVar, playbackInfo2.f7958m, playbackInfo2.f7959n, playbackInfo2.f7960o, j, 0L, j, this.f7069R, false);
        if (z4) {
            MediaSourceList mediaSourceList = this.f7054C;
            for (MediaSourceList.b bVar : mediaSourceList.f7870g.values()) {
                try {
                    bVar.f7879a.mo2446a(bVar.f7880b);
                } catch (RuntimeException e4) {
                    Log2.m3039b("MediaSourceList", "Failed to release child source.", e4);
                }
                bVar.f7879a.mo2448c(bVar.f7881c);
                bVar.f7879a.mo2452g(bVar.f7881c);
            }
            mediaSourceList.f7870g.clear();
            mediaSourceList.f7871h.clear();
            mediaSourceList.f7873j = false;
        }
    }

    /* renamed from: I */
    public final void m3220I() {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h;
        this.f7062K = mediaPeriodHolder != null && mediaPeriodHolder.f7447f.f7472h && this.f7061J;
    }

    /* renamed from: J */
    public final void m3221J(long j) throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h;
        long j2 = j + (mediaPeriodHolder == null ? 1000000000000L : mediaPeriodHolder.f7456o);
        this.f7072U = j2;
        this.f7090x.f5467j.m3117a(j2);
        for (Renderer2 renderer2 : this.f7076j) {
            if (m3210w(renderer2)) {
                renderer2.mo2943u(this.f7072U);
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = this.f7053B.f7493h; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.f7453l) {
            for (ExoTrackSelection2 exoTrackSelection2 : mediaPeriodHolder2.f7455n.f6328c) {
                if (exoTrackSelection2 != null) {
                    exoTrackSelection2.mo2732j();
                }
            }
        }
    }

    /* renamed from: L */
    public final void m3222L(Timeline timeline, Timeline timeline2) {
        if (timeline.m3331q() && timeline2.m3331q()) {
            return;
        }
        int size = this.f7091y.size();
        while (true) {
            size--;
            if (size < 0) {
                Collections.sort(this.f7091y);
                return;
            } else if (!m3206K(this.f7091y.get(size), timeline, timeline2, this.f7065N, this.f7066O, this.f7086t, this.f7087u)) {
                this.f7091y.get(size).f7097j.m2599c(false);
                this.f7091y.remove(size);
            }
        }
    }

    /* renamed from: O */
    public final void m3223O(long j, long j2) {
        this.f7083q.mo2961h(2);
        this.f7083q.mo2960g(2, j + j2);
    }

    /* renamed from: P */
    public final void m3224P(boolean z2) throws ExoPlaybackException {
        MediaSource2.a aVar = this.f7053B.f7493h.f7447f.f7465a;
        long jM3227S = m3227S(aVar, this.f7058G.f7965t, true, false);
        if (jM3227S != this.f7058G.f7965t) {
            PlaybackInfo playbackInfo = this.f7058G;
            this.f7058G = m3266u(aVar, jM3227S, playbackInfo.f7949d, playbackInfo.f7950e, z2, 5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ab A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ae  */
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3225Q(g gVar) throws Throwable {
        long jLongValue;
        long j;
        boolean z2;
        MediaSource2.a aVar;
        long j2;
        long j3;
        long j4;
        long jMo2485i;
        long j5;
        PlaybackInfo playbackInfo;
        int i;
        this.f7059H.m3271a(1);
        Pair<Object, Long> pairM3207M = m3207M(this.f7058G.f7947b, gVar, true, this.f7065N, this.f7066O, this.f7086t, this.f7087u);
        try {
            if (pairM3207M == null) {
                Pair<MediaSource2.a, Long> pairM3254l = m3254l(this.f7058G.f7947b);
                aVar = (MediaSource2.a) pairM3254l.first;
                jLongValue = ((Long) pairM3254l.second).longValue();
                z2 = !this.f7058G.f7947b.m3331q();
                j = -9223372036854775807L;
            } else {
                Object obj = pairM3207M.first;
                jLongValue = ((Long) pairM3207M.second).longValue();
                long j6 = gVar.f7116c == -9223372036854775807L ? -9223372036854775807L : jLongValue;
                MediaSource2.a aVarM3379o = this.f7053B.m3379o(this.f7058G.f7947b, obj, jLongValue);
                if (aVarM3379o.m2593a()) {
                    this.f7058G.f7947b.mo3327h(aVarM3379o.f5732a, this.f7087u);
                    j2 = this.f7087u.m3335d(aVarM3379o.f5733b) == aVarM3379o.f5734c ? this.f7087u.f7344p.f5685o : 0L;
                    j3 = j6;
                    z2 = true;
                    aVar = aVarM3379o;
                    if (!this.f7058G.f7947b.m3331q()) {
                        this.f7071T = gVar;
                    } else {
                        if (pairM3207M != null) {
                            if (aVar.equals(this.f7058G.f7948c)) {
                                MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h;
                                jMo2485i = (mediaPeriodHolder == null || !mediaPeriodHolder.f7445d || j2 == 0) ? j2 : mediaPeriodHolder.f7442a.mo2485i(j2, this.f7057F);
                                if (Util2.m2992M(jMo2485i) == Util2.m2992M(this.f7058G.f7965t) && ((i = (playbackInfo = this.f7058G).f7951f) == 2 || i == 3)) {
                                    long j7 = playbackInfo.f7965t;
                                    this.f7058G = m3266u(aVar, j7, j3, j7, z2, 2);
                                    return;
                                }
                            } else {
                                jMo2485i = j2;
                            }
                            long jM3226R = m3226R(aVar, jMo2485i, this.f7058G.f7951f == 4);
                            boolean z3 = (j2 != jM3226R) | z2;
                            try {
                                PlaybackInfo playbackInfo2 = this.f7058G;
                                Timeline timeline = playbackInfo2.f7947b;
                                m3257m0(timeline, aVar, timeline, playbackInfo2.f7948c, j3);
                                z2 = z3;
                                j5 = jM3226R;
                                this.f7058G = m3266u(aVar, j5, j3, j5, z2, 2);
                                return;
                            } catch (Throwable th) {
                                th = th;
                                z2 = z3;
                                j4 = jM3226R;
                                this.f7058G = m3266u(aVar, j4, j3, j4, z2, 2);
                                throw th;
                            }
                        }
                        if (this.f7058G.f7951f != 1) {
                            m3244f0(4);
                        }
                        m3219H(false, true, false, true);
                    }
                    j5 = j2;
                    this.f7058G = m3266u(aVar, j5, j3, j5, z2, 2);
                    return;
                }
                j = j6;
                z2 = gVar.f7116c == -9223372036854775807L;
                aVar = aVarM3379o;
            }
            if (!this.f7058G.f7947b.m3331q()) {
            }
            j5 = j2;
            this.f7058G = m3266u(aVar, j5, j3, j5, z2, 2);
            return;
        } catch (Throwable th2) {
            th = th2;
            j4 = j2;
        }
        j2 = jLongValue;
        j3 = j;
    }

    /* renamed from: R */
    public final long m3226R(MediaSource2.a aVar, long j, boolean z2) throws ExoPlaybackException {
        MediaPeriodQueue mediaPeriodQueue = this.f7053B;
        return m3227S(aVar, j, mediaPeriodQueue.f7493h != mediaPeriodQueue.f7494i, z2);
    }

    /* renamed from: S */
    public final long m3227S(MediaSource2.a aVar, long j, boolean z2, boolean z3) throws ExoPlaybackException {
        MediaPeriodQueue mediaPeriodQueue;
        m3253k0();
        this.f7063L = false;
        if (z3 || this.f7058G.f7951f == 3) {
            m3244f0(2);
        }
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder;
        while (mediaPeriodHolder2 != null && !aVar.equals(mediaPeriodHolder2.f7447f.f7465a)) {
            mediaPeriodHolder2 = mediaPeriodHolder2.f7453l;
        }
        if (z2 || mediaPeriodHolder != mediaPeriodHolder2 || (mediaPeriodHolder2 != null && mediaPeriodHolder2.f7456o + j < 0)) {
            for (Renderer2 renderer2 : this.f7076j) {
                m3241e(renderer2);
            }
            if (mediaPeriodHolder2 != null) {
                while (true) {
                    mediaPeriodQueue = this.f7053B;
                    if (mediaPeriodQueue.f7493h == mediaPeriodHolder2) {
                        break;
                    }
                    mediaPeriodQueue.m3365a();
                }
                mediaPeriodQueue.m3378n(mediaPeriodHolder2);
                mediaPeriodHolder2.f7456o = 1000000000000L;
                m3245g();
            }
        }
        if (mediaPeriodHolder2 != null) {
            this.f7053B.m3378n(mediaPeriodHolder2);
            if (!mediaPeriodHolder2.f7445d) {
                mediaPeriodHolder2.f7447f = mediaPeriodHolder2.f7447f.m3361b(j);
            } else if (mediaPeriodHolder2.f7446e) {
                long jMo2482f = mediaPeriodHolder2.f7442a.mo2482f(j);
                mediaPeriodHolder2.f7442a.mo2494r(jMo2482f - this.f7088v, this.f7089w);
                j = jMo2482f;
            }
            m3221J(j);
            m3269z();
        } else {
            this.f7053B.m3366b();
            m3221J(j);
        }
        m3262q(false);
        this.f7083q.mo2959f(2);
        return j;
    }

    /* renamed from: T */
    public final void m3228T(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.f5748g != this.f7085s) {
            ((SystemHandlerWrapper.b) this.f7083q.mo2962i(15, playerMessage)).m2965b();
            return;
        }
        m3239d(playerMessage);
        int i = this.f7058G.f7951f;
        if (i == 3 || i == 2) {
            this.f7083q.mo2959f(2);
        }
    }

    /* renamed from: U */
    public final void m3229U(PlayerMessage playerMessage) {
        Looper looper = playerMessage.f5748g;
        if (looper.getThread().isAlive()) {
            this.f7092z.mo2950b(looper, null).mo2955b(new RunnableC2761g0(this, playerMessage));
        } else {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.m2599c(false);
        }
    }

    /* renamed from: V */
    public final void m3230V(Renderer2 renderer2, long j) {
        renderer2.mo2937l();
        if (renderer2 instanceof TextRenderer) {
            TextRenderer textRenderer = (TextRenderer) renderer2;
            AnimatableValueParser.m426D(textRenderer.f7898s);
            textRenderer.f5811I = j;
        }
    }

    /* renamed from: W */
    public final void m3231W(boolean z2, @Nullable AtomicBoolean atomicBoolean) {
        if (this.f7067P != z2) {
            this.f7067P = z2;
            if (!z2) {
                for (Renderer2 renderer2 : this.f7076j) {
                    if (!m3210w(renderer2) && this.f7077k.remove(renderer2)) {
                        renderer2.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    /* renamed from: X */
    public final void m3232X(a aVar) throws Throwable {
        this.f7059H.m3271a(1);
        if (aVar.f7095c != -1) {
            this.f7071T = new g(new PlaylistTimeline(aVar.f7093a, aVar.f7094b), aVar.f7095c, aVar.f7096d);
        }
        MediaSourceList mediaSourceList = this.f7054C;
        List<MediaSourceList.c> list = aVar.f7093a;
        ShuffleOrder shuffleOrder = aVar.f7094b;
        mediaSourceList.m3543i(0, mediaSourceList.f7864a.size());
        m3263r(mediaSourceList.m3535a(mediaSourceList.f7864a.size(), list, shuffleOrder), false);
    }

    /* renamed from: Y */
    public final void m3233Y(boolean z2) {
        if (z2 == this.f7069R) {
            return;
        }
        this.f7069R = z2;
        PlaybackInfo playbackInfo = this.f7058G;
        int i = playbackInfo.f7951f;
        if (z2 || i == 4 || i == 1) {
            this.f7058G = playbackInfo.m3564c(z2);
        } else {
            this.f7083q.mo2959f(2);
        }
    }

    /* renamed from: Z */
    public final void m3234Z(boolean z2) throws ExoPlaybackException {
        this.f7061J = z2;
        m3220I();
        if (this.f7062K) {
            MediaPeriodQueue mediaPeriodQueue = this.f7053B;
            if (mediaPeriodQueue.f7494i != mediaPeriodQueue.f7493h) {
                m3224P(true);
                m3262q(false);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.SequenceableLoader.a
    /* renamed from: a */
    public void mo2542a(SequenceableLoader sequenceableLoader) {
        ((SystemHandlerWrapper.b) this.f7083q.mo2962i(9, (MediaPeriod) sequenceableLoader)).m2965b();
    }

    /* renamed from: a0 */
    public final void m3235a0(boolean z2, int i, boolean z3, int i2) throws ExoPlaybackException {
        this.f7059H.m3271a(z3 ? 1 : 0);
        d dVar = this.f7059H;
        dVar.f7101a = true;
        dVar.f7106f = true;
        dVar.f7107g = i2;
        this.f7058G = this.f7058G.m3565d(z2, i);
        this.f7063L = false;
        for (MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.f7453l) {
            for (ExoTrackSelection2 exoTrackSelection2 : mediaPeriodHolder.f7455n.f6328c) {
                if (exoTrackSelection2 != null) {
                    exoTrackSelection2.mo2728c(z2);
                }
            }
        }
        if (!m3246g0()) {
            m3253k0();
            m3259n0();
            return;
        }
        int i3 = this.f7058G.f7951f;
        if (i3 == 3) {
            m3249i0();
            this.f7083q.mo2959f(2);
        } else if (i3 == 2) {
            this.f7083q.mo2959f(2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod.a
    /* renamed from: b */
    public void mo2563b(MediaPeriod mediaPeriod) {
        ((SystemHandlerWrapper.b) this.f7083q.mo2962i(8, mediaPeriod)).m2965b();
    }

    /* renamed from: b0 */
    public final void m3236b0(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        this.f7090x.mo2418i(playbackParameters);
        PlaybackParameters playbackParametersMo2416c = this.f7090x.mo2416c();
        m3265t(playbackParametersMo2416c, playbackParametersMo2416c.f8027k, true, true);
    }

    /* renamed from: c */
    public final void m3237c(a aVar, int i) throws Throwable {
        this.f7059H.m3271a(1);
        MediaSourceList mediaSourceList = this.f7054C;
        if (i == -1) {
            i = mediaSourceList.m3539e();
        }
        m3263r(mediaSourceList.m3535a(i, aVar.f7093a, aVar.f7094b), false);
    }

    /* renamed from: c0 */
    public final void m3238c0(int i) throws ExoPlaybackException {
        this.f7065N = i;
        MediaPeriodQueue mediaPeriodQueue = this.f7053B;
        Timeline timeline = this.f7058G.f7947b;
        mediaPeriodQueue.f7491f = i;
        if (!mediaPeriodQueue.m3380q(timeline)) {
            m3224P(true);
        }
        m3262q(false);
    }

    /* renamed from: d */
    public final void m3239d(PlayerMessage playerMessage) throws ExoPlaybackException {
        playerMessage.m2598b();
        try {
            playerMessage.f5742a.mo2603r(playerMessage.f5746e, playerMessage.f5747f);
        } finally {
            playerMessage.m2599c(true);
        }
    }

    /* renamed from: d0 */
    public final void m3240d0(boolean z2) throws ExoPlaybackException {
        this.f7066O = z2;
        MediaPeriodQueue mediaPeriodQueue = this.f7053B;
        Timeline timeline = this.f7058G.f7947b;
        mediaPeriodQueue.f7492g = z2;
        if (!mediaPeriodQueue.m3380q(timeline)) {
            m3224P(true);
        }
        m3262q(false);
    }

    /* renamed from: e */
    public final void m3241e(Renderer2 renderer2) throws ExoPlaybackException {
        if (renderer2.getState() != 0) {
            DefaultMediaClock defaultMediaClock = this.f7090x;
            if (renderer2 == defaultMediaClock.f5469l) {
                defaultMediaClock.f5470m = null;
                defaultMediaClock.f5469l = null;
                defaultMediaClock.f5471n = true;
            }
            if (renderer2.getState() == 2) {
                renderer2.stop();
            }
            renderer2.mo2933g();
            this.f7070S--;
        }
    }

    /* renamed from: e0 */
    public final void m3242e0(ShuffleOrder shuffleOrder) throws Throwable {
        this.f7059H.m3271a(1);
        MediaSourceList mediaSourceList = this.f7054C;
        int iM3539e = mediaSourceList.m3539e();
        if (shuffleOrder.mo2544b() != iM3539e) {
            shuffleOrder = shuffleOrder.mo2550h().mo2548f(0, iM3539e);
        }
        mediaSourceList.f7872i = shuffleOrder;
        m3263r(mediaSourceList.m3537c(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:297:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014e  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3243f() throws ExoPlaybackException, IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean zM3268x;
        int i;
        boolean z5;
        boolean z6;
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2;
        boolean z7;
        long jMo2949a = this.f7092z.mo2949a();
        if (!this.f7058G.f7947b.m3331q() && this.f7054C.f7873j) {
            this.f7053B.m3377m(this.f7072U);
            MediaPeriodQueue mediaPeriodQueue = this.f7053B;
            MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodQueue.f7495j;
            if (mediaPeriodHolder3 == null || (!mediaPeriodHolder3.f7447f.f7473i && mediaPeriodHolder3.m3352f() && mediaPeriodQueue.f7495j.f7447f.f7469e != -9223372036854775807L && mediaPeriodQueue.f7496k < 100)) {
                MediaPeriodQueue mediaPeriodQueue2 = this.f7053B;
                long j = this.f7072U;
                PlaybackInfo playbackInfo = this.f7058G;
                MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodQueue2.f7495j;
                MediaPeriodInfo mediaPeriodInfoM3368d = mediaPeriodHolder4 == null ? mediaPeriodQueue2.m3368d(playbackInfo.f7947b, playbackInfo.f7948c, playbackInfo.f7949d, playbackInfo.f7965t) : mediaPeriodQueue2.m3367c(playbackInfo.f7947b, mediaPeriodHolder4, j);
                if (mediaPeriodInfoM3368d != null) {
                    MediaPeriodQueue mediaPeriodQueue3 = this.f7053B;
                    RendererCapabilities[] rendererCapabilitiesArr = this.f7078l;
                    TrackSelector trackSelector = this.f7079m;
                    DefaultAllocator defaultAllocatorMo3316h = this.f7081o.mo3316h();
                    MediaSourceList mediaSourceList = this.f7054C;
                    TrackSelectorResult trackSelectorResult = this.f7080n;
                    MediaPeriodHolder mediaPeriodHolder5 = mediaPeriodQueue3.f7495j;
                    MediaPeriodHolder mediaPeriodHolder6 = new MediaPeriodHolder(rendererCapabilitiesArr, mediaPeriodHolder5 == null ? 1000000000000L : (mediaPeriodHolder5.f7456o + mediaPeriodHolder5.f7447f.f7469e) - mediaPeriodInfoM3368d.f7466b, trackSelector, defaultAllocatorMo3316h, mediaSourceList, mediaPeriodInfoM3368d, trackSelectorResult);
                    MediaPeriodHolder mediaPeriodHolder7 = mediaPeriodQueue3.f7495j;
                    if (mediaPeriodHolder7 == null) {
                        mediaPeriodQueue3.f7493h = mediaPeriodHolder6;
                        mediaPeriodQueue3.f7494i = mediaPeriodHolder6;
                    } else if (mediaPeriodHolder6 != mediaPeriodHolder7.f7453l) {
                        mediaPeriodHolder7.m3348b();
                        mediaPeriodHolder7.f7453l = mediaPeriodHolder6;
                        mediaPeriodHolder7.m3349c();
                    }
                    mediaPeriodQueue3.f7497l = null;
                    mediaPeriodQueue3.f7495j = mediaPeriodHolder6;
                    mediaPeriodQueue3.f7496k++;
                    mediaPeriodQueue3.m3376l();
                    mediaPeriodHolder6.f7442a.mo2488l(this, mediaPeriodInfoM3368d.f7466b);
                    if (this.f7053B.f7493h == mediaPeriodHolder6) {
                        m3221J(mediaPeriodInfoM3368d.f7466b);
                    }
                    m3262q(false);
                }
            }
            if (this.f7064M) {
                this.f7064M = m3267v();
                m3255l0();
            } else {
                m3269z();
            }
            MediaPeriodHolder mediaPeriodHolder8 = this.f7053B.f7494i;
            if (mediaPeriodHolder8 != null) {
                if (mediaPeriodHolder8.f7453l == null || this.f7062K) {
                    if (mediaPeriodHolder8.f7447f.f7473i || this.f7062K) {
                        int i2 = 0;
                        while (true) {
                            Renderer2[] renderer2Arr = this.f7076j;
                            if (i2 >= renderer2Arr.length) {
                                break;
                            }
                            Renderer2 renderer2 = renderer2Arr[i2];
                            SampleStream sampleStream = mediaPeriodHolder8.f7444c[i2];
                            if (sampleStream != null && renderer2.mo2934h() == sampleStream && renderer2.mo2935j()) {
                                long j2 = mediaPeriodHolder8.f7447f.f7469e;
                                m3230V(renderer2, (j2 == -9223372036854775807L || j2 == Long.MIN_VALUE) ? -9223372036854775807L : j2 + mediaPeriodHolder8.f7456o);
                            }
                            i2++;
                        }
                    }
                } else if (mediaPeriodHolder8.f7445d) {
                    int i3 = 0;
                    while (true) {
                        Renderer2[] renderer2Arr2 = this.f7076j;
                        if (i3 >= renderer2Arr2.length) {
                            z7 = true;
                            break;
                        }
                        Renderer2 renderer22 = renderer2Arr2[i3];
                        SampleStream sampleStream2 = mediaPeriodHolder8.f7444c[i3];
                        if (renderer22.mo2934h() != sampleStream2) {
                            break;
                        }
                        if (sampleStream2 != null && !renderer22.mo2935j()) {
                            MediaPeriodHolder mediaPeriodHolder9 = mediaPeriodHolder8.f7453l;
                            if (!(mediaPeriodHolder8.f7447f.f7470f && mediaPeriodHolder9.f7445d && ((renderer22 instanceof TextRenderer) || renderer22.mo2942t() >= mediaPeriodHolder9.m3351e()))) {
                                break;
                            }
                        }
                        i3++;
                    }
                    z7 = false;
                    if (z7) {
                    }
                } else {
                    z7 = false;
                    if (z7) {
                        MediaPeriodHolder mediaPeriodHolder10 = mediaPeriodHolder8.f7453l;
                        if (mediaPeriodHolder10.f7445d || this.f7072U >= mediaPeriodHolder10.m3351e()) {
                            TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder8.f7455n;
                            MediaPeriodQueue mediaPeriodQueue4 = this.f7053B;
                            MediaPeriodHolder mediaPeriodHolder11 = mediaPeriodQueue4.f7494i;
                            AnimatableValueParser.m426D((mediaPeriodHolder11 == null || mediaPeriodHolder11.f7453l == null) ? false : true);
                            mediaPeriodQueue4.f7494i = mediaPeriodQueue4.f7494i.f7453l;
                            mediaPeriodQueue4.m3376l();
                            MediaPeriodHolder mediaPeriodHolder12 = mediaPeriodQueue4.f7494i;
                            TrackSelectorResult trackSelectorResult3 = mediaPeriodHolder12.f7455n;
                            if (!mediaPeriodHolder12.f7445d || mediaPeriodHolder12.f7442a.mo2487k() == -9223372036854775807L) {
                                for (int i4 = 0; i4 < this.f7076j.length; i4++) {
                                    boolean zM2756b = trackSelectorResult2.m2756b(i4);
                                    boolean zM2756b2 = trackSelectorResult3.m2756b(i4);
                                    if (zM2756b && !this.f7076j[i4].mo2944v()) {
                                        boolean z8 = ((BaseRenderer) this.f7078l[i4]).f7889j == -2;
                                        RendererConfiguration rendererConfiguration = trackSelectorResult2.f6327b[i4];
                                        RendererConfiguration rendererConfiguration2 = trackSelectorResult3.f6327b[i4];
                                        if (!zM2756b2 || !rendererConfiguration2.equals(rendererConfiguration) || z8) {
                                            m3230V(this.f7076j[i4], mediaPeriodHolder12.m3351e());
                                        }
                                    }
                                }
                            } else {
                                long jM3351e = mediaPeriodHolder12.m3351e();
                                for (Renderer2 renderer23 : this.f7076j) {
                                    if (renderer23.mo2934h() != null) {
                                        m3230V(renderer23, jM3351e);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            MediaPeriodQueue mediaPeriodQueue5 = this.f7053B;
            MediaPeriodHolder mediaPeriodHolder13 = mediaPeriodQueue5.f7494i;
            if (mediaPeriodHolder13 != null && mediaPeriodQueue5.f7493h != mediaPeriodHolder13 && !mediaPeriodHolder13.f7448g) {
                TrackSelectorResult trackSelectorResult4 = mediaPeriodHolder13.f7455n;
                int i5 = 0;
                boolean z9 = false;
                while (true) {
                    Renderer2[] renderer2Arr3 = this.f7076j;
                    if (i5 >= renderer2Arr3.length) {
                        break;
                    }
                    Renderer2 renderer24 = renderer2Arr3[i5];
                    if (m3210w(renderer24)) {
                        boolean z10 = renderer24.mo2934h() != mediaPeriodHolder13.f7444c[i5];
                        if (!trackSelectorResult4.m2756b(i5) || z10) {
                            if (!renderer24.mo2944v()) {
                                renderer24.mo2936k(m3209i(trackSelectorResult4.f6328c[i5]), mediaPeriodHolder13.f7444c[i5], mediaPeriodHolder13.m3351e(), mediaPeriodHolder13.f7456o);
                            } else if (renderer24.mo2631b()) {
                                m3241e(renderer24);
                            } else {
                                z9 = true;
                            }
                        }
                    }
                    i5++;
                }
                if (!z9) {
                    m3245g();
                }
            }
            boolean z11 = false;
            while (true) {
                if (!(m3246g0() && !this.f7062K && (mediaPeriodHolder = this.f7053B.f7493h) != null && (mediaPeriodHolder2 = mediaPeriodHolder.f7453l) != null && this.f7072U >= mediaPeriodHolder2.m3351e() && mediaPeriodHolder2.f7448g)) {
                    break;
                }
                if (z11) {
                    m3212A();
                }
                MediaPeriodQueue mediaPeriodQueue6 = this.f7053B;
                MediaPeriodHolder mediaPeriodHolder14 = mediaPeriodQueue6.f7493h;
                MediaPeriodHolder mediaPeriodHolderM3365a = mediaPeriodQueue6.m3365a();
                MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolderM3365a.f7447f;
                MediaSource2.a aVar = mediaPeriodInfo.f7465a;
                long j3 = mediaPeriodInfo.f7466b;
                PlaybackInfo playbackInfoM3266u = m3266u(aVar, j3, mediaPeriodInfo.f7467c, j3, true, 0);
                this.f7058G = playbackInfoM3266u;
                Timeline timeline = playbackInfoM3266u.f7947b;
                m3257m0(timeline, mediaPeriodHolderM3365a.f7447f.f7465a, timeline, mediaPeriodHolder14.f7447f.f7465a, -9223372036854775807L);
                m3220I();
                m3259n0();
                z11 = true;
            }
        }
        int i6 = this.f7058G.f7951f;
        if (i6 == 1 || i6 == 4) {
            this.f7083q.mo2961h(2);
            return;
        }
        MediaPeriodHolder mediaPeriodHolder15 = this.f7053B.f7493h;
        if (mediaPeriodHolder15 == null) {
            m3223O(jMo2949a, 10L);
            return;
        }
        AnimatableValueParser.m515f("doSomeWork");
        m3259n0();
        if (mediaPeriodHolder15.f7445d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            mediaPeriodHolder15.f7442a.mo2494r(this.f7058G.f7965t - this.f7088v, this.f7089w);
            boolean z12 = true;
            z2 = true;
            int i7 = 0;
            while (true) {
                Renderer2[] renderer2Arr4 = this.f7076j;
                if (i7 >= renderer2Arr4.length) {
                    break;
                }
                Renderer2 renderer25 = renderer2Arr4[i7];
                if (m3210w(renderer25)) {
                    renderer25.mo2633q(this.f7072U, jElapsedRealtime);
                    boolean z13 = z12 && renderer25.mo2631b();
                    boolean z14 = mediaPeriodHolder15.f7444c[i7] != renderer25.mo2934h();
                    boolean z15 = z14 || (!z14 && renderer25.mo2935j()) || renderer25.mo2632d() || renderer25.mo2631b();
                    boolean z16 = z2 && z15;
                    if (!z15) {
                        renderer25.mo2941s();
                    }
                    z2 = z16;
                    z12 = z13;
                }
                i7++;
            }
            z3 = z12;
        } else {
            mediaPeriodHolder15.f7442a.mo2481e();
            z2 = true;
            z3 = true;
        }
        long j4 = mediaPeriodHolder15.f7447f.f7469e;
        boolean z17 = z3 && mediaPeriodHolder15.f7445d && (j4 == -9223372036854775807L || j4 <= this.f7058G.f7965t);
        if (z17 && this.f7062K) {
            z4 = false;
            this.f7062K = false;
            m3235a0(false, this.f7058G.f7959n, false, 5);
        } else {
            z4 = false;
        }
        if (z17 && mediaPeriodHolder15.f7447f.f7473i) {
            m3244f0(4);
            m3253k0();
        } else {
            PlaybackInfo playbackInfo2 = this.f7058G;
            if (playbackInfo2.f7951f == 2) {
                if (this.f7070S == 0) {
                    zM3268x = m3268x();
                } else if (z2) {
                    if (playbackInfo2.f7953h) {
                        long j5 = m3248h0(playbackInfo2.f7947b, this.f7053B.f7493h.f7447f.f7465a) ? ((DefaultLivePlaybackSpeedControl) this.f7055D).f9025i : -9223372036854775807L;
                        MediaPeriodHolder mediaPeriodHolder16 = this.f7053B.f7495j;
                        boolean z18 = mediaPeriodHolder16.m3352f() && mediaPeriodHolder16.f7447f.f7473i;
                        boolean z19 = mediaPeriodHolder16.f7447f.f7465a.m2593a() && !mediaPeriodHolder16.f7445d;
                        if (!z18 && !z19 && !this.f7081o.mo3314f(m3256m(), this.f7090x.mo2416c().f8027k, this.f7063L, j5)) {
                            zM3268x = false;
                        }
                    }
                    zM3268x = true;
                }
                if (zM3268x) {
                    m3244f0(3);
                    this.f7075X = null;
                    if (m3246g0()) {
                        m3249i0();
                    }
                }
            } else if (this.f7058G.f7951f == 3 && (this.f7070S != 0 ? !z2 : !m3268x())) {
                this.f7063L = m3246g0();
                m3244f0(2);
                if (this.f7063L) {
                    for (MediaPeriodHolder mediaPeriodHolder17 = this.f7053B.f7493h; mediaPeriodHolder17 != null; mediaPeriodHolder17 = mediaPeriodHolder17.f7453l) {
                        for (ExoTrackSelection2 exoTrackSelection2 : mediaPeriodHolder17.f7455n.f6328c) {
                            if (exoTrackSelection2 != null) {
                                exoTrackSelection2.mo2733k();
                            }
                        }
                    }
                    DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = (DefaultLivePlaybackSpeedControl) this.f7055D;
                    long j6 = defaultLivePlaybackSpeedControl.f9025i;
                    if (j6 != -9223372036854775807L) {
                        long j7 = j6 + defaultLivePlaybackSpeedControl.f9018b;
                        defaultLivePlaybackSpeedControl.f9025i = j7;
                        long j8 = defaultLivePlaybackSpeedControl.f9024h;
                        if (j8 != -9223372036854775807L && j7 > j8) {
                            defaultLivePlaybackSpeedControl.f9025i = j8;
                        }
                        defaultLivePlaybackSpeedControl.f9029m = -9223372036854775807L;
                    }
                }
                m3253k0();
            }
        }
        if (this.f7058G.f7951f == 2) {
            int i8 = 0;
            while (true) {
                Renderer2[] renderer2Arr5 = this.f7076j;
                if (i8 >= renderer2Arr5.length) {
                    break;
                }
                if (m3210w(renderer2Arr5[i8]) && this.f7076j[i8].mo2934h() == mediaPeriodHolder15.f7444c[i8]) {
                    this.f7076j[i8].mo2941s();
                }
                i8++;
            }
            PlaybackInfo playbackInfo3 = this.f7058G;
            if (!playbackInfo3.f7953h && playbackInfo3.f7964s < 500000 && m3267v()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z20 = this.f7069R;
        PlaybackInfo playbackInfo4 = this.f7058G;
        if (z20 != playbackInfo4.f7961p) {
            this.f7058G = playbackInfo4.m3564c(z20);
        }
        if ((m3246g0() && this.f7058G.f7951f == 3) || (i = this.f7058G.f7951f) == 2) {
            if (this.f7069R && this.f7068Q) {
                z6 = false;
            } else {
                this.f7083q.mo2961h(2);
                this.f7083q.mo2960g(2, jMo2949a + 10);
                z6 = true;
            }
            z5 = !z6;
        } else {
            if (this.f7070S == 0 || i == 4) {
                this.f7083q.mo2961h(2);
            } else {
                m3223O(jMo2949a, 1000L);
            }
            z5 = false;
        }
        PlaybackInfo playbackInfo5 = this.f7058G;
        if (playbackInfo5.f7962q != z5) {
            this.f7058G = new PlaybackInfo(playbackInfo5.f7947b, playbackInfo5.f7948c, playbackInfo5.f7949d, playbackInfo5.f7950e, playbackInfo5.f7951f, playbackInfo5.f7952g, playbackInfo5.f7953h, playbackInfo5.f7954i, playbackInfo5.f7955j, playbackInfo5.f7956k, playbackInfo5.f7957l, playbackInfo5.f7958m, playbackInfo5.f7959n, playbackInfo5.f7960o, playbackInfo5.f7963r, playbackInfo5.f7964s, playbackInfo5.f7965t, playbackInfo5.f7961p, z5);
        }
        this.f7068Q = z4;
        AnimatableValueParser.m508d0();
    }

    /* renamed from: f0 */
    public final void m3244f0(int i) {
        PlaybackInfo playbackInfo = this.f7058G;
        if (playbackInfo.f7951f != i) {
            this.f7058G = playbackInfo.m3567f(i);
        }
    }

    /* renamed from: g */
    public final void m3245g() throws ExoPlaybackException {
        m3247h(new boolean[this.f7076j.length]);
    }

    /* renamed from: g0 */
    public final boolean m3246g0() {
        PlaybackInfo playbackInfo = this.f7058G;
        return playbackInfo.f7958m && playbackInfo.f7959n == 0;
    }

    /* renamed from: h */
    public final void m3247h(boolean[] zArr) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7494i;
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.f7455n;
        for (int i = 0; i < this.f7076j.length; i++) {
            if (!trackSelectorResult.m2756b(i) && this.f7077k.remove(this.f7076j[i])) {
                this.f7076j[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.f7076j.length; i2++) {
            if (trackSelectorResult.m2756b(i2)) {
                boolean z2 = zArr[i2];
                Renderer2 renderer2 = this.f7076j[i2];
                if (m3210w(renderer2)) {
                    continue;
                } else {
                    MediaPeriodQueue mediaPeriodQueue = this.f7053B;
                    MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.f7494i;
                    boolean z3 = mediaPeriodHolder2 == mediaPeriodQueue.f7493h;
                    TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder2.f7455n;
                    RendererConfiguration rendererConfiguration = trackSelectorResult2.f6327b[i2];
                    Format2[] format2ArrM3209i = m3209i(trackSelectorResult2.f6328c[i2]);
                    boolean z4 = m3246g0() && this.f7058G.f7951f == 3;
                    boolean z5 = !z2 && z4;
                    this.f7070S++;
                    this.f7077k.add(renderer2);
                    renderer2.mo2940o(rendererConfiguration, format2ArrM3209i, mediaPeriodHolder2.f7444c[i2], this.f7072U, z5, z3, mediaPeriodHolder2.m3351e(), mediaPeriodHolder2.f7456o);
                    renderer2.mo2603r(11, new ExoPlayerImplInternal(this));
                    DefaultMediaClock defaultMediaClock = this.f7090x;
                    Objects.requireNonNull(defaultMediaClock);
                    MediaClock mediaClockMo2945w = renderer2.mo2945w();
                    if (mediaClockMo2945w != null && mediaClockMo2945w != (mediaClock = defaultMediaClock.f5470m)) {
                        if (mediaClock != null) {
                            throw ExoPlaybackException.m8753b(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
                        }
                        defaultMediaClock.f5470m = mediaClockMo2945w;
                        defaultMediaClock.f5469l = renderer2;
                        mediaClockMo2945w.mo2418i(defaultMediaClock.f5467j.f6804n);
                    }
                    if (z4) {
                        renderer2.start();
                    }
                }
            }
        }
        mediaPeriodHolder.f7448g = true;
    }

    /* renamed from: h0 */
    public final boolean m3248h0(Timeline timeline, MediaSource2.a aVar) {
        if (aVar.m2593a() || timeline.m3331q()) {
            return false;
        }
        timeline.m3330n(timeline.mo3327h(aVar.f5732a, this.f7087u).f7340l, this.f7086t);
        if (!this.f7086t.m3341c()) {
            return false;
        }
        Timeline.c cVar = this.f7086t;
        return cVar.f7361v && cVar.f7358s != -9223372036854775807L;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        MediaPeriodHolder mediaPeriodHolder;
        try {
            switch (message.what) {
                case 0:
                    m3215D();
                    break;
                case 1:
                    m3235a0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    m3243f();
                    break;
                case 3:
                    m3225Q((g) message.obj);
                    break;
                case 4:
                    m3236b0((PlaybackParameters) message.obj);
                    break;
                case 5:
                    this.f7057F = (SeekParameters) message.obj;
                    break;
                case 6:
                    m3251j0(false, true);
                    break;
                case 7:
                    m3216E();
                    return true;
                case 8:
                    m3264s((MediaPeriod) message.obj);
                    break;
                case 9:
                    m3260o((MediaPeriod) message.obj);
                    break;
                case 10:
                    m3218G();
                    break;
                case 11:
                    m3238c0(message.arg1);
                    break;
                case 12:
                    m3240d0(message.arg1 != 0);
                    break;
                case 13:
                    m3231W(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    PlayerMessage playerMessage = (PlayerMessage) message.obj;
                    Objects.requireNonNull(playerMessage);
                    m3228T(playerMessage);
                    break;
                case 15:
                    m3229U((PlayerMessage) message.obj);
                    break;
                case 16:
                    PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
                    m3265t(playbackParameters, playbackParameters.f8027k, true, false);
                    break;
                case 17:
                    m3232X((a) message.obj);
                    break;
                case 18:
                    m3237c((a) message.obj, message.arg1);
                    break;
                case 19:
                    m3214C((b) message.obj);
                    break;
                case 20:
                    m3217F(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    m3242e0((ShuffleOrder) message.obj);
                    break;
                case 22:
                    m3213B();
                    break;
                case 23:
                    m3234Z(message.arg1 != 0);
                    break;
                case 24:
                    m3233Y(message.arg1 == 1);
                    break;
                case 25:
                    m3224P(true);
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (mediaPeriodHolder = this.f7053B.f7494i) != null) {
                e = e.m8754a(mediaPeriodHolder.f7447f.f7465a);
            }
            if (e.isRecoverable && this.f7075X == null) {
                Log2.m3040c("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.f7075X = e;
                HandlerWrapper handlerWrapper = this.f7083q;
                handlerWrapper.mo2957d(handlerWrapper.mo2962i(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.f7075X;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.f7075X;
                }
                Log2.m3039b("ExoPlayerImplInternal", "Playback error", e);
                m3251j0(true, false);
                this.f7058G = this.f7058G.m3566e(e);
            }
        } catch (ParserException e3) {
            int i = e3.dataType;
            if (i == 1) {
                i = e3.contentIsMalformed ? 3001 : 3003;
            } else if (i == 4) {
                i = e3.contentIsMalformed ? 3002 : 3004;
            }
            m3261p(e3, i);
        } catch (DrmSession.DrmSessionException e4) {
            m3261p(e4, e4.errorCode);
        } catch (BehindLiveWindowException e5) {
            m3261p(e5, PointerIconCompat.TYPE_HAND);
        } catch (DataSourceException e6) {
            m3261p(e6, e6.reason);
        } catch (IOException e7) {
            m3261p(e7, 2000);
        } catch (RuntimeException e8) {
            ExoPlaybackException exoPlaybackExceptionM8753b = ExoPlaybackException.m8753b(e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? PointerIconCompat.TYPE_WAIT : 1000);
            Log2.m3039b("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionM8753b);
            m3251j0(true, false);
            this.f7058G = this.f7058G.m3566e(exoPlaybackExceptionM8753b);
        }
        m3212A();
        return true;
    }

    /* renamed from: i0 */
    public final void m3249i0() throws ExoPlaybackException {
        this.f7063L = false;
        DefaultMediaClock defaultMediaClock = this.f7090x;
        defaultMediaClock.f5472o = true;
        defaultMediaClock.f5467j.m3118b();
        for (Renderer2 renderer2 : this.f7076j) {
            if (m3210w(renderer2)) {
                renderer2.start();
            }
        }
    }

    /* renamed from: j */
    public final long m3250j(Timeline timeline, Object obj, long j) {
        timeline.m3330n(timeline.mo3327h(obj, this.f7087u).f7340l, this.f7086t);
        Timeline.c cVar = this.f7086t;
        if (cVar.f7358s != -9223372036854775807L && cVar.m3341c()) {
            Timeline.c cVar2 = this.f7086t;
            if (cVar2.f7361v) {
                long j2 = cVar2.f7359t;
                int i = Util2.f6708a;
                return Util2.m2981B((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - this.f7086t.f7358s) - (j + this.f7087u.f7342n);
            }
        }
        return -9223372036854775807L;
    }

    /* renamed from: j0 */
    public final void m3251j0(boolean z2, boolean z3) {
        m3219H(z2 || !this.f7067P, false, true, false);
        this.f7059H.m3271a(z3 ? 1 : 0);
        this.f7081o.mo3317i();
        m3244f0(1);
    }

    /* renamed from: k */
    public final long m3252k() {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7494i;
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        long jMax = mediaPeriodHolder.f7456o;
        if (!mediaPeriodHolder.f7445d) {
            return jMax;
        }
        int i = 0;
        while (true) {
            Renderer2[] renderer2Arr = this.f7076j;
            if (i >= renderer2Arr.length) {
                return jMax;
            }
            if (m3210w(renderer2Arr[i]) && this.f7076j[i].mo2934h() == mediaPeriodHolder.f7444c[i]) {
                long jMo2942t = this.f7076j[i].mo2942t();
                if (jMo2942t == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jMax = Math.max(jMo2942t, jMax);
            }
            i++;
        }
    }

    /* renamed from: k0 */
    public final void m3253k0() throws ExoPlaybackException {
        DefaultMediaClock defaultMediaClock = this.f7090x;
        defaultMediaClock.f5472o = false;
        StandaloneMediaClock standaloneMediaClock = defaultMediaClock.f5467j;
        if (standaloneMediaClock.f6801k) {
            standaloneMediaClock.m3117a(standaloneMediaClock.mo2417e());
            standaloneMediaClock.f6801k = false;
        }
        for (Renderer2 renderer2 : this.f7076j) {
            if (m3210w(renderer2) && renderer2.getState() == 2) {
                renderer2.stop();
            }
        }
    }

    /* renamed from: l */
    public final Pair<MediaSource2.a, Long> m3254l(Timeline timeline) {
        if (timeline.m3331q()) {
            MediaSource2.a aVar = PlaybackInfo.f7946a;
            return Pair.create(PlaybackInfo.f7946a, 0L);
        }
        Pair<Object, Long> pairM3328j = timeline.m3328j(this.f7086t, this.f7087u, timeline.mo2582a(this.f7066O), -9223372036854775807L);
        MediaSource2.a aVarM3379o = this.f7053B.m3379o(timeline, pairM3328j.first, 0L);
        long jLongValue = ((Long) pairM3328j.second).longValue();
        if (aVarM3379o.m2593a()) {
            timeline.mo3327h(aVarM3379o.f5732a, this.f7087u);
            jLongValue = aVarM3379o.f5734c == this.f7087u.m3335d(aVarM3379o.f5733b) ? this.f7087u.f7344p.f5685o : 0L;
        }
        return Pair.create(aVarM3379o, Long.valueOf(jLongValue));
    }

    /* renamed from: l0 */
    public final void m3255l0() {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7495j;
        boolean z2 = this.f7064M || (mediaPeriodHolder != null && mediaPeriodHolder.f7442a.mo2484h());
        PlaybackInfo playbackInfo = this.f7058G;
        if (z2 != playbackInfo.f7953h) {
            this.f7058G = new PlaybackInfo(playbackInfo.f7947b, playbackInfo.f7948c, playbackInfo.f7949d, playbackInfo.f7950e, playbackInfo.f7951f, playbackInfo.f7952g, z2, playbackInfo.f7954i, playbackInfo.f7955j, playbackInfo.f7956k, playbackInfo.f7957l, playbackInfo.f7958m, playbackInfo.f7959n, playbackInfo.f7960o, playbackInfo.f7963r, playbackInfo.f7964s, playbackInfo.f7965t, playbackInfo.f7961p, playbackInfo.f7962q);
        }
    }

    /* renamed from: m */
    public final long m3256m() {
        return m3258n(this.f7058G.f7963r);
    }

    /* renamed from: m0 */
    public final void m3257m0(Timeline timeline, MediaSource2.a aVar, Timeline timeline2, MediaSource2.a aVar2, long j) {
        if (timeline.m3331q() || !m3248h0(timeline, aVar)) {
            float f2 = this.f7090x.mo2416c().f8027k;
            PlaybackParameters playbackParameters = this.f7058G.f7960o;
            if (f2 != playbackParameters.f8027k) {
                this.f7090x.mo2418i(playbackParameters);
                return;
            }
            return;
        }
        timeline.m3330n(timeline.mo3327h(aVar.f5732a, this.f7087u).f7340l, this.f7086t);
        LivePlaybackSpeedControl livePlaybackSpeedControl = this.f7055D;
        MediaItem2.g gVar = this.f7086t.f7363x;
        int i = Util2.f6708a;
        DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = (DefaultLivePlaybackSpeedControl) livePlaybackSpeedControl;
        Objects.requireNonNull(defaultLivePlaybackSpeedControl);
        defaultLivePlaybackSpeedControl.f9020d = Util2.m2981B(gVar.f7308l);
        defaultLivePlaybackSpeedControl.f9023g = Util2.m2981B(gVar.f7309m);
        defaultLivePlaybackSpeedControl.f9024h = Util2.m2981B(gVar.f7310n);
        float f3 = gVar.f7311o;
        if (f3 == -3.4028235E38f) {
            f3 = 0.97f;
        }
        defaultLivePlaybackSpeedControl.f9027k = f3;
        float f4 = gVar.f7312p;
        if (f4 == -3.4028235E38f) {
            f4 = 1.03f;
        }
        defaultLivePlaybackSpeedControl.f9026j = f4;
        defaultLivePlaybackSpeedControl.m3825a();
        if (j != -9223372036854775807L) {
            DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl2 = (DefaultLivePlaybackSpeedControl) this.f7055D;
            defaultLivePlaybackSpeedControl2.f9021e = m3250j(timeline, aVar.f5732a, j);
            defaultLivePlaybackSpeedControl2.m3825a();
        } else {
            if (Util2.m2993a(timeline2.m3331q() ? null : timeline2.m3330n(timeline2.mo3327h(aVar2.f5732a, this.f7087u).f7340l, this.f7086t).f7353n, this.f7086t.f7353n)) {
                return;
            }
            DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl3 = (DefaultLivePlaybackSpeedControl) this.f7055D;
            defaultLivePlaybackSpeedControl3.f9021e = -9223372036854775807L;
            defaultLivePlaybackSpeedControl3.m3825a();
        }
    }

    /* renamed from: n */
    public final long m3258n(long j) {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7495j;
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.f7072U - mediaPeriodHolder.f7456o));
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x0166, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /* renamed from: n0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3259n0() throws ExoPlaybackException {
        PlaybackParameters playbackParametersMo2416c;
        long j;
        ExoPlayerImplInternal2 exoPlayerImplInternal2;
        c cVar;
        c cVar2;
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h;
        if (mediaPeriodHolder == null) {
            return;
        }
        long jMo2487k = mediaPeriodHolder.f7445d ? mediaPeriodHolder.f7442a.mo2487k() : -9223372036854775807L;
        if (jMo2487k != -9223372036854775807L) {
            m3221J(jMo2487k);
            if (jMo2487k != this.f7058G.f7965t) {
                PlaybackInfo playbackInfo = this.f7058G;
                this.f7058G = m3266u(playbackInfo.f7948c, jMo2487k, playbackInfo.f7949d, jMo2487k, true, 5);
            }
        } else {
            DefaultMediaClock defaultMediaClock = this.f7090x;
            boolean z2 = mediaPeriodHolder != this.f7053B.f7494i;
            Renderer2 renderer2 = defaultMediaClock.f5469l;
            if (renderer2 == null || renderer2.mo2631b() || (!defaultMediaClock.f5469l.mo2632d() && (z2 || defaultMediaClock.f5469l.mo2935j()))) {
                defaultMediaClock.f5471n = true;
                if (defaultMediaClock.f5472o) {
                    defaultMediaClock.f5467j.m3118b();
                }
            } else {
                MediaClock mediaClock = defaultMediaClock.f5470m;
                Objects.requireNonNull(mediaClock);
                long jMo2417e = mediaClock.mo2417e();
                if (!defaultMediaClock.f5471n) {
                    defaultMediaClock.f5467j.m3117a(jMo2417e);
                    playbackParametersMo2416c = mediaClock.mo2416c();
                    if (!playbackParametersMo2416c.equals(defaultMediaClock.f5467j.f6804n)) {
                        StandaloneMediaClock standaloneMediaClock = defaultMediaClock.f5467j;
                        if (standaloneMediaClock.f6801k) {
                            standaloneMediaClock.m3117a(standaloneMediaClock.mo2417e());
                        }
                        standaloneMediaClock.f6804n = playbackParametersMo2416c;
                        ((SystemHandlerWrapper.b) ((ExoPlayerImplInternal2) defaultMediaClock.f5468k).f7083q.mo2962i(16, playbackParametersMo2416c)).m2965b();
                    }
                } else if (jMo2417e < defaultMediaClock.f5467j.mo2417e()) {
                    StandaloneMediaClock standaloneMediaClock2 = defaultMediaClock.f5467j;
                    if (standaloneMediaClock2.f6801k) {
                        standaloneMediaClock2.m3117a(standaloneMediaClock2.mo2417e());
                        standaloneMediaClock2.f6801k = false;
                    }
                } else {
                    defaultMediaClock.f5471n = false;
                    if (defaultMediaClock.f5472o) {
                        defaultMediaClock.f5467j.m3118b();
                    }
                    defaultMediaClock.f5467j.m3117a(jMo2417e);
                    playbackParametersMo2416c = mediaClock.mo2416c();
                    if (!playbackParametersMo2416c.equals(defaultMediaClock.f5467j.f6804n)) {
                    }
                }
            }
            long jMo2417e2 = defaultMediaClock.mo2417e();
            this.f7072U = jMo2417e2;
            long j2 = jMo2417e2 - mediaPeriodHolder.f7456o;
            long j3 = this.f7058G.f7965t;
            if (!this.f7091y.isEmpty() && !this.f7058G.f7948c.m2593a()) {
                if (this.f7074W) {
                    j3--;
                    this.f7074W = false;
                }
                PlaybackInfo playbackInfo2 = this.f7058G;
                int iMo2554b = playbackInfo2.f7947b.mo2554b(playbackInfo2.f7948c.f5732a);
                int iMin = Math.min(this.f7073V, this.f7091y.size());
                if (iMin > 0) {
                    cVar = this.f7091y.get(iMin - 1);
                    j = j2;
                    exoPlayerImplInternal2 = this;
                } else {
                    j = j2;
                    exoPlayerImplInternal2 = this;
                    cVar = null;
                }
                while (cVar != null) {
                    int i = cVar.f7098k;
                    if (i <= iMo2554b && (i != iMo2554b || cVar.f7099l <= j3)) {
                        break;
                    }
                    iMin--;
                    if (iMin > 0) {
                        cVar = exoPlayerImplInternal2.f7091y.get(iMin - 1);
                    } else {
                        j = j;
                        exoPlayerImplInternal2 = exoPlayerImplInternal2;
                        cVar = null;
                    }
                }
                if (iMin < exoPlayerImplInternal2.f7091y.size()) {
                    cVar2 = exoPlayerImplInternal2.f7091y.get(iMin);
                    while (cVar2 != null && cVar2.f7100m != null) {
                        int i2 = cVar2.f7098k;
                        if (i2 >= iMo2554b && (i2 != iMo2554b || cVar2.f7099l > j3)) {
                            break;
                        }
                        iMin++;
                        if (iMin < exoPlayerImplInternal2.f7091y.size()) {
                            cVar2 = exoPlayerImplInternal2.f7091y.get(iMin);
                        }
                    }
                    while (cVar2 != null && cVar2.f7100m != null && cVar2.f7098k == iMo2554b) {
                        long j4 = cVar2.f7099l;
                        if (j4 <= j3 || j4 > j) {
                            break;
                        }
                        try {
                            exoPlayerImplInternal2.m3228T(cVar2.f7097j);
                            Objects.requireNonNull(cVar2.f7097j);
                            exoPlayerImplInternal2.f7091y.remove(iMin);
                            cVar2 = iMin < exoPlayerImplInternal2.f7091y.size() ? exoPlayerImplInternal2.f7091y.get(iMin) : null;
                        } catch (Throwable th) {
                            Objects.requireNonNull(cVar2.f7097j);
                            exoPlayerImplInternal2.f7091y.remove(iMin);
                            throw th;
                        }
                    }
                    exoPlayerImplInternal2.f7073V = iMin;
                }
                cVar2 = null;
            }
            this.f7058G.f7965t = j2;
        }
        this.f7058G.f7963r = this.f7053B.f7495j.m3350d();
        this.f7058G.f7964s = m3256m();
        PlaybackInfo playbackInfo3 = this.f7058G;
        if (playbackInfo3.f7958m && playbackInfo3.f7951f == 3 && m3248h0(playbackInfo3.f7947b, playbackInfo3.f7948c)) {
            PlaybackInfo playbackInfo4 = this.f7058G;
            float f2 = 1.0f;
            if (playbackInfo4.f7960o.f8027k == 1.0f) {
                LivePlaybackSpeedControl livePlaybackSpeedControl = this.f7055D;
                long jM3250j = m3250j(playbackInfo4.f7947b, playbackInfo4.f7948c.f5732a, playbackInfo4.f7965t);
                long jM3256m = m3256m();
                DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = (DefaultLivePlaybackSpeedControl) livePlaybackSpeedControl;
                if (defaultLivePlaybackSpeedControl.f9020d != -9223372036854775807L) {
                    long j5 = jM3250j - jM3256m;
                    long j6 = defaultLivePlaybackSpeedControl.f9030n;
                    if (j6 == -9223372036854775807L) {
                        defaultLivePlaybackSpeedControl.f9030n = j5;
                        defaultLivePlaybackSpeedControl.f9031o = 0L;
                    } else {
                        float f3 = defaultLivePlaybackSpeedControl.f9019c;
                        long jMax = Math.max(j5, (long) (((1.0f - f3) * j5) + (j6 * f3)));
                        defaultLivePlaybackSpeedControl.f9030n = jMax;
                        long jAbs = Math.abs(j5 - jMax);
                        long j7 = defaultLivePlaybackSpeedControl.f9031o;
                        float f4 = defaultLivePlaybackSpeedControl.f9019c;
                        defaultLivePlaybackSpeedControl.f9031o = (long) (((1.0f - f4) * jAbs) + (j7 * f4));
                    }
                    if (defaultLivePlaybackSpeedControl.f9029m == -9223372036854775807L || SystemClock.elapsedRealtime() - defaultLivePlaybackSpeedControl.f9029m >= 1000) {
                        defaultLivePlaybackSpeedControl.f9029m = SystemClock.elapsedRealtime();
                        long j8 = (defaultLivePlaybackSpeedControl.f9031o * 3) + defaultLivePlaybackSpeedControl.f9030n;
                        if (defaultLivePlaybackSpeedControl.f9025i > j8) {
                            float fM2981B = Util2.m2981B(1000L);
                            long[] jArr = {j8, defaultLivePlaybackSpeedControl.f9022f, defaultLivePlaybackSpeedControl.f9025i - (((long) ((defaultLivePlaybackSpeedControl.f9028l - 1.0f) * fM2981B)) + ((long) ((defaultLivePlaybackSpeedControl.f9026j - 1.0f) * fM2981B)))};
                            C3404f.m4351v(true);
                            long j9 = jArr[0];
                            for (int i3 = 1; i3 < 3; i3++) {
                                if (jArr[i3] > j9) {
                                    j9 = jArr[i3];
                                }
                            }
                            defaultLivePlaybackSpeedControl.f9025i = j9;
                        } else {
                            long jM3001i = Util2.m3001i(jM3250j - ((long) (Math.max(0.0f, defaultLivePlaybackSpeedControl.f9028l - 1.0f) / 1.0E-7f)), defaultLivePlaybackSpeedControl.f9025i, j8);
                            defaultLivePlaybackSpeedControl.f9025i = jM3001i;
                            long j10 = defaultLivePlaybackSpeedControl.f9024h;
                            if (j10 != -9223372036854775807L && jM3001i > j10) {
                                defaultLivePlaybackSpeedControl.f9025i = j10;
                            }
                        }
                        long j11 = jM3250j - defaultLivePlaybackSpeedControl.f9025i;
                        if (Math.abs(j11) < defaultLivePlaybackSpeedControl.f9017a) {
                            defaultLivePlaybackSpeedControl.f9028l = 1.0f;
                        } else {
                            defaultLivePlaybackSpeedControl.f9028l = Util2.m2999g((1.0E-7f * j11) + 1.0f, defaultLivePlaybackSpeedControl.f9027k, defaultLivePlaybackSpeedControl.f9026j);
                        }
                        f2 = defaultLivePlaybackSpeedControl.f9028l;
                    } else {
                        f2 = defaultLivePlaybackSpeedControl.f9028l;
                    }
                }
                if (this.f7090x.mo2416c().f8027k != f2) {
                    this.f7090x.mo2418i(new PlaybackParameters(f2, this.f7058G.f7960o.f8028l));
                    m3265t(this.f7058G.f7960o, this.f7090x.mo2416c().f8027k, false, false);
                }
            }
        }
    }

    /* renamed from: o */
    public final void m3260o(MediaPeriod mediaPeriod) {
        MediaPeriodQueue mediaPeriodQueue = this.f7053B;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.f7495j;
        if (mediaPeriodHolder != null && mediaPeriodHolder.f7442a == mediaPeriod) {
            mediaPeriodQueue.m3377m(this.f7072U);
            m3269z();
        }
    }

    /* renamed from: p */
    public final void m3261p(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, iOException, i);
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h;
        if (mediaPeriodHolder != null) {
            exoPlaybackException = exoPlaybackException.m8754a(mediaPeriodHolder.f7447f.f7465a);
        }
        Log2.m3039b("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
        m3251j0(false, false);
        this.f7058G = this.f7058G.m3566e(exoPlaybackException);
    }

    /* renamed from: q */
    public final void m3262q(boolean z2) {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7495j;
        MediaSource2.a aVar = mediaPeriodHolder == null ? this.f7058G.f7948c : mediaPeriodHolder.f7447f.f7465a;
        boolean z3 = !this.f7058G.f7957l.equals(aVar);
        if (z3) {
            this.f7058G = this.f7058G.m3562a(aVar);
        }
        PlaybackInfo playbackInfo = this.f7058G;
        playbackInfo.f7963r = mediaPeriodHolder == null ? playbackInfo.f7965t : mediaPeriodHolder.m3350d();
        this.f7058G.f7964s = m3256m();
        if ((z3 || z2) && mediaPeriodHolder != null && mediaPeriodHolder.f7445d) {
            this.f7081o.mo3312d(this.f7076j, mediaPeriodHolder.f7454m, mediaPeriodHolder.f7455n.f6328c);
        }
    }

    /* renamed from: r */
    public final void m3263r(Timeline timeline, boolean z2) throws Throwable {
        Object obj;
        MediaSource2.a aVar;
        int iMo2582a;
        Object obj2;
        long j;
        long j2;
        int i;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iMo2582a2;
        boolean z6;
        boolean z7;
        long j3;
        long j4;
        f fVar;
        long j5;
        int i3;
        long jLongValue;
        Object obj3;
        boolean z8;
        int i4;
        int iMo2582a3;
        boolean z9;
        boolean z10;
        boolean z11;
        long j6;
        g gVar;
        boolean z12;
        boolean z13;
        boolean z14;
        PlaybackInfo playbackInfo = this.f7058G;
        g gVar2 = this.f7071T;
        MediaPeriodQueue mediaPeriodQueue = this.f7053B;
        int i5 = this.f7065N;
        boolean z15 = this.f7066O;
        Timeline.c cVar = this.f7086t;
        Timeline.b bVar = this.f7087u;
        if (timeline.m3331q()) {
            MediaSource2.a aVar2 = PlaybackInfo.f7946a;
            fVar = new f(PlaybackInfo.f7946a, 0L, -9223372036854775807L, false, true, false);
        } else {
            MediaSource2.a aVar3 = playbackInfo.f7948c;
            Object obj4 = aVar3.f5732a;
            boolean zM3211y = m3211y(playbackInfo, bVar);
            long j7 = (playbackInfo.f7948c.m2593a() || zM3211y) ? playbackInfo.f7949d : playbackInfo.f7965t;
            if (gVar2 != null) {
                Object obj5 = obj4;
                Pair<Object, Long> pairM3207M = m3207M(timeline, gVar2, true, i5, z15, cVar, bVar);
                if (pairM3207M == null) {
                    iMo2582a3 = timeline.mo2582a(z15);
                    j6 = j7;
                    z11 = false;
                    z10 = false;
                    z9 = true;
                } else {
                    if (gVar2.f7116c == -9223372036854775807L) {
                        i4 = timeline.mo3327h(pairM3207M.first, bVar).f7340l;
                        jLongValue = j7;
                        obj3 = obj5;
                        z8 = false;
                    } else {
                        Object obj6 = pairM3207M.first;
                        jLongValue = ((Long) pairM3207M.second).longValue();
                        obj3 = obj6;
                        z8 = true;
                        i4 = -1;
                    }
                    obj5 = obj3;
                    iMo2582a3 = i4;
                    z9 = false;
                    long j8 = jLongValue;
                    z10 = playbackInfo.f7951f == 4;
                    z11 = z8;
                    j6 = j8;
                }
                z5 = z11;
                z3 = z10;
                j2 = j6;
                z4 = z9;
                aVar = aVar3;
                i2 = -1;
                i = iMo2582a3;
                obj2 = obj5;
            } else {
                if (playbackInfo.f7947b.m3331q()) {
                    iMo2582a = timeline.mo2582a(z15);
                    obj = obj4;
                } else if (timeline.mo2554b(obj4) == -1) {
                    obj = obj4;
                    Object objM3208N = m3208N(cVar, bVar, i5, z15, obj4, playbackInfo.f7947b, timeline);
                    if (objM3208N == null) {
                        iMo2582a2 = timeline.mo2582a(z15);
                        z6 = true;
                    } else {
                        iMo2582a2 = timeline.mo3327h(objM3208N, bVar).f7340l;
                        z6 = false;
                    }
                    z7 = z6;
                    aVar = aVar3;
                    i = iMo2582a2;
                    z4 = z7;
                    obj2 = obj;
                    j2 = j7;
                    i2 = -1;
                    z3 = false;
                    z5 = false;
                } else {
                    obj = obj4;
                    if (j7 == -9223372036854775807L) {
                        iMo2582a = timeline.mo3327h(obj, bVar).f7340l;
                    } else if (zM3211y) {
                        aVar = aVar3;
                        playbackInfo.f7947b.mo3327h(aVar.f5732a, bVar);
                        if (playbackInfo.f7947b.m3330n(bVar.f7340l, cVar).f7350B == playbackInfo.f7947b.mo2554b(aVar.f5732a)) {
                            Pair<Object, Long> pairM3328j = timeline.m3328j(cVar, bVar, timeline.mo3327h(obj, bVar).f7340l, j7 + bVar.f7342n);
                            Object obj7 = pairM3328j.first;
                            long jLongValue2 = ((Long) pairM3328j.second).longValue();
                            obj2 = obj7;
                            j = jLongValue2;
                        } else {
                            obj2 = obj;
                            j = j7;
                        }
                        j2 = j;
                        i = -1;
                        i2 = -1;
                        z3 = false;
                        z4 = false;
                        z5 = true;
                    } else {
                        aVar = aVar3;
                        iMo2582a = -1;
                        iMo2582a2 = iMo2582a;
                        z7 = false;
                        i = iMo2582a2;
                        z4 = z7;
                        obj2 = obj;
                        j2 = j7;
                        i2 = -1;
                        z3 = false;
                        z5 = false;
                    }
                }
                aVar = aVar3;
                iMo2582a2 = iMo2582a;
                z7 = false;
                i = iMo2582a2;
                z4 = z7;
                obj2 = obj;
                j2 = j7;
                i2 = -1;
                z3 = false;
                z5 = false;
            }
            if (i != i2) {
                Pair<Object, Long> pairM3328j2 = timeline.m3328j(cVar, bVar, i, -9223372036854775807L);
                Object obj8 = pairM3328j2.first;
                long jLongValue3 = ((Long) pairM3328j2.second).longValue();
                obj2 = obj8;
                j2 = jLongValue3;
                j3 = -9223372036854775807L;
            } else {
                j3 = j2;
            }
            MediaSource2.a aVarM3379o = mediaPeriodQueue.m3379o(timeline, obj2, j2);
            boolean z16 = aVarM3379o.f5736e == -1 || ((i3 = aVar.f5736e) != -1 && aVarM3379o.f5733b >= i3);
            boolean zEquals = aVar.f5732a.equals(obj2);
            boolean z17 = zEquals && !aVar.m2593a() && !aVarM3379o.m2593a() && z16;
            timeline.mo3327h(obj2, bVar);
            boolean z18 = zEquals && !zM3211y && j7 == j3 && ((aVarM3379o.m2593a() && bVar.m3336e(aVarM3379o.f5733b)) || (aVar.m2593a() && bVar.m3336e(aVar.f5733b)));
            if (z17 || z18) {
                aVarM3379o = aVar;
            }
            if (aVarM3379o.m2593a()) {
                if (aVarM3379o.equals(aVar)) {
                    j5 = playbackInfo.f7965t;
                } else {
                    timeline.mo3327h(aVarM3379o.f5732a, bVar);
                    j5 = aVarM3379o.f5734c == bVar.m3335d(aVarM3379o.f5733b) ? bVar.f7344p.f5685o : 0L;
                }
                j4 = j5;
            } else {
                j4 = j2;
            }
            fVar = new f(aVarM3379o, j4, j3, z3, z4, z5);
        }
        f fVar2 = fVar;
        MediaSource2.a aVar4 = fVar2.f7108a;
        long j9 = fVar2.f7110c;
        boolean z19 = fVar2.f7111d;
        long jM3226R = fVar2.f7109b;
        boolean z20 = (this.f7058G.f7948c.equals(aVar4) && jM3226R == this.f7058G.f7965t) ? false : true;
        try {
            if (fVar2.f7112e) {
                if (this.f7058G.f7951f != 1) {
                    m3244f0(4);
                }
                m3219H(false, false, false, true);
            }
            try {
                if (z20) {
                    z13 = false;
                    z14 = true;
                    if (!timeline.m3331q()) {
                        for (MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.f7453l) {
                            if (mediaPeriodHolder.f7447f.f7465a.equals(aVar4)) {
                                mediaPeriodHolder.f7447f = this.f7053B.m3372h(timeline, mediaPeriodHolder.f7447f);
                                mediaPeriodHolder.m3356j();
                            }
                        }
                        jM3226R = m3226R(aVar4, jM3226R, z19);
                    }
                } else {
                    try {
                        z13 = false;
                        z14 = true;
                        if (!this.f7053B.m3381r(timeline, this.f7072U, m3252k())) {
                            m3224P(false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z12 = true;
                        gVar = null;
                        PlaybackInfo playbackInfo2 = this.f7058G;
                        g gVar3 = gVar;
                        m3257m0(timeline, aVar4, playbackInfo2.f7947b, playbackInfo2.f7948c, fVar2.f7113f ? jM3226R : -9223372036854775807L);
                        if (z20 || j9 != this.f7058G.f7949d) {
                            PlaybackInfo playbackInfo3 = this.f7058G;
                            Object obj9 = playbackInfo3.f7948c.f5732a;
                            Timeline timeline2 = playbackInfo3.f7947b;
                            if (!z20 || !z2 || timeline2.m3331q() || timeline2.mo3327h(obj9, this.f7087u).f7343o) {
                                z12 = false;
                            }
                            this.f7058G = m3266u(aVar4, jM3226R, j9, this.f7058G.f7950e, z12, timeline.mo2554b(obj9) == -1 ? 4 : 3);
                        }
                        m3220I();
                        m3222L(timeline, this.f7058G.f7947b);
                        this.f7058G = this.f7058G.m3568g(timeline);
                        if (!timeline.m3331q()) {
                            this.f7071T = gVar3;
                        }
                        m3262q(false);
                        throw th;
                    }
                }
                PlaybackInfo playbackInfo4 = this.f7058G;
                m3257m0(timeline, aVar4, playbackInfo4.f7947b, playbackInfo4.f7948c, fVar2.f7113f ? jM3226R : -9223372036854775807L);
                if (z20 || j9 != this.f7058G.f7949d) {
                    PlaybackInfo playbackInfo5 = this.f7058G;
                    Object obj10 = playbackInfo5.f7948c.f5732a;
                    Timeline timeline3 = playbackInfo5.f7947b;
                    if (!z20 || !z2 || timeline3.m3331q() || timeline3.mo3327h(obj10, this.f7087u).f7343o) {
                        z14 = false;
                    }
                    this.f7058G = m3266u(aVar4, jM3226R, j9, this.f7058G.f7950e, z14, timeline.mo2554b(obj10) == -1 ? 4 : 3);
                }
                m3220I();
                m3222L(timeline, this.f7058G.f7947b);
                this.f7058G = this.f7058G.m3568g(timeline);
                if (!timeline.m3331q()) {
                    this.f7071T = null;
                }
                m3262q(z13);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            gVar = null;
            z12 = true;
        }
    }

    /* renamed from: s */
    public final void m3264s(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7495j;
        if (mediaPeriodHolder != null && mediaPeriodHolder.f7442a == mediaPeriod) {
            float f2 = this.f7090x.mo2416c().f8027k;
            Timeline timeline = this.f7058G.f7947b;
            mediaPeriodHolder.f7445d = true;
            mediaPeriodHolder.f7454m = mediaPeriodHolder.f7442a.mo2490n();
            TrackSelectorResult trackSelectorResultM3355i = mediaPeriodHolder.m3355i(f2, timeline);
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f7447f;
            long jMax = mediaPeriodInfo.f7466b;
            long j = mediaPeriodInfo.f7469e;
            if (j != -9223372036854775807L && jMax >= j) {
                jMax = Math.max(0L, j - 1);
            }
            long jM3347a = mediaPeriodHolder.m3347a(trackSelectorResultM3355i, jMax, false, new boolean[mediaPeriodHolder.f7450i.length]);
            long j2 = mediaPeriodHolder.f7456o;
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.f7447f;
            mediaPeriodHolder.f7456o = (mediaPeriodInfo2.f7466b - jM3347a) + j2;
            mediaPeriodHolder.f7447f = mediaPeriodInfo2.m3361b(jM3347a);
            this.f7081o.mo3312d(this.f7076j, mediaPeriodHolder.f7454m, mediaPeriodHolder.f7455n.f6328c);
            if (mediaPeriodHolder == this.f7053B.f7493h) {
                m3221J(mediaPeriodHolder.f7447f.f7466b);
                m3245g();
                PlaybackInfo playbackInfo = this.f7058G;
                MediaSource2.a aVar = playbackInfo.f7948c;
                long j3 = mediaPeriodHolder.f7447f.f7466b;
                this.f7058G = m3266u(aVar, j3, playbackInfo.f7949d, j3, false, 5);
            }
            m3269z();
        }
    }

    /* renamed from: t */
    public final void m3265t(PlaybackParameters playbackParameters, float f2, boolean z2, boolean z3) throws ExoPlaybackException {
        int i;
        ExoPlayerImplInternal2 exoPlayerImplInternal2 = this;
        if (z2) {
            if (z3) {
                exoPlayerImplInternal2.f7059H.m3271a(1);
            }
            PlaybackInfo playbackInfo = exoPlayerImplInternal2.f7058G;
            exoPlayerImplInternal2 = this;
            exoPlayerImplInternal2.f7058G = new PlaybackInfo(playbackInfo.f7947b, playbackInfo.f7948c, playbackInfo.f7949d, playbackInfo.f7950e, playbackInfo.f7951f, playbackInfo.f7952g, playbackInfo.f7953h, playbackInfo.f7954i, playbackInfo.f7955j, playbackInfo.f7956k, playbackInfo.f7957l, playbackInfo.f7958m, playbackInfo.f7959n, playbackParameters, playbackInfo.f7963r, playbackInfo.f7964s, playbackInfo.f7965t, playbackInfo.f7961p, playbackInfo.f7962q);
        }
        float f3 = playbackParameters.f8027k;
        MediaPeriodHolder mediaPeriodHolder = exoPlayerImplInternal2.f7053B.f7493h;
        while (true) {
            i = 0;
            if (mediaPeriodHolder == null) {
                break;
            }
            ExoTrackSelection2[] exoTrackSelection2Arr = mediaPeriodHolder.f7455n.f6328c;
            int length = exoTrackSelection2Arr.length;
            while (i < length) {
                ExoTrackSelection2 exoTrackSelection2 = exoTrackSelection2Arr[i];
                if (exoTrackSelection2 != null) {
                    exoTrackSelection2.mo2726i(f3);
                }
                i++;
            }
            mediaPeriodHolder = mediaPeriodHolder.f7453l;
        }
        Renderer2[] renderer2Arr = exoPlayerImplInternal2.f7076j;
        int length2 = renderer2Arr.length;
        while (i < length2) {
            Renderer2 renderer2 = renderer2Arr[i];
            if (renderer2 != null) {
                renderer2.mo2939n(f2, playbackParameters.f8027k);
            }
            i++;
        }
    }

    @CheckResult
    /* renamed from: u */
    public final PlaybackInfo m3266u(MediaSource2.a aVar, long j, long j2, long j3, boolean z2, int i) {
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List<Metadata> list;
        ImmutableList2<Object> immutableList2M6262l;
        TrackGroupArray trackGroupArray2;
        int i2 = 0;
        this.f7074W = (!this.f7074W && j == this.f7058G.f7965t && aVar.equals(this.f7058G.f7948c)) ? false : true;
        m3220I();
        PlaybackInfo playbackInfo = this.f7058G;
        TrackGroupArray trackGroupArray3 = playbackInfo.f7954i;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.f7955j;
        List<Metadata> list2 = playbackInfo.f7956k;
        if (this.f7054C.f7873j) {
            MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h;
            TrackGroupArray trackGroupArray4 = mediaPeriodHolder == null ? TrackGroupArray.f5674j : mediaPeriodHolder.f7454m;
            TrackSelectorResult trackSelectorResult3 = mediaPeriodHolder == null ? this.f7080n : mediaPeriodHolder.f7455n;
            ExoTrackSelection2[] exoTrackSelection2Arr = trackSelectorResult3.f6328c;
            C3404f.m4189A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int length = exoTrackSelection2Arr.length;
            int i3 = 0;
            boolean z3 = false;
            int i4 = 0;
            while (i3 < length) {
                ExoTrackSelection2 exoTrackSelection2 = exoTrackSelection2Arr[i3];
                if (exoTrackSelection2 != null) {
                    Metadata metadata = exoTrackSelection2.mo2729d(i2).f7153u;
                    if (metadata == null) {
                        trackGroupArray2 = trackGroupArray4;
                        Metadata metadata2 = new Metadata(new Metadata.Entry[i2]);
                        int i5 = i4 + 1;
                        if (objArrCopyOf.length < i5) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.m6260a(objArrCopyOf.length, i5));
                        }
                        objArrCopyOf[i4] = metadata2;
                        i4 = i5;
                    } else {
                        trackGroupArray2 = trackGroupArray4;
                        int i6 = i4 + 1;
                        if (objArrCopyOf.length < i6) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.m6260a(objArrCopyOf.length, i6));
                        }
                        objArrCopyOf[i4] = metadata;
                        i4 = i6;
                        z3 = true;
                    }
                } else {
                    trackGroupArray2 = trackGroupArray4;
                }
                i3++;
                trackGroupArray4 = trackGroupArray2;
                i2 = 0;
            }
            TrackGroupArray trackGroupArray5 = trackGroupArray4;
            if (z3) {
                immutableList2M6262l = ImmutableList2.m6262l(objArrCopyOf, i4);
            } else {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
                immutableList2M6262l = RegularImmutableList.f12012l;
            }
            if (mediaPeriodHolder != null) {
                MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f7447f;
                if (mediaPeriodInfo.f7467c != j2) {
                    mediaPeriodHolder.f7447f = mediaPeriodInfo.m3360a(j2);
                }
            }
            list = immutableList2M6262l;
            trackSelectorResult = trackSelectorResult3;
            trackGroupArray = trackGroupArray5;
        } else if (aVar.equals(playbackInfo.f7948c)) {
            trackGroupArray = trackGroupArray3;
            trackSelectorResult = trackSelectorResult2;
            list = list2;
        } else {
            TrackGroupArray trackGroupArray6 = TrackGroupArray.f5674j;
            TrackSelectorResult trackSelectorResult4 = this.f7080n;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator2 = ImmutableList2.f12045k;
            trackGroupArray = trackGroupArray6;
            trackSelectorResult = trackSelectorResult4;
            list = RegularImmutableList.f12012l;
        }
        if (z2) {
            d dVar = this.f7059H;
            if (!dVar.f7104d || dVar.f7105e == 5) {
                dVar.f7101a = true;
                dVar.f7104d = true;
                dVar.f7105e = i;
            } else {
                AnimatableValueParser.m531j(i == 5);
            }
        }
        return this.f7058G.m3563b(aVar, j, j2, j3, m3256m(), trackGroupArray, trackSelectorResult, list);
    }

    /* renamed from: v */
    public final boolean m3267v() {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7495j;
        if (mediaPeriodHolder == null) {
            return false;
        }
        return (!mediaPeriodHolder.f7445d ? 0L : mediaPeriodHolder.f7442a.mo2479c()) != Long.MIN_VALUE;
    }

    /* renamed from: x */
    public final boolean m3268x() {
        MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7493h;
        long j = mediaPeriodHolder.f7447f.f7469e;
        return mediaPeriodHolder.f7445d && (j == -9223372036854775807L || this.f7058G.f7965t < j || !m3246g0());
    }

    /* renamed from: z */
    public final void m3269z() {
        long j;
        long j2;
        boolean zMo3315g;
        if (m3267v()) {
            MediaPeriodHolder mediaPeriodHolder = this.f7053B.f7495j;
            long jM3258n = m3258n(!mediaPeriodHolder.f7445d ? 0L : mediaPeriodHolder.f7442a.mo2479c());
            if (mediaPeriodHolder == this.f7053B.f7493h) {
                j = this.f7072U;
                j2 = mediaPeriodHolder.f7456o;
            } else {
                j = this.f7072U - mediaPeriodHolder.f7456o;
                j2 = mediaPeriodHolder.f7447f.f7466b;
            }
            zMo3315g = this.f7081o.mo3315g(j - j2, jM3258n, this.f7090x.mo2416c().f8027k);
        } else {
            zMo3315g = false;
        }
        this.f7064M = zMo3315g;
        if (zMo3315g) {
            MediaPeriodHolder mediaPeriodHolder2 = this.f7053B.f7495j;
            long j3 = this.f7072U;
            AnimatableValueParser.m426D(mediaPeriodHolder2.m3353g());
            mediaPeriodHolder2.f7442a.mo2483g(j3 - mediaPeriodHolder2.f7456o);
        }
        m3255l0();
    }
}
