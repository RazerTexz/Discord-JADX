package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import d0.t._Collections;
import j0.k.Func1;
import java.util.List;
import java.util.Map;

/* compiled from: ManageReactionsModel.kt */
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsModel5<T, R> implements Func1<Map<String, ? extends MessageReaction>, List<? extends MessageReaction>> {
    public static final ManageReactionsModel5 INSTANCE = new ManageReactionsModel5();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<? extends MessageReaction> call(Map<String, ? extends MessageReaction> map) {
        return call2((Map<String, MessageReaction>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<MessageReaction> call2(Map<String, MessageReaction> map) {
        return _Collections.sortedWith(map.values(), new ManageReactionsModelProvider$get$reactionsObs$2$$special$$inlined$sortedByDescending$1());
    }
}
