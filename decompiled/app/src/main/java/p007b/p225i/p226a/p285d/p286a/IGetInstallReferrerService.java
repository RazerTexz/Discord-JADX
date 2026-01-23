package p007b.p225i.p226a.p285d.p286a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import p007b.p225i.p226a.p227a.BaseProxy;
import p007b.p225i.p226a.p227a.BaseStub;
import p007b.p225i.p226a.p227a.Codecs;

/* JADX INFO: renamed from: b.i.a.d.a.a, reason: use source file name */
/* JADX INFO: compiled from: IGetInstallReferrerService.java */
/* JADX INFO: loaded from: classes3.dex */
public interface IGetInstallReferrerService extends IInterface {

    /* JADX INFO: renamed from: b.i.a.d.a.a$a */
    /* JADX INFO: compiled from: IGetInstallReferrerService.java */
    public static abstract class a extends BaseStub implements IGetInstallReferrerService {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int f9162a = 0;

        /* JADX INFO: renamed from: b.i.a.d.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IGetInstallReferrerService.java */
        public static class C13227a extends BaseProxy implements IGetInstallReferrerService {
            public C13227a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // p007b.p225i.p226a.p285d.p286a.IGetInstallReferrerService
            /* JADX INFO: renamed from: B */
            public final Bundle mo3923B(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                int i = Codecs.f5115a;
                parcelObtain.writeInt(1);
                bundle.writeToParcel(parcelObtain, 0);
                parcelObtain = Parcel.obtain();
                try {
                    this.f5114a.transact(1, parcelObtain, parcelObtain, 0);
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

    /* JADX INFO: renamed from: B */
    Bundle mo3923B(Bundle bundle) throws RemoteException;
}
