package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import androidx.view.Lifecycle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt, reason: use source file name */
/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcher2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2 */
    /* JADX INFO: compiled from: PausingDispatcher.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", m10085f = "PausingDispatcher.kt", m10086l = {Opcodes.IF_ICMPGE}, m10087m = "invokeSuspend")
    public static final class C04462<T> extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        public final /* synthetic */ Function2 $block;
        public final /* synthetic */ Lifecycle.State $minState;
        public final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04462(Lifecycle lifecycle, Lifecycle.State state, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = function2;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            C04462 c04462 = new C04462(this.$this_whenStateAtLeast, this.$minState, this.$block, continuation);
            c04462.L$0 = obj;
            return c04462;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Object obj) {
            return ((C04462) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LifecycleController lifecycleController;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    Result3.throwOnFailure(obj);
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            }
            Result3.throwOnFailure(obj);
            Job job = (Job) ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.INSTANCE);
            if (job == null) {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, job);
            try {
                Function2 function2 = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = C3404f.m4197C1(pausingDispatcher, function2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        }
    }

    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return whenCreated(lifecycle, function2, continuation);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return whenResumed(lifecycle, function2, continuation);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return whenStarted(lifecycle, function2, continuation);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        return C3404f.m4197C1(MainDispatchers.f27700b.mo11194H(), new C04462(lifecycle, state, function2, null), continuation);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, function2, continuation);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, function2, continuation);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, function2, continuation);
    }
}
