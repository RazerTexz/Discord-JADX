package b.n.a.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: ISAService.java */
/* loaded from: classes3.dex */
public interface b extends IInterface {

    /* compiled from: ISAService.java */
    public static abstract class a extends Binder implements b {
        public static final /* synthetic */ int a = 0;

        /* compiled from: ISAService.java */
        /* renamed from: b.n.a.a.b$a$a, reason: collision with other inner class name */
        public static class C0165a implements b {
            public IBinder a;

            public C0165a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // b.n.a.a.b
            public String Q(String str, String str2, String str3, b.n.a.a.a aVar) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.msc.sa.aidl.ISAService");
                    parcelObtain.writeString(str);
                    parcelObtain.writeString(str2);
                    parcelObtain.writeString(str3);
                    parcelObtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (!this.a.transact(1, parcelObtain, parcelObtain2, 0)) {
                        int i = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // b.n.a.a.b
            public boolean h0(int i, String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.msc.sa.aidl.ISAService");
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(1);
                    bundle.writeToParcel(parcelObtain, 0);
                    if (!this.a.transact(6, parcelObtain, parcelObtain2, 0)) {
                        int i2 = a.a;
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }
    }

    String Q(String str, String str2, String str3, b.n.a.a.a aVar) throws RemoteException;

    boolean h0(int i, String str, Bundle bundle) throws RemoteException;
}
