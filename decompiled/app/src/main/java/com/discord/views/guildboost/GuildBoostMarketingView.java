package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.api.premium.PremiumTier;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.button.MaterialButton;
import java.text.NumberFormat;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p025i.ViewPremiumMarketingBinding;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: GuildBoostMarketingView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostMarketingView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewPremiumMarketingBinding binding;

    /* JADX INFO: renamed from: com.discord.views.guildboost.GuildBoostMarketingView$a */
    /* JADX INFO: compiled from: GuildBoostMarketingView.kt */
    public static final class ViewOnClickListenerC7114a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Function0 f19271j;

        public ViewOnClickListenerC7114a(Function0 function0) {
            this.f19271j = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f19271j.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostMarketingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_premium_marketing, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.view_premium_marketing_container_tier1;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.view_premium_marketing_container_tier1);
        if (linearLayout != null) {
            i = C5419R.id.view_premium_marketing_learn_more;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.view_premium_marketing_learn_more);
            if (materialButton != null) {
                LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                i = C5419R.id.view_premium_marketing_marketing_subtitle;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_marketing_subtitle);
                if (textView != null) {
                    i = C5419R.id.view_premium_marketing_marketing_title;
                    TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_marketing_title);
                    if (textView2 != null) {
                        i = C5419R.id.view_premium_marketing_nitro_boost_count;
                        TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_nitro_boost_count);
                        if (textView3 != null) {
                            i = C5419R.id.view_premium_marketing_nitro_boost_discount;
                            TextView textView4 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_nitro_boost_discount);
                            if (textView4 != null) {
                                i = C5419R.id.view_premium_marketing_nitro_classic_boost_count;
                                TextView textView5 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_nitro_classic_boost_count);
                                if (textView5 != null) {
                                    i = C5419R.id.view_premium_marketing_nitro_classic_boost_discount;
                                    TextView textView6 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_marketing_nitro_classic_boost_discount);
                                    if (textView6 != null) {
                                        ViewPremiumMarketingBinding viewPremiumMarketingBinding = new ViewPremiumMarketingBinding(linearLayout2, linearLayout, materialButton, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6);
                                        Intrinsics3.checkNotNullExpressionValue(viewPremiumMarketingBinding, "ViewPremiumMarketingBind…rom(context), this, true)");
                                        this.binding = viewPremiumMarketingBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0138  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8595a(PremiumTier userPremiumTier, Function0<Unit> onlearnMoreClickCallback) {
        Unit unit;
        Intrinsics3.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        Intrinsics3.checkNotNullParameter(onlearnMoreClickCallback, "onlearnMoreClickCallback");
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(context, C5419R.plurals.guild_settings_premium_upsell_body_perk_no_free_guild_subscriptions_numFreeGuildSubscriptions, 2, 2);
        TextView textView = this.binding.f1414h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewPremiumMarketingNitroBoostDiscount");
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        Float fValueOf = Float.valueOf(0.3f);
        FormatUtils.m222n(textView, C5419R.string.f14757xf6a2f9e9, new Object[]{percentInstance.format(fValueOf)}, null, 4);
        TextView textView2 = this.binding.f1413g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewPremiumMarketingNitroBoostCount");
        FormatUtils.m222n(textView2, C5419R.string.guild_settings_premium_upsell_body_perk_num_guild_subscriptions, new Object[]{i18nPluralString}, null, 4);
        TextView textView3 = this.binding.f1416j;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.viewPremiumMarke…NitroClassicBoostDiscount");
        FormatUtils.m222n(textView3, C5419R.string.f14757xf6a2f9e9, new Object[]{NumberFormat.getPercentInstance().format(fValueOf)}, null, 4);
        TextView textView4 = this.binding.f1415i;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.viewPremiumMarketingNitroClassicBoostCount");
        FormatUtils.m222n(textView4, C5419R.string.f14758xe408127, new Object[]{i18nPluralString}, null, 4);
        this.binding.f1409c.setOnClickListener(new ViewOnClickListenerC7114a(onlearnMoreClickCallback));
        int iOrdinal = userPremiumTier.ordinal();
        if (iOrdinal == 0) {
            TextView textView5 = this.binding.f1411e;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.viewPremiumMarketingMarketingSubtitle");
            textView5.setVisibility(8);
            unit = Unit.f27425a;
        } else if (iOrdinal == 1) {
            LinearLayout linearLayout = this.binding.f1410d;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.viewPremiumMarketingMarketingContainer");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.binding.f1408b;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.viewPremiumMarketingContainerTier1");
            linearLayout2.setVisibility(0);
            TextView textView6 = this.binding.f1412f;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.viewPremiumMarketingMarketingTitle");
            ViewExtensions.setTextAndVisibilityBy(textView6, FormatUtils.m218j(this, C5419R.string.guild_settings_premium_upsell_heading_secondary, new Object[0], null, 4));
            TextView textView7 = this.binding.f1411e;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.viewPremiumMarketingMarketingSubtitle");
            textView7.setVisibility(8);
            unit = Unit.f27425a;
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                LinearLayout linearLayout3 = this.binding.f1410d;
                Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.viewPremiumMarketingMarketingContainer");
                linearLayout3.setVisibility(0);
                LinearLayout linearLayout4 = this.binding.f1408b;
                Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.viewPremiumMarketingContainerTier1");
                linearLayout4.setVisibility(8);
                TextView textView8 = this.binding.f1412f;
                Intrinsics3.checkNotNullExpressionValue(textView8, "binding.viewPremiumMarketingMarketingTitle");
                ViewExtensions.setTextAndVisibilityBy(textView8, FormatUtils.m218j(this, C5419R.string.guild_settings_premium_upsell_heading_secondary_premium_user, new Object[0], null, 4));
                TextView textView9 = this.binding.f1411e;
                Intrinsics3.checkNotNullExpressionValue(textView9, "binding.viewPremiumMarketingMarketingSubtitle");
                ViewExtensions.setTextAndVisibilityBy(textView9, FormatUtils.m218j(this, C5419R.string.guild_settings_premium_upsell_heading_tertiary_premium_user, new Object[]{String.valueOf(2)}, null, 4));
                unit = Unit.f27425a;
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                LinearLayout linearLayout5 = this.binding.f1410d;
                Intrinsics3.checkNotNullExpressionValue(linearLayout5, "binding.viewPremiumMarketingMarketingContainer");
                linearLayout5.setVisibility(8);
                unit = Unit.f27425a;
            }
        }
        KotlinExtensions.getExhaustive(unit);
    }
}
