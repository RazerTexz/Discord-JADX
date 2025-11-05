package b.i.c.m.d.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: CrashlyticsCore.java */
/* loaded from: classes3.dex */
public class k0 {
    public final Context a;

    /* renamed from: b, reason: collision with root package name */
    public final b.i.c.c f1689b;
    public final q0 c;
    public final long d;
    public m0 e;
    public m0 f;
    public boolean g;
    public x h;
    public final v0 i;
    public final b.i.c.m.d.j.a j;
    public final b.i.c.m.d.i.a k;
    public ExecutorService l;
    public i m;
    public b.i.c.m.d.a n;

    /* compiled from: CrashlyticsCore.java */
    public class a implements Runnable {
        public final /* synthetic */ b.i.c.m.d.s.d j;

        public a(b.i.c.m.d.s.d dVar) {
            this.j = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.a(k0.this, this.j);
        }
    }

    /* compiled from: CrashlyticsCore.java */
    public class b implements Callable<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                boolean zDelete = k0.this.e.b().delete();
                b.i.c.m.d.b.a.b("Initialization marker file removed: " + zDelete);
                return Boolean.valueOf(zDelete);
            } catch (Exception e) {
                if (b.i.c.m.d.b.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e);
                }
                return Boolean.FALSE;
            }
        }
    }

    public k0(b.i.c.c cVar, v0 v0Var, b.i.c.m.d.a aVar, q0 q0Var, b.i.c.m.d.j.a aVar2, b.i.c.m.d.i.a aVar3, ExecutorService executorService) {
        this.f1689b = cVar;
        this.c = q0Var;
        cVar.a();
        this.a = cVar.d;
        this.i = v0Var;
        this.n = aVar;
        this.j = aVar2;
        this.k = aVar3;
        this.l = executorService;
        this.m = new i(executorService);
        this.d = System.currentTimeMillis();
    }

    public static Task a(k0 k0Var, b.i.c.m.d.s.d dVar) {
        Task<Void> taskY;
        k0Var.m.a();
        k0Var.e.a();
        b.i.c.m.d.b bVar = b.i.c.m.d.b.a;
        bVar.b("Initialization marker file created.");
        x xVar = k0Var.h;
        i iVar = xVar.m;
        iVar.b(new j(iVar, new s(xVar)));
        try {
            try {
                k0Var.j.a(new i0(k0Var));
                b.i.c.m.d.s.c cVar = (b.i.c.m.d.s.c) dVar;
                b.i.c.m.d.s.h.e eVarC = cVar.c();
                if (eVarC.a().a) {
                    if (!k0Var.h.h(eVarC.b().a)) {
                        bVar.b("Could not finalize previous sessions.");
                    }
                    taskY = k0Var.h.u(1.0f, cVar.a());
                } else {
                    bVar.b("Collection of crash reports disabled in Crashlytics settings.");
                    taskY = b.i.a.f.e.o.f.Y(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
                }
            } catch (Exception e) {
                if (b.i.c.m.d.b.a.a(6)) {
                    Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", e);
                }
                taskY = b.i.a.f.e.o.f.Y(e);
            }
            return taskY;
        } finally {
            k0Var.c();
        }
    }

    public final void b(b.i.c.m.d.s.d dVar) {
        Future<?> futureSubmit = this.l.submit(new a(dVar));
        b.i.c.m.d.b.a.b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", e);
            }
        } catch (ExecutionException e2) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Problem encountered during Crashlytics initialization.", e2);
            }
        } catch (TimeoutException e3) {
            if (b.i.c.m.d.b.a.a(6)) {
                Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", e3);
            }
        }
    }

    public void c() {
        this.m.b(new b());
    }

    public void d(@Nullable Boolean bool) {
        Boolean boolA;
        q0 q0Var = this.c;
        synchronized (q0Var) {
            if (bool != null) {
                try {
                    q0Var.f = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bool != null) {
                boolA = bool;
            } else {
                b.i.c.c cVar = q0Var.f1693b;
                cVar.a();
                boolA = q0Var.a(cVar.d);
            }
            q0Var.g = boolA;
            SharedPreferences.Editor editorEdit = q0Var.a.edit();
            if (bool != null) {
                editorEdit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
            } else {
                editorEdit.remove("firebase_crashlytics_collection_enabled");
            }
            editorEdit.commit();
            synchronized (q0Var.c) {
                if (q0Var.b()) {
                    if (!q0Var.e) {
                        q0Var.d.b(null);
                        q0Var.e = true;
                    }
                } else if (q0Var.e) {
                    q0Var.d = new TaskCompletionSource<>();
                    q0Var.e = false;
                }
            }
        }
    }

    public void e(String str, String str2) {
        x xVar = this.h;
        Objects.requireNonNull(xVar);
        try {
            xVar.l.c(str, str2);
            xVar.m.b(new q(xVar, xVar.l.a()));
        } catch (IllegalArgumentException e) {
            Context context = xVar.i;
            if (context != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    throw e;
                }
            }
            b.i.c.m.d.b.a.d("Attempting to set custom attribute with null key, ignoring.");
        }
    }
}
