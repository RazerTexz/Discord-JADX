package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import p637j0.p641k.Func1;

/* compiled from: WidgetGroupInviteFriends.kt */
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1<T, R> implements Func1<User, Long> {
    public static final WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$1();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Long call(User user) {
        return call2(user);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(User user) {
        return Long.valueOf(user.getId());
    }
}
