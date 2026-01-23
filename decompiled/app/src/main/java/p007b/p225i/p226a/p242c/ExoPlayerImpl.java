package p007b.p225i.p226a.p242c;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.util.SparseBooleanArray;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArraySet;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.ExoPlayer2;
import p007b.p225i.p226a.p242c.ExoPlayerImplInternal2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.PlayerMessage;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.MediaSourceFactory;
import p007b.p225i.p226a.p242c.p243a3.ShuffleOrder;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p255c3.DefaultTrackSelector;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p255c3.TrackSelector;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectorResult;
import p007b.p225i.p226a.p242c.p257e3.BandwidthMeter;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p226a.p242c.p259f3.FlagSet;
import p007b.p225i.p226a.p242c.p259f3.HandlerWrapper;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p259f3.SystemHandlerWrapper;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;
import p007b.p225i.p226a.p242c.p262s2.C2869h;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;

/* JADX INFO: renamed from: b.i.a.c.f1, reason: use source file name */
/* JADX INFO: compiled from: ExoPlayerImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExoPlayerImpl extends BasePlayer {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ int f6651b = 0;

    /* JADX INFO: renamed from: A */
    public int f6652A;

    /* JADX INFO: renamed from: B */
    public ShuffleOrder f6653B;

    /* JADX INFO: renamed from: C */
    public Player2.b f6654C;

    /* JADX INFO: renamed from: D */
    public MediaMetadata f6655D;

    /* JADX INFO: renamed from: E */
    public MediaMetadata f6656E;

    /* JADX INFO: renamed from: F */
    public PlaybackInfo f6657F;

    /* JADX INFO: renamed from: G */
    public int f6658G;

    /* JADX INFO: renamed from: H */
    public long f6659H;

    /* JADX INFO: renamed from: c */
    public final TrackSelectorResult f6660c;

    /* JADX INFO: renamed from: d */
    public final Player2.b f6661d;

    /* JADX INFO: renamed from: e */
    public final Renderer2[] f6662e;

    /* JADX INFO: renamed from: f */
    public final TrackSelector f6663f;

    /* JADX INFO: renamed from: g */
    public final HandlerWrapper f6664g;

    /* JADX INFO: renamed from: h */
    public final ExoPlayerImplInternal2.e f6665h;

    /* JADX INFO: renamed from: i */
    public final ExoPlayerImplInternal2 f6666i;

    /* JADX INFO: renamed from: j */
    public final ListenerSet<Player2.c> f6667j;

    /* JADX INFO: renamed from: k */
    public final CopyOnWriteArraySet<ExoPlayer2.a> f6668k;

    /* JADX INFO: renamed from: l */
    public final Timeline.b f6669l;

    /* JADX INFO: renamed from: m */
    public final List<a> f6670m;

    /* JADX INFO: renamed from: n */
    public final boolean f6671n;

    /* JADX INFO: renamed from: o */
    public final MediaSourceFactory f6672o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public final AnalyticsCollector f6673p;

    /* JADX INFO: renamed from: q */
    public final Looper f6674q;

    /* JADX INFO: renamed from: r */
    public final BandwidthMeter f6675r;

    /* JADX INFO: renamed from: s */
    public final long f6676s;

    /* JADX INFO: renamed from: t */
    public final long f6677t;

    /* JADX INFO: renamed from: u */
    public final Clock4 f6678u;

    /* JADX INFO: renamed from: v */
    public int f6679v;

    /* JADX INFO: renamed from: w */
    public boolean f6680w;

    /* JADX INFO: renamed from: x */
    public int f6681x;

    /* JADX INFO: renamed from: y */
    public int f6682y;

    /* JADX INFO: renamed from: z */
    public boolean f6683z;

    /* JADX INFO: renamed from: b.i.a.c.f1$a */
    /* JADX INFO: compiled from: ExoPlayerImpl.java */
    public static final class a implements MediaSourceInfoHolder {

        /* JADX INFO: renamed from: a */
        public final Object f6684a;

        /* JADX INFO: renamed from: b */
        public Timeline f6685b;

        public a(Object obj, Timeline timeline) {
            this.f6684a = obj;
            this.f6685b = timeline;
        }

        @Override // p007b.p225i.p226a.p242c.MediaSourceInfoHolder
        /* JADX INFO: renamed from: a */
        public Timeline mo2931a() {
            return this.f6685b;
        }

        @Override // p007b.p225i.p226a.p242c.MediaSourceInfoHolder
        public Object getUid() {
            return this.f6684a;
        }
    }

    static {
        ExoPlayerLibraryInfo.m3272a("goog.exo.exoplayer");
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer2[] renderer2Arr, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, @Nullable AnalyticsCollector analyticsCollector, boolean z2, SeekParameters seekParameters, long j, long j2, LivePlaybackSpeedControl livePlaybackSpeedControl, long j3, boolean z3, Clock4 clock4, Looper looper, @Nullable Player2 player2, Player2.b bVar) {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = Util2.f6712e;
        StringBuilder sbM831S = outline.m831S(outline.m841b(str, outline.m841b(hexString, 30)), "Init ", hexString, " [", "ExoPlayerLib/2.16.0");
        sbM831S.append("] [");
        sbM831S.append(str);
        sbM831S.append("]");
        Log.i("ExoPlayerImpl", sbM831S.toString());
        AnimatableValueParser.m426D(renderer2Arr.length > 0);
        this.f6662e = renderer2Arr;
        Objects.requireNonNull(trackSelector);
        this.f6663f = trackSelector;
        this.f6672o = mediaSourceFactory;
        this.f6675r = bandwidthMeter;
        this.f6673p = analyticsCollector;
        this.f6671n = z2;
        this.f6676s = j;
        this.f6677t = j2;
        this.f6674q = looper;
        this.f6678u = clock4;
        this.f6679v = 0;
        this.f6667j = new ListenerSet<>(new CopyOnWriteArraySet(), looper, clock4, new C2943u(player2));
        this.f6668k = new CopyOnWriteArraySet<>();
        this.f6670m = new ArrayList();
        this.f6653B = new ShuffleOrder.a(0, new Random());
        this.f6660c = new TrackSelectorResult(new RendererConfiguration[renderer2Arr.length], new ExoTrackSelection2[renderer2Arr.length], TracksInfo.f7433j, null);
        this.f6669l = new Timeline.b();
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 20, 30};
        for (int i = 0; i < 12; i++) {
            int i2 = iArr[i];
            AnimatableValueParser.m426D(!false);
            sparseBooleanArray.append(i2, true);
        }
        if (trackSelector instanceof DefaultTrackSelector) {
            AnimatableValueParser.m426D(!false);
            sparseBooleanArray.append(29, true);
        }
        FlagSet flagSet = bVar.f9033k;
        for (int i3 = 0; i3 < flagSet.m3031c(); i3++) {
            int iM3030b = flagSet.m3030b(i3);
            AnimatableValueParser.m426D(true);
            sparseBooleanArray.append(iM3030b, true);
        }
        AnimatableValueParser.m426D(true);
        FlagSet flagSet2 = new FlagSet(sparseBooleanArray, null);
        this.f6661d = new Player2.b(flagSet2, null);
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
        for (int i4 = 0; i4 < flagSet2.m3031c(); i4++) {
            int iM3030b2 = flagSet2.m3030b(i4);
            AnimatableValueParser.m426D(true);
            sparseBooleanArray2.append(iM3030b2, true);
        }
        AnimatableValueParser.m426D(true);
        sparseBooleanArray2.append(4, true);
        AnimatableValueParser.m426D(true);
        sparseBooleanArray2.append(10, true);
        AnimatableValueParser.m426D(true);
        this.f6654C = new Player2.b(new FlagSet(sparseBooleanArray2, null), null);
        MediaMetadata mediaMetadata = MediaMetadata.f7368j;
        this.f6655D = mediaMetadata;
        this.f6656E = mediaMetadata;
        this.f6658G = -1;
        this.f6664g = clock4.mo2950b(looper, null);
        C2962w c2962w = new C2962w(this);
        this.f6665h = c2962w;
        this.f6657F = PlaybackInfo.m3561h(this.f6660c);
        if (analyticsCollector != null) {
            AnimatableValueParser.m426D(analyticsCollector.f7553p == null || analyticsCollector.f7550m.f7557b.isEmpty());
            analyticsCollector.f7553p = player2;
            analyticsCollector.f7554q = analyticsCollector.f7547j.mo2950b(looper, null);
            ListenerSet<AnalyticsListener> listenerSet = analyticsCollector.f7552o;
            analyticsCollector.f7552o = new ListenerSet<>(listenerSet.f6739d, looper, listenerSet.f6736a, new C2869h(analyticsCollector, player2));
            m2898d0(analyticsCollector);
            bandwidthMeter.mo2846f(new Handler(looper), analyticsCollector);
        }
        this.f6666i = new ExoPlayerImplInternal2(renderer2Arr, trackSelector, this.f6660c, loadControl, bandwidthMeter, this.f6679v, this.f6680w, analyticsCollector, seekParameters, livePlaybackSpeedControl, j3, z3, looper, clock4, c2962w);
    }

    /* JADX INFO: renamed from: j0 */
    public static long m2877j0(PlaybackInfo playbackInfo) {
        Timeline.c cVar = new Timeline.c();
        Timeline.b bVar = new Timeline.b();
        playbackInfo.f7947b.mo3327h(playbackInfo.f7948c.f5732a, bVar);
        long j = playbackInfo.f7949d;
        return j == -9223372036854775807L ? playbackInfo.f7947b.m3330n(bVar.f7340l, cVar).f7365z : bVar.f7342n + j;
    }

    /* JADX INFO: renamed from: k0 */
    public static boolean m2878k0(PlaybackInfo playbackInfo) {
        return playbackInfo.f7951f == 3 && playbackInfo.f7958m && playbackInfo.f7959n == 0;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: A */
    public List mo2879A() {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
        return RegularImmutableList.f12012l;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: B */
    public int mo2880B() {
        if (mo2900f()) {
            return this.f6657F.f7948c.f5733b;
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: C */
    public int mo2881C() {
        int iM2905h0 = m2905h0();
        if (iM2905h0 == -1) {
            return 0;
        }
        return iM2905h0;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: E */
    public void mo2882E(int i) {
        if (this.f6679v != i) {
            this.f6679v = i;
            ((SystemHandlerWrapper.b) this.f6666i.f7083q.mo2954a(11, i, 0)).m2965b();
            this.f6667j.m3035b(8, new C2813k(i));
            m2923r0();
            this.f6667j.m3034a();
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: F */
    public void mo2883F(@Nullable SurfaceView surfaceView) {
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: G */
    public int mo2884G() {
        return this.f6657F.f7959n;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: H */
    public TracksInfo mo2885H() {
        return this.f6657F.f7955j.f6329d;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: I */
    public int mo2886I() {
        return this.f6679v;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: J */
    public long mo2887J() {
        if (mo2900f()) {
            PlaybackInfo playbackInfo = this.f6657F;
            MediaSource2.a aVar = playbackInfo.f7948c;
            playbackInfo.f7947b.mo3327h(aVar.f5732a, this.f6669l);
            return Util2.m2992M(this.f6669l.m3332a(aVar.f5733b, aVar.f5734c));
        }
        Timeline timelineMo2888K = mo2888K();
        if (timelineMo2888K.m3331q()) {
            return -9223372036854775807L;
        }
        return timelineMo2888K.m3330n(mo2881C(), this.f7863a).m3340b();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: K */
    public Timeline mo2888K() {
        return this.f6657F.f7947b;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: L */
    public Looper mo2889L() {
        return this.f6674q;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: M */
    public boolean mo2890M() {
        return this.f6680w;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: N */
    public long mo2891N() {
        if (this.f6657F.f7947b.m3331q()) {
            return this.f6659H;
        }
        PlaybackInfo playbackInfo = this.f6657F;
        if (playbackInfo.f7957l.f5735d != playbackInfo.f7948c.f5735d) {
            return playbackInfo.f7947b.m3330n(mo2881C(), this.f7863a).m3340b();
        }
        long j = playbackInfo.f7963r;
        if (this.f6657F.f7957l.m2593a()) {
            PlaybackInfo playbackInfo2 = this.f6657F;
            Timeline.b bVarMo3327h = playbackInfo2.f7947b.mo3327h(playbackInfo2.f7957l.f5732a, this.f6669l);
            long jM3334c = bVarMo3327h.m3334c(this.f6657F.f7957l.f5733b);
            j = jM3334c == Long.MIN_VALUE ? bVarMo3327h.f7341m : jM3334c;
        }
        PlaybackInfo playbackInfo3 = this.f6657F;
        return Util2.m2992M(m2913m0(playbackInfo3.f7947b, playbackInfo3.f7957l, j));
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: Q */
    public void mo2892Q(@Nullable TextureView textureView) {
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: S */
    public MediaMetadata mo2893S() {
        return this.f6655D;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: T */
    public long mo2894T() {
        return Util2.m2992M(m2903g0(this.f6657F));
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: U */
    public long mo2895U() {
        return this.f6676s;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: a */
    public void mo2896a() {
        PlaybackInfo playbackInfo = this.f6657F;
        if (playbackInfo.f7951f != 1) {
            return;
        }
        PlaybackInfo playbackInfoM3566e = playbackInfo.m3566e(null);
        PlaybackInfo playbackInfoM3567f = playbackInfoM3566e.m3567f(playbackInfoM3566e.f7947b.m3331q() ? 4 : 2);
        this.f6681x++;
        ((SystemHandlerWrapper.b) this.f6666i.f7083q.mo2956c(0)).m2965b();
        m2924s0(playbackInfoM3567f, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: c */
    public PlaybackParameters mo2897c() {
        return this.f6657F.f7960o;
    }

    /* JADX INFO: renamed from: d0 */
    public void m2898d0(Player2.c cVar) {
        ListenerSet<Player2.c> listenerSet = this.f6667j;
        if (listenerSet.f6742g) {
            return;
        }
        Objects.requireNonNull(cVar);
        listenerSet.f6739d.add(new ListenerSet.c<>(cVar));
    }

    /* JADX INFO: renamed from: e0 */
    public final MediaMetadata m2899e0() {
        Timeline timelineMo2888K = mo2888K();
        MediaItem2 mediaItem2 = timelineMo2888K.m3331q() ? null : timelineMo2888K.m3330n(mo2881C(), this.f7863a).f7355p;
        if (mediaItem2 == null) {
            return this.f6656E;
        }
        MediaMetadata.b bVarM3344a = this.f6656E.m3344a();
        MediaMetadata mediaMetadata = mediaItem2.f7265n;
        if (mediaMetadata != null) {
            CharSequence charSequence = mediaMetadata.f7387l;
            if (charSequence != null) {
                bVarM3344a.f7407a = charSequence;
            }
            CharSequence charSequence2 = mediaMetadata.f7388m;
            if (charSequence2 != null) {
                bVarM3344a.f7408b = charSequence2;
            }
            CharSequence charSequence3 = mediaMetadata.f7389n;
            if (charSequence3 != null) {
                bVarM3344a.f7409c = charSequence3;
            }
            CharSequence charSequence4 = mediaMetadata.f7390o;
            if (charSequence4 != null) {
                bVarM3344a.f7410d = charSequence4;
            }
            CharSequence charSequence5 = mediaMetadata.f7391p;
            if (charSequence5 != null) {
                bVarM3344a.f7411e = charSequence5;
            }
            CharSequence charSequence6 = mediaMetadata.f7392q;
            if (charSequence6 != null) {
                bVarM3344a.f7412f = charSequence6;
            }
            CharSequence charSequence7 = mediaMetadata.f7393r;
            if (charSequence7 != null) {
                bVarM3344a.f7413g = charSequence7;
            }
            Uri uri = mediaMetadata.f7394s;
            if (uri != null) {
                bVarM3344a.f7414h = uri;
            }
            Rating rating = mediaMetadata.f7395t;
            if (rating != null) {
                bVarM3344a.f7415i = rating;
            }
            Rating rating2 = mediaMetadata.f7396u;
            if (rating2 != null) {
                bVarM3344a.f7416j = rating2;
            }
            byte[] bArr = mediaMetadata.f7397v;
            if (bArr != null) {
                Integer num = mediaMetadata.f7398w;
                bVarM3344a.f7417k = (byte[]) bArr.clone();
                bVarM3344a.f7418l = num;
            }
            Uri uri2 = mediaMetadata.f7399x;
            if (uri2 != null) {
                bVarM3344a.f7419m = uri2;
            }
            Integer num2 = mediaMetadata.f7400y;
            if (num2 != null) {
                bVarM3344a.f7420n = num2;
            }
            Integer num3 = mediaMetadata.f7401z;
            if (num3 != null) {
                bVarM3344a.f7421o = num3;
            }
            Integer num4 = mediaMetadata.f7370A;
            if (num4 != null) {
                bVarM3344a.f7422p = num4;
            }
            Boolean bool = mediaMetadata.f7371B;
            if (bool != null) {
                bVarM3344a.f7423q = bool;
            }
            Integer num5 = mediaMetadata.f7372C;
            if (num5 != null) {
                bVarM3344a.f7424r = num5;
            }
            Integer num6 = mediaMetadata.f7373D;
            if (num6 != null) {
                bVarM3344a.f7424r = num6;
            }
            Integer num7 = mediaMetadata.f7374E;
            if (num7 != null) {
                bVarM3344a.f7425s = num7;
            }
            Integer num8 = mediaMetadata.f7375F;
            if (num8 != null) {
                bVarM3344a.f7426t = num8;
            }
            Integer num9 = mediaMetadata.f7376G;
            if (num9 != null) {
                bVarM3344a.f7427u = num9;
            }
            Integer num10 = mediaMetadata.f7377H;
            if (num10 != null) {
                bVarM3344a.f7428v = num10;
            }
            Integer num11 = mediaMetadata.f7378I;
            if (num11 != null) {
                bVarM3344a.f7429w = num11;
            }
            CharSequence charSequence8 = mediaMetadata.f7379J;
            if (charSequence8 != null) {
                bVarM3344a.f7430x = charSequence8;
            }
            CharSequence charSequence9 = mediaMetadata.f7380K;
            if (charSequence9 != null) {
                bVarM3344a.f7431y = charSequence9;
            }
            CharSequence charSequence10 = mediaMetadata.f7381L;
            if (charSequence10 != null) {
                bVarM3344a.f7432z = charSequence10;
            }
            Integer num12 = mediaMetadata.f7382M;
            if (num12 != null) {
                bVarM3344a.f7402A = num12;
            }
            Integer num13 = mediaMetadata.f7383N;
            if (num13 != null) {
                bVarM3344a.f7403B = num13;
            }
            CharSequence charSequence11 = mediaMetadata.f7384O;
            if (charSequence11 != null) {
                bVarM3344a.f7404C = charSequence11;
            }
            CharSequence charSequence12 = mediaMetadata.f7385P;
            if (charSequence12 != null) {
                bVarM3344a.f7405D = charSequence12;
            }
            Bundle bundle = mediaMetadata.f7386Q;
            if (bundle != null) {
                bVarM3344a.f7406E = bundle;
            }
        }
        return bVarM3344a.m3345a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: f */
    public boolean mo2900f() {
        return this.f6657F.f7948c.m2593a();
    }

    /* JADX INFO: renamed from: f0 */
    public PlayerMessage m2901f0(PlayerMessage.b bVar) {
        return new PlayerMessage(this.f6666i, bVar, this.f6657F.f7947b, mo2881C(), this.f6678u, this.f6666i.f7085s);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: g */
    public long mo2902g() {
        return Util2.m2992M(this.f6657F.f7964s);
    }

    /* JADX INFO: renamed from: g0 */
    public final long m2903g0(PlaybackInfo playbackInfo) {
        return playbackInfo.f7947b.m3331q() ? Util2.m2981B(this.f6659H) : playbackInfo.f7948c.m2593a() ? playbackInfo.f7965t : m2913m0(playbackInfo.f7947b, playbackInfo.f7948c, playbackInfo.f7965t);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: h */
    public void mo2904h(int i, long j) {
        Timeline timeline = this.f6657F.f7947b;
        if (i < 0 || (!timeline.m3331q() && i >= timeline.mo2557p())) {
            throw new IllegalSeekPositionException(timeline, i, j);
        }
        this.f6681x++;
        if (mo2900f()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            ExoPlayerImplInternal2.d dVar = new ExoPlayerImplInternal2.d(this.f6657F);
            dVar.m3271a(1);
            ExoPlayerImpl exoPlayerImpl = ((C2962w) this.f6665h).f7945a;
            exoPlayerImpl.f6664g.mo2955b(new RunnableC2632c0(exoPlayerImpl, dVar));
            return;
        }
        int i2 = this.f6657F.f7951f != 1 ? 2 : 1;
        int iMo2881C = mo2881C();
        PlaybackInfo playbackInfoM2911l0 = m2911l0(this.f6657F.m3567f(i2), timeline, m2907i0(timeline, i, j));
        ((SystemHandlerWrapper.b) this.f6666i.f7083q.mo2962i(3, new ExoPlayerImplInternal2.g(timeline, i, Util2.m2981B(j)))).m2965b();
        m2924s0(playbackInfoM2911l0, 0, 1, true, true, 1, m2903g0(playbackInfoM2911l0), iMo2881C);
    }

    /* JADX INFO: renamed from: h0 */
    public final int m2905h0() {
        if (this.f6657F.f7947b.m3331q()) {
            return this.f6658G;
        }
        PlaybackInfo playbackInfo = this.f6657F;
        return playbackInfo.f7947b.mo3327h(playbackInfo.f7948c.f5732a, this.f6669l).f7340l;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: i */
    public Player2.b mo2906i() {
        return this.f6654C;
    }

    @Nullable
    /* JADX INFO: renamed from: i0 */
    public final Pair<Object, Long> m2907i0(Timeline timeline, int i, long j) {
        if (timeline.m3331q()) {
            this.f6658G = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.f6659H = j;
            return null;
        }
        if (i == -1 || i >= timeline.mo2557p()) {
            i = timeline.mo2582a(this.f6680w);
            j = timeline.m3330n(i, this.f7863a).m3339a();
        }
        return timeline.m3328j(this.f7863a, this.f6669l, i, Util2.m2981B(j));
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: j */
    public boolean mo2908j() {
        return this.f6657F.f7958m;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: k */
    public void mo2909k(boolean z2) {
        if (this.f6680w != z2) {
            this.f6680w = z2;
            ((SystemHandlerWrapper.b) this.f6666i.f7083q.mo2954a(12, z2 ? 1 : 0, 0)).m2965b();
            this.f6667j.m3035b(9, new C2825n(z2));
            m2923r0();
            this.f6667j.m3034a();
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: l */
    public long mo2910l() {
        return 3000L;
    }

    /* JADX INFO: renamed from: l0 */
    public final PlaybackInfo m2911l0(PlaybackInfo playbackInfo, Timeline timeline, @Nullable Pair<Object, Long> pair) {
        MediaSource2.a aVar;
        TrackSelectorResult trackSelectorResult;
        List<Metadata> list;
        AnimatableValueParser.m531j(timeline.m3331q() || pair != null);
        Timeline timeline2 = playbackInfo.f7947b;
        PlaybackInfo playbackInfoM3568g = playbackInfo.m3568g(timeline);
        if (timeline.m3331q()) {
            MediaSource2.a aVar2 = PlaybackInfo.f7946a;
            MediaSource2.a aVar3 = PlaybackInfo.f7946a;
            long jM2981B = Util2.m2981B(this.f6659H);
            TrackGroupArray trackGroupArray = TrackGroupArray.f5674j;
            TrackSelectorResult trackSelectorResult2 = this.f6660c;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
            PlaybackInfo playbackInfoM3562a = playbackInfoM3568g.m3563b(aVar3, jM2981B, jM2981B, jM2981B, 0L, trackGroupArray, trackSelectorResult2, RegularImmutableList.f12012l).m3562a(aVar3);
            playbackInfoM3562a.f7963r = playbackInfoM3562a.f7965t;
            return playbackInfoM3562a;
        }
        Object obj = playbackInfoM3568g.f7948c.f5732a;
        int i = Util2.f6708a;
        boolean z2 = !obj.equals(pair.first);
        MediaSource2.a aVar4 = z2 ? new MediaSource2.a(pair.first) : playbackInfoM3568g.f7948c;
        long jLongValue = ((Long) pair.second).longValue();
        long jM2981B2 = Util2.m2981B(mo2928w());
        if (!timeline2.m3331q()) {
            jM2981B2 -= timeline2.mo3327h(obj, this.f6669l).f7342n;
        }
        if (z2 || jLongValue < jM2981B2) {
            AnimatableValueParser.m426D(!aVar4.m2593a());
            TrackGroupArray trackGroupArray2 = z2 ? TrackGroupArray.f5674j : playbackInfoM3568g.f7954i;
            if (z2) {
                aVar = aVar4;
                trackSelectorResult = this.f6660c;
            } else {
                aVar = aVar4;
                trackSelectorResult = playbackInfoM3568g.f7955j;
            }
            TrackSelectorResult trackSelectorResult3 = trackSelectorResult;
            if (z2) {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator2 = ImmutableList2.f12045k;
                list = RegularImmutableList.f12012l;
            } else {
                list = playbackInfoM3568g.f7956k;
            }
            PlaybackInfo playbackInfoM3562a2 = playbackInfoM3568g.m3563b(aVar, jLongValue, jLongValue, jLongValue, 0L, trackGroupArray2, trackSelectorResult3, list).m3562a(aVar);
            playbackInfoM3562a2.f7963r = jLongValue;
            return playbackInfoM3562a2;
        }
        if (jLongValue == jM2981B2) {
            int iMo2554b = timeline.mo2554b(playbackInfoM3568g.f7957l.f5732a);
            if (iMo2554b == -1 || timeline.m3326f(iMo2554b, this.f6669l).f7340l != timeline.mo3327h(aVar4.f5732a, this.f6669l).f7340l) {
                timeline.mo3327h(aVar4.f5732a, this.f6669l);
                long jM3332a = aVar4.m2593a() ? this.f6669l.m3332a(aVar4.f5733b, aVar4.f5734c) : this.f6669l.f7341m;
                playbackInfoM3568g = playbackInfoM3568g.m3563b(aVar4, playbackInfoM3568g.f7965t, playbackInfoM3568g.f7965t, playbackInfoM3568g.f7950e, jM3332a - playbackInfoM3568g.f7965t, playbackInfoM3568g.f7954i, playbackInfoM3568g.f7955j, playbackInfoM3568g.f7956k).m3562a(aVar4);
                playbackInfoM3568g.f7963r = jM3332a;
            }
        } else {
            AnimatableValueParser.m426D(!aVar4.m2593a());
            long jMax = Math.max(0L, playbackInfoM3568g.f7964s - (jLongValue - jM2981B2));
            long j = playbackInfoM3568g.f7963r;
            if (playbackInfoM3568g.f7957l.equals(playbackInfoM3568g.f7948c)) {
                j = jLongValue + jMax;
            }
            playbackInfoM3568g = playbackInfoM3568g.m3563b(aVar4, jLongValue, jLongValue, jLongValue, jMax, playbackInfoM3568g.f7954i, playbackInfoM3568g.f7955j, playbackInfoM3568g.f7956k);
            playbackInfoM3568g.f7963r = j;
        }
        return playbackInfoM3568g;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: m */
    public int mo2912m() {
        if (this.f6657F.f7947b.m3331q()) {
            return 0;
        }
        PlaybackInfo playbackInfo = this.f6657F;
        return playbackInfo.f7947b.mo2554b(playbackInfo.f7948c.f5732a);
    }

    /* JADX INFO: renamed from: m0 */
    public final long m2913m0(Timeline timeline, MediaSource2.a aVar, long j) {
        timeline.mo3327h(aVar.f5732a, this.f6669l);
        return j + this.f6669l.f7342n;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: n */
    public void mo2914n(@Nullable TextureView textureView) {
    }

    /* JADX INFO: renamed from: n0 */
    public void m2915n0() {
        String str;
        boolean z2;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str2 = Util2.f6712e;
        HashSet<String> hashSet = ExoPlayerLibraryInfo.f7121a;
        synchronized (ExoPlayerLibraryInfo.class) {
            str = ExoPlayerLibraryInfo.f7122b;
        }
        StringBuilder sbM831S = outline.m831S(outline.m841b(str, outline.m841b(str2, outline.m841b(hexString, 36))), "Release ", hexString, " [", "ExoPlayerLib/2.16.0");
        outline.m876s0(sbM831S, "] [", str2, "] [", str);
        sbM831S.append("]");
        Log.i("ExoPlayerImpl", sbM831S.toString());
        ExoPlayerImplInternal2 exoPlayerImplInternal2 = this.f6666i;
        synchronized (exoPlayerImplInternal2) {
            if (exoPlayerImplInternal2.f7060I || !exoPlayerImplInternal2.f7084r.isAlive()) {
                z2 = true;
            } else {
                exoPlayerImplInternal2.f7083q.mo2959f(7);
                long jMo2952d = exoPlayerImplInternal2.f7056E;
                synchronized (exoPlayerImplInternal2) {
                    long jMo2952d2 = exoPlayerImplInternal2.f7092z.mo2952d() + jMo2952d;
                    boolean z3 = false;
                    while (!Boolean.valueOf(exoPlayerImplInternal2.f7060I).booleanValue() && jMo2952d > 0) {
                        try {
                            exoPlayerImplInternal2.f7092z.mo2951c();
                            exoPlayerImplInternal2.wait(jMo2952d);
                        } catch (InterruptedException unused) {
                            z3 = true;
                        }
                        jMo2952d = jMo2952d2 - exoPlayerImplInternal2.f7092z.mo2952d();
                    }
                    if (z3) {
                        Thread.currentThread().interrupt();
                    }
                    z2 = exoPlayerImplInternal2.f7060I;
                }
            }
        }
        if (!z2) {
            ListenerSet<Player2.c> listenerSet = this.f6667j;
            listenerSet.m3035b(10, C2574b0.f5738a);
            listenerSet.m3034a();
        }
        this.f6667j.m3036c();
        this.f6664g.mo2963j(null);
        AnalyticsCollector analyticsCollector = this.f6673p;
        if (analyticsCollector != null) {
            this.f6675r.mo2845d(analyticsCollector);
        }
        PlaybackInfo playbackInfoM3567f = this.f6657F.m3567f(1);
        this.f6657F = playbackInfoM3567f;
        PlaybackInfo playbackInfoM3562a = playbackInfoM3567f.m3562a(playbackInfoM3567f.f7948c);
        this.f6657F = playbackInfoM3562a;
        playbackInfoM3562a.f7963r = playbackInfoM3562a.f7965t;
        this.f6657F.f7964s = 0L;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: o */
    public VideoSize mo2916o() {
        return VideoSize.f6954j;
    }

    /* JADX INFO: renamed from: o0 */
    public void m2917o0(Player2.c cVar) {
        ListenerSet<Player2.c> listenerSet = this.f6667j;
        for (ListenerSet.c<Player2.c> cVar2 : listenerSet.f6739d) {
            if (cVar2.f6743a.equals(cVar)) {
                ListenerSet.b<Player2.c> bVar = listenerSet.f6738c;
                cVar2.f6746d = true;
                if (cVar2.f6745c) {
                    bVar.mo3037a(cVar2.f6743a, cVar2.f6744b.m3033b());
                }
                listenerSet.f6739d.remove(cVar2);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: p */
    public void mo2918p(Player2.e eVar) {
        m2917o0(eVar);
    }

    /* JADX INFO: renamed from: p0 */
    public final void m2919p0(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            this.f6670m.remove(i3);
        }
        this.f6653B = this.f6653B.mo2543a(i, i2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: q */
    public int mo2920q() {
        if (mo2900f()) {
            return this.f6657F.f7948c.f5734c;
        }
        return -1;
    }

    /* JADX INFO: renamed from: q0 */
    public void m2921q0(boolean z2, int i, int i2) {
        PlaybackInfo playbackInfo = this.f6657F;
        if (playbackInfo.f7958m == z2 && playbackInfo.f7959n == i) {
            return;
        }
        this.f6681x++;
        PlaybackInfo playbackInfoM3565d = playbackInfo.m3565d(z2, i);
        ((SystemHandlerWrapper.b) this.f6666i.f7083q.mo2954a(1, z2 ? 1 : 0, i)).m2965b();
        m2924s0(playbackInfoM3565d, 0, i2, false, false, 5, -9223372036854775807L, -1);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: r */
    public void mo2922r(@Nullable SurfaceView surfaceView) {
    }

    /* JADX INFO: renamed from: r0 */
    public final void m2923r0() {
        Player2.b bVar = this.f6654C;
        Player2.b bVar2 = this.f6661d;
        Player2.b.a aVar = new Player2.b.a();
        aVar.m3826a(bVar2);
        aVar.m3827b(4, !mo2900f());
        aVar.m3827b(5, m3527a0() && !mo2900f());
        aVar.m3827b(6, m3524X() && !mo2900f());
        aVar.m3827b(7, !mo2888K().m3331q() && (m3524X() || !m3526Z() || m3527a0()) && !mo2900f());
        aVar.m3827b(8, m3523W() && !mo2900f());
        aVar.m3827b(9, !mo2888K().m3331q() && (m3523W() || (m3526Z() && m3525Y())) && !mo2900f());
        aVar.m3827b(10, !mo2900f());
        aVar.m3827b(11, m3527a0() && !mo2900f());
        aVar.m3827b(12, m3527a0() && !mo2900f());
        Player2.b bVarM3828c = aVar.m3828c();
        this.f6654C = bVarM3828c;
        if (bVarM3828c.equals(bVar)) {
            return;
        }
        this.f6667j.m3035b(13, new C2996x(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0260  */
    /* JADX INFO: renamed from: s0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2924s0(PlaybackInfo playbackInfo, int i, int i2, boolean z2, boolean z3, int i3, long j, int i4) {
        Pair pair;
        int i5;
        MediaItem2 mediaItem2;
        int i6;
        Object obj;
        MediaItem2 mediaItem22;
        Object obj2;
        int iMo2554b;
        long jM2877j0;
        long jM2877j02;
        Object obj3;
        MediaItem2 mediaItem23;
        Object obj4;
        int iMo2554b2;
        PlaybackInfo playbackInfo2 = this.f6657F;
        this.f6657F = playbackInfo;
        boolean z4 = !playbackInfo2.f7947b.equals(playbackInfo.f7947b);
        Timeline timeline = playbackInfo2.f7947b;
        Timeline timeline2 = playbackInfo.f7947b;
        if (timeline2.m3331q() && timeline.m3331q()) {
            pair = new Pair(Boolean.FALSE, -1);
        } else if (timeline2.m3331q() != timeline.m3331q()) {
            pair = new Pair(Boolean.TRUE, 3);
        } else if (timeline.m3330n(timeline.mo3327h(playbackInfo2.f7948c.f5732a, this.f6669l).f7340l, this.f7863a).f7353n.equals(timeline2.m3330n(timeline2.mo3327h(playbackInfo.f7948c.f5732a, this.f6669l).f7340l, this.f7863a).f7353n)) {
            pair = (z3 && i3 == 0 && playbackInfo2.f7948c.f5735d < playbackInfo.f7948c.f5735d) ? new Pair(Boolean.TRUE, 0) : new Pair(Boolean.FALSE, -1);
        } else {
            if (z3 && i3 == 0) {
                i5 = 1;
            } else if (z3 && i3 == 1) {
                i5 = 2;
            } else {
                if (!z4) {
                    throw new IllegalStateException();
                }
                i5 = 3;
            }
            pair = new Pair(Boolean.TRUE, Integer.valueOf(i5));
        }
        boolean zBooleanValue = ((Boolean) pair.first).booleanValue();
        int iIntValue = ((Integer) pair.second).intValue();
        MediaMetadata mediaMetadataM2899e0 = this.f6655D;
        if (zBooleanValue) {
            mediaItem2 = !playbackInfo.f7947b.m3331q() ? playbackInfo.f7947b.m3330n(playbackInfo.f7947b.mo3327h(playbackInfo.f7948c.f5732a, this.f6669l).f7340l, this.f7863a).f7355p : null;
            this.f6656E = MediaMetadata.f7368j;
        } else {
            mediaItem2 = null;
        }
        if (zBooleanValue || !playbackInfo2.f7956k.equals(playbackInfo.f7956k)) {
            MediaMetadata.b bVarM3344a = this.f6656E.m3344a();
            List<Metadata> list = playbackInfo.f7956k;
            for (int i7 = 0; i7 < list.size(); i7++) {
                Metadata metadata = list.get(i7);
                int i8 = 0;
                while (true) {
                    Metadata.Entry[] entryArr = metadata.f19936j;
                    if (i8 < entryArr.length) {
                        entryArr[i8].mo8878n(bVarM3344a);
                        i8++;
                    }
                }
            }
            this.f6656E = bVarM3344a.m3345a();
            mediaMetadataM2899e0 = m2899e0();
        }
        boolean z5 = !mediaMetadataM2899e0.equals(this.f6655D);
        this.f6655D = mediaMetadataM2899e0;
        if (!playbackInfo2.f7947b.equals(playbackInfo.f7947b)) {
            this.f6667j.m3035b(0, new C2654d0(playbackInfo, i));
        }
        if (z3) {
            Timeline.b bVar = new Timeline.b();
            if (playbackInfo2.f7947b.m3331q()) {
                i6 = i4;
                obj = null;
                mediaItem22 = null;
                obj2 = null;
                iMo2554b = -1;
            } else {
                Object obj5 = playbackInfo2.f7948c.f5732a;
                playbackInfo2.f7947b.mo3327h(obj5, bVar);
                int i9 = bVar.f7340l;
                obj2 = obj5;
                i6 = i9;
                iMo2554b = playbackInfo2.f7947b.mo2554b(obj5);
                obj = playbackInfo2.f7947b.m3330n(i9, this.f7863a).f7353n;
                mediaItem22 = this.f7863a.f7355p;
            }
            if (i3 == 0) {
                jM2877j0 = bVar.f7342n + bVar.f7341m;
                if (playbackInfo2.f7948c.m2593a()) {
                    MediaSource2.a aVar = playbackInfo2.f7948c;
                    jM2877j0 = bVar.m3332a(aVar.f5733b, aVar.f5734c);
                    jM2877j02 = m2877j0(playbackInfo2);
                    long jM2992M = Util2.m2992M(jM2877j0);
                    long jM2992M2 = Util2.m2992M(jM2877j02);
                    MediaSource2.a aVar2 = playbackInfo2.f7948c;
                    Player2.f fVar = new Player2.f(obj, i6, mediaItem22, obj2, iMo2554b, jM2992M, jM2992M2, aVar2.f5733b, aVar2.f5734c);
                    int iMo2881C = mo2881C();
                    if (this.f6657F.f7947b.m3331q()) {
                        PlaybackInfo playbackInfo3 = this.f6657F;
                        Object obj6 = playbackInfo3.f7948c.f5732a;
                        playbackInfo3.f7947b.mo3327h(obj6, this.f6669l);
                        iMo2554b2 = this.f6657F.f7947b.mo2554b(obj6);
                        obj4 = obj6;
                        obj3 = this.f6657F.f7947b.m3330n(iMo2881C, this.f7863a).f7353n;
                        mediaItem23 = this.f7863a.f7355p;
                    } else {
                        obj3 = null;
                        mediaItem23 = null;
                        obj4 = null;
                        iMo2554b2 = -1;
                    }
                    long jM2992M3 = Util2.m2992M(j);
                    long jM2992M4 = !this.f6657F.f7948c.m2593a() ? Util2.m2992M(m2877j0(this.f6657F)) : jM2992M3;
                    MediaSource2.a aVar3 = this.f6657F.f7948c;
                    this.f6667j.m3035b(11, new C2526a0(i3, fVar, new Player2.f(obj3, iMo2881C, mediaItem23, obj4, iMo2554b2, jM2992M3, jM2992M4, aVar3.f5733b, aVar3.f5734c)));
                } else {
                    if (playbackInfo2.f7948c.f5736e != -1 && this.f6657F.f7948c.m2593a()) {
                        jM2877j0 = m2877j0(this.f6657F);
                    }
                    jM2877j02 = jM2877j0;
                    long jM2992M5 = Util2.m2992M(jM2877j0);
                    long jM2992M22 = Util2.m2992M(jM2877j02);
                    MediaSource2.a aVar22 = playbackInfo2.f7948c;
                    Player2.f fVar2 = new Player2.f(obj, i6, mediaItem22, obj2, iMo2554b, jM2992M5, jM2992M22, aVar22.f5733b, aVar22.f5734c);
                    int iMo2881C2 = mo2881C();
                    if (this.f6657F.f7947b.m3331q()) {
                    }
                    long jM2992M32 = Util2.m2992M(j);
                    if (!this.f6657F.f7948c.m2593a()) {
                    }
                    MediaSource2.a aVar32 = this.f6657F.f7948c;
                    this.f6667j.m3035b(11, new C2526a0(i3, fVar2, new Player2.f(obj3, iMo2881C2, mediaItem23, obj4, iMo2554b2, jM2992M32, jM2992M4, aVar32.f5733b, aVar32.f5734c)));
                }
            } else if (playbackInfo2.f7948c.m2593a()) {
                jM2877j0 = playbackInfo2.f7965t;
                jM2877j02 = m2877j0(playbackInfo2);
                long jM2992M52 = Util2.m2992M(jM2877j0);
                long jM2992M222 = Util2.m2992M(jM2877j02);
                MediaSource2.a aVar222 = playbackInfo2.f7948c;
                Player2.f fVar22 = new Player2.f(obj, i6, mediaItem22, obj2, iMo2554b, jM2992M52, jM2992M222, aVar222.f5733b, aVar222.f5734c);
                int iMo2881C22 = mo2881C();
                if (this.f6657F.f7947b.m3331q()) {
                }
                long jM2992M322 = Util2.m2992M(j);
                if (!this.f6657F.f7948c.m2593a()) {
                }
                MediaSource2.a aVar322 = this.f6657F.f7948c;
                this.f6667j.m3035b(11, new C2526a0(i3, fVar22, new Player2.f(obj3, iMo2881C22, mediaItem23, obj4, iMo2554b2, jM2992M322, jM2992M4, aVar322.f5733b, aVar322.f5734c)));
            } else {
                jM2877j0 = bVar.f7342n + playbackInfo2.f7965t;
                jM2877j02 = jM2877j0;
                long jM2992M522 = Util2.m2992M(jM2877j0);
                long jM2992M2222 = Util2.m2992M(jM2877j02);
                MediaSource2.a aVar2222 = playbackInfo2.f7948c;
                Player2.f fVar222 = new Player2.f(obj, i6, mediaItem22, obj2, iMo2554b, jM2992M522, jM2992M2222, aVar2222.f5733b, aVar2222.f5734c);
                int iMo2881C222 = mo2881C();
                if (this.f6657F.f7947b.m3331q()) {
                }
                long jM2992M3222 = Util2.m2992M(j);
                if (!this.f6657F.f7948c.m2593a()) {
                }
                MediaSource2.a aVar3222 = this.f6657F.f7948c;
                this.f6667j.m3035b(11, new C2526a0(i3, fVar222, new Player2.f(obj3, iMo2881C222, mediaItem23, obj4, iMo2554b2, jM2992M3222, jM2992M4, aVar3222.f5733b, aVar3222.f5734c)));
            }
        }
        if (zBooleanValue) {
            this.f6667j.m3035b(1, new C3152z(mediaItem2, iIntValue));
        }
        if (playbackInfo2.f7952g != playbackInfo.f7952g) {
            this.f6667j.m3035b(10, new C2817l(playbackInfo));
            if (playbackInfo.f7952g != null) {
                this.f6667j.m3035b(10, new C3126y(playbackInfo));
            }
        }
        TrackSelectorResult trackSelectorResult = playbackInfo2.f7955j;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.f7955j;
        if (trackSelectorResult != trackSelectorResult2) {
            this.f6663f.mo2752a(trackSelectorResult2.f6330e);
            this.f6667j.m3035b(2, new C2837q(playbackInfo, new TrackSelectionArray(playbackInfo.f7955j.f6328c)));
            this.f6667j.m3035b(2, new C2908t(playbackInfo));
        }
        if (z5) {
            this.f6667j.m3035b(14, new C2833p(this.f6655D));
        }
        if (playbackInfo2.f7953h != playbackInfo.f7953h) {
            this.f6667j.m3035b(3, new C2829o(playbackInfo));
        }
        if (playbackInfo2.f7951f != playbackInfo.f7951f || playbackInfo2.f7958m != playbackInfo.f7958m) {
            this.f6667j.m3035b(-1, new C2676e0(playbackInfo));
        }
        if (playbackInfo2.f7951f != playbackInfo.f7951f) {
            this.f6667j.m3035b(4, new C2821m(playbackInfo));
        }
        if (playbackInfo2.f7958m != playbackInfo.f7958m) {
            this.f6667j.m3035b(5, new C2845s(playbackInfo, i2));
        }
        if (playbackInfo2.f7959n != playbackInfo.f7959n) {
            this.f6667j.m3035b(6, new C2841r(playbackInfo));
        }
        if (m2878k0(playbackInfo2) != m2878k0(playbackInfo)) {
            this.f6667j.m3035b(7, new C2950v(playbackInfo));
        }
        if (!playbackInfo2.f7960o.equals(playbackInfo.f7960o)) {
            this.f6667j.m3035b(12, new C2726f0(playbackInfo));
        }
        if (z2) {
            this.f6667j.m3035b(-1, C2573b.f5737a);
        }
        m2923r0();
        this.f6667j.m3034a();
        if (playbackInfo2.f7961p != playbackInfo.f7961p) {
            Iterator<ExoPlayer2.a> it = this.f6668k.iterator();
            while (it.hasNext()) {
                it.next().mo2771x(playbackInfo.f7961p);
            }
        }
        if (playbackInfo2.f7962q != playbackInfo.f7962q) {
            Iterator<ExoPlayer2.a> it2 = this.f6668k.iterator();
            while (it2.hasNext()) {
                it2.next().mo2770o(playbackInfo.f7962q);
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    @Nullable
    /* JADX INFO: renamed from: t */
    public PlaybackException mo2925t() {
        return this.f6657F.f7952g;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: u */
    public void mo2926u(boolean z2) {
        m2921q0(z2, 0, 1);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: v */
    public long mo2927v() {
        return this.f6677t;
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: w */
    public long mo2928w() {
        if (!mo2900f()) {
            return mo2894T();
        }
        PlaybackInfo playbackInfo = this.f6657F;
        playbackInfo.f7947b.mo3327h(playbackInfo.f7948c.f5732a, this.f6669l);
        PlaybackInfo playbackInfo2 = this.f6657F;
        return playbackInfo2.f7949d == -9223372036854775807L ? playbackInfo2.f7947b.m3330n(mo2881C(), this.f7863a).m3339a() : Util2.m2992M(this.f6669l.f7342n) + Util2.m2992M(this.f6657F.f7949d);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: x */
    public void mo2929x(Player2.e eVar) {
        m2898d0(eVar);
    }

    @Override // p007b.p225i.p226a.p242c.Player2
    /* JADX INFO: renamed from: y */
    public int mo2930y() {
        return this.f6657F.f7951f;
    }
}
