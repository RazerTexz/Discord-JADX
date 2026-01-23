package com.discord.utilities.gifting;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.SkuDetails;
import com.discord.C5419R;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSku4;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSku2;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.DurationUtils2;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.notice.WidgetNoticeDialog;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: GiftingUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftingUtils {
    public static final GiftingUtils INSTANCE = new GiftingUtils();
    public static final long PREMIUM_SUBSCRIPTION_APPLICATION_ID = 521842831262875670L;

    /* JADX INFO: compiled from: GiftingUtils.kt */
    public enum SkuTypes {
        DURABLE_PRIMARY(1),
        DURABLE(2),
        CONSUMABLE(3),
        BUNDLE(4),
        SUBSCRIPTION(5);

        private final int id;

        SkuTypes(int i) {
            this.id = i;
        }

        public final int getId() {
            return this.id;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$1 */
    /* JADX INFO: compiled from: GiftingUtils.kt */
    public static final class C67611 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FragmentActivity $activity;
        public final /* synthetic */ BillingFlowParams $billingParams;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67611(FragmentActivity fragmentActivity, BillingFlowParams billingFlowParams) {
            super(0);
            this.$activity = fragmentActivity;
            this.$billingParams = billingFlowParams;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (googlePlayBillingManager.launchBillingFlow(this.$activity, this.$billingParams) == 7) {
                googlePlayBillingManager.queryPurchases();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$2 */
    /* JADX INFO: compiled from: GiftingUtils.kt */
    public static final class C67622 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ GooglePlayInAppSku $inAppSku;
        public final /* synthetic */ C67611 $launchBillingFlow$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67622(GooglePlayInAppSku googlePlayInAppSku, C67611 c67611) {
            super(1);
            this.$inAppSku = googlePlayInAppSku;
            this.$launchBillingFlow$1 = c67611;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowStep(this.$inAppSku.getPaymentGatewaySkuId(), "warning_dialog", "");
            this.$launchBillingFlow$1.invoke2();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$3 */
    /* JADX INFO: compiled from: GiftingUtils.kt */
    public static final class C67633 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $dismissWarningCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67633(Function0 function0) {
            super(1);
            this.$dismissWarningCallback = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            Function0 function0 = this.$dismissWarningCallback;
            if (function0 != null) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$4 */
    /* JADX INFO: compiled from: GiftingUtils.kt */
    public static final class C67644 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 $dismissWarningCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67644(Function0 function0) {
            super(0);
            this.$dismissWarningCallback = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0 = this.$dismissWarningCallback;
            if (function0 != null) {
            }
        }
    }

    private GiftingUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void buyGift$default(GiftingUtils giftingUtils, FragmentActivity fragmentActivity, GooglePlayInAppSku googlePlayInAppSku, Traits.Location location, Function0 function0, int i, Object obj) throws Exception {
        if ((i & 8) != 0) {
            function0 = null;
        }
        giftingUtils.buyGift(fragmentActivity, googlePlayInAppSku, location, function0);
    }

    public final void buyGift(FragmentActivity activity, GooglePlayInAppSku inAppSku, Traits.Location location, Function0<Unit> dismissWarningCallback) throws Exception {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(inAppSku, "inAppSku");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        SkuDetails skuDetails = inAppSku.getSkuDetails();
        if (skuDetails == null) {
            throw new Exception("No skuDetails for " + inAppSku);
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        String obfuscatedUserId = userUtils.getObfuscatedUserId(Long.valueOf(companion.getUsers().getMeSnapshot().getId()));
        if (obfuscatedUserId == null) {
            throw new Exception("No current user ID");
        }
        BillingFlowParams.C5412a c5412a = new BillingFlowParams.C5412a();
        ArrayList<SkuDetails> arrayList = new ArrayList<>();
        arrayList.add(skuDetails);
        c5412a.f14556d = arrayList;
        c5412a.f14553a = obfuscatedUserId;
        BillingFlowParams billingFlowParamsM7495a = c5412a.m7495a();
        Intrinsics3.checkNotNullExpressionValue(billingFlowParamsM7495a, "BillingFlowParams\n      …dUserId)\n        .build()");
        Long skuId = inAppSku.getSkuId();
        if (skuId == null) {
            throw new Exception("No skuId for " + inAppSku);
        }
        long jLongValue = skuId.longValue();
        StoreGooglePlayPurchases googlePlayPurchases = companion.getGooglePlayPurchases();
        String paymentGatewaySkuId = inAppSku.getPaymentGatewaySkuId();
        int id2 = SkuTypes.SUBSCRIPTION.getId();
        String strM7500a = skuDetails.m7500a();
        Intrinsics3.checkNotNullExpressionValue(strM7500a, "skuDetails.description");
        Traits.StoreSku storeSku = new Traits.StoreSku(jLongValue, id2, 521842831262875670L, strM7500a);
        PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
        int iMicroAmountToMinor = premiumUtils.microAmountToMinor(skuDetails.m7502c());
        int iMicroAmountToMinor2 = premiumUtils.microAmountToMinor(skuDetails.f14567b.has("original_price_micros") ? skuDetails.f14567b.optLong("original_price_micros") : skuDetails.m7502c());
        String strOptString = skuDetails.f14567b.optString("price_currency_code");
        Intrinsics3.checkNotNullExpressionValue(strOptString, "skuDetails.priceCurrencyCode");
        Locale locale = Locale.ROOT;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(strOptString, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strOptString.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        googlePlayPurchases.trackPaymentFlowStarted(paymentGatewaySkuId, jLongValue, location, storeSku, new Traits.Payment(Traits.Payment.Type.SUBSCRIPTION, iMicroAmountToMinor, iMicroAmountToMinor2, lowerCase, true));
        C67611 c67611 = new C67611(activity, billingFlowParamsM7495a);
        if (companion.getGooglePlayPurchases().hasSeenGiftingWarning()) {
            c67611.invoke2();
            return;
        }
        WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String string = activity.getString(C5419R.string.dialog_just_so_you_know);
        String string2 = activity.getString(C5419R.string.gift_purchase_google_play_notice_extended);
        Intrinsics3.checkNotNullExpressionValue(string2, "activity.getString(R.str…gle_play_notice_extended)");
        WidgetNoticeDialog.Companion.show$default(companion2, supportFragmentManager, string, string2, activity.getString(C5419R.string.application_store_buy_gift), activity.getString(C5419R.string.nevermind), Maps6.mapOf(Tuples.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C67622(inAppSku, c67611)), Tuples.m10073to(Integer.valueOf(C5419R.id.notice_cancel), new C67633(dismissWarningCallback))), null, null, null, null, null, null, 0, new C67644(dismissWarningCallback), 8128, null);
        companion.getGooglePlayPurchases().markViewedGiftingWarning();
    }

    public final String generateGiftUrl(String giftCode) {
        Intrinsics3.checkNotNullParameter(giftCode, "giftCode");
        return "https://discord.gift/" + giftCode;
    }

    public final Integer getIconForSku(GooglePlayInAppSku inAppSku) {
        Intrinsics3.checkNotNullParameter(inAppSku, "inAppSku");
        if (Intrinsics3.areEqual(inAppSku, GooglePlayInAppSku2.getPremiumTier1Month())) {
            return Integer.valueOf(C5419R.drawable.ic_plan_premium_tier_1);
        }
        if (Intrinsics3.areEqual(inAppSku, GooglePlayInAppSku2.getPremiumTier1Year())) {
            return Integer.valueOf(C5419R.drawable.ic_plan_premium_tier_1_year);
        }
        if (Intrinsics3.areEqual(inAppSku, GooglePlayInAppSku2.getPremiumTier2Month())) {
            return Integer.valueOf(C5419R.drawable.ic_plan_premium_tier_2);
        }
        if (Intrinsics3.areEqual(inAppSku, GooglePlayInAppSku2.getPremiumTier2Year())) {
            return Integer.valueOf(C5419R.drawable.ic_plan_premium_tier_2_year);
        }
        return null;
    }

    public final PremiumTier getTierForSku(Long skuId) {
        if (skuId != null && skuId.longValue() == ModelSku4.PREMIUM_TIER_1_SKU_ID) {
            return PremiumTier.TIER_1;
        }
        if (skuId != null && skuId.longValue() == ModelSku4.PREMIUM_TIER_2_SKU_ID) {
            return PremiumTier.TIER_2;
        }
        return null;
    }

    public final CharSequence getTimeString(long millis, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int hoursFromMillis = timeUtils.getHoursFromMillis(millis);
        if (hoursFromMillis > 0) {
            return DurationUtils3.formatDuration(context, DurationUtils2.HOURS, hoursFromMillis);
        }
        return DurationUtils3.formatDuration(context, DurationUtils2.MINS, timeUtils.getMinutesFromMillis(millis));
    }
}
