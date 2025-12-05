package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p313h.p324k.C3570o;
import p007b.p225i.p226a.p288f.p313h.p324k.C3572q;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* loaded from: classes3.dex */
public final class zzk extends AbstractSafeParcelable {

    /* renamed from: k */
    public final String f20593k;

    /* renamed from: l */
    public final zzt f20594l;

    /* renamed from: m */
    public final int f20595m;

    /* renamed from: n */
    public final byte[] f20596n;

    /* renamed from: j */
    public static final int f20592j = Integer.parseInt("-1");
    public static final Parcelable.Creator<zzk> CREATOR = new C3570o();

    static {
        ArrayList arrayList = new ArrayList();
        new zzt("SsbContext", "blob", true, 1, false, null, (zzm[]) arrayList.toArray(new zzm[arrayList.size()]), null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzk(String str, zzt zztVar, int i, byte[] bArr) {
        boolean z2;
        int i2 = f20592j;
        String strM851g = null;
        if (i != i2) {
            String[] strArr = C3572q.f9837a;
            if (i >= 0) {
                String[] strArr2 = C3572q.f9837a;
                String str2 = i >= strArr2.length ? null : strArr2[i];
                z2 = str2 != null;
            }
        }
        StringBuilder sb = new StringBuilder(32);
        sb.append("Invalid section type ");
        sb.append(i);
        AnimatableValueParser.m551o(z2, sb.toString());
        this.f20593k = str;
        this.f20594l = zztVar;
        this.f20595m = i;
        this.f20596n = bArr;
        if (i != i2) {
            String[] strArr3 = C3572q.f9837a;
            if (i >= 0) {
                String[] strArr4 = C3572q.f9837a;
                String str3 = i >= strArr4.length ? null : strArr4[i];
                if (str3 == null) {
                    strM851g = outline.m851g(32, "Invalid section type ", i);
                } else if (str != null && bArr != null) {
                    strM851g = "Both content and blobContent set";
                }
            }
        }
        if (strM851g != null) {
            throw new IllegalArgumentException(strM851g);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 1, this.f20593k, false);
        AnimatableValueParser.m570s2(parcel, 3, this.f20594l, i, false);
        int i2 = this.f20595m;
        parcel.writeInt(262148);
        parcel.writeInt(i2);
        AnimatableValueParser.m562q2(parcel, 5, this.f20596n, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }
}
