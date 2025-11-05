package com.discord.widgets.guilds.leave;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: LeaveGuildDialogViewModel.kt */
/* loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final StoreLurking lurkingStore;
    private final RestAPI restAPI;

    /* compiled from: LeaveGuildDialogViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<StoreState, Unit> {
        public AnonymousClass1(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
            super(1, leaveGuildDialogViewModel, LeaveGuildDialogViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "p1");
            LeaveGuildDialogViewModel.access$handleStoreState((LeaveGuildDialogViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreGuilds storeGuilds, StoreLurking storeLurking) {
            return companion.observeStoreState(j, storeGuilds, storeLurking);
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds guildStore, StoreLurking lurkingStore) {
            Observable<StoreState> observableJ = Observable.j(guildStore.observeGuild(guildId), lurkingStore.isLurkingObs(guildId), LeaveGuildDialogViewModel$Companion$observeStoreState$1.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…urking)\n        }\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    public static abstract class Event {

        /* compiled from: LeaveGuildDialogViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: LeaveGuildDialogViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: LeaveGuildDialogViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final boolean isLurking;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2) {
                super(null);
                m.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.isLurking = z2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.isLurking;
                }
                return valid.copy(guild, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            public final Valid copy(Guild guild, boolean isLurking) {
                m.checkNotNullParameter(guild, "guild");
                return new Valid(guild, isLurking);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return m.areEqual(this.guild, valid.guild) && this.isLurking == valid.isLurking;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.isLurking;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public String toString() {
                StringBuilder sbU = a.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", isLurking=");
                return a.O(sbU, this.isLurking, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: LeaveGuildDialogViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: LeaveGuildDialogViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final Guild guild;
            private final boolean isLoading;
            private final boolean isLurking;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2, boolean z3) {
                super(null);
                m.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.isLoading = z2;
                this.isLurking = z3;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.isLoading;
                }
                if ((i & 4) != 0) {
                    z3 = valid.isLurking;
                }
                return valid.copy(guild, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsLoading() {
                return this.isLoading;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            public final Valid copy(Guild guild, boolean isLoading, boolean isLurking) {
                m.checkNotNullParameter(guild, "guild");
                return new Valid(guild, isLoading, isLurking);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return m.areEqual(this.guild, valid.guild) && this.isLoading == valid.isLoading && this.isLurking == valid.isLurking;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.isLoading;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.isLurking;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isLoading() {
                return this.isLoading;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public String toString() {
                StringBuilder sbU = a.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", isLoading=");
                sbU.append(this.isLoading);
                sbU.append(", isLurking=");
                return a.O(sbU, this.isLurking, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$1, reason: invalid class name */
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
            LeaveGuildDialogViewModel.access$onLeaveSucceeded(LeaveGuildDialogViewModel.this);
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LeaveGuildDialogViewModel.access$onLeaveFailed(LeaveGuildDialogViewModel.this);
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Void, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            LeaveGuildDialogViewModel.access$onLeaveSucceeded(LeaveGuildDialogViewModel.this);
        }
    }

    /* compiled from: LeaveGuildDialogViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Error, Unit> {
        public AnonymousClass4() {
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
            LeaveGuildDialogViewModel.access$onLeaveFailed(LeaveGuildDialogViewModel.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LeaveGuildDialogViewModel(long j, RestAPI restAPI, StoreLurking storeLurking, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreLurking lurking = (i & 4) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking;
        this(j, api, lurking, (i & 8) != 0 ? Companion.access$observeStoreState(INSTANCE, j, StoreStream.INSTANCE.getGuilds(), lurking) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(LeaveGuildDialogViewModel leaveGuildDialogViewModel, StoreState storeState) {
        leaveGuildDialogViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$onLeaveFailed(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
        leaveGuildDialogViewModel.onLeaveFailed();
    }

    public static final /* synthetic */ void access$onLeaveSucceeded(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
        leaveGuildDialogViewModel.onLeaveSucceeded();
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        boolean zIsLoading = valid != null ? valid.isLoading() : false;
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid2 = (StoreState.Valid) storeState;
            updateViewState(new ViewState.Valid(valid2.getGuild(), zIsLoading, valid2.isLurking()));
        } else if (m.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    @MainThread
    private final void onLeaveFailed() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, false, false, 5, null));
        }
    }

    @MainThread
    private final void onLeaveSucceeded() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Dismiss.INSTANCE);
    }

    @MainThread
    public final void leaveGuild() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, true, false, 5, null));
            if (valid.isLurking()) {
                this.lurkingStore.stopLurking(valid.getGuild().getId(), new AnonymousClass1(), new AnonymousClass2());
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), LeaveGuildDialogViewModel.class, (Context) null, (Function1) null, new AnonymousClass4(), (Function0) null, (Function0) null, new AnonymousClass3(), 54, (Object) null);
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveGuildDialogViewModel(long j, RestAPI restAPI, StoreLurking storeLurking, Observable<StoreState> observable) {
        super(null);
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(storeLurking, "lurkingStore");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        this.lurkingStore = storeLurking;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), LeaveGuildDialogViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
