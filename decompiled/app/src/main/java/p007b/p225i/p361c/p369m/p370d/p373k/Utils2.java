package p007b.p225i.p361c.p369m.p370d.p373k;

import com.google.android.gms.tasks.Task;
import java.io.FilenameFilter;
import java.util.concurrent.CountDownLatch;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: renamed from: b.i.c.m.d.k.g1, reason: use source file name */
/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Utils2 implements InterfaceC4353a {

    /* JADX INFO: renamed from: a */
    public final CountDownLatch f12296a;

    public Utils2(CountDownLatch countDownLatch) {
        this.f12296a = countDownLatch;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public Object mo4012a(Task task) {
        CountDownLatch countDownLatch = this.f12296a;
        FilenameFilter filenameFilter = Utils3.f12313a;
        countDownLatch.countDown();
        return null;
    }
}
