package p007b.p225i.p361c.p369m.p370d.p375m;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import java.io.IOException;
import p007b.p225i.p361c.p369m.p370d.p375m.CrashlyticsReport;
import p007b.p225i.p361c.p393p.ObjectEncoder;
import p007b.p225i.p361c.p393p.ObjectEncoderContext;
import p007b.p225i.p361c.p393p.p394g.Configurator;
import p007b.p225i.p361c.p393p.p394g.EncoderConfig;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder5;

/* compiled from: AutoCrashlyticsReportEncoder.java */
/* renamed from: b.i.c.m.d.m.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoCrashlyticsReportEncoder implements Configurator {

    /* renamed from: a */
    public static final Configurator f12497a = new AutoCrashlyticsReportEncoder();

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$a */
    public static final class a implements ObjectEncoder<CrashlyticsReport.b> {

        /* renamed from: a */
        public static final a f12498a = new a();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.b bVar = (CrashlyticsReport.b) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("key", bVar.mo6525a());
            objectEncoderContext2.mo6708f("value", bVar.mo6526b());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$b */
    public static final class b implements ObjectEncoder<CrashlyticsReport> {

        /* renamed from: a */
        public static final b f12499a = new b();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("sdkVersion", crashlyticsReport.mo6521g());
            objectEncoderContext2.mo6708f("gmpAppId", crashlyticsReport.mo6517c());
            objectEncoderContext2.mo6707c("platform", crashlyticsReport.mo6520f());
            objectEncoderContext2.mo6708f("installationUuid", crashlyticsReport.mo6518d());
            objectEncoderContext2.mo6708f("buildVersion", crashlyticsReport.mo6515a());
            objectEncoderContext2.mo6708f("displayVersion", crashlyticsReport.mo6516b());
            objectEncoderContext2.mo6708f("session", crashlyticsReport.mo6522h());
            objectEncoderContext2.mo6708f("ndkPayload", crashlyticsReport.mo6519e());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$c */
    public static final class c implements ObjectEncoder<CrashlyticsReport.c> {

        /* renamed from: a */
        public static final c f12500a = new c();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.c cVar = (CrashlyticsReport.c) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f(ChatInputComponentTypes.FILES, cVar.mo6527a());
            objectEncoderContext2.mo6708f("orgId", cVar.mo6528b());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$d */
    public static final class d implements ObjectEncoder<CrashlyticsReport.c.a> {

        /* renamed from: a */
        public static final d f12501a = new d();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.c.a aVar = (CrashlyticsReport.c.a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("filename", aVar.mo6530b());
            objectEncoderContext2.mo6708f("contents", aVar.mo6529a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$e */
    public static final class e implements ObjectEncoder<CrashlyticsReport.d.a> {

        /* renamed from: a */
        public static final e f12502a = new e();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.a aVar = (CrashlyticsReport.d.a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("identifier", aVar.mo6548d());
            objectEncoderContext2.mo6708f("version", aVar.mo6551g());
            objectEncoderContext2.mo6708f("displayVersion", aVar.mo6547c());
            objectEncoderContext2.mo6708f("organization", aVar.mo6550f());
            objectEncoderContext2.mo6708f("installationUuid", aVar.mo6549e());
            objectEncoderContext2.mo6708f("developmentPlatform", aVar.mo6545a());
            objectEncoderContext2.mo6708f("developmentPlatformVersion", aVar.mo6546b());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$f */
    public static final class f implements ObjectEncoder<CrashlyticsReport.d.a.AbstractC13232a> {

        /* renamed from: a */
        public static final f f12503a = new f();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo6708f("clsId", ((CrashlyticsReport.d.a.AbstractC13232a) obj).mo6552a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$g */
    public static final class g implements ObjectEncoder<CrashlyticsReport.d.c> {

        /* renamed from: a */
        public static final g f12504a = new g();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.c cVar = (CrashlyticsReport.d.c) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6707c("arch", cVar.mo6553a());
            objectEncoderContext2.mo6708f("model", cVar.mo6557e());
            objectEncoderContext2.mo6707c("cores", cVar.mo6554b());
            objectEncoderContext2.mo6706b("ram", cVar.mo6559g());
            objectEncoderContext2.mo6706b("diskSpace", cVar.mo6555c());
            objectEncoderContext2.mo6705a("simulator", cVar.mo6561i());
            objectEncoderContext2.mo6707c("state", cVar.mo6560h());
            objectEncoderContext2.mo6708f("manufacturer", cVar.mo6556d());
            objectEncoderContext2.mo6708f("modelClass", cVar.mo6558f());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$h */
    public static final class h implements ObjectEncoder<CrashlyticsReport.d> {

        /* renamed from: a */
        public static final h f12505a = new h();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d dVar = (CrashlyticsReport.d) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("generator", dVar.mo6535e());
            objectEncoderContext2.mo6708f("identifier", dVar.mo6537g().getBytes(CrashlyticsReport.f12647a));
            objectEncoderContext2.mo6706b("startedAt", dVar.mo6539i());
            objectEncoderContext2.mo6708f("endedAt", dVar.mo6533c());
            objectEncoderContext2.mo6705a("crashed", dVar.mo6541k());
            objectEncoderContext2.mo6708f("app", dVar.mo6531a());
            objectEncoderContext2.mo6708f("user", dVar.mo6540j());
            objectEncoderContext2.mo6708f("os", dVar.mo6538h());
            objectEncoderContext2.mo6708f("device", dVar.mo6532b());
            objectEncoderContext2.mo6708f("events", dVar.mo6534d());
            objectEncoderContext2.mo6707c("generatorType", dVar.mo6536f());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$i */
    public static final class i implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.a> {

        /* renamed from: a */
        public static final i f12506a = new i();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d.a aVar = (CrashlyticsReport.d.AbstractC13233d.a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("execution", aVar.mo6570c());
            objectEncoderContext2.mo6708f("customAttributes", aVar.mo6569b());
            objectEncoderContext2.mo6708f("background", aVar.mo6568a());
            objectEncoderContext2.mo6707c("uiOrientation", aVar.mo6571d());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$j */
    public static final class j implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13235a> {

        /* renamed from: a */
        public static final j f12507a = new j();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13235a abstractC13235a = (CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13235a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6706b("baseAddress", abstractC13235a.mo6578a());
            objectEncoderContext2.mo6706b("size", abstractC13235a.mo6580c());
            objectEncoderContext2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_NAME, abstractC13235a.mo6579b());
            String strMo6581d = abstractC13235a.mo6581d();
            objectEncoderContext2.mo6708f("uuid", strMo6581d != null ? strMo6581d.getBytes(CrashlyticsReport.f12647a) : null);
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$k */
    public static final class k implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.a.b> {

        /* renamed from: a */
        public static final k f12508a = new k();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d.a.b bVar = (CrashlyticsReport.d.AbstractC13233d.a.b) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("threads", bVar.mo6577d());
            objectEncoderContext2.mo6708f("exception", bVar.mo6575b());
            objectEncoderContext2.mo6708f("signal", bVar.mo6576c());
            objectEncoderContext2.mo6708f("binaries", bVar.mo6574a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$l */
    public static final class l implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b> {

        /* renamed from: a */
        public static final l f12509a = new l();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b abstractC13236b = (CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("type", abstractC13236b.mo6586e());
            objectEncoderContext2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_REASON, abstractC13236b.mo6585d());
            objectEncoderContext2.mo6708f("frames", abstractC13236b.mo6583b());
            objectEncoderContext2.mo6708f("causedBy", abstractC13236b.mo6582a());
            objectEncoderContext2.mo6707c("overflowCount", abstractC13236b.mo6584c());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$m */
    public static final class m implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.a.b.c> {

        /* renamed from: a */
        public static final m f12510a = new m();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d.a.b.c cVar = (CrashlyticsReport.d.AbstractC13233d.a.b.c) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_NAME, cVar.mo6589c());
            objectEncoderContext2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_CODE, cVar.mo6588b());
            objectEncoderContext2.mo6706b("address", cVar.mo6587a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$n */
    public static final class n implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d> {

        /* renamed from: a */
        public static final n f12511a = new n();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d abstractC13237d = (CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_NAME, abstractC13237d.mo6592c());
            objectEncoderContext2.mo6707c("importance", abstractC13237d.mo6591b());
            objectEncoderContext2.mo6708f("frames", abstractC13237d.mo6590a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$o */
    public static final class o implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a> {

        /* renamed from: a */
        public static final o f12512a = new o();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a abstractC13238a = (CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6706b("pc", abstractC13238a.mo6596d());
            objectEncoderContext2.mo6708f("symbol", abstractC13238a.mo6597e());
            objectEncoderContext2.mo6708f("file", abstractC13238a.mo6593a());
            objectEncoderContext2.mo6706b("offset", abstractC13238a.mo6595c());
            objectEncoderContext2.mo6707c("importance", abstractC13238a.mo6594b());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$p */
    public static final class p implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.b> {

        /* renamed from: a */
        public static final p f12513a = new p();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d.b bVar = (CrashlyticsReport.d.AbstractC13233d.b) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("batteryLevel", bVar.mo6599a());
            objectEncoderContext2.mo6707c("batteryVelocity", bVar.mo6600b());
            objectEncoderContext2.mo6705a("proximityOn", bVar.mo6604f());
            objectEncoderContext2.mo6707c("orientation", bVar.mo6602d());
            objectEncoderContext2.mo6706b("ramUsed", bVar.mo6603e());
            objectEncoderContext2.mo6706b("diskUsed", bVar.mo6601c());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$q */
    public static final class q implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d> {

        /* renamed from: a */
        public static final q f12514a = new q();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.AbstractC13233d abstractC13233d = (CrashlyticsReport.d.AbstractC13233d) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6706b("timestamp", abstractC13233d.mo6566d());
            objectEncoderContext2.mo6708f("type", abstractC13233d.mo6567e());
            objectEncoderContext2.mo6708f("app", abstractC13233d.mo6563a());
            objectEncoderContext2.mo6708f("device", abstractC13233d.mo6564b());
            objectEncoderContext2.mo6708f("log", abstractC13233d.mo6565c());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$r */
    public static final class r implements ObjectEncoder<CrashlyticsReport.d.AbstractC13233d.c> {

        /* renamed from: a */
        public static final r f12515a = new r();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo6708f("content", ((CrashlyticsReport.d.AbstractC13233d.c) obj).mo6606a());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$s */
    public static final class s implements ObjectEncoder<CrashlyticsReport.d.e> {

        /* renamed from: a */
        public static final s f12516a = new s();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            CrashlyticsReport.d.e eVar = (CrashlyticsReport.d.e) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6707c("platform", eVar.mo6608b());
            objectEncoderContext2.mo6708f("version", eVar.mo6609c());
            objectEncoderContext2.mo6708f("buildVersion", eVar.mo6607a());
            objectEncoderContext2.mo6705a("jailbroken", eVar.mo6610d());
        }
    }

    /* compiled from: AutoCrashlyticsReportEncoder.java */
    /* renamed from: b.i.c.m.d.m.a$t */
    public static final class t implements ObjectEncoder<CrashlyticsReport.d.f> {

        /* renamed from: a */
        public static final t f12517a = new t();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo6708f("identifier", ((CrashlyticsReport.d.f) obj).mo6611a());
        }
    }

    /* renamed from: a */
    public void m6514a(EncoderConfig<?> encoderConfig) {
        b bVar = b.f12499a;
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = (JsonDataEncoderBuilder5) encoderConfig;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.class, bVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport.class, bVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport.class);
        h hVar = h.f12505a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.class, hVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session.class, hVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session.class);
        e eVar = e.f12502a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.a.class, eVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.a.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Application.class, eVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Application.class);
        f fVar = f.f12503a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.a.AbstractC13232a.class, fVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.a.AbstractC13232a.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Application_Organization.class, fVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Application_Organization.class);
        t tVar = t.f12517a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.f.class, tVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.f.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_User.class, tVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_User.class);
        s sVar = s.f12516a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.e.class, sVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.e.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, sVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_OperatingSystem.class);
        g gVar = g.f12504a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.c.class, gVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.c.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Device.class, gVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Device.class);
        q qVar = q.f12514a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.class, qVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event.class, qVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event.class);
        i iVar = i.f12506a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.a.class, iVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.a.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Application.class, iVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Application.class);
        k kVar = k.f12508a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.a.b.class, kVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.a.b.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, kVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class);
        n nVar = n.f12511a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.class, nVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, nVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class);
        o oVar = o.f12512a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a.class, oVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13237d.AbstractC13238a.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, oVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class);
        l lVar = l.f12509a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b.class, lVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13236b.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, lVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class);
        m mVar = m.f12510a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.a.b.c.class, mVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.a.b.c.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, mVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class);
        j jVar = j.f12507a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13235a.class, jVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.a.b.AbstractC13235a.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, jVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class);
        a aVar = a.f12498a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.b.class, aVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.b.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_CustomAttribute.class, aVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_CustomAttribute.class);
        p pVar = p.f12513a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.b.class, pVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.b.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Device.class, pVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Device.class);
        r rVar = r.f12515a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.d.AbstractC13233d.c.class, rVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.d.AbstractC13233d.c.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_Session_Event_Log.class, rVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_Session_Event_Log.class);
        c cVar = c.f12500a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.c.class, cVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.c.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_FilesPayload.class, cVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_FilesPayload.class);
        d dVar = d.f12501a;
        jsonDataEncoderBuilder5.f12822b.put(CrashlyticsReport.c.a.class, dVar);
        jsonDataEncoderBuilder5.f12823c.remove(CrashlyticsReport.c.a.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_CrashlyticsReport_FilesPayload_File.class, dVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_CrashlyticsReport_FilesPayload_File.class);
    }
}
