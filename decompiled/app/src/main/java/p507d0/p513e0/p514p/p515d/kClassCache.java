package p507d0.p513e0.p514p.p515d;

import java.lang.ref.WeakReference;
import p507d0.p513e0.p514p.p515d.p577n0.HashPMap;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.g, reason: use source file name */
/* JADX INFO: compiled from: kClassCache.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class kClassCache {

    /* JADX INFO: renamed from: a */
    public static HashPMap<String, Object> f22359a;

    static {
        HashPMap<String, Object> hashPMapEmpty = HashPMap.empty();
        Intrinsics3.checkNotNullExpressionValue(hashPMapEmpty, "HashPMap.empty<String, Any>()");
        f22359a = hashPMapEmpty;
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> cls) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        String name = cls.getName();
        Object obj = f22359a.get(name);
        if (obj instanceof WeakReference) {
            KClassImpl<T> kClassImpl = (KClassImpl) ((WeakReference) obj).get();
            if (Intrinsics3.areEqual(kClassImpl != null ? kClassImpl.getJClass() : null, cls)) {
                return kClassImpl;
            }
        } else if (obj != null) {
            for (WeakReference weakReference : (WeakReference[]) obj) {
                KClassImpl<T> kClassImpl2 = (KClassImpl) weakReference.get();
                if (Intrinsics3.areEqual(kClassImpl2 != null ? kClassImpl2.getJClass() : null, cls)) {
                    return kClassImpl2;
                }
            }
            int length = ((Object[]) obj).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(obj, 0, weakReferenceArr, 0, length);
            KClassImpl<T> kClassImpl3 = new KClassImpl<>(cls);
            weakReferenceArr[length] = new WeakReference(kClassImpl3);
            HashPMap<String, Object> hashPMapPlus = f22359a.plus(name, weakReferenceArr);
            Intrinsics3.checkNotNullExpressionValue(hashPMapPlus, "K_CLASS_CACHE.plus(name, newArray)");
            f22359a = hashPMapPlus;
            return kClassImpl3;
        }
        KClassImpl<T> kClassImpl4 = new KClassImpl<>(cls);
        HashPMap<String, Object> hashPMapPlus2 = f22359a.plus(name, new WeakReference(kClassImpl4));
        Intrinsics3.checkNotNullExpressionValue(hashPMapPlus2, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        f22359a = hashPMapPlus2;
        return kClassImpl4;
    }
}
