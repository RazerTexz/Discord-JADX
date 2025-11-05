package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMessagesLoader;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelTop;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: WidgetChatListModelTop.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelTop2<T, R> implements Func1<StoreMessagesLoader.ChannelLoadedState, Observable<? extends WidgetChatListModelTop>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: WidgetChatListModelTop.kt */
    /* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ChatListEntry, WidgetChatListModelTop> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetChatListModelTop call(ChatListEntry chatListEntry) {
            return call2(chatListEntry);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatListModelTop call2(ChatListEntry chatListEntry) {
            Intrinsics3.checkNotNullExpressionValue(chatListEntry, "it");
            return new WidgetChatListModelTop(chatListEntry);
        }
    }

    public WidgetChatListModelTop2(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelTop> call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        return call2(channelLoadedState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModelTop> call2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        Observable scalarSynchronousObservable;
        if (channelLoadedState.isOldestMessagesLoaded()) {
            scalarSynchronousObservable = WidgetChatListModelTop.Companion.access$getWelcomeEntry(WidgetChatListModelTop.INSTANCE, this.$channel);
        } else {
            scalarSynchronousObservable = (channelLoadedState.isTouchedSinceLastJump() || !channelLoadedState.isInitialMessagesLoaded()) ? new ScalarSynchronousObservable(new LoadingEntry()) : new ScalarSynchronousObservable(new SpacerEntry(this.$channel.getId()));
        }
        return scalarSynchronousObservable.G(AnonymousClass1.INSTANCE);
    }
}
