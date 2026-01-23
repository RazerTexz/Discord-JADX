package p007b.p109f.p132g.p138b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayList;
import p007b.p109f.p132g.p138b.DeferredReleaser;

/* JADX INFO: renamed from: b.f.g.b.b, reason: use source file name */
/* JADX INFO: compiled from: DeferredReleaserConcurrentImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class DeferredReleaserConcurrentImpl extends DeferredReleaser {

    /* JADX INFO: renamed from: b */
    public final Object f3254b = new Object();

    /* JADX INFO: renamed from: f */
    public final Runnable f3258f = new a();

    /* JADX INFO: renamed from: d */
    public ArrayList<DeferredReleaser.a> f3256d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    public ArrayList<DeferredReleaser.a> f3257e = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    public final Handler f3255c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b.f.g.b.b$a */
    /* JADX INFO: compiled from: DeferredReleaserConcurrentImpl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            ArrayList<DeferredReleaser.a> arrayList;
            synchronized (DeferredReleaserConcurrentImpl.this.f3254b) {
                DeferredReleaserConcurrentImpl deferredReleaserConcurrentImpl = DeferredReleaserConcurrentImpl.this;
                ArrayList<DeferredReleaser.a> arrayList2 = deferredReleaserConcurrentImpl.f3257e;
                arrayList = deferredReleaserConcurrentImpl.f3256d;
                deferredReleaserConcurrentImpl.f3257e = arrayList;
                deferredReleaserConcurrentImpl.f3256d = arrayList2;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                DeferredReleaserConcurrentImpl.this.f3257e.get(i).release();
            }
            DeferredReleaserConcurrentImpl.this.f3257e.clear();
        }
    }

    @Override // p007b.p109f.p132g.p138b.DeferredReleaser
    @AnyThread
    /* JADX INFO: renamed from: a */
    public void mo1083a(DeferredReleaser.a aVar) {
        synchronized (this.f3254b) {
            this.f3256d.remove(aVar);
        }
    }
}
