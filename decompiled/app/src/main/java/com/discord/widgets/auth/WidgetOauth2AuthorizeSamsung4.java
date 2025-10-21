package com.discord.widgets.auth;

import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* renamed from: com.discord.widgets.auth.WidgetOauth2AuthorizeSamsung$captchaLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung4 extends Lambda implements Function1<CaptchaHelper.CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung4(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        super(1);
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.CaptchaPayload captchaPayload) {
        invoke2(captchaPayload);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
        String strAccess$getSamsungAuthCode$p = WidgetOauth2AuthorizeSamsung.access$getSamsungAuthCode$p(this.this$0);
        if (strAccess$getSamsungAuthCode$p != null) {
            WidgetOauth2AuthorizeSamsung.access$authorizeForSamsung(this.this$0, strAccess$getSamsungAuthCode$p, captchaPayload);
        } else {
            WidgetOauth2AuthorizeSamsung.Companion.logW$default(WidgetOauth2AuthorizeSamsung.INSTANCE, "auth code not set", null, 2, null);
        }
    }
}
