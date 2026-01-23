package com.discord.widgets.hubs.events;

import android.os.Bundle;
import com.discord.app.AppBottomSheet;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEventsPage$$special$$inlined$args$1 extends Lambda implements Function0<WidgetHubEventsPage2> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppBottomSheet $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage$$special$$inlined$args$1(AppBottomSheet appBottomSheet, String str) {
        super(0);
        this.$this_args = appBottomSheet;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubEventsPage2 invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetHubEventsPage2 widgetHubEventsPage2 = (WidgetHubEventsPage2) (obj instanceof WidgetHubEventsPage2 ? obj : null);
        if (widgetHubEventsPage2 != null) {
            return widgetHubEventsPage2;
        }
        StringBuilder sbM833U = outline.m833U("Missing args for class type ");
        outline.m862l0(WidgetHubEventsPage2.class, sbM833U, " + key ");
        throw new IllegalStateException(outline.m820H(sbM833U, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.hubs.events.HubEventsArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubEventsPage2 invoke() {
        return invoke();
    }
}
