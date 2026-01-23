package com.discord.widgets.servers.guild_role_subscription;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionTierListBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsGuildRoleSubscriptionTierList2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsGuildRoleSubscriptionTierListBinding> {
    public static final WidgetServerSettingsGuildRoleSubscriptionTierList2 INSTANCE = new WidgetServerSettingsGuildRoleSubscriptionTierList2();

    public WidgetServerSettingsGuildRoleSubscriptionTierList2() {
        super(1, WidgetServerSettingsGuildRoleSubscriptionTierListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionTierListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionTierListBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsGuildRoleSubscriptionTierListBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.server_settings_guild_role_subscription_tier_list;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.server_settings_guild_role_subscription_tier_list);
        if (recyclerView != null) {
            i = C5419R.id.server_settings_guild_role_subscription_tier_list_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.server_settings_guild_role_subscription_tier_list_view_flipper);
            if (appViewFlipper != null) {
                return new WidgetServerSettingsGuildRoleSubscriptionTierListBinding((CoordinatorLayout) view, recyclerView, appViewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
