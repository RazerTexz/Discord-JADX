package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzn;
import java.util.ArrayList;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.i.b.z9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4262z9 implements Parcelable.Creator<zzn> {
    @Override // android.os.Parcelable.Creator
    public final zzn createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        long jM440H1 = 0;
        long jM440H12 = 0;
        long jM440H13 = 0;
        long jM440H14 = 0;
        long jM440H15 = 0;
        String strM468R = null;
        String strM468R2 = null;
        String strM468R3 = null;
        String strM468R4 = null;
        String strM468R5 = null;
        String strM468R6 = null;
        String strM468R7 = null;
        Boolean boolValueOf = null;
        ArrayList<String> arrayListM474T = null;
        String strM468R8 = null;
        long jM440H16 = -2147483648L;
        String strM468R9 = "";
        boolean zM431E1 = true;
        boolean zM431E12 = false;
        int iM437G1 = 0;
        boolean zM431E13 = true;
        boolean zM431E14 = true;
        boolean zM431E15 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 2:
                    strM468R = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 3:
                    strM468R2 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 4:
                    strM468R3 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 5:
                    strM468R4 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 6:
                    jM440H1 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case 7:
                    jM440H12 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case '\b':
                    strM468R5 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case '\t':
                    zM431E1 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case '\n':
                    zM431E12 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 11:
                    jM440H16 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case '\f':
                    strM468R6 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case '\r':
                    jM440H13 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case 14:
                    jM440H14 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case 15:
                    iM437G1 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case 16:
                    zM431E13 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 17:
                    zM431E14 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 18:
                    zM431E15 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 19:
                    strM468R7 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 20:
                default:
                    AnimatableValueParser.m510d2(parcel, i);
                    break;
                case 21:
                    int iM455M1 = AnimatableValueParser.m455M1(parcel, i);
                    if (iM455M1 != 0) {
                        AnimatableValueParser.m598z2(parcel, i, iM455M1, 4);
                        boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                    } else {
                        boolValueOf = null;
                    }
                    break;
                case 22:
                    jM440H15 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case 23:
                    arrayListM474T = AnimatableValueParser.m474T(parcel, i);
                    break;
                case 24:
                    strM468R8 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 25:
                    strM468R9 = AnimatableValueParser.m468R(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzn(strM468R, strM468R2, strM468R3, strM468R4, jM440H1, jM440H12, strM468R5, zM431E1, zM431E12, jM440H16, strM468R6, jM440H13, jM440H14, iM437G1, zM431E13, zM431E14, zM431E15, strM468R7, boolValueOf, jM440H15, arrayListM474T, strM468R8, strM468R9);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzn[] newArray(int i) {
        return new zzn[i];
    }
}
