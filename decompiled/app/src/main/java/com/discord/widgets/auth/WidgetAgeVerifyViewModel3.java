package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import com.discord.widgets.auth.WidgetAgeVerifyViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func3;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$Companion$observeStores$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel3<T1, T2, T3, R> implements Func3<MeUser, Boolean, Channel, WidgetAgeVerifyViewModel.StoreState> {
    public static final WidgetAgeVerifyViewModel3 INSTANCE = new WidgetAgeVerifyViewModel3();

    @Override // p658rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetAgeVerifyViewModel.StoreState call(MeUser meUser, Boolean bool, Channel channel) {
        return call(meUser, bool.booleanValue(), channel);
    }

    public final WidgetAgeVerifyViewModel.StoreState call(MeUser meUser, boolean z2, Channel channel) {
        Intrinsics3.checkNotNullParameter(meUser, "me");
        return new WidgetAgeVerifyViewModel.StoreState(channel, meUser.getNsfwAllowance(), z2);
    }
}
