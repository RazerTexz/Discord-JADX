package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p292c.p293a.p296f.C3222g;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes3.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new C3222g();

    /* renamed from: j */
    @Deprecated
    public String f20455j;

    /* renamed from: k */
    public GoogleSignInAccount f20456k;

    /* renamed from: l */
    @Deprecated
    public String f20457l;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f20456k = googleSignInAccount;
        AnimatableValueParser.m579v(str, "8.3 and 8.4 SDKs require non-null email");
        this.f20455j = str;
        AnimatableValueParser.m579v(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.f20457l = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 4, this.f20455j, false);
        AnimatableValueParser.m570s2(parcel, 7, this.f20456k, i, false);
        AnimatableValueParser.m574t2(parcel, 8, this.f20457l, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
