package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.stores.StoreUserConnections;
import java.util.ListIterator;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$1<T, R> implements Func1<StoreUserConnections.State, ConnectedAccount> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$1 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$1();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ ConnectedAccount call(StoreUserConnections.State state) {
        return call2(state);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ConnectedAccount call2(StoreUserConnections.State state) {
        ConnectedAccount connectedAccountPrevious;
        Intrinsics3.checkNotNullExpressionValue(state, "accounts");
        ListIterator<ConnectedAccount> listIterator = state.listIterator(state.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            }
            connectedAccountPrevious = listIterator.previous();
            if (Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                break;
            }
        }
        return connectedAccountPrevious;
    }
}
