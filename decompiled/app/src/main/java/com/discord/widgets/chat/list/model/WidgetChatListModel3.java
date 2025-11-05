package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: WidgetChatListModel.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModel3<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends WidgetChatListModel>> {
    public static final WidgetChatListModel3 INSTANCE = new WidgetChatListModel3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModel> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModel> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel) {
            StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
            return ChannelUtils.o(channel.getChannel()) ? new ScalarSynchronousObservable(null) : WidgetChatListModel.Companion.access$getChannel(WidgetChatListModel.INSTANCE, channel.getChannel());
        }
        if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
            return new ScalarSynchronousObservable(null);
        }
        StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
        return WidgetChatListModel.Companion.access$getThreadDraft(WidgetChatListModel.INSTANCE, threadDraft.getParentChannel(), threadDraft.getStarterMessageId());
    }
}
