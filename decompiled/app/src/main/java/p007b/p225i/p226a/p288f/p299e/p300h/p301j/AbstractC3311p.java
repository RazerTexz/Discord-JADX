package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a.b;
import p007b.p225i.p226a.p288f.p313h.p315b.C3450j;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.e.h.j.p */
/* loaded from: classes3.dex */
public abstract class AbstractC3311p<A extends C3266a.b, ResultT> {

    /* renamed from: a */
    @Nullable
    public final Feature[] f9438a;

    /* renamed from: b */
    public final boolean f9439b;

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.h.j.p$a */
    public static class a<A extends C3266a.b, ResultT> {

        /* renamed from: a */
        public C3450j<A, TaskCompletionSource<ResultT>> f9440a;

        /* renamed from: b */
        public Feature[] f9441b;

        public a(C3300j0 c3300j0) {
        }
    }

    @Deprecated
    public AbstractC3311p() {
        this.f9438a = null;
        this.f9439b = false;
    }

    /* renamed from: c */
    public abstract void mo4109c(A a2, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    public AbstractC3311p(Feature[] featureArr, boolean z2, C3300j0 c3300j0) {
        this.f9438a = featureArr;
        this.f9439b = z2;
    }
}
