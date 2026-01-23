package com.discord.views.guildboost;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.premium.GuildBoostUtils;
import p007b.p008a.p025i.ViewPremiumGuildProgressBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: GuildBoostProgressView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostProgressView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewPremiumGuildProgressBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_premium_guild_progress, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.progress_gem_icon;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.progress_gem_icon);
        if (imageView != null) {
            i = C5419R.id.progress_level_text;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.progress_level_text);
            if (textView != null) {
                i = C5419R.id.progress_progress;
                ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(C5419R.id.progress_progress);
                if (progressBar != null) {
                    ViewPremiumGuildProgressBinding viewPremiumGuildProgressBinding = new ViewPremiumGuildProgressBinding((FrameLayout) viewInflate, imageView, textView, progressBar);
                    Intrinsics3.checkNotNullExpressionValue(viewPremiumGuildProgressBinding, "ViewPremiumGuildProgress…rom(context), this, true)");
                    this.binding = viewPremiumGuildProgressBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8596a(long guildId, int premiumTier, int premiumSubscriptionCount) {
        ImageView imageView = this.binding.f1374b;
        int themedDrawableRes$default = 0;
        if (premiumTier == 0) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(context, C5419R.attr.boosted_guild_tier_0, 0, 2, (Object) null);
        } else if (premiumTier == 1) {
            themedDrawableRes$default = C5419R.drawable.ic_boosted_guild_tier_1;
        } else if (premiumTier == 2) {
            themedDrawableRes$default = C5419R.drawable.ic_boosted_guild_tier_2;
        } else if (premiumTier == 3) {
            themedDrawableRes$default = C5419R.drawable.ic_boosted_guild_tier_3;
        }
        imageView.setImageResource(themedDrawableRes$default);
        TextView textView = this.binding.f1375c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.progressLevelText");
        textView.setText(premiumTier != 0 ? premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? "" : getContext().getString(C5419R.string.premium_guild_tier_3) : getContext().getString(C5419R.string.premium_guild_tier_2) : getContext().getString(C5419R.string.premium_guild_tier_1) : getContext().getString(C5419R.string.premium_guild_header_badge_no_tier));
        ProgressBar progressBar = this.binding.f1376d;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.progressProgress");
        progressBar.setProgress(GuildBoostUtils.calculatePercentToNextTier$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, premiumSubscriptionCount, null, null, 24, null));
    }
}
