package kotlinx.coroutines.internal;

import java.util.List;
import p659s.p660a.MainCoroutineDispatcher;

/* compiled from: MainDispatcherFactory.kt */
/* loaded from: classes3.dex */
public interface MainDispatcherFactory {
    MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
