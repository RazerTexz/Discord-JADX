package com.discord.widgets.voice.settings;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.n;
import b.a.d.j;
import b.a.i.s4;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildVoiceRegions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.voice.Bitrate;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action2;

/* compiled from: WidgetVoiceChannelSettings.kt */
/* loaded from: classes.dex */
public final class WidgetVoiceChannelSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetVoiceChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    /* compiled from: WidgetVoiceChannelSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long channelId, Context context) {
            m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetVoiceChannelSettings.INTENT_EXTRA_CHANNEL_ID, channelId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
            j.d(context, WidgetVoiceChannelSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageChannel;
        private final boolean canManagePermissions;
        private final Channel channel;
        private final long guildID;
        private final int maxBitrate;
        private final List<ModelVoiceRegion> regions;

        /* compiled from: WidgetVoiceChannelSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreChannels channels = companion.getChannels();
                StoreGuilds guilds = companion.getGuilds();
                StoreUser users = companion.getUsers();
                StorePermissions permissions = companion.getPermissions();
                StoreGuildVoiceRegions guildVoiceRegions = companion.getGuildVoiceRegions();
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{channels, guilds, StoreUser.INSTANCE.getMeUpdate(), permissions, guildVoiceRegions, companion.getExperiments()}, false, null, null, new WidgetVoiceChannelSettings$Model$Companion$get$1(channels, channelId, guilds, permissions, users, guildVoiceRegions), 14, null)).r();
                m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, boolean z2, boolean z3, int i, List<? extends ModelVoiceRegion> list, long j) {
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(list, "regions");
            this.channel = channel;
            this.canManageChannel = z2;
            this.canManagePermissions = z3;
            this.maxBitrate = i;
            this.regions = list;
            this.guildID = j;
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, boolean z2, boolean z3, int i, List list, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                channel = model.channel;
            }
            if ((i2 & 2) != 0) {
                z2 = model.canManageChannel;
            }
            boolean z4 = z2;
            if ((i2 & 4) != 0) {
                z3 = model.canManagePermissions;
            }
            boolean z5 = z3;
            if ((i2 & 8) != 0) {
                i = model.maxBitrate;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                list = model.regions;
            }
            List list2 = list;
            if ((i2 & 32) != 0) {
                j = model.guildID;
            }
            return model.copy(channel, z4, z5, i3, list2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        /* renamed from: component4, reason: from getter */
        public final int getMaxBitrate() {
            return this.maxBitrate;
        }

        public final List<ModelVoiceRegion> component5() {
            return this.regions;
        }

        /* renamed from: component6, reason: from getter */
        public final long getGuildID() {
            return this.guildID;
        }

        public final Model copy(Channel channel, boolean canManageChannel, boolean canManagePermissions, int maxBitrate, List<? extends ModelVoiceRegion> regions, long guildID) {
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(regions, "regions");
            return new Model(channel, canManageChannel, canManagePermissions, maxBitrate, regions, guildID);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.maxBitrate == model.maxBitrate && m.areEqual(this.regions, model.regions) && this.guildID == model.guildID;
        }

        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final long getGuildID() {
            return this.guildID;
        }

        public final int getMaxBitrate() {
            return this.maxBitrate;
        }

        public final List<ModelVoiceRegion> getRegions() {
            return this.regions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.canManageChannel;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.canManagePermissions;
            int i3 = (((i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.maxBitrate) * 31;
            List<ModelVoiceRegion> list = this.regions;
            return b.a(this.guildID) + ((i3 + (list != null ? list.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", canManageChannel=");
            sbU.append(this.canManageChannel);
            sbU.append(", canManagePermissions=");
            sbU.append(this.canManagePermissions);
            sbU.append(", maxBitrate=");
            sbU.append(this.maxBitrate);
            sbU.append(", regions=");
            sbU.append(this.regions);
            sbU.append(", guildID=");
            return a.C(sbU, this.guildID, ")");
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass1(Model model) {
            this.$this_configureUI = model;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            m.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_channel_settings_delete) {
                return;
            }
            WidgetVoiceChannelSettings.access$confirmDelete(WidgetVoiceChannelSettings.this, this.$this_configureUI.getChannel());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends b.a.y.j {
        public AnonymousClass2() {
        }

        @Override // b.a.y.j, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            m.checkNotNullParameter(seekBar, "seekBar");
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).n;
            m.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
            textView.setText(WidgetVoiceChannelSettings.access$getUserLimitDisplayString(WidgetVoiceChannelSettings.this, progress));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends b.a.y.j {
        public AnonymousClass3() {
        }

        @Override // b.a.y.j, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            m.checkNotNullParameter(seekBar, "seekBar");
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).m;
            m.checkNotNullExpressionValue(textView, "binding.currentBitrateDisplay");
            textView.setText(WidgetVoiceChannelSettings.access$getBitrateDisplayString(WidgetVoiceChannelSettings.this, Bitrate.MIN.getKbps() + progress));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass4(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceChannelSettings.access$showRegionDialog(WidgetVoiceChannelSettings.this, this.$this_configureUI.getRegions());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass5(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(WidgetVoiceChannelSettings.this.requireContext(), this.$this_configureUI.getChannel().getId());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass6(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceChannelSettings widgetVoiceChannelSettings = WidgetVoiceChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            StatefulViews statefulViewsAccess$getState$p = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextInputLayout textInputLayout = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            String str = (String) statefulViewsAccess$getState$p.get(textInputLayout.getId(), ChannelUtils.c(this.$this_configureUI.getChannel()));
            StatefulViews statefulViewsAccess$getState$p2 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextInputLayout textInputLayout2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditTopic");
            int id3 = textInputLayout2.getId();
            String topic = this.$this_configureUI.getChannel().getTopic();
            if (topic == null) {
                topic = "";
            }
            String str2 = (String) statefulViewsAccess$getState$p2.get(id3, topic);
            CheckedSetting checkedSetting = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).e;
            m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
            Boolean boolValueOf = Boolean.valueOf(checkedSetting.isChecked());
            int type = this.$this_configureUI.getChannel().getType();
            SeekBar seekBar = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).t;
            m.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
            int progress = seekBar.getProgress();
            SeekBar seekBar2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f2702b;
            m.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
            int kbps = (Bitrate.MIN.getKbps() + seekBar2.getProgress()) * 1000;
            StatefulViews statefulViewsAccess$getState$p3 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
            m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
            WidgetVoiceChannelSettings.access$saveChannel(widgetVoiceChannelSettings, id2, str, type, str2, boolValueOf, progress, kbps, (String) statefulViewsAccess$getState$p3.get(textView.getId(), this.$this_configureUI.getChannel().getRtcRegion()));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetVoiceChannelSettings.kt */
        /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C04872 extends o implements Function1<Channel, Unit> {
            public C04872() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                m.checkNotNullParameter(channel, "channel");
                Integer numB = ChannelUtils.b(channel);
                if (numB != null) {
                    b.a.d.m.i(WidgetVoiceChannelSettings.this, numB.intValue(), 0, 4);
                }
            }
        }

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(this.$channel.getId()), false, 1, null), WidgetVoiceChannelSettings.this, null, 2, null);
            m.checkNotNullExpressionValue(view, "v");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, view.getContext(), "javaClass", (Function1) null, new C04872(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetVoiceChannelSettings.access$configureUI(WidgetVoiceChannelSettings.this, model);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$saveChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            b.a.d.m.g(WidgetVoiceChannelSettings.this.getContext(), R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$showRegionDialog$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Integer, Unit> {
        public final /* synthetic */ List $regions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list) {
            super(1);
            this.$regions = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            if (i == 0) {
                StatefulViews statefulViewsAccess$getState$p = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
                TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
                m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
                statefulViewsAccess$getState$p.put(textView.getId(), null);
                TextView textView2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
                m.checkNotNullExpressionValue(textView2, "binding.channelSettingsRegionOverride");
                textView2.setText(b.a.k.b.k(WidgetVoiceChannelSettings.this, R.string.automatic_region, new Object[0], null, 4));
            } else {
                StatefulViews statefulViewsAccess$getState$p2 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
                TextView textView3 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
                m.checkNotNullExpressionValue(textView3, "binding.channelSettingsRegionOverride");
                int i2 = i - 1;
                statefulViewsAccess$getState$p2.put(textView3.getId(), ((ModelVoiceRegion) this.$regions.get(i2)).getId());
                TextView textView4 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).g;
                m.checkNotNullExpressionValue(textView4, "binding.channelSettingsRegionOverride");
                textView4.setText(((ModelVoiceRegion) this.$regions.get(i2)).getName());
            }
            WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this).configureSaveActionView(WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).j);
        }
    }

    public WidgetVoiceChannelSettings() {
        super(R.layout.widget_voice_channel_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetVoiceChannelSettings$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.channel_settings_edit_name, R.id.channel_settings_edit_topic, R.id.current_user_limit_display, R.id.current_bitrate_display, R.id.channel_settings_region_override, R.id.channel_settings_nsfw);
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceChannelSettings widgetVoiceChannelSettings, Model model) {
        widgetVoiceChannelSettings.configureUI(model);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetVoiceChannelSettings widgetVoiceChannelSettings, Channel channel) {
        widgetVoiceChannelSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetVoiceChannelSettingsBinding access$getBinding$p(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        return widgetVoiceChannelSettings.getBinding();
    }

    public static final /* synthetic */ String access$getBitrateDisplayString(WidgetVoiceChannelSettings widgetVoiceChannelSettings, int i) {
        return widgetVoiceChannelSettings.getBitrateDisplayString(i);
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetVoiceChannelSettings widgetVoiceChannelSettings) {
        return widgetVoiceChannelSettings.state;
    }

    public static final /* synthetic */ CharSequence access$getUserLimitDisplayString(WidgetVoiceChannelSettings widgetVoiceChannelSettings, int i) {
        return widgetVoiceChannelSettings.getUserLimitDisplayString(i);
    }

    public static final /* synthetic */ void access$saveChannel(WidgetVoiceChannelSettings widgetVoiceChannelSettings, long j, String str, int i, String str2, Boolean bool, int i2, int i3, String str3) {
        widgetVoiceChannelSettings.saveChannel(j, str, i, str2, bool, i2, i3, str3);
    }

    public static final /* synthetic */ void access$showRegionDialog(WidgetVoiceChannelSettings widgetVoiceChannelSettings, List list) {
        widgetVoiceChannelSettings.showRegionDialog(list);
    }

    private final void configureRegionOverrideVisibility(boolean isVisible) {
        View view = getBinding().o;
        m.checkNotNullExpressionValue(view, "binding.regionOverrideDivider");
        view.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().h;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsRegionOverrideContainer");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverrideHelp");
        textView.setVisibility(isVisible ? 0 : 8);
    }

    private final void configureUI(Model model) {
        Object next;
        String string;
        if (model == null || !(model.getCanManageChannel() || model.getCanManagePermissions())) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.state.clear(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_voice_channel_settings, new AnonymousClass1(model), null, 4, null);
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
        StatefulViews statefulViews = this.state;
        TextView textView2 = getBinding().n;
        m.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        textView.setText((CharSequence) statefulViews.get(textView2.getId(), getUserLimitDisplayString(model.getChannel().getUserLimit())));
        TextView textView3 = getBinding().r;
        m.checkNotNullExpressionValue(textView3, "binding.settingsUserLimitHelp");
        b.a.k.b.n(textView3, R.string.form_help_user_limit, new Object[0], null, 4);
        SeekBar seekBar = getBinding().t;
        m.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
        seekBar.setProgress(model.getChannel().getUserLimit());
        getBinding().t.setOnSeekBarChangeListener(new AnonymousClass2());
        configureUserLimitVisibility(model.getChannel().getType() == 2);
        int bitrate = model.getChannel().getBitrate() / 1000;
        TextView textView4 = getBinding().m;
        m.checkNotNullExpressionValue(textView4, "binding.currentBitrateDisplay");
        StatefulViews statefulViews2 = this.state;
        TextView textView5 = getBinding().m;
        m.checkNotNullExpressionValue(textView5, "binding.currentBitrateDisplay");
        textView4.setText((CharSequence) statefulViews2.get(textView5.getId(), getBitrateDisplayString(bitrate)));
        TextView textView6 = getBinding().p;
        m.checkNotNullExpressionValue(textView6, "binding.settingsBitrateHelp");
        b.a.k.b.n(textView6, R.string.form_help_bitrate, new Object[]{"64"}, null, 4);
        SeekBar seekBar2 = getBinding().f2702b;
        m.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
        int maxBitrate = model.getMaxBitrate();
        Bitrate bitrate2 = Bitrate.MIN;
        seekBar2.setMax(maxBitrate - bitrate2.getKbps());
        SeekBar seekBar3 = getBinding().f2702b;
        m.checkNotNullExpressionValue(seekBar3, "binding.bitrateSeekbar");
        seekBar3.setProgress(bitrate - bitrate2.getKbps());
        getBinding().f2702b.setOnSeekBarChangeListener(new AnonymousClass3());
        StatefulViews statefulViews3 = this.state;
        TextView textView7 = getBinding().g;
        m.checkNotNullExpressionValue(textView7, "binding.channelSettingsRegionOverride");
        String str = (String) statefulViews3.get(textView7.getId(), model.getChannel().getRtcRegion());
        Iterator<T> it = model.getRegions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (m.areEqual(((ModelVoiceRegion) next).getId(), str)) {
                    break;
                }
            }
        }
        ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) next;
        if (modelVoiceRegion == null || (string = modelVoiceRegion.getName()) == null) {
            string = getString(R.string.automatic_region);
            m.checkNotNullExpressionValue(string, "getString(R.string.automatic_region)");
        }
        TextView textView8 = getBinding().g;
        m.checkNotNullExpressionValue(textView8, "binding.channelSettingsRegionOverride");
        textView8.setText(string);
        TextView textView9 = getBinding().i;
        m.checkNotNullExpressionValue(textView9, "binding.channelSettingsRegionOverrideHelp");
        b.a.k.b.n(textView9, R.string.form_help_region_override, new Object[0], null, 4);
        getBinding().h.setOnClickListener(new AnonymousClass4(model));
        configureRegionOverrideVisibility(model.getCanManageChannel());
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews4 = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews4.get(textInputLayout2.getId(), ChannelUtils.c(model.getChannel())));
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        textInputLayout3.setVisibility(8);
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews5 = this.state;
        TextInputLayout textInputLayout5 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout5.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout4, (CharSequence) statefulViews5.get(id2, topic));
        LinearLayout linearLayout = getBinding().l;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsSectionUserManagement");
        linearLayout.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().f.setOnClickListener(new AnonymousClass5(model));
        LinearLayout linearLayout2 = getBinding().k;
        m.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsSectionPrivacySafety");
        linearLayout2.setVisibility(model.getCanManageChannel() && ChannelUtils.J(model.getChannel()) && TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId())) ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        checkedSetting.setVisibility(model.getCanManageChannel() ? 0 : 8);
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.channelSettingsNsfw");
        getBinding().e.g(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(model.getChannel().getNsfw()))).booleanValue(), false);
        getBinding().j.setOnClickListener(new AnonymousClass6(model));
        this.state.configureSaveActionView(getBinding().j);
    }

    private final void configureUserLimitVisibility(boolean isVisible) {
        View view = getBinding().f2703s;
        m.checkNotNullExpressionValue(view, "binding.userLimitDivider");
        view.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().u;
        m.checkNotNullExpressionValue(textView, "binding.userLimitTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().q;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsUserLimit");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView2 = getBinding().r;
        m.checkNotNullExpressionValue(textView2, "binding.settingsUserLimitHelp");
        textView2.setVisibility(isVisible ? 0 : 8);
    }

    private final void confirmDelete(Channel channel) {
        s4 s4VarA = s4.a(LayoutInflater.from(getContext()), null, false);
        m.checkNotNullExpressionValue(s4VarA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = s4VarA.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(s4VarA.a).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        s4VarA.c.setOnClickListener(new AnonymousClass1(alertDialogCreate));
        s4VarA.d.setOnClickListener(new AnonymousClass2(channel));
        TextView textView = s4VarA.f199b;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        LinearLayout linearLayout2 = s4VarA.a;
        m.checkNotNullExpressionValue(linearLayout2, "binding.root");
        Context context = linearLayout2.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        b.a.k.b.n(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, context, false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetVoiceChannelSettingsBinding getBinding() {
        return (WidgetVoiceChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getBitrateDisplayString(int bitrate) {
        return bitrate + " Kbps";
    }

    private final CharSequence getUserLimitDisplayString(int userLimit) {
        if (userLimit == 0) {
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            return b.a.k.b.i(resources, R.string.no_user_limit, new Object[0], null, 4);
        }
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        return StringResourceUtilsKt.getQuantityString(resources2, requireContext(), R.plurals.num_users_num, userLimit, Integer.valueOf(userLimit));
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long channelId, String channelName, int channelType, String channelTopic, Boolean nsfw, int userLimit, int bitrate, String rtcRegion) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApiSerializeNulls().editVoiceChannel(channelId, channelName, channelTopic, nsfw, Integer.valueOf(channelType), Integer.valueOf(bitrate), Integer.valueOf(userLimit), rtcRegion), this, null, 2, null).k(b.a.d.o.a.g(getContext(), new AnonymousClass1(), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetVoiceChannelSettings widgetVoiceChannelSettings, long j, String str, int i, String str2, Boolean bool, int i2, int i3, String str3, int i4, Object obj) {
        widgetVoiceChannelSettings.saveChannel(j, str, i, str2, (i4 & 16) != 0 ? null : bool, i2, i3, str3);
    }

    private final void showRegionDialog(List<? extends ModelVoiceRegion> regions) {
        n.Companion companion = n.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceK = b.a.k.b.k(this, R.string.form_label_region_override, new Object[0], null, 4);
        List listListOf = d0.t.m.listOf(b.a.k.b.k(this, R.string.automatic_region, new Object[0], null, 4));
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(regions, 10));
        Iterator<T> it = regions.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelVoiceRegion) it.next()).getName());
        }
        Object[] array = u.plus((Collection) listListOf, (Iterable) arrayList).toArray(new CharSequence[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        companion.a(parentFragmentManager, charSequenceK, (CharSequence[]) array, new AnonymousClass2(regions));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditTopic");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
        statefulViews2.addOptionalFields(textView);
        StatefulViews statefulViews3 = this.state;
        FloatingActionButton floatingActionButton = getBinding().j;
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        TextView textView2 = getBinding().n;
        m.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        TextView textView3 = getBinding().m;
        m.checkNotNullExpressionValue(textView3, "binding.currentBitrateDisplay");
        CheckedSetting checkedSetting = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        statefulViews3.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3, textView2, textView3, checkedSetting);
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetVoiceChannelSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
