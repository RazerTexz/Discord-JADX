package p007b.p225i.p226a.p242c.p262s2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p225i.p226a.p242c.DeviceInfo2;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.PlaybackParameters;
import p007b.p225i.p226a.p242c.Player;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.Player3;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.TracksInfo;
import p007b.p225i.p226a.p242c.p243a3.LoadEventInfo;
import p007b.p225i.p226a.p242c.p243a3.MediaLoadData;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriodId;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p257e3.BandwidthMeter;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p226a.p242c.p259f3.HandlerWrapper;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener;
import p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener;
import p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2;
import p007b.p225i.p226a.p242c.p265v2.DecoderCounters;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.ImmutableMap2;
import p007b.p225i.p355b.p357b.RegularImmutableList;
import p007b.p225i.p355b.p357b.RegularImmutableMap;

/* JADX INFO: renamed from: b.i.a.c.s2.g1, reason: use source file name */
/* JADX INFO: compiled from: AnalyticsCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnalyticsCollector implements Player2.e, AudioRendererEventListener2, VideoRendererEventListener2, MediaSourceEventListener, BandwidthMeter.a, DrmSessionEventListener {

    /* JADX INFO: renamed from: j */
    public final Clock4 f7547j;

    /* JADX INFO: renamed from: k */
    public final Timeline.b f7548k;

    /* JADX INFO: renamed from: l */
    public final Timeline.c f7549l;

    /* JADX INFO: renamed from: m */
    public final a f7550m;

    /* JADX INFO: renamed from: n */
    public final SparseArray<AnalyticsListener.a> f7551n;

    /* JADX INFO: renamed from: o */
    public ListenerSet<AnalyticsListener> f7552o;

    /* JADX INFO: renamed from: p */
    public Player2 f7553p;

    /* JADX INFO: renamed from: q */
    public HandlerWrapper f7554q;

    /* JADX INFO: renamed from: r */
    public boolean f7555r;

    /* JADX INFO: renamed from: b.i.a.c.s2.g1$a */
    /* JADX INFO: compiled from: AnalyticsCollector.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final Timeline.b f7556a;

        /* JADX INFO: renamed from: b */
        public ImmutableList2<MediaSource2.a> f7557b;

        /* JADX INFO: renamed from: c */
        public ImmutableMap2<MediaSource2.a, Timeline> f7558c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public MediaSource2.a f7559d;

        /* JADX INFO: renamed from: e */
        public MediaSource2.a f7560e;

        /* JADX INFO: renamed from: f */
        public MediaSource2.a f7561f;

        public a(Timeline.b bVar) {
            this.f7556a = bVar;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
            this.f7557b = RegularImmutableList.f12012l;
            this.f7558c = RegularImmutableMap.f12015m;
        }

        @Nullable
        /* JADX INFO: renamed from: b */
        public static MediaSource2.a m3388b(Player2 player2, ImmutableList2<MediaSource2.a> immutableList2, @Nullable MediaSource2.a aVar, Timeline.b bVar) {
            Timeline timelineMo2888K = player2.mo2888K();
            int iMo2912m = player2.mo2912m();
            Object objMo2556m = timelineMo2888K.m3331q() ? null : timelineMo2888K.mo2556m(iMo2912m);
            int iM3333b = (player2.mo2900f() || timelineMo2888K.m3331q()) ? -1 : timelineMo2888K.m3326f(iMo2912m, bVar).m3333b(Util2.m2981B(player2.mo2894T()) - bVar.f7342n);
            for (int i = 0; i < immutableList2.size(); i++) {
                MediaSource2.a aVar2 = immutableList2.get(i);
                if (m3389c(aVar2, objMo2556m, player2.mo2900f(), player2.mo2880B(), player2.mo2920q(), iM3333b)) {
                    return aVar2;
                }
            }
            if (immutableList2.isEmpty() && aVar != null) {
                if (m3389c(aVar, objMo2556m, player2.mo2900f(), player2.mo2880B(), player2.mo2920q(), iM3333b)) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: c */
        public static boolean m3389c(MediaSource2.a aVar, @Nullable Object obj, boolean z2, int i, int i2, int i3) {
            if (aVar.f5732a.equals(obj)) {
                return (z2 && aVar.f5733b == i && aVar.f5734c == i2) || (!z2 && aVar.f5733b == -1 && aVar.f5736e == i3);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public final void m3390a(ImmutableMap2.a<MediaSource2.a, Timeline> aVar, @Nullable MediaSource2.a aVar2, Timeline timeline) {
            if (aVar2 == null) {
                return;
            }
            if (timeline.mo2554b(aVar2.f5732a) != -1) {
                aVar.m6277c(aVar2, timeline);
                return;
            }
            Timeline timeline2 = this.f7558c.get(aVar2);
            if (timeline2 != null) {
                aVar.m6277c(aVar2, timeline2);
            }
        }

        /* JADX INFO: renamed from: d */
        public final void m3391d(Timeline timeline) {
            ImmutableMap2.a<MediaSource2.a, Timeline> aVar = new ImmutableMap2.a<>(4);
            if (this.f7557b.isEmpty()) {
                m3390a(aVar, this.f7560e, timeline);
                if (!C3404f.m4252V(this.f7561f, this.f7560e)) {
                    m3390a(aVar, this.f7561f, timeline);
                }
                if (!C3404f.m4252V(this.f7559d, this.f7560e) && !C3404f.m4252V(this.f7559d, this.f7561f)) {
                    m3390a(aVar, this.f7559d, timeline);
                }
            } else {
                for (int i = 0; i < this.f7557b.size(); i++) {
                    m3390a(aVar, this.f7557b.get(i), timeline);
                }
                if (!this.f7557b.contains(this.f7559d)) {
                    m3390a(aVar, this.f7559d, timeline);
                }
            }
            this.f7558c = aVar.m6275a();
        }
    }

    public AnalyticsCollector(Clock4 clock4) {
        this.f7547j = clock4;
        this.f7552o = new ListenerSet<>(new CopyOnWriteArraySet(), Util2.m3007o(), clock4, C2885o0.f7609a);
        Timeline.b bVar = new Timeline.b();
        this.f7548k = bVar;
        this.f7549l = new Timeline.c();
        this.f7550m = new a(bVar);
        this.f7551n = new SparseArray<>();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: A */
    public void mo235A(MediaMetadata mediaMetadata) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2891r0 c2891r0 = new C2891r0(aVarM3382k0, mediaMetadata);
        this.f7551n.put(14, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(14, c2891r0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: B */
    public final void mo3291B(String str) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2894t c2894t = new C2894t(aVarM3387p0, str);
        this.f7551n.put(PointerIconCompat.TYPE_ALL_SCROLL, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_ALL_SCROLL, c2894t);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: C */
    public final void mo3292C(String str, long j, long j2) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2879l0 c2879l0 = new C2879l0(aVarM3387p0, str, j2, j);
        this.f7551n.put(PointerIconCompat.TYPE_VERTICAL_TEXT, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_VERTICAL_TEXT, c2879l0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: D */
    public final void mo236D(boolean z2) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2867g0 c2867g0 = new C2867g0(aVarM3382k0, z2);
        this.f7551n.put(9, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(9, c2867g0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: E */
    public /* synthetic */ void mo237E(Player2 player2, Player2.d dVar) {
        Player.m2423e(this, player2, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: F */
    public final void mo3185F(int i, long j) {
        AnalyticsListener.a aVarM3386o0 = m3386o0();
        C2906z c2906z = new C2906z(aVarM3386o0, i, j);
        this.f7551n.put(AudioAttributesCompat.FLAG_ALL, aVarM3386o0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(AudioAttributesCompat.FLAG_ALL, c2906z);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: G */
    public /* synthetic */ void mo238G(int i, boolean z2) {
        Player.m2422d(this, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: H */
    public final void mo239H(boolean z2, int i) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2875j0 c2875j0 = new C2875j0(aVarM3382k0, z2, i);
        this.f7551n.put(-1, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(-1, c2875j0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: I */
    public final void mo3293I(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2873i0 c2873i0 = new C2873i0(aVarM3387p0, format2, decoderReuseEvaluation);
        this.f7551n.put(PointerIconCompat.TYPE_ALIAS, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_ALIAS, c2873i0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
    /* JADX INFO: renamed from: J */
    public final void mo2567J(int i, @Nullable MediaSource2.a aVar) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2895t0 c2895t0 = new C2895t0(aVarM3385n0);
        this.f7551n.put(1034, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1034, c2895t0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: K */
    public final void mo3186K(Object obj, long j) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2865f1 c2865f1 = new C2865f1(aVarM3387p0, obj, j);
        this.f7551n.put(1027, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1027, c2865f1);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: L */
    public final void mo240L(int i) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2852b0 c2852b0 = new C2852b0(aVarM3382k0, i);
        this.f7551n.put(8, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(8, c2852b0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: M */
    public final void mo241M(@Nullable MediaItem2 mediaItem2, int i) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2888q c2888q = new C2888q(aVarM3382k0, mediaItem2, i);
        this.f7551n.put(1, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1, c2888q);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: N */
    public final void mo3294N(Exception exc) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2861e0 c2861e0 = new C2861e0(aVarM3387p0, exc);
        this.f7551n.put(PointerIconCompat.TYPE_ZOOM_IN, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_ZOOM_IN, c2861e0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: O */
    public /* synthetic */ void mo3187O(Format2 format2) {
        VideoRendererEventListener.m3184a(this, format2);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: P */
    public final void mo3188P(DecoderCounters decoderCounters) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2858d0 c2858d0 = new C2858d0(aVarM3387p0, decoderCounters);
        this.f7551n.put(PointerIconCompat.TYPE_GRAB, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_GRAB, c2858d0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: Q */
    public final void mo3189Q(Format2 format2, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2905y0 c2905y0 = new C2905y0(aVarM3387p0, format2, decoderReuseEvaluation);
        this.f7551n.put(1022, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1022, c2905y0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: R */
    public final void mo3295R(long j) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2883n0 c2883n0 = new C2883n0(aVarM3387p0, j);
        this.f7551n.put(PointerIconCompat.TYPE_COPY, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_COPY, c2883n0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
    /* JADX INFO: renamed from: S */
    public final void mo2568S(int i, @Nullable MediaSource2.a aVar) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2862e1 c2862e1 = new C2862e1(aVarM3385n0);
        this.f7551n.put(1031, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1031, c2862e1);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: T */
    public final void mo3296T(Exception exc) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2876k c2876k = new C2876k(aVarM3387p0, exc);
        this.f7551n.put(1037, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1037, c2876k);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: U */
    public /* synthetic */ void mo3297U(Format2 format2) {
        AudioRendererEventListener.m3497a(this, format2);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: V */
    public final void mo3190V(Exception exc) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2889q0 c2889q0 = new C2889q0(aVarM3387p0, exc);
        this.f7551n.put(1038, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1038, c2889q0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: W */
    public final void mo242W(boolean z2, int i) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2859d1 c2859d1 = new C2859d1(aVarM3382k0, z2, i);
        this.f7551n.put(5, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(5, c2859d1);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
    /* JADX INFO: renamed from: X */
    public final void mo2461X(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2904y c2904y = new C2904y(aVarM3385n0, loadEventInfo, mediaLoadData);
        this.f7551n.put(PointerIconCompat.TYPE_CONTEXT_MENU, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_CONTEXT_MENU, c2904y);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: Y */
    public final void mo243Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2872i c2872i = new C2872i(aVarM3382k0, trackGroupArray, trackSelectionArray);
        this.f7551n.put(2, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(2, c2872i);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: Z */
    public final void mo3191Z(DecoderCounters decoderCounters) {
        AnalyticsListener.a aVarM3386o0 = m3386o0();
        C2874j c2874j = new C2874j(aVarM3386o0, decoderCounters);
        this.f7551n.put(InputDeviceCompat.SOURCE_GAMEPAD, aVarM3386o0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(InputDeviceCompat.SOURCE_GAMEPAD, c2874j);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: a */
    public final void mo244a() {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2896u c2896u = new C2896u(aVarM3382k0);
        this.f7551n.put(-1, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(-1, c2896u);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: a0 */
    public void mo245a0(int i, int i2) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2882n c2882n = new C2882n(aVarM3387p0, i, i2);
        this.f7551n.put(1029, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1029, c2882n);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: b */
    public final void mo246b(Metadata metadata) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2898v c2898v = new C2898v(aVarM3382k0, metadata);
        this.f7551n.put(PointerIconCompat.TYPE_CROSSHAIR, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_CROSSHAIR, c2898v);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: b0 */
    public final void mo247b0(PlaybackParameters playbackParameters) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2880m c2880m = new C2880m(aVarM3382k0, playbackParameters);
        this.f7551n.put(12, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(12, c2880m);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo248c() {
        Player.m2436r(this);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
    /* JADX INFO: renamed from: c0 */
    public final void mo2571c0(int i, @Nullable MediaSource2.a aVar, int i2) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2887p0 c2887p0 = new C2887p0(aVarM3385n0, i2);
        this.f7551n.put(1030, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1030, c2887p0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: d */
    public final void mo249d(boolean z2) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2897u0 c2897u0 = new C2897u0(aVarM3387p0, z2);
        this.f7551n.put(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, c2897u0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
    /* JADX INFO: renamed from: d0 */
    public final void mo2572d0(int i, @Nullable MediaSource2.a aVar) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2851b c2851b = new C2851b(aVarM3385n0);
        this.f7551n.put(1035, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1035, c2851b);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: e */
    public /* synthetic */ void mo250e(List list) {
        Player.m2420b(this, list);
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: e0 */
    public final void mo3300e0(int i, long j, long j2) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2855c0 c2855c0 = new C2855c0(aVarM3387p0, i, j, j2);
        this.f7551n.put(PointerIconCompat.TYPE_NO_DROP, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_NO_DROP, c2855c0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: f */
    public final void mo251f(VideoSize videoSize) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2881m0 c2881m0 = new C2881m0(aVarM3387p0, videoSize);
        this.f7551n.put(1028, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1028, c2881m0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: f0 */
    public /* synthetic */ void mo252f0(PlaybackException playbackException) {
        Player.m2434p(this, playbackException);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: g */
    public final void mo253g(Player2.f fVar, Player2.f fVar2, int i) {
        if (i == 1) {
            this.f7555r = false;
        }
        a aVar = this.f7550m;
        Player2 player2 = this.f7553p;
        Objects.requireNonNull(player2);
        aVar.f7559d = a.m3388b(player2, aVar.f7557b, aVar.f7560e, aVar.f7556a);
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2890r c2890r = new C2890r(aVarM3382k0, i, fVar, fVar2);
        this.f7551n.put(11, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(11, c2890r);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
    /* JADX INFO: renamed from: g0 */
    public final void mo2462g0(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2864f0 c2864f0 = new C2864f0(aVarM3385n0, loadEventInfo, mediaLoadData, iOException, z2);
        this.f7551n.put(PointerIconCompat.TYPE_HELP, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_HELP, c2864f0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: h */
    public final void mo254h(int i) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2853b1 c2853b1 = new C2853b1(aVarM3382k0, i);
        this.f7551n.put(6, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(6, c2853b1);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: h0 */
    public final void mo3193h0(long j, int i) {
        AnalyticsListener.a aVarM3386o0 = m3386o0();
        C2856c1 c2856c1 = new C2856c1(aVarM3386o0, j, i);
        this.f7551n.put(1026, aVarM3386o0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1026, c2856c1);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: i */
    public /* synthetic */ void mo255i(boolean z2) {
        Player3.m3876d(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
    /* JADX INFO: renamed from: i0 */
    public final void mo2573i0(int i, @Nullable MediaSource2.a aVar) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2899v0 c2899v0 = new C2899v0(aVarM3385n0);
        this.f7551n.put(1033, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1033, c2899v0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: j */
    public /* synthetic */ void mo256j(int i) {
        Player3.m3884l(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: j0 */
    public void mo257j0(boolean z2) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2907z0 c2907z0 = new C2907z0(aVarM3382k0, z2);
        this.f7551n.put(7, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(7, c2907z0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: k */
    public final void mo3301k(DecoderCounters decoderCounters) {
        AnalyticsListener.a aVarM3386o0 = m3386o0();
        C2901w0 c2901w0 = new C2901w0(aVarM3386o0, decoderCounters);
        this.f7551n.put(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, aVarM3386o0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, c2901w0);
        listenerSet.m3034a();
    }

    /* JADX INFO: renamed from: k0 */
    public final AnalyticsListener.a m3382k0() {
        return m3384m0(this.f7550m.f7559d);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: l */
    public final void mo3194l(String str) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2863f c2863f = new C2863f(aVarM3387p0, str);
        this.f7551n.put(1024, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1024, c2863f);
        listenerSet.m3034a();
    }

    @RequiresNonNull({"player"})
    /* JADX INFO: renamed from: l0 */
    public final AnalyticsListener.a m3383l0(Timeline timeline, int i, @Nullable MediaSource2.a aVar) {
        long jMo2928w;
        MediaSource2.a aVar2 = timeline.m3331q() ? null : aVar;
        long jMo2952d = this.f7547j.mo2952d();
        boolean z2 = false;
        boolean z3 = timeline.equals(this.f7553p.mo2888K()) && i == this.f7553p.mo2881C();
        long jM3339a = 0;
        if (aVar2 != null && aVar2.m2593a()) {
            if (z3 && this.f7553p.mo2880B() == aVar2.f5733b && this.f7553p.mo2920q() == aVar2.f5734c) {
                z2 = true;
            }
            if (z2) {
                jM3339a = this.f7553p.mo2894T();
            }
        } else {
            if (z3) {
                jMo2928w = this.f7553p.mo2928w();
                return new AnalyticsListener.a(jMo2952d, timeline, i, aVar2, jMo2928w, this.f7553p.mo2888K(), this.f7553p.mo2881C(), this.f7550m.f7559d, this.f7553p.mo2894T(), this.f7553p.mo2902g());
            }
            if (!timeline.m3331q()) {
                jM3339a = timeline.mo2514o(i, this.f7549l, 0L).m3339a();
            }
        }
        jMo2928w = jM3339a;
        return new AnalyticsListener.a(jMo2952d, timeline, i, aVar2, jMo2928w, this.f7553p.mo2888K(), this.f7553p.mo2881C(), this.f7550m.f7559d, this.f7553p.mo2894T(), this.f7553p.mo2902g());
    }

    @Override // p007b.p225i.p226a.p242c.p263t2.AudioRendererEventListener2
    /* JADX INFO: renamed from: m */
    public final void mo3302m(DecoderCounters decoderCounters) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2878l c2878l = new C2878l(aVarM3387p0, decoderCounters);
        this.f7551n.put(PointerIconCompat.TYPE_TEXT, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_TEXT, c2878l);
        listenerSet.m3034a();
    }

    /* JADX INFO: renamed from: m0 */
    public final AnalyticsListener.a m3384m0(@Nullable MediaSource2.a aVar) {
        Objects.requireNonNull(this.f7553p);
        Timeline timeline = aVar == null ? null : this.f7550m.f7558c.get(aVar);
        if (aVar != null && timeline != null) {
            return m3383l0(timeline, timeline.mo3327h(aVar.f5732a, this.f7548k).f7340l, aVar);
        }
        int iMo2881C = this.f7553p.mo2881C();
        Timeline timelineMo2888K = this.f7553p.mo2888K();
        if (!(iMo2881C < timelineMo2888K.mo2557p())) {
            timelineMo2888K = Timeline.f7337j;
        }
        return m3383l0(timelineMo2888K, iMo2881C, null);
    }

    @Override // p007b.p225i.p226a.p242c.p260g3.VideoRendererEventListener2
    /* JADX INFO: renamed from: n */
    public final void mo3195n(String str, long j, long j2) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2857d c2857d = new C2857d(aVarM3387p0, str, j2, j);
        this.f7551n.put(PointerIconCompat.TYPE_GRABBING, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_GRABBING, c2857d);
        listenerSet.m3034a();
    }

    /* JADX INFO: renamed from: n0 */
    public final AnalyticsListener.a m3385n0(int i, @Nullable MediaSource2.a aVar) {
        Objects.requireNonNull(this.f7553p);
        if (aVar != null) {
            return this.f7550m.f7558c.get(aVar) != null ? m3384m0(aVar) : m3383l0(Timeline.f7337j, i, aVar);
        }
        Timeline timelineMo2888K = this.f7553p.mo2888K();
        if (!(i < timelineMo2888K.mo2557p())) {
            timelineMo2888K = Timeline.f7337j;
        }
        return m3383l0(timelineMo2888K, i, null);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
    /* JADX INFO: renamed from: o */
    public final void mo2463o(int i, @Nullable MediaSource2.a aVar, MediaLoadData mediaLoadData) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2866g c2866g = new C2866g(aVarM3385n0, mediaLoadData);
        this.f7551n.put(PointerIconCompat.TYPE_WAIT, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_WAIT, c2866g);
        listenerSet.m3034a();
    }

    /* JADX INFO: renamed from: o0 */
    public final AnalyticsListener.a m3386o0() {
        return m3384m0(this.f7550m.f7560e);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: p */
    public void mo258p(TracksInfo tracksInfo) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2900w c2900w = new C2900w(aVarM3382k0, tracksInfo);
        this.f7551n.put(2, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(2, c2900w);
        listenerSet.m3034a();
    }

    /* JADX INFO: renamed from: p0 */
    public final AnalyticsListener.a m3387p0() {
        return m3384m0(this.f7550m.f7561f);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
    /* JADX INFO: renamed from: q */
    public final void mo2464q(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2870h0 c2870h0 = new C2870h0(aVarM3385n0, loadEventInfo, mediaLoadData);
        this.f7551n.put(PointerIconCompat.TYPE_HAND, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_HAND, c2870h0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: r */
    public final void mo259r(boolean z2) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2860e c2860e = new C2860e(aVarM3382k0, z2);
        this.f7551n.put(3, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(3, c2860e);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: s */
    public final void mo260s(PlaybackException playbackException) {
        MediaPeriodId mediaPeriodId;
        AnalyticsListener.a aVarM3384m0 = (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? null : m3384m0(new MediaSource2.a(mediaPeriodId));
        if (aVarM3384m0 == null) {
            aVarM3384m0 = m3382k0();
        }
        C2848a c2848a = new C2848a(aVarM3384m0, playbackException);
        this.f7551n.put(10, aVarM3384m0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(10, c2848a);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: t */
    public void mo261t(Player2.b bVar) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2849a0 c2849a0 = new C2849a0(aVarM3382k0, bVar);
        this.f7551n.put(13, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(13, c2849a0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p266w2.DrmSessionEventListener
    /* JADX INFO: renamed from: u */
    public final void mo2574u(int i, @Nullable MediaSource2.a aVar, Exception exc) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2854c c2854c = new C2854c(aVarM3385n0, exc);
        this.f7551n.put(1032, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1032, c2854c);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: v */
    public final void mo262v(Timeline timeline, int i) {
        a aVar = this.f7550m;
        Player2 player2 = this.f7553p;
        Objects.requireNonNull(player2);
        aVar.f7559d = a.m3388b(player2, aVar.f7557b, aVar.f7560e, aVar.f7556a);
        aVar.m3391d(player2.mo2888K());
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2902x c2902x = new C2902x(aVarM3382k0, i);
        this.f7551n.put(0, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(0, c2902x);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: w */
    public final void mo263w(float f) {
        AnalyticsListener.a aVarM3387p0 = m3387p0();
        C2892s c2892s = new C2892s(aVarM3387p0, f);
        this.f7551n.put(PointerIconCompat.TYPE_ZOOM_OUT, aVarM3387p0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_ZOOM_OUT, c2892s);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaSourceEventListener
    /* JADX INFO: renamed from: x */
    public final void mo2465x(int i, @Nullable MediaSource2.a aVar, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.a aVarM3385n0 = m3385n0(i, aVar);
        C2877k0 c2877k0 = new C2877k0(aVarM3385n0, loadEventInfo, mediaLoadData);
        this.f7551n.put(1000, aVarM3385n0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(1000, c2877k0);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: y */
    public final void mo264y(int i) {
        AnalyticsListener.a aVarM3382k0 = m3382k0();
        C2850a1 c2850a1 = new C2850a1(aVarM3382k0, i);
        this.f7551n.put(4, aVarM3382k0);
        ListenerSet<AnalyticsListener> listenerSet = this.f7552o;
        listenerSet.m3035b(4, c2850a1);
        listenerSet.m3034a();
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: z */
    public /* synthetic */ void mo265z(DeviceInfo2 deviceInfo2) {
        Player.m2421c(this, deviceInfo2);
    }
}
