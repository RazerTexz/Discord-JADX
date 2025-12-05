package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.os.Bundle;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$guildId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionReview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionReview3(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionReview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return arguments.getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        }
        return -1L;
    }
}
