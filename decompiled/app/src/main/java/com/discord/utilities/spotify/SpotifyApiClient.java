package com.discord.utilities.spotify;

import android.annotation.SuppressLint;
import android.content.Context;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelConnectionAccessToken;
import com.discord.models.domain.spotify.ModelSpotifyTrack;
import com.discord.utilities.error.Error;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: SpotifyApiClient.kt */
/* loaded from: classes2.dex */
public final class SpotifyApiClient {
    private final Clock clock;
    private String spotifyAccountId;
    private final BehaviorSubject<ModelSpotifyTrack> spotifyTrackSubject;
    private final HashMap<String, ModelSpotifyTrack> spotifyTracks;
    private long tokenExpiresAt;
    private Subscription tokenSubscription;
    private String trackIdToFetch;

    /* compiled from: SpotifyApiClient.kt */
    /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$fetchSpotifyTrack$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $trackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$trackId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            if (response.getCode() == 401) {
                SpotifyApiClient.access$setTrackIdToFetch(SpotifyApiClient.this, this.$trackId);
                SpotifyApiClient.access$refreshSpotifyToken(SpotifyApiClient.this);
            }
        }
    }

    /* compiled from: SpotifyApiClient.kt */
    /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$fetchSpotifyTrack$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelSpotifyTrack, Unit> {
        public final /* synthetic */ String $trackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$trackId = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelSpotifyTrack modelSpotifyTrack) {
            invoke2(modelSpotifyTrack);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelSpotifyTrack modelSpotifyTrack) {
            Intrinsics3.checkNotNullParameter(modelSpotifyTrack, "track");
            SpotifyApiClient.access$setCachedTrack(SpotifyApiClient.this, modelSpotifyTrack);
            SpotifyApiClient.access$getSpotifyTrackSubject$p(SpotifyApiClient.this).onNext(SpotifyApiClient.access$getCachedTrack(SpotifyApiClient.this, this.$trackId));
        }
    }

    /* compiled from: SpotifyApiClient.kt */
    /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelConnectionAccessToken, Unit> {

        /* compiled from: SpotifyApiClient.kt */
        /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02241 extends Lambda implements Function0<String> {
            public final /* synthetic */ ModelConnectionAccessToken $spotifyToken;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02241(ModelConnectionAccessToken modelConnectionAccessToken) {
                super(0);
                this.$spotifyToken = modelConnectionAccessToken;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ String invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final String invoke2() {
                return this.$spotifyToken.getAccessToken();
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelConnectionAccessToken modelConnectionAccessToken) {
            invoke2(modelConnectionAccessToken);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelConnectionAccessToken modelConnectionAccessToken) {
            Intrinsics3.checkNotNullParameter(modelConnectionAccessToken, "spotifyToken");
            RestAPI.AppHeadersProvider.spotifyTokenProvider = new C02241(modelConnectionAccessToken);
            SpotifyApiClient spotifyApiClient = SpotifyApiClient.this;
            SpotifyApiClient.access$setTokenExpiresAt(spotifyApiClient, SpotifyApiClient.access$getClock$p(spotifyApiClient).currentTimeMillis() + 3600000);
            String strAccess$getTrackIdToFetch = SpotifyApiClient.access$getTrackIdToFetch(SpotifyApiClient.this);
            if (strAccess$getTrackIdToFetch != null) {
                SpotifyApiClient.this.fetchSpotifyTrack(strAccess$getTrackIdToFetch);
                SpotifyApiClient.access$setTrackIdToFetch(SpotifyApiClient.this, null);
            }
        }
    }

    /* compiled from: SpotifyApiClient.kt */
    /* renamed from: com.discord.utilities.spotify.SpotifyApiClient$refreshSpotifyToken$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            SpotifyApiClient.access$setTokenSubscription$p(SpotifyApiClient.this, subscription);
        }
    }

    public SpotifyApiClient(Clock clock) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.spotifyTracks = new HashMap<>();
        this.spotifyTrackSubject = BehaviorSubject.k0();
    }

    public static final /* synthetic */ ModelSpotifyTrack access$getCachedTrack(SpotifyApiClient spotifyApiClient, String str) {
        return spotifyApiClient.getCachedTrack(str);
    }

    public static final /* synthetic */ Clock access$getClock$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.clock;
    }

    public static final /* synthetic */ BehaviorSubject access$getSpotifyTrackSubject$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.spotifyTrackSubject;
    }

    public static final /* synthetic */ Subscription access$getTokenSubscription$p(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.tokenSubscription;
    }

    public static final /* synthetic */ String access$getTrackIdToFetch(SpotifyApiClient spotifyApiClient) {
        return spotifyApiClient.getTrackIdToFetch();
    }

    public static final /* synthetic */ void access$refreshSpotifyToken(SpotifyApiClient spotifyApiClient) {
        spotifyApiClient.refreshSpotifyToken();
    }

    public static final /* synthetic */ void access$setCachedTrack(SpotifyApiClient spotifyApiClient, ModelSpotifyTrack modelSpotifyTrack) {
        spotifyApiClient.setCachedTrack(modelSpotifyTrack);
    }

    public static final /* synthetic */ void access$setTokenExpiresAt(SpotifyApiClient spotifyApiClient, long j) {
        spotifyApiClient.setTokenExpiresAt(j);
    }

    public static final /* synthetic */ void access$setTokenSubscription$p(SpotifyApiClient spotifyApiClient, Subscription subscription) {
        spotifyApiClient.tokenSubscription = subscription;
    }

    public static final /* synthetic */ void access$setTrackIdToFetch(SpotifyApiClient spotifyApiClient, String str) {
        spotifyApiClient.setTrackIdToFetch(str);
    }

    private final synchronized ModelSpotifyTrack getCachedTrack(String trackId) {
        return this.spotifyTracks.get(trackId);
    }

    private final synchronized long getTokenExpiresAt() {
        return this.tokenExpiresAt;
    }

    private final synchronized String getTrackIdToFetch() {
        return this.trackIdToFetch;
    }

    private final boolean isTokenExpiring() {
        return this.clock.currentTimeMillis() >= getTokenExpiresAt() - 10000;
    }

    @SuppressLint({"DefaultLocale"})
    private final void refreshSpotifyToken() {
        String str;
        Subscription subscription = this.tokenSubscription;
        if ((subscription == null || (subscription != null && subscription.isUnsubscribed())) && (str = this.spotifyAccountId) != null) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            String strName = Platform.SPOTIFY.name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = strName.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(api.getConnectionAccessToken(lowerCase, str), false, 1, null), SpotifyApiClient.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
        }
    }

    private final synchronized void setCachedTrack(ModelSpotifyTrack track) {
        this.spotifyTracks.put(track.getId(), track);
    }

    private final synchronized void setTokenExpiresAt(long expiresAt) {
        this.tokenExpiresAt = expiresAt;
    }

    private final synchronized void setTrackIdToFetch(String trackId) {
        this.trackIdToFetch = trackId;
    }

    public final void fetchSpotifyTrack(String trackId) {
        Intrinsics3.checkNotNullParameter(trackId, "trackId");
        if (getCachedTrack(trackId) != null) {
            this.spotifyTrackSubject.onNext(getCachedTrack(trackId));
            return;
        }
        this.spotifyTrackSubject.onNext(null);
        if (!isTokenExpiring()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSpotify().getSpotifyTrack(trackId), false, 1, null), SpotifyApiClient.class, (Context) null, (Function1) null, new AnonymousClass1(trackId), (Function0) null, (Function0) null, new AnonymousClass2(trackId), 54, (Object) null);
        } else {
            setTrackIdToFetch(trackId);
            refreshSpotifyToken();
        }
    }

    public final Observable<ModelSpotifyTrack> getSpotifyTrack() {
        BehaviorSubject<ModelSpotifyTrack> behaviorSubject = this.spotifyTrackSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "spotifyTrackSubject");
        return behaviorSubject;
    }

    public final void setSpotifyAccountId(String id2) {
        this.spotifyAccountId = id2;
    }
}
