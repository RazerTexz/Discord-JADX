package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.ViewNitroBoostPerksBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.servers.guildboost.GuildBoostPerkViewAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p600f0.p601e0.Util7;

/* compiled from: GuildBoostPerkView.kt */
/* loaded from: classes2.dex */
public final class GuildBoostPerkView extends RelativeLayout {
    private GuildBoostPerkViewAdapter adapter;
    private final ViewNitroBoostPerksBinding binding;

    /* compiled from: GuildBoostPerkView.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostPerkView$configure$1 */
    public static final class C94981 extends Lambda implements Function2<Integer, Boolean, Integer> {
        public static final C94981 INSTANCE = new C94981();

        public C94981() {
            super(2);
        }

        public final int invoke(@DrawableRes int i, boolean z2) {
            return z2 ? C5419R.drawable.ic_check_green_24dp : i;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, Boolean bool) {
            return Integer.valueOf(invoke(num.intValue(), bool.booleanValue()));
        }
    }

    /* compiled from: GuildBoostPerkView.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostPerkView$initialize$1 */
    public static final class C94991 implements RecyclerView.OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            Intrinsics3.checkNotNullParameter(rv, "rv");
            Intrinsics3.checkNotNullParameter(e, "e");
            return e.getAction() == 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            Intrinsics3.checkNotNullParameter(rv, "rv");
            Intrinsics3.checkNotNullParameter(e, "e");
        }
    }

    public GuildBoostPerkView(Context context) {
        super(context);
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingM8400a = ViewNitroBoostPerksBinding.m8400a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewNitroBoostPerksBindingM8400a, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingM8400a;
    }

    private final void initialize() {
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = this.binding.f15522c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.perksLevelContentsRecycler");
        this.adapter = (GuildBoostPerkViewAdapter) companion.configure(new GuildBoostPerkViewAdapter(recyclerView));
        this.binding.f15522c.addOnItemTouchListener(new C94991());
    }

    public final void configure(int premiumTier, int currentPremiumTier, long guildId) {
        List mutableList;
        C94981 c94981 = C94981.INSTANCE;
        boolean z2 = currentPremiumTier >= premiumTier;
        if (z2) {
            this.binding.f15523d.setBackgroundResource(C5419R.drawable.drawable_bg_premium_guild_gradient);
        } else {
            this.binding.f15523d.setBackgroundColor(ColorCompat.getThemedColor(this, C5419R.attr.primary_700));
        }
        int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, null, null, 12, null);
        TextView textView = this.binding.f15525f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.perksLevelHeaderText");
        FormatUtils.m222n(textView, premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? 0 : C5419R.string.guild_settings_guild_premium_perks_title_tier_3 : C5419R.string.guild_settings_guild_premium_perks_title_tier_2 : C5419R.string.guild_settings_guild_premium_perks_title_tier_1, new Object[0], null, 4);
        int i = premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? 0 : z2 ? C5419R.drawable.ic_perk_tier_3_boosted : C5419R.drawable.ic_perk_tier_3_unboosted : z2 ? C5419R.drawable.ic_perk_tier_2_boosted : C5419R.drawable.ic_perk_tier_2_unboosted : z2 ? C5419R.drawable.ic_perk_tier_1_boosted : C5419R.drawable.ic_perk_tier_1_unboosted;
        TextView textView2 = this.binding.f15525f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.perksLevelHeaderText");
        DrawableCompat.setCompoundDrawablesCompat$default(textView2, i, 0, 0, 0, 14, (Object) null);
        this.binding.f15525f.setTextColor(z2 ? ColorCompat.getColor(getContext(), C5419R.color.white) : ColorCompat.getThemedColor(getContext(), C5419R.attr.primary_300));
        TextView textView3 = this.binding.f15524e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.perksLevelHeaderBoosts");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView3.setText(StringResourceUtils.getQuantityString(resources, context, C5419R.plurals.guild_settings_premium_guild_tier_requirement_required, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default)));
        TextView textView4 = this.binding.f15524e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.perksLevelHeaderBoosts");
        textView4.setVisibility(z2 ^ true ? 0 : 8);
        CardView cardView = this.binding.f15526g;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.perksLevelHeaderUnlocked");
        cardView.setVisibility(z2 ? 0 : 8);
        TextView textView5 = this.binding.f15521b;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.perksLevelContentsHeader");
        FormatUtils.m222n(textView5, premiumTier != 1 ? C5419R.string.guild_settings_guild_premium_perks_previous_perks : C5419R.string.guild_settings_guild_premium_perks_base_perks, new Object[0], null, 4);
        boolean zIsThreadsEnabled = ThreadUtils.INSTANCE.isThreadsEnabled(guildId);
        if (premiumTier == 1) {
            int iInvoke = c94981.invoke(C5419R.drawable.ic_smile_24dp, z2);
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            mutableList = _Collections.toMutableList((Collection) _Collections.filterNotNull(Collections2.mutableListOf(new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(iInvoke, FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_emoji, new Object[]{50, Integer.valueOf(premiumUtils.getGuildEmojiMaxCount(1, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_sticker_icon_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_sticker, new Object[]{15, Integer.valueOf(premiumUtils.getGuildStickerMaxCount(1, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_headset_blue_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_audio_quality, new Object[]{Integer.valueOf(GuildUtils.getMaxVoiceBitrateKbps(1, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_nitro_gifs_24dp, z2), FormatUtils.m218j(this, C5419R.string.f14748xa9bebeaa, new Object[0], null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_image_library_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_1_splash, new Object[0], null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_guild_nitro_perk_stream_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_1_streaming, new Object[0], null, 4)))));
        } else if (premiumTier == 2) {
            GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem[] guildBoostPerkViewListItemArr = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem[8];
            int iInvoke2 = c94981.invoke(C5419R.drawable.ic_smile_24dp, z2);
            PremiumUtils premiumUtils2 = PremiumUtils.INSTANCE;
            guildBoostPerkViewListItemArr[0] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(iInvoke2, FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_emoji, new Object[]{50, Integer.valueOf(premiumUtils2.getGuildEmojiMaxCount(2, false))}, null, 4));
            guildBoostPerkViewListItemArr[1] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_sticker_icon_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_sticker, new Object[]{15, Integer.valueOf(premiumUtils2.getGuildStickerMaxCount(2, false))}, null, 4));
            guildBoostPerkViewListItemArr[2] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_headset_blue_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_audio_quality, new Object[]{Integer.valueOf(GuildUtils.getMaxVoiceBitrateKbps(2, false))}, null, 4));
            guildBoostPerkViewListItemArr[3] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_upload_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_upload_limit, new Object[]{FormatUtils.m218j(this, C5419R.string.file_size_mb, new Object[]{Integer.valueOf(premiumUtils2.getGuildMaxFileSizeMB(2))}, null, 4)}, null, 4));
            guildBoostPerkViewListItemArr[4] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_image_library_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_2_banner, new Object[0], null, 4));
            guildBoostPerkViewListItemArr[5] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_guild_nitro_perk_stream_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_2_streaming, new Object[0], null, 4));
            guildBoostPerkViewListItemArr[6] = zIsThreadsEnabled ? new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_thread_locked, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_2_thread_private, new Object[0], null, 4)) : null;
            guildBoostPerkViewListItemArr[7] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_person_shield_purple_24dp, z2), FormatUtils.m218j(this, C5419R.string.premium_guild_guild_role_icons, new Object[0], null, 4));
            mutableList = _Collections.toMutableList((Collection) _Collections.filterNotNull(Collections2.mutableListOf(guildBoostPerkViewListItemArr)));
        } else if (premiumTier != 3) {
            mutableList = new ArrayList();
        } else {
            int iInvoke3 = c94981.invoke(C5419R.drawable.ic_smile_24dp, z2);
            PremiumUtils premiumUtils3 = PremiumUtils.INSTANCE;
            mutableList = Collections2.mutableListOf(new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(iInvoke3, FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_emoji, new Object[]{100, Integer.valueOf(premiumUtils3.getGuildEmojiMaxCount(3, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_sticker_icon_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_sticker, new Object[]{30, Integer.valueOf(premiumUtils3.getGuildStickerMaxCount(3, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_headset_blue_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_audio_quality, new Object[]{Integer.valueOf(GuildUtils.getMaxVoiceBitrateKbps(3, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_upload_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_any_upload_limit, new Object[]{FormatUtils.m218j(this, C5419R.string.file_size_mb, new Object[]{Integer.valueOf(premiumUtils3.getGuildMaxFileSizeMB(3))}, null, 4)}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_star_24dp, z2), FormatUtils.m218j(this, C5419R.string.guild_settings_guild_premium_perk_title_tier_3_vanity_url, new Object[0], null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(c94981.invoke(C5419R.drawable.ic_nitro_gifs_24dp, z2), FormatUtils.m218j(this, C5419R.string.f14745x2bca96bb, new Object[0], null, 4)));
        }
        GuildBoostPerkViewAdapter guildBoostPerkViewAdapter = this.adapter;
        if (guildBoostPerkViewAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        guildBoostPerkViewAdapter.configure(Util7.m10145z(mutableList));
    }

    public GuildBoostPerkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingM8400a = ViewNitroBoostPerksBinding.m8400a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewNitroBoostPerksBindingM8400a, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingM8400a;
        initialize();
    }

    public /* synthetic */ GuildBoostPerkView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public /* synthetic */ GuildBoostPerkView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostPerkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingM8400a = ViewNitroBoostPerksBinding.m8400a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(viewNitroBoostPerksBindingM8400a, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingM8400a;
        initialize();
    }
}
