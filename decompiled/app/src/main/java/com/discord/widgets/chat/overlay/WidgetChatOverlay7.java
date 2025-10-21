package com.discord.widgets.chat.overlay;

import android.content.Context;
import android.view.View;
import com.discord.api.sticker.Sticker;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.MessageManager;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: WidgetChatOverlay.kt */
/* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$configureStickerSuggestions$$inlined$forEachIndexed$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay7 implements View.OnClickListener {
    public final /* synthetic */ Sticker $matchedSticker$inlined;
    public final /* synthetic */ boolean $shouldClearTextOnSend$inlined;
    public final /* synthetic */ Sticker $sticker;
    public final /* synthetic */ List $stickerMatches$inlined;
    public final /* synthetic */ StickerView $stickerView$inlined;
    public final /* synthetic */ WidgetChatOverlay this$0;

    public WidgetChatOverlay7(Sticker sticker, StickerView stickerView, Sticker sticker2, WidgetChatOverlay widgetChatOverlay, List list, boolean z2) {
        this.$sticker = sticker;
        this.$stickerView$inlined = stickerView;
        this.$matchedSticker$inlined = sticker2;
        this.this$0 = widgetChatOverlay;
        this.$stickerMatches$inlined = list;
        this.$shouldClearTextOnSend$inlined = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AnalyticsTracker.INSTANCE.expressionSuggestionsSelected(this.$matchedSticker$inlined.getId(), StoreStream.INSTANCE.getExpressionSuggestions().getLastSuggestionTrigger());
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "it.context");
        WidgetChatOverlay.access$getChatInputViewModel$p(this.this$0).sendSticker(this.$sticker, new MessageManager(context, null, null, null, null, null, null, null, null, 510, null));
        WidgetChatOverlay.access$getFlexInputViewModel$p(this.this$0).onStickerSuggestionSent(this.$shouldClearTextOnSend$inlined);
    }
}
