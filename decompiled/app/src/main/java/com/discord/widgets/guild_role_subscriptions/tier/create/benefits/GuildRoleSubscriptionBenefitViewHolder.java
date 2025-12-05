package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.databinding.ViewGuildRoleSubscriptionAddBenefitItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionFreeTrialItemBinding;
import com.discord.databinding.ViewGuildRoleSubscriptionSectionHeaderItemBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionBenefitItemView;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils2;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
/* loaded from: classes2.dex */
public abstract class GuildRoleSubscriptionBenefitViewHolder extends RecyclerView.ViewHolder {

    /* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
    public static final class AddItemViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
        private final ViewGuildRoleSubscriptionAddBenefitItemBinding binding;
        private final GuildRoleSubscriptionBenefitAdapter.Listener listener;

        /* JADX WARN: Illegal instructions before constructor call */
        public AddItemViewHolder(ViewGuildRoleSubscriptionAddBenefitItemBinding viewGuildRoleSubscriptionAddBenefitItemBinding, GuildRoleSubscriptionBenefitAdapter.Listener listener) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionAddBenefitItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(listener, "listener");
            ConstraintLayout constraintLayout = viewGuildRoleSubscriptionAddBenefitItemBinding.f15458a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout, null);
            this.binding = viewGuildRoleSubscriptionAddBenefitItemBinding;
            this.listener = listener;
        }

        public static final /* synthetic */ GuildRoleSubscriptionBenefitAdapter.Listener access$getListener$p(AddItemViewHolder addItemViewHolder) {
            return addItemViewHolder.listener;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
        public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
            String string;
            Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
            GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem addBenefitItem = (GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem) benefitAdapterItem;
            this.binding.f15458a.setOnClickListener(new GuildRoleSubscriptionBenefitViewHolder2(this, addBenefitItem));
            if (addBenefitItem.getType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                string = view.getContext().getString(C5419R.string.guild_role_subscription_tier_benefits_add_channel_label);
            } else {
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                string = view2.getContext().getString(C5419R.string.guild_role_subscription_tier_benefits_add_benefit_label);
            }
            Intrinsics3.checkNotNullExpressionValue(string, "if (data.type == GuildRo…dd_benefit_label)\n      }");
            TextView textView = this.binding.f15459b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionAddBenefitText");
            textView.setText(string);
            TextView textView2 = this.binding.f15459b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionAddBenefitText");
            textView2.setContentDescription(string);
        }
    }

    /* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
    public static final class FreeTrialViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
        private final ViewGuildRoleSubscriptionFreeTrialItemBinding binding;
        private final GuildRoleSubscriptionBenefitAdapter.Listener listener;

        /* JADX WARN: Illegal instructions before constructor call */
        public FreeTrialViewHolder(ViewGuildRoleSubscriptionFreeTrialItemBinding viewGuildRoleSubscriptionFreeTrialItemBinding, GuildRoleSubscriptionBenefitAdapter.Listener listener) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionFreeTrialItemBinding, "binding");
            Intrinsics3.checkNotNullParameter(listener, "listener");
            LinearLayout linearLayout = viewGuildRoleSubscriptionFreeTrialItemBinding.f15468a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionFreeTrialItemBinding;
            this.listener = listener;
        }

        public static final /* synthetic */ ViewGuildRoleSubscriptionFreeTrialItemBinding access$getBinding$p(FreeTrialViewHolder freeTrialViewHolder) {
            return freeTrialViewHolder.binding;
        }

        public static final /* synthetic */ GuildRoleSubscriptionBenefitAdapter.Listener access$getListener$p(FreeTrialViewHolder freeTrialViewHolder) {
            return freeTrialViewHolder.listener;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00d8  */
        @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
            CharSequence text;
            CharSequence text2;
            Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
            GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem freeTrialItem = (GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem) benefitAdapterItem;
            CheckedSetting checkedSetting = this.binding.f15472e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildRoleSubscriptionFreeTrialEnableToggle");
            checkedSetting.setChecked(freeTrialItem.isFreeTrialEnabled());
            this.binding.f15472e.m8527e(new GuildRoleSubscriptionBenefitViewHolder5(this));
            TextView textView = this.binding.f15473f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionFreeTrialSubtitle");
            textView.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView2 = this.binding.f15471d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionActiveUserLimitTitle");
            textView2.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView3 = this.binding.f15469b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…ctiveUserLimitDescription");
            textView3.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView4 = this.binding.f15470c;
            textView4.setSelected(freeTrialItem.isFreeTrialEnabled());
            Integer activeTrialUserLimit = freeTrialItem.getActiveTrialUserLimit();
            if (activeTrialUserLimit == null || (text = String.valueOf(activeTrialUserLimit.intValue())) == null) {
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                text = view.getContext().getText(C5419R.string.f14707x846378d0);
            }
            textView4.setText(text);
            if (freeTrialItem.isFreeTrialEnabled()) {
                textView4.setOnClickListener(new GuildRoleSubscriptionBenefitViewHolder3(this, freeTrialItem));
            }
            TextView textView5 = this.binding.f15476i;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTimeLimitTitle");
            textView5.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView6 = this.binding.f15474g;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.guildRoleSubscriptionTimeLimitDescription");
            textView6.setEnabled(freeTrialItem.isFreeTrialEnabled());
            TextView textView7 = this.binding.f15475h;
            textView7.setSelected(freeTrialItem.isFreeTrialEnabled());
            SubscriptionTrialInterval trialInterval = freeTrialItem.getTrialInterval();
            if (trialInterval != null) {
                View view2 = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "itemView.context");
                text2 = GuildRoleSubscriptionUtils2.getFormattedLabel(trialInterval, context);
                if (text2 == null) {
                    View view3 = this.itemView;
                    Intrinsics3.checkNotNullExpressionValue(view3, "itemView");
                    text2 = view3.getContext().getText(C5419R.string.guild_role_subscription_setup_free_trial_disabled);
                }
            }
            textView7.setText(text2);
            if (freeTrialItem.isFreeTrialEnabled()) {
                textView7.setOnClickListener(new GuildRoleSubscriptionBenefitViewHolder4(this, freeTrialItem));
            }
        }
    }

    /* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
    public static final class HeaderViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
        private final ViewGuildRoleSubscriptionSectionHeaderItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public HeaderViewHolder(ViewGuildRoleSubscriptionSectionHeaderItemBinding viewGuildRoleSubscriptionSectionHeaderItemBinding) {
            Intrinsics3.checkNotNullParameter(viewGuildRoleSubscriptionSectionHeaderItemBinding, "binding");
            LinearLayout linearLayout = viewGuildRoleSubscriptionSectionHeaderItemBinding.f15491a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            super(linearLayout, null);
            this.binding = viewGuildRoleSubscriptionSectionHeaderItemBinding;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
        public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
            Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
            this.binding.f15492b.setText(((GuildRoleSubscriptionBenefitAdapterItem.Header) benefitAdapterItem).getType() == GuildRoleSubscriptionBenefitType.CHANNEL ? C5419R.string.guild_role_subscription_tier_exclusive_channels_section_title : C5419R.string.guild_role_subscription_tier_additional_benefits_section_title);
        }
    }

    /* compiled from: GuildRoleSubscriptionBenefitViewHolder.kt */
    public static final class ItemViewHolder extends GuildRoleSubscriptionBenefitViewHolder {
        private final GuildRoleSubscriptionBenefitAdapter.Listener listener;
        private final GuildRoleSubscriptionBenefitItemView view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemViewHolder(GuildRoleSubscriptionBenefitItemView guildRoleSubscriptionBenefitItemView, GuildRoleSubscriptionBenefitAdapter.Listener listener) {
            super(guildRoleSubscriptionBenefitItemView, null);
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionBenefitItemView, "view");
            Intrinsics3.checkNotNullParameter(listener, "listener");
            this.view = guildRoleSubscriptionBenefitItemView;
            this.listener = listener;
        }

        public static final /* synthetic */ GuildRoleSubscriptionBenefitAdapter.Listener access$getListener$p(ItemViewHolder itemViewHolder) {
            return itemViewHolder.listener;
        }

        @Override // com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitViewHolder
        public void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem) {
            Intrinsics3.checkNotNullParameter(benefitAdapterItem, "benefitAdapterItem");
            this.itemView.setOnClickListener(new GuildRoleSubscriptionBenefitViewHolder6(this, benefitAdapterItem));
            if (!(benefitAdapterItem instanceof GuildRoleSubscriptionBenefitAdapterItem.BenefitItem)) {
                benefitAdapterItem = null;
            }
            GuildRoleSubscriptionBenefitAdapterItem.BenefitItem benefitItem = (GuildRoleSubscriptionBenefitAdapterItem.BenefitItem) benefitAdapterItem;
            if (benefitItem != null) {
                this.view.configureUI(benefitItem.getBenefit());
            }
        }
    }

    private GuildRoleSubscriptionBenefitViewHolder(View view) {
        super(view);
    }

    public abstract void configure(GuildRoleSubscriptionBenefitAdapterItem benefitAdapterItem);

    public /* synthetic */ GuildRoleSubscriptionBenefitViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
