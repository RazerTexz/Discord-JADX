package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding;
import com.discord.databinding.ViewServerSettingsGuildRoleSubscriptionTierItemBinding;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter2;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder, reason: use source file name */
/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ServerSettingsGuildRoleSubscriptionTierAdapter3 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$AddTierItemViewHolder */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public static final class AddTierItemViewHolder extends ServerSettingsGuildRoleSubscriptionTierAdapter3 {

        /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$AddTierItemViewHolder$1 */
        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
        public static final class ViewOnClickListenerC94481 implements View.OnClickListener {
            public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener $itemClickListener;

            public ViewOnClickListenerC94481(ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
                this.$itemClickListener = itemClickListener;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.$itemClickListener.onAddTierItemClick();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public AddTierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionAddTierItemBinding viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
            Intrinsics3.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionAddTierItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(itemClickListener, "itemClickListener");
            ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.f15558a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.itemView.setOnClickListener(new ViewOnClickListenerC94481(itemClickListener));
            viewServerSettingsGuildRoleSubscriptionAddTierItemBinding.f15559b.setText(C5419R.string.guild_settings_role_subscription_tier_card_create);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.TierViewHolder$TierItemViewHolder */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    public static final class TierItemViewHolder extends ServerSettingsGuildRoleSubscriptionTierAdapter3 {
        private static final int MAX_TIER_IMAGE_SIZE = 64;
        private final ViewServerSettingsGuildRoleSubscriptionTierItemBinding binding;
        private final int tierImageSizePx;

        /* JADX WARN: Illegal instructions before constructor call */
        public TierItemViewHolder(ViewServerSettingsGuildRoleSubscriptionTierItemBinding viewServerSettingsGuildRoleSubscriptionTierItemBinding) {
            Intrinsics3.checkNotNullParameter(viewServerSettingsGuildRoleSubscriptionTierItemBinding, "binding");
            ConstraintLayout constraintLayout = viewServerSettingsGuildRoleSubscriptionTierItemBinding.f15560a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.binding = viewServerSettingsGuildRoleSubscriptionTierItemBinding;
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            this.tierImageSizePx = view.getResources().getDimensionPixelSize(C5419R.dimen.guild_role_subscription_tier_image_size);
        }

        public final void configureUI(ServerSettingsGuildRoleSubscriptionTierAdapter2.Tier tierAdapterItem, ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener itemClickListener) {
            Intrinsics3.checkNotNullParameter(tierAdapterItem, "tierAdapterItem");
            Intrinsics3.checkNotNullParameter(itemClickListener, "itemClickListener");
            this.itemView.setOnClickListener(new ServerSettingsGuildRoleSubscriptionTierAdapter4(itemClickListener, tierAdapterItem));
            TextView textView = this.binding.f15563d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierName");
            textView.setText(tierAdapterItem.getTierName());
            TextView textView2 = this.binding.f15564e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierPrice");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            int tierPrice = tierAdapterItem.getTierPrice();
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            Context context = view2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
            textView2.setText(FormatUtils.m218j(view, C5419R.string.billing_price_per_month, new Object[]{PremiumUtils2.getFormattedPriceUsd(tierPrice, context)}, null, 4));
            String storeAssetImage = tierAdapterItem.getTierImageAssetId() != null ? IconUtils.INSTANCE.getStoreAssetImage(Long.valueOf(tierAdapterItem.getApplicationId()), String.valueOf(tierAdapterItem.getTierImageAssetId().longValue()), 64) : null;
            SimpleDraweeView simpleDraweeView = this.binding.f15562c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierIcon");
            int i = this.tierImageSizePx;
            MGImages.setImage$default(simpleDraweeView, storeAssetImage, i, i, false, null, null, 112, null);
            TextView textView3 = this.binding.f15561b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierDraftTag");
            textView3.setVisibility(tierAdapterItem.isPublished() ^ true ? 0 : 8);
        }
    }

    private ServerSettingsGuildRoleSubscriptionTierAdapter3(View view) {
        super(view);
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter3(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
