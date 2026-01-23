package com.discord.utilities.directories;

import android.content.Context;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.analytics.generated.events.TrackHubEventCtaClicked;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.utils.hubs.HubGuildScheduledEventClickType;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.dialogs.SimpleConfirmationDialog2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import com.discord.widgets.hubs.WidgetHubDescription;
import com.discord.widgets.hubs.WidgetHubDescriptionViewModel2;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p009a.SimpleConfirmationDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.SelectorBottomSheet;
import p007b.p008a.p062y.SelectorBottomSheet2;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtils {
    public static final String JOIN_GUILD_SOURCE = "Directory Channel Entry";
    public static final DirectoryUtils INSTANCE = new DirectoryUtils();
    private static final List<DirectoryServerMenuOptions> SERVER_OWNER_MENU_OPTIONS = Collections2.listOf((Object[]) new DirectoryServerMenuOptions[]{DirectoryServerMenuOptions.Edit, DirectoryServerMenuOptions.Remove});
    private static final List<DirectoryServerMenuOptions> NON_SERVER_OWNER_MENU_OPTIONS = CollectionsJVM.listOf(DirectoryServerMenuOptions.Report);

    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public enum DirectoryServerMenuOptions {
        Edit(C5419R.string.hub_entry_update, C5419R.drawable.ic_edit_24dp),
        Remove(C5419R.string.hub_entry_remove, C5419R.drawable.ic_delete_24dp),
        Report(C5419R.string.report, C5419R.drawable.ic_flag_24dp);

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

    /* JADX INFO: renamed from: com.discord.utilities.directories.DirectoryUtils$maybeJoinAndGoToGuild$1 */
    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public static final class C67421 extends Lambda implements Function1<Guild, Unit> {
        public final /* synthetic */ AppBottomSheet $bottomSheet;
        public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
        public final /* synthetic */ boolean $shouldToggleRsvp;
        public final /* synthetic */ Function0 $toggleRsvp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67421(boolean z2, Function0 function0, GuildScheduledEvent guildScheduledEvent, AppBottomSheet appBottomSheet) {
            super(1);
            this.$shouldToggleRsvp = z2;
            this.$toggleRsvp = function0;
            this.$guildScheduledEvent = guildScheduledEvent;
            this.$bottomSheet = appBottomSheet;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            if (this.$shouldToggleRsvp) {
                this.$toggleRsvp.invoke();
            }
            StoreStream.INSTANCE.getGuildSelected().set(this.$guildScheduledEvent.getGuildId());
            FragmentManager parentFragmentManager = this.$bottomSheet.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "bottomSheet.parentFragmentManager");
            List<Fragment> fragments = parentFragmentManager.getFragments();
            Intrinsics3.checkNotNullExpressionValue(fragments, "bottomSheet.parentFragmentManager.fragments");
            for (Fragment fragment : fragments) {
                if (fragment instanceof AppBottomSheet) {
                    ((AppBottomSheet) fragment).dismiss();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.directories.DirectoryUtils$showServerOptions$2 */
    /* JADX INFO: compiled from: DirectoryUtils.kt */
    public static final class C67432 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ DirectoryEntryGuild $directoryEntry;
        public final /* synthetic */ AppFragment $fragment;
        public final /* synthetic */ String $hubName;
        public final /* synthetic */ List $options;
        public final /* synthetic */ Function0 $removeGuildListener;

        /* JADX INFO: renamed from: com.discord.utilities.directories.DirectoryUtils$showServerOptions$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: DirectoryUtils.kt */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C67432.this.$removeGuildListener.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67432(List list, Context context, DirectoryEntryGuild directoryEntryGuild, String str, AppFragment appFragment, Function0 function0) {
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
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            DirectoryServerMenuOptions directoryServerMenuOptions = (DirectoryServerMenuOptions) _Collections.getOrNull(this.$options, i);
            if (directoryServerMenuOptions != null) {
                int iOrdinal = directoryServerMenuOptions.ordinal();
                if (iOrdinal == 0) {
                    AppScreen2.m156d(this.$context, WidgetHubDescription.class, new WidgetHubDescriptionViewModel2(this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getDirectoryChannelId(), true, this.$hubName, false, this.$directoryEntry.getDescription(), Integer.valueOf(this.$directoryEntry.getPrimaryCategoryId()), 16, null));
                    return;
                }
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        return;
                    }
                    WidgetMobileReports.INSTANCE.launchDirectoryServerReport(this.$context, this.$directoryEntry.getGuild().getId(), this.$directoryEntry.getEntityId(), this.$directoryEntry.getDirectoryChannelId());
                } else {
                    SimpleConfirmationDialog.Companion cVar = SimpleConfirmationDialog.INSTANCE;
                    FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                    cVar.m128a(childFragmentManager, new SimpleConfirmationDialog2(this.$fragment.getString(C5419R.string.hub_entry_remove), FormatUtils.m216h(this.$context, C5419R.string.hub_entry_remove_body, new Object[]{this.$directoryEntry.getGuild().getName()}, null, 4).toString(), this.$fragment.getString(C5419R.string.remove), this.$fragment.getString(C5419R.string.cancel)), new AnonymousClass1());
                }
            }
        }
    }

    private DirectoryUtils() {
    }

    public final void logGuildScheduledEventClickAction(long guildScheduledEventId, long guildScheduledEventGuildId, long guildId, HubGuildScheduledEventClickType clickType) {
        Intrinsics3.checkNotNullParameter(clickType, "clickType");
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        TrackHubEventCtaClicked trackHubEventCtaClicked = new TrackHubEventCtaClicked(Long.valueOf(guildScheduledEventId), Long.valueOf(guildScheduledEventGuildId), clickType.getType());
        trackHubEventCtaClicked.mo7508c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        tracker.track(trackHubEventCtaClicked);
    }

    public final void maybeJoinAndGoToGuild(AppBottomSheet bottomSheet, GuildScheduledEvent guildScheduledEvent, boolean isInGuild, long hubGuildId, long directoryChannelId, boolean shouldToggleRsvp, Function0<Unit> toggleRsvp) {
        Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        Intrinsics3.checkNotNullParameter(toggleRsvp, "toggleRsvp");
        if (isInGuild) {
            StoreStream.INSTANCE.getGuildSelected().set(guildScheduledEvent.getGuildId());
            bottomSheet.dismiss();
        } else {
            logGuildScheduledEventClickAction(guildScheduledEvent.getId(), guildScheduledEvent.getGuildId(), hubGuildId, HubGuildScheduledEventClickType.JoinServer);
            Context contextRequireContext = bottomSheet.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "bottomSheet.requireContext()");
            GuildJoinHelper.joinGuild$default(contextRequireContext, guildScheduledEvent.getGuildId(), false, null, Long.valueOf(directoryChannelId), RestAPI.INSTANCE.getApi().jsonObjectOf(Tuples.m10073to("source", JOIN_GUILD_SOURCE)), DirectoryUtils.class, null, null, null, new C67421(shouldToggleRsvp, toggleRsvp, guildScheduledEvent, bottomSheet), 896, null);
        }
    }

    public final void showServerOptions(AppFragment fragment, DirectoryEntryGuild directoryEntry, String hubName, boolean isServerOwner, Function0<Unit> removeGuildListener) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        Intrinsics3.checkNotNullParameter(removeGuildListener, "removeGuildListener");
        Context context = fragment.getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "fragment.context ?: return");
            List<DirectoryServerMenuOptions> list = isServerOwner ? SERVER_OWNER_MENU_OPTIONS : NON_SERVER_OWNER_MENU_OPTIONS;
            SelectorBottomSheet.Companion companion = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            String string = fragment.getString(C5419R.string.server_settings);
            Intrinsics3.checkNotNullExpressionValue(string, "fragment.getString(R.string.server_settings)");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (DirectoryServerMenuOptions directoryServerMenuOptions : list) {
                arrayList.add(new SelectorBottomSheet2(fragment.getString(directoryServerMenuOptions.getTitleRes()), null, Integer.valueOf(directoryServerMenuOptions.getIconRes()), null, null, null, null, 122));
            }
            companion.m379a(childFragmentManager, string, arrayList, false, new C67432(list, context, directoryEntry, hubName, fragment, removeGuildListener));
        }
    }
}
