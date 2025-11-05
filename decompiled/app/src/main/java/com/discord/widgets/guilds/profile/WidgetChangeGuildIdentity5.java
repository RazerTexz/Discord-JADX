package com.discord.widgets.guilds.profile;

import android.view.View;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;

/* compiled from: WidgetChangeGuildIdentity.kt */
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity5 implements View.OnClickListener {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    public WidgetChangeGuildIdentity5(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel.ViewState.Loaded loaded) {
        this.this$0 = widgetChangeGuildIdentity;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChangeGuildIdentity.access$getViewModel$p(this.this$0).updateNickname("");
    }
}
