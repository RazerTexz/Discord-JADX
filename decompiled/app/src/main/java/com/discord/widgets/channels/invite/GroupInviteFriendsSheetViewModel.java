package com.discord.widgets.channels.invite;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter;
import d0.g0.w;
import d0.t.h0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* compiled from: GroupInviteFriendsSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_GROUP_MEMBERS = 10;
    private static final int MAX_GROUP_MEMBERS_STAFF = 25;
    private static final long SEARCH_DEBOUNCE_MILLIS = 150;
    private final long channelId;
    private final HashSet<User> checkedUsers;
    private StoreState currentStoreState;
    private final PublishSubject<Event> eventSubject;
    private final int maxNumMembers;
    private final BehaviorSubject<CharSequence> searchTextChangedPublisher;
    private final StoreUser storeUser;

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    /* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$1, reason: invalid class name */
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
            GroupInviteFriendsSheetViewModel.access$handleStoreState(GroupInviteFriendsSheetViewModel.this, storeState);
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    /* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<CharSequence, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
            invoke2(charSequence);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CharSequence charSequence) {
            GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel = GroupInviteFriendsSheetViewModel.this;
            m.checkNotNullExpressionValue(charSequence, "searchText");
            GroupInviteFriendsSheetViewModel.access$onSearch(groupInviteFriendsSheetViewModel, charSequence);
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ int access$getMaxNumMembers(Companion companion, StoreUser storeUser) {
            return companion.getMaxNumMembers(storeUser);
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreUserRelationships storeUserRelationships, StoreUser storeUser, StoreChannels storeChannels) {
            return companion.observeStoreState(j, storeUserRelationships, storeUser, storeChannels);
        }

        private final int getMaxNumMembers(StoreUser storeUser) {
            return UserUtils.INSTANCE.isStaff(storeUser.getMeSnapshot()) ? 25 : 10;
        }

        private final Observable<Map<Long, User>> observeFriends(StoreUserRelationships storeUserRelationships, StoreUser storeUser) {
            Observable observableY = storeUserRelationships.observeForType(1).Y(new GroupInviteFriendsSheetViewModel$Companion$observeFriends$1(storeUser));
            m.checkNotNullExpressionValue(observableY, "storeUserRelationships.o…ships.keys)\n            }");
            return observableY;
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreUserRelationships storeUserRelationships, StoreUser storeUser, StoreChannels storeChannels) {
            if (channelId == -1) {
                Observable observableG = observeFriends(storeUserRelationships, storeUser).G(GroupInviteFriendsSheetViewModel$Companion$observeStoreState$1.INSTANCE);
                m.checkNotNullExpressionValue(observableG, "observeFriends(storeUser…          )\n            }");
                return observableG;
            }
            Observable<StoreState> observableJ = Observable.j(storeChannels.observeChannel(channelId), observeFriends(storeUserRelationships, storeUser), GroupInviteFriendsSheetViewModel$Companion$observeStoreState$2.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable\n             …      )\n                }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static abstract class Event {

        /* compiled from: GroupInviteFriendsSheetViewModel.kt */
        public static final class ChannelFull extends Event {
            public static final ChannelFull INSTANCE = new ChannelFull();

            private ChannelFull() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Map<Long, User> friendUsersMap;

        public StoreState() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, ? extends User> map, Channel channel) {
            m.checkNotNullParameter(map, "friendUsersMap");
            this.friendUsersMap = map;
            this.channel = channel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.friendUsersMap;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            return storeState.copy(map, channel);
        }

        public final Map<Long, User> component1() {
            return this.friendUsersMap;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreState copy(Map<Long, ? extends User> friendUsersMap, Channel channel) {
            m.checkNotNullParameter(friendUsersMap, "friendUsersMap");
            return new StoreState(friendUsersMap, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.friendUsersMap, storeState.friendUsersMap) && m.areEqual(this.channel, storeState.channel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, User> getFriendUsersMap() {
            return this.friendUsersMap;
        }

        public int hashCode() {
            Map<Long, User> map = this.friendUsersMap;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Channel channel = this.channel;
            return iHashCode + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(friendUsersMap=");
            sbU.append(this.friendUsersMap);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ StoreState(Map map, Channel channel, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? h0.emptyMap() : map, (i & 2) != 0 ? null : channel);
        }
    }

    /* compiled from: GroupInviteFriendsSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final HashSet<User> checkedUsers;
        private final List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems;
        private final boolean showSearchIcon;

        public ViewState(HashSet<User> hashSet, List<GroupInviteFriendsSheetAdapter.FriendItem> list, boolean z2) {
            m.checkNotNullParameter(hashSet, "checkedUsers");
            m.checkNotNullParameter(list, "friendItems");
            this.checkedUsers = hashSet;
            this.friendItems = list;
            this.showSearchIcon = z2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, HashSet hashSet, List list, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                hashSet = viewState.checkedUsers;
            }
            if ((i & 2) != 0) {
                list = viewState.friendItems;
            }
            if ((i & 4) != 0) {
                z2 = viewState.showSearchIcon;
            }
            return viewState.copy(hashSet, list, z2);
        }

        public final HashSet<User> component1() {
            return this.checkedUsers;
        }

        public final List<GroupInviteFriendsSheetAdapter.FriendItem> component2() {
            return this.friendItems;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowSearchIcon() {
            return this.showSearchIcon;
        }

        public final ViewState copy(HashSet<User> checkedUsers, List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems, boolean showSearchIcon) {
            m.checkNotNullParameter(checkedUsers, "checkedUsers");
            m.checkNotNullParameter(friendItems, "friendItems");
            return new ViewState(checkedUsers, friendItems, showSearchIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.checkedUsers, viewState.checkedUsers) && m.areEqual(this.friendItems, viewState.friendItems) && this.showSearchIcon == viewState.showSearchIcon;
        }

        public final HashSet<User> getCheckedUsers() {
            return this.checkedUsers;
        }

        public final List<GroupInviteFriendsSheetAdapter.FriendItem> getFriendItems() {
            return this.friendItems;
        }

        public final boolean getShowSearchIcon() {
            return this.showSearchIcon;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            HashSet<User> hashSet = this.checkedUsers;
            int iHashCode = (hashSet != null ? hashSet.hashCode() : 0) * 31;
            List<GroupInviteFriendsSheetAdapter.FriendItem> list = this.friendItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.showSearchIcon;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(checkedUsers=");
            sbU.append(this.checkedUsers);
            sbU.append(", friendItems=");
            sbU.append(this.friendItems);
            sbU.append(", showSearchIcon=");
            return a.O(sbU, this.showSearchIcon, ")");
        }

        public /* synthetic */ ViewState(HashSet hashSet, List list, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(hashSet, list, (i & 4) != 0 ? true : z2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GroupInviteFriendsSheetViewModel(long j, StoreUser storeUser, int i, Observable observable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        storeUser = (i2 & 2) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        i = (i2 & 4) != 0 ? Companion.access$getMaxNumMembers(INSTANCE, storeUser) : i;
        if ((i2 & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = Companion.access$observeStoreState(companion, j, companion2.getUserRelationships(), storeUser, companion2.getChannels());
        }
        this(j, storeUser, i, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel, StoreState storeState) {
        groupInviteFriendsSheetViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$onSearch(GroupInviteFriendsSheetViewModel groupInviteFriendsSheetViewModel, CharSequence charSequence) {
        groupInviteFriendsSheetViewModel.onSearch(charSequence);
    }

    private final void emitChannelFullEvent() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ChannelFull.INSTANCE);
    }

    private final List<User> excludeUsersAlreadyInChannel(Map<Long, ? extends User> users, Channel channel) {
        Set set;
        List<com.discord.api.user.User> listZ;
        if (channel == null || (listZ = channel.z()) == null) {
            set = null;
        } else {
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listZ, 10));
            Iterator<T> it = listZ.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((com.discord.api.user.User) it.next()).getId()));
            }
            set = u.toSet(arrayList);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, ? extends User> entry : users.entrySet()) {
            boolean z2 = true;
            if (set != null && set.contains(entry.getKey())) {
                z2 = false;
            }
            if (z2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return u.toList(linkedHashMap.values());
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        this.currentStoreState = storeState;
        List<User> listExcludeUsersAlreadyInChannel = excludeUsersAlreadyInChannel(storeState.getFriendUsersMap(), storeState.getChannel());
        HashSet<User> hashSet = this.checkedUsers;
        ArrayList<GroupInviteFriendsSheetAdapter.FriendItem> arrayListCreateItems = GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(listExcludeUsersAlreadyInChannel, hashSet);
        ViewState viewState = getViewState();
        updateViewState(new ViewState(hashSet, arrayListCreateItems, viewState != null ? viewState.getShowSearchIcon() : true));
    }

    private final void onSearch(CharSequence searchText) {
        Collection<User> collectionValues = this.currentStoreState.getFriendUsersMap().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (w.contains((CharSequence) ((User) next).getUsername(), searchText, true)) {
                arrayList.add(next);
            }
        }
        HashSet<User> hashSet = this.checkedUsers;
        updateViewState(new ViewState(hashSet, GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(arrayList, hashSet), (searchText.length() == 0) && this.checkedUsers.isEmpty()));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onChangeUserChecked(User user, boolean isChecked) {
        m.checkNotNullParameter(user, "user");
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (!isChecked) {
                this.checkedUsers.remove(user);
            } else if (this.checkedUsers.size() < this.maxNumMembers) {
                this.checkedUsers.add(user);
            } else {
                emitChannelFullEvent();
            }
            List<GroupInviteFriendsSheetAdapter.FriendItem> friendItems = viewState.getFriendItems();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(friendItems, 10));
            Iterator<T> it = friendItems.iterator();
            while (it.hasNext()) {
                arrayList.add(((GroupInviteFriendsSheetAdapter.FriendItem) it.next()).getUser());
            }
            HashSet<User> hashSet = this.checkedUsers;
            updateViewState(ViewState.copy$default(viewState, hashSet, GroupInviteFriendsSheetAdapter.FriendItem.INSTANCE.createItems(arrayList, hashSet), false, 4, null));
        }
    }

    public final void onSearchTextChanged(CharSequence searchText) {
        m.checkNotNullParameter(searchText, "searchText");
        this.searchTextChangedPublisher.onNext(searchText);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupInviteFriendsSheetViewModel(long j, StoreUser storeUser, int i, Observable<StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.storeUser = storeUser;
        this.maxNumMembers = i;
        this.eventSubject = PublishSubject.k0();
        this.currentStoreState = new StoreState(null, null, 3, null);
        this.checkedUsers = new HashSet<>();
        BehaviorSubject<CharSequence> behaviorSubjectK0 = BehaviorSubject.k0();
        this.searchTextChangedPublisher = behaviorSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), GroupInviteFriendsSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<CharSequence> observableP = behaviorSubjectK0.p(150L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableP, "searchTextChangedPublish…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), GroupInviteFriendsSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
