package p007b.p225i.p226a.p288f.p336k;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.safetynet.zza;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.k.b */
/* JADX INFO: loaded from: classes3.dex */
public final class C4328b implements Parcelable.Creator<zza> {
    @Override // android.os.Parcelable.Creator
    public final zza createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        String strM468R = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            if (((char) i) != 2) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                strM468R = AnimatableValueParser.m468R(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zza(strM468R);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
