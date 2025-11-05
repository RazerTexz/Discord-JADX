package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserProfile;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.settings.profile.SettingsUserProfileViewModel;
import d0.z.d.m;
import j0.k.b;
import kotlin.Pair;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$Companion$observeStoreState$2<T, R> implements b<Pair<? extends MeUser, ? extends Guild>, Observable<? extends SettingsUserProfileViewModel.StoreState>> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<UserProfile, GuildMember, GuildChannelsInfo, SettingsUserProfileViewModel.StoreState> {
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser, Guild guild) {
            this.$meUser = meUser;
            this.$guild = guild;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ SettingsUserProfileViewModel.StoreState call(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            return call2(userProfile, guildMember, guildChannelsInfo);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final SettingsUserProfileViewModel.StoreState call2(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            MeUser.Companion companion = MeUser.INSTANCE;
            MeUser meUser = this.$meUser;
            m.checkNotNullExpressionValue(meUser, "meUser");
            MeUser meUserMerge = companion.merge(meUser, userProfile.getUser());
            Guild guild = this.$guild;
            m.checkNotNullExpressionValue(userProfile, "userProfile");
            m.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
            return new SettingsUserProfileViewModel.StoreState(meUserMerge, guild, userProfile, guildMember, guildChannelsInfo);
        }
    }

    public SettingsUserProfileViewModel$Companion$observeStoreState$2(StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, Long l) {
        this.$storeUserProfile = storeUserProfile;
        this.$storeGuilds = storeGuilds;
        this.$guildId = l;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends SettingsUserProfileViewModel.StoreState> call(Pair<? extends MeUser, ? extends Guild> pair) {
        return call2((Pair<MeUser, Guild>) pair);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends SettingsUserProfileViewModel.StoreState> call2(Pair<MeUser, Guild> pair) {
        MeUser meUserComponent1 = pair.component1();
        Guild guildComponent2 = pair.component2();
        Observable<UserProfile> observableObserveUserProfile = this.$storeUserProfile.observeUserProfile(meUserComponent1.getId());
        StoreGuilds storeGuilds = this.$storeGuilds;
        Long l = this.$guildId;
        Observable<GuildMember> observableObserveGuildMember = storeGuilds.observeGuildMember(l != null ? l.longValue() : -1L, meUserComponent1.getId());
        GuildChannelsInfo.Companion companion = GuildChannelsInfo.INSTANCE;
        Long l2 = this.$guildId;
        return Observable.i(observableObserveUserProfile, observableObserveGuildMember, companion.get(l2 != null ? l2.longValue() : -1L), new AnonymousClass1(meUserComponent1, guildComponent2));
    }
}
