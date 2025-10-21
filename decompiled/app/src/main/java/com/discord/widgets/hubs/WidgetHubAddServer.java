package com.discord.widgets.hubs;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubAddServerBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.hubs.HubUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.GuildTemplateAnalytics;
import com.discord.widgets.nux.GuildTemplates2;
import com.discord.widgets.nux.WidgetGuildTemplates2;
import com.discord.widgets.nux.WidgetGuildTemplates3;
import com.discord.widgets.nux.WidgetGuildTemplates6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubAddServer.kt */
/* loaded from: classes2.dex */
public final class WidgetHubAddServer extends AppFragment {
    private static final int CHOOSE_GUILD = 0;
    private static final int GUILDS_ADDED = 1;
    private final SimpleRecyclerAdapter<Guild, DiscordHubAddServerViewHolder> adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> launcher;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetHubAddServer.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAddServerBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetHubAddServer.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void startScreenForResult(AppFragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            AppScreen2.g.f(fragment.requireContext(), HubUtils.getAddServerActivityResultHandler(fragment), WidgetHubAddServer.class, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetHubAddServer.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetHubAddServerViewModel2 $state;

        public AnonymousClass1(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            this.$state = widgetHubAddServerViewModel2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = WidgetHubAddServer.this.getContext();
            if (context != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
                AppScreen2 appScreen2 = AppScreen2.g;
                ActivityResultLauncher<Intent> activityResultLauncherAccess$getLauncher$p = WidgetHubAddServer.access$getLauncher$p(WidgetHubAddServer.this);
                CreateGuildTrigger createGuildTrigger = CreateGuildTrigger.DIRECTORY_CHANNEL;
                String string = FormatUtils.h(context, R.string.hub_create_or_add_guild_title, new Object[]{this.$state.getHubName()}, null, 4).toString();
                String string2 = context.getString(R.string.hub_create_or_add_guild_subtitle);
                Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…te_or_add_guild_subtitle)");
                appScreen2.f(context, activityResultLauncherAccess$getLauncher$p, WidgetGuildTemplates6.class, new WidgetGuildTemplates2(false, GuildTemplateAnalytics.IN_APP_LOCATION_TEMPLATE, createGuildTrigger, new WidgetGuildTemplates3(string, string2, GuildTemplates2.INSTANCE.getHUB(), false, true), true));
            }
        }
    }

    /* compiled from: WidgetHubAddServer.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$onServerClickListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHubAddServerViewModel2, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $isNewGuild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Context context, long j2, boolean z2) {
            super(1);
            this.$guildId = j;
            this.$context = context;
            this.$channelId = j2;
            this.$isNewGuild = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            invoke2(widgetHubAddServerViewModel2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            Object next;
            Intrinsics3.checkNotNullParameter(widgetHubAddServerViewModel2, "state");
            Iterator<T> it = widgetHubAddServerViewModel2.getAddedDirectories().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((DirectoryEntryGuild) next).getGuild().getId() == this.$guildId) {
                        break;
                    }
                }
            }
            DirectoryEntryGuild directoryEntryGuild = (DirectoryEntryGuild) next;
            if (directoryEntryGuild != null) {
                DirectoryUtils.INSTANCE.showServerOptions(WidgetHubAddServer.this, directoryEntryGuild, widgetHubAddServerViewModel2.getHubName(), true, new WidgetHubAddServer6(directoryEntryGuild, this, widgetHubAddServerViewModel2));
            } else {
                WidgetHubAddServer widgetHubAddServer = WidgetHubAddServer.this;
                AppScreen2.g(AppScreen2.g, widgetHubAddServer.getParentFragmentManager(), this.$context, WidgetHubDescription.class, 0, true, null, new WidgetHubDescriptionViewModel2(this.$guildId, this.$channelId, false, widgetHubAddServer.getViewModel().getHubName(), this.$isNewGuild, null, null, 96, null), 40);
            }
        }
    }

    /* compiled from: WidgetHubAddServer.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddServer$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetHubAddServerViewModel2, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            invoke2(widgetHubAddServerViewModel2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
            Intrinsics3.checkNotNullParameter(widgetHubAddServerViewModel2, "viewState");
            WidgetHubAddServer.access$configureUI(WidgetHubAddServer.this, widgetHubAddServerViewModel2);
        }
    }

    public WidgetHubAddServer() {
        super(R.layout.widget_hub_add_server);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubAddServer3.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubAddServerViewModel.class), new WidgetHubAddServer$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetHubAddServer8.INSTANCE));
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubAddServer2(this), 1, null);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetHubAddServer4(this));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul… isNewGuild = true) }\n  }");
        this.launcher = activityResultLauncherRegisterForActivityResult;
        this.loggingConfig = new AppLogger2(false, null, WidgetHubAddServer5.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubAddServer widgetHubAddServer, WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2) {
        widgetHubAddServer.configureUI(widgetHubAddServerViewModel2);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getLauncher$p(WidgetHubAddServer widgetHubAddServer) {
        return widgetHubAddServer.launcher;
    }

    public static final /* synthetic */ void access$onServerClickListener(WidgetHubAddServer widgetHubAddServer, long j, boolean z2) {
        widgetHubAddServer.onServerClickListener(j, z2);
    }

    private final void configureUI(WidgetHubAddServerViewModel2 state) {
        List<Guild> selectableGuilds;
        SimpleRecyclerAdapter<Guild, DiscordHubAddServerViewHolder> simpleRecyclerAdapter = this.adapter;
        int selectedIndex = state.getSelectedIndex();
        if (selectedIndex == 0) {
            selectableGuilds = state.getSelectableGuilds();
        } else if (selectedIndex != 1) {
            return;
        } else {
            selectableGuilds = state.getAddedGuilds();
        }
        simpleRecyclerAdapter.setData(selectableGuilds);
        getBinding().e.setSelectedIndex(state.getSelectedIndex());
        getBinding().c.setTitle(FormatUtils.k(this, R.string.hub_choose_guild_title, new Object[]{state.getHubName()}, null, 4));
        getBinding().f2468b.setOnClickListener(new AnonymousClass1(state));
    }

    private final void onServerClickListener(long guildId, boolean isNewGuild) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            Long channelId = getViewModel().getChannelId();
            if (channelId != null) {
                getViewModel().withViewState(new AnonymousClass1(guildId, context, channelId.longValue(), isNewGuild));
            }
        }
    }

    public static /* synthetic */ void onServerClickListener$default(WidgetHubAddServer widgetHubAddServer, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        widgetHubAddServer.onServerClickListener(j, z2);
    }

    public final SimpleRecyclerAdapter<Guild, DiscordHubAddServerViewHolder> getAdapter() {
        return this.adapter;
    }

    public final WidgetHubAddServerBinding getBinding() {
        return (WidgetHubAddServerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubAddServerViewModel getViewModel() {
        return (WidgetHubAddServerViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().d;
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        getBinding().g.setText(getString(R.string.hub_choose_guild_choose_tab));
        getBinding().f.setText(getString(R.string.hub_choose_guild_added_tab));
        SegmentedControlContainer segmentedControlContainer = getBinding().e;
        SegmentedControlContainer.b(segmentedControlContainer, 0, 1);
        segmentedControlContainer.setOnSegmentSelectedChangeListener(new WidgetHubAddServer7(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHubAddServer.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
