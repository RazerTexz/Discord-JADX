package com.discord.widgets.guild_role_subscriptions.tier.create;

import androidx.core.app.NotificationCompat;
import p658rx.functions.Action1;

/* compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$tierImageSelectedResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails3<T> implements Action1<String> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDetails this$0;

    public WidgetGuildRoleSubscriptionTierDetails3(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails) {
        this.this$0 = widgetGuildRoleSubscriptionTierDetails;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        WidgetGuildRoleSubscriptionTierDetails.access$getViewModel$p(this.this$0).updateImage(str);
    }
}
