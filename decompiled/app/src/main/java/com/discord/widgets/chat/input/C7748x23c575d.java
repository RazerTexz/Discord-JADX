package com.discord.widgets.chat.input;

import com.discord.api.sticker.Sticker;
import com.discord.widgets.chat.input.sticker.StickerPickerListener;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatInputAttachments.kt */
/* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$stickerPickerListener$1 */
/* loaded from: classes2.dex */
public final class C7748x23c575d implements StickerPickerListener {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    public C7748x23c575d(WidgetChatInputAttachments widgetChatInputAttachments) {
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
    public void onStickerPicked(Sticker sticker) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        FlexInputViewModel flexInputViewModel = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.hideExpressionTray();
        }
    }
}
