package com.discord.utilities.handoff;

import android.content.Context;
import com.discord.analytics.generated.events.TrackMobileWebHandoffFailure;
import com.discord.api.handoff.HandoffToken;
import com.discord.utilities.coroutines.RxCoroutineExtensions;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p659s.p660a.Dispatchers;

/* JADX INFO: renamed from: com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1, reason: use source file name */
/* JADX INFO: compiled from: MobileWebHandoff.kt */
/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(m10084c = "com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1", m10085f = "MobileWebHandoff.kt", m10086l = {45}, m10087m = "invokeSuspend")
public final class MobileWebHandoff2 extends ContinuationImpl6 implements Function1<Continuation<? super HandoffToken>, Object> {
    public final /* synthetic */ Ref$ObjectRef $nonce;
    public int label;
    public final /* synthetic */ MobileWebHandoff this$0;

    /* JADX INFO: renamed from: com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1$1 */
    /* JADX INFO: compiled from: MobileWebHandoff.kt */
    @DebugMetadata(m10084c = "com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$token$1$1", m10085f = "MobileWebHandoff.kt", m10086l = {48}, m10087m = "invokeSuspend")
    public static final class C67711 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super HandoffToken>, Object> {
        public int label;

        public C67711(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return MobileWebHandoff2.this.new C67711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HandoffToken> continuation) {
            return ((C67711) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    Observable<HandoffToken> observableCreateHandoffTokenWithNonce = MobileWebHandoff.access$getRestAPI$p(MobileWebHandoff2.this.this$0).createHandoffTokenWithNonce((String) MobileWebHandoff2.this.$nonce.element);
                    Context contextAccess$getContext$p = MobileWebHandoff.access$getContext$p(MobileWebHandoff2.this.this$0);
                    this.label = 1;
                    obj = RxCoroutineExtensions.appAwaitFirst(observableCreateHandoffTokenWithNonce, contextAccess$getContext$p, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                return (HandoffToken) obj;
            } catch (Throwable th) {
                MobileWebHandoff.access$getAnalytics$p(MobileWebHandoff2.this.this$0).track(new TrackMobileWebHandoffFailure("handoff_token_fetch_failure", null, 2));
                throw th;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileWebHandoff2(MobileWebHandoff mobileWebHandoff, Ref$ObjectRef ref$ObjectRef, Continuation continuation) {
        super(1, continuation);
        this.this$0 = mobileWebHandoff;
        this.$nonce = ref$ObjectRef;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new MobileWebHandoff2(this.this$0, this.$nonce, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super HandoffToken> continuation) {
        return ((MobileWebHandoff2) create(continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcher = Dispatchers.f27867b;
            C67711 c67711 = new C67711(null);
            this.label = 1;
            obj = C3404f.m4197C1(coroutineDispatcher, c67711, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
        }
        return obj;
    }
}
