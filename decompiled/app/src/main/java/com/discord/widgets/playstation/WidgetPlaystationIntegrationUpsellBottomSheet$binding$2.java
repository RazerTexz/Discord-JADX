package com.discord.widgets.playstation;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetPlaystationUpsellBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetPlaystationIntegrationUpsellBottomSheet$binding$2 extends k implements Function1<View, WidgetPlaystationUpsellBottomSheetBinding> {
    public static final WidgetPlaystationIntegrationUpsellBottomSheet$binding$2 INSTANCE = new WidgetPlaystationIntegrationUpsellBottomSheet$binding$2();

    public WidgetPlaystationIntegrationUpsellBottomSheet$binding$2() {
        super(1, WidgetPlaystationUpsellBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPlaystationUpsellBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPlaystationUpsellBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPlaystationUpsellBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.cancel_button);
        if (materialButton != null) {
            i = R.id.confirm_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.confirm_button);
            if (materialButton2 != null) {
                i = R.id.upsell_body;
                TextView textView = (TextView) view.findViewById(R.id.upsell_body);
                if (textView != null) {
                    i = R.id.upsell_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.upsell_header);
                    if (textView2 != null) {
                        i = R.id.upsell_image;
                        ImageView imageView = (ImageView) view.findViewById(R.id.upsell_image);
                        if (imageView != null) {
                            return new WidgetPlaystationUpsellBottomSheetBinding((NestedScrollView) view, materialButton, materialButton2, textView, textView2, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
