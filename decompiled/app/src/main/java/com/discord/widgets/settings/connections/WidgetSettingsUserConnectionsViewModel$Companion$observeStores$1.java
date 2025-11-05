package com.discord.widgets.settings.connections;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreUserConnections;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Map;
import rx.functions.Func2;

/* compiled from: WidgetSettingsUserConnectionsViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsViewModel$Companion$observeStores$1<T1, T2, R> implements Func2<StoreUserConnections.State, Map<Long, ? extends Guild>, WidgetSettingsUserConnectionsViewModel.StoreState> {
    public static final WidgetSettingsUserConnectionsViewModel$Companion$observeStores$1 INSTANCE = new WidgetSettingsUserConnectionsViewModel$Companion$observeStores$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetSettingsUserConnectionsViewModel.StoreState call(StoreUserConnections.State state, Map<Long, ? extends Guild> map) {
        return call2(state, (Map<Long, Guild>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSettingsUserConnectionsViewModel.StoreState call2(StoreUserConnections.State state, Map<Long, Guild> map) {
        m.checkNotNullExpressionValue(state, "accounts");
        ArrayList arrayList = new ArrayList();
        for (ConnectedAccount connectedAccount : state) {
            if (!m.areEqual(connectedAccount.getType(), "contacts")) {
                arrayList.add(connectedAccount);
            }
        }
        m.checkNotNullExpressionValue(map, "guilds");
        return new WidgetSettingsUserConnectionsViewModel.StoreState(arrayList, map);
    }
}
