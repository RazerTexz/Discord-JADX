package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: WidgetChatListModel.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$ChatListState$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModel2<T, R> implements Func1<Boolean, Observable<? extends WidgetChatListModel.ChatListState>> {
    public final /* synthetic */ long $channelId;

    /* compiled from: WidgetChatListModel.kt */
    /* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$ChatListState$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<StoreMessagesLoader.ChannelLoadedState, WidgetChatListModel.ChatListState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ WidgetChatListModel.ChatListState call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
            return call2(channelLoadedState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetChatListModel.ChatListState call2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
            return channelLoadedState.getIsTouchedSinceLastJump() ? WidgetChatListModel.ChatListState.DETACHED : WidgetChatListModel.ChatListState.DETACHED_UNTOUCHED;
        }
    }

    public WidgetChatListModel2(long j) {
        this.$channelId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModel.ChatListState> call(Boolean bool) {
        return call(bool.booleanValue());
    }

    public final Observable<? extends WidgetChatListModel.ChatListState> call(boolean z2) {
        return z2 ? StoreStream.INSTANCE.getMessagesLoader().getMessagesLoadedState(this.$channelId).G(AnonymousClass1.INSTANCE).r() : new ScalarSynchronousObservable(WidgetChatListModel.ChatListState.ATTACHED);
    }
}
