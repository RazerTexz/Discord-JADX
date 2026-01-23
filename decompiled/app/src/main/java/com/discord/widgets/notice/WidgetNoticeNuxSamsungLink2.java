package com.discord.widgets.notice;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import kotlin.Tuples2;
import p507d0.Tuples;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$Companion$enqueue$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink2<T1, T2, R> implements Func2<Boolean, MeUser, Tuples2<? extends Boolean, ? extends MeUser>> {
    public static final WidgetNoticeNuxSamsungLink2 INSTANCE = new WidgetNoticeNuxSamsungLink2();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Boolean, ? extends MeUser> call(Boolean bool, MeUser meUser) {
        return call2(bool, meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Boolean, MeUser> call2(Boolean bool, MeUser meUser) {
        return Tuples.m10073to(bool, meUser);
    }
}
