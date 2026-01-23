package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.widgets.user.WidgetUserStatusSheetViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheetViewModel2<T, R> implements Func1<Presence, WidgetUserStatusSheetViewModel.StoreState> {
    public static final WidgetUserStatusSheetViewModel2 INSTANCE = new WidgetUserStatusSheetViewModel2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ WidgetUserStatusSheetViewModel.StoreState call(Presence presence) {
        return call2(presence);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetUserStatusSheetViewModel.StoreState call2(Presence presence) {
        PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(presence, "localPresence");
        return new WidgetUserStatusSheetViewModel.StoreState(presenceUtils.getCustomStatusActivity(presence));
    }
}
