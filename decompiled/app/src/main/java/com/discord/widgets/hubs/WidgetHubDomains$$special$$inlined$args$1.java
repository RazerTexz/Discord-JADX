package com.discord.widgets.hubs;

import android.os.Bundle;
import b.d.b.a.outline;
import com.discord.app.AppFragment;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: ArgUtils.kt */
/* loaded from: classes2.dex */
public final class WidgetHubDomains$$special$$inlined$args$1 extends Lambda implements Function0<WidgetHubDomains3> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomains$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.os.Parcelable] */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDomains3 invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetHubDomains3 widgetHubDomains3 = (WidgetHubDomains3) (obj instanceof WidgetHubDomains3 ? obj : null);
        WidgetHubDomains3 parcelableExtra = widgetHubDomains3;
        if (widgetHubDomains3 == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (parcelableExtra != null) {
            return parcelableExtra;
        }
        StringBuilder sbU = outline.U("Missing args for class type ");
        outline.l0(WidgetHubDomains3.class, sbU, " + key ");
        throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.hubs.HubDomainArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubDomains3 invoke() {
        return invoke();
    }
}
