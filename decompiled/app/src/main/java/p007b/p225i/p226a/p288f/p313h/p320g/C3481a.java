package p007b.p225i.p226a.p288f.p313h.p320g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.h.g.a */
/* loaded from: classes3.dex */
public class C3481a implements IInterface {

    /* renamed from: a */
    public final IBinder f9648a;

    /* renamed from: b */
    public final String f9649b;

    public C3481a(IBinder iBinder, String str) {
        this.f9648a = iBinder;
        this.f9649b = str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9648a;
    }

    /* renamed from: c */
    public final Parcel m4407c(int i, Parcel parcel) throws RemoteException {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f9648a.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    /* renamed from: g */
    public final Parcel m4408g() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9649b);
        return parcelObtain;
    }
}
