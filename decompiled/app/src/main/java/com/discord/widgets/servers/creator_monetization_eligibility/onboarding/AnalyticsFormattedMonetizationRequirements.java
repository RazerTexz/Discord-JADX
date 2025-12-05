package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AnalyticsFormattedMonetizationRequirements.kt */
/* loaded from: classes2.dex */
public final /* data */ class AnalyticsFormattedMonetizationRequirements {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy gsonInstance$delegate = LazyJVM.lazy(AnalyticsFormattedMonetizationRequirements2.INSTANCE);
    private final boolean canApply;
    private final Integer communicatorCount;
    private final Integer guildMemberCount;
    private final boolean hasMemberRetention;
    private final boolean hasSufficientMembers;
    private final boolean isApplicationPending;
    private final boolean isEligibleForMonetization;
    private final CreatorMonetizationEnableRequest latestRequest;
    private final boolean meetsServerAgeRequirement;
    private final int minimumAgeInDays;
    private final int minimumSize;
    private final boolean noRecentViolations;
    private final boolean notNSFW;
    private final CreatorMonetizationEligibilityRequirements.Rejection rejection;
    private final Double retentionScore;
    private final boolean weeklyCommunicators;

    /* compiled from: AnalyticsFormattedMonetizationRequirements.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Gson access$getGsonInstance$p(Companion companion) {
            return companion.getGsonInstance();
        }

        private final Gson getGsonInstance() {
            Lazy lazyAccess$getGsonInstance$cp = AnalyticsFormattedMonetizationRequirements.access$getGsonInstance$cp();
            Companion companion = AnalyticsFormattedMonetizationRequirements.INSTANCE;
            return (Gson) lazyAccess$getGsonInstance$cp.getValue();
        }

        public final AnalyticsFormattedMonetizationRequirements toAnalyticsFormat(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            Intrinsics3.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "$this$toAnalyticsFormat");
            boolean sufficient = creatorMonetizationEligibilityRequirements.getSufficient();
            boolean size = creatorMonetizationEligibilityRequirements.getSize();
            boolean age = creatorMonetizationEligibilityRequirements.getAge();
            boolean safeEnvironment = creatorMonetizationEligibilityRequirements.getSafeEnvironment();
            boolean engagementHealthy = creatorMonetizationEligibilityRequirements.getEngagementHealthy();
            boolean retentionHealthy = creatorMonetizationEligibilityRequirements.getRetentionHealthy();
            Map<String, Object> mapM7774i = creatorMonetizationEligibilityRequirements.m7774i();
            boolean z2 = mapM7774i == null || mapM7774i.isEmpty();
            boolean canApply = creatorMonetizationEligibilityRequirements.getCanApply();
            CreatorMonetizationEnableRequest latestRequest = creatorMonetizationEligibilityRequirements.getLatestRequest();
            boolean z3 = (latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest.State.OPEN;
            int minimumAgeInDays = creatorMonetizationEligibilityRequirements.getMinimumAgeInDays();
            int minimumSize = creatorMonetizationEligibilityRequirements.getMinimumSize();
            CreatorMonetizationEnableRequest latestRequest2 = creatorMonetizationEligibilityRequirements.getLatestRequest();
            CreatorMonetizationEligibilityRequirements.Rejection rejection = creatorMonetizationEligibilityRequirements.getRejection();
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore = creatorMonetizationEligibilityRequirements.getHealthScore();
            Integer guildSize = healthScore != null ? healthScore.getGuildSize() : null;
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore2 = creatorMonetizationEligibilityRequirements.getHealthScore();
            Integer communicators = healthScore2 != null ? healthScore2.getCommunicators() : null;
            CreatorMonetizationEligibilityRequirements.HealthScore healthScore3 = creatorMonetizationEligibilityRequirements.getHealthScore();
            return new AnalyticsFormattedMonetizationRequirements(sufficient, size, age, safeEnvironment, engagementHealthy, retentionHealthy, z2, canApply, z3, minimumAgeInDays, minimumSize, latestRequest2, rejection, guildSize, communicators, healthScore3 != null ? healthScore3.getPercRetW1() : null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AnalyticsFormattedMonetizationRequirements(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, int i2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, CreatorMonetizationEligibilityRequirements.Rejection rejection, Integer num, Integer num2, Double d) {
        this.isEligibleForMonetization = z2;
        this.hasSufficientMembers = z3;
        this.meetsServerAgeRequirement = z4;
        this.noRecentViolations = z5;
        this.weeklyCommunicators = z6;
        this.hasMemberRetention = z7;
        this.notNSFW = z8;
        this.canApply = z9;
        this.isApplicationPending = z10;
        this.minimumAgeInDays = i;
        this.minimumSize = i2;
        this.latestRequest = creatorMonetizationEnableRequest;
        this.rejection = rejection;
        this.guildMemberCount = num;
        this.communicatorCount = num2;
        this.retentionScore = d;
    }

    public static final /* synthetic */ Lazy access$getGsonInstance$cp() {
        return gsonInstance$delegate;
    }

    public static /* synthetic */ AnalyticsFormattedMonetizationRequirements copy$default(AnalyticsFormattedMonetizationRequirements analyticsFormattedMonetizationRequirements, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i, int i2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, CreatorMonetizationEligibilityRequirements.Rejection rejection, Integer num, Integer num2, Double d, int i3, Object obj) {
        return analyticsFormattedMonetizationRequirements.copy((i3 & 1) != 0 ? analyticsFormattedMonetizationRequirements.isEligibleForMonetization : z2, (i3 & 2) != 0 ? analyticsFormattedMonetizationRequirements.hasSufficientMembers : z3, (i3 & 4) != 0 ? analyticsFormattedMonetizationRequirements.meetsServerAgeRequirement : z4, (i3 & 8) != 0 ? analyticsFormattedMonetizationRequirements.noRecentViolations : z5, (i3 & 16) != 0 ? analyticsFormattedMonetizationRequirements.weeklyCommunicators : z6, (i3 & 32) != 0 ? analyticsFormattedMonetizationRequirements.hasMemberRetention : z7, (i3 & 64) != 0 ? analyticsFormattedMonetizationRequirements.notNSFW : z8, (i3 & 128) != 0 ? analyticsFormattedMonetizationRequirements.canApply : z9, (i3 & 256) != 0 ? analyticsFormattedMonetizationRequirements.isApplicationPending : z10, (i3 & 512) != 0 ? analyticsFormattedMonetizationRequirements.minimumAgeInDays : i, (i3 & 1024) != 0 ? analyticsFormattedMonetizationRequirements.minimumSize : i2, (i3 & 2048) != 0 ? analyticsFormattedMonetizationRequirements.latestRequest : creatorMonetizationEnableRequest, (i3 & 4096) != 0 ? analyticsFormattedMonetizationRequirements.rejection : rejection, (i3 & 8192) != 0 ? analyticsFormattedMonetizationRequirements.guildMemberCount : num, (i3 & 16384) != 0 ? analyticsFormattedMonetizationRequirements.communicatorCount : num2, (i3 & 32768) != 0 ? analyticsFormattedMonetizationRequirements.retentionScore : d);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsEligibleForMonetization() {
        return this.isEligibleForMonetization;
    }

    /* renamed from: component10, reason: from getter */
    public final int getMinimumAgeInDays() {
        return this.minimumAgeInDays;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMinimumSize() {
        return this.minimumSize;
    }

    /* renamed from: component12, reason: from getter */
    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    /* renamed from: component13, reason: from getter */
    public final CreatorMonetizationEligibilityRequirements.Rejection getRejection() {
        return this.rejection;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getGuildMemberCount() {
        return this.guildMemberCount;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getCommunicatorCount() {
        return this.communicatorCount;
    }

    /* renamed from: component16, reason: from getter */
    public final Double getRetentionScore() {
        return this.retentionScore;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasSufficientMembers() {
        return this.hasSufficientMembers;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getMeetsServerAgeRequirement() {
        return this.meetsServerAgeRequirement;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getNoRecentViolations() {
        return this.noRecentViolations;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getWeeklyCommunicators() {
        return this.weeklyCommunicators;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getHasMemberRetention() {
        return this.hasMemberRetention;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getNotNSFW() {
        return this.notNSFW;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getCanApply() {
        return this.canApply;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsApplicationPending() {
        return this.isApplicationPending;
    }

    public final AnalyticsFormattedMonetizationRequirements copy(boolean isEligibleForMonetization, boolean hasSufficientMembers, boolean meetsServerAgeRequirement, boolean noRecentViolations, boolean weeklyCommunicators, boolean hasMemberRetention, boolean notNSFW, boolean canApply, boolean isApplicationPending, int minimumAgeInDays, int minimumSize, CreatorMonetizationEnableRequest latestRequest, CreatorMonetizationEligibilityRequirements.Rejection rejection, Integer guildMemberCount, Integer communicatorCount, Double retentionScore) {
        return new AnalyticsFormattedMonetizationRequirements(isEligibleForMonetization, hasSufficientMembers, meetsServerAgeRequirement, noRecentViolations, weeklyCommunicators, hasMemberRetention, notNSFW, canApply, isApplicationPending, minimumAgeInDays, minimumSize, latestRequest, rejection, guildMemberCount, communicatorCount, retentionScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyticsFormattedMonetizationRequirements)) {
            return false;
        }
        AnalyticsFormattedMonetizationRequirements analyticsFormattedMonetizationRequirements = (AnalyticsFormattedMonetizationRequirements) other;
        return this.isEligibleForMonetization == analyticsFormattedMonetizationRequirements.isEligibleForMonetization && this.hasSufficientMembers == analyticsFormattedMonetizationRequirements.hasSufficientMembers && this.meetsServerAgeRequirement == analyticsFormattedMonetizationRequirements.meetsServerAgeRequirement && this.noRecentViolations == analyticsFormattedMonetizationRequirements.noRecentViolations && this.weeklyCommunicators == analyticsFormattedMonetizationRequirements.weeklyCommunicators && this.hasMemberRetention == analyticsFormattedMonetizationRequirements.hasMemberRetention && this.notNSFW == analyticsFormattedMonetizationRequirements.notNSFW && this.canApply == analyticsFormattedMonetizationRequirements.canApply && this.isApplicationPending == analyticsFormattedMonetizationRequirements.isApplicationPending && this.minimumAgeInDays == analyticsFormattedMonetizationRequirements.minimumAgeInDays && this.minimumSize == analyticsFormattedMonetizationRequirements.minimumSize && Intrinsics3.areEqual(this.latestRequest, analyticsFormattedMonetizationRequirements.latestRequest) && Intrinsics3.areEqual(this.rejection, analyticsFormattedMonetizationRequirements.rejection) && Intrinsics3.areEqual(this.guildMemberCount, analyticsFormattedMonetizationRequirements.guildMemberCount) && Intrinsics3.areEqual(this.communicatorCount, analyticsFormattedMonetizationRequirements.communicatorCount) && Intrinsics3.areEqual(this.retentionScore, analyticsFormattedMonetizationRequirements.retentionScore);
    }

    public final boolean getCanApply() {
        return this.canApply;
    }

    public final Integer getCommunicatorCount() {
        return this.communicatorCount;
    }

    public final Integer getGuildMemberCount() {
        return this.guildMemberCount;
    }

    public final boolean getHasMemberRetention() {
        return this.hasMemberRetention;
    }

    public final boolean getHasSufficientMembers() {
        return this.hasSufficientMembers;
    }

    public final CreatorMonetizationEnableRequest getLatestRequest() {
        return this.latestRequest;
    }

    public final boolean getMeetsServerAgeRequirement() {
        return this.meetsServerAgeRequirement;
    }

    public final int getMinimumAgeInDays() {
        return this.minimumAgeInDays;
    }

    public final int getMinimumSize() {
        return this.minimumSize;
    }

    public final boolean getNoRecentViolations() {
        return this.noRecentViolations;
    }

    public final boolean getNotNSFW() {
        return this.notNSFW;
    }

    public final CreatorMonetizationEligibilityRequirements.Rejection getRejection() {
        return this.rejection;
    }

    public final Double getRetentionScore() {
        return this.retentionScore;
    }

    public final boolean getWeeklyCommunicators() {
        return this.weeklyCommunicators;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.isEligibleForMonetization;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.hasSufficientMembers;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.meetsServerAgeRequirement;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.noRecentViolations;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r24 = this.weeklyCommunicators;
        int i8 = r24;
        if (r24 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        ?? r25 = this.hasMemberRetention;
        int i10 = r25;
        if (r25 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        ?? r26 = this.notNSFW;
        int i12 = r26;
        if (r26 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        ?? r27 = this.canApply;
        int i14 = r27;
        if (r27 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z3 = this.isApplicationPending;
        int i16 = (((((i15 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.minimumAgeInDays) * 31) + this.minimumSize) * 31;
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = this.latestRequest;
        int iHashCode = (i16 + (creatorMonetizationEnableRequest != null ? creatorMonetizationEnableRequest.hashCode() : 0)) * 31;
        CreatorMonetizationEligibilityRequirements.Rejection rejection = this.rejection;
        int iHashCode2 = (iHashCode + (rejection != null ? rejection.hashCode() : 0)) * 31;
        Integer num = this.guildMemberCount;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.communicatorCount;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Double d = this.retentionScore;
        return iHashCode4 + (d != null ? d.hashCode() : 0);
    }

    public final boolean isApplicationPending() {
        return this.isApplicationPending;
    }

    public final boolean isEligibleForMonetization() {
        return this.isEligibleForMonetization;
    }

    public final String toJson() throws JsonIOException {
        String strM9209m = Companion.access$getGsonInstance$p(INSTANCE).m9209m(this);
        Intrinsics3.checkNotNullExpressionValue(strM9209m, "gsonInstance.toJson(this)");
        return strM9209m;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("AnalyticsFormattedMonetizationRequirements(isEligibleForMonetization=");
        sbM833U.append(this.isEligibleForMonetization);
        sbM833U.append(", hasSufficientMembers=");
        sbM833U.append(this.hasSufficientMembers);
        sbM833U.append(", meetsServerAgeRequirement=");
        sbM833U.append(this.meetsServerAgeRequirement);
        sbM833U.append(", noRecentViolations=");
        sbM833U.append(this.noRecentViolations);
        sbM833U.append(", weeklyCommunicators=");
        sbM833U.append(this.weeklyCommunicators);
        sbM833U.append(", hasMemberRetention=");
        sbM833U.append(this.hasMemberRetention);
        sbM833U.append(", notNSFW=");
        sbM833U.append(this.notNSFW);
        sbM833U.append(", canApply=");
        sbM833U.append(this.canApply);
        sbM833U.append(", isApplicationPending=");
        sbM833U.append(this.isApplicationPending);
        sbM833U.append(", minimumAgeInDays=");
        sbM833U.append(this.minimumAgeInDays);
        sbM833U.append(", minimumSize=");
        sbM833U.append(this.minimumSize);
        sbM833U.append(", latestRequest=");
        sbM833U.append(this.latestRequest);
        sbM833U.append(", rejection=");
        sbM833U.append(this.rejection);
        sbM833U.append(", guildMemberCount=");
        sbM833U.append(this.guildMemberCount);
        sbM833U.append(", communicatorCount=");
        sbM833U.append(this.communicatorCount);
        sbM833U.append(", retentionScore=");
        sbM833U.append(this.retentionScore);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
