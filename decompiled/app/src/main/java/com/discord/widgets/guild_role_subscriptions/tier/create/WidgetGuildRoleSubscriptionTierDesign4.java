package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$hideHeader$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign4 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDesign this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierDesign4(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierDesign;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            return arguments.getBoolean("INTENT_EXTRA_HIDE_HEADER", false);
        }
        return false;
    }
}
