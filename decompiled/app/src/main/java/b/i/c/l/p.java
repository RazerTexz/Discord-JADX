package b.i.c.l;

import java.util.Map;

/* compiled from: EventBus.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {
    public final Map.Entry j;
    public final b.i.c.q.a k;

    public p(Map.Entry entry, b.i.c.q.a aVar) {
        this.j = entry;
        this.k = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map.Entry entry = this.j;
        ((b.i.c.q.b) entry.getKey()).a(this.k);
    }
}
