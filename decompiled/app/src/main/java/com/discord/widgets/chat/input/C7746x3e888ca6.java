package com.discord.widgets.chat.input;

import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatInputAttachments.kt */
/* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1 */
/* loaded from: classes2.dex */
public final class C7746x3e888ca6 implements EmojiPickerListener {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    public C7746x3e888ca6(WidgetChatInputAttachments widgetChatInputAttachments) {
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
    public void onEmojiPicked(Emoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0);
        String chatInputText = emoji.getChatInputText();
        Intrinsics3.checkNotNullExpressionValue(chatInputText, "emoji.chatInputText");
        Objects.requireNonNull(flexInputFragmentAccess$getFlexInputFragment$p);
        Intrinsics3.checkNotNullParameter(chatInputText, "emojiText");
        FlexInputViewModel flexInputViewModel = flexInputFragmentAccess$getFlexInputFragment$p.viewModel;
        if (flexInputViewModel != null) {
            flexInputViewModel.onInputTextAppended(chatInputText + ' ');
        }
    }
}
