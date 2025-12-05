package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;
import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.TransportContext;

/* compiled from: EventStore.java */
@WorkerThread
/* renamed from: b.i.a.b.j.t.i.c, reason: use source file name */
/* loaded from: classes3.dex */
public interface EventStore extends Closeable {
    @Nullable
    /* renamed from: a0 */
    PersistedEvent mo2394a0(TransportContext transportContext, EventInternal eventInternal);

    /* renamed from: h0 */
    long mo2395h0(TransportContext transportContext);

    /* renamed from: l */
    int mo2396l();

    /* renamed from: l0 */
    boolean mo2397l0(TransportContext transportContext);

    /* renamed from: m */
    void mo2398m(Iterable<PersistedEvent> iterable);

    /* renamed from: n0 */
    void mo2399n0(Iterable<PersistedEvent> iterable);

    /* renamed from: r */
    Iterable<PersistedEvent> mo2400r(TransportContext transportContext);

    /* renamed from: v */
    void mo2401v(TransportContext transportContext, long j);

    /* renamed from: z */
    Iterable<TransportContext> mo2402z();
}
