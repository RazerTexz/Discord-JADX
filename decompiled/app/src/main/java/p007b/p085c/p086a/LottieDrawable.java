package p007b.p085c.p086a;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.LayerParser;
import p007b.p085c.p086a.p087a0.p088i0.JsonReader2;
import p007b.p085c.p086a.p089b0.LogcatLogger2;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p089b0.LottieValueAnimator;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p094x.FontAssetManager;
import p007b.p085c.p086a.p094x.ImageAssetManager;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.KeyPathElement;
import p007b.p085c.p086a.p095y.Marker2;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p098m.CompositionLayer;
import p007b.p085c.p086a.p095y.p098m.Layer2;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: LottieDrawable.java */
/* renamed from: b.c.a.j, reason: use source file name */
/* loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: A */
    public boolean f2366A;

    /* renamed from: B */
    public boolean f2367B;

    /* renamed from: C */
    public boolean f2368C;

    /* renamed from: j */
    public final Matrix f2369j = new Matrix();

    /* renamed from: k */
    public LottieComposition f2370k;

    /* renamed from: l */
    public final LottieValueAnimator f2371l;

    /* renamed from: m */
    public float f2372m;

    /* renamed from: n */
    public boolean f2373n;

    /* renamed from: o */
    public boolean f2374o;

    /* renamed from: p */
    public final ArrayList<o> f2375p;

    /* renamed from: q */
    public final ValueAnimator.AnimatorUpdateListener f2376q;

    /* renamed from: r */
    @Nullable
    public ImageView.ScaleType f2377r;

    /* renamed from: s */
    @Nullable
    public ImageAssetManager f2378s;

    /* renamed from: t */
    @Nullable
    public String f2379t;

    /* renamed from: u */
    @Nullable
    public ImageAssetDelegate f2380u;

    /* renamed from: v */
    @Nullable
    public FontAssetManager f2381v;

    /* renamed from: w */
    public boolean f2382w;

    /* renamed from: x */
    @Nullable
    public CompositionLayer f2383x;

    /* renamed from: y */
    public int f2384y;

    /* renamed from: z */
    public boolean f2385z;

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$a */
    public class a implements o {

        /* renamed from: a */
        public final /* synthetic */ String f2386a;

        public a(String str) {
            this.f2386a = str;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m697q(this.f2386a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$b */
    public class b implements o {

        /* renamed from: a */
        public final /* synthetic */ int f2388a;

        /* renamed from: b */
        public final /* synthetic */ int f2389b;

        public b(int i, int i2) {
            this.f2388a = i;
            this.f2389b = i2;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m696p(this.f2388a, this.f2389b);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$c */
    public class c implements o {

        /* renamed from: a */
        public final /* synthetic */ int f2391a;

        public c(int i) {
            this.f2391a = i;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m692l(this.f2391a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$d */
    public class d implements o {

        /* renamed from: a */
        public final /* synthetic */ float f2393a;

        public d(float f) {
            this.f2393a = f;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m701u(this.f2393a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$e */
    public class e implements o {

        /* renamed from: a */
        public final /* synthetic */ KeyPath f2395a;

        /* renamed from: b */
        public final /* synthetic */ Object f2396b;

        /* renamed from: c */
        public final /* synthetic */ LottieValueCallback f2397c;

        public e(KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback) {
            this.f2395a = keyPath;
            this.f2396b = obj;
            this.f2397c = lottieValueCallback;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m681a(this.f2395a, this.f2396b, this.f2397c);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$f */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LottieDrawable lottieDrawable = LottieDrawable.this;
            CompositionLayer compositionLayer = lottieDrawable.f2383x;
            if (compositionLayer != null) {
                compositionLayer.mo785o(lottieDrawable.f2371l.m643h());
            }
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$g */
    public class g implements o {
        public g() {
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m690j();
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$h */
    public class h implements o {
        public h() {
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m691k();
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$i */
    public class i implements o {

        /* renamed from: a */
        public final /* synthetic */ int f2402a;

        public i(int i) {
            this.f2402a = i;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m698r(this.f2402a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$j */
    public class j implements o {

        /* renamed from: a */
        public final /* synthetic */ float f2404a;

        public j(float f) {
            this.f2404a = f;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m700t(this.f2404a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$k */
    public class k implements o {

        /* renamed from: a */
        public final /* synthetic */ int f2406a;

        public k(int i) {
            this.f2406a = i;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m693m(this.f2406a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$l */
    public class l implements o {

        /* renamed from: a */
        public final /* synthetic */ float f2408a;

        public l(float f) {
            this.f2408a = f;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m695o(this.f2408a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$m */
    public class m implements o {

        /* renamed from: a */
        public final /* synthetic */ String f2410a;

        public m(String str) {
            this.f2410a = str;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m699s(this.f2410a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$n */
    public class n implements o {

        /* renamed from: a */
        public final /* synthetic */ String f2412a;

        public n(String str) {
            this.f2412a = str;
        }

        @Override // p007b.p085c.p086a.LottieDrawable.o
        /* renamed from: a */
        public void mo703a(LottieComposition lottieComposition) {
            LottieDrawable.this.m694n(this.f2412a);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* renamed from: b.c.a.j$o */
    public interface o {
        /* renamed from: a */
        void mo703a(LottieComposition lottieComposition);
    }

    public LottieDrawable() {
        LottieValueAnimator lottieValueAnimator = new LottieValueAnimator();
        this.f2371l = lottieValueAnimator;
        this.f2372m = 1.0f;
        this.f2373n = true;
        this.f2374o = false;
        new HashSet();
        this.f2375p = new ArrayList<>();
        f fVar = new f();
        this.f2376q = fVar;
        this.f2384y = 255;
        this.f2367B = true;
        this.f2368C = false;
        lottieValueAnimator.f2293j.add(fVar);
    }

    /* renamed from: a */
    public <T> void m681a(KeyPath keyPath, T t, LottieValueCallback<T> lottieValueCallback) {
        List listEmptyList;
        CompositionLayer compositionLayer = this.f2383x;
        if (compositionLayer == null) {
            this.f2375p.add(new e(keyPath, t, lottieValueCallback));
            return;
        }
        boolean zIsEmpty = true;
        if (keyPath == KeyPath.f2712a) {
            compositionLayer.mo714g(t, lottieValueCallback);
        } else {
            KeyPathElement keyPathElement = keyPath.f2714c;
            if (keyPathElement != null) {
                keyPathElement.mo714g(t, lottieValueCallback);
            } else {
                if (compositionLayer == null) {
                    Logger2.m640b("Cannot resolve KeyPath. Composition is not set yet.");
                    listEmptyList = Collections.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList();
                    this.f2383x.mo711c(keyPath, 0, arrayList, new KeyPath(new String[0]));
                    listEmptyList = arrayList;
                }
                for (int i2 = 0; i2 < listEmptyList.size(); i2++) {
                    ((KeyPath) listEmptyList.get(i2)).f2714c.mo714g(t, lottieValueCallback);
                }
                zIsEmpty = true ^ listEmptyList.isEmpty();
            }
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == LottieProperty.f2419A) {
                m701u(m687g());
            }
        }
    }

    /* renamed from: b */
    public final void m682b() {
        LottieComposition lottieComposition = this.f2370k;
        JsonReader2.a aVar = LayerParser.f2280a;
        Rect rect = lottieComposition.f2345j;
        Layer2 layer2 = new Layer2(Collections.emptyList(), lottieComposition, "__container", -1L, Layer2.a.PRE_COMP, -1L, null, Collections.emptyList(), new AnimatableTransform(null, null, null, null, null, null, null, null, null), 0, 0, 0, 0.0f, 0.0f, rect.width(), rect.height(), null, null, Collections.emptyList(), 1, null, false);
        LottieComposition lottieComposition2 = this.f2370k;
        this.f2383x = new CompositionLayer(this, layer2, lottieComposition2.f2344i, lottieComposition2);
    }

    /* renamed from: c */
    public void m683c() {
        LottieValueAnimator lottieValueAnimator = this.f2371l;
        if (lottieValueAnimator.f2305t) {
            lottieValueAnimator.cancel();
        }
        this.f2370k = null;
        this.f2383x = null;
        this.f2378s = null;
        LottieValueAnimator lottieValueAnimator2 = this.f2371l;
        lottieValueAnimator2.f2304s = null;
        lottieValueAnimator2.f2302q = -2.1474836E9f;
        lottieValueAnimator2.f2303r = 2.1474836E9f;
        invalidateSelf();
    }

    /* renamed from: d */
    public final void m684d(@NonNull Canvas canvas) {
        float f2;
        float f3;
        int iSave = -1;
        if (ImageView.ScaleType.FIT_XY != this.f2377r) {
            if (this.f2383x == null) {
                return;
            }
            float f4 = this.f2372m;
            float fMin = Math.min(canvas.getWidth() / this.f2370k.f2345j.width(), canvas.getHeight() / this.f2370k.f2345j.height());
            if (f4 > fMin) {
                f2 = this.f2372m / fMin;
            } else {
                fMin = f4;
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                iSave = canvas.save();
                float fWidth = this.f2370k.f2345j.width() / 2.0f;
                float fHeight = this.f2370k.f2345j.height() / 2.0f;
                float f5 = fWidth * fMin;
                float f6 = fHeight * fMin;
                float f7 = this.f2372m;
                canvas.translate((fWidth * f7) - f5, (f7 * fHeight) - f6);
                canvas.scale(f2, f2, f5, f6);
            }
            this.f2369j.reset();
            this.f2369j.preScale(fMin, fMin);
            this.f2383x.mo713f(canvas, this.f2369j, this.f2384y);
            if (iSave > 0) {
                canvas.restoreToCount(iSave);
                return;
            }
            return;
        }
        if (this.f2383x == null) {
            return;
        }
        Rect bounds = getBounds();
        float fWidth2 = bounds.width() / this.f2370k.f2345j.width();
        float fHeight2 = bounds.height() / this.f2370k.f2345j.height();
        if (this.f2367B) {
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
        this.f2369j.reset();
        this.f2369j.preScale(fWidth2, fHeight2);
        this.f2383x.mo713f(canvas, this.f2369j, this.f2384y);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.f2368C = false;
        if (this.f2374o) {
            try {
                m684d(canvas);
            } catch (Throwable unused) {
                Objects.requireNonNull((LogcatLogger2) Logger2.f2296a);
            }
        } else {
            m684d(canvas);
        }
        L.m663a("Drawable#draw");
    }

    /* renamed from: e */
    public float m685e() {
        return this.f2371l.m644i();
    }

    /* renamed from: f */
    public float m686f() {
        return this.f2371l.m645j();
    }

    @FloatRange(from = 0.0d, m75to = 1.0d)
    /* renamed from: g */
    public float m687g() {
        return this.f2371l.m643h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2384y;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f2370k == null) {
            return -1;
        }
        return (int) (r0.f2345j.height() * this.f2372m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f2370k == null) {
            return -1;
        }
        return (int) (r0.f2345j.width() * this.f2372m);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: h */
    public int m688h() {
        return this.f2371l.getRepeatCount();
    }

    /* renamed from: i */
    public boolean m689i() {
        LottieValueAnimator lottieValueAnimator = this.f2371l;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.f2305t;
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
        if (this.f2368C) {
            return;
        }
        this.f2368C = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return m689i();
    }

    @MainThread
    /* renamed from: j */
    public void m690j() {
        if (this.f2383x == null) {
            this.f2375p.add(new g());
            return;
        }
        if (this.f2373n || m688h() == 0) {
            LottieValueAnimator lottieValueAnimator = this.f2371l;
            lottieValueAnimator.f2305t = true;
            boolean zM646k = lottieValueAnimator.m646k();
            for (Animator.AnimatorListener animatorListener : lottieValueAnimator.f2294k) {
                if (Build.VERSION.SDK_INT >= 26) {
                    animatorListener.onAnimationStart(lottieValueAnimator, zM646k);
                } else {
                    animatorListener.onAnimationStart(lottieValueAnimator);
                }
            }
            lottieValueAnimator.m649n((int) (lottieValueAnimator.m646k() ? lottieValueAnimator.m644i() : lottieValueAnimator.m645j()));
            lottieValueAnimator.f2299n = 0L;
            lottieValueAnimator.f2301p = 0;
            lottieValueAnimator.m647l();
        }
        if (this.f2373n) {
            return;
        }
        m692l((int) (this.f2371l.f2297l < 0.0f ? m686f() : m685e()));
        this.f2371l.m642g();
    }

    @MainThread
    /* renamed from: k */
    public void m691k() {
        if (this.f2383x == null) {
            this.f2375p.add(new h());
            return;
        }
        if (this.f2373n || m688h() == 0) {
            LottieValueAnimator lottieValueAnimator = this.f2371l;
            lottieValueAnimator.f2305t = true;
            lottieValueAnimator.m647l();
            lottieValueAnimator.f2299n = 0L;
            if (lottieValueAnimator.m646k() && lottieValueAnimator.f2300o == lottieValueAnimator.m645j()) {
                lottieValueAnimator.f2300o = lottieValueAnimator.m644i();
            } else if (!lottieValueAnimator.m646k() && lottieValueAnimator.f2300o == lottieValueAnimator.m644i()) {
                lottieValueAnimator.f2300o = lottieValueAnimator.m645j();
            }
        }
        if (this.f2373n) {
            return;
        }
        m692l((int) (this.f2371l.f2297l < 0.0f ? m686f() : m685e()));
        this.f2371l.m642g();
    }

    /* renamed from: l */
    public void m692l(int i2) {
        if (this.f2370k == null) {
            this.f2375p.add(new c(i2));
        } else {
            this.f2371l.m649n(i2);
        }
    }

    /* renamed from: m */
    public void m693m(int i2) {
        if (this.f2370k == null) {
            this.f2375p.add(new k(i2));
            return;
        }
        LottieValueAnimator lottieValueAnimator = this.f2371l;
        lottieValueAnimator.m650o(lottieValueAnimator.f2302q, i2 + 0.99f);
    }

    /* renamed from: n */
    public void m694n(String str) {
        LottieComposition lottieComposition = this.f2370k;
        if (lottieComposition == null) {
            this.f2375p.add(new n(str));
            return;
        }
        Marker2 marker2M672d = lottieComposition.m672d(str);
        if (marker2M672d == null) {
            throw new IllegalArgumentException(outline.m886y("Cannot find marker with name ", str, "."));
        }
        m693m((int) (marker2M672d.f2718b + marker2M672d.f2719c));
    }

    /* renamed from: o */
    public void m695o(@FloatRange(from = 0.0d, m75to = 1.0d) float f2) {
        LottieComposition lottieComposition = this.f2370k;
        if (lottieComposition == null) {
            this.f2375p.add(new l(f2));
        } else {
            m693m((int) MiscUtils.m655e(lottieComposition.f2346k, lottieComposition.f2347l, f2));
        }
    }

    /* renamed from: p */
    public void m696p(int i2, int i3) {
        if (this.f2370k == null) {
            this.f2375p.add(new b(i2, i3));
        } else {
            this.f2371l.m650o(i2, i3 + 0.99f);
        }
    }

    /* renamed from: q */
    public void m697q(String str) {
        LottieComposition lottieComposition = this.f2370k;
        if (lottieComposition == null) {
            this.f2375p.add(new a(str));
            return;
        }
        Marker2 marker2M672d = lottieComposition.m672d(str);
        if (marker2M672d == null) {
            throw new IllegalArgumentException(outline.m886y("Cannot find marker with name ", str, "."));
        }
        int i2 = (int) marker2M672d.f2718b;
        m696p(i2, ((int) marker2M672d.f2719c) + i2);
    }

    /* renamed from: r */
    public void m698r(int i2) {
        if (this.f2370k == null) {
            this.f2375p.add(new i(i2));
        } else {
            this.f2371l.m650o(i2, (int) r0.f2303r);
        }
    }

    /* renamed from: s */
    public void m699s(String str) {
        LottieComposition lottieComposition = this.f2370k;
        if (lottieComposition == null) {
            this.f2375p.add(new m(str));
            return;
        }
        Marker2 marker2M672d = lottieComposition.m672d(str);
        if (marker2M672d == null) {
            throw new IllegalArgumentException(outline.m886y("Cannot find marker with name ", str, "."));
        }
        m698r((int) marker2M672d.f2718b);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, m76to = 255) int i2) {
        this.f2384y = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Logger2.m640b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        m690j();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        this.f2375p.clear();
        this.f2371l.m642g();
    }

    /* renamed from: t */
    public void m700t(float f2) {
        LottieComposition lottieComposition = this.f2370k;
        if (lottieComposition == null) {
            this.f2375p.add(new j(f2));
        } else {
            m698r((int) MiscUtils.m655e(lottieComposition.f2346k, lottieComposition.f2347l, f2));
        }
    }

    /* renamed from: u */
    public void m701u(@FloatRange(from = 0.0d, m75to = 1.0d) float f2) {
        LottieComposition lottieComposition = this.f2370k;
        if (lottieComposition == null) {
            this.f2375p.add(new d(f2));
        } else {
            this.f2371l.m649n(MiscUtils.m655e(lottieComposition.f2346k, lottieComposition.f2347l, f2));
            L.m663a("Drawable#setProgress");
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

    /* renamed from: v */
    public final void m702v() {
        if (this.f2370k == null) {
            return;
        }
        float f2 = this.f2372m;
        setBounds(0, 0, (int) (r0.f2345j.width() * f2), (int) (this.f2370k.f2345j.height() * f2));
    }
}
