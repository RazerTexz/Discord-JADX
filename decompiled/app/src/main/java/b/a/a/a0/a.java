package b.a.a.a0;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.r;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.app.AppDialog;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSkus;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: GiftPurchasedDialog.kt */
/* loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/GiftPurchasedDialogBinding;", 0)};

    /* renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* compiled from: GiftPurchasedDialog.kt */
    /* renamed from: b.a.a.a0.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: GiftPurchasedDialog.kt */
    public static final /* synthetic */ class b extends k implements Function1<View, r> {
        public static final b j = new b();

        public b() {
            super(1, r.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GiftPurchasedDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public r invoke(View view) {
            View view2 = view;
            m.checkNotNullParameter(view2, "p1");
            int i = R.id.gift_entitlement_code;
            TextView textView = (TextView) view2.findViewById(R.id.gift_entitlement_code);
            if (textView != null) {
                i = R.id.gift_entitlement_code_container;
                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.gift_entitlement_code_container);
                if (relativeLayout != null) {
                    i = R.id.gift_entitlement_copy;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.gift_entitlement_copy);
                    if (materialButton != null) {
                        i = R.id.gift_link_subtext;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R.id.gift_link_subtext);
                        if (linkifiedTextView != null) {
                            i = R.id.gift_purchased_dialog_confirm;
                            MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R.id.gift_purchased_dialog_confirm);
                            if (materialButton2 != null) {
                                i = R.id.gift_purchased_dialog_subtext;
                                TextView textView2 = (TextView) view2.findViewById(R.id.gift_purchased_dialog_subtext);
                                if (textView2 != null) {
                                    i = R.id.gift_purchased_icon;
                                    ImageView imageView = (ImageView) view2.findViewById(R.id.gift_purchased_icon);
                                    if (imageView != null) {
                                        return new r((LinearLayout) view2, textView, relativeLayout, materialButton, linkifiedTextView, materialButton2, textView2, imageView);
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
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0<Unit> function0 = a.this.onDismiss;
            if (function0 != null) {
                function0.invoke();
            }
            a.this.dismiss();
        }
    }

    /* compiled from: GiftPurchasedDialog.kt */
    public static final class d extends o implements Function1<RenderContext, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(RenderContext renderContext) {
            RenderContext renderContext2 = renderContext;
            m.checkNotNullParameter(renderContext2, "$receiver");
            renderContext2.b("onInventoryClick", new b.a.a.a0.b(this));
            return Unit.a;
        }
    }

    /* compiled from: GiftPurchasedDialog.kt */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ String k;

        public e(String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = a.this.getContext();
            if (context != null) {
                m.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
                Object systemService = context.getSystemService("clipboard");
                if (!(systemService instanceof ClipboardManager)) {
                    systemService = null;
                }
                ClipboardManager clipboardManager = (ClipboardManager) systemService;
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText("", this.k));
                }
                a aVar = a.this;
                KProperty[] kPropertyArr = a.j;
                MaterialButton materialButton = aVar.g().d;
                m.checkNotNullExpressionValue(materialButton, "binding.giftEntitlementCopy");
                materialButton.setText(context.getString(R.string.copied));
                a.this.g().c.setBackgroundResource(DrawableCompat.getThemedDrawableRes$default(context, R.attr.gift_code_copied_outline, 0, 2, (Object) null));
            }
        }
    }

    public a() {
        super(R.layout.gift_purchased_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.j, null, 2, null);
    }

    public final r g() {
        return (r) this.binding.getValue((Fragment) this, j[0]);
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().f.setOnClickListener(new c());
        String string = getArgumentsOrDefault().getString("ARG_SKU_NAME");
        GooglePlayInAppSku inAppSku = string != null ? GooglePlayInAppSkus.INSTANCE.getInAppSku(string) : null;
        if ((inAppSku != null ? inAppSku.getSkuDetails() : null) == null) {
            g().f.callOnClick();
            return;
        }
        LinkifiedTextView linkifiedTextView = g().e;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.giftLinkSubtext");
        b.a.k.b.m(linkifiedTextView, R.string.application_store_gift_purchase_confirmation_subtext, new Object[0], new d());
        GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
        Integer iconForSku = giftingUtils.getIconForSku(inAppSku);
        if (iconForSku != null) {
            g().h.setImageResource(iconForSku.intValue());
        }
        Pair pair = SubscriptionPlanType.INSTANCE.from(inAppSku.getPaymentGatewaySkuId()).getInterval() == SubscriptionInterval.MONTHLY ? new Pair(Integer.valueOf(R.string.application_store_gift_purchase_confirm_monthly_mobile), Integer.valueOf(R.plurals.application_store_gift_purchase_confirm_monthly_mobile_intervalCount)) : new Pair(Integer.valueOf(R.string.application_store_gift_purchase_confirm_yearly_mobile), Integer.valueOf(R.plurals.application_store_gift_purchase_confirm_yearly_mobile_intervalCount));
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        String string2 = getString(giftingUtils.getTierForSku(inAppSku.getSkuId()) == PremiumTier.TIER_1 ? R.string.premium_tier_1 : R.string.premium_tier_2);
        m.checkNotNullExpressionValue(string2, "getString(\n        if (G…ring.premium_tier_2\n    )");
        TextView textView = g().g;
        m.checkNotNullExpressionValue(textView, "binding.giftPurchasedDialogSubtext");
        Object[] objArr = new Object[2];
        Context context = getContext();
        objArr[0] = context != null ? StringResourceUtilsKt.getI18nPluralString(context, iIntValue2, 1, 1) : null;
        objArr[1] = string2;
        textView.setText(b.a.k.b.k(this, iIntValue, objArr, null, 4));
        String string3 = getArgumentsOrDefault().getString("ARG_GIFT_CODE", "");
        m.checkNotNullExpressionValue(string3, "giftCode");
        String strGenerateGiftUrl = giftingUtils.generateGiftUrl(string3);
        TextView textView2 = g().f189b;
        m.checkNotNullExpressionValue(textView2, "binding.giftEntitlementCode");
        textView2.setText(strGenerateGiftUrl);
        g().d.setOnClickListener(new e(strGenerateGiftUrl));
    }
}
