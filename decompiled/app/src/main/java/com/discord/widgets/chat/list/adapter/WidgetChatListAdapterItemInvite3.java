package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import d0.z.d.Intrinsics3;
import rx.functions.Func2;

/* compiled from: WidgetChatListAdapterItemInvite.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite$ModelProvider$getInvalidInvite$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite3<T1, T2, R> implements Func2<Long, User, WidgetChatListAdapterItemInvite.Model> {
    public static final WidgetChatListAdapterItemInvite3 INSTANCE = new WidgetChatListAdapterItemInvite3();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemInvite.Model call(Long l, User user) {
        return call2(l, user);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListAdapterItemInvite.Model call2(Long l, User user) {
        Intrinsics3.checkNotNullExpressionValue(l, "meId");
        return new WidgetChatListAdapterItemInvite.Model.Invalid(user, l.longValue(), null);
    }
}
