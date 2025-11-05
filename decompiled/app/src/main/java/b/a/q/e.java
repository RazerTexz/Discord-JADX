package b.a.q;

import com.discord.rtcconnection.EncodeQuality;
import d0.t.n0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MediaSinkWantsLadder.kt */
/* loaded from: classes.dex */
public final class e {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    public final int f257b;
    public final Map<EncodeQuality, n> c;
    public final List<c> d;
    public final j0 e;

    /* compiled from: MediaSinkWantsLadder.kt */
    public static final class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f258b;
        public final double c;
        public final int d;

        public a(int i, int i2, double d, int i3) {
            this.a = i;
            this.f258b = i2;
            this.c = d;
            this.d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.f258b == aVar.f258b && Double.compare(this.c, aVar.c) == 0 && this.d == aVar.d;
        }

        public int hashCode() {
            return ((a0.a.a.a.a(this.c) + (((this.a * 31) + this.f258b) * 31)) * 31) + this.d;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("CandidateResolution(width=");
            sbU.append(this.a);
            sbU.append(", height=");
            sbU.append(this.f258b);
            sbU.append(", budgetPortion=");
            sbU.append(this.c);
            sbU.append(", pixelCount=");
            return b.d.b.a.a.B(sbU, this.d, ")");
        }
    }

    /* compiled from: MediaSinkWantsLadder.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: MediaSinkWantsLadder.kt */
    public static final class c {
        public final n a;

        /* renamed from: b, reason: collision with root package name */
        public final int f259b;
        public final EncodeQuality c;

        public c(n nVar, int i, EncodeQuality encodeQuality) {
            d0.z.d.m.checkNotNullParameter(nVar, "budget");
            d0.z.d.m.checkNotNullParameter(encodeQuality, "wantValue");
            this.a = nVar;
            this.f259b = i;
            this.c = encodeQuality;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return d0.z.d.m.areEqual(this.a, cVar.a) && this.f259b == cVar.f259b && d0.z.d.m.areEqual(this.c, cVar.c);
        }

        public int hashCode() {
            n nVar = this.a;
            int iHashCode = (((nVar != null ? nVar.hashCode() : 0) * 31) + this.f259b) * 31;
            EncodeQuality encodeQuality = this.c;
            return iHashCode + (encodeQuality != null ? encodeQuality.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("OrderedLadder(budget=");
            sbU.append(this.a);
            sbU.append(", pixelCount=");
            sbU.append(this.f259b);
            sbU.append(", wantValue=");
            sbU.append(this.c);
            sbU.append(")");
            return sbU.toString();
        }
    }

    public e(j0 j0Var, int i) {
        n nVar;
        Object objPrevious;
        int i2;
        EncodeQuality encodeQuality;
        j0 j0Var2 = (i & 1) != 0 ? f.a : null;
        d0.z.d.m.checkNotNullParameter(j0Var2, "options");
        this.e = j0Var2;
        b.a.q.b bVar = j0Var2.a;
        int i3 = bVar.a * bVar.f256b;
        this.f257b = i3;
        Set of = n0.setOf((Object[]) new Double[]{Double.valueOf(0.0d), Double.valueOf(4.0d), Double.valueOf(8.0d), Double.valueOf(10.0d)});
        ArrayList arrayList = new ArrayList();
        for (int i4 = 1; i4 < 4096; i4++) {
            double d = i4;
            double d2 = (d * 16.0d) / 9.0d;
            if (of.contains(Double.valueOf(d2 % 16.0d)) && of.contains(Double.valueOf(d % 16.0d))) {
                double d3 = d * d2;
                arrayList.add(new a((int) d2, i4, d3 / i3, (int) d3));
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        EncodeQuality encodeQuality2 = EncodeQuality.Hundred;
        int i5 = 1;
        int i6 = 0;
        while (i5 <= 25) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    objPrevious = listIterator.previous();
                    if (((a) objPrevious).d * i5 <= i3) {
                        break;
                    }
                } else {
                    objPrevious = null;
                    break;
                }
            }
            a aVar = (a) objPrevious;
            aVar = aVar == null ? (a) d0.t.u.first((List) arrayList) : aVar;
            if (i6 != aVar.a) {
                i2 = i3;
                linkedHashMap.put(encodeQuality2, new n(aVar.a, aVar.f258b, aVar.c, encodeQuality2.compareTo(EncodeQuality.Twenty) <= 0 ? 12 : 20, 30));
                EncodeQuality[] encodeQualityArrValues = EncodeQuality.values();
                int i7 = 10;
                while (true) {
                    if (i7 < 0) {
                        encodeQuality = null;
                        break;
                    }
                    encodeQuality = encodeQualityArrValues[i7];
                    if (encodeQuality.getValue() < encodeQuality2.getValue()) {
                        break;
                    } else {
                        i7--;
                    }
                }
                encodeQuality2 = encodeQuality == null ? EncodeQuality.Zero : encodeQuality;
                i6 = aVar.a;
            } else {
                i2 = i3;
            }
            i5++;
            i3 = i2;
        }
        this.c = linkedHashMap;
        EncodeQuality[] encodeQualityArrValues2 = EncodeQuality.values();
        ArrayList arrayList2 = new ArrayList(11);
        for (int i8 = 0; i8 < 11; i8++) {
            EncodeQuality encodeQuality3 = encodeQualityArrValues2[i8];
            arrayList2.add((encodeQuality3 == EncodeQuality.Zero || (nVar = (n) linkedHashMap.get(encodeQuality3)) == null) ? null : new c(nVar, nVar.f274b * nVar.a, encodeQuality3));
        }
        this.d = d0.t.u.filterNotNull(arrayList2);
    }
}
