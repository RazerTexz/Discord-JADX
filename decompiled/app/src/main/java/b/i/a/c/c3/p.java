package b.i.a.c.c3;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.w0;
import b.i.b.b.h0;
import b.i.b.b.j0;
import java.util.Locale;
import java.util.Objects;

/* compiled from: TrackSelectionParameters.java */
/* loaded from: classes3.dex */
public class p implements w0 {
    public static final p j = new p(new a());
    public final b.i.b.b.p<String> A;
    public final b.i.b.b.p<String> B;
    public final int C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final o G;
    public final b.i.b.b.r<Integer> H;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f905s;
    public final int t;
    public final boolean u;
    public final b.i.b.b.p<String> v;
    public final b.i.b.b.p<String> w;

    /* renamed from: x, reason: collision with root package name */
    public final int f906x;

    /* renamed from: y, reason: collision with root package name */
    public final int f907y;

    /* renamed from: z, reason: collision with root package name */
    public final int f908z;

    /* compiled from: TrackSelectionParameters.java */
    public static class a {
        public int e;
        public int f;
        public int g;
        public int h;
        public b.i.b.b.p<String> l;
        public b.i.b.b.p<String> m;
        public int n;
        public int o;
        public int p;
        public b.i.b.b.p<String> q;
        public b.i.b.b.p<String> r;

        /* renamed from: s, reason: collision with root package name */
        public int f910s;
        public boolean t;
        public boolean u;
        public boolean v;
        public o w;

        /* renamed from: x, reason: collision with root package name */
        public b.i.b.b.r<Integer> f911x;
        public int a = Integer.MAX_VALUE;

        /* renamed from: b, reason: collision with root package name */
        public int f909b = Integer.MAX_VALUE;
        public int c = Integer.MAX_VALUE;
        public int d = Integer.MAX_VALUE;
        public int i = Integer.MAX_VALUE;
        public int j = Integer.MAX_VALUE;
        public boolean k = true;

        @Deprecated
        public a() {
            b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
            b.i.b.b.p pVar = h0.l;
            this.l = pVar;
            this.m = pVar;
            this.n = 0;
            this.o = Integer.MAX_VALUE;
            this.p = Integer.MAX_VALUE;
            this.q = pVar;
            this.r = pVar;
            this.f910s = 0;
            this.t = false;
            this.u = false;
            this.v = false;
            this.w = o.j;
            int i = b.i.b.b.r.k;
            this.f911x = j0.m;
        }

        public a a(Context context) {
            CaptioningManager captioningManager;
            int i = e0.a;
            if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
                this.f910s = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.r = b.i.b.b.p.u(i >= 21 ? locale.toLanguageTag() : locale.toString());
                }
            }
            return this;
        }

        public a b(int i, int i2, boolean z2) {
            this.i = i;
            this.j = i2;
            this.k = z2;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a c(Context context, boolean z2) {
            Point point;
            int i;
            DisplayManager displayManager;
            int i2 = e0.a;
            Display display = (i2 < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
            if (display == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Objects.requireNonNull(windowManager);
                display = windowManager.getDefaultDisplay();
            }
            if (display.getDisplayId() == 0 && e0.A(context)) {
                String strV = i2 < 28 ? e0.v("sys.display-size") : e0.v("vendor.display-size");
                if (!TextUtils.isEmpty(strV)) {
                    try {
                        String[] strArrH = e0.H(strV.trim(), "x");
                        if (strArrH.length == 2) {
                            int i3 = Integer.parseInt(strArrH[0]);
                            int i4 = Integer.parseInt(strArrH[1]);
                            if (i3 > 0 && i4 > 0) {
                                point = new Point(i3, i4);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                    String strValueOf = String.valueOf(strV);
                    Log.e("Util", strValueOf.length() != 0 ? "Invalid display size: ".concat(strValueOf) : new String("Invalid display size: "));
                    if (!"Sony".equals(e0.c) && e0.d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                        point = new Point(3840, 2160);
                    }
                } else if (!"Sony".equals(e0.c)) {
                    point = new Point();
                    i = e0.a;
                    if (i < 23) {
                    }
                }
            } else {
                point = new Point();
                i = e0.a;
                if (i < 23) {
                    Display.Mode mode = display.getMode();
                    point.x = mode.getPhysicalWidth();
                    point.y = mode.getPhysicalHeight();
                } else if (i >= 17) {
                    display.getRealSize(point);
                } else {
                    display.getSize(point);
                }
            }
            return b(point.x, point.y, z2);
        }
    }

    public p(a aVar) {
        this.k = aVar.a;
        this.l = aVar.f909b;
        this.m = aVar.c;
        this.n = aVar.d;
        this.o = aVar.e;
        this.p = aVar.f;
        this.q = aVar.g;
        this.r = aVar.h;
        this.f905s = aVar.i;
        this.t = aVar.j;
        this.u = aVar.k;
        this.v = aVar.l;
        this.w = aVar.m;
        this.f906x = aVar.n;
        this.f907y = aVar.o;
        this.f908z = aVar.p;
        this.A = aVar.q;
        this.B = aVar.r;
        this.C = aVar.f910s;
        this.D = aVar.t;
        this.E = aVar.u;
        this.F = aVar.v;
        this.G = aVar.w;
        this.H = aVar.f911x;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.k == pVar.k && this.l == pVar.l && this.m == pVar.m && this.n == pVar.n && this.o == pVar.o && this.p == pVar.p && this.q == pVar.q && this.r == pVar.r && this.u == pVar.u && this.f905s == pVar.f905s && this.t == pVar.t && this.v.equals(pVar.v) && this.w.equals(pVar.w) && this.f906x == pVar.f906x && this.f907y == pVar.f907y && this.f908z == pVar.f908z && this.A.equals(pVar.A) && this.B.equals(pVar.B) && this.C == pVar.C && this.D == pVar.D && this.E == pVar.E && this.F == pVar.F && this.G.equals(pVar.G) && this.H.equals(pVar.H);
    }

    public int hashCode() {
        return this.H.hashCode() + ((this.G.hashCode() + ((((((((((this.B.hashCode() + ((this.A.hashCode() + ((((((((this.w.hashCode() + ((this.v.hashCode() + ((((((((((((((((((((((this.k + 31) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + (this.u ? 1 : 0)) * 31) + this.f905s) * 31) + this.t) * 31)) * 31)) * 31) + this.f906x) * 31) + this.f907y) * 31) + this.f908z) * 31)) * 31)) * 31) + this.C) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31)) * 31);
    }
}
