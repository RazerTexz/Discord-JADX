package p007b.p225i.p361c.p398s;

import android.util.Log;
import p007b.p225i.p361c.p398s.ServiceConnectionC4812d0;

/* JADX INFO: renamed from: b.i.c.s.b0 */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4808b0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final ServiceConnectionC4812d0.a f12847j;

    public RunnableC4808b0(ServiceConnectionC4812d0.a aVar) {
        this.f12847j = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ServiceConnectionC4812d0.a aVar = this.f12847j;
        String action = aVar.f12858a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        aVar.m6723a();
    }
}
