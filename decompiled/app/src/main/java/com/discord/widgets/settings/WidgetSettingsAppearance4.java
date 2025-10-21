package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetSettingsAppearance.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsAppearance$pureEvilEasterEggSubject$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsAppearance4 extends Lambda implements Function0<BehaviorSubject<Boolean>> {
    public static final WidgetSettingsAppearance4 INSTANCE = new WidgetSettingsAppearance4();

    public WidgetSettingsAppearance4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ BehaviorSubject<Boolean> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final BehaviorSubject<Boolean> invoke2() {
        return BehaviorSubject.l0(Boolean.valueOf(Intrinsics3.areEqual(StoreStream.INSTANCE.getUserSettingsSystem().getTheme(), ModelUserSettings.THEME_PURE_EVIL)));
    }
}
