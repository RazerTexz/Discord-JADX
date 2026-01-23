package com.discord.widgets.settings.profile;

import android.text.Editable;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$1 */
/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9973x9758651b extends Lambda implements Function1<Editable, Unit> {
    public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9973x9758651b(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile, EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        Intrinsics3.checkNotNullParameter(editable, "editable");
        WidgetEditUserOrGuildMemberProfile.access$getViewModel$p(this.this$0).updateNickname(editable.toString());
    }
}
