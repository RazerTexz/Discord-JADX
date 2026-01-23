package p007b.p225i.p226a.p288f.p337l.p338b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.signin.internal.zab;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.l.b.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4337b implements Parcelable.Creator<zab> {
    @Override // android.os.Parcelable.Creator
    public final zab createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        int iM437G1 = 0;
        Intent intent = null;
        int iM437G12 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c == 2) {
                iM437G12 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c != 3) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                intent = (Intent) AnimatableValueParser.m465Q(parcel, i, Intent.CREATOR);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zab(iM437G1, iM437G12, intent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zab[] newArray(int i) {
        return new zab[i];
    }
}
