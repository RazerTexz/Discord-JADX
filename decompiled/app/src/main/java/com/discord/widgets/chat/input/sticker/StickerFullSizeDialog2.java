package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.databinding.StickerFullSizeDialogBinding;
import com.discord.views.sticker.StickerView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerFullSizeDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: StickerFullSizeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StickerFullSizeDialog2 extends FunctionReferenceImpl implements Function1<View, StickerFullSizeDialogBinding> {
    public static final StickerFullSizeDialog2 INSTANCE = new StickerFullSizeDialog2();

    public StickerFullSizeDialog2() {
        super(1, StickerFullSizeDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerFullSizeDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StickerFullSizeDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StickerFullSizeDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.sticker_full_size_sticker);
        if (stickerView != null) {
            return new StickerFullSizeDialogBinding((FrameLayout) view, stickerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.sticker_full_size_sticker)));
    }
}
