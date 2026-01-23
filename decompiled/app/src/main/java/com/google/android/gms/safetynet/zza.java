package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p336k.C4328b;

/* JADX INFO: loaded from: classes3.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new C4328b();

    /* JADX INFO: renamed from: j */
    public final String f20826j;

    public zza(String str) {
        this.f20826j = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 2, this.f20826j, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
