package com.discord.widgets.guilds.create;

import android.os.Bundle;
import com.discord.app.AppFragment;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ArgUtils.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildCreate$$special$$inlined$args$1 extends Lambda implements Function0<WidgetGuildCreate.Options> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreate$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.os.Parcelable] */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildCreate.Options invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetGuildCreate.Options options = (WidgetGuildCreate.Options) (obj instanceof WidgetGuildCreate.Options ? obj : null);
        WidgetGuildCreate.Options parcelableExtra = options;
        if (options == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (parcelableExtra != null) {
            return parcelableExtra;
        }
        StringBuilder sbM833U = outline.m833U("Missing args for class type ");
        outline.m862l0(WidgetGuildCreate.Options.class, sbM833U, " + key ");
        throw new IllegalStateException(outline.m820H(sbM833U, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.guilds.create.WidgetGuildCreate$Options] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildCreate.Options invoke() {
        return invoke();
    }
}
