package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierReviewBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildRoleSubscriptionReview2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildRoleSubscriptionTierReviewBinding> {
    public static final WidgetGuildRoleSubscriptionReview2 INSTANCE = new WidgetGuildRoleSubscriptionReview2();

    public WidgetGuildRoleSubscriptionReview2() {
        super(1, WidgetGuildRoleSubscriptionTierReviewBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildRoleSubscriptionTierReviewBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildRoleSubscriptionTierReviewBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.subscription_tier_review_recycler);
        if (recyclerView != null) {
            return new WidgetGuildRoleSubscriptionTierReviewBinding((LinearLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.subscription_tier_review_recycler)));
    }
}
