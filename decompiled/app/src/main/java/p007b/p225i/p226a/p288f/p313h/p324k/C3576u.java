package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzi;
import com.google.android.gms.internal.icing.zzw;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* renamed from: b.i.a.f.h.k.u */
/* loaded from: classes3.dex */
public final class C3576u implements Parcelable.Creator<zzw> {
    @Override // android.os.Parcelable.Creator
    public final zzw createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        zzi zziVar = null;
        String strM468R = null;
        zzh zzhVar = null;
        String strM468R2 = null;
        long jM440H1 = 0;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        int iM437G12 = -1;
        int iM437G13 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    zziVar = (zzi) AnimatableValueParser.m465Q(parcel, i, zzi.CREATOR);
                    break;
                case 2:
                    jM440H1 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case 3:
                    iM437G1 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case 4:
                    strM468R = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 5:
                    zzhVar = (zzh) AnimatableValueParser.m465Q(parcel, i, zzh.CREATOR);
                    break;
                case 6:
                    zM431E1 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 7:
                    iM437G12 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case '\b':
                    iM437G13 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case '\t':
                    strM468R2 = AnimatableValueParser.m468R(parcel, i);
                    break;
                default:
                    AnimatableValueParser.m510d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzw(zziVar, jM440H1, iM437G1, strM468R, zzhVar, zM431E1, iM437G12, iM437G13, strM468R2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzw[] newArray(int i) {
        return new zzw[i];
    }
}
