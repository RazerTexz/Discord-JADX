package b.i.a.a;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: BaseProxy.java */
/* loaded from: classes3.dex */
public class a implements IInterface {
    public final IBinder a;

    public a(IBinder iBinder) {
        this.a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }
}
