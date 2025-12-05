package p007b.p225i.p226a.p228b.p229i.p230e;

import java.io.IOException;
import p007b.p225i.p361c.p393p.ObjectEncoder;
import p007b.p225i.p361c.p393p.ObjectEncoderContext;
import p007b.p225i.p361c.p393p.p394g.Configurator;
import p007b.p225i.p361c.p393p.p394g.EncoderConfig;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder5;

/* compiled from: AutoBatchedLogRequestEncoder.java */
/* renamed from: b.i.a.b.i.e.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AutoBatchedLogRequestEncoder implements Configurator {

    /* renamed from: a */
    public static final Configurator f5145a = new AutoBatchedLogRequestEncoder();

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: b.i.a.b.i.e.b$a */
    public static final class a implements ObjectEncoder<AndroidClientInfo> {

        /* renamed from: a */
        public static final a f5146a = new a();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("sdkVersion", androidClientInfo.mo2310l());
            objectEncoderContext2.mo6708f("model", androidClientInfo.mo2307i());
            objectEncoderContext2.mo6708f("hardware", androidClientInfo.mo2303e());
            objectEncoderContext2.mo6708f("device", androidClientInfo.mo2301c());
            objectEncoderContext2.mo6708f("product", androidClientInfo.mo2309k());
            objectEncoderContext2.mo6708f("osBuild", androidClientInfo.mo2308j());
            objectEncoderContext2.mo6708f("manufacturer", androidClientInfo.mo2305g());
            objectEncoderContext2.mo6708f("fingerprint", androidClientInfo.mo2302d());
            objectEncoderContext2.mo6708f("locale", androidClientInfo.mo2304f());
            objectEncoderContext2.mo6708f("country", androidClientInfo.mo2300b());
            objectEncoderContext2.mo6708f("mccMnc", androidClientInfo.mo2306h());
            objectEncoderContext2.mo6708f("applicationBuild", androidClientInfo.mo2299a());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: b.i.a.b.i.e.b$b */
    public static final class b implements ObjectEncoder<BatchedLogRequest> {

        /* renamed from: a */
        public static final b f5147a = new b();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo6708f("logRequest", ((BatchedLogRequest) obj).mo2313a());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: b.i.a.b.i.e.b$c */
    public static final class c implements ObjectEncoder<ClientInfo2> {

        /* renamed from: a */
        public static final c f5148a = new c();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            ClientInfo2 clientInfo2 = (ClientInfo2) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("clientType", clientInfo2.mo2315b());
            objectEncoderContext2.mo6708f("androidClientInfo", clientInfo2.mo2314a());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: b.i.a.b.i.e.b$d */
    public static final class d implements ObjectEncoder<LogEvent> {

        /* renamed from: a */
        public static final d f5149a = new d();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            LogEvent logEvent = (LogEvent) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6706b("eventTimeMs", logEvent.mo2317b());
            objectEncoderContext2.mo6708f("eventCode", logEvent.mo2316a());
            objectEncoderContext2.mo6706b("eventUptimeMs", logEvent.mo2318c());
            objectEncoderContext2.mo6708f("sourceExtension", logEvent.mo2320e());
            objectEncoderContext2.mo6708f("sourceExtensionJsonProto3", logEvent.mo2321f());
            objectEncoderContext2.mo6706b("timezoneOffsetSeconds", logEvent.mo2322g());
            objectEncoderContext2.mo6708f("networkConnectionInfo", logEvent.mo2319d());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: b.i.a.b.i.e.b$e */
    public static final class e implements ObjectEncoder<LogRequest> {

        /* renamed from: a */
        public static final e f5150a = new e();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            LogRequest logRequest = (LogRequest) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6706b("requestTimeMs", logRequest.mo2328f());
            objectEncoderContext2.mo6706b("requestUptimeMs", logRequest.mo2329g());
            objectEncoderContext2.mo6708f("clientInfo", logRequest.mo2323a());
            objectEncoderContext2.mo6708f("logSource", logRequest.mo2325c());
            objectEncoderContext2.mo6708f("logSourceName", logRequest.mo2326d());
            objectEncoderContext2.mo6708f("logEvent", logRequest.mo2324b());
            objectEncoderContext2.mo6708f("qosTier", logRequest.mo2327e());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: b.i.a.b.i.e.b$f */
    public static final class f implements ObjectEncoder<NetworkConnectionInfo> {

        /* renamed from: a */
        public static final f f5151a = new f();

        @Override // p007b.p225i.p361c.p393p.Encoder
        /* renamed from: a */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            objectEncoderContext2.mo6708f("networkType", networkConnectionInfo.mo2332b());
            objectEncoderContext2.mo6708f("mobileSubtype", networkConnectionInfo.mo2331a());
        }
    }

    /* renamed from: a */
    public void m2311a(EncoderConfig<?> encoderConfig) {
        b bVar = b.f5147a;
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = (JsonDataEncoderBuilder5) encoderConfig;
        jsonDataEncoderBuilder5.f12822b.put(BatchedLogRequest.class, bVar);
        jsonDataEncoderBuilder5.f12823c.remove(BatchedLogRequest.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_BatchedLogRequest.class, bVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_BatchedLogRequest.class);
        e eVar = e.f5150a;
        jsonDataEncoderBuilder5.f12822b.put(LogRequest.class, eVar);
        jsonDataEncoderBuilder5.f12823c.remove(LogRequest.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_LogRequest.class, eVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_LogRequest.class);
        c cVar = c.f5148a;
        jsonDataEncoderBuilder5.f12822b.put(ClientInfo2.class, cVar);
        jsonDataEncoderBuilder5.f12823c.remove(ClientInfo2.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_ClientInfo.class, cVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_ClientInfo.class);
        a aVar = a.f5146a;
        jsonDataEncoderBuilder5.f12822b.put(AndroidClientInfo.class, aVar);
        jsonDataEncoderBuilder5.f12823c.remove(AndroidClientInfo.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_AndroidClientInfo.class, aVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_AndroidClientInfo.class);
        d dVar = d.f5149a;
        jsonDataEncoderBuilder5.f12822b.put(LogEvent.class, dVar);
        jsonDataEncoderBuilder5.f12823c.remove(LogEvent.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_LogEvent.class, dVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_LogEvent.class);
        f fVar = f.f5151a;
        jsonDataEncoderBuilder5.f12822b.put(NetworkConnectionInfo.class, fVar);
        jsonDataEncoderBuilder5.f12823c.remove(NetworkConnectionInfo.class);
        jsonDataEncoderBuilder5.f12822b.put(AutoValue_NetworkConnectionInfo.class, fVar);
        jsonDataEncoderBuilder5.f12823c.remove(AutoValue_NetworkConnectionInfo.class);
    }
}
