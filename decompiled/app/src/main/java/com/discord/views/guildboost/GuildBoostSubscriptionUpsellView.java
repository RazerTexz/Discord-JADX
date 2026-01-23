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
import com.discord.i18n.RenderContext;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import java.text.NumberFormat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.ViewPremiumUpsellInfoBinding;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: GuildBoostSubscriptionUpsellView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostSubscriptionUpsellView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewPremiumUpsellInfoBinding binding;

    /* JADX INFO: renamed from: com.discord.views.guildboost.GuildBoostSubscriptionUpsellView$a */
    /* JADX INFO: compiled from: GuildBoostSubscriptionUpsellView.kt */
    public static final class C7115a extends Lambda implements Function1<RenderContext, Unit> {
        public C7115a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            RenderContext renderContext2 = renderContext;
            Intrinsics3.checkNotNullParameter(renderContext2, "$receiver");
            renderContext2.strikethroughColor = Integer.valueOf(ColorCompat.getThemedColor(GuildBoostSubscriptionUpsellView.this.getContext(), C5419R.attr.colorTextMuted));
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostSubscriptionUpsellView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_premium_upsell_info, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.view_premium_upsell_info_subheading;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.view_premium_upsell_info_subheading);
        if (textView != null) {
            i = C5419R.id.view_premium_upsell_info_subheading_blurb;
            TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_upsell_info_subheading_blurb);
            if (textView2 != null) {
                i = C5419R.id.view_premium_upsell_info_subheading_price;
                TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.view_premium_upsell_info_subheading_price);
                if (textView3 != null) {
                    ViewPremiumUpsellInfoBinding viewPremiumUpsellInfoBinding = new ViewPremiumUpsellInfoBinding((LinearLayout) viewInflate, textView, textView2, textView3);
                    Intrinsics3.checkNotNullExpressionValue(viewPremiumUpsellInfoBinding, "ViewPremiumUpsellInfoBin…rom(context), this, true)");
                    this.binding = viewPremiumUpsellInfoBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8597a(PremiumTier userPremiumTier, boolean showBlurb) {
        Intrinsics3.checkNotNullParameter(userPremiumTier, "userPremiumTier");
        TextView textView = this.binding.f744c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewPremiumUpsellInfoSubheadingBlurb");
        textView.setVisibility(showBlurb ? 0 : 8);
        int price = SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPrice();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence charSequenceM218j = FormatUtils.m218j(this, C5419R.string.billing_price_per_month, new Object[]{PremiumUtils2.getFormattedPriceUsd(price, context)}, null, 4);
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        CharSequence charSequenceM218j2 = FormatUtils.m218j(this, C5419R.string.billing_price_per_month, new Object[]{PremiumUtils2.getFormattedPriceUsd((int) (r2.getPrice() * 0.7f), context2)}, null, 4);
        String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
        Context context3 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context3, "context");
        CharSequence charSequenceM210b = FormatUtils.m210b(context3, C5419R.string.guild_settings_premium_upsell_subheading_extra_android, new Object[]{charSequenceM218j2, charSequenceM218j}, new C7115a());
        int iOrdinal = userPremiumTier.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            TextView textView2 = this.binding.f743b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewPremiumUpsellInfoSubheading");
            FormatUtils.m222n(textView2, C5419R.string.guild_settings_premium_upsell_subheading, new Object[]{charSequenceM218j}, null, 4);
            TextView textView3 = this.binding.f745d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.viewPremiumUpsellInfoSubheadingPrice");
            ViewExtensions.setTextAndVisibilityBy(textView3, null);
            return;
        }
        if (iOrdinal == 3) {
            TextView textView4 = this.binding.f743b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.viewPremiumUpsellInfoSubheading");
            FormatUtils.m222n(textView4, C5419R.string.guild_settings_premium_upsell_subheading_tier_1_mobile, new Object[]{str}, null, 4);
            TextView textView5 = this.binding.f745d;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.viewPremiumUpsellInfoSubheadingPrice");
            ViewExtensions.setTextAndVisibilityBy(textView5, charSequenceM210b);
            return;
        }
        if (iOrdinal != 4) {
            return;
        }
        TextView textView6 = this.binding.f743b;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.viewPremiumUpsellInfoSubheading");
        FormatUtils.m222n(textView6, C5419R.string.guild_settings_premium_upsell_subheading_tier_2_mobile, new Object[]{String.valueOf(2), str}, null, 4);
        TextView textView7 = this.binding.f745d;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.viewPremiumUpsellInfoSubheadingPrice");
        ViewExtensions.setTextAndVisibilityBy(textView7, charSequenceM210b);
    }
}
