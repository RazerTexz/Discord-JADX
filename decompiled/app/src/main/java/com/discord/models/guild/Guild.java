package com.discord.models.guild;

import a0.a.a.b;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import b.d.b.a.a;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildHubType;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guild.welcome.GuildWelcomeScreen;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.guilds.GuildUtilsKt;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Guild.kt */
/* loaded from: classes.dex */
public final /* data */ class Guild {
    private final Long afkChannelId;
    private final int afkTimeout;
    private final int approximatePresenceCount;
    private final String banner;
    private final int defaultMessageNotifications;
    private final String description;
    private final List<GuildEmoji> emojis;
    private final GuildExplicitContentFilter explicitContentFilter;
    private final Set<GuildFeature> features;
    private final GuildHubType hubType;
    private final String icon;
    private final long id;
    private final String joinedAt;
    private final GuildMaxVideoChannelUsers maxVideoChannelUsers;
    private final int memberCount;
    private final int mfaLevel;
    private final String name;
    private final boolean nsfw;
    private final long ownerId;
    private final String preferredLocale;
    private final int premiumSubscriptionCount;
    private final int premiumTier;
    private final Long publicUpdatesChannelId;
    private final String region;
    private final List<GuildRole> roles;
    private final Long rulesChannelId;
    private final String shortName;
    private final String splash;
    private final List<Sticker> stickers;
    private final int systemChannelFlags;
    private final Long systemChannelId;
    private final boolean unavailable;
    private final String vanityUrlCode;
    private final GuildVerificationLevel verificationLevel;
    private final GuildWelcomeScreen welcomeScreen;

    public Guild() {
        this(null, null, null, null, null, 0, 0L, null, 0L, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, false, null, -1, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Guild(List<GuildRole> list, List<GuildEmoji> list2, List<Sticker> list3, String str, String str2, int i, long j, String str3, long j2, String str4, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, boolean z2, int i2, int i3, Long l, Long l2, Set<? extends GuildFeature> set, int i4, String str5, String str6, int i5, int i6, int i7, String str7, Long l3, Long l4, String str8, GuildWelcomeScreen guildWelcomeScreen, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, String str9, int i8, boolean z3, GuildHubType guildHubType) {
        m.checkNotNullParameter(list, "roles");
        m.checkNotNullParameter(list2, "emojis");
        m.checkNotNullParameter(list3, "stickers");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(guildVerificationLevel, "verificationLevel");
        m.checkNotNullParameter(guildExplicitContentFilter, "explicitContentFilter");
        m.checkNotNullParameter(set, "features");
        m.checkNotNullParameter(guildMaxVideoChannelUsers, "maxVideoChannelUsers");
        this.roles = list;
        this.emojis = list2;
        this.stickers = list3;
        this.name = str;
        this.description = str2;
        this.defaultMessageNotifications = i;
        this.id = j;
        this.region = str3;
        this.ownerId = j2;
        this.icon = str4;
        this.verificationLevel = guildVerificationLevel;
        this.explicitContentFilter = guildExplicitContentFilter;
        this.unavailable = z2;
        this.mfaLevel = i2;
        this.afkTimeout = i3;
        this.afkChannelId = l;
        this.systemChannelId = l2;
        this.features = set;
        this.memberCount = i4;
        this.banner = str5;
        this.splash = str6;
        this.premiumTier = i5;
        this.premiumSubscriptionCount = i6;
        this.systemChannelFlags = i7;
        this.joinedAt = str7;
        this.rulesChannelId = l3;
        this.publicUpdatesChannelId = l4;
        this.preferredLocale = str8;
        this.welcomeScreen = guildWelcomeScreen;
        this.maxVideoChannelUsers = guildMaxVideoChannelUsers;
        this.vanityUrlCode = str9;
        this.approximatePresenceCount = i8;
        this.nsfw = z3;
        this.hubType = guildHubType;
        this.shortName = GuildUtilsKt.computeShortName(str);
    }

    public static /* synthetic */ Guild copy$default(Guild guild, List list, List list2, List list3, String str, String str2, int i, long j, String str3, long j2, String str4, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, boolean z2, int i2, int i3, Long l, Long l2, Set set, int i4, String str5, String str6, int i5, int i6, int i7, String str7, Long l3, Long l4, String str8, GuildWelcomeScreen guildWelcomeScreen, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, String str9, int i8, boolean z3, GuildHubType guildHubType, int i9, int i10, Object obj) {
        return guild.copy((i9 & 1) != 0 ? guild.roles : list, (i9 & 2) != 0 ? guild.emojis : list2, (i9 & 4) != 0 ? guild.stickers : list3, (i9 & 8) != 0 ? guild.name : str, (i9 & 16) != 0 ? guild.description : str2, (i9 & 32) != 0 ? guild.defaultMessageNotifications : i, (i9 & 64) != 0 ? guild.id : j, (i9 & 128) != 0 ? guild.region : str3, (i9 & 256) != 0 ? guild.ownerId : j2, (i9 & 512) != 0 ? guild.icon : str4, (i9 & 1024) != 0 ? guild.verificationLevel : guildVerificationLevel, (i9 & 2048) != 0 ? guild.explicitContentFilter : guildExplicitContentFilter, (i9 & 4096) != 0 ? guild.unavailable : z2, (i9 & 8192) != 0 ? guild.mfaLevel : i2, (i9 & 16384) != 0 ? guild.afkTimeout : i3, (i9 & 32768) != 0 ? guild.afkChannelId : l, (i9 & 65536) != 0 ? guild.systemChannelId : l2, (i9 & 131072) != 0 ? guild.features : set, (i9 & 262144) != 0 ? guild.memberCount : i4, (i9 & 524288) != 0 ? guild.banner : str5, (i9 & 1048576) != 0 ? guild.splash : str6, (i9 & 2097152) != 0 ? guild.premiumTier : i5, (i9 & 4194304) != 0 ? guild.premiumSubscriptionCount : i6, (i9 & 8388608) != 0 ? guild.systemChannelFlags : i7, (i9 & 16777216) != 0 ? guild.joinedAt : str7, (i9 & 33554432) != 0 ? guild.rulesChannelId : l3, (i9 & 67108864) != 0 ? guild.publicUpdatesChannelId : l4, (i9 & 134217728) != 0 ? guild.preferredLocale : str8, (i9 & 268435456) != 0 ? guild.welcomeScreen : guildWelcomeScreen, (i9 & 536870912) != 0 ? guild.maxVideoChannelUsers : guildMaxVideoChannelUsers, (i9 & BasicMeasure.EXACTLY) != 0 ? guild.vanityUrlCode : str9, (i9 & Integer.MIN_VALUE) != 0 ? guild.approximatePresenceCount : i8, (i10 & 1) != 0 ? guild.nsfw : z3, (i10 & 2) != 0 ? guild.hubType : guildHubType);
    }

    public final boolean canHaveAnimatedBanner() {
        return hasFeature(GuildFeature.ANIMATED_BANNER);
    }

    public final boolean canHaveBanner() {
        return hasFeature(GuildFeature.BANNER) || hasFeature(GuildFeature.VERIFIED) || this.premiumTier >= 2;
    }

    public final boolean canHaveSplash() {
        return hasFeature(GuildFeature.INVITE_SPLASH) || hasFeature(GuildFeature.VERIFIED) || this.premiumTier >= 1;
    }

    public final boolean canHaveVanityURL() {
        return this.features.contains(GuildFeature.VANITY_URL) || this.premiumTier >= 3;
    }

    public final List<GuildRole> component1() {
        return this.roles;
    }

    /* renamed from: component10, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component11, reason: from getter */
    public final GuildVerificationLevel getVerificationLevel() {
        return this.verificationLevel;
    }

    /* renamed from: component12, reason: from getter */
    public final GuildExplicitContentFilter getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getUnavailable() {
        return this.unavailable;
    }

    /* renamed from: component14, reason: from getter */
    public final int getMfaLevel() {
        return this.mfaLevel;
    }

    /* renamed from: component15, reason: from getter */
    public final int getAfkTimeout() {
        return this.afkTimeout;
    }

    /* renamed from: component16, reason: from getter */
    public final Long getAfkChannelId() {
        return this.afkChannelId;
    }

    /* renamed from: component17, reason: from getter */
    public final Long getSystemChannelId() {
        return this.systemChannelId;
    }

    public final Set<GuildFeature> component18() {
        return this.features;
    }

    /* renamed from: component19, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    public final List<GuildEmoji> component2() {
        return this.emojis;
    }

    /* renamed from: component20, reason: from getter */
    public final String getBanner() {
        return this.banner;
    }

    /* renamed from: component21, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    /* renamed from: component22, reason: from getter */
    public final int getPremiumTier() {
        return this.premiumTier;
    }

    /* renamed from: component23, reason: from getter */
    public final int getPremiumSubscriptionCount() {
        return this.premiumSubscriptionCount;
    }

    /* renamed from: component24, reason: from getter */
    public final int getSystemChannelFlags() {
        return this.systemChannelFlags;
    }

    /* renamed from: component25, reason: from getter */
    public final String getJoinedAt() {
        return this.joinedAt;
    }

    /* renamed from: component26, reason: from getter */
    public final Long getRulesChannelId() {
        return this.rulesChannelId;
    }

    /* renamed from: component27, reason: from getter */
    public final Long getPublicUpdatesChannelId() {
        return this.publicUpdatesChannelId;
    }

    /* renamed from: component28, reason: from getter */
    public final String getPreferredLocale() {
        return this.preferredLocale;
    }

    /* renamed from: component29, reason: from getter */
    public final GuildWelcomeScreen getWelcomeScreen() {
        return this.welcomeScreen;
    }

    public final List<Sticker> component3() {
        return this.stickers;
    }

    /* renamed from: component30, reason: from getter */
    public final GuildMaxVideoChannelUsers getMaxVideoChannelUsers() {
        return this.maxVideoChannelUsers;
    }

    /* renamed from: component31, reason: from getter */
    public final String getVanityUrlCode() {
        return this.vanityUrlCode;
    }

    /* renamed from: component32, reason: from getter */
    public final int getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    /* renamed from: component33, reason: from getter */
    public final boolean getNsfw() {
        return this.nsfw;
    }

    /* renamed from: component34, reason: from getter */
    public final GuildHubType getHubType() {
        return this.hubType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final int getDefaultMessageNotifications() {
        return this.defaultMessageNotifications;
    }

    /* renamed from: component7, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component8, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component9, reason: from getter */
    public final long getOwnerId() {
        return this.ownerId;
    }

    public final Guild copy(List<GuildRole> roles, List<GuildEmoji> emojis, List<Sticker> stickers, String name, String description, int defaultMessageNotifications, long id2, String region, long ownerId, String icon, GuildVerificationLevel verificationLevel, GuildExplicitContentFilter explicitContentFilter, boolean unavailable, int mfaLevel, int afkTimeout, Long afkChannelId, Long systemChannelId, Set<? extends GuildFeature> features, int memberCount, String banner, String splash, int premiumTier, int premiumSubscriptionCount, int systemChannelFlags, String joinedAt, Long rulesChannelId, Long publicUpdatesChannelId, String preferredLocale, GuildWelcomeScreen welcomeScreen, GuildMaxVideoChannelUsers maxVideoChannelUsers, String vanityUrlCode, int approximatePresenceCount, boolean nsfw, GuildHubType hubType) {
        m.checkNotNullParameter(roles, "roles");
        m.checkNotNullParameter(emojis, "emojis");
        m.checkNotNullParameter(stickers, "stickers");
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(verificationLevel, "verificationLevel");
        m.checkNotNullParameter(explicitContentFilter, "explicitContentFilter");
        m.checkNotNullParameter(features, "features");
        m.checkNotNullParameter(maxVideoChannelUsers, "maxVideoChannelUsers");
        return new Guild(roles, emojis, stickers, name, description, defaultMessageNotifications, id2, region, ownerId, icon, verificationLevel, explicitContentFilter, unavailable, mfaLevel, afkTimeout, afkChannelId, systemChannelId, features, memberCount, banner, splash, premiumTier, premiumSubscriptionCount, systemChannelFlags, joinedAt, rulesChannelId, publicUpdatesChannelId, preferredLocale, welcomeScreen, maxVideoChannelUsers, vanityUrlCode, approximatePresenceCount, nsfw, hubType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Guild)) {
            return false;
        }
        Guild guild = (Guild) other;
        return m.areEqual(this.roles, guild.roles) && m.areEqual(this.emojis, guild.emojis) && m.areEqual(this.stickers, guild.stickers) && m.areEqual(this.name, guild.name) && m.areEqual(this.description, guild.description) && this.defaultMessageNotifications == guild.defaultMessageNotifications && this.id == guild.id && m.areEqual(this.region, guild.region) && this.ownerId == guild.ownerId && m.areEqual(this.icon, guild.icon) && m.areEqual(this.verificationLevel, guild.verificationLevel) && m.areEqual(this.explicitContentFilter, guild.explicitContentFilter) && this.unavailable == guild.unavailable && this.mfaLevel == guild.mfaLevel && this.afkTimeout == guild.afkTimeout && m.areEqual(this.afkChannelId, guild.afkChannelId) && m.areEqual(this.systemChannelId, guild.systemChannelId) && m.areEqual(this.features, guild.features) && this.memberCount == guild.memberCount && m.areEqual(this.banner, guild.banner) && m.areEqual(this.splash, guild.splash) && this.premiumTier == guild.premiumTier && this.premiumSubscriptionCount == guild.premiumSubscriptionCount && this.systemChannelFlags == guild.systemChannelFlags && m.areEqual(this.joinedAt, guild.joinedAt) && m.areEqual(this.rulesChannelId, guild.rulesChannelId) && m.areEqual(this.publicUpdatesChannelId, guild.publicUpdatesChannelId) && m.areEqual(this.preferredLocale, guild.preferredLocale) && m.areEqual(this.welcomeScreen, guild.welcomeScreen) && m.areEqual(this.maxVideoChannelUsers, guild.maxVideoChannelUsers) && m.areEqual(this.vanityUrlCode, guild.vanityUrlCode) && this.approximatePresenceCount == guild.approximatePresenceCount && this.nsfw == guild.nsfw && m.areEqual(this.hubType, guild.hubType);
    }

    public final Long getAfkChannelId() {
        return this.afkChannelId;
    }

    public final int getAfkTimeout() {
        return this.afkTimeout;
    }

    public final int getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    public final String getBanner() {
        return this.banner;
    }

    public final int getDefaultMessageNotifications() {
        return this.defaultMessageNotifications;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<GuildEmoji> getEmojis() {
        return this.emojis;
    }

    public final GuildExplicitContentFilter getExplicitContentFilter() {
        return this.explicitContentFilter;
    }

    public final Set<GuildFeature> getFeatures() {
        return this.features;
    }

    public final GuildHubType getHubType() {
        return this.hubType;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final long getId() {
        return this.id;
    }

    public final String getJoinedAt() {
        return this.joinedAt;
    }

    public final GuildMaxVideoChannelUsers getMaxVideoChannelUsers() {
        return this.maxVideoChannelUsers;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final int getMfaLevel() {
        return this.mfaLevel;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNsfw() {
        return this.nsfw;
    }

    public final long getOwnerId() {
        return this.ownerId;
    }

    public final String getPreferredLocale() {
        return this.preferredLocale;
    }

    public final int getPremiumSubscriptionCount() {
        return this.premiumSubscriptionCount;
    }

    public final int getPremiumTier() {
        return this.premiumTier;
    }

    public final Long getPublicUpdatesChannelId() {
        return this.publicUpdatesChannelId;
    }

    public final String getRegion() {
        return this.region;
    }

    public final List<GuildRole> getRoles() {
        return this.roles;
    }

    public final Long getRulesChannelId() {
        return this.rulesChannelId;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public final String getSplash() {
        return this.splash;
    }

    public final List<Sticker> getStickers() {
        return this.stickers;
    }

    public final int getSystemChannelFlags() {
        return this.systemChannelFlags;
    }

    public final Long getSystemChannelId() {
        return this.systemChannelId;
    }

    public final boolean getUnavailable() {
        return this.unavailable;
    }

    public final String getVanityUrlCode() {
        return this.vanityUrlCode;
    }

    public final GuildVerificationLevel getVerificationLevel() {
        return this.verificationLevel;
    }

    public final GuildWelcomeScreen getWelcomeScreen() {
        return this.welcomeScreen;
    }

    public final boolean hasFeature(GuildFeature feature) {
        m.checkNotNullParameter(feature, "feature");
        return this.features.contains(feature);
    }

    public final boolean hasIcon() {
        String str = this.icon;
        return !(str == null || str.length() == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<GuildRole> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<GuildEmoji> list2 = this.emojis;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Sticker> list3 = this.stickers;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str = this.name;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iA = (b.a(this.id) + ((((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.defaultMessageNotifications) * 31)) * 31;
        String str3 = this.region;
        int iA2 = (b.a(this.ownerId) + ((iA + (str3 != null ? str3.hashCode() : 0)) * 31)) * 31;
        String str4 = this.icon;
        int iHashCode5 = (iA2 + (str4 != null ? str4.hashCode() : 0)) * 31;
        GuildVerificationLevel guildVerificationLevel = this.verificationLevel;
        int iHashCode6 = (iHashCode5 + (guildVerificationLevel != null ? guildVerificationLevel.hashCode() : 0)) * 31;
        GuildExplicitContentFilter guildExplicitContentFilter = this.explicitContentFilter;
        int iHashCode7 = (iHashCode6 + (guildExplicitContentFilter != null ? guildExplicitContentFilter.hashCode() : 0)) * 31;
        boolean z2 = this.unavailable;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (((((iHashCode7 + i) * 31) + this.mfaLevel) * 31) + this.afkTimeout) * 31;
        Long l = this.afkChannelId;
        int iHashCode8 = (i2 + (l != null ? l.hashCode() : 0)) * 31;
        Long l2 = this.systemChannelId;
        int iHashCode9 = (iHashCode8 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Set<GuildFeature> set = this.features;
        int iHashCode10 = (((iHashCode9 + (set != null ? set.hashCode() : 0)) * 31) + this.memberCount) * 31;
        String str5 = this.banner;
        int iHashCode11 = (iHashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.splash;
        int iHashCode12 = (((((((iHashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.premiumTier) * 31) + this.premiumSubscriptionCount) * 31) + this.systemChannelFlags) * 31;
        String str7 = this.joinedAt;
        int iHashCode13 = (iHashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Long l3 = this.rulesChannelId;
        int iHashCode14 = (iHashCode13 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Long l4 = this.publicUpdatesChannelId;
        int iHashCode15 = (iHashCode14 + (l4 != null ? l4.hashCode() : 0)) * 31;
        String str8 = this.preferredLocale;
        int iHashCode16 = (iHashCode15 + (str8 != null ? str8.hashCode() : 0)) * 31;
        GuildWelcomeScreen guildWelcomeScreen = this.welcomeScreen;
        int iHashCode17 = (iHashCode16 + (guildWelcomeScreen != null ? guildWelcomeScreen.hashCode() : 0)) * 31;
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = this.maxVideoChannelUsers;
        int iHashCode18 = (iHashCode17 + (guildMaxVideoChannelUsers != null ? guildMaxVideoChannelUsers.hashCode() : 0)) * 31;
        String str9 = this.vanityUrlCode;
        int iHashCode19 = (((iHashCode18 + (str9 != null ? str9.hashCode() : 0)) * 31) + this.approximatePresenceCount) * 31;
        boolean z3 = this.nsfw;
        int i3 = (iHashCode19 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        GuildHubType guildHubType = this.hubType;
        return i3 + (guildHubType != null ? guildHubType.hashCode() : 0);
    }

    public final boolean isHub() {
        return hasFeature(GuildFeature.HUB);
    }

    public final boolean isOwner(long userId) {
        return this.ownerId == userId;
    }

    public final Guild merge(com.discord.api.guild.Guild apiGuild) {
        m.checkNotNullParameter(apiGuild, "apiGuild");
        List listEmptyList = n.emptyList();
        List<GuildEmoji> listK = apiGuild.k();
        if (listK == null) {
            listK = n.emptyList();
        }
        String name = apiGuild.getName();
        String description = apiGuild.getDescription();
        if (description == null) {
            description = this.description;
        }
        Integer defaultMessageNotifications = apiGuild.getDefaultMessageNotifications();
        int iIntValue = defaultMessageNotifications != null ? defaultMessageNotifications.intValue() : this.defaultMessageNotifications;
        long id2 = apiGuild.getId() != 0 ? apiGuild.getId() : this.id;
        String region = apiGuild.getRegion();
        if (region == null) {
            region = this.region;
        }
        long ownerId = apiGuild.getOwnerId() != 0 ? apiGuild.getOwnerId() : this.ownerId;
        String icon = apiGuild.getIcon();
        if (icon == null) {
            icon = this.icon;
        }
        String str = icon;
        GuildVerificationLevel verificationLevel = apiGuild.getVerificationLevel();
        if (verificationLevel == null) {
            verificationLevel = this.verificationLevel;
        }
        GuildVerificationLevel guildVerificationLevel = verificationLevel;
        GuildExplicitContentFilter explicitContentFilter = apiGuild.getExplicitContentFilter();
        if (explicitContentFilter == null) {
            explicitContentFilter = this.explicitContentFilter;
        }
        GuildExplicitContentFilter guildExplicitContentFilter = explicitContentFilter;
        boolean unavailable = apiGuild.getUnavailable();
        int mfaLevel = apiGuild.getMfaLevel();
        int afkTimeout = apiGuild.getAfkTimeout() != 0 ? apiGuild.getAfkTimeout() : this.afkTimeout;
        Long afkChannelId = apiGuild.getAfkChannelId();
        Long systemChannelId = apiGuild.getSystemChannelId();
        Set set = u.toSet(apiGuild.m());
        String banner = apiGuild.getBanner();
        String splash = apiGuild.getSplash();
        if (splash == null) {
            splash = this.splash;
        }
        String str2 = splash;
        int premiumTier = apiGuild.getPremiumTier();
        int premiumSubscriptionCount = apiGuild.getPremiumSubscriptionCount();
        int systemChannelFlags = apiGuild.getSystemChannelFlags();
        String joinedAt = apiGuild.getJoinedAt();
        if (joinedAt == null) {
            joinedAt = this.joinedAt;
        }
        String str3 = joinedAt;
        Long rulesChannelId = apiGuild.getRulesChannelId();
        if (rulesChannelId == null) {
            rulesChannelId = this.rulesChannelId;
        }
        Long l = rulesChannelId;
        Long publicUpdatesChannelId = apiGuild.getPublicUpdatesChannelId();
        if (publicUpdatesChannelId == null) {
            publicUpdatesChannelId = this.publicUpdatesChannelId;
        }
        Long l2 = publicUpdatesChannelId;
        String preferredLocale = apiGuild.getPreferredLocale();
        if (preferredLocale == null) {
            preferredLocale = this.preferredLocale;
        }
        String str4 = preferredLocale;
        GuildWelcomeScreen welcomeScreen = apiGuild.getWelcomeScreen();
        if (welcomeScreen == null) {
            welcomeScreen = this.welcomeScreen;
        }
        GuildWelcomeScreen guildWelcomeScreen = welcomeScreen;
        GuildMaxVideoChannelUsers maxVideoChannelUsers = apiGuild.getMaxVideoChannelUsers();
        if (maxVideoChannelUsers == null) {
            maxVideoChannelUsers = this.maxVideoChannelUsers;
        }
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers = maxVideoChannelUsers;
        String vanityUrlCode = apiGuild.getVanityUrlCode();
        if (vanityUrlCode == null) {
            vanityUrlCode = this.vanityUrlCode;
        }
        return new Guild(listEmptyList, listK, null, name, description, iIntValue, id2, region, ownerId, str, guildVerificationLevel, guildExplicitContentFilter, unavailable, mfaLevel, afkTimeout, afkChannelId, systemChannelId, set, 0, banner, str2, premiumTier, premiumSubscriptionCount, systemChannelFlags, str3, l, l2, str4, guildWelcomeScreen, guildMaxVideoChannelUsers, vanityUrlCode, apiGuild.getApproximatePresenceCount() != 0 ? apiGuild.getApproximatePresenceCount() : this.approximatePresenceCount, apiGuild.getNsfw(), apiGuild.getHubType(), 4, 0, null);
    }

    public String toString() {
        StringBuilder sbU = a.U("Guild(roles=");
        sbU.append(this.roles);
        sbU.append(", emojis=");
        sbU.append(this.emojis);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", defaultMessageNotifications=");
        sbU.append(this.defaultMessageNotifications);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", region=");
        sbU.append(this.region);
        sbU.append(", ownerId=");
        sbU.append(this.ownerId);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", verificationLevel=");
        sbU.append(this.verificationLevel);
        sbU.append(", explicitContentFilter=");
        sbU.append(this.explicitContentFilter);
        sbU.append(", unavailable=");
        sbU.append(this.unavailable);
        sbU.append(", mfaLevel=");
        sbU.append(this.mfaLevel);
        sbU.append(", afkTimeout=");
        sbU.append(this.afkTimeout);
        sbU.append(", afkChannelId=");
        sbU.append(this.afkChannelId);
        sbU.append(", systemChannelId=");
        sbU.append(this.systemChannelId);
        sbU.append(", features=");
        sbU.append(this.features);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", splash=");
        sbU.append(this.splash);
        sbU.append(", premiumTier=");
        sbU.append(this.premiumTier);
        sbU.append(", premiumSubscriptionCount=");
        sbU.append(this.premiumSubscriptionCount);
        sbU.append(", systemChannelFlags=");
        sbU.append(this.systemChannelFlags);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", rulesChannelId=");
        sbU.append(this.rulesChannelId);
        sbU.append(", publicUpdatesChannelId=");
        sbU.append(this.publicUpdatesChannelId);
        sbU.append(", preferredLocale=");
        sbU.append(this.preferredLocale);
        sbU.append(", welcomeScreen=");
        sbU.append(this.welcomeScreen);
        sbU.append(", maxVideoChannelUsers=");
        sbU.append(this.maxVideoChannelUsers);
        sbU.append(", vanityUrlCode=");
        sbU.append(this.vanityUrlCode);
        sbU.append(", approximatePresenceCount=");
        sbU.append(this.approximatePresenceCount);
        sbU.append(", nsfw=");
        sbU.append(this.nsfw);
        sbU.append(", hubType=");
        sbU.append(this.hubType);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ Guild(List list, List list2, List list3, String str, String str2, int i, long j, String str3, long j2, String str4, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, boolean z2, int i2, int i3, Long l, Long l2, Set set, int i4, String str5, String str6, int i5, int i6, int i7, String str7, Long l3, Long l4, String str8, GuildWelcomeScreen guildWelcomeScreen, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, String str9, int i8, boolean z3, GuildHubType guildHubType, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? n.emptyList() : list, (i9 & 2) != 0 ? n.emptyList() : list2, (i9 & 4) != 0 ? n.emptyList() : list3, (i9 & 8) != 0 ? "" : str, (i9 & 16) != 0 ? null : str2, (i9 & 32) != 0 ? ModelNotificationSettings.FREQUENCY_ALL : i, (i9 & 64) != 0 ? 0L : j, (i9 & 128) != 0 ? null : str3, (i9 & 256) == 0 ? j2 : 0L, (i9 & 512) != 0 ? null : str4, (i9 & 1024) != 0 ? GuildVerificationLevel.NONE : guildVerificationLevel, (i9 & 2048) != 0 ? GuildExplicitContentFilter.NONE : guildExplicitContentFilter, (i9 & 4096) != 0 ? false : z2, (i9 & 8192) != 0 ? 0 : i2, (i9 & 16384) != 0 ? 0 : i3, (i9 & 32768) != 0 ? null : l, (i9 & 65536) != 0 ? null : l2, (i9 & 131072) != 0 ? n0.emptySet() : set, (i9 & 262144) != 0 ? 0 : i4, (i9 & 524288) != 0 ? null : str5, (i9 & 1048576) != 0 ? null : str6, (i9 & 2097152) != 0 ? 0 : i5, (i9 & 4194304) != 0 ? 0 : i6, (i9 & 8388608) != 0 ? 0 : i7, (i9 & 16777216) != 0 ? null : str7, (i9 & 33554432) != 0 ? null : l3, (i9 & 67108864) != 0 ? null : l4, (i9 & 134217728) != 0 ? null : str8, (i9 & 268435456) != 0 ? null : guildWelcomeScreen, (i9 & 536870912) != 0 ? GuildMaxVideoChannelUsers.Unlimited.INSTANCE : guildMaxVideoChannelUsers, (i9 & BasicMeasure.EXACTLY) != 0 ? null : str9, (i9 & Integer.MIN_VALUE) != 0 ? 0 : i8, (i10 & 1) == 0 ? z3 : false, (i10 & 2) != 0 ? null : guildHubType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Guild(com.discord.api.guild.Guild guild) {
        m.checkNotNullParameter(guild, "apiGuild");
        List<GuildRole> listG = guild.G();
        List<GuildRole> listEmptyList = listG == null ? n.emptyList() : listG;
        List<GuildEmoji> listK = guild.k();
        List<GuildEmoji> listEmptyList2 = listK == null ? n.emptyList() : listK;
        String name = guild.getName();
        String description = guild.getDescription();
        Integer defaultMessageNotifications = guild.getDefaultMessageNotifications();
        int iIntValue = defaultMessageNotifications != null ? defaultMessageNotifications.intValue() : ModelNotificationSettings.FREQUENCY_ALL;
        long id2 = guild.getId();
        String region = guild.getRegion();
        long ownerId = guild.getOwnerId();
        String icon = guild.getIcon();
        GuildVerificationLevel verificationLevel = guild.getVerificationLevel();
        GuildVerificationLevel guildVerificationLevel = verificationLevel == null ? GuildVerificationLevel.NONE : verificationLevel;
        GuildExplicitContentFilter explicitContentFilter = guild.getExplicitContentFilter();
        GuildExplicitContentFilter guildExplicitContentFilter = explicitContentFilter == null ? GuildExplicitContentFilter.NONE : explicitContentFilter;
        boolean unavailable = guild.getUnavailable();
        int mfaLevel = guild.getMfaLevel();
        int afkTimeout = guild.getAfkTimeout();
        Long afkChannelId = guild.getAfkChannelId();
        Long systemChannelId = guild.getSystemChannelId();
        Set set = u.toSet(guild.m());
        int memberCount = guild.getMemberCount();
        String banner = guild.getBanner();
        String splash = guild.getSplash();
        int premiumTier = guild.getPremiumTier();
        int premiumSubscriptionCount = guild.getPremiumSubscriptionCount();
        int systemChannelFlags = guild.getSystemChannelFlags();
        String joinedAt = guild.getJoinedAt();
        Long rulesChannelId = guild.getRulesChannelId();
        Long publicUpdatesChannelId = guild.getPublicUpdatesChannelId();
        String preferredLocale = guild.getPreferredLocale();
        GuildWelcomeScreen welcomeScreen = guild.getWelcomeScreen();
        GuildMaxVideoChannelUsers maxVideoChannelUsers = guild.getMaxVideoChannelUsers();
        this(listEmptyList, listEmptyList2, null, name, description, iIntValue, id2, region, ownerId, icon, guildVerificationLevel, guildExplicitContentFilter, unavailable, mfaLevel, afkTimeout, afkChannelId, systemChannelId, set, memberCount, banner, splash, premiumTier, premiumSubscriptionCount, systemChannelFlags, joinedAt, rulesChannelId, publicUpdatesChannelId, preferredLocale, welcomeScreen, maxVideoChannelUsers == null ? GuildMaxVideoChannelUsers.Unlimited.INSTANCE : maxVideoChannelUsers, guild.getVanityUrlCode(), guild.getApproximatePresenceCount(), guild.getNsfw(), guild.getHubType(), 4, 0, null);
    }
}
