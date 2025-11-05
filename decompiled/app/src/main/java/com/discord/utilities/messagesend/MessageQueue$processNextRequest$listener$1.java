package com.discord.utilities.messagesend;

import android.content.Context;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* compiled from: MessageQueue.kt */
/* loaded from: classes2.dex */
public final class MessageQueue$processNextRequest$listener$1 extends o implements Function1<MessageResult, Unit> {
    public final /* synthetic */ MessageRequest $request;
    public final /* synthetic */ MessageQueue this$0;

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Unit> {

        /* compiled from: MessageQueue.kt */
        /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class RunnableC03381 implements Runnable {
            public RunnableC03381() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                MessageQueue.access$getQueue$p(MessageQueue$processNextRequest$listener$1.this.this$0).addFirst(MessageQueue$processNextRequest$listener$1.this.$request);
                MessageQueue.access$setRetrySubscription$p(MessageQueue$processNextRequest$listener$1.this.this$0, null);
                MessageQueue.access$onDrainingCompleted(MessageQueue$processNextRequest$listener$1.this.this$0);
                MessageQueue.access$processNextRequest(MessageQueue$processNextRequest$listener$1.this.this$0);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            MessageQueue.access$getExecutorService$p(MessageQueue$processNextRequest$listener$1.this.this$0).submit(new RunnableC03381());
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            MessageQueue.access$setRetrySubscription$p(MessageQueue$processNextRequest$listener$1.this.this$0, subscription);
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3, reason: invalid class name */
    public static final class AnonymousClass3 implements Runnable {

        /* compiled from: MessageQueue.kt */
        /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {

            /* compiled from: MessageQueue.kt */
            /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class RunnableC03391 implements Runnable {
                public RunnableC03391() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    MessageQueue.access$processNextRequest(MessageQueue$processNextRequest$listener$1.this.this$0);
                }
            }

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MessageQueue.access$getExecutorService$p(MessageQueue$processNextRequest$listener$1.this.this$0).submit(new RunnableC03391());
            }
        }

        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue.access$onDrainingCompleted(MessageQueue$processNextRequest$listener$1.this.this$0);
            MessageQueue.access$getQueue$p(MessageQueue$processNextRequest$listener$1.this.this$0).addFirst(MessageQueue$processNextRequest$listener$1.this.$request);
            MessageQueue.access$getNetworkBackoff$p(MessageQueue$processNextRequest$listener$1.this.this$0).fail(new AnonymousClass1());
        }
    }

    /* compiled from: MessageQueue.kt */
    /* renamed from: com.discord.utilities.messagesend.MessageQueue$processNextRequest$listener$1$4, reason: invalid class name */
    public static final class AnonymousClass4 implements Runnable {
        public final /* synthetic */ MessageResult $result;

        public AnonymousClass4(MessageResult messageResult) {
            this.$result = messageResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MessageQueue.access$onDrainingCompleted(MessageQueue$processNextRequest$listener$1.this.this$0);
            MessageQueue$processNextRequest$listener$1.this.$request.getOnCompleted().invoke(this.$result, Boolean.valueOf(MessageQueue.access$getQueue$p(MessageQueue$processNextRequest$listener$1.this.this$0).isEmpty()));
            MessageQueue.access$getNetworkBackoff$p(MessageQueue$processNextRequest$listener$1.this.this$0).succeed();
            MessageQueue.access$processNextRequest(MessageQueue$processNextRequest$listener$1.this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageQueue$processNextRequest$listener$1(MessageQueue messageQueue, MessageRequest messageRequest) {
        super(1);
        this.this$0 = messageQueue;
        this.$request = messageRequest;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
        invoke2(messageResult);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MessageResult messageResult) {
        m.checkNotNullParameter(messageResult, "result");
        if (!(messageResult instanceof MessageResult.RateLimited)) {
            if (messageResult instanceof MessageResult.NetworkFailure) {
                MessageQueue.access$getExecutorService$p(this.this$0).submit(new AnonymousClass3());
                return;
            } else {
                MessageQueue.access$getExecutorService$p(this.this$0).submit(new AnonymousClass4(messageResult));
                return;
            }
        }
        Observable<Long> observableD0 = Observable.d0(((MessageResult.RateLimited) messageResult).getRetryAfterMs(), TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n             …s, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, this.this$0.getClass(), (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
    }
}
