package com.discord.widgets.botuikit;

import android.os.Bundle;
import b.d.b.a.outline;
import com.discord.app.AppFragment;
import com.discord.widgets.botuikit.ModalComponent;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: ArgUtils.kt */
/* loaded from: classes2.dex */
public final class ModalComponent$$special$$inlined$args$1 extends Lambda implements Function0<ModalComponent.Options> {
    public final /* synthetic */ String $argsKey;
    public final /* synthetic */ AppFragment $this_args;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalComponent$$special$$inlined$args$1(AppFragment appFragment, String str) {
        super(0);
        this.$this_args = appFragment;
        this.$argsKey = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.os.Parcelable] */
    @Override // kotlin.jvm.functions.Function0
    public final ModalComponent.Options invoke() {
        Bundle arguments = this.$this_args.getArguments();
        Object obj = arguments != null ? arguments.get(this.$argsKey) : null;
        ModalComponent.Options options = (ModalComponent.Options) (obj instanceof ModalComponent.Options ? obj : null);
        ModalComponent.Options parcelableExtra = options;
        if (options == null) {
            parcelableExtra = this.$this_args.getMostRecentIntent().getParcelableExtra(this.$argsKey);
        }
        if (parcelableExtra != null) {
            return parcelableExtra;
        }
        StringBuilder sbU = outline.U("Missing args for class type ");
        outline.l0(ModalComponent.Options.class, sbU, " + key ");
        throw new IllegalStateException(outline.H(sbU, this.$argsKey, '!'));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, com.discord.widgets.botuikit.ModalComponent$Options] */
    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ModalComponent.Options invoke() {
        return invoke();
    }
}
