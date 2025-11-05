package com.discord.widgets.settings.account;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.f0._Sequences2;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LOCATION = "Blocked Users List";
    public static final int VIEW_TYPE_BLOCKED_USER_ITEM = 0;
    private final PublishSubject<Event> eventSubject;
    private final RestAPI restAPI;

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$1, reason: invalid class name */
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
            WidgetSettingsBlockedUsersViewModel.access$handleStoreState(WidgetSettingsBlockedUsersViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(StoreUserRelationships storeUserRelationships, StoreUser storeUser) {
            Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Observable observableY = storeUserRelationships.observe().Y(new WidgetSettingsBlockedUsersViewModel2(storeUser));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeUserRelationships\n …          }\n            }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
        public static final /* data */ class ShowToast extends Event {
            private final int stringRes;

            public ShowToast(int i) {
                super(null);
                this.stringRes = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.stringRes;
                }
                return showToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getStringRes() {
                return this.stringRes;
            }

            public final ShowToast copy(int stringRes) {
                return new ShowToast(stringRes);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.stringRes == ((ShowToast) other).stringRes;
                }
                return true;
            }

            public final int getStringRes() {
                return this.stringRes;
            }

            public int hashCode() {
                return this.stringRes;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(stringRes="), this.stringRes, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    public static final /* data */ class Item implements MGRecyclerDataPayload {
        private final String key;
        private final int type;
        private final User user;

        public Item(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.key = String.valueOf(user.getId());
        }

        public static /* synthetic */ Item copy$default(Item item, User user, int i, Object obj) {
            if ((i & 1) != 0) {
                user = item.user;
            }
            return item.copy(user);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final Item copy(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new Item(user);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Item) && Intrinsics3.areEqual(this.user, ((Item) other).user);
            }
            return true;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            if (user != null) {
                return user.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Item(user=");
            sbU.append(this.user);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, ? extends User> map) {
            Intrinsics3.checkNotNullParameter(map, "users");
            this.users = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.users;
            }
            return storeState.copy(map);
        }

        public final Map<Long, User> component1() {
            return this.users;
        }

        public final StoreState copy(Map<Long, ? extends User> users) {
            Intrinsics3.checkNotNullParameter(users, "users");
            return new StoreState(users);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.users, ((StoreState) other).users);
            }
            return true;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Map<Long, User> map = this.users;
            if (map != null) {
                return map.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.M(outline.U("StoreState(users="), this.users, ")");
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<Item> items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Item> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "items");
                this.items = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.items;
                }
                return loaded.copy(list);
            }

            public final List<Item> component1() {
                return this.items;
            }

            public final Loaded copy(List<Item> items) {
                Intrinsics3.checkNotNullParameter(items, "items");
                return new Loaded(items);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.items, ((Loaded) other).items);
                }
                return true;
            }

            public final List<Item> getItems() {
                return this.items;
            }

            public int hashCode() {
                List<Item> list = this.items;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(items="), this.items, ")");
            }
        }

        /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$getItems$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends User>, Item> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Item invoke(Map.Entry<? extends Long, ? extends User> entry) {
            return invoke2((Map.Entry<Long, ? extends User>) entry);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Item invoke2(Map.Entry<Long, ? extends User> entry) {
            Intrinsics3.checkNotNullParameter(entry, "userEntry");
            return new Item(entry.getValue());
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$getItems$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Comparator<Item> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Item item, Item item2) {
            return compare2(item, item2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(Item item, Item item2) {
            return UserUtils.INSTANCE.compareUserNames(item.getUser(), item2.getUser());
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$onClickUnblock$1, reason: invalid class name */
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
            WidgetSettingsBlockedUsersViewModel.access$emitShowToastEvent(WidgetSettingsBlockedUsersViewModel.this, R.string.user_has_been_unblocked);
        }
    }

    /* compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$onClickUnblock$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
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
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetSettingsBlockedUsersViewModel.access$emitShowToastEvent(WidgetSettingsBlockedUsersViewModel.this, R.string.default_failure_to_perform_action_message);
        }
    }

    public WidgetSettingsBlockedUsersViewModel() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetSettingsBlockedUsersViewModel(Observable observable, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStores(companion2.getUserRelationships(), companion2.getUsers());
        }
        this(observable, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$emitShowToastEvent(WidgetSettingsBlockedUsersViewModel widgetSettingsBlockedUsersViewModel, int i) {
        widgetSettingsBlockedUsersViewModel.emitShowToastEvent(i);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetSettingsBlockedUsersViewModel widgetSettingsBlockedUsersViewModel, StoreState storeState) {
        widgetSettingsBlockedUsersViewModel.handleStoreState(storeState);
    }

    private final void emitShowToastEvent(@StringRes int stringRes) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowToast(stringRes));
    }

    private final List<Item> getItems(Map<Long, ? extends User> users) {
        return _Sequences2.toList(_Sequences2.sortedWith(_Sequences2.map(_Maps.asSequence(users), AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE));
    }

    private final void handleStoreState(StoreState storeState) {
        List<Item> items = getItems(storeState.getUsers());
        if (items.isEmpty()) {
            updateViewState(ViewState.Empty.INSTANCE);
        } else {
            updateViewState(new ViewState.Loaded(items));
        }
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickUnblock(long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.removeRelationship(LOCATION, userId), false, 1, null), this, null, 2, null), WidgetSettingsBlockedUsersViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsBlockedUsersViewModel(Observable<StoreState> observable, RestAPI restAPI) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetSettingsBlockedUsersViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
