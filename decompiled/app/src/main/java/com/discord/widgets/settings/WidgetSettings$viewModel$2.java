package com.discord.widgets.settings;

import androidx.core.app.FrameMetricsAggregator;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$viewModel$2 extends Lambda implements Function0<SettingsViewModel> {
    public static final WidgetSettings$viewModel$2 INSTANCE = new WidgetSettings$viewModel$2();

    public WidgetSettings$viewModel$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SettingsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SettingsViewModel invoke() {
        return new SettingsViewModel(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }
}
