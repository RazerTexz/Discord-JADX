package com.discord.widgets.stickers;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.PremiumStickerUpsellDialogBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StickerPremiumUpsellDialog.kt */
/* renamed from: com.discord.widgets.stickers.StickerPremiumUpsellDialog$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class StickerPremiumUpsellDialog2 extends FunctionReferenceImpl implements Function1<View, PremiumStickerUpsellDialogBinding> {
    public static final StickerPremiumUpsellDialog2 INSTANCE = new StickerPremiumUpsellDialog2();

    public StickerPremiumUpsellDialog2() {
        super(1, PremiumStickerUpsellDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumStickerUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ PremiumStickerUpsellDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final PremiumStickerUpsellDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.close_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.close_button);
        if (textView != null) {
            i = C5419R.id.premium_upsell_close;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.premium_upsell_close);
            if (imageView != null) {
                i = C5419R.id.premium_upsell_description;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.premium_upsell_description);
                if (textView2 != null) {
                    i = C5419R.id.premium_upsell_perk_boosts;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.premium_upsell_perk_boosts);
                    if (textView3 != null) {
                        i = C5419R.id.subscribe_button;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.subscribe_button);
                        if (materialButton != null) {
                            return new PremiumStickerUpsellDialogBinding((RelativeLayout) view, textView, imageView, textView2, textView3, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
