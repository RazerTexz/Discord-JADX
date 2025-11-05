package b.i.c.k.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.appindexing.internal.zzc;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* loaded from: classes3.dex */
public final class f implements Parcelable.Creator<zzc> {
    @Override // android.os.Parcelable.Creator
    public final zzc createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        String strR = null;
        String strR2 = null;
        byte[] bArrN = null;
        int iG1 = 0;
        boolean zE1 = false;
        boolean zE12 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 2:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 3:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 4:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 5:
                    bArrN = b.c.a.a0.d.N(parcel, i);
                    break;
                case 6:
                    zE12 = b.c.a.a0.d.E1(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzc(iG1, zE1, strR, strR2, bArrN, zE12);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzc[] newArray(int i) {
        return new zzc[i];
    }
}
