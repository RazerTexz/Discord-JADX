package com.discord.utilities.directories;

import android.content.Context;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.a.e;
import b.a.d.j;
import b.a.k.b;
import b.a.y.b0;
import b.a.y.c0;
import com.discord.R;
import com.discord.analytics.generated.events.TrackHubEventCtaClicked;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.dialogs.SimpleConfirmationDialogArgs;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import com.discord.widgets.hubs.HubDescriptionArgs;
import com.discord.widgets.hubs.WidgetHubDescription;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import d0.t.m;
import d0.t.n;
import d0.t.u;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: DirectoryUtils.kt */
/* loaded from: classes2.dex */
public final class DirectoryUtils {
    public static final String JOIN_GUILD_SOURCE = "Directory Channel Entry";
    public static final DirectoryUtils INSTANCE = new DirectoryUtils();
    private static final List<DirectoryServerMenuOptions> SERVER_OWNER_MENU_OPTIONS = n.listOf((Object[]) new DirectoryServerMenuOptions[]{DirectoryServerMenuOptions.Edit, DirectoryServerMenuOptions.Remove});
    private static final List<DirectoryServerMenuOptions> NON_SERVER_OWNER_MENU_OPTIONS = m.listOf(DirectoryServerMenuOptions.Report);

    /* compiled from: DirectoryUtils.kt */
    public enum DirectoryServerMenuOptions {
        Edit(R.string.hub_entry_update, R.drawable.ic_edit_24dp),
        Remove(R.string.hub_entry_remove, R.drawable.ic_delete_24dp),
        Report(R.string.report, R.drawable.ic_flag_24dp);

        private final int iconRes;
        private final int titleRes;

        DirectoryServerMenuOptions(@StringRes int i, @DrawableRes int i2) {
            this.titleRes = i;
            this.iconRes = i2;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final int getTitleRes() {
            return this.titleRes;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DirectoryServerMenuOptions.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[DirectoryServerMenuOptions.Edit.ordinal()] = 1;
            iArr[DirectoryServerMenuOptions.Remove.ordinal()] = 2;
            iArr[DirectoryServerMenuOptions.Report.ordinal()] = 3;
        }
    }

    /* compiled from: DirectoryUtils.kt */
    /* renamed from: com.discord.utilities.directories.DirectoryUtils$maybeJoinAndGoToGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Guild, Unit> {
        public final /* synthetic */ AppBottomSheet $bottomSheet;
        public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
        public final /* synthetic */ boolean $shouldToggleRsvp;
        public final /* synthetic */ Function0 $toggleRsvp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, Function0 function0, GuildScheduledEvent guildScheduledEvent, AppBottomSheet appBottomSheet) {
            super(1);
            this.$shouldToggleRsvp = z2;
            this.$toggleRsvp = function0;
            this.$guildScheduledEvent = guildScheduledEvent;
            this.$bottomSheet = appBottomSheet;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            d0.z.d.m.checkNotNullParameter(guild, "it");
            if (this.$shouldToggleRsvp) {
                this.$toggleRsvp.invoke();
            }
            StoreStream.INSTANCE.getGuildSelected().set(this.$guildScheduledEvent.getGuildId());
            FragmentManager parentFragmentManager = this.$bottomSheet.getParentFragmentManager();
            d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "bottomSheet.parentFragmentManager");
            List<Fragment> fragments = parentFragmentManager.getFragments();
            d0.z.d.m.checkNotNullExpressionValue(fragments, "bottomSheet.parentFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof AppBottomSheet) {
                    ((AppBottomSheet) fragment).dismiss();
                }
            }
        }
    }

    /* compiled from: DirectoryUtils.kt */
    /* renamed from: com.discord.utilities.directories.DirectoryUtils$showServerOptions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Integer, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
        public final /* synthetic */ AppFragment $fragment;
        public final /* synthetic */ String $hubName;
        public final /* synthetic */ List $options;
        public final /* synthetic */ Function0 $removeGuildListener;

        /* compiled from: DirectoryUtils.kt */
        /* renamed from: com.discord.utilities.directories.DirectoryUtils$showServerOptions$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnonymousClass2.this.$removeGuildListener.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list, Context context, DirectoryEntryGuild directoryEntryGuild, String str, AppFragment appFragment, Function0 function0) {
            super(1);
            this.$options = list;
            this.$context = context;
            this.$directoryEntry = directoryEntryGuild;
            this.$hubName = str;
            this.$fragment = appFragment;
            this.$removeGuildListener = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            DirectoryServerMenuOptions directoryServerMenuOptions = (DirectoryServerMenuOptions) u.getOrNull(this.$options, i);
            if (directoryServerMenuOptions != null) {
                int iOrdinal = directoryServerMenuOptions.ordinal();
                if (iOrdinal == 0) {
                    j.d(this.$context, WidgetHubDescription.class, new HubDescriptionArgs(this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getDirectoryChannelId(), true, this.$hubName, false, this.$directoryEntry.getDescription(), Integer.valueOf(this.$directoryEntry.getPrimaryCategoryId()), 16, null));
                    return;
                }
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        return;
                    }
                    WidgetMobileReports.INSTANCE.launchDirectoryServerReport(this.$context, this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getEntityId(), this.$directoryEntry.getDirectoryChannelId());
                } else {
                    e.Companion cVar = e.INSTANCE;
                    FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
                    d0.z.d.m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                    cVar.a(childFragmentManager, new SimpleConfirmationDialogArgs(this.$fragment.getString(R.string.hub_entry_remove), b.h(this.$context, R.string.hub_entry_remove_body, new Object[]{this.$directoryEntry.getGuild().getName()}, null, 4).toString(), this.$fragment.getString(R.string.remove), this.$fragment.getString(R.string.cancel)), new AnonymousClass1());
                }
            }
        }
    }

    private DirectoryUtils() {
    }

    public final void logGuildScheduledEventClickAction(long guildScheduledEventId, long guildScheduledEventGuildId, long guildId, HubGuildScheduledEventClickType clickType) {
        d0.z.d.m.checkNotNullParameter(clickType, "clickType");
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        TrackHubEventCtaClicked trackHubEventCtaClicked = new TrackHubEventCtaClicked(Long.valueOf(guildScheduledEventId), Long.valueOf(guildScheduledEventGuildId), clickType.getType());
        trackHubEventCtaClicked.c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        tracker.track(trackHubEventCtaClicked);
    }

    public final void maybeJoinAndGoToGuild(AppBottomSheet bottomSheet, GuildScheduledEvent guildScheduledEvent, boolean isInGuild, long hubGuildId, long directoryChannelId, boolean shouldToggleRsvp, Function0<Unit> toggleRsvp) {
        d0.z.d.m.checkNotNullParameter(bottomSheet, "bottomSheet");
        d0.z.d.m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        d0.z.d.m.checkNotNullParameter(toggleRsvp, "toggleRsvp");
        if (isInGuild) {
            StoreStream.INSTANCE.getGuildSelected().set(guildScheduledEvent.getGuildId());
            bottomSheet.dismiss();
        } else {
            logGuildScheduledEventClickAction(guildScheduledEvent.getId(), guildScheduledEvent.getGuildId(), hubGuildId, HubGuildScheduledEventClickType.JoinServer);
            Context contextRequireContext = bottomSheet.requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "bottomSheet.requireContext()");
            GuildJoinHelperKt.joinGuild$default(contextRequireContext, guildScheduledEvent.getGuildId(), false, null, Long.valueOf(directoryChannelId), RestAPI.INSTANCE.getApi().jsonObjectOf(d0.o.to("source", JOIN_GUILD_SOURCE)), DirectoryUtils.class, null, null, null, new AnonymousClass1(shouldToggleRsvp, toggleRsvp, guildScheduledEvent, bottomSheet), 896, null);
        }
    }

    public final void showServerOptions(AppFragment fragment, DirectoryEntryGuild directoryEntry, String hubName, boolean isServerOwner, Function0<Unit> removeGuildListener) {
        d0.z.d.m.checkNotNullParameter(fragment, "fragment");
        d0.z.d.m.checkNotNullParameter(directoryEntry, "directoryEntry");
        d0.z.d.m.checkNotNullParameter(hubName, "hubName");
        d0.z.d.m.checkNotNullParameter(removeGuildListener, "removeGuildListener");
        Context context = fragment.getContext();
        if (context != null) {
            d0.z.d.m.checkNotNullExpressionValue(context, "fragment.context ?: return");
            List<DirectoryServerMenuOptions> list = isServerOwner ? SERVER_OWNER_MENU_OPTIONS : NON_SERVER_OWNER_MENU_OPTIONS;
            b0.Companion companion = b0.INSTANCE;
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            d0.z.d.m.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            String string = fragment.getString(R.string.server_settings);
            d0.z.d.m.checkNotNullExpressionValue(string, "fragment.getString(R.string.server_settings)");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            for (DirectoryServerMenuOptions directoryServerMenuOptions : list) {
                arrayList.add(new c0(fragment.getString(directoryServerMenuOptions.getTitleRes()), null, Integer.valueOf(directoryServerMenuOptions.getIconRes()), null, null, null, null, 122));
            }
            companion.a(childFragmentManager, string, arrayList, false, new AnonymousClass2(list, context, directoryEntry, hubName, fragment, removeGuildListener));
        }
    }
}
