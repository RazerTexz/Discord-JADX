package com.discord.widgets.stickers;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.models.guild.Guild;
import com.discord.utilities.analytics.Traits;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetGuildStickerSheet.kt */
/* renamed from: com.discord.widgets.stickers.WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGuildStickerSheet3 implements View.OnClickListener {
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $isUserInGuild$inlined;
    public final /* synthetic */ boolean $isUserPremium$inlined;
    public final /* synthetic */ WidgetGuildStickerSheet this$0;

    public WidgetGuildStickerSheet3(WidgetGuildStickerSheet widgetGuildStickerSheet, Guild guild, boolean z2, boolean z3) {
        this.this$0 = widgetGuildStickerSheet;
        this.$guild$inlined = guild;
        this.$isUserPremium$inlined = z2;
        this.$isUserInGuild$inlined = z3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        StickerPremiumUpsellDialog.Companion companion = StickerPremiumUpsellDialog.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, new Traits.Location(null, Traits.Location.Section.STICKER_POPOUT, null, null, null, 29, null));
    }
}
