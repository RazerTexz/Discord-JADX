package com.discord.widgets.user;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.guild.PruneCountResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* compiled from: WidgetPruneUsersViewModel.kt */
/* loaded from: classes.dex */
public final class WidgetPruneUsersViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PruneDays DEFAULT_DAYS = PruneDays.Thirty;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final String guildName;
    private Subscription pruneCountRequest;
    private final RestAPI restAPI;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUsers;
    private PruneDays whichPruneDays;

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<StoreData, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(StoreData storeData) {
            return call2(storeData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(StoreData storeData) {
            return Boolean.valueOf((storeData.getPermission() == null || storeData.getUser() == null || storeData.getGuild() == null || !PermissionUtils.canAndIsElevated(2L, storeData.getPermission(), storeData.getUser().getMfaEnabled(), storeData.getGuild().getMfaLevel())) ? false : true);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            m.checkNotNullExpressionValue(bool, "canKick");
            if (bool.booleanValue()) {
                WidgetPruneUsersViewModel.access$getUpdatedPruneCount(WidgetPruneUsersViewModel.this);
            } else {
                WidgetPruneUsersViewModel.access$updateViewState(WidgetPruneUsersViewModel.this, new ViewState.LoadFailed(true));
            }
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreData> observeStoreState(long guildId, ObservationDeck observationDeck, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreUser storeUsers) {
            m.checkNotNullParameter(observationDeck, "observationDeck");
            m.checkNotNullParameter(storePermissions, "storePermissions");
            m.checkNotNullParameter(storeGuilds, "storeGuilds");
            m.checkNotNullParameter(storeUsers, "storeUsers");
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storePermissions, storeGuilds, storeUsers}, false, null, null, new WidgetPruneUsersViewModel$Companion$observeStoreState$1(storePermissions, guildId, storeGuilds, storeUsers), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetPruneUsersViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* compiled from: WidgetPruneUsersViewModel.kt */
        public static final /* data */ class RestClientFailed extends Event {
            private final Throwable throwable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RestClientFailed(Throwable th) {
                super(null);
                m.checkNotNullParameter(th, "throwable");
                this.throwable = th;
            }

            public static /* synthetic */ RestClientFailed copy$default(RestClientFailed restClientFailed, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = restClientFailed.throwable;
                }
                return restClientFailed.copy(th);
            }

            /* renamed from: component1, reason: from getter */
            public final Throwable getThrowable() {
                return this.throwable;
            }

            public final RestClientFailed copy(Throwable throwable) {
                m.checkNotNullParameter(throwable, "throwable");
                return new RestClientFailed(throwable);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof RestClientFailed) && m.areEqual(this.throwable, ((RestClientFailed) other).throwable);
                }
                return true;
            }

            public final Throwable getThrowable() {
                return this.throwable;
            }

            public int hashCode() {
                Throwable th = this.throwable;
                if (th != null) {
                    return th.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("RestClientFailed(throwable=");
                sbU.append(this.throwable);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    public enum PruneDays {
        Seven(7),
        Thirty(30);

        private final int count;

        PruneDays(int i) {
            this.count = i;
        }

        public final int getCount() {
            return this.count;
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    public static final /* data */ class StoreData {
        private final Guild guild;
        private final Long permission;
        private final MeUser user;

        public StoreData(Long l, Guild guild, MeUser meUser) {
            this.permission = l;
            this.guild = guild;
            this.user = meUser;
        }

        public static /* synthetic */ StoreData copy$default(StoreData storeData, Long l, Guild guild, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                l = storeData.permission;
            }
            if ((i & 2) != 0) {
                guild = storeData.guild;
            }
            if ((i & 4) != 0) {
                meUser = storeData.user;
            }
            return storeData.copy(l, guild, meUser);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getPermission() {
            return this.permission;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final MeUser getUser() {
            return this.user;
        }

        public final StoreData copy(Long permission, Guild guild, MeUser user) {
            return new StoreData(permission, guild, user);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreData)) {
                return false;
            }
            StoreData storeData = (StoreData) other;
            return m.areEqual(this.permission, storeData.permission) && m.areEqual(this.guild, storeData.guild) && m.areEqual(this.user, storeData.user);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getPermission() {
            return this.permission;
        }

        public final MeUser getUser() {
            return this.user;
        }

        public int hashCode() {
            Long l = this.permission;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            MeUser meUser = this.user;
            return iHashCode2 + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreData(permission=");
            sbU.append(this.permission);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetPruneUsersViewModel.kt */
        public static final /* data */ class LoadFailed extends ViewState {
            private final boolean dismiss;

            public LoadFailed(boolean z2) {
                super(null);
                this.dismiss = z2;
            }

            public static /* synthetic */ LoadFailed copy$default(LoadFailed loadFailed, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loadFailed.dismiss;
                }
                return loadFailed.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getDismiss() {
                return this.dismiss;
            }

            public final LoadFailed copy(boolean dismiss) {
                return new LoadFailed(dismiss);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LoadFailed) && this.dismiss == ((LoadFailed) other).dismiss;
                }
                return true;
            }

            public final boolean getDismiss() {
                return this.dismiss;
            }

            public int hashCode() {
                boolean z2 = this.dismiss;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public String toString() {
                return a.O(a.U("LoadFailed(dismiss="), this.dismiss, ")");
            }
        }

        /* compiled from: WidgetPruneUsersViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final int pruneCount;
            private final PruneDays pruneDays;
            private final boolean pruneInProgress;

            public /* synthetic */ Loaded(PruneDays pruneDays, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(pruneDays, i, (i2 & 4) != 0 ? false : z2);
            }

            /* renamed from: component3, reason: from getter */
            private final boolean getPruneInProgress() {
                return this.pruneInProgress;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, PruneDays pruneDays, int i, boolean z2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    pruneDays = loaded.pruneDays;
                }
                if ((i2 & 2) != 0) {
                    i = loaded.pruneCount;
                }
                if ((i2 & 4) != 0) {
                    z2 = loaded.pruneInProgress;
                }
                return loaded.copy(pruneDays, i, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final PruneDays getPruneDays() {
                return this.pruneDays;
            }

            /* renamed from: component2, reason: from getter */
            public final int getPruneCount() {
                return this.pruneCount;
            }

            public final Loaded copy(PruneDays pruneDays, int pruneCount, boolean pruneInProgress) {
                m.checkNotNullParameter(pruneDays, "pruneDays");
                return new Loaded(pruneDays, pruneCount, pruneInProgress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return m.areEqual(this.pruneDays, loaded.pruneDays) && this.pruneCount == loaded.pruneCount && this.pruneInProgress == loaded.pruneInProgress;
            }

            public final boolean getPruneButtonEnabled() {
                return this.pruneCount > 0 && !this.pruneInProgress;
            }

            public final int getPruneCount() {
                return this.pruneCount;
            }

            public final PruneDays getPruneDays() {
                return this.pruneDays;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                PruneDays pruneDays = this.pruneDays;
                int iHashCode = (((pruneDays != null ? pruneDays.hashCode() : 0) * 31) + this.pruneCount) * 31;
                boolean z2 = this.pruneInProgress;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(pruneDays=");
                sbU.append(this.pruneDays);
                sbU.append(", pruneCount=");
                sbU.append(this.pruneCount);
                sbU.append(", pruneInProgress=");
                return a.O(sbU, this.pruneInProgress, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(PruneDays pruneDays, int i, boolean z2) {
                super(null);
                m.checkNotNullParameter(pruneDays, "pruneDays");
                this.pruneDays = pruneDays;
                this.pruneCount = i;
                this.pruneInProgress = z2;
            }
        }

        /* compiled from: WidgetPruneUsersViewModel.kt */
        public static final /* data */ class Loading extends ViewState {
            private final String guildName;
            private final PruneDays whichPruneDays;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(PruneDays pruneDays, String str) {
                super(null);
                m.checkNotNullParameter(pruneDays, "whichPruneDays");
                m.checkNotNullParameter(str, "guildName");
                this.whichPruneDays = pruneDays;
                this.guildName = str;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, PruneDays pruneDays, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    pruneDays = loading.whichPruneDays;
                }
                if ((i & 2) != 0) {
                    str = loading.guildName;
                }
                return loading.copy(pruneDays, str);
            }

            /* renamed from: component1, reason: from getter */
            public final PruneDays getWhichPruneDays() {
                return this.whichPruneDays;
            }

            /* renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            public final Loading copy(PruneDays whichPruneDays, String guildName) {
                m.checkNotNullParameter(whichPruneDays, "whichPruneDays");
                m.checkNotNullParameter(guildName, "guildName");
                return new Loading(whichPruneDays, guildName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                Loading loading = (Loading) other;
                return m.areEqual(this.whichPruneDays, loading.whichPruneDays) && m.areEqual(this.guildName, loading.guildName);
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final PruneDays getWhichPruneDays() {
                return this.whichPruneDays;
            }

            public int hashCode() {
                PruneDays pruneDays = this.whichPruneDays;
                int iHashCode = (pruneDays != null ? pruneDays.hashCode() : 0) * 31;
                String str = this.guildName;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Loading(whichPruneDays=");
                sbU.append(this.whichPruneDays);
                sbU.append(", guildName=");
                return a.J(sbU, this.guildName, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<PruneCountResponse, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Integer call(PruneCountResponse pruneCountResponse) {
            return call2(pruneCountResponse);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Integer call2(PruneCountResponse pruneCountResponse) {
            return Integer.valueOf(pruneCountResponse.getPruned());
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Integer, ViewState> {
        public AnonymousClass2() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ ViewState call(Integer num) {
            return call2(num);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ViewState call2(Integer num) {
            PruneDays pruneDaysAccess$getWhichPruneDays$p = WidgetPruneUsersViewModel.access$getWhichPruneDays$p(WidgetPruneUsersViewModel.this);
            m.checkNotNullExpressionValue(num, "count");
            return new ViewState.Loaded(pruneDaysAccess$getWhichPruneDays$p, num.intValue(), false, 4, null);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Throwable> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetPruneUsersViewModel.access$getEventSubject$p(WidgetPruneUsersViewModel.this);
            m.checkNotNullExpressionValue(th, "it");
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.RestClientFailed(th));
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements b<Throwable, ViewState> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ ViewState call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ViewState call2(Throwable th) {
            return new ViewState.LoadFailed(false);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "request");
            Subscription subscriptionAccess$getPruneCountRequest$p = WidgetPruneUsersViewModel.access$getPruneCountRequest$p(WidgetPruneUsersViewModel.this);
            if (subscriptionAccess$getPruneCountRequest$p != null) {
                subscriptionAccess$getPruneCountRequest$p.unsubscribe();
            }
            WidgetPruneUsersViewModel.access$setPruneCountRequest$p(WidgetPruneUsersViewModel.this, subscription);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$getUpdatedPruneCount$6, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass6 extends k implements Function1<ViewState, Unit> {
        public AnonymousClass6(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
            super(1, widgetPruneUsersViewModel, WidgetPruneUsersViewModel.class, "updateViewState", "updateViewState(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetPruneUsersViewModel.access$updateViewState((WidgetPruneUsersViewModel) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$1, reason: invalid class name */
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
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetPruneUsersViewModel.access$getEventSubject$p(WidgetPruneUsersViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Dismiss.INSTANCE);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$2, reason: invalid class name */
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
            WidgetPruneUsersViewModel.access$pruneInProgress(WidgetPruneUsersViewModel.this, false);
        }
    }

    /* compiled from: WidgetPruneUsersViewModel.kt */
    /* renamed from: com.discord.widgets.user.WidgetPruneUsersViewModel$pruneClicked$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetPruneUsersViewModel.access$getEventSubject$p(WidgetPruneUsersViewModel.this);
            Throwable throwable = error.getThrowable();
            m.checkNotNullExpressionValue(throwable, "it.throwable");
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.RestClientFailed(throwable));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetPruneUsersViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, String str, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str2;
        Observable observableObserveStoreState;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        if ((i & 8) != 0) {
            Guild guild = guilds.getGuilds().get(Long.valueOf(j));
            String name = guild != null ? guild.getName() : null;
            str2 = name == null ? "" : name;
        } else {
            str2 = str;
        }
        RestAPI api = (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 32) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableObserveStoreState = companion.observeStoreState(j, observationDeck, companion2.getPermissions(), companion2.getGuilds(), users);
        } else {
            observableObserveStoreState = observable;
        }
        this(j, guilds, users, str2, api, observableObserveStoreState);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.eventSubject;
    }

    public static final /* synthetic */ Subscription access$getPruneCountRequest$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.pruneCountRequest;
    }

    public static final /* synthetic */ void access$getUpdatedPruneCount(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        widgetPruneUsersViewModel.getUpdatedPruneCount();
    }

    public static final /* synthetic */ PruneDays access$getWhichPruneDays$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel) {
        return widgetPruneUsersViewModel.whichPruneDays;
    }

    public static final /* synthetic */ void access$pruneInProgress(WidgetPruneUsersViewModel widgetPruneUsersViewModel, boolean z2) {
        widgetPruneUsersViewModel.pruneInProgress(z2);
    }

    public static final /* synthetic */ void access$setPruneCountRequest$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel, Subscription subscription) {
        widgetPruneUsersViewModel.pruneCountRequest = subscription;
    }

    public static final /* synthetic */ void access$setWhichPruneDays$p(WidgetPruneUsersViewModel widgetPruneUsersViewModel, PruneDays pruneDays) {
        widgetPruneUsersViewModel.whichPruneDays = pruneDays;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetPruneUsersViewModel widgetPruneUsersViewModel, ViewState viewState) {
        widgetPruneUsersViewModel.updateViewState(viewState);
    }

    private final ViewState.Loading getLoadingState() {
        return new ViewState.Loading(this.whichPruneDays, this.guildName);
    }

    private final void getUpdatedPruneCount() {
        updateViewState(getLoadingState());
        Observable observableM = ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPruneCount(this.guildId, this.whichPruneDays.getCount()), false, 1, null).G(AnonymousClass1.INSTANCE).G(new AnonymousClass2()).t(new AnonymousClass3()).M(AnonymousClass4.INSTANCE);
        m.checkNotNullExpressionValue(observableM, "restAPI.getPruneCount(gu…Failed(dismiss = false) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM, this, null, 2, null), WidgetPruneUsersViewModel.class, (Context) null, new AnonymousClass5(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass6(this), 58, (Object) null);
    }

    private final void pruneInProgress(boolean inProgress) {
        ViewState.Loaded loadedCopy$default;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || (loadedCopy$default = ViewState.Loaded.copy$default(loaded, null, 0, inProgress, 3, null)) == null) {
            return;
        }
        updateViewState(loadedCopy$default);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void pruneClicked() {
        pruneInProgress(true);
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.pruneMembers(this.guildId, new RestAPIParams.PruneGuild(Integer.valueOf(this.whichPruneDays.getCount()), Boolean.FALSE)), false, 1, null), this, null, 2, null);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, WidgetPruneUsersViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, new AnonymousClass2(), anonymousClass1, 22, (Object) null);
    }

    public final void pruneDaysSelected(PruneDays days) {
        m.checkNotNullParameter(days, "days");
        this.whichPruneDays = days;
        getUpdatedPruneCount();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsersViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, String str, RestAPI restAPI, Observable<StoreData> observable) {
        super(new ViewState.Loading(DEFAULT_DAYS, str));
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUser, "storeUsers");
        m.checkNotNullParameter(str, "guildName");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observable, "storeDataObservable");
        this.guildId = j;
        this.storeGuilds = storeGuilds;
        this.storeUsers = storeUser;
        this.guildName = str;
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        ViewState viewState = getViewState();
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.user.WidgetPruneUsersViewModel.ViewState.Loading");
        this.whichPruneDays = ((ViewState.Loading) viewState).getWhichPruneDays();
        Observable observableR = observable.G(AnonymousClass1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "storeDataObservable\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetPruneUsersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
