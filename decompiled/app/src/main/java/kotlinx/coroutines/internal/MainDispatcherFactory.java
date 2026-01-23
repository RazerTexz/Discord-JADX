package kotlinx.coroutines.internal;

import java.util.List;
import p659s.p660a.MainCoroutineDispatcher;

/* JADX INFO: compiled from: MainDispatcherFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MainDispatcherFactory {
    MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
