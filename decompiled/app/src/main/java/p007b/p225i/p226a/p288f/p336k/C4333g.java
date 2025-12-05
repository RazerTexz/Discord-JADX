package p007b.p225i.p226a.p288f.p336k;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.safetynet.SafeBrowsingData;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* renamed from: b.i.a.f.k.g */
/* loaded from: classes3.dex */
public final class C4333g implements Parcelable.Creator<SafeBrowsingData> {
    /* renamed from: a */
    public static void m5997a(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int iM594y2 = AnimatableValueParser.m594y2(parcel, 20293);
        AnimatableValueParser.m574t2(parcel, 2, safeBrowsingData.f20821j, false);
        AnimatableValueParser.m570s2(parcel, 3, safeBrowsingData.f20822k, i, false);
        AnimatableValueParser.m570s2(parcel, 4, safeBrowsingData.f20823l, i, false);
        long j = safeBrowsingData.f20824m;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        AnimatableValueParser.m562q2(parcel, 6, safeBrowsingData.f20825n, false);
        AnimatableValueParser.m418A2(parcel, iM594y2);
    }

    @Override // android.os.Parcelable.Creator
    public final SafeBrowsingData createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        String strM468R = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArrM456N = null;
        long jM440H1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 2) {
                strM468R = AnimatableValueParser.m468R(parcel, i);
            } else if (c == 3) {
                dataHolder = (DataHolder) AnimatableValueParser.m465Q(parcel, i, DataHolder.CREATOR);
            } else if (c == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) AnimatableValueParser.m465Q(parcel, i, ParcelFileDescriptor.CREATOR);
            } else if (c == 5) {
                jM440H1 = AnimatableValueParser.m440H1(parcel, i);
            } else if (c != 6) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                bArrM456N = AnimatableValueParser.m456N(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new SafeBrowsingData(strM468R, dataHolder, parcelFileDescriptor, jM440H1, bArrM456N);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData[] newArray(int i) {
        return new SafeBrowsingData[i];
    }
}
