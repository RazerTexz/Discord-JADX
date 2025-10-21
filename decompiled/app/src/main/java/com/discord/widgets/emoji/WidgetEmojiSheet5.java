package com.discord.widgets.emoji;

import android.view.View;
import com.discord.models.guild.Guild;

/* compiled from: WidgetEmojiSheet.kt */
/* renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$configureButtons$$inlined$with$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEmojiSheet5 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $isUserInGuild$inlined;
    public final /* synthetic */ boolean $isUserPremium$inlined;
    public final /* synthetic */ WidgetEmojiSheet this$0;

    public WidgetEmojiSheet5(WidgetEmojiSheet widgetEmojiSheet, Guild guild, boolean z2, boolean z3) {
        this.this$0 = widgetEmojiSheet;
        this.$guild$inlined = guild;
        this.$isUserPremium$inlined = z2;
        this.$isUserInGuild$inlined = z3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetEmojiSheet.access$getViewModel$p(this.this$0).joinGuild(this.$guild$inlined, this.this$0);
    }
}
