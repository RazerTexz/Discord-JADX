package com.discord.widgets.contact_sync;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.models.user.MeUser;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import java.util.ListIterator;
import kotlin.Unit;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: WidgetContactSyncViewModel.kt */
/* renamed from: com.discord.widgets.contact_sync.WidgetContactSyncViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetContactSyncViewModel2<T, R> implements Func1<Unit, WidgetContactSyncViewModel.StoreState> {
    public final /* synthetic */ StoreUserConnections $storeConnections;
    public final /* synthetic */ StorePhone $storePhone;
    public final /* synthetic */ StoreUser $storeUsers;

    public WidgetContactSyncViewModel2(StoreUser storeUser, StorePhone storePhone, StoreUserConnections storeUserConnections) {
        this.$storeUsers = storeUser;
        this.$storePhone = storePhone;
        this.$storeConnections = storeUserConnections;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel.StoreState call(Unit unit) {
        return call2(unit);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetContactSyncViewModel.StoreState call2(Unit unit) {
        ConnectedAccount connectedAccountPrevious;
        MeUser meSnapshot = this.$storeUsers.getMeSnapshot();
        PhoneCountryCode countryCode = this.$storePhone.getCountryCode();
        StoreUserConnections.State stateSnapshot = this.$storeConnections.getStateSnapshot();
        ListIterator<ConnectedAccount> listIterator = stateSnapshot.listIterator(stateSnapshot.size());
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
        return new WidgetContactSyncViewModel.StoreState(meSnapshot.getPhoneNumber(), UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, meSnapshot, null, null, 3, null).toString(), countryCode, connectedAccountPrevious);
    }
}
