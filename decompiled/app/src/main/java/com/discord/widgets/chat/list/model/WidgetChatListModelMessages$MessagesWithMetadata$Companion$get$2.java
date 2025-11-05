package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadMessages;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import d0.z.d.k;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function6;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: WidgetChatListModelMessages.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2<T, R> implements b<List<? extends Message>, Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: WidgetChatListModelMessages.kt */
    /* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function6<List<? extends Message>, Map<Long, ? extends StoreMessageState.State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends StoreMessageReplies.MessageState>, Map<Long, ? extends StoreMessageReplies.MessageState>, WidgetChatListModelMessages.MessagesWithMetadata> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(6, WidgetChatListModelMessages.MessagesWithMetadata.class, "<init>", "<init>(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ WidgetChatListModelMessages.MessagesWithMetadata invoke(List<? extends Message> list, Map<Long, ? extends StoreMessageState.State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
            return invoke2((List<Message>) list, (Map<Long, StoreMessageState.State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages.ThreadState>) map3, map4, map5);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetChatListModelMessages.MessagesWithMetadata invoke2(List<Message> list, Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
            m.checkNotNullParameter(list, "p1");
            m.checkNotNullParameter(map, "p2");
            m.checkNotNullParameter(map2, "p3");
            m.checkNotNullParameter(map3, "p4");
            m.checkNotNullParameter(map4, "p5");
            m.checkNotNullParameter(map5, "p6");
            return new WidgetChatListModelMessages.MessagesWithMetadata(list, map, map2, map3, map4, map5);
        }
    }

    public WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2(Channel channel) {
        this.$channel = channel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.discord.widgets.chat.list.model.WidgetChatListModelMessages$sam$rx_functions_Func6$0] */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata> call2(List<Message> list) {
        j0.l.e.k kVar = new j0.l.e.k(list);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, StoreMessageState.State>> messageState = companion.getMessageState().getMessageState();
        StoreChannels channels = companion.getChannels();
        m.checkNotNullExpressionValue(list, "messages");
        Observable<Map<Long, Channel>> observableObserveThreadsFromMessages = channels.observeThreadsFromMessages(list);
        Observable<Map<Long, StoreThreadMessages.ThreadState>> observableObserveThreadCountAndLatestMessage = companion.getThreadMessages().observeThreadCountAndLatestMessage();
        Observable<Map<Long, StoreMessageReplies.MessageState>> observableObserveMessageReferencesForChannel = companion.getRepliedMessages().observeMessageReferencesForChannel(this.$channel.getId());
        Observable<Map<Long, StoreMessageReplies.MessageState>> observableObserveMessageReferencesForChannel2 = companion.getRepliedMessages().observeMessageReferencesForChannel(this.$channel.getParentId());
        AnonymousClass1 widgetChatListModelMessages$sam$rx_functions_Func6$0 = AnonymousClass1.INSTANCE;
        if (widgetChatListModelMessages$sam$rx_functions_Func6$0 != null) {
            widgetChatListModelMessages$sam$rx_functions_Func6$0 = new WidgetChatListModelMessages$sam$rx_functions_Func6$0(widgetChatListModelMessages$sam$rx_functions_Func6$0);
        }
        return Observable.f(kVar, messageState, observableObserveThreadsFromMessages, observableObserveThreadCountAndLatestMessage, observableObserveMessageReferencesForChannel, observableObserveMessageReferencesForChannel2, (Func6) widgetChatListModelMessages$sam$rx_functions_Func6$0);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }
}
