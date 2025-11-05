package kotlinx.coroutines.internal;

import java.util.List;
import s.a.l1;

/* compiled from: MainDispatcherFactory.kt */
/* loaded from: classes3.dex */
public interface MainDispatcherFactory {
    l1 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
