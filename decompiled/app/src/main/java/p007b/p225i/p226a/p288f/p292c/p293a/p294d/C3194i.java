package p007b.p225i.p226a.p288f.p292c.p293a.p294d;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.IdToken;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.f.c.a.d.i */
/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3194i implements Parcelable.Creator<IdToken> {
    @Override // android.os.Parcelable.Creator
    public final IdToken createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                strM468R = AnimatableValueParser.m468R(parcel, i);
            } else if (c != 2) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                strM468R2 = AnimatableValueParser.m468R(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new IdToken(strM468R, strM468R2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ IdToken[] newArray(int i) {
        return new IdToken[i];
    }
}
