package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventUpsellBottomSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventUpsellBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventUpsellBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventUpsellBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String GUILD_EVENT_UPSELL_CACHE_KEY = "GUILD_EVENT_UPSELL_CACHE_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(FragmentManager fragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildScheduledEventUpsellBottomSheet widgetGuildScheduledEventUpsellBottomSheet = new WidgetGuildScheduledEventUpsellBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            widgetGuildScheduledEventUpsellBottomSheet.setArguments(bundle);
            widgetGuildScheduledEventUpsellBottomSheet.show(fragmentManager, WidgetGuildScheduledEventUpsellBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Set<GuildFeature> features;
            Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(WidgetGuildScheduledEventUpsellBottomSheet.access$getGuildId$p(WidgetGuildScheduledEventUpsellBottomSheet.this));
            if (guild == null || (features = guild.getFeatures()) == null || !features.contains(GuildFeature.COMMUNITY)) {
                WidgetGuildProfileSheet.Companion companion = WidgetGuildProfileSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGuildScheduledEventUpsellBottomSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetGuildProfileSheet.Companion.show$default(companion, parentFragmentManager, true, WidgetGuildScheduledEventUpsellBottomSheet.access$getGuildId$p(WidgetGuildScheduledEventUpsellBottomSheet.this), 0L, true, 8, null);
            } else {
                WidgetGuildScheduledEventListBottomSheet.Companion companion2 = WidgetGuildScheduledEventListBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager2 = WidgetGuildScheduledEventUpsellBottomSheet.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                WidgetGuildScheduledEventListBottomSheet.Companion.show$default(companion2, parentFragmentManager2, WidgetGuildScheduledEventUpsellBottomSheet.access$getGuildId$p(WidgetGuildScheduledEventUpsellBottomSheet.this), null, 4, null);
            }
            WidgetGuildScheduledEventUpsellBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetGuildScheduledEventUpsellBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventUpsellBottomSheet.this.dismiss();
        }
    }

    public WidgetGuildScheduledEventUpsellBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventUpsellBottomSheet2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildScheduledEventUpsellBottomSheet3(this));
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventUpsellBottomSheet widgetGuildScheduledEventUpsellBottomSheet) {
        return widgetGuildScheduledEventUpsellBottomSheet.getGuildId();
    }

    private final WidgetGuildScheduledEventUpsellBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventUpsellBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_scheduled_event_upsell_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().f2450b.setOnClickListener(new AnonymousClass2());
    }
}
