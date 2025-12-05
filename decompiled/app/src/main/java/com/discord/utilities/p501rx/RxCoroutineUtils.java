package com.discord.utilities.p501rx;

import androidx.exifinterface.media.ExifInterface;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Produce;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.Observer2;
import p637j0.p642l.p647e.ObserverSubscriber;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.Subscription;
import p659s.p660a.CancellableContinuationImpl5;
import p659s.p660a.p663c2.Produce2;
import p659s.p660a.p664d2.Builders;
import p659s.p660a.p664d2.Flow3;

/* compiled from: RxCoroutineUtils.kt */
/* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class RxCoroutineUtils {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RxCoroutineUtils.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2", m10085f = "RxCoroutineUtils.kt", m10086l = {47}, m10087m = "invokeSuspend")
    /* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2 */
    public static final class C68982<T> extends ContinuationImpl6 implements Function2<Produce<? super T>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Observable $this_toFlow;
        private /* synthetic */ Object L$0;
        public int label;

        /* compiled from: RxCoroutineUtils.kt */
        /* renamed from: com.discord.utilities.rx.RxCoroutineUtilsKt$toFlow$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.$subscription.unsubscribe();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68982(Observable observable, Continuation continuation) {
            super(2, continuation);
            this.$this_toFlow = observable;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            C68982 c68982 = new C68982(this.$this_toFlow, continuation);
            c68982.L$0 = obj;
            return c68982;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C68982) create(obj, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                Produce produce = (Produce) this.L$0;
                Observable observable = this.$this_toFlow;
                Observer2 rxCoroutineUtils5 = new RxCoroutineUtils5(produce);
                Objects.requireNonNull(observable);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(rxCoroutineUtils5 instanceof Subscriber ? observable.m11095U((Subscriber) rxCoroutineUtils5) : observable.m11095U(new ObserverSubscriber(rxCoroutineUtils5)));
                this.label = 1;
                if (Produce2.m11236a(produce, anonymousClass1, this) == coroutine_suspended) {
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

    public static final <T> Object awaitFirst(Observable<T> observable, Continuation<? super T> continuation) {
        Observable<T> observableM11119z = observable.m11119z();
        Intrinsics3.checkNotNullExpressionValue(observableM11119z, "first()");
        return awaitSingle(observableM11119z, continuation);
    }

    public static final <T> Object awaitSingle(Observable<T> observable, Continuation<? super T> continuation) {
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.m11318A();
        cancellableContinuationImpl5.mo10902f(new RxCoroutineUtils2(observable.m11092R().m11097W(new RxCoroutineUtils3(cancellableContinuationImpl5), new RxCoroutineUtils4(cancellableContinuationImpl5))));
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    public static final <T> Object toFlow(Observable<T> observable, Continuation<? super Flow3<? extends T>> continuation) {
        return new Builders(new C68982(observable, null), null, 0, null, 14);
    }
}
