package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import j0.k.Func1;

/* compiled from: WidgetGuildsList.kt */
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsList4<T, R> implements Func1<Throwable, WidgetGuildsList.AddGuildHint> {
    public static final WidgetGuildsList4 INSTANCE = new WidgetGuildsList4();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ WidgetGuildsList.AddGuildHint call(Throwable th) {
        return call2(th);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildsList.AddGuildHint call2(Throwable th) {
        return new WidgetGuildsList.AddGuildHint(false, false, 2, null);
    }
}
