package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewCheckableRoleListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditMemberRolesAdapter extends MGRecyclerAdapterSimple<RoleItem> {
    private Function1<? super Long, Unit> roleClickListener;

    /* compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
    public static final class RoleListItem extends MGRecyclerViewHolder<WidgetServerSettingsEditMemberRolesAdapter, RoleItem> {
        private final ViewCheckableRoleListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleListItem(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter) {
            super(C5419R.layout.view_checkable_role_list_item, widgetServerSettingsEditMemberRolesAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsEditMemberRolesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            CheckedSetting checkedSetting = (CheckedSetting) view;
            ViewCheckableRoleListItemBinding viewCheckableRoleListItemBinding = new ViewCheckableRoleListItemBinding(checkedSetting, checkedSetting);
            Intrinsics3.checkNotNullExpressionValue(viewCheckableRoleListItemBinding, "ViewCheckableRoleListItemBinding.bind(itemView)");
            this.binding = viewCheckableRoleListItemBinding;
        }

        public static final /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter access$getAdapter$p(RoleListItem roleListItem) {
            return (WidgetServerSettingsEditMemberRolesAdapter) roleListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, RoleItem roleItem) {
            onConfigure2(i, roleItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, RoleItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.binding.f15398b.setText(data.getRole().getName());
            CheckedSetting checkedSetting = this.binding.f15398b;
            GuildRole role = data.getRole();
            CheckedSetting checkedSetting2 = this.binding.f15398b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
            Context context = checkedSetting2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.roleItemCheckedSetting.context");
            checkedSetting.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
            CheckedSetting checkedSetting3 = this.binding.f15398b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.roleItemCheckedSetting");
            checkedSetting3.setChecked(data.isUserHasRole());
            if (data.isManageable()) {
                this.binding.f15398b.m8527e(new WidgetServerSettingsEditMemberRolesAdapter2(this, data));
            } else if (data.isRoleManaged()) {
                this.binding.f15398b.m8525b(C5419R.string.managed_role_explaination);
            } else {
                CheckedSetting.m8523d(this.binding.f15398b, null, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditMemberRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getRoleClickListener$p(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter) {
        return widgetServerSettingsEditMemberRolesAdapter.roleClickListener;
    }

    public static final /* synthetic */ void access$setRoleClickListener$p(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter, Function1 function1) {
        widgetServerSettingsEditMemberRolesAdapter.roleClickListener = function1;
    }

    public final void configure(List<RoleItem> roleItems, Function1<? super Long, Unit> roleClickListener) {
        Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
        Intrinsics3.checkNotNullParameter(roleClickListener, "roleClickListener");
        this.roleClickListener = roleClickListener;
        setData(roleItems);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RoleListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new RoleListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
    public static final /* data */ class RoleItem implements MGRecyclerDataPayload {
        public static final int TYPE_ROLE = 1;
        private final boolean isManageable;
        private final boolean isUserHasRole;
        private final String key;
        private final GuildRole role;
        private final int type;

        public RoleItem(GuildRole guildRole, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
            this.isUserHasRole = z2;
            this.isManageable = z3;
            this.type = 1;
            this.key = String.valueOf(guildRole.getId());
        }

        public static /* synthetic */ RoleItem copy$default(RoleItem roleItem, GuildRole guildRole, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = roleItem.role;
            }
            if ((i & 2) != 0) {
                z2 = roleItem.isUserHasRole;
            }
            if ((i & 4) != 0) {
                z3 = roleItem.isManageable;
            }
            return roleItem.copy(guildRole, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsUserHasRole() {
            return this.isUserHasRole;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsManageable() {
            return this.isManageable;
        }

        public final RoleItem copy(GuildRole role, boolean isUserHasRole, boolean isManageable) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new RoleItem(role, isUserHasRole, isManageable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleItem)) {
                return false;
            }
            RoleItem roleItem = (RoleItem) other;
            return Intrinsics3.areEqual(this.role, roleItem.role) && this.isUserHasRole == roleItem.isUserHasRole && this.isManageable == roleItem.isManageable;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            GuildRole guildRole = this.role;
            int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
            boolean z2 = this.isUserHasRole;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.isManageable;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isManageable() {
            return this.isManageable;
        }

        public final boolean isRoleManaged() {
            return this.role.getManaged();
        }

        public final boolean isUserHasRole() {
            return this.isUserHasRole;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("RoleItem(role=");
            sbM833U.append(this.role);
            sbM833U.append(", isUserHasRole=");
            sbM833U.append(this.isUserHasRole);
            sbM833U.append(", isManageable=");
            return outline.m827O(sbM833U, this.isManageable, ")");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RoleItem(GuildRole guildRole, boolean z2, GuildRole guildRole2, boolean z3, boolean z4) {
            this(guildRole, z2, !guildRole.getManaged() && (z3 || RoleUtils.rankIsHigher(guildRole2, guildRole)) && z4);
            Intrinsics3.checkNotNullParameter(guildRole, "role");
        }
    }
}
