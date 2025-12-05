package com.discord.widgets.chat.managereactions;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.reaction.MessageReaction;
import java.util.List;
import java.util.Map;
import p507d0.p580t._Collections;
import p637j0.p641k.Func1;

/* compiled from: ManageReactionsModel.kt */
/* renamed from: com.discord.widgets.chat.managereactions.ManageReactionsModelProvider$get$reactionsObs$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ManageReactionsModel5<T, R> implements Func1<Map<String, ? extends MessageReaction>, List<? extends MessageReaction>> {
    public static final ManageReactionsModel5 INSTANCE = new ManageReactionsModel5();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ List<? extends MessageReaction> call(Map<String, ? extends MessageReaction> map) {
        return call2((Map<String, MessageReaction>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<MessageReaction> call2(Map<String, MessageReaction> map) {
        return _Collections.sortedWith(map.values(), new C8180xeb27760a());
    }
}
