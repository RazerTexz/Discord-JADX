package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;

/* compiled from: DefaultBitmapPoolParams.java */
/* renamed from: b.f.j.l.j, reason: use source file name */
/* loaded from: classes3.dex */
public class DefaultBitmapPoolParams {

    /* renamed from: a */
    public static final SparseIntArray f3941a = new SparseIntArray(0);

    /* renamed from: a */
    public static PoolParams m1390a() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return new PoolParams(0, iMin > 16777216 ? (iMin / 4) * 3 : iMin / 2, f3941a);
    }
}
