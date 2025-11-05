package d0.e0.p.d.m0.i;

import java.util.Iterator;
import java.util.Map;

/* compiled from: LazyField.java */
/* loaded from: classes3.dex */
public class i extends j {

    /* compiled from: LazyField.java */
    public static class b<K> implements Map.Entry<K, Object> {
        public Map.Entry<K, i> j;

        public b(Map.Entry entry, a aVar) {
            this.j = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.j.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            i value = this.j.getValue();
            if (value == null) {
                return null;
            }
            return value.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof n) {
                return this.j.getValue().setValue((n) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* compiled from: LazyField.java */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {
        public Iterator<Map.Entry<K, Object>> j;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.j = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.j.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.j.next();
            return next.getValue() instanceof i ? new b(next, null) : next;
        }
    }

    public boolean equals(Object obj) {
        return getValue().equals(obj);
    }

    public n getValue() {
        return getValue(null);
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue().toString();
    }
}
