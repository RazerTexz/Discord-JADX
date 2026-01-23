package com.discord.widgets.hubs;

import android.os.Bundle;
import com.discord.app.AppFragment;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$$special$$inlined$args$1 extends Lambda implements Function0<WidgetHubDescriptionViewModel2> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDescriptionViewModel2 invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetHubDescriptionViewModel2 widgetHubDescriptionViewModel2 = (WidgetHubDescriptionViewModel2) (obj instanceof WidgetHubDescriptionViewModel2 ? obj : null);
        WidgetHubDescriptionViewModel2 parcelableExtra = widgetHubDescriptionViewModel2;
        if (widgetHubDescriptionViewModel2 == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (parcelableExtra != 0) {
            return parcelableExtra;
        }
        StringBuilder sbM833U = outline.m833U("Missing args for class type ");
        outline.m862l0(WidgetHubDescriptionViewModel2.class, sbM833U, " + key ");
        throw new IllegalStateException(outline.m820H(sbM833U, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.hubs.HubDescriptionArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubDescriptionViewModel2 invoke() {
        return invoke();
    }
}
