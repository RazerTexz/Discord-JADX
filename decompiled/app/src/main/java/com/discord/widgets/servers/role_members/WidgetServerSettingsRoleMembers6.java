package com.discord.widgets.servers.role_members;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetServerSettingsRoleMembers.kt */
/* renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$guildRoleId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers6 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetServerSettingsRoleMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers6(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        super(0);
        this.this$0 = widgetServerSettingsRoleMembers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return arguments.getLong("INTENT_EXTRA_GUILD_ROLE_ID", -1L);
        }
        return -1L;
    }
}
