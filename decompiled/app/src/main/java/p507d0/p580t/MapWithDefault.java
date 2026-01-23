package p507d0.p580t;

import java.util.Map;
import p507d0.p592z.p594d.p595g0.KMarkers;

/* JADX INFO: renamed from: d0.t.e0, reason: use source file name */
/* JADX INFO: compiled from: MapWithDefault.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MapWithDefault<K, V> extends Map<K, V>, KMarkers {
    V getOrImplicitDefault(K k);
}
