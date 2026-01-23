package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p299e.p308o.p309j.ThreadFactoryC3408a;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p398s.C4817h;
import p007b.p225i.p361c.p398s.C4818i;
import p007b.p225i.p361c.p398s.C4820k;
import p007b.p225i.p361c.p398s.C4821l;
import p007b.p225i.p361c.p398s.C4823n;
import p007b.p225i.p361c.p398s.C4825p;
import p007b.p225i.p361c.p398s.C4826q;
import p007b.p225i.p361c.p398s.C4829t;
import p007b.p225i.p361c.p398s.C4830u;
import p007b.p225i.p361c.p398s.C4832w;
import p007b.p225i.p361c.p398s.ExecutorC4819j;
import p007b.p225i.p361c.p398s.InterfaceC4824o;
import p007b.p225i.p361c.p398s.RunnableC4833x;
import p007b.p225i.p361c.p400t.Provider2;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p407x.UserAgentPublisher;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class FirebaseInstanceId {

    /* JADX INFO: renamed from: b */
    public static C4832w f21433b;

    /* JADX INFO: renamed from: d */
    public static ScheduledExecutorService f21435d;

    /* JADX INFO: renamed from: e */
    public final Executor f21436e;

    /* JADX INFO: renamed from: f */
    public final FirebaseApp2 f21437f;

    /* JADX INFO: renamed from: g */
    public final C4826q f21438g;

    /* JADX INFO: renamed from: h */
    public final C4823n f21439h;

    /* JADX INFO: renamed from: i */
    public final C4830u f21440i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC4843g f21441j;

    /* JADX INFO: renamed from: k */
    public boolean f21442k;

    /* JADX INFO: renamed from: a */
    public static final long f21432a = TimeUnit.HOURS.toSeconds(8);

    /* JADX INFO: renamed from: c */
    public static final Pattern f21434c = Pattern.compile("\\AA[\\w-]{38}\\z");

    public FirebaseInstanceId(FirebaseApp2 firebaseApp2, Provider2<UserAgentPublisher> provider2, Provider2<HeartBeatInfo> provider22, InterfaceC4843g interfaceC4843g) {
        firebaseApp2.m6330a();
        C4826q c4826q = new C4826q(firebaseApp2.f12118d);
        ExecutorService executorServiceM6726a = C4817h.m6726a();
        ExecutorService executorServiceM6726a2 = C4817h.m6726a();
        this.f21442k = false;
        if (C4826q.m6730b(firebaseApp2) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            if (f21433b == null) {
                firebaseApp2.m6330a();
                f21433b = new C4832w(firebaseApp2.f12118d);
            }
        }
        this.f21437f = firebaseApp2;
        this.f21438g = c4826q;
        this.f21439h = new C4823n(firebaseApp2, c4826q, provider2, provider22, interfaceC4843g);
        this.f21436e = executorServiceM6726a2;
        this.f21440i = new C4830u(executorServiceM6726a);
        this.f21441j = interfaceC4843g;
    }

    /* JADX INFO: renamed from: a */
    public static <T> T m9177a(@NonNull Task<T> task) throws InterruptedException {
        AnimatableValueParser.m595z(task, "Task must not be null");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.mo6008c(ExecutorC4819j.f12870j, new C4820k(countDownLatch));
        countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
        if (task.mo6021p()) {
            return task.mo6017l();
        }
        if (task.mo6019n()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.mo6020o()) {
            throw new IllegalStateException(task.mo6016k());
        }
        throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
    }

    /* JADX INFO: renamed from: c */
    public static void m9178c(@NonNull FirebaseApp2 firebaseApp2) {
        firebaseApp2.m6330a();
        AnimatableValueParser.m579v(firebaseApp2.f12120f.f12140g, "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        firebaseApp2.m6330a();
        AnimatableValueParser.m579v(firebaseApp2.f12120f.f12135b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        firebaseApp2.m6330a();
        AnimatableValueParser.m579v(firebaseApp2.f12120f.f12134a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        firebaseApp2.m6330a();
        AnimatableValueParser.m551o(firebaseApp2.f12120f.f12135b.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        firebaseApp2.m6330a();
        AnimatableValueParser.m551o(f21434c.matcher(firebaseApp2.f12120f.f12134a).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp2 firebaseApp2) {
        m9178c(firebaseApp2);
        firebaseApp2.m6330a();
        FirebaseInstanceId firebaseInstanceId = (FirebaseInstanceId) firebaseApp2.f12121g.mo6346a(FirebaseInstanceId.class);
        AnimatableValueParser.m595z(firebaseInstanceId, "Firebase Instance ID component is not present");
        return firebaseInstanceId;
    }

    /* JADX INFO: renamed from: l */
    public static boolean m9179l() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    /* JADX INFO: renamed from: b */
    public String m9180b() throws IOException {
        String strM6730b = C4826q.m6730b(this.f21437f);
        m9178c(this.f21437f);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        try {
            return ((InterfaceC4824o) C3404f.m4307k(m9184g(strM6730b, "*"), 30000L, TimeUnit.MILLISECONDS)).mo6729a();
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (!(cause instanceof IOException)) {
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new IOException(e);
            }
            if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                synchronized (this) {
                    f21433b.m6740c();
                }
            }
            throw ((IOException) cause);
        }
    }

    /* JADX INFO: renamed from: d */
    public void m9181d(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (f21435d == null) {
                f21435d = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC3408a("FirebaseInstanceId"));
            }
            f21435d.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: renamed from: e */
    public String m9182e() {
        try {
            C4832w c4832w = f21433b;
            String strM6331c = this.f21437f.m6331c();
            synchronized (c4832w) {
                c4832w.f12903c.put(strM6331c, Long.valueOf(c4832w.m6741d(strM6331c)));
            }
            return (String) m9177a(this.f21441j.getId());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    @NonNull
    @Deprecated
    /* JADX INFO: renamed from: f */
    public Task<InterfaceC4824o> m9183f() {
        m9178c(this.f21437f);
        return m9184g(C4826q.m6730b(this.f21437f), "*");
    }

    /* JADX INFO: renamed from: g */
    public final Task<InterfaceC4824o> m9184g(String str, String str2) {
        if (str2.isEmpty() || str2.equalsIgnoreCase("fcm") || str2.equalsIgnoreCase("gcm")) {
            str2 = "*";
        }
        return C3404f.m4264Z(null).mo6015j(this.f21436e, new C4818i(this, str, str2));
    }

    /* JADX INFO: renamed from: h */
    public final String m9185h() {
        FirebaseApp2 firebaseApp2 = this.f21437f;
        firebaseApp2.m6330a();
        return "[DEFAULT]".equals(firebaseApp2.f12119e) ? "" : this.f21437f.m6331c();
    }

    @Nullable
    @Deprecated
    /* JADX INFO: renamed from: i */
    public String m9186i() {
        m9178c(this.f21437f);
        C4832w.a aVarM9187j = m9187j();
        if (m9192p(aVarM9187j)) {
            synchronized (this) {
                if (!this.f21442k) {
                    m9191o(0L);
                }
            }
        }
        int i = C4832w.a.f12905b;
        if (aVarM9187j == null) {
            return null;
        }
        return aVarM9187j.f12906c;
    }

    @Nullable
    /* JADX INFO: renamed from: j */
    public C4832w.a m9187j() {
        return m9188k(C4826q.m6730b(this.f21437f), "*");
    }

    @Nullable
    /* JADX INFO: renamed from: k */
    public C4832w.a m9188k(String str, String str2) {
        C4832w.a aVarM6743b;
        C4832w c4832w = f21433b;
        String strM9185h = m9185h();
        synchronized (c4832w) {
            aVarM6743b = C4832w.a.m6743b(c4832w.f12901a.getString(c4832w.m6739b(strM9185h, str, str2), null));
        }
        return aVarM6743b;
    }

    /* JADX INFO: renamed from: m */
    public final Task m9189m(String str, String str2) throws Exception {
        Task<InterfaceC4824o> taskMo6015j;
        String strM9182e = m9182e();
        C4832w.a aVarM9188k = m9188k(str, str2);
        if (!m9192p(aVarM9188k)) {
            return C3404f.m4264Z(new C4825p(strM9182e, aVarM9188k.f12906c));
        }
        C4830u c4830u = this.f21440i;
        synchronized (c4830u) {
            Pair<String, String> pair = new Pair<>(str, str2);
            taskMo6015j = c4830u.f12895b.get(pair);
            if (taskMo6015j == null) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String strValueOf = String.valueOf(pair);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                    sb.append("Making new request for: ");
                    sb.append(strValueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                C4823n c4823n = this.f21439h;
                Objects.requireNonNull(c4823n);
                taskMo6015j = c4823n.m6727a(c4823n.m6728b(strM9182e, str, str2, new Bundle())).mo6023r(this.f21436e, new C4821l(this, str, str2, strM9182e)).mo6015j(c4830u.f12894a, new C4829t(c4830u, pair));
                c4830u.f12895b.put(pair, taskMo6015j);
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf2 = String.valueOf(pair);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 29);
                sb2.append("Joining ongoing request for: ");
                sb2.append(strValueOf2);
                Log.d("FirebaseInstanceId", sb2.toString());
            }
        }
        return taskMo6015j;
    }

    /* JADX INFO: renamed from: n */
    public synchronized void m9190n(boolean z2) {
        this.f21442k = z2;
    }

    /* JADX INFO: renamed from: o */
    public synchronized void m9191o(long j) {
        m9181d(new RunnableC4833x(this, Math.min(Math.max(30L, j << 1), f21432a)), j);
        this.f21442k = true;
    }

    /* JADX INFO: renamed from: p */
    public boolean m9192p(@Nullable C4832w.a aVar) {
        if (aVar != null) {
            if (!(System.currentTimeMillis() > aVar.f12908e + C4832w.a.f12904a || !this.f21438g.m6731a().equals(aVar.f12907d))) {
                return false;
            }
        }
        return true;
    }
}
