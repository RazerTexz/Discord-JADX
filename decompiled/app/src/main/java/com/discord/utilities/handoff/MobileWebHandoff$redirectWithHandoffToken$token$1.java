package com.discord.utilities.handoff;

import android.content.Context;
import b.i.a.f.e.o.f;
import com.discord.analytics.generated.events.TrackMobileWebHandoffFailure;
import com.discord.api.handoff.HandoffToken;
import com.discord.utilities.coroutines.RxCoroutineExtensionsKt;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import s.a.k0;

/* compiled from: MobileWebHandoff.kt */
@e(c = "com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1", f = "MobileWebHandoff.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MobileWebHandoff$redirectWithHandoffToken$token$1 extends k implements Function1<Continuation<? super HandoffToken>, Object> {
    public final /* synthetic */ Ref$ObjectRef $nonce;
    public int label;
    public final /* synthetic */ MobileWebHandoff this$0;

    /* compiled from: MobileWebHandoff.kt */
    @e(c = "com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1$1", f = "MobileWebHandoff.kt", l = {48}, m = "invokeSuspend")
    /* renamed from: com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super HandoffToken>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return MobileWebHandoff$redirectWithHandoffToken$token$1.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HandoffToken> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    l.throwOnFailure(obj);
                    Observable<HandoffToken> observableCreateHandoffTokenWithNonce = MobileWebHandoff.access$getRestAPI$p(MobileWebHandoff$redirectWithHandoffToken$token$1.this.this$0).createHandoffTokenWithNonce((String) MobileWebHandoff$redirectWithHandoffToken$token$1.this.$nonce.element);
                    Context contextAccess$getContext$p = MobileWebHandoff.access$getContext$p(MobileWebHandoff$redirectWithHandoffToken$token$1.this.this$0);
                    this.label = 1;
                    obj = RxCoroutineExtensionsKt.appAwaitFirst(observableCreateHandoffTokenWithNonce, contextAccess$getContext$p, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.throwOnFailure(obj);
                }
                return (HandoffToken) obj;
            } catch (Throwable th) {
                MobileWebHandoff.access$getAnalytics$p(MobileWebHandoff$redirectWithHandoffToken$token$1.this.this$0).track(new TrackMobileWebHandoffFailure("handoff_token_fetch_failure", null, 2));
                throw th;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileWebHandoff$redirectWithHandoffToken$token$1(MobileWebHandoff mobileWebHandoff, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(1, continuation);
        this.this$0 = mobileWebHandoff;
        this.$nonce = ref$ObjectRef;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new MobileWebHandoff$redirectWithHandoffToken$token$1(this.this$0, this.$nonce, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super HandoffToken> continuation) {
        return ((MobileWebHandoff$redirectWithHandoffToken$token$1) create(continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = k0.f3842b;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
            this.label = 1;
            obj = f.C1(coroutineDispatcher, anonymousClass1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        return obj;
    }
}
