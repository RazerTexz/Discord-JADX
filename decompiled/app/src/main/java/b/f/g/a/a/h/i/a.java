package b.f.g.a.a.h.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import b.f.g.a.a.h.f;
import b.f.g.a.a.h.g;
import b.f.g.a.a.h.h;
import b.f.h.b.a.b;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.image.ImageInfo;
import java.io.Closeable;
import java.util.Objects;

/* compiled from: ImagePerfControllerListener2.java */
/* loaded from: classes.dex */
public class a extends b.f.h.b.a.a<ImageInfo> implements Closeable {
    public static Handler j;
    public final b.f.d.k.b k;
    public final h l;
    public final g m;
    public final Supplier<Boolean> n;
    public final Supplier<Boolean> o;

    /* compiled from: ImagePerfControllerListener2.java */
    /* renamed from: b.f.g.a.a.h.i.a$a, reason: collision with other inner class name */
    public static class HandlerC0067a extends Handler {
        public final g a;

        public HandlerC0067a(@NonNull Looper looper, @NonNull g gVar) {
            super(looper);
            this.a = gVar;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Object obj = message.obj;
            Objects.requireNonNull(obj);
            h hVar = (h) obj;
            int i = message.what;
            if (i == 1) {
                ((f) this.a).b(hVar, message.arg1);
            } else {
                if (i != 2) {
                    return;
                }
                ((f) this.a).a(hVar, message.arg1);
            }
        }
    }

    public a(b.f.d.k.b bVar, h hVar, g gVar, Supplier<Boolean> supplier, Supplier<Boolean> supplier2) {
        this.k = bVar;
        this.l = hVar;
        this.m = gVar;
        this.n = supplier;
        this.o = supplier2;
    }

    @Override // b.f.h.b.a.b
    public void a(String str, Object obj, b.a aVar) {
        long jNow = this.k.now();
        h hVarE = e();
        hVarE.b();
        hVarE.i = jNow;
        hVarE.a = str;
        hVarE.d = obj;
        hVarE.A = aVar;
        n(hVarE, 0);
        hVarE.w = 1;
        hVarE.f488x = jNow;
        q(hVarE, 1);
    }

    @Override // b.f.h.b.a.b
    public void b(String str, Throwable th, b.a aVar) {
        long jNow = this.k.now();
        h hVarE = e();
        hVarE.A = aVar;
        hVarE.l = jNow;
        hVarE.a = str;
        hVarE.u = th;
        n(hVarE, 5);
        hVarE.w = 2;
        hVarE.f489y = jNow;
        q(hVarE, 2);
    }

    @Override // b.f.h.b.a.b
    public void c(String str, b.a aVar) {
        long jNow = this.k.now();
        h hVarE = e();
        hVarE.A = aVar;
        hVarE.a = str;
        int i = hVarE.v;
        if (i != 3 && i != 5 && i != 6) {
            hVarE.m = jNow;
            n(hVarE, 4);
        }
        hVarE.w = 2;
        hVarE.f489y = jNow;
        q(hVarE, 2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e().a();
    }

    @Override // b.f.h.b.a.b
    public void d(String str, Object obj, b.a aVar) {
        long jNow = this.k.now();
        h hVarE = e();
        hVarE.A = aVar;
        hVarE.k = jNow;
        hVarE.o = jNow;
        hVarE.a = str;
        hVarE.e = (ImageInfo) obj;
        n(hVarE, 3);
    }

    public final h e() {
        return Boolean.FALSE.booleanValue() ? new h() : this.l;
    }

    public final boolean f() {
        boolean zBooleanValue = this.n.get().booleanValue();
        if (zBooleanValue && j == null) {
            synchronized (this) {
                if (j == null) {
                    HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    Objects.requireNonNull(looper);
                    j = new HandlerC0067a(looper, this.m);
                }
            }
        }
        return zBooleanValue;
    }

    public final void n(h hVar, int i) {
        if (!f()) {
            ((f) this.m).b(hVar, i);
            return;
        }
        Handler handler = j;
        Objects.requireNonNull(handler);
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = hVar;
        j.sendMessage(messageObtainMessage);
    }

    public final void q(h hVar, int i) {
        if (!f()) {
            ((f) this.m).a(hVar, i);
            return;
        }
        Handler handler = j;
        Objects.requireNonNull(handler);
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = 2;
        messageObtainMessage.arg1 = i;
        messageObtainMessage.obj = hVar;
        j.sendMessage(messageObtainMessage);
    }
}
