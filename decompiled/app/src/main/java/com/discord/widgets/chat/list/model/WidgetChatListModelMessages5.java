package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreThreadMessages;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import rx.functions.Func3;

/* compiled from: WidgetChatListModelMessages.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages5<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreMessageState.State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages.ThreadState>, WidgetChatListModelMessages.MessagesWithMetadata> {
    public final /* synthetic */ List $messages;

    public WidgetChatListModelMessages5(List list) {
        this.$messages = list;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetChatListModelMessages.MessagesWithMetadata call(Map<Long, ? extends StoreMessageState.State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages.ThreadState> map3) {
        return call2((Map<Long, StoreMessageState.State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages.ThreadState>) map3);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModelMessages.MessagesWithMetadata call2(Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3) {
        List list = this.$messages;
        Intrinsics3.checkNotNullExpressionValue(map, "messageState");
        Intrinsics3.checkNotNullExpressionValue(map2, "messageThreads");
        Intrinsics3.checkNotNullExpressionValue(map3, "threadCountsAndLatestMessages");
        return new WidgetChatListModelMessages.MessagesWithMetadata(list, map, map2, map3, Maps6.emptyMap(), Maps6.emptyMap());
    }
}
