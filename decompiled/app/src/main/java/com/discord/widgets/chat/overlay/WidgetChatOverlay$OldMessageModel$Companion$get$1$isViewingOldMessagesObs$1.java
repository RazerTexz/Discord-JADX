package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChat;
import j0.k.b;

/* compiled from: WidgetChatOverlay.kt */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1<T, R> implements b<StoreChat.InteractionState, Boolean> {
    public final /* synthetic */ Long $selectedChannelId;

    public WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$1(Long l) {
        this.$selectedChannelId = l;
    }

    @Override // j0.k.b
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
