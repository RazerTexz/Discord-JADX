package com.discord.widgets.emoji;

import android.content.Context;
import android.view.View;
import com.discord.models.guild.Guild;
import com.discord.utilities.analytics.Traits;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.z.d.m;

/* compiled from: WidgetEmojiSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetEmojiSheet$configureButtons$$inlined$with$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $isUserInGuild$inlined;
    public final /* synthetic */ boolean $isUserPremium$inlined;
    public final /* synthetic */ WidgetEmojiSheet this$0;

    public WidgetEmojiSheet$configureButtons$$inlined$with$lambda$1(WidgetEmojiSheet widgetEmojiSheet, Guild guild, boolean z2, boolean z3) {
        this.this$0 = widgetEmojiSheet;
        this.$guild$inlined = guild;
        this.$isUserPremium$inlined = z2;
        this.$isUserInGuild$inlined = z3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, Traits.Location.Section.EMOJI_SHEET_UPSELL, 2, null);
    }
}
