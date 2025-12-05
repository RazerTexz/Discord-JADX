package p659s.p660a;

/* compiled from: EventLoop.common.kt */
/* renamed from: s.a.w1 */
/* loaded from: classes3.dex */
public final class C13161w1 {

    /* renamed from: a */
    public static final ThreadLocal<AbstractC13142q0> f27915a = new ThreadLocal<>();

    /* renamed from: b */
    public static final C13161w1 f27916b = null;

    /* renamed from: a */
    public static final AbstractC13142q0 m11353a() {
        ThreadLocal<AbstractC13142q0> threadLocal = f27915a;
        AbstractC13142q0 abstractC13142q0 = threadLocal.get();
        if (abstractC13142q0 != null) {
            return abstractC13142q0;
        }
        EventLoop eventLoop = new EventLoop(Thread.currentThread());
        threadLocal.set(eventLoop);
        return eventLoop;
    }
}
