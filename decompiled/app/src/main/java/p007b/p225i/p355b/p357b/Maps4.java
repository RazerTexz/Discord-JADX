package p007b.p225i.p355b.p357b;

import com.google.j2objc.annotations.Weak;
import java.util.Map;
import java.util.Objects;

/* compiled from: Maps.java */
/* renamed from: b.i.b.b.y, reason: use source file name */
/* loaded from: classes3.dex */
public class Maps4<K, V> extends Sets3<K> {

    /* renamed from: j */
    @Weak
    public final Map<K, V> f12111j;

    public Maps4(Map<K, V> map) {
        Objects.requireNonNull(map);
        this.f12111j = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f12111j.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12111j.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f12111j.size();
    }
}
