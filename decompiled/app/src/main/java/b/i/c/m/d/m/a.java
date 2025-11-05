package b.i.c.m.d.m;

import b.i.c.m.d.m.v;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;

/* compiled from: AutoCrashlyticsReportEncoder.java */
/* loaded from: classes3.dex */
public final class a implements b.i.c.p.g.a {
    public static final b.i.c.p.g.a a = new a();

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$a, reason: collision with other inner class name */
    public static final class C0140a implements b.i.c.p.c<v.b> {
        public static final C0140a a = new C0140a();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.b bVar = (v.b) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("key", bVar.a());
            dVar2.f("value", bVar.b());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class b implements b.i.c.p.c<v> {
        public static final b a = new b();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v vVar = (v) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("sdkVersion", vVar.g());
            dVar2.f("gmpAppId", vVar.c());
            dVar2.c("platform", vVar.f());
            dVar2.f("installationUuid", vVar.d());
            dVar2.f("buildVersion", vVar.a());
            dVar2.f("displayVersion", vVar.b());
            dVar2.f("session", vVar.h());
            dVar2.f("ndkPayload", vVar.e());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class c implements b.i.c.p.c<v.c> {
        public static final c a = new c();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.c cVar = (v.c) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f(ChatInputComponentTypes.FILES, cVar.a());
            dVar2.f("orgId", cVar.b());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class d implements b.i.c.p.c<v.c.a> {
        public static final d a = new d();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.c.a aVar = (v.c.a) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("filename", aVar.b());
            dVar2.f("contents", aVar.a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class e implements b.i.c.p.c<v.d.a> {
        public static final e a = new e();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.a aVar = (v.d.a) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("identifier", aVar.d());
            dVar2.f("version", aVar.g());
            dVar2.f("displayVersion", aVar.c());
            dVar2.f("organization", aVar.f());
            dVar2.f("installationUuid", aVar.e());
            dVar2.f("developmentPlatform", aVar.a());
            dVar2.f("developmentPlatformVersion", aVar.b());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class f implements b.i.c.p.c<v.d.a.AbstractC0142a> {
        public static final f a = new f();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            dVar.f("clsId", ((v.d.a.AbstractC0142a) obj).a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class g implements b.i.c.p.c<v.d.c> {
        public static final g a = new g();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.c cVar = (v.d.c) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.c("arch", cVar.a());
            dVar2.f("model", cVar.e());
            dVar2.c("cores", cVar.b());
            dVar2.b("ram", cVar.g());
            dVar2.b("diskSpace", cVar.c());
            dVar2.a("simulator", cVar.i());
            dVar2.c("state", cVar.h());
            dVar2.f("manufacturer", cVar.d());
            dVar2.f("modelClass", cVar.f());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class h implements b.i.c.p.c<v.d> {
        public static final h a = new h();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d dVar2 = (v.d) obj;
            b.i.c.p.d dVar3 = dVar;
            dVar3.f("generator", dVar2.e());
            dVar3.f("identifier", dVar2.g().getBytes(v.a));
            dVar3.b("startedAt", dVar2.i());
            dVar3.f("endedAt", dVar2.c());
            dVar3.a("crashed", dVar2.k());
            dVar3.f("app", dVar2.a());
            dVar3.f("user", dVar2.j());
            dVar3.f("os", dVar2.h());
            dVar3.f("device", dVar2.b());
            dVar3.f("events", dVar2.d());
            dVar3.c("generatorType", dVar2.f());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class i implements b.i.c.p.c<v.d.AbstractC0143d.a> {
        public static final i a = new i();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d.a aVar = (v.d.AbstractC0143d.a) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("execution", aVar.c());
            dVar2.f("customAttributes", aVar.b());
            dVar2.f("background", aVar.a());
            dVar2.c("uiOrientation", aVar.d());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class j implements b.i.c.p.c<v.d.AbstractC0143d.a.b.AbstractC0145a> {
        public static final j a = new j();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d.a.b.AbstractC0145a abstractC0145a = (v.d.AbstractC0143d.a.b.AbstractC0145a) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.b("baseAddress", abstractC0145a.a());
            dVar2.b("size", abstractC0145a.c());
            dVar2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, abstractC0145a.b());
            String strD = abstractC0145a.d();
            dVar2.f("uuid", strD != null ? strD.getBytes(v.a) : null);
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class k implements b.i.c.p.c<v.d.AbstractC0143d.a.b> {
        public static final k a = new k();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d.a.b bVar = (v.d.AbstractC0143d.a.b) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("threads", bVar.d());
            dVar2.f("exception", bVar.b());
            dVar2.f("signal", bVar.c());
            dVar2.f("binaries", bVar.a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class l implements b.i.c.p.c<v.d.AbstractC0143d.a.b.AbstractC0146b> {
        public static final l a = new l();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d.a.b.AbstractC0146b abstractC0146b = (v.d.AbstractC0143d.a.b.AbstractC0146b) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("type", abstractC0146b.e());
            dVar2.f(ModelAuditLogEntry.CHANGE_KEY_REASON, abstractC0146b.d());
            dVar2.f("frames", abstractC0146b.b());
            dVar2.f("causedBy", abstractC0146b.a());
            dVar2.c("overflowCount", abstractC0146b.c());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class m implements b.i.c.p.c<v.d.AbstractC0143d.a.b.c> {
        public static final m a = new m();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d.a.b.c cVar = (v.d.AbstractC0143d.a.b.c) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, cVar.c());
            dVar2.f(ModelAuditLogEntry.CHANGE_KEY_CODE, cVar.b());
            dVar2.b("address", cVar.a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class n implements b.i.c.p.c<v.d.AbstractC0143d.a.b.AbstractC0147d> {
        public static final n a = new n();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d.a.b.AbstractC0147d abstractC0147d = (v.d.AbstractC0143d.a.b.AbstractC0147d) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f(ModelAuditLogEntry.CHANGE_KEY_NAME, abstractC0147d.c());
            dVar2.c("importance", abstractC0147d.b());
            dVar2.f("frames", abstractC0147d.a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class o implements b.i.c.p.c<v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a> {
        public static final o a = new o();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a abstractC0148a = (v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.b("pc", abstractC0148a.d());
            dVar2.f("symbol", abstractC0148a.e());
            dVar2.f("file", abstractC0148a.a());
            dVar2.b("offset", abstractC0148a.c());
            dVar2.c("importance", abstractC0148a.b());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class p implements b.i.c.p.c<v.d.AbstractC0143d.b> {
        public static final p a = new p();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d.b bVar = (v.d.AbstractC0143d.b) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.f("batteryLevel", bVar.a());
            dVar2.c("batteryVelocity", bVar.b());
            dVar2.a("proximityOn", bVar.f());
            dVar2.c("orientation", bVar.d());
            dVar2.b("ramUsed", bVar.e());
            dVar2.b("diskUsed", bVar.c());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class q implements b.i.c.p.c<v.d.AbstractC0143d> {
        public static final q a = new q();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.AbstractC0143d abstractC0143d = (v.d.AbstractC0143d) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.b("timestamp", abstractC0143d.d());
            dVar2.f("type", abstractC0143d.e());
            dVar2.f("app", abstractC0143d.a());
            dVar2.f("device", abstractC0143d.b());
            dVar2.f("log", abstractC0143d.c());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class r implements b.i.c.p.c<v.d.AbstractC0143d.c> {
        public static final r a = new r();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            dVar.f("content", ((v.d.AbstractC0143d.c) obj).a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class s implements b.i.c.p.c<v.d.e> {
        public static final s a = new s();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            v.d.e eVar = (v.d.e) obj;
            b.i.c.p.d dVar2 = dVar;
            dVar2.c("platform", eVar.b());
            dVar2.f("version", eVar.c());
            dVar2.f("buildVersion", eVar.a());
            dVar2.a("jailbroken", eVar.d());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    public static final class t implements b.i.c.p.c<v.d.f> {
        public static final t a = new t();

        @Override // b.i.c.p.b
        public void a(Object obj, b.i.c.p.d dVar) throws IOException {
            dVar.f("identifier", ((v.d.f) obj).a());
        }
    }

    public void a(b.i.c.p.g.b<?> bVar) {
        b bVar2 = b.a;
        b.i.c.p.h.e eVar = (b.i.c.p.h.e) bVar;
        eVar.f1761b.put(v.class, bVar2);
        eVar.c.remove(v.class);
        eVar.f1761b.put(b.i.c.m.d.m.b.class, bVar2);
        eVar.c.remove(b.i.c.m.d.m.b.class);
        h hVar = h.a;
        eVar.f1761b.put(v.d.class, hVar);
        eVar.c.remove(v.d.class);
        eVar.f1761b.put(b.i.c.m.d.m.f.class, hVar);
        eVar.c.remove(b.i.c.m.d.m.f.class);
        e eVar2 = e.a;
        eVar.f1761b.put(v.d.a.class, eVar2);
        eVar.c.remove(v.d.a.class);
        eVar.f1761b.put(b.i.c.m.d.m.g.class, eVar2);
        eVar.c.remove(b.i.c.m.d.m.g.class);
        f fVar = f.a;
        eVar.f1761b.put(v.d.a.AbstractC0142a.class, fVar);
        eVar.c.remove(v.d.a.AbstractC0142a.class);
        eVar.f1761b.put(b.i.c.m.d.m.h.class, fVar);
        eVar.c.remove(b.i.c.m.d.m.h.class);
        t tVar = t.a;
        eVar.f1761b.put(v.d.f.class, tVar);
        eVar.c.remove(v.d.f.class);
        eVar.f1761b.put(u.class, tVar);
        eVar.c.remove(u.class);
        s sVar = s.a;
        eVar.f1761b.put(v.d.e.class, sVar);
        eVar.c.remove(v.d.e.class);
        eVar.f1761b.put(b.i.c.m.d.m.t.class, sVar);
        eVar.c.remove(b.i.c.m.d.m.t.class);
        g gVar = g.a;
        eVar.f1761b.put(v.d.c.class, gVar);
        eVar.c.remove(v.d.c.class);
        eVar.f1761b.put(b.i.c.m.d.m.i.class, gVar);
        eVar.c.remove(b.i.c.m.d.m.i.class);
        q qVar = q.a;
        eVar.f1761b.put(v.d.AbstractC0143d.class, qVar);
        eVar.c.remove(v.d.AbstractC0143d.class);
        eVar.f1761b.put(b.i.c.m.d.m.j.class, qVar);
        eVar.c.remove(b.i.c.m.d.m.j.class);
        i iVar = i.a;
        eVar.f1761b.put(v.d.AbstractC0143d.a.class, iVar);
        eVar.c.remove(v.d.AbstractC0143d.a.class);
        eVar.f1761b.put(b.i.c.m.d.m.k.class, iVar);
        eVar.c.remove(b.i.c.m.d.m.k.class);
        k kVar = k.a;
        eVar.f1761b.put(v.d.AbstractC0143d.a.b.class, kVar);
        eVar.c.remove(v.d.AbstractC0143d.a.b.class);
        eVar.f1761b.put(b.i.c.m.d.m.l.class, kVar);
        eVar.c.remove(b.i.c.m.d.m.l.class);
        n nVar = n.a;
        eVar.f1761b.put(v.d.AbstractC0143d.a.b.AbstractC0147d.class, nVar);
        eVar.c.remove(v.d.AbstractC0143d.a.b.AbstractC0147d.class);
        eVar.f1761b.put(b.i.c.m.d.m.p.class, nVar);
        eVar.c.remove(b.i.c.m.d.m.p.class);
        o oVar = o.a;
        eVar.f1761b.put(v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a.class, oVar);
        eVar.c.remove(v.d.AbstractC0143d.a.b.AbstractC0147d.AbstractC0148a.class);
        eVar.f1761b.put(b.i.c.m.d.m.q.class, oVar);
        eVar.c.remove(b.i.c.m.d.m.q.class);
        l lVar = l.a;
        eVar.f1761b.put(v.d.AbstractC0143d.a.b.AbstractC0146b.class, lVar);
        eVar.c.remove(v.d.AbstractC0143d.a.b.AbstractC0146b.class);
        eVar.f1761b.put(b.i.c.m.d.m.n.class, lVar);
        eVar.c.remove(b.i.c.m.d.m.n.class);
        m mVar = m.a;
        eVar.f1761b.put(v.d.AbstractC0143d.a.b.c.class, mVar);
        eVar.c.remove(v.d.AbstractC0143d.a.b.c.class);
        eVar.f1761b.put(b.i.c.m.d.m.o.class, mVar);
        eVar.c.remove(b.i.c.m.d.m.o.class);
        j jVar = j.a;
        eVar.f1761b.put(v.d.AbstractC0143d.a.b.AbstractC0145a.class, jVar);
        eVar.c.remove(v.d.AbstractC0143d.a.b.AbstractC0145a.class);
        eVar.f1761b.put(b.i.c.m.d.m.m.class, jVar);
        eVar.c.remove(b.i.c.m.d.m.m.class);
        C0140a c0140a = C0140a.a;
        eVar.f1761b.put(v.b.class, c0140a);
        eVar.c.remove(v.b.class);
        eVar.f1761b.put(b.i.c.m.d.m.c.class, c0140a);
        eVar.c.remove(b.i.c.m.d.m.c.class);
        p pVar = p.a;
        eVar.f1761b.put(v.d.AbstractC0143d.b.class, pVar);
        eVar.c.remove(v.d.AbstractC0143d.b.class);
        eVar.f1761b.put(b.i.c.m.d.m.r.class, pVar);
        eVar.c.remove(b.i.c.m.d.m.r.class);
        r rVar = r.a;
        eVar.f1761b.put(v.d.AbstractC0143d.c.class, rVar);
        eVar.c.remove(v.d.AbstractC0143d.c.class);
        eVar.f1761b.put(b.i.c.m.d.m.s.class, rVar);
        eVar.c.remove(b.i.c.m.d.m.s.class);
        c cVar = c.a;
        eVar.f1761b.put(v.c.class, cVar);
        eVar.c.remove(v.c.class);
        eVar.f1761b.put(b.i.c.m.d.m.d.class, cVar);
        eVar.c.remove(b.i.c.m.d.m.d.class);
        d dVar = d.a;
        eVar.f1761b.put(v.c.a.class, dVar);
        eVar.c.remove(v.c.a.class);
        eVar.f1761b.put(b.i.c.m.d.m.e.class, dVar);
        eVar.c.remove(b.i.c.m.d.m.e.class);
    }
}
