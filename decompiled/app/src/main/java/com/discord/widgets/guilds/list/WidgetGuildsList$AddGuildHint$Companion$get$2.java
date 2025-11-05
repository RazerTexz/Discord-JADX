package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import j0.k.b;

/* compiled from: WidgetGuildsList.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildsList$AddGuildHint$Companion$get$2<T, R> implements b<WidgetGuildsList.AddGuildHint, Boolean> {
    public static final WidgetGuildsList$AddGuildHint$Companion$get$2 INSTANCE = new WidgetGuildsList$AddGuildHint$Companion$get$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(WidgetGuildsList.AddGuildHint addGuildHint) {
        return call2(addGuildHint);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(WidgetGuildsList.AddGuildHint addGuildHint) {
        return Boolean.valueOf(addGuildHint.isEligible());
    }
}
