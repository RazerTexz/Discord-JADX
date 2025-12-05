package com.discord.widgets.user.email;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: WidgetUserEmailVerify.kt */
/* renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserEmailVerify2<T, R> implements Func1<MeUser, WidgetUserEmailVerify.Model> {
    public static final WidgetUserEmailVerify2 INSTANCE = new WidgetUserEmailVerify2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ WidgetUserEmailVerify.Model call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserEmailVerify.Model call2(MeUser meUser) {
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        return new WidgetUserEmailVerify.Model(meUser);
    }
}
