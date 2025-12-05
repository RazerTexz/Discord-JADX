package p007b.p225i.p361c.p368l;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p007b.p225i.p361c.p400t.Provider2;

/* compiled from: ComponentRuntime.java */
/* renamed from: b.i.c.l.i, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class ComponentRuntime2 implements Provider2 {

    /* renamed from: a */
    public final Set f12189a;

    public ComponentRuntime2(Set set) {
        this.f12189a = set;
    }

    @Override // p007b.p225i.p361c.p400t.Provider2
    public Object get() {
        Set set = this.f12189a;
        int i = ComponentRuntime4.f12191a;
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((Lazy2) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
