package com.discord.widgets.chat;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.utilities.messagesend.MessageQueue4;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import rx.Observable;

/* compiled from: MessageManager.kt */
/* renamed from: com.discord.widgets.chat.MessageManager$sendMessage$messageResultObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageManager3<T, R> implements Func1<Integer, Observable<? extends MessageQueue4>> {
    public final /* synthetic */ MessageAllowedMentions $allowedMentions;
    public final /* synthetic */ List $attachments;
    public final /* synthetic */ String $content;
    public final /* synthetic */ MeUser $me;
    public final /* synthetic */ List $mentions;
    public final /* synthetic */ long $nonNullChannelId;
    public final /* synthetic */ StorePendingReplies.PendingReply $pendingReply;
    public final /* synthetic */ List $stickers;
    public final /* synthetic */ MessageManager this$0;

    public MessageManager3(MessageManager messageManager, StorePendingReplies.PendingReply pendingReply, long j, MeUser meUser, String str, List list, List list2, List list3, MessageAllowedMentions messageAllowedMentions) {
        this.this$0 = messageManager;
        this.$pendingReply = pendingReply;
        this.$nonNullChannelId = j;
        this.$me = meUser;
        this.$content = str;
        this.$mentions = list;
        this.$attachments = list2;
        this.$stickers = list3;
        this.$allowedMentions = messageAllowedMentions;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends MessageQueue4> call(Integer num) {
        return call2(num);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends MessageQueue4> call2(Integer num) {
        if (num.intValue() > 0) {
            return new ScalarSynchronousObservable(new MessageQueue4.Slowmode(num.intValue() * 1000));
        }
        if (this.$pendingReply != null) {
            MessageManager.access$getStorePendingReplies$p(this.this$0).onDeletePendingReply(this.$nonNullChannelId);
        }
        StoreMessages storeMessagesAccess$getStoreMessages$p = MessageManager.access$getStoreMessages$p(this.this$0);
        long j = this.$nonNullChannelId;
        MeUser meUser = this.$me;
        String str = this.$content;
        List list = this.$mentions;
        List list2 = this.$attachments;
        List list3 = this.$stickers;
        StorePendingReplies.PendingReply pendingReply = this.$pendingReply;
        return StoreMessages.sendMessage$default(storeMessagesAccess$getStoreMessages$p, j, meUser, str, list, list2, list3, pendingReply != null ? pendingReply.getMessageReference() : null, this.$allowedMentions, null, null, null, null, null, null, null, 32512, null);
    }
}
