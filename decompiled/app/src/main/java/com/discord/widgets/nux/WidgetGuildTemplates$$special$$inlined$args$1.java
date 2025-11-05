package com.discord.widgets.nux;

import android.os.Bundle;
import b.d.b.a.a;
import com.discord.app.AppFragment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* compiled from: ArgUtils.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildTemplates$$special$$inlined$args$1 extends o implements Function0<GuildCreateArgs> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildTemplates$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.os.Parcelable] */
    @Override // kotlin.jvm.functions.Function0
    public final GuildCreateArgs invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        GuildCreateArgs guildCreateArgs = (GuildCreateArgs) (obj instanceof GuildCreateArgs ? obj : null);
        GuildCreateArgs parcelableExtra = guildCreateArgs;
        if (guildCreateArgs == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (parcelableExtra != null) {
            return parcelableExtra;
        }
        StringBuilder sbU = a.U("Missing args for class type ");
        a.l0(GuildCreateArgs.class, sbU, " + key ");
        throw new IllegalStateException(a.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.nux.GuildCreateArgs] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildCreateArgs invoke() {
        return invoke();
    }
}
