package com.discord.widgets.servers.settings.members;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetServerSettingsMemberListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.roles.RolesListView;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerSettingsMembersAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter extends MGRecyclerAdapterSimple<WidgetServerSettingsMembersModel.MemberItem> {
    private Function2<? super Long, ? super List<Long>, Unit> memberSelectedListener;

    /* compiled from: WidgetServerSettingsMembersAdapter.kt */
    public static final class MemberListItem extends MGRecyclerViewHolder<WidgetServerSettingsMembersAdapter, WidgetServerSettingsMembersModel.MemberItem> {
        private final WidgetServerSettingsMemberListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberListItem(WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter) {
            super(R.layout.widget_server_settings_member_list_item, widgetServerSettingsMembersAdapter);
            m.checkNotNullParameter(widgetServerSettingsMembersAdapter, "adapter");
            View view = this.itemView;
            FrameLayout frameLayout = (FrameLayout) view;
            int i = R.id.member_list_item_lock;
            ImageView imageView = (ImageView) view.findViewById(R.id.member_list_item_lock);
            if (imageView != null) {
                i = R.id.member_list_item_overflow;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.member_list_item_overflow);
                if (imageView2 != null) {
                    i = R.id.member_list_item_roles_list;
                    RolesListView rolesListView = (RolesListView) view.findViewById(R.id.member_list_item_roles_list);
                    if (rolesListView != null) {
                        i = R.id.settings_member_view;
                        SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R.id.settings_member_view);
                        if (settingsMemberView != null) {
                            WidgetServerSettingsMemberListItemBinding widgetServerSettingsMemberListItemBinding = new WidgetServerSettingsMemberListItemBinding((FrameLayout) view, frameLayout, imageView, imageView2, rolesListView, settingsMemberView);
                            m.checkNotNullExpressionValue(widgetServerSettingsMemberListItemBinding, "WidgetServerSettingsMemb…temBinding.bind(itemView)");
                            this.binding = widgetServerSettingsMemberListItemBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetServerSettingsMembersAdapter access$getAdapter$p(MemberListItem memberListItem) {
            return (WidgetServerSettingsMembersAdapter) memberListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsMembersModel.MemberItem memberItem) {
            onConfigure2(i, memberItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, WidgetServerSettingsMembersModel.MemberItem data) {
            m.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            this.binding.f.a(data.getUser(), data.getGuildMember());
            RolesListView rolesListView = this.binding.e;
            List<GuildRole> roles = data.getRoles();
            RolesListView rolesListView2 = this.binding.e;
            m.checkNotNullExpressionValue(rolesListView2, "binding.memberListItemRolesList");
            rolesListView.updateView(roles, ColorCompat.getColor(rolesListView2, R.color.status_grey_500), data.getGuildMember().getGuildId());
            RolesListView rolesListView3 = this.binding.e;
            m.checkNotNullExpressionValue(rolesListView3, "binding.memberListItemRolesList");
            rolesListView3.setVisibility(data.getRoles().isEmpty() ^ true ? 0 : 8);
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.memberListItemLock");
            imageView.setVisibility(data.isManagable() ^ true ? 0 : 8);
            ImageView imageView2 = this.binding.d;
            m.checkNotNullExpressionValue(imageView2, "binding.memberListItemOverflow");
            imageView2.setVisibility(data.isManagable() ? 0 : 8);
            this.binding.f2578b.setOnClickListener(new WidgetServerSettingsMembersAdapter$MemberListItem$onConfigure$1(this, data));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsMembersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.memberSelectedListener = WidgetServerSettingsMembersAdapter$memberSelectedListener$1.INSTANCE;
    }

    public static final /* synthetic */ Function2 access$getMemberSelectedListener$p(WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter) {
        return widgetServerSettingsMembersAdapter.memberSelectedListener;
    }

    public static final /* synthetic */ void access$setMemberSelectedListener$p(WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter, Function2 function2) {
        widgetServerSettingsMembersAdapter.memberSelectedListener = function2;
    }

    public final void configure(WidgetServerSettingsMembersModel model, Function2<? super Long, ? super List<Long>, Unit> memberSelectedListener) {
        m.checkNotNullParameter(model, "model");
        m.checkNotNullParameter(memberSelectedListener, "memberSelectedListener");
        this.memberSelectedListener = memberSelectedListener;
        setData(model.getMemberItems());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MemberListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new MemberListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
