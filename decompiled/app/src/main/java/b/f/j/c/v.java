package b.f.j.c;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import b.f.j.a.c.c;
import b.f.j.c.m;
import b.f.j.c.w;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;

/* compiled from: LruCountingMemoryCache.java */
/* loaded from: classes.dex */
public class v<K, V> implements m<K, V>, w<K, V> {
    public final m.b<K> a;

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final l<K, m.a<K, V>> f561b;

    @VisibleForTesting
    public final l<K, m.a<K, V>> c;
    public final b0<V> d;
    public final Supplier<MemoryCacheParams> e;
    public MemoryCacheParams f;
    public long g;
    public final boolean h;
    public final boolean i;

    /* compiled from: LruCountingMemoryCache.java */
    public class a implements b.f.d.h.f<V> {
        public final /* synthetic */ m.a a;

        public a(m.a aVar) {
            this.a = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x003d  */
        @Override // b.f.d.h.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void release(V v) {
            boolean z2;
            m.b<K> bVar;
            v vVar = v.this;
            m.a<K, V> aVar = this.a;
            Objects.requireNonNull(vVar);
            Objects.requireNonNull(aVar);
            synchronized (vVar) {
                synchronized (vVar) {
                    z2 = false;
                    b.c.a.a0.d.B(aVar.c > 0);
                    aVar.c--;
                }
                CloseableReference.s(vVar.o(aVar));
                if (!z2) {
                    aVar = null;
                }
                if (aVar != null && (bVar = aVar.e) != null) {
                    ((c.a) bVar).a(aVar.a, true);
                }
                vVar.m();
                vVar.j();
            }
            synchronized (vVar) {
                if (!aVar.d && aVar.c == 0) {
                    vVar.f561b.d(aVar.a, aVar);
                    z2 = true;
                }
            }
            CloseableReference.s(vVar.o(aVar));
            if (!z2) {
            }
            if (aVar != null) {
                ((c.a) bVar).a(aVar.a, true);
            }
            vVar.m();
            vVar.j();
        }
    }

    public v(b0<V> b0Var, w.a aVar, Supplier<MemoryCacheParams> supplier, m.b<K> bVar, boolean z2, boolean z3) {
        new WeakHashMap();
        this.d = b0Var;
        this.f561b = new l<>(new u(this, b0Var));
        this.c = new l<>(new u(this, b0Var));
        this.e = supplier;
        MemoryCacheParams memoryCacheParams = supplier.get();
        b.c.a.a0.d.y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f = memoryCacheParams;
        this.g = SystemClock.uptimeMillis();
        this.a = bVar;
        this.h = z2;
        this.i = z3;
    }

    public static <K, V> void k(m.a<K, V> aVar) {
        m.b<K> bVar;
        if (aVar == null || (bVar = aVar.e) == null) {
            return;
        }
        ((c.a) bVar).a(aVar.a, false);
    }

    @Override // b.f.j.c.w
    public CloseableReference<V> a(K k, CloseableReference<V> closeableReference) {
        return c(k, closeableReference, this.a);
    }

    @Override // b.f.j.c.m
    public CloseableReference<V> b(K k) {
        m.a<K, V> aVarE;
        boolean z2;
        CloseableReference<V> closeableReference;
        Objects.requireNonNull(k);
        synchronized (this) {
            aVarE = this.f561b.e(k);
            if (aVarE != null) {
                m.a<K, V> aVarE2 = this.c.e(k);
                Objects.requireNonNull(aVarE2);
                b.c.a.a0.d.B(aVarE2.c == 0);
                closeableReference = aVarE2.f558b;
                z2 = true;
            } else {
                closeableReference = null;
            }
        }
        if (z2) {
            k(aVarE);
        }
        return closeableReference;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    @Override // b.f.j.c.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CloseableReference<V> c(K k, CloseableReference<V> closeableReference, m.b<K> bVar) {
        CloseableReference<V> closeableReferenceN;
        CloseableReference<V> closeableReferenceO;
        int iA;
        boolean z2;
        Objects.requireNonNull(k);
        Objects.requireNonNull(closeableReference);
        m();
        synchronized (this) {
            m.a<K, V> aVarE = this.f561b.e(k);
            m.a<K, V> aVarE2 = this.c.e(k);
            closeableReferenceN = null;
            if (aVarE2 != null) {
                g(aVarE2);
                closeableReferenceO = o(aVarE2);
            } else {
                closeableReferenceO = null;
            }
            iA = this.d.a(closeableReference.u());
            synchronized (this) {
                z2 = true;
                if (iA > this.f.e || e() > this.f.f2895b - 1) {
                    z2 = false;
                } else if (f() > this.f.a - iA) {
                }
            }
            if (closeableReferenceO != null) {
                closeableReferenceO.close();
            }
            k(aVarE);
            j();
            return closeableReferenceN;
        }
        if (z2) {
            m.a<K, V> aVar = this.h ? new m.a<>(k, closeableReference, bVar, iA) : new m.a<>(k, closeableReference, bVar, -1);
            this.c.d(k, aVar);
            closeableReferenceN = n(aVar);
        }
        if (closeableReferenceO != null) {
        }
        k(aVarE);
        j();
        return closeableReferenceN;
    }

    @Override // b.f.j.c.w
    public synchronized boolean contains(K k) {
        boolean zContainsKey;
        l<K, m.a<K, V>> lVar = this.c;
        synchronized (lVar) {
            zContainsKey = lVar.f557b.containsKey(k);
        }
        return zContainsKey;
    }

    @Override // b.f.j.c.w
    public int d(b.f.d.d.j<K> jVar) {
        ArrayList<m.a<K, V>> arrayListF;
        ArrayList<m.a<K, V>> arrayListF2;
        synchronized (this) {
            arrayListF = this.f561b.f(jVar);
            arrayListF2 = this.c.f(jVar);
            h(arrayListF2);
        }
        i(arrayListF2);
        l(arrayListF);
        m();
        j();
        return arrayListF2.size();
    }

    public synchronized int e() {
        return this.c.a() - this.f561b.a();
    }

    public synchronized int f() {
        return this.c.b() - this.f561b.b();
    }

    public final synchronized void g(m.a<K, V> aVar) {
        Objects.requireNonNull(aVar);
        b.c.a.a0.d.B(!aVar.d);
        aVar.d = true;
    }

    @Override // b.f.j.c.w
    public CloseableReference<V> get(K k) {
        m.a<K, V> aVarE;
        m.a<K, V> aVar;
        CloseableReference<V> closeableReferenceN;
        Objects.requireNonNull(k);
        synchronized (this) {
            aVarE = this.f561b.e(k);
            l<K, m.a<K, V>> lVar = this.c;
            synchronized (lVar) {
                aVar = lVar.f557b.get(k);
            }
            m.a<K, V> aVar2 = aVar;
            closeableReferenceN = aVar2 != null ? n(aVar2) : null;
        }
        k(aVarE);
        m();
        j();
        return closeableReferenceN;
    }

    public final synchronized void h(ArrayList<m.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<m.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
        }
    }

    public final void i(ArrayList<m.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<m.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                CloseableReference.s(o(it.next()));
            }
        }
    }

    public void j() {
        ArrayList<m.a<K, V>> arrayListP;
        synchronized (this) {
            MemoryCacheParams memoryCacheParams = this.f;
            int iMin = Math.min(memoryCacheParams.d, memoryCacheParams.f2895b - e());
            MemoryCacheParams memoryCacheParams2 = this.f;
            arrayListP = p(iMin, Math.min(memoryCacheParams2.c, memoryCacheParams2.a - f()));
            h(arrayListP);
        }
        i(arrayListP);
        l(arrayListP);
    }

    public final void l(ArrayList<m.a<K, V>> arrayList) {
        if (arrayList != null) {
            Iterator<m.a<K, V>> it = arrayList.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
        }
    }

    public final synchronized void m() {
        if (this.g + this.f.f > SystemClock.uptimeMillis()) {
            return;
        }
        this.g = SystemClock.uptimeMillis();
        MemoryCacheParams memoryCacheParams = this.e.get();
        b.c.a.a0.d.y(memoryCacheParams, "mMemoryCacheParamsSupplier returned null");
        this.f = memoryCacheParams;
    }

    public final synchronized CloseableReference<V> n(m.a<K, V> aVar) {
        synchronized (this) {
            b.c.a.a0.d.B(!aVar.d);
            aVar.c++;
        }
        return CloseableReference.D(aVar.f558b.u(), new a(aVar));
        return CloseableReference.D(aVar.f558b.u(), new a(aVar));
    }

    public final synchronized CloseableReference<V> o(m.a<K, V> aVar) {
        Objects.requireNonNull(aVar);
        return (aVar.d && aVar.c == 0) ? aVar.f558b : null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        if (r5.i == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        r6 = r5.f561b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        monitor-enter(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        if (r6.f557b.isEmpty() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        r6.c = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        monitor-exit(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
    
        throw new java.lang.IllegalStateException(java.lang.String.format("key is null, but exclusiveEntries count: %d, size: %d", java.lang.Integer.valueOf(r5.f561b.a()), java.lang.Integer.valueOf(r5.f561b.b())));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized ArrayList<m.a<K, V>> p(int i, int i2) {
        K next;
        int iMax = Math.max(i, 0);
        int iMax2 = Math.max(i2, 0);
        if (this.f561b.a() <= iMax && this.f561b.b() <= iMax2) {
            return null;
        }
        ArrayList<m.a<K, V>> arrayList = new ArrayList<>();
        while (true) {
            if (this.f561b.a() <= iMax && this.f561b.b() <= iMax2) {
                break;
            }
            l<K, m.a<K, V>> lVar = this.f561b;
            synchronized (lVar) {
                next = lVar.f557b.isEmpty() ? null : lVar.f557b.keySet().iterator().next();
            }
            if (next == null) {
                break;
            }
            this.f561b.e(next);
            arrayList.add(this.c.e(next));
        }
        return arrayList;
    }
}
