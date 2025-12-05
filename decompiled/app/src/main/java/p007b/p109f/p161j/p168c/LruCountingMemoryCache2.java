package p007b.p109f.p161j.p168c;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.Predicate2;
import p007b.p109f.p115d.p123h.ResourceReleaser;
import p007b.p109f.p161j.p162a.p165c.AnimatedFrameCache;
import p007b.p109f.p161j.p168c.CountingMemoryCache;
import p007b.p109f.p161j.p168c.MemoryCache;

/* compiled from: LruCountingMemoryCache.java */
/* renamed from: b.f.j.c.v, reason: use source file name */
/* loaded from: classes.dex */
public class LruCountingMemoryCache2<K, V> implements CountingMemoryCache<K, V>, MemoryCache<K, V> {

    /* renamed from: a */
    public final CountingMemoryCache.b<K> f3692a;

    /* renamed from: b */
    @VisibleForTesting
    public final CountingLruMap<K, CountingMemoryCache.a<K, V>> f3693b;

    /* renamed from: c */
    @VisibleForTesting
    public final CountingLruMap<K, CountingMemoryCache.a<K, V>> f3694c;

    /* renamed from: d */
    public final ValueDescriptor<V> f3695d;

    /* renamed from: e */
    public final Supplier<MemoryCacheParams> f3696e;

    /* renamed from: f */
    public MemoryCacheParams f3697f;

    /* renamed from: g */
    public long f3698g;

    /* renamed from: h */
    public final boolean f3699h;

    /* renamed from: i */
    public final boolean f3700i;

    /* compiled from: LruCountingMemoryCache.java */
    /* renamed from: b.f.j.c.v$a */
    public class a implements ResourceReleaser<V> {

        /* renamed from: a */
        public final /* synthetic */ CountingMemoryCache.a f3701a;

        public a(CountingMemoryCache.a aVar) {
            this.f3701a = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
        @Override // p007b.p109f.p115d.p123h.ResourceReleaser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void release(V v) {
            boolean z2;
            CountingMemoryCache.b<K> bVar;
            LruCountingMemoryCache2 lruCountingMemoryCache2 = LruCountingMemoryCache2.this;
            CountingMemoryCache.a<K, V> aVar = this.f3701a;
            Objects.requireNonNull(lruCountingMemoryCache2);
            Objects.requireNonNull(aVar);
            synchronized (lruCountingMemoryCache2) {
                synchronized (lruCountingMemoryCache2) {
                    z2 = false;
                    AnimatableValueParser.m419B(aVar.f3680c > 0);
                    aVar.f3680c--;
                }
                CloseableReference.m8638s(lruCountingMemoryCache2.m1247o(aVar));
                if (!z2) {
                    aVar = null;
                }
                if (aVar != null && (bVar = aVar.f3682e) != null) {
                    ((AnimatedFrameCache.a) bVar).m1201a(aVar.f3678a, true);
                }
                lruCountingMemoryCache2.m1245m();
                lruCountingMemoryCache2.m1243j();
            }
            synchronized (lruCountingMemoryCache2) {
                if (!aVar.f3681d && aVar.f3680c == 0) {
                    lruCountingMemoryCache2.f3693b.m1224d(aVar.f3678a, aVar);
                    z2 = true;
                }
            }
            CloseableReference.m8638s(lruCountingMemoryCache2.m1247o(aVar));
            if (!z2) {
            }
            if (aVar != null) {
                ((AnimatedFrameCache.a) bVar).m1201a(aVar.f3678a, true);
            }
            lruCountingMemoryCache2.m1245m();
            lruCountingMemoryCache2.m1243j();
        }
    }

    public LruCountingMemoryCache2(ValueDescriptor<V> valueDescriptor, MemoryCache.a aVar, Supplier<MemoryCacheParams> supplier, CountingMemoryCache.b<K> bVar, boolean z2, boolean z3) {
        new WeakHashMap();
        this.f3695d = valueDescriptor;
        this.f3693b = new CountingLruMap<>(new LruCountingMemoryCache(this, valueDescriptor));
        this.f3694c = new CountingLruMap<>(new LruCountingMemoryCache(this, valueDescriptor));
        this.f3696e = supplier;
        MemoryCacheParams memoryCacheParams = supplier.get();
        AnimatableValueParser.m591y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f3697f = memoryCacheParams;
        this.f3698g = SystemClock.uptimeMillis();
        this.f3692a = bVar;
        this.f3699h = z2;
        this.f3700i = z3;
    }

    /* renamed from: k */
    public static <K, V> void m1237k(CountingMemoryCache.a<K, V> aVar) {
        CountingMemoryCache.b<K> bVar;
        if (aVar == null || (bVar = aVar.f3682e) == null) {
            return;
        }
        ((AnimatedFrameCache.a) bVar).m1201a(aVar.f3678a, false);
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCache
    /* renamed from: a */
    public CloseableReference<V> mo1235a(K k, CloseableReference<V> closeableReference) {
        return mo1228c(k, closeableReference, this.f3692a);
    }

    @Override // p007b.p109f.p161j.p168c.CountingMemoryCache
    /* renamed from: b */
    public CloseableReference<V> mo1227b(K k) {
        CountingMemoryCache.a<K, V> aVarM1225e;
        boolean z2;
        CloseableReference<V> closeableReference;
        Objects.requireNonNull(k);
        synchronized (this) {
            aVarM1225e = this.f3693b.m1225e(k);
            if (aVarM1225e != null) {
                CountingMemoryCache.a<K, V> aVarM1225e2 = this.f3694c.m1225e(k);
                Objects.requireNonNull(aVarM1225e2);
                AnimatableValueParser.m419B(aVarM1225e2.f3680c == 0);
                closeableReference = aVarM1225e2.f3679b;
                z2 = true;
            } else {
                closeableReference = null;
            }
        }
        if (z2) {
            m1237k(aVarM1225e);
        }
        return closeableReference;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    @Override // p007b.p109f.p161j.p168c.CountingMemoryCache
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableReference<V> mo1228c(K k, CloseableReference<V> closeableReference, CountingMemoryCache.b<K> bVar) {
        CloseableReference<V> closeableReferenceM1246n;
        CloseableReference<V> closeableReferenceM1247o;
        int iMo1212a;
        boolean z2;
        Objects.requireNonNull(k);
        Objects.requireNonNull(closeableReference);
        m1245m();
        synchronized (this) {
            CountingMemoryCache.a<K, V> aVarM1225e = this.f3693b.m1225e(k);
            CountingMemoryCache.a<K, V> aVarM1225e2 = this.f3694c.m1225e(k);
            closeableReferenceM1246n = null;
            if (aVarM1225e2 != null) {
                m1240g(aVarM1225e2);
                closeableReferenceM1247o = m1247o(aVarM1225e2);
            } else {
                closeableReferenceM1247o = null;
            }
            iMo1212a = this.f3695d.mo1212a(closeableReference.m8642u());
            synchronized (this) {
                z2 = true;
                if (iMo1212a > this.f3697f.f19546e || m1238e() > this.f3697f.f19543b - 1) {
                    z2 = false;
                } else if (m1239f() > this.f3697f.f19542a - iMo1212a) {
                }
            }
            if (closeableReferenceM1247o != null) {
                closeableReferenceM1247o.close();
            }
            m1237k(aVarM1225e);
            m1243j();
            return closeableReferenceM1246n;
        }
        if (z2) {
            CountingMemoryCache.a<K, V> aVar = this.f3699h ? new CountingMemoryCache.a<>(k, closeableReference, bVar, iMo1212a) : new CountingMemoryCache.a<>(k, closeableReference, bVar, -1);
            this.f3694c.m1224d(k, aVar);
            closeableReferenceM1246n = m1246n(aVar);
        }
        if (closeableReferenceM1247o != null) {
        }
        m1237k(aVarM1225e);
        m1243j();
        return closeableReferenceM1246n;
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCache
    public synchronized boolean contains(K k) {
        boolean zContainsKey;
        CountingLruMap<K, CountingMemoryCache.a<K, V>> countingLruMap = this.f3694c;
        synchronized (countingLruMap) {
            zContainsKey = countingLruMap.f3676b.containsKey(k);
        }
        return zContainsKey;
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCache
    /* renamed from: d */
    public int mo1236d(Predicate2<K> predicate2) {
        ArrayList<CountingMemoryCache.a<K, V>> arrayListM1226f;
        ArrayList<CountingMemoryCache.a<K, V>> arrayListM1226f2;
        synchronized (this) {
            arrayListM1226f = this.f3693b.m1226f(predicate2);
            arrayListM1226f2 = this.f3694c.m1226f(predicate2);
            m1241h(arrayListM1226f2);
        }
        m1242i(arrayListM1226f2);
        m1244l(arrayListM1226f);
        m1245m();
        m1243j();
        return arrayListM1226f2.size();
    }

    /* renamed from: e */
    public synchronized int m1238e() {
        return this.f3694c.m1221a() - this.f3693b.m1221a();
    }

    /* renamed from: f */
    public synchronized int m1239f() {
        return this.f3694c.m1222b() - this.f3693b.m1222b();
    }

    /* renamed from: g */
    public final synchronized void m1240g(CountingMemoryCache.a<K, V> aVar) {
        Objects.requireNonNull(aVar);
        AnimatableValueParser.m419B(!aVar.f3681d);
        aVar.f3681d = true;
    }

    @Override // p007b.p109f.p161j.p168c.MemoryCache
    public CloseableReference<V> get(K k) {
        CountingMemoryCache.a<K, V> aVarM1225e;
        CountingMemoryCache.a<K, V> aVar;
        CloseableReference<V> closeableReferenceM1246n;
        Objects.requireNonNull(k);
        synchronized (this) {
            aVarM1225e = this.f3693b.m1225e(k);
            CountingLruMap<K, CountingMemoryCache.a<K, V>> countingLruMap = this.f3694c;
            synchronized (countingLruMap) {
                aVar = countingLruMap.f3676b.get(k);
            }
            CountingMemoryCache.a<K, V> aVar2 = aVar;
            closeableReferenceM1246n = aVar2 != null ? m1246n(aVar2) : null;
        }
        m1237k(aVarM1225e);
        m1245m();
        m1243j();
        return closeableReferenceM1246n;
    }

    /* renamed from: h */
    public final synchronized void m1241h(ArrayList<CountingMemoryCache.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                m1240g(it.next());
            }
        }
    }

    /* renamed from: i */
    public final void m1242i(ArrayList<CountingMemoryCache.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.m8638s(m1247o(it.next()));
            }
        }
    }

    /* renamed from: j */
    public void m1243j() {
        ArrayList<CountingMemoryCache.a<K, V>> arrayListM1248p;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.f3697f;
            int iMin = Math.min(memoryCacheParams.f19545d, memoryCacheParams.f19543b - m1238e());
            MemoryCacheParams memoryCacheParams2 = this.f3697f;
            arrayListM1248p = m1248p(iMin, Math.min(memoryCacheParams2.f19544c, memoryCacheParams2.f19542a - m1239f()));
            m1241h(arrayListM1248p);
        }
        m1242i(arrayListM1248p);
        m1244l(arrayListM1248p);
    }

    /* renamed from: l */
    public final void m1244l(ArrayList<CountingMemoryCache.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<CountingMemoryCache.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                m1237k(it.next());
            }
        }
    }

    /* renamed from: m */
    public final synchronized void m1245m() {
        if (this.f3698g + this.f3697f.f19547f > SystemClock.uptimeMillis()) {
            return;
        }
        this.f3698g = SystemClock.uptimeMillis();
        MemoryCacheParams memoryCacheParams = this.f3696e.get();
        AnimatableValueParser.m591y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f3697f = memoryCacheParams;
    }

    /* renamed from: n */
    public final synchronized CloseableReference<V> m1246n(CountingMemoryCache.a<K, V> aVar) {
        synchronized (this) {
            AnimatableValueParser.m419B(!aVar.f3681d);
            aVar.f3680c++;
        }
        return CloseableReference.m8633D(aVar.f3679b.m8642u(), new a(aVar));
        return CloseableReference.m8633D(aVar.f3679b.m8642u(), new a(aVar));
    }

    /* renamed from: o */
    public final synchronized CloseableReference<V> m1247o(CountingMemoryCache.a<K, V> aVar) {
        Objects.requireNonNull(aVar);
        return (aVar.f3681d && aVar.f3680c == 0) ? aVar.f3679b : null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (r5.f3700i == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        r6 = r5.f3693b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        monitor-enter(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        if (r6.f3676b.isEmpty() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        r6.f3677c = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        monitor-exit(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
    
        throw new java.lang.IllegalStateException(java.lang.String.format("key is null, but exclusiveEntries count: %d, size: %d", java.lang.Integer.valueOf(r5.f3693b.m1221a()), java.lang.Integer.valueOf(r5.f3693b.m1222b())));
     */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized ArrayList<CountingMemoryCache.a<K, V>> m1248p(int i, int i2) {
        K next;
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (this.f3693b.m1221a() <= iMax && this.f3693b.m1222b() <= iMax2) {
            return null;
        }
        ArrayList<CountingMemoryCache.a<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.f3693b.m1221a() <= iMax && this.f3693b.m1222b() <= iMax2) {
                break;
            }
            CountingLruMap<K, CountingMemoryCache.a<K, V>> countingLruMap = this.f3693b;
            synchronized (countingLruMap) {
                next = countingLruMap.f3676b.isEmpty() ? null : countingLruMap.f3676b.keySet().iterator().next();
            }
            if (next == null) {
                break;
            }
            this.f3693b.m1225e(next);
            arrayList.add(this.f3694c.m1225e(next));
        }
        return arrayList;
    }
}
