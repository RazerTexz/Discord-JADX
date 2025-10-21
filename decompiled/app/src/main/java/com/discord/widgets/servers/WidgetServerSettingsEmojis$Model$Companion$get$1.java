package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: WidgetServerSettingsEmojis.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$get$1<T, R> implements Func1<WidgetServerSettingsEmojis.Model.Permission, Observable<? extends WidgetServerSettingsEmojis.Model>> {
    public static final WidgetServerSettingsEmojis$Model$Companion$get$1 INSTANCE = new WidgetServerSettingsEmojis$Model$Companion$get$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsEmojis.Model> call(WidgetServerSettingsEmojis.Model.Permission permission) {
        return call2(permission);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsEmojis.Model> call2(WidgetServerSettingsEmojis.Model.Permission permission) {
        return (permission == null || !permission.getCanManage()) ? new ScalarSynchronousObservable(null) : WidgetServerSettingsEmojis.Model.Companion.access$getGuildEmojis(WidgetServerSettingsEmojis.Model.INSTANCE, permission.getGuild());
    }
}
