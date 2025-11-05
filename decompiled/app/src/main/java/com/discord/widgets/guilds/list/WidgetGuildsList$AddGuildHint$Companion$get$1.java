package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreNux;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func3;

/* compiled from: WidgetGuildsList.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildsList$AddGuildHint$Companion$get$1<T1, T2, T3, R> implements Func3<StoreNux.NuxState, Boolean, Map<Long, ? extends Channel>, WidgetGuildsList.AddGuildHint> {
    public static final WidgetGuildsList$AddGuildHint$Companion$get$1 INSTANCE = new WidgetGuildsList$AddGuildHint$Companion$get$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetGuildsList.AddGuildHint call(StoreNux.NuxState nuxState, Boolean bool, Map<Long, ? extends Channel> map) {
        return call2(nuxState, bool, (Map<Long, Channel>) map);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetGuildsList.AddGuildHint call2(StoreNux.NuxState nuxState, Boolean bool, Map<Long, Channel> map) {
        boolean z2;
        if (nuxState.getAddGuildHint()) {
            m.checkNotNullExpressionValue(bool, "connectionOpen");
            z2 = bool.booleanValue() && map.isEmpty();
        }
        return new WidgetGuildsList.AddGuildHint(z2, nuxState.getAddGuildHint());
    }
}
