package com.discord.widgets.servers.guild_role_subscription;

import com.discord.utilities.recycler.DiffKeyProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
/* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class ServerSettingsGuildRoleSubscriptionTierAdapter2 implements DiffKeyProvider {

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem$AddTier */
    public static final class AddTier extends ServerSettingsGuildRoleSubscriptionTierAdapter2 {
        public static final AddTier INSTANCE = new AddTier();
        private static final String key = "AddTierItem";

        private AddTier() {
            super(null);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }
    }

    /* compiled from: ServerSettingsGuildRoleSubscriptionTierAdapter.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapterItem$Tier */
    public static final /* data */ class Tier extends ServerSettingsGuildRoleSubscriptionTierAdapter2 {
        private final long applicationId;
        private final boolean isPublished;
        private final String key;
        private final Long tierImageAssetId;
        private final long tierListingId;
        private final String tierName;
        private final int tierPrice;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tier(long j, String str, int i, long j2, boolean z2, Long l) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "tierName");
            this.tierListingId = j;
            this.tierName = str;
            this.tierPrice = i;
            this.applicationId = j2;
            this.isPublished = z2;
            this.tierImageAssetId = l;
            this.key = String.valueOf(j);
        }

        public static /* synthetic */ Tier copy$default(Tier tier, long j, String str, int i, long j2, boolean z2, Long l, int i2, Object obj) {
            return tier.copy((i2 & 1) != 0 ? tier.tierListingId : j, (i2 & 2) != 0 ? tier.tierName : str, (i2 & 4) != 0 ? tier.tierPrice : i, (i2 & 8) != 0 ? tier.applicationId : j2, (i2 & 16) != 0 ? tier.isPublished : z2, (i2 & 32) != 0 ? tier.tierImageAssetId : l);
        }

        /* renamed from: component1, reason: from getter */
        public final long getTierListingId() {
            return this.tierListingId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTierName() {
            return this.tierName;
        }

        /* renamed from: component3, reason: from getter */
        public final int getTierPrice() {
            return this.tierPrice;
        }

        /* renamed from: component4, reason: from getter */
        public final long getApplicationId() {
            return this.applicationId;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsPublished() {
            return this.isPublished;
        }

        /* renamed from: component6, reason: from getter */
        public final Long getTierImageAssetId() {
            return this.tierImageAssetId;
        }

        public final Tier copy(long tierListingId, String tierName, int tierPrice, long applicationId, boolean isPublished, Long tierImageAssetId) {
            Intrinsics3.checkNotNullParameter(tierName, "tierName");
            return new Tier(tierListingId, tierName, tierPrice, applicationId, isPublished, tierImageAssetId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tier)) {
                return false;
            }
            Tier tier = (Tier) other;
            return this.tierListingId == tier.tierListingId && Intrinsics3.areEqual(this.tierName, tier.tierName) && this.tierPrice == tier.tierPrice && this.applicationId == tier.applicationId && this.isPublished == tier.isPublished && Intrinsics3.areEqual(this.tierImageAssetId, tier.tierImageAssetId);
        }

        public final long getApplicationId() {
            return this.applicationId;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final Long getTierImageAssetId() {
            return this.tierImageAssetId;
        }

        public final long getTierListingId() {
            return this.tierListingId;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final int getTierPrice() {
            return this.tierPrice;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.tierListingId) * 31;
            String str = this.tierName;
            int iM3a2 = (C0002b.m3a(this.applicationId) + ((((iM3a + (str != null ? str.hashCode() : 0)) * 31) + this.tierPrice) * 31)) * 31;
            boolean z2 = this.isPublished;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iM3a2 + i) * 31;
            Long l = this.tierImageAssetId;
            return i2 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isPublished() {
            return this.isPublished;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Tier(tierListingId=");
            sbM833U.append(this.tierListingId);
            sbM833U.append(", tierName=");
            sbM833U.append(this.tierName);
            sbM833U.append(", tierPrice=");
            sbM833U.append(this.tierPrice);
            sbM833U.append(", applicationId=");
            sbM833U.append(this.applicationId);
            sbM833U.append(", isPublished=");
            sbM833U.append(this.isPublished);
            sbM833U.append(", tierImageAssetId=");
            return outline.m819G(sbM833U, this.tierImageAssetId, ")");
        }
    }

    private ServerSettingsGuildRoleSubscriptionTierAdapter2() {
    }

    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierAdapter2(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
