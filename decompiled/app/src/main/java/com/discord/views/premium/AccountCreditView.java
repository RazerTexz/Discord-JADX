package com.discord.views.premium;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.time.TimeUtils;
import java.text.DateFormat;
import p007b.p008a.p025i.ViewAccountCreditBinding;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: AccountCreditView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccountCreditView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewAccountCreditBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountCreditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_account_credit, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.credit_header;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.credit_header);
        if (textView != null) {
            i = C5419R.id.credit_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.credit_icon);
            if (imageView != null) {
                i = C5419R.id.credit_info;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.credit_info);
                if (textView2 != null) {
                    i = C5419R.id.credit_info_container;
                    LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.credit_info_container);
                    if (linearLayout != null) {
                        i = C5419R.id.credit_time;
                        TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.credit_time);
                        if (textView3 != null) {
                            ViewAccountCreditBinding viewAccountCreditBinding = new ViewAccountCreditBinding((ConstraintLayout) viewInflate, textView, imageView, textView2, linearLayout, textView3);
                            Intrinsics3.checkNotNullExpressionValue(viewAccountCreditBinding, "ViewAccountCreditBinding…rom(context), this, true)");
                            this.binding = viewAccountCreditBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8605a(long planId, int monthsCredit, ModelSubscription currentSubscription) {
        Object objM218j;
        setVisibility(monthsCredit > 0 ? 0 : 8);
        if (monthsCredit <= 0) {
            return;
        }
        if (planId == SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId()) {
            objM218j = FormatUtils.m218j(this, C5419R.string.premium_tier_1, new Object[0], null, 4);
            this.binding.f1370c.setImageResource(C5419R.drawable.drawable_ic_nitro_classic);
            TextView textView = this.binding.f1369b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.creditHeader");
            FormatUtils.m222n(textView, C5419R.string.premium_subscription_credit, new Object[]{objM218j}, null, 4);
        } else if (planId == SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId()) {
            objM218j = FormatUtils.m218j(this, C5419R.string.premium_tier_2, new Object[0], null, 4);
            this.binding.f1370c.setImageResource(C5419R.drawable.drawable_ic_nitro);
            TextView textView2 = this.binding.f1369b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.creditHeader");
            FormatUtils.m222n(textView2, C5419R.string.premium_subscription_credit, new Object[]{objM218j}, null, 4);
        } else {
            objM218j = "";
        }
        if ((currentSubscription != null && currentSubscription.isGoogleSubscription()) || currentSubscription == null || !currentSubscription.hasPlan(planId)) {
            TextView textView3 = this.binding.f1371d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.creditInfo");
            FormatUtils.m222n(textView3, C5419R.string.premium_subscription_credit_applied_mismatched_plan_android, new Object[]{objM218j}, null, 4);
        } else {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String currentPeriodEnd = currentSubscription.getCurrentPeriodEnd();
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodEnd, context, (String) null, (DateFormat) null, 0, 28, (Object) null);
            TextView textView4 = this.binding.f1371d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.creditInfo");
            FormatUtils.m222n(textView4, C5419R.string.premium_subscription_credit_applied_on, new Object[]{strRenderUtcDate$default}, null, 4);
        }
        TextView textView5 = this.binding.f1372e;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.creditTime");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        textView5.setText(StringResourceUtils.getQuantityString(resources, context2, C5419R.plurals.premium_subscription_credit_count_months_count, monthsCredit, Integer.valueOf(monthsCredit)));
    }
}
