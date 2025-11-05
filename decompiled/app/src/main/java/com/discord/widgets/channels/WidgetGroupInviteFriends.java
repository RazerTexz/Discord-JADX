package com.discord.widgets.channels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.WidgetGroupInviteFriendsBinding;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.internal.LinkedTreeMap;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetGroupInviteFriends.kt */
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGroupInviteFriends.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGroupInviteFriendsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final int MAX_GROUP_MEMBERS = 10;
    private static final int MAX_GROUP_MEMBERS_STAFF = 25;
    private static final long NO_CHANNEL_ID = -1;
    private static final int VIEW_INDEX_FRIENDS_LIST = 0;
    private static final int VIEW_INDEX_GROUP_FULL = 2;
    private static final int VIEW_INDEX_NO_FRIENDS = 1;
    private WidgetGroupInviteFriendsAdapter adapter;
    private final LinkedTreeMap<Long, User> addedUsers;
    private final BehaviorSubject<Collection<User>> addedUsersPublisher;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> filterPublisher;

    /* compiled from: WidgetGroupInviteFriends.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, String source) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("DM Group Create", source, null, 4, null);
            j.e(context, WidgetGroupInviteFriends.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void launch(Context context, long channelId, String source) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(source, "source");
            AnalyticsTracker.openModal$default("DM Group Add", source, null, 4, null);
            Intent intent = new Intent();
            intent.putExtra(WidgetGroupInviteFriends.INTENT_EXTRA_CHANNEL_ID, channelId);
            j.d(context, WidgetGroupInviteFriends.class, intent);
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int MODE_ADD = 1;
        public static final int MODE_CREATE = 0;
        private final Channel channel;
        private final String filterText;
        private final int maxGroupMemberCount;
        private final int mode;
        private final List<FriendItem> potentialAdditions;
        private final Collection<User> selectedUsers;

        /* compiled from: WidgetGroupInviteFriends.kt */
        public static final class Companion {

            /* compiled from: WidgetGroupInviteFriends.kt */
            public static final /* data */ class AddedUsersInput {
                private final Collection<User> addedUsers;
                private final String filter;

                /* JADX WARN: Multi-variable type inference failed */
                public AddedUsersInput(Collection<? extends User> collection, String str) {
                    m.checkNotNullParameter(collection, "addedUsers");
                    m.checkNotNullParameter(str, "filter");
                    this.addedUsers = collection;
                    this.filter = str;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ AddedUsersInput copy$default(AddedUsersInput addedUsersInput, Collection collection, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        collection = addedUsersInput.addedUsers;
                    }
                    if ((i & 2) != 0) {
                        str = addedUsersInput.filter;
                    }
                    return addedUsersInput.copy(collection, str);
                }

                public final Collection<User> component1() {
                    return this.addedUsers;
                }

                /* renamed from: component2, reason: from getter */
                public final String getFilter() {
                    return this.filter;
                }

                public final AddedUsersInput copy(Collection<? extends User> addedUsers, String filter) {
                    m.checkNotNullParameter(addedUsers, "addedUsers");
                    m.checkNotNullParameter(filter, "filter");
                    return new AddedUsersInput(addedUsers, filter);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AddedUsersInput)) {
                        return false;
                    }
                    AddedUsersInput addedUsersInput = (AddedUsersInput) other;
                    return m.areEqual(this.addedUsers, addedUsersInput.addedUsers) && m.areEqual(this.filter, addedUsersInput.filter);
                }

                public final Collection<User> getAddedUsers() {
                    return this.addedUsers;
                }

                public final String getFilter() {
                    return this.filter;
                }

                public int hashCode() {
                    Collection<User> collection = this.addedUsers;
                    int iHashCode = (collection != null ? collection.hashCode() : 0) * 31;
                    String str = this.filter;
                    return iHashCode + (str != null ? str.hashCode() : 0);
                }

                public String toString() {
                    StringBuilder sbU = a.U("AddedUsersInput(addedUsers=");
                    sbU.append(this.addedUsers);
                    sbU.append(", filter=");
                    return a.J(sbU, this.filter, ")");
                }
            }

            private Companion() {
            }

            public static final /* synthetic */ Observable access$getFilteredFriends(Companion companion, Collection collection, String str) {
                return companion.getFilteredFriends(collection, str);
            }

            @SuppressLint({"DefaultLocale"})
            private final Observable<ModelAppUserRelationship> getFilteredFriends(Collection<? extends User> oldExcludeUsers, String nameFilter) {
                if (oldExcludeUsers == null) {
                    oldExcludeUsers = n.emptyList();
                }
                Observable<ModelAppUserRelationship> observableY = Observable.B(oldExcludeUsers).G(WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1.INSTANCE).f0().A(new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$2(nameFilter)).Y(WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3.INSTANCE);
                m.checkNotNullExpressionValue(observableY, "Observable\n            .…          }\n            }");
                return observableY;
            }

            private final Observable<Model> getForAdd(long channelId, Observable<Collection<User>> addedUsersPublisher, Observable<String> filterPublisher) {
                Observable observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new WidgetGroupInviteFriends$Model$Companion$getForAdd$1(addedUsersPublisher, filterPublisher));
                m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                return observableY;
            }

            private final Observable<Model> getForCreate(Observable<Collection<User>> addedUsersPublisher, Observable<String> filterPublisher) {
                WidgetGroupInviteFriends$Model$Companion$getForCreate$1 widgetGroupInviteFriends$Model$Companion$getForCreate$1 = WidgetGroupInviteFriends$Model$Companion$getForCreate$1.INSTANCE;
                Object widgetGroupInviteFriends$sam$rx_functions_Func2$0 = widgetGroupInviteFriends$Model$Companion$getForCreate$1;
                if (widgetGroupInviteFriends$Model$Companion$getForCreate$1 != null) {
                    widgetGroupInviteFriends$sam$rx_functions_Func2$0 = new WidgetGroupInviteFriends$sam$rx_functions_Func2$0(widgetGroupInviteFriends$Model$Companion$getForCreate$1);
                }
                Observable<Model> observableY = Observable.j(addedUsersPublisher, filterPublisher, (Func2) widgetGroupInviteFriends$sam$rx_functions_Func2$0).Y(WidgetGroupInviteFriends$Model$Companion$getForCreate$2.INSTANCE);
                m.checkNotNullExpressionValue(observableY, "Observable\n            .…          }\n            }");
                return observableY;
            }

            public static /* synthetic */ void getMODE_CREATE$annotations() {
            }

            public final Observable<Model> get(long channelId, Observable<Collection<User>> addedUsersPublisher, Observable<String> filterPublisher) {
                m.checkNotNullParameter(addedUsersPublisher, "addedUsersPublisher");
                m.checkNotNullParameter(filterPublisher, "filterPublisher");
                return channelId == -1 ? getForCreate(addedUsersPublisher, filterPublisher) : getForAdd(channelId, addedUsersPublisher, filterPublisher);
            }

            public final Observable<? extends Collection<User>> getFriendChanges(Observable<Collection<User>> addedUsers) {
                m.checkNotNullParameter(addedUsers, "addedUsers");
                Observable<? extends Collection<User>> observableR = StoreStream.INSTANCE.getUserRelationships().observeForType(1).Y(new WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1(addedUsers)).r();
                m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetGroupInviteFriends.kt */
        public static final /* data */ class ModelAppUserRelationship {
            private final Map<Long, Presence> presences;
            private final Map<Long, Integer> relationships;
            private final Map<Long, ModelApplicationStream> streams;
            private final Map<Long, User> users;

            /* JADX WARN: Multi-variable type inference failed */
            public ModelAppUserRelationship(Map<Long, Integer> map, Map<Long, Presence> map2, Map<Long, ? extends User> map3, Map<Long, ? extends ModelApplicationStream> map4) {
                m.checkNotNullParameter(map, "relationships");
                m.checkNotNullParameter(map2, "presences");
                m.checkNotNullParameter(map3, "users");
                m.checkNotNullParameter(map4, "streams");
                this.relationships = map;
                this.presences = map2;
                this.users = map3;
                this.streams = map4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ModelAppUserRelationship copy$default(ModelAppUserRelationship modelAppUserRelationship, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = modelAppUserRelationship.relationships;
                }
                if ((i & 2) != 0) {
                    map2 = modelAppUserRelationship.presences;
                }
                if ((i & 4) != 0) {
                    map3 = modelAppUserRelationship.users;
                }
                if ((i & 8) != 0) {
                    map4 = modelAppUserRelationship.streams;
                }
                return modelAppUserRelationship.copy(map, map2, map3, map4);
            }

            public final Map<Long, Integer> component1() {
                return this.relationships;
            }

            public final Map<Long, Presence> component2() {
                return this.presences;
            }

            public final Map<Long, User> component3() {
                return this.users;
            }

            public final Map<Long, ModelApplicationStream> component4() {
                return this.streams;
            }

            public final ModelAppUserRelationship copy(Map<Long, Integer> relationships, Map<Long, Presence> presences, Map<Long, ? extends User> users, Map<Long, ? extends ModelApplicationStream> streams) {
                m.checkNotNullParameter(relationships, "relationships");
                m.checkNotNullParameter(presences, "presences");
                m.checkNotNullParameter(users, "users");
                m.checkNotNullParameter(streams, "streams");
                return new ModelAppUserRelationship(relationships, presences, users, streams);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ModelAppUserRelationship)) {
                    return false;
                }
                ModelAppUserRelationship modelAppUserRelationship = (ModelAppUserRelationship) other;
                return m.areEqual(this.relationships, modelAppUserRelationship.relationships) && m.areEqual(this.presences, modelAppUserRelationship.presences) && m.areEqual(this.users, modelAppUserRelationship.users) && m.areEqual(this.streams, modelAppUserRelationship.streams);
            }

            public final Map<Long, Presence> getPresences() {
                return this.presences;
            }

            public final Map<Long, Integer> getRelationships() {
                return this.relationships;
            }

            public final Map<Long, ModelApplicationStream> getStreams() {
                return this.streams;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                Map<Long, Integer> map = this.relationships;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                Map<Long, Presence> map2 = this.presences;
                int iHashCode2 = (iHashCode + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, User> map3 = this.users;
                int iHashCode3 = (iHashCode2 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, ModelApplicationStream> map4 = this.streams;
                return iHashCode3 + (map4 != null ? map4.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("ModelAppUserRelationship(relationships=");
                sbU.append(this.relationships);
                sbU.append(", presences=");
                sbU.append(this.presences);
                sbU.append(", users=");
                sbU.append(this.users);
                sbU.append(", streams=");
                return a.M(sbU, this.streams, ")");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, String str, Collection<? extends User> collection, List<FriendItem> list, int i, int i2) {
            m.checkNotNullParameter(collection, "selectedUsers");
            m.checkNotNullParameter(list, "potentialAdditions");
            this.channel = channel;
            this.filterText = str;
            this.selectedUsers = collection;
            this.potentialAdditions = list;
            this.mode = i;
            this.maxGroupMemberCount = i2;
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, String str, Collection collection, List list, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                channel = model.channel;
            }
            if ((i3 & 2) != 0) {
                str = model.filterText;
            }
            String str2 = str;
            if ((i3 & 4) != 0) {
                collection = model.selectedUsers;
            }
            Collection collection2 = collection;
            if ((i3 & 8) != 0) {
                list = model.potentialAdditions;
            }
            List list2 = list;
            if ((i3 & 16) != 0) {
                i = model.mode;
            }
            int i4 = i;
            if ((i3 & 32) != 0) {
                i2 = model.maxGroupMemberCount;
            }
            return model.copy(channel, str2, collection2, list2, i4, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFilterText() {
            return this.filterText;
        }

        public final Collection<User> component3() {
            return this.selectedUsers;
        }

        public final List<FriendItem> component4() {
            return this.potentialAdditions;
        }

        /* renamed from: component5, reason: from getter */
        public final int getMode() {
            return this.mode;
        }

        /* renamed from: component6, reason: from getter */
        public final int getMaxGroupMemberCount() {
            return this.maxGroupMemberCount;
        }

        public final Model copy(Channel channel, String filterText, Collection<? extends User> selectedUsers, List<FriendItem> potentialAdditions, int mode, int maxGroupMemberCount) {
            m.checkNotNullParameter(selectedUsers, "selectedUsers");
            m.checkNotNullParameter(potentialAdditions, "potentialAdditions");
            return new Model(channel, filterText, selectedUsers, potentialAdditions, mode, maxGroupMemberCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.channel, model.channel) && m.areEqual(this.filterText, model.filterText) && m.areEqual(this.selectedUsers, model.selectedUsers) && m.areEqual(this.potentialAdditions, model.potentialAdditions) && this.mode == model.mode && this.maxGroupMemberCount == model.maxGroupMemberCount;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final String getFilterText() {
            return this.filterText;
        }

        public final int getMaxGroupMemberCount() {
            return this.maxGroupMemberCount;
        }

        public final int getMode() {
            return this.mode;
        }

        public final List<FriendItem> getPotentialAdditions() {
            return this.potentialAdditions;
        }

        public final Collection<User> getSelectedUsers() {
            return this.selectedUsers;
        }

        public final int getTotalNumRecipients() {
            int size = this.selectedUsers.size() + 1;
            Channel channel = this.channel;
            if (channel == null) {
                return size;
            }
            List<com.discord.api.user.User> listZ = channel.z();
            return size + (listZ != null ? listZ.size() : 0);
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            String str = this.filterText;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            Collection<User> collection = this.selectedUsers;
            int iHashCode3 = (iHashCode2 + (collection != null ? collection.hashCode() : 0)) * 31;
            List<FriendItem> list = this.potentialAdditions;
            return ((((iHashCode3 + (list != null ? list.hashCode() : 0)) * 31) + this.mode) * 31) + this.maxGroupMemberCount;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", filterText=");
            sbU.append(this.filterText);
            sbU.append(", selectedUsers=");
            sbU.append(this.selectedUsers);
            sbU.append(", potentialAdditions=");
            sbU.append(this.potentialAdditions);
            sbU.append(", mode=");
            sbU.append(this.mode);
            sbU.append(", maxGroupMemberCount=");
            return a.B(sbU, this.maxGroupMemberCount, ")");
        }

        /* compiled from: WidgetGroupInviteFriends.kt */
        public static final /* data */ class FriendItem implements MGRecyclerDataPayload {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int TYPE_FRIEND = 0;
            private final boolean isApplicationStreaming;
            private final boolean isSelected;
            private final String key;
            private final Presence presence;
            private final int type;
            private final User user;

            /* compiled from: WidgetGroupInviteFriends.kt */
            public static final class Companion {
                private Companion() {
                }

                public final List<FriendItem> createData(ModelAppUserRelationship friends, Collection<? extends User> alreadyAddedUsers) {
                    m.checkNotNullParameter(friends, "friends");
                    m.checkNotNullParameter(alreadyAddedUsers, "alreadyAddedUsers");
                    ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(alreadyAddedUsers, 10));
                    Iterator<T> it = alreadyAddedUsers.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((User) it.next()).getId()));
                    }
                    Set set = u.toSet(arrayList);
                    Set<Long> setKeySet = friends.getUsers().keySet();
                    ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(setKeySet, 10));
                    Iterator<T> it2 = setKeySet.iterator();
                    while (it2.hasNext()) {
                        long jLongValue = ((Number) it2.next()).longValue();
                        arrayList2.add(new FriendItem(friends.getUsers().get(Long.valueOf(jLongValue)), friends.getPresences().get(Long.valueOf(jLongValue)), set.contains(Long.valueOf(jLongValue)), friends.getStreams().containsKey(Long.valueOf(jLongValue))));
                    }
                    return arrayList2;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public FriendItem() {
                this(null, null, false, false, 15, null);
            }

            public FriendItem(User user, Presence presence, boolean z2, boolean z3) {
                this.user = user;
                this.presence = presence;
                this.isSelected = z2;
                this.isApplicationStreaming = z3;
                this.key = String.valueOf(user != null ? Long.valueOf(user.getId()) : null);
            }

            public static /* synthetic */ FriendItem copy$default(FriendItem friendItem, User user, Presence presence, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = friendItem.user;
                }
                if ((i & 2) != 0) {
                    presence = friendItem.presence;
                }
                if ((i & 4) != 0) {
                    z2 = friendItem.isSelected;
                }
                if ((i & 8) != 0) {
                    z3 = friendItem.isApplicationStreaming;
                }
                return friendItem.copy(user, presence, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component2, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsSelected() {
                return this.isSelected;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final FriendItem copy(User user, Presence presence, boolean isSelected, boolean isApplicationStreaming) {
                return new FriendItem(user, presence, isSelected, isApplicationStreaming);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FriendItem)) {
                    return false;
                }
                FriendItem friendItem = (FriendItem) other;
                return m.areEqual(this.user, friendItem.user) && m.areEqual(this.presence, friendItem.presence) && this.isSelected == friendItem.isSelected && this.isApplicationStreaming == friendItem.isApplicationStreaming;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public final User getUser() {
                return this.user;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                Presence presence = this.presence;
                int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
                boolean z2 = this.isSelected;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode2 + i) * 31;
                boolean z3 = this.isApplicationStreaming;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isApplicationStreaming() {
                return this.isApplicationStreaming;
            }

            public final boolean isSelected() {
                return this.isSelected;
            }

            public String toString() {
                StringBuilder sbU = a.U("FriendItem(user=");
                sbU.append(this.user);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", isSelected=");
                sbU.append(this.isSelected);
                sbU.append(", isApplicationStreaming=");
                return a.O(sbU, this.isApplicationStreaming, ")");
            }

            public /* synthetic */ FriendItem(User user, Presence presence, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : user, (i & 2) != 0 ? null : presence, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
            }
        }

        public /* synthetic */ Model(Channel channel, String str, Collection collection, List list, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : channel, (i3 & 2) != 0 ? null : str, collection, list, (i3 & 16) != 0 ? 0 : i, i2);
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    public static final class UserDataContract implements ChipsView.a {
        private final String displayString;
        private final User modelUser;

        public UserDataContract(User user) {
            this.modelUser = user;
            this.displayString = user != null ? user.getUsername() : null;
        }

        @Override // com.discord.chips_view.ChipsView.a
        public String getDisplayString() {
            return this.displayString;
        }

        public final User getModelUser() {
            return this.modelUser;
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function2<User, Boolean, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(2);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Boolean bool) {
            invoke(user, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(User user, boolean z2) {
            m.checkNotNullParameter(user, "user");
            if (!z2) {
                WidgetGroupInviteFriends.access$unselectUser(WidgetGroupInviteFriends.this, user);
            } else if (this.$data.getTotalNumRecipients() >= this.$data.getMaxGroupMemberCount()) {
                b.a.d.m.i(WidgetGroupInviteFriends.this, R.string.group_dm_invite_full_sub, 0, 4);
            } else {
                WidgetGroupInviteFriends.access$selectUser(WidgetGroupInviteFriends.this, user);
            }
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<UserDataContract, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserDataContract userDataContract) {
            invoke2(userDataContract);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserDataContract userDataContract) {
            User modelUser;
            if (userDataContract == null || (modelUser = userDataContract.getModelUser()) == null) {
                return;
            }
            WidgetGroupInviteFriends.access$unselectUser(WidgetGroupInviteFriends.this, modelUser);
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function1<Object, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            WidgetGroupInviteFriends.access$getFilterPublisher$p(WidgetGroupInviteFriends.this).onNext(String.valueOf(obj));
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<Collection<? extends User>, Unit> {
        public AnonymousClass3(BehaviorSubject behaviorSubject) {
            super(1, behaviorSubject, BehaviorSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Collection<? extends User> collection) {
            invoke2(collection);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Collection<? extends User> collection) {
            ((BehaviorSubject) this.receiver).onNext(collection);
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends k implements Function1<Model, Unit> {
        public AnonymousClass4(WidgetGroupInviteFriends widgetGroupInviteFriends) {
            super(1, widgetGroupInviteFriends, WidgetGroupInviteFriends.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/WidgetGroupInviteFriends$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            WidgetGroupInviteFriends.access$configureUI((WidgetGroupInviteFriends) this.receiver, model);
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$setupFAB$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            b.a.d.m.g(WidgetGroupInviteFriends.this.getContext(), R.string.group_dm_invite_full_sub, 0, null, 12);
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$setupFAB$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        /* compiled from: WidgetGroupInviteFriends.kt */
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$setupFAB$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03652<T1, T2, R> implements Func2<Channel, Long, Pair<? extends Channel, ? extends Long>> {
            public static final C03652 INSTANCE = new C03652();

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Pair<? extends Channel, ? extends Long> call(Channel channel, Long l) {
                return call2(channel, l);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair<Channel, Long> call2(Channel channel, Long l) {
                return d0.o.to(channel, l);
            }
        }

        /* compiled from: WidgetGroupInviteFriends.kt */
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$setupFAB$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends d0.z.d.o implements Function1<Pair<? extends Channel, ? extends Long>, Unit> {

            /* compiled from: WidgetGroupInviteFriends.kt */
            /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$setupFAB$2$3$2, reason: invalid class name and collision with other inner class name */
            public static final class C03662 extends d0.z.d.o implements Function0<Unit> {
                public static final C03662 INSTANCE = new C03662();

                public C03662() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreStream.INSTANCE.getMediaEngine().selectVideoInputDevice(null);
                }
            }

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Channel, ? extends Long> pair) throws Exception {
                invoke2((Pair<Channel, Long>) pair);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Channel, Long> pair) throws Exception {
                Channel channelComponent1 = pair.component1();
                Long lComponent2 = pair.component2();
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, channelComponent1.getId(), null, null, 12, null);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreTabsNavigation.selectHomeTab$default(companion.getTabsNavigation(), StoreNavigation.PanelAction.CLOSE, false, 2, null);
                Channel channel = AnonymousClass2.this.$data.getChannel();
                if (m.areEqual(lComponent2, channel != null ? Long.valueOf(channel.getId()) : null)) {
                    Channel channel2 = AnonymousClass2.this.$data.getChannel();
                    if (channel2 == null || !ChannelUtils.z(channel2)) {
                        companion.getVoiceChannelSelected().clear();
                        StoreCalls calls = companion.getCalls();
                        WidgetGroupInviteFriends widgetGroupInviteFriends = WidgetGroupInviteFriends.this;
                        Context contextRequireContext = widgetGroupInviteFriends.requireContext();
                        FragmentManager parentFragmentManager = WidgetGroupInviteFriends.this.getParentFragmentManager();
                        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        calls.call(widgetGroupInviteFriends, contextRequireContext, parentFragmentManager, channelComponent1.getId(), C03662.INSTANCE);
                    } else {
                        StoreCalls calls2 = companion.getCalls();
                        long id2 = channelComponent1.getId();
                        Collection<User> selectedUsers = AnonymousClass2.this.$data.getSelectedUsers();
                        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(selectedUsers, 10));
                        Iterator<T> it = selectedUsers.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Long.valueOf(((User) it.next()).getId()));
                        }
                        calls2.ring(id2, arrayList);
                    }
                }
                AppActivity appActivity = WidgetGroupInviteFriends.this.getAppActivity();
                if (appActivity != null) {
                    appActivity.onBackPressed();
                }
            }
        }

        public AnonymousClass2(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable<Channel> observableCreateGroupDM;
            if (this.$data.getChannel() != null) {
                observableCreateGroupDM = RestAPI.INSTANCE.getApi().addGroupRecipients(this.$data.getChannel().getId(), u.toList(this.$data.getSelectedUsers()));
            } else if (this.$data.getSelectedUsers().size() == 1) {
                observableCreateGroupDM = RestAPI.INSTANCE.getApi().createOrFetchDM(((User) u.first(this.$data.getSelectedUsers())).getId());
            } else {
                RestAPI api = RestAPI.INSTANCE.getApi();
                Collection<User> selectedUsers = this.$data.getSelectedUsers();
                ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(selectedUsers, 10));
                Iterator<T> it = selectedUsers.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((User) it.next()).getId()));
                }
                observableCreateGroupDM = api.createGroupDM(arrayList);
            }
            Observable observableJ = Observable.j(observableCreateGroupDM, ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId(), 0L, false, 3, null), C03652.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…dVoiceChannelId\n        }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableJ, WidgetGroupInviteFriends.this, null, 2, null), WidgetGroupInviteFriends.this.getClass(), WidgetGroupInviteFriends.this.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 60, (Object) null);
        }
    }

    public WidgetGroupInviteFriends() {
        super(R.layout.widget_group_invite_friends);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGroupInviteFriends$binding$2.INSTANCE, null, 2, null);
        this.addedUsers = new LinkedTreeMap<>();
        this.filterPublisher = BehaviorSubject.l0("");
        this.addedUsersPublisher = BehaviorSubject.l0(new ArrayList());
    }

    public static final /* synthetic */ void access$configureUI(WidgetGroupInviteFriends widgetGroupInviteFriends, Model model) throws Resources.NotFoundException {
        widgetGroupInviteFriends.configureUI(model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetGroupInviteFriends widgetGroupInviteFriends) {
        return widgetGroupInviteFriends.filterPublisher;
    }

    public static final /* synthetic */ void access$selectUser(WidgetGroupInviteFriends widgetGroupInviteFriends, User user) {
        widgetGroupInviteFriends.selectUser(user);
    }

    public static final /* synthetic */ void access$unselectUser(WidgetGroupInviteFriends widgetGroupInviteFriends, User user) {
        widgetGroupInviteFriends.unselectUser(user);
    }

    private final void configureUI(Model data) throws Resources.NotFoundException {
        int size;
        List<com.discord.api.user.User> listZ;
        if (data == null || (data.getMode() == 1 && data.getChannel() == null)) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<User> it = data.getSelectedUsers().iterator();
        while (true) {
            size = 0;
            if (!it.hasNext()) {
                break;
            }
            User next = it.next();
            getBinding().f2406b.b(next.getUsername(), b.k(this, R.string.remove_role_or_user, new Object[]{next.getUsername()}, null, 4).toString(), Long.valueOf(next.getId()), new UserDataContract(next));
            hashSet.add(Long.valueOf(next.getId()));
        }
        String filterText = data.getFilterText();
        if (filterText != null) {
            if (filterText.length() > 0) {
                if (getBinding().f2406b.getText().length() == 0) {
                    getBinding().f2406b.setText(data.getFilterText());
                }
            }
        }
        getBinding().f2406b.d(hashSet);
        List<Model.FriendItem> potentialAdditions = data.getPotentialAdditions();
        Channel channel = data.getChannel();
        if (channel != null && (listZ = channel.z()) != null) {
            size = listZ.size();
        }
        AppViewFlipper appViewFlipper = getBinding().f;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.groupInviteFriendsViewFlipper");
        appViewFlipper.setDisplayedChild(getChildToDisplay(data.getMaxGroupMemberCount(), 1 + size, potentialAdditions));
        WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter = this.adapter;
        if (widgetGroupInviteFriendsAdapter != null) {
            widgetGroupInviteFriendsAdapter.setData(potentialAdditions, new AnonymousClass1(data));
        }
        setupFAB(data);
        setupToolbar(data);
    }

    private final WidgetGroupInviteFriendsBinding getBinding() {
        return (WidgetGroupInviteFriendsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getChildToDisplay(int maxGroupSize, int numRecipients, List<Model.FriendItem> potentialAdditions) {
        if (numRecipients >= maxGroupSize) {
            return 2;
        }
        return potentialAdditions == null || potentialAdditions.isEmpty() ? 1 : 0;
    }

    private final void selectUser(User user) {
        getBinding().f2406b.b(user.getUsername(), b.k(this, R.string.remove_role_or_user, new Object[]{user.getUsername()}, null, 4).toString(), Long.valueOf(user.getId()), new UserDataContract(user));
        this.addedUsers.put(Long.valueOf(user.getId()), user);
        this.addedUsersPublisher.onNext(new ArrayList(this.addedUsers.values()));
    }

    @SuppressLint({"RestrictedApi"})
    private final void setupFAB(Model data) {
        if (!(!data.getSelectedUsers().isEmpty())) {
            FloatingActionButton floatingActionButton = getBinding().e;
            m.checkNotNullExpressionValue(floatingActionButton, "binding.groupInviteFriendsSaveFab");
            floatingActionButton.setVisibility(8);
            return;
        }
        FloatingActionButton floatingActionButton2 = getBinding().e;
        m.checkNotNullExpressionValue(floatingActionButton2, "binding.groupInviteFriendsSaveFab");
        floatingActionButton2.setVisibility(0);
        if (data.getTotalNumRecipients() > data.getMaxGroupMemberCount()) {
            getBinding().e.setOnClickListener(new AnonymousClass1());
        } else {
            getBinding().e.setOnClickListener(new AnonymousClass2(data));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void setupToolbar(Model data) throws Resources.NotFoundException {
        CharSequence quantityString;
        if (data.getChannel() != null) {
            setActionBarTitle(b.k(this, R.string.group_dm_invite_with_name, new Object[]{ChannelUtils.e(data.getChannel(), requireContext(), false, 2)}, null, 4));
        } else {
            setActionBarTitle(getString(R.string.invite_friend_modal_title));
        }
        if (data.getChannel() == null) {
            int maxGroupMemberCount = data.getMaxGroupMemberCount() - data.getTotalNumRecipients();
            if (maxGroupMemberCount > 0) {
                Resources resources = getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R.plurals.group_dm_invite_remaining_number, maxGroupMemberCount, Integer.valueOf(maxGroupMemberCount));
            } else if (maxGroupMemberCount == 0) {
                quantityString = getString(R.string.group_dm_invite_will_fill_mobile);
                m.checkNotNullExpressionValue(quantityString, "getString(R.string.group…_invite_will_fill_mobile)");
            } else {
                int i = maxGroupMemberCount * (-1);
                Resources resources2 = getResources();
                m.checkNotNullExpressionValue(resources2, "resources");
                quantityString = StringResourceUtilsKt.getQuantityString(resources2, requireContext(), R.plurals.group_dm_invite_unselect_users_number, i, Integer.valueOf(i));
            }
            RelativeLayout relativeLayout = getBinding().c;
            m.checkNotNullExpressionValue(relativeLayout, "binding.groupInviteFriendsRecipientsContainer");
            relativeLayout.setVisibility(0);
        } else {
            List<com.discord.api.user.User> listZ = data.getChannel().z();
            if ((listZ != null ? listZ.size() : 1) >= data.getMaxGroupMemberCount()) {
                quantityString = getString(R.string.group_dm_invite_full_main);
                m.checkNotNullExpressionValue(quantityString, "getString(R.string.group_dm_invite_full_main)");
                RelativeLayout relativeLayout2 = getBinding().c;
                m.checkNotNullExpressionValue(relativeLayout2, "binding.groupInviteFriendsRecipientsContainer");
                relativeLayout2.setVisibility(8);
            }
        }
        setActionBarSubtitle(quantityString);
    }

    private final void unselectUser(User user) {
        this.addedUsers.remove(Long.valueOf(user.getId()));
        this.addedUsersPublisher.onNext(new ArrayList(this.addedUsers.values()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.groupInviteFriendsRecycler");
        this.adapter = (WidgetGroupInviteFriendsAdapter) companion.configure(new WidgetGroupInviteFriendsAdapter(recyclerView));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        ChipsView chipsView = getBinding().f2406b;
        Objects.requireNonNull(chipsView, "null cannot be cast to non-null type com.discord.chips_view.ChipsView<kotlin.Long, com.discord.widgets.channels.WidgetGroupInviteFriends.UserDataContract>");
        chipsView.setChipDeletedListener(new AnonymousClass1());
        getBinding().f2406b.setTextChangedListener(new AnonymousClass2());
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Collection<User>> behaviorSubject = this.addedUsersPublisher;
        m.checkNotNullExpressionValue(behaviorSubject, "addedUsersPublisher");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(companion.getFriendChanges(behaviorSubject), this, this.adapter), WidgetGroupInviteFriends.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this.addedUsersPublisher), 62, (Object) null);
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L);
        BehaviorSubject<Collection<User>> behaviorSubject2 = this.addedUsersPublisher;
        m.checkNotNullExpressionValue(behaviorSubject2, "addedUsersPublisher");
        BehaviorSubject<String> behaviorSubject3 = this.filterPublisher;
        m.checkNotNullExpressionValue(behaviorSubject3, "filterPublisher");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(companion.get(longExtra, behaviorSubject2, behaviorSubject3), this, this.adapter), WidgetGroupInviteFriends.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(this), 62, (Object) null);
    }
}
