package com.discord.api.auth.mfa;

import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.Intrinsics3;

/* compiled from: GetBackupCodesSendVerificationKeyRequestBody.kt */
/* loaded from: classes.dex */
public final class GetBackupCodesSendVerificationKeyRequestBody {
    private final String password;

    public GetBackupCodesSendVerificationKeyRequestBody(String str) {
        Intrinsics3.checkNotNullParameter(str, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = str;
    }
}
