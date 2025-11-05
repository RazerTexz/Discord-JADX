package b.i.a.f.j.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.Strategy;

/* loaded from: classes3.dex */
public final class j implements Parcelable.Creator<Strategy> {
    @Override // android.os.Parcelable.Creator
    public final Strategy createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        int iG1 = 0;
        int iG12 = 0;
        int iG13 = 0;
        int iG14 = 0;
        boolean zE1 = false;
        int iG15 = 0;
        int iG16 = 0;
        int iG17 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c != 1000) {
                switch (c) {
                    case 1:
                        iG12 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 2:
                        iG13 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 3:
                        iG14 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 4:
                        zE1 = b.c.a.a0.d.E1(parcel, i);
                        break;
                    case 5:
                        iG15 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 6:
                        iG16 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    case 7:
                        iG17 = b.c.a.a0.d.G1(parcel, i);
                        break;
                    default:
                        b.c.a.a0.d.d2(parcel, i);
                        break;
                }
            } else {
                iG1 = b.c.a.a0.d.G1(parcel, i);
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new Strategy(iG1, iG12, iG13, iG14, zE1, iG15, iG16, iG17);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Strategy[] newArray(int i) {
        return new Strategy[i];
    }
}
