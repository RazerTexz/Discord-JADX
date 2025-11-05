package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.f;
import b.a.d.j;
import b.a.i.r4;
import b.a.i.s4;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTextChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.resources.DurationUnit;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetTextChannelSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetTextChannelSettings extends AppFragment {
    public static final int ONE_DAY = 86400;
    public static final int ONE_HOUR = 3600;
    public static final int ONE_MINUTE = 60;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetTextChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Integer> SLOWMODE_COOLDOWN_VALUES = n.listOf((Object[]) new Integer[]{0, 5, 10, 15, 30, 60, 120, 300, 600, 900, Integer.valueOf(ModelInvite.Settings.HALF_HOUR), 3600, 7200, Integer.valueOf(ModelInvite.Settings.SIX_HOURS)});

    /* compiled from: WidgetTextChannelSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void setDurationSecondsLabel$default(Companion companion, TextView textView, int i, Context context, int i2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                i2 = R.string.form_label_slowmode_off;
            }
            companion.setDurationSecondsLabel(textView, i, context, i2);
        }

        public final List<Integer> getSLOWMODE_COOLDOWN_VALUES() {
            return WidgetTextChannelSettings.access$getSLOWMODE_COOLDOWN_VALUES$cp();
        }

        public final void launch(long channelId, Context context) {
            m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            j.d(context, WidgetTextChannelSettings.class, intentPutExtra);
        }

        public final void setDurationSecondsLabel(TextView textView, int seconds, Context context, int zeroLabel) {
            m.checkNotNullParameter(textView, "textView");
            m.checkNotNullParameter(context, "context");
            if (seconds == 0) {
                textView.setText(context.getString(zeroLabel));
                return;
            }
            if (1 <= seconds && 60 > seconds) {
                DurationUtilsKt.setDurationText(textView, DurationUnit.SECONDS, seconds);
                return;
            }
            if (60 <= seconds && 3600 > seconds) {
                DurationUtilsKt.setDurationText(textView, DurationUnit.MINS, seconds / 60);
            } else if (3600 <= seconds && 86400 > seconds) {
                DurationUtilsKt.setDurationText(textView, DurationUnit.HOURS, seconds / 3600);
            } else {
                DurationUtilsKt.setDurationText(textView, DurationUnit.DAYS, seconds / 86400);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageChannel;
        private final boolean canManagePermissions;
        private final Channel channel;
        private final Guild guild;
        private final boolean isCommunityGuild;
        private final boolean isPinsEnabled;
        private final boolean isPublicGuildRulesChannel;
        private final boolean isPublicGuildUpdatesChannel;

        /* compiled from: WidgetTextChannelSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new WidgetTextChannelSettings$Model$Companion$get$1(channelId));
                m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(channel, "channel");
            this.guild = guild;
            this.channel = channel;
            this.canManageChannel = z2;
            this.canManagePermissions = z3;
            this.isPinsEnabled = z4;
            this.isPublicGuildRulesChannel = z5;
            this.isPublicGuildUpdatesChannel = z6;
            this.isCommunityGuild = z7;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.guild : guild, (i & 2) != 0 ? model.channel : channel, (i & 4) != 0 ? model.canManageChannel : z2, (i & 8) != 0 ? model.canManagePermissions : z3, (i & 16) != 0 ? model.isPinsEnabled : z4, (i & 32) != 0 ? model.isPublicGuildRulesChannel : z5, (i & 64) != 0 ? model.isPublicGuildUpdatesChannel : z6, (i & 128) != 0 ? model.isCommunityGuild : z7);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsPinsEnabled() {
            return this.isPinsEnabled;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsPublicGuildRulesChannel() {
            return this.isPublicGuildRulesChannel;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getIsPublicGuildUpdatesChannel() {
            return this.isPublicGuildUpdatesChannel;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsCommunityGuild() {
            return this.isCommunityGuild;
        }

        public final Model copy(Guild guild, Channel channel, boolean canManageChannel, boolean canManagePermissions, boolean isPinsEnabled, boolean isPublicGuildRulesChannel, boolean isPublicGuildUpdatesChannel, boolean isCommunityGuild) {
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(channel, "channel");
            return new Model(guild, channel, canManageChannel, canManagePermissions, isPinsEnabled, isPublicGuildRulesChannel, isPublicGuildUpdatesChannel, isCommunityGuild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.guild, model.guild) && m.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.isPinsEnabled == model.isPinsEnabled && this.isPublicGuildRulesChannel == model.isPublicGuildRulesChannel && this.isPublicGuildUpdatesChannel == model.isPublicGuildUpdatesChannel && this.isCommunityGuild == model.isCommunityGuild;
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

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.canManageChannel;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.canManagePermissions;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.isPinsEnabled;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.isPublicGuildRulesChannel;
            int i7 = z5;
            if (z5 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z6 = this.isPublicGuildUpdatesChannel;
            int i9 = z6;
            if (z6 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            boolean z7 = this.isCommunityGuild;
            return i10 + (z7 ? 1 : z7 ? 1 : 0);
        }

        public final boolean isCommunityGuild() {
            return this.isCommunityGuild;
        }

        public final boolean isPinsEnabled() {
            return this.isPinsEnabled;
        }

        public final boolean isPublicGuildRulesChannel() {
            return this.isPublicGuildRulesChannel;
        }

        public final boolean isPublicGuildUpdatesChannel() {
            return this.isPublicGuildUpdatesChannel;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", canManageChannel=");
            sbU.append(this.canManageChannel);
            sbU.append(", canManagePermissions=");
            sbU.append(this.canManagePermissions);
            sbU.append(", isPinsEnabled=");
            sbU.append(this.isPinsEnabled);
            sbU.append(", isPublicGuildRulesChannel=");
            sbU.append(this.isPublicGuildRulesChannel);
            sbU.append(", isPublicGuildUpdatesChannel=");
            sbU.append(this.isPublicGuildUpdatesChannel);
            sbU.append(", isCommunityGuild=");
            return a.O(sbU, this.isCommunityGuild, ")");
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$cannotDeleteWarn$1, reason: invalid class name */
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

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$1, reason: invalid class name */
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
            switch (menuItem.getItemId()) {
                case R.id.menu_channel_settings_delete /* 2131364369 */:
                    if (!this.$this_configureUI.isPublicGuildRulesChannel() && !this.$this_configureUI.isPublicGuildUpdatesChannel()) {
                        WidgetTextChannelSettings.access$confirmDelete(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel());
                        break;
                    } else {
                        WidgetTextChannelSettings.access$cannotDeleteWarn(WidgetTextChannelSettings.this, this.$this_configureUI.isPublicGuildRulesChannel());
                        break;
                    }
                    break;
                case R.id.menu_channel_settings_reset /* 2131364370 */:
                    StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                    m.checkNotNullExpressionValue(context, "context");
                    userGuildSettings.setChannelNotificationsDefault(context, this.$this_configureUI.getChannel());
                    break;
            }
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public AnonymousClass10(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.duration_selector, 60);
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, 60);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public AnonymousClass11(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.duration_selector, 1440);
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, 1440);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$12, reason: invalid class name */
    public static final class AnonymousClass12 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public AnonymousClass12(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES));
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$13, reason: invalid class name */
    public static final class AnonymousClass13 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public AnonymousClass13(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES));
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass2(Model model) {
            this.$this_configureUI = model;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_channel_settings_delete);
            m.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
            menuItemFindItem.setVisible(this.$this_configureUI.getCanManageChannel());
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass3(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            StatefulViews statefulViewsAccess$getState$p = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            TextInputLayout textInputLayout = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            String str = (String) statefulViewsAccess$getState$p.getIfChanged(textInputLayout.getId());
            StatefulViews statefulViewsAccess$getState$p2 = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            TextInputLayout textInputLayout2 = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditTopic");
            String str2 = (String) statefulViewsAccess$getState$p2.getIfChanged(textInputLayout2.getId());
            StatefulViews statefulViewsAccess$getState$p3 = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            SeekBar seekBar = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).q;
            m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
            WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id2, str, null, str2, null, (Integer) statefulViewsAccess$getState$p3.getIfChanged(seekBar.getId()), (Integer) WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).getIfChanged(R.id.duration_selector), 20, null);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass5(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPinnedMessages.INSTANCE.show(a.x(view, "it", "it.context"), this.$this_configureUI.getChannel().getId());
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            m.checkNotNullExpressionValue(view, "it");
            b.a.d.m.g(view.getContext(), R.string.pins_disabled_nsfw, 0, null, 12);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass7(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(a.x(view, "it", "it.context"), this.$this_configureUI.getChannel().getId());
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass8(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ChannelUtils.i(this.$this_configureUI.getChannel())) {
                WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel().getId(), null, 0, null, null, null, null, 122, null);
            } else {
                WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel().getId(), null, 5, null, null, null, null, 122, null);
            }
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public AnonymousClass9(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            m.checkNotNullExpressionValue(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f, "binding.channelSettingsNsfw");
            WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id2, null, null, null, Boolean.valueOf(!r12.isChecked()), null, null, 110, null);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$1, reason: invalid class name */
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

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetTextChannelSettings.kt */
        /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C03702 extends o implements Function1<Channel, Unit> {
            public C03702() {
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
                    b.a.d.m.i(WidgetTextChannelSettings.this, numB.intValue(), 0, 4);
                }
            }
        }

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(this.$channel.getId()), false, 1, null), WidgetTextChannelSettings.this, null, 2, null);
            m.checkNotNullExpressionValue(view, "v");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, view.getContext(), "javaClass", (Function1) null, new C03702(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends b.a.y.j {
        public AnonymousClass1() {
        }

        @Override // b.a.y.j, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            m.checkNotNullParameter(seekBar, "seekBar");
            super.onProgressChanged(seekBar, progress, fromUser);
            if (fromUser) {
                int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                WidgetTextChannelSettings.access$setSlowmodeLabel(WidgetTextChannelSettings.this, iIntValue);
                WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(iIntValue));
                WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).k);
                TextView textView = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).p;
                m.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
                seekBar.setContentDescription(textView.getText());
            }
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetTextChannelSettings.access$configureUI(WidgetTextChannelSettings.this, model);
        }
    }

    /* compiled from: WidgetTextChannelSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$saveChannel$1, reason: invalid class name */
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
            Context context = WidgetTextChannelSettings.this.getContext();
            m.checkNotNullExpressionValue(channel, "it");
            b.a.d.m.g(context, ChannelUtils.k(channel) ? R.string.category_settings_have_been_updated : R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    public WidgetTextChannelSettings() {
        super(R.layout.widget_text_channel_settings);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTextChannelSettings$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.channel_settings_edit_name, R.id.channel_settings_edit_topic, R.id.channel_settings_slow_mode_cooldown_slider, R.id.duration_selector, R.id.channel_settings_announcement);
    }

    public static final /* synthetic */ void access$cannotDeleteWarn(WidgetTextChannelSettings widgetTextChannelSettings, boolean z2) {
        widgetTextChannelSettings.cannotDeleteWarn(z2);
    }

    public static final /* synthetic */ void access$configureUI(WidgetTextChannelSettings widgetTextChannelSettings, Model model) {
        widgetTextChannelSettings.configureUI(model);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetTextChannelSettings widgetTextChannelSettings, Channel channel) {
        widgetTextChannelSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetTextChannelSettingsBinding access$getBinding$p(WidgetTextChannelSettings widgetTextChannelSettings) {
        return widgetTextChannelSettings.getBinding();
    }

    public static final /* synthetic */ List access$getSLOWMODE_COOLDOWN_VALUES$cp() {
        return SLOWMODE_COOLDOWN_VALUES;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetTextChannelSettings widgetTextChannelSettings) {
        return widgetTextChannelSettings.state;
    }

    public static final /* synthetic */ void access$setSlowmodeLabel(WidgetTextChannelSettings widgetTextChannelSettings, int i) {
        widgetTextChannelSettings.setSlowmodeLabel(i);
    }

    public static final /* synthetic */ void access$updateRadioState(WidgetTextChannelSettings widgetTextChannelSettings, Map map, int i) {
        widgetTextChannelSettings.updateRadioState(map, i);
    }

    private final void cannotDeleteWarn(boolean isPublicGuildRulesChannel) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.widget_channel_settings_cannot_delete, (ViewGroup) null, false);
        int i = R.id.channel_settings_cannot_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channel_settings_cannot_delete_body);
        if (textView != null) {
            i = R.id.channel_settings_cannot_delete_confirm;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.channel_settings_cannot_delete_confirm);
            if (materialButton != null) {
                i = R.id.channel_settings_cannot_delete_title;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.channel_settings_cannot_delete_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    m.checkNotNullExpressionValue(new r4(linearLayout, textView, materialButton, textView2), "WidgetChannelSettingsCan…om(context), null, false)");
                    m.checkNotNullExpressionValue(linearLayout, "binding.root");
                    AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).create();
                    m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
                    textView.setText(isPublicGuildRulesChannel ? R.string.delete_rules_channel_body : R.string.delete_updates_channel_body);
                    materialButton.setOnClickListener(new AnonymousClass1(alertDialogCreate));
                    alertDialogCreate.show();
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void configureUI(Model model) {
        if (model == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(ChannelUtils.F(model.getChannel()) ? R.string.channel_settings : R.string.category_settings);
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(ChannelUtils.F(model.getChannel()) ? R.menu.menu_text_channel_settings : R.menu.menu_category_settings, new AnonymousClass1(model), new AnonymousClass2(model));
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), ChannelUtils.c(model.getChannel())));
        getBinding().c.setHint(ChannelUtils.F(model.getChannel()) ? R.string.form_label_channel_name : R.string.category_name);
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout4.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, topic));
        TextInputLayout textInputLayout5 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        textInputLayout5.setVisibility(ChannelUtils.F(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsEditWrap");
        linearLayout.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().k.setOnClickListener(new AnonymousClass3(model));
        this.state.configureSaveActionView(getBinding().k);
        LinearLayout linearLayout2 = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsPinnedMessagesContainer");
        linearLayout2.setVisibility(ChannelUtils.F(model.getChannel()) ? 0 : 8);
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsPinnedMessages");
        textView.setEnabled(model.isPinsEnabled());
        getBinding().h.setOnClickListener(new AnonymousClass5(model));
        View view = getBinding().j;
        m.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(model.isPinsEnabled() ^ true ? 0 : 8);
        getBinding().j.setOnClickListener(AnonymousClass6.INSTANCE);
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.channelSettingsPermissions");
        textView2.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().g.setOnClickListener(new AnonymousClass7(model));
        CheckedSetting checkedSetting = getBinding().f2665b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsAnnouncement");
        checkedSetting.setVisibility((ChannelUtils.u(model.getChannel()) || ChannelUtils.i(model.getChannel())) && model.getCanManageChannel() && model.isCommunityGuild() && !model.isPublicGuildRulesChannel() && !model.isPublicGuildUpdatesChannel() ? 0 : 8);
        getBinding().f2665b.g(ChannelUtils.i(model.getChannel()), false);
        CheckedSetting checkedSetting2 = getBinding().f2665b;
        Context context = getContext();
        checkedSetting2.h(context != null ? b.h(context, R.string.form_help_news_android, new Object[]{f.a.a(360032008192L, null)}, null, 4) : null, true);
        getBinding().f2665b.e(new AnonymousClass8(model));
        LinearLayout linearLayout3 = getBinding().o;
        m.checkNotNullExpressionValue(linearLayout3, "binding.channelSettingsSectionUserManagement");
        linearLayout3.setVisibility(model.getCanManageChannel() || model.getCanManagePermissions() ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().m;
        m.checkNotNullExpressionValue(linearLayout4, "binding.channelSettingsSectionPrivacySafety");
        linearLayout4.setVisibility(model.getCanManageChannel() && ChannelUtils.F(model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting3 = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.channelSettingsNsfw");
        checkedSetting3.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().f.g(model.getChannel().getNsfw(), false);
        getBinding().f.e(new AnonymousClass9(model));
        LinearLayout linearLayout5 = getBinding().n;
        m.checkNotNullExpressionValue(linearLayout5, "binding.channelSettingsSectionSlowMode");
        linearLayout5.setVisibility(model.getCanManageChannel() && ChannelUtils.F(model.getChannel()) && !ChannelUtils.i(model.getChannel()) ? 0 : 8);
        int iIntValue = ((Number) this.state.get(R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(model.getChannel().getRateLimitPerUser()))).intValue();
        setSlowmodeLabel(iIntValue);
        Iterator<Integer> it = SLOWMODE_COOLDOWN_VALUES.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().intValue() >= iIntValue) {
                    break;
                } else {
                    i++;
                }
            }
        }
        SeekBar seekBar = getBinding().q;
        m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        this.state.configureSaveActionView(getBinding().k);
        SeekBar seekBar2 = getBinding().q;
        m.checkNotNullExpressionValue(seekBar2, "binding.channelSettingsSlowModeCooldownSlider");
        TextView textView3 = getBinding().p;
        m.checkNotNullExpressionValue(textView3, "binding.channelSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView3.getText());
        LinearLayout linearLayout6 = getBinding().l;
        m.checkNotNullExpressionValue(linearLayout6, "binding.channelSettingsS…efaultAutoArchiveDuration");
        linearLayout6.setVisibility(model.getCanManageChannel() && ChannelUtils.I(model.getChannel()) && ThreadUtils.INSTANCE.isThreadsEnabled(model.getGuild().getId()) ? 0 : 8);
        Integer num = (Integer) this.state.get(R.id.duration_selector, model.getChannel().getDefaultAutoArchiveDuration());
        int iIntValue2 = num != null ? num.intValue() : 1440;
        this.state.configureSaveActionView(getBinding().k);
        Map<MaterialRadioButton, Integer> mapMapOf = h0.mapOf(d0.o.to(getBinding().r.e, 60), d0.o.to(getBinding().r.k, 1440), d0.o.to(getBinding().r.i, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES)), d0.o.to(getBinding().r.g, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES)));
        getBinding().r.d.setOnClickListener(new AnonymousClass10(mapMapOf));
        getBinding().r.j.setOnClickListener(new AnonymousClass11(mapMapOf));
        getBinding().r.h.setOnClickListener(new AnonymousClass12(mapMapOf));
        getBinding().r.f.setOnClickListener(new AnonymousClass13(mapMapOf));
        updateRadioState(mapMapOf, iIntValue2);
    }

    private final void confirmDelete(Channel channel) {
        s4 s4VarA = s4.a(LayoutInflater.from(getContext()), null, false);
        m.checkNotNullExpressionValue(s4VarA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = s4VarA.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(s4VarA.a).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        s4VarA.e.setText(ChannelUtils.F(channel) ? R.string.delete_channel : R.string.delete_category);
        s4VarA.c.setOnClickListener(new AnonymousClass1(alertDialogCreate));
        s4VarA.d.setOnClickListener(new AnonymousClass2(channel));
        TextView textView = s4VarA.f199b;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        b.n(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, requireContext(), false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetTextChannelSettingsBinding getBinding() {
        return (WidgetTextChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long id2, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().editTextChannel(id2, name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration), this, null, 2, null).k(b.a.d.o.a.g(getContext(), new AnonymousClass1(), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetTextChannelSettings widgetTextChannelSettings, long j, String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3, int i, Object obj) {
        widgetTextChannelSettings.saveChannel(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3);
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        Companion companion = INSTANCE;
        TextView textView = getBinding().p;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), R.string.form_label_slowmode_off);
    }

    private final void updateRadioState(Map<MaterialRadioButton, Integer> durationMap, int newDuration) {
        for (Map.Entry<MaterialRadioButton, Integer> entry : durationMap.entrySet()) {
            entry.getKey().setChecked(entry.getValue().intValue() == newDuration);
        }
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
        FloatingActionButton floatingActionButton = getBinding().k;
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3);
        SeekBar seekBar = getBinding().q;
        m.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setMax(n.getLastIndex(SLOWMODE_COOLDOWN_VALUES));
        getBinding().q.setOnSeekBarChangeListener(new AnonymousClass1());
        TextInputLayout textInputLayout4 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)), this, null, 2, null), WidgetTextChannelSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
