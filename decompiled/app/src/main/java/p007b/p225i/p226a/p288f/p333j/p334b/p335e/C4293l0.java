package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* renamed from: b.i.a.f.j.b.e.l0 */
/* loaded from: classes3.dex */
public final class C4293l0 implements Parcelable.Creator<ClientAppContext> {
    @Override // android.os.Parcelable.Creator
    public final ClientAppContext createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        String strM468R = null;
        String strM468R2 = null;
        String strM468R3 = null;
        int iM437G1 = 0;
        boolean zM431E1 = false;
        int iM437G12 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case 2:
                    strM468R = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 3:
                    strM468R2 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case 4:
                    zM431E1 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 5:
                    iM437G12 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case 6:
                    strM468R3 = AnimatableValueParser.m468R(parcel, i);
                    break;
                default:
                    AnimatableValueParser.m510d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new ClientAppContext(iM437G1, strM468R, strM468R2, zM431E1, iM437G12, strM468R3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ClientAppContext[] newArray(int i) {
        return new ClientAppContext[i];
    }
}
