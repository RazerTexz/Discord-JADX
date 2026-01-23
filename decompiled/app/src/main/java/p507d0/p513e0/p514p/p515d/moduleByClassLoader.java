package p507d0.p513e0.p514p.p515d;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a.RuntimeModuleData;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.b0, reason: use source file name */
/* JADX INFO: compiled from: moduleByClassLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class moduleByClassLoader {

    /* JADX INFO: renamed from: a */
    public static final ConcurrentMap<moduleByClassLoader2, WeakReference<RuntimeModuleData>> f22321a = new ConcurrentHashMap();

    public static final RuntimeModuleData getOrCreateModule(Class<?> cls) {
        Intrinsics3.checkNotNullParameter(cls, "$this$getOrCreateModule");
        ClassLoader safeClassLoader = reflectClassUtil.getSafeClassLoader(cls);
        moduleByClassLoader2 modulebyclassloader2 = new moduleByClassLoader2(safeClassLoader);
        ConcurrentMap<moduleByClassLoader2, WeakReference<RuntimeModuleData>> concurrentMap = f22321a;
        WeakReference<RuntimeModuleData> weakReference = concurrentMap.get(modulebyclassloader2);
        if (weakReference != null) {
            RuntimeModuleData runtimeModuleData = weakReference.get();
            if (runtimeModuleData != null) {
                Intrinsics3.checkNotNullExpressionValue(runtimeModuleData, "it");
                return runtimeModuleData;
            }
            concurrentMap.remove(modulebyclassloader2, weakReference);
        }
        RuntimeModuleData runtimeModuleDataCreate = RuntimeModuleData.f23022a.create(safeClassLoader);
        while (true) {
            try {
                ConcurrentMap<moduleByClassLoader2, WeakReference<RuntimeModuleData>> concurrentMap2 = f22321a;
                WeakReference<RuntimeModuleData> weakReferencePutIfAbsent = concurrentMap2.putIfAbsent(modulebyclassloader2, new WeakReference<>(runtimeModuleDataCreate));
                if (weakReferencePutIfAbsent == null) {
                    return runtimeModuleDataCreate;
                }
                RuntimeModuleData runtimeModuleData2 = weakReferencePutIfAbsent.get();
                if (runtimeModuleData2 != null) {
                    return runtimeModuleData2;
                }
                concurrentMap2.remove(modulebyclassloader2, weakReferencePutIfAbsent);
            } finally {
                modulebyclassloader2.setTemporaryStrongRef(null);
            }
        }
    }
}
