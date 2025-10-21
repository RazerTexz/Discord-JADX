package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* compiled from: WidgetChatStatus.kt */
/* renamed from: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatStatus5<T, R> implements Func1<Boolean, Boolean> {
    public static final WidgetChatStatus5 INSTANCE = new WidgetChatStatus5();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool) {
        return Boolean.valueOf(Intrinsics3.areEqual(bool, Boolean.FALSE));
    }
}
