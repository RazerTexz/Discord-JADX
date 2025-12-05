package p007b.p225i.p226a.p242c.p255c3;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p243a3.TrackGroup;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p255c3.AdaptiveTrackSelection;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionParameters;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p355b.p357b.ComparisonChain;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.NaturalOrdering;
import p007b.p225i.p355b.p357b.Ordering;
import p007b.p225i.p355b.p357b.ReverseNaturalOrdering;

/* compiled from: DefaultTrackSelector.java */
/* renamed from: b.i.a.c.c3.h, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultTrackSelector extends MappingTrackSelector {

    /* renamed from: b */
    public static final int[] f6192b = new int[0];

    /* renamed from: c */
    public static final Ordering<Integer> f6193c = Ordering.m6237a(C2637c.f6179j);

    /* renamed from: d */
    public static final Ordering<Integer> f6194d = Ordering.m6237a(C2636b.f6178j);

    /* renamed from: e */
    public final ExoTrackSelection2.b f6195e;

    /* renamed from: f */
    public final AtomicReference<d> f6196f;

    /* compiled from: DefaultTrackSelector.java */
    /* renamed from: b.i.a.c.c3.h$b */
    public static final class b implements Comparable<b> {

        /* renamed from: j */
        public final boolean f6197j;

        /* renamed from: k */
        @Nullable
        public final String f6198k;

        /* renamed from: l */
        public final d f6199l;

        /* renamed from: m */
        public final boolean f6200m;

        /* renamed from: n */
        public final int f6201n;

        /* renamed from: o */
        public final int f6202o;

        /* renamed from: p */
        public final int f6203p;

        /* renamed from: q */
        public final int f6204q;

        /* renamed from: r */
        public final int f6205r;

        /* renamed from: s */
        public final boolean f6206s;

        /* renamed from: t */
        public final int f6207t;

        /* renamed from: u */
        public final int f6208u;

        /* renamed from: v */
        public final int f6209v;

        /* renamed from: w */
        public final int f6210w;

        public b(Format2 format2, d dVar, int i) {
            int i2;
            int iM2735c;
            String[] strArrM2987H;
            int iM2735c2;
            this.f6199l = dVar;
            this.f6198k = DefaultTrackSelector.m2739g(format2.f7146n);
            int i3 = 0;
            this.f6200m = DefaultTrackSelector.m2737e(i, false);
            int i4 = 0;
            while (true) {
                i2 = Integer.MAX_VALUE;
                if (i4 >= dVar.f6297w.size()) {
                    i4 = Integer.MAX_VALUE;
                    iM2735c = 0;
                    break;
                } else {
                    iM2735c = DefaultTrackSelector.m2735c(format2, dVar.f6297w.get(i4), false);
                    if (iM2735c > 0) {
                        break;
                    } else {
                        i4++;
                    }
                }
            }
            this.f6202o = i4;
            this.f6201n = iM2735c;
            this.f6203p = Integer.bitCount(format2.f7148p & dVar.f6298x);
            this.f6206s = (format2.f7147o & 1) != 0;
            int i5 = format2.f7136J;
            this.f6207t = i5;
            this.f6208u = format2.f7137K;
            int i6 = format2.f7151s;
            this.f6209v = i6;
            this.f6197j = (i6 == -1 || i6 <= dVar.f6300z) && (i5 == -1 || i5 <= dVar.f6299y);
            int i7 = Util2.f6708a;
            Configuration configuration = Resources.getSystem().getConfiguration();
            int i8 = Util2.f6708a;
            if (i8 >= 24) {
                strArrM2987H = Util2.m2987H(configuration.getLocales().toLanguageTags(), ",");
            } else {
                String[] strArr = new String[1];
                Locale locale = configuration.locale;
                strArr[0] = i8 >= 21 ? locale.toLanguageTag() : locale.toString();
                strArrM2987H = strArr;
            }
            for (int i9 = 0; i9 < strArrM2987H.length; i9++) {
                strArrM2987H[i9] = Util2.m2982C(strArrM2987H[i9]);
            }
            int i10 = 0;
            while (true) {
                if (i10 >= strArrM2987H.length) {
                    i10 = Integer.MAX_VALUE;
                    iM2735c2 = 0;
                    break;
                } else {
                    iM2735c2 = DefaultTrackSelector.m2735c(format2, strArrM2987H[i10], false);
                    if (iM2735c2 > 0) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            this.f6204q = i10;
            this.f6205r = iM2735c2;
            while (true) {
                if (i3 >= dVar.f6277A.size()) {
                    break;
                }
                String str = format2.f7155w;
                if (str != null && str.equals(dVar.f6277A.get(i3))) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            this.f6210w = i2;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(b bVar) {
            return m2740f(bVar);
        }

        /* renamed from: f */
        public int m2740f(b bVar) {
            Object objMo6236b = (this.f6197j && this.f6200m) ? DefaultTrackSelector.f6193c : DefaultTrackSelector.f6193c.mo6236b();
            ComparisonChain comparisonChainMo6256c = ComparisonChain.f12028a.mo6256c(this.f6200m, bVar.f6200m);
            Integer numValueOf = Integer.valueOf(this.f6202o);
            Integer numValueOf2 = Integer.valueOf(bVar.f6202o);
            ReverseNaturalOrdering reverseNaturalOrdering = ReverseNaturalOrdering.f12038j;
            ComparisonChain comparisonChainMo6255b = comparisonChainMo6256c.mo6255b(numValueOf, numValueOf2, reverseNaturalOrdering).mo6254a(this.f6201n, bVar.f6201n).mo6254a(this.f6203p, bVar.f6203p).mo6256c(this.f6197j, bVar.f6197j).mo6255b(Integer.valueOf(this.f6210w), Integer.valueOf(bVar.f6210w), reverseNaturalOrdering).mo6255b(Integer.valueOf(this.f6209v), Integer.valueOf(bVar.f6209v), this.f6199l.f6281E ? DefaultTrackSelector.f6193c.mo6236b() : DefaultTrackSelector.f6194d).mo6256c(this.f6206s, bVar.f6206s).mo6255b(Integer.valueOf(this.f6204q), Integer.valueOf(bVar.f6204q), reverseNaturalOrdering).mo6254a(this.f6205r, bVar.f6205r).mo6255b(Integer.valueOf(this.f6207t), Integer.valueOf(bVar.f6207t), objMo6236b).mo6255b(Integer.valueOf(this.f6208u), Integer.valueOf(bVar.f6208u), objMo6236b);
            Integer numValueOf3 = Integer.valueOf(this.f6209v);
            Integer numValueOf4 = Integer.valueOf(bVar.f6209v);
            if (!Util2.m2993a(this.f6198k, bVar.f6198k)) {
                objMo6236b = DefaultTrackSelector.f6194d;
            }
            return comparisonChainMo6255b.mo6255b(numValueOf3, numValueOf4, objMo6236b).mo6258e();
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    /* renamed from: b.i.a.c.c3.h$c */
    public static final class c implements Comparable<c> {

        /* renamed from: j */
        public final boolean f6211j;

        /* renamed from: k */
        public final boolean f6212k;

        public c(Format2 format2, int i) {
            this.f6211j = (format2.f7147o & 1) != 0;
            this.f6212k = DefaultTrackSelector.m2737e(i, false);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(c cVar) {
            return m2741f(cVar);
        }

        /* renamed from: f */
        public int m2741f(c cVar) {
            return ComparisonChain.f12028a.mo6256c(this.f6212k, cVar.f6212k).mo6256c(this.f6211j, cVar.f6211j).mo6258e();
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    /* renamed from: b.i.a.c.c3.h$d */
    public static final class d extends TrackSelectionParameters implements Bundleable {

        /* renamed from: I */
        public static final d f6213I = new e().m2745d();

        /* renamed from: J */
        public final int f6214J;

        /* renamed from: K */
        public final boolean f6215K;

        /* renamed from: L */
        public final boolean f6216L;

        /* renamed from: M */
        public final boolean f6217M;

        /* renamed from: N */
        public final boolean f6218N;

        /* renamed from: O */
        public final boolean f6219O;

        /* renamed from: P */
        public final boolean f6220P;

        /* renamed from: Q */
        public final boolean f6221Q;

        /* renamed from: R */
        public final boolean f6222R;

        /* renamed from: S */
        public final boolean f6223S;

        /* renamed from: T */
        public final boolean f6224T;

        /* renamed from: U */
        public final SparseArray<Map<TrackGroupArray, f>> f6225U;

        /* renamed from: V */
        public final SparseBooleanArray f6226V;

        public d(e eVar, a aVar) {
            super(eVar);
            this.f6215K = eVar.f6238y;
            this.f6216L = eVar.f6239z;
            this.f6217M = eVar.f6227A;
            this.f6218N = eVar.f6228B;
            this.f6219O = eVar.f6229C;
            this.f6220P = eVar.f6230D;
            this.f6221Q = eVar.f6231E;
            this.f6214J = eVar.f6232F;
            this.f6222R = eVar.f6233G;
            this.f6223S = eVar.f6234H;
            this.f6224T = eVar.f6235I;
            this.f6225U = eVar.f6236J;
            this.f6226V = eVar.f6237K;
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00e7 A[LOOP:0: B:49:0x0090->B:66:0x00e7, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x008d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
        @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelectionParameters
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
            if (super.equals(dVar) && this.f6215K == dVar.f6215K && this.f6216L == dVar.f6216L && this.f6217M == dVar.f6217M && this.f6218N == dVar.f6218N && this.f6219O == dVar.f6219O && this.f6220P == dVar.f6220P && this.f6221Q == dVar.f6221Q && this.f6214J == dVar.f6214J && this.f6222R == dVar.f6222R && this.f6223S == dVar.f6223S && this.f6224T == dVar.f6224T) {
                SparseBooleanArray sparseBooleanArray = this.f6226V;
                SparseBooleanArray sparseBooleanArray2 = dVar.f6226V;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() != size) {
                    z2 = false;
                    if (z2) {
                        SparseArray<Map<TrackGroupArray, f>> sparseArray = this.f6225U;
                        SparseArray<Map<TrackGroupArray, f>> sparseArray2 = dVar.f6225U;
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
                                    Map<TrackGroupArray, f> mapValueAt = sparseArray.valueAt(i);
                                    Map<TrackGroupArray, f> mapValueAt2 = sparseArray2.valueAt(iIndexOfKey);
                                    if (mapValueAt2.size() != mapValueAt.size()) {
                                        z4 = false;
                                        if (!z4) {
                                        }
                                    } else {
                                        for (Map.Entry<TrackGroupArray, f> entry : mapValueAt.entrySet()) {
                                            TrackGroupArray key = entry.getKey();
                                            if (!mapValueAt2.containsKey(key) || !Util2.m2993a(entry.getValue(), mapValueAt2.get(key))) {
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

        @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelectionParameters
        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.f6215K ? 1 : 0)) * 31) + (this.f6216L ? 1 : 0)) * 31) + (this.f6217M ? 1 : 0)) * 31) + (this.f6218N ? 1 : 0)) * 31) + (this.f6219O ? 1 : 0)) * 31) + (this.f6220P ? 1 : 0)) * 31) + (this.f6221Q ? 1 : 0)) * 31) + this.f6214J) * 31) + (this.f6222R ? 1 : 0)) * 31) + (this.f6223S ? 1 : 0)) * 31) + (this.f6224T ? 1 : 0);
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    /* renamed from: b.i.a.c.c3.h$f */
    public static final class f implements Bundleable {

        /* renamed from: j */
        public final int f6240j;

        /* renamed from: k */
        public final int[] f6241k;

        /* renamed from: l */
        public final int f6242l;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f6240j == fVar.f6240j && Arrays.equals(this.f6241k, fVar.f6241k) && this.f6242l == fVar.f6242l;
        }

        public int hashCode() {
            return ((Arrays.hashCode(this.f6241k) + (this.f6240j * 31)) * 31) + this.f6242l;
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    /* renamed from: b.i.a.c.c3.h$g */
    public static final class g implements Comparable<g> {

        /* renamed from: j */
        public final boolean f6243j;

        /* renamed from: k */
        public final boolean f6244k;

        /* renamed from: l */
        public final boolean f6245l;

        /* renamed from: m */
        public final boolean f6246m;

        /* renamed from: n */
        public final int f6247n;

        /* renamed from: o */
        public final int f6248o;

        /* renamed from: p */
        public final int f6249p;

        /* renamed from: q */
        public final int f6250q;

        /* renamed from: r */
        public final boolean f6251r;

        public g(Format2 format2, d dVar, int i, @Nullable String str) {
            int iM2735c;
            boolean z2 = false;
            this.f6244k = DefaultTrackSelector.m2737e(i, false);
            int i2 = format2.f7147o & (~dVar.f6214J);
            this.f6245l = (i2 & 1) != 0;
            this.f6246m = (i2 & 2) != 0;
            int i3 = Integer.MAX_VALUE;
            ImmutableList2<String> immutableList2M6266u = dVar.f6278B.isEmpty() ? ImmutableList2.m6266u("") : dVar.f6278B;
            int i4 = 0;
            while (true) {
                if (i4 >= immutableList2M6266u.size()) {
                    iM2735c = 0;
                    break;
                }
                iM2735c = DefaultTrackSelector.m2735c(format2, immutableList2M6266u.get(i4), dVar.f6280D);
                if (iM2735c > 0) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
            this.f6247n = i3;
            this.f6248o = iM2735c;
            int iBitCount = Integer.bitCount(format2.f7148p & dVar.f6279C);
            this.f6249p = iBitCount;
            this.f6251r = (format2.f7148p & 1088) != 0;
            int iM2735c2 = DefaultTrackSelector.m2735c(format2, str, DefaultTrackSelector.m2739g(str) == null);
            this.f6250q = iM2735c2;
            if (iM2735c > 0 || ((dVar.f6278B.isEmpty() && iBitCount > 0) || this.f6245l || (this.f6246m && iM2735c2 > 0))) {
                z2 = true;
            }
            this.f6243j = z2;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(g gVar) {
            return m2747f(gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [b.i.b.b.k0, java.util.Comparator] */
        /* renamed from: f */
        public int m2747f(g gVar) {
            ComparisonChain comparisonChainMo6256c = ComparisonChain.f12028a.mo6256c(this.f6244k, gVar.f6244k);
            Integer numValueOf = Integer.valueOf(this.f6247n);
            Integer numValueOf2 = Integer.valueOf(gVar.f6247n);
            NaturalOrdering naturalOrdering = NaturalOrdering.f12005j;
            ?? r4 = ReverseNaturalOrdering.f12038j;
            ComparisonChain comparisonChainMo6256c2 = comparisonChainMo6256c.mo6255b(numValueOf, numValueOf2, r4).mo6254a(this.f6248o, gVar.f6248o).mo6254a(this.f6249p, gVar.f6249p).mo6256c(this.f6245l, gVar.f6245l);
            Boolean boolValueOf = Boolean.valueOf(this.f6246m);
            Boolean boolValueOf2 = Boolean.valueOf(gVar.f6246m);
            if (this.f6248o != 0) {
                naturalOrdering = r4;
            }
            ComparisonChain comparisonChainMo6254a = comparisonChainMo6256c2.mo6255b(boolValueOf, boolValueOf2, naturalOrdering).mo6254a(this.f6250q, gVar.f6250q);
            if (this.f6249p == 0) {
                comparisonChainMo6254a = comparisonChainMo6254a.mo6257d(this.f6251r, gVar.f6251r);
            }
            return comparisonChainMo6254a.mo6258e();
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    /* renamed from: b.i.a.c.c3.h$h */
    public static final class h implements Comparable<h> {

        /* renamed from: j */
        public final boolean f6252j;

        /* renamed from: k */
        public final d f6253k;

        /* renamed from: l */
        public final boolean f6254l;

        /* renamed from: m */
        public final boolean f6255m;

        /* renamed from: n */
        public final int f6256n;

        /* renamed from: o */
        public final int f6257o;

        /* renamed from: p */
        public final int f6258p;

        /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x005e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public h(Format2 format2, d dVar, int i, boolean z2) {
            boolean z3;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            this.f6253k = dVar;
            int i9 = 0;
            boolean z4 = true;
            int i10 = -1;
            if (!z2 || (((i6 = format2.f7128B) != -1 && i6 > dVar.f6285k) || ((i7 = format2.f7129C) != -1 && i7 > dVar.f6286l))) {
                z3 = false;
            } else {
                float f = format2.f7130D;
                if ((f == -1.0f || f <= dVar.f6287m) && ((i8 = format2.f7151s) == -1 || i8 <= dVar.f6288n)) {
                    z3 = true;
                }
            }
            this.f6252j = z3;
            if (!z2 || (((i3 = format2.f7128B) != -1 && i3 < dVar.f6289o) || ((i4 = format2.f7129C) != -1 && i4 < dVar.f6290p))) {
                z4 = false;
            } else {
                float f2 = format2.f7130D;
                if ((f2 != -1.0f && f2 < dVar.f6291q) || ((i5 = format2.f7151s) != -1 && i5 < dVar.f6292r)) {
                }
            }
            this.f6254l = z4;
            this.f6255m = DefaultTrackSelector.m2737e(i, false);
            this.f6256n = format2.f7151s;
            int i11 = format2.f7128B;
            if (i11 != -1 && (i2 = format2.f7129C) != -1) {
                i10 = i11 * i2;
            }
            this.f6257o = i10;
            int i12 = Integer.MAX_VALUE;
            while (true) {
                if (i9 < dVar.f6296v.size()) {
                    String str = format2.f7155w;
                    if (str != null && str.equals(dVar.f6296v.get(i9))) {
                        i12 = i9;
                        break;
                    }
                    i9++;
                } else {
                    break;
                }
            }
            this.f6258p = i12;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(h hVar) {
            return m2748f(hVar);
        }

        /* renamed from: f */
        public int m2748f(h hVar) {
            Object objMo6236b = (this.f6252j && this.f6255m) ? DefaultTrackSelector.f6193c : DefaultTrackSelector.f6193c.mo6236b();
            return ComparisonChain.f12028a.mo6256c(this.f6255m, hVar.f6255m).mo6256c(this.f6252j, hVar.f6252j).mo6256c(this.f6254l, hVar.f6254l).mo6255b(Integer.valueOf(this.f6258p), Integer.valueOf(hVar.f6258p), ReverseNaturalOrdering.f12038j).mo6255b(Integer.valueOf(this.f6256n), Integer.valueOf(hVar.f6256n), this.f6253k.f6281E ? DefaultTrackSelector.f6193c.mo6236b() : DefaultTrackSelector.f6194d).mo6255b(Integer.valueOf(this.f6257o), Integer.valueOf(hVar.f6257o), objMo6236b).mo6255b(Integer.valueOf(this.f6256n), Integer.valueOf(hVar.f6256n), objMo6236b).mo6258e();
        }
    }

    public DefaultTrackSelector(Context context) {
        AdaptiveTrackSelection.b bVar = new AdaptiveTrackSelection.b();
        d dVar = d.f6213I;
        d dVarM2745d = new e(context).m2745d();
        this.f6195e = bVar;
        this.f6196f = new AtomicReference<>(dVarM2745d);
    }

    /* renamed from: c */
    public static int m2735c(Format2 format2, @Nullable String str, boolean z2) {
        if (!TextUtils.isEmpty(str) && str.equals(format2.f7146n)) {
            return 4;
        }
        String strM2739g = m2739g(str);
        String strM2739g2 = m2739g(format2.f7146n);
        if (strM2739g2 == null || strM2739g == null) {
            return (z2 && strM2739g2 == null) ? 1 : 0;
        }
        if (strM2739g2.startsWith(strM2739g) || strM2739g.startsWith(strM2739g2)) {
            return 3;
        }
        int i = Util2.f6708a;
        return strM2739g2.split("-", 2)[0].equals(strM2739g.split("-", 2)[0]) ? 2 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<Integer> m2736d(TrackGroup trackGroup, int i, int i2, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        Point point;
        int i7;
        ArrayList arrayList = new ArrayList(trackGroup.f5661k);
        for (int i8 = 0; i8 < trackGroup.f5661k; i8++) {
            arrayList.add(Integer.valueOf(i8));
        }
        if (i != Integer.MAX_VALUE && i2 != Integer.MAX_VALUE) {
            int i9 = 0;
            int i10 = Integer.MAX_VALUE;
            while (true) {
                if (i9 >= trackGroup.f5661k) {
                    break;
                }
                Format2 format2 = trackGroup.f5662l[i9];
                int i11 = format2.f7128B;
                if (i11 > 0 && (i4 = format2.f7129C) > 0) {
                    if (z2) {
                        if ((i11 > i4) != (i > i2)) {
                            i6 = i;
                            i5 = i2;
                        }
                        int i12 = i11 * i6;
                        int i13 = i4 * i5;
                        if (i12 < i13) {
                        }
                        i7 = format2.f7128B;
                        int i14 = format2.f7129C;
                        int i15 = i7 * i14;
                        if (i7 < ((int) (point.x * 0.98f))) {
                        }
                    } else {
                        i5 = i;
                        i6 = i2;
                        int i122 = i11 * i6;
                        int i132 = i4 * i5;
                        point = i122 < i132 ? new Point(i5, Util2.m2998f(i132, i11)) : new Point(Util2.m2998f(i122, i4), i6);
                        i7 = format2.f7128B;
                        int i142 = format2.f7129C;
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
                    Format2 format22 = trackGroup.f5662l[((Integer) arrayList.get(size)).intValue()];
                    int i16 = format22.f7128B;
                    int i17 = (i16 == -1 || (i3 = format22.f7129C) == -1) ? -1 : i16 * i3;
                    if (i17 == -1 || i17 > i10) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static boolean m2737e(int i, boolean z2) {
        int i2 = i & 7;
        return i2 == 4 || (z2 && i2 == 3);
    }

    /* renamed from: f */
    public static boolean m2738f(Format2 format2, @Nullable String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if ((format2.f7148p & 16384) != 0 || !m2737e(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !Util2.m2993a(format2.f7155w, str)) {
            return false;
        }
        int i12 = format2.f7128B;
        if (i12 != -1 && (i7 > i12 || i12 > i3)) {
            return false;
        }
        int i13 = format2.f7129C;
        if (i13 != -1 && (i8 > i13 || i13 > i4)) {
            return false;
        }
        float f2 = format2.f7130D;
        return (f2 == -1.0f || (((float) i9) <= f2 && f2 <= ((float) i5))) && (i11 = format2.f7151s) != -1 && i10 <= i11 && i11 <= i6;
    }

    @Nullable
    /* renamed from: g */
    public static String m2739g(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* compiled from: DefaultTrackSelector.java */
    /* renamed from: b.i.a.c.c3.h$e */
    public static final class e extends TrackSelectionParameters.a {

        /* renamed from: A */
        public boolean f6227A;

        /* renamed from: B */
        public boolean f6228B;

        /* renamed from: C */
        public boolean f6229C;

        /* renamed from: D */
        public boolean f6230D;

        /* renamed from: E */
        public boolean f6231E;

        /* renamed from: F */
        public int f6232F;

        /* renamed from: G */
        public boolean f6233G;

        /* renamed from: H */
        public boolean f6234H;

        /* renamed from: I */
        public boolean f6235I;

        /* renamed from: J */
        public final SparseArray<Map<TrackGroupArray, f>> f6236J;

        /* renamed from: K */
        public final SparseBooleanArray f6237K;

        /* renamed from: y */
        public boolean f6238y;

        /* renamed from: z */
        public boolean f6239z;

        public e(Context context) {
            mo2742a(context);
            mo2744c(context, true);
            this.f6236J = new SparseArray<>();
            this.f6237K = new SparseBooleanArray();
            m2746e();
        }

        @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelectionParameters.a
        /* renamed from: a */
        public TrackSelectionParameters.a mo2742a(Context context) {
            super.mo2742a(context);
            return this;
        }

        @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelectionParameters.a
        /* renamed from: b */
        public TrackSelectionParameters.a mo2743b(int i, int i2, boolean z2) {
            this.f6309i = i;
            this.f6310j = i2;
            this.f6311k = z2;
            return this;
        }

        @Override // p007b.p225i.p226a.p242c.p255c3.TrackSelectionParameters.a
        /* renamed from: c */
        public TrackSelectionParameters.a mo2744c(Context context, boolean z2) {
            super.mo2744c(context, z2);
            return this;
        }

        /* renamed from: d */
        public d m2745d() {
            return new d(this, null);
        }

        /* renamed from: e */
        public final void m2746e() {
            this.f6238y = true;
            this.f6239z = false;
            this.f6227A = true;
            this.f6228B = true;
            this.f6229C = false;
            this.f6230D = false;
            this.f6231E = false;
            this.f6232F = 0;
            this.f6233G = true;
            this.f6234H = false;
            this.f6235I = true;
        }

        @Deprecated
        public e() {
            this.f6236J = new SparseArray<>();
            this.f6237K = new SparseBooleanArray();
            m2746e();
        }
    }
}
