package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$defaultColor$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign3 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ WidgetGuildRoleSubscriptionTierDesign this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildRoleSubscriptionTierDesign3(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        super(0);
        this.this$0 = widgetGuildRoleSubscriptionTierDesign;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return ColorCompat.getColor(this.this$0, C5419R.color.primary_300);
    }
}
