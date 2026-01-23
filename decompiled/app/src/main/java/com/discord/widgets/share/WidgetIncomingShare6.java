package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.widgets.share.WidgetIncomingShare;
import kotlin.Tuples2;
import p507d0.Tuples;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$2$$special$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare6<T, R> implements Func1<MessageQueue4, Tuples2<? extends MeUser, ? extends MessageQueue4>> {
    public final /* synthetic */ MeUser $meUser$inlined;
    public final /* synthetic */ WidgetIncomingShare.C99912 this$0;

    public WidgetIncomingShare6(WidgetIncomingShare.C99912 c99912, MeUser meUser) {
        this.this$0 = c99912;
        this.$meUser$inlined = meUser;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends MessageQueue4> call(MessageQueue4 messageQueue4) {
        return call2(messageQueue4);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<MeUser, MessageQueue4> call2(MessageQueue4 messageQueue4) {
        return Tuples.m10073to(this.$meUser$inlined, messageQueue4);
    }
}
