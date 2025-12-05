package p007b.p225i.p361c.p398s;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;
import java.util.concurrent.Executor;
import p007b.p225i.p361c.p398s.ServiceConnectionC4812d0;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* renamed from: b.i.c.s.a0 */
/* loaded from: classes3.dex */
public class BinderC4806a0 extends Binder {

    /* renamed from: a */
    public final a f12844a;

    /* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    /* renamed from: b.i.c.s.a0$a */
    public interface a {
    }

    public BinderC4806a0(a aVar) {
        this.f12844a = aVar;
    }

    /* renamed from: a */
    public void m6719a(ServiceConnectionC4812d0.a aVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
        }
        a aVar2 = this.f12844a;
        Task taskAccess$000 = EnhancedIntentService.access$000(EnhancedIntentService.this, aVar.f12858a);
        Executor executor = C4817h.f12866a;
        taskAccess$000.mo6008c(ExecutorC4816g.f12865j, new C4835z(aVar));
    }
}
