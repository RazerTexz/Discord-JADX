package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.widgets.share.WidgetIncomingShare;
import d0.Tuples;
import j0.k.Func1;
import kotlin.Tuples2;

/* compiled from: WidgetIncomingShare.kt */
/* renamed from: com.discord.widgets.share.WidgetIncomingShare$onSendClicked$2$$special$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare6<T, R> implements Func1<MessageQueue4, Tuples2<? extends MeUser, ? extends MessageQueue4>> {
    public final /* synthetic */ MeUser $meUser$inlined;
    public final /* synthetic */ WidgetIncomingShare.AnonymousClass2 this$0;

    public WidgetIncomingShare6(WidgetIncomingShare.AnonymousClass2 anonymousClass2, MeUser meUser) {
        this.this$0 = anonymousClass2;
        this.$meUser$inlined = meUser;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends MessageQueue4> call(MessageQueue4 messageQueue4) {
        return call2(messageQueue4);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<MeUser, MessageQueue4> call2(MessageQueue4 messageQueue4) {
        return Tuples.to(this.$meUser$inlined, messageQueue4);
    }
}
