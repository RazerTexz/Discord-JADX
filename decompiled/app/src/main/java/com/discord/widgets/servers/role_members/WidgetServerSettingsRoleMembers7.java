package com.discord.widgets.servers.role_members;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsRoleMembers.kt */
/* renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers7 extends Lambda implements Function0<ServerSettingsRoleMembersViewModel> {
    public final /* synthetic */ WidgetServerSettingsRoleMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers7(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        super(0);
        this.this$0 = widgetServerSettingsRoleMembers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ServerSettingsRoleMembersViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ServerSettingsRoleMembersViewModel invoke() {
        return new ServerSettingsRoleMembersViewModel(WidgetServerSettingsRoleMembers.access$getGuildId$p(this.this$0), WidgetServerSettingsRoleMembers.access$getGuildRoleId$p(this.this$0), null, null, null, null, null, null, null, 508, null);
    }
}
