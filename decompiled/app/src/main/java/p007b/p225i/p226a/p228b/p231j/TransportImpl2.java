package p007b.p225i.p226a.p228b.p231j;

import java.util.HashMap;
import java.util.Objects;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.Event2;
import p007b.p225i.p226a.p228b.Priority3;
import p007b.p225i.p226a.p228b.Transformer;
import p007b.p225i.p226a.p228b.Transport2;
import p007b.p225i.p226a.p228b.TransportScheduleCallback;
import p007b.p225i.p226a.p228b.p231j.AutoValue_EventInternal;
import p007b.p225i.p226a.p228b.p231j.AutoValue_TransportContext;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.Scheduler2;

/* compiled from: TransportImpl.java */
/* renamed from: b.i.a.b.j.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class TransportImpl2<T> implements Transport2<T> {

    /* renamed from: a */
    public final TransportContext f5285a;

    /* renamed from: b */
    public final String f5286b;

    /* renamed from: c */
    public final Encoding2 f5287c;

    /* renamed from: d */
    public final Transformer<T, byte[]> f5288d;

    /* renamed from: e */
    public final TransportInternal f5289e;

    public TransportImpl2(TransportContext transportContext, String str, Encoding2 encoding2, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.f5285a = transportContext;
        this.f5286b = str;
        this.f5287c = encoding2;
        this.f5288d = transformer;
        this.f5289e = transportInternal;
    }

    @Override // p007b.p225i.p226a.p228b.Transport2
    /* renamed from: a */
    public void mo2289a(Event2<T> event2) {
        mo2290b(event2, TransportImpl.f5284a);
    }

    @Override // p007b.p225i.p226a.p228b.Transport2
    /* renamed from: b */
    public void mo2290b(Event2<T> event2, TransportScheduleCallback transportScheduleCallback) {
        TransportInternal transportInternal = this.f5289e;
        TransportContext transportContext = this.f5285a;
        Objects.requireNonNull(transportContext, "Null transportContext");
        Objects.requireNonNull(event2, "Null event");
        String str = this.f5286b;
        Objects.requireNonNull(str, "Null transportName");
        Transformer<T, byte[]> transformer = this.f5288d;
        Objects.requireNonNull(transformer, "Null transformer");
        Encoding2 encoding2 = this.f5287c;
        Objects.requireNonNull(encoding2, "Null encoding");
        TransportRuntime transportRuntime = (TransportRuntime) transportInternal;
        Scheduler2 scheduler2 = transportRuntime.f5293d;
        Priority3 priority3Mo2288c = event2.mo2288c();
        TransportContext.a aVarM2358a = TransportContext.m2358a();
        aVarM2358a.mo2352b(transportContext.mo2348b());
        aVarM2358a.mo2353c(priority3Mo2288c);
        AutoValue_TransportContext.b bVar = (AutoValue_TransportContext.b) aVarM2358a;
        bVar.f5262b = transportContext.mo2349c();
        TransportContext transportContextMo2351a = bVar.mo2351a();
        AutoValue_EventInternal.b bVar2 = new AutoValue_EventInternal.b();
        bVar2.f5257f = new HashMap();
        bVar2.m2345e(transportRuntime.f5291b.mo2413a());
        bVar2.m2347g(transportRuntime.f5292c.mo2413a());
        bVar2.m2346f(str);
        bVar2.m2344d(new EncodedPayload(encoding2, transformer.apply(event2.mo2287b())));
        bVar2.f5253b = event2.mo2286a();
        scheduler2.mo2373a(transportContextMo2351a, bVar2.mo2342b(), transportScheduleCallback);
    }
}
