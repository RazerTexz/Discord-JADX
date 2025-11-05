package b.i.a.d.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import b.i.a.a.b;
import b.i.a.a.c;

/* compiled from: IGetInstallReferrerService.java */
/* loaded from: classes3.dex */
public interface a extends IInterface {

    /* compiled from: IGetInstallReferrerService.java */
    /* renamed from: b.i.a.d.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0107a extends b implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: IGetInstallReferrerService.java */
        /* renamed from: b.i.a.d.a.a$a$a, reason: collision with other inner class name */
        public static class C0108a extends b.i.a.a.a implements a {
            public C0108a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // b.i.a.d.a.a
            public final Bundle B(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                int i = c.a;
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
                parcelObtain = Parcel.obtain();
                try {
                    this.a.transact(1, parcelObtain, parcelObtain, 0);
                    parcelObtain.readException();
                    parcelObtain.recycle();
                    return (Bundle) (parcelObtain.readInt() == 0 ? null : (Parcelable) Bundle.CREATOR.createFromParcel(parcelObtain));
                } catch (RuntimeException e) {
                    throw e;
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }

    Bundle B(Bundle bundle) throws RemoteException;
}
