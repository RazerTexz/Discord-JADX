package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p330i.p332b.C4075ia;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new C4075ia();

    /* renamed from: j */
    public String f20700j;

    /* renamed from: k */
    public String f20701k;

    /* renamed from: l */
    public zzku f20702l;

    /* renamed from: m */
    public long f20703m;

    /* renamed from: n */
    public boolean f20704n;

    /* renamed from: o */
    public String f20705o;

    /* renamed from: p */
    public zzaq f20706p;

    /* renamed from: q */
    public long f20707q;

    /* renamed from: r */
    public zzaq f20708r;

    /* renamed from: s */
    public long f20709s;

    /* renamed from: t */
    public zzaq f20710t;

    public zzz(zzz zzzVar) {
        this.f20700j = zzzVar.f20700j;
        this.f20701k = zzzVar.f20701k;
        this.f20702l = zzzVar.f20702l;
        this.f20703m = zzzVar.f20703m;
        this.f20704n = zzzVar.f20704n;
        this.f20705o = zzzVar.f20705o;
        this.f20706p = zzzVar.f20706p;
        this.f20707q = zzzVar.f20707q;
        this.f20708r = zzzVar.f20708r;
        this.f20709s = zzzVar.f20709s;
        this.f20710t = zzzVar.f20710t;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 2, this.f20700j, false);
        AnimatableValueParser.m574t2(parcel, 3, this.f20701k, false);
        AnimatableValueParser.m570s2(parcel, 4, this.f20702l, i, false);
        long j = this.f20703m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        boolean z2 = this.f20704n;
        parcel.writeInt(262150);
        parcel.writeInt(z2 ? 1 : 0);
        AnimatableValueParser.m574t2(parcel, 7, this.f20705o, false);
        AnimatableValueParser.m570s2(parcel, 8, this.f20706p, i, false);
        long j2 = this.f20707q;
        parcel.writeInt(524297);
        parcel.writeLong(j2);
        AnimatableValueParser.m570s2(parcel, 10, this.f20708r, i, false);
        long j3 = this.f20709s;
        parcel.writeInt(524299);
        parcel.writeLong(j3);
        AnimatableValueParser.m570s2(parcel, 12, this.f20710t, i, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }

    public zzz(String str, String str2, zzku zzkuVar, long j, boolean z2, String str3, zzaq zzaqVar, long j2, zzaq zzaqVar2, long j3, zzaq zzaqVar3) {
        this.f20700j = str;
        this.f20701k = str2;
        this.f20702l = zzkuVar;
        this.f20703m = j;
        this.f20704n = z2;
        this.f20705o = str3;
        this.f20706p = zzaqVar;
        this.f20707q = j2;
        this.f20708r = zzaqVar2;
        this.f20709s = j3;
        this.f20710t = zzaqVar3;
    }
}
