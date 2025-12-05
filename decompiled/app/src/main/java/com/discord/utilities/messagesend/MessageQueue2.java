package com.discord.utilities.messagesend;

import android.content.Context;
import com.discord.utilities.messagesend.MessageQueue4;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.Subscription;

/* compiled from: MessageQueue.kt */
/* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MessageQueue2 extends Lambda implements Function1<MessageQueue4, Unit> {
    public final /* synthetic */ MessageQueue3 $request;
    public final /* synthetic */ MessageQueue this$0;

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$1 */
    public static final class C68111 extends Lambda implements Function1<Long, Unit> {

        /* compiled from: MessageQueue.kt */
        /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$1$1, reason: invalid class name */
        public static final class AnonymousClass1 implements Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MessageQueue.access$getQueue$p(MessageQueue2.this.this$0).addFirst(MessageQueue2.this.$request);
                MessageQueue.access$setRetrySubscription$p(MessageQueue2.this.this$0, null);
                MessageQueue.access$onDrainingCompleted(MessageQueue2.this.this$0);
                MessageQueue.access$processNextRequest(MessageQueue2.this.this$0);
            }
        }

        public C68111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            MessageQueue.access$getExecutorService$p(MessageQueue2.this.this$0).submit(new AnonymousClass1());
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$2 */
    public static final class C68122 extends Lambda implements Function1<Subscription, Unit> {
        public C68122() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            MessageQueue.access$setRetrySubscription$p(MessageQueue2.this.this$0, subscription);
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3 */
    public static final class RunnableC68133 implements Runnable {

        /* compiled from: MessageQueue.kt */
        /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

            /* compiled from: MessageQueue.kt */
            /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class RunnableC132711 implements Runnable {
                public RunnableC132711() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MessageQueue.access$processNextRequest(MessageQueue2.this.this$0);
                }
            }

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MessageQueue.access$getExecutorService$p(MessageQueue2.this.this$0).submit(new RunnableC132711());
            }
        }

        public RunnableC68133() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue.access$onDrainingCompleted(MessageQueue2.this.this$0);
            MessageQueue.access$getQueue$p(MessageQueue2.this.this$0).addFirst(MessageQueue2.this.$request);
            MessageQueue.access$getNetworkBackoff$p(MessageQueue2.this.this$0).fail(new AnonymousClass1());
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$4 */
    public static final class RunnableC68144 implements Runnable {
        public final /* synthetic */ MessageQueue4 $result;

        public RunnableC68144(MessageQueue4 messageQueue4) {
            this.$result = messageQueue4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue.access$onDrainingCompleted(MessageQueue2.this.this$0);
            MessageQueue2.this.$request.getOnCompleted().invoke(this.$result, Boolean.valueOf(MessageQueue.access$getQueue$p(MessageQueue2.this.this$0).isEmpty()));
            MessageQueue.access$getNetworkBackoff$p(MessageQueue2.this.this$0).succeed();
            MessageQueue.access$processNextRequest(MessageQueue2.this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue2(MessageQueue messageQueue, MessageQueue3 messageQueue3) {
        super(1);
        this.this$0 = messageQueue;
        this.$request = messageQueue3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageQueue4 messageQueue4) {
        invoke2(messageQueue4);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageQueue4 messageQueue4) {
        Intrinsics3.checkNotNullParameter(messageQueue4, "result");
        if (!(messageQueue4 instanceof MessageQueue4.RateLimited)) {
            if (messageQueue4 instanceof MessageQueue4.NetworkFailure) {
                MessageQueue.access$getExecutorService$p(this.this$0).submit(new RunnableC68133());
                return;
            } else {
                MessageQueue.access$getExecutorService$p(this.this$0).submit(new RunnableC68144(messageQueue4));
                return;
            }
        }
        Observable<Long> observableM11068d0 = Observable.m11068d0(((MessageQueue4.RateLimited) messageQueue4).getRetryAfterMs(), TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable\n             …s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableM11068d0, this.this$0.getClass(), (Context) null, new C68122(), (Function1) null, (Function0) null, (Function0) null, new C68111(), 58, (Object) null);
    }
}
