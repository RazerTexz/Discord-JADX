package androidx.view;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope, reason: use source file name */
/* JADX INFO: compiled from: Lifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle2 implements CoroutineScope {

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1 */
    /* JADX INFO: compiled from: Lifecycle.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", m10085f = "Lifecycle.kt", m10086l = {74}, m10087m = "invokeSuspend")
    public static final class C04381 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function2 $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04381(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return Lifecycle2.this.new C04381(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04381) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = Lifecycle2.this.getLifecycle();
                Function2 function2 = this.$block;
                this.label = 1;
                if (PausingDispatcher2.whenCreated(lifecycle$lifecycle_runtime_ktx_release, function2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1 */
    /* JADX INFO: compiled from: Lifecycle.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", m10085f = "Lifecycle.kt", m10086l = {99}, m10087m = "invokeSuspend")
    public static final class C04391 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function2 $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04391(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return Lifecycle2.this.new C04391(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04391) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = Lifecycle2.this.getLifecycle();
                Function2 function2 = this.$block;
                this.label = 1;
                if (PausingDispatcher2.whenResumed(lifecycle$lifecycle_runtime_ktx_release, function2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1 */
    /* JADX INFO: compiled from: Lifecycle.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", m10085f = "Lifecycle.kt", m10086l = {87}, m10087m = "invokeSuspend")
    public static final class C04401 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function2 $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04401(Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return Lifecycle2.this.new C04401(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04401) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = Lifecycle2.this.getLifecycle();
                Function2 function2 = this.$block;
                this.label = 1;
                if (PausingDispatcher2.whenStarted(lifecycle$lifecycle_runtime_ktx_release, function2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public abstract /* synthetic */ CoroutineContext getCoroutineContext();

    /* JADX INFO: renamed from: getLifecycle$lifecycle_runtime_ktx_release */
    public abstract Lifecycle getLifecycle();

    public final Job launchWhenCreated(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics3.checkNotNullParameter(block, "block");
        return C3404f.m4211H0(this, null, null, new C04381(block, null), 3, null);
    }

    public final Job launchWhenResumed(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics3.checkNotNullParameter(block, "block");
        return C3404f.m4211H0(this, null, null, new C04391(block, null), 3, null);
    }

    public final Job launchWhenStarted(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics3.checkNotNullParameter(block, "block");
        return C3404f.m4211H0(this, null, null, new C04401(block, null), 3, null);
    }
}
