package com.discord.api.guild.preview;

import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildFeature;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildPreview.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildPreview {
    private final Integer approximateMemberCount;
    private final Integer approximatePresenceCount;
    private final String banner;
    private final String description;
    private final List<GuildEmoji> emojis;
    private final Boolean featurableInDirectory;
    private final List<GuildFeature> features;
    private final String icon;
    private final long id;
    private final String name;
    private final String splash;

    /* renamed from: a, reason: from getter */
    public final Integer getApproximateMemberCount() {
        return this.approximateMemberCount;
    }

    /* renamed from: b, reason: from getter */
    public final Integer getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d */
    public final List<GuildEmoji> m7887d() {
        return this.emojis;
    }

    /* renamed from: e, reason: from getter */
    public final Boolean getFeaturableInDirectory() {
        return this.featurableInDirectory;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildPreview)) {
            return false;
        }
        GuildPreview guildPreview = (GuildPreview) other;
        return this.id == guildPreview.id && Intrinsics3.areEqual(this.name, guildPreview.name) && Intrinsics3.areEqual(this.description, guildPreview.description) && Intrinsics3.areEqual(this.splash, guildPreview.splash) && Intrinsics3.areEqual(this.banner, guildPreview.banner) && Intrinsics3.areEqual(this.icon, guildPreview.icon) && Intrinsics3.areEqual(this.approximatePresenceCount, guildPreview.approximatePresenceCount) && Intrinsics3.areEqual(this.approximateMemberCount, guildPreview.approximateMemberCount) && Intrinsics3.areEqual(this.emojis, guildPreview.emojis) && Intrinsics3.areEqual(this.features, guildPreview.features) && Intrinsics3.areEqual(this.featurableInDirectory, guildPreview.featurableInDirectory);
    }

    /* renamed from: f */
    public final List<GuildFeature> m7889f() {
        return this.features;
    }

    /* renamed from: g, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: h, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.splash;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.banner;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.icon;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.approximatePresenceCount;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.approximateMemberCount;
        int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<GuildEmoji> list = this.emojis;
        int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildFeature> list2 = this.features;
        int iHashCode9 = (iHashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Boolean bool = this.featurableInDirectory;
        return iHashCode9 + (bool != null ? bool.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: j, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildPreview(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", splash=");
        sbM833U.append(this.splash);
        sbM833U.append(", banner=");
        sbM833U.append(this.banner);
        sbM833U.append(", icon=");
        sbM833U.append(this.icon);
        sbM833U.append(", approximatePresenceCount=");
        sbM833U.append(this.approximatePresenceCount);
        sbM833U.append(", approximateMemberCount=");
        sbM833U.append(this.approximateMemberCount);
        sbM833U.append(", emojis=");
        sbM833U.append(this.emojis);
        sbM833U.append(", features=");
        sbM833U.append(this.features);
        sbM833U.append(", featurableInDirectory=");
        return outline.m816D(sbM833U, this.featurableInDirectory, ")");
    }
}
