package p007b.p109f.p161j.p177l;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.util.LinkedList;
import java.util.Queue;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;

/* compiled from: Bucket.java */
@VisibleForTesting
/* renamed from: b.f.j.l.f, reason: use source file name */
/* loaded from: classes3.dex */
public class Bucket2<V> {

    /* renamed from: a */
    public final int f3926a;

    /* renamed from: b */
    public final int f3927b;

    /* renamed from: c */
    public final Queue f3928c;

    /* renamed from: d */
    public final boolean f3929d;

    /* renamed from: e */
    public int f3930e;

    public Bucket2(int i, int i2, int i3, boolean z2) {
        AnimatableValueParser.m419B(i > 0);
        AnimatableValueParser.m419B(i2 >= 0);
        AnimatableValueParser.m419B(i3 >= 0);
        this.f3926a = i;
        this.f3927b = i2;
        this.f3928c = new LinkedList();
        this.f3930e = i3;
        this.f3929d = z2;
    }

    /* renamed from: a */
    public void m1376a(V v) {
        this.f3928c.add(v);
    }

    /* renamed from: b */
    public void m1377b() {
        AnimatableValueParser.m419B(this.f3930e > 0);
        this.f3930e--;
    }

    /* renamed from: c */
    public V m1378c() {
        return (V) this.f3928c.poll();
    }

    /* renamed from: d */
    public void m1379d(V v) {
        if (this.f3929d) {
            AnimatableValueParser.m419B(this.f3930e > 0);
            this.f3930e--;
            m1376a(v);
            return;
        }
        int i = this.f3930e;
        if (i > 0) {
            this.f3930e = i - 1;
            m1376a(v);
        } else {
            Object[] objArr = {v};
            int i2 = FLog.f3102a;
            Log.println(6, "unknown:BUCKET", FLog.m979g("Tried to release value %s from an empty bucket!", objArr));
        }
    }
}
