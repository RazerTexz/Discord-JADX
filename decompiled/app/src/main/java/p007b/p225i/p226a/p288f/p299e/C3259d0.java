package p007b.p225i.p226a.p288f.p299e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzq;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.d0 */
/* loaded from: classes3.dex */
public final class C3259d0 implements Parcelable.Creator<zzq> {
    @Override // android.os.Parcelable.Creator
    public final zzq createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        boolean zM431E1 = false;
        String strM468R = null;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                zM431E1 = AnimatableValueParser.m431E1(parcel, i);
            } else if (c == 2) {
                strM468R = AnimatableValueParser.m468R(parcel, i);
            } else if (c != 3) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new zzq(zM431E1, strM468R, iM437G1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzq[] newArray(int i) {
        return new zzq[i];
    }
}
