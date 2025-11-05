package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;

/* compiled from: GuildRoleSubscriptionBenefitAdapter.kt */
/* loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitAdapter$onAttachedToRecyclerView$$inlined$also$lambda$1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ GuildRoleSubscriptionBenefitAdapter.StickyHeadersManager $it;
    public final /* synthetic */ RecyclerView $recyclerView$inlined;

    public GuildRoleSubscriptionBenefitAdapter$onAttachedToRecyclerView$$inlined$also$lambda$1(GuildRoleSubscriptionBenefitAdapter.StickyHeadersManager stickyHeadersManager, RecyclerView recyclerView) {
        this.$it = stickyHeadersManager;
        this.$recyclerView$inlined = recyclerView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.$it.layoutViews(this.$recyclerView$inlined);
    }
}
