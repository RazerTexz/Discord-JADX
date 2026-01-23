package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;

/* JADX INFO: renamed from: b.o.a.x.a, reason: use source file name */
/* JADX INFO: compiled from: AspectRatio.java */
/* JADX INFO: loaded from: classes3.dex */
public class AspectRatio2 implements Comparable<AspectRatio2> {

    /* JADX INFO: renamed from: j */
    @VisibleForTesting
    public static final HashMap<String, AspectRatio2> f14248j = new HashMap<>(16);

    /* JADX INFO: renamed from: k */
    public final int f14249k;

    /* JADX INFO: renamed from: l */
    public final int f14250l;

    public AspectRatio2(int i, int i2) {
        this.f14249k = i;
        this.f14250l = i2;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public static AspectRatio2 m7447f(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 != 0) {
            int i5 = i3 % i4;
            i3 = i4;
            i4 = i5;
        }
        if (i3 > 0) {
            i /= i3;
        }
        if (i3 > 0) {
            i2 /= i3;
        }
        String str = i + ":" + i2;
        HashMap<String, AspectRatio2> map = f14248j;
        AspectRatio2 aspectRatio2 = map.get(str);
        if (aspectRatio2 != null) {
            return aspectRatio2;
        }
        AspectRatio2 aspectRatio22 = new AspectRatio2(i, i2);
        map.put(str, aspectRatio22);
        return aspectRatio22;
    }

    @NonNull
    /* JADX INFO: renamed from: g */
    public static AspectRatio2 m7448g(@NonNull Size3 size3) {
        return m7447f(size3.f14251j, size3.f14252k);
    }

    @NonNull
    /* JADX INFO: renamed from: h */
    public static AspectRatio2 m7449h(@NonNull String str) {
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length == 2) {
            return m7447f(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull AspectRatio2 aspectRatio2) {
        return Float.compare(m7450i(), aspectRatio2.m7450i());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof AspectRatio2) && m7450i() == ((AspectRatio2) obj).m7450i();
    }

    public int hashCode() {
        return Float.floatToIntBits(m7450i());
    }

    /* JADX INFO: renamed from: i */
    public float m7450i() {
        return this.f14249k / this.f14250l;
    }

    @NonNull
    public String toString() {
        return this.f14249k + ":" + this.f14250l;
    }
}
