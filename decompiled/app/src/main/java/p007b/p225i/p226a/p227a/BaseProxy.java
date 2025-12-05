package p007b.p225i.p226a.p227a;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: BaseProxy.java */
/* renamed from: b.i.a.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public class BaseProxy implements IInterface {

    /* renamed from: a */
    public final IBinder f5114a;

    public BaseProxy(IBinder iBinder) {
        this.f5114a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f5114a;
    }
}
