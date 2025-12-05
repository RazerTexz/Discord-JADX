package com.discord.utilities.billing;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.DrawableRes;
import com.discord.C5419R;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.locale.LocaleManager;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PremiumUtils.kt */
/* renamed from: com.discord.utilities.billing.PremiumUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PremiumUtils2 {
    public static final int GRACE_PERIOD_LONG = 7;
    public static final int GRACE_PERIOD_SHORT = 3;
    private static final Date GRANDFATHERED_MONTHLY_END_DATE;
    private static final Date GRANDFATHERED_YEARLY_END_DATE;
    public static final int MAX_ACCOUNT_HOLD_DAYS = 30;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 2, 1);
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance().apply { set(2020, 2, 1) }");
        Date time = calendar.getTime();
        Intrinsics3.checkNotNullExpressionValue(time, "Calendar.getInstance().a… { set(2020, 2, 1) }.time");
        GRANDFATHERED_MONTHLY_END_DATE = time;
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021, 0, 1);
        Intrinsics3.checkNotNullExpressionValue(calendar2, "Calendar.getInstance().apply { set(2021, 0, 1) }");
        Date time2 = calendar2.getTime();
        Intrinsics3.checkNotNullExpressionValue(time2, "Calendar.getInstance().a… { set(2021, 0, 1) }.time");
        GRANDFATHERED_YEARLY_END_DATE = time2;
    }

    public static final CharSequence getFormattedPriceUsd(int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(new LocaleManager().getPrimaryLocale(context));
        currencyInstance.setCurrency(Currency.getInstance("USD"));
        String str = currencyInstance.format(Float.valueOf(i / 100));
        Intrinsics3.checkNotNullExpressionValue(str, "numberFormat.format(priceUsdDollars)");
        return str;
    }

    public static final Date getGRANDFATHERED_MONTHLY_END_DATE() {
        return GRANDFATHERED_MONTHLY_END_DATE;
    }

    public static final Date getGRANDFATHERED_YEARLY_END_DATE() {
        return GRANDFATHERED_YEARLY_END_DATE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @DrawableRes
    @SuppressLint({"DefaultLocale"})
    public static final int getPaymentSourceIcon(ModelPaymentSource modelPaymentSource) {
        Intrinsics3.checkNotNullParameter(modelPaymentSource, "paymentSource");
        if (modelPaymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal) {
            return C5419R.drawable.ic_creditcard_paypal;
        }
        if (!(modelPaymentSource instanceof ModelPaymentSource.ModelPaymentSourceCard)) {
            return C5419R.drawable.ic_creditcard_generic;
        }
        String brand = ((ModelPaymentSource.ModelPaymentSourceCard) modelPaymentSource).getBrand();
        Objects.requireNonNull(brand, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = brand.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        switch (lowerCase.hashCode()) {
            case -2038717326:
                if (lowerCase.equals("mastercard")) {
                }
                break;
            case 2997727:
                if (lowerCase.equals("amex")) {
                }
                break;
            case 3619905:
                if (lowerCase.equals("visa")) {
                }
                break;
            case 61060803:
                if (lowerCase.equals("american-express")) {
                }
                break;
            case 273184745:
                if (lowerCase.equals("discover")) {
                }
                break;
            case 1174445979:
                if (lowerCase.equals("master-card")) {
                }
                break;
        }
        return C5419R.drawable.ic_creditcard_generic;
    }
}
