package p007b.p225i.p361c.p369m.p370d.p384s;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.p373k.SystemCurrentTimeProvider;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.FeaturesSettingsData;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.SessionSettingsData;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.SettingsData;

/* compiled from: DefaultSettingsJsonTransform.java */
/* renamed from: b.i.c.m.d.s.b, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    /* renamed from: b */
    public static long m6681b(SystemCurrentTimeProvider systemCurrentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.optLong("expires_at");
        }
        Objects.requireNonNull(systemCurrentTimeProvider);
        return (j * 1000) + System.currentTimeMillis();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p384s.SettingsJsonTransform
    /* renamed from: a */
    public SettingsData mo6682a(SystemCurrentTimeProvider systemCurrentTimeProvider, JSONObject jSONObject) throws JSONException {
        int iOptInt = jSONObject.optInt("settings_version", 0);
        int iOptInt2 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("app");
        return new SettingsData(m6681b(systemCurrentTimeProvider, iOptInt2, jSONObject), new AppSettingsData(jSONObject2.getString("status"), jSONObject2.getString("url"), jSONObject2.getString("reports_url"), jSONObject2.getString("ndk_reports_url"), jSONObject2.optBoolean("update_required", false)), new SessionSettingsData(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8), 4), new FeaturesSettingsData(jSONObject.getJSONObject("features").optBoolean("collect_reports", true)), iOptInt, iOptInt2);
    }
}
