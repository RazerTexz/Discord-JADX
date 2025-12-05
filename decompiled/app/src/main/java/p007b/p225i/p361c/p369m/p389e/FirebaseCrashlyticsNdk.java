package p007b.p225i.p361c.p369m.p389e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.ndk.JniNativeApi;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.NativeSessionFileProvider;

/* compiled from: FirebaseCrashlyticsNdk.java */
/* renamed from: b.i.c.m.e.c, reason: use source file name */
/* loaded from: classes3.dex */
public class FirebaseCrashlyticsNdk implements CrashlyticsNativeComponent {

    /* renamed from: a */
    public final NativeComponentController f12789a;

    public FirebaseCrashlyticsNdk(@NonNull NativeComponentController nativeComponentController) {
        this.f12789a = nativeComponentController;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent
    /* renamed from: a */
    public boolean mo6362a(@NonNull String str) {
        NdkCrashFilesManager ndkCrashFilesManager = ((BreakpadController) this.f12789a).f12787d;
        Objects.requireNonNull(ndkCrashFilesManager);
        NdkCrashFilesManager.m6701b(new File(ndkCrashFilesManager.f12790a, str));
        return true;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent
    @NonNull
    /* renamed from: b */
    public NativeSessionFileProvider mo6363b(@NonNull String str) {
        return new SessionFilesProvider(((BreakpadController) this.f12789a).m6699a(str));
    }

    @Override // p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent
    /* renamed from: c */
    public void mo6364c(@NonNull String str, int i, @NonNull String str2, int i2, long j, long j2, boolean z2, int i3, @NonNull String str3, @NonNull String str4) throws Throwable {
        BreakpadController breakpadController = (BreakpadController) this.f12789a;
        Objects.requireNonNull(breakpadController);
        HashMap map = new HashMap();
        map.put("arch", Integer.valueOf(i));
        map.put("build_model", str2);
        map.put("available_processors", Integer.valueOf(i2));
        map.put("total_ram", Long.valueOf(j));
        map.put("disk_space", Long.valueOf(j2));
        map.put("is_emulator", Boolean.valueOf(z2));
        map.put("state", Integer.valueOf(i3));
        map.put("build_manufacturer", str3);
        map.put("build_product", str4);
        breakpadController.m6700c(str, new JSONObject(map).toString(), "device.json");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent
    /* renamed from: d */
    public void mo6365d(@NonNull String str, @NonNull String str2, long j) throws Throwable {
        BreakpadController breakpadController = (BreakpadController) this.f12789a;
        Objects.requireNonNull(breakpadController);
        HashMap map = new HashMap();
        map.put("session_id", str);
        map.put("generator", str2);
        map.put("started_at_seconds", Long.valueOf(j));
        breakpadController.m6700c(str, new JSONObject(map).toString(), "session.json");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent
    /* renamed from: e */
    public boolean mo6366e(@NonNull String str) {
        File file;
        BreakpadController breakpadController = (BreakpadController) this.f12789a;
        NdkCrashFilesManager ndkCrashFilesManager = breakpadController.f12787d;
        Objects.requireNonNull(ndkCrashFilesManager);
        return new File(ndkCrashFilesManager.f12790a, str).exists() && (file = breakpadController.m6699a(str).f12791a) != null && file.exists();
    }

    @Override // p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent
    /* renamed from: f */
    public void mo6367f(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i, @NonNull String str6) throws Throwable {
        BreakpadController breakpadController = (BreakpadController) this.f12789a;
        Objects.requireNonNull(breakpadController);
        if (TextUtils.isEmpty(str6)) {
            str6 = "";
        }
        HashMap map = new HashMap();
        map.put("app_identifier", str2);
        map.put("version_code", str3);
        map.put("version_name", str4);
        map.put("install_uuid", str5);
        map.put("delivery_mechanism", Integer.valueOf(i));
        map.put("unity_version", str6);
        breakpadController.m6700c(str, new JSONObject(map).toString(), "app.json");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent
    /* renamed from: g */
    public void mo6368g(@NonNull String str, @NonNull String str2, @NonNull String str3, boolean z2) throws Throwable {
        BreakpadController breakpadController = (BreakpadController) this.f12789a;
        Objects.requireNonNull(breakpadController);
        HashMap map = new HashMap();
        map.put("version", str2);
        map.put("build_version", str3);
        map.put("is_rooted", Boolean.valueOf(z2));
        breakpadController.m6700c(str, new JSONObject(map).toString(), "os.json");
    }

    @Override // p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent
    /* renamed from: h */
    public boolean mo6369h(String str) {
        BreakpadController breakpadController = (BreakpadController) this.f12789a;
        File fileM6702a = breakpadController.f12787d.m6702a(str);
        boolean zM9176a = false;
        if (fileM6702a != null) {
            try {
                zM9176a = ((JniNativeApi) breakpadController.f12786c).m9176a(fileM6702a.getCanonicalPath(), breakpadController.f12785b.getAssets());
            } catch (IOException e) {
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Error initializing CrashlyticsNdk", e);
                }
            }
        }
        Logger3 logger3 = Logger3.f12227a;
        StringBuilder sbM833U = outline.m833U("Crashlytics NDK initialization ");
        sbM833U.append(zM9176a ? "successful" : "FAILED");
        logger3.m6375f(sbM833U.toString());
        return zM9176a;
    }
}
