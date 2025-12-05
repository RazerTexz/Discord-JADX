package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.e.h.j.s */
/* loaded from: classes3.dex */
public abstract class AbstractC3317s {

    /* renamed from: a */
    public final int f9447a;

    public AbstractC3317s(int i) {
        this.f9447a = i;
    }

    /* renamed from: a */
    public static Status m4114a(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    /* renamed from: b */
    public abstract void mo4072b(@NonNull Status status);

    /* renamed from: c */
    public abstract void mo4073c(C3293g.a<?> aVar) throws DeadObjectException;

    /* renamed from: d */
    public abstract void mo4113d(@NonNull C3328x0 c3328x0, boolean z2);

    /* renamed from: e */
    public abstract void mo4074e(@NonNull Exception exc);
}
