package p007b.p225i.p361c.p406w;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.iid.FirebaseInstanceId;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import p007b.p225i.p361c.p398s.C4823n;
import p007b.p225i.p361c.p398s.C4826q;

/* JADX INFO: renamed from: b.i.c.w.x */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CallableC4886x implements Callable {

    /* JADX INFO: renamed from: j */
    public final Context f13054j;

    /* JADX INFO: renamed from: k */
    public final ScheduledExecutorService f13055k;

    /* JADX INFO: renamed from: l */
    public final FirebaseInstanceId f13056l;

    /* JADX INFO: renamed from: m */
    public final C4826q f13057m;

    /* JADX INFO: renamed from: n */
    public final C4823n f13058n;

    public CallableC4886x(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseInstanceId firebaseInstanceId, C4826q c4826q, C4823n c4823n) {
        this.f13054j = context;
        this.f13055k = scheduledExecutorService;
        this.f13056l = firebaseInstanceId;
        this.f13057m = c4826q;
        this.f13058n = c4823n;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        C4885w c4885w;
        Context context = this.f13054j;
        ScheduledExecutorService scheduledExecutorService = this.f13055k;
        FirebaseInstanceId firebaseInstanceId = this.f13056l;
        C4826q c4826q = this.f13057m;
        C4823n c4823n = this.f13058n;
        synchronized (C4885w.class) {
            WeakReference<C4885w> weakReference = C4885w.f13050a;
            c4885w = weakReference != null ? weakReference.get() : null;
            if (c4885w == null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
                C4885w c4885w2 = new C4885w(sharedPreferences, scheduledExecutorService);
                synchronized (c4885w2) {
                    c4885w2.f13052c = C4883u.m6828a(sharedPreferences, "topic_operation_queue", ",", scheduledExecutorService);
                }
                C4885w.f13050a = new WeakReference<>(c4885w2);
                c4885w = c4885w2;
            }
        }
        return new C4887y(firebaseInstanceId, c4826q, c4885w, c4823n, context, scheduledExecutorService);
    }
}
