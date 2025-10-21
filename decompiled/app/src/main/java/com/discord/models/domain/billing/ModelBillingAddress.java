package com.discord.models.domain.billing;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ModelBillingAddress.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelBillingAddress {
    private final String city;
    private final String country;
    private final String line_1;
    private final String line_2;
    private final String name;
    private final String postalCode;
    private final String state;

    public ModelBillingAddress(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "line_1");
        Intrinsics3.checkNotNullParameter(str3, "line_2");
        Intrinsics3.checkNotNullParameter(str4, "city");
        Intrinsics3.checkNotNullParameter(str5, "state");
        Intrinsics3.checkNotNullParameter(str6, "country");
        Intrinsics3.checkNotNullParameter(str7, "postalCode");
        this.name = str;
        this.line_1 = str2;
        this.line_2 = str3;
        this.city = str4;
        this.state = str5;
        this.country = str6;
        this.postalCode = str7;
    }

    public static /* synthetic */ ModelBillingAddress copy$default(ModelBillingAddress modelBillingAddress, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelBillingAddress.name;
        }
        if ((i & 2) != 0) {
            str2 = modelBillingAddress.line_1;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = modelBillingAddress.line_2;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = modelBillingAddress.city;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = modelBillingAddress.state;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = modelBillingAddress.country;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = modelBillingAddress.postalCode;
        }
        return modelBillingAddress.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLine_1() {
        return this.line_1;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLine_2() {
        return this.line_2;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCity() {
        return this.city;
    }

    /* renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCountry() {
        return this.country;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    public final ModelBillingAddress copy(String name, String line_1, String line_2, String city, String state, String country, String postalCode) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(line_1, "line_1");
        Intrinsics3.checkNotNullParameter(line_2, "line_2");
        Intrinsics3.checkNotNullParameter(city, "city");
        Intrinsics3.checkNotNullParameter(state, "state");
        Intrinsics3.checkNotNullParameter(country, "country");
        Intrinsics3.checkNotNullParameter(postalCode, "postalCode");
        return new ModelBillingAddress(name, line_1, line_2, city, state, country, postalCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelBillingAddress)) {
            return false;
        }
        ModelBillingAddress modelBillingAddress = (ModelBillingAddress) other;
        return Intrinsics3.areEqual(this.name, modelBillingAddress.name) && Intrinsics3.areEqual(this.line_1, modelBillingAddress.line_1) && Intrinsics3.areEqual(this.line_2, modelBillingAddress.line_2) && Intrinsics3.areEqual(this.city, modelBillingAddress.city) && Intrinsics3.areEqual(this.state, modelBillingAddress.state) && Intrinsics3.areEqual(this.country, modelBillingAddress.country) && Intrinsics3.areEqual(this.postalCode, modelBillingAddress.postalCode);
    }

    public final String getCity() {
        return this.city;
    }

    public final String getCountry() {
        return this.country;
    }

    public final String getLine_1() {
        return this.line_1;
    }

    public final String getLine_2() {
        return this.line_2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.line_1;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.line_2;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.city;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.state;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.country;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.postalCode;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelBillingAddress(name=");
        sbU.append(this.name);
        sbU.append(", line_1=");
        sbU.append(this.line_1);
        sbU.append(", line_2=");
        sbU.append(this.line_2);
        sbU.append(", city=");
        sbU.append(this.city);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", country=");
        sbU.append(this.country);
        sbU.append(", postalCode=");
        return outline.J(sbU, this.postalCode, ")");
    }
}
