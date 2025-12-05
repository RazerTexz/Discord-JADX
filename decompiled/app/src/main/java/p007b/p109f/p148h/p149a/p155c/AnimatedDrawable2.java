package p007b.p109f.p148h.p149a.p155c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import java.util.Objects;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p130f.p131a.DrawableWithCaches;
import p007b.p109f.p132g.p142e.DrawableProperties;
import p007b.p109f.p148h.p149a.p150a.AnimationBackend;
import p007b.p109f.p148h.p149a.p157e.DropFramesFrameScheduler;

/* compiled from: AnimatedDrawable2.java */
/* renamed from: b.f.h.a.c.a, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatedDrawable2 extends Drawable implements Animatable, DrawableWithCaches {

    /* renamed from: j */
    public static final Class<?> f3532j = AnimatedDrawable2.class;

    /* renamed from: k */
    public static final BaseAnimationListener f3533k = new BaseAnimationListener();

    /* renamed from: l */
    public AnimationBackend f3534l;

    /* renamed from: m */
    public DropFramesFrameScheduler f3535m;

    /* renamed from: n */
    public volatile boolean f3536n;

    /* renamed from: o */
    public long f3537o;

    /* renamed from: p */
    public long f3538p;

    /* renamed from: q */
    public long f3539q;

    /* renamed from: r */
    public int f3540r;

    /* renamed from: s */
    public long f3541s;

    /* renamed from: t */
    public long f3542t;

    /* renamed from: u */
    public int f3543u;

    /* renamed from: v */
    public long f3544v;

    /* renamed from: w */
    public int f3545w;

    /* renamed from: x */
    public volatile BaseAnimationListener f3546x;

    /* renamed from: y */
    public DrawableProperties f3547y;

    /* renamed from: z */
    public final Runnable f3548z;

    /* compiled from: AnimatedDrawable2.java */
    /* renamed from: b.f.h.a.c.a$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatedDrawable2 animatedDrawable2 = AnimatedDrawable2.this;
            animatedDrawable2.unscheduleSelf(animatedDrawable2.f3548z);
            AnimatedDrawable2.this.invalidateSelf();
        }
    }

    public AnimatedDrawable2() {
        this(null);
    }

    @Override // p007b.p109f.p130f.p131a.DrawableWithCaches
    /* renamed from: a */
    public void mo1034a() {
        AnimationBackend animationBackend = this.f3534l;
        if (animationBackend != null) {
            animationBackend.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        long j;
        if (this.f3534l == null || this.f3535m == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long jMax = this.f3536n ? (jUptimeMillis - this.f3537o) + 0 : Math.max(this.f3538p, 0L);
        DropFramesFrameScheduler dropFramesFrameScheduler = this.f3535m;
        long jM1167b = dropFramesFrameScheduler.m1167b();
        int iM1166a = jM1167b == 0 ? dropFramesFrameScheduler.m1166a(0L) : ((dropFramesFrameScheduler.f3561a.mo1143b() == 0) || jMax / jM1167b < ((long) dropFramesFrameScheduler.f3561a.mo1143b())) ? dropFramesFrameScheduler.m1166a(jMax % jM1167b) : -1;
        if (iM1166a == -1) {
            iM1166a = this.f3534l.mo1142a() - 1;
            Objects.requireNonNull(this.f3546x);
            this.f3536n = false;
        } else if (iM1166a == 0 && this.f3540r != -1 && jUptimeMillis >= this.f3539q) {
            Objects.requireNonNull(this.f3546x);
        }
        boolean zMo1141j = this.f3534l.mo1141j(this, canvas, iM1166a);
        if (zMo1141j) {
            Objects.requireNonNull(this.f3546x);
            this.f3540r = iM1166a;
        }
        if (!zMo1141j) {
            this.f3545w++;
            FLog.m980h(2);
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis();
        if (this.f3536n) {
            DropFramesFrameScheduler dropFramesFrameScheduler2 = this.f3535m;
            long j2 = jUptimeMillis2 - this.f3537o;
            long jM1167b2 = dropFramesFrameScheduler2.m1167b();
            if (jM1167b2 != 0) {
                if ((dropFramesFrameScheduler2.f3561a.mo1143b() == 0) || j2 / dropFramesFrameScheduler2.m1167b() < dropFramesFrameScheduler2.f3561a.mo1143b()) {
                    long j3 = j2 % jM1167b2;
                    int iMo1142a = dropFramesFrameScheduler2.f3561a.mo1142a();
                    long jMo1144e = 0;
                    for (int i = 0; i < iMo1142a && jMo1144e <= j3; i++) {
                        jMo1144e += dropFramesFrameScheduler2.f3561a.mo1144e(i);
                    }
                    j = (jMo1144e - j3) + j2;
                } else {
                    j = -1;
                }
                if (j != -1) {
                    long j4 = this.f3537o + j + this.f3544v;
                    this.f3539q = j4;
                    scheduleSelf(this.f3548z, j4);
                } else {
                    Objects.requireNonNull(this.f3546x);
                    this.f3536n = false;
                }
            }
        }
        this.f3538p = jMax;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AnimationBackend animationBackend = this.f3534l;
        return animationBackend == null ? super.getIntrinsicHeight() : animationBackend.mo1138g();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AnimationBackend animationBackend = this.f3534l;
        return animationBackend == null ? super.getIntrinsicWidth() : animationBackend.mo1140i();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f3536n;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        AnimationBackend animationBackend = this.f3534l;
        if (animationBackend != null) {
            animationBackend.mo1139h(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        if (this.f3536n) {
            return false;
        }
        long j = i;
        if (this.f3538p == j) {
            return false;
        }
        this.f3538p = j;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f3547y == null) {
            this.f3547y = new DrawableProperties();
        }
        this.f3547y.f3339a = i;
        AnimationBackend animationBackend = this.f3534l;
        if (animationBackend != null) {
            animationBackend.mo1137f(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f3547y == null) {
            this.f3547y = new DrawableProperties();
        }
        DrawableProperties drawableProperties = this.f3547y;
        drawableProperties.f3341c = colorFilter;
        drawableProperties.f3340b = colorFilter != null;
        AnimationBackend animationBackend = this.f3534l;
        if (animationBackend != null) {
            animationBackend.mo1136d(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        AnimationBackend animationBackend;
        if (this.f3536n || (animationBackend = this.f3534l) == null || animationBackend.mo1142a() <= 1) {
            return;
        }
        this.f3536n = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.f3541s;
        this.f3537o = j;
        this.f3539q = j;
        this.f3538p = jUptimeMillis - this.f3542t;
        this.f3540r = this.f3543u;
        invalidateSelf();
        Objects.requireNonNull(this.f3546x);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f3536n) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            this.f3541s = jUptimeMillis - this.f3537o;
            this.f3542t = jUptimeMillis - this.f3538p;
            this.f3543u = this.f3540r;
            this.f3536n = false;
            this.f3537o = 0L;
            this.f3539q = 0L;
            this.f3538p = -1L;
            this.f3540r = -1;
            unscheduleSelf(this.f3548z);
            Objects.requireNonNull(this.f3546x);
        }
    }

    public AnimatedDrawable2(AnimationBackend animationBackend) {
        this.f3544v = 8L;
        this.f3546x = f3533k;
        this.f3548z = new a();
        this.f3534l = animationBackend;
        this.f3535m = animationBackend == null ? null : new DropFramesFrameScheduler(animationBackend);
    }
}
