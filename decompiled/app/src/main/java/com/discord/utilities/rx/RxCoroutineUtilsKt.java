package com.discord.utilities.rx;

import androidx.exifinterface.media.ExifInterface;
import d0.l;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.g;
import j0.l.e.f;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import s.a.d2.d;

/* compiled from: RxCoroutineUtils.kt */
/* loaded from: classes2.dex */
public final class RxCoroutineUtilsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RxCoroutineUtils.kt */
    @e(c = "com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2", f = "RxCoroutineUtils.kt", l = {47}, m = "invokeSuspend")
    /* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends k implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Observable $this_toFlow;
        private /* synthetic */ Object L$0;
        public int label;

        /* compiled from: RxCoroutineUtils.kt */
        /* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$subscription.unsubscribe();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Observable observable, Continuation continuation) {
            super(2, continuation);
            this.$this_toFlow = observable;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_toFlow, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(obj, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.L$0;
                Observable observable = this.$this_toFlow;
                g rxCoroutineUtilsKt$toFlow$2$subscription$1 = new RxCoroutineUtilsKt$toFlow$2$subscription$1(producerScope);
                Objects.requireNonNull(observable);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(rxCoroutineUtilsKt$toFlow$2$subscription$1 instanceof Subscriber ? observable.U((Subscriber) rxCoroutineUtilsKt$toFlow$2$subscription$1) : observable.U(new f(rxCoroutineUtilsKt$toFlow$2$subscription$1)));
                this.label = 1;
                if (s.a.c2.l.a(producerScope, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    public static final <T> Object awaitFirst(Observable<T> observable, Continuation<? super T> continuation) {
        Observable<T> observableZ = observable.z();
        m.checkNotNullExpressionValue(observableZ, "first()");
        return awaitSingle(observableZ, continuation);
    }

    public static final <T> Object awaitSingle(Observable<T> observable, Continuation<? super T> continuation) {
        s.a.l lVar = new s.a.l(b.intercepted(continuation), 1);
        lVar.A();
        lVar.f(new RxCoroutineUtilsKt$awaitSingle$2$1(observable.R().W(new RxCoroutineUtilsKt$awaitSingle$2$subscription$1(lVar), new RxCoroutineUtilsKt$awaitSingle$2$subscription$2(lVar))));
        Object objU = lVar.u();
        if (objU == c.getCOROUTINE_SUSPENDED()) {
            d0.w.i.a.g.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public static final <T> Object toFlow(Observable<T> observable, Continuation<? super d<? extends T>> continuation) {
        return new s.a.d2.b(new AnonymousClass2(observable, null), null, 0, null, 14);
    }
}
