package b.i.a.f.j.b.e;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.ClientAppContext;
import com.google.android.gms.nearby.messages.internal.SubscribeRequest;

/* loaded from: classes3.dex */
public final class h0 implements Parcelable.Creator<SubscribeRequest> {
    @Override // android.os.Parcelable.Creator
    public final SubscribeRequest createFromParcel(Parcel parcel) {
        int iM2 = b.c.a.a0.d.m2(parcel);
        IBinder iBinderF1 = null;
        Strategy strategy = null;
        IBinder iBinderF12 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        String strR = null;
        String strR2 = null;
        byte[] bArrN = null;
        IBinder iBinderF13 = null;
        ClientAppContext clientAppContext = null;
        int iG1 = 0;
        int iG12 = 0;
        boolean zE1 = false;
        boolean zE12 = false;
        boolean zE13 = false;
        int iG13 = 0;
        int iG14 = 0;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 2:
                    iBinderF1 = b.c.a.a0.d.F1(parcel, i);
                    break;
                case 3:
                    strategy = (Strategy) b.c.a.a0.d.Q(parcel, i, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderF12 = b.c.a.a0.d.F1(parcel, i);
                    break;
                case 5:
                    messageFilter = (MessageFilter) b.c.a.a0.d.Q(parcel, i, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) b.c.a.a0.d.Q(parcel, i, PendingIntent.CREATOR);
                    break;
                case 7:
                    iG12 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case '\b':
                    strR = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\t':
                    strR2 = b.c.a.a0.d.R(parcel, i);
                    break;
                case '\n':
                    bArrN = b.c.a.a0.d.N(parcel, i);
                    break;
                case 11:
                    zE1 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case '\f':
                    iBinderF13 = b.c.a.a0.d.F1(parcel, i);
                    break;
                case '\r':
                    zE12 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) b.c.a.a0.d.Q(parcel, i, ClientAppContext.CREATOR);
                    break;
                case 15:
                    zE13 = b.c.a.a0.d.E1(parcel, i);
                    break;
                case 16:
                    iG13 = b.c.a.a0.d.G1(parcel, i);
                    break;
                case 17:
                    iG14 = b.c.a.a0.d.G1(parcel, i);
                    break;
                default:
                    b.c.a.a0.d.d2(parcel, i);
                    break;
            }
        }
        b.c.a.a0.d.f0(parcel, iM2);
        return new SubscribeRequest(iG1, iBinderF1, strategy, iBinderF12, messageFilter, pendingIntent, iG12, strR, strR2, bArrN, zE1, iBinderF13, zE12, clientAppContext, zE13, iG13, iG14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
