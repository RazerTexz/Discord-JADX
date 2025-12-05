package p007b.p109f.p161j.p181p;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: ThreadHandoffProducerQueueImpl.java */
/* renamed from: b.f.j.p.h1, reason: use source file name */
/* loaded from: classes3.dex */
public class ThreadHandoffProducerQueueImpl implements ThreadHandoffProducerQueue {

    /* renamed from: a */
    public final Deque<Runnable> f4073a;

    /* renamed from: b */
    public final Executor f4074b;

    public ThreadHandoffProducerQueueImpl(Executor executor) {
        Objects.requireNonNull(executor);
        this.f4074b = executor;
        this.f4073a = new ArrayDeque();
    }
}
