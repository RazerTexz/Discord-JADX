package androidx.core.util;

import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LruCache.kt */
/* renamed from: androidx.core.util.LruCacheKt, reason: use source file name */
/* loaded from: classes.dex */
public final class LruCache3 {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$1 */
    public static final class C02641<K, V> extends Lambda implements Function2<K, V, Integer> {
        public static final C02641 INSTANCE = new C02641();

        public C02641() {
            super(2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(K k, V v) {
            Intrinsics3.checkNotNullParameter(k, "$noName_0");
            Intrinsics3.checkNotNullParameter(v, "$noName_1");
            return 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
            return Integer.valueOf(invoke2(obj, obj2));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$2 */
    public static final class C02652<K, V> extends Lambda implements Function1<K, V> {
        public static final C02652 INSTANCE = new C02652();

        public C02652() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final V invoke(K k) {
            Intrinsics3.checkNotNullParameter(k, "it");
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$3 */
    public static final class C02663<K, V> extends Lambda implements Function4<Boolean, K, V, V, Unit> {
        public static final C02663 INSTANCE = new C02663();

        public C02663() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
            invoke(bool.booleanValue(), obj, obj2, obj3);
            return Unit.f27425a;
        }

        public final void invoke(boolean z2, K k, V v, V v2) {
            Intrinsics3.checkNotNullParameter(k, "$noName_1");
            Intrinsics3.checkNotNullParameter(v, "$noName_2");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$4 */
    public static final class C02674<K, V> extends LruCache<K, V> {
        public final /* synthetic */ Function1<K, V> $create;
        public final /* synthetic */ int $maxSize;
        public final /* synthetic */ Function4<Boolean, K, V, V, Unit> $onEntryRemoved;
        public final /* synthetic */ Function2<K, V, Integer> $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C02674(Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4, int i) {
            super(i);
            this.$sizeOf = function2;
            this.$create = function1;
            this.$onEntryRemoved = function4;
            this.$maxSize = i;
        }

        @Override // android.util.LruCache
        public V create(K key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return this.$create.invoke(key);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
            Intrinsics3.checkNotNullParameter(key, "key");
            Intrinsics3.checkNotNullParameter(oldValue, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
        }

        @Override // android.util.LruCache
        public int sizeOf(K key, V value) {
            Intrinsics3.checkNotNullParameter(key, "key");
            Intrinsics3.checkNotNullParameter(value, "value");
            return this.$sizeOf.invoke(key, value).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int i, Function2<? super K, ? super V, Integer> function2, Function1<? super K, ? extends V> function1, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> function4) {
        Intrinsics3.checkNotNullParameter(function2, "sizeOf");
        Intrinsics3.checkNotNullParameter(function1, "create");
        Intrinsics3.checkNotNullParameter(function4, "onEntryRemoved");
        return new C02674(function2, function1, function4, i);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, Function2 function2, Function1 function1, Function4 function4, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function2 = C02641.INSTANCE;
        }
        if ((i2 & 4) != 0) {
            function1 = C02652.INSTANCE;
        }
        if ((i2 & 8) != 0) {
            function4 = C02663.INSTANCE;
        }
        Intrinsics3.checkNotNullParameter(function2, "sizeOf");
        Intrinsics3.checkNotNullParameter(function1, "create");
        Intrinsics3.checkNotNullParameter(function4, "onEntryRemoved");
        return new C02674(function2, function1, function4, i);
    }
}
