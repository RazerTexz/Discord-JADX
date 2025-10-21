package com.discord.widgets.settings;

import com.discord.views.CheckedSetting;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetSettingsPrivacy.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$friendSourceRadios$2 extends Lambda implements Function0<List<? extends CheckedSetting>> {
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$friendSourceRadios$2(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        super(0);
        this.this$0 = widgetSettingsPrivacy;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends CheckedSetting> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends CheckedSetting> invoke2() {
        return Collections2.listOf((Object[]) new CheckedSetting[]{WidgetSettingsPrivacy.access$getBinding$p(this.this$0).r, WidgetSettingsPrivacy.access$getBinding$p(this.this$0).f2636s, WidgetSettingsPrivacy.access$getBinding$p(this.this$0).t});
    }
}
