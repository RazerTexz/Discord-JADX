package com.discord.widgets.stickers;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUnknownStickerSheetBinding;
import com.discord.views.sticker.StickerView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetUnknownStickerSheet.kt */
/* renamed from: com.discord.widgets.stickers.WidgetUnknownStickerSheet$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUnknownStickerSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetUnknownStickerSheetBinding> {
    public static final WidgetUnknownStickerSheet2 INSTANCE = new WidgetUnknownStickerSheet2();

    public WidgetUnknownStickerSheet2() {
        super(1, WidgetUnknownStickerSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUnknownStickerSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUnknownStickerSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUnknownStickerSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.unknown_sticker_sheet_sticker;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.unknown_sticker_sheet_sticker);
        if (stickerView != null) {
            i = C5419R.id.unknown_sticker_sheet_sticker_name;
            TextView textView = (TextView) view.findViewById(C5419R.id.unknown_sticker_sheet_sticker_name);
            if (textView != null) {
                return new WidgetUnknownStickerSheetBinding((LinearLayout) view, stickerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
