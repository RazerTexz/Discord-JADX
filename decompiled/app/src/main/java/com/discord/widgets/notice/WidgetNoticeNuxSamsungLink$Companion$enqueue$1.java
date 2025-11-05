package com.discord.widgets.notice;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import d0.o;
import kotlin.Pair;
import rx.functions.Func2;

/* compiled from: WidgetNoticeNuxSamsungLink.kt */
/* loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink$Companion$enqueue$1<T1, T2, R> implements Func2<Boolean, MeUser, Pair<? extends Boolean, ? extends MeUser>> {
    public static final WidgetNoticeNuxSamsungLink$Companion$enqueue$1 INSTANCE = new WidgetNoticeNuxSamsungLink$Companion$enqueue$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Pair<? extends Boolean, ? extends MeUser> call(Boolean bool, MeUser meUser) {
        return call2(bool, meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Pair<Boolean, MeUser> call2(Boolean bool, MeUser meUser) {
        return o.to(bool, meUser);
    }
}
