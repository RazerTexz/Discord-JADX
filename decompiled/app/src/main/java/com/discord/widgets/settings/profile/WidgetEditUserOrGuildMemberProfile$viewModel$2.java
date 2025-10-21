package com.discord.widgets.settings.profile;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$viewModel$2 extends Lambda implements Function0<EditUserOrGuildMemberProfileViewModel2> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$viewModel$2(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        super(0);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EditUserOrGuildMemberProfileViewModel2 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EditUserOrGuildMemberProfileViewModel2 invoke() {
        return new EditUserOrGuildMemberProfileViewModel2(WidgetEditUserOrGuildMemberProfile.access$getGuildId$p(this.this$0), null, null, null, null, null, null, 126, null);
    }
}
