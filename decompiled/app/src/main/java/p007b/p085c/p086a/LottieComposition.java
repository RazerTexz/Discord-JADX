package p007b.p085c.p086a;

import android.graphics.Rect;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p089b0.Logger2;
import p007b.p085c.p086a.p095y.Font;
import p007b.p085c.p086a.p095y.FontCharacter;
import p007b.p085c.p086a.p095y.Marker2;
import p007b.p085c.p086a.p095y.p098m.Layer2;

/* compiled from: LottieComposition.java */
/* renamed from: b.c.a.d, reason: use source file name */
/* loaded from: classes.dex */
public class LottieComposition {

    /* renamed from: c */
    public Map<String, List<Layer2>> f2338c;

    /* renamed from: d */
    public Map<String, LottieImageAsset> f2339d;

    /* renamed from: e */
    public Map<String, Font> f2340e;

    /* renamed from: f */
    public List<Marker2> f2341f;

    /* renamed from: g */
    public SparseArrayCompat<FontCharacter> f2342g;

    /* renamed from: h */
    public LongSparseArray<Layer2> f2343h;

    /* renamed from: i */
    public List<Layer2> f2344i;

    /* renamed from: j */
    public Rect f2345j;

    /* renamed from: k */
    public float f2346k;

    /* renamed from: l */
    public float f2347l;

    /* renamed from: m */
    public float f2348m;

    /* renamed from: n */
    public boolean f2349n;

    /* renamed from: a */
    public final PerformanceTracker f2336a = new PerformanceTracker();

    /* renamed from: b */
    public final HashSet<String> f2337b = new HashSet<>();

    /* renamed from: o */
    public int f2350o = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public void m669a(String str) {
        Logger2.m640b(str);
        this.f2337b.add(str);
    }

    /* renamed from: b */
    public float m670b() {
        return (long) ((m671c() / this.f2348m) * 1000.0f);
    }

    /* renamed from: c */
    public float m671c() {
        return this.f2347l - this.f2346k;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Nullable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Marker2 m672d(String str) {
        this.f2341f.size();
        for (int i = 0; i < this.f2341f.size(); i++) {
            Marker2 marker2 = this.f2341f.get(i);
            boolean z2 = true;
            if (!marker2.f2717a.equalsIgnoreCase(str)) {
                if (marker2.f2717a.endsWith("\r")) {
                    String str2 = marker2.f2717a;
                    if (!str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                        z2 = false;
                    }
                }
            }
            if (z2) {
                return marker2;
            }
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: e */
    public Layer2 m673e(long j) {
        return this.f2343h.get(j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer2> it = this.f2344i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().m788a("\t"));
        }
        return sb.toString();
    }
}
