package com.discord.widgets.captcha;

import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetCaptcha.kt */
/* renamed from: com.discord.widgets.captcha.WidgetCaptchaKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCaptcha4 {
    public static final boolean isCaptchaError(Error error) {
        Intrinsics3.checkNotNullParameter(error, "$this$isCaptchaError");
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "response");
        return response.getMessages().keySet().contains(CaptchaHelper.CAPTCHA_KEY);
    }
}
