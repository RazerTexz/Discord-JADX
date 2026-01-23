package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$ModelProvider$getInvalidGift$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift3<T1, T2, R> implements Func2<Long, Long, WidgetChatListAdapterItemGift.Model> {
    public static final WidgetChatListAdapterItemGift3 INSTANCE = new WidgetChatListAdapterItemGift3();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemGift.Model call(Long l, Long l2) {
        return call2(l, l2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemGift.Model call2(Long l, Long l2) {
        Intrinsics3.checkNotNullExpressionValue(l2, "meId");
        return new WidgetChatListAdapterItemGift.Model.Invalid(l, l2.longValue());
    }
}
