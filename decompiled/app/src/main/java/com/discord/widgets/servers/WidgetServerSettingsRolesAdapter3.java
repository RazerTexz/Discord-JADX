package com.discord.widgets.servers;

import android.view.View;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.widgets.servers.WidgetServerSettingsRolesAdapter;
import java.util.Objects;

/* compiled from: WidgetServerSettingsRolesAdapter.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter3 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsRolesAdapter.RoleItem $roleItem;
    public final /* synthetic */ WidgetServerSettingsRolesAdapter.RoleListItem this$0;

    public WidgetServerSettingsRolesAdapter3(WidgetServerSettingsRolesAdapter.RoleListItem roleListItem, WidgetServerSettingsRolesAdapter.RoleItem roleItem) {
        this.this$0 = roleListItem;
        this.$roleItem = roleItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MGRecyclerAdapter mGRecyclerAdapterAccess$getAdapter$p = WidgetServerSettingsRolesAdapter.RoleListItem.access$getAdapter$p(this.this$0);
        Objects.requireNonNull(mGRecyclerAdapterAccess$getAdapter$p, "null cannot be cast to non-null type com.discord.widgets.servers.WidgetServerSettingsRolesAdapter");
        WidgetServerSettingsRolesAdapter.access$getRoleSelectedListener$p((WidgetServerSettingsRolesAdapter) mGRecyclerAdapterAccess$getAdapter$p).invoke(this.$roleItem.getRole());
    }
}
