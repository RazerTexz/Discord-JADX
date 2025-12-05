package com.discord.widgets.servers.community;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$1 */
    public static final /* synthetic */ class C94051 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public C94051(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel) {
            super(1, widgetServerSettingsEnableCommunityViewModel, WidgetServerSettingsEnableCommunityViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            WidgetServerSettingsEnableCommunityViewModel.access$handleStoreState((WidgetServerSettingsEnableCommunityViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final /* data */ class CommunityGuildConfig {
        private final boolean defaultMessageNotifications;
        private final boolean everyonePermissions;
        private final boolean explicitContentFilter;
        private final List<GuildFeature> features;
        private final Guild guild;
        private final boolean isPrivacyPolicyAccepted;
        private final Map<Long, GuildRole> roles;
        private final Channel rulesChannel;
        private final Long rulesChannelId;
        private final Channel updatesChannel;
        private final Long updatesChannelId;
        private final boolean verificationLevel;

        /* JADX WARN: Multi-variable type inference failed */
        public CommunityGuildConfig(Channel channel, Channel channel2, Long l, Long l2, boolean z2, boolean z3, boolean z4, boolean z5, Guild guild, boolean z6, List<? extends GuildFeature> list, Map<Long, GuildRole> map) {
            Intrinsics3.checkNotNullParameter(list, "features");
            this.rulesChannel = channel;
            this.updatesChannel = channel2;
            this.rulesChannelId = l;
            this.updatesChannelId = l2;
            this.isPrivacyPolicyAccepted = z2;
            this.defaultMessageNotifications = z3;
            this.verificationLevel = z4;
            this.explicitContentFilter = z5;
            this.guild = guild;
            this.everyonePermissions = z6;
            this.features = list;
            this.roles = map;
        }

        public static /* synthetic */ CommunityGuildConfig copy$default(CommunityGuildConfig communityGuildConfig, Channel channel, Channel channel2, Long l, Long l2, boolean z2, boolean z3, boolean z4, boolean z5, Guild guild, boolean z6, List list, Map map, int i, Object obj) {
            return communityGuildConfig.copy((i & 1) != 0 ? communityGuildConfig.rulesChannel : channel, (i & 2) != 0 ? communityGuildConfig.updatesChannel : channel2, (i & 4) != 0 ? communityGuildConfig.rulesChannelId : l, (i & 8) != 0 ? communityGuildConfig.updatesChannelId : l2, (i & 16) != 0 ? communityGuildConfig.isPrivacyPolicyAccepted : z2, (i & 32) != 0 ? communityGuildConfig.defaultMessageNotifications : z3, (i & 64) != 0 ? communityGuildConfig.verificationLevel : z4, (i & 128) != 0 ? communityGuildConfig.explicitContentFilter : z5, (i & 256) != 0 ? communityGuildConfig.guild : guild, (i & 512) != 0 ? communityGuildConfig.everyonePermissions : z6, (i & 1024) != 0 ? communityGuildConfig.features : list, (i & 2048) != 0 ? communityGuildConfig.roles : map);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getRulesChannel() {
            return this.rulesChannel;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getEveryonePermissions() {
            return this.everyonePermissions;
        }

        public final List<GuildFeature> component11() {
            return this.features;
        }

        public final Map<Long, GuildRole> component12() {
            return this.roles;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getUpdatesChannel() {
            return this.updatesChannel;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getRulesChannelId() {
            return this.rulesChannelId;
        }

        /* renamed from: component4, reason: from getter */
        public final Long getUpdatesChannelId() {
            return this.updatesChannelId;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsPrivacyPolicyAccepted() {
            return this.isPrivacyPolicyAccepted;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getDefaultMessageNotifications() {
            return this.defaultMessageNotifications;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getVerificationLevel() {
            return this.verificationLevel;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        /* renamed from: component9, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final CommunityGuildConfig copy(Channel rulesChannel, Channel updatesChannel, Long rulesChannelId, Long updatesChannelId, boolean isPrivacyPolicyAccepted, boolean defaultMessageNotifications, boolean verificationLevel, boolean explicitContentFilter, Guild guild, boolean everyonePermissions, List<? extends GuildFeature> features, Map<Long, GuildRole> roles) {
            Intrinsics3.checkNotNullParameter(features, "features");
            return new CommunityGuildConfig(rulesChannel, updatesChannel, rulesChannelId, updatesChannelId, isPrivacyPolicyAccepted, defaultMessageNotifications, verificationLevel, explicitContentFilter, guild, everyonePermissions, features, roles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommunityGuildConfig)) {
                return false;
            }
            CommunityGuildConfig communityGuildConfig = (CommunityGuildConfig) other;
            return Intrinsics3.areEqual(this.rulesChannel, communityGuildConfig.rulesChannel) && Intrinsics3.areEqual(this.updatesChannel, communityGuildConfig.updatesChannel) && Intrinsics3.areEqual(this.rulesChannelId, communityGuildConfig.rulesChannelId) && Intrinsics3.areEqual(this.updatesChannelId, communityGuildConfig.updatesChannelId) && this.isPrivacyPolicyAccepted == communityGuildConfig.isPrivacyPolicyAccepted && this.defaultMessageNotifications == communityGuildConfig.defaultMessageNotifications && this.verificationLevel == communityGuildConfig.verificationLevel && this.explicitContentFilter == communityGuildConfig.explicitContentFilter && Intrinsics3.areEqual(this.guild, communityGuildConfig.guild) && this.everyonePermissions == communityGuildConfig.everyonePermissions && Intrinsics3.areEqual(this.features, communityGuildConfig.features) && Intrinsics3.areEqual(this.roles, communityGuildConfig.roles);
        }

        public final boolean getDefaultMessageNotifications() {
            return this.defaultMessageNotifications;
        }

        public final boolean getEveryonePermissions() {
            return this.everyonePermissions;
        }

        public final boolean getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        public final List<GuildFeature> getFeatures() {
            return this.features;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Channel getRulesChannel() {
            return this.rulesChannel;
        }

        public final Long getRulesChannelId() {
            return this.rulesChannelId;
        }

        public final Channel getUpdatesChannel() {
            return this.updatesChannel;
        }

        public final Long getUpdatesChannelId() {
            return this.updatesChannelId;
        }

        public final boolean getVerificationLevel() {
            return this.verificationLevel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.rulesChannel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Channel channel2 = this.updatesChannel;
            int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
            Long l = this.rulesChannelId;
            int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
            Long l2 = this.updatesChannelId;
            int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 31;
            boolean z2 = this.isPrivacyPolicyAccepted;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode4 + i) * 31;
            boolean z3 = this.defaultMessageNotifications;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.verificationLevel;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.explicitContentFilter;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            Guild guild = this.guild;
            int iHashCode5 = (i8 + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z6 = this.everyonePermissions;
            int i9 = (iHashCode5 + (z6 ? 1 : z6 ? 1 : 0)) * 31;
            List<GuildFeature> list = this.features;
            int iHashCode6 = (i9 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map = this.roles;
            return iHashCode6 + (map != null ? map.hashCode() : 0);
        }

        public final boolean isPrivacyPolicyAccepted() {
            return this.isPrivacyPolicyAccepted;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("CommunityGuildConfig(rulesChannel=");
            sbM833U.append(this.rulesChannel);
            sbM833U.append(", updatesChannel=");
            sbM833U.append(this.updatesChannel);
            sbM833U.append(", rulesChannelId=");
            sbM833U.append(this.rulesChannelId);
            sbM833U.append(", updatesChannelId=");
            sbM833U.append(this.updatesChannelId);
            sbM833U.append(", isPrivacyPolicyAccepted=");
            sbM833U.append(this.isPrivacyPolicyAccepted);
            sbM833U.append(", defaultMessageNotifications=");
            sbM833U.append(this.defaultMessageNotifications);
            sbM833U.append(", verificationLevel=");
            sbM833U.append(this.verificationLevel);
            sbM833U.append(", explicitContentFilter=");
            sbM833U.append(this.explicitContentFilter);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", everyonePermissions=");
            sbM833U.append(this.everyonePermissions);
            sbM833U.append(", features=");
            sbM833U.append(this.features);
            sbM833U.append(", roles=");
            return outline.m825M(sbM833U, this.roles, ")");
        }

        public /* synthetic */ CommunityGuildConfig(Channel channel, Channel channel2, Long l, Long l2, boolean z2, boolean z3, boolean z4, boolean z5, Guild guild, boolean z6, List list, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, channel2, l, l2, z2, z3, z4, z5, guild, z6, (i & 1024) != 0 ? new ArrayList() : list, map);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreUser storeUsers) {
            Observable observableM11099Y = storeGuilds.observeGuild(guildId).m11099Y(new WidgetServerSettingsEnableCommunityViewModel2(storeUsers, storePermissions, guildId, storeChannels));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "storeGuilds.observeGuild…      }\n        }\n      }");
            return observableM11099Y;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, StoreGuilds storeGuilds, StoreChannels storeChannels, StorePermissions storePermissions, StoreUser storeUser, int i, Object obj) {
            if ((i & 2) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            StoreGuilds storeGuilds2 = storeGuilds;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            StorePermissions storePermissions2 = storePermissions;
            if ((i & 16) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(j, storeGuilds2, storeChannels2, storePermissions2, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static abstract class Event {

        /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final class SaveSuccess extends Event {
            public static final SaveSuccess INSTANCE = new SaveSuccess();

            private SaveSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static abstract class StoreState {

        /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final MeUser me;
            private final Long permissions;
            private final Map<Long, GuildRole> roles;
            private final Channel rulesChannel;
            private final Channel updatesChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, MeUser meUser, Long l, Map<Long, GuildRole> map, Channel channel, Channel channel2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(meUser, "me");
                this.guild = guild;
                this.me = meUser;
                this.permissions = l;
                this.roles = map;
                this.rulesChannel = channel;
                this.updatesChannel = channel2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, MeUser meUser, Long l, Map map, Channel channel, Channel channel2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    meUser = valid.me;
                }
                MeUser meUser2 = meUser;
                if ((i & 4) != 0) {
                    l = valid.permissions;
                }
                Long l2 = l;
                if ((i & 8) != 0) {
                    map = valid.roles;
                }
                Map map2 = map;
                if ((i & 16) != 0) {
                    channel = valid.rulesChannel;
                }
                Channel channel3 = channel;
                if ((i & 32) != 0) {
                    channel2 = valid.updatesChannel;
                }
                return valid.copy(guild, meUser2, l2, map2, channel3, channel2);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final MeUser getMe() {
                return this.me;
            }

            /* renamed from: component3, reason: from getter */
            public final Long getPermissions() {
                return this.permissions;
            }

            public final Map<Long, GuildRole> component4() {
                return this.roles;
            }

            /* renamed from: component5, reason: from getter */
            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            /* renamed from: component6, reason: from getter */
            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public final Valid copy(Guild guild, MeUser me2, Long permissions, Map<Long, GuildRole> roles, Channel rulesChannel, Channel updatesChannel) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(me2, "me");
                return new Valid(guild, me2, permissions, roles, rulesChannel, updatesChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && Intrinsics3.areEqual(this.me, valid.me) && Intrinsics3.areEqual(this.permissions, valid.permissions) && Intrinsics3.areEqual(this.roles, valid.roles) && Intrinsics3.areEqual(this.rulesChannel, valid.rulesChannel) && Intrinsics3.areEqual(this.updatesChannel, valid.updatesChannel);
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final MeUser getMe() {
                return this.me;
            }

            public final Long getPermissions() {
                return this.permissions;
            }

            public final Map<Long, GuildRole> getRoles() {
                return this.roles;
            }

            public final Channel getRulesChannel() {
                return this.rulesChannel;
            }

            public final Channel getUpdatesChannel() {
                return this.updatesChannel;
            }

            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                MeUser meUser = this.me;
                int iHashCode2 = (iHashCode + (meUser != null ? meUser.hashCode() : 0)) * 31;
                Long l = this.permissions;
                int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.roles;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Channel channel = this.rulesChannel;
                int iHashCode5 = (iHashCode4 + (channel != null ? channel.hashCode() : 0)) * 31;
                Channel channel2 = this.updatesChannel;
                return iHashCode5 + (channel2 != null ? channel2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Valid(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", me=");
                sbM833U.append(this.me);
                sbM833U.append(", permissions=");
                sbM833U.append(this.permissions);
                sbM833U.append(", roles=");
                sbM833U.append(this.roles);
                sbM833U.append(", rulesChannel=");
                sbM833U.append(this.rulesChannel);
                sbM833U.append(", updatesChannel=");
                sbM833U.append(this.updatesChannel);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final CommunityGuildConfig communityGuildConfig;
            private final int currentPage;
            private final boolean isLoading;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(int i, boolean z2, CommunityGuildConfig communityGuildConfig) {
                super(null);
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "communityGuildConfig");
                this.currentPage = i;
                this.isLoading = z2;
                this.communityGuildConfig = communityGuildConfig;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, int i, boolean z2, CommunityGuildConfig communityGuildConfig, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = loaded.currentPage;
                }
                if ((i2 & 2) != 0) {
                    z2 = loaded.isLoading;
                }
                if ((i2 & 4) != 0) {
                    communityGuildConfig = loaded.communityGuildConfig;
                }
                return loaded.copy(i, z2, communityGuildConfig);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCurrentPage() {
                return this.currentPage;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsLoading() {
                return this.isLoading;
            }

            /* renamed from: component3, reason: from getter */
            public final CommunityGuildConfig getCommunityGuildConfig() {
                return this.communityGuildConfig;
            }

            public final Loaded copy(int currentPage, boolean isLoading, CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "communityGuildConfig");
                return new Loaded(currentPage, isLoading, communityGuildConfig);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.currentPage == loaded.currentPage && this.isLoading == loaded.isLoading && Intrinsics3.areEqual(this.communityGuildConfig, loaded.communityGuildConfig);
            }

            public final CommunityGuildConfig getCommunityGuildConfig() {
                return this.communityGuildConfig;
            }

            public final int getCurrentPage() {
                return this.currentPage;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int i = this.currentPage * 31;
                boolean z2 = this.isLoading;
                int i2 = z2;
                if (z2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                CommunityGuildConfig communityGuildConfig = this.communityGuildConfig;
                return i3 + (communityGuildConfig != null ? communityGuildConfig.hashCode() : 0);
            }

            public final boolean isLoading() {
                return this.isLoading;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(currentPage=");
                sbM833U.append(this.currentPage);
                sbM833U.append(", isLoading=");
                sbM833U.append(this.isLoading);
                sbM833U.append(", communityGuildConfig=");
                sbM833U.append(this.communityGuildConfig);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
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
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$patchRole$1 */
    public static final class C94071 extends Lambda implements Function1<Error, Unit> {
        public C94071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsEnableCommunityViewModel.access$handleGuildUpdateError(WidgetServerSettingsEnableCommunityViewModel.this);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$patchRole$2 */
    public static final class C94082 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ ViewState.Loaded $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C94082(ViewState.Loaded loaded) {
            super(1);
            this.$currentViewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            WidgetServerSettingsEnableCommunityViewModel.access$updateViewState(WidgetServerSettingsEnableCommunityViewModel.this, ViewState.Loaded.copy$default(this.$currentViewState, 0, false, null, 5, null));
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetServerSettingsEnableCommunityViewModel.access$getEventSubject$p(WidgetServerSettingsEnableCommunityViewModel.this);
            publishSubjectAccess$getEventSubject$p.f27650k.onNext(Event.SaveSuccess.INSTANCE);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$updateGuild$1 */
    public static final class C94091 extends Lambda implements Function1<Error, Unit> {
        public C94091() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsEnableCommunityViewModel.access$handleGuildUpdateError(WidgetServerSettingsEnableCommunityViewModel.this);
        }
    }

    /* compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel$updateGuild$2 */
    public static final class C94102 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public final /* synthetic */ CommunityGuildConfig $currentConfig;
        public final /* synthetic */ ViewState.Loaded $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C94102(CommunityGuildConfig communityGuildConfig, ViewState.Loaded loaded) {
            super(1);
            this.$currentConfig = communityGuildConfig;
            this.$currentViewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            GuildRole guildRole;
            Intrinsics3.checkNotNullParameter(guild, "it");
            if (this.$currentConfig.getEveryonePermissions()) {
                Map<Long, GuildRole> roles = this.$currentConfig.getRoles();
                WidgetServerSettingsEnableCommunityViewModel.access$patchRole(WidgetServerSettingsEnableCommunityViewModel.this, new RestAPIParams.Role(null, null, null, null, null, Long.valueOf((-1116960071743L) & ((roles == null || (guildRole = roles.get(Long.valueOf(WidgetServerSettingsEnableCommunityViewModel.this.getGuildId()))) == null) ? 0L : guildRole.getPermissions())), guild.getId(), null, Opcodes.IF_ICMPEQ, null));
            } else {
                WidgetServerSettingsEnableCommunityViewModel.access$updateViewState(WidgetServerSettingsEnableCommunityViewModel.this, ViewState.Loaded.copy$default(this.$currentViewState, 0, false, null, 5, null));
                WidgetServerSettingsEnableCommunityViewModel.access$getEventSubject$p(WidgetServerSettingsEnableCommunityViewModel.this).f27650k.onNext(Event.SaveSuccess.INSTANCE);
            }
        }
    }

    public /* synthetic */ WidgetServerSettingsEnableCommunityViewModel(long j, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? Companion.observeStoreState$default(INSTANCE, j, null, null, null, null, 30, null) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel) {
        return widgetServerSettingsEnableCommunityViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleGuildUpdateError(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel) {
        widgetServerSettingsEnableCommunityViewModel.handleGuildUpdateError();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel, StoreState storeState) {
        widgetServerSettingsEnableCommunityViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$patchRole(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel, RestAPIParams.Role role) {
        widgetServerSettingsEnableCommunityViewModel.patchRole(role);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel, ViewState viewState) {
        widgetServerSettingsEnableCommunityViewModel.updateViewState(viewState);
    }

    @MainThread
    private final RestAPIParams.UpdateGuild getUpdatedGuildParams() {
        GuildVerificationLevel verificationLevel;
        GuildVerificationLevel guildVerificationLevel;
        GuildExplicitContentFilter explicitContentFilter;
        GuildExplicitContentFilter guildExplicitContentFilter;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null) {
            return new RestAPIParams.UpdateGuild(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
        }
        CommunityGuildConfig communityGuildConfig = loaded.getCommunityGuildConfig();
        List listPlus = _Collections.plus((Collection<? extends GuildFeature>) communityGuildConfig.getFeatures(), GuildFeature.COMMUNITY);
        Guild guild = communityGuildConfig.getGuild();
        if (guild == null || (verificationLevel = guild.getVerificationLevel()) == null) {
            verificationLevel = GuildVerificationLevel.NONE;
        }
        GuildVerificationLevel guildVerificationLevel2 = GuildVerificationLevel.NONE;
        if (verificationLevel.compareTo(guildVerificationLevel2) <= 0 || communityGuildConfig.getVerificationLevel()) {
            if (verificationLevel == guildVerificationLevel2 && communityGuildConfig.getVerificationLevel()) {
                verificationLevel = GuildVerificationLevel.LOW;
            }
            guildVerificationLevel = verificationLevel;
        } else {
            guildVerificationLevel = guildVerificationLevel2;
        }
        Guild guild2 = communityGuildConfig.getGuild();
        if (guild2 == null || (explicitContentFilter = guild2.getExplicitContentFilter()) == null) {
            explicitContentFilter = GuildExplicitContentFilter.NONE;
        }
        GuildExplicitContentFilter guildExplicitContentFilter2 = GuildExplicitContentFilter.NONE;
        if (explicitContentFilter.compareTo(guildExplicitContentFilter2) <= 0 || communityGuildConfig.getExplicitContentFilter()) {
            if (explicitContentFilter == guildExplicitContentFilter2 && communityGuildConfig.getExplicitContentFilter()) {
                explicitContentFilter = GuildExplicitContentFilter.ALL;
            }
            guildExplicitContentFilter = explicitContentFilter;
        } else {
            guildExplicitContentFilter = guildExplicitContentFilter2;
        }
        boolean defaultMessageNotifications = communityGuildConfig.getDefaultMessageNotifications();
        int i = 1;
        if (!defaultMessageNotifications) {
            if (defaultMessageNotifications) {
                throw new NoWhenBranchMatchedException();
            }
            i = 0;
        }
        return new RestAPIParams.UpdateGuild(null, null, null, Integer.valueOf(i), null, null, guildVerificationLevel, guildExplicitContentFilter, null, null, null, listPlus, communityGuildConfig.getRulesChannelId(), communityGuildConfig.getUpdatesChannelId(), null, 18231, null);
    }

    private final void handleGuildUpdateError() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, 0, false, null, 5, null));
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.f27650k.onNext(Event.Error.INSTANCE);
        }
    }

    private final void handleStoreState(StoreState storeState) {
        GuildRole guildRole;
        GuildRole guildRole2;
        if (!(storeState instanceof StoreState.Valid)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        Guild guild = valid.getGuild();
        MeUser me2 = valid.getMe();
        if (!(guild.isOwner(me2.getId()) || PermissionUtils.canAndIsElevated(32L, valid.getPermissions(), me2.getMfaEnabled(), guild.getMfaLevel()))) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        Channel rulesChannel = valid.getRulesChannel();
        Channel updatesChannel = valid.getUpdatesChannel();
        boolean z2 = guild.getDefaultMessageNotifications() == 1;
        boolean z3 = guild.getVerificationLevel().compareTo(GuildVerificationLevel.NONE) > 0;
        boolean z4 = guild.getExplicitContentFilter().compareTo(GuildExplicitContentFilter.NONE) > 0;
        Map<Long, GuildRole> roles = valid.getRoles();
        long permissions = (-1116960071743L) & ((roles == null || (guildRole2 = roles.get(Long.valueOf(this.guildId))) == null) ? 0L : guildRole2.getPermissions());
        Map<Long, GuildRole> roles2 = valid.getRoles();
        updateViewState(new ViewState.Loaded(0, false, new CommunityGuildConfig(rulesChannel, updatesChannel, 1L, 1L, false, z2, z3, z4, guild, (roles2 == null || (guildRole = roles2.get(Long.valueOf(this.guildId))) == null || permissions != guildRole.getPermissions()) ? false : true, _Collections.toList(guild.getFeatures()), valid.getRoles())));
    }

    private final void patchRole(RestAPIParams.Role roleParams) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            RestAPI api = RestAPI.INSTANCE.getApi();
            long j = this.guildId;
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.updateRole(j, j, roleParams), false, 1, null), this, null, 2, null), WidgetServerSettingsEnableCommunityViewModel.class, (Context) null, (Function1) null, new C94071(), (Function0) null, (Function0) null, new C94082(loaded), 54, (Object) null);
        }
    }

    public final long getGuildId() {
        return this.guildId;
    }

    @MainThread
    public final void goBackToPreviousPage() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        if (((ViewState.Loaded) viewState) != null) {
            updateCurrentPage(r0.getCurrentPage() - 1);
        }
    }

    @MainThread
    public final void modifyGuildConfig(Function1<? super CommunityGuildConfig, CommunityGuildConfig> transform) {
        Intrinsics3.checkNotNullParameter(transform, "transform");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, 0, false, transform.invoke(loaded.getCommunityGuildConfig()), 3, null));
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void updateCurrentPage(int currentPage) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, currentPage, false, null, 6, null));
        }
    }

    public final void updateGuild() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            CommunityGuildConfig communityGuildConfig = loaded.getCommunityGuildConfig();
            updateViewState(ViewState.Loaded.copy$default(loaded, 0, true, null, 5, null));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(this.guildId, getUpdatedGuildParams()), false, 1, null), this, null, 2, null), WidgetServerSettingsEnableCommunityViewModel.class, (Context) null, (Function1) null, new C94091(), (Function0) null, (Function0) null, new C94102(communityGuildConfig, loaded), 54, (Object) null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunityViewModel(long j, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetServerSettingsEnableCommunityViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C94051(this), 62, (Object) null);
    }
}
