package p007b.p225i.p361c.p368l;

import androidx.annotation.GuardedBy;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import p007b.p225i.p361c.p396q.Event3;
import p007b.p225i.p361c.p396q.EventHandler2;
import p007b.p225i.p361c.p396q.Publisher;
import p007b.p225i.p361c.p396q.Subscriber2;

/* JADX INFO: renamed from: b.i.c.l.q, reason: use source file name */
/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes3.dex */
public class EventBus2 implements Subscriber2, Publisher {

    /* JADX INFO: renamed from: a */
    @GuardedBy("this")
    public final Map<Class<?>, ConcurrentHashMap<EventHandler2<Object>, Executor>> f12206a = new HashMap();

    /* JADX INFO: renamed from: b */
    @GuardedBy("this")
    public Queue<Event3<?>> f12207b = new ArrayDeque();

    /* JADX INFO: renamed from: c */
    public final Executor f12208c;

    public EventBus2(Executor executor) {
        this.f12208c = executor;
    }

    @Override // p007b.p225i.p361c.p396q.Subscriber2
    /* JADX INFO: renamed from: a */
    public <T> void mo6359a(Class<T> cls, EventHandler2<? super T> eventHandler2) {
        mo6360b(cls, this.f12208c, eventHandler2);
    }

    @Override // p007b.p225i.p361c.p396q.Subscriber2
    /* JADX INFO: renamed from: b */
    public synchronized <T> void mo6360b(Class<T> cls, Executor executor, EventHandler2<? super T> eventHandler2) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(eventHandler2);
        Objects.requireNonNull(executor);
        if (!this.f12206a.containsKey(cls)) {
            this.f12206a.put(cls, new ConcurrentHashMap<>());
        }
        this.f12206a.get(cls).put(eventHandler2, executor);
    }
}
