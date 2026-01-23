package com.discord.widgets.servers;

import android.view.View;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.servers.WidgetServerSettingsSecurity;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1 implements View.OnClickListener {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ boolean $mfaEnabled;
    public final /* synthetic */ WidgetServerSettingsSecurity.ToggleMfaDialog this$0;

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
    public static final class C93091 extends Lambda implements Function1<Void, Unit> {
        public C93091() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
        TextInputLayout textInputLayout = WidgetServerSettingsSecurity.ToggleMfaDialog.access$getBinding$p(this.this$0).f17758d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsSecurityServerMfaCode");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().setMfaLevel(this.$guildId, new RestAPIParams.GuildMFA(i, ViewExtensions.getTextOrEmpty(textInputLayout))), false, 1, null), this.this$0, null, 2, null), this.this$0.getClass(), this.this$0.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93091(), 60, (Object) null);
    }
}
