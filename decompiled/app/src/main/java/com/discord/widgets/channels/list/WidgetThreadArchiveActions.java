package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadMetadata;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetThreadArchiveActions.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadArchiveActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadArchiveActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetThreadArchiveActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, long guildId) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetThreadArchiveActions widgetThreadArchiveActions = new WidgetThreadArchiveActions();
            Bundle bundleT = a.T(WidgetThreadArchiveActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            bundleT.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetThreadArchiveActions.setArguments(bundleT);
            widgetThreadArchiveActions.show(fragmentManager, WidgetThreadArchiveActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final Guild guild;
        private final boolean isModerator;

        /* compiled from: WidgetThreadArchiveActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId, long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getChannels().observeChannel(channelId), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForChannel(channelId), WidgetThreadArchiveActions$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…            }\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, Guild guild, boolean z2) {
            m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.guild = guild;
            this.isModerator = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, Guild guild, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = model.channel;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                z2 = model.isModerator;
            }
            return model.copy(channel, guild, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        public final Model copy(Channel channel, Guild guild, boolean isModerator) {
            m.checkNotNullParameter(channel, "channel");
            return new Model(channel, guild, isModerator);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.channel, model.channel) && m.areEqual(this.guild, model.guild) && this.isModerator == model.isModerator;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", isModerator=");
            return a.O(sbU, this.isModerator, ")");
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$archiveThread$1, reason: invalid class name */
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
            m.checkNotNullParameter(channel, "it");
            WidgetThreadArchiveActions.this.dismiss();
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$bindSubscriptions$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetThreadArchiveActions widgetThreadArchiveActions) {
            super(1, widgetThreadArchiveActions, WidgetThreadArchiveActions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/list/WidgetThreadArchiveActions$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetThreadArchiveActions.access$configureUI((WidgetThreadArchiveActions) this.receiver, model);
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Channel channel, Model model) {
            this.$channel = channel;
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$archiveThread(WidgetThreadArchiveActions.this, this.$channel, this.$model.isModerator());
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$setAutoArchiveDuration(WidgetThreadArchiveActions.this, this.$channel, 60);
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass3(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$setAutoArchiveDuration(WidgetThreadArchiveActions.this, this.$channel, 1440);
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass4(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$setAutoArchiveDuration(WidgetThreadArchiveActions.this, this.$channel, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass5(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$setAutoArchiveDuration(WidgetThreadArchiveActions.this, this.$channel, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
        }
    }

    /* compiled from: WidgetThreadArchiveActions.kt */
    /* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$setAutoArchiveDuration$1, reason: invalid class name */
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
            m.checkNotNullParameter(channel, "it");
            WidgetThreadArchiveActions.this.dismiss();
        }
    }

    public WidgetThreadArchiveActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadArchiveActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$archiveThread(WidgetThreadArchiveActions widgetThreadArchiveActions, Channel channel, boolean z2) {
        widgetThreadArchiveActions.archiveThread(channel, z2);
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadArchiveActions widgetThreadArchiveActions, Model model) {
        widgetThreadArchiveActions.configureUI(model);
    }

    public static final /* synthetic */ void access$setAutoArchiveDuration(WidgetThreadArchiveActions widgetThreadArchiveActions, Channel channel, int i) {
        widgetThreadArchiveActions.setAutoArchiveDuration(channel, i);
    }

    private final void archiveThread(Channel channel, boolean lockThread) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long id2 = channel.getId();
        Boolean bool = Boolean.TRUE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, lockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), getContext(), "REST: archiveThread", (Function1) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    private final void configureUI(Model model) {
        if (model == null) {
            dismiss();
            return;
        }
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Channel channel = model.getChannel();
        model.getGuild();
        new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_ARCHIVAL_DURATION_SHEET, Traits.Location.Obj.LIST_ITEM, null, null, 24, null);
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.autoArchiveHeader");
        boolean z2 = false;
        linearLayout.setVisibility(0);
        long jComputeThreadAutoArchiveTimeMs = ThreadUtils.INSTANCE.computeThreadAutoArchiveTimeMs(channel);
        TextView textView = getBinding().l;
        m.checkNotNullExpressionValue(textView, "binding.subtitle");
        textView.setText(b.h(contextRequireContext, R.string.auto_archive_thread_at_long, new Object[]{TimeUtils.toReadableTimeString$default(contextRequireContext, jComputeThreadAutoArchiveTimeMs, null, 4, null)}, null, 4));
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        Integer numValueOf = threadMetadata != null ? Integer.valueOf(threadMetadata.getAutoArchiveDuration()) : null;
        TextView textView2 = getBinding().f2667b;
        m.checkNotNullExpressionValue(textView2, "binding.archiveNow");
        textView2.setVisibility(0);
        getBinding().f2667b.setOnClickListener(new AnonymousClass1(channel, model));
        getBinding().d.setOnClickListener(new AnonymousClass2(channel));
        MaterialRadioButton materialRadioButton = getBinding().e;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.optionOneHourRadio");
        materialRadioButton.setChecked(numValueOf != null && numValueOf.intValue() == 60);
        getBinding().j.setOnClickListener(new AnonymousClass3(channel));
        MaterialRadioButton materialRadioButton2 = getBinding().k;
        m.checkNotNullExpressionValue(materialRadioButton2, "binding.optionTwentyFourHoursRadio");
        materialRadioButton2.setChecked(numValueOf != null && numValueOf.intValue() == 1440);
        getBinding().h.setOnClickListener(new AnonymousClass4(channel));
        MaterialRadioButton materialRadioButton3 = getBinding().i;
        m.checkNotNullExpressionValue(materialRadioButton3, "binding.optionThreeDaysRadio");
        materialRadioButton3.setChecked(numValueOf != null && numValueOf.intValue() == 4320);
        getBinding().f.setOnClickListener(new AnonymousClass5(channel));
        MaterialRadioButton materialRadioButton4 = getBinding().g;
        m.checkNotNullExpressionValue(materialRadioButton4, "binding.optionSevenDaysRadio");
        if (numValueOf != null && numValueOf.intValue() == 10080) {
            z2 = true;
        }
        materialRadioButton4.setChecked(z2);
    }

    private final WidgetThreadArchiveActionsSheetBinding getBinding() {
        return (WidgetThreadArchiveActionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void setAutoArchiveDuration(Channel channel, int minutes) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().editThread(channel.getId(), new RestAPIParams.ThreadSettings(null, null, Integer.valueOf(minutes), 3, null)), false, 1, null), this, null, 2, null), getContext(), "REST: setAutoArchiveDuration", (Function1) null, new AnonymousClass1(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2) {
        INSTANCE.show(fragmentManager, j, j2);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L), getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), WidgetThreadArchiveActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_thread_archive_actions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
