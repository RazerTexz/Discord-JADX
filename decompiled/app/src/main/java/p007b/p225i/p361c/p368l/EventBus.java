package p007b.p225i.p361c.p368l;

import java.util.Map;
import p007b.p225i.p361c.p396q.Event3;
import p007b.p225i.p361c.p396q.EventHandler2;

/* compiled from: EventBus.java */
/* renamed from: b.i.c.l.p, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class EventBus implements Runnable {

    /* renamed from: j */
    public final Map.Entry f12204j;

    /* renamed from: k */
    public final Event3 f12205k;

    public EventBus(Map.Entry entry, Event3 event3) {
        this.f12204j = entry;
        this.f12205k = event3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Map.Entry entry = this.f12204j;
        ((EventHandler2) entry.getKey()).mo6343a(this.f12205k);
    }
}
