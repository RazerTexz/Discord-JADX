package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p313h.p324k.C3576u;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzw> CREATOR = new C3576u();

    /* renamed from: j */
    public final zzi f20612j;

    /* renamed from: k */
    public final long f20613k;

    /* renamed from: l */
    public int f20614l;

    /* renamed from: m */
    public final String f20615m;

    /* renamed from: n */
    public final zzh f20616n;

    /* renamed from: o */
    public final boolean f20617o;

    /* renamed from: p */
    public int f20618p;

    /* renamed from: q */
    public int f20619q;

    /* renamed from: r */
    public final String f20620r;

    public zzw(zzi zziVar, long j, int i, String str, zzh zzhVar, boolean z2, int i2, int i3, String str2) {
        this.f20612j = zziVar;
        this.f20613k = j;
        this.f20614l = i;
        this.f20615m = str;
        this.f20616n = zzhVar;
        this.f20617o = z2;
        this.f20618p = i2;
        this.f20619q = i3;
        this.f20620r = str2;
    }

    public final String toString() {
        return String.format(Locale.US, "UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", this.f20612j, Long.valueOf(this.f20613k), Integer.valueOf(this.f20614l), Integer.valueOf(this.f20619q));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m570s2(parcel, 1, this.f20612j, i, false);
        long j = this.f20613k;
        parcel.writeInt(524290);
        parcel.writeLong(j);
        int i2 = this.f20614l;
        parcel.writeInt(262147);
        parcel.writeInt(i2);
        AnimatableValueParser.m574t2(parcel, 4, this.f20615m, false);
        AnimatableValueParser.m570s2(parcel, 5, this.f20616n, i, false);
        boolean z2 = this.f20617o;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.f20618p;
        parcel.writeInt(262151);
        parcel.writeInt(i3);
        int i4 = this.f20619q;
        parcel.writeInt(262152);
        parcel.writeInt(i4);
        AnimatableValueParser.m574t2(parcel, 9, this.f20620r, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
