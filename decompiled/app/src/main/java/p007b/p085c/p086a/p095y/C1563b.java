package p007b.p085c.p086a.p095y;

import android.graphics.Paint;
import androidx.browser.trusted.sharing.ShareTarget;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;

/* renamed from: b.c.a.y.b */
/* loaded from: classes.dex */
public /* synthetic */ class C1563b {

    /* renamed from: A */
    public static /* synthetic */ int[] f2655A;

    /* renamed from: B */
    public static /* synthetic */ int[] f2656B;

    /* renamed from: C */
    public static /* synthetic */ int[] f2657C;

    /* renamed from: D */
    public static /* synthetic */ int[] f2658D;

    /* renamed from: E */
    public static /* synthetic */ int[] f2659E;

    /* renamed from: F */
    public static /* synthetic */ int[] f2660F;

    /* renamed from: G */
    public static /* synthetic */ int[] f2661G;

    /* renamed from: H */
    public static /* synthetic */ int[] f2662H;

    /* renamed from: I */
    public static /* synthetic */ int[] f2663I;

    /* renamed from: J */
    public static /* synthetic */ int[] f2664J;

    /* renamed from: K */
    public static /* synthetic */ int[] f2665K;

    /* renamed from: L */
    public static /* synthetic */ int[] f2666L;

    /* renamed from: a */
    public static /* synthetic */ int[] f2667a;

    /* renamed from: b */
    public static /* synthetic */ int[] f2668b;

    /* renamed from: c */
    public static /* synthetic */ int[] f2669c;

    /* renamed from: d */
    public static /* synthetic */ int[] f2670d;

    /* renamed from: e */
    public static /* synthetic */ int[] f2671e;

    /* renamed from: f */
    public static /* synthetic */ int[] f2672f;

    /* renamed from: g */
    public static /* synthetic */ int[] f2673g;

    /* renamed from: h */
    public static /* synthetic */ int[] f2674h;

    /* renamed from: i */
    public static /* synthetic */ int[] f2675i;

    /* renamed from: j */
    public static /* synthetic */ int[] f2676j;

    /* renamed from: k */
    public static /* synthetic */ int[] f2677k;

    /* renamed from: l */
    public static /* synthetic */ int[] f2678l;

    /* renamed from: m */
    public static /* synthetic */ int[] f2679m;

    /* renamed from: n */
    public static /* synthetic */ int[] f2680n;

    /* renamed from: o */
    public static /* synthetic */ int[] f2681o;

    /* renamed from: p */
    public static /* synthetic */ int[] f2682p;

    /* renamed from: q */
    public static /* synthetic */ int[] f2683q;

    /* renamed from: r */
    public static /* synthetic */ int[] f2684r;

    /* renamed from: s */
    public static /* synthetic */ int[] f2685s;

    /* renamed from: t */
    public static /* synthetic */ int[] f2686t;

    /* renamed from: u */
    public static /* synthetic */ int[] f2687u;

    /* renamed from: v */
    public static /* synthetic */ int[] f2688v;

    /* renamed from: w */
    public static /* synthetic */ int[] f2689w;

    /* renamed from: x */
    public static /* synthetic */ int[] f2690x;

    /* renamed from: y */
    public static /* synthetic */ int[] f2691y;

    /* renamed from: z */
    public static /* synthetic */ int[] f2692z;

    /* renamed from: a */
    public static synchronized /* synthetic */ int[] m750a() {
        if (f2667a == null) {
            f2667a = m759i(3);
        }
        return f2667a;
    }

    /* renamed from: b */
    public static synchronized /* synthetic */ int[] m751b() {
        if (f2670d == null) {
            f2670d = m759i(3);
        }
        return f2670d;
    }

    /* renamed from: c */
    public static synchronized /* synthetic */ int[] m752c() {
        if (f2671e == null) {
            f2671e = m759i(3);
        }
        return f2671e;
    }

    public static int[] com$airbnb$lottie$model$DocumentData$Justification$s$values() {
        return (int[]) m750a().clone();
    }

    public static int[] com$airbnb$lottie$model$content$ShapeStroke$LineCapType$s$values() {
        return (int[]) m751b().clone();
    }

    /* renamed from: com$airbnb$lottie$model$content$ShapeStroke$LineJoinType$s$values */
    public static int[] m753x4b958c1e() {
        return (int[]) m752c().clone();
    }

    public static int[] com$airbnb$lottie$model$layer$Layer$MatteType$s$values() {
        return (int[]) m754d().clone();
    }

    public static int[] com$fasterxml$jackson$databind$cfg$CoercionInputShape$s$values() {
        return (int[]) m755e().clone();
    }

    public static int[] com$fasterxml$jackson$databind$type$LogicalType$s$values() {
        return (int[]) m756f().clone();
    }

    /* renamed from: d */
    public static synchronized /* synthetic */ int[] m754d() {
        if (f2673g == null) {
            f2673g = m759i(4);
        }
        return f2673g;
    }

    /* renamed from: e */
    public static synchronized /* synthetic */ int[] m755e() {
        if (f2688v == null) {
            f2688v = m759i(10);
        }
        return f2688v;
    }

    /* renamed from: f */
    public static synchronized /* synthetic */ int[] m756f() {
        if (f2689w == null) {
            f2689w = m759i(13);
        }
        return f2689w;
    }

    /* renamed from: g */
    public static /* synthetic */ boolean m757g(int i, int i2) {
        if (i != 0) {
            return i == i2;
        }
        throw null;
    }

    /* renamed from: h */
    public static /* synthetic */ int m758h(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    /* renamed from: i */
    public static /* synthetic */ int[] m759i(int i) {
        int[] iArr = new int[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            iArr[i2] = i3;
            i2 = i3;
        }
        return iArr;
    }

    /* renamed from: j */
    public static /* synthetic */ void m760j(int i) {
        if (i == 0) {
            throw null;
        }
    }

    /* renamed from: k */
    public static Paint.Cap m761k(int i) {
        int iM758h = m758h(i);
        return iM758h != 0 ? iM758h != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
    }

    /* renamed from: l */
    public static Paint.Join m762l(int i) {
        int iM758h = m758h(i);
        if (iM758h == 0) {
            return Paint.Join.MITER;
        }
        if (iM758h == 1) {
            return Paint.Join.ROUND;
        }
        if (iM758h != 2) {
            return null;
        }
        return Paint.Join.BEVEL;
    }

    /* renamed from: m */
    public static int m763m(AppSettingsData appSettingsData) {
        boolean z2 = appSettingsData.f12755g == 2;
        boolean z3 = appSettingsData.f12756h == 2;
        if (z2) {
            return !z3 ? 2 : 3;
        }
        return 1;
    }

    /* renamed from: n */
    public static /* synthetic */ String m764n(int i) {
        if (i == 1) {
            return ShareTarget.METHOD_GET;
        }
        if (i == 2) {
            return ShareTarget.METHOD_POST;
        }
        if (i == 3) {
            return "PUT";
        }
        if (i == 4) {
            return "DELETE";
        }
        throw null;
    }
}
