package s.a.c2;

import kotlin.coroutines.Continuation;

/* compiled from: Channel.kt */
/* loaded from: classes3.dex */
public interface g<E> {
    Object a(Continuation<? super Boolean> continuation);

    E next();
}
