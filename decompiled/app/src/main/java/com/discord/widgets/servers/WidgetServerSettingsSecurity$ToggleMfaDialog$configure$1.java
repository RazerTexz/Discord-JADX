package com.discord.widgets.servers;

import android.view.View;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.servers.WidgetServerSettingsSecurity;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsSecurity.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1 implements View.OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ boolean $mfaEnabled;
    public final /* synthetic */ WidgetServerSettingsSecurity.ToggleMfaDialog this$0;

    /* compiled from: WidgetServerSettingsSecurity.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1.this.this$0.dismiss();
        }
    }

    public WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1(WidgetServerSettingsSecurity.ToggleMfaDialog toggleMfaDialog, boolean z2, long j) {
        this.this$0 = toggleMfaDialog;
        this.$mfaEnabled = z2;
        this.$guildId = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = !this.$mfaEnabled ? 1 : 0;
        TextInputLayout textInputLayout = WidgetServerSettingsSecurity.ToggleMfaDialog.access$getBinding$p(this.this$0).d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsSecurityServerMfaCode");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().setMfaLevel(this.$guildId, new RestAPIParams.GuildMFA(i, ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
    }
}
