package com.discord.widgets.user.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.presence.ModelRichPresence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: UserProfileHeaderViewModel.kt */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: ME */
    public static final long f19406ME = -1;
    private final long userId;

    /* compiled from: UserProfileHeaderViewModel.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$1 */
    public static final class C103091 extends Lambda implements Function1<StoreState, Unit> {
        public C103091() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            UserProfileHeaderViewModel.access$handleStoreState(UserProfileHeaderViewModel.this, storeState);
        }
    }

    /* compiled from: UserProfileHeaderViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeComputedMembers(Companion companion, Long l, Long l2, Collection collection, StoreChannels storeChannels, StoreGuilds storeGuilds) {
            return companion.observeComputedMembers(l, l2, collection, storeChannels, storeGuilds);
        }

        private final Observable<Map<Long, GuildMember>> observeComputedMembers(Long channelId, Long guildId, Collection<Long> users, StoreChannels storeChannels, StoreGuilds storeGuilds) {
            if (channelId != null && channelId.longValue() > 0) {
                Observable observableM11099Y = storeChannels.observeChannel(channelId.longValue()).m11099Y(new UserProfileHeaderViewModel2(storeGuilds, users));
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "storeChannels\n          …emptyMap())\n            }");
                return observableM11099Y;
            }
            if (guildId != null && guildId.longValue() > 0) {
                return storeGuilds.observeComputed(guildId.longValue(), users);
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Maps6.emptyMap());
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(emptyMap())");
            return scalarSynchronousObservable;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, Long l, Long l2, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreUserProfile storeUserProfile, StoreExperiments storeExperiments, StoreUserSettings storeUserSettings, StreamContextService streamContextService, StoreAccessibility storeAccessibility, int i, Object obj) {
            return companion.observeStoreState(j, l, l2, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 128) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile, (i & 256) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 512) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 1024) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : streamContextService, (i & 2048) != 0 ? StoreStream.INSTANCE.getAccessibility() : storeAccessibility);
        }

        @VisibleForTesting
        public final Observable<StoreState> observeStoreState(long userId, Long channelId, Long guildId, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreUserProfile storeUserProfile, StoreExperiments storeExperiments, StoreUserSettings storeUserSettings, StreamContextService streamContextService, StoreAccessibility storeAccessibility) {
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
            Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
            Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
            Intrinsics3.checkNotNullParameter(streamContextService, "streamContextService");
            Intrinsics3.checkNotNullParameter(storeAccessibility, "storeAccessibility");
            Observable<StoreState> observableM11099Y = StoreUser.observeMe$default(storeUser, false, 1, null).m11099Y(new UserProfileHeaderViewModel3(userId, storeUser)).m11099Y(new UserProfileHeaderViewModel4(channelId, storeChannels, storeGuilds, guildId, storeUserPresence, streamContextService, storeUserProfile, storeUserSettings, storeAccessibility));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "storeUser.observeMe()\n  …            }\n          }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: UserProfileHeaderViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean allowAnimatedEmojis;
        private final Channel channel;
        private final Collection<Map<Long, GuildMember>> guildMembers;
        private final MeUser me;
        private final boolean reducedMotionEnabled;
        private final ModelRichPresence richPresence;
        private final StreamContext streamContext;
        private final User user;
        private final Map<Long, GuildMember> userIdToGuildMemberMap;
        private final UserProfile userProfile;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(MeUser meUser, User user, Map<Long, GuildMember> map, Collection<? extends Map<Long, GuildMember>> collection, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, Channel channel) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(map, "userIdToGuildMemberMap");
            Intrinsics3.checkNotNullParameter(collection, "guildMembers");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            this.me = meUser;
            this.user = user;
            this.userIdToGuildMemberMap = map;
            this.guildMembers = collection;
            this.richPresence = modelRichPresence;
            this.streamContext = streamContext;
            this.userProfile = userProfile;
            this.allowAnimatedEmojis = z2;
            this.reducedMotionEnabled = z3;
            this.channel = channel;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, User user, Map map, Collection collection, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, Channel channel, int i, Object obj) {
            return storeState.copy((i & 1) != 0 ? storeState.me : meUser, (i & 2) != 0 ? storeState.user : user, (i & 4) != 0 ? storeState.userIdToGuildMemberMap : map, (i & 8) != 0 ? storeState.guildMembers : collection, (i & 16) != 0 ? storeState.richPresence : modelRichPresence, (i & 32) != 0 ? storeState.streamContext : streamContext, (i & 64) != 0 ? storeState.userProfile : userProfile, (i & 128) != 0 ? storeState.allowAnimatedEmojis : z2, (i & 256) != 0 ? storeState.reducedMotionEnabled : z3, (i & 512) != 0 ? storeState.channel : channel);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component10, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final Map<Long, GuildMember> component3() {
            return this.userIdToGuildMemberMap;
        }

        public final Collection<Map<Long, GuildMember>> component4() {
            return this.guildMembers;
        }

        /* renamed from: component5, reason: from getter */
        public final ModelRichPresence getRichPresence() {
            return this.richPresence;
        }

        /* renamed from: component6, reason: from getter */
        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        /* renamed from: component7, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        public final StoreState copy(MeUser me2, User user, Map<Long, GuildMember> userIdToGuildMemberMap, Collection<? extends Map<Long, GuildMember>> guildMembers, ModelRichPresence richPresence, StreamContext streamContext, UserProfile userProfile, boolean allowAnimatedEmojis, boolean reducedMotionEnabled, Channel channel) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userIdToGuildMemberMap, "userIdToGuildMemberMap");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            return new StoreState(me2, user, userIdToGuildMemberMap, guildMembers, richPresence, streamContext, userProfile, allowAnimatedEmojis, reducedMotionEnabled, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.userIdToGuildMemberMap, storeState.userIdToGuildMemberMap) && Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.richPresence, storeState.richPresence) && Intrinsics3.areEqual(this.streamContext, storeState.streamContext) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile) && this.allowAnimatedEmojis == storeState.allowAnimatedEmojis && this.reducedMotionEnabled == storeState.reducedMotionEnabled && Intrinsics3.areEqual(this.channel, storeState.channel);
        }

        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Collection<Map<Long, GuildMember>> getGuildMembers() {
            return this.guildMembers;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        public final ModelRichPresence getRichPresence() {
            return this.richPresence;
        }

        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        public final User getUser() {
            return this.user;
        }

        public final Map<Long, GuildMember> getUserIdToGuildMemberMap() {
            return this.userIdToGuildMemberMap;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            User user = this.user;
            int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map = this.userIdToGuildMemberMap;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Collection<Map<Long, GuildMember>> collection = this.guildMembers;
            int iHashCode4 = (iHashCode3 + (collection != null ? collection.hashCode() : 0)) * 31;
            ModelRichPresence modelRichPresence = this.richPresence;
            int iHashCode5 = (iHashCode4 + (modelRichPresence != null ? modelRichPresence.hashCode() : 0)) * 31;
            StreamContext streamContext = this.streamContext;
            int iHashCode6 = (iHashCode5 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            UserProfile userProfile = this.userProfile;
            int iHashCode7 = (iHashCode6 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
            boolean z2 = this.allowAnimatedEmojis;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode7 + i) * 31;
            boolean z3 = this.reducedMotionEnabled;
            int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            Channel channel = this.channel;
            return i3 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(me=");
            sbM833U.append(this.me);
            sbM833U.append(", user=");
            sbM833U.append(this.user);
            sbM833U.append(", userIdToGuildMemberMap=");
            sbM833U.append(this.userIdToGuildMemberMap);
            sbM833U.append(", guildMembers=");
            sbM833U.append(this.guildMembers);
            sbM833U.append(", richPresence=");
            sbM833U.append(this.richPresence);
            sbM833U.append(", streamContext=");
            sbM833U.append(this.streamContext);
            sbM833U.append(", userProfile=");
            sbM833U.append(this.userProfile);
            sbM833U.append(", allowAnimatedEmojis=");
            sbM833U.append(this.allowAnimatedEmojis);
            sbM833U.append(", reducedMotionEnabled=");
            sbM833U.append(this.reducedMotionEnabled);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: UserProfileHeaderViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: UserProfileHeaderViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: UserProfileHeaderViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean allowAnimatedEmojis;
            private final boolean allowAnimationInReducedMotion;

            /* renamed from: avatarColorId$delegate, reason: from kotlin metadata */
            private final Lazy avatarColorId;
            private final String banner;
            private final String bannerColorHex;
            private final boolean editable;
            private final GuildMember guildMember;

            /* renamed from: guildMemberColorId$delegate, reason: from kotlin metadata */
            private final Lazy guildMemberColorId;
            private final List<GuildMember> guildMembersForAka;
            private final boolean hasGuildMemberAvatar;
            private final boolean hasNickname;
            private final boolean isMe;
            private final boolean isMeUserPremium;
            private final boolean isMeUserVerified;
            private final boolean isProfileLoaded;
            private final Presence presence;
            private final boolean reducedMotionEnabled;
            private final boolean shouldAnimateBanner;
            private final boolean shouldShowGIFTag;
            private final boolean showAkas;
            private final boolean showMediumAvatar;
            private final boolean showPresence;
            private final boolean showSmallAvatar;
            private final StreamContext streamContext;
            private final User user;
            private final UserProfile userProfile;

            public /* synthetic */ Loaded(User user, String str, String str2, GuildMember guildMember, List list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(user, str, str2, (i & 8) != 0 ? null : guildMember, (i & 16) != 0 ? Collections2.emptyList() : list, (i & 32) != 0 ? null : presence, (i & 64) != 0 ? null : streamContext, (i & 128) != 0 ? StoreUserProfile.INSTANCE.getEMPTY_PROFILE() : userProfile, z2, z3, (i & 1024) != 0 ? false : z4, z5, (i & 4096) != 0 ? false : z6, (i & 8192) != 0 ? false : z7, (i & 16384) != 0 ? false : z8, (i & 32768) != 0 ? false : z9);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, User user, String str, String str2, GuildMember guildMember, List list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.user : user, (i & 2) != 0 ? loaded.banner : str, (i & 4) != 0 ? loaded.bannerColorHex : str2, (i & 8) != 0 ? loaded.guildMember : guildMember, (i & 16) != 0 ? loaded.guildMembersForAka : list, (i & 32) != 0 ? loaded.presence : presence, (i & 64) != 0 ? loaded.streamContext : streamContext, (i & 128) != 0 ? loaded.userProfile : userProfile, (i & 256) != 0 ? loaded.isMeUserPremium : z2, (i & 512) != 0 ? loaded.isMeUserVerified : z3, (i & 1024) != 0 ? loaded.allowAnimatedEmojis : z4, (i & 2048) != 0 ? loaded.showPresence : z5, (i & 4096) != 0 ? loaded.editable : z6, (i & 8192) != 0 ? loaded.reducedMotionEnabled : z7, (i & 16384) != 0 ? loaded.allowAnimationInReducedMotion : z8, (i & 32768) != 0 ? loaded.isMe : z9);
            }

            /* renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* renamed from: component10, reason: from getter */
            public final boolean getIsMeUserVerified() {
                return this.isMeUserVerified;
            }

            /* renamed from: component11, reason: from getter */
            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getShowPresence() {
                return this.showPresence;
            }

            /* renamed from: component13, reason: from getter */
            public final boolean getEditable() {
                return this.editable;
            }

            /* renamed from: component14, reason: from getter */
            public final boolean getReducedMotionEnabled() {
                return this.reducedMotionEnabled;
            }

            /* renamed from: component15, reason: from getter */
            public final boolean getAllowAnimationInReducedMotion() {
                return this.allowAnimationInReducedMotion;
            }

            /* renamed from: component16, reason: from getter */
            public final boolean getIsMe() {
                return this.isMe;
            }

            /* renamed from: component2, reason: from getter */
            public final String getBanner() {
                return this.banner;
            }

            /* renamed from: component3, reason: from getter */
            public final String getBannerColorHex() {
                return this.bannerColorHex;
            }

            /* renamed from: component4, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final List<GuildMember> component5() {
                return this.guildMembersForAka;
            }

            /* renamed from: component6, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component7, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* renamed from: component8, reason: from getter */
            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* renamed from: component9, reason: from getter */
            public final boolean getIsMeUserPremium() {
                return this.isMeUserPremium;
            }

            public final Loaded copy(User user, String banner, String bannerColorHex, GuildMember guildMember, List<GuildMember> guildMembersForAka, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean isMeUserPremium, boolean isMeUserVerified, boolean allowAnimatedEmojis, boolean showPresence, boolean editable, boolean reducedMotionEnabled, boolean allowAnimationInReducedMotion, boolean isMe) {
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(guildMembersForAka, "guildMembersForAka");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                return new Loaded(user, banner, bannerColorHex, guildMember, guildMembersForAka, presence, streamContext, userProfile, isMeUserPremium, isMeUserVerified, allowAnimatedEmojis, showPresence, editable, reducedMotionEnabled, allowAnimationInReducedMotion, isMe);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.user, loaded.user) && Intrinsics3.areEqual(this.banner, loaded.banner) && Intrinsics3.areEqual(this.bannerColorHex, loaded.bannerColorHex) && Intrinsics3.areEqual(this.guildMember, loaded.guildMember) && Intrinsics3.areEqual(this.guildMembersForAka, loaded.guildMembersForAka) && Intrinsics3.areEqual(this.presence, loaded.presence) && Intrinsics3.areEqual(this.streamContext, loaded.streamContext) && Intrinsics3.areEqual(this.userProfile, loaded.userProfile) && this.isMeUserPremium == loaded.isMeUserPremium && this.isMeUserVerified == loaded.isMeUserVerified && this.allowAnimatedEmojis == loaded.allowAnimatedEmojis && this.showPresence == loaded.showPresence && this.editable == loaded.editable && this.reducedMotionEnabled == loaded.reducedMotionEnabled && this.allowAnimationInReducedMotion == loaded.allowAnimationInReducedMotion && this.isMe == loaded.isMe;
            }

            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            public final boolean getAllowAnimationInReducedMotion() {
                return this.allowAnimationInReducedMotion;
            }

            public final String getAvatarColorId() {
                return (String) this.avatarColorId.getValue();
            }

            public final String getBanner() {
                return this.banner;
            }

            public final String getBannerColorHex() {
                return this.bannerColorHex;
            }

            public final boolean getEditable() {
                return this.editable;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final String getGuildMemberColorId() {
                return (String) this.guildMemberColorId.getValue();
            }

            public final List<GuildMember> getGuildMembersForAka() {
                return this.guildMembersForAka;
            }

            public final boolean getHasGuildMemberAvatar() {
                return this.hasGuildMemberAvatar;
            }

            public final boolean getHasNickname() {
                return this.hasNickname;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final boolean getReducedMotionEnabled() {
                return this.reducedMotionEnabled;
            }

            public final boolean getShouldAnimateBanner() {
                return this.shouldAnimateBanner;
            }

            public final boolean getShouldShowGIFTag() {
                return this.shouldShowGIFTag;
            }

            public final boolean getShowAkas() {
                return this.showAkas;
            }

            public final boolean getShowMediumAvatar() {
                return this.showMediumAvatar;
            }

            public final boolean getShowPresence() {
                return this.showPresence;
            }

            public final boolean getShowSmallAvatar() {
                return this.showSmallAvatar;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final User getUser() {
                return this.user;
            }

            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                String str = this.banner;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.bannerColorHex;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                GuildMember guildMember = this.guildMember;
                int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                List<GuildMember> list = this.guildMembersForAka;
                int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
                Presence presence = this.presence;
                int iHashCode6 = (iHashCode5 + (presence != null ? presence.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode7 = (iHashCode6 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                UserProfile userProfile = this.userProfile;
                int iHashCode8 = (iHashCode7 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
                boolean z2 = this.isMeUserPremium;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode8 + i) * 31;
                boolean z3 = this.isMeUserVerified;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.allowAnimatedEmojis;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.showPresence;
                int i7 = z5;
                if (z5 != 0) {
                    i7 = 1;
                }
                int i8 = (i6 + i7) * 31;
                boolean z6 = this.editable;
                int i9 = z6;
                if (z6 != 0) {
                    i9 = 1;
                }
                int i10 = (i8 + i9) * 31;
                boolean z7 = this.reducedMotionEnabled;
                int i11 = z7;
                if (z7 != 0) {
                    i11 = 1;
                }
                int i12 = (i10 + i11) * 31;
                boolean z8 = this.allowAnimationInReducedMotion;
                int i13 = z8;
                if (z8 != 0) {
                    i13 = 1;
                }
                int i14 = (i12 + i13) * 31;
                boolean z9 = this.isMe;
                return i14 + (z9 ? 1 : z9 ? 1 : 0);
            }

            public final boolean isMe() {
                return this.isMe;
            }

            public final boolean isMeUserPremium() {
                return this.isMeUserPremium;
            }

            public final boolean isMeUserVerified() {
                return this.isMeUserVerified;
            }

            /* renamed from: isProfileLoaded, reason: from getter */
            public final boolean getIsProfileLoaded() {
                return this.isProfileLoaded;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(user=");
                sbM833U.append(this.user);
                sbM833U.append(", banner=");
                sbM833U.append(this.banner);
                sbM833U.append(", bannerColorHex=");
                sbM833U.append(this.bannerColorHex);
                sbM833U.append(", guildMember=");
                sbM833U.append(this.guildMember);
                sbM833U.append(", guildMembersForAka=");
                sbM833U.append(this.guildMembersForAka);
                sbM833U.append(", presence=");
                sbM833U.append(this.presence);
                sbM833U.append(", streamContext=");
                sbM833U.append(this.streamContext);
                sbM833U.append(", userProfile=");
                sbM833U.append(this.userProfile);
                sbM833U.append(", isMeUserPremium=");
                sbM833U.append(this.isMeUserPremium);
                sbM833U.append(", isMeUserVerified=");
                sbM833U.append(this.isMeUserVerified);
                sbM833U.append(", allowAnimatedEmojis=");
                sbM833U.append(this.allowAnimatedEmojis);
                sbM833U.append(", showPresence=");
                sbM833U.append(this.showPresence);
                sbM833U.append(", editable=");
                sbM833U.append(this.editable);
                sbM833U.append(", reducedMotionEnabled=");
                sbM833U.append(this.reducedMotionEnabled);
                sbM833U.append(", allowAnimationInReducedMotion=");
                sbM833U.append(this.allowAnimationInReducedMotion);
                sbM833U.append(", isMe=");
                return outline.m827O(sbM833U, this.isMe, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(User user, String str, String str2, GuildMember guildMember, List<GuildMember> list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
                String nick;
                super(null);
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(list, "guildMembersForAka");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                this.user = user;
                this.banner = str;
                this.bannerColorHex = str2;
                this.guildMember = guildMember;
                this.guildMembersForAka = list;
                this.presence = presence;
                this.streamContext = streamContext;
                this.userProfile = userProfile;
                this.isMeUserPremium = z2;
                this.isMeUserVerified = z3;
                this.allowAnimatedEmojis = z4;
                this.showPresence = z5;
                this.editable = z6;
                this.reducedMotionEnabled = z7;
                this.allowAnimationInReducedMotion = z8;
                this.isMe = z9;
                boolean z10 = false;
                boolean z11 = guildMember != null && guildMember.hasAvatar();
                this.hasGuildMemberAvatar = z11;
                boolean z12 = !StringsJVM.isBlank((guildMember == null || (nick = guildMember.getNick()) == null) ? "" : nick);
                this.hasNickname = z12;
                this.showMediumAvatar = z11 && !z12;
                this.showSmallAvatar = z11 && z12;
                this.shouldAnimateBanner = !z7 || z8;
                this.shouldShowGIFTag = z7 && !z8 && str != null && StringsJVM.startsWith$default(str, "a_", false, 2, null);
                this.isProfileLoaded = !Intrinsics3.areEqual(userProfile, StoreUserProfile.INSTANCE.getEMPTY_PROFILE());
                this.avatarColorId = LazyJVM.lazy(new UserProfileHeaderViewModel5(this));
                this.guildMemberColorId = LazyJVM.lazy(new UserProfileHeaderViewModel6(this));
                if ((!list.isEmpty()) && !z9) {
                    z10 = true;
                }
                this.showAkas = z10;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ UserProfileHeaderViewModel(long j, Long l, Long l2, Observable observable, boolean z2, StoreUser storeUser, StoreUserProfile storeUserProfile, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Long l3 = (i & 2) != 0 ? null : l;
        Long l4 = (i & 4) == 0 ? l2 : null;
        this(j, l3, l4, (i & 8) != 0 ? Companion.observeStoreState$default(INSTANCE, j, l3, l4, null, null, null, null, null, null, null, null, null, 4088, null) : observable, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 64) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile);
    }

    public static final /* synthetic */ void access$handleStoreState(UserProfileHeaderViewModel userProfileHeaderViewModel, StoreState storeState) {
        userProfileHeaderViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        List listEmptyList;
        long id2 = storeState.getUser().getId();
        GuildMember guildMember = storeState.getUserIdToGuildMemberMap().get(Long.valueOf(id2));
        NullSerializable<String> nullSerializableM8289b = storeState.getUserProfile().getUser().m8289b();
        if (!(nullSerializableM8289b instanceof NullSerializable.C5566b)) {
            nullSerializableM8289b = null;
        }
        NullSerializable.C5566b c5566b = (NullSerializable.C5566b) nullSerializableM8289b;
        String str = c5566b != null ? (String) c5566b.mo8429a() : null;
        Channel channel = storeState.getChannel();
        boolean z2 = channel != null && ChannelUtils.m7667B(channel);
        ViewState viewState = getViewState();
        User user = storeState.getUser();
        NullSerializable<String> nullSerializableM8290c = storeState.getUserProfile().getUser().m8290c();
        String strMo8429a = nullSerializableM8290c != null ? nullSerializableM8290c.mo8429a() : null;
        if (z2) {
            Collection<Map<Long, GuildMember>> guildMembers = storeState.getGuildMembers();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = guildMembers.iterator();
            while (it.hasNext()) {
                GuildMember guildMember2 = (GuildMember) ((Map) it.next()).get(Long.valueOf(id2));
                if (guildMember2 != null) {
                    arrayList.add(guildMember2);
                }
            }
            listEmptyList = _Collections.toList(arrayList);
        } else {
            listEmptyList = Collections2.emptyList();
        }
        ModelRichPresence richPresence = storeState.getRichPresence();
        updateViewState(new ViewState.Loaded(user, str, strMo8429a, guildMember, listEmptyList, richPresence != null ? richPresence.getPresence() : null, storeState.getStreamContext(), storeState.getUserProfile(), UserUtils.INSTANCE.isPremium(storeState.getMe()), storeState.getMe().isVerified(), storeState.getAllowAnimatedEmojis(), true, false, storeState.getReducedMotionEnabled(), viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getAllowAnimationInReducedMotion() : false, id2 == storeState.getMe().getId(), 4096, null));
    }

    @MainThread
    public final void toggleAllowAnimationInReducedMotion() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || !loaded.getReducedMotionEnabled()) {
            return;
        }
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, false, false, false, false, false, false, !loaded.getAllowAnimationInReducedMotion(), false, 49151, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel(long j, Long l, Long l2, Observable<StoreState> observable, boolean z2, StoreUser storeUser, StoreUserProfile storeUserProfile) {
        super(ViewState.Uninitialized.INSTANCE);
        long j2 = j;
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        this.userId = j2;
        if (z2) {
            StoreUserProfile.fetchProfile$default(storeUserProfile, j2 == -1 ? storeUser.getMeSnapshot().getId() : j2, l2, false, null, 12, null);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), UserProfileHeaderViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C103091(), 62, (Object) null);
    }
}
