package com.discord.widgets.guilds.profile;

import android.text.Editable;
import com.discord.widgets.guilds.profile.WidgetChangeGuildIdentityViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChangeGuildIdentity.kt */
/* renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity4 extends Lambda implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentity4(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel.ViewState.Loaded loaded) {
        super(1);
        this.this$0 = widgetChangeGuildIdentity;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        Intrinsics3.checkNotNullParameter(editable, "editable");
        WidgetChangeGuildIdentity.access$getViewModel$p(this.this$0).updateNickname(editable.toString());
    }
}
