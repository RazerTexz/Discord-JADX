package com.discord.widgets.settings.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserProfile;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;
import kotlin.Tuples2;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func3;

/* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class EditUserOrGuildMemberProfileViewModel4<T, R> implements Func1<Tuples2<? extends MeUser, ? extends Guild>, Observable<? extends EditUserOrGuildMemberProfileViewModel2.StoreState>> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;

    /* compiled from: EditUserOrGuildMemberProfileViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.SettingsUserProfileViewModel$Companion$observeStoreState$2$1 */
    public static final class C99551<T1, T2, T3, R> implements Func3<UserProfile, GuildMember, GuildChannelsInfo, EditUserOrGuildMemberProfileViewModel2.StoreState> {
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ MeUser $meUser;

        public C99551(MeUser meUser, Guild guild) {
            this.$meUser = meUser;
            this.$guild = guild;
        }

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ EditUserOrGuildMemberProfileViewModel2.StoreState call(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            return call2(userProfile, guildMember, guildChannelsInfo);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final EditUserOrGuildMemberProfileViewModel2.StoreState call2(UserProfile userProfile, GuildMember guildMember, GuildChannelsInfo guildChannelsInfo) {
            MeUser.Companion companion = MeUser.INSTANCE;
            MeUser meUser = this.$meUser;
            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
            MeUser meUserMerge = companion.merge(meUser, userProfile.getUser());
            Guild guild = this.$guild;
            Intrinsics3.checkNotNullExpressionValue(userProfile, "userProfile");
            Intrinsics3.checkNotNullExpressionValue(guildChannelsInfo, "guildChannelsInfo");
            return new EditUserOrGuildMemberProfileViewModel2.StoreState(meUserMerge, guild, userProfile, guildMember, guildChannelsInfo);
        }
    }

    public EditUserOrGuildMemberProfileViewModel4(StoreUserProfile storeUserProfile, StoreGuilds storeGuilds, Long l) {
        this.$storeUserProfile = storeUserProfile;
        this.$storeGuilds = storeGuilds;
        this.$guildId = l;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends EditUserOrGuildMemberProfileViewModel2.StoreState> call(Tuples2<? extends MeUser, ? extends Guild> tuples2) {
        return call2((Tuples2<MeUser, Guild>) tuples2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EditUserOrGuildMemberProfileViewModel2.StoreState> call2(Tuples2<MeUser, Guild> tuples2) {
        MeUser meUserComponent1 = tuples2.component1();
        Guild guildComponent2 = tuples2.component2();
        Observable<UserProfile> observableObserveUserProfile = this.$storeUserProfile.observeUserProfile(meUserComponent1.getId());
        StoreGuilds storeGuilds = this.$storeGuilds;
        Long l = this.$guildId;
        Observable<GuildMember> observableObserveGuildMember = storeGuilds.observeGuildMember(l != null ? l.longValue() : -1L, meUserComponent1.getId());
        GuildChannelsInfo.Companion companion = GuildChannelsInfo.INSTANCE;
        Long l2 = this.$guildId;
        return Observable.m11075i(observableObserveUserProfile, observableObserveGuildMember, companion.get(l2 != null ? l2.longValue() : -1L), new C99551(meUserComponent1, guildComponent2));
    }
}
