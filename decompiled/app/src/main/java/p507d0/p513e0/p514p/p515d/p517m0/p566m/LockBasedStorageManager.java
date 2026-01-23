package p507d0.p513e0.p514p.p515d.p517m0.p566m;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.locks4;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.exceptionUtils;
import p507d0.p579g0.Strings4;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.f, reason: use source file name */
/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class LockBasedStorageManager implements StorageManager {

    /* JADX INFO: renamed from: a */
    public static final String f24709a = Strings4.substringBeforeLast(LockBasedStorageManager.class.getCanonicalName(), ".", "");

    /* JADX INFO: renamed from: b */
    public static final StorageManager f24710b = new a("NO_LOCKS", f.f24717a, locks3.f24708b);

    /* JADX INFO: renamed from: c */
    public final locks4 f24711c;

    /* JADX INFO: renamed from: d */
    public final f f24712d;

    /* JADX INFO: renamed from: e */
    public final String f24713e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$a */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class a extends LockBasedStorageManager {
        public a(String str, f fVar, locks4 locks4Var) {
            super(str, fVar, locks4Var);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9981a(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 1 ? 3 : 2];
            if (i != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String str2 = String.format(str, objArr);
            if (i == 1) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager
        /* JADX INFO: renamed from: c */
        public <K, V> o<V> mo9980c(String str, K k) {
            o<V> oVarFallThrough = o.fallThrough();
            if (oVarFallThrough != null) {
                return oVarFallThrough;
            }
            m9981a(1);
            throw null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$b */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public class b<T> extends j<T> {

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ Object f24714m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LockBasedStorageManager lockBasedStorageManager, LockBasedStorageManager lockBasedStorageManager2, Function0 function0, Object obj) {
            super(lockBasedStorageManager2, function0);
            this.f24714m = obj;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.h
        /* JADX INFO: renamed from: c */
        public o<T> mo9982c(boolean z2) {
            o<T> oVarValue = o.value(this.f24714m);
            if (oVarValue != null) {
                return oVarValue;
            }
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$c */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public class c<T> extends k<T> {

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ Function1 f24715n;

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ Function1 f24716o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(LockBasedStorageManager lockBasedStorageManager, LockBasedStorageManager lockBasedStorageManager2, Function0 function0, Function1 function1, Function1 function12) {
            super(lockBasedStorageManager2, function0);
            this.f24715n = function1;
            this.f24716o = function12;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9983a(int i) {
            String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i != 2 ? 2 : 3];
            if (i != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i == 2) {
                objArr[2] = "doPostCompute";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.h
        /* JADX INFO: renamed from: c */
        public o<T> mo9982c(boolean z2) {
            Function1 function1 = this.f24715n;
            if (function1 == null) {
                o<T> oVarMo9982c = super.mo9982c(z2);
                if (oVarMo9982c != null) {
                    return oVarMo9982c;
                }
                m9983a(0);
                throw null;
            }
            o<T> oVarValue = o.value(function1.invoke(Boolean.valueOf(z2)));
            if (oVarValue != null) {
                return oVarValue;
            }
            m9983a(1);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$d */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class d<K, V> extends e<K, V> implements storage<K, V> {
        public d(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            super(lockBasedStorageManager, concurrentMap, null);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9984a(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "computation";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.e
        public V computeIfAbsent(K k, Function0<? extends V> function0) {
            if (function0 == null) {
                m9984a(2);
                throw null;
            }
            V v = (V) super.computeIfAbsent(k, function0);
            if (v != null) {
                return v;
            }
            m9984a(3);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$e */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class e<K, V> extends l<g<K, V>, V> implements storage2<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            super(lockBasedStorageManager, concurrentMap, new LockBasedStorageManager2());
            if (lockBasedStorageManager == null) {
                m9985a(0);
                throw null;
            }
            if (concurrentMap != null) {
            } else {
                m9985a(1);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9985a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public V computeIfAbsent(K k, Function0<? extends V> function0) {
            if (function0 != null) {
                return invoke(new g(k, function0));
            }
            m9985a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$f */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public interface f {

        /* JADX INFO: renamed from: a */
        public static final f f24717a = new a();

        /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$f$a */
        /* JADX INFO: compiled from: LockBasedStorageManager.java */
        public static class a implements f {
            public RuntimeException handleException(Throwable th) {
                if (th == null) {
                    throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
                }
                throw exceptionUtils.rethrow(th);
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$g */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class g<K, V> {

        /* JADX INFO: renamed from: a */
        public final K f24718a;

        /* JADX INFO: renamed from: b */
        public final Function0<? extends V> f24719b;

        public g(K k, Function0<? extends V> function0) {
            this.f24718a = k;
            this.f24719b = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && g.class == obj.getClass() && this.f24718a.equals(((g) obj).f24718a);
        }

        public int hashCode() {
            return this.f24718a.hashCode();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$h */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class h<T> implements storage6<T> {

        /* JADX INFO: renamed from: j */
        public final LockBasedStorageManager f24720j;

        /* JADX INFO: renamed from: k */
        public final Function0<? extends T> f24721k;

        /* JADX INFO: renamed from: l */
        public volatile Object f24722l;

        public h(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                m9986a(0);
                throw null;
            }
            if (function0 == null) {
                m9986a(1);
                throw null;
            }
            this.f24722l = n.NOT_COMPUTED;
            this.f24720j = lockBasedStorageManager;
            this.f24721k = function0;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9986a(int i) {
            String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i != 2 && i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        /* JADX INFO: renamed from: b */
        public void mo9987b(T t) {
        }

        /* JADX INFO: renamed from: c */
        public o<T> mo9982c(boolean z2) {
            o<T> oVarMo9980c = this.f24720j.mo9980c("in a lazy value", null);
            if (oVarMo9980c != null) {
                return oVarMo9980c;
            }
            m9986a(2);
            throw null;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004e A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #1 {all -> 0x007f, blocks: (B:7:0x0016, B:9:0x001c, B:13:0x002a, B:15:0x0037, B:17:0x003e, B:19:0x0049, B:20:0x004e, B:24:0x005d, B:26:0x0063, B:28:0x0067, B:29:0x006d, B:30:0x0077, B:31:0x0078, B:32:0x007e, B:21:0x0050), top: B:38:0x0016, inners: #0 }] */
        @Override // kotlin.jvm.functions.Function0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public T invoke() {
            T tInvoke;
            n nVar = n.RECURSION_WAS_DETECTED;
            n nVar2 = n.COMPUTING;
            Object obj = this.f24722l;
            if (!(obj instanceof n)) {
                return (T) WrappedValues.unescapeThrowable(obj);
            }
            this.f24720j.f24711c.lock();
            try {
                Object obj2 = this.f24722l;
                if (!(obj2 instanceof n)) {
                    tInvoke = (T) WrappedValues.unescapeThrowable(obj2);
                } else if (obj2 == nVar2) {
                    this.f24722l = nVar;
                    o<T> oVarMo9982c = mo9982c(true);
                    if (!oVarMo9982c.isFallThrough()) {
                        tInvoke = oVarMo9982c.getValue();
                    } else if (obj2 == nVar) {
                        o<T> oVarMo9982c2 = mo9982c(false);
                        if (oVarMo9982c2.isFallThrough()) {
                            this.f24722l = nVar2;
                            try {
                                tInvoke = this.f24721k.invoke();
                                mo9987b(tInvoke);
                                this.f24722l = tInvoke;
                            } catch (Throwable th) {
                                if (exceptionUtils.isProcessCanceledException(th)) {
                                    this.f24722l = n.NOT_COMPUTED;
                                    throw th;
                                }
                                if (this.f24722l == nVar2) {
                                    this.f24722l = WrappedValues.escapeThrowable(th);
                                }
                                throw ((f.a) this.f24720j.f24712d).handleException(th);
                            }
                        } else {
                            tInvoke = oVarMo9982c2.getValue();
                        }
                    }
                }
                return tInvoke;
            } finally {
                this.f24720j.f24711c.unlock();
            }
        }

        public boolean isComputed() {
            return (this.f24722l == n.NOT_COMPUTED || this.f24722l == n.COMPUTING) ? false : true;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$i */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static abstract class i<T> extends h<T> {

        /* JADX INFO: renamed from: m */
        public volatile SingleThreadValue<T> f24723m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                m9988a(0);
                throw null;
            }
            if (function0 == null) {
                m9988a(1);
                throw null;
            }
            this.f24723m = null;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9988a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.h
        /* JADX INFO: renamed from: b */
        public final void mo9987b(T t) {
            this.f24723m = new SingleThreadValue<>(t);
            try {
                c cVar = (c) this;
                if (t != null) {
                    cVar.f24716o.invoke(t);
                } else {
                    c.m9983a(2);
                    throw null;
                }
            } finally {
                this.f24723m = null;
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.h, kotlin.jvm.functions.Function0
        public T invoke() {
            SingleThreadValue<T> singleThreadValue = this.f24723m;
            return (singleThreadValue == null || !singleThreadValue.hasValue()) ? (T) super.invoke() : singleThreadValue.getValue();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$j */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class j<T> extends h<T> implements storage5<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                m9989a(0);
                throw null;
            }
            if (function0 != null) {
            } else {
                m9989a(1);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9989a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.h, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t != null) {
                return t;
            }
            m9989a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$k */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static abstract class k<T> extends i<T> implements storage5<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(LockBasedStorageManager lockBasedStorageManager, Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                m9990a(0);
                throw null;
            }
            if (function0 != null) {
            } else {
                m9990a(1);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9990a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.i, p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.h, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t != null) {
                return t;
            }
            m9990a(2);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$l */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class l<K, V> implements storage4<K, V> {

        /* JADX INFO: renamed from: j */
        public final LockBasedStorageManager f24724j;

        /* JADX INFO: renamed from: k */
        public final ConcurrentMap<K, Object> f24725k;

        /* JADX INFO: renamed from: l */
        public final Function1<? super K, ? extends V> f24726l;

        public l(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                m9991a(0);
                throw null;
            }
            if (concurrentMap == null) {
                m9991a(1);
                throw null;
            }
            if (function1 == null) {
                m9991a(2);
                throw null;
            }
            this.f24724j = lockBasedStorageManager;
            this.f24725k = concurrentMap;
            this.f24726l = function1;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9991a(int i) {
            String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        /* JADX INFO: renamed from: b */
        public final AssertionError m9992b(K k, Object obj) {
            AssertionError assertionError = new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.f24724j);
            LockBasedStorageManager.m9979d(assertionError);
            return assertionError;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0041 A[Catch: all -> 0x00c2, TryCatch #0 {all -> 0x00c2, blocks: (B:8:0x001a, B:11:0x0026, B:13:0x002e, B:15:0x0034, B:17:0x003b, B:18:0x003e, B:20:0x0041, B:22:0x0049, B:24:0x004f, B:25:0x0054, B:26:0x0057, B:28:0x005a, B:38:0x008b, B:41:0x0093, B:43:0x009f, B:44:0x00a3, B:45:0x00a4, B:46:0x00ae, B:47:0x00af, B:48:0x00b9, B:49:0x00ba, B:50:0x00c1, B:31:0x0066, B:35:0x0085, B:36:0x0089), top: B:54:0x001a, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
        @Override // kotlin.jvm.functions.Function1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public V invoke(K k) {
            V value;
            n nVar = n.RECURSION_WAS_DETECTED;
            n nVar2 = n.COMPUTING;
            Object obj = this.f24725k.get(k);
            if (obj != null && obj != nVar2) {
                return (V) WrappedValues.unescapeExceptionOrNull(obj);
            }
            this.f24724j.f24711c.lock();
            try {
                Object obj2 = this.f24725k.get(k);
                AssertionError assertionErrorM9992b = null;
                if (obj2 == nVar2) {
                    o<V> oVarMo9980c = this.f24724j.mo9980c("", k);
                    if (oVarMo9980c == null) {
                        m9991a(3);
                        throw null;
                    }
                    if (oVarMo9980c.isFallThrough()) {
                        obj2 = nVar;
                        if (obj2 == nVar) {
                        }
                    } else {
                        value = oVarMo9980c.getValue();
                    }
                } else if (obj2 == nVar) {
                    o<V> oVarMo9980c2 = this.f24724j.mo9980c("", k);
                    if (oVarMo9980c2 == null) {
                        m9991a(3);
                        throw null;
                    }
                    if (!oVarMo9980c2.isFallThrough()) {
                        value = oVarMo9980c2.getValue();
                    }
                } else {
                    if (obj2 == null) {
                        try {
                            this.f24725k.put(k, nVar2);
                            V vInvoke = this.f24726l.invoke(k);
                            Object objPut = this.f24725k.put(k, WrappedValues.escapeNull(vInvoke));
                            if (objPut == nVar2) {
                                return vInvoke;
                            }
                            assertionErrorM9992b = m9992b(k, objPut);
                            throw assertionErrorM9992b;
                        } catch (Throwable th) {
                            if (exceptionUtils.isProcessCanceledException(th)) {
                                this.f24725k.remove(k);
                                throw th;
                            }
                            if (th == assertionErrorM9992b) {
                                throw ((f.a) this.f24724j.f24712d).handleException(th);
                            }
                            Object objPut2 = this.f24725k.put(k, WrappedValues.escapeThrowable(th));
                            if (objPut2 != nVar2) {
                                throw m9992b(k, objPut2);
                            }
                            throw ((f.a) this.f24724j.f24712d).handleException(th);
                        }
                    }
                    value = (V) WrappedValues.unescapeExceptionOrNull(obj2);
                }
                return value;
            } finally {
                this.f24724j.f24711c.unlock();
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$m */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class m<K, V> extends l<K, V> implements storage3<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                m9993a(0);
                throw null;
            }
            if (concurrentMap == null) {
                m9993a(1);
                throw null;
            }
            if (function1 != null) {
            } else {
                m9993a(2);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m9993a(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(str2);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager.l, kotlin.jvm.functions.Function1
        public V invoke(K k) {
            V v = (V) super.invoke(k);
            if (v != null) {
                return v;
            }
            m9993a(3);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$n */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.m.f$o */
    /* JADX INFO: compiled from: LockBasedStorageManager.java */
    public static class o<T> {

        /* JADX INFO: renamed from: a */
        public final T f24731a;

        /* JADX INFO: renamed from: b */
        public final boolean f24732b;

        public o(T t, boolean z2) {
            this.f24731a = t;
            this.f24732b = z2;
        }

        public static <T> o<T> fallThrough() {
            return new o<>(null, true);
        }

        public static <T> o<T> value(T t) {
            return new o<>(t, false);
        }

        public T getValue() {
            return this.f24731a;
        }

        public boolean isFallThrough() {
            return this.f24732b;
        }

        public String toString() {
            return isFallThrough() ? "FALL_THROUGH" : String.valueOf(this.f24731a);
        }
    }

    public LockBasedStorageManager(String str, f fVar, locks4 locks4Var) {
        if (str == null) {
            m9977a(4);
            throw null;
        }
        if (fVar == null) {
            m9977a(5);
            throw null;
        }
        if (locks4Var == null) {
            m9977a(6);
            throw null;
        }
        this.f24711c = locks4Var;
        this.f24712d = fVar;
        this.f24713e = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void m9977a(int i2) {
        String str = (i2 == 10 || i2 == 13 || i2 == 20 || i2 == 37) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 10 || i2 == 13 || i2 == 20 || i2 == 37) ? 2 : 3];
        if (i2 == 1 || i2 == 3 || i2 == 5) {
            objArr[0] = "exceptionHandlingStrategy";
        } else if (i2 != 6) {
            switch (i2) {
                case 8:
                    break;
                case 9:
                case 11:
                case 14:
                case 16:
                case 19:
                case 21:
                    objArr[0] = "compute";
                    break;
                case 10:
                case 13:
                case 20:
                case 37:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                    break;
                case 12:
                case 17:
                case 25:
                case 27:
                    objArr[0] = "onRecursiveCall";
                    break;
                case 15:
                case 18:
                case 22:
                    objArr[0] = "map";
                    break;
                case 23:
                case 24:
                case 26:
                case 28:
                case 30:
                case 31:
                case 32:
                case 34:
                    objArr[0] = "computable";
                    break;
                case 29:
                case 33:
                    objArr[0] = "postCompute";
                    break;
                case 35:
                    objArr[0] = "source";
                    break;
                case 36:
                    objArr[0] = "throwable";
                    break;
                default:
                    objArr[0] = "debugText";
                    break;
            }
        } else {
            objArr[0] = "lock";
        }
        if (i2 == 10 || i2 == 13) {
            objArr[1] = "createMemoizedFunction";
        } else if (i2 == 20) {
            objArr[1] = "createMemoizedFunctionWithNullableValues";
        } else if (i2 != 37) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        } else {
            objArr[1] = "sanitizeStackTrace";
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "<init>";
                break;
            case 7:
            case 8:
                objArr[2] = "replaceExceptionHandling";
                break;
            case 9:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createMemoizedFunction";
                break;
            case 10:
            case 13:
            case 20:
            case 37:
                break;
            case 19:
            case 21:
            case 22:
                objArr[2] = "createMemoizedFunctionWithNullableValues";
                break;
            case 23:
            case 24:
            case 25:
                objArr[2] = "createLazyValue";
                break;
            case 26:
            case 27:
                objArr[2] = "createRecursionTolerantLazyValue";
                break;
            case 28:
            case 29:
                objArr[2] = "createLazyValueWithPostCompute";
                break;
            case 30:
                objArr[2] = "createNullableLazyValue";
                break;
            case 31:
                objArr[2] = "createRecursionTolerantNullableLazyValue";
                break;
            case 32:
            case 33:
                objArr[2] = "createNullableLazyValueWithPostCompute";
                break;
            case 34:
                objArr[2] = "compute";
                break;
            case 35:
                objArr[2] = "recursionDetectedDefault";
                break;
            case 36:
                objArr[2] = "sanitizeStackTrace";
                break;
            default:
                objArr[2] = "createWithExceptionHandling";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 10 && i2 != 13 && i2 != 20 && i2 != 37) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    /* JADX INFO: renamed from: b */
    public static <K> ConcurrentMap<K, Object> m9978b() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: renamed from: d */
    public static <T extends Throwable> T m9979d(T t) {
        if (t == null) {
            m9977a(36);
            throw null;
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (!stackTrace[i3].getClassName().startsWith(f24709a)) {
                i2 = i3;
                break;
            }
            i3++;
        }
        List listSubList = Arrays.asList(stackTrace).subList(i2, length);
        t.setStackTrace((StackTraceElement[]) listSubList.toArray(new StackTraceElement[listSubList.size()]));
        return t;
    }

    /* JADX INFO: renamed from: c */
    public <K, V> o<V> mo9980c(String str, K k2) {
        StringBuilder sbM836X = outline.m836X("Recursion detected ", str);
        sbM836X.append(k2 == null ? "" : outline.m881v("on input: ", k2));
        sbM836X.append(" under ");
        sbM836X.append(this);
        AssertionError assertionError = new AssertionError(sbM836X.toString());
        m9979d(assertionError);
        throw assertionError;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <T> T compute(Function0<? extends T> function0) {
        if (function0 == null) {
            m9977a(34);
            throw null;
        }
        this.f24711c.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <K, V> storage<K, V> createCacheWithNotNullValues() {
        return new d(this, m9978b(), null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <K, V> storage2<K, V> createCacheWithNullableValues() {
        return new e(this, m9978b(), null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <T> storage5<T> createLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new j(this, function0);
        }
        m9977a(23);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <T> storage5<T> createLazyValueWithPostCompute(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, Unit> function12) {
        if (function0 == null) {
            m9977a(28);
            throw null;
        }
        if (function12 != null) {
            return new c(this, this, function0, function1, function12);
        }
        m9977a(29);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <K, V> storage3<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            m9977a(9);
            throw null;
        }
        storage3<K, V> storage3VarCreateMemoizedFunction = createMemoizedFunction(function1, m9978b());
        if (storage3VarCreateMemoizedFunction != null) {
            return storage3VarCreateMemoizedFunction;
        }
        m9977a(10);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <K, V> storage4<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            m9977a(19);
            throw null;
        }
        storage4<K, V> storage4VarCreateMemoizedFunctionWithNullableValues = createMemoizedFunctionWithNullableValues(function1, m9978b());
        if (storage4VarCreateMemoizedFunctionWithNullableValues != null) {
            return storage4VarCreateMemoizedFunctionWithNullableValues;
        }
        m9977a(20);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <T> storage6<T> createNullableLazyValue(Function0<? extends T> function0) {
        if (function0 != null) {
            return new h(this, function0);
        }
        m9977a(30);
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager
    public <T> storage5<T> createRecursionTolerantLazyValue(Function0<? extends T> function0, T t) {
        if (function0 == null) {
            m9977a(26);
            throw null;
        }
        if (t != null) {
            return new b(this, this, function0, t);
        }
        m9977a(27);
        throw null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" (");
        return outline.m822J(sb, this.f24713e, ")");
    }

    public <K, V> storage3<K, V> createMemoizedFunction(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            m9977a(14);
            throw null;
        }
        if (concurrentMap != null) {
            return new m(this, concurrentMap, function1);
        }
        m9977a(15);
        throw null;
    }

    public <K, V> storage4<K, V> createMemoizedFunctionWithNullableValues(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            m9977a(21);
            throw null;
        }
        if (concurrentMap != null) {
            return new l(this, concurrentMap, function1);
        }
        m9977a(22);
        throw null;
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, Unit>) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LockBasedStorageManager(String str, Runnable runnable, Function1<InterruptedException, Unit> function1) {
        f fVar = f.f24717a;
        int i2 = locks4.f24733a;
        this(str, fVar, locks4.a.f24734a.simpleLock(runnable, function1));
    }
}
