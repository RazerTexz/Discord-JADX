package b.i.a.g.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager.java */
/* loaded from: classes3.dex */
public class a {
    public static a a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Object f1624b = new Object();

    @NonNull
    public final Handler c = new Handler(Looper.getMainLooper(), new C0124a());

    @Nullable
    public c d;

    @Nullable
    public c e;

    /* compiled from: SnackbarManager.java */
    /* renamed from: b.i.a.g.h.a$a, reason: collision with other inner class name */
    public class C0124a implements Handler.Callback {
        public C0124a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            a aVar = a.this;
            c cVar = (c) message.obj;
            synchronized (aVar.f1624b) {
                if (aVar.d == cVar || aVar.e == cVar) {
                    aVar.a(cVar, 2);
                }
            }
            return true;
        }
    }

    /* compiled from: SnackbarManager.java */
    public interface b {
        void a(int i);

        void show();
    }

    /* compiled from: SnackbarManager.java */
    public static class c {

        @NonNull
        public final WeakReference<b> a;

        /* renamed from: b, reason: collision with root package name */
        public int f1625b;
        public boolean c;

        public c(int i, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.f1625b = i;
        }
    }

    public static a b() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public final boolean a(@NonNull c cVar, int i) {
        b bVar = cVar.a.get();
        if (bVar == null) {
            return false;
        }
        this.c.removeCallbacksAndMessages(cVar);
        bVar.a(i);
        return true;
    }

    public final boolean c(b bVar) {
        c cVar = this.d;
        if (cVar != null) {
            return bVar != null && cVar.a.get() == bVar;
        }
        return false;
    }

    public final boolean d(b bVar) {
        c cVar = this.e;
        if (cVar != null) {
            return bVar != null && cVar.a.get() == bVar;
        }
        return false;
    }

    public void e(b bVar) {
        synchronized (this.f1624b) {
            if (c(bVar)) {
                c cVar = this.d;
                if (!cVar.c) {
                    cVar.c = true;
                    this.c.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    public void f(b bVar) {
        synchronized (this.f1624b) {
            if (c(bVar)) {
                c cVar = this.d;
                if (cVar.c) {
                    cVar.c = false;
                    g(cVar);
                }
            }
        }
    }

    public final void g(@NonNull c cVar) {
        int i = cVar.f1625b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.c.removeCallbacksAndMessages(cVar);
        Handler handler = this.c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
    }

    public final void h() {
        c cVar = this.e;
        if (cVar != null) {
            this.d = cVar;
            this.e = null;
            b bVar = cVar.a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.d = null;
            }
        }
    }
}
