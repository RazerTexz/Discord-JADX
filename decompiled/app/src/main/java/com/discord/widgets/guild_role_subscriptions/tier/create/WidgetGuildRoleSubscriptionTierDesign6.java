package com.discord.widgets.guild_role_subscriptions.tier.create;

import androidx.core.app.NotificationCompat;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$memberBadgeImageSelectedResult$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign6<T> implements Action1<String> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDesign this$0;

    public WidgetGuildRoleSubscriptionTierDesign6(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        this.this$0 = widgetGuildRoleSubscriptionTierDesign;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetGuildRoleSubscriptionTierDesign.access$getViewModel$p(this.this$0).updateMemberIcon(str);
    }
}
