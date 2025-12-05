package p007b.p452o.p453a.p455n.p463v;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p467r.WorkerHandler;

/* compiled from: CameraOrchestrator.java */
/* renamed from: b.o.a.n.v.a, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraOrchestrator {

    /* renamed from: a */
    public static final CameraLogger f14005a = new CameraLogger(CameraOrchestrator.class.getSimpleName());

    /* renamed from: b */
    public final b f14006b;

    /* renamed from: c */
    public final ArrayDeque<c<?>> f14007c = new ArrayDeque<>();

    /* renamed from: d */
    public boolean f14008d = false;

    /* renamed from: e */
    public final Object f14009e = new Object();

    /* compiled from: CameraOrchestrator.java */
    /* renamed from: b.o.a.n.v.a$a */
    public class a implements Callable<Task<Void>> {

        /* renamed from: j */
        public final /* synthetic */ Runnable f14010j;

        public a(CameraOrchestrator cameraOrchestrator, Runnable runnable) {
            this.f14010j = runnable;
        }

        @Override // java.util.concurrent.Callable
        public Task<Void> call() throws Exception {
            this.f14010j.run();
            return C3404f.m4264Z(null);
        }
    }

    /* compiled from: CameraOrchestrator.java */
    /* renamed from: b.o.a.n.v.a$b */
    public interface b {
    }

    /* compiled from: CameraOrchestrator.java */
    /* renamed from: b.o.a.n.v.a$c */
    public static class c<T> {

        /* renamed from: a */
        public final String f14011a;

        /* renamed from: b */
        public final TaskCompletionSource<T> f14012b = new TaskCompletionSource<>();

        /* renamed from: c */
        public final Callable<Task<T>> f14013c;

        /* renamed from: d */
        public final boolean f14014d;

        /* renamed from: e */
        public final long f14015e;

        public c(String str, Callable callable, boolean z2, long j, a aVar) {
            this.f14011a = str;
            this.f14013c = callable;
            this.f14014d = z2;
            this.f14015e = j;
        }
    }

    public CameraOrchestrator(@NonNull b bVar) {
        this.f14006b = bVar;
    }

    /* renamed from: a */
    public static void m7362a(CameraOrchestrator cameraOrchestrator, c cVar) {
        if (!cameraOrchestrator.f14008d) {
            StringBuilder sbM833U = outline.m833U("mJobRunning was not true after completing job=");
            sbM833U.append(cVar.f14011a);
            throw new IllegalStateException(sbM833U.toString());
        }
        cameraOrchestrator.f14008d = false;
        cameraOrchestrator.f14007c.remove(cVar);
        WorkerHandler workerHandler = CameraEngine.this.f13919k;
        workerHandler.f14132f.postDelayed(new CameraOrchestrator2(cameraOrchestrator), 0L);
    }

    @NonNull
    /* renamed from: b */
    public Task<Void> m7363b(@NonNull String str, boolean z2, @NonNull Runnable runnable) {
        return m7365d(str, z2, 0L, new a(this, runnable));
    }

    @NonNull
    /* renamed from: c */
    public Task<Void> m7364c(@NonNull String str, boolean z2, long j, @NonNull Runnable runnable) {
        return m7365d(str, z2, j, new a(this, runnable));
    }

    @NonNull
    /* renamed from: d */
    public final <T> Task<T> m7365d(@NonNull String str, boolean z2, long j, @NonNull Callable<Task<T>> callable) {
        f14005a.m7159a(1, str.toUpperCase(), "- Scheduling.");
        c<?> cVar = new c<>(str, callable, z2, System.currentTimeMillis() + j, null);
        synchronized (this.f14009e) {
            this.f14007c.addLast(cVar);
            CameraEngine.this.f13919k.f14132f.postDelayed(new CameraOrchestrator2(this), j);
        }
        return cVar.f14012b.f20845a;
    }

    /* renamed from: e */
    public void m7366e(@NonNull String str, int i) {
        synchronized (this.f14009e) {
            ArrayList arrayList = new ArrayList();
            for (c<?> cVar : this.f14007c) {
                if (cVar.f14011a.equals(str)) {
                    arrayList.add(cVar);
                }
            }
            f14005a.m7159a(0, "trim: name=", str, "scheduled=", Integer.valueOf(arrayList.size()), "allowed=", Integer.valueOf(i));
            int iMax = Math.max(arrayList.size() - i, 0);
            if (iMax > 0) {
                Collections.reverse(arrayList);
                Iterator it = arrayList.subList(0, iMax).iterator();
                while (it.hasNext()) {
                    this.f14007c.remove((c) it.next());
                }
            }
        }
    }
}
