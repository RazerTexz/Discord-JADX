package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p313h.p326m.C3927d;

/* loaded from: classes3.dex */
public final class zzgp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgp> CREATOR = new C3927d();

    /* renamed from: j */
    public final int f20635j;

    /* renamed from: k */
    @Nullable
    public final ParcelUuid f20636k;

    /* renamed from: l */
    @Nullable
    public final ParcelUuid f20637l;

    /* renamed from: m */
    @Nullable
    public final ParcelUuid f20638m;

    /* renamed from: n */
    @Nullable
    public final byte[] f20639n;

    /* renamed from: o */
    @Nullable
    public final byte[] f20640o;

    /* renamed from: p */
    public final int f20641p;

    /* renamed from: q */
    @Nullable
    public final byte[] f20642q;

    /* renamed from: r */
    @Nullable
    public final byte[] f20643r;

    public zzgp(int i, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        this.f20635j = i;
        this.f20636k = parcelUuid;
        this.f20637l = parcelUuid2;
        this.f20638m = parcelUuid3;
        this.f20639n = bArr;
        this.f20640o = bArr2;
        this.f20641p = i2;
        this.f20642q = bArr3;
        this.f20643r = bArr4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzgp.class == obj.getClass()) {
            zzgp zzgpVar = (zzgp) obj;
            if (this.f20641p == zzgpVar.f20641p && Arrays.equals(this.f20642q, zzgpVar.f20642q) && Arrays.equals(this.f20643r, zzgpVar.f20643r) && AnimatableValueParser.m524h0(this.f20638m, zzgpVar.f20638m) && Arrays.equals(this.f20639n, zzgpVar.f20639n) && Arrays.equals(this.f20640o, zzgpVar.f20640o) && AnimatableValueParser.m524h0(this.f20636k, zzgpVar.f20636k) && AnimatableValueParser.m524h0(this.f20637l, zzgpVar.f20637l)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f20641p), Integer.valueOf(Arrays.hashCode(this.f20642q)), Integer.valueOf(Arrays.hashCode(this.f20643r)), this.f20638m, Integer.valueOf(Arrays.hashCode(this.f20639n)), Integer.valueOf(Arrays.hashCode(this.f20640o)), this.f20636k, this.f20637l});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        int i2 = this.f20635j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.m570s2(parcel, 4, this.f20636k, i, false);
        AnimatableValueParser.m570s2(parcel, 5, this.f20637l, i, false);
        AnimatableValueParser.m570s2(parcel, 6, this.f20638m, i, false);
        AnimatableValueParser.m562q2(parcel, 7, this.f20639n, false);
        AnimatableValueParser.m562q2(parcel, 8, this.f20640o, false);
        int i3 = this.f20641p;
        parcel.writeInt(262153);
        parcel.writeInt(i3);
        AnimatableValueParser.m562q2(parcel, 10, this.f20642q, false);
        AnimatableValueParser.m562q2(parcel, 11, this.f20643r, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
