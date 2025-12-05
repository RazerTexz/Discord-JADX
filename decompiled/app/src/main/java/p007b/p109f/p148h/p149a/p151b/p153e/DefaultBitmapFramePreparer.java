package p007b.p109f.p148h.p149a.p151b.p153e;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p148h.p149a.p150a.AnimationBackend;
import p007b.p109f.p148h.p149a.p151b.BitmapFrameCache;
import p007b.p109f.p148h.p149a.p151b.BitmapFrameRenderer;
import p007b.p109f.p148h.p149a.p151b.p154f.AnimatedDrawableBackendFrameRenderer;

/* compiled from: DefaultBitmapFramePreparer.java */
/* renamed from: b.f.h.a.b.e.c, reason: use source file name */
/* loaded from: classes.dex */
public class DefaultBitmapFramePreparer implements BitmapFramePreparer {

    /* renamed from: a */
    public final PlatformBitmapFactory f3515a;

    /* renamed from: b */
    public final BitmapFrameRenderer f3516b;

    /* renamed from: c */
    public final Bitmap.Config f3517c;

    /* renamed from: d */
    public final ExecutorService f3518d;

    /* renamed from: e */
    public final SparseArray<Runnable> f3519e = new SparseArray<>();

    /* compiled from: DefaultBitmapFramePreparer.java */
    /* renamed from: b.f.h.a.b.e.c$a */
    public class a implements Runnable {

        /* renamed from: j */
        public final BitmapFrameCache f3520j;

        /* renamed from: k */
        public final AnimationBackend f3521k;

        /* renamed from: l */
        public final int f3522l;

        /* renamed from: m */
        public final int f3523m;

        public a(AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            this.f3521k = animationBackend;
            this.f3520j = bitmapFrameCache;
            this.f3522l = i;
            this.f3523m = i2;
        }

        /* renamed from: a */
        public final boolean m1159a(int i, int i2) {
            CloseableReference closeableReferenceMo1151a;
            int i3 = 2;
            CloseableReference closeableReference = null;
            try {
                if (i2 == 1) {
                    closeableReferenceMo1151a = this.f3520j.mo1151a(i, this.f3521k.mo1140i(), this.f3521k.mo1138g());
                } else {
                    if (i2 != 2) {
                        Class<CloseableReference> cls = CloseableReference.f19438j;
                        return false;
                    }
                    try {
                        closeableReferenceMo1151a = DefaultBitmapFramePreparer.this.f3515a.m8695a(this.f3521k.mo1140i(), this.f3521k.mo1138g(), DefaultBitmapFramePreparer.this.f3517c);
                        i3 = -1;
                    } catch (RuntimeException e) {
                        FLog.m984l(DefaultBitmapFramePreparer.class, "Failed to create frame bitmap", e);
                        Class<CloseableReference> cls2 = CloseableReference.f19438j;
                        return false;
                    }
                }
                boolean zM1160b = m1160b(i, closeableReferenceMo1151a, i2);
                if (closeableReferenceMo1151a != null) {
                    closeableReferenceMo1151a.close();
                }
                return (zM1160b || i3 == -1) ? zM1160b : m1159a(i, i3);
            } catch (Throwable th) {
                Class<CloseableReference> cls3 = CloseableReference.f19438j;
                if (0 != 0) {
                    closeableReference.close();
                }
                throw th;
            }
        }

        /* renamed from: b */
        public final boolean m1160b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (!CloseableReference.m8640y(closeableReference)) {
                return false;
            }
            if (!((AnimatedDrawableBackendFrameRenderer) DefaultBitmapFramePreparer.this.f3516b).m1161a(i, closeableReference.m8642u())) {
                return false;
            }
            int i3 = FLog.f3102a;
            synchronized (DefaultBitmapFramePreparer.this.f3519e) {
                this.f3520j.mo1152b(this.f3522l, closeableReference, i2);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f3520j.mo1153c(this.f3522l)) {
                    int i = FLog.f3102a;
                    synchronized (DefaultBitmapFramePreparer.this.f3519e) {
                        DefaultBitmapFramePreparer.this.f3519e.remove(this.f3523m);
                    }
                    return;
                }
                if (m1159a(this.f3522l, 1)) {
                    int i2 = FLog.f3102a;
                } else {
                    FLog.m975c(DefaultBitmapFramePreparer.class, "Could not prepare frame %d.", Integer.valueOf(this.f3522l));
                }
                synchronized (DefaultBitmapFramePreparer.this.f3519e) {
                    DefaultBitmapFramePreparer.this.f3519e.remove(this.f3523m);
                }
            } catch (Throwable th) {
                synchronized (DefaultBitmapFramePreparer.this.f3519e) {
                    DefaultBitmapFramePreparer.this.f3519e.remove(this.f3523m);
                    throw th;
                }
            }
        }
    }

    public DefaultBitmapFramePreparer(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, Bitmap.Config config, ExecutorService executorService) {
        this.f3515a = platformBitmapFactory;
        this.f3516b = bitmapFrameRenderer;
        this.f3517c = config;
        this.f3518d = executorService;
    }
}
