package p007b.p225i.p226a.p288f.p333j.p334b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.nearby.zzgs;
import com.google.android.gms.nearby.messages.Message;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* renamed from: b.i.a.f.j.b.f */
/* loaded from: classes3.dex */
public final class C4322f implements Parcelable.Creator<Message> {
    @Override // android.os.Parcelable.Creator
    public final Message createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        byte[] bArrM456N = null;
        String strM468R = null;
        String strM468R2 = null;
        zzgs[] zzgsVarArr = null;
        long jM440H1 = 0;
        int iM437G1 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            char c = (char) i;
            if (c == 1) {
                bArrM456N = AnimatableValueParser.m456N(parcel, i);
            } else if (c == 2) {
                strM468R2 = AnimatableValueParser.m468R(parcel, i);
            } else if (c == 3) {
                strM468R = AnimatableValueParser.m468R(parcel, i);
            } else if (c == 4) {
                zzgsVarArr = (zzgs[]) AnimatableValueParser.m477U(parcel, i, zzgs.CREATOR);
            } else if (c == 5) {
                jM440H1 = AnimatableValueParser.m440H1(parcel, i);
            } else if (c != 1000) {
                AnimatableValueParser.m510d2(parcel, i);
            } else {
                iM437G1 = AnimatableValueParser.m437G1(parcel, i);
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new Message(iM437G1, bArrM456N, strM468R, strM468R2, zzgsVarArr, jM440H1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Message[] newArray(int i) {
        return new Message[i];
    }
}
