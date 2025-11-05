package b.i.c.m.d.k;

import com.google.android.gms.tasks.Task;
import java.io.FilenameFilter;
import java.util.concurrent.CountDownLatch;

/* compiled from: Utils.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class g1 implements b.i.a.f.n.a {
    public final CountDownLatch a;

    public g1(CountDownLatch countDownLatch) {
        this.a = countDownLatch;
    }

    @Override // b.i.a.f.n.a
    public Object a(Task task) {
        CountDownLatch countDownLatch = this.a;
        FilenameFilter filenameFilter = h1.a;
        countDownLatch.countDown();
        return null;
    }
}
