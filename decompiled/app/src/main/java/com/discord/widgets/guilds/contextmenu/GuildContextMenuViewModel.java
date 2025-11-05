package com.discord.widgets.guilds.contextmenu;

import a0.a.a.b;
import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: GuildContextMenuViewModel.kt */
/* loaded from: classes2.dex */
public final class GuildContextMenuViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;
    private final Observable<StoreState> storeStateObservable;

    /* compiled from: GuildContextMenuViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(GuildContextMenuViewModel guildContextMenuViewModel) {
            super(1, guildContextMenuViewModel, GuildContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            GuildContextMenuViewModel.access$handleStoreState((GuildContextMenuViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreGuilds storeGuilds, StoreUser storeUser, StoreReadStates storeReadStates, StoreGuildSelected storeGuildSelected) {
            return companion.observeStoreState(j, storeGuilds, storeUser, storeReadStates, storeGuildSelected);
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds guildStore, StoreUser userStore, StoreReadStates readStateStore, StoreGuildSelected selectedGuildStore) {
            Observable<StoreState> observableH = Observable.h(guildStore.observeGuild(guildId), StoreUser.observeMe$default(userStore, false, 1, null), readStateStore.getIsUnread(guildId), selectedGuildStore.observeSelectedGuildId(), GuildContextMenuViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…      )\n        }\n      }");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    public static abstract class Event {

        /* compiled from: GuildContextMenuViewModel.kt */
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

    /* compiled from: GuildContextMenuViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: GuildContextMenuViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: GuildContextMenuViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final boolean isGuildUnread;
            private final long myUserId;
            private final long selectedGuildId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, long j, boolean z2, long j2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.myUserId = j;
                this.isGuildUnread = z2;
                this.selectedGuildId = j2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, long j, boolean z2, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    j = valid.myUserId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    z2 = valid.isGuildUnread;
                }
                boolean z3 = z2;
                if ((i & 8) != 0) {
                    j2 = valid.selectedGuildId;
                }
                return valid.copy(guild, j3, z3, j2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsGuildUnread() {
                return this.isGuildUnread;
            }

            /* renamed from: component4, reason: from getter */
            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            public final Valid copy(Guild guild, long myUserId, boolean isGuildUnread, long selectedGuildId) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild, myUserId, isGuildUnread, selectedGuildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && this.myUserId == valid.myUserId && this.isGuildUnread == valid.isGuildUnread && this.selectedGuildId == valid.selectedGuildId;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iA = (b.a(this.myUserId) + ((guild != null ? guild.hashCode() : 0) * 31)) * 31;
                boolean z2 = this.isGuildUnread;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return b.a(this.selectedGuildId) + ((iA + i) * 31);
            }

            public final boolean isGuildUnread() {
                return this.isGuildUnread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", isGuildUnread=");
                sbU.append(this.isGuildUnread);
                sbU.append(", selectedGuildId=");
                return outline.C(sbU, this.selectedGuildId, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: GuildContextMenuViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: GuildContextMenuViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final Guild guild;
            private final boolean isGuildSelected;
            private final boolean showLeaveGuild;
            private final boolean showMarkAsRead;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.showMarkAsRead = z2;
                this.showLeaveGuild = z3;
                this.isGuildSelected = z4;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.showMarkAsRead;
                }
                if ((i & 4) != 0) {
                    z3 = valid.showLeaveGuild;
                }
                if ((i & 8) != 0) {
                    z4 = valid.isGuildSelected;
                }
                return valid.copy(guild, z2, z3, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getShowLeaveGuild() {
                return this.showLeaveGuild;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsGuildSelected() {
                return this.isGuildSelected;
            }

            public final Valid copy(Guild guild, boolean showMarkAsRead, boolean showLeaveGuild, boolean isGuildSelected) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild, showMarkAsRead, showLeaveGuild, isGuildSelected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && this.showMarkAsRead == valid.showMarkAsRead && this.showLeaveGuild == valid.showLeaveGuild && this.isGuildSelected == valid.isGuildSelected;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getShowLeaveGuild() {
                return this.showLeaveGuild;
            }

            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.showMarkAsRead;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.showLeaveGuild;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isGuildSelected;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isGuildSelected() {
                return this.isGuildSelected;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", showMarkAsRead=");
                sbU.append(this.showMarkAsRead);
                sbU.append(", showLeaveGuild=");
                sbU.append(this.showLeaveGuild);
                sbU.append(", isGuildSelected=");
                return outline.O(sbU, this.isGuildSelected, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildContextMenuViewModel.kt */
    /* renamed from: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$onMarkAsReadClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = GuildContextMenuViewModel.access$getEventSubject$p(GuildContextMenuViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildContextMenuViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        restAPI = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, j, companion2.getGuilds(), companion2.getUsers(), companion2.getReadStates(), companion2.getGuildSelected());
        }
        this(j, restAPI, observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(GuildContextMenuViewModel guildContextMenuViewModel) {
        return guildContextMenuViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(GuildContextMenuViewModel guildContextMenuViewModel, StoreState storeState) {
        guildContextMenuViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            updateViewState(new ViewState.Valid(valid.getGuild(), valid.isGuildUnread(), valid.getGuild().getOwnerId() != valid.getMyUserId(), valid.getSelectedGuildId() == valid.getGuild().getId()));
        } else if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(this.guildId), false, 1, null), this, null, 2, null), GuildContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContextMenuViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GuildContextMenuViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
