package androidx.view;

import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.time.Duration;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: CoroutineLiveData.kt */
/* renamed from: androidx.lifecycle.CoroutineLiveDataKt, reason: use source file name */
/* loaded from: classes.dex */
public final class CoroutineLiveData5 {
    public static final long DEFAULT_TIMEOUT = 5000;

    /* compiled from: CoroutineLiveData.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", m10085f = "CoroutineLiveData.kt", m10086l = {}, m10087m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2 */
    public static final class C04302 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super CoroutineLiveData6>, Object> {
        public final /* synthetic */ LiveData $source;
        public final /* synthetic */ MediatorLiveData $this_addDisposableSource;
        public int label;

        /* compiled from: CoroutineLiveData.kt */
        /* renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Observer<T> {
            public AnonymousClass1() {
            }

            @Override // androidx.view.Observer
            public final void onChanged(T t) {
                C04302.this.$this_addDisposableSource.setValue(t);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04302(MediatorLiveData mediatorLiveData, LiveData liveData, Continuation continuation) {
            super(2, continuation);
            this.$this_addDisposableSource = mediatorLiveData;
            this.$source = liveData;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C04302(this.$this_addDisposableSource, this.$source, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CoroutineLiveData6> continuation) {
            return ((C04302) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            this.$this_addDisposableSource.addSource(this.$source, new AnonymousClass1());
            return new CoroutineLiveData6(this.$source, this.$this_addDisposableSource);
        }
    }

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, Continuation<? super CoroutineLiveData6> continuation) {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        return C3404f.m4197C1(MainDispatchers.f27700b.mo11194H(), new C04302(mediatorLiveData, liveData, null), continuation);
    }

    public static final <T> LiveData<T> liveData(CoroutineContext coroutineContext, long j, Function2<? super CoroutineLiveData7<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(function2, "block");
        return new CoroutineLiveData(coroutineContext, j, function2);
    }

    public static /* synthetic */ LiveData liveData$default(CoroutineContext coroutineContext, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextImpl4.f25237j;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return liveData(coroutineContext, j, function2);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(CoroutineContext coroutineContext, Duration duration, Function2<? super CoroutineLiveData7<T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics3.checkNotNullParameter(coroutineContext, "context");
        Intrinsics3.checkNotNullParameter(duration, "timeout");
        Intrinsics3.checkNotNullParameter(function2, "block");
        return new CoroutineLiveData(coroutineContext, duration.toMillis(), function2);
    }

    public static /* synthetic */ LiveData liveData$default(CoroutineContext coroutineContext, Duration duration, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = CoroutineContextImpl4.f25237j;
        }
        return liveData(coroutineContext, duration, function2);
    }
}
