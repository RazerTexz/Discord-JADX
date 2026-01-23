package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$ModelProvider$getInvalidInvite$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite3<T1, T2, R> implements Func2<Long, User, WidgetChatListAdapterItemInvite.Model> {
    public static final WidgetChatListAdapterItemInvite3 INSTANCE = new WidgetChatListAdapterItemInvite3();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemInvite.Model call(Long l, User user) {
        return call2(l, user);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemInvite.Model call2(Long l, User user) {
        Intrinsics3.checkNotNullExpressionValue(l, "meId");
        return new WidgetChatListAdapterItemInvite.Model.Invalid(user, l.longValue(), null);
    }
}
