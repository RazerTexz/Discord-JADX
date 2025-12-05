package com.discord.widgets.auth;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetRemoteAuth.kt */
/* renamed from: com.discord.widgets.auth.WidgetRemoteAuth$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetRemoteAuth3 extends Lambda implements Function0<WidgetRemoteAuthViewModel> {
    public final /* synthetic */ WidgetRemoteAuth this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuth3(WidgetRemoteAuth widgetRemoteAuth) {
        super(0);
        this.this$0 = widgetRemoteAuth;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetRemoteAuthViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetRemoteAuthViewModel invoke() {
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra("REMOTE_AUTH_FINGERPRINT");
        if (stringExtra == null) {
            stringExtra = "";
        }
        return new WidgetRemoteAuthViewModel(stringExtra, null, 2, null);
    }
}
