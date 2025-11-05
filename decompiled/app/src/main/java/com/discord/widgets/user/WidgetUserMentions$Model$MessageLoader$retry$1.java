package com.discord.widgets.user;

import com.discord.utilities.analytics.Traits;
import com.discord.widgets.user.WidgetUserMentions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$retry$1 extends Lambda implements Function1<Subscription, Unit> {
    public final /* synthetic */ WidgetUserMentions.Model.MessageLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$retry$1(WidgetUserMentions.Model.MessageLoader messageLoader) {
        super(1);
        this.this$0 = messageLoader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
        invoke2(subscription);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Subscription subscription) {
        Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        WidgetUserMentions.Model.MessageLoader.access$setRetrySubscription$p(this.this$0, subscription);
    }
}
