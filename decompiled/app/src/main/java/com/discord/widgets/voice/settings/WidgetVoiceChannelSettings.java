package com.discord.widgets.voice.settings;

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
import com.discord.C5419R;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.voice.Bitrate;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
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
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p009a.SelectorDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p025i.WidgetChannelSettingsDeleteBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.OnSeekBarChangeListenerAdapter;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Action2;

/* compiled from: WidgetVoiceChannelSettings.kt */
/* loaded from: classes.dex */
public final class WidgetVoiceChannelSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetVoiceChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceChannelSettingsBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetVoiceChannelSettings.INTENT_EXTRA_CHANNEL_ID, channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT…RA_CHANNEL_ID, channelId)");
            AppScreen2.m156d(context, WidgetVoiceChannelSettings.class, intentPutExtra);
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
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{channels, guilds, StoreUser.INSTANCE.getMeUpdate(), permissions, guildVoiceRegions, companion.getExperiments()}, false, null, null, new WidgetVoiceChannelSettings2(channels, channelId, guilds, permissions, users, guildVoiceRegions), 14, null)).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "ObservationDeckProvider.…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, boolean z2, boolean z3, int i, List<? extends ModelVoiceRegion> list, long j) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(list, "regions");
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
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(regions, "regions");
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
            return Intrinsics3.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.maxBitrate == model.maxBitrate && Intrinsics3.areEqual(this.regions, model.regions) && this.guildID == model.guildID;
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
            return C0002b.m3a(this.guildID) + ((i3 + (list != null ? list.hashCode() : 0)) * 31);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", canManageChannel=");
            sbM833U.append(this.canManageChannel);
            sbM833U.append(", canManagePermissions=");
            sbM833U.append(this.canManagePermissions);
            sbM833U.append(", maxBitrate=");
            sbM833U.append(this.maxBitrate);
            sbM833U.append(", regions=");
            sbM833U.append(this.regions);
            sbM833U.append(", guildID=");
            return outline.m815C(sbM833U, this.guildID, ")");
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$1 */
    public static final class C105611<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Model $this_configureUI;

        public C105611(Model model) {
            this.$this_configureUI = model;
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != C5419R.id.menu_channel_settings_delete) {
                return;
            }
            WidgetVoiceChannelSettings.access$confirmDelete(WidgetVoiceChannelSettings.this, this.$this_configureUI.getChannel());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$2 */
    public static final class C105622 extends OnSeekBarChangeListenerAdapter {
        public C105622() {
        }

        @Override // p007b.p008a.p062y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18471n;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
            textView.setText(WidgetVoiceChannelSettings.access$getUserLimitDisplayString(WidgetVoiceChannelSettings.this, progress));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$3 */
    public static final class C105633 extends OnSeekBarChangeListenerAdapter {
        public C105633() {
        }

        @Override // p007b.p008a.p062y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18470m;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.currentBitrateDisplay");
            textView.setText(WidgetVoiceChannelSettings.access$getBitrateDisplayString(WidgetVoiceChannelSettings.this, Bitrate.MIN.getKbps() + progress));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$4 */
    public static final class ViewOnClickListenerC105644 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC105644(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceChannelSettings.access$showRegionDialog(WidgetVoiceChannelSettings.this, this.$this_configureUI.getRegions());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$5 */
    public static final class ViewOnClickListenerC105655 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC105655(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(WidgetVoiceChannelSettings.this.requireContext(), this.$this_configureUI.getChannel().getId());
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$configureUI$6 */
    public static final class ViewOnClickListenerC105666 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC105666(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceChannelSettings widgetVoiceChannelSettings = WidgetVoiceChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            StatefulViews statefulViewsAccess$getState$p = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextInputLayout textInputLayout = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18460c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            String str = (String) statefulViewsAccess$getState$p.get(textInputLayout.getId(), ChannelUtils.m7679c(this.$this_configureUI.getChannel()));
            StatefulViews statefulViewsAccess$getState$p2 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextInputLayout textInputLayout2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18461d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditTopic");
            int id3 = textInputLayout2.getId();
            String topic = this.$this_configureUI.getChannel().getTopic();
            if (topic == null) {
                topic = "";
            }
            String str2 = (String) statefulViewsAccess$getState$p2.get(id3, topic);
            CheckedSetting checkedSetting = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18462e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
            Boolean boolValueOf = Boolean.valueOf(checkedSetting.isChecked());
            int type = this.$this_configureUI.getChannel().getType();
            SeekBar seekBar = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18477t;
            Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
            int progress = seekBar.getProgress();
            SeekBar seekBar2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18459b;
            Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
            int kbps = (Bitrate.MIN.getKbps() + seekBar2.getProgress()) * 1000;
            StatefulViews statefulViewsAccess$getState$p3 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
            TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18464g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
            WidgetVoiceChannelSettings.access$saveChannel(widgetVoiceChannelSettings, id2, str, type, str2, boolValueOf, progress, kbps, (String) statefulViewsAccess$getState$p3.get(textView.getId(), this.$this_configureUI.getChannel().getRtcRegion()));
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$1 */
    public static final class ViewOnClickListenerC105671 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public ViewOnClickListenerC105671(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$2 */
    public static final class ViewOnClickListenerC105682 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetVoiceChannelSettings.kt */
        /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$confirmDelete$2$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Integer numM7678b = ChannelUtils.m7678b(channel);
                if (numM7678b != null) {
                    AppToast.m171i(WidgetVoiceChannelSettings.this, numM7678b.intValue(), 0, 4);
                }
            }
        }

        public ViewOnClickListenerC105682(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(this.$channel.getId()), false, 1, null), WidgetVoiceChannelSettings.this, null, 2, null);
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, view.getContext(), "javaClass", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$onViewBoundOrOnResume$1 */
    public static final class C105691 extends Lambda implements Function1<Model, Unit> {
        public C105691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetVoiceChannelSettings.access$configureUI(WidgetVoiceChannelSettings.this, model);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$saveChannel$1 */
    public static final class C105701 extends Lambda implements Function1<Channel, Unit> {
        public C105701() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            AppToast.m169g(WidgetVoiceChannelSettings.this.getContext(), C5419R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    /* compiled from: WidgetVoiceChannelSettings.kt */
    /* renamed from: com.discord.widgets.voice.settings.WidgetVoiceChannelSettings$showRegionDialog$2 */
    public static final class C105712 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ List $regions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105712(List list) {
            super(1);
            this.$regions = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            if (i == 0) {
                StatefulViews statefulViewsAccess$getState$p = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
                TextView textView = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18464g;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
                statefulViewsAccess$getState$p.put(textView.getId(), null);
                TextView textView2 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18464g;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsRegionOverride");
                textView2.setText(FormatUtils.m219k(WidgetVoiceChannelSettings.this, C5419R.string.automatic_region, new Object[0], null, 4));
            } else {
                StatefulViews statefulViewsAccess$getState$p2 = WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this);
                TextView textView3 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18464g;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelSettingsRegionOverride");
                int i2 = i - 1;
                statefulViewsAccess$getState$p2.put(textView3.getId(), ((ModelVoiceRegion) this.$regions.get(i2)).getId());
                TextView textView4 = WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18464g;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelSettingsRegionOverride");
                textView4.setText(((ModelVoiceRegion) this.$regions.get(i2)).getName());
            }
            WidgetVoiceChannelSettings.access$getState$p(WidgetVoiceChannelSettings.this).configureSaveActionView(WidgetVoiceChannelSettings.access$getBinding$p(WidgetVoiceChannelSettings.this).f18467j);
        }
    }

    public WidgetVoiceChannelSettings() {
        super(C5419R.layout.widget_voice_channel_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceChannelSettings3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.channel_settings_edit_name, C5419R.id.channel_settings_edit_topic, C5419R.id.current_user_limit_display, C5419R.id.current_bitrate_display, C5419R.id.channel_settings_region_override, C5419R.id.channel_settings_nsfw);
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
        View view = getBinding().f18472o;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.regionOverrideDivider");
        view.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18465h;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsRegionOverrideContainer");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().f18466i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverrideHelp");
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
        setActionBarTitle(C5419R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.m7681e(model.getChannel(), requireContext(), false, 2));
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_voice_channel_settings, new C105611(model), null, 4, null);
        TextView textView = getBinding().f18471n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.currentUserLimitDisplay");
        StatefulViews statefulViews = this.state;
        TextView textView2 = getBinding().f18471n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        textView.setText((CharSequence) statefulViews.get(textView2.getId(), getUserLimitDisplayString(model.getChannel().getUserLimit())));
        TextView textView3 = getBinding().f18475r;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.settingsUserLimitHelp");
        FormatUtils.m222n(textView3, C5419R.string.form_help_user_limit, new Object[0], null, 4);
        SeekBar seekBar = getBinding().f18477t;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.userLimitSeekbar");
        seekBar.setProgress(model.getChannel().getUserLimit());
        getBinding().f18477t.setOnSeekBarChangeListener(new C105622());
        configureUserLimitVisibility(model.getChannel().getType() == 2);
        int bitrate = model.getChannel().getBitrate() / 1000;
        TextView textView4 = getBinding().f18470m;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.currentBitrateDisplay");
        StatefulViews statefulViews2 = this.state;
        TextView textView5 = getBinding().f18470m;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.currentBitrateDisplay");
        textView4.setText((CharSequence) statefulViews2.get(textView5.getId(), getBitrateDisplayString(bitrate)));
        TextView textView6 = getBinding().f18473p;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.settingsBitrateHelp");
        FormatUtils.m222n(textView6, C5419R.string.form_help_bitrate, new Object[]{"64"}, null, 4);
        SeekBar seekBar2 = getBinding().f18459b;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.bitrateSeekbar");
        int maxBitrate = model.getMaxBitrate();
        Bitrate bitrate2 = Bitrate.MIN;
        seekBar2.setMax(maxBitrate - bitrate2.getKbps());
        SeekBar seekBar3 = getBinding().f18459b;
        Intrinsics3.checkNotNullExpressionValue(seekBar3, "binding.bitrateSeekbar");
        seekBar3.setProgress(bitrate - bitrate2.getKbps());
        getBinding().f18459b.setOnSeekBarChangeListener(new C105633());
        StatefulViews statefulViews3 = this.state;
        TextView textView7 = getBinding().f18464g;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelSettingsRegionOverride");
        String str = (String) statefulViews3.get(textView7.getId(), model.getChannel().getRtcRegion());
        Iterator<T> it = model.getRegions().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics3.areEqual(((ModelVoiceRegion) next).getId(), str)) {
                    break;
                }
            }
        }
        ModelVoiceRegion modelVoiceRegion = (ModelVoiceRegion) next;
        if (modelVoiceRegion == null || (string = modelVoiceRegion.getName()) == null) {
            string = getString(C5419R.string.automatic_region);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.automatic_region)");
        }
        TextView textView8 = getBinding().f18464g;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.channelSettingsRegionOverride");
        textView8.setText(string);
        TextView textView9 = getBinding().f18466i;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.channelSettingsRegionOverrideHelp");
        FormatUtils.m222n(textView9, C5419R.string.form_help_region_override, new Object[0], null, 4);
        getBinding().f18465h.setOnClickListener(new ViewOnClickListenerC105644(model));
        configureRegionOverrideVisibility(model.getCanManageChannel());
        TextInputLayout textInputLayout = getBinding().f18460c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews4 = this.state;
        TextInputLayout textInputLayout2 = getBinding().f18460c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews4.get(textInputLayout2.getId(), ChannelUtils.m7679c(model.getChannel())));
        TextInputLayout textInputLayout3 = getBinding().f18461d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        textInputLayout3.setVisibility(8);
        TextInputLayout textInputLayout4 = getBinding().f18461d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews5 = this.state;
        TextInputLayout textInputLayout5 = getBinding().f18461d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout5.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout4, (CharSequence) statefulViews5.get(id2, topic));
        LinearLayout linearLayout = getBinding().f18469l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsSectionUserManagement");
        linearLayout.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().f18463f.setOnClickListener(new ViewOnClickListenerC105655(model));
        LinearLayout linearLayout2 = getBinding().f18468k;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsSectionPrivacySafety");
        linearLayout2.setVisibility(model.getCanManageChannel() && ChannelUtils.m7675J(model.getChannel()) && TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId())) ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().f18462e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        checkedSetting.setVisibility(model.getCanManageChannel() ? 0 : 8);
        StatefulViews statefulViews6 = this.state;
        CheckedSetting checkedSetting2 = getBinding().f18462e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.channelSettingsNsfw");
        getBinding().f18462e.m8529g(((Boolean) statefulViews6.get(checkedSetting2.getId(), Boolean.valueOf(model.getChannel().getNsfw()))).booleanValue(), false);
        getBinding().f18467j.setOnClickListener(new ViewOnClickListenerC105666(model));
        this.state.configureSaveActionView(getBinding().f18467j);
    }

    private final void configureUserLimitVisibility(boolean isVisible) {
        View view = getBinding().f18476s;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.userLimitDivider");
        view.setVisibility(isVisible ? 0 : 8);
        TextView textView = getBinding().f18478u;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userLimitTitle");
        textView.setVisibility(isVisible ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18474q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsUserLimit");
        linearLayout.setVisibility(isVisible ? 0 : 8);
        TextView textView2 = getBinding().f18475r;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsUserLimitHelp");
        textView2.setVisibility(isVisible ? 0 : 8);
    }

    private final void confirmDelete(Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingM206a = WidgetChannelSettingsDeleteBinding.m206a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingM206a, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingM206a.f1214a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingM206a.f1214a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        widgetChannelSettingsDeleteBindingM206a.f1216c.setOnClickListener(new ViewOnClickListenerC105671(alertDialogCreate));
        widgetChannelSettingsDeleteBindingM206a.f1217d.setOnClickListener(new ViewOnClickListenerC105682(channel));
        TextView textView = widgetChannelSettingsDeleteBindingM206a.f1215b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        LinearLayout linearLayout2 = widgetChannelSettingsDeleteBindingM206a.f1214a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.root");
        Context context = linearLayout2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        FormatUtils.m222n(textView, C5419R.string.delete_channel_body, new Object[]{ChannelUtils.m7681e(channel, context, false, 2)}, null, 4);
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
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            return FormatUtils.m217i(resources, C5419R.string.no_user_limit, new Object[0], null, 4);
        }
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        return StringResourceUtils.getQuantityString(resources2, requireContext(), C5419R.plurals.num_users_num, userLimit, Integer.valueOf(userLimit));
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long channelId, String channelName, int channelType, String channelTopic, Boolean nsfw, int userLimit, int bitrate, String rtcRegion) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApiSerializeNulls().editVoiceChannel(channelId, channelName, channelTopic, nsfw, Integer.valueOf(channelType), Integer.valueOf(bitrate), Integer.valueOf(userLimit), rtcRegion), this, null, 2, null).m11108k(C0879o.f566a.m184g(getContext(), new C105701(), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetVoiceChannelSettings widgetVoiceChannelSettings, long j, String str, int i, String str2, Boolean bool, int i2, int i3, String str3, int i4, Object obj) {
        widgetVoiceChannelSettings.saveChannel(j, str, i, str2, (i4 & 16) != 0 ? null : bool, i2, i3, str3);
    }

    private final void showRegionDialog(List<? extends ModelVoiceRegion> regions) {
        SelectorDialog.Companion companion = SelectorDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceM219k = FormatUtils.m219k(this, C5419R.string.form_label_region_override, new Object[0], null, 4);
        List listListOf = CollectionsJVM.listOf(FormatUtils.m219k(this, C5419R.string.automatic_region, new Object[0], null, 4));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(regions, 10));
        Iterator<T> it = regions.iterator();
        while (it.hasNext()) {
            arrayList.add(((ModelVoiceRegion) it.next()).getName());
        }
        Object[] array = _Collections.plus((Collection) listListOf, (Iterable) arrayList).toArray(new CharSequence[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        companion.m142a(parentFragmentManager, charSequenceM219k, (CharSequence[]) array, new C105712(regions));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().f18461d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditTopic");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        TextView textView = getBinding().f18464g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsRegionOverride");
        statefulViews2.addOptionalFields(textView);
        StatefulViews statefulViews3 = this.state;
        FloatingActionButton floatingActionButton = getBinding().f18467j;
        TextInputLayout textInputLayout2 = getBinding().f18460c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().f18461d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        TextView textView2 = getBinding().f18471n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.currentUserLimitDisplay");
        TextView textView3 = getBinding().f18470m;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.currentBitrateDisplay");
        CheckedSetting checkedSetting = getBinding().f18462e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsNsfw");
        statefulViews3.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3, textView2, textView3, checkedSetting);
        TextInputLayout textInputLayout4 = getBinding().f18461d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L)), this, null, 2, null), WidgetVoiceChannelSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C105691(), 62, (Object) null);
    }
}
