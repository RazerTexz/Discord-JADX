package p007b.p225i.p226a.p288f.p336k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.zzd;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* renamed from: b.i.a.f.k.d */
/* loaded from: classes3.dex */
public final class C4330d implements Parcelable.Creator<zzd> {
    @Override // android.os.Parcelable.Creator
    public final zzd createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        long jM440H1 = 0;
        HarmfulAppsData[] harmfulAppsDataArr = null;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                jM440H1 = AnimatableValueParser.m440H1(parcel, i);
            } else if (c == 3) {
                harmfulAppsDataArr = (HarmfulAppsData[]) AnimatableValueParser.m477U(parcel, i, HarmfulAppsData.CREATOR);
            } else if (c == 4) {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c != 5) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                zM431E1 = AnimatableValueParser.m431E1(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzd(jM440H1, harmfulAppsDataArr, iM437G1, zM431E1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i) {
        return new zzd[i];
    }
}
