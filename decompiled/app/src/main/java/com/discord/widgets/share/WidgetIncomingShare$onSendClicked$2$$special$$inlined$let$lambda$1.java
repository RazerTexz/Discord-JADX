package com.discord.widgets.share;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.widgets.share.WidgetIncomingShare;
import d0.o;
import j0.k.b;
import kotlin.Pair;

/* compiled from: WidgetIncomingShare.kt */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare$onSendClicked$2$$special$$inlined$let$lambda$1<T, R> implements b<MessageResult, Pair<? extends MeUser, ? extends MessageResult>> {
    public final /* synthetic */ MeUser $meUser$inlined;
    public final /* synthetic */ WidgetIncomingShare.AnonymousClass2 this$0;

    public WidgetIncomingShare$onSendClicked$2$$special$$inlined$let$lambda$1(WidgetIncomingShare.AnonymousClass2 anonymousClass2, MeUser meUser) {
        this.this$0 = anonymousClass2;
        this.$meUser$inlined = meUser;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Pair<? extends MeUser, ? extends MessageResult> call(MessageResult messageResult) {
        return call2(messageResult);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<MeUser, MessageResult> call2(MessageResult messageResult) {
        return o.to(this.$meUser$inlined, messageResult);
    }
}
