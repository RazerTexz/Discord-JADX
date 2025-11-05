package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.y2;
import b.a.k.b;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.text.NumberFormat;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: GuildBoostMarketingView.kt */
/* loaded from: classes2.dex */
public final class GuildBoostMarketingView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final y2 binding;

    /* compiled from: GuildBoostMarketingView.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 j;

        public a(Function0 function0) {
            this.j = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.j.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostMarketingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_premium_marketing, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.view_premium_marketing_container_tier1;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.view_premium_marketing_container_tier1);
        if (linearLayout != null) {
            i = R.id.view_premium_marketing_learn_more;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.view_premium_marketing_learn_more);
            if (materialButton != null) {
                LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                i = R.id.view_premium_marketing_marketing_subtitle;
                TextView textView = (TextView) viewInflate.findViewById(R.id.view_premium_marketing_marketing_subtitle);
                if (textView != null) {
                    i = R.id.view_premium_marketing_marketing_title;
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.view_premium_marketing_marketing_title);
                    if (textView2 != null) {
                        i = R.id.view_premium_marketing_nitro_boost_count;
                        TextView textView3 = (TextView) viewInflate.findViewById(R.id.view_premium_marketing_nitro_boost_count);
                        if (textView3 != null) {
                            i = R.id.view_premium_marketing_nitro_boost_discount;
                            TextView textView4 = (TextView) viewInflate.findViewById(R.id.view_premium_marketing_nitro_boost_discount);
                            if (textView4 != null) {
                                i = R.id.view_premium_marketing_nitro_classic_boost_count;
                                TextView textView5 = (TextView) viewInflate.findViewById(R.id.view_premium_marketing_nitro_classic_boost_count);
                                if (textView5 != null) {
                                    i = R.id.view_premium_marketing_nitro_classic_boost_discount;
                                    TextView textView6 = (TextView) viewInflate.findViewById(R.id.view_premium_marketing_nitro_classic_boost_discount);
                                    if (textView6 != null) {
                                        y2 y2Var = new y2(linearLayout2, linearLayout, materialButton, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6);
                                        m.checkNotNullExpressionValue(y2Var, "ViewPremiumMarketingBind…rom(context), this, true)");
                                        this.binding = y2Var;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(PremiumTier userPremiumTier, Function0<Unit> onlearnMoreClickCallback) {
        Unit unit;
        m.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        m.checkNotNullParameter(onlearnMoreClickCallback, "onlearnMoreClickCallback");
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(context, R.plurals.guild_settings_premium_upsell_body_perk_no_free_guild_subscriptions_numFreeGuildSubscriptions, 2, 2);
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.viewPremiumMarketingNitroBoostDiscount");
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        Float fValueOf = Float.valueOf(0.3f);
        b.n(textView, R.string.guild_settings_premium_upsell_body_perk_guild_subscription_discount, new Object[]{percentInstance.format(fValueOf)}, null, 4);
        TextView textView2 = this.binding.g;
        m.checkNotNullExpressionValue(textView2, "binding.viewPremiumMarketingNitroBoostCount");
        b.n(textView2, R.string.guild_settings_premium_upsell_body_perk_num_guild_subscriptions, new Object[]{i18nPluralString}, null, 4);
        TextView textView3 = this.binding.j;
        m.checkNotNullExpressionValue(textView3, "binding.viewPremiumMarke…NitroClassicBoostDiscount");
        b.n(textView3, R.string.guild_settings_premium_upsell_body_perk_guild_subscription_discount, new Object[]{NumberFormat.getPercentInstance().format(fValueOf)}, null, 4);
        TextView textView4 = this.binding.i;
        m.checkNotNullExpressionValue(textView4, "binding.viewPremiumMarketingNitroClassicBoostCount");
        b.n(textView4, R.string.guild_settings_premium_upsell_body_perk_no_free_guild_subscriptions, new Object[]{i18nPluralString}, null, 4);
        this.binding.c.setOnClickListener(new a(onlearnMoreClickCallback));
        int iOrdinal = userPremiumTier.ordinal();
        if (iOrdinal == 0) {
            TextView textView5 = this.binding.e;
            m.checkNotNullExpressionValue(textView5, "binding.viewPremiumMarketingMarketingSubtitle");
            textView5.setVisibility(8);
            unit = Unit.a;
        } else if (iOrdinal == 1) {
            LinearLayout linearLayout = this.binding.d;
            m.checkNotNullExpressionValue(linearLayout, "binding.viewPremiumMarketingMarketingContainer");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.binding.f235b;
            m.checkNotNullExpressionValue(linearLayout2, "binding.viewPremiumMarketingContainerTier1");
            linearLayout2.setVisibility(0);
            TextView textView6 = this.binding.f;
            m.checkNotNullExpressionValue(textView6, "binding.viewPremiumMarketingMarketingTitle");
            ViewExtensions.setTextAndVisibilityBy(textView6, b.j(this, R.string.guild_settings_premium_upsell_heading_secondary, new Object[0], null, 4));
            TextView textView7 = this.binding.e;
            m.checkNotNullExpressionValue(textView7, "binding.viewPremiumMarketingMarketingSubtitle");
            textView7.setVisibility(8);
            unit = Unit.a;
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                LinearLayout linearLayout3 = this.binding.d;
                m.checkNotNullExpressionValue(linearLayout3, "binding.viewPremiumMarketingMarketingContainer");
                linearLayout3.setVisibility(0);
                LinearLayout linearLayout4 = this.binding.f235b;
                m.checkNotNullExpressionValue(linearLayout4, "binding.viewPremiumMarketingContainerTier1");
                linearLayout4.setVisibility(8);
                TextView textView8 = this.binding.f;
                m.checkNotNullExpressionValue(textView8, "binding.viewPremiumMarketingMarketingTitle");
                ViewExtensions.setTextAndVisibilityBy(textView8, b.j(this, R.string.guild_settings_premium_upsell_heading_secondary_premium_user, new Object[0], null, 4));
                TextView textView9 = this.binding.e;
                m.checkNotNullExpressionValue(textView9, "binding.viewPremiumMarketingMarketingSubtitle");
                ViewExtensions.setTextAndVisibilityBy(textView9, b.j(this, R.string.guild_settings_premium_upsell_heading_tertiary_premium_user, new Object[]{String.valueOf(2)}, null, 4));
                unit = Unit.a;
            } else {
                if (iOrdinal != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                LinearLayout linearLayout5 = this.binding.d;
                m.checkNotNullExpressionValue(linearLayout5, "binding.viewPremiumMarketingMarketingContainer");
                linearLayout5.setVisibility(8);
                unit = Unit.a;
            }
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }
}
