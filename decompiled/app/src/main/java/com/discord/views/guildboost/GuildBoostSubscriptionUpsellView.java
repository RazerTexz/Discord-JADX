package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.c3;
import b.a.k.b;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.m;
import d0.z.d.o;
import java.text.NumberFormat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: GuildBoostSubscriptionUpsellView.kt */
/* loaded from: classes2.dex */
public final class GuildBoostSubscriptionUpsellView extends FrameLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public final c3 binding;

    /* compiled from: GuildBoostSubscriptionUpsellView.kt */
    public static final class a extends o implements Function1<RenderContext, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            RenderContext renderContext2 = renderContext;
            m.checkNotNullParameter(renderContext2, "$receiver");
            renderContext2.strikethroughColor = Integer.valueOf(ColorCompat.getThemedColor(GuildBoostSubscriptionUpsellView.this.getContext(), R.attr.colorTextMuted));
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostSubscriptionUpsellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_premium_upsell_info, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.view_premium_upsell_info_subheading;
        TextView textView = (TextView) viewInflate.findViewById(R.id.view_premium_upsell_info_subheading);
        if (textView != null) {
            i = R.id.view_premium_upsell_info_subheading_blurb;
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.view_premium_upsell_info_subheading_blurb);
            if (textView2 != null) {
                i = R.id.view_premium_upsell_info_subheading_price;
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.view_premium_upsell_info_subheading_price);
                if (textView3 != null) {
                    c3 c3Var = new c3((LinearLayout) viewInflate, textView, textView2, textView3);
                    m.checkNotNullExpressionValue(c3Var, "ViewPremiumUpsellInfoBin…rom(context), this, true)");
                    this.binding = c3Var;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(PremiumTier userPremiumTier, boolean showBlurb) {
        m.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.viewPremiumUpsellInfoSubheadingBlurb");
        textView.setVisibility(showBlurb ? 0 : 8);
        int price = SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPrice();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        CharSequence charSequenceJ = b.j(this, R.string.billing_price_per_month, new Object[]{PremiumUtilsKt.getFormattedPriceUsd(price, context)}, null, 4);
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        CharSequence charSequenceJ2 = b.j(this, R.string.billing_price_per_month, new Object[]{PremiumUtilsKt.getFormattedPriceUsd((int) (r2.getPrice() * 0.7f), context2)}, null, 4);
        String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
        Context context3 = getContext();
        m.checkNotNullExpressionValue(context3, "context");
        CharSequence charSequenceB = b.b(context3, R.string.guild_settings_premium_upsell_subheading_extra_android, new Object[]{charSequenceJ2, charSequenceJ}, new a());
        int iOrdinal = userPremiumTier.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            TextView textView2 = this.binding.f92b;
            m.checkNotNullExpressionValue(textView2, "binding.viewPremiumUpsellInfoSubheading");
            b.n(textView2, R.string.guild_settings_premium_upsell_subheading, new Object[]{charSequenceJ}, null, 4);
            TextView textView3 = this.binding.d;
            m.checkNotNullExpressionValue(textView3, "binding.viewPremiumUpsellInfoSubheadingPrice");
            ViewExtensions.setTextAndVisibilityBy(textView3, null);
            return;
        }
        if (iOrdinal == 3) {
            TextView textView4 = this.binding.f92b;
            m.checkNotNullExpressionValue(textView4, "binding.viewPremiumUpsellInfoSubheading");
            b.n(textView4, R.string.guild_settings_premium_upsell_subheading_tier_1_mobile, new Object[]{str}, null, 4);
            TextView textView5 = this.binding.d;
            m.checkNotNullExpressionValue(textView5, "binding.viewPremiumUpsellInfoSubheadingPrice");
            ViewExtensions.setTextAndVisibilityBy(textView5, charSequenceB);
            return;
        }
        if (iOrdinal != 4) {
            return;
        }
        TextView textView6 = this.binding.f92b;
        m.checkNotNullExpressionValue(textView6, "binding.viewPremiumUpsellInfoSubheading");
        b.n(textView6, R.string.guild_settings_premium_upsell_subheading_tier_2_mobile, new Object[]{String.valueOf(2), str}, null, 4);
        TextView textView7 = this.binding.d;
        m.checkNotNullExpressionValue(textView7, "binding.viewPremiumUpsellInfoSubheadingPrice");
        ViewExtensions.setTextAndVisibilityBy(textView7, charSequenceB);
    }
}
