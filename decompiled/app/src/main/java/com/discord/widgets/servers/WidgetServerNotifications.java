package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.a.i.z1;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerNotificationsBinding;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.servers.NotificationHighlightsSettingsView;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.discord.widgets.servers.NotificationsOverridesAdapter;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetServerNotifications.kt */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerNotifications.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerNotificationsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager notificationSettingsRadioManager;
    private NotificationsOverridesAdapter overrideAdapter;

    /* compiled from: WidgetServerNotifications.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$getNotificationOverrides(Companion companion, long j) {
            return companion.getNotificationOverrides(j);
        }

        private final Observable<List<NotificationsOverridesAdapter.Item>> getNotificationOverrides(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.i(companion.getUserGuildSettings().observeGuildSettings(guildId).G(WidgetServerNotifications$Companion$getNotificationOverrides$1.INSTANCE), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), GuildChannelsInfo.INSTANCE.get(guildId), WidgetServerNotifications$Companion$getNotificationOverrides$2.INSTANCE);
        }

        public final void launch(long guildId, Context context) {
            m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE….EXTRA_GUILD_ID, guildId)");
            j.d(context, WidgetServerNotifications.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer approximateMemberCount;
        private final Guild guild;
        private final StoreGuildProfiles.GuildProfileData guildProfile;
        private final ModelNotificationSettings guildSettings;
        private final boolean highlightsEnabled;
        private final boolean isAboveHighlightsSize;
        private final boolean isAboveNotifyAllSize;
        private final int notificationsSetting;

        /* compiled from: WidgetServerNotifications.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getGuilds().observeGuild(guildId), companion.getUserGuildSettings().observeGuildSettings(guildId), companion.getGuildProfiles().observeGuildProfile(guildId), WidgetServerNotifications$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableI, "Observable\n          .co…  } else null\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationBuffered(observableI).r();
                m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
                return observableR;
            }

            public final boolean isValid(Guild guild, ModelNotificationSettings guildSettings) {
                return (guild == null || guildSettings == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData) {
            GuildPreview data;
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(modelNotificationSettings, "guildSettings");
            this.guild = guild;
            this.guildSettings = modelNotificationSettings;
            this.guildProfile = guildProfileData;
            this.notificationsSetting = modelNotificationSettings.getMessageNotifications() != ModelNotificationSettings.FREQUENCY_UNSET ? modelNotificationSettings.getMessageNotifications() : guild.getDefaultMessageNotifications();
            Integer approximateMemberCount = (guildProfileData == null || (data = guildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
            this.approximateMemberCount = approximateMemberCount;
            this.isAboveNotifyAllSize = approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
            boolean zIsHighlightsSettingsEnabled = GrowthTeamFeatures.INSTANCE.isHighlightsSettingsEnabled();
            this.highlightsEnabled = zIsHighlightsSettingsEnabled;
            this.isAboveHighlightsSize = zIsHighlightsSettingsEnabled && approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                modelNotificationSettings = model.guildSettings;
            }
            if ((i & 4) != 0) {
                guildProfileData = model.guildProfile;
            }
            return model.copy(guild, modelNotificationSettings, guildProfileData);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelNotificationSettings getGuildSettings() {
            return this.guildSettings;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final Model copy(Guild guild, ModelNotificationSettings guildSettings, StoreGuildProfiles.GuildProfileData guildProfile) {
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(guildSettings, "guildSettings");
            return new Model(guild, guildSettings, guildProfile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.guild, model.guild) && m.areEqual(this.guildSettings, model.guildSettings) && m.areEqual(this.guildProfile, model.guildProfile);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildProfiles.GuildProfileData getGuildProfile() {
            return this.guildProfile;
        }

        public final ModelNotificationSettings getGuildSettings() {
            return this.guildSettings;
        }

        public final boolean getHighlightsEnabled() {
            return this.highlightsEnabled;
        }

        public final int getNotificationsSetting() {
            return this.notificationsSetting;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            ModelNotificationSettings modelNotificationSettings = this.guildSettings;
            int iHashCode2 = (iHashCode + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
            StoreGuildProfiles.GuildProfileData guildProfileData = this.guildProfile;
            return iHashCode2 + (guildProfileData != null ? guildProfileData.hashCode() : 0);
        }

        /* renamed from: isAboveHighlightsSize, reason: from getter */
        public final boolean getIsAboveHighlightsSize() {
            return this.isAboveHighlightsSize;
        }

        /* renamed from: isAboveNotifyAllSize, reason: from getter */
        public final boolean getIsAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", guildSettings=");
            sbU.append(this.guildSettings);
            sbU.append(", guildProfile=");
            sbU.append(this.guildProfile);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;
        public final /* synthetic */ int $type;

        public AnonymousClass1(Model model, int i) {
            this.$model = model;
            this.$type = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserGuildSettings().setGuildFrequency(a.x(view, "view", "view.context"), this.$model.getGuild(), this.$type);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            NotificationHighlightsSettingsView notificationHighlightsSettingsView = WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).j;
            m.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
            Context context = notificationHighlightsSettingsView.getContext();
            m.checkNotNullExpressionValue(context, "binding.serverNotificationsHighlights.context");
            userGuildSettings.setNotifyHighlights(context, this.$model.getGuild(), i);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            CheckedSetting checkedSetting = WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).d;
            m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
            Context context = checkedSetting.getContext();
            m.checkNotNullExpressionValue(context, "binding.serverNotificationsEveryoneSwitch.context");
            StoreUserGuildSettings.setGuildToggles$default(userGuildSettings, context, this.$model.getGuild(), Boolean.valueOf(!this.$model.getGuildSettings().isSuppressEveryone()), null, null, null, 32, null);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            CheckedSetting checkedSetting = WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).q;
            m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsRolesSwitch");
            Context context = checkedSetting.getContext();
            m.checkNotNullExpressionValue(context, "binding.serverNotificationsRolesSwitch.context");
            StoreUserGuildSettings.setGuildToggles$default(userGuildSettings, context, this.$model.getGuild(), null, Boolean.valueOf(!this.$model.getGuildSettings().isSuppressRoles()), null, null, 32, null);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass4(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).o.toggle();
            StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            CheckedSetting checkedSetting = WidgetServerNotifications.access$getBinding$p(WidgetServerNotifications.this).o;
            m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsPushSwitch");
            Context context = checkedSetting.getContext();
            m.checkNotNullExpressionValue(context, "binding.serverNotificationsPushSwitch.context");
            userGuildSettings.setGuildToggles(context, this.$model.getGuild(), null, null, null, Boolean.valueOf(!this.$model.getGuildSettings().isMobilePush()));
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$createSwipeableItemTouchHelper$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SwipeableItemTouchHelper {
        public final /* synthetic */ SwipeableItemTouchHelper.SwipeRevealConfiguration $deleteConfig;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration, SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration2, SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration3) {
            super(0, 0, swipeRevealConfiguration2, swipeRevealConfiguration3, 3, null);
            this.$deleteConfig = swipeRevealConfiguration;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            m.checkNotNullParameter(viewHolder, "viewHolder");
            NotificationsOverridesAdapter.Item item = (NotificationsOverridesAdapter.Item) u.getOrNull(WidgetServerNotifications.access$getOverrideAdapter$p(WidgetServerNotifications.this).getData(), viewHolder.getAdapterPosition());
            if (item != null) {
                Channel channel = item.getChannel();
                if (item.getOverrideSettings().isMuted()) {
                    StoreUserGuildSettings.setChannelMuted$default(StoreStream.INSTANCE.getUserGuildSettings(), WidgetServerNotifications.this.requireContext(), channel.getId(), false, null, 8, null);
                }
                StoreStream.INSTANCE.getUserGuildSettings().setChannelFrequency(WidgetServerNotifications.this.requireContext(), channel, ModelNotificationSettings.FREQUENCY_UNSET);
            }
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<View, NotificationsOverridesAdapter.Item, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, NotificationsOverridesAdapter.Item item) {
            invoke2(view, item);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, NotificationsOverridesAdapter.Item item) {
            m.checkNotNullParameter(view, "itemView");
            m.checkNotNullParameter(item, "item");
            WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "itemView.context");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, context, item.getChannel().getId(), false, 4, null);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerNotificationsOverrideSelector.INSTANCE.launch(a.x(view, "it", "it.context"), this.$guildId);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerNotifications.access$configureUI(WidgetServerNotifications.this, model);
        }
    }

    /* compiled from: WidgetServerNotifications.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerNotifications$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<List<? extends NotificationsOverridesAdapter.Item>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends NotificationsOverridesAdapter.Item> list) {
            invoke2((List<NotificationsOverridesAdapter.Item>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<NotificationsOverridesAdapter.Item> list) {
            NotificationsOverridesAdapter notificationsOverridesAdapterAccess$getOverrideAdapter$p = WidgetServerNotifications.access$getOverrideAdapter$p(WidgetServerNotifications.this);
            m.checkNotNullExpressionValue(list, "it");
            notificationsOverridesAdapterAccess$getOverrideAdapter$p.setData(list);
        }
    }

    public WidgetServerNotifications() {
        super(R.layout.widget_server_notifications);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerNotifications$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerNotifications widgetServerNotifications, Model model) throws Exception {
        widgetServerNotifications.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerNotificationsBinding access$getBinding$p(WidgetServerNotifications widgetServerNotifications) {
        return widgetServerNotifications.getBinding();
    }

    public static final /* synthetic */ NotificationsOverridesAdapter access$getOverrideAdapter$p(WidgetServerNotifications widgetServerNotifications) {
        NotificationsOverridesAdapter notificationsOverridesAdapter = widgetServerNotifications.overrideAdapter;
        if (notificationsOverridesAdapter == null) {
            m.throwUninitializedPropertyAccessException("overrideAdapter");
        }
        return notificationsOverridesAdapter;
    }

    public static final /* synthetic */ void access$setOverrideAdapter$p(WidgetServerNotifications widgetServerNotifications, NotificationsOverridesAdapter notificationsOverridesAdapter) {
        widgetServerNotifications.overrideAdapter = notificationsOverridesAdapter;
    }

    private final void configureForHub() {
        View view = getBinding().h;
        m.checkNotNullExpressionValue(view, "binding.serverNotificationsFrequencyDivider");
        view.setVisibility(8);
        LinearLayout linearLayout = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout, "binding.serverNotificationsFrequencyWrap");
        linearLayout.setVisibility(8);
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting.setVisibility(8);
        View view2 = getBinding().p;
        m.checkNotNullExpressionValue(view2, "binding.serverNotificationsRolesDivider");
        view2.setVisibility(8);
        CheckedSetting checkedSetting2 = getBinding().q;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.serverNotificationsRolesSwitch");
        checkedSetting2.setVisibility(8);
        CheckedSetting checkedSetting3 = getBinding().o;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.serverNotificationsPushSwitch");
        checkedSetting3.setVisibility(8);
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.serverNotificationsOverrideTitle");
        textView.setVisibility(8);
        z1 z1Var = getBinding().f2538b;
        m.checkNotNullExpressionValue(z1Var, "binding.addOverride");
        ConstraintLayout constraintLayout = z1Var.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.addOverride.root");
        constraintLayout.setVisibility(8);
        View view3 = getBinding().m;
        m.checkNotNullExpressionValue(view3, "binding.serverNotificationsOverrideDivider");
        view3.setVisibility(8);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsOverrideList");
        recyclerView.setVisibility(8);
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = getBinding().j;
        m.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        notificationHighlightsSettingsView.setVisibility(8);
        View view4 = getBinding().k;
        m.checkNotNullExpressionValue(view4, "binding.serverNotificationsHighlightsDivider");
        view4.setVisibility(8);
    }

    @MainThread
    private final void configureRadio(CheckedSetting radio, int type, Model model) {
        if (model.getNotificationsSetting() == type) {
            RadioManager radioManager = this.notificationSettingsRadioManager;
            if (radioManager == null) {
                m.throwUninitializedPropertyAccessException("notificationSettingsRadioManager");
            }
            radioManager.a(radio);
        }
        if (model.getIsAboveNotifyAllSize() && type == ModelNotificationSettings.FREQUENCY_ALL) {
            CharSequence charSequenceK = b.k(this, R.string.large_guild_notify_all_messages_description, new Object[0], null, 4);
            int i = CheckedSetting.j;
            radio.h(charSequenceK, false);
        } else {
            int i2 = CheckedSetting.j;
            radio.h(null, false);
        }
        radio.e(new AnonymousClass1(model, type));
    }

    private final void configureUI(Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.notification_settings);
        setActionBarSubtitle(model.getGuild().getName());
        ModelNotificationSettings guildSettings = model.getGuildSettings();
        boolean zIsMuted = guildSettings.isMuted();
        long id2 = model.getGuild().getId();
        View view = getBinding().h;
        m.checkNotNullExpressionValue(view, "binding.serverNotificationsFrequencyDivider");
        view.setVisibility(zIsMuted ^ true ? 0 : 8);
        LinearLayout linearLayout = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout, "binding.serverNotificationsFrequencyWrap");
        linearLayout.setVisibility(zIsMuted ^ true ? 0 : 8);
        getBinding().l.updateView(new NotificationMuteSettingsView.ViewState(zIsMuted, guildSettings.getMuteEndTime(), b.h(requireContext(), R.string.form_label_mute_server, new Object[]{model.getGuild().getName()}, null, 4), b.h(requireContext(), R.string.form_label_unmute_server, new Object[]{model.getGuild().getName()}, null, 4), b.h(requireContext(), R.string.form_label_mobile_server_muted, new Object[0], null, 4), R.string.form_label_mobile_server_muted_until, b.h(requireContext(), R.string.form_label_mute_server_description, new Object[0], null, 4)), new WidgetServerNotifications$configureUI$onMute$1(this, id2), new WidgetServerNotifications$configureUI$onUnmute$1(this, id2));
        if (model.getGuild().isHub()) {
            configureForHub();
            return;
        }
        NotificationHighlightsSettingsView.ViewState viewState = new NotificationHighlightsSettingsView.ViewState(model.getGuildSettings().isMuted(), model.getGuildSettings().getNotifyHighlights(), model.getIsAboveHighlightsSize());
        NotificationHighlightsSettingsView notificationHighlightsSettingsView = getBinding().j;
        m.checkNotNullExpressionValue(notificationHighlightsSettingsView, "binding.serverNotificationsHighlights");
        notificationHighlightsSettingsView.setVisibility(model.getHighlightsEnabled() ? 0 : 8);
        View view2 = getBinding().k;
        m.checkNotNullExpressionValue(view2, "binding.serverNotificationsHighlightsDivider");
        view2.setVisibility(model.getHighlightsEnabled() ? 0 : 8);
        if (model.getHighlightsEnabled()) {
            getBinding().j.updateView(viewState, new AnonymousClass1(model));
        }
        getBinding().d.setOnCheckedListener(new AnonymousClass2(model));
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting.setChecked(model.getGuildSettings().isSuppressEveryone());
        CheckedSetting checkedSetting2 = getBinding().d;
        CheckedSetting checkedSetting3 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.serverNotificationsEveryoneSwitch");
        checkedSetting2.setText(b.j(checkedSetting3, R.string.form_label_suppress_everyone, new Object[0], null, 4));
        getBinding().q.setOnCheckedListener(new AnonymousClass3(model));
        CheckedSetting checkedSetting4 = getBinding().q;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.serverNotificationsRolesSwitch");
        checkedSetting4.setChecked(model.getGuildSettings().isSuppressRoles());
        CheckedSetting checkedSetting5 = getBinding().q;
        CheckedSetting checkedSetting6 = getBinding().q;
        m.checkNotNullExpressionValue(checkedSetting6, "binding.serverNotificationsRolesSwitch");
        checkedSetting5.setText(b.j(checkedSetting6, R.string.form_label_suppress_roles, new Object[0], null, 4));
        CheckedSetting checkedSetting7 = getBinding().o;
        m.checkNotNullExpressionValue(checkedSetting7, "binding.serverNotificationsPushSwitch");
        checkedSetting7.setChecked(model.getGuildSettings().isMobilePush() && !model.getGuildSettings().isMuted());
        if (model.getGuildSettings().isMuted()) {
            CheckedSetting.d(getBinding().o, null, 1);
        } else {
            getBinding().o.e(new AnonymousClass4(model));
        }
        CheckedSetting checkedSetting8 = getBinding().f;
        CheckedSetting checkedSetting9 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting9, "binding.serverNotificationsFrequency1Radio");
        checkedSetting8.setText(b.j(checkedSetting9, R.string.form_label_only_mentions, new Object[0], null, 4));
        CheckedSetting checkedSetting10 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting10, "binding.serverNotificationsFrequency0Radio");
        configureRadio(checkedSetting10, ModelNotificationSettings.FREQUENCY_ALL, model);
        CheckedSetting checkedSetting11 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting11, "binding.serverNotificationsFrequency1Radio");
        configureRadio(checkedSetting11, ModelNotificationSettings.FREQUENCY_MENTIONS, model);
        CheckedSetting checkedSetting12 = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting12, "binding.serverNotificationsFrequency2Radio");
        configureRadio(checkedSetting12, ModelNotificationSettings.FREQUENCY_NOTHING, model);
    }

    private final ItemTouchHelper createSwipeableItemTouchHelper() {
        SwipeableItemTouchHelper.SwipeRevealConfiguration swipeRevealConfiguration = new SwipeableItemTouchHelper.SwipeRevealConfiguration(ColorCompat.getColor(this, R.color.status_red_500), ContextCompat.getDrawable(requireContext(), R.drawable.ic_delete_white_24dp), DimenUtils.dpToPixels(8));
        return new ItemTouchHelper(new AnonymousClass1(swipeRevealConfiguration, swipeRevealConfiguration, swipeRevealConfiguration));
    }

    private final WidgetServerNotificationsBinding getBinding() {
        return (WidgetServerNotificationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.notificationSettingsRadioManager = new RadioManager(n.listOf((Object[]) new CheckedSetting[]{getBinding().e, getBinding().f, getBinding().g}));
        this.overrideAdapter = new NotificationsOverridesAdapter(AnonymousClass1.INSTANCE);
        RecyclerView recyclerView = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsOverrideList");
        recyclerView.setNestedScrollingEnabled(false);
        RecyclerView recyclerView2 = getBinding().c;
        m.checkNotNullExpressionValue(recyclerView2, "binding.guildNotificationsOverrideList");
        NotificationsOverridesAdapter notificationsOverridesAdapter = this.overrideAdapter;
        if (notificationsOverridesAdapter == null) {
            m.throwUninitializedPropertyAccessException("overrideAdapter");
        }
        recyclerView2.setAdapter(notificationsOverridesAdapter);
        createSwipeableItemTouchHelper().attachToRecyclerView(getBinding().c);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        z1 z1Var = getBinding().f2538b;
        m.checkNotNullExpressionValue(z1Var, "binding.addOverride");
        z1Var.a.setOnClickListener(new AnonymousClass2(longExtra));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), WidgetServerNotifications.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable observableAccess$getNotificationOverrides = Companion.access$getNotificationOverrides(INSTANCE, longExtra);
        m.checkNotNullExpressionValue(observableAccess$getNotificationOverrides, "getNotificationOverrides(guildId)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(observableAccess$getNotificationOverrides), this, null, 2, null), WidgetServerNotifications.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
