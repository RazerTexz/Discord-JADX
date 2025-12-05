package com.google.firebase.dynamiclinks.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p361c.p391o.p392b.C4781n;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* loaded from: classes3.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new C4781n();

    /* renamed from: j */
    public final String f21431j;

    public zzr(String str) {
        this.f21431j = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 2, this.f21431j, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
