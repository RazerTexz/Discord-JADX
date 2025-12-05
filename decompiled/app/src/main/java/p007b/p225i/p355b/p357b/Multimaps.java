package p007b.p225i.p355b.p357b;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.Supplier2;

/* compiled from: Multimaps.java */
/* renamed from: b.i.b.b.d0, reason: use source file name */
/* loaded from: classes3.dex */
public class Multimaps<K, V> extends AbstractListMultimap<K, V> {
    private static final long serialVersionUID = 0;

    /* renamed from: o */
    public transient Supplier2<? extends List<V>> f11972o;

    public Multimaps(Map<K, Collection<V>> map, Supplier2<? extends List<V>> supplier2) {
        super(map);
        Objects.requireNonNull(supplier2);
        this.f11972o = supplier2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f11972o = (Supplier2) objectInputStream.readObject();
        Map<K, Collection<V>> map = (Map) objectInputStream.readObject();
        this.f11973m = map;
        this.f11974n = 0;
        for (Collection<V> collection : map.values()) {
            C3404f.m4351v(!collection.isEmpty());
            this.f11974n = collection.size() + this.f11974n;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f11972o);
        objectOutputStream.writeObject(this.f11973m);
    }

    @Override // p007b.p225i.p355b.p357b.AbstractMapBasedMultimap2
    /* renamed from: e */
    public Collection mo6217e() {
        return this.f11972o.get();
    }
}
