package s.a.c2;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public interface o<E> {
    void b(CancellationException cancellationException);

    g<E> iterator();

    Object m(Continuation<? super v<? extends E>> continuation);
}
