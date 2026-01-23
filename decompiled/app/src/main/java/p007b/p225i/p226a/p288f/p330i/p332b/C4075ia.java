package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzz;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.i.b.ia */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4075ia implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final zzz createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        long jM440H1 = 0;
        long jM440H12 = 0;
        long jM440H13 = 0;
        String strM468R = null;
        String strM468R2 = null;
        zzku zzkuVar = null;
        String strM468R3 = null;
        zzaq zzaqVar = null;
        zzaq zzaqVar2 = null;
        zzaq zzaqVar3 = null;
        boolean zM431E1 = false;
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
                    zzkuVar = (zzku) AnimatableValueParser.m465Q(parcel, i, zzku.CREATOR);
                    break;
                case 5:
                    jM440H1 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case 6:
                    zM431E1 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 7:
                    strM468R3 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case '\b':
                    zzaqVar = (zzaq) AnimatableValueParser.m465Q(parcel, i, zzaq.CREATOR);
                    break;
                case '\t':
                    jM440H12 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case '\n':
                    zzaqVar2 = (zzaq) AnimatableValueParser.m465Q(parcel, i, zzaq.CREATOR);
                    break;
                case 11:
                    jM440H13 = AnimatableValueParser.m440H1(parcel, i);
                    break;
                case '\f':
                    zzaqVar3 = (zzaq) AnimatableValueParser.m465Q(parcel, i, zzaq.CREATOR);
                    break;
                default:
                    AnimatableValueParser.m510d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzz(strM468R, strM468R2, zzkuVar, jM440H1, zM431E1, strM468R3, zzaqVar, jM440H12, zzaqVar2, jM440H13, zzaqVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
