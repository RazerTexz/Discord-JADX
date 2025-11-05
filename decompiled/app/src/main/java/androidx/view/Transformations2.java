package androidx.view;

import androidx.arch.core.util.Function;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: Transformations.kt */
/* renamed from: androidx.lifecycle.TransformationsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Transformations2 {

    /* JADX INFO: Add missing generic type declarations: [X, Y] */
    /* compiled from: Transformations.kt */
    /* renamed from: androidx.lifecycle.TransformationsKt$map$1, reason: invalid class name */
    public static final class AnonymousClass1<I, O, X, Y> implements Function<X, Y> {
        public final /* synthetic */ Function1 $transform;

        public AnonymousClass1(Function1 function1) {
            this.$transform = function1;
        }

        @Override // androidx.arch.core.util.Function
        public final Y apply(X x2) {
            return (Y) this.$transform.invoke(x2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X, Y] */
    /* compiled from: Transformations.kt */
    /* renamed from: androidx.lifecycle.TransformationsKt$switchMap$1, reason: invalid class name */
    public static final class AnonymousClass1<I, O, X, Y> implements Function<X, LiveData<Y>> {
        public final /* synthetic */ Function1 $transform;

        public AnonymousClass1(Function1 function1) {
            this.$transform = function1;
        }

        @Override // androidx.arch.core.util.Function
        public final LiveData<Y> apply(X x2) {
            return (LiveData) this.$transform.invoke(x2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.arch.core.util.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) {
            return apply((AnonymousClass1<I, O, X, Y>) obj);
        }
    }

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$distinctUntilChanged");
        LiveData<X> liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(liveData);
        Intrinsics3.checkNotNullExpressionValue(liveDataDistinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return liveDataDistinctUntilChanged;
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, Function1<? super X, ? extends Y> function1) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$map");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        LiveData<Y> map = Transformations.map(liveData, new AnonymousClass1(function1));
        Intrinsics3.checkNotNullExpressionValue(map, "Transformations.map(this) { transform(it) }");
        return map;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, Function1<? super X, ? extends LiveData<Y>> function1) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$switchMap");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        LiveData<Y> liveDataSwitchMap = Transformations.switchMap(liveData, new AnonymousClass1(function1));
        Intrinsics3.checkNotNullExpressionValue(liveDataSwitchMap, "Transformations.switchMap(this) { transform(it) }");
        return liveDataSwitchMap;
    }
}
