package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreMessagesLoader;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelTop;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* compiled from: WidgetChatListModelTop.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListModelTop$Companion$get$1<T, R> implements b<StoreMessagesLoader.ChannelLoadedState, Observable<? extends WidgetChatListModelTop>> {
    public final /* synthetic */ Channel $channel;

    /* compiled from: WidgetChatListModelTop.kt */
    /* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<ChatListEntry, WidgetChatListModelTop> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ WidgetChatListModelTop call(ChatListEntry chatListEntry) {
            return call2(chatListEntry);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatListModelTop call2(ChatListEntry chatListEntry) {
            m.checkNotNullExpressionValue(chatListEntry, "it");
            return new WidgetChatListModelTop(chatListEntry);
        }
    }

    public WidgetChatListModelTop$Companion$get$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModelTop> call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        return call2(channelLoadedState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModelTop> call2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
        Observable kVar;
        if (channelLoadedState.isOldestMessagesLoaded()) {
            kVar = WidgetChatListModelTop.Companion.access$getWelcomeEntry(WidgetChatListModelTop.INSTANCE, this.$channel);
        } else {
            kVar = (channelLoadedState.isTouchedSinceLastJump() || !channelLoadedState.isInitialMessagesLoaded()) ? new k(new LoadingEntry()) : new k(new SpacerEntry(this.$channel.getId()));
        }
        return kVar.G(AnonymousClass1.INSTANCE);
    }
}
