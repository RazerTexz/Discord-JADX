package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p292c.p293a.p294d.C3192g;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes3.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new C3192g();

    /* renamed from: j */
    public final int f20405j;

    /* renamed from: k */
    public final boolean f20406k;

    /* renamed from: l */
    public final String[] f20407l;

    /* renamed from: m */
    public final CredentialPickerConfig f20408m;

    /* renamed from: n */
    public final CredentialPickerConfig f20409n;

    /* renamed from: o */
    public final boolean f20410o;

    /* renamed from: p */
    @Nullable
    public final String f20411p;

    /* renamed from: q */
    @Nullable
    public final String f20412q;

    /* renamed from: r */
    public final boolean f20413r;

    public CredentialRequest(int i, boolean z2, String[] strArr, @Nullable CredentialPickerConfig credentialPickerConfig, @Nullable CredentialPickerConfig credentialPickerConfig2, boolean z3, @Nullable String str, @Nullable String str2, boolean z4) {
        this.f20405j = i;
        this.f20406k = z2;
        Objects.requireNonNull(strArr, "null reference");
        this.f20407l = strArr;
        this.f20408m = credentialPickerConfig == null ? new CredentialPickerConfig(2, false, true, false, 1) : credentialPickerConfig;
        this.f20409n = credentialPickerConfig2 == null ? new CredentialPickerConfig(2, false, true, false, 1) : credentialPickerConfig2;
        if (i < 3) {
            this.f20410o = true;
            this.f20411p = null;
            this.f20412q = null;
        } else {
            this.f20410o = z3;
            this.f20411p = str;
            this.f20412q = str2;
        }
        this.f20413r = z4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        boolean z2 = this.f20406k;
        parcel.writeInt(262145);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.m578u2(parcel, 2, this.f20407l, false);
        AnimatableValueParser.m570s2(parcel, 3, this.f20408m, i, false);
        AnimatableValueParser.m570s2(parcel, 4, this.f20409n, i, false);
        boolean z3 = this.f20410o;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        AnimatableValueParser.m574t2(parcel, 6, this.f20411p, false);
        AnimatableValueParser.m574t2(parcel, 7, this.f20412q, false);
        boolean z4 = this.f20413r;
        parcel.writeInt(262152);
        parcel.writeInt(z4 ? 1 : 0);
        int i2 = this.f20405j;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
