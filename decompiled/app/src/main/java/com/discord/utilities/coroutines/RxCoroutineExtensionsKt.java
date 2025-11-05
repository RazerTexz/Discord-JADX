package com.discord.utilities.coroutines;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import com.discord.utilities.coroutines.AppErrorTag;
import com.discord.utilities.error.AppCancellationException;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.RxCoroutineUtilsKt;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import s.a.a.n;
import s.a.k0;
import s.a.l1;

/* compiled from: RxCoroutineExtensions.kt */
/* loaded from: classes2.dex */
public final class RxCoroutineExtensionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RxCoroutineExtensions.kt */
    @e(c = "com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2", f = "RxCoroutineExtensions.kt", l = {35, 40}, m = "invokeSuspend")
    /* renamed from: com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends k implements Function2<CoroutineScope, Continuation<? super T>, Object> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ Boolean $suppressToast;
        public final /* synthetic */ Observable $this_appAwaitSingle;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public int label;

        /* compiled from: RxCoroutineExtensions.kt */
        @e(c = "com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2$1", f = "RxCoroutineExtensions.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.discord.utilities.coroutines.RxCoroutineExtensionsKt$appAwaitSingle$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ Throwable $e;
            public final /* synthetic */ Ref$ObjectRef $errorTag;
            public final /* synthetic */ Ref$ObjectRef $weakContext;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Throwable th, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Continuation continuation) {
                super(2, continuation);
                this.$e = th;
                this.$errorTag = ref$ObjectRef;
                this.$weakContext = ref$ObjectRef2;
            }

            @Override // d0.w.i.a.a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                m.checkNotNullParameter(continuation, "completion");
                return new AnonymousClass1(this.$e, this.$errorTag, this.$weakContext, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                c.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
                Error.handle(this.$e, (String) this.$errorTag.element, null, (Context) ((WeakReference) this.$weakContext.element).get(), AnonymousClass2.this.$suppressToast);
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Observable observable, Context context, Boolean bool, Continuation continuation) {
            super(2, continuation);
            this.$this_appAwaitSingle = observable;
            this.$context = context;
            this.$suppressToast = bool;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_appAwaitSingle, this.$context, this.$suppressToast, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Object obj) {
            return ((AnonymousClass2) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x009a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
        @Override // d0.w.i.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            T t;
            Throwable th;
            Ref$ObjectRef ref$ObjectRef;
            Ref$ObjectRef ref$ObjectRef2;
            l1 l1Var;
            AnonymousClass1 anonymousClass1;
            Error error;
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                ref$ObjectRef3.element = (T) new WeakReference(this.$context);
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                AppErrorTag appErrorTag = (AppErrorTag) coroutineScope.getCoroutineContext().get(AppErrorTag.Key.INSTANCE);
                if (appErrorTag == null || (t = (T) appErrorTag.getErrorTag()) == null) {
                    t = (T) coroutineScope.getClass().getSimpleName();
                }
                ref$ObjectRef4.element = t;
                try {
                    Observable observable = this.$this_appAwaitSingle;
                    this.L$0 = ref$ObjectRef3;
                    this.L$1 = ref$ObjectRef4;
                    this.label = 1;
                    obj = RxCoroutineUtilsKt.awaitSingle(observable, this);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                } catch (Throwable th2) {
                    th = th2;
                    ref$ObjectRef = ref$ObjectRef3;
                    ref$ObjectRef2 = ref$ObjectRef4;
                    Error errorCreate = Error.create(th);
                    CoroutineDispatcher coroutineDispatcher = k0.a;
                    l1Var = n.f3830b;
                    anonymousClass1 = new AnonymousClass1(th, ref$ObjectRef2, ref$ObjectRef, null);
                    this.L$0 = errorCreate;
                    this.L$1 = null;
                    this.label = 2;
                    if (f.C1(l1Var, anonymousClass1, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    error = errorCreate;
                    m.checkNotNullExpressionValue(error, "error");
                    throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
                }
            }
            if (i == 1) {
                Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) this.L$1;
                Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) this.L$0;
                try {
                    l.throwOnFailure(obj);
                } catch (Throwable th3) {
                    th = th3;
                    ref$ObjectRef2 = ref$ObjectRef5;
                    ref$ObjectRef = ref$ObjectRef6;
                    Error errorCreate2 = Error.create(th);
                    CoroutineDispatcher coroutineDispatcher2 = k0.a;
                    l1Var = n.f3830b;
                    anonymousClass1 = new AnonymousClass1(th, ref$ObjectRef2, ref$ObjectRef, null);
                    this.L$0 = errorCreate2;
                    this.L$1 = null;
                    this.label = 2;
                    if (f.C1(l1Var, anonymousClass1, this) != coroutine_suspended) {
                    }
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                error = (Error) this.L$0;
                l.throwOnFailure(obj);
            }
            m.checkNotNullExpressionValue(error, "error");
            throw new AppCancellationException("Unexpected error", error.getThrowable(), error);
        }
    }

    public static final <T> Object appAwaitFirst(Observable<T> observable, Context context, Continuation<? super T> continuation) {
        Observable<T> observableZ = observable.z();
        m.checkNotNullExpressionValue(observableZ, "first()");
        return appAwaitSingle$default(observableZ, context, null, continuation, 2, null);
    }

    public static /* synthetic */ Object appAwaitFirst$default(Observable observable, Context context, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        return appAwaitFirst(observable, context, continuation);
    }

    public static final <T> Object appAwaitSingle(Observable<T> observable, Context context, Boolean bool, Continuation<? super T> continuation) {
        return f.M(new AnonymousClass2(observable, context, bool, null), continuation);
    }

    public static /* synthetic */ Object appAwaitSingle$default(Observable observable, Context context, Boolean bool, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            context = null;
        }
        if ((i & 2) != 0) {
            bool = Boolean.FALSE;
        }
        return appAwaitSingle(observable, context, bool, continuation);
    }
}
