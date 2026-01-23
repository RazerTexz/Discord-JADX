package p007b.p225i.p361c.p406w;

import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.messaging.EnhancedIntentService;

/* JADX INFO: renamed from: b.i.c.w.d */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4866d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final EnhancedIntentService f13017j;

    /* JADX INFO: renamed from: k */
    public final Intent f13018k;

    /* JADX INFO: renamed from: l */
    public final TaskCompletionSource f13019l;

    public RunnableC4866d(EnhancedIntentService enhancedIntentService, Intent intent, TaskCompletionSource taskCompletionSource) {
        this.f13017j = enhancedIntentService;
        this.f13018k = intent;
        this.f13019l = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13017j.lambda$processIntent$0$EnhancedIntentService(this.f13018k, this.f13019l);
    }
}
