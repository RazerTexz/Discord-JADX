package b.i.a.b.i.e;

import java.io.IOException;

/* compiled from: AutoBatchedLogRequestEncoder.java */
/* loaded from: classes3.dex */
public final class b implements b.i.c.p.g.a {
    public static final b.i.c.p.g.a a = new b();

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class a implements b.i.c.p.c<b.i.a.b.i.e.a> {
        public static final a a = new a();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            b.i.a.b.i.e.a aVar = (b.i.a.b.i.e.a) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("sdkVersion", aVar.l());
            dVar2.f("model", aVar.i());
            dVar2.f("hardware", aVar.e());
            dVar2.f("device", aVar.c());
            dVar2.f("product", aVar.k());
            dVar2.f("osBuild", aVar.j());
            dVar2.f("manufacturer", aVar.g());
            dVar2.f("fingerprint", aVar.d());
            dVar2.f("locale", aVar.f());
            dVar2.f("country", aVar.b());
            dVar2.f("mccMnc", aVar.h());
            dVar2.f("applicationBuild", aVar.a());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: b.i.a.b.i.e.b$b, reason: collision with other inner class name */
    public static final class C0085b implements b.i.c.p.c<j> {
        public static final C0085b a = new C0085b();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            dVar.f("logRequest", ((j) obj).a());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class c implements b.i.c.p.c<k> {
        public static final c a = new c();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            k kVar = (k) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("clientType", kVar.b());
            dVar2.f("androidClientInfo", kVar.a());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class d implements b.i.c.p.c<l> {
        public static final d a = new d();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            l lVar = (l) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.b("eventTimeMs", lVar.b());
            dVar2.f("eventCode", lVar.a());
            dVar2.b("eventUptimeMs", lVar.c());
            dVar2.f("sourceExtension", lVar.e());
            dVar2.f("sourceExtensionJsonProto3", lVar.f());
            dVar2.b("timezoneOffsetSeconds", lVar.g());
            dVar2.f("networkConnectionInfo", lVar.d());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class e implements b.i.c.p.c<m> {
        public static final e a = new e();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            m mVar = (m) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.b("requestTimeMs", mVar.f());
            dVar2.b("requestUptimeMs", mVar.g());
            dVar2.f("clientInfo", mVar.a());
            dVar2.f("logSource", mVar.c());
            dVar2.f("logSourceName", mVar.d());
            dVar2.f("logEvent", mVar.b());
            dVar2.f("qosTier", mVar.e());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    public static final class f implements b.i.c.p.c<o> {
        public static final f a = new f();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            o oVar = (o) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("networkType", oVar.b());
            dVar2.f("mobileSubtype", oVar.a());
        }
    }

    public void a(b.i.c.p.g.b<?> bVar) {
        C0085b c0085b = C0085b.a;
        b.i.c.p.h.e eVar = (b.i.c.p.h.e) bVar;
        eVar.f1761b.put(j.class, c0085b);
        eVar.c.remove(j.class);
        eVar.f1761b.put(b.i.a.b.i.e.d.class, c0085b);
        eVar.c.remove(b.i.a.b.i.e.d.class);
        e eVar2 = e.a;
        eVar.f1761b.put(m.class, eVar2);
        eVar.c.remove(m.class);
        eVar.f1761b.put(g.class, eVar2);
        eVar.c.remove(g.class);
        c cVar = c.a;
        eVar.f1761b.put(k.class, cVar);
        eVar.c.remove(k.class);
        eVar.f1761b.put(b.i.a.b.i.e.e.class, cVar);
        eVar.c.remove(b.i.a.b.i.e.e.class);
        a aVar = a.a;
        eVar.f1761b.put(b.i.a.b.i.e.a.class, aVar);
        eVar.c.remove(b.i.a.b.i.e.a.class);
        eVar.f1761b.put(b.i.a.b.i.e.c.class, aVar);
        eVar.c.remove(b.i.a.b.i.e.c.class);
        d dVar = d.a;
        eVar.f1761b.put(l.class, dVar);
        eVar.c.remove(l.class);
        eVar.f1761b.put(b.i.a.b.i.e.f.class, dVar);
        eVar.c.remove(b.i.a.b.i.e.f.class);
        f fVar = f.a;
        eVar.f1761b.put(o.class, fVar);
        eVar.c.remove(o.class);
        eVar.f1761b.put(i.class, fVar);
        eVar.c.remove(i.class);
    }
}
