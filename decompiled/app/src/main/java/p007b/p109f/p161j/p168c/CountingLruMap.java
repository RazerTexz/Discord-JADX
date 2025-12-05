package p007b.p109f.p161j.p168c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p007b.p109f.p115d.p119d.Predicate2;

/* compiled from: CountingLruMap.java */
/* renamed from: b.f.j.c.l, reason: use source file name */
/* loaded from: classes.dex */
public class CountingLruMap<K, V> {

    /* renamed from: a */
    public final ValueDescriptor<V> f3675a;

    /* renamed from: b */
    public final LinkedHashMap<K, V> f3676b = new LinkedHashMap<>();

    /* renamed from: c */
    public int f3677c = 0;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.f3675a = valueDescriptor;
    }

    /* renamed from: a */
    public synchronized int m1221a() {
        return this.f3676b.size();
    }

    /* renamed from: b */
    public synchronized int m1222b() {
        return this.f3677c;
    }

    /* renamed from: c */
    public final int m1223c(V v) {
        if (v == null) {
            return 0;
        }
        return this.f3675a.mo1212a(v);
    }

    /* renamed from: d */
    public synchronized V m1224d(K k, V v) {
        V vRemove;
        vRemove = this.f3676b.remove(k);
        this.f3677c -= m1223c(vRemove);
        this.f3676b.put(k, v);
        this.f3677c += m1223c(v);
        return vRemove;
    }

    /* renamed from: e */
    public synchronized V m1225e(K k) {
        V vRemove;
        vRemove = this.f3676b.remove(k);
        this.f3677c -= m1223c(vRemove);
        return vRemove;
    }

    /* renamed from: f */
    public synchronized ArrayList<V> m1226f(Predicate2<K> predicate2) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.f3676b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (predicate2 != null) {
            }
            arrayList.add(next.getValue());
            this.f3677c -= m1223c(next.getValue());
            it.remove();
        }
        return arrayList;
    }
}
