package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreLurking;
import com.discord.stores.StorePermissions;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.home.WidgetHomeViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func5;

/* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel3<T, R> implements Func1<Long, Observable<? extends WidgetHomeViewModel.GuildInfo>> {
    public final /* synthetic */ StoreGuildWelcomeScreens $storeGuildWelcomeScreens;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreGuildsNsfw $storeGuildsNsfw;
    public final /* synthetic */ StoreLurking $storeLurking;
    public final /* synthetic */ StorePermissions $storePermissions;

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHomeViewModel.kt */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, R> implements Func5<Guild, Boolean, StoreGuildWelcomeScreens.State, Long, Boolean, WidgetHomeViewModel.GuildInfo> {
        public final /* synthetic */ Long $selectedGuildId;

        public AnonymousClass1(Long l) {
            this.$selectedGuildId = l;
        }

        @Override // p658rx.functions.Func5
        public /* bridge */ /* synthetic */ WidgetHomeViewModel.GuildInfo call(Guild guild, Boolean bool, StoreGuildWelcomeScreens.State state, Long l, Boolean bool2) {
            return call2(guild, bool, state, l, bool2);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetHomeViewModel.GuildInfo call2(Guild guild, Boolean bool, StoreGuildWelcomeScreens.State state, Long l, Boolean bool2) {
            Long l2 = this.$selectedGuildId;
            Intrinsics3.checkNotNullExpressionValue(l2, "selectedGuildId");
            long jLongValue = l2.longValue();
            Intrinsics3.checkNotNullExpressionValue(bool, "isLurking");
            return new WidgetHomeViewModel.GuildInfo(jLongValue, guild, bool.booleanValue(), state, !bool2.booleanValue(), l != null ? PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue())) : false);
        }
    }

    public WidgetHomeViewModel3(StoreGuilds storeGuilds, StoreLurking storeLurking, StoreGuildWelcomeScreens storeGuildWelcomeScreens, StorePermissions storePermissions, StoreGuildsNsfw storeGuildsNsfw) {
        this.$storeGuilds = storeGuilds;
        this.$storeLurking = storeLurking;
        this.$storeGuildWelcomeScreens = storeGuildWelcomeScreens;
        this.$storePermissions = storePermissions;
        this.$storeGuildsNsfw = storeGuildsNsfw;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetHomeViewModel.GuildInfo> call(Long l) {
        return call2(l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetHomeViewModel.GuildInfo> call2(Long l) {
        StoreGuilds storeGuilds = this.$storeGuilds;
        Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
        return Observable.m11072g(storeGuilds.observeGuild(l.longValue()), this.$storeLurking.isLurkingObs(l.longValue()), this.$storeGuildWelcomeScreens.observeGuildWelcomeScreen(l.longValue()), this.$storePermissions.observePermissionsForGuild(l.longValue()), this.$storeGuildsNsfw.observeIsGuildNsfwGateAgreed(l.longValue()), new AnonymousClass1(l));
    }
}
