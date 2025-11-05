package b.i.a.f.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class z9 implements Parcelable.Creator<zzn> {
    @Override // android.os.Parcelable.Creator
    public final zzn createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        long jH1 = 0;
        long jH12 = 0;
        long jH13 = 0;
        long jH14 = 0;
        long jH15 = 0;
        String strR = null;
        String strR2 = null;
        String strR3 = null;
        String strR4 = null;
        String strR5 = null;
        String strR6 = null;
        String strR7 = null;
        Boolean boolValueOf = null;
        ArrayList<String> arrayListT = null;
        String strR8 = null;
        long jH16 = -2147483648L;
        String strR9 = "";
        boolean zE1 = true;
        boolean zE12 = false;
        int iG1 = 0;
        boolean zE13 = true;
        boolean zE14 = true;
        boolean zE15 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case 3:
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 4:
                    strR3 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 5:
                    strR4 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 6:
                    jH1 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 7:
                    jH12 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case '\b':
                    strR5 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\t':
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case '\n':
                    zE12 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 11:
                    jH16 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case '\f':
                    strR6 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\r':
                    jH13 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 14:
                    jH14 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 15:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 16:
                    zE13 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 17:
                    zE14 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 18:
                    zE15 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 19:
                    strR7 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 20:
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
                case 21:
                    int iM1 = b.c.a.a0.d.M1(parcel, i);
                    if (iM1 != 0) {
                        b.c.a.a0.d.z2(parcel, i, iM1, 4);
                        boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                        break;
                    } else {
                        boolValueOf = null;
                        break;
                    }
                case 22:
                    jH15 = b.c.a.a0.d.H1(parcel, i);
                    break;
                case 23:
                    arrayListT = b.c.a.a0.d.T(parcel, i);
                    break;
                case 24:
                    strR8 = b.c.a.a0.d.R(parcel, i);
                    break;
                case 25:
                    strR9 = b.c.a.a0.d.R(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new zzn(strR, strR2, strR3, strR4, jH1, jH12, strR5, zE1, zE12, jH16, strR6, jH13, jH14, iG1, zE13, zE14, zE15, strR7, boolValueOf, jH15, arrayListT, strR8, strR9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzn[] newArray(int i) {
        return new zzn[i];
    }
}
