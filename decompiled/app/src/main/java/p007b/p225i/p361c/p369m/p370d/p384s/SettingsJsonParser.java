package p007b.p225i.p361c.p369m.p370d.p384s;

import org.json.JSONException;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.p373k.SystemCurrentTimeProvider;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.SettingsData;

/* compiled from: SettingsJsonParser.java */
/* renamed from: b.i.c.m.d.s.e, reason: use source file name */
/* loaded from: classes3.dex */
public class SettingsJsonParser {

    /* renamed from: a */
    public final SystemCurrentTimeProvider f12739a;

    public SettingsJsonParser(SystemCurrentTimeProvider systemCurrentTimeProvider) {
        this.f12739a = systemCurrentTimeProvider;
    }

    /* renamed from: a */
    public SettingsData m6688a(JSONObject jSONObject) throws JSONException {
        return (jSONObject.getInt("settings_version") != 3 ? new DefaultSettingsJsonTransform() : new SettingsV3JsonTransform()).mo6682a(this.f12739a, jSONObject);
    }
}
