package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzku;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.i.b.s9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4185s9 implements Parcelable.Creator<zzku> {
    @Override // android.os.Parcelable.Creator
    public final zzku createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        String strM468R = null;
        Long lValueOf = null;
        Float fValueOf = null;
        String strM468R2 = null;
        String strM468R3 = null;
        Double dValueOf = null;
        long jM440H1 = 0;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case 2:
                    strM468R = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 3:
                    jM440H1 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case 4:
                    int iM455M1 = AnimatableValueParser.m455M1(parcel, i);
                    if (iM455M1 != 0) {
                        AnimatableValueParser.m598z2(parcel, i, iM455M1, 8);
                        lValueOf = Long.valueOf(parcel.readLong());
                    } else {
                        lValueOf = null;
                    }
                    break;
                case 5:
                    int iM455M12 = AnimatableValueParser.m455M1(parcel, i);
                    if (iM455M12 != 0) {
                        AnimatableValueParser.m598z2(parcel, i, iM455M12, 4);
                        fValueOf = Float.valueOf(parcel.readFloat());
                    } else {
                        fValueOf = null;
                    }
                    break;
                case 6:
                    strM468R2 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 7:
                    strM468R3 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case '\b':
                    int iM455M13 = AnimatableValueParser.m455M1(parcel, i);
                    if (iM455M13 != 0) {
                        AnimatableValueParser.m598z2(parcel, i, iM455M13, 8);
                        dValueOf = Double.valueOf(parcel.readDouble());
                    } else {
                        dValueOf = null;
                    }
                    break;
                default:
                    AnimatableValueParser.m510d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzku(iM437G1, strM468R, jM440H1, lValueOf, fValueOf, strM468R2, strM468R3, dValueOf);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzku[] newArray(int i) {
        return new zzku[i];
    }
}
