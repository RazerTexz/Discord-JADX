package p007b.p225i.p361c.p369m.p370d.p384s.p386i;

import com.discord.restapi.RestAPIBuilder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.AbstractSpiCall;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p007b.p225i.p361c.p369m.p370d.p373k.IdManager;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequest;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequestFactory;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpResponse;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.SettingsRequest;

/* compiled from: DefaultSettingsSpiCall.java */
/* renamed from: b.i.c.m.d.s.i.c, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultSettingsSpiCall extends AbstractSpiCall implements SettingsSpiCall {

    /* renamed from: f */
    public Logger3 f12773f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSettingsSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory) {
        super(str, str2, httpRequestFactory, 1);
        Logger3 logger3 = Logger3.f12227a;
        this.f12773f = logger3;
    }

    /* renamed from: d */
    public final HttpRequest m6692d(HttpRequest httpRequest, SettingsRequest settingsRequest) {
        m6693e(httpRequest, "X-CRASHLYTICS-GOOGLE-APP-ID", settingsRequest.f12763a);
        m6693e(httpRequest, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m6693e(httpRequest, "X-CRASHLYTICS-API-CLIENT-VERSION", "17.3.0");
        m6693e(httpRequest, "Accept", RestAPIBuilder.CONTENT_TYPE_JSON);
        m6693e(httpRequest, "X-CRASHLYTICS-DEVICE-MODEL", settingsRequest.f12764b);
        m6693e(httpRequest, "X-CRASHLYTICS-OS-BUILD-VERSION", settingsRequest.f12765c);
        m6693e(httpRequest, "X-CRASHLYTICS-OS-DISPLAY-VERSION", settingsRequest.f12766d);
        m6693e(httpRequest, "X-CRASHLYTICS-INSTALLATION-ID", ((IdManager) settingsRequest.f12767e).m6456b());
        return httpRequest;
    }

    /* renamed from: e */
    public final void m6693e(HttpRequest httpRequest, String str, String str2) {
        if (str2 != null) {
            httpRequest.f12661e.put(str, str2);
        }
    }

    /* renamed from: f */
    public final Map<String, String> m6694f(SettingsRequest settingsRequest) {
        HashMap map = new HashMap();
        map.put("build_version", settingsRequest.f12770h);
        map.put("display_version", settingsRequest.f12769g);
        map.put("source", Integer.toString(settingsRequest.f12771i));
        String str = settingsRequest.f12768f;
        if (!CommonUtils.m6426t(str)) {
            map.put("instance", str);
        }
        return map;
    }

    /* renamed from: g */
    public JSONObject m6695g(HttpResponse httpResponse) {
        int i = httpResponse.f12663a;
        this.f12773f.m6371b("Settings result was: " + i);
        if (!(i == 200 || i == 201 || i == 202 || i == 203)) {
            Logger3 logger3 = this.f12773f;
            StringBuilder sbM833U = outline.m833U("Failed to retrieve settings from ");
            sbM833U.append(this.f12253b);
            logger3.m6373d(sbM833U.toString());
            return null;
        }
        String str = httpResponse.f12664b;
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            Logger3 logger32 = this.f12773f;
            StringBuilder sbM833U2 = outline.m833U("Failed to parse settings JSON from ");
            sbM833U2.append(this.f12253b);
            logger32.m6372c(sbM833U2.toString(), e);
            outline.m868o0("Settings response ", str, this.f12773f);
            return null;
        }
    }
}
