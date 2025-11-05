package b.i.c.q;

import java.util.concurrent.Executor;

/* compiled from: Subscriber.java */
/* loaded from: classes3.dex */
public interface d {
    <T> void a(Class<T> cls, b<? super T> bVar);

    <T> void b(Class<T> cls, Executor executor, b<? super T> bVar);
}
