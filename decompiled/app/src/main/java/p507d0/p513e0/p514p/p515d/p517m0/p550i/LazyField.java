package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.util.Iterator;
import java.util.Map;

/* compiled from: LazyField.java */
/* renamed from: d0.e0.p.d.m0.i.i, reason: use source file name */
/* loaded from: classes3.dex */
public class LazyField extends LazyFieldLite {

    /* compiled from: LazyField.java */
    /* renamed from: d0.e0.p.d.m0.i.i$b */
    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: j */
        public Map.Entry<K, LazyField> f24143j;

        public b(Map.Entry entry, a aVar) {
            this.f24143j = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f24143j.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.f24143j.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof MessageLite) {
                return this.f24143j.getValue().setValue((MessageLite) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* compiled from: LazyField.java */
    /* renamed from: d0.e0.p.d.m0.i.i$c */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: j */
        public Iterator<Map.Entry<K, Object>> f24144j;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f24144j = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f24144j.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f24144j.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f24144j.next();
            return next.getValue() instanceof LazyField ? new b(next, null) : next;
        }
    }

    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public MessageLite getValue() {
        return getValue(null);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
