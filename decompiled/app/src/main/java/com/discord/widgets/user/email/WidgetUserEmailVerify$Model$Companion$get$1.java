package com.discord.widgets.user.email;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import d0.z.d.m;
import j0.k.b;

/* compiled from: WidgetUserEmailVerify.kt */
/* loaded from: classes.dex */
public final class WidgetUserEmailVerify$Model$Companion$get$1<T, R> implements b<MeUser, WidgetUserEmailVerify.Model> {
    public static final WidgetUserEmailVerify$Model$Companion$get$1 INSTANCE = new WidgetUserEmailVerify$Model$Companion$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetUserEmailVerify.Model call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserEmailVerify.Model call2(MeUser meUser) {
        m.checkNotNullExpressionValue(meUser, "me");
        return new WidgetUserEmailVerify.Model(meUser);
    }
}
