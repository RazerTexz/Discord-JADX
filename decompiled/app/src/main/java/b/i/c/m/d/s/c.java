package b.i.c.m.d.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.i.c.m.d.k.e1;
import b.i.c.m.d.k.q0;
import b.i.c.m.d.o.h;
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

/* compiled from: SettingsController.java */
/* loaded from: classes3.dex */
public class c implements d {
    public final Context a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.c.m.d.s.h.g f1747b;
    public final e c;
    public final e1 d;
    public final b.i.c.m.d.s.a e;
    public final b.i.c.m.d.s.i.d f;
    public final q0 g;
    public final AtomicReference<b.i.c.m.d.s.h.e> h;
    public final AtomicReference<TaskCompletionSource<b.i.c.m.d.s.h.b>> i;

    /* compiled from: SettingsController.java */
    public class a implements b.i.a.f.n.f<Void, Void> {
        public a() {
        }

        @Override // b.i.a.f.n.f
        @NonNull
        public Task<Void> a(@Nullable Void r11) throws Exception {
            JSONObject jSONObjectG;
            FileWriter fileWriter;
            c cVar = c.this;
            b.i.c.m.d.s.i.d dVar = cVar.f;
            b.i.c.m.d.s.h.g gVar = cVar.f1747b;
            b.i.c.m.d.s.i.c cVar2 = (b.i.c.m.d.s.i.c) dVar;
            Objects.requireNonNull(cVar2);
            FileWriter fileWriter2 = null;
            try {
                Map<String, String> mapF = cVar2.f(gVar);
                b.i.c.m.d.n.a aVarC = cVar2.c(mapF);
                cVar2.d(aVarC, gVar);
                cVar2.f.b("Requesting settings from " + cVar2.f1676b);
                cVar2.f.b("Settings query params were: " + mapF);
                b.i.c.m.d.n.c cVarA = aVarC.a();
                cVar2.f.b("Settings request ID: " + cVarA.c.c("X-REQUEST-ID"));
                jSONObjectG = cVar2.g(cVarA);
            } catch (IOException e) {
                if (cVar2.f.a(6)) {
                    Log.e("FirebaseCrashlytics", "Settings request failed.", e);
                }
                jSONObjectG = null;
            }
            if (jSONObjectG != null) {
                b.i.c.m.d.s.h.f fVarA = c.this.c.a(jSONObjectG);
                b.i.c.m.d.s.a aVar = c.this.e;
                long j = fVarA.d;
                Objects.requireNonNull(aVar);
                b.i.c.m.d.b.a.b("Writing settings to cache file...");
                try {
                    jSONObjectG.put("expires_at", j);
                    fileWriter = new FileWriter(new File(new h(aVar.a).a(), "com.crashlytics.settings.json"));
                    try {
                        fileWriter.write(jSONObjectG.toString());
                        fileWriter.flush();
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            if (b.i.c.m.d.b.a.a(6)) {
                                Log.e("FirebaseCrashlytics", "Failed to cache settings", e);
                            }
                            b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
                            c.this.e(jSONObjectG, "Loaded settings: ");
                            c cVar3 = c.this;
                            String str = cVar3.f1747b.f;
                            SharedPreferences.Editor editorEdit = b.i.c.m.d.k.h.o(cVar3.a).edit();
                            editorEdit.putString("existing_instance_identifier", str);
                            editorEdit.apply();
                            c.this.h.set(fVarA);
                            c.this.i.get().b(fVarA.a);
                            TaskCompletionSource<b.i.c.m.d.s.h.b> taskCompletionSource = new TaskCompletionSource<>();
                            taskCompletionSource.b(fVarA.a);
                            c.this.i.set(taskCompletionSource);
                            return b.i.a.f.e.o.f.Z(null);
                        } catch (Throwable th) {
                            th = th;
                            fileWriter2 = fileWriter;
                            fileWriter = fileWriter2;
                            b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileWriter = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileWriter = fileWriter2;
                    b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
                    throw th;
                }
                b.i.c.m.d.k.h.c(fileWriter, "Failed to close settings writer.");
                c.this.e(jSONObjectG, "Loaded settings: ");
                c cVar32 = c.this;
                String str2 = cVar32.f1747b.f;
                SharedPreferences.Editor editorEdit2 = b.i.c.m.d.k.h.o(cVar32.a).edit();
                editorEdit2.putString("existing_instance_identifier", str2);
                editorEdit2.apply();
                c.this.h.set(fVarA);
                c.this.i.get().b(fVarA.a);
                TaskCompletionSource<b.i.c.m.d.s.h.b> taskCompletionSource2 = new TaskCompletionSource<>();
                taskCompletionSource2.b(fVarA.a);
                c.this.i.set(taskCompletionSource2);
            }
            return b.i.a.f.e.o.f.Z(null);
        }
    }

    public c(Context context, b.i.c.m.d.s.h.g gVar, e1 e1Var, e eVar, b.i.c.m.d.s.a aVar, b.i.c.m.d.s.i.d dVar, q0 q0Var) {
        AtomicReference<b.i.c.m.d.s.h.e> atomicReference = new AtomicReference<>();
        this.h = atomicReference;
        this.i = new AtomicReference<>(new TaskCompletionSource());
        this.a = context;
        this.f1747b = gVar;
        this.d = e1Var;
        this.c = eVar;
        this.e = aVar;
        this.f = dVar;
        this.g = q0Var;
        JSONObject jSONObject = new JSONObject();
        atomicReference.set(new b.i.c.m.d.s.h.f(b.b(e1Var, 3600L, jSONObject), null, new b.i.c.m.d.s.h.d(jSONObject.optInt("max_custom_exception_events", 8), 4), new b.i.c.m.d.s.h.c(jSONObject.optBoolean("collect_reports", true)), 0, 3600));
    }

    public Task<b.i.c.m.d.s.h.b> a() {
        return this.i.get().a;
    }

    public final b.i.c.m.d.s.h.f b(int i) throws Throwable {
        b.i.c.m.d.s.h.f fVar = null;
        try {
        } catch (Exception e) {
            e = e;
        }
        if (!b.c.a.y.b.g(2, i)) {
            JSONObject jSONObjectA = this.e.a();
            if (jSONObjectA != null) {
                b.i.c.m.d.s.h.f fVarA = this.c.a(jSONObjectA);
                if (fVarA != null) {
                    e(jSONObjectA, "Loaded cached settings: ");
                    Objects.requireNonNull(this.d);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (b.c.a.y.b.g(3, i)) {
                        try {
                            b.i.c.m.d.b.a.b("Returning cached settings.");
                            fVar = fVarA;
                        } catch (Exception e2) {
                            e = e2;
                            fVar = fVarA;
                            if (b.i.c.m.d.b.a.a(6)) {
                                Log.e("FirebaseCrashlytics", "Failed to get cached settings", e);
                            }
                            return fVar;
                        }
                    } else {
                        if (fVarA.d < jCurrentTimeMillis) {
                            b.i.c.m.d.b.a.b("Cached settings have expired.");
                        } else {
                            b.i.c.m.d.b.a.b("Returning cached settings.");
                            fVar = fVarA;
                        }
                    }
                    return fVar;
                }
                if (b.i.c.m.d.b.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Failed to parse cached settings data.", null);
                }
            } else {
                b.i.c.m.d.b.a.b("No cached settings data found.");
            }
        }
        return fVar;
    }

    public b.i.c.m.d.s.h.e c() {
        return this.h.get();
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/Executor;)Lcom/google/android/gms/tasks/Task<Ljava/lang/Void;>; */
    public Task d(int i, Executor executor) throws Throwable {
        b.i.c.m.d.s.h.f fVarB;
        if (!(!b.i.c.m.d.k.h.o(this.a).getString("existing_instance_identifier", "").equals(this.f1747b.f)) && (fVarB = b(i)) != null) {
            this.h.set(fVarB);
            this.i.get().b(fVarB.a);
            return b.i.a.f.e.o.f.Z(null);
        }
        b.i.c.m.d.s.h.f fVarB2 = b(3);
        if (fVarB2 != null) {
            this.h.set(fVarB2);
            this.i.get().b(fVarB2.a);
        }
        return this.g.c().r(executor, new a());
    }

    public final void e(JSONObject jSONObject, String str) throws JSONException {
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        StringBuilder sbU = b.d.b.a.a.U(str);
        sbU.append(jSONObject.toString());
        bVar.b(sbU.toString());
    }
}
