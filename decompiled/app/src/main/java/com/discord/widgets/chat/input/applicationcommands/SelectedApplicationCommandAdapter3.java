package com.discord.widgets.chat.input.applicationcommands;

import android.view.View;
import com.discord.models.commands.ApplicationCommandOption;

/* compiled from: SelectedApplicationCommandAdapter.kt */
/* renamed from: com.discord.widgets.chat.input.applicationcommands.SelectedAppCommandOptionAdapterItem$onConfigure$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter3 implements View.OnClickListener {
    public final /* synthetic */ SelectedApplicationCommandAdapter8 $data$inlined;
    public final /* synthetic */ ApplicationCommandOption $option;
    public final /* synthetic */ SelectedApplicationCommandAdapter2 this$0;

    public SelectedApplicationCommandAdapter3(ApplicationCommandOption applicationCommandOption, SelectedApplicationCommandAdapter2 selectedApplicationCommandAdapter2, SelectedApplicationCommandAdapter8 selectedApplicationCommandAdapter8) {
        this.$option = applicationCommandOption;
        this.this$0 = selectedApplicationCommandAdapter2;
        this.$data$inlined = selectedApplicationCommandAdapter8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SelectedApplicationCommandAdapter2.access$getAdapter$p(this.this$0).onParamClicked(this.$option);
    }
}
