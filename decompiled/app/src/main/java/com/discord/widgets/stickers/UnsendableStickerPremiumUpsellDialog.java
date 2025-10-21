package com.discord.widgets.stickers;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerPremiumUpsellDialogBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: UnsendableStickerPremiumUpsellDialog.kt */
/* loaded from: classes.dex */
public final class UnsendableStickerPremiumUpsellDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(UnsendableStickerPremiumUpsellDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerPremiumUpsellDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: UnsendableStickerPremiumUpsellDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            new UnsendableStickerPremiumUpsellDialog().show(fragmentManager, UnsendableStickerPremiumUpsellDialog.class.getSimpleName());
            AnalyticsTracker.premiumUpsellViewed$default(AnalyticsTracker.INSTANCE, AnalyticsTracker.PremiumUpsellType.StickerPickerUpsell, new Traits.Location(null, Traits.Location.Section.STICKER_PICKER_UPSELL, null, null, null, 29, null), null, null, 12, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UnsendableStickerPremiumUpsellDialog.kt */
    /* renamed from: com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UnsendableStickerPremiumUpsellDialog.this.dismiss();
        }
    }

    /* compiled from: UnsendableStickerPremiumUpsellDialog.kt */
    /* renamed from: com.discord.widgets.stickers.UnsendableStickerPremiumUpsellDialog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
            Context contextRequireContext = UnsendableStickerPremiumUpsellDialog.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, Traits.Location.Section.EXPRESSION_PICKER, 2, null);
            UnsendableStickerPremiumUpsellDialog.this.dismiss();
        }
    }

    public UnsendableStickerPremiumUpsellDialog() {
        super(R.layout.sticker_premium_upsell_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, UnsendableStickerPremiumUpsellDialog2.INSTANCE, null, 2, null);
    }

    private final StickerPremiumUpsellDialogBinding getBinding() {
        return (StickerPremiumUpsellDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stickerPremiumUpsellDescription");
        textView.setText(FormatUtils.k(this, R.string.premium_upsell_global_stickers_description_mobile, new Object[0], null, 4));
        getBinding().f2154b.setOnClickListener(new AnonymousClass1());
        getBinding().d.setOnClickListener(new AnonymousClass2());
    }
}
