package p007b.p225i.p361c.p369m.p370d.p384s;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p007b.p225i.p361c.p369m.p370d.p378o.FileStoreImpl;

/* compiled from: CachedSettingsIo.java */
/* renamed from: b.i.c.m.d.s.a, reason: use source file name */
/* loaded from: classes3.dex */
public class CachedSettingsIo {

    /* renamed from: a */
    public final Context f12728a;

    public CachedSettingsIo(Context context) {
        this.f12728a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* renamed from: a */
    public JSONObject m6680a() throws Throwable {
        Exception e;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        Logger3 logger3 = Logger3.f12227a;
        logger3.m6371b("Reading cached settings...");
        ?? r2 = 0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(new FileStoreImpl(this.f12728a).m6636a(), "com.crashlytics.settings.json");
                if (file.exists()) {
                    fileInputStream = new FileInputStream(file);
                    try {
                        jSONObject = new JSONObject(CommonUtils.m6430x(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e2) {
                        e = e2;
                        if (Logger3.f12227a.m6370a(6)) {
                            Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        }
                        CommonUtils.m6409c(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    logger3.m6371b("No cached settings found.");
                    jSONObject = null;
                }
                CommonUtils.m6409c(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th) {
                r2 = logger3;
                th = th;
                CommonUtils.m6409c(r2, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.m6409c(r2, "Error while closing settings cache file.");
            throw th;
        }
    }
}
