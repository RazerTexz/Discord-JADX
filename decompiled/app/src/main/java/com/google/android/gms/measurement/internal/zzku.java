package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p330i.p332b.C4185s9;
import p007b.p225i.p226a.p288f.p330i.p332b.C4207u9;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzku extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzku> CREATOR = new C4185s9();

    /* renamed from: j */
    public final int f20670j;

    /* renamed from: k */
    public final String f20671k;

    /* renamed from: l */
    public final long f20672l;

    /* renamed from: m */
    public final Long f20673m;

    /* renamed from: n */
    public final String f20674n;

    /* renamed from: o */
    public final String f20675o;

    /* renamed from: p */
    public final Double f20676p;

    public zzku(C4207u9 c4207u9) {
        this(c4207u9.f11292c, c4207u9.f11293d, c4207u9.f11294e, c4207u9.f11291b);
    }

    /* renamed from: w0 */
    public final Object m9117w0() {
        Long l = this.f20673m;
        if (l != null) {
            return l;
        }
        Double d = this.f20676p;
        if (d != null) {
            return d;
        }
        String str = this.f20674n;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        int i2 = this.f20670j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        AnimatableValueParser.m574t2(parcel, 2, this.f20671k, false);
        long j = this.f20672l;
        parcel.writeInt(524291);
        parcel.writeLong(j);
        Long l = this.f20673m;
        if (l != null) {
            parcel.writeInt(524292);
            parcel.writeLong(l.longValue());
        }
        AnimatableValueParser.m574t2(parcel, 6, this.f20674n, false);
        AnimatableValueParser.m574t2(parcel, 7, this.f20675o, false);
        Double d = this.f20676p;
        if (d != null) {
            parcel.writeInt(524296);
            parcel.writeDouble(d.doubleValue());
        }
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }

    public zzku(String str, long j, Object obj, String str2) {
        AnimatableValueParser.m583w(str);
        this.f20670j = 2;
        this.f20671k = str;
        this.f20672l = j;
        this.f20675o = str2;
        if (obj == null) {
            this.f20673m = null;
            this.f20676p = null;
            this.f20674n = null;
            return;
        }
        if (obj instanceof Long) {
            this.f20673m = (Long) obj;
            this.f20676p = null;
            this.f20674n = null;
        } else if (obj instanceof String) {
            this.f20673m = null;
            this.f20676p = null;
            this.f20674n = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f20673m = null;
            this.f20676p = (Double) obj;
            this.f20674n = null;
        }
    }

    public zzku(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.f20670j = i;
        this.f20671k = str;
        this.f20672l = j;
        this.f20673m = l;
        if (i == 1) {
            this.f20676p = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.f20676p = d;
        }
        this.f20674n = str2;
        this.f20675o = str3;
    }
}
