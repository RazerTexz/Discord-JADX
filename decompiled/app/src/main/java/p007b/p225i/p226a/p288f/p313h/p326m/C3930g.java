package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.nearby.zzgu;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* renamed from: b.i.a.f.h.m.g */
/* loaded from: classes3.dex */
public final class C3930g implements Parcelable.Creator<zzgu> {
    @Override // android.os.Parcelable.Creator
    public final zzgu createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        int iM437G1 = 0;
        byte[] bArrM456N = null;
        int iM437G12 = 0;
        boolean zM431E1 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G12 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c == 2) {
                bArrM456N = AnimatableValueParser.m456N(parcel, i);
            } else if (c == 3) {
                zM431E1 = AnimatableValueParser.m431E1(parcel, i);
            } else if (c != 1000) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzgu(iM437G1, iM437G12, bArrM456N, zM431E1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgu[] newArray(int i) {
        return new zzgu[i];
    }
}
