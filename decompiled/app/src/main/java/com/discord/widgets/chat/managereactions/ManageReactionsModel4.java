package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.message.Message;
import d0.t.Maps6;
import j0.k.Func1;
import java.util.Map;

/* compiled from: ManageReactionsModel.kt */
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsModel4<T, R> implements Func1<Message, Map<String, ? extends MessageReaction>> {
    public static final ManageReactionsModel4 INSTANCE = new ManageReactionsModel4();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Map<String, ? extends MessageReaction> call(Message message) {
        return call2(message);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<String, MessageReaction> call2(Message message) {
        Map<String, MessageReaction> reactionsMap;
        return (message == null || (reactionsMap = message.getReactionsMap()) == null) ? Maps6.emptyMap() : reactionsMap;
    }
}
