package p007b.p225i.p361c.p369m.p370d.p380q.p382d;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractSpiCall;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequest;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequestFactory;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpResponse;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.CreateReportRequest;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2;

/* JADX INFO: renamed from: b.i.c.m.d.q.d.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultCreateReportSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {

    /* JADX INFO: renamed from: f */
    public final String f12718f;

    public DefaultCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, 2);
        this.f12718f = str3;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p380q.p382d.CreateReportSpiCall
    /* JADX INFO: renamed from: a */
    public boolean mo6678a(CreateReportRequest createReportRequest, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        HttpRequest httpRequestM6390b = m6390b();
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-GOOGLE-APP-ID", createReportRequest.f12710b);
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f12718f);
        for (Map.Entry<String, String> entry : createReportRequest.f12711c.mo6673b().entrySet()) {
            httpRequestM6390b.f12661e.put(entry.getKey(), entry.getValue());
        }
        Report2 report2 = createReportRequest.f12711c;
        httpRequestM6390b.m6622b("report[identifier]", report2.mo6672a());
        if (report2.mo6676e().length == 1) {
            Logger3 logger3 = Logger3.f12227a;
            StringBuilder sbM833U = outline.m833U("Adding single file ");
            sbM833U.append(report2.mo6677f());
            sbM833U.append(" to report ");
            sbM833U.append(report2.mo6672a());
            logger3.m6371b(sbM833U.toString());
            httpRequestM6390b.m6623c("report[file]", report2.mo6677f(), "application/octet-stream", report2.mo6674c());
        } else {
            int i = 0;
            for (File file : report2.mo6676e()) {
                Logger3 logger32 = Logger3.f12227a;
                StringBuilder sbM833U2 = outline.m833U("Adding file ");
                sbM833U2.append(file.getName());
                sbM833U2.append(" to report ");
                sbM833U2.append(report2.mo6672a());
                logger32.m6371b(sbM833U2.toString());
                httpRequestM6390b.m6623c("report[file" + i + "]", file.getName(), "application/octet-stream", file);
                i++;
            }
        }
        Logger3 logger33 = Logger3.f12227a;
        StringBuilder sbM833U3 = outline.m833U("Sending report to: ");
        sbM833U3.append(this.f12253b);
        logger33.m6371b(sbM833U3.toString());
        try {
            HttpResponse httpResponseM6621a = httpRequestM6390b.m6621a();
            int i2 = httpResponseM6621a.f12663a;
            logger33.m6371b("Create report request ID: " + httpResponseM6621a.f12665c.m10954c("X-REQUEST-ID"));
            logger33.m6371b("Result was: " + i2);
            return C3404f.m4241R0(i2) == 0;
        } catch (IOException e) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Create report HTTP request failed.", e);
            }
            throw new RuntimeException(e);
        }
    }
}
