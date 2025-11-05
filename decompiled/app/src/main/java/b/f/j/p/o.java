package b.f.j.p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: DelayProducer.java */
/* loaded from: classes3.dex */
public class o implements w0<CloseableReference<b.f.j.j.c>> {
    public final w0<CloseableReference<b.f.j.j.c>> a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f631b;

    /* compiled from: DelayProducer.java */
    public class a implements Runnable {
        public final /* synthetic */ l j;
        public final /* synthetic */ x0 k;

        public a(l lVar, x0 x0Var) {
            this.j = lVar;
            this.k = x0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.a.b(this.j, this.k);
        }
    }

    public o(w0<CloseableReference<b.f.j.j.c>> w0Var, ScheduledExecutorService scheduledExecutorService) {
        this.a = w0Var;
        this.f631b = scheduledExecutorService;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        ImageRequest imageRequestE = x0Var.e();
        ScheduledExecutorService scheduledExecutorService = this.f631b;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new a(lVar, x0Var), imageRequestE.u, TimeUnit.MILLISECONDS);
        } else {
            this.a.b(lVar, x0Var);
        }
    }
}
