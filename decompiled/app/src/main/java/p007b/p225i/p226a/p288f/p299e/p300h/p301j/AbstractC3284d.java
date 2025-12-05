package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3268c;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a.b;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;
import p007b.p225i.p226a.p288f.p299e.p304k.C3391y;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.e.h.j.d */
/* loaded from: classes3.dex */
public abstract class AbstractC3284d<R extends InterfaceC3273h, A extends C3266a.b> extends BasePendingResult<R> implements InterfaceC3287e<R> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC3284d(@NonNull C3266a<?> c3266a, @NonNull AbstractC3268c abstractC3268c) {
        super(abstractC3268c);
        AnimatableValueParser.m595z(abstractC3268c, "GoogleApiClient must not be null");
        AnimatableValueParser.m595z(c3266a, "Api must not be null");
        if (c3266a.f9324b == null) {
            throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3287e
    /* renamed from: a */
    public final void mo4067a(@NonNull Status status) {
        AnimatableValueParser.m551o(!status.m9030w0(), "Failed result must not be success");
        m9035g(mo3987d(status));
    }

    /* renamed from: k */
    public abstract void mo3988k(@NonNull A a) throws RemoteException;

    /* renamed from: l */
    public final void m4068l(@NonNull A a) throws DeadObjectException {
        if (a instanceof C3391y) {
            throw new NoSuchMethodError();
        }
        try {
            mo3988k(a);
        } catch (DeadObjectException e) {
            mo4067a(new Status(8, e.getLocalizedMessage(), null));
            throw e;
        } catch (RemoteException e2) {
            mo4067a(new Status(8, e2.getLocalizedMessage(), null));
        }
    }
}
