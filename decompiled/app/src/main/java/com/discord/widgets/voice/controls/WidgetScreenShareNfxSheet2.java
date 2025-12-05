package com.discord.widgets.voice.controls;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetScreenShareNfxSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetScreenShareNfxSheet.kt */
/* renamed from: com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetScreenShareNfxSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetScreenShareNfxSheetBinding> {
    public static final WidgetScreenShareNfxSheet2 INSTANCE = new WidgetScreenShareNfxSheet2();

    public WidgetScreenShareNfxSheet2() {
        super(1, WidgetScreenShareNfxSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetScreenShareNfxSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetScreenShareNfxSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetScreenShareNfxSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.screen_share_nfx_cancel_button;
        TextView textView = (TextView) view.findViewById(C5419R.id.screen_share_nfx_cancel_button);
        if (textView != null) {
            i = C5419R.id.screen_share_nfx_cta;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.screen_share_nfx_cta);
            if (materialButton != null) {
                return new WidgetScreenShareNfxSheetBinding((NestedScrollView) view, textView, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
