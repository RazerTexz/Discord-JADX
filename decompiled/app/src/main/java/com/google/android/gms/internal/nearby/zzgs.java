package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p313h.p326m.C3929f;

/* loaded from: classes3.dex */
public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgs> CREATOR = new C3929f();

    /* renamed from: j */
    public static final zzgs f20644j = new zzgs(1, "", null);

    /* renamed from: k */
    public final int f20645k;

    /* renamed from: l */
    public final String f20646l;

    /* renamed from: m */
    @Nullable
    public final String f20647m;

    public zzgs(int i, @Nullable String str, @Nullable String str2) {
        Integer numValueOf = Integer.valueOf(i);
        Objects.requireNonNull(numValueOf, "null reference");
        this.f20645k = numValueOf.intValue();
        this.f20646l = str == null ? "" : str;
        this.f20647m = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgs)) {
            return false;
        }
        zzgs zzgsVar = (zzgs) obj;
        return AnimatableValueParser.m524h0(this.f20646l, zzgsVar.f20646l) && AnimatableValueParser.m524h0(this.f20647m, zzgsVar.f20647m);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20646l, this.f20647m});
    }

    public final String toString() {
        String str = this.f20646l;
        String str2 = this.f20647m;
        StringBuilder sbM831S = outline.m831S(outline.m841b(str2, outline.m841b(str, 40)), "NearbyDevice{handle=", str, ", bluetoothAddress=", str2);
        sbM831S.append("}");
        return sbM831S.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 3, this.f20646l, false);
        AnimatableValueParser.m574t2(parcel, 6, this.f20647m, false);
        int i2 = this.f20645k;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
