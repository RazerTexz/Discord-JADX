package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import com.discord.R;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* loaded from: classes2.dex */
public abstract class TierViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public static final class AddTierItemViewHolder extends TierViewHolder {

        /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
        /* renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$AddTierItemViewHolder$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener $itemClickListener;

            public AnonymousClass1(ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
                this.$itemClickListener = itemClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.$itemClickListener.onAddTierItemClick();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public AddTierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
            m.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "binding");
            m.checkNotNullParameter(itemClickListener, "itemClickListener");
            ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.itemView.setOnClickListener(new AnonymousClass1(itemClickListener));
            viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.f2209b.setText(R.string.guild_settings_role_subscription_tier_card_create);
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public static final class TierItemViewHolder extends TierViewHolder {
        private static final int MAX_TIER_IMAGE_SIZE = 64;
        private final ViewServerSettingsGuildRoleSubscriptionTierItemBinding binding;
        private final int tierImageSizePx;

        /* JADX WARN: Illegal instructions before constructor call */
        public TierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding) {
            m.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "binding");
            ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionTierItemBinding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.binding = viewServerSettingsGuildRoleSubscriptionTierItemBinding;
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            this.tierImageSizePx = view.getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_tier_image_size);
        }

        public final void configureUI(ServerSettingsGuildRoleSubscriptionTierAdapterItem.Tier tierAdapterItem, ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
            m.checkNotNullParameter(tierAdapterItem, "tierAdapterItem");
            m.checkNotNullParameter(itemClickListener, "itemClickListener");
            this.itemView.setOnClickListener(new TierViewHolder$TierItemViewHolder$configureUI$1(itemClickListener, tierAdapterItem));
            TextView textView = this.binding.d;
            m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierName");
            textView.setText(tierAdapterItem.getTierName());
            TextView textView2 = this.binding.e;
            m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierPrice");
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            int tierPrice = tierAdapterItem.getTierPrice();
            View view2 = this.itemView;
            m.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            m.checkNotNullExpressionValue(context, "itemView.context");
            textView2.setText(b.j(view, R.string.billing_price_per_month, new Object[]{PremiumUtilsKt.getFormattedPriceUsd(tierPrice, context)}, null, 4));
            String storeAssetImage = tierAdapterItem.getTierImageAssetId() != null ? IconUtils.INSTANCE.getStoreAssetImage(Long.valueOf(tierAdapterItem.getApplicationId()), String.valueOf(tierAdapterItem.getTierImageAssetId().longValue()), 64) : null;
            SimpleDraweeView simpleDraweeView = this.binding.c;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierIcon");
            int i = this.tierImageSizePx;
            MGImages.setImage$default(simpleDraweeView, storeAssetImage, i, i, false, null, null, 112, null);
            TextView textView3 = this.binding.f2210b;
            m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierDraftTag");
            textView3.setVisibility(tierAdapterItem.isPublished() ^ true ? 0 : 8);
        }
    }

    private TierViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ TierViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
