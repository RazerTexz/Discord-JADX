package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p361c.p391o.p392b.C4768a;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
/* loaded from: classes3.dex */
public class DynamicLinkData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DynamicLinkData> CREATOR = new C4768a();

    /* renamed from: j */
    public String f21422j;

    /* renamed from: k */
    public String f21423k;

    /* renamed from: l */
    public int f21424l;

    /* renamed from: m */
    public long f21425m;

    /* renamed from: n */
    public Bundle f21426n;

    /* renamed from: o */
    public Uri f21427o;

    public DynamicLinkData(String str, String str2, int i, long j, Bundle bundle, Uri uri) {
        this.f21425m = 0L;
        this.f21426n = null;
        this.f21422j = str;
        this.f21423k = str2;
        this.f21424l = i;
        this.f21425m = j;
        this.f21426n = bundle;
        this.f21427o = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 1, this.f21422j, false);
        AnimatableValueParser.m574t2(parcel, 2, this.f21423k, false);
        int i2 = this.f21424l;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        long j = this.f21425m;
        parcel.writeInt(524292);
        parcel.writeLong(j);
        Bundle bundle = this.f21426n;
        if (bundle == null) {
            bundle = new Bundle();
        }
        AnimatableValueParser.m558p2(parcel, 5, bundle, false);
        AnimatableValueParser.m570s2(parcel, 6, this.f21427o, i, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
