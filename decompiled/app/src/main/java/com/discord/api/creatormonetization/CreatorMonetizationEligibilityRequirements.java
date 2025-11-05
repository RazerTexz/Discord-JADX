package com.discord.api.creatormonetization;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/* compiled from: CreatorMonetizationEligibilityRequirements.kt */
/* loaded from: classes.dex */
public final /* data */ class CreatorMonetizationEligibilityRequirements {
    private final boolean age;
    private final boolean canApply;
    private final boolean engagementHealthy;
    private final long guildId;
    private final HealthScore healthScore;
    private final boolean healthScorePending;
    private final CreatorMonetizationEnableRequest latestRequest;
    private final int minimumAgeInDays;
    private final int minimumSize;
    private final Map<String, Object> nsfwProperties;
    private final Rejection rejection;
    private final boolean retentionHealthy;
    private final boolean safeEnvironment;
    private final boolean size;
    private final boolean sufficient;

    /* compiled from: CreatorMonetizationEligibilityRequirements.kt */
    public static final /* data */ class HealthScore {
        private final Integer avgNonnewCommunicators;
        private final Integer avgNonnewParticipators;
        private final Integer communicators;
        private final Integer guildSize;
        private final Integer numIntentfulJoiners;
        private final Double percRetW1;
        private final Double percRetW1Intentful;

        /* renamed from: a, reason: from getter */
        public final Integer getCommunicators() {
            return this.communicators;
        }

        /* renamed from: b, reason: from getter */
        public final Integer getGuildSize() {
            return this.guildSize;
        }

        /* renamed from: c, reason: from getter */
        public final Double getPercRetW1() {
            return this.percRetW1;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HealthScore)) {
                return false;
            }
            HealthScore healthScore = (HealthScore) other;
            return m.areEqual(this.avgNonnewParticipators, healthScore.avgNonnewParticipators) && m.areEqual(this.avgNonnewCommunicators, healthScore.avgNonnewCommunicators) && m.areEqual(this.numIntentfulJoiners, healthScore.numIntentfulJoiners) && m.areEqual(this.percRetW1Intentful, healthScore.percRetW1Intentful) && m.areEqual(this.guildSize, healthScore.guildSize) && m.areEqual(this.communicators, healthScore.communicators) && m.areEqual(this.percRetW1, healthScore.percRetW1);
        }

        public int hashCode() {
            Integer num = this.avgNonnewParticipators;
            int iHashCode = (num != null ? num.hashCode() : 0) * 31;
            Integer num2 = this.avgNonnewCommunicators;
            int iHashCode2 = (iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.numIntentfulJoiners;
            int iHashCode3 = (iHashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
            Double d = this.percRetW1Intentful;
            int iHashCode4 = (iHashCode3 + (d != null ? d.hashCode() : 0)) * 31;
            Integer num4 = this.guildSize;
            int iHashCode5 = (iHashCode4 + (num4 != null ? num4.hashCode() : 0)) * 31;
            Integer num5 = this.communicators;
            int iHashCode6 = (iHashCode5 + (num5 != null ? num5.hashCode() : 0)) * 31;
            Double d2 = this.percRetW1;
            return iHashCode6 + (d2 != null ? d2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("HealthScore(avgNonnewParticipators=");
            sbU.append(this.avgNonnewParticipators);
            sbU.append(", avgNonnewCommunicators=");
            sbU.append(this.avgNonnewCommunicators);
            sbU.append(", numIntentfulJoiners=");
            sbU.append(this.numIntentfulJoiners);
            sbU.append(", percRetW1Intentful=");
            sbU.append(this.percRetW1Intentful);
            sbU.append(", guildSize=");
            sbU.append(this.guildSize);
            sbU.append(", communicators=");
            sbU.append(this.communicators);
            sbU.append(", percRetW1=");
            sbU.append(this.percRetW1);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: CreatorMonetizationEligibilityRequirements.kt */
    public static final /* data */ class Rejection {
        private final Date canReapplyAt;

        /* renamed from: a, reason: from getter */
        public final Date getCanReapplyAt() {
            return this.canReapplyAt;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Rejection) && m.areEqual(this.canReapplyAt, ((Rejection) other).canReapplyAt);
            }
            return true;
        }

        public int hashCode() {
            Date date = this.canReapplyAt;
            if (date != null) {
                return date.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("Rejection(canReapplyAt=");
            sbU.append(this.canReapplyAt);
            sbU.append(")");
            return sbU.toString();
        }
    }

    public CreatorMonetizationEligibilityRequirements(long j, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z2, boolean z3, boolean z4, boolean z5, Map<String, ? extends Object> map, boolean z6, boolean z7, boolean z8, HealthScore healthScore, boolean z9, Rejection rejection, int i, int i2) {
        m.checkNotNullParameter(map, "nsfwProperties");
        this.guildId = j;
        this.latestRequest = creatorMonetizationEnableRequest;
        this.canApply = z2;
        this.sufficient = z3;
        this.age = z4;
        this.engagementHealthy = z5;
        this.nsfwProperties = map;
        this.retentionHealthy = z6;
        this.safeEnvironment = z7;
        this.size = z8;
        this.healthScore = healthScore;
        this.healthScorePending = z9;
        this.rejection = rejection;
        this.minimumAgeInDays = i;
        this.minimumSize = i2;
    }

    public static CreatorMonetizationEligibilityRequirements a(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, long j, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z2, boolean z3, boolean z4, boolean z5, Map map, boolean z6, boolean z7, boolean z8, HealthScore healthScore, boolean z9, Rejection rejection, int i, int i2, int i3) {
        long j2 = (i3 & 1) != 0 ? creatorMonetizationEligibilityRequirements.guildId : j;
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest2 = (i3 & 2) != 0 ? creatorMonetizationEligibilityRequirements.latestRequest : creatorMonetizationEnableRequest;
        boolean z10 = (i3 & 4) != 0 ? creatorMonetizationEligibilityRequirements.canApply : z2;
        boolean z11 = (i3 & 8) != 0 ? creatorMonetizationEligibilityRequirements.sufficient : z3;
        boolean z12 = (i3 & 16) != 0 ? creatorMonetizationEligibilityRequirements.age : z4;
        boolean z13 = (i3 & 32) != 0 ? creatorMonetizationEligibilityRequirements.engagementHealthy : z5;
        Map<String, Object> map2 = (i3 & 64) != 0 ? creatorMonetizationEligibilityRequirements.nsfwProperties : null;
        boolean z14 = (i3 & 128) != 0 ? creatorMonetizationEligibilityRequirements.retentionHealthy : z6;
        boolean z15 = (i3 & 256) != 0 ? creatorMonetizationEligibilityRequirements.safeEnvironment : z7;
        boolean z16 = (i3 & 512) != 0 ? creatorMonetizationEligibilityRequirements.size : z8;
        HealthScore healthScore2 = (i3 & 1024) != 0 ? creatorMonetizationEligibilityRequirements.healthScore : null;
        boolean z17 = (i3 & 2048) != 0 ? creatorMonetizationEligibilityRequirements.healthScorePending : z9;
        Rejection rejection2 = (i3 & 4096) != 0 ? creatorMonetizationEligibilityRequirements.rejection : null;
        int i4 = (i3 & 8192) != 0 ? creatorMonetizationEligibilityRequirements.minimumAgeInDays : i;
        int i5 = (i3 & 16384) != 0 ? creatorMonetizationEligibilityRequirements.minimumSize : i2;
        Objects.requireNonNull(creatorMonetizationEligibilityRequirements);
        m.checkNotNullParameter(map2, "nsfwProperties");
        return new CreatorMonetizationEligibilityRequirements(j2, creatorMonetizationEnableRequest2, z10, z11, z12, z13, map2, z14, z15, z16, healthScore2, z17, rejection2, i4, i5);
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAge() {
        return this.age;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getCanApply() {
        return this.canApply;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEngagementHealthy() {
        return this.engagementHealthy;
    }

    /* renamed from: e, reason: from getter */
    public final HealthScore getHealthScore() {
        return this.healthScore;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatorMonetizationEligibilityRequirements)) {
            return false;
        }
        CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements = (CreatorMonetizationEligibilityRequirements) other;
        return this.guildId == creatorMonetizationEligibilityRequirements.guildId && m.areEqual(this.latestRequest, creatorMonetizationEligibilityRequirements.latestRequest) && this.canApply == creatorMonetizationEligibilityRequirements.canApply && this.sufficient == creatorMonetizationEligibilityRequirements.sufficient && this.age == creatorMonetizationEligibilityRequirements.age && this.engagementHealthy == creatorMonetizationEligibilityRequirements.engagementHealthy && m.areEqual(this.nsfwProperties, creatorMonetizationEligibilityRequirements.nsfwProperties) && this.retentionHealthy == creatorMonetizationEligibilityRequirements.retentionHealthy && this.safeEnvironment == creatorMonetizationEligibilityRequirements.safeEnvironment && this.size == creatorMonetizationEligibilityRequirements.size && m.areEqual(this.healthScore, creatorMonetizationEligibilityRequirements.healthScore) && this.healthScorePending == creatorMonetizationEligibilityRequirements.healthScorePending && m.areEqual(this.rejection, creatorMonetizationEligibilityRequirements.rejection) && this.minimumAgeInDays == creatorMonetizationEligibilityRequirements.minimumAgeInDays && this.minimumSize == creatorMonetizationEligibilityRequirements.minimumSize;
    }

    /* renamed from: f, reason: from getter */
    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    /* renamed from: g, reason: from getter */
    public final int getMinimumAgeInDays() {
        return this.minimumAgeInDays;
    }

    /* renamed from: h, reason: from getter */
    public final int getMinimumSize() {
        return this.minimumSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = this.latestRequest;
        int iHashCode = (i + (creatorMonetizationEnableRequest != null ? creatorMonetizationEnableRequest.hashCode() : 0)) * 31;
        boolean z2 = this.canApply;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        boolean z3 = this.sufficient;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z4 = this.age;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        boolean z5 = this.engagementHealthy;
        int i8 = z5;
        if (z5 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        Map<String, Object> map = this.nsfwProperties;
        int iHashCode2 = (i9 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z6 = this.retentionHealthy;
        int i10 = z6;
        if (z6 != 0) {
            i10 = 1;
        }
        int i11 = (iHashCode2 + i10) * 31;
        boolean z7 = this.safeEnvironment;
        int i12 = z7;
        if (z7 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z8 = this.size;
        int i14 = z8;
        if (z8 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        HealthScore healthScore = this.healthScore;
        int iHashCode3 = (i15 + (healthScore != null ? healthScore.hashCode() : 0)) * 31;
        boolean z9 = this.healthScorePending;
        int i16 = (iHashCode3 + (z9 ? 1 : z9 ? 1 : 0)) * 31;
        Rejection rejection = this.rejection;
        return ((((i16 + (rejection != null ? rejection.hashCode() : 0)) * 31) + this.minimumAgeInDays) * 31) + this.minimumSize;
    }

    public final Map<String, Object> i() {
        return this.nsfwProperties;
    }

    /* renamed from: j, reason: from getter */
    public final Rejection getRejection() {
        return this.rejection;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getRetentionHealthy() {
        return this.retentionHealthy;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getSafeEnvironment() {
        return this.safeEnvironment;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getSize() {
        return this.size;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getSufficient() {
        return this.sufficient;
    }

    public String toString() {
        StringBuilder sbU = a.U("CreatorMonetizationEligibilityRequirements(guildId=");
        sbU.append(this.guildId);
        sbU.append(", latestRequest=");
        sbU.append(this.latestRequest);
        sbU.append(", canApply=");
        sbU.append(this.canApply);
        sbU.append(", sufficient=");
        sbU.append(this.sufficient);
        sbU.append(", age=");
        sbU.append(this.age);
        sbU.append(", engagementHealthy=");
        sbU.append(this.engagementHealthy);
        sbU.append(", nsfwProperties=");
        sbU.append(this.nsfwProperties);
        sbU.append(", retentionHealthy=");
        sbU.append(this.retentionHealthy);
        sbU.append(", safeEnvironment=");
        sbU.append(this.safeEnvironment);
        sbU.append(", size=");
        sbU.append(this.size);
        sbU.append(", healthScore=");
        sbU.append(this.healthScore);
        sbU.append(", healthScorePending=");
        sbU.append(this.healthScorePending);
        sbU.append(", rejection=");
        sbU.append(this.rejection);
        sbU.append(", minimumAgeInDays=");
        sbU.append(this.minimumAgeInDays);
        sbU.append(", minimumSize=");
        return a.B(sbU, this.minimumSize, ")");
    }
}
