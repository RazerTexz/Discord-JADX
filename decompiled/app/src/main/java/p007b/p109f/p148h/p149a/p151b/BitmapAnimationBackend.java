package p007b.p109f.p148h.p149a.p151b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p148h.p149a.p150a.AnimationBackend;
import p007b.p109f.p148h.p149a.p150a.AnimationBackendDelegateWithInactivityCheck;
import p007b.p109f.p148h.p149a.p150a.AnimationInformation;
import p007b.p109f.p148h.p149a.p151b.p153e.BitmapFramePreparationStrategy;
import p007b.p109f.p148h.p149a.p151b.p153e.BitmapFramePreparer;
import p007b.p109f.p148h.p149a.p151b.p153e.DefaultBitmapFramePreparer;
import p007b.p109f.p148h.p149a.p151b.p153e.DefaultBitmapFramePreparer.a;
import p007b.p109f.p148h.p149a.p151b.p153e.FixedNumberBitmapFramePreparationStrategy;
import p007b.p109f.p148h.p149a.p151b.p154f.AnimatedDrawableBackendFrameRenderer;
import p007b.p109f.p161j.p162a.p165c.AnimatedDrawableBackendImpl;
import p007b.p109f.p161j.p162a.p165c.AnimatedImageCompositor;

/* JADX INFO: renamed from: b.f.h.a.b.a, reason: use source file name */
/* JADX INFO: compiled from: BitmapAnimationBackend.java */
/* JADX INFO: loaded from: classes.dex */
public class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.b {

    /* JADX INFO: renamed from: a */
    public final PlatformBitmapFactory f3496a;

    /* JADX INFO: renamed from: b */
    public final BitmapFrameCache f3497b;

    /* JADX INFO: renamed from: c */
    public final AnimationInformation f3498c;

    /* JADX INFO: renamed from: d */
    public final BitmapFrameRenderer f3499d;

    /* JADX INFO: renamed from: e */
    public final BitmapFramePreparationStrategy f3500e;

    /* JADX INFO: renamed from: f */
    public final BitmapFramePreparer f3501f;

    /* JADX INFO: renamed from: h */
    public Rect f3503h;

    /* JADX INFO: renamed from: i */
    public int f3504i;

    /* JADX INFO: renamed from: j */
    public int f3505j;

    /* JADX INFO: renamed from: k */
    public Bitmap.Config f3506k = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: g */
    public final Paint f3502g = new Paint(6);

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer) {
        this.f3496a = platformBitmapFactory;
        this.f3497b = bitmapFrameCache;
        this.f3498c = animationInformation;
        this.f3499d = bitmapFrameRenderer;
        this.f3500e = bitmapFramePreparationStrategy;
        this.f3501f = bitmapFramePreparer;
        m1150n();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationInformation
    /* JADX INFO: renamed from: a */
    public int mo1142a() {
        return this.f3498c.mo1142a();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationInformation
    /* JADX INFO: renamed from: b */
    public int mo1143b() {
        return this.f3498c.mo1143b();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackendDelegateWithInactivityCheck.b
    /* JADX INFO: renamed from: c */
    public void mo1146c() {
        this.f3497b.clear();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackend
    public void clear() {
        this.f3497b.clear();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackend
    /* JADX INFO: renamed from: d */
    public void mo1136d(ColorFilter colorFilter) {
        this.f3502g.setColorFilter(colorFilter);
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationInformation
    /* JADX INFO: renamed from: e */
    public int mo1144e(int i) {
        return this.f3498c.mo1144e(i);
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackend
    /* JADX INFO: renamed from: f */
    public void mo1137f(@IntRange(from = 0, m76to = 255) int i) {
        this.f3502g.setAlpha(i);
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackend
    /* JADX INFO: renamed from: g */
    public int mo1138g() {
        return this.f3505j;
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackend
    /* JADX INFO: renamed from: h */
    public void mo1139h(Rect rect) {
        this.f3503h = rect;
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = (AnimatedDrawableBackendFrameRenderer) this.f3499d;
        AnimatedDrawableBackendImpl animatedDrawableBackendImpl = (AnimatedDrawableBackendImpl) animatedDrawableBackendFrameRenderer.f3528b;
        if (!AnimatedDrawableBackendImpl.m1195a(animatedDrawableBackendImpl.f3626c, rect).equals(animatedDrawableBackendImpl.f3627d)) {
            animatedDrawableBackendImpl = new AnimatedDrawableBackendImpl(animatedDrawableBackendImpl.f3624a, animatedDrawableBackendImpl.f3625b, rect, animatedDrawableBackendImpl.f3632i);
        }
        if (animatedDrawableBackendImpl != animatedDrawableBackendFrameRenderer.f3528b) {
            animatedDrawableBackendFrameRenderer.f3528b = animatedDrawableBackendImpl;
            animatedDrawableBackendFrameRenderer.f3529c = new AnimatedImageCompositor(animatedDrawableBackendImpl, animatedDrawableBackendFrameRenderer.f3530d);
        }
        m1150n();
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackend
    /* JADX INFO: renamed from: i */
    public int mo1140i() {
        return this.f3504i;
    }

    @Override // p007b.p109f.p148h.p149a.p150a.AnimationBackend
    /* JADX INFO: renamed from: j */
    public boolean mo1141j(Drawable drawable, Canvas canvas, int i) {
        BitmapFramePreparer bitmapFramePreparer;
        int i2 = i;
        boolean zM1148l = m1148l(canvas, i2, 0);
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.f3500e;
        if (bitmapFramePreparationStrategy != null && (bitmapFramePreparer = this.f3501f) != null) {
            BitmapFrameCache bitmapFrameCache = this.f3497b;
            FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy = (FixedNumberBitmapFramePreparationStrategy) bitmapFramePreparationStrategy;
            int i3 = 1;
            while (i3 <= fixedNumberBitmapFramePreparationStrategy.f3525a) {
                int iMo1142a = (i2 + i3) % mo1142a();
                FLog.m980h(2);
                DefaultBitmapFramePreparer defaultBitmapFramePreparer = (DefaultBitmapFramePreparer) bitmapFramePreparer;
                Objects.requireNonNull(defaultBitmapFramePreparer);
                int iHashCode = (hashCode() * 31) + iMo1142a;
                synchronized (defaultBitmapFramePreparer.f3519e) {
                    if (defaultBitmapFramePreparer.f3519e.get(iHashCode) != null) {
                        int i4 = FLog.f3102a;
                    } else if (bitmapFrameCache.mo1153c(iMo1142a)) {
                        int i5 = FLog.f3102a;
                    } else {
                        DefaultBitmapFramePreparer.a aVar = defaultBitmapFramePreparer.new a(this, bitmapFrameCache, iMo1142a, iHashCode);
                        defaultBitmapFramePreparer.f3519e.put(iHashCode, aVar);
                        defaultBitmapFramePreparer.f3518d.execute(aVar);
                    }
                }
                i3++;
                i2 = i;
            }
        }
        return zM1148l;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m1147k(int i, CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (!CloseableReference.m8640y(closeableReference)) {
            return false;
        }
        if (this.f3503h == null) {
            canvas.drawBitmap(closeableReference.m8642u(), 0.0f, 0.0f, this.f3502g);
        } else {
            canvas.drawBitmap(closeableReference.m8642u(), (Rect) null, this.f3503h, this.f3502g);
        }
        if (i2 == 3) {
            return true;
        }
        this.f3497b.mo1155e(i, closeableReference, i2);
        return true;
    }

    /* JADX INFO: renamed from: l */
    public final boolean m1148l(Canvas canvas, int i, int i2) {
        CloseableReference closeableReferenceMo1154d;
        boolean zM1147k;
        int i3 = 2;
        boolean z2 = true;
        CloseableReference closeableReference = null;
        try {
            if (i2 == 0) {
                closeableReferenceMo1154d = this.f3497b.mo1154d(i);
                zM1147k = m1147k(i, closeableReferenceMo1154d, canvas, 0);
                i3 = 1;
            } else if (i2 == 1) {
                closeableReferenceMo1154d = this.f3497b.mo1151a(i, this.f3504i, this.f3505j);
                if (!m1149m(i, closeableReferenceMo1154d) || !m1147k(i, closeableReferenceMo1154d, canvas, 1)) {
                    z2 = false;
                }
                zM1147k = z2;
            } else if (i2 == 2) {
                try {
                    closeableReferenceMo1154d = this.f3496a.m8695a(this.f3504i, this.f3505j, this.f3506k);
                    if (!m1149m(i, closeableReferenceMo1154d) || !m1147k(i, closeableReferenceMo1154d, canvas, 2)) {
                        z2 = false;
                    }
                    zM1147k = z2;
                    i3 = 3;
                } catch (RuntimeException e) {
                    FLog.m984l(BitmapAnimationBackend.class, "Failed to create frame bitmap", e);
                    Class<CloseableReference> cls = CloseableReference.f19438j;
                    return false;
                }
            } else {
                if (i2 != 3) {
                    Class<CloseableReference> cls2 = CloseableReference.f19438j;
                    return false;
                }
                closeableReferenceMo1154d = this.f3497b.mo1156f(i);
                zM1147k = m1147k(i, closeableReferenceMo1154d, canvas, 3);
                i3 = -1;
            }
            Class<CloseableReference> cls3 = CloseableReference.f19438j;
            if (closeableReferenceMo1154d != null) {
                closeableReferenceMo1154d.close();
            }
            return (zM1147k || i3 == -1) ? zM1147k : m1148l(canvas, i, i3);
        } catch (Throwable th) {
            Class<CloseableReference> cls4 = CloseableReference.f19438j;
            if (0 != 0) {
                closeableReference.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: m */
    public final boolean m1149m(int i, CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.m8640y(closeableReference)) {
            return false;
        }
        boolean zM1161a = ((AnimatedDrawableBackendFrameRenderer) this.f3499d).m1161a(i, closeableReference.m8642u());
        if (!zM1161a) {
            closeableReference.close();
        }
        return zM1161a;
    }

    /* JADX INFO: renamed from: n */
    public final void m1150n() {
        int width = ((AnimatedDrawableBackendImpl) ((AnimatedDrawableBackendFrameRenderer) this.f3499d).f3528b).f3626c.getWidth();
        this.f3504i = width;
        if (width == -1) {
            Rect rect = this.f3503h;
            this.f3504i = rect == null ? -1 : rect.width();
        }
        int height = ((AnimatedDrawableBackendImpl) ((AnimatedDrawableBackendFrameRenderer) this.f3499d).f3528b).f3626c.getHeight();
        this.f3505j = height;
        if (height == -1) {
            Rect rect2 = this.f3503h;
            this.f3505j = rect2 != null ? rect2.height() : -1;
        }
    }
}
