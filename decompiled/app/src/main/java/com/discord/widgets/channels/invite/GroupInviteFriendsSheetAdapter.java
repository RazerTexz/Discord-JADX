package com.discord.widgets.channels.invite;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R;
import com.discord.databinding.GroupInviteFriendsSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GroupInviteFriendsSheetAdapter.kt */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter extends MGRecyclerAdapterSimple<FriendItem> {
    private final Function2<User, Boolean, Unit> onUserChecked;

    /* compiled from: GroupInviteFriendsSheetAdapter.kt */
    public static final /* data */ class FriendItem implements MGRecyclerDataPayload {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int TYPE_FRIEND = 0;
        private final boolean isSelected;
        private final String key;
        private final int type;
        private final User user;

        /* compiled from: GroupInviteFriendsSheetAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ArrayList<FriendItem> createItems(Collection<? extends User> users, Set<? extends User> checkedUsers) {
                m.checkNotNullParameter(users, "users");
                m.checkNotNullParameter(checkedUsers, "checkedUsers");
                ArrayList<FriendItem> arrayList = new ArrayList<>();
                for (User user : users) {
                    arrayList.add(new FriendItem(user, checkedUsers.contains(user)));
                }
                return arrayList;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public FriendItem(User user, boolean z2) {
            m.checkNotNullParameter(user, "user");
            this.user = user;
            this.isSelected = z2;
            this.key = String.valueOf(user.getId());
        }

        public static /* synthetic */ FriendItem copy$default(FriendItem friendItem, User user, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = friendItem.user;
            }
            if ((i & 2) != 0) {
                z2 = friendItem.isSelected;
            }
            return friendItem.copy(user, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final FriendItem copy(User user, boolean isSelected) {
            m.checkNotNullParameter(user, "user");
            return new FriendItem(user, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FriendItem)) {
                return false;
            }
            FriendItem friendItem = (FriendItem) other;
            return m.areEqual(this.user, friendItem.user) && this.isSelected == friendItem.isSelected;
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

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            boolean z2 = this.isSelected;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = a.U("FriendItem(user=");
            sbU.append(this.user);
            sbU.append(", isSelected=");
            return a.O(sbU, this.isSelected, ")");
        }
    }

    /* compiled from: GroupInviteFriendsSheetAdapter.kt */
    public static final class GroupInviteFriendsListItem extends MGRecyclerViewHolder<GroupInviteFriendsSheetAdapter, FriendItem> {
        private final GroupInviteFriendsSheetItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupInviteFriendsListItem(@LayoutRes int i, GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter) {
            super(i, groupInviteFriendsSheetAdapter);
            m.checkNotNullParameter(groupInviteFriendsSheetAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.friends_list_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friends_list_item_avatar);
            if (simpleDraweeView != null) {
                i2 = R.id.friends_list_item_name;
                TextView textView = (TextView) view.findViewById(R.id.friends_list_item_name);
                if (textView != null) {
                    i2 = R.id.user_selected_checkbox;
                    MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.user_selected_checkbox);
                    if (materialCheckBox != null) {
                        GroupInviteFriendsSheetItemBinding groupInviteFriendsSheetItemBinding = new GroupInviteFriendsSheetItemBinding((ConstraintLayout) view, simpleDraweeView, textView, materialCheckBox);
                        m.checkNotNullExpressionValue(groupInviteFriendsSheetItemBinding, "GroupInviteFriendsSheetItemBinding.bind(itemView)");
                        this.binding = groupInviteFriendsSheetItemBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ GroupInviteFriendsSheetAdapter access$getAdapter$p(GroupInviteFriendsListItem groupInviteFriendsListItem) {
            return (GroupInviteFriendsSheetAdapter) groupInviteFriendsListItem.adapter;
        }

        public static final /* synthetic */ GroupInviteFriendsSheetItemBinding access$getBinding$p(GroupInviteFriendsListItem groupInviteFriendsListItem) {
            return groupInviteFriendsListItem.binding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, FriendItem friendItem) {
            onConfigure2(i, friendItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, FriendItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            User user = data.getUser();
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            textView.setText(user.getUsername());
            SimpleDraweeView simpleDraweeView = this.binding.f2115b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, R.dimen.avatar_size_standard, null, null, null, 56, null);
            MaterialCheckBox materialCheckBox = this.binding.d;
            m.checkNotNullExpressionValue(materialCheckBox, "binding.userSelectedCheckbox");
            materialCheckBox.setChecked(data.isSelected());
            this.binding.d.setOnClickListener(new GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem$onConfigure$1(this, user));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GroupInviteFriendsSheetAdapter(RecyclerView recyclerView, Function2<? super User, ? super Boolean, Unit> function2) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(function2, "onUserChecked");
        this.onUserChecked = function2;
    }

    public final Function2<User, Boolean, Unit> getOnUserChecked() {
        return this.onUserChecked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, FriendItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new GroupInviteFriendsListItem(R.layout.group_invite_friends_sheet_item, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
