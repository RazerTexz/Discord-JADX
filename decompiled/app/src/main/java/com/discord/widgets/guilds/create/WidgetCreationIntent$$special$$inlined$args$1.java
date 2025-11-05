package com.discord.widgets.guilds.create;

import android.os.Bundle;
import b.d.b.a.outline;
import com.discord.app.AppFragment;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: ArgUtils.kt */
/* loaded from: classes2.dex */
public final class WidgetCreationIntent$$special$$inlined$args$1 extends Lambda implements Function0<WidgetCreationIntent2> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreationIntent$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.os.Parcelable] */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetCreationIntent2 invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        WidgetCreationIntent2 widgetCreationIntent2 = (WidgetCreationIntent2) (obj instanceof WidgetCreationIntent2 ? obj : null);
        WidgetCreationIntent2 parcelableExtra = widgetCreationIntent2;
        if (widgetCreationIntent2 == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (parcelableExtra != null) {
            return parcelableExtra;
        }
        StringBuilder sbU = outline.U("Missing args for class type ");
        outline.l0(WidgetCreationIntent2.class, sbU, " + key ");
        throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.guilds.create.CreationIntentArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetCreationIntent2 invoke() {
        return invoke();
    }
}
