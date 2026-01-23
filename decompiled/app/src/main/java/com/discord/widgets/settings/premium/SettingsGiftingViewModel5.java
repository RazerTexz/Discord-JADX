package com.discord.widgets.settings.premium;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.SettingsGiftingViewModel$onGiftCodeResolved$1, reason: use source file name */
/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGiftingViewModel5 extends Lambda implements Function1<String, Unit> {
    public static final SettingsGiftingViewModel5 INSTANCE = new SettingsGiftingViewModel5();

    public SettingsGiftingViewModel5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
    }
}
