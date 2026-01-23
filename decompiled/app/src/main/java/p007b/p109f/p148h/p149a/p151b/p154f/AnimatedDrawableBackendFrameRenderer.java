package p007b.p109f.p148h.p149a.p151b.p154f;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p148h.p149a.p151b.BitmapFrameCache;
import p007b.p109f.p148h.p149a.p151b.BitmapFrameRenderer;
import p007b.p109f.p161j.p162a.p163a.AnimatedDrawableBackend;
import p007b.p109f.p161j.p162a.p165c.AnimatedImageCompositor;

/* JADX INFO: renamed from: b.f.h.a.b.f.b, reason: use source file name */
/* JADX INFO: compiled from: AnimatedDrawableBackendFrameRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawableBackendFrameRenderer implements BitmapFrameRenderer {

    /* JADX INFO: renamed from: a */
    public final BitmapFrameCache f3527a;

    /* JADX INFO: renamed from: b */
    public AnimatedDrawableBackend f3528b;

    /* JADX INFO: renamed from: c */
    public AnimatedImageCompositor f3529c;

    /* JADX INFO: renamed from: d */
    public final AnimatedImageCompositor.a f3530d;

    /* JADX INFO: renamed from: b.f.h.a.b.f.b$a */
    /* JADX INFO: compiled from: AnimatedDrawableBackendFrameRenderer.java */
    public class a implements AnimatedImageCompositor.a {
        public a() {
        }

        @Override // p007b.p109f.p161j.p162a.p165c.AnimatedImageCompositor.a
        /* JADX INFO: renamed from: a */
        public void mo1162a(int i, Bitmap bitmap) {
        }

        @Override // p007b.p109f.p161j.p162a.p165c.AnimatedImageCompositor.a
        /* JADX INFO: renamed from: b */
        public CloseableReference<Bitmap> mo1163b(int i) {
            return AnimatedDrawableBackendFrameRenderer.this.f3527a.mo1154d(i);
        }
    }

    public AnimatedDrawableBackendFrameRenderer(BitmapFrameCache bitmapFrameCache, AnimatedDrawableBackend animatedDrawableBackend) {
        a aVar = new a();
        this.f3530d = aVar;
        this.f3527a = bitmapFrameCache;
        this.f3528b = animatedDrawableBackend;
        this.f3529c = new AnimatedImageCompositor(animatedDrawableBackend, aVar);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1161a(int i, Bitmap bitmap) {
        try {
            this.f3529c.m1205d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            FLog.m976d(AnimatedDrawableBackendFrameRenderer.class, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
