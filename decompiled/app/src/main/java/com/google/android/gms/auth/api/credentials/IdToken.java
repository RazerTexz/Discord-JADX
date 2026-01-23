package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.C3194i;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new C3194i();

    /* JADX INFO: renamed from: j */
    @NonNull
    public final String f20414j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final String f20415k;

    public IdToken(@NonNull String str, @NonNull String str2) {
        AnimatableValueParser.m551o(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        AnimatableValueParser.m551o(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.f20414j = str;
        this.f20415k = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return AnimatableValueParser.m524h0(this.f20414j, idToken.f20414j) && AnimatableValueParser.m524h0(this.f20415k, idToken.f20415k);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 1, this.f20414j, false);
        AnimatableValueParser.m574t2(parcel, 2, this.f20415k, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
