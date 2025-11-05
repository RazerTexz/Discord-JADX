package com.discord.widgets.friends;

import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsAddById.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsAddById$captchaLauncher$1 extends o implements Function1<CaptchaHelper.CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetFriendsAddById this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddById$captchaLauncher$1(WidgetFriendsAddById widgetFriendsAddById) {
        super(1);
        this.this$0 = widgetFriendsAddById;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.CaptchaPayload captchaPayload) {
        invoke2(captchaPayload);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.CaptchaPayload captchaPayload) {
        m.checkNotNullParameter(captchaPayload, "captchaPayload");
        WidgetFriendsAddById.access$extractTargetAndSendFriendRequest(this.this$0, captchaPayload);
    }
}
