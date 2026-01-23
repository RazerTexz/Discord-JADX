package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelApplicationStreamPreview;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.Subscription;
import retrofit2.HttpException;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationStreamPreviews extends StoreV2 {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long READ_PREVIEW_DEFAULT_RETRY_DELAY_MS = 10000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final HashMap<String, Integer> fetchAttempts;
    private final HashMap<String, Subscription> fetchStreamPreviewSubscriptions;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final Map<String, StreamPreview> streamKeyToPreviewMap;
    private Map<String, ? extends StreamPreview> streamKeyToPreviewMapSnapshot;

    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static abstract class StreamPreview {

        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final class Fetching extends StreamPreview {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final /* data */ class Resolved extends StreamPreview {
            private final String url;

            public Resolved(String str) {
                super(null);
                this.url = str;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = resolved.url;
                }
                return resolved.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final Resolved copy(String url) {
                return new Resolved(url);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.url, ((Resolved) other).url);
                }
                return true;
            }

            public final String getUrl() {
                return this.url;
            }

            public int hashCode() {
                String str = this.url;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m822J(outline.m833U("Resolved(url="), this.url, ")");
            }
        }

        private StreamPreview() {
        }

        public /* synthetic */ StreamPreview(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$1 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57351 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57351(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.this.handleFetchStart(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$2 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57362 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57362(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews.this).put(this.$streamKey, subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$3 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57373 extends Lambda implements Function1<ModelApplicationStreamPreview, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelApplicationStreamPreview $res;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelApplicationStreamPreview modelApplicationStreamPreview) {
                super(0);
                this.$res = modelApplicationStreamPreview;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57373 c57373 = C57373.this;
                StoreApplicationStreamPreviews.this.handleFetchSuccess(c57373.$streamKey, this.$res.getUrl());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57373(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelApplicationStreamPreview modelApplicationStreamPreview) {
            invoke2(modelApplicationStreamPreview);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelApplicationStreamPreview modelApplicationStreamPreview) {
            Intrinsics3.checkNotNullParameter(modelApplicationStreamPreview, "res");
            StoreApplicationStreamPreviews.access$getDispatcher$p(StoreApplicationStreamPreviews.this).schedule(new AnonymousClass1(modelApplicationStreamPreview));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$4 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57384 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57384 c57384 = C57384.this;
                StoreApplicationStreamPreviews.this.handleFetchFailed(c57384.$streamKey, this.$error);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57384(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreApplicationStreamPreviews.access$getDispatcher$p(StoreApplicationStreamPreviews.this).schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$fetchStreamPreview$5 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57395 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57395(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews.this).remove(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$1 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57401 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57401(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews.this).put(this.$streamKey, subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$2 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57412 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57412(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreApplicationStreamPreviews.access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews.this).remove(this.$streamKey);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$3 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57423 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$handleFetchFailed$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C57423 c57423 = C57423.this;
                StoreApplicationStreamPreviews.access$fetchStreamPreviewIfNotFetching(StoreApplicationStreamPreviews.this, c57423.$streamKey);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57423(String str) {
            super(1);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreApplicationStreamPreviews.access$getDispatcher$p(StoreApplicationStreamPreviews.this).schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplicationStreamPreviews$observeStreamPreview$1 */
    /* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
    public static final class C57431 extends Lambda implements Function0<StreamPreview> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57431(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StreamPreview invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StreamPreview invoke() {
            return StoreApplicationStreamPreviews.this.getStreamKeyToPreviewMap().get(this.$streamKey);
        }
    }

    public /* synthetic */ StoreApplicationStreamPreviews(Dispatcher dispatcher, Clock clock, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, clock, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchStreamPreviewIfNotFetching(StoreApplicationStreamPreviews storeApplicationStreamPreviews, String str) {
        storeApplicationStreamPreviews.fetchStreamPreviewIfNotFetching(str);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return storeApplicationStreamPreviews.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getFetchStreamPreviewSubscriptions$p(StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return storeApplicationStreamPreviews.fetchStreamPreviewSubscriptions;
    }

    private final void fetchStreamPreview(String streamKey) {
        this.dispatcher.schedule(new C57351(streamKey));
        Subscription subscription = this.fetchStreamPreviewSubscriptions.get(streamKey);
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(this.restAPI.getStreamPreview(streamKey, this.clock.currentTimeMillis()), false), StoreApplicationStreamPreviews.class, (Context) null, new C57362(streamKey), new C57384(streamKey), new C57395(streamKey), (Function0) null, new C57373(streamKey), 34, (Object) null);
    }

    public final void fetchStreamPreviewIfNotFetching(StreamContext streamContext) {
        Intrinsics3.checkNotNullParameter(streamContext, "streamContext");
        fetchStreamPreviewIfNotFetching(streamContext.getPreview(), streamContext.getStream().getEncodedStreamKey());
    }

    public final Map<String, StreamPreview> getStreamKeyToPreviewMap() {
        return this.streamKeyToPreviewMapSnapshot;
    }

    @Store3
    public final void handleFetchFailed(String streamKey, Error error) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(error, "error");
        Long lValueOf = null;
        this.streamKeyToPreviewMap.put(streamKey, new StreamPreview.Resolved(null));
        Throwable throwable = error.getThrowable();
        if (!(throwable instanceof HttpException)) {
            throwable = null;
        }
        HttpException httpException = (HttpException) throwable;
        Integer numValueOf = httpException != null ? Integer.valueOf(httpException.m11055a()) : null;
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        Long retryAfterMs = response.getRetryAfterMs();
        Integer num = this.fetchAttempts.get(streamKey);
        if (num == null) {
            num = 0;
        }
        Intrinsics3.checkNotNullExpressionValue(num, "fetchAttempts[streamKey] ?: 0");
        int iIntValue = num.intValue() + 1;
        long jLongValue = ((long) iIntValue) * 10000;
        if (numValueOf == null) {
            lValueOf = Long.valueOf(jLongValue);
        } else if (numValueOf.intValue() == 429) {
            if (retryAfterMs != null) {
                jLongValue = retryAfterMs.longValue();
            }
            lValueOf = Long.valueOf(jLongValue);
        } else if (numValueOf.intValue() != 401 && numValueOf.intValue() != 403) {
            lValueOf = Long.valueOf(jLongValue);
        }
        if (lValueOf != null) {
            Subscription subscription = this.fetchStreamPreviewSubscriptions.get(streamKey);
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Long> observableM11068d0 = Observable.m11068d0(lValueOf.longValue(), TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(retryAf…s, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(observableM11068d0, StoreApplicationStreamPreviews.class, (Context) null, new C57401(streamKey), (Function1) null, new C57412(streamKey), (Function0) null, new C57423(streamKey), 42, (Object) null);
        }
        this.fetchAttempts.put(streamKey, Integer.valueOf(iIntValue));
        markChanged();
    }

    @Store3
    public final void handleFetchStart(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        this.streamKeyToPreviewMap.put(streamKey, StreamPreview.Fetching.INSTANCE);
        markChanged();
    }

    @Store3
    public final void handleFetchSuccess(String streamKey, String url) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(url, "url");
        this.streamKeyToPreviewMap.put(streamKey, new StreamPreview.Resolved(url));
        this.fetchAttempts.remove(streamKey);
        markChanged();
    }

    public final Observable<StreamPreview> observeStreamPreview(ModelApplicationStream applicationStream) {
        Intrinsics3.checkNotNullParameter(applicationStream, "applicationStream");
        return observeStreamPreview(applicationStream.getEncodedStreamKey());
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.streamKeyToPreviewMapSnapshot = new HashMap(this.streamKeyToPreviewMap);
    }

    public final Observable<StreamPreview> observeStreamPreview(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Observable<StreamPreview> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C57431(streamKey), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public StoreApplicationStreamPreviews(Dispatcher dispatcher, Clock clock, RestAPI restAPI, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.streamKeyToPreviewMap = new HashMap();
        this.streamKeyToPreviewMapSnapshot = Maps6.emptyMap();
        this.fetchAttempts = new HashMap<>();
        this.fetchStreamPreviewSubscriptions = new HashMap<>();
    }

    @Store3
    private final void fetchStreamPreviewIfNotFetching(String streamKey) {
        fetchStreamPreviewIfNotFetching(this.streamKeyToPreviewMap.get(streamKey), streamKey);
    }

    private final void fetchStreamPreviewIfNotFetching(StreamPreview preview, String streamKey) {
        if (preview == null || !(preview instanceof StreamPreview.Fetching)) {
            fetchStreamPreview(streamKey);
        }
    }
}
