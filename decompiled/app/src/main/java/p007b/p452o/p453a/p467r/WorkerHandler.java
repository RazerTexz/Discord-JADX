package p007b.p452o.p453a.p467r;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import p007b.p452o.p453a.CameraLogger;

/* JADX INFO: renamed from: b.o.a.r.g, reason: use source file name */
/* JADX INFO: compiled from: WorkerHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class WorkerHandler {

    /* JADX INFO: renamed from: a */
    public static final CameraLogger f14127a = new CameraLogger(WorkerHandler.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public static final ConcurrentHashMap<String, WeakReference<WorkerHandler>> f14128b = new ConcurrentHashMap<>(4);

    /* JADX INFO: renamed from: c */
    public static WorkerHandler f14129c;

    /* JADX INFO: renamed from: d */
    public String f14130d;

    /* JADX INFO: renamed from: e */
    public HandlerThread f14131e;

    /* JADX INFO: renamed from: f */
    public Handler f14132f;

    /* JADX INFO: renamed from: g */
    public Executor f14133g;

    /* JADX INFO: renamed from: b.o.a.r.g$a */
    /* JADX INFO: compiled from: WorkerHandler.java */
    public class a extends HandlerThread {
        public a(WorkerHandler workerHandler, String str) {
            super(str);
        }

        @Override // java.lang.Thread
        @NonNull
        public String toString() {
            return super.toString() + "[" + getThreadId() + "]";
        }
    }

    /* JADX INFO: renamed from: b.o.a.r.g$b */
    /* JADX INFO: compiled from: WorkerHandler.java */
    public class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            WorkerHandler.this.m7404c(runnable);
        }
    }

    /* JADX INFO: renamed from: b.o.a.r.g$c */
    /* JADX INFO: compiled from: WorkerHandler.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ CountDownLatch f14135j;

        public c(WorkerHandler workerHandler, CountDownLatch countDownLatch) {
            this.f14135j = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14135j.countDown();
        }
    }

    public WorkerHandler(@NonNull String str) {
        this.f14130d = str;
        a aVar = new a(this, str);
        this.f14131e = aVar;
        aVar.setDaemon(true);
        this.f14131e.start();
        this.f14132f = new Handler(this.f14131e.getLooper());
        this.f14133g = new b();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f14132f.post(new c(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7402a(@NonNull Runnable runnable) {
        WorkerHandler workerHandlerM7403b = m7403b("FallbackCameraThread");
        f14129c = workerHandlerM7403b;
        workerHandlerM7403b.f14132f.post(runnable);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public static WorkerHandler m7403b(@NonNull String str) {
        ConcurrentHashMap<String, WeakReference<WorkerHandler>> concurrentHashMap = f14128b;
        if (concurrentHashMap.containsKey(str)) {
            WorkerHandler workerHandler = concurrentHashMap.get(str).get();
            if (workerHandler == null) {
                f14127a.m7159a(2, "get:", "Thread reference died. Removing.", str);
                concurrentHashMap.remove(str);
            } else {
                if (workerHandler.f14131e.isAlive() && !workerHandler.f14131e.isInterrupted()) {
                    f14127a.m7159a(2, "get:", "Reusing cached worker handler.", str);
                    return workerHandler;
                }
                HandlerThread handlerThread = workerHandler.f14131e;
                if (handlerThread.isAlive()) {
                    handlerThread.interrupt();
                    handlerThread.quit();
                }
                concurrentHashMap.remove(workerHandler.f14130d);
                f14127a.m7159a(2, "get:", "Thread reference found, but not alive or interrupted.", "Removing.", str);
                concurrentHashMap.remove(str);
            }
        }
        f14127a.m7159a(1, "get:", "Creating new handler.", str);
        WorkerHandler workerHandler2 = new WorkerHandler(str);
        concurrentHashMap.put(str, new WeakReference<>(workerHandler2));
        return workerHandler2;
    }

    /* JADX INFO: renamed from: c */
    public void m7404c(@NonNull Runnable runnable) {
        if (Thread.currentThread() == this.f14131e) {
            runnable.run();
        } else {
            this.f14132f.post(runnable);
        }
    }
}
