package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChat;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* compiled from: WidgetChatOverlay.kt */
/* renamed from: com.discord.widgets.chat.overlay.WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatOverlay4<T1, T2, R> implements Func2<Boolean, StoreChat.InteractionState, Boolean> {
    public static final WidgetChatOverlay4 INSTANCE = new WidgetChatOverlay4();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, StoreChat.InteractionState interactionState) {
        return call2(bool, interactionState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, StoreChat.InteractionState interactionState) {
        Intrinsics3.checkNotNullExpressionValue(bool, "isDetached");
        return Boolean.valueOf(bool.booleanValue() || !(interactionState.isAtBottomIgnoringTouch() || interactionState.isNearBottomIgnoringTouch()));
    }
}
