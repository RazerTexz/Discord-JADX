package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.Bundleable;

/* compiled from: TrackGroupArray.java */
/* renamed from: b.i.a.c.a3.o0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TrackGroupArray implements Bundleable {

    /* renamed from: j */
    public static final TrackGroupArray f5674j = new TrackGroupArray(new TrackGroup[0]);

    /* renamed from: k */
    public final int f5675k;

    /* renamed from: l */
    public final TrackGroup[] f5676l;

    /* renamed from: m */
    public int f5677m;

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f5676l = trackGroupArr;
        this.f5675k = trackGroupArr.length;
    }

    /* renamed from: a */
    public int m2575a(TrackGroup trackGroup) {
        for (int i = 0; i < this.f5675k; i++) {
            if (this.f5676l[i] == trackGroup) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.f5675k == trackGroupArray.f5675k && Arrays.equals(this.f5676l, trackGroupArray.f5676l);
    }

    public int hashCode() {
        if (this.f5677m == 0) {
            this.f5677m = Arrays.hashCode(this.f5676l);
        }
        return this.f5677m;
    }
}
