package com.discord.widgets.stage;

import android.graphics.Bitmap;
import com.discord.utilities.images.MGImagesBitmap;
import com.discord.utilities.p501rx.RxCoroutineUtils;
import com.discord.widgets.stage.StageChannelNotifications;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OperatorOnErrorResumeNextViaFunction4;
import p658rx.Observable;

/* compiled from: StageChannelNotifications.kt */
@DebugMetadata(m10084c = "com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$bitmap$1$1", m10085f = "StageChannelNotifications.kt", m10086l = {51}, m10087m = "invokeSuspend")
/* renamed from: com.discord.widgets.stage.StageChannelNotifications$onInvitedToSpeak$1$invokeSuspend$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StageChannelNotifications4 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    public final /* synthetic */ String $iconUrl$inlined;
    public int label;
    public final /* synthetic */ StageChannelNotifications.C100131 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelNotifications4(Continuation continuation, StageChannelNotifications.C100131 c100131, String str) {
        super(2, continuation);
        this.this$0 = c100131;
        this.$iconUrl$inlined = str;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new StageChannelNotifications4(continuation, this.this$0, this.$iconUrl$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((StageChannelNotifications4) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            Observable<Bitmap> bitmap = MGImagesBitmap.INSTANCE.getBitmap(this.$iconUrl$inlined, true);
            Observable observableM11074h0 = Observable.m11074h0(new OnSubscribeLift(bitmap.f27640j, new OperatorOnErrorResumeNextViaFunction4(StageChannelNotifications3.INSTANCE)));
            Intrinsics3.checkNotNullExpressionValue(observableM11074h0, "MGImagesBitmap.getBitmap…nErrorResumeNext { null }");
            this.label = 1;
            obj = RxCoroutineUtils.awaitSingle(observableM11074h0, this);
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
