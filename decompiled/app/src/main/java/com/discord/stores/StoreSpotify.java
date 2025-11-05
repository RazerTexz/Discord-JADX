package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.activity.ActivityType;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.spotify.ModelSpotifyAlbum;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spotify.SpotifyApiClient;
import com.discord.utilities.time.Clock;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.t;
import d0.g0.w;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.e.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreSpotify.kt */
/* loaded from: classes2.dex */
public final class StoreSpotify {
    private final Clock clock;
    private final Dispatcher dispatcher;
    private Subscription expireStateSub;
    private final BehaviorSubject<Unit> publishStateTrigger;
    private final SpotifyApiClient spotifyApiClient;
    private SpotifyState spotifyState;
    private final StoreStream stream;

    /* compiled from: StoreSpotify.kt */
    public static final /* data */ class SpotifyState {
        private final boolean playing;
        private final int position;
        private final long start;
        private final ModelSpotifyTrack track;

        public SpotifyState() {
            this(null, false, 0, 0L, 15, null);
        }

        public SpotifyState(ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j) {
            this.track = modelSpotifyTrack;
            this.playing = z2;
            this.position = i;
            this.start = j;
        }

        public static /* synthetic */ SpotifyState copy$default(SpotifyState spotifyState, ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                modelSpotifyTrack = spotifyState.track;
            }
            if ((i2 & 2) != 0) {
                z2 = spotifyState.playing;
            }
            boolean z3 = z2;
            if ((i2 & 4) != 0) {
                i = spotifyState.position;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                j = spotifyState.start;
            }
            return spotifyState.copy(modelSpotifyTrack, z3, i3, j);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelSpotifyTrack getTrack() {
            return this.track;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getPlaying() {
            return this.playing;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPosition() {
            return this.position;
        }

        /* renamed from: component4, reason: from getter */
        public final long getStart() {
            return this.start;
        }

        public final SpotifyState copy(ModelSpotifyTrack track, boolean playing, int position, long start) {
            return new SpotifyState(track, playing, position, start);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpotifyState)) {
                return false;
            }
            SpotifyState spotifyState = (SpotifyState) other;
            return m.areEqual(this.track, spotifyState.track) && this.playing == spotifyState.playing && this.position == spotifyState.position && this.start == spotifyState.start;
        }

        public final boolean getPlaying() {
            return this.playing;
        }

        public final int getPosition() {
            return this.position;
        }

        public final long getStart() {
            return this.start;
        }

        public final ModelSpotifyTrack getTrack() {
            return this.track;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelSpotifyTrack modelSpotifyTrack = this.track;
            int iHashCode = (modelSpotifyTrack != null ? modelSpotifyTrack.hashCode() : 0) * 31;
            boolean z2 = this.playing;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return b.a(this.start) + ((((iHashCode + i) * 31) + this.position) * 31);
        }

        public String toString() {
            StringBuilder sbU = a.U("SpotifyState(track=");
            sbU.append(this.track);
            sbU.append(", playing=");
            sbU.append(this.playing);
            sbU.append(", position=");
            sbU.append(this.position);
            sbU.append(", start=");
            return a.C(sbU, this.start, ")");
        }

        public /* synthetic */ SpotifyState(ModelSpotifyTrack modelSpotifyTrack, boolean z2, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : modelSpotifyTrack, (i2 & 2) != 0 ? false : z2, (i2 & 4) == 0 ? i : 0, (i2 & 8) != 0 ? 0L : j);
        }
    }

    /* compiled from: StoreSpotify.kt */
    /* renamed from: com.discord.stores.StoreSpotify$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<ModelSpotifyTrack, Observable<? extends ModelSpotifyTrack>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: StoreSpotify.kt */
        /* renamed from: com.discord.stores.StoreSpotify$init$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02921<T, R> implements j0.k.b {
            public static final C02921 INSTANCE = new C02921();

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((Long) obj);
            }

            public final Void call(Long l) {
                return null;
            }
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends ModelSpotifyTrack> call(ModelSpotifyTrack modelSpotifyTrack) {
            return call2(modelSpotifyTrack);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends ModelSpotifyTrack> call2(ModelSpotifyTrack modelSpotifyTrack) {
            return modelSpotifyTrack != null ? new k(modelSpotifyTrack) : Observable.d0(1L, TimeUnit.SECONDS).G(C02921.INSTANCE);
        }
    }

    /* compiled from: StoreSpotify.kt */
    /* renamed from: com.discord.stores.StoreSpotify$init$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<Unit, ModelSpotifyTrack, ModelSpotifyTrack> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelSpotifyTrack call2(Unit unit, ModelSpotifyTrack modelSpotifyTrack) {
            return modelSpotifyTrack;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ ModelSpotifyTrack call(Unit unit, ModelSpotifyTrack modelSpotifyTrack) {
            return call2(unit, modelSpotifyTrack);
        }
    }

    /* compiled from: StoreSpotify.kt */
    /* renamed from: com.discord.stores.StoreSpotify$init$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<ModelSpotifyTrack, Unit> {

        /* compiled from: StoreSpotify.kt */
        /* renamed from: com.discord.stores.StoreSpotify$init$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ ModelSpotifyTrack $track;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelSpotifyTrack modelSpotifyTrack) {
                super(0);
                this.$track = modelSpotifyTrack;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SpotifyState spotifyStateAccess$getSpotifyState$p = StoreSpotify.access$getSpotifyState$p(StoreSpotify.this);
                if (spotifyStateAccess$getSpotifyState$p != null) {
                    StoreSpotify.access$setSpotifyState$p(StoreSpotify.this, SpotifyState.copy$default(spotifyStateAccess$getSpotifyState$p, this.$track, false, 0, 0L, 14, null));
                    Subscription subscriptionAccess$getExpireStateSub$p = StoreSpotify.access$getExpireStateSub$p(StoreSpotify.this);
                    if (subscriptionAccess$getExpireStateSub$p != null) {
                        subscriptionAccess$getExpireStateSub$p.unsubscribe();
                    }
                    if (this.$track != null) {
                        StoreSpotify.access$startStateExpiration(StoreSpotify.this, (this.$track.getDurationMs() + spotifyStateAccess$getSpotifyState$p.getStart()) - StoreSpotify.access$getClock$p(StoreSpotify.this).currentTimeMillis());
                    }
                }
                StoreSpotify.access$publishState(StoreSpotify.this);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSpotifyTrack modelSpotifyTrack) {
            invoke2(modelSpotifyTrack);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSpotifyTrack modelSpotifyTrack) {
            StoreSpotify.access$getDispatcher$p(StoreSpotify.this).schedule(new AnonymousClass1(modelSpotifyTrack));
        }
    }

    /* compiled from: StoreSpotify.kt */
    /* renamed from: com.discord.stores.StoreSpotify$setPlayingStatus$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ boolean $playing;
        public final /* synthetic */ int $position;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, int i) {
            super(0);
            this.$playing = z2;
            this.$position = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreSpotify.access$getSpotifyState$p(StoreSpotify.this) == null) {
                StoreSpotify.access$setSpotifyState$p(StoreSpotify.this, new SpotifyState(null, false, 0, 0L, 15, null));
            }
            StoreSpotify storeSpotify = StoreSpotify.this;
            SpotifyState spotifyStateAccess$getSpotifyState$p = StoreSpotify.access$getSpotifyState$p(storeSpotify);
            StoreSpotify.access$setSpotifyState$p(storeSpotify, spotifyStateAccess$getSpotifyState$p != null ? SpotifyState.copy$default(spotifyStateAccess$getSpotifyState$p, null, this.$playing, this.$position, StoreSpotify.access$getClock$p(StoreSpotify.this).currentTimeMillis() - this.$position, 1, null) : null);
            StoreSpotify.access$getPublishStateTrigger$p(StoreSpotify.this).onNext(Unit.a);
        }
    }

    /* compiled from: StoreSpotify.kt */
    /* renamed from: com.discord.stores.StoreSpotify$startStateExpiration$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            StoreSpotify.access$setExpireStateSub$p(StoreSpotify.this, subscription);
        }
    }

    /* compiled from: StoreSpotify.kt */
    /* renamed from: com.discord.stores.StoreSpotify$startStateExpiration$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Long, Unit> {

        /* compiled from: StoreSpotify.kt */
        /* renamed from: com.discord.stores.StoreSpotify$startStateExpiration$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreSpotify.access$setSpotifyState$p(StoreSpotify.this, null);
                StoreSpotify.access$publishState(StoreSpotify.this);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreSpotify.access$getDispatcher$p(StoreSpotify.this).schedule(new AnonymousClass1());
        }
    }

    public StoreSpotify(StoreStream storeStream, Dispatcher dispatcher, Clock clock) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(clock, "clock");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.publishStateTrigger = BehaviorSubject.k0();
        this.spotifyApiClient = new SpotifyApiClient(clock);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreSpotify storeSpotify) {
        return storeSpotify.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreSpotify storeSpotify) {
        return storeSpotify.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getExpireStateSub$p(StoreSpotify storeSpotify) {
        return storeSpotify.expireStateSub;
    }

    public static final /* synthetic */ BehaviorSubject access$getPublishStateTrigger$p(StoreSpotify storeSpotify) {
        return storeSpotify.publishStateTrigger;
    }

    public static final /* synthetic */ SpotifyState access$getSpotifyState$p(StoreSpotify storeSpotify) {
        return storeSpotify.spotifyState;
    }

    public static final /* synthetic */ void access$publishState(StoreSpotify storeSpotify) {
        storeSpotify.publishState();
    }

    public static final /* synthetic */ void access$setExpireStateSub$p(StoreSpotify storeSpotify, Subscription subscription) {
        storeSpotify.expireStateSub = subscription;
    }

    public static final /* synthetic */ void access$setSpotifyState$p(StoreSpotify storeSpotify, SpotifyState spotifyState) {
        storeSpotify.spotifyState = spotifyState;
    }

    public static final /* synthetic */ void access$startStateExpiration(StoreSpotify storeSpotify, long j) {
        storeSpotify.startStateExpiration(j);
    }

    @StoreThread
    private final void publishState() {
        boolean z2;
        List<ModelSpotifyAlbum.AlbumImage> images;
        List<ModelSpotifyAlbum.AlbumImage> images2;
        ModelSpotifyAlbum.AlbumImage albumImage;
        String url;
        List listSplit$default;
        if (this.spotifyState == null) {
            this.stream.getPresences().updateActivity(ActivityType.LISTENING, null, true);
            return;
        }
        StoreUserConnections.State stateSnapshot = this.stream.getUserConnections().getStateSnapshot();
        if ((stateSnapshot instanceof Collection) && stateSnapshot.isEmpty()) {
            z2 = false;
        } else {
            for (ConnectedAccount connectedAccount : stateSnapshot) {
                if (m.areEqual(connectedAccount.getType(), Platform.SPOTIFY.getPlatformId()) && connectedAccount.getShowActivity()) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        if (z2) {
            SpotifyState spotifyState = this.spotifyState;
            m.checkNotNull(spotifyState);
            ModelSpotifyTrack track = spotifyState.getTrack();
            boolean playing = spotifyState.getPlaying();
            long start = spotifyState.getStart();
            if (!playing || track == null) {
                this.stream.getPresences().updateActivity(ActivityType.LISTENING, null, true);
                return;
            }
            ModelSpotifyAlbum album = track.getAlbum();
            String str = (album == null || (images2 = album.getImages()) == null || (albumImage = (ModelSpotifyAlbum.AlbumImage) u.firstOrNull((List) images2)) == null || (url = albumImage.getUrl()) == null || (listSplit$default = w.split$default((CharSequence) url, new String[]{AutocompleteViewModel.COMMAND_DISCOVER_TOKEN}, false, 0, 6, (Object) null)) == null) ? null : (String) u.last(listSplit$default);
            String str2 = str != null ? Platform.SPOTIFY.getPlatformId() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + str : null;
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            Platform platform = Platform.SPOTIFY;
            String properName = platform.getProperName();
            String name = track.getName();
            String id2 = track.getId();
            ModelSpotifyAlbum album2 = track.getAlbum();
            this.stream.getPresences().updateActivity(ActivityType.LISTENING, ActivityUtilsKt.createSpotifyListeningActivity(jCurrentTimeMillis, properName, name, id2, album2 != null ? album2.getName() : null, str2, u.joinToString$default(track.getArtists(), null, null, null, 0, null, StoreSpotify$publishState$activity$1.INSTANCE, 31, null), start, track.getDurationMs() + start, platform.getPlatformId() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + this.stream.getUsers().getMe().getId()), true);
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            String id3 = track.getId();
            ModelSpotifyAlbum album3 = track.getAlbum();
            analyticsTracker.activityUpdatedSpotify(id3, (album3 == null || (images = album3.getImages()) == null || images.isEmpty()) ? false : true);
        }
    }

    @StoreThread
    private final void startStateExpiration(long timeLeftMs) {
        Observable<Long> observableD0 = Observable.d0(timeLeftMs + 5000, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…), TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, StoreSpotify.class, (Context) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 58, (Object) null);
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<ConnectedAccount> connectedAccounts = payload.getConnectedAccounts();
        m.checkNotNullExpressionValue(connectedAccounts, "payload.connectedAccounts");
        handleUserConnections(connectedAccounts);
        this.publishStateTrigger.onNext(Unit.a);
    }

    @StoreThread
    public final void handleConnectionReady(boolean ready) {
        if (ready) {
            this.publishStateTrigger.onNext(Unit.a);
        }
    }

    @StoreThread
    public final void handlePreLogout() {
        this.spotifyState = null;
    }

    @StoreThread
    public final void handleUserConnections(List<ConnectedAccount> accounts) {
        Object next;
        m.checkNotNullParameter(accounts, "accounts");
        Iterator<T> it = accounts.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (t.equals(Platform.SPOTIFY.name(), ((ConnectedAccount) next).getType(), true)) {
                    break;
                }
            }
        }
        ConnectedAccount connectedAccount = (ConnectedAccount) next;
        this.spotifyApiClient.setSpotifyAccountId(connectedAccount != null ? connectedAccount.getId() : null);
    }

    public final void init(Context context) {
        m.checkNotNullParameter(context, "context");
        SpotifyHelper.registerSpotifyBroadcastReceivers(context);
        Observable observableP = Observable.j(this.publishStateTrigger, this.spotifyApiClient.getSpotifyTrack().Y(AnonymousClass1.INSTANCE).r(), AnonymousClass2.INSTANCE).p(2L, TimeUnit.SECONDS);
        m.checkNotNullExpressionValue(observableP, "Observable.combineLatest…unce(2, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, StoreSpotify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }

    public final void setCurrentTrackId(String trackId) {
        m.checkNotNullParameter(trackId, "trackId");
        this.spotifyApiClient.fetchSpotifyTrack(trackId);
    }

    public final void setPlayingStatus(boolean playing, int position) {
        this.dispatcher.schedule(new AnonymousClass1(playing, position));
    }
}
