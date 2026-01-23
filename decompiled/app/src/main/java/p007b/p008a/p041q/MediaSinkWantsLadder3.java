package p007b.p008a.p041q;

import com.discord.rtcconnection.MediaSinkWantsManager9;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0001a;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.e, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsLadder3 {

    /* JADX INFO: renamed from: a */
    public static final b f1613a = new b(null);

    /* JADX INFO: renamed from: b */
    public final int f1614b;

    /* JADX INFO: renamed from: c */
    public final Map<MediaSinkWantsManager9, MediaSinkWantsLadder6> f1615c;

    /* JADX INFO: renamed from: d */
    public final List<c> f1616d;

    /* JADX INFO: renamed from: e */
    public final MediaSinkWantsLadder5 f1617e;

    /* JADX INFO: renamed from: b.a.q.e$a */
    /* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f1618a;

        /* JADX INFO: renamed from: b */
        public final int f1619b;

        /* JADX INFO: renamed from: c */
        public final double f1620c;

        /* JADX INFO: renamed from: d */
        public final int f1621d;

        public a(int i, int i2, double d, int i3) {
            this.f1618a = i;
            this.f1619b = i2;
            this.f1620c = d;
            this.f1621d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f1618a == aVar.f1618a && this.f1619b == aVar.f1619b && Double.compare(this.f1620c, aVar.f1620c) == 0 && this.f1621d == aVar.f1621d;
        }

        public int hashCode() {
            return ((C0001a.m2a(this.f1620c) + (((this.f1618a * 31) + this.f1619b) * 31)) * 31) + this.f1621d;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("CandidateResolution(width=");
            sbM833U.append(this.f1618a);
            sbM833U.append(", height=");
            sbM833U.append(this.f1619b);
            sbM833U.append(", budgetPortion=");
            sbM833U.append(this.f1620c);
            sbM833U.append(", pixelCount=");
            return outline.m814B(sbM833U, this.f1621d, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.q.e$b */
    /* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.q.e$c */
    /* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final MediaSinkWantsLadder6 f1622a;

        /* JADX INFO: renamed from: b */
        public final int f1623b;

        /* JADX INFO: renamed from: c */
        public final MediaSinkWantsManager9 f1624c;

        public c(MediaSinkWantsLadder6 mediaSinkWantsLadder6, int i, MediaSinkWantsManager9 mediaSinkWantsManager9) {
            Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder6, "budget");
            Intrinsics3.checkNotNullParameter(mediaSinkWantsManager9, "wantValue");
            this.f1622a = mediaSinkWantsLadder6;
            this.f1623b = i;
            this.f1624c = mediaSinkWantsManager9;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics3.areEqual(this.f1622a, cVar.f1622a) && this.f1623b == cVar.f1623b && Intrinsics3.areEqual(this.f1624c, cVar.f1624c);
        }

        public int hashCode() {
            MediaSinkWantsLadder6 mediaSinkWantsLadder6 = this.f1622a;
            int iHashCode = (((mediaSinkWantsLadder6 != null ? mediaSinkWantsLadder6.hashCode() : 0) * 31) + this.f1623b) * 31;
            MediaSinkWantsManager9 mediaSinkWantsManager9 = this.f1624c;
            return iHashCode + (mediaSinkWantsManager9 != null ? mediaSinkWantsManager9.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("OrderedLadder(budget=");
            sbM833U.append(this.f1622a);
            sbM833U.append(", pixelCount=");
            sbM833U.append(this.f1623b);
            sbM833U.append(", wantValue=");
            sbM833U.append(this.f1624c);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    public MediaSinkWantsLadder3(MediaSinkWantsLadder5 mediaSinkWantsLadder5, int i) {
        MediaSinkWantsLadder6 mediaSinkWantsLadder6;
        Object objPrevious;
        int i2;
        MediaSinkWantsManager9 mediaSinkWantsManager9;
        MediaSinkWantsLadder5 mediaSinkWantsLadder52 = (i & 1) != 0 ? MediaSinkWantsLadder4.f1625a : null;
        Intrinsics3.checkNotNullParameter(mediaSinkWantsLadder52, "options");
        this.f1617e = mediaSinkWantsLadder52;
        MediaSinkWantsLadder2 mediaSinkWantsLadder2 = mediaSinkWantsLadder52.f1635a;
        int i3 = mediaSinkWantsLadder2.f1602a * mediaSinkWantsLadder2.f1603b;
        this.f1614b = i3;
        Set of = Sets5.setOf((Object[]) new Double[]{Double.valueOf(0.0d), Double.valueOf(4.0d), Double.valueOf(8.0d), Double.valueOf(10.0d)});
        ArrayList arrayList = new ArrayList();
        for (int i4 = 1; i4 < 4096; i4++) {
            double d = i4;
            double d2 = (d * 16.0d) / 9.0d;
            if (of.contains(Double.valueOf(d2 % 16.0d)) && of.contains(Double.valueOf(d % 16.0d))) {
                double d3 = d * d2;
                arrayList.add(new a((int) d2, i4, d3 / ((double) i3), (int) d3));
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        MediaSinkWantsManager9 mediaSinkWantsManager92 = MediaSinkWantsManager9.Hundred;
        int i5 = 1;
        int i6 = 0;
        while (i5 <= 25) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    objPrevious = listIterator.previous();
                    if (((a) objPrevious).f1621d * i5 <= i3) {
                        break;
                    }
                } else {
                    objPrevious = null;
                    break;
                }
            }
            a aVar = (a) objPrevious;
            aVar = aVar == null ? (a) _Collections.first((List) arrayList) : aVar;
            if (i6 != aVar.f1618a) {
                i2 = i3;
                linkedHashMap.put(mediaSinkWantsManager92, new MediaSinkWantsLadder6(aVar.f1618a, aVar.f1619b, aVar.f1620c, mediaSinkWantsManager92.compareTo(MediaSinkWantsManager9.Twenty) <= 0 ? 12 : 20, 30));
                MediaSinkWantsManager9[] mediaSinkWantsManager9ArrValues = MediaSinkWantsManager9.values();
                int i7 = 10;
                while (true) {
                    if (i7 < 0) {
                        mediaSinkWantsManager9 = null;
                        break;
                    }
                    mediaSinkWantsManager9 = mediaSinkWantsManager9ArrValues[i7];
                    if (mediaSinkWantsManager9.getValue() < mediaSinkWantsManager92.getValue()) {
                        break;
                    } else {
                        i7--;
                    }
                }
                mediaSinkWantsManager92 = mediaSinkWantsManager9 == null ? MediaSinkWantsManager9.Zero : mediaSinkWantsManager9;
                i6 = aVar.f1618a;
            } else {
                i2 = i3;
            }
            i5++;
            i3 = i2;
        }
        this.f1615c = linkedHashMap;
        MediaSinkWantsManager9[] mediaSinkWantsManager9ArrValues2 = MediaSinkWantsManager9.values();
        ArrayList arrayList2 = new ArrayList(11);
        for (int i8 = 0; i8 < 11; i8++) {
            MediaSinkWantsManager9 mediaSinkWantsManager93 = mediaSinkWantsManager9ArrValues2[i8];
            arrayList2.add((mediaSinkWantsManager93 == MediaSinkWantsManager9.Zero || (mediaSinkWantsLadder6 = (MediaSinkWantsLadder6) linkedHashMap.get(mediaSinkWantsManager93)) == null) ? null : new c(mediaSinkWantsLadder6, mediaSinkWantsLadder6.f1759b * mediaSinkWantsLadder6.f1758a, mediaSinkWantsManager93));
        }
        this.f1616d = _Collections.filterNotNull(arrayList2);
    }
}
