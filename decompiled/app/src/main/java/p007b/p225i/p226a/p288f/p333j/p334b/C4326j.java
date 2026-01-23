package p007b.p225i.p226a.p288f.p333j.p334b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.Strategy;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.j.b.j */
/* JADX INFO: loaded from: classes3.dex */
public final class C4326j implements Parcelable.Creator<Strategy> {
    @Override // android.os.Parcelable.Creator
    public final Strategy createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        int iM437G1 = 0;
        int iM437G12 = 0;
        int iM437G13 = 0;
        int iM437G14 = 0;
        boolean zM431E1 = false;
        int iM437G15 = 0;
        int iM437G16 = 0;
        int iM437G17 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c != 1000) {
                switch (c) {
                    case 1:
                        iM437G12 = AnimatableValueParser.m437G1(parcel, i);
                        break;
                    case 2:
                        iM437G13 = AnimatableValueParser.m437G1(parcel, i);
                        break;
                    case 3:
                        iM437G14 = AnimatableValueParser.m437G1(parcel, i);
                        break;
                    case 4:
                        zM431E1 = AnimatableValueParser.m431E1(parcel, i);
                        break;
                    case 5:
                        iM437G15 = AnimatableValueParser.m437G1(parcel, i);
                        break;
                    case 6:
                        iM437G16 = AnimatableValueParser.m437G1(parcel, i);
                        break;
                    case 7:
                        iM437G17 = AnimatableValueParser.m437G1(parcel, i);
                        break;
                    default:
                        AnimatableValueParser.m510d2(parcel, i);
                        break;
                }
            } else {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new Strategy(iM437G1, iM437G12, iM437G13, iM437G14, zM431E1, iM437G15, iM437G16, iM437G17);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
