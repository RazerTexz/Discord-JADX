package b.i.a.c.c3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import b.i.a.c.a3.n0;
import b.i.a.c.a3.o0;
import b.i.a.c.c3.f;
import b.i.a.c.c3.j;
import b.i.a.c.c3.p;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.w0;
import b.i.b.b.f0;
import b.i.b.b.g0;
import b.i.b.b.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: DefaultTrackSelector.java */
/* loaded from: classes3.dex */
public class h extends l {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f898b = new int[0];
    public static final g0<Integer> c = g0.a(b.i.a.c.c3.c.j);
    public static final g0<Integer> d = g0.a(b.i.a.c.c3.b.j);
    public final j.b e;
    public final AtomicReference<d> f;

    /* compiled from: DefaultTrackSelector.java */
    public static final class b implements Comparable<b> {
        public final boolean j;

        @Nullable
        public final String k;
        public final d l;
        public final boolean m;
        public final int n;
        public final int o;
        public final int p;
        public final int q;
        public final int r;

        /* renamed from: s, reason: collision with root package name */
        public final boolean f899s;
        public final int t;
        public final int u;
        public final int v;
        public final int w;

        public b(j1 j1Var, d dVar, int i) {
            int i2;
            int iC;
            String[] strArrH;
            int iC2;
            this.l = dVar;
            this.k = h.g(j1Var.n);
            int i3 = 0;
            this.m = h.e(i, false);
            int i4 = 0;
            while (true) {
                i2 = Integer.MAX_VALUE;
                if (i4 >= dVar.w.size()) {
                    i4 = Integer.MAX_VALUE;
                    iC = 0;
                    break;
                } else {
                    iC = h.c(j1Var, dVar.w.get(i4), false);
                    if (iC > 0) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            this.o = i4;
            this.n = iC;
            this.p = Integer.bitCount(j1Var.p & dVar.f906x);
            this.f899s = (j1Var.o & 1) != 0;
            int i5 = j1Var.J;
            this.t = i5;
            this.u = j1Var.K;
            int i6 = j1Var.f1017s;
            this.v = i6;
            this.j = (i6 == -1 || i6 <= dVar.f908z) && (i5 == -1 || i5 <= dVar.f907y);
            int i7 = e0.a;
            Configuration configuration = Resources.getSystem().getConfiguration();
            int i8 = e0.a;
            if (i8 >= 24) {
                strArrH = e0.H(configuration.getLocales().toLanguageTags(), ",");
            } else {
                String[] strArr = new String[1];
                Locale locale = configuration.locale;
                strArr[0] = i8 >= 21 ? locale.toLanguageTag() : locale.toString();
                strArrH = strArr;
            }
            for (int i9 = 0; i9 < strArrH.length; i9++) {
                strArrH[i9] = e0.C(strArrH[i9]);
            }
            int i10 = 0;
            while (true) {
                if (i10 >= strArrH.length) {
                    i10 = Integer.MAX_VALUE;
                    iC2 = 0;
                    break;
                } else {
                    iC2 = h.c(j1Var, strArrH[i10], false);
                    if (iC2 > 0) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            this.q = i10;
            this.r = iC2;
            while (true) {
                if (i3 >= dVar.A.size()) {
                    break;
                }
                String str = j1Var.w;
                if (str != null && str.equals(dVar.A.get(i3))) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            this.w = i2;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(b bVar) {
            return f(bVar);
        }

        public int f(b bVar) {
            Object objB = (this.j && this.m) ? h.c : h.c.b();
            b.i.b.b.j jVarC = b.i.b.b.j.a.c(this.m, bVar.m);
            Integer numValueOf = Integer.valueOf(this.o);
            Integer numValueOf2 = Integer.valueOf(bVar.o);
            k0 k0Var = k0.j;
            b.i.b.b.j jVarB = jVarC.b(numValueOf, numValueOf2, k0Var).a(this.n, bVar.n).a(this.p, bVar.p).c(this.j, bVar.j).b(Integer.valueOf(this.w), Integer.valueOf(bVar.w), k0Var).b(Integer.valueOf(this.v), Integer.valueOf(bVar.v), this.l.E ? h.c.b() : h.d).c(this.f899s, bVar.f899s).b(Integer.valueOf(this.q), Integer.valueOf(bVar.q), k0Var).a(this.r, bVar.r).b(Integer.valueOf(this.t), Integer.valueOf(bVar.t), objB).b(Integer.valueOf(this.u), Integer.valueOf(bVar.u), objB);
            Integer numValueOf3 = Integer.valueOf(this.v);
            Integer numValueOf4 = Integer.valueOf(bVar.v);
            if (!e0.a(this.k, bVar.k)) {
                objB = h.d;
            }
            return jVarB.b(numValueOf3, numValueOf4, objB).e();
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    public static final class c implements Comparable<c> {
        public final boolean j;
        public final boolean k;

        public c(j1 j1Var, int i) {
            this.j = (j1Var.o & 1) != 0;
            this.k = h.e(i, false);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(c cVar) {
            return f(cVar);
        }

        public int f(c cVar) {
            return b.i.b.b.j.a.c(this.k, cVar.k).c(this.j, cVar.j).e();
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    public static final class d extends p implements w0 {
        public static final d I = new e().d();
        public final int J;
        public final boolean K;
        public final boolean L;
        public final boolean M;
        public final boolean N;
        public final boolean O;
        public final boolean P;
        public final boolean Q;
        public final boolean R;
        public final boolean S;
        public final boolean T;
        public final SparseArray<Map<o0, f>> U;
        public final SparseBooleanArray V;

        public d(e eVar, a aVar) {
            super(eVar);
            this.K = eVar.f900y;
            this.L = eVar.f901z;
            this.M = eVar.A;
            this.N = eVar.B;
            this.O = eVar.C;
            this.P = eVar.D;
            this.Q = eVar.E;
            this.J = eVar.F;
            this.R = eVar.G;
            this.S = eVar.H;
            this.T = eVar.I;
            this.U = eVar.J;
            this.V = eVar.K;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00e7 A[LOOP:0: B:49:0x0090->B:66:0x00e7, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x008d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
        @Override // b.i.a.c.c3.p
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean equals(@Nullable Object obj) {
            boolean z2;
            boolean z3;
            boolean z4;
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (super.equals(dVar) && this.K == dVar.K && this.L == dVar.L && this.M == dVar.M && this.N == dVar.N && this.O == dVar.O && this.P == dVar.P && this.Q == dVar.Q && this.J == dVar.J && this.R == dVar.R && this.S == dVar.S && this.T == dVar.T) {
                SparseBooleanArray sparseBooleanArray = this.V;
                SparseBooleanArray sparseBooleanArray2 = dVar.V;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() != size) {
                    z2 = false;
                    if (z2) {
                        SparseArray<Map<o0, f>> sparseArray = this.U;
                        SparseArray<Map<o0, f>> sparseArray2 = dVar.U;
                        int size2 = sparseArray.size();
                        if (sparseArray2.size() != size2) {
                            z3 = false;
                            if (!z3) {
                                return true;
                            }
                        } else {
                            for (int i = 0; i < size2; i++) {
                                int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                                if (iIndexOfKey >= 0) {
                                    Map<o0, f> mapValueAt = sparseArray.valueAt(i);
                                    Map<o0, f> mapValueAt2 = sparseArray2.valueAt(iIndexOfKey);
                                    if (mapValueAt2.size() != mapValueAt.size()) {
                                        z4 = false;
                                        if (!z4) {
                                        }
                                    } else {
                                        for (Map.Entry<o0, f> entry : mapValueAt.entrySet()) {
                                            o0 key = entry.getKey();
                                            if (!mapValueAt2.containsKey(key) || !e0.a(entry.getValue(), mapValueAt2.get(key))) {
                                                z4 = false;
                                                break;
                                            }
                                        }
                                        z4 = true;
                                        if (!z4) {
                                        }
                                    }
                                }
                                z3 = false;
                                break;
                            }
                            z3 = true;
                            if (!z3) {
                            }
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                            z2 = false;
                            break;
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
            }
            return false;
        }

        @Override // b.i.a.c.c3.p
        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.K ? 1 : 0)) * 31) + (this.L ? 1 : 0)) * 31) + (this.M ? 1 : 0)) * 31) + (this.N ? 1 : 0)) * 31) + (this.O ? 1 : 0)) * 31) + (this.P ? 1 : 0)) * 31) + (this.Q ? 1 : 0)) * 31) + this.J) * 31) + (this.R ? 1 : 0)) * 31) + (this.S ? 1 : 0)) * 31) + (this.T ? 1 : 0);
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    public static final class f implements w0 {
        public final int j;
        public final int[] k;
        public final int l;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.j == fVar.j && Arrays.equals(this.k, fVar.k) && this.l == fVar.l;
        }

        public int hashCode() {
            return ((Arrays.hashCode(this.k) + (this.j * 31)) * 31) + this.l;
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    public static final class g implements Comparable<g> {
        public final boolean j;
        public final boolean k;
        public final boolean l;
        public final boolean m;
        public final int n;
        public final int o;
        public final int p;
        public final int q;
        public final boolean r;

        public g(j1 j1Var, d dVar, int i, @Nullable String str) {
            int iC;
            boolean z2 = false;
            this.k = h.e(i, false);
            int i2 = j1Var.o & (~dVar.J);
            this.l = (i2 & 1) != 0;
            this.m = (i2 & 2) != 0;
            int i3 = Integer.MAX_VALUE;
            b.i.b.b.p<String> pVarU = dVar.B.isEmpty() ? b.i.b.b.p.u("") : dVar.B;
            int i4 = 0;
            while (true) {
                if (i4 >= pVarU.size()) {
                    iC = 0;
                    break;
                }
                iC = h.c(j1Var, pVarU.get(i4), dVar.D);
                if (iC > 0) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
            this.n = i3;
            this.o = iC;
            int iBitCount = Integer.bitCount(j1Var.p & dVar.C);
            this.p = iBitCount;
            this.r = (j1Var.p & 1088) != 0;
            int iC2 = h.c(j1Var, str, h.g(str) == null);
            this.q = iC2;
            if (iC > 0 || ((dVar.B.isEmpty() && iBitCount > 0) || this.l || (this.m && iC2 > 0))) {
                z2 = true;
            }
            this.j = z2;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(g gVar) {
            return f(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [b.i.b.b.k0, java.util.Comparator] */
        public int f(g gVar) {
            b.i.b.b.j jVarC = b.i.b.b.j.a.c(this.k, gVar.k);
            Integer numValueOf = Integer.valueOf(this.n);
            Integer numValueOf2 = Integer.valueOf(gVar.n);
            f0 f0Var = f0.j;
            ?? r4 = k0.j;
            b.i.b.b.j jVarC2 = jVarC.b(numValueOf, numValueOf2, r4).a(this.o, gVar.o).a(this.p, gVar.p).c(this.l, gVar.l);
            Boolean boolValueOf = Boolean.valueOf(this.m);
            Boolean boolValueOf2 = Boolean.valueOf(gVar.m);
            if (this.o != 0) {
                f0Var = r4;
            }
            b.i.b.b.j jVarA = jVarC2.b(boolValueOf, boolValueOf2, f0Var).a(this.q, gVar.q);
            if (this.p == 0) {
                jVarA = jVarA.d(this.r, gVar.r);
            }
            return jVarA.e();
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    /* renamed from: b.i.a.c.c3.h$h, reason: collision with other inner class name */
    public static final class C0098h implements Comparable<C0098h> {
        public final boolean j;
        public final d k;
        public final boolean l;
        public final boolean m;
        public final int n;
        public final int o;
        public final int p;

        /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public C0098h(j1 j1Var, d dVar, int i, boolean z2) {
            boolean z3;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            this.k = dVar;
            int i9 = 0;
            boolean z4 = true;
            int i10 = -1;
            if (!z2 || (((i6 = j1Var.B) != -1 && i6 > dVar.k) || ((i7 = j1Var.C) != -1 && i7 > dVar.l))) {
                z3 = false;
            } else {
                float f = j1Var.D;
                if ((f == -1.0f || f <= dVar.m) && ((i8 = j1Var.f1017s) == -1 || i8 <= dVar.n)) {
                    z3 = true;
                }
            }
            this.j = z3;
            if (!z2 || (((i3 = j1Var.B) != -1 && i3 < dVar.o) || ((i4 = j1Var.C) != -1 && i4 < dVar.p))) {
                z4 = false;
            } else {
                float f2 = j1Var.D;
                if ((f2 != -1.0f && f2 < dVar.q) || ((i5 = j1Var.f1017s) != -1 && i5 < dVar.r)) {
                }
            }
            this.l = z4;
            this.m = h.e(i, false);
            this.n = j1Var.f1017s;
            int i11 = j1Var.B;
            if (i11 != -1 && (i2 = j1Var.C) != -1) {
                i10 = i11 * i2;
            }
            this.o = i10;
            int i12 = Integer.MAX_VALUE;
            while (true) {
                if (i9 < dVar.v.size()) {
                    String str = j1Var.w;
                    if (str != null && str.equals(dVar.v.get(i9))) {
                        i12 = i9;
                        break;
                    }
                    i9++;
                } else {
                    break;
                }
            }
            this.p = i12;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(C0098h c0098h) {
            return f(c0098h);
        }

        public int f(C0098h c0098h) {
            Object objB = (this.j && this.m) ? h.c : h.c.b();
            return b.i.b.b.j.a.c(this.m, c0098h.m).c(this.j, c0098h.j).c(this.l, c0098h.l).b(Integer.valueOf(this.p), Integer.valueOf(c0098h.p), k0.j).b(Integer.valueOf(this.n), Integer.valueOf(c0098h.n), this.k.E ? h.c.b() : h.d).b(Integer.valueOf(this.o), Integer.valueOf(c0098h.o), objB).b(Integer.valueOf(this.n), Integer.valueOf(c0098h.n), objB).e();
        }
    }

    public h(Context context) {
        f.b bVar = new f.b();
        d dVar = d.I;
        d dVarD = new e(context).d();
        this.e = bVar;
        this.f = new AtomicReference<>(dVarD);
    }

    public static int c(j1 j1Var, @Nullable String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(j1Var.n)) {
            return 4;
        }
        String strG = g(str);
        String strG2 = g(j1Var.n);
        if (strG2 == null || strG == null) {
            return (z2 && strG2 == null) ? 1 : 0;
        }
        if (strG2.startsWith(strG) || strG.startsWith(strG2)) {
            return 3;
        }
        int i = e0.a;
        return strG2.split("-", 2)[0].equals(strG.split("-", 2)[0]) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<Integer> d(n0 n0Var, int i, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Point point;
        int i7;
        ArrayList arrayList = new ArrayList(n0Var.k);
        for (int i8 = 0; i8 < n0Var.k; i8++) {
            arrayList.add(Integer.valueOf(i8));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i9 = 0;
            int i10 = Integer.MAX_VALUE;
            while (true) {
                if (i9 >= n0Var.k) {
                    break;
                }
                j1 j1Var = n0Var.l[i9];
                int i11 = j1Var.B;
                if (i11 > 0 && (i4 = j1Var.C) > 0) {
                    if (z2) {
                        if ((i11 > i4) != (i > i2)) {
                            i6 = i;
                            i5 = i2;
                        }
                        int i12 = i11 * i6;
                        int i13 = i4 * i5;
                        if (i12 < i13) {
                        }
                        i7 = j1Var.B;
                        int i14 = j1Var.C;
                        int i15 = i7 * i14;
                        if (i7 < ((int) (point.x * 0.98f))) {
                        }
                    } else {
                        i5 = i;
                        i6 = i2;
                        int i122 = i11 * i6;
                        int i132 = i4 * i5;
                        point = i122 < i132 ? new Point(i5, e0.f(i132, i11)) : new Point(e0.f(i122, i4), i6);
                        i7 = j1Var.B;
                        int i142 = j1Var.C;
                        int i152 = i7 * i142;
                        if (i7 < ((int) (point.x * 0.98f)) && i142 >= ((int) (point.y * 0.98f)) && i152 < i10) {
                            i10 = i152;
                        }
                    }
                }
                i9++;
            }
            if (i10 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    j1 j1Var2 = n0Var.l[((Integer) arrayList.get(size)).intValue()];
                    int i16 = j1Var2.B;
                    int i17 = (i16 == -1 || (i3 = j1Var2.C) == -1) ? -1 : i16 * i3;
                    if (i17 == -1 || i17 > i10) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean e(int i, boolean z2) {
        int i2 = i & 7;
        return i2 == 4 || (z2 && i2 == 3);
    }

    public static boolean f(j1 j1Var, @Nullable String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if ((j1Var.p & 16384) != 0 || !e(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !e0.a(j1Var.w, str)) {
            return false;
        }
        int i12 = j1Var.B;
        if (i12 != -1 && (i7 > i12 || i12 > i3)) {
            return false;
        }
        int i13 = j1Var.C;
        if (i13 != -1 && (i8 > i13 || i13 > i4)) {
            return false;
        }
        float f2 = j1Var.D;
        return (f2 == -1.0f || (((float) i9) <= f2 && f2 <= ((float) i5))) && (i11 = j1Var.f1017s) != -1 && i10 <= i11 && i11 <= i6;
    }

    @Nullable
    public static String g(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* compiled from: DefaultTrackSelector.java */
    public static final class e extends p.a {
        public boolean A;
        public boolean B;
        public boolean C;
        public boolean D;
        public boolean E;
        public int F;
        public boolean G;
        public boolean H;
        public boolean I;
        public final SparseArray<Map<o0, f>> J;
        public final SparseBooleanArray K;

        /* renamed from: y, reason: collision with root package name */
        public boolean f900y;

        /* renamed from: z, reason: collision with root package name */
        public boolean f901z;

        public e(Context context) {
            a(context);
            c(context, true);
            this.J = new SparseArray<>();
            this.K = new SparseBooleanArray();
            e();
        }

        @Override // b.i.a.c.c3.p.a
        public p.a a(Context context) {
            super.a(context);
            return this;
        }

        @Override // b.i.a.c.c3.p.a
        public p.a b(int i, int i2, boolean z2) {
            this.i = i;
            this.j = i2;
            this.k = z2;
            return this;
        }

        @Override // b.i.a.c.c3.p.a
        public p.a c(Context context, boolean z2) {
            super.c(context, z2);
            return this;
        }

        public d d() {
            return new d(this, null);
        }

        public final void e() {
            this.f900y = true;
            this.f901z = false;
            this.A = true;
            this.B = true;
            this.C = false;
            this.D = false;
            this.E = false;
            this.F = 0;
            this.G = true;
            this.H = false;
            this.I = true;
        }

        @Deprecated
        public e() {
            this.J = new SparseArray<>();
            this.K = new SparseBooleanArray();
            e();
        }
    }
}
