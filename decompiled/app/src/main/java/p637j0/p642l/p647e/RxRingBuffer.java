package p637j0.p642l.p647e;

import java.io.PrintStream;
import java.util.Queue;
import p007b.p100d.p104b.p105a.outline;
import p637j0.p642l.p643a.NotificationLite;
import p637j0.p642l.p647e.p648n.SpscAtomicArrayQueue;
import p637j0.p642l.p647e.p649o.SpmcArrayQueue;
import p637j0.p642l.p647e.p649o.SpscArrayQueue;
import p658rx.Subscription;
import p658rx.exceptions.MissingBackpressureException;

/* compiled from: RxRingBuffer.java */
/* renamed from: j0.l.e.i, reason: use source file name */
/* loaded from: classes3.dex */
public class RxRingBuffer implements Subscription {

    /* renamed from: j */
    public static final int f27283j;

    /* renamed from: k */
    public Queue<Object> f27284k;

    /* renamed from: l */
    public volatile Object f27285l;

    static {
        int i = PlatformDependent.f27282b ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                StringBuilder sbM837Y = outline.m837Y("Failed to set 'rx.buffer.size' with value ", property, " => ");
                sbM837Y.append(e.getMessage());
                printStream.println(sbM837Y.toString());
            }
        }
        f27283j = i;
    }

    public RxRingBuffer(boolean z2, int i) {
        this.f27284k = z2 ? new SpmcArrayQueue<>(i) : new SpscArrayQueue<>(i);
    }

    /* renamed from: a */
    public void m10817a(Object obj) throws MissingBackpressureException {
        boolean z2;
        boolean z3;
        synchronized (this) {
            Queue<Object> queue = this.f27284k;
            z2 = true;
            z3 = false;
            if (queue != null) {
                if (obj == null) {
                    obj = NotificationLite.f26769b;
                }
                z3 = !queue.offer(obj);
                z2 = false;
            }
        }
        if (z2) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z3) {
            throw new MissingBackpressureException();
        }
    }

    /* renamed from: b */
    public Object m10818b() {
        synchronized (this) {
            Queue<Object> queue = this.f27284k;
            if (queue == null) {
                return null;
            }
            Object objPeek = queue.peek();
            Object obj = this.f27285l;
            if (objPeek == null && obj != null && queue.peek() == null) {
                objPeek = obj;
            }
            return objPeek;
        }
    }

    /* renamed from: c */
    public Object m10819c() {
        synchronized (this) {
            Queue<Object> queue = this.f27284k;
            if (queue == null) {
                return null;
            }
            Object objPoll = queue.poll();
            Object obj = this.f27285l;
            if (objPoll == null && obj != null && queue.peek() == null) {
                this.f27285l = null;
                objPoll = obj;
            }
            return objPoll;
        }
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27284k == null;
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        synchronized (this) {
        }
    }

    public RxRingBuffer() {
        this.f27284k = new SpscAtomicArrayQueue(f27283j);
    }
}
