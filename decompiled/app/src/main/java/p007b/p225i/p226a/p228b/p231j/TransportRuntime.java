package p007b.p225i.p226a.p228b.p231j;

import android.content.Context;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.TransportFactory;
import p007b.p225i.p226a.p228b.p229i.CCTDestination;
import p007b.p225i.p226a.p228b.p231j.AutoValue_TransportContext;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.Scheduler2;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.Uploader6;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkInitializer;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkInitializer3;
import p007b.p225i.p226a.p228b.p231j.p240v.Clock3;

/* compiled from: TransportRuntime.java */
/* renamed from: b.i.a.b.j.n, reason: use source file name */
/* loaded from: classes3.dex */
public class TransportRuntime implements TransportInternal {

    /* renamed from: a */
    public static volatile TransportRuntimeComponent f5290a;

    /* renamed from: b */
    public final Clock3 f5291b;

    /* renamed from: c */
    public final Clock3 f5292c;

    /* renamed from: d */
    public final Scheduler2 f5293d;

    /* renamed from: e */
    public final Uploader6 f5294e;

    public TransportRuntime(Clock3 clock3, Clock3 clock32, Scheduler2 scheduler2, Uploader6 uploader6, WorkInitializer3 workInitializer3) {
        this.f5291b = clock3;
        this.f5292c = clock32;
        this.f5293d = scheduler2;
        this.f5294e = uploader6;
        workInitializer3.f5401a.execute(new WorkInitializer(workInitializer3));
    }

    /* renamed from: a */
    public static TransportRuntime m2359a() {
        TransportRuntimeComponent transportRuntimeComponent = f5290a;
        if (transportRuntimeComponent != null) {
            return ((DaggerTransportRuntimeComponent) transportRuntimeComponent).f5275u.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    /* renamed from: b */
    public static void m2360b(Context context) {
        if (f5290a == null) {
            synchronized (TransportRuntime.class) {
                if (f5290a == null) {
                    Objects.requireNonNull(context);
                    f5290a = new DaggerTransportRuntimeComponent(context, null);
                }
            }
        }
    }

    /* renamed from: c */
    public TransportFactory m2361c(EncodedDestination encodedDestination) {
        Set setSingleton;
        if (encodedDestination instanceof EncodedDestination) {
            Objects.requireNonNull((CCTDestination) encodedDestination);
            setSingleton = Collections.unmodifiableSet(CCTDestination.f5126d);
        } else {
            setSingleton = Collections.singleton(new Encoding2("proto"));
        }
        TransportContext.a aVarM2358a = TransportContext.m2358a();
        Objects.requireNonNull(encodedDestination);
        aVarM2358a.mo2352b("cct");
        AutoValue_TransportContext.b bVar = (AutoValue_TransportContext.b) aVarM2358a;
        bVar.f5262b = ((CCTDestination) encodedDestination).m2294b();
        return new TransportFactoryImpl(setSingleton, bVar.mo2351a(), this);
    }
}
