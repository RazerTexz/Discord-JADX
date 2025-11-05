package b.c.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.i0.c;
import b.c.a.y.m.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class j extends Drawable implements Drawable.Callback, Animatable {
    public boolean A;
    public boolean B;
    public boolean C;
    public final Matrix j = new Matrix();
    public b.c.a.d k;
    public final b.c.a.b0.d l;
    public float m;
    public boolean n;
    public boolean o;
    public final ArrayList<o> p;
    public final ValueAnimator.AnimatorUpdateListener q;

    @Nullable
    public ImageView.ScaleType r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public b.c.a.x.b f352s;

    @Nullable
    public String t;

    @Nullable
    public b.c.a.b u;

    @Nullable
    public b.c.a.x.a v;
    public boolean w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public b.c.a.y.m.c f353x;

    /* renamed from: y, reason: collision with root package name */
    public int f354y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f355z;

    /* compiled from: LottieDrawable.java */
    public class a implements o {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.q(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class b implements o {
        public final /* synthetic */ int a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f357b;

        public b(int i, int i2) {
            this.a = i;
            this.f357b = i2;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.p(this.a, this.f357b);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class c implements o {
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.l(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class d implements o {
        public final /* synthetic */ float a;

        public d(float f) {
            this.a = f;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.u(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class e implements o {
        public final /* synthetic */ b.c.a.y.f a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f360b;
        public final /* synthetic */ b.c.a.c0.c c;

        public e(b.c.a.y.f fVar, Object obj, b.c.a.c0.c cVar) {
            this.a = fVar;
            this.f360b = obj;
            this.c = cVar;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.a(this.a, this.f360b, this.c);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j jVar = j.this;
            b.c.a.y.m.c cVar = jVar.f353x;
            if (cVar != null) {
                cVar.o(jVar.l.h());
            }
        }
    }

    /* compiled from: LottieDrawable.java */
    public class g implements o {
        public g() {
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.j();
        }
    }

    /* compiled from: LottieDrawable.java */
    public class h implements o {
        public h() {
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.k();
        }
    }

    /* compiled from: LottieDrawable.java */
    public class i implements o {
        public final /* synthetic */ int a;

        public i(int i) {
            this.a = i;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.r(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$j, reason: collision with other inner class name */
    public class C0061j implements o {
        public final /* synthetic */ float a;

        public C0061j(float f) {
            this.a = f;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.t(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class k implements o {
        public final /* synthetic */ int a;

        public k(int i) {
            this.a = i;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.m(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class l implements o {
        public final /* synthetic */ float a;

        public l(float f) {
            this.a = f;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.o(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class m implements o {
        public final /* synthetic */ String a;

        public m(String str) {
            this.a = str;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.s(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public class n implements o {
        public final /* synthetic */ String a;

        public n(String str) {
            this.a = str;
        }

        @Override // b.c.a.j.o
        public void a(b.c.a.d dVar) {
            j.this.n(this.a);
        }
    }

    /* compiled from: LottieDrawable.java */
    public interface o {
        void a(b.c.a.d dVar);
    }

    public j() {
        b.c.a.b0.d dVar = new b.c.a.b0.d();
        this.l = dVar;
        this.m = 1.0f;
        this.n = true;
        this.o = false;
        new HashSet();
        this.p = new ArrayList<>();
        f fVar = new f();
        this.q = fVar;
        this.f354y = 255;
        this.B = true;
        this.C = false;
        dVar.j.add(fVar);
    }

    public <T> void a(b.c.a.y.f fVar, T t, b.c.a.c0.c<T> cVar) {
        List listEmptyList;
        b.c.a.y.m.c cVar2 = this.f353x;
        if (cVar2 == null) {
            this.p.add(new e(fVar, t, cVar));
            return;
        }
        boolean zIsEmpty = true;
        if (fVar == b.c.a.y.f.a) {
            cVar2.g(t, cVar);
        } else {
            b.c.a.y.g gVar = fVar.c;
            if (gVar != null) {
                gVar.g(t, cVar);
            } else {
                if (cVar2 == null) {
                    b.c.a.b0.c.b("Cannot resolve KeyPath. Composition is not set yet.");
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    this.f353x.c(fVar, 0, arrayList, new b.c.a.y.f(new String[0]));
                    listEmptyList = arrayList;
                }
                for (int i2 = 0; i2 < listEmptyList.size(); i2++) {
                    ((b.c.a.y.f) listEmptyList.get(i2)).c.g(t, cVar);
                }
                zIsEmpty = true ^ listEmptyList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == b.c.a.o.A) {
                u(g());
            }
        }
    }

    public final void b() {
        b.c.a.d dVar = this.k;
        c.a aVar = b.c.a.a0.s.a;
        Rect rect = dVar.j;
        b.c.a.y.m.e eVar = new b.c.a.y.m.e(Collections.emptyList(), dVar, "__container", -1L, e.a.PRE_COMP, -1L, null, Collections.emptyList(), new b.c.a.y.k.l(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), 1, null, false);
        b.c.a.d dVar2 = this.k;
        this.f353x = new b.c.a.y.m.c(this, eVar, dVar2.i, dVar2);
    }

    public void c() {
        b.c.a.b0.d dVar = this.l;
        if (dVar.t) {
            dVar.cancel();
        }
        this.k = null;
        this.f353x = null;
        this.f352s = null;
        b.c.a.b0.d dVar2 = this.l;
        dVar2.f344s = null;
        dVar2.q = -2.1474836E9f;
        dVar2.r = 2.1474836E9f;
        invalidateSelf();
    }

    public final void d(@NonNull Canvas canvas) {
        float f2;
        float f3;
        int iSave = -1;
        if (ImageView.ScaleType.FIT_XY != this.r) {
            if (this.f353x == null) {
                return;
            }
            float f4 = this.m;
            float fMin = Math.min(canvas.getWidth() / this.k.j.width(), canvas.getHeight() / this.k.j.height());
            if (f4 > fMin) {
                f2 = this.m / fMin;
            } else {
                fMin = f4;
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                iSave = canvas.save();
                float fWidth = this.k.j.width() / 2.0f;
                float fHeight = this.k.j.height() / 2.0f;
                float f5 = fWidth * fMin;
                float f6 = fHeight * fMin;
                float f7 = this.m;
                canvas.translate((fWidth * f7) - f5, (f7 * fHeight) - f6);
                canvas.scale(f2, f2, f5, f6);
            }
            this.j.reset();
            this.j.preScale(fMin, fMin);
            this.f353x.f(canvas, this.j, this.f354y);
            if (iSave > 0) {
                canvas.restoreToCount(iSave);
                return;
            }
            return;
        }
        if (this.f353x == null) {
            return;
        }
        Rect bounds = getBounds();
        float fWidth2 = bounds.width() / this.k.j.width();
        float fHeight2 = bounds.height() / this.k.j.height();
        if (this.B) {
            float fMin2 = Math.min(fWidth2, fHeight2);
            if (fMin2 < 1.0f) {
                f3 = 1.0f / fMin2;
                fWidth2 /= f3;
                fHeight2 /= f3;
            } else {
                f3 = 1.0f;
            }
            if (f3 > 1.0f) {
                iSave = canvas.save();
                float fWidth3 = bounds.width() / 2.0f;
                float fHeight3 = bounds.height() / 2.0f;
                float f8 = fWidth3 * fMin2;
                float f9 = fMin2 * fHeight3;
                canvas.translate(fWidth3 - f8, fHeight3 - f9);
                canvas.scale(f3, f3, f8, f9);
            }
        }
        this.j.reset();
        this.j.preScale(fWidth2, fHeight2);
        this.f353x.f(canvas, this.j, this.f354y);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.C = false;
        if (this.o) {
            try {
                d(canvas);
            } catch (Throwable unused) {
                Objects.requireNonNull((b.c.a.b0.b) b.c.a.b0.c.a);
            }
        } else {
            d(canvas);
        }
        b.c.a.c.a("Drawable#draw");
    }

    public float e() {
        return this.l.i();
    }

    public float f() {
        return this.l.j();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float g() {
        return this.l.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f354y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.k == null) {
            return -1;
        }
        return (int) (r0.j.height() * this.m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.k == null) {
            return -1;
        }
        return (int) (r0.j.width() * this.m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.l.getRepeatCount();
    }

    public boolean i() {
        b.c.a.b0.d dVar = this.l;
        if (dVar == null) {
            return false;
        }
        return dVar.t;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.C) {
            return;
        }
        this.C = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return i();
    }

    @MainThread
    public void j() {
        if (this.f353x == null) {
            this.p.add(new g());
            return;
        }
        if (this.n || h() == 0) {
            b.c.a.b0.d dVar = this.l;
            dVar.t = true;
            boolean zK = dVar.k();
            for (Animator.AnimatorListener animatorListener : dVar.k) {
                if (Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationStart(dVar, zK);
                } else {
                    animatorListener.onAnimationStart(dVar);
                }
            }
            dVar.n((int) (dVar.k() ? dVar.i() : dVar.j()));
            dVar.n = 0L;
            dVar.p = 0;
            dVar.l();
        }
        if (this.n) {
            return;
        }
        l((int) (this.l.l < 0.0f ? f() : e()));
        this.l.g();
    }

    @MainThread
    public void k() {
        if (this.f353x == null) {
            this.p.add(new h());
            return;
        }
        if (this.n || h() == 0) {
            b.c.a.b0.d dVar = this.l;
            dVar.t = true;
            dVar.l();
            dVar.n = 0L;
            if (dVar.k() && dVar.o == dVar.j()) {
                dVar.o = dVar.i();
            } else if (!dVar.k() && dVar.o == dVar.i()) {
                dVar.o = dVar.j();
            }
        }
        if (this.n) {
            return;
        }
        l((int) (this.l.l < 0.0f ? f() : e()));
        this.l.g();
    }

    public void l(int i2) {
        if (this.k == null) {
            this.p.add(new c(i2));
        } else {
            this.l.n(i2);
        }
    }

    public void m(int i2) {
        if (this.k == null) {
            this.p.add(new k(i2));
            return;
        }
        b.c.a.b0.d dVar = this.l;
        dVar.o(dVar.q, i2 + 0.99f);
    }

    public void n(String str) {
        b.c.a.d dVar = this.k;
        if (dVar == null) {
            this.p.add(new n(str));
            return;
        }
        b.c.a.y.i iVarD = dVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(b.d.b.a.a.y("Cannot find marker with name ", str, "."));
        }
        m((int) (iVarD.f410b + iVarD.c));
    }

    public void o(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        b.c.a.d dVar = this.k;
        if (dVar == null) {
            this.p.add(new l(f2));
        } else {
            m((int) b.c.a.b0.f.e(dVar.k, dVar.l, f2));
        }
    }

    public void p(int i2, int i3) {
        if (this.k == null) {
            this.p.add(new b(i2, i3));
        } else {
            this.l.o(i2, i3 + 0.99f);
        }
    }

    public void q(String str) {
        b.c.a.d dVar = this.k;
        if (dVar == null) {
            this.p.add(new a(str));
            return;
        }
        b.c.a.y.i iVarD = dVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(b.d.b.a.a.y("Cannot find marker with name ", str, "."));
        }
        int i2 = (int) iVarD.f410b;
        p(i2, ((int) iVarD.c) + i2);
    }

    public void r(int i2) {
        if (this.k == null) {
            this.p.add(new i(i2));
        } else {
            this.l.o(i2, (int) r0.r);
        }
    }

    public void s(String str) {
        b.c.a.d dVar = this.k;
        if (dVar == null) {
            this.p.add(new m(str));
            return;
        }
        b.c.a.y.i iVarD = dVar.d(str);
        if (iVarD == null) {
            throw new IllegalArgumentException(b.d.b.a.a.y("Cannot find marker with name ", str, "."));
        }
        r((int) iVarD.f410b);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.f354y = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        b.c.a.b0.c.b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        j();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        this.p.clear();
        this.l.g();
    }

    public void t(float f2) {
        b.c.a.d dVar = this.k;
        if (dVar == null) {
            this.p.add(new C0061j(f2));
        } else {
            r((int) b.c.a.b0.f.e(dVar.k, dVar.l, f2));
        }
    }

    public void u(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        b.c.a.d dVar = this.k;
        if (dVar == null) {
            this.p.add(new d(f2));
        } else {
            this.l.n(b.c.a.b0.f.e(dVar.k, dVar.l, f2));
            b.c.a.c.a("Drawable#setProgress");
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public final void v() {
        if (this.k == null) {
            return;
        }
        float f2 = this.m;
        setBounds(0, 0, (int) (r0.j.width() * f2), (int) (this.k.j.height() * f2));
    }
}
