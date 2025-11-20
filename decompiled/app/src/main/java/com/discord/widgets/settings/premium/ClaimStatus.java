package com.discord.widgets.settings.premium;

import a0.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import b.d.b.a.a;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.UtcDateTimeParceler;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ClaimStatus.kt */
/* loaded from: classes2.dex */
public abstract class ClaimStatus implements Parcelable {

    /* compiled from: ClaimStatus.kt */
    public static final /* data */ class Claimed extends ClaimStatus {
        public static final Parcelable.Creator<Claimed> CREATOR = new Creator();
        private final String body;
        private final String code;
        private final String link;
        private final long promoId;
        private final UtcDateTime redeemBy;

        public static class Creator implements Parcelable.Creator<Claimed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Claimed createFromParcel(Parcel parcel) {
                m.checkNotNullParameter(parcel, "in");
                return new Claimed(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), UtcDateTimeParceler.INSTANCE.create(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Claimed createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Claimed[] newArray(int i) {
                return new Claimed[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Claimed[] newArray(int i) {
                return newArray(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Claimed(long j, String str, String str2, String str3, UtcDateTime utcDateTime) {
            super(null);
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            m.checkNotNullParameter(str2, "body");
            m.checkNotNullParameter(str3, "link");
            m.checkNotNullParameter(utcDateTime, "redeemBy");
            this.promoId = j;
            this.code = str;
            this.body = str2;
            this.link = str3;
            this.redeemBy = utcDateTime;
        }

        public static /* synthetic */ Claimed copy$default(Claimed claimed, long j, String str, String str2, String str3, UtcDateTime utcDateTime, int i, Object obj) {
            if ((i & 1) != 0) {
                j = claimed.promoId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = claimed.code;
            }
            String str4 = str;
            if ((i & 4) != 0) {
                str2 = claimed.body;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = claimed.link;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                utcDateTime = claimed.redeemBy;
            }
            return claimed.copy(j2, str4, str5, str6, utcDateTime);
        }

        /* renamed from: component1, reason: from getter */
        public final long getPromoId() {
            return this.promoId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* renamed from: component3, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        /* renamed from: component4, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        /* renamed from: component5, reason: from getter */
        public final UtcDateTime getRedeemBy() {
            return this.redeemBy;
        }

        public final Claimed copy(long promoId, String code, String body, String link, UtcDateTime redeemBy) {
            m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
            m.checkNotNullParameter(body, "body");
            m.checkNotNullParameter(link, "link");
            m.checkNotNullParameter(redeemBy, "redeemBy");
            return new Claimed(promoId, code, body, link, redeemBy);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Claimed)) {
                return false;
            }
            Claimed claimed = (Claimed) other;
            return this.promoId == claimed.promoId && m.areEqual(this.code, claimed.code) && m.areEqual(this.body, claimed.body) && m.areEqual(this.link, claimed.link) && m.areEqual(this.redeemBy, claimed.redeemBy);
        }

        public final String getBody() {
            return this.body;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getLink() {
            return this.link;
        }

        public final long getPromoId() {
            return this.promoId;
        }

        public final UtcDateTime getRedeemBy() {
            return this.redeemBy;
        }

        public int hashCode() {
            int iA = b.a(this.promoId) * 31;
            String str = this.code;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.body;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.link;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            UtcDateTime utcDateTime = this.redeemBy;
            return iHashCode3 + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Claimed(promoId=");
            sbU.append(this.promoId);
            sbU.append(", code=");
            sbU.append(this.code);
            sbU.append(", body=");
            sbU.append(this.body);
            sbU.append(", link=");
            sbU.append(this.link);
            sbU.append(", redeemBy=");
            sbU.append(this.redeemBy);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            m.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.promoId);
            parcel.writeString(this.code);
            parcel.writeString(this.body);
            parcel.writeString(this.link);
            UtcDateTimeParceler.INSTANCE.write(this.redeemBy, parcel, flags);
        }
    }

    /* compiled from: ClaimStatus.kt */
    public static final /* data */ class Unclaimed extends ClaimStatus {
        public static final Parcelable.Creator<Unclaimed> CREATOR = new Creator();
        private final UtcDateTime claimBy;
        private final long promoId;

        public static class Creator implements Parcelable.Creator<Unclaimed> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unclaimed createFromParcel(Parcel parcel) {
                m.checkNotNullParameter(parcel, "in");
                return new Unclaimed(parcel.readLong(), UtcDateTimeParceler.INSTANCE.create(parcel));
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Unclaimed createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Unclaimed[] newArray(int i) {
                return new Unclaimed[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Unclaimed[] newArray(int i) {
                return newArray(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unclaimed(long j, UtcDateTime utcDateTime) {
            super(null);
            m.checkNotNullParameter(utcDateTime, "claimBy");
            this.promoId = j;
            this.claimBy = utcDateTime;
        }

        public static /* synthetic */ Unclaimed copy$default(Unclaimed unclaimed, long j, UtcDateTime utcDateTime, int i, Object obj) {
            if ((i & 1) != 0) {
                j = unclaimed.promoId;
            }
            if ((i & 2) != 0) {
                utcDateTime = unclaimed.claimBy;
            }
            return unclaimed.copy(j, utcDateTime);
        }

        /* renamed from: component1, reason: from getter */
        public final long getPromoId() {
            return this.promoId;
        }

        /* renamed from: component2, reason: from getter */
        public final UtcDateTime getClaimBy() {
            return this.claimBy;
        }

        public final Unclaimed copy(long promoId, UtcDateTime claimBy) {
            m.checkNotNullParameter(claimBy, "claimBy");
            return new Unclaimed(promoId, claimBy);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Unclaimed)) {
                return false;
            }
            Unclaimed unclaimed = (Unclaimed) other;
            return this.promoId == unclaimed.promoId && m.areEqual(this.claimBy, unclaimed.claimBy);
        }

        public final UtcDateTime getClaimBy() {
            return this.claimBy;
        }

        public final long getPromoId() {
            return this.promoId;
        }

        public int hashCode() {
            int iA = b.a(this.promoId) * 31;
            UtcDateTime utcDateTime = this.claimBy;
            return iA + (utcDateTime != null ? utcDateTime.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Unclaimed(promoId=");
            sbU.append(this.promoId);
            sbU.append(", claimBy=");
            sbU.append(this.claimBy);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            m.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.promoId);
            UtcDateTimeParceler.INSTANCE.write(this.claimBy, parcel, flags);
        }
    }

    private ClaimStatus() {
    }

    public /* synthetic */ ClaimStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
