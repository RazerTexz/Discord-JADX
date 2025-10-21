package com.discord.widgets.guilds.list;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import j0.k.Func1;

/* compiled from: WidgetGuildsListViewModel.kt */
/* renamed from: com.discord.widgets.guilds.list.WidgetGuildsListViewModel$Companion$observeStores$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildsListViewModel4<T, R> implements Func1<MeUser, Boolean> {
    public final /* synthetic */ Clock $clock;

    public WidgetGuildsListViewModel4(Clock clock) {
        this.$clock = clock;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(MeUser meUser) {
        UserUtils userUtils = UserUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
        return Boolean.valueOf(userUtils.getAgeMs(meUser, this.$clock) < 1209600000);
    }
}
