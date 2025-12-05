package p007b.p109f.p161j.p177l;

import java.util.HashSet;
import java.util.Set;
import p007b.p109f.p161j.p177l.BucketMap;

/* compiled from: LruBucketsPoolBackend.java */
/* renamed from: b.f.j.l.q, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class LruBucketsPoolBackend<T> {

    /* renamed from: a */
    public final Set<T> f3950a = new HashSet();

    /* renamed from: b */
    public final BucketMap<T> f3951b = new BucketMap<>();

    /* renamed from: a */
    public abstract T mo1373a(int i);

    /* renamed from: b */
    public abstract int mo1374b(T t);

    /* renamed from: c */
    public T m1392c() {
        T t;
        BucketMap<T> bucketMap = this.f3951b;
        synchronized (bucketMap) {
            BucketMap.b<T> bVar = bucketMap.f3933c;
            if (bVar == null) {
                t = null;
            } else {
                T tPollLast = bVar.f3936c.pollLast();
                if (bVar.f3936c.isEmpty()) {
                    bucketMap.m1381b(bVar);
                    bucketMap.f3931a.remove(bVar.f3935b);
                }
                t = tPollLast;
            }
        }
        if (t != null) {
            synchronized (this) {
                this.f3950a.remove(t);
            }
        }
        return t;
    }
}
