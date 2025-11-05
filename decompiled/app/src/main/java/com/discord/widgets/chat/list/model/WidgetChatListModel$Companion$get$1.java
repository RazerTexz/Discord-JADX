package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannelsSelected;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* compiled from: WidgetChatListModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListModel$Companion$get$1<T, R> implements b<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends WidgetChatListModel>> {
    public static final WidgetChatListModel$Companion$get$1 INSTANCE = new WidgetChatListModel$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListModel> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        return call2(resolvedSelectedChannel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListModel> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
        if (resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel) {
            StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
            return ChannelUtils.o(channel.getChannel()) ? new k(null) : WidgetChatListModel.Companion.access$getChannel(WidgetChatListModel.INSTANCE, channel.getChannel());
        }
        if (!(resolvedSelectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft)) {
            return new k(null);
        }
        StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft threadDraft = (StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
        return WidgetChatListModel.Companion.access$getThreadDraft(WidgetChatListModel.INSTANCE, threadDraft.getParentChannel(), threadDraft.getStarterMessageId());
    }
}
