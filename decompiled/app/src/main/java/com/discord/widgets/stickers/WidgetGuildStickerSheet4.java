package com.discord.widgets.stickers;

import android.view.View;
import com.discord.models.guild.Guild;

/* compiled from: WidgetGuildStickerSheet.kt */
/* renamed from: com.discord.widgets.stickers.WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGuildStickerSheet4 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $isUserInGuild$inlined;
    public final /* synthetic */ boolean $isUserPremium$inlined;
    public final /* synthetic */ WidgetGuildStickerSheet this$0;

    public WidgetGuildStickerSheet4(WidgetGuildStickerSheet widgetGuildStickerSheet, Guild guild, boolean z2, boolean z3) {
        this.this$0 = widgetGuildStickerSheet;
        this.$guild$inlined = guild;
        this.$isUserPremium$inlined = z2;
        this.$isUserInGuild$inlined = z3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildStickerSheet.access$getViewModel$p(this.this$0).joinGuild(this.$guild$inlined, this.this$0);
    }
}
