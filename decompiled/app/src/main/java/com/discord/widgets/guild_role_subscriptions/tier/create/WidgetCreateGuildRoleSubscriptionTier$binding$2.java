package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import com.discord.databinding.WidgetCreateGuildRoleSubscriptionTierBinding;
import com.discord.views.steps.StepsView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetCreateGuildRoleSubscriptionTier$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetCreateGuildRoleSubscriptionTierBinding> {
    public static final WidgetCreateGuildRoleSubscriptionTier$binding$2 INSTANCE = new WidgetCreateGuildRoleSubscriptionTier$binding$2();

    public WidgetCreateGuildRoleSubscriptionTier$binding$2() {
        super(1, WidgetCreateGuildRoleSubscriptionTierBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCreateGuildRoleSubscriptionTierBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCreateGuildRoleSubscriptionTierBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        StepsView stepsView = (StepsView) view;
        return new WidgetCreateGuildRoleSubscriptionTierBinding(stepsView, stepsView);
    }
}
