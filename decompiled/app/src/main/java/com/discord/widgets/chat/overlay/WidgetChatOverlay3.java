package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChat;
import p637j0.p641k.Func1;

/* compiled from: WidgetChatOverlay.kt */
/* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay3<T, R> implements Func1<StoreChat.InteractionState, Boolean> {
    public final /* synthetic */ Long $selectedChannelId;

    public WidgetChatOverlay3(Long l) {
        this.$selectedChannelId = l;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(StoreChat.InteractionState interactionState) {
        return call2(interactionState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreChat.InteractionState interactionState) {
        long channelId = interactionState.getChannelId();
        Long l = this.$selectedChannelId;
        return Boolean.valueOf((l == null || channelId != l.longValue() || interactionState.getLastMessageId() == 0) ? false : true);
    }
}
