package com.discord.widgets.friends;

import com.discord.utilities.captcha.CaptchaHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetFriendsAddById.kt */
/* renamed from: com.discord.widgets.friends.WidgetFriendsAddById$captchaLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsAddById3 extends Lambda implements Function1<CaptchaHelper.CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetFriendsAddById this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddById3(WidgetFriendsAddById widgetFriendsAddById) {
        super(1);
        this.this$0 = widgetFriendsAddById;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.CaptchaPayload captchaPayload) {
        invoke2(captchaPayload);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
        WidgetFriendsAddById.access$extractTargetAndSendFriendRequest(this.this$0, captchaPayload);
    }
}
