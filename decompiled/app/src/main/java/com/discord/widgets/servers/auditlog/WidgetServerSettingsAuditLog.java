package com.discord.widgets.servers.auditlog;

import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsAuditLogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetServerSettingsAuditLog.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsAuditLog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DIRECTION_DOWN = 1;
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final String INTENT_EXTRA_GUILD_NAME = "GUILD_NAME";
    private static final int RESULTS_VIEW_INDEX_LOGS = 0;
    private static final int RESULTS_VIEW_INDEX_NO_LOGS = 1;
    private static final int VIEW_INDEX_LOGS_CONTENT = 1;
    private static final int VIEW_INDEX_LOGS_LOADING = 0;
    private WidgetServerSettingsAuditLogAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private boolean loadingAuditLogs;
    private final LoggingConfig loggingConfig;

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId, String guildName) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(guildName, "guildName");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("AUDIT_LOG", guildId);
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsAuditLog.INTENT_EXTRA_GUILD_ID, guildId).putExtra(WidgetServerSettingsAuditLog.INTENT_EXTRA_GUILD_NAME, guildName);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_GUILD_NAME, guildName)");
            j.d(context, WidgetServerSettingsAuditLog.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    public static abstract class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: WidgetServerSettingsAuditLog.kt */
        public static final class Companion {

            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    ModelAuditLogEntry.TargetType.values();
                    int[] iArr = new int[15];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[ModelAuditLogEntry.TargetType.CHANNEL.ordinal()] = 1;
                    iArr[ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE.ordinal()] = 2;
                    iArr[ModelAuditLogEntry.TargetType.USER.ordinal()] = 3;
                    iArr[ModelAuditLogEntry.TargetType.ROLE.ordinal()] = 4;
                    iArr[ModelAuditLogEntry.TargetType.GUILD.ordinal()] = 5;
                    iArr[ModelAuditLogEntry.TargetType.INVITE.ordinal()] = 6;
                    iArr[ModelAuditLogEntry.TargetType.ALL.ordinal()] = 7;
                    iArr[ModelAuditLogEntry.TargetType.WEBHOOK.ordinal()] = 8;
                    iArr[ModelAuditLogEntry.TargetType.EMOJI.ordinal()] = 9;
                    iArr[ModelAuditLogEntry.TargetType.INTEGRATION.ordinal()] = 10;
                    iArr[ModelAuditLogEntry.TargetType.STAGE_INSTANCE.ordinal()] = 11;
                    iArr[ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT.ordinal()] = 12;
                    iArr[ModelAuditLogEntry.TargetType.THREAD.ordinal()] = 13;
                    iArr[ModelAuditLogEntry.TargetType.UNKNOWN.ordinal()] = 14;
                    iArr[ModelAuditLogEntry.TargetType.STICKER.ordinal()] = 15;
                }
            }

            private Companion() {
            }

            public static final /* synthetic */ String access$resolveChannelName(Companion companion, Map map, ModelAuditLogEntry modelAuditLogEntry) {
                return companion.resolveChannelName(map, modelAuditLogEntry);
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00ac  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private final String resolveChannelName(Map<Long, Channel> channels, ModelAuditLogEntry entry) {
                Object next;
                Object next2;
                Channel channel = channels.get(Long.valueOf(entry.getTargetId()));
                if (channel != null) {
                    boolean zV = ChannelUtils.v(channel);
                    if (zV) {
                        StringBuilder sbQ = a.Q(MentionUtilsKt.CHANNELS_CHAR);
                        sbQ.append(ChannelUtils.c(channel));
                        return sbQ.toString();
                    }
                    if (zV) {
                        throw new NoWhenBranchMatchedException();
                    }
                    return ChannelUtils.c(channel);
                }
                if (entry.getActionTypeId() == 12) {
                    List<ModelAuditLogEntry.Change> changes = entry.getChanges();
                    if (changes != null) {
                        Iterator<T> it = changes.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                next2 = null;
                                break;
                            }
                            next2 = it.next();
                            ModelAuditLogEntry.Change change = (ModelAuditLogEntry.Change) next2;
                            m.checkNotNullExpressionValue(change, "it");
                            if (m.areEqual(change.getKey(), ModelAuditLogEntry.CHANGE_KEY_NAME)) {
                                break;
                            }
                        }
                        ModelAuditLogEntry.Change change2 = (ModelAuditLogEntry.Change) next2;
                        Object oldValue = change2 != null ? change2.getOldValue() : null;
                        if (!(oldValue instanceof String)) {
                            oldValue = null;
                        }
                        String str = (String) oldValue;
                        List<ModelAuditLogEntry.Change> changes2 = entry.getChanges();
                        if (changes2 != null) {
                            Iterator<T> it2 = changes2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    next = null;
                                    break;
                                }
                                next = it2.next();
                                ModelAuditLogEntry.Change change3 = (ModelAuditLogEntry.Change) next;
                                m.checkNotNullExpressionValue(change3, "it");
                                if (m.areEqual(change3.getKey(), "type")) {
                                    break;
                                }
                            }
                            ModelAuditLogEntry.Change change4 = (ModelAuditLogEntry.Change) next;
                            Object oldValue2 = change4 != null ? change4.getOldValue() : null;
                            if (!(oldValue2 instanceof Long)) {
                                oldValue2 = null;
                            }
                            Long l = (Long) oldValue2;
                            if (str != null && l != null) {
                                boolean zL = ChannelUtils.l((int) l.longValue());
                                if (!zL) {
                                    if (zL) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    return str;
                                }
                                return MentionUtilsKt.CHANNELS_CHAR + str;
                            }
                        }
                    }
                }
                return null;
            }

            public final Observable<Model> get(long guildId, Context context) {
                m.checkNotNullParameter(context, "context");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableR = Observable.f(companion.getAuditLog().observeAuditLogState(guildId), companion.getGuilds().observeGuild(guildId), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), ObservableExtensionsKt.leadingEdgeThrottle(companion.getUsers().observeAllUsers(), 3L, TimeUnit.SECONDS), companion.getGuilds().observeRoles(guildId), companion.getGuilds().observeComputed(guildId), new WidgetServerSettingsAuditLog$Model$Companion$get$1(guildId, context)).r();
                m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetServerSettingsAuditLog.kt */
        public static final class Loaded extends Model {
            private final CharSequence actionFilterText;
            private final List<MGRecyclerDataPayload> auditLogEntryItems;
            private final CharSequence usernameFilterText;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends MGRecyclerDataPayload> list, CharSequence charSequence, CharSequence charSequence2) {
                super(null);
                m.checkNotNullParameter(list, "auditLogEntryItems");
                m.checkNotNullParameter(charSequence, "usernameFilterText");
                m.checkNotNullParameter(charSequence2, "actionFilterText");
                this.auditLogEntryItems = list;
                this.usernameFilterText = charSequence;
                this.actionFilterText = charSequence2;
            }

            public final CharSequence getActionFilterText() {
                return this.actionFilterText;
            }

            public final List<MGRecyclerDataPayload> getAuditLogEntryItems() {
                return this.auditLogEntryItems;
            }

            public final CharSequence getUsernameFilterText() {
                return this.usernameFilterText;
            }
        }

        /* compiled from: WidgetServerSettingsAuditLog.kt */
        public static final class Loading extends Model {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Menu> {

        /* compiled from: WidgetServerSettingsAuditLog.kt */
        /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        public static final class ViewOnClickListenerC04361 implements View.OnClickListener {

            /* compiled from: WidgetServerSettingsAuditLog.kt */
            /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C04371 implements PopupMenu.OnMenuItemClickListener {
                public final /* synthetic */ View $view;

                public C04371(View view) {
                    this.$view = view;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    m.checkNotNullExpressionValue(menuItem, "it");
                    switch (menuItem.getItemId()) {
                        case R.id.menu_audit_log_sort_actions /* 2131364361 */:
                            WidgetServerSettingsAuditLogFilter.INSTANCE.show(a.x(this.$view, "view", "view.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(WidgetServerSettingsAuditLog.this), 1);
                            return true;
                        case R.id.menu_audit_log_sort_users /* 2131364362 */:
                            WidgetServerSettingsAuditLogFilter.INSTANCE.show(a.x(this.$view, "view", "view.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(WidgetServerSettingsAuditLog.this), 0);
                            return true;
                        default:
                            return true;
                    }
                }
            }

            public ViewOnClickListenerC04361() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(WidgetServerSettingsAuditLog.this.getContext(), 2131951663), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_audit_log_sort, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new C04371(view));
                popupMenu.show();
            }
        }

        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            View actionView;
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_filter);
            if (menuItemFindItem == null || (actionView = menuItemFindItem.getActionView()) == null) {
                return;
            }
            actionView.setOnClickListener(new ViewOnClickListenerC04361());
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends RecyclerView.OnScrollListener {
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            m.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (recyclerView.canScrollVertically(1)) {
                return;
            }
            StoreStream.INSTANCE.getAuditLog().fetchMoreAuditLogEntries();
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsAuditLogFilter.INSTANCE.show(a.x(view, "it", "it.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(WidgetServerSettingsAuditLog.this), 0);
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsAuditLogFilter.INSTANCE.show(a.x(view, "it", "it.context"), WidgetServerSettingsAuditLog.access$getGuildId$p(WidgetServerSettingsAuditLog.this), 1);
        }
    }

    /* compiled from: WidgetServerSettingsAuditLog.kt */
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
            super(1, widgetServerSettingsAuditLog, WidgetServerSettingsAuditLog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            m.checkNotNullParameter(model, "p1");
            WidgetServerSettingsAuditLog.access$configureUI((WidgetServerSettingsAuditLog) this.receiver, model);
        }
    }

    public WidgetServerSettingsAuditLog() {
        super(R.layout.widget_server_settings_audit_log);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsAuditLog$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsAuditLog$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog, Model model) {
        widgetServerSettingsAuditLog.configureUI(model);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog) {
        return widgetServerSettingsAuditLog.guildId;
    }

    public static final /* synthetic */ void access$setGuildId$p(WidgetServerSettingsAuditLog widgetServerSettingsAuditLog, long j) {
        widgetServerSettingsAuditLog.guildId = j;
    }

    private final void configureUI(Model model) {
        if (model instanceof Model.Loading) {
            AppViewFlipper appViewFlipper = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsAuditLogsViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (model instanceof Model.Loaded) {
            WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter = this.adapter;
            if (widgetServerSettingsAuditLogAdapter != null) {
                widgetServerSettingsAuditLogAdapter.configure(((Model.Loaded) model).getAuditLogEntryItems());
            }
            AppViewFlipper appViewFlipper2 = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsAuditLogsViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.serverSettingsAuditLogsUserFilter");
            Model.Loaded loaded = (Model.Loaded) model;
            textView.setText(loaded.getUsernameFilterText());
            TextView textView2 = getBinding().f2539b;
            m.checkNotNullExpressionValue(textView2, "binding.serverSettingsAuditLogsActionFilter");
            textView2.setText(loaded.getActionFilterText());
            if (!loaded.getAuditLogEntryItems().isEmpty()) {
                AppViewFlipper appViewFlipper3 = getBinding().f;
                m.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsAuditLogsViewResultsFlipper");
                appViewFlipper3.setDisplayedChild(0);
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().f;
                m.checkNotNullExpressionValue(appViewFlipper4, "binding.serverSettingsAuditLogsViewResultsFlipper");
                appViewFlipper4.setDisplayedChild(1);
            }
            this.loadingAuditLogs = false;
        }
    }

    public static final void create(Context context, long j, String str) {
        INSTANCE.create(context, j, str);
    }

    private final WidgetServerSettingsAuditLogBinding getBinding() {
        return (WidgetServerSettingsAuditLogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            StoreStream.INSTANCE.getAuditLog().clearState();
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
        this.guildId = longExtra;
        if (longExtra == -1) {
            b.a.d.m.g(getContext(), R.string.crash_unexpected, 0, null, 12);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
        setActionBarTitle(R.string.guild_settings_label_audit_log);
        setActionBarSubtitle(getMostRecentIntent().getStringExtra(INTENT_EXTRA_GUILD_NAME));
        setActionBarOptionsMenu(R.menu.menu_filter, null, new AnonymousClass1());
        getBinding().c.addOnScrollListener(new AnonymousClass2());
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsAuditLogsRecycler");
        WidgetServerSettingsAuditLogAdapter widgetServerSettingsAuditLogAdapter = (WidgetServerSettingsAuditLogAdapter) companion.configure(new WidgetServerSettingsAuditLogAdapter(recyclerView));
        widgetServerSettingsAuditLogAdapter.setOnAuditLogAvatarClicked(new WidgetServerSettingsAuditLog$onViewBound$$inlined$apply$lambda$1(this));
        this.adapter = widgetServerSettingsAuditLogAdapter;
        getBinding().d.setOnClickListener(new AnonymousClass4());
        getBinding().f2539b.setOnClickListener(new AnonymousClass5());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(this.guildId, requireContext())), this, null, 2, null), WidgetServerSettingsAuditLog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
