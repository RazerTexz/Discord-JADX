package p007b.p225i.p361c.p369m.p370d.p384s;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p007b.p225i.p361c.p369m.p370d.p373k.DataCollectionArbiter;
import p007b.p225i.p361c.p369m.p370d.p373k.SystemCurrentTimeProvider;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequest;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpResponse;
import p007b.p225i.p361c.p369m.p370d.p378o.FileStoreImpl;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.FeaturesSettingsData;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.SessionSettingsData;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.Settings2;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.SettingsData;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.SettingsRequest;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.DefaultSettingsSpiCall;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.SettingsSpiCall;

/* compiled from: SettingsController.java */
/* renamed from: b.i.c.m.d.s.c, reason: use source file name */
/* loaded from: classes3.dex */
public class SettingsController implements SettingsDataProvider {

    /* renamed from: a */
    public final Context f12729a;

    /* renamed from: b */
    public final SettingsRequest f12730b;

    /* renamed from: c */
    public final SettingsJsonParser f12731c;

    /* renamed from: d */
    public final SystemCurrentTimeProvider f12732d;

    /* renamed from: e */
    public final CachedSettingsIo f12733e;

    /* renamed from: f */
    public final SettingsSpiCall f12734f;

    /* renamed from: g */
    public final DataCollectionArbiter f12735g;

    /* renamed from: h */
    public final AtomicReference<Settings2> f12736h;

    /* renamed from: i */
    public final AtomicReference<TaskCompletionSource<AppSettingsData>> f12737i;

    /* compiled from: SettingsController.java */
    /* renamed from: b.i.c.m.d.s.c$a */
    public class a implements InterfaceC4362f<Void, Void> {
        public a() {
        }

        @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
        @NonNull
        /* renamed from: a */
        public Task<Void> mo4013a(@Nullable Void r11) throws Exception {
            JSONObject jSONObjectM6695g;
            FileWriter fileWriter;
            SettingsController settingsController = SettingsController.this;
            SettingsSpiCall settingsSpiCall = settingsController.f12734f;
            SettingsRequest settingsRequest = settingsController.f12730b;
            DefaultSettingsSpiCall defaultSettingsSpiCall = (DefaultSettingsSpiCall) settingsSpiCall;
            Objects.requireNonNull(defaultSettingsSpiCall);
            FileWriter fileWriter2 = null;
            try {
                Map<String, String> mapM6694f = defaultSettingsSpiCall.m6694f(settingsRequest);
                HttpRequest httpRequestM6391c = defaultSettingsSpiCall.m6391c(mapM6694f);
                defaultSettingsSpiCall.m6692d(httpRequestM6391c, settingsRequest);
                defaultSettingsSpiCall.f12773f.m6371b("Requesting settings from " + defaultSettingsSpiCall.f12253b);
                defaultSettingsSpiCall.f12773f.m6371b("Settings query params were: " + mapM6694f);
                HttpResponse httpResponseM6621a = httpRequestM6391c.m6621a();
                defaultSettingsSpiCall.f12773f.m6371b("Settings request ID: " + httpResponseM6621a.f12665c.m10954c("X-REQUEST-ID"));
                jSONObjectM6695g = defaultSettingsSpiCall.m6695g(httpResponseM6621a);
            } catch (IOException e) {
                if (defaultSettingsSpiCall.f12773f.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Settings request failed.", e);
                }
                jSONObjectM6695g = null;
            }
            if (jSONObjectM6695g != null) {
                SettingsData settingsDataM6688a = SettingsController.this.f12731c.m6688a(jSONObjectM6695g);
                CachedSettingsIo cachedSettingsIo = SettingsController.this.f12733e;
                long j = settingsDataM6688a.f12762d;
                Objects.requireNonNull(cachedSettingsIo);
                Logger3.f12227a.m6371b("Writing settings to cache file...");
                try {
                    jSONObjectM6695g.put("expires_at", j);
                    fileWriter = new FileWriter(new File(new FileStoreImpl(cachedSettingsIo.f12728a).m6636a(), "com.crashlytics.settings.json"));
                    try {
                        fileWriter.write(jSONObjectM6695g.toString());
                        fileWriter.flush();
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            if (Logger3.f12227a.m6370a(6)) {
                                Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                            }
                            CommonUtils.m6409c(fileWriter, "Failed to close settings writer.");
                            SettingsController.this.m6687e(jSONObjectM6695g, "Loaded settings: ");
                            SettingsController settingsController2 = SettingsController.this;
                            String str = settingsController2.f12730b.f12768f;
                            SharedPreferences.Editor editorEdit = CommonUtils.m6421o(settingsController2.f12729a).edit();
                            editorEdit.putString("existing_instance_identifier", str);
                            editorEdit.apply();
                            SettingsController.this.f12736h.set(settingsDataM6688a);
                            SettingsController.this.f12737i.get().m9126b(settingsDataM6688a.f12759a);
                            TaskCompletionSource<AppSettingsData> taskCompletionSource = new TaskCompletionSource<>();
                            taskCompletionSource.m9126b(settingsDataM6688a.f12759a);
                            SettingsController.this.f12737i.set(taskCompletionSource);
                            return C3404f.m4264Z(null);
                        } catch (Throwable th) {
                            th = th;
                            fileWriter2 = fileWriter;
                            fileWriter = fileWriter2;
                            CommonUtils.m6409c(fileWriter, "Failed to close settings writer.");
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        CommonUtils.m6409c(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    CommonUtils.m6409c(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
                CommonUtils.m6409c(fileWriter, "Failed to close settings writer.");
                SettingsController.this.m6687e(jSONObjectM6695g, "Loaded settings: ");
                SettingsController settingsController22 = SettingsController.this;
                String str2 = settingsController22.f12730b.f12768f;
                SharedPreferences.Editor editorEdit2 = CommonUtils.m6421o(settingsController22.f12729a).edit();
                editorEdit2.putString("existing_instance_identifier", str2);
                editorEdit2.apply();
                SettingsController.this.f12736h.set(settingsDataM6688a);
                SettingsController.this.f12737i.get().m9126b(settingsDataM6688a.f12759a);
                TaskCompletionSource<AppSettingsData> taskCompletionSource2 = new TaskCompletionSource<>();
                taskCompletionSource2.m9126b(settingsDataM6688a.f12759a);
                SettingsController.this.f12737i.set(taskCompletionSource2);
            }
            return C3404f.m4264Z(null);
        }
    }

    public SettingsController(Context context, SettingsRequest settingsRequest, SystemCurrentTimeProvider systemCurrentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference<Settings2> atomicReference = new AtomicReference<>();
        this.f12736h = atomicReference;
        this.f12737i = new AtomicReference<>(new TaskCompletionSource());
        this.f12729a = context;
        this.f12730b = settingsRequest;
        this.f12732d = systemCurrentTimeProvider;
        this.f12731c = settingsJsonParser;
        this.f12733e = cachedSettingsIo;
        this.f12734f = settingsSpiCall;
        this.f12735g = dataCollectionArbiter;
        JSONObject jSONObject = new JSONObject();
        atomicReference.set(new SettingsData(DefaultSettingsJsonTransform.m6681b(systemCurrentTimeProvider, 3600L, jSONObject), null, new SessionSettingsData(jSONObject.optInt("max_custom_exception_events", 8), 4), new FeaturesSettingsData(jSONObject.optBoolean("collect_reports", true)), 0, 3600));
    }

    /* renamed from: a */
    public Task<AppSettingsData> m6683a() {
        return this.f12737i.get().f20845a;
    }

    /* renamed from: b */
    public final SettingsData m6684b(int i) throws Throwable {
        SettingsData settingsData = null;
        try {
        } catch (Exception e) {
            e = e;
        }
        if (!C1563b.m757g(2, i)) {
            JSONObject jSONObjectM6680a = this.f12733e.m6680a();
            if (jSONObjectM6680a != null) {
                SettingsData settingsDataM6688a = this.f12731c.m6688a(jSONObjectM6680a);
                if (settingsDataM6688a != null) {
                    m6687e(jSONObjectM6680a, "Loaded cached settings: ");
                    Objects.requireNonNull(this.f12732d);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (C1563b.m757g(3, i)) {
                        try {
                            Logger3.f12227a.m6371b("Returning cached settings.");
                            settingsData = settingsDataM6688a;
                        } catch (Exception e2) {
                            e = e2;
                            settingsData = settingsDataM6688a;
                            if (Logger3.f12227a.m6370a(6)) {
                                Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            }
                            return settingsData;
                        }
                    } else {
                        if (settingsDataM6688a.f12762d < jCurrentTimeMillis) {
                            Logger3.f12227a.m6371b("Cached settings have expired.");
                        } else {
                            Logger3.f12227a.m6371b("Returning cached settings.");
                            settingsData = settingsDataM6688a;
                        }
                    }
                    return settingsData;
                }
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Failed to parse cached settings data.", null);
                }
            } else {
                Logger3.f12227a.m6371b("No cached settings data found.");
            }
        }
        return settingsData;
    }

    /* renamed from: c */
    public Settings2 m6685c() {
        return this.f12736h.get();
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/Executor;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    /* renamed from: d */
    public Task m6686d(int i, Executor executor) throws Throwable {
        SettingsData settingsDataM6684b;
        if (!(!CommonUtils.m6421o(this.f12729a).getString("existing_instance_identifier", "").equals(this.f12730b.f12768f)) && (settingsDataM6684b = m6684b(i)) != null) {
            this.f12736h.set(settingsDataM6684b);
            this.f12737i.get().m9126b(settingsDataM6684b.f12759a);
            return C3404f.m4264Z(null);
        }
        SettingsData settingsDataM6684b2 = m6684b(3);
        if (settingsDataM6684b2 != null) {
            this.f12736h.set(settingsDataM6684b2);
            this.f12737i.get().m9126b(settingsDataM6684b2.f12759a);
        }
        return this.f12735g.m6451c().mo6023r(executor, new a());
    }

    /* renamed from: e */
    public final void m6687e(JSONObject jSONObject, String str) throws JSONException {
        Logger3 logger3 = Logger3.f12227a;
        StringBuilder sbM833U = outline.m833U(str);
        sbM833U.append(jSONObject.toString());
        logger3.m6371b(sbM833U.toString());
    }
}
