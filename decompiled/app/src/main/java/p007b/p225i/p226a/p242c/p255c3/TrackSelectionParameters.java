package p007b.p225i.p226a.p242c.p255c3;

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
import java.util.Locale;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.ImmutableSet2;
import p007b.p225i.p355b.p357b.RegularImmutableList;
import p007b.p225i.p355b.p357b.RegularImmutableSet;

/* compiled from: TrackSelectionParameters.java */
/* renamed from: b.i.a.c.c3.p, reason: use source file name */
/* loaded from: classes3.dex */
public class TrackSelectionParameters implements Bundleable {

    /* renamed from: j */
    public static final TrackSelectionParameters f6276j = new TrackSelectionParameters(new a());

    /* renamed from: A */
    public final ImmutableList2<String> f6277A;

    /* renamed from: B */
    public final ImmutableList2<String> f6278B;

    /* renamed from: C */
    public final int f6279C;

    /* renamed from: D */
    public final boolean f6280D;

    /* renamed from: E */
    public final boolean f6281E;

    /* renamed from: F */
    public final boolean f6282F;

    /* renamed from: G */
    public final TrackSelectionOverrides f6283G;

    /* renamed from: H */
    public final ImmutableSet2<Integer> f6284H;

    /* renamed from: k */
    public final int f6285k;

    /* renamed from: l */
    public final int f6286l;

    /* renamed from: m */
    public final int f6287m;

    /* renamed from: n */
    public final int f6288n;

    /* renamed from: o */
    public final int f6289o;

    /* renamed from: p */
    public final int f6290p;

    /* renamed from: q */
    public final int f6291q;

    /* renamed from: r */
    public final int f6292r;

    /* renamed from: s */
    public final int f6293s;

    /* renamed from: t */
    public final int f6294t;

    /* renamed from: u */
    public final boolean f6295u;

    /* renamed from: v */
    public final ImmutableList2<String> f6296v;

    /* renamed from: w */
    public final ImmutableList2<String> f6297w;

    /* renamed from: x */
    public final int f6298x;

    /* renamed from: y */
    public final int f6299y;

    /* renamed from: z */
    public final int f6300z;

    /* compiled from: TrackSelectionParameters.java */
    /* renamed from: b.i.a.c.c3.p$a */
    public static class a {

        /* renamed from: e */
        public int f6305e;

        /* renamed from: f */
        public int f6306f;

        /* renamed from: g */
        public int f6307g;

        /* renamed from: h */
        public int f6308h;

        /* renamed from: l */
        public ImmutableList2<String> f6312l;

        /* renamed from: m */
        public ImmutableList2<String> f6313m;

        /* renamed from: n */
        public int f6314n;

        /* renamed from: o */
        public int f6315o;

        /* renamed from: p */
        public int f6316p;

        /* renamed from: q */
        public ImmutableList2<String> f6317q;

        /* renamed from: r */
        public ImmutableList2<String> f6318r;

        /* renamed from: s */
        public int f6319s;

        /* renamed from: t */
        public boolean f6320t;

        /* renamed from: u */
        public boolean f6321u;

        /* renamed from: v */
        public boolean f6322v;

        /* renamed from: w */
        public TrackSelectionOverrides f6323w;

        /* renamed from: x */
        public ImmutableSet2<Integer> f6324x;

        /* renamed from: a */
        public int f6301a = Integer.MAX_VALUE;

        /* renamed from: b */
        public int f6302b = Integer.MAX_VALUE;

        /* renamed from: c */
        public int f6303c = Integer.MAX_VALUE;

        /* renamed from: d */
        public int f6304d = Integer.MAX_VALUE;

        /* renamed from: i */
        public int f6309i = Integer.MAX_VALUE;

        /* renamed from: j */
        public int f6310j = Integer.MAX_VALUE;

        /* renamed from: k */
        public boolean f6311k = true;

        @Deprecated
        public a() {
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
            ImmutableList2 immutableList2 = RegularImmutableList.f12012l;
            this.f6312l = immutableList2;
            this.f6313m = immutableList2;
            this.f6314n = 0;
            this.f6315o = Integer.MAX_VALUE;
            this.f6316p = Integer.MAX_VALUE;
            this.f6317q = immutableList2;
            this.f6318r = immutableList2;
            this.f6319s = 0;
            this.f6320t = false;
            this.f6321u = false;
            this.f6322v = false;
            this.f6323w = TrackSelectionOverrides.f6270j;
            int i = ImmutableSet2.f12057k;
            this.f6324x = RegularImmutableSet.f12032m;
        }

        /* renamed from: a */
        public a mo2742a(Context context) {
            CaptioningManager captioningManager;
            int i = Util2.f6708a;
            if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
                this.f6319s = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f6318r = ImmutableList2.m6266u(i >= 21 ? locale.toLanguageTag() : locale.toString());
                }
            }
            return this;
        }

        /* renamed from: b */
        public a mo2743b(int i, int i2, boolean z2) {
            this.f6309i = i;
            this.f6310j = i2;
            this.f6311k = z2;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a mo2744c(Context context, boolean z2) {
            Point point;
            int i;
            DisplayManager displayManager;
            int i2 = Util2.f6708a;
            Display display = (i2 < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
            if (display == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Objects.requireNonNull(windowManager);
                display = windowManager.getDefaultDisplay();
            }
            if (display.getDisplayId() == 0 && Util2.m2980A(context)) {
                String strM3014v = i2 < 28 ? Util2.m3014v("sys.display-size") : Util2.m3014v("vendor.display-size");
                if (!TextUtils.isEmpty(strM3014v)) {
                    try {
                        String[] strArrM2987H = Util2.m2987H(strM3014v.trim(), "x");
                        if (strArrM2987H.length == 2) {
                            int i3 = Integer.parseInt(strArrM2987H[0]);
                            int i4 = Integer.parseInt(strArrM2987H[1]);
                            if (i3 > 0 && i4 > 0) {
                                point = new Point(i3, i4);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                    String strValueOf = String.valueOf(strM3014v);
                    Log.e("Util", strValueOf.length() != 0 ? "Invalid display size: ".concat(strValueOf) : new String("Invalid display size: "));
                    if (!"Sony".equals(Util2.f6710c) && Util2.f6711d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                        point = new Point(3840, 2160);
                    }
                } else if (!"Sony".equals(Util2.f6710c)) {
                    point = new Point();
                    i = Util2.f6708a;
                    if (i < 23) {
                    }
                }
            } else {
                point = new Point();
                i = Util2.f6708a;
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
            return mo2743b(point.x, point.y, z2);
        }
    }

    public TrackSelectionParameters(a aVar) {
        this.f6285k = aVar.f6301a;
        this.f6286l = aVar.f6302b;
        this.f6287m = aVar.f6303c;
        this.f6288n = aVar.f6304d;
        this.f6289o = aVar.f6305e;
        this.f6290p = aVar.f6306f;
        this.f6291q = aVar.f6307g;
        this.f6292r = aVar.f6308h;
        this.f6293s = aVar.f6309i;
        this.f6294t = aVar.f6310j;
        this.f6295u = aVar.f6311k;
        this.f6296v = aVar.f6312l;
        this.f6297w = aVar.f6313m;
        this.f6298x = aVar.f6314n;
        this.f6299y = aVar.f6315o;
        this.f6300z = aVar.f6316p;
        this.f6277A = aVar.f6317q;
        this.f6278B = aVar.f6318r;
        this.f6279C = aVar.f6319s;
        this.f6280D = aVar.f6320t;
        this.f6281E = aVar.f6321u;
        this.f6282F = aVar.f6322v;
        this.f6283G = aVar.f6323w;
        this.f6284H = aVar.f6324x;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.f6285k == trackSelectionParameters.f6285k && this.f6286l == trackSelectionParameters.f6286l && this.f6287m == trackSelectionParameters.f6287m && this.f6288n == trackSelectionParameters.f6288n && this.f6289o == trackSelectionParameters.f6289o && this.f6290p == trackSelectionParameters.f6290p && this.f6291q == trackSelectionParameters.f6291q && this.f6292r == trackSelectionParameters.f6292r && this.f6295u == trackSelectionParameters.f6295u && this.f6293s == trackSelectionParameters.f6293s && this.f6294t == trackSelectionParameters.f6294t && this.f6296v.equals(trackSelectionParameters.f6296v) && this.f6297w.equals(trackSelectionParameters.f6297w) && this.f6298x == trackSelectionParameters.f6298x && this.f6299y == trackSelectionParameters.f6299y && this.f6300z == trackSelectionParameters.f6300z && this.f6277A.equals(trackSelectionParameters.f6277A) && this.f6278B.equals(trackSelectionParameters.f6278B) && this.f6279C == trackSelectionParameters.f6279C && this.f6280D == trackSelectionParameters.f6280D && this.f6281E == trackSelectionParameters.f6281E && this.f6282F == trackSelectionParameters.f6282F && this.f6283G.equals(trackSelectionParameters.f6283G) && this.f6284H.equals(trackSelectionParameters.f6284H);
    }

    public int hashCode() {
        return this.f6284H.hashCode() + ((this.f6283G.hashCode() + ((((((((((this.f6278B.hashCode() + ((this.f6277A.hashCode() + ((((((((this.f6297w.hashCode() + ((this.f6296v.hashCode() + ((((((((((((((((((((((this.f6285k + 31) * 31) + this.f6286l) * 31) + this.f6287m) * 31) + this.f6288n) * 31) + this.f6289o) * 31) + this.f6290p) * 31) + this.f6291q) * 31) + this.f6292r) * 31) + (this.f6295u ? 1 : 0)) * 31) + this.f6293s) * 31) + this.f6294t) * 31)) * 31)) * 31) + this.f6298x) * 31) + this.f6299y) * 31) + this.f6300z) * 31)) * 31)) * 31) + this.f6279C) * 31) + (this.f6280D ? 1 : 0)) * 31) + (this.f6281E ? 1 : 0)) * 31) + (this.f6282F ? 1 : 0)) * 31)) * 31);
    }
}
