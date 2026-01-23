package com.discord.widgets.settings.premium;

import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.gifting.GiftingUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$chooseGiftCallback$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting3 extends Lambda implements Function1<GooglePlayInAppSku, Unit> {
    public final /* synthetic */ Traits.Location $locationTrait;
    public final /* synthetic */ WidgetSettingsGifting this$0;

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGifting$onViewBound$chooseGiftCallback$1$1 */
    /* JADX INFO: compiled from: WidgetSettingsGifting.kt */
    public static final class C99141 extends Lambda implements Function0<Unit> {
        public C99141() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGifting.access$enableGiftingButtons(WidgetSettingsGifting3.this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGifting3(WidgetSettingsGifting widgetSettingsGifting, Traits.Location location) {
        super(1);
        this.this$0 = widgetSettingsGifting;
        this.$locationTrait = location;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GooglePlayInAppSku googlePlayInAppSku) {
        invoke2(googlePlayInAppSku);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GooglePlayInAppSku googlePlayInAppSku) {
        Intrinsics3.checkNotNullParameter(googlePlayInAppSku, "inAppSku");
        try {
            GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
            AppActivity appActivityRequireAppActivity = this.this$0.requireAppActivity();
            Traits.Location location = this.$locationTrait;
            if (location == null) {
                location = new Traits.Location("Gifting Settings", null, null, null, null, 30, null);
            }
            giftingUtils.buyGift(appActivityRequireAppActivity, googlePlayInAppSku, location, new C99141());
        } catch (Exception unused) {
            WidgetSettingsGifting widgetSettingsGifting = this.this$0;
            AppToast.m172j(widgetSettingsGifting, FormatUtils.m219k(widgetSettingsGifting, C5419R.string.error_occurred_try_again, new Object[0], null, 4), 0, 4);
        }
    }
}
