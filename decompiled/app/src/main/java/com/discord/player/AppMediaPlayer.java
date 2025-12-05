package com.discord.player;

import android.media.AudioTrack;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.MainThread;
import com.discord.utilities.logging.Logger;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.p505ui.PlayerControlView;
import com.google.android.exoplayer2.p505ui.PlayerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p040p.AppMediaPlayer2;
import p007b.p008a.p040p.AppMediaPlayer3;
import p007b.p008a.p040p.AppMediaPlayer4;
import p007b.p008a.p040p.AppMediaPlayer5;
import p007b.p008a.p040p.AppMediaPlayer6;
import p007b.p008a.p040p.AppMediaPlayer7;
import p007b.p008a.p040p.RxPlayerEventListener;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.AudioFocusManager;
import p007b.p225i.p226a.p242c.BasePlayer;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.ExoPlayer2;
import p007b.p225i.p226a.p242c.ExoPlayerImpl;
import p007b.p225i.p226a.p242c.ExoPlayerImplInternal2;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.MediaSourceList;
import p007b.p225i.p226a.p242c.PlaybackInfo;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.PlaylistTimeline;
import p007b.p225i.p226a.p242c.SimpleExoPlayer;
import p007b.p225i.p226a.p242c.StreamVolumeManager;
import p007b.p225i.p226a.p242c.WakeLockManager;
import p007b.p225i.p226a.p242c.WifiLockManager;
import p007b.p225i.p226a.p242c.p243a3.C2547j;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.ProgressiveMediaSource;
import p007b.p225i.p226a.p242c.p243a3.ShuffleOrder;
import p007b.p225i.p226a.p242c.p257e3.DataSource3;
import p007b.p225i.p226a.p242c.p257e3.DefaultLoadErrorHandlingPolicy;
import p007b.p225i.p226a.p242c.p259f3.HandlerWrapper;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p259f3.SystemHandlerWrapper;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p226a.p242c.p262s2.RunnableC2886p;
import p007b.p225i.p226a.p242c.p266w2.DefaultDrmSessionManagerProvider;
import p007b.p225i.p226a.p242c.p266w2.DrmSessionManager2;
import p007b.p225i.p226a.p242c.p267x2.DefaultExtractorsFactory;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.RegularImmutableList;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: AppMediaPlayer.kt */
/* loaded from: classes.dex */
public final class AppMediaPlayer {

    /* renamed from: a, reason: from kotlin metadata */
    public final PublishSubject<Event> eventSubject;

    /* renamed from: b, reason: from kotlin metadata */
    public Subscription positionPollingSubscription;

    /* renamed from: c, reason: from kotlin metadata */
    public final CompositeSubscription compositeSubscription;

    /* renamed from: d, reason: from kotlin metadata */
    public final BehaviorSubject<Float> volumeSubject;

    /* renamed from: e, reason: from kotlin metadata */
    public MediaSource mediaSource;

    /* renamed from: f, reason: from kotlin metadata */
    public final ExoPlayer2 exoPlayer;

    /* renamed from: g, reason: from kotlin metadata */
    public final RxPlayerEventListener rxPlayerEventListener;

    /* renamed from: h, reason: from kotlin metadata */
    public final DataSource3.a dataSourceFactory;

    /* renamed from: i, reason: from kotlin metadata */
    public final Scheduler timerScheduler;

    /* renamed from: j, reason: from kotlin metadata */
    public final Logger logger;

    /* compiled from: AppMediaPlayer.kt */
    public static abstract class Event {

        /* compiled from: AppMediaPlayer.kt */
        /* renamed from: com.discord.player.AppMediaPlayer$Event$a */
        public static final class C5583a extends Event {

            /* renamed from: a */
            public static final C5583a f18654a = new C5583a();

            public C5583a() {
                super(null);
            }
        }

        /* compiled from: AppMediaPlayer.kt */
        /* renamed from: com.discord.player.AppMediaPlayer$Event$b */
        public static final class C5584b extends Event {

            /* renamed from: a */
            public static final C5584b f18655a = new C5584b();

            public C5584b() {
                super(null);
            }
        }

        /* compiled from: AppMediaPlayer.kt */
        /* renamed from: com.discord.player.AppMediaPlayer$Event$c */
        public static final class C5585c extends Event {

            /* renamed from: a */
            public final long f18656a;

            public C5585c(long j) {
                super(null);
                this.f18656a = j;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C5585c) && this.f18656a == ((C5585c) obj).f18656a;
                }
                return true;
            }

            public int hashCode() {
                return C0002b.m3a(this.f18656a);
            }

            public String toString() {
                return outline.m815C(outline.m833U("CurrentPositionUpdate(positionMs="), this.f18656a, ")");
            }
        }

        /* compiled from: AppMediaPlayer.kt */
        /* renamed from: com.discord.player.AppMediaPlayer$Event$d */
        public static final class C5586d extends Event {

            /* renamed from: a */
            public static final C5586d f18657a = new C5586d();

            public C5586d() {
                super(null);
            }
        }

        /* compiled from: AppMediaPlayer.kt */
        /* renamed from: com.discord.player.AppMediaPlayer$Event$e */
        public static final class C5587e extends Event {

            /* renamed from: a */
            public static final C5587e f18658a = new C5587e();

            public C5587e() {
                super(null);
            }
        }

        /* compiled from: AppMediaPlayer.kt */
        /* renamed from: com.discord.player.AppMediaPlayer$Event$f */
        public static final class C5588f extends Event {

            /* renamed from: a */
            public static final C5588f f18659a = new C5588f();

            public C5588f() {
                super(null);
            }
        }

        public Event() {
        }

        public Event(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AppMediaPlayer(ExoPlayer2 exoPlayer2, RxPlayerEventListener rxPlayerEventListener, DataSource3.a aVar, Scheduler scheduler, Logger logger) {
        Intrinsics3.checkNotNullParameter(exoPlayer2, "exoPlayer");
        Intrinsics3.checkNotNullParameter(rxPlayerEventListener, "rxPlayerEventListener");
        Intrinsics3.checkNotNullParameter(aVar, "dataSourceFactory");
        Intrinsics3.checkNotNullParameter(scheduler, "timerScheduler");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.exoPlayer = exoPlayer2;
        this.rxPlayerEventListener = rxPlayerEventListener;
        this.dataSourceFactory = aVar;
        this.timerScheduler = scheduler;
        this.logger = logger;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        this.compositeSubscription = compositeSubscription;
        BehaviorSubject<Float> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(Float.valueOf(((SimpleExoPlayer) exoPlayer2).f7198B));
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(exoPlayer.volume)");
        this.volumeSubject = behaviorSubjectM11130l0;
        PublishSubject<RxPlayerEventListener.c> publishSubject = rxPlayerEventListener.f1590j;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "playerStateChangeSubject");
        compositeSubscription.m11136a(publishSubject.m11085K().m11097W(new AppMediaPlayer6(this), new AppMediaPlayer7(this)));
        PublishSubject<RxPlayerEventListener.a> publishSubject2 = rxPlayerEventListener.f1591k;
        Intrinsics3.checkNotNullExpressionValue(publishSubject2, "isPlayingChangeSubject");
        compositeSubscription.m11136a(publishSubject2.m11086L().m11097W(new AppMediaPlayer2(this), new AppMediaPlayer3(this)));
        MediaSource mediaSource = this.mediaSource;
        String str = (mediaSource == null || (str = mediaSource.featureTag) == null) ? "" : str;
        PublishSubject<RxPlayerEventListener.b> publishSubject3 = rxPlayerEventListener.f1592l;
        Intrinsics3.checkNotNullExpressionValue(publishSubject3, "playerErrorSubject");
        compositeSubscription.m11136a(publishSubject3.m11085K().m11097W(new AppMediaPlayer4(this, str), new AppMediaPlayer5(this)));
    }

    /* renamed from: b */
    public static /* synthetic */ void m8438b(AppMediaPlayer appMediaPlayer, MediaSource mediaSource, boolean z2, boolean z3, long j, PlayerView playerView, PlayerControlView playerControlView, int i) {
        int i2 = i & 32;
        appMediaPlayer.m8439a(mediaSource, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? 0L : j, playerView, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    /* renamed from: a */
    public final void m8439a(MediaSource mediaSource, boolean autoPlayWhenReady, boolean loopMedia, long initialSeekPositionMs, PlayerView playerView, PlayerControlView playerControlView) {
        DrmSessionManager2 drmSessionManager2;
        Intrinsics3.checkNotNullParameter(mediaSource, "mediaSource");
        Intrinsics3.checkNotNullParameter(playerView, "playerView");
        this.mediaSource = mediaSource;
        SimpleExoPlayer simpleExoPlayer = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer.m3290n0();
        simpleExoPlayer.f7227w = 1;
        int i = 4;
        simpleExoPlayer.m3286j0(2, 4, 1);
        playerView.setPlayer(this.exoPlayer);
        if (playerControlView != null) {
            playerControlView.setPlayer(this.exoPlayer);
        }
        DataSource3.a aVar = this.dataSourceFactory;
        C2547j c2547j = new C2547j(new DefaultExtractorsFactory());
        DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
        DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        Uri uri = mediaSource.progressiveMediaUri;
        Bundleable.a<MediaItem2> aVar2 = MediaItem2.f7261j;
        MediaItem2.d.a aVar3 = new MediaItem2.d.a();
        MediaItem2.f.a aVar4 = new MediaItem2.f.a(null);
        List listEmptyList = Collections.emptyList();
        ImmutableList2<Object> immutableList2 = RegularImmutableList.f12012l;
        MediaItem2.g.a aVar5 = new MediaItem2.g.a();
        AnimatableValueParser.m426D(aVar4.f7299b == null || aVar4.f7298a != null);
        MediaItem2.i iVar = uri != null ? new MediaItem2.i(uri, null, aVar4.f7298a != null ? new MediaItem2.f(aVar4, null) : null, null, listEmptyList, null, immutableList2, null, null) : null;
        MediaItem2 mediaItem2 = new MediaItem2("", aVar3.m3322a(), iVar, new MediaItem2.g(aVar5, null), MediaMetadata.f7368j, null);
        Objects.requireNonNull(iVar);
        MediaItem2.f fVar = iVar.f7320c;
        if (fVar == null || Util2.f6708a < 18) {
            drmSessionManager2 = DrmSessionManager2.f8017a;
        } else {
            synchronized (defaultDrmSessionManagerProvider.f8009a) {
                if (!Util2.m2993a(fVar, defaultDrmSessionManagerProvider.f8010b)) {
                    defaultDrmSessionManagerProvider.f8010b = fVar;
                    defaultDrmSessionManagerProvider.f8011c = defaultDrmSessionManagerProvider.m3586a(fVar);
                }
                drmSessionManager2 = defaultDrmSessionManagerProvider.f8011c;
                Objects.requireNonNull(drmSessionManager2);
            }
        }
        ProgressiveMediaSource progressiveMediaSource = new ProgressiveMediaSource(mediaItem2, aVar, c2547j, drmSessionManager2, defaultLoadErrorHandlingPolicy, 1048576, null);
        Intrinsics3.checkNotNullExpressionValue(progressiveMediaSource, "ProgressiveMediaSource.F…rce.progressiveMediaUri))");
        SimpleExoPlayer simpleExoPlayer2 = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer2.m3290n0();
        ExoPlayerImpl exoPlayerImpl = simpleExoPlayer2.f7209e;
        Objects.requireNonNull(exoPlayerImpl);
        List listSingletonList = Collections.singletonList(progressiveMediaSource);
        exoPlayerImpl.m2905h0();
        exoPlayerImpl.mo2894T();
        exoPlayerImpl.f6681x++;
        if (!exoPlayerImpl.f6670m.isEmpty()) {
            exoPlayerImpl.m2919p0(0, exoPlayerImpl.f6670m.size());
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            MediaSourceList.c cVar = new MediaSourceList.c((MediaSource2) listSingletonList.get(i2), exoPlayerImpl.f6671n);
            arrayList.add(cVar);
            exoPlayerImpl.f6670m.add(i2 + 0, new ExoPlayerImpl.a(cVar.f7883b, cVar.f7882a.f5716n));
        }
        ShuffleOrder shuffleOrderMo2548f = exoPlayerImpl.f6653B.mo2548f(0, arrayList.size());
        exoPlayerImpl.f6653B = shuffleOrderMo2548f;
        PlaylistTimeline playlistTimeline = new PlaylistTimeline(exoPlayerImpl.f6670m, shuffleOrderMo2548f);
        if (!playlistTimeline.m3331q() && -1 >= playlistTimeline.f6170n) {
            throw new IllegalSeekPositionException(playlistTimeline, -1, -9223372036854775807L);
        }
        int iMo2582a = playlistTimeline.mo2582a(exoPlayerImpl.f6680w);
        PlaybackInfo playbackInfoM2911l0 = exoPlayerImpl.m2911l0(exoPlayerImpl.f6657F, playlistTimeline, exoPlayerImpl.m2907i0(playlistTimeline, iMo2582a, -9223372036854775807L));
        int i3 = playbackInfoM2911l0.f7951f;
        if (iMo2582a == -1 || i3 == 1) {
            i = i3;
        } else if (!playlistTimeline.m3331q() && iMo2582a < playlistTimeline.f6170n) {
            i = 2;
        }
        PlaybackInfo playbackInfoM3567f = playbackInfoM2911l0.m3567f(i);
        ((SystemHandlerWrapper.b) exoPlayerImpl.f6666i.f7083q.mo2962i(17, new ExoPlayerImplInternal2.a(arrayList, exoPlayerImpl.f6653B, iMo2582a, Util2.m2981B(-9223372036854775807L), null))).m2965b();
        exoPlayerImpl.m2924s0(playbackInfoM3567f, 0, 1, false, (exoPlayerImpl.f6657F.f7948c.f5732a.equals(playbackInfoM3567f.f7948c.f5732a) || exoPlayerImpl.f6657F.f7947b.m3331q()) ? false : true, 4, exoPlayerImpl.m2903g0(playbackInfoM3567f), -1);
        ((SimpleExoPlayer) this.exoPlayer).mo2896a();
        if (autoPlayWhenReady) {
            ((SimpleExoPlayer) this.exoPlayer).mo2926u(true);
        }
        if (initialSeekPositionMs > 0) {
            BasePlayer basePlayer = (BasePlayer) this.exoPlayer;
            basePlayer.mo2904h(basePlayer.mo2881C(), initialSeekPositionMs);
        }
        SimpleExoPlayer simpleExoPlayer3 = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer3.m3290n0();
        simpleExoPlayer3.f7209e.mo2882E(loopMedia ? 1 : 0);
    }

    @MainThread
    /* renamed from: c */
    public final void m8440c() {
        AudioTrack audioTrack;
        ((SimpleExoPlayer) this.exoPlayer).mo2926u(false);
        Subscription subscription = this.positionPollingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.compositeSubscription.unsubscribe();
        SimpleExoPlayer simpleExoPlayer = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer.m3290n0();
        if (Util2.f6708a < 21 && (audioTrack = simpleExoPlayer.f7220p) != null) {
            audioTrack.release();
            simpleExoPlayer.f7220p = null;
        }
        simpleExoPlayer.f7214j.m3363a(false);
        StreamVolumeManager streamVolumeManager = simpleExoPlayer.f7216l;
        StreamVolumeManager.c cVar = streamVolumeManager.f7250e;
        if (cVar != null) {
            try {
                streamVolumeManager.f7246a.unregisterReceiver(cVar);
            } catch (RuntimeException e) {
                Log2.m3040c("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            streamVolumeManager.f7250e = null;
        }
        WakeLockManager wakeLockManager = simpleExoPlayer.f7217m;
        wakeLockManager.f7460d = false;
        wakeLockManager.m3357a();
        WifiLockManager wifiLockManager = simpleExoPlayer.f7218n;
        wifiLockManager.f7477d = false;
        wifiLockManager.m3362a();
        AudioFocusManager audioFocusManager = simpleExoPlayer.f7215k;
        audioFocusManager.f7660c = null;
        audioFocusManager.m3460a();
        simpleExoPlayer.f7209e.m2915n0();
        AnalyticsCollector analyticsCollector = simpleExoPlayer.f7213i;
        HandlerWrapper handlerWrapper = analyticsCollector.f7554q;
        AnimatableValueParser.m438H(handlerWrapper);
        handlerWrapper.mo2955b(new RunnableC2886p(analyticsCollector));
        simpleExoPlayer.m3285i0();
        Surface surface = simpleExoPlayer.f7222r;
        if (surface != null) {
            surface.release();
            simpleExoPlayer.f7222r = null;
        }
        if (simpleExoPlayer.f7203G) {
            Objects.requireNonNull(null);
            throw null;
        }
        simpleExoPlayer.f7200D = Collections.emptyList();
    }

    @MainThread
    /* renamed from: d */
    public final void m8441d(float volume) {
        SimpleExoPlayer simpleExoPlayer = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer.m3290n0();
        float fM2999g = Util2.m2999g(volume, 0.0f, 1.0f);
        if (simpleExoPlayer.f7198B != fM2999g) {
            simpleExoPlayer.f7198B = fM2999g;
            simpleExoPlayer.m3286j0(1, 2, Float.valueOf(simpleExoPlayer.f7215k.f7664g * fM2999g));
            simpleExoPlayer.f7213i.mo263w(fM2999g);
            Iterator<Player2.e> it = simpleExoPlayer.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo263w(fM2999g);
            }
        }
        this.volumeSubject.onNext(Float.valueOf(volume));
    }
}
