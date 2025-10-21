package com.discord.widgets.chat.input.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.discord.models.guild.Guild;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildIcon.kt */
/* loaded from: classes2.dex */
public final class GuildIcon extends SimpleDraweeView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIcon(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public final void updateView(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        if (guild.hasIcon()) {
            int mediaProxySize = IconUtils.getMediaProxySize(getLayoutParams().width);
            MGImages.setImage$default(this, Intrinsics3.stringPlus(IconUtils.getForGuild$default(guild, null, false, null, 10, null), "?size=" + mediaProxySize), getLayoutParams().width, getLayoutParams().height, false, null, null, 112, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildIcon(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildIcon(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
