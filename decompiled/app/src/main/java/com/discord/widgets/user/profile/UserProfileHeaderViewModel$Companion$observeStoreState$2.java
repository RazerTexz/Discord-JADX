package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.t.n0;
import d0.z.d.m;
import j0.k.b;
import j0.l.a.c;
import j0.l.e.k;
import java.util.Collection;
import java.util.Map;
import kotlin.Pair;
import rx.Observable;
import rx.functions.Func8;

/* compiled from: UserProfileHeaderViewModel.kt */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel$Companion$observeStoreState$2<T, R> implements b<Pair<? extends MeUser, ? extends User>, Observable<? extends UserProfileHeaderViewModel.StoreState>> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreAccessibility $storeAccessibility;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreUserPresence $storeUserPresence;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;
    public final /* synthetic */ StreamContextService $streamContextService;

    /* compiled from: UserProfileHeaderViewModel.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<Map<Long, ? extends GuildMember>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, ModelRichPresence, StreamContext, UserProfile, Boolean, Boolean, Channel, UserProfileHeaderViewModel.StoreState> {
        public final /* synthetic */ MeUser $meUser;
        public final /* synthetic */ User $targetUser;

        public AnonymousClass1(MeUser meUser, User user) {
            this.$meUser = meUser;
            this.$targetUser = user;
        }

        @Override // rx.functions.Func8
        public /* bridge */ /* synthetic */ UserProfileHeaderViewModel.StoreState call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends Map<Long, ? extends GuildMember>> map2, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, Boolean bool, Boolean bool2, Channel channel) {
            return call2((Map<Long, GuildMember>) map, (Map<Long, ? extends Map<Long, GuildMember>>) map2, modelRichPresence, streamContext, userProfile, bool, bool2, channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final UserProfileHeaderViewModel.StoreState call2(Map<Long, GuildMember> map, Map<Long, ? extends Map<Long, GuildMember>> map2, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, Boolean bool, Boolean bool2, Channel channel) {
            MeUser meUser = this.$meUser;
            m.checkNotNullExpressionValue(meUser, "meUser");
            User user = this.$targetUser;
            m.checkNotNullExpressionValue(map, "userIdToGuildMembersMap");
            Collection<? extends Map<Long, GuildMember>> collectionValues = map2.values();
            m.checkNotNullExpressionValue(userProfile, "userProfile");
            m.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
            boolean zBooleanValue = bool.booleanValue();
            m.checkNotNullExpressionValue(bool2, "reducedMotionEnabled");
            return new UserProfileHeaderViewModel.StoreState(meUser, user, map, collectionValues, modelRichPresence, streamContext, userProfile, zBooleanValue, bool2.booleanValue(), channel);
        }
    }

    public UserProfileHeaderViewModel$Companion$observeStoreState$2(Long l, StoreChannels storeChannels, StoreGuilds storeGuilds, Long l2, StoreUserPresence storeUserPresence, StreamContextService streamContextService, StoreUserProfile storeUserProfile, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility) {
        this.$channelId = l;
        this.$storeChannels = storeChannels;
        this.$storeGuilds = storeGuilds;
        this.$guildId = l2;
        this.$storeUserPresence = storeUserPresence;
        this.$streamContextService = streamContextService;
        this.$storeUserProfile = storeUserProfile;
        this.$storeUserSettings = storeUserSettings;
        this.$storeAccessibility = storeAccessibility;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Observable<? extends UserProfileHeaderViewModel.StoreState> call2(Pair<MeUser, ? extends User> pair) {
        Observable<Channel> kVar;
        MeUser meUserComponent1 = pair.component1();
        User userComponent2 = pair.component2();
        if (userComponent2 == null) {
            return c.k;
        }
        Long l = this.$channelId;
        if (l != null) {
            l.longValue();
            kVar = this.$storeChannels.observeChannel(this.$channelId.longValue());
            if (kVar == null) {
                kVar = new k<>(null);
            }
        }
        return Observable.d(UserProfileHeaderViewModel.Companion.access$observeComputedMembers(UserProfileHeaderViewModel.INSTANCE, this.$channelId, this.$guildId, n0.setOf((Object[]) new Long[]{Long.valueOf(meUserComponent1.getId()), Long.valueOf(userComponent2.getId())}), this.$storeChannels, this.$storeGuilds), this.$storeGuilds.observeComputed(), ModelRichPresence.INSTANCE.get(userComponent2.getId(), this.$storeUserPresence), this.$streamContextService.getForUser(userComponent2.getId(), true), this.$storeUserProfile.observeUserProfile(userComponent2.getId()), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(this.$storeUserSettings, false, 1, null), this.$storeAccessibility.observeReducedMotionEnabled(), kVar, new AnonymousClass1(meUserComponent1, userComponent2));
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends UserProfileHeaderViewModel.StoreState> call(Pair<? extends MeUser, ? extends User> pair) {
        return call2((Pair<MeUser, ? extends User>) pair);
    }
}
