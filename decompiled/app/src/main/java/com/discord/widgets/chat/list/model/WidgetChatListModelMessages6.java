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
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function6;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func6;

/* compiled from: WidgetChatListModelMessages.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages6<T, R> implements Func1<List<? extends Message>, Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: WidgetChatListModelMessages.kt */
    /* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata$Companion$get$2$1 */
    public static final /* synthetic */ class C81611 extends FunctionReferenceImpl implements Function6<List<? extends Message>, Map<Long, ? extends StoreMessageState.State>, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends StoreMessageReplies.MessageState>, Map<Long, ? extends StoreMessageReplies.MessageState>, WidgetChatListModelMessages.MessagesWithMetadata> {
        public static final C81611 INSTANCE = new C81611();

        public C81611() {
            super(6, WidgetChatListModelMessages.MessagesWithMetadata.class, "<init>", "<init>(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ WidgetChatListModelMessages.MessagesWithMetadata invoke(List<? extends Message> list, Map<Long, ? extends StoreMessageState.State> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
            return invoke2((List<Message>) list, (Map<Long, StoreMessageState.State>) map, (Map<Long, Channel>) map2, (Map<Long, StoreThreadMessages.ThreadState>) map3, map4, map5);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetChatListModelMessages.MessagesWithMetadata invoke2(List<Message> list, Map<Long, StoreMessageState.State> map, Map<Long, Channel> map2, Map<Long, StoreThreadMessages.ThreadState> map3, Map<Long, ? extends StoreMessageReplies.MessageState> map4, Map<Long, ? extends StoreMessageReplies.MessageState> map5) {
            Intrinsics3.checkNotNullParameter(list, "p1");
            Intrinsics3.checkNotNullParameter(map, "p2");
            Intrinsics3.checkNotNullParameter(map2, "p3");
            Intrinsics3.checkNotNullParameter(map3, "p4");
            Intrinsics3.checkNotNullParameter(map4, "p5");
            Intrinsics3.checkNotNullParameter(map5, "p6");
            return new WidgetChatListModelMessages.MessagesWithMetadata(list, map, map2, map3, map4, map5);
        }
    }

    public WidgetChatListModelMessages6(Channel channel) {
        this.$channel = channel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.discord.widgets.chat.list.model.WidgetChatListModelMessages$sam$rx_functions_Func6$0] */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata> call2(List<Message> list) {
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(list);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, StoreMessageState.State>> messageState = companion.getMessageState().getMessageState();
        StoreChannels channels = companion.getChannels();
        Intrinsics3.checkNotNullExpressionValue(list, "messages");
        Observable<Map<Long, Channel>> observableObserveThreadsFromMessages = channels.observeThreadsFromMessages(list);
        Observable<Map<Long, StoreThreadMessages.ThreadState>> observableObserveThreadCountAndLatestMessage = companion.getThreadMessages().observeThreadCountAndLatestMessage();
        Observable<Map<Long, StoreMessageReplies.MessageState>> observableObserveMessageReferencesForChannel = companion.getRepliedMessages().observeMessageReferencesForChannel(this.$channel.getId());
        Observable<Map<Long, StoreMessageReplies.MessageState>> observableObserveMessageReferencesForChannel2 = companion.getRepliedMessages().observeMessageReferencesForChannel(this.$channel.getParentId());
        C81611 widgetChatListModelMessages7 = C81611.INSTANCE;
        if (widgetChatListModelMessages7 != null) {
            widgetChatListModelMessages7 = new WidgetChatListModelMessages7(widgetChatListModelMessages7);
        }
        return Observable.m11071f(scalarSynchronousObservable, messageState, observableObserveThreadsFromMessages, observableObserveThreadCountAndLatestMessage, observableObserveMessageReferencesForChannel, observableObserveMessageReferencesForChannel2, (Func6) widgetChatListModelMessages7);
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelMessages.MessagesWithMetadata> call(List<? extends Message> list) {
        return call2((List<Message>) list);
    }
}
