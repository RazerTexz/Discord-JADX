package com.discord.widgets.settings.profile;

import android.view.View;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;

/* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$2 */
/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC9974x9758651c implements View.OnClickListener {
    public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    public ViewOnClickListenerC9974x9758651c(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0).updateNickname("");
    }
}
