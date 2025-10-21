package com.discord.widgets.servers.member_verification;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: MemberVerificationSuccessViewModel.kt */
/* loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    /* compiled from: MemberVerificationSuccessViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
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
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            MemberVerificationSuccessViewModel.access$handleStoreState(MemberVerificationSuccessViewModel.this, storeState);
        }
    }

    /* compiled from: MemberVerificationSuccessViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j) {
            return companion.observeStores(j);
        }

        private final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableJ = Observable.j(companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), companion.getGuilds().observeGuild(guildId), MemberVerificationSuccessViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…?.name,\n        )\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MemberVerificationSuccessViewModel.kt */
    public static abstract class Event {

        /* compiled from: MemberVerificationSuccessViewModel.kt */
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: MemberVerificationSuccessViewModel.kt */
        public static final class Success extends Event {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MemberVerificationSuccessViewModel.kt */
    public static final /* data */ class StoreState {
        private final String guildName;
        private final String lastSeen;

        public StoreState(String str, String str2) {
            this.lastSeen = str;
            this.guildName = str2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storeState.lastSeen;
            }
            if ((i & 2) != 0) {
                str2 = storeState.guildName;
            }
            return storeState.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLastSeen() {
            return this.lastSeen;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        public final StoreState copy(String lastSeen, String guildName) {
            return new StoreState(lastSeen, guildName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.lastSeen, storeState.lastSeen) && Intrinsics3.areEqual(this.guildName, storeState.guildName);
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final String getLastSeen() {
            return this.lastSeen;
        }

        public int hashCode() {
            String str = this.lastSeen;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.guildName;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(lastSeen=");
            sbU.append(this.lastSeen);
            sbU.append(", guildName=");
            return outline.J(sbU, this.guildName, ")");
        }
    }

    /* compiled from: MemberVerificationSuccessViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: MemberVerificationSuccessViewModel.kt */
        public static final class Acked extends ViewState {
            public static final Acked INSTANCE = new Acked();

            private Acked() {
                super(null);
            }
        }

        /* compiled from: MemberVerificationSuccessViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final String guildName;

            public Loaded(String str) {
                super(null);
                this.guildName = str;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.guildName;
                }
                return loaded.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            public final Loaded copy(String guildName) {
                return new Loaded(guildName);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.guildName, ((Loaded) other).guildName);
                }
                return true;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public int hashCode() {
                String str = this.guildName;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("Loaded(guildName="), this.guildName, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MemberVerificationSuccessViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$ackGuildJoinRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationSuccessViewModel.access$getEventSubject$p(MemberVerificationSuccessViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationSuccessViewModel.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$ackGuildJoinRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationSuccessViewModel.access$getEventSubject$p(MemberVerificationSuccessViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Success.INSTANCE);
        }
    }

    public /* synthetic */ MemberVerificationSuccessViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? Companion.access$observeStores(INSTANCE, j) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(MemberVerificationSuccessViewModel memberVerificationSuccessViewModel) {
        return memberVerificationSuccessViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(MemberVerificationSuccessViewModel memberVerificationSuccessViewModel, StoreState storeState) {
        memberVerificationSuccessViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState.getLastSeen() != null) {
            updateViewState(ViewState.Acked.INSTANCE);
        } else {
            updateViewState(new ViewState.Loaded(storeState.getGuildName()));
        }
    }

    public final void ackGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationSuccessViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationSuccessViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), MemberVerificationSuccessViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
