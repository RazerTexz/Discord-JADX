package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Map;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* renamed from: b.i.a.f.h.l.y6 */
/* loaded from: classes3.dex */
public final class C3905y6<K, V> implements Comparable<C3905y6>, Map.Entry<K, V> {

    /* renamed from: j */
    /* JADX INFO: Incorrect field signature: TK; */
    public final Comparable f10425j;

    /* renamed from: k */
    public V f10426k;

    /* renamed from: l */
    public final /* synthetic */ C3814r6 f10427l;

    public C3905y6(C3814r6 c3814r6, Map.Entry<K, V> entry) {
        Comparable comparable = (Comparable) entry.getKey();
        V value = entry.getValue();
        this.f10427l = c3814r6;
        this.f10425j = comparable;
        this.f10426k = value;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(C3905y6 c3905y6) {
        return this.f10425j.compareTo(c3905y6.f10425j);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Comparable comparable = this.f10425j;
        Object key = entry.getKey();
        if (comparable == null ? key == null : comparable.equals(key)) {
            V v = this.f10426k;
            Object value = entry.getValue();
            if (v == null ? value == null : v.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f10425j;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.f10426k;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f10425j;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.f10426k;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        C3814r6 c3814r6 = this.f10427l;
        int i = C3814r6.f10288j;
        c3814r6.m5210h();
        V v2 = this.f10426k;
        this.f10426k = v;
        return v2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f10425j);
        String strValueOf2 = String.valueOf(this.f10426k);
        return outline.m859k(strValueOf2.length() + strValueOf.length() + 1, strValueOf, "=", strValueOf2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C3905y6(C3814r6 c3814r6, K k, V v) {
        this.f10427l = c3814r6;
        this.f10425j = k;
        this.f10426k = v;
    }
}
