package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.premium.GuildBoostUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.chip.Chip;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.ViewGuildBoostConfirmationBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: GuildBoostConfirmationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostConfirmationView extends CardView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewGuildBoostConfirmationBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostConfirmationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.view_guild_boost_confirmation, this);
        int i = C5419R.id.guild_boost_confirmation_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.guild_boost_confirmation_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.guild_boost_confirmation_guild_name;
            TextView textView = (TextView) findViewById(C5419R.id.guild_boost_confirmation_guild_name);
            if (textView != null) {
                i = C5419R.id.guild_boost_confirmation_level_info_previous;
                Chip chip = (Chip) findViewById(C5419R.id.guild_boost_confirmation_level_info_previous);
                if (chip != null) {
                    i = C5419R.id.guild_boost_confirmation_level_info_upgrade;
                    Chip chip2 = (Chip) findViewById(C5419R.id.guild_boost_confirmation_level_info_upgrade);
                    if (chip2 != null) {
                        i = C5419R.id.guild_boost_confirmation_upgrade_arrow;
                        ImageView imageView = (ImageView) findViewById(C5419R.id.guild_boost_confirmation_upgrade_arrow);
                        if (imageView != null) {
                            ViewGuildBoostConfirmationBinding viewGuildBoostConfirmationBinding = new ViewGuildBoostConfirmationBinding(this, simpleDraweeView, textView, chip, chip2, imageView);
                            Intrinsics3.checkNotNullExpressionValue(viewGuildBoostConfirmationBinding, "ViewGuildBoostConfirmati…ater.from(context), this)");
                            this.binding = viewGuildBoostConfirmationBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: b */
    public final void m8592b(Guild guild, int netNewSubscriptions) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        int boostTier$default = GuildBoostUtils.getBoostTier$default(GuildBoostUtils.INSTANCE, guild.getId(), guild.getPremiumSubscriptionCount() + netNewSubscriptions, null, null, 12, null);
        char c = boostTier$default > guild.getPremiumTier() ? (char) 1 : boostTier$default < guild.getPremiumTier() ? (char) 2 : (char) 3;
        SimpleDraweeView simpleDraweeView = this.binding.f1020b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildBoostConfirmationAvatar");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForGuild$default(guild, null, false, null, 14, null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = this.binding.f1021c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostConfirmationGuildName");
        textView.setText(guild.getName());
        Chip chip = this.binding.f1022d;
        Intrinsics3.checkNotNullExpressionValue(chip, "binding.guildBoostConfirmationLevelInfoPrevious");
        chip.setChipIcon(ContextCompat.getDrawable(getContext(), m8593c(guild.getPremiumTier())));
        Chip chip2 = this.binding.f1022d;
        Intrinsics3.checkNotNullExpressionValue(chip2, "binding.guildBoostConfirmationLevelInfoPrevious");
        chip2.setText(m8594d(guild.getPremiumTier()));
        ImageView imageView = this.binding.f1024f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildBoostConfirmationUpgradeArrow");
        imageView.setVisibility(c != 3 ? 0 : 8);
        Chip chip3 = this.binding.f1023e;
        Intrinsics3.checkNotNullExpressionValue(chip3, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip3.setVisibility(c != 3 ? 0 : 8);
        if (c == 3) {
            return;
        }
        int i = c == 2 ? C5419R.color.status_red_500 : C5419R.color.status_green_600;
        ImageView imageView2 = this.binding.f1024f;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildBoostConfirmationUpgradeArrow");
        ColorCompat2.tintWithColorResource(imageView2, i);
        Chip chip4 = this.binding.f1023e;
        Intrinsics3.checkNotNullExpressionValue(chip4, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip4.setChipIcon(ContextCompat.getDrawable(getContext(), m8593c(boostTier$default)));
        Chip chip5 = this.binding.f1023e;
        Intrinsics3.checkNotNullExpressionValue(chip5, "binding.guildBoostConfirmationLevelInfoUpgrade");
        chip5.setText(m8594d(boostTier$default));
    }

    /* JADX INFO: renamed from: c */
    public final int m8593c(int boostTier) {
        if (boostTier == 0) {
            return C5419R.drawable.ic_guild_nitro_progress_banner;
        }
        if (boostTier == 1) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.guild_boost_badge_tier_1, 0, 2, (Object) null);
        }
        if (boostTier == 2) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            return DrawableCompat.getThemedDrawableRes$default(context2, C5419R.attr.guild_boost_badge_tier_2, 0, 2, (Object) null);
        }
        if (boostTier != 3) {
            return 0;
        }
        Context context3 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context3, "context");
        return DrawableCompat.getThemedDrawableRes$default(context3, C5419R.attr.guild_boost_badge_tier_3, 0, 2, (Object) null);
    }

    /* JADX INFO: renamed from: d */
    public final String m8594d(int boostTier) {
        String string = boostTier != 0 ? boostTier != 1 ? boostTier != 2 ? boostTier != 3 ? "" : getContext().getString(C5419R.string.premium_guild_tier_3) : getContext().getString(C5419R.string.premium_guild_tier_2) : getContext().getString(C5419R.string.premium_guild_tier_1) : getContext().getString(C5419R.string.premium_guild_header_badge_no_tier);
        Intrinsics3.checkNotNullExpressionValue(string, "when (boostTier) {\n     …       else -> \"\"\n      }");
        return string;
    }
}
