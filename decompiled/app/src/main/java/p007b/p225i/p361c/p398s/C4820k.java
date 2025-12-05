package p007b.p225i.p361c.p398s;

import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.concurrent.CountDownLatch;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4357c;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* renamed from: b.i.c.s.k */
/* loaded from: classes3.dex */
public final /* synthetic */ class C4820k implements InterfaceC4357c {

    /* renamed from: a */
    public final CountDownLatch f12871a;

    public C4820k(CountDownLatch countDownLatch) {
        this.f12871a = countDownLatch;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4357c
    public final void onComplete(Task task) {
        CountDownLatch countDownLatch = this.f12871a;
        C4832w c4832w = FirebaseInstanceId.f21433b;
        countDownLatch.countDown();
    }
}
