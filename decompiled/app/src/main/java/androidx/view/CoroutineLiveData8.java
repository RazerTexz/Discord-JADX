package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;
import p659s.p660a.Job2;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: CoroutineLiveData.kt */
/* renamed from: androidx.lifecycle.LiveDataScopeImpl, reason: use source file name */
/* loaded from: classes.dex */
public final class CoroutineLiveData8<T> implements CoroutineLiveData7<T> {
    private final CoroutineContext coroutineContext;
    private CoroutineLiveData<T> target;

    /* compiled from: CoroutineLiveData.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", m10085f = "CoroutineLiveData.kt", m10086l = {98}, m10087m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LiveDataScopeImpl$emit$2 */
    public static final class C04442 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Object $value;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04442(Object obj, Continuation continuation) {
            super(2, continuation);
            this.$value = obj;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C04442(this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04442) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CoroutineLiveData<T> target$lifecycle_livedata_ktx_release = CoroutineLiveData8.this.getTarget$lifecycle_livedata_ktx_release();
                this.label = 1;
                if (target$lifecycle_livedata_ktx_release.clearSource$lifecycle_livedata_ktx_release(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            CoroutineLiveData8.this.getTarget$lifecycle_livedata_ktx_release().setValue(this.$value);
            return Unit.f27425a;
        }
    }

    /* compiled from: CoroutineLiveData.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", m10085f = "CoroutineLiveData.kt", m10086l = {94}, m10087m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LiveDataScopeImpl$emitSource$2 */
    public static final class C04452 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Job2>, Object> {
        public final /* synthetic */ LiveData $source;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04452(LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$source = liveData;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C04452(this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job2> continuation) {
            return ((C04452) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CoroutineLiveData<T> target$lifecycle_livedata_ktx_release = CoroutineLiveData8.this.getTarget$lifecycle_livedata_ktx_release();
                LiveData<T> liveData = this.$source;
                this.label = 1;
                obj = target$lifecycle_livedata_ktx_release.emitSource$lifecycle_livedata_ktx_release(liveData, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return obj;
        }
    }

    public CoroutineLiveData8(CoroutineLiveData<T> coroutineLiveData, CoroutineContext coroutineContext) {
        Intrinsics3.checkNotNullParameter(coroutineLiveData, "target");
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        this.target = coroutineLiveData;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        this.coroutineContext = coroutineContext.plus(MainDispatchers.f27700b.mo11194H());
    }

    @Override // androidx.view.CoroutineLiveData7
    public Object emit(T t, Continuation<? super Unit> continuation) throws Throwable {
        Object objM4197C1 = C3404f.m4197C1(this.coroutineContext, new C04442(t, null), continuation);
        return objM4197C1 == Intrinsics2.getCOROUTINE_SUSPENDED() ? objM4197C1 : Unit.f27425a;
    }

    @Override // androidx.view.CoroutineLiveData7
    public Object emitSource(LiveData<T> liveData, Continuation<? super Job2> continuation) {
        return C3404f.m4197C1(this.coroutineContext, new C04452(liveData, null), continuation);
    }

    @Override // androidx.view.CoroutineLiveData7
    public T getLatestValue() {
        return this.target.getValue();
    }

    public final CoroutineLiveData<T> getTarget$lifecycle_livedata_ktx_release() {
        return this.target;
    }

    public final void setTarget$lifecycle_livedata_ktx_release(CoroutineLiveData<T> coroutineLiveData) {
        Intrinsics3.checkNotNullParameter(coroutineLiveData, "<set-?>");
        this.target = coroutineLiveData;
    }
}
