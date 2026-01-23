package com.discord.widgets.settings.account;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel2<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends WidgetSettingsBlockedUsersViewModel.StoreState>> {
    public final /* synthetic */ StoreUser $storeUser;

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1$1 */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
    public static final class C97811<T, R> implements Func1<Map<Long, ? extends User>, WidgetSettingsBlockedUsersViewModel.StoreState> {
        public static final C97811 INSTANCE = new C97811();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ WidgetSettingsBlockedUsersViewModel.StoreState call(Map<Long, ? extends User> map) {
            return call2(map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetSettingsBlockedUsersViewModel.StoreState call2(Map<Long, ? extends User> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "users");
            return new WidgetSettingsBlockedUsersViewModel.StoreState(map);
        }
    }

    public WidgetSettingsBlockedUsersViewModel2(StoreUser storeUser) {
        this.$storeUser = storeUser;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSettingsBlockedUsersViewModel.StoreState> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSettingsBlockedUsersViewModel.StoreState> call2(Map<Long, Integer> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "relationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() == 2) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return this.$storeUser.observeUsers(linkedHashMap.keySet()).m11083G(C97811.INSTANCE);
    }
}
