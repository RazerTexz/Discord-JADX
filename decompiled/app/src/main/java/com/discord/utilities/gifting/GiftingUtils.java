package com.discord.utilities.gifting;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelSkuKt;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSkuKt;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.DurationUnit;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.gson.JsonIOException;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: GiftingUtils.kt */
/* loaded from: classes2.dex */
public final class GiftingUtils {
    public static final GiftingUtils INSTANCE = new GiftingUtils();
    public static final long PREMIUM_SUBSCRIPTION_APPLICATION_ID = 521842831262875670L;

    /* compiled from: GiftingUtils.kt */
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

    /* compiled from: GiftingUtils.kt */
    /* renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ FragmentActivity $activity;
        public final /* synthetic */ BillingFlowParams $billingParams;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FragmentActivity fragmentActivity, BillingFlowParams billingFlowParams) {
            super(0);
            this.$activity = fragmentActivity;
            this.$billingParams = billingFlowParams;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GooglePlayBillingManager googlePlayBillingManager = GooglePlayBillingManager.INSTANCE;
            if (googlePlayBillingManager.launchBillingFlow(this.$activity, this.$billingParams) == 7) {
                googlePlayBillingManager.queryPurchases();
            }
        }
    }

    /* compiled from: GiftingUtils.kt */
    /* renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<View, Unit> {
        public final /* synthetic */ GooglePlayInAppSku $inAppSku;
        public final /* synthetic */ AnonymousClass1 $launchBillingFlow$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(GooglePlayInAppSku googlePlayInAppSku, AnonymousClass1 anonymousClass1) {
            super(1);
            this.$inAppSku = googlePlayInAppSku;
            this.$launchBillingFlow$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) throws JsonIOException {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) throws JsonIOException {
            m.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getGooglePlayPurchases().trackPaymentFlowStep(this.$inAppSku.getPaymentGatewaySkuId(), "warning_dialog", "");
            this.$launchBillingFlow$1.invoke2();
        }
    }

    /* compiled from: GiftingUtils.kt */
    /* renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $dismissWarningCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function0 function0) {
            super(1);
            this.$dismissWarningCallback = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "it");
            Function0 function0 = this.$dismissWarningCallback;
            if (function0 != null) {
            }
        }
    }

    /* compiled from: GiftingUtils.kt */
    /* renamed from: com.discord.utilities.gifting.GiftingUtils$buyGift$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function0<Unit> {
        public final /* synthetic */ Function0 $dismissWarningCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Function0 function0) {
            super(0);
            this.$dismissWarningCallback = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
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
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(inAppSku, "inAppSku");
        m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
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
        BillingFlowParams.a aVar = new BillingFlowParams.a();
        ArrayList<SkuDetails> arrayList = new ArrayList<>();
        arrayList.add(skuDetails);
        aVar.d = arrayList;
        aVar.a = obfuscatedUserId;
        BillingFlowParams billingFlowParamsA = aVar.a();
        m.checkNotNullExpressionValue(billingFlowParamsA, "BillingFlowParams\n      …dUserId)\n        .build()");
        Long skuId = inAppSku.getSkuId();
        if (skuId == null) {
            throw new Exception("No skuId for " + inAppSku);
        }
        long jLongValue = skuId.longValue();
        StoreGooglePlayPurchases googlePlayPurchases = companion.getGooglePlayPurchases();
        String paymentGatewaySkuId = inAppSku.getPaymentGatewaySkuId();
        int id2 = SkuTypes.SUBSCRIPTION.getId();
        String strA = skuDetails.a();
        m.checkNotNullExpressionValue(strA, "skuDetails.description");
        Traits.StoreSku storeSku = new Traits.StoreSku(jLongValue, id2, 521842831262875670L, strA);
        PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
        int iMicroAmountToMinor = premiumUtils.microAmountToMinor(skuDetails.c());
        int iMicroAmountToMinor2 = premiumUtils.microAmountToMinor(skuDetails.f2006b.has("original_price_micros") ? skuDetails.f2006b.optLong("original_price_micros") : skuDetails.c());
        String strOptString = skuDetails.f2006b.optString("price_currency_code");
        m.checkNotNullExpressionValue(strOptString, "skuDetails.priceCurrencyCode");
        Locale locale = Locale.ROOT;
        m.checkNotNullExpressionValue(locale, "Locale.ROOT");
        Objects.requireNonNull(strOptString, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strOptString.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        googlePlayPurchases.trackPaymentFlowStarted(paymentGatewaySkuId, jLongValue, location, storeSku, new Traits.Payment(Traits.Payment.Type.SUBSCRIPTION, iMicroAmountToMinor, iMicroAmountToMinor2, lowerCase, true));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(activity, billingFlowParamsA);
        if (companion.getGooglePlayPurchases().hasSeenGiftingWarning()) {
            anonymousClass1.invoke2();
            return;
        }
        WidgetNoticeDialog.Companion companion2 = WidgetNoticeDialog.INSTANCE;
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String string = activity.getString(R.string.dialog_just_so_you_know);
        String string2 = activity.getString(R.string.gift_purchase_google_play_notice_extended);
        m.checkNotNullExpressionValue(string2, "activity.getString(R.str…gle_play_notice_extended)");
        WidgetNoticeDialog.Companion.show$default(companion2, supportFragmentManager, string, string2, activity.getString(R.string.application_store_buy_gift), activity.getString(R.string.nevermind), h0.mapOf(d0.o.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass2(inAppSku, anonymousClass1)), d0.o.to(Integer.valueOf(R.id.notice_cancel), new AnonymousClass3(dismissWarningCallback))), null, null, null, null, null, null, 0, new AnonymousClass4(dismissWarningCallback), 8128, null);
        companion.getGooglePlayPurchases().markViewedGiftingWarning();
    }

    public final String generateGiftUrl(String giftCode) {
        m.checkNotNullParameter(giftCode, "giftCode");
        return "https://discord.gift/" + giftCode;
    }

    public final Integer getIconForSku(GooglePlayInAppSku inAppSku) {
        m.checkNotNullParameter(inAppSku, "inAppSku");
        if (m.areEqual(inAppSku, GooglePlayInAppSkuKt.getPremiumTier1Month())) {
            return Integer.valueOf(R.drawable.ic_plan_premium_tier_1);
        }
        if (m.areEqual(inAppSku, GooglePlayInAppSkuKt.getPremiumTier1Year())) {
            return Integer.valueOf(R.drawable.ic_plan_premium_tier_1_year);
        }
        if (m.areEqual(inAppSku, GooglePlayInAppSkuKt.getPremiumTier2Month())) {
            return Integer.valueOf(R.drawable.ic_plan_premium_tier_2);
        }
        if (m.areEqual(inAppSku, GooglePlayInAppSkuKt.getPremiumTier2Year())) {
            return Integer.valueOf(R.drawable.ic_plan_premium_tier_2_year);
        }
        return null;
    }

    public final PremiumTier getTierForSku(Long skuId) {
        if (skuId != null && skuId.longValue() == ModelSkuKt.PREMIUM_TIER_1_SKU_ID) {
            return PremiumTier.TIER_1;
        }
        if (skuId != null && skuId.longValue() == ModelSkuKt.PREMIUM_TIER_2_SKU_ID) {
            return PremiumTier.TIER_2;
        }
        return null;
    }

    public final CharSequence getTimeString(long millis, Context context) {
        m.checkNotNullParameter(context, "context");
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int hoursFromMillis = timeUtils.getHoursFromMillis(millis);
        if (hoursFromMillis > 0) {
            return DurationUtilsKt.formatDuration(context, DurationUnit.HOURS, hoursFromMillis);
        }
        return DurationUtilsKt.formatDuration(context, DurationUnit.MINS, timeUtils.getMinutesFromMillis(millis));
    }
}
