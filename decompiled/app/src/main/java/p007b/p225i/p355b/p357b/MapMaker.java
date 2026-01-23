package p007b.p225i.p355b.p357b;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p356a.Equivalence;
import p007b.p225i.p355b.p356a.MoreObjects2;
import p007b.p225i.p355b.p357b.MapMakerInternalMap;

/* JADX INFO: renamed from: b.i.b.b.u, reason: use source file name */
/* JADX INFO: compiled from: MapMaker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MapMaker {

    /* JADX INFO: renamed from: a */
    public boolean f12064a;

    /* JADX INFO: renamed from: b */
    public int f12065b = -1;

    /* JADX INFO: renamed from: c */
    public int f12066c = -1;

    /* JADX INFO: renamed from: d */
    @MonotonicNonNullDecl
    public MapMakerInternalMap.p f12067d;

    /* JADX INFO: renamed from: e */
    @MonotonicNonNullDecl
    public MapMakerInternalMap.p f12068e;

    /* JADX INFO: renamed from: f */
    @MonotonicNonNullDecl
    public Equivalence<Object> f12069f;

    /* JADX INFO: renamed from: a */
    public MapMakerInternalMap.p m6284a() {
        return (MapMakerInternalMap.p) C3404f.m4255W(this.f12067d, MapMakerInternalMap.p.f12099j);
    }

    /* JADX INFO: renamed from: b */
    public MapMakerInternalMap.p m6285b() {
        return (MapMakerInternalMap.p) C3404f.m4255W(this.f12068e, MapMakerInternalMap.p.f12099j);
    }

    /* JADX INFO: renamed from: c */
    public <K, V> ConcurrentMap<K, V> m6286c() {
        if (!this.f12064a) {
            int i = this.f12065b;
            if (i == -1) {
                i = 16;
            }
            int i2 = this.f12066c;
            if (i2 == -1) {
                i2 = 4;
            }
            return new ConcurrentHashMap(i, 0.75f, i2);
        }
        MapMakerInternalMap.b0<Object, Object, MapMakerInternalMap.e> b0Var = MapMakerInternalMap.f12070j;
        MapMakerInternalMap.p pVar = MapMakerInternalMap.p.f12100k;
        MapMakerInternalMap.p pVarM6284a = m6284a();
        MapMakerInternalMap.p pVar2 = MapMakerInternalMap.p.f12099j;
        if (pVarM6284a == pVar2 && m6285b() == pVar2) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.q.a.f12103a);
        }
        if (m6284a() == pVar2 && m6285b() == pVar) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.s.a.f12105a);
        }
        if (m6284a() == pVar && m6285b() == pVar2) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.w.a.f12108a);
        }
        if (m6284a() == pVar && m6285b() == pVar) {
            return new MapMakerInternalMap(this, MapMakerInternalMap.y.a.f12110a);
        }
        throw new AssertionError();
    }

    /* JADX INFO: renamed from: d */
    public MapMaker m6287d(MapMakerInternalMap.p pVar) {
        MapMakerInternalMap.p pVar2 = this.f12067d;
        C3404f.m4207G(pVar2 == null, "Key strength was already set to %s", pVar2);
        Objects.requireNonNull(pVar);
        this.f12067d = pVar;
        if (pVar != MapMakerInternalMap.p.f12099j) {
            this.f12064a = true;
        }
        return this;
    }

    public String toString() {
        MoreObjects2 moreObjects2 = new MoreObjects2(MapMaker.class.getSimpleName(), null);
        int i = this.f12065b;
        if (i != -1) {
            moreObjects2.m6214a("initialCapacity", i);
        }
        int i2 = this.f12066c;
        if (i2 != -1) {
            moreObjects2.m6214a("concurrencyLevel", i2);
        }
        MapMakerInternalMap.p pVar = this.f12067d;
        if (pVar != null) {
            String strM4349u1 = C3404f.m4349u1(pVar.toString());
            MoreObjects2.a aVar = new MoreObjects2.a(null);
            moreObjects2.f11952c.f11955c = aVar;
            moreObjects2.f11952c = aVar;
            aVar.f11954b = strM4349u1;
            aVar.f11953a = "keyStrength";
        }
        MapMakerInternalMap.p pVar2 = this.f12068e;
        if (pVar2 != null) {
            String strM4349u12 = C3404f.m4349u1(pVar2.toString());
            MoreObjects2.a aVar2 = new MoreObjects2.a(null);
            moreObjects2.f11952c.f11955c = aVar2;
            moreObjects2.f11952c = aVar2;
            aVar2.f11954b = strM4349u12;
            aVar2.f11953a = "valueStrength";
        }
        if (this.f12069f != null) {
            MoreObjects2.a aVar3 = new MoreObjects2.a(null);
            moreObjects2.f11952c.f11955c = aVar3;
            moreObjects2.f11952c = aVar3;
            aVar3.f11954b = "keyEquivalence";
        }
        return moreObjects2.toString();
    }
}
