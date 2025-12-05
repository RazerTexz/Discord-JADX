package com.discord.widgets.guild_role_subscriptions.setup;

import androidx.core.app.NotificationCompat;
import p658rx.functions.Action1;

/* compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails$coverImageSelectedResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanDetails3<T> implements Action1<String> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionPlanDetails this$0;

    public WidgetGuildRoleSubscriptionPlanDetails3(WidgetGuildRoleSubscriptionPlanDetails widgetGuildRoleSubscriptionPlanDetails) {
        this.this$0 = widgetGuildRoleSubscriptionPlanDetails;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetGuildRoleSubscriptionPlanDetails.access$getViewModel$p(this.this$0).updateCoverImage(str);
    }
}
