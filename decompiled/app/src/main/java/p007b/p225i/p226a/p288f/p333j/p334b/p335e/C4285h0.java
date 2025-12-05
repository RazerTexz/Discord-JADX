package p007b.p225i.p226a.p288f.p333j.p334b.p335e;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* renamed from: b.i.a.f.j.b.e.h0 */
/* loaded from: classes3.dex */
public final class C4285h0 implements Parcelable.Creator<SubscribeRequest> {
    @Override // android.os.Parcelable.Creator
    public final SubscribeRequest createFromParcel(Parcel parcel) {
        int iM546m2 = AnimatableValueParser.m546m2(parcel);
        IBinder iBinderM434F1 = null;
        Strategy strategy = null;
        IBinder iBinderM434F12 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        String strM468R = null;
        String strM468R2 = null;
        byte[] bArrM456N = null;
        IBinder iBinderM434F13 = null;
        ClientAppContext clientAppContext = null;
        int iM437G1 = 0;
        int iM437G12 = 0;
        boolean zM431E1 = false;
        boolean zM431E12 = false;
        boolean zM431E13 = false;
        int iM437G13 = 0;
        int iM437G14 = 0;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case 2:
                    iBinderM434F1 = AnimatableValueParser.m434F1(parcel, i);
                    break;
                case 3:
                    strategy = (Strategy) AnimatableValueParser.m465Q(parcel, i, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderM434F12 = AnimatableValueParser.m434F1(parcel, i);
                    break;
                case 5:
                    messageFilter = (MessageFilter) AnimatableValueParser.m465Q(parcel, i, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) AnimatableValueParser.m465Q(parcel, i, PendingIntent.CREATOR);
                    break;
                case 7:
                    iM437G12 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case '\b':
                    strM468R = AnimatableValueParser.m468R(parcel, i);
                    break;
                case '\t':
                    strM468R2 = AnimatableValueParser.m468R(parcel, i);
                    break;
                case '\n':
                    bArrM456N = AnimatableValueParser.m456N(parcel, i);
                    break;
                case 11:
                    zM431E1 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case '\f':
                    iBinderM434F13 = AnimatableValueParser.m434F1(parcel, i);
                    break;
                case '\r':
                    zM431E12 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) AnimatableValueParser.m465Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                case 15:
                    zM431E13 = AnimatableValueParser.m431E1(parcel, i);
                    break;
                case 16:
                    iM437G13 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                case 17:
                    iM437G14 = AnimatableValueParser.m437G1(parcel, i);
                    break;
                default:
                    AnimatableValueParser.m510d2(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.m516f0(parcel, iM546m2);
        return new SubscribeRequest(iM437G1, iBinderM434F1, strategy, iBinderM434F12, messageFilter, pendingIntent, iM437G12, strM468R, strM468R2, bArrM456N, zM431E1, iBinderM434F13, zM431E12, clientAppContext, zM431E13, iM437G13, iM437G14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
