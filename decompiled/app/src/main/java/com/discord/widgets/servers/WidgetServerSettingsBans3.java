package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: WidgetServerSettingsBans.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsBans3<T, R> implements Func1<Boolean, Observable<? extends WidgetServerSettingsBans.Model>> {
    public final /* synthetic */ Observable $filterPublisher;
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsBans3(long j, Observable observable) {
        this.$guildId = j;
        this.$filterPublisher = observable;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsBans.Model> call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetServerSettingsBans.Model> call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "canManage");
        return bool.booleanValue() ? WidgetServerSettingsBans.Model.Companion.access$getBanItems(WidgetServerSettingsBans.Model.INSTANCE, this.$guildId, this.$filterPublisher) : new ScalarSynchronousObservable(null);
    }
}
