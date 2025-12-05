package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    /* renamed from: g */
    public static final /* synthetic */ int f27455g = 0;

    /* compiled from: CoroutineExceptionHandler.kt */
    /* renamed from: kotlinx.coroutines.CoroutineExceptionHandler$a */
    public static final class C12804a implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* renamed from: a */
        public static final /* synthetic */ C12804a f27456a = new C12804a();
    }

    void handleException(CoroutineContext coroutineContext, Throwable th);
}
