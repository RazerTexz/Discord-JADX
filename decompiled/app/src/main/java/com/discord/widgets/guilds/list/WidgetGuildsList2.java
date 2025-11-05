package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreNux;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import d0.z.d.Intrinsics3;
import java.util.Map;
import rx.functions.Func3;

/* compiled from: WidgetGuildsList.kt */
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsList2<T1, T2, T3, R> implements Func3<StoreNux.NuxState, Boolean, Map<Long, ? extends Channel>, WidgetGuildsList.AddGuildHint> {
    public static final WidgetGuildsList2 INSTANCE = new WidgetGuildsList2();

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
            Intrinsics3.checkNotNullExpressionValue(bool, "connectionOpen");
            z2 = bool.booleanValue() && map.isEmpty();
        }
        return new WidgetGuildsList.AddGuildHint(z2, nuxState.getAddGuildHint());
    }
}
