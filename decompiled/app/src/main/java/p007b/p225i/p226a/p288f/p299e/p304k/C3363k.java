package p007b.p225i.p226a.p288f.p299e.p304k;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p288f.p299e.p300h.AbstractC3269d;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;

/* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* renamed from: b.i.a.f.e.k.k */
/* loaded from: classes3.dex */
public class C3363k {

    /* renamed from: a */
    public static final b f9531a = new C3381t();

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.k.k$a */
    public interface a<R extends InterfaceC3273h, T> {
        /* renamed from: a */
        T mo4165a(R r);
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    /* renamed from: b.i.a.f.e.k.k$b */
    public interface b {
    }

    /* renamed from: a */
    public static <R extends InterfaceC3273h> Task<Void> m4164a(AbstractC3269d<R> abstractC3269d) {
        C3383u c3383u = new C3383u();
        b bVar = f9531a;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        abstractC3269d.mo4051c(new C3379s(abstractC3269d, taskCompletionSource, c3383u, bVar));
        return taskCompletionSource.f20845a;
    }
}
