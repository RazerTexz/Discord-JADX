package com.discord.widgets.auth;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.MeUser;
import com.discord.widgets.auth.WidgetAgeVerifyViewModel;
import d0.z.d.Intrinsics3;
import rx.functions.Func3;

/* compiled from: WidgetAgeVerifyViewModel.kt */
/* renamed from: com.discord.widgets.auth.WidgetAgeVerifyViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAgeVerifyViewModel3<T1, T2, T3, R> implements Func3<MeUser, Boolean, Channel, WidgetAgeVerifyViewModel.StoreState> {
    public static final WidgetAgeVerifyViewModel3 INSTANCE = new WidgetAgeVerifyViewModel3();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetAgeVerifyViewModel.StoreState call(MeUser meUser, Boolean bool, Channel channel) {
        return call(meUser, bool.booleanValue(), channel);
    }

    public final WidgetAgeVerifyViewModel.StoreState call(MeUser meUser, boolean z2, Channel channel) {
        Intrinsics3.checkNotNullParameter(meUser, "me");
        return new WidgetAgeVerifyViewModel.StoreState(channel, meUser.getNsfwAllowance(), z2);
    }
}
