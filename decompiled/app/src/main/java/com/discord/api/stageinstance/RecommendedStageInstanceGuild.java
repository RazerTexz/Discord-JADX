package com.discord.api.stageinstance;

import b.d.b.a.outline;
import com.discord.api.guild.GuildFeature;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* compiled from: RecommendedStageInstanceGuild.kt */
/* loaded from: classes.dex */
public final /* data */ class RecommendedStageInstanceGuild {
    private final Set<GuildFeature> features;
    private final String icon;
    private final long id;
    private final String name;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecommendedStageInstanceGuild)) {
            return false;
        }
        RecommendedStageInstanceGuild recommendedStageInstanceGuild = (RecommendedStageInstanceGuild) other;
        return this.id == recommendedStageInstanceGuild.id && Intrinsics3.areEqual(this.name, recommendedStageInstanceGuild.name) && Intrinsics3.areEqual(this.icon, recommendedStageInstanceGuild.icon) && Intrinsics3.areEqual(this.features, recommendedStageInstanceGuild.features);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.icon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Set<GuildFeature> set = this.features;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("RecommendedStageInstanceGuild(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", features=");
        return outline.N(sbU, this.features, ")");
    }
}
