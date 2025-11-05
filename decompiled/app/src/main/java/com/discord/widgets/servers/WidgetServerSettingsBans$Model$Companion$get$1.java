package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* compiled from: WidgetServerSettingsBans.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Model$Companion$get$1<T, R> implements b<Boolean, Observable<? extends WidgetServerSettingsBans.Model>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsBans$Model$Companion$get$1(long j, Observable observable) {
        this.$guildId = j;
        this.$filterPublisher = observable;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsBans.Model> call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsBans.Model> call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "canManage");
        return bool.booleanValue() ? WidgetServerSettingsBans.Model.Companion.access$getBanItems(WidgetServerSettingsBans.Model.INSTANCE, this.$guildId, this.$filterPublisher) : new k(null);
    }
}
