package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.stores.StoreUserConnections;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ListIterator;

/* compiled from: WidgetSettingsPrivacy.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$1<T, R> implements Func1<StoreUserConnections.State, ConnectedAccount> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$1 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$1();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ ConnectedAccount call(StoreUserConnections.State state) {
        return call2(state);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
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
