package com.discord.widgets.friends;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetAddFriendUserListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetFriendsAddUserAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter extends MGRecyclerAdapterSimple<ItemUser> {
    private static final int TYPE_USER = 1;
    private Function1<? super Long, Unit> acceptHandler;
    private Function2<? super Long, ? super Boolean, Unit> declineHandler;
    private final HashSet<Long> incomingRequestUserIds;
    private Function1<? super Long, Unit> onItemClick;
    private final HashSet<Long> outgoingRequestUserIds;
    private Function2<? super String, ? super Integer, Unit> sendHandler;

    /* compiled from: WidgetFriendsAddUserAdapter.kt */
    public static final class UserViewHolder extends MGRecyclerViewHolder<WidgetFriendsAddUserAdapter, ItemUser> {
        private final WidgetAddFriendUserListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserViewHolder(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
            super(C5419R.layout.widget_add_friend_user_list_item, widgetFriendsAddUserAdapter);
            Intrinsics3.checkNotNullParameter(widgetFriendsAddUserAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.add_friend_user_accept_button;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.add_friend_user_accept_button);
            if (appCompatImageView != null) {
                i = C5419R.id.add_friend_user_check_image;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(C5419R.id.add_friend_user_check_image);
                if (appCompatImageView2 != null) {
                    i = C5419R.id.add_friend_user_decline_button;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(C5419R.id.add_friend_user_decline_button);
                    if (appCompatImageView3 != null) {
                        i = C5419R.id.add_friend_user_item_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.add_friend_user_item_avatar);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.add_friend_user_item_buttons;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.add_friend_user_item_buttons);
                            if (linearLayout != null) {
                                i = C5419R.id.add_friend_user_item_name;
                                TextView textView = (TextView) view.findViewById(C5419R.id.add_friend_user_item_name);
                                if (textView != null) {
                                    i = C5419R.id.add_friend_user_item_name_secondary;
                                    TextView textView2 = (TextView) view.findViewById(C5419R.id.add_friend_user_item_name_secondary);
                                    if (textView2 != null) {
                                        i = C5419R.id.add_friend_user_item_status;
                                        StatusView statusView = (StatusView) view.findViewById(C5419R.id.add_friend_user_item_status);
                                        if (statusView != null) {
                                            i = C5419R.id.add_friend_user_item_text;
                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.add_friend_user_item_text);
                                            if (linearLayout2 != null) {
                                                i = C5419R.id.add_friend_user_send_button;
                                                AppCompatImageView appCompatImageView4 = (AppCompatImageView) view.findViewById(C5419R.id.add_friend_user_send_button);
                                                if (appCompatImageView4 != null) {
                                                    WidgetAddFriendUserListItemBinding widgetAddFriendUserListItemBinding = new WidgetAddFriendUserListItemBinding((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, simpleDraweeView, linearLayout, textView, textView2, statusView, linearLayout2, appCompatImageView4);
                                                    Intrinsics3.checkNotNullExpressionValue(widgetAddFriendUserListItemBinding, "WidgetAddFriendUserListItemBinding.bind(itemView)");
                                                    this.binding = widgetAddFriendUserListItemBinding;
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetFriendsAddUserAdapter access$getAdapter$p(UserViewHolder userViewHolder) {
            return (WidgetFriendsAddUserAdapter) userViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ItemUser itemUser) {
            onConfigure2(i, itemUser);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ItemUser data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            User user = data.getUser();
            SimpleDraweeView simpleDraweeView = this.binding.f15638e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.addFriendUserItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, 0, null, null, null, 60, null);
            TextView textView = this.binding.f15639f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.addFriendUserItemName");
            CharSequence username = (CharSequence) _Collections.lastOrNull((List) data.getAliases());
            if (username == null) {
                username = user.getUsername();
            }
            textView.setText(username);
            TextView textView2 = this.binding.f15640g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.addFriendUserItemNameSecondary");
            textView2.setText(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            this.binding.f15641h.setPresence(data.getPresence());
            StatusView statusView = this.binding.f15641h;
            Intrinsics3.checkNotNullExpressionValue(statusView, "binding.addFriendUserItemStatus");
            boolean z2 = true;
            statusView.setVisibility(data.getPresence() != null ? 0 : 8);
            long id2 = data.getUser().getId();
            boolean zContains = WidgetFriendsAddUserAdapter.access$getOutgoingRequestUserIds$p((WidgetFriendsAddUserAdapter) this.adapter).contains(Long.valueOf(id2));
            boolean zContains2 = WidgetFriendsAddUserAdapter.access$getIncomingRequestUserIds$p((WidgetFriendsAddUserAdapter) this.adapter).contains(Long.valueOf(id2));
            this.binding.f15635b.setOnClickListener(new WidgetFriendsAddUserAdapter2(this, id2));
            this.binding.f15637d.setOnClickListener(new WidgetFriendsAddUserAdapter3(this, id2, zContains2));
            this.binding.f15642i.setOnClickListener(new WidgetFriendsAddUserAdapter4(this, user));
            this.binding.f15634a.setOnClickListener(new WidgetFriendsAddUserAdapter5(this, id2));
            AppCompatImageView appCompatImageView = this.binding.f15636c;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.addFriendUserCheckImage");
            appCompatImageView.setVisibility(data.isFriend() ? 0 : 8);
            AppCompatImageView appCompatImageView2 = this.binding.f15642i;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.addFriendUserSendButton");
            appCompatImageView2.setVisibility(!data.isFriend() && !zContains && !zContains2 ? 0 : 8);
            AppCompatImageView appCompatImageView3 = this.binding.f15635b;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageView3, "binding.addFriendUserAcceptButton");
            appCompatImageView3.setVisibility(!data.isFriend() && zContains2 ? 0 : 8);
            AppCompatImageView appCompatImageView4 = this.binding.f15637d;
            Intrinsics3.checkNotNullExpressionValue(appCompatImageView4, "binding.addFriendUserDeclineButton");
            if (data.isFriend() || (!zContains && !zContains2)) {
                z2 = false;
            }
            appCompatImageView4.setVisibility(z2 ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddUserAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.outgoingRequestUserIds = new HashSet<>();
        this.incomingRequestUserIds = new HashSet<>();
        this.onItemClick = WidgetFriendsAddUserAdapter6.INSTANCE;
    }

    public static final /* synthetic */ Function1 access$getAcceptHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.acceptHandler;
    }

    public static final /* synthetic */ Function2 access$getDeclineHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.declineHandler;
    }

    public static final /* synthetic */ HashSet access$getIncomingRequestUserIds$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.incomingRequestUserIds;
    }

    public static final /* synthetic */ Function1 access$getOnItemClick$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.onItemClick;
    }

    public static final /* synthetic */ HashSet access$getOutgoingRequestUserIds$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.outgoingRequestUserIds;
    }

    public static final /* synthetic */ Function2 access$getSendHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.sendHandler;
    }

    public static final /* synthetic */ void access$setAcceptHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function1 function1) {
        widgetFriendsAddUserAdapter.acceptHandler = function1;
    }

    public static final /* synthetic */ void access$setDeclineHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function2 function2) {
        widgetFriendsAddUserAdapter.declineHandler = function2;
    }

    public static final /* synthetic */ void access$setOnItemClick$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function1 function1) {
        widgetFriendsAddUserAdapter.onItemClick = function1;
    }

    public static final /* synthetic */ void access$setSendHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function2 function2) {
        widgetFriendsAddUserAdapter.sendHandler = function2;
    }

    public final void addFriendRequestUserIds(Collection<Long> outgoingIds, Collection<Long> incomingIds) {
        Intrinsics3.checkNotNullParameter(outgoingIds, "outgoingIds");
        Intrinsics3.checkNotNullParameter(incomingIds, "incomingIds");
        this.outgoingRequestUserIds.clear();
        this.outgoingRequestUserIds.addAll(outgoingIds);
        this.incomingRequestUserIds.clear();
        this.incomingRequestUserIds.addAll(incomingIds);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setAcceptHandler(Function1<? super Long, Unit> handler) {
        Intrinsics3.checkNotNullParameter(handler, "handler");
        this.acceptHandler = handler;
    }

    public final void setDeclineHandler(Function2<? super Long, ? super Boolean, Unit> handler) {
        Intrinsics3.checkNotNullParameter(handler, "handler");
        this.declineHandler = handler;
    }

    public final void setOnItemClick(Function1<? super Long, Unit> onItemClick) {
        Intrinsics3.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
    }

    public final void setSendHandler(Function2<? super String, ? super Integer, Unit> handler) {
        Intrinsics3.checkNotNullParameter(handler, "handler");
        this.sendHandler = handler;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new UserViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: WidgetFriendsAddUserAdapter.kt */
    public static final /* data */ class ItemUser implements MGRecyclerDataPayload {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<CharSequence> aliases;
        private final boolean isFriend;
        private final String key;
        private final Presence presence;
        private final int type;
        private final User user;

        /* compiled from: WidgetFriendsAddUserAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ItemUser create(WidgetGlobalSearchModel.ItemUser item) {
                Intrinsics3.checkNotNullParameter(item, "item");
                return new ItemUser(item.getUser(), item.getAliases(), item.getPresence(), item.isFriend());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ItemUser(User user, List<? extends CharSequence> list, Presence presence, boolean z2) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(list, "aliases");
            this.user = user;
            this.aliases = list;
            this.presence = presence;
            this.isFriend = z2;
            this.type = 1;
            this.key = String.valueOf(user.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ItemUser copy$default(ItemUser itemUser, User user, List list, Presence presence, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = itemUser.user;
            }
            if ((i & 2) != 0) {
                list = itemUser.aliases;
            }
            if ((i & 4) != 0) {
                presence = itemUser.presence;
            }
            if ((i & 8) != 0) {
                z2 = itemUser.isFriend;
            }
            return itemUser.copy(user, list, presence, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final List<CharSequence> component2() {
            return this.aliases;
        }

        /* renamed from: component3, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsFriend() {
            return this.isFriend;
        }

        public final ItemUser copy(User user, List<? extends CharSequence> aliases, Presence presence, boolean isFriend) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(aliases, "aliases");
            return new ItemUser(user, aliases, presence, isFriend);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemUser)) {
                return false;
            }
            ItemUser itemUser = (ItemUser) other;
            return Intrinsics3.areEqual(this.user, itemUser.user) && Intrinsics3.areEqual(this.aliases, itemUser.aliases) && Intrinsics3.areEqual(this.presence, itemUser.presence) && this.isFriend == itemUser.isFriend;
        }

        public final List<CharSequence> getAliases() {
            return this.aliases;
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
            List<CharSequence> list = this.aliases;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Presence presence = this.presence;
            int iHashCode3 = (iHashCode2 + (presence != null ? presence.hashCode() : 0)) * 31;
            boolean z2 = this.isFriend;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isFriend() {
            return this.isFriend;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ItemUser(user=");
            sbM833U.append(this.user);
            sbM833U.append(", aliases=");
            sbM833U.append(this.aliases);
            sbM833U.append(", presence=");
            sbM833U.append(this.presence);
            sbM833U.append(", isFriend=");
            return outline.m827O(sbM833U, this.isFriend, ")");
        }

        public /* synthetic */ ItemUser(User user, List list, Presence presence, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(user, list, (i & 4) != 0 ? null : presence, z2);
        }
    }
}
