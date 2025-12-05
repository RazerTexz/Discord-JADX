package p659s.p660a.p663c2;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* compiled from: Channel.kt */
/* renamed from: s.a.c2.o, reason: use source file name */
/* loaded from: classes3.dex */
public interface Channel6<E> {
    /* renamed from: b */
    void mo11199b(CancellationException cancellationException);

    Channel5<E> iterator();

    /* renamed from: m */
    Object mo11200m(Continuation<? super Channel8<? extends E>> continuation);
}
