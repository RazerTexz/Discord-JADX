package com.discord.widgets.servers;

import android.view.View;
import com.discord.widgets.servers.WidgetServerSettingsEditMemberRolesAdapter;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditMemberRolesAdapter$RoleListItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditMemberRolesAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter.RoleItem $data;
    public final /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter.RoleListItem this$0;

    public WidgetServerSettingsEditMemberRolesAdapter2(WidgetServerSettingsEditMemberRolesAdapter.RoleListItem roleListItem, WidgetServerSettingsEditMemberRolesAdapter.RoleItem roleItem) {
        this.this$0 = roleListItem;
        this.$data = roleItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getRoleClickListener$p = WidgetServerSettingsEditMemberRolesAdapter.access$getRoleClickListener$p(WidgetServerSettingsEditMemberRolesAdapter.RoleListItem.access$getAdapter$p(this.this$0));
        if (function1Access$getRoleClickListener$p != null) {
        }
    }
}
