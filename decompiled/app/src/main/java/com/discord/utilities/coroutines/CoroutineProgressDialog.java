package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.appcompat.app.AlertDialog;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;
import p659s.p660a.MainCoroutineDispatcher;
import p659s.p660a.NonCancellable;
import p659s.p660a.p661a.MainDispatchers;

/* JADX INFO: compiled from: CoroutineProgressDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CoroutineProgressDialog {
    public static final CoroutineProgressDialog INSTANCE = new CoroutineProgressDialog();

    /* JADX INFO: renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$1 */
    /* JADX INFO: compiled from: CoroutineProgressDialog.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.coroutines.CoroutineProgressDialog", m10085f = "CoroutineProgressDialog.kt", m10086l = {22, 32, 34, 34}, m10087m = "withCancellableProgressDialog")
    public static final class C67371 extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;
        public /* synthetic */ Object result;

        public C67371(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CoroutineProgressDialog.this.withCancellableProgressDialog(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$2 */
    /* JADX INFO: compiled from: CoroutineProgressDialog.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.coroutines.CoroutineProgressDialog$withCancellableProgressDialog$2", m10085f = "CoroutineProgressDialog.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C67382 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Ref$ObjectRef $dialog;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67382(Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
            super(2, continuation);
            this.$dialog = ref$ObjectRef;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new C67382(this.$dialog, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C67382) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            ((AlertDialog) this.$dialog.element).dismiss();
            return Unit.f27425a;
        }
    }

    private CoroutineProgressDialog() {
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r14v5, types: [T, androidx.appcompat.app.AlertDialog] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <Result> Object withCancellableProgressDialog(Context context, Function1<? super Continuation<? super Result>, ? extends Object> function1, Continuation<? super Result> continuation) {
        C67371 c67371;
        Ref$ObjectRef ref$ObjectRef;
        Function1<? super Continuation<? super Result>, ? extends Object> function12;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        CoroutineContext coroutineContextPlus;
        C67382 c67382;
        if (continuation instanceof C67371) {
            c67371 = (C67371) continuation;
            int i = c67371.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c67371.label = i - Integer.MIN_VALUE;
            } else {
                c67371 = new C67371(continuation);
            }
        }
        Object objM4197C1 = c67371.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = c67371.label;
        try {
            if (i2 == 0) {
                Result3.throwOnFailure(objM4197C1);
                CoroutineContext context2 = c67371.getContext();
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
                MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
                CoroutineProgressDialog2 coroutineProgressDialog2 = new CoroutineProgressDialog2(context, context2, null);
                c67371.L$0 = function1;
                c67371.L$1 = ref$ObjectRef4;
                c67371.L$2 = ref$ObjectRef4;
                c67371.label = 1;
                objM4197C1 = C3404f.m4197C1(mainCoroutineDispatcherMo11194H, coroutineProgressDialog2, c67371);
                if (objM4197C1 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                ref$ObjectRef = ref$ObjectRef4;
                function12 = function1;
                ref$ObjectRef2 = ref$ObjectRef;
            } else if (i2 == 1) {
                ref$ObjectRef = (Ref$ObjectRef) c67371.L$2;
                ref$ObjectRef2 = (Ref$ObjectRef) c67371.L$1;
                function12 = (Function1) c67371.L$0;
                Result3.throwOnFailure(objM4197C1);
            } else {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Object obj = c67371.L$0;
                        Result3.throwOnFailure(objM4197C1);
                        return obj;
                    }
                    if (i2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) c67371.L$0;
                    Result3.throwOnFailure(objM4197C1);
                    throw th;
                }
                ref$ObjectRef3 = (Ref$ObjectRef) c67371.L$0;
                try {
                    Result3.throwOnFailure(objM4197C1);
                    CoroutineDispatcher coroutineDispatcher2 = Dispatchers.f27866a;
                    CoroutineContext coroutineContextPlus2 = MainDispatchers.f27700b.mo11194H().plus(NonCancellable.f27877j);
                    C67382 c673822 = new C67382(ref$ObjectRef3, null);
                    c67371.L$0 = objM4197C1;
                    c67371.label = 3;
                    return C3404f.m4197C1(coroutineContextPlus2, c673822, c67371) != coroutine_suspended ? coroutine_suspended : objM4197C1;
                } catch (Throwable th2) {
                    ref$ObjectRef2 = ref$ObjectRef3;
                    th = th2;
                    CoroutineDispatcher coroutineDispatcher3 = Dispatchers.f27866a;
                    coroutineContextPlus = MainDispatchers.f27700b.mo11194H().plus(NonCancellable.f27877j);
                    c67382 = new C67382(ref$ObjectRef2, null);
                    c67371.L$0 = th;
                    c67371.L$1 = null;
                    c67371.L$2 = null;
                    c67371.label = 4;
                    if (C3404f.m4197C1(coroutineContextPlus, c67382, c67371) != coroutine_suspended) {
                    }
                }
            }
            c67371.L$0 = ref$ObjectRef2;
            c67371.L$1 = null;
            c67371.L$2 = null;
            c67371.label = 2;
            objM4197C1 = function12.invoke(c67371);
            if (objM4197C1 == coroutine_suspended) {
                return coroutine_suspended;
            }
            ref$ObjectRef3 = ref$ObjectRef2;
            CoroutineDispatcher coroutineDispatcher22 = Dispatchers.f27866a;
            CoroutineContext coroutineContextPlus22 = MainDispatchers.f27700b.mo11194H().plus(NonCancellable.f27877j);
            C67382 c6738222 = new C67382(ref$ObjectRef3, null);
            c67371.L$0 = objM4197C1;
            c67371.label = 3;
            if (C3404f.m4197C1(coroutineContextPlus22, c6738222, c67371) != coroutine_suspended) {
            }
        } catch (Throwable th3) {
            th = th3;
            CoroutineDispatcher coroutineDispatcher32 = Dispatchers.f27866a;
            coroutineContextPlus = MainDispatchers.f27700b.mo11194H().plus(NonCancellable.f27877j);
            c67382 = new C67382(ref$ObjectRef2, null);
            c67371.L$0 = th;
            c67371.L$1 = null;
            c67371.L$2 = null;
            c67371.label = 4;
            if (C3404f.m4197C1(coroutineContextPlus, c67382, c67371) != coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th;
        }
        ref$ObjectRef.element = (AlertDialog) objM4197C1;
    }
}
