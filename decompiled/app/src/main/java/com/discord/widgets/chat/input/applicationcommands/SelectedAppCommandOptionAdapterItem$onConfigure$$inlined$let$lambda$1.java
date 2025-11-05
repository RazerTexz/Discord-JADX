package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import com.discord.models.commands.ApplicationCommandOption;

/* compiled from: SelectedApplicationCommandAdapter.kt */
/* loaded from: classes2.dex */
public final class SelectedAppCommandOptionAdapterItem$onConfigure$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ SelectedApplicationCommandItem $data$inlined;
    public final /* synthetic */ ApplicationCommandOption $option;
    public final /* synthetic */ SelectedAppCommandOptionAdapterItem this$0;

    public SelectedAppCommandOptionAdapterItem$onConfigure$$inlined$let$lambda$1(ApplicationCommandOption applicationCommandOption, SelectedAppCommandOptionAdapterItem selectedAppCommandOptionAdapterItem, SelectedApplicationCommandItem selectedApplicationCommandItem) {
        this.$option = applicationCommandOption;
        this.this$0 = selectedAppCommandOptionAdapterItem;
        this.$data$inlined = selectedApplicationCommandItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SelectedAppCommandOptionAdapterItem.access$getAdapter$p(this.this$0).onParamClicked(this.$option);
    }
}
