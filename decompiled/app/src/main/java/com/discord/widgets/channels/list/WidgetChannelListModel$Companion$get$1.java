package com.discord.widgets.channels.list;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.channels.list.WidgetChannelListModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$get$1<T, R> implements Func1<Long, Observable<? extends WidgetChannelListModel>> {
    public static final WidgetChannelListModel$Companion$get$1 INSTANCE = new WidgetChannelListModel$Companion$get$1();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelListModel> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelListModel> call2(Long l) {
        if (l != null && l.longValue() == 0) {
            return WidgetChannelListModel.Companion.access$getPrivateChannelList(WidgetChannelListModel.INSTANCE);
        }
        WidgetChannelListModel.Companion companion = WidgetChannelListModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(l, "guildId");
        return WidgetChannelListModel.Companion.access$getSelectedGuildChannelList(companion, l.longValue());
    }
}
