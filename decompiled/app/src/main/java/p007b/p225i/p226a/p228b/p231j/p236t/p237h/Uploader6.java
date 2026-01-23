package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p232q.AutoValue_BackendRequest;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendRegistry;
import p007b.p225i.p226a.p228b.p231j.p232q.BackendResponse;
import p007b.p225i.p226a.p228b.p231j.p232q.TransportBackend;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.PersistedEvent;
import p007b.p225i.p226a.p228b.p231j.p239u.SynchronizationGuard;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.l, reason: use source file name */
/* JADX INFO: compiled from: Uploader.java */
/* JADX INFO: loaded from: classes3.dex */
public class Uploader6 {

    /* JADX INFO: renamed from: a */
    public final Context f5385a;

    /* JADX INFO: renamed from: b */
    public final BackendRegistry f5386b;

    /* JADX INFO: renamed from: c */
    public final EventStore f5387c;

    /* JADX INFO: renamed from: d */
    public final WorkScheduler f5388d;

    /* JADX INFO: renamed from: e */
    public final Executor f5389e;

    /* JADX INFO: renamed from: f */
    public final SynchronizationGuard f5390f;

    /* JADX INFO: renamed from: g */
    public final Clock3 f5391g;

    public Uploader6(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock3 clock3) {
        this.f5385a = context;
        this.f5386b = backendRegistry;
        this.f5387c = eventStore;
        this.f5388d = workScheduler;
        this.f5389e = executor;
        this.f5390f = synchronizationGuard;
        this.f5391g = clock3;
    }

    /* JADX INFO: renamed from: a */
    public void m2385a(TransportContext transportContext, int i) {
        BackendResponse backendResponseMo2297a;
        TransportBackend transportBackend = this.f5386b.get(transportContext.mo2348b());
        Iterable iterable = (Iterable) this.f5390f.mo2406a(new Uploader2(this, transportContext));
        if (iterable.iterator().hasNext()) {
            if (transportBackend == null) {
                AnimatableValueParser.m486X("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                backendResponseMo2297a = BackendResponse.m2370a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((PersistedEvent) it.next()).mo2391a());
                }
                byte[] bArrMo2349c = transportContext.mo2349c();
                if (1 == 0) {
                    throw new IllegalStateException(outline.m883w("Missing required properties:", ""));
                }
                backendResponseMo2297a = transportBackend.mo2297a(new AutoValue_BackendRequest(arrayList, bArrMo2349c, null));
            }
            this.f5390f.mo2406a(new Uploader3(this, backendResponseMo2297a, iterable, transportContext, i));
        }
    }
}
