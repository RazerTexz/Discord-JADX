package p007b.p225i.p226a.p288f.p299e;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.e.q */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3412q implements Parcelable.Creator<ConnectionResult> {
    @Override // android.os.Parcelable.Creator
    public final ConnectionResult createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        int iM437G1 = 0;
        PendingIntent pendingIntent = null;
        String strM468R = null;
        int iM437G12 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c == 2) {
                iM437G12 = AnimatableValueParser.m437G1(parcel, i);
            } else if (c == 3) {
                pendingIntent = (PendingIntent) AnimatableValueParser.m465Q(parcel, i, PendingIntent.CREATOR);
            } else if (c != 4) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                strM468R = AnimatableValueParser.m468R(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new ConnectionResult(iM437G1, iM437G12, pendingIntent, strM468R);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
