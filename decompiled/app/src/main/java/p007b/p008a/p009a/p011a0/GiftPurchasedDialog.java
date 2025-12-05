package p007b.p008a.p009a.p011a0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.app.AppDialog;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSku3;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.GiftPurchasedDialogBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: GiftPurchasedDialog.kt */
/* renamed from: b.a.a.a0.a, reason: use source file name */
/* loaded from: classes.dex */
public final class GiftPurchasedDialog extends AppDialog {

    /* renamed from: j */
    public static final /* synthetic */ KProperty[] f224j = {outline.m846d0(GiftPurchasedDialog.class, "binding", "getBinding()Lcom/discord/databinding/GiftPurchasedDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: GiftPurchasedDialog.kt */
    /* renamed from: b.a.a.a0.a$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GiftPurchasedDialog.kt */
    /* renamed from: b.a.a.a0.a$b */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, GiftPurchasedDialogBinding> {

        /* renamed from: j */
        public static final b f228j = new b();

        public b() {
            super(1, GiftPurchasedDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GiftPurchasedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GiftPurchasedDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.gift_entitlement_code;
            TextView textView = (TextView) view2.findViewById(C5419R.id.gift_entitlement_code);
            if (textView != null) {
                i = C5419R.id.gift_entitlement_code_container;
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(C5419R.id.gift_entitlement_code_container);
                if (relativeLayout != null) {
                    i = C5419R.id.gift_entitlement_copy;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.gift_entitlement_copy);
                    if (materialButton != null) {
                        i = C5419R.id.gift_link_subtext;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(C5419R.id.gift_link_subtext);
                        if (linkifiedTextView != null) {
                            i = C5419R.id.gift_purchased_dialog_confirm;
                            MaterialButton materialButton2 = (MaterialButton) view2.findViewById(C5419R.id.gift_purchased_dialog_confirm);
                            if (materialButton2 != null) {
                                i = C5419R.id.gift_purchased_dialog_subtext;
                                TextView textView2 = (TextView) view2.findViewById(C5419R.id.gift_purchased_dialog_subtext);
                                if (textView2 != null) {
                                    i = C5419R.id.gift_purchased_icon;
                                    ImageView imageView = (ImageView) view2.findViewById(C5419R.id.gift_purchased_icon);
                                    if (imageView != null) {
                                        return new GiftPurchasedDialogBinding((LinearLayout) view2, textView, relativeLayout, materialButton, linkifiedTextView, materialButton2, textView2, imageView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* compiled from: GiftPurchasedDialog.kt */
    /* renamed from: b.a.a.a0.a$c */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> function0 = GiftPurchasedDialog.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            GiftPurchasedDialog.this.dismiss();
        }
    }

    /* compiled from: GiftPurchasedDialog.kt */
    /* renamed from: b.a.a.a0.a$d */
    public static final class d extends Lambda implements Function1<RenderContext, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            RenderContext renderContext2 = renderContext;
            Intrinsics3.checkNotNullParameter(renderContext2, "$receiver");
            renderContext2.m8423b("onInventoryClick", new GiftPurchasedDialog2(this));
            return Unit.f27425a;
        }
    }

    /* compiled from: GiftPurchasedDialog.kt */
    /* renamed from: b.a.a.a0.a$e */
    public static final class e implements View.OnClickListener {

        /* renamed from: k */
        public final /* synthetic */ String f231k;

        public e(String str) {
            this.f231k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = GiftPurchasedDialog.this.getContext();
            if (context != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
                Object systemService = context.getSystemService("clipboard");
                if (!(systemService instanceof ClipboardManager)) {
                    systemService = null;
                }
                ClipboardManager clipboardManager = (ClipboardManager) systemService;
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("", this.f231k));
                }
                GiftPurchasedDialog giftPurchasedDialog = GiftPurchasedDialog.this;
                KProperty[] kPropertyArr = GiftPurchasedDialog.f224j;
                MaterialButton materialButton = giftPurchasedDialog.m103g().f1168d;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.giftEntitlementCopy");
                materialButton.setText(context.getString(C5419R.string.copied));
                GiftPurchasedDialog.this.m103g().f1167c.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.gift_code_copied_outline, 0, 2, (Object) null));
            }
        }
    }

    public GiftPurchasedDialog() {
        super(C5419R.layout.gift_purchased_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.f228j, null, 2, null);
    }

    /* renamed from: g */
    public final GiftPurchasedDialogBinding m103g() {
        return (GiftPurchasedDialogBinding) this.binding.getValue((Fragment) this, f224j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.onDismiss == null) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        m103g().f1170f.setOnClickListener(new c());
        String string = getArgumentsOrDefault().getString("ARG_SKU_NAME");
        GooglePlayInAppSku inAppSku = string != null ? GooglePlayInAppSku3.INSTANCE.getInAppSku(string) : null;
        if ((inAppSku != null ? inAppSku.getSkuDetails() : null) == null) {
            m103g().f1170f.callOnClick();
            return;
        }
        LinkifiedTextView linkifiedTextView = m103g().f1169e;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.giftLinkSubtext");
        FormatUtils.m221m(linkifiedTextView, C5419R.string.application_store_gift_purchase_confirmation_subtext, new Object[0], new d());
        GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
        Integer iconForSku = giftingUtils.getIconForSku(inAppSku);
        if (iconForSku != null) {
            m103g().f1172h.setImageResource(iconForSku.intValue());
        }
        Tuples2 tuples2 = SubscriptionPlanType.INSTANCE.from(inAppSku.getPaymentGatewaySkuId()).getInterval() == SubscriptionInterval.MONTHLY ? new Tuples2(Integer.valueOf(C5419R.string.application_store_gift_purchase_confirm_monthly_mobile), Integer.valueOf(C5419R.plurals.application_store_gift_purchase_confirm_monthly_mobile_intervalCount)) : new Tuples2(Integer.valueOf(C5419R.string.application_store_gift_purchase_confirm_yearly_mobile), Integer.valueOf(C5419R.plurals.application_store_gift_purchase_confirm_yearly_mobile_intervalCount));
        int iIntValue = ((Number) tuples2.component1()).intValue();
        int iIntValue2 = ((Number) tuples2.component2()).intValue();
        String string2 = getString(giftingUtils.getTierForSku(inAppSku.getSkuId()) == PremiumTier.TIER_1 ? C5419R.string.premium_tier_1 : C5419R.string.premium_tier_2);
        Intrinsics3.checkNotNullExpressionValue(string2, "getString(\n        if (G…ring.premium_tier_2\n    )");
        TextView textView = m103g().f1171g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.giftPurchasedDialogSubtext");
        Object[] objArr = new Object[2];
        Context context = getContext();
        objArr[0] = context != null ? StringResourceUtils.getI18nPluralString(context, iIntValue2, 1, 1) : null;
        objArr[1] = string2;
        textView.setText(FormatUtils.m219k(this, iIntValue, objArr, null, 4));
        String string3 = getArgumentsOrDefault().getString("ARG_GIFT_CODE", "");
        Intrinsics3.checkNotNullExpressionValue(string3, "giftCode");
        String strGenerateGiftUrl = giftingUtils.generateGiftUrl(string3);
        TextView textView2 = m103g().f1166b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.giftEntitlementCode");
        textView2.setText(strGenerateGiftUrl);
        m103g().f1168d.setOnClickListener(new e(strGenerateGiftUrl));
    }
}
