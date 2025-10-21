package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierReviewBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionReview2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionTierReviewBinding> {
    public static final WidgetGuildRoleSubscriptionReview2 INSTANCE = new WidgetGuildRoleSubscriptionReview2();

    public WidgetGuildRoleSubscriptionReview2() {
        super(1, WidgetGuildRoleSubscriptionTierReviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionTierReviewBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionTierReviewBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.subscription_tier_review_recycler);
        if (recyclerView != null) {
            return new WidgetGuildRoleSubscriptionTierReviewBinding((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.subscription_tier_review_recycler)));
    }
}
