package p007b.p195g.p196a.p205c.p210c0;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: b.g.a.c.c0.l, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedMethodMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedMethodMap implements Iterable<AnnotatedMethod> {

    /* JADX INFO: renamed from: j */
    public Map<MemberKey, AnnotatedMethod> f4724j;

    public AnnotatedMethodMap() {
    }

    @Override // java.lang.Iterable
    public Iterator<AnnotatedMethod> iterator() {
        Map<MemberKey, AnnotatedMethod> map = this.f4724j;
        return map == null ? Collections.emptyIterator() : map.values().iterator();
    }

    public AnnotatedMethodMap(Map<MemberKey, AnnotatedMethod> map) {
        this.f4724j = map;
    }
}
