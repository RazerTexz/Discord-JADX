package com.discord.widgets.stickers;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.PremiumStickerUpsellDialogBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StickerPremiumUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(StickerPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/PremiumStickerUpsellDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Traits.Location analyticsLocation) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(analyticsLocation, "analyticsLocation");
            AnalyticsTracker.INSTANCE.openModal(Traits.Location.Section.STICKER_PREMIUM_TIER_2_UPSELL_MODAL, analyticsLocation);
            new StickerPremiumUpsellDialog().show(fragmentManager, StickerPremiumUpsellDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.StickerPremiumUpsellDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
    public static final class ViewOnClickListenerC101271 implements View.OnClickListener {
        public ViewOnClickListenerC101271() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StickerPremiumUpsellDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.StickerPremiumUpsellDialog$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
    public static final class ViewOnClickListenerC101282 implements View.OnClickListener {
        public ViewOnClickListenerC101282() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StickerPremiumUpsellDialog.this.dismiss();
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            Context contextRequireContext = StickerPremiumUpsellDialog.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launch(contextRequireContext, 1, Traits.Location.Section.STICKER_PREMIUM_TIER_2_UPSELL_MODAL);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.StickerPremiumUpsellDialog$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: StickerPremiumUpsellDialog.kt */
    public static final class ViewOnClickListenerC101293 implements View.OnClickListener {
        public ViewOnClickListenerC101293() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StickerPremiumUpsellDialog.this.dismiss();
        }
    }

    public StickerPremiumUpsellDialog() {
        super(C5419R.layout.premium_sticker_upsell_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, StickerPremiumUpsellDialog2.INSTANCE, null, 2, null);
    }

    private final PremiumStickerUpsellDialogBinding getBinding() {
        return (PremiumStickerUpsellDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        requireDialog().setCanceledOnTouchOutside(true);
        String skuPrice = PremiumUtils.INSTANCE.getSkuPrice(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName());
        if (skuPrice != null) {
            TextView textView = getBinding().f15216d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumUpsellDescription");
            FormatUtils.m222n(textView, C5419R.string.premium_upsell_feature_pretext, new Object[]{skuPrice}, null, 4);
        } else {
            TextView textView2 = getBinding().f15216d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumUpsellDescription");
            FormatUtils.m222n(textView2, C5419R.string.premium_upsell_feature_pretext_without_price, new Object[0], null, 4);
        }
        TextView textView3 = getBinding().f15217e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.premiumUpsellPerkBoosts");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.m222n(textView3, C5419R.string.premium_upsell_feature_free_guild_subscription, new Object[]{StringResourceUtils.getI18nPluralString(contextRequireContext, C5419R.plurals.premium_upsell_feature_free_guild_subscription_numFreeGuildSubscriptions, 2, 2)}, null, 4);
        getBinding().f15215c.setOnClickListener(new ViewOnClickListenerC101271());
        getBinding().f15218f.setOnClickListener(new ViewOnClickListenerC101282());
        getBinding().f15214b.setOnClickListener(new ViewOnClickListenerC101293());
    }
}
