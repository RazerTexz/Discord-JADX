package p659s.p660a.p663c2;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: s.a.c2.o, reason: use source file name */
/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Channel6<E> {
    /* JADX INFO: renamed from: b */
    void mo11199b(CancellationException cancellationException);

    Channel5<E> iterator();

    /* JADX INFO: renamed from: m */
    Object mo11200m(Continuation<? super Channel8<? extends E>> continuation);
}
