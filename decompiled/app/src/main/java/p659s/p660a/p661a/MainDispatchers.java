package p659s.p660a.p661a;

import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import p000.ServiceLoader;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p578f0.C12075n;
import p507d0.p578f0._Sequences2;
import p659s.p660a.MainCoroutineDispatcher;

/* compiled from: MainDispatchers.kt */
/* renamed from: s.a.a.n, reason: use source file name */
/* loaded from: classes3.dex */
public final class MainDispatchers {

    /* renamed from: a */
    public static final boolean f27699a;

    /* renamed from: b */
    public static final MainCoroutineDispatcher f27700b;

    static {
        MainDispatchers mainDispatchers = new MainDispatchers();
        String strM4309k1 = C3404f.m4309k1("kotlinx.coroutines.fast.service.loader");
        f27699a = strM4309k1 != null ? Boolean.parseBoolean(strM4309k1) : true;
        f27700b = mainDispatchers.m11170a();
    }

    /* renamed from: a */
    public final MainCoroutineDispatcher m11170a() {
        Object obj;
        List<? extends MainDispatcherFactory> list = _Sequences2.toList(C12075n.asSequence(ServiceLoader.m1b()));
        Iterator it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
        if (mainDispatcherFactory != null) {
            try {
                MainCoroutineDispatcher mainCoroutineDispatcherCreateDispatcher = mainDispatcherFactory.createDispatcher(list);
                if (mainCoroutineDispatcherCreateDispatcher != null) {
                    return mainCoroutineDispatcherCreateDispatcher;
                }
            } catch (Throwable th) {
                mainDispatcherFactory.hintOnError();
                throw th;
            }
        }
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
