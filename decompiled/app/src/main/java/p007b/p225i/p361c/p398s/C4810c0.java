package p007b.p225i.p361c.p398s;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* renamed from: b.i.c.s.c0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C4810c0 implements InterfaceC4357c {

    /* renamed from: a */
    public final ScheduledFuture f12850a;

    public C4810c0(ScheduledFuture scheduledFuture) {
        this.f12850a = scheduledFuture;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
    public final void onComplete(Task task) {
        this.f12850a.cancel(false);
    }
}
