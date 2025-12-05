package p007b.p225i.p361c.p369m.p370d.p380q.p382d;

import java.io.File;
import java.io.IOException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractSpiCall;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequest;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequestFactory;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.CreateReportRequest;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2;

/* compiled from: NativeCreateReportSpiCall.java */
/* renamed from: b.i.c.m.d.q.d.d, reason: use source file name */
/* loaded from: classes3.dex */
public class NativeCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {

    /* renamed from: f */
    public final String f12719f;

    public NativeCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, 2);
        this.f12719f = str3;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p382d.CreateReportSpiCall
    /* renamed from: a */
    public boolean mo6678a(CreateReportRequest createReportRequest, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        HttpRequest httpRequestM6390b = m6390b();
        String str = createReportRequest.f12710b;
        httpRequestM6390b.f12661e.put("User-Agent", "Crashlytics Android SDK/17.3.0");
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f12719f);
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        String str2 = createReportRequest.f12709a;
        Report2 report2 = createReportRequest.f12711c;
        if (str2 != null) {
            httpRequestM6390b.m6622b("org_id", str2);
        }
        httpRequestM6390b.m6622b("report_id", report2.mo6672a());
        for (File file : report2.mo6676e()) {
            if (file.getName().equals("minidump")) {
                httpRequestM6390b.m6623c("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                httpRequestM6390b.m6623c("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                httpRequestM6390b.m6623c("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                httpRequestM6390b.m6623c("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                httpRequestM6390b.m6623c("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                httpRequestM6390b.m6623c("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                httpRequestM6390b.m6623c("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                httpRequestM6390b.m6623c("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                httpRequestM6390b.m6623c("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                httpRequestM6390b.m6623c("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        Logger3 logger3 = Logger3.f12227a;
        StringBuilder sbM833U = outline.m833U("Sending report to: ");
        sbM833U.append(this.f12253b);
        logger3.m6371b(sbM833U.toString());
        try {
            int i = httpRequestM6390b.m6621a().f12663a;
            logger3.m6371b("Result was: " + i);
            return C3404f.m4241R0(i) == 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
