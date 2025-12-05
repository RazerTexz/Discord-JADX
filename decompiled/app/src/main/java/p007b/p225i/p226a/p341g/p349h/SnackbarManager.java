package p007b.p225i.p226a.p341g.p349h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager.java */
/* renamed from: b.i.a.g.h.a, reason: use source file name */
/* loaded from: classes3.dex */
public class SnackbarManager {

    /* renamed from: a */
    public static SnackbarManager f11762a;

    /* renamed from: b */
    @NonNull
    public final Object f11763b = new Object();

    /* renamed from: c */
    @NonNull
    public final Handler f11764c = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: d */
    @Nullable
    public c f11765d;

    /* renamed from: e */
    @Nullable
    public c f11766e;

    /* compiled from: SnackbarManager.java */
    /* renamed from: b.i.a.g.h.a$a */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            SnackbarManager snackbarManager = SnackbarManager.this;
            c cVar = (c) message.obj;
            synchronized (snackbarManager.f11763b) {
                if (snackbarManager.f11765d == cVar || snackbarManager.f11766e == cVar) {
                    snackbarManager.m6135a(cVar, 2);
                }
            }
            return true;
        }
    }

    /* compiled from: SnackbarManager.java */
    /* renamed from: b.i.a.g.h.a$b */
    public interface b {
        /* renamed from: a */
        void mo6142a(int i);

        void show();
    }

    /* compiled from: SnackbarManager.java */
    /* renamed from: b.i.a.g.h.a$c */
    public static class c {

        /* renamed from: a */
        @NonNull
        public final WeakReference<b> f11768a;

        /* renamed from: b */
        public int f11769b;

        /* renamed from: c */
        public boolean f11770c;

        public c(int i, b bVar) {
            this.f11768a = new WeakReference<>(bVar);
            this.f11769b = i;
        }
    }

    /* renamed from: b */
    public static SnackbarManager m6134b() {
        if (f11762a == null) {
            f11762a = new SnackbarManager();
        }
        return f11762a;
    }

    /* renamed from: a */
    public final boolean m6135a(@NonNull c cVar, int i) {
        b bVar = cVar.f11768a.get();
        if (bVar == null) {
            return false;
        }
        this.f11764c.removeCallbacksAndMessages(cVar);
        bVar.mo6142a(i);
        return true;
    }

    /* renamed from: c */
    public final boolean m6136c(b bVar) {
        c cVar = this.f11765d;
        if (cVar != null) {
            return bVar != null && cVar.f11768a.get() == bVar;
        }
        return false;
    }

    /* renamed from: d */
    public final boolean m6137d(b bVar) {
        c cVar = this.f11766e;
        if (cVar != null) {
            return bVar != null && cVar.f11768a.get() == bVar;
        }
        return false;
    }

    /* renamed from: e */
    public void m6138e(b bVar) {
        synchronized (this.f11763b) {
            if (m6136c(bVar)) {
                c cVar = this.f11765d;
                if (!cVar.f11770c) {
                    cVar.f11770c = true;
                    this.f11764c.removeCallbacksAndMessages(cVar);
                }
            }
        }
    }

    /* renamed from: f */
    public void m6139f(b bVar) {
        synchronized (this.f11763b) {
            if (m6136c(bVar)) {
                c cVar = this.f11765d;
                if (cVar.f11770c) {
                    cVar.f11770c = false;
                    m6140g(cVar);
                }
            }
        }
    }

    /* renamed from: g */
    public final void m6140g(@NonNull c cVar) {
        int i = cVar.f11769b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.f11764c.removeCallbacksAndMessages(cVar);
        Handler handler = this.f11764c;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
    }

    /* renamed from: h */
    public final void m6141h() {
        c cVar = this.f11766e;
        if (cVar != null) {
            this.f11765d = cVar;
            this.f11766e = null;
            b bVar = cVar.f11768a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f11765d = null;
            }
        }
    }
}
