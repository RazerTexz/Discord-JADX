package b.f.g.b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import b.f.g.b.a;
import java.util.ArrayList;

/* compiled from: DeferredReleaserConcurrentImpl.java */
/* loaded from: classes.dex */
public class b extends b.f.g.b.a {

    /* renamed from: b, reason: collision with root package name */
    public final Object f493b = new Object();
    public final Runnable f = new a();
    public ArrayList<a.InterfaceC0068a> d = new ArrayList<>();
    public ArrayList<a.InterfaceC0068a> e = new ArrayList<>();
    public final Handler c = new Handler(Looper.getMainLooper());

    /* compiled from: DeferredReleaserConcurrentImpl.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            ArrayList<a.InterfaceC0068a> arrayList;
            synchronized (b.this.f493b) {
                b bVar = b.this;
                ArrayList<a.InterfaceC0068a> arrayList2 = bVar.e;
                arrayList = bVar.d;
                bVar.e = arrayList;
                bVar.d = arrayList2;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                b.this.e.get(i).release();
            }
            b.this.e.clear();
        }
    }

    @Override // b.f.g.b.a
    @AnyThread
    public void a(a.InterfaceC0068a interfaceC0068a) {
        synchronized (this.f493b) {
            this.d.remove(interfaceC0068a);
        }
    }
}
