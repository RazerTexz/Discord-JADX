package p007b.p225i.p361c.p369m.p370d.p384s.p386i;

import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractSpiCall;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequest;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequestFactory;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpResponse;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppRequestData;

/* compiled from: AbstractAppSpiCall.java */
/* renamed from: b.i.c.m.d.s.i.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractAppSpiCall extends AbstractSpiCall {

    /* renamed from: f */
    public final String f12772f;

    public AbstractAppSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, int i, String str3) {
        super(str, str2, httpRequestFactory, i);
        this.f12772f = str3;
    }

    /* renamed from: d */
    public boolean m6691d(AppRequestData appRequestData, boolean z2) {
        if (!z2) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        HttpRequest httpRequestM6390b = m6390b();
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-ORG-ID", appRequestData.f12740a);
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-GOOGLE-APP-ID", appRequestData.f12741b);
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        httpRequestM6390b.f12661e.put("X-CRASHLYTICS-API-CLIENT-VERSION", this.f12772f);
        httpRequestM6390b.m6622b("org_id", appRequestData.f12740a);
        httpRequestM6390b.m6622b("app[identifier]", appRequestData.f12742c);
        httpRequestM6390b.m6622b("app[name]", appRequestData.f12746g);
        httpRequestM6390b.m6622b("app[display_version]", appRequestData.f12743d);
        httpRequestM6390b.m6622b("app[build_version]", appRequestData.f12744e);
        httpRequestM6390b.m6622b("app[source]", Integer.toString(appRequestData.f12747h));
        httpRequestM6390b.m6622b("app[minimum_sdk_version]", appRequestData.f12748i);
        httpRequestM6390b.m6622b("app[built_sdk_version]", "0");
        if (!CommonUtils.m6426t(appRequestData.f12745f)) {
            httpRequestM6390b.m6622b("app[instance_identifier]", appRequestData.f12745f);
        }
        Logger3 logger3 = Logger3.f12227a;
        StringBuilder sbM833U = outline.m833U("Sending app info to ");
        sbM833U.append(this.f12253b);
        logger3.m6371b(sbM833U.toString());
        try {
            HttpResponse httpResponseM6621a = httpRequestM6390b.m6621a();
            int i = httpResponseM6621a.f12663a;
            logger3.m6371b((ShareTarget.METHOD_POST.equalsIgnoreCase(C1563b.m764n(httpRequestM6390b.f12658b)) ? "Create" : "Update") + " app request ID: " + httpResponseM6621a.f12665c.m10954c("X-REQUEST-ID"));
            StringBuilder sb = new StringBuilder();
            sb.append("Result was ");
            sb.append(i);
            logger3.m6371b(sb.toString());
            return C3404f.m4241R0(i) == 0;
        } catch (IOException e) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "HTTP request failed.", e);
            }
            throw new RuntimeException(e);
        }
    }
}
