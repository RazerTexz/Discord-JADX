package p007b.p225i.p226a.p288f.p313h.p326m;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.internal.nearby.zzgp;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* renamed from: b.i.a.f.h.m.d */
/* loaded from: classes3.dex */
public final class C3927d implements Parcelable.Creator<zzgp> {
    @Override // android.os.Parcelable.Creator
    public final zzgp createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        ParcelUuid parcelUuid = null;
        ParcelUuid parcelUuid2 = null;
        ParcelUuid parcelUuid3 = null;
        byte[] bArrM456N = null;
        byte[] bArrM456N2 = null;
        byte[] bArrM456N3 = null;
        byte[] bArrM456N4 = null;
        int iM437G1 = 0;
        int iM437G12 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c != 1) {
                switch (c) {
                    case 4:
                        parcelUuid = (ParcelUuid) AnimatableValueParser.m465Q(parcel, i, ParcelUuid.CREATOR);
                        break;
                    case 5:
                        parcelUuid2 = (ParcelUuid) AnimatableValueParser.m465Q(parcel, i, ParcelUuid.CREATOR);
                        break;
                    case 6:
                        parcelUuid3 = (ParcelUuid) AnimatableValueParser.m465Q(parcel, i, ParcelUuid.CREATOR);
                        break;
                    case 7:
                        bArrM456N = AnimatableValueParser.m456N(parcel, i);
                        break;
                    case '\b':
                        bArrM456N2 = AnimatableValueParser.m456N(parcel, i);
                        break;
                    case '\t':
                        iM437G12 = AnimatableValueParser.m437G1(parcel, i);
                        break;
                    case '\n':
                        bArrM456N3 = AnimatableValueParser.m456N(parcel, i);
                        break;
                    case 11:
                        bArrM456N4 = AnimatableValueParser.m456N(parcel, i);
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
        return new zzgp(iM437G1, parcelUuid, parcelUuid2, parcelUuid3, bArrM456N, bArrM456N2, iM437G12, bArrM456N3, bArrM456N4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzgp[] newArray(int i) {
        return new zzgp[i];
    }
}
