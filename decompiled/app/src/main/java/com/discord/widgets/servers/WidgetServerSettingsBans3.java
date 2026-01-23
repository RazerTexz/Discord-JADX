package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans3<T, R> implements Func1<Boolean, Observable<? extends WidgetServerSettingsBans.Model>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsBans3(long j, Observable observable) {
        this.$guildId = j;
        this.$filterPublisher = observable;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsBans.Model> call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsBans.Model> call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "canManage");
        return bool.booleanValue() ? WidgetServerSettingsBans.Model.Companion.access$getBanItems(WidgetServerSettingsBans.Model.INSTANCE, this.$guildId, this.$filterPublisher) : new ScalarSynchronousObservable(null);
    }
}
