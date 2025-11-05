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
import b.a.k.b;
import com.discord.R;
import com.discord.databinding.ViewNitroBoostPerksBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.servers.guildboost.GuildBoostPerkViewAdapter;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import f0.e0.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildBoostPerkView.kt */
/* loaded from: classes2.dex */
public final class GuildBoostPerkView extends RelativeLayout {
    private GuildBoostPerkViewAdapter adapter;
    private final ViewNitroBoostPerksBinding binding;

    /* compiled from: GuildBoostPerkView.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostPerkView$configure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<Integer, Boolean, Integer> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        public final int invoke(@DrawableRes int i, boolean z2) {
            return z2 ? R.drawable.ic_check_green_24dp : i;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, Boolean bool) {
            return Integer.valueOf(invoke(num.intValue(), bool.booleanValue()));
        }
    }

    /* compiled from: GuildBoostPerkView.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.GuildBoostPerkView$initialize$1, reason: invalid class name */
    public static final class AnonymousClass1 implements RecyclerView.OnItemTouchListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            m.checkNotNullParameter(rv, "rv");
            m.checkNotNullParameter(e, "e");
            return e.getAction() == 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            m.checkNotNullParameter(rv, "rv");
            m.checkNotNullParameter(e, "e");
        }
    }

    public GuildBoostPerkView(Context context) {
        super(context);
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingA = ViewNitroBoostPerksBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewNitroBoostPerksBindingA, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingA;
    }

    private final void initialize() {
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = this.binding.c;
        m.checkNotNullExpressionValue(recyclerView, "binding.perksLevelContentsRecycler");
        this.adapter = (GuildBoostPerkViewAdapter) companion.configure(new GuildBoostPerkViewAdapter(recyclerView));
        this.binding.c.addOnItemTouchListener(new AnonymousClass1());
    }

    public final void configure(int premiumTier, int currentPremiumTier, long guildId) {
        List mutableList;
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        boolean z2 = currentPremiumTier >= premiumTier;
        if (z2) {
            this.binding.d.setBackgroundResource(R.drawable.drawable_bg_premium_guild_gradient);
        } else {
            this.binding.d.setBackgroundColor(ColorCompat.getThemedColor(this, R.attr.primary_700));
        }
        int boostsRequiredForTier$default = GuildBoostUtils.getBoostsRequiredForTier$default(GuildBoostUtils.INSTANCE, guildId, premiumTier, null, null, 12, null);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.perksLevelHeaderText");
        b.n(textView, premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? 0 : R.string.guild_settings_guild_premium_perks_title_tier_3 : R.string.guild_settings_guild_premium_perks_title_tier_2 : R.string.guild_settings_guild_premium_perks_title_tier_1, new Object[0], null, 4);
        int i = premiumTier != 1 ? premiumTier != 2 ? premiumTier != 3 ? 0 : z2 ? R.drawable.ic_perk_tier_3_boosted : R.drawable.ic_perk_tier_3_unboosted : z2 ? R.drawable.ic_perk_tier_2_boosted : R.drawable.ic_perk_tier_2_unboosted : z2 ? R.drawable.ic_perk_tier_1_boosted : R.drawable.ic_perk_tier_1_unboosted;
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.perksLevelHeaderText");
        DrawableCompat.setCompoundDrawablesCompat$default(textView2, i, 0, 0, 0, 14, (Object) null);
        this.binding.f.setTextColor(z2 ? ColorCompat.getColor(getContext(), R.color.white) : ColorCompat.getThemedColor(getContext(), R.attr.primary_300));
        TextView textView3 = this.binding.e;
        m.checkNotNullExpressionValue(textView3, "binding.perksLevelHeaderBoosts");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView3.setText(StringResourceUtilsKt.getQuantityString(resources, context, R.plurals.guild_settings_premium_guild_tier_requirement_required, boostsRequiredForTier$default, Integer.valueOf(boostsRequiredForTier$default)));
        TextView textView4 = this.binding.e;
        m.checkNotNullExpressionValue(textView4, "binding.perksLevelHeaderBoosts");
        textView4.setVisibility(z2 ^ true ? 0 : 8);
        CardView cardView = this.binding.g;
        m.checkNotNullExpressionValue(cardView, "binding.perksLevelHeaderUnlocked");
        cardView.setVisibility(z2 ? 0 : 8);
        TextView textView5 = this.binding.f2204b;
        m.checkNotNullExpressionValue(textView5, "binding.perksLevelContentsHeader");
        b.n(textView5, premiumTier != 1 ? R.string.guild_settings_guild_premium_perks_previous_perks : R.string.guild_settings_guild_premium_perks_base_perks, new Object[0], null, 4);
        boolean zIsThreadsEnabled = ThreadUtils.INSTANCE.isThreadsEnabled(guildId);
        if (premiumTier == 1) {
            int iInvoke = anonymousClass1.invoke(R.drawable.ic_smile_24dp, z2);
            PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
            mutableList = u.toMutableList((Collection) u.filterNotNull(n.mutableListOf(new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(iInvoke, b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_emoji, new Object[]{50, Integer.valueOf(premiumUtils.getGuildEmojiMaxCount(1, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_sticker_icon_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_sticker, new Object[]{15, Integer.valueOf(premiumUtils.getGuildStickerMaxCount(1, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_headset_blue_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_audio_quality, new Object[]{Integer.valueOf(GuildUtilsKt.getMaxVoiceBitrateKbps(1, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_nitro_gifs_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_1_animated_guild_icon, new Object[0], null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_image_library_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_1_splash, new Object[0], null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_guild_nitro_perk_stream_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_1_streaming, new Object[0], null, 4)))));
        } else if (premiumTier == 2) {
            GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem[] guildBoostPerkViewListItemArr = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem[8];
            int iInvoke2 = anonymousClass1.invoke(R.drawable.ic_smile_24dp, z2);
            PremiumUtils premiumUtils2 = PremiumUtils.INSTANCE;
            guildBoostPerkViewListItemArr[0] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(iInvoke2, b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_emoji, new Object[]{50, Integer.valueOf(premiumUtils2.getGuildEmojiMaxCount(2, false))}, null, 4));
            guildBoostPerkViewListItemArr[1] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_sticker_icon_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_sticker, new Object[]{15, Integer.valueOf(premiumUtils2.getGuildStickerMaxCount(2, false))}, null, 4));
            guildBoostPerkViewListItemArr[2] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_headset_blue_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_audio_quality, new Object[]{Integer.valueOf(GuildUtilsKt.getMaxVoiceBitrateKbps(2, false))}, null, 4));
            guildBoostPerkViewListItemArr[3] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_upload_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_upload_limit, new Object[]{b.j(this, R.string.file_size_mb, new Object[]{Integer.valueOf(premiumUtils2.getGuildMaxFileSizeMB(2))}, null, 4)}, null, 4));
            guildBoostPerkViewListItemArr[4] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_image_library_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_2_banner, new Object[0], null, 4));
            guildBoostPerkViewListItemArr[5] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_guild_nitro_perk_stream_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_2_streaming, new Object[0], null, 4));
            guildBoostPerkViewListItemArr[6] = zIsThreadsEnabled ? new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_thread_locked, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_2_thread_private, new Object[0], null, 4)) : null;
            guildBoostPerkViewListItemArr[7] = new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_person_shield_purple_24dp, z2), b.j(this, R.string.premium_guild_guild_role_icons, new Object[0], null, 4));
            mutableList = u.toMutableList((Collection) u.filterNotNull(n.mutableListOf(guildBoostPerkViewListItemArr)));
        } else if (premiumTier != 3) {
            mutableList = new ArrayList();
        } else {
            int iInvoke3 = anonymousClass1.invoke(R.drawable.ic_smile_24dp, z2);
            PremiumUtils premiumUtils3 = PremiumUtils.INSTANCE;
            mutableList = n.mutableListOf(new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(iInvoke3, b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_emoji, new Object[]{100, Integer.valueOf(premiumUtils3.getGuildEmojiMaxCount(3, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_sticker_icon_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_sticker, new Object[]{30, Integer.valueOf(premiumUtils3.getGuildStickerMaxCount(3, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_headset_blue_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_audio_quality, new Object[]{Integer.valueOf(GuildUtilsKt.getMaxVoiceBitrateKbps(3, false))}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_upload_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_any_upload_limit, new Object[]{b.j(this, R.string.file_size_mb, new Object[]{Integer.valueOf(premiumUtils3.getGuildMaxFileSizeMB(3))}, null, 4)}, null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_star_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_title_tier_3_vanity_url, new Object[0], null, 4)), new GuildBoostPerkViewAdapter.GuildBoostPerkViewListItem(anonymousClass1.invoke(R.drawable.ic_nitro_gifs_24dp, z2), b.j(this, R.string.guild_settings_guild_premium_perk_description_tier_3_animated_guild_banner, new Object[0], null, 4)));
        }
        GuildBoostPerkViewAdapter guildBoostPerkViewAdapter = this.adapter;
        if (guildBoostPerkViewAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        guildBoostPerkViewAdapter.configure(c.z(mutableList));
    }

    public GuildBoostPerkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingA = ViewNitroBoostPerksBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewNitroBoostPerksBindingA, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingA;
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
        m.checkNotNullParameter(context, "context");
        ViewNitroBoostPerksBinding viewNitroBoostPerksBindingA = ViewNitroBoostPerksBinding.a(LayoutInflater.from(getContext()), this, true);
        m.checkNotNullExpressionValue(viewNitroBoostPerksBindingA, "ViewNitroBoostPerksBindi…rom(context), this, true)");
        this.binding = viewNitroBoostPerksBindingA;
        initialize();
    }
}
