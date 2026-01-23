package p007b.p225i.p226a.p288f.p313h.p324k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzm;
import com.google.android.gms.internal.icing.zzt;
import com.google.android.gms.internal.icing.zzu;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.h.k.s */
/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3574s implements Parcelable.Creator<zzt> {
    @Override // android.os.Parcelable.Creator
    public final zzt createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        String strM468R3 = null;
        zzm[] zzmVarArr = null;
        String strM468R4 = null;
        zzu zzuVar = null;
        boolean zM431E1 = false;
        int iM437G1 = 1;
        boolean zM431E12 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 11) {
                strM468R4 = AnimatableValueParser.m468R(parcel, i);
            } else if (c != '\f') {
                switch (c) {
                    case 1:
                        strM468R = AnimatableValueParser.m468R(parcel, i);
                        break;
                    case 2:
                        strM468R2 = AnimatableValueParser.m468R(parcel, i);
                        break;
                    case 3:
                        zM431E1 = AnimatableValueParser.m431E1(parcel, i);
                        break;
                    case 4:
                        iM437G1 = AnimatableValueParser.m437G1(parcel, i);
                        break;
                    case 5:
                        zM431E12 = AnimatableValueParser.m431E1(parcel, i);
                        break;
                    case 6:
                        strM468R3 = AnimatableValueParser.m468R(parcel, i);
                        break;
                    case 7:
                        zzmVarArr = (zzm[]) AnimatableValueParser.m477U(parcel, i, zzm.CREATOR);
                        break;
                    default:
                        AnimatableValueParser.m510d2(parcel, i);
                        break;
                }
            } else {
                zzuVar = (zzu) AnimatableValueParser.m465Q(parcel, i, zzu.CREATOR);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzt(strM468R, strM468R2, zM431E1, iM437G1, zM431E12, strM468R3, zzmVarArr, strM468R4, zzuVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt[] newArray(int i) {
        return new zzt[i];
    }
}
