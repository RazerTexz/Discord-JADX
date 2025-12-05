package com.discord.models.guild;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
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
import com.discord.utilities.guilds.GuildUtils;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

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
        Intrinsics3.checkNotNullParameter(list, "roles");
        Intrinsics3.checkNotNullParameter(list2, "emojis");
        Intrinsics3.checkNotNullParameter(list3, "stickers");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(guildVerificationLevel, "verificationLevel");
        Intrinsics3.checkNotNullParameter(guildExplicitContentFilter, "explicitContentFilter");
        Intrinsics3.checkNotNullParameter(set, "features");
        Intrinsics3.checkNotNullParameter(guildMaxVideoChannelUsers, "maxVideoChannelUsers");
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
        this.shortName = GuildUtils.computeShortName(str);
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
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(emojis, "emojis");
        Intrinsics3.checkNotNullParameter(stickers, "stickers");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(verificationLevel, "verificationLevel");
        Intrinsics3.checkNotNullParameter(explicitContentFilter, "explicitContentFilter");
        Intrinsics3.checkNotNullParameter(features, "features");
        Intrinsics3.checkNotNullParameter(maxVideoChannelUsers, "maxVideoChannelUsers");
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
        return Intrinsics3.areEqual(this.roles, guild.roles) && Intrinsics3.areEqual(this.emojis, guild.emojis) && Intrinsics3.areEqual(this.stickers, guild.stickers) && Intrinsics3.areEqual(this.name, guild.name) && Intrinsics3.areEqual(this.description, guild.description) && this.defaultMessageNotifications == guild.defaultMessageNotifications && this.id == guild.id && Intrinsics3.areEqual(this.region, guild.region) && this.ownerId == guild.ownerId && Intrinsics3.areEqual(this.icon, guild.icon) && Intrinsics3.areEqual(this.verificationLevel, guild.verificationLevel) && Intrinsics3.areEqual(this.explicitContentFilter, guild.explicitContentFilter) && this.unavailable == guild.unavailable && this.mfaLevel == guild.mfaLevel && this.afkTimeout == guild.afkTimeout && Intrinsics3.areEqual(this.afkChannelId, guild.afkChannelId) && Intrinsics3.areEqual(this.systemChannelId, guild.systemChannelId) && Intrinsics3.areEqual(this.features, guild.features) && this.memberCount == guild.memberCount && Intrinsics3.areEqual(this.banner, guild.banner) && Intrinsics3.areEqual(this.splash, guild.splash) && this.premiumTier == guild.premiumTier && this.premiumSubscriptionCount == guild.premiumSubscriptionCount && this.systemChannelFlags == guild.systemChannelFlags && Intrinsics3.areEqual(this.joinedAt, guild.joinedAt) && Intrinsics3.areEqual(this.rulesChannelId, guild.rulesChannelId) && Intrinsics3.areEqual(this.publicUpdatesChannelId, guild.publicUpdatesChannelId) && Intrinsics3.areEqual(this.preferredLocale, guild.preferredLocale) && Intrinsics3.areEqual(this.welcomeScreen, guild.welcomeScreen) && Intrinsics3.areEqual(this.maxVideoChannelUsers, guild.maxVideoChannelUsers) && Intrinsics3.areEqual(this.vanityUrlCode, guild.vanityUrlCode) && this.approximatePresenceCount == guild.approximatePresenceCount && this.nsfw == guild.nsfw && Intrinsics3.areEqual(this.hubType, guild.hubType);
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
        Intrinsics3.checkNotNullParameter(feature, "feature");
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
        int iM3a = (C0002b.m3a(this.id) + ((((iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.defaultMessageNotifications) * 31)) * 31;
        String str3 = this.region;
        int iM3a2 = (C0002b.m3a(this.ownerId) + ((iM3a + (str3 != null ? str3.hashCode() : 0)) * 31)) * 31;
        String str4 = this.icon;
        int iHashCode5 = (iM3a2 + (str4 != null ? str4.hashCode() : 0)) * 31;
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
        Intrinsics3.checkNotNullParameter(apiGuild, "apiGuild");
        List listEmptyList = Collections2.emptyList();
        List<GuildEmoji> listM7864k = apiGuild.m7864k();
        if (listM7864k == null) {
            listM7864k = Collections2.emptyList();
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
        Set set = _Collections.toSet(apiGuild.m7866m());
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
        return new Guild(listEmptyList, listM7864k, null, name, description, iIntValue, id2, region, ownerId, str, guildVerificationLevel, guildExplicitContentFilter, unavailable, mfaLevel, afkTimeout, afkChannelId, systemChannelId, set, 0, banner, str2, premiumTier, premiumSubscriptionCount, systemChannelFlags, str3, l, l2, str4, guildWelcomeScreen, guildMaxVideoChannelUsers, vanityUrlCode, apiGuild.getApproximatePresenceCount() != 0 ? apiGuild.getApproximatePresenceCount() : this.approximatePresenceCount, apiGuild.getNsfw(), apiGuild.getHubType(), 4, 0, null);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Guild(roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", emojis=");
        sbM833U.append(this.emojis);
        sbM833U.append(", stickers=");
        sbM833U.append(this.stickers);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", defaultMessageNotifications=");
        sbM833U.append(this.defaultMessageNotifications);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", region=");
        sbM833U.append(this.region);
        sbM833U.append(", ownerId=");
        sbM833U.append(this.ownerId);
        sbM833U.append(", icon=");
        sbM833U.append(this.icon);
        sbM833U.append(", verificationLevel=");
        sbM833U.append(this.verificationLevel);
        sbM833U.append(", explicitContentFilter=");
        sbM833U.append(this.explicitContentFilter);
        sbM833U.append(", unavailable=");
        sbM833U.append(this.unavailable);
        sbM833U.append(", mfaLevel=");
        sbM833U.append(this.mfaLevel);
        sbM833U.append(", afkTimeout=");
        sbM833U.append(this.afkTimeout);
        sbM833U.append(", afkChannelId=");
        sbM833U.append(this.afkChannelId);
        sbM833U.append(", systemChannelId=");
        sbM833U.append(this.systemChannelId);
        sbM833U.append(", features=");
        sbM833U.append(this.features);
        sbM833U.append(", memberCount=");
        sbM833U.append(this.memberCount);
        sbM833U.append(", banner=");
        sbM833U.append(this.banner);
        sbM833U.append(", splash=");
        sbM833U.append(this.splash);
        sbM833U.append(", premiumTier=");
        sbM833U.append(this.premiumTier);
        sbM833U.append(", premiumSubscriptionCount=");
        sbM833U.append(this.premiumSubscriptionCount);
        sbM833U.append(", systemChannelFlags=");
        sbM833U.append(this.systemChannelFlags);
        sbM833U.append(", joinedAt=");
        sbM833U.append(this.joinedAt);
        sbM833U.append(", rulesChannelId=");
        sbM833U.append(this.rulesChannelId);
        sbM833U.append(", publicUpdatesChannelId=");
        sbM833U.append(this.publicUpdatesChannelId);
        sbM833U.append(", preferredLocale=");
        sbM833U.append(this.preferredLocale);
        sbM833U.append(", welcomeScreen=");
        sbM833U.append(this.welcomeScreen);
        sbM833U.append(", maxVideoChannelUsers=");
        sbM833U.append(this.maxVideoChannelUsers);
        sbM833U.append(", vanityUrlCode=");
        sbM833U.append(this.vanityUrlCode);
        sbM833U.append(", approximatePresenceCount=");
        sbM833U.append(this.approximatePresenceCount);
        sbM833U.append(", nsfw=");
        sbM833U.append(this.nsfw);
        sbM833U.append(", hubType=");
        sbM833U.append(this.hubType);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public /* synthetic */ Guild(List list, List list2, List list3, String str, String str2, int i, long j, String str3, long j2, String str4, GuildVerificationLevel guildVerificationLevel, GuildExplicitContentFilter guildExplicitContentFilter, boolean z2, int i2, int i3, Long l, Long l2, Set set, int i4, String str5, String str6, int i5, int i6, int i7, String str7, Long l3, Long l4, String str8, GuildWelcomeScreen guildWelcomeScreen, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, String str9, int i8, boolean z3, GuildHubType guildHubType, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i9 & 1) != 0 ? Collections2.emptyList() : list, (i9 & 2) != 0 ? Collections2.emptyList() : list2, (i9 & 4) != 0 ? Collections2.emptyList() : list3, (i9 & 8) != 0 ? "" : str, (i9 & 16) != 0 ? null : str2, (i9 & 32) != 0 ? ModelNotificationSettings.FREQUENCY_ALL : i, (i9 & 64) != 0 ? 0L : j, (i9 & 128) != 0 ? null : str3, (i9 & 256) == 0 ? j2 : 0L, (i9 & 512) != 0 ? null : str4, (i9 & 1024) != 0 ? GuildVerificationLevel.NONE : guildVerificationLevel, (i9 & 2048) != 0 ? GuildExplicitContentFilter.NONE : guildExplicitContentFilter, (i9 & 4096) != 0 ? false : z2, (i9 & 8192) != 0 ? 0 : i2, (i9 & 16384) != 0 ? 0 : i3, (i9 & 32768) != 0 ? null : l, (i9 & 65536) != 0 ? null : l2, (i9 & 131072) != 0 ? Sets5.emptySet() : set, (i9 & 262144) != 0 ? 0 : i4, (i9 & 524288) != 0 ? null : str5, (i9 & 1048576) != 0 ? null : str6, (i9 & 2097152) != 0 ? 0 : i5, (i9 & 4194304) != 0 ? 0 : i6, (i9 & 8388608) != 0 ? 0 : i7, (i9 & 16777216) != 0 ? null : str7, (i9 & 33554432) != 0 ? null : l3, (i9 & 67108864) != 0 ? null : l4, (i9 & 134217728) != 0 ? null : str8, (i9 & 268435456) != 0 ? null : guildWelcomeScreen, (i9 & 536870912) != 0 ? GuildMaxVideoChannelUsers.Unlimited.INSTANCE : guildMaxVideoChannelUsers, (i9 & BasicMeasure.EXACTLY) != 0 ? null : str9, (i9 & Integer.MIN_VALUE) != 0 ? 0 : i8, (i10 & 1) == 0 ? z3 : false, (i10 & 2) != 0 ? null : guildHubType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Guild(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "apiGuild");
        List<GuildRole> listM7842G = guild.m7842G();
        List<GuildRole> listEmptyList = listM7842G == null ? Collections2.emptyList() : listM7842G;
        List<GuildEmoji> listM7864k = guild.m7864k();
        List<GuildEmoji> listEmptyList2 = listM7864k == null ? Collections2.emptyList() : listM7864k;
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
        Set set = _Collections.toSet(guild.m7866m());
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
