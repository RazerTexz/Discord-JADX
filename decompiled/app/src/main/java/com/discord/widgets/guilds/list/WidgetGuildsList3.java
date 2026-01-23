package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList3<T, R> implements Func1<WidgetGuildsList.AddGuildHint, Boolean> {
    public static final WidgetGuildsList3 INSTANCE = new WidgetGuildsList3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(WidgetGuildsList.AddGuildHint addGuildHint) {
        return call2(addGuildHint);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(WidgetGuildsList.AddGuildHint addGuildHint) {
        return Boolean.valueOf(addGuildHint.isEligible());
    }
}
