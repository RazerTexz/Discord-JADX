package p007b.p225i.p226a.p288f.p298d;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;

/* JADX INFO: renamed from: b.i.a.f.d.x */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3249x implements InterfaceC4357c {

    /* JADX INFO: renamed from: a */
    public final C3227b f9291a;

    /* JADX INFO: renamed from: b */
    public final String f9292b;

    /* JADX INFO: renamed from: c */
    public final ScheduledFuture f9293c;

    public C3249x(C3227b c3227b, String str, ScheduledFuture scheduledFuture) {
        this.f9291a = c3227b;
        this.f9292b = str;
        this.f9293c = scheduledFuture;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
    public final void onComplete(Task task) {
        C3227b c3227b = this.f9291a;
        String str = this.f9292b;
        ScheduledFuture scheduledFuture = this.f9293c;
        synchronized (c3227b.f9246d) {
            c3227b.f9246d.remove(str);
        }
        scheduledFuture.cancel(false);
    }
}
