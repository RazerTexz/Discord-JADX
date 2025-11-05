package com.discord.widgets.chat.list;

import android.content.Context;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.models.domain.ModelChannelFollowerStats;
import com.discord.stores.StoreChannelFollowerStats;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: PublishActionDialogViewModel.kt */
/* loaded from: classes2.dex */
public final class PublishActionDialogViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final PublishSubject<Event> eventSubject;
    private final long messageId;
    private final RestAPI restAPI;

    /* compiled from: PublishActionDialogViewModel.kt */
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "storeState");
            PublishActionDialogViewModel.access$handleStoreState(PublishActionDialogViewModel.this, storeState);
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeChannelFollowerStatsStoreState(Companion companion, long j, StoreChannelFollowerStats storeChannelFollowerStats) {
            return companion.observeChannelFollowerStatsStoreState(j, storeChannelFollowerStats);
        }

        private final Observable<StoreState> observeChannelFollowerStatsStoreState(long channelId, StoreChannelFollowerStats storeChannelFollowerStats) {
            Observable<StoreState> observableR = storeChannelFollowerStats.observeChannelFollowerStats(channelId).G(PublishActionDialogViewModel$Companion$observeChannelFollowerStatsStoreState$1.INSTANCE).r();
            m.checkNotNullExpressionValue(observableR, "storeChannelFollowerStat…  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    public static abstract class Event {

        /* compiled from: PublishActionDialogViewModel.kt */
        public static final /* data */ class Failure extends Event {
            private final int failureMessageStringRes;

            public Failure(int i) {
                super(null);
                this.failureMessageStringRes = i;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = failure.failureMessageStringRes;
                }
                return failure.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public final Failure copy(int failureMessageStringRes) {
                return new Failure(failureMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Failure) && this.failureMessageStringRes == ((Failure) other).failureMessageStringRes;
                }
                return true;
            }

            public final int getFailureMessageStringRes() {
                return this.failureMessageStringRes;
            }

            public int hashCode() {
                return this.failureMessageStringRes;
            }

            public String toString() {
                return a.B(a.U("Failure(failureMessageStringRes="), this.failureMessageStringRes, ")");
            }
        }

        /* compiled from: PublishActionDialogViewModel.kt */
        public static final /* data */ class Success extends Event {
            private final int successMessageStringRes;

            public Success(int i) {
                super(null);
                this.successMessageStringRes = i;
            }

            public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = success.successMessageStringRes;
                }
                return success.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public final Success copy(int successMessageStringRes) {
                return new Success(successMessageStringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Success) && this.successMessageStringRes == ((Success) other).successMessageStringRes;
                }
                return true;
            }

            public final int getSuccessMessageStringRes() {
                return this.successMessageStringRes;
            }

            public int hashCode() {
                return this.successMessageStringRes;
            }

            public String toString() {
                return a.B(a.U("Success(successMessageStringRes="), this.successMessageStringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    public static final class StoreState {
        private final ModelChannelFollowerStats followerStats;

        public StoreState(ModelChannelFollowerStats modelChannelFollowerStats) {
            this.followerStats = modelChannelFollowerStats;
        }

        public final ModelChannelFollowerStats getFollowerStats() {
            return this.followerStats;
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: PublishActionDialogViewModel.kt */
        public static final /* data */ class LoadedHasFollowers extends ViewState {
            private final ModelChannelFollowerStats followerStats;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadedHasFollowers(ModelChannelFollowerStats modelChannelFollowerStats) {
                super(null);
                m.checkNotNullParameter(modelChannelFollowerStats, "followerStats");
                this.followerStats = modelChannelFollowerStats;
            }

            public static /* synthetic */ LoadedHasFollowers copy$default(LoadedHasFollowers loadedHasFollowers, ModelChannelFollowerStats modelChannelFollowerStats, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelChannelFollowerStats = loadedHasFollowers.followerStats;
                }
                return loadedHasFollowers.copy(modelChannelFollowerStats);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelChannelFollowerStats getFollowerStats() {
                return this.followerStats;
            }

            public final LoadedHasFollowers copy(ModelChannelFollowerStats followerStats) {
                m.checkNotNullParameter(followerStats, "followerStats");
                return new LoadedHasFollowers(followerStats);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LoadedHasFollowers) && m.areEqual(this.followerStats, ((LoadedHasFollowers) other).followerStats);
                }
                return true;
            }

            public final ModelChannelFollowerStats getFollowerStats() {
                return this.followerStats;
            }

            public int hashCode() {
                ModelChannelFollowerStats modelChannelFollowerStats = this.followerStats;
                if (modelChannelFollowerStats != null) {
                    return modelChannelFollowerStats.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("LoadedHasFollowers(followerStats=");
                sbU.append(this.followerStats);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: PublishActionDialogViewModel.kt */
        public static final class LoadedNoFollowers extends ViewState {
            public static final LoadedNoFollowers INSTANCE = new LoadedNoFollowers();

            private LoadedNoFollowers() {
                super(null);
            }
        }

        /* compiled from: PublishActionDialogViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$publishMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            PublishActionDialogViewModel.access$emitSuccessActionEvent(PublishActionDialogViewModel.this);
        }
    }

    /* compiled from: PublishActionDialogViewModel.kt */
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialogViewModel$publishMessage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            PublishActionDialogViewModel.access$emitFailureEvent(PublishActionDialogViewModel.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PublishActionDialogViewModel(long j, long j2, RestAPI restAPI, StoreChannelFollowerStats storeChannelFollowerStats, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreChannelFollowerStats channelFollowerStats = (i & 8) != 0 ? StoreStream.INSTANCE.getChannelFollowerStats() : storeChannelFollowerStats;
        this(j, j2, api, channelFollowerStats, (i & 16) != 0 ? Companion.access$observeChannelFollowerStatsStoreState(INSTANCE, j2, channelFollowerStats) : observable);
    }

    public static final /* synthetic */ void access$emitFailureEvent(PublishActionDialogViewModel publishActionDialogViewModel) {
        publishActionDialogViewModel.emitFailureEvent();
    }

    public static final /* synthetic */ void access$emitSuccessActionEvent(PublishActionDialogViewModel publishActionDialogViewModel) {
        publishActionDialogViewModel.emitSuccessActionEvent();
    }

    public static final /* synthetic */ void access$handleStoreState(PublishActionDialogViewModel publishActionDialogViewModel, StoreState storeState) {
        publishActionDialogViewModel.handleStoreState(storeState);
    }

    private final void emitFailureEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.Failure(R.string.default_failure_to_perform_action_message));
    }

    private final void emitSuccessActionEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.Success(R.string.message_published));
    }

    private final void handleStoreState(StoreState storeState) {
        Integer guildsFollowing;
        ModelChannelFollowerStats followerStats = storeState.getFollowerStats();
        int iIntValue = (followerStats == null || (guildsFollowing = followerStats.getGuildsFollowing()) == null) ? 0 : guildsFollowing.intValue();
        if ((followerStats != null ? followerStats.getGuildsFollowing() : null) == null || iIntValue <= 0) {
            updateViewState(ViewState.LoadedNoFollowers.INSTANCE);
        } else {
            updateViewState(new ViewState.LoadedHasFollowers(followerStats));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void publishMessage() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.crosspostMessage(this.channelId, Long.valueOf(this.messageId)), false, 1, null), this, null, 2, null), PublishActionDialogViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishActionDialogViewModel(long j, long j2, RestAPI restAPI, StoreChannelFollowerStats storeChannelFollowerStats, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeChannelFollowerStats, "storeChannelFollowerStats");
        m.checkNotNullParameter(observable, "storeObservable");
        this.messageId = j;
        this.channelId = j2;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        storeChannelFollowerStats.fetchChannelFollowerStats(j2);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), PublishActionDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
