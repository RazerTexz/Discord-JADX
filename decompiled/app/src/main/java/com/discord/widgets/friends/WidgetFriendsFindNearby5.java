package com.discord.widgets.friends;

import com.discord.utilities.captcha.CaptchaHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$captchaLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby5 extends Lambda implements Function1<CaptchaHelper.CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby5(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        super(1);
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.CaptchaPayload captchaPayload) {
        invoke2(captchaPayload);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.CaptchaPayload captchaPayload) {
        Integer discriminator;
        Intrinsics3.checkNotNullParameter(captchaPayload, "token");
        String username = WidgetFriendsFindNearby.access$getViewModel$p(this.this$0).getUsername();
        if (username == null || (discriminator = WidgetFriendsFindNearby.access$getViewModel$p(this.this$0).getDiscriminator()) == null) {
            return;
        }
        WidgetFriendsFindNearby.access$sendFriendRequest(this.this$0, username, discriminator.intValue(), captchaPayload);
    }
}
