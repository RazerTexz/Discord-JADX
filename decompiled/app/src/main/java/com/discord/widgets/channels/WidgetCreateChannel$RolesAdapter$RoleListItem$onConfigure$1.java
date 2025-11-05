package com.discord.widgets.channels;

import android.view.View;
import com.discord.api.role.GuildRole;
import com.discord.widgets.channels.WidgetCreateChannel;
import d0.z.d.m;

/* compiled from: WidgetCreateChannel.kt */
/* loaded from: classes2.dex */
public final class WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ GuildRole $role;
    public final /* synthetic */ WidgetCreateChannel.RolesAdapter.RoleListItem this$0;

    public WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1(WidgetCreateChannel.RolesAdapter.RoleListItem roleListItem, GuildRole guildRole) {
        this.this$0 = roleListItem;
        this.$role = guildRole;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel.RolesAdapter rolesAdapterAccess$getAdapter$p = WidgetCreateChannel.RolesAdapter.RoleListItem.access$getAdapter$p(this.this$0);
        m.checkNotNullExpressionValue(WidgetCreateChannel.RolesAdapter.RoleListItem.access$getBinding$p(this.this$0).f2180b, "binding.roleItemCheckedSetting");
        WidgetCreateChannel.RolesAdapter.access$onRoleClicked(rolesAdapterAccess$getAdapter$p, !r0.isChecked(), this.this$0.getAdapterPosition(), this.$role.getId());
    }
}
