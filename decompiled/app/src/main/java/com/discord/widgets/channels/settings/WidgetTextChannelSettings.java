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
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTextChannelSettingsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.DurationUtils2;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p025i.WidgetChannelSettingsCannotDeleteBinding;
import p007b.p008a.p025i.WidgetChannelSettingsDeleteBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.OnSeekBarChangeListenerAdapter;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextChannelSettings extends AppFragment {
    public static final int ONE_DAY = 86400;
    public static final int ONE_HOUR = 3600;
    public static final int ONE_MINUTE = 60;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetTextChannelSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextChannelSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Integer> SLOWMODE_COOLDOWN_VALUES = Collections2.listOf((Object[]) new Integer[]{0, 5, 10, 15, 30, 60, 120, 300, 600, 900, Integer.valueOf(ModelInvite.Settings.HALF_HOUR), 3600, 7200, Integer.valueOf(ModelInvite.Settings.SIX_HOURS)});

    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void setDurationSecondsLabel$default(Companion companion, TextView textView, int i, Context context, int i2, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                i2 = C5419R.string.form_label_slowmode_off;
            }
            companion.setDurationSecondsLabel(textView, i, context, i2);
        }

        public final List<Integer> getSLOWMODE_COOLDOWN_VALUES() {
            return WidgetTextChannelSettings.access$getSLOWMODE_COOLDOWN_VALUES$cp();
        }

        public final void launch(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            AppScreen2.m156d(context, WidgetTextChannelSettings.class, intentPutExtra);
        }

        public final void setDurationSecondsLabel(TextView textView, int seconds, Context context, int zeroLabel) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            Intrinsics3.checkNotNullParameter(context, "context");
            if (seconds == 0) {
                textView.setText(context.getString(zeroLabel));
                return;
            }
            if (1 <= seconds && 60 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.SECONDS, seconds);
                return;
            }
            if (60 <= seconds && 3600 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.MINS, seconds / 60);
            } else if (3600 <= seconds && 86400 > seconds) {
                DurationUtils3.setDurationText(textView, DurationUtils2.HOURS, seconds / 3600);
            } else {
                DurationUtils3.setDurationText(textView, DurationUtils2.DAYS, seconds / 86400);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageChannel;
        private final boolean canManagePermissions;
        private final Channel channel;
        private final Guild guild;
        private final boolean isCommunityGuild;
        private final boolean isPinsEnabled;
        private final boolean isPublicGuildRulesChannel;
        private final boolean isPublicGuildUpdatesChannel;

        /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new WidgetTextChannelSettings2(channelId));
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
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

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getCanManageChannel() {
            return this.canManageChannel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getCanManagePermissions() {
            return this.canManagePermissions;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsPinsEnabled() {
            return this.isPinsEnabled;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsPublicGuildRulesChannel() {
            return this.isPublicGuildRulesChannel;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsPublicGuildUpdatesChannel() {
            return this.isPublicGuildUpdatesChannel;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getIsCommunityGuild() {
            return this.isCommunityGuild;
        }

        public final Model copy(Guild guild, Channel channel, boolean canManageChannel, boolean canManagePermissions, boolean isPinsEnabled, boolean isPublicGuildRulesChannel, boolean isPublicGuildUpdatesChannel, boolean isCommunityGuild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && this.canManageChannel == model.canManageChannel && this.canManagePermissions == model.canManagePermissions && this.isPinsEnabled == model.isPinsEnabled && this.isPublicGuildRulesChannel == model.isPublicGuildRulesChannel && this.isPublicGuildUpdatesChannel == model.isPublicGuildUpdatesChannel && this.isCommunityGuild == model.isCommunityGuild;
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
        /* JADX WARN: Type inference failed for: r1v11, types: [int] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v17 */
        /* JADX WARN: Type inference failed for: r1v19 */
        /* JADX WARN: Type inference failed for: r1v20 */
        /* JADX WARN: Type inference failed for: r1v21 */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            boolean z2 = this.canManageChannel;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode2 + r1) * 31;
            boolean z3 = this.canManagePermissions;
            ?? r12 = z3;
            if (z3) {
                r12 = 1;
            }
            int i2 = (i + r12) * 31;
            boolean z4 = this.isPinsEnabled;
            ?? r13 = z4;
            if (z4) {
                r13 = 1;
            }
            int i3 = (i2 + r13) * 31;
            boolean z5 = this.isPublicGuildRulesChannel;
            ?? r14 = z5;
            if (z5) {
                r14 = 1;
            }
            int i4 = (i3 + r14) * 31;
            boolean z6 = this.isPublicGuildUpdatesChannel;
            ?? r15 = z6;
            if (z6) {
                r15 = 1;
            }
            int i5 = (i4 + r15) * 31;
            boolean z7 = this.isCommunityGuild;
            return i5 + (z7 ? 1 : z7);
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
            StringBuilder sbM833U = outline.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", canManageChannel=");
            sbM833U.append(this.canManageChannel);
            sbM833U.append(", canManagePermissions=");
            sbM833U.append(this.canManagePermissions);
            sbM833U.append(", isPinsEnabled=");
            sbM833U.append(this.isPinsEnabled);
            sbM833U.append(", isPublicGuildRulesChannel=");
            sbM833U.append(this.isPublicGuildRulesChannel);
            sbM833U.append(", isPublicGuildUpdatesChannel=");
            sbM833U.append(this.isPublicGuildUpdatesChannel);
            sbM833U.append(", isCommunityGuild=");
            return outline.m827O(sbM833U, this.isCommunityGuild, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$cannotDeleteWarn$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC75911 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public ViewOnClickListenerC75911(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class C75921<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Model $this_configureUI;

        public C75921(Model model) {
            this.$this_configureUI = model;
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case C5419R.id.menu_channel_settings_delete /* 2131364369 */:
                    if (this.$this_configureUI.isPublicGuildRulesChannel() || this.$this_configureUI.isPublicGuildUpdatesChannel()) {
                        WidgetTextChannelSettings.access$cannotDeleteWarn(WidgetTextChannelSettings.this, this.$this_configureUI.isPublicGuildRulesChannel());
                    } else {
                        WidgetTextChannelSettings.access$confirmDelete(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel());
                    }
                    break;
                case C5419R.id.menu_channel_settings_reset /* 2131364370 */:
                    StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    userGuildSettings.setChannelNotificationsDefault(context, this.$this_configureUI.getChannel());
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$10 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC759310 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public ViewOnClickListenerC759310(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(C5419R.id.duration_selector, 60);
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18237k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, 60);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$11 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC759411 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public ViewOnClickListenerC759411(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(C5419R.id.duration_selector, 1440);
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18237k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, 1440);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$12 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC759512 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public ViewOnClickListenerC759512(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(C5419R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES));
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18237k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$13 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC759613 implements View.OnClickListener {
        public final /* synthetic */ Map $durationsMap;

        public ViewOnClickListenerC759613(Map map) {
            this.$durationsMap = map;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(C5419R.id.duration_selector, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES));
            WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18237k);
            WidgetTextChannelSettings.access$updateRadioState(WidgetTextChannelSettings.this, this.$durationsMap, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$2 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class C75972<T> implements Action1<Menu> {
        public final /* synthetic */ Model $this_configureUI;

        public C75972(Model model) {
            this.$this_configureUI = model;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_channel_settings_delete);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
            menuItemFindItem.setVisible(this.$this_configureUI.getCanManageChannel());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$3 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC75983 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC75983(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            StatefulViews statefulViewsAccess$getState$p = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            TextInputLayout textInputLayout = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18229c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
            String str = (String) statefulViewsAccess$getState$p.getIfChanged(textInputLayout.getId());
            StatefulViews statefulViewsAccess$getState$p2 = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            TextInputLayout textInputLayout2 = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18230d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditTopic");
            String str2 = (String) statefulViewsAccess$getState$p2.getIfChanged(textInputLayout2.getId());
            StatefulViews statefulViewsAccess$getState$p3 = WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this);
            SeekBar seekBar = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18243q;
            Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
            WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id2, str, null, str2, null, (Integer) statefulViewsAccess$getState$p3.getIfChanged(seekBar.getId()), (Integer) WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).getIfChanged(C5419R.id.duration_selector), 20, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$5 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC75995 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC75995(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPinnedMessages.INSTANCE.show(outline.m885x(view, "it", "it.context"), this.$this_configureUI.getChannel().getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$6 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC76006 implements View.OnClickListener {
        public static final ViewOnClickListenerC76006 INSTANCE = new ViewOnClickListenerC76006();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            AppToast.m169g(view.getContext(), C5419R.string.pins_disabled_nsfw, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$7 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC76017 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC76017(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsPermissionsOverview.INSTANCE.launch(outline.m885x(view, "it", "it.context"), this.$this_configureUI.getChannel().getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$8 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC76028 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC76028(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (ChannelUtils.m7685i(this.$this_configureUI.getChannel())) {
                WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel().getId(), null, 0, null, null, null, null, 122, null);
            } else {
                WidgetTextChannelSettings.saveChannel$default(WidgetTextChannelSettings.this, this.$this_configureUI.getChannel().getId(), null, 5, null, null, null, null, 122, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$configureUI$9 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC76039 implements View.OnClickListener {
        public final /* synthetic */ Model $this_configureUI;

        public ViewOnClickListenerC76039(Model model) {
            this.$this_configureUI = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextChannelSettings widgetTextChannelSettings = WidgetTextChannelSettings.this;
            long id2 = this.$this_configureUI.getChannel().getId();
            Intrinsics3.checkNotNullExpressionValue(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18232f, "binding.channelSettingsNsfw");
            WidgetTextChannelSettings.saveChannel$default(widgetTextChannelSettings, id2, null, null, null, Boolean.valueOf(!r12.isChecked()), null, null, 110, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC76041 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public ViewOnClickListenerC76041(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$2 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class ViewOnClickListenerC76052 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$confirmDelete$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Integer numM7678b = ChannelUtils.m7678b(channel);
                if (numM7678b != null) {
                    AppToast.m171i(WidgetTextChannelSettings.this, numM7678b.intValue(), 0, 4);
                }
            }
        }

        public ViewOnClickListenerC76052(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteChannel(this.$channel.getId()), false, 1, null), WidgetTextChannelSettings.this, null, 2, null);
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, view.getContext(), "javaClass", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class C76061 extends OnSeekBarChangeListenerAdapter {
        public C76061() {
        }

        @Override // p007b.p008a.p062y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            super.onProgressChanged(seekBar, progress, fromUser);
            if (fromUser) {
                int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                WidgetTextChannelSettings.access$setSlowmodeLabel(WidgetTextChannelSettings.this, iIntValue);
                WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).put(C5419R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(iIntValue));
                WidgetTextChannelSettings.access$getState$p(WidgetTextChannelSettings.this).configureSaveActionView(WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18237k);
                TextView textView = WidgetTextChannelSettings.access$getBinding$p(WidgetTextChannelSettings.this).f18242p;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
                seekBar.setContentDescription(textView.getText());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class C76071 extends Lambda implements Function1<Model, Unit> {
        public C76071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetTextChannelSettings.access$configureUI(WidgetTextChannelSettings.this, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetTextChannelSettings$saveChannel$1 */
    /* JADX INFO: compiled from: WidgetTextChannelSettings.kt */
    public static final class C76081 extends Lambda implements Function1<Channel, Unit> {
        public C76081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Context context = WidgetTextChannelSettings.this.getContext();
            Intrinsics3.checkNotNullExpressionValue(channel, "it");
            AppToast.m169g(context, ChannelUtils.m7687k(channel) ? C5419R.string.category_settings_have_been_updated : C5419R.string.channel_settings_have_been_updated, 0, null, 12);
        }
    }

    public WidgetTextChannelSettings() {
        super(C5419R.layout.widget_text_channel_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTextChannelSettings3.INSTANCE, null, 2, null);
        this.state = new StatefulViews(C5419R.id.channel_settings_edit_name, C5419R.id.channel_settings_edit_topic, C5419R.id.channel_settings_slow_mode_cooldown_slider, C5419R.id.duration_selector, C5419R.id.channel_settings_announcement);
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
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.widget_channel_settings_cannot_delete, (ViewGroup) null, false);
        int i = C5419R.id.channel_settings_cannot_delete_body;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channel_settings_cannot_delete_body);
        if (textView != null) {
            i = C5419R.id.channel_settings_cannot_delete_confirm;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.channel_settings_cannot_delete_confirm);
            if (materialButton != null) {
                i = C5419R.id.channel_settings_cannot_delete_title;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.channel_settings_cannot_delete_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new WidgetChannelSettingsCannotDeleteBinding(linearLayout, textView, materialButton, textView2), "WidgetChannelSettingsCan…om(context), null, false)");
                    Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                    AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).create();
                    Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
                    textView.setText(isPublicGuildRulesChannel ? C5419R.string.delete_rules_channel_body : C5419R.string.delete_updates_channel_body);
                    materialButton.setOnClickListener(new ViewOnClickListenerC75911(alertDialogCreate));
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
        setActionBarTitle(ChannelUtils.m7671F(model.getChannel()) ? C5419R.string.channel_settings : C5419R.string.category_settings);
        setActionBarSubtitle(ChannelUtils.m7681e(model.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(ChannelUtils.m7671F(model.getChannel()) ? C5419R.menu.menu_text_channel_settings : C5419R.menu.menu_category_settings, new C75921(model), new C75972(model));
        TextInputLayout textInputLayout = getBinding().f18229c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f18229c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), ChannelUtils.m7679c(model.getChannel())));
        getBinding().f18229c.setHint(ChannelUtils.m7671F(model.getChannel()) ? C5419R.string.form_label_channel_name : C5419R.string.category_name);
        TextInputLayout textInputLayout3 = getBinding().f18230d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        StatefulViews statefulViews2 = this.state;
        TextInputLayout textInputLayout4 = getBinding().f18230d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        int id2 = textInputLayout4.getId();
        String topic = model.getChannel().getTopic();
        if (topic == null) {
            topic = "";
        }
        ViewExtensions.setText(textInputLayout3, (CharSequence) statefulViews2.get(id2, topic));
        TextInputLayout textInputLayout5 = getBinding().f18230d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.channelSettingsEditTopic");
        textInputLayout5.setVisibility(ChannelUtils.m7671F(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout = getBinding().f18231e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelSettingsEditWrap");
        linearLayout.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().f18237k.setOnClickListener(new ViewOnClickListenerC75983(model));
        this.state.configureSaveActionView(getBinding().f18237k);
        LinearLayout linearLayout2 = getBinding().f18235i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelSettingsPinnedMessagesContainer");
        linearLayout2.setVisibility(ChannelUtils.m7671F(model.getChannel()) ? 0 : 8);
        TextView textView = getBinding().f18234h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsPinnedMessages");
        textView.setEnabled(model.isPinsEnabled());
        getBinding().f18234h.setOnClickListener(new ViewOnClickListenerC75995(model));
        View view = getBinding().f18236j;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(model.isPinsEnabled() ^ true ? 0 : 8);
        getBinding().f18236j.setOnClickListener(ViewOnClickListenerC76006.INSTANCE);
        TextView textView2 = getBinding().f18233g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsPermissions");
        textView2.setVisibility(model.getCanManagePermissions() ? 0 : 8);
        getBinding().f18233g.setOnClickListener(new ViewOnClickListenerC76017(model));
        CheckedSetting checkedSetting = getBinding().f18228b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.channelSettingsAnnouncement");
        checkedSetting.setVisibility((ChannelUtils.m7697u(model.getChannel()) || ChannelUtils.m7685i(model.getChannel())) && model.getCanManageChannel() && model.isCommunityGuild() && !model.isPublicGuildRulesChannel() && !model.isPublicGuildUpdatesChannel() ? 0 : 8);
        getBinding().f18228b.m8529g(ChannelUtils.m7685i(model.getChannel()), false);
        CheckedSetting checkedSetting2 = getBinding().f18228b;
        Context context = getContext();
        checkedSetting2.m8530h(context != null ? FormatUtils.m216h(context, C5419R.string.form_help_news_android, new Object[]{AppHelpDesk.f507a.m149a(360032008192L, null)}, null, 4) : null, true);
        getBinding().f18228b.m8527e(new ViewOnClickListenerC76028(model));
        LinearLayout linearLayout3 = getBinding().f18241o;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.channelSettingsSectionUserManagement");
        linearLayout3.setVisibility(model.getCanManageChannel() || model.getCanManagePermissions() ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().f18239m;
        Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.channelSettingsSectionPrivacySafety");
        linearLayout4.setVisibility(model.getCanManageChannel() && ChannelUtils.m7671F(model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting3 = getBinding().f18232f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.channelSettingsNsfw");
        checkedSetting3.setVisibility(model.getCanManageChannel() ? 0 : 8);
        getBinding().f18232f.m8529g(model.getChannel().getNsfw(), false);
        getBinding().f18232f.m8527e(new ViewOnClickListenerC76039(model));
        LinearLayout linearLayout5 = getBinding().f18240n;
        Intrinsics3.checkNotNullExpressionValue(linearLayout5, "binding.channelSettingsSectionSlowMode");
        linearLayout5.setVisibility(model.getCanManageChannel() && ChannelUtils.m7671F(model.getChannel()) && !ChannelUtils.m7685i(model.getChannel()) ? 0 : 8);
        int iIntValue = ((Number) this.state.get(C5419R.id.channel_settings_slow_mode_cooldown_slider, Integer.valueOf(model.getChannel().getRateLimitPerUser()))).intValue();
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
        SeekBar seekBar = getBinding().f18243q;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        this.state.configureSaveActionView(getBinding().f18237k);
        SeekBar seekBar2 = getBinding().f18243q;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.channelSettingsSlowModeCooldownSlider");
        TextView textView3 = getBinding().f18242p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView3.getText());
        LinearLayout linearLayout6 = getBinding().f18238l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout6, "binding.channelSettingsS…efaultAutoArchiveDuration");
        linearLayout6.setVisibility(model.getCanManageChannel() && ChannelUtils.m7674I(model.getChannel()) && ThreadUtils.INSTANCE.isThreadsEnabled(model.getGuild().getId()) ? 0 : 8);
        Integer num = (Integer) this.state.get(C5419R.id.duration_selector, model.getChannel().getDefaultAutoArchiveDuration());
        int iIntValue2 = num != null ? num.intValue() : 1440;
        this.state.configureSaveActionView(getBinding().f18237k);
        Map<MaterialRadioButton, Integer> mapMapOf = Maps6.mapOf(Tuples.m10073to(getBinding().f18244r.f18256e, 60), Tuples.m10073to(getBinding().f18244r.f18262k, 1440), Tuples.m10073to(getBinding().f18244r.f18260i, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES)), Tuples.m10073to(getBinding().f18244r.f18258g, Integer.valueOf(ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES)));
        getBinding().f18244r.f18255d.setOnClickListener(new ViewOnClickListenerC759310(mapMapOf));
        getBinding().f18244r.f18261j.setOnClickListener(new ViewOnClickListenerC759411(mapMapOf));
        getBinding().f18244r.f18259h.setOnClickListener(new ViewOnClickListenerC759512(mapMapOf));
        getBinding().f18244r.f18257f.setOnClickListener(new ViewOnClickListenerC759613(mapMapOf));
        updateRadioState(mapMapOf, iIntValue2);
    }

    private final void confirmDelete(Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingM206a = WidgetChannelSettingsDeleteBinding.m206a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingM206a, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingM206a.f1214a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingM206a.f1214a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(bind…ew(binding.root).create()");
        widgetChannelSettingsDeleteBindingM206a.f1218e.setText(ChannelUtils.m7671F(channel) ? C5419R.string.delete_channel : C5419R.string.delete_category);
        widgetChannelSettingsDeleteBindingM206a.f1216c.setOnClickListener(new ViewOnClickListenerC76041(alertDialogCreate));
        widgetChannelSettingsDeleteBindingM206a.f1217d.setOnClickListener(new ViewOnClickListenerC76052(channel));
        TextView textView = widgetChannelSettingsDeleteBindingM206a.f1215b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        FormatUtils.m222n(textView, C5419R.string.delete_channel_body, new Object[]{ChannelUtils.m7681e(channel, requireContext(), false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetTextChannelSettingsBinding getBinding() {
        return (WidgetTextChannelSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(long j, Context context) {
        INSTANCE.launch(j, context);
    }

    private final void saveChannel(long id2, String name, Integer type, String topic, Boolean nsfw, Integer rateLimit, Integer defaultAutoArchiveDuration) {
        ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().editTextChannel(id2, name, type, topic, nsfw, rateLimit, defaultAutoArchiveDuration), this, null, 2, null).m11108k(C0879o.f566a.m184g(getContext(), new C76081(), null));
    }

    public static /* synthetic */ void saveChannel$default(WidgetTextChannelSettings widgetTextChannelSettings, long j, String str, Integer num, String str2, Boolean bool, Integer num2, Integer num3, int i, Object obj) {
        widgetTextChannelSettings.saveChannel(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : num3);
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        Companion companion = INSTANCE;
        TextView textView = getBinding().f18242p;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), C5419R.string.form_label_slowmode_off);
    }

    private final void updateRadioState(Map<MaterialRadioButton, Integer> durationMap, int newDuration) {
        for (Map.Entry<MaterialRadioButton, Integer> entry : durationMap.entrySet()) {
            entry.getKey().setChecked(entry.getValue().intValue() == newDuration);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout = getBinding().f18230d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.channelSettingsEditTopic");
        statefulViews.addOptionalFields(textInputLayout);
        StatefulViews statefulViews2 = this.state;
        FloatingActionButton floatingActionButton = getBinding().f18237k;
        TextInputLayout textInputLayout2 = getBinding().f18229c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.channelSettingsEditName");
        TextInputLayout textInputLayout3 = getBinding().f18230d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.channelSettingsEditTopic");
        statefulViews2.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2, textInputLayout3);
        SeekBar seekBar = getBinding().f18243q;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.channelSettingsSlowModeCooldownSlider");
        seekBar.setMax(Collections2.getLastIndex(SLOWMODE_COOLDOWN_VALUES));
        getBinding().f18243q.setOnSeekBarChangeListener(new C76061());
        TextInputLayout textInputLayout4 = getBinding().f18230d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.channelSettingsEditTopic");
        ViewExtensions.interceptScrollWhenInsideScrollable(textInputLayout4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)), this, null, 2, null), WidgetTextChannelSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C76071(), 62, (Object) null);
    }
}
