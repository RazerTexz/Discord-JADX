package com.discord.widgets.chat.input;

import com.discord.models.domain.emoji.Emoji;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* compiled from: WidgetChatInputAttachments.kt */
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1 implements EmojiPickerListener {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    public WidgetChatInputAttachments$createAndConfigureExpressionFragment$emojiPickerListener$1(WidgetChatInputAttachments widgetChatInputAttachments) {
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
