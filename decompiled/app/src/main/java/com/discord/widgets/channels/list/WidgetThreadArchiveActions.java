package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadMetadata;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.radiobutton.MaterialRadioButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadArchiveActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetThreadArchiveActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetThreadArchiveActions widgetThreadArchiveActions = new WidgetThreadArchiveActions();
            Bundle bundleM832T = outline.m832T(WidgetThreadArchiveActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            bundleM832T.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetThreadArchiveActions.setArguments(bundleM832T);
            widgetThreadArchiveActions.show(fragmentManager, WidgetThreadArchiveActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final Guild guild;
        private final boolean isModerator;

        /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId, long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11075i = Observable.m11075i(companion.getChannels().observeChannel(channelId), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForChannel(channelId), WidgetThreadArchiveActions2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…            }\n          }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, Guild guild, boolean z2) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
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

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        public final Model copy(Channel channel, Guild guild, boolean isModerator) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            return Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && this.isModerator == model.isModerator;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", isModerator=");
            return outline.m827O(sbM833U, this.isModerator, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$archiveThread$1 */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class C74751 extends Lambda implements Function1<Channel, Unit> {
        public C74751() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            WidgetThreadArchiveActions.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final /* synthetic */ class C74761 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C74761(WidgetThreadArchiveActions widgetThreadArchiveActions) {
            super(1, widgetThreadArchiveActions, WidgetThreadArchiveActions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/list/WidgetThreadArchiveActions$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetThreadArchiveActions.access$configureUI((WidgetThreadArchiveActions) this.receiver, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$1 */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class ViewOnClickListenerC74771 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC74771(Channel channel, Model model) {
            this.$channel = channel;
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$archiveThread(WidgetThreadArchiveActions.this, this.$channel, this.$model.isModerator());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$2 */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class ViewOnClickListenerC74782 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public ViewOnClickListenerC74782(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$setAutoArchiveDuration(WidgetThreadArchiveActions.this, this.$channel, 60);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$3 */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class ViewOnClickListenerC74793 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public ViewOnClickListenerC74793(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$setAutoArchiveDuration(WidgetThreadArchiveActions.this, this.$channel, 1440);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$4 */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class ViewOnClickListenerC74804 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public ViewOnClickListenerC74804(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$setAutoArchiveDuration(WidgetThreadArchiveActions.this, this.$channel, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$configureUI$5 */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class ViewOnClickListenerC74815 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public ViewOnClickListenerC74815(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadArchiveActions.access$setAutoArchiveDuration(WidgetThreadArchiveActions.this, this.$channel, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$setAutoArchiveDuration$1 */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class C74821 extends Lambda implements Function1<Channel, Unit> {
        public C74821() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            WidgetThreadArchiveActions.this.dismiss();
        }
    }

    public WidgetThreadArchiveActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadArchiveActions3.INSTANCE, null, 2, null);
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, lockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), getContext(), "REST: archiveThread", (Function1) null, new C74751(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    private final void configureUI(Model model) {
        if (model == null) {
            dismiss();
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Channel channel = model.getChannel();
        model.getGuild();
        new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_ARCHIVAL_DURATION_SHEET, Traits.Location.Obj.LIST_ITEM, null, null, 24, null);
        LinearLayout linearLayout = getBinding().f18254c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.autoArchiveHeader");
        boolean z2 = false;
        linearLayout.setVisibility(0);
        long jComputeThreadAutoArchiveTimeMs = ThreadUtils.INSTANCE.computeThreadAutoArchiveTimeMs(channel);
        TextView textView = getBinding().f18263l;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.subtitle");
        textView.setText(FormatUtils.m216h(contextRequireContext, C5419R.string.auto_archive_thread_at_long, new Object[]{TimeUtils.toReadableTimeString$default(contextRequireContext, jComputeThreadAutoArchiveTimeMs, null, 4, null)}, null, 4));
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        Integer numValueOf = threadMetadata != null ? Integer.valueOf(threadMetadata.getAutoArchiveDuration()) : null;
        TextView textView2 = getBinding().f18253b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.archiveNow");
        textView2.setVisibility(0);
        getBinding().f18253b.setOnClickListener(new ViewOnClickListenerC74771(channel, model));
        getBinding().f18255d.setOnClickListener(new ViewOnClickListenerC74782(channel));
        MaterialRadioButton materialRadioButton = getBinding().f18256e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.optionOneHourRadio");
        materialRadioButton.setChecked(numValueOf != null && numValueOf.intValue() == 60);
        getBinding().f18261j.setOnClickListener(new ViewOnClickListenerC74793(channel));
        MaterialRadioButton materialRadioButton2 = getBinding().f18262k;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.optionTwentyFourHoursRadio");
        materialRadioButton2.setChecked(numValueOf != null && numValueOf.intValue() == 1440);
        getBinding().f18259h.setOnClickListener(new ViewOnClickListenerC74804(channel));
        MaterialRadioButton materialRadioButton3 = getBinding().f18260i;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.optionThreeDaysRadio");
        materialRadioButton3.setChecked(numValueOf != null && numValueOf.intValue() == 4320);
        getBinding().f18257f.setOnClickListener(new ViewOnClickListenerC74815(channel));
        MaterialRadioButton materialRadioButton4 = getBinding().f18258g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.optionSevenDaysRadio");
        if (numValueOf != null && numValueOf.intValue() == 10080) {
            z2 = true;
        }
        materialRadioButton4.setChecked(z2);
    }

    private final WidgetThreadArchiveActionsSheetBinding getBinding() {
        return (WidgetThreadArchiveActionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void setAutoArchiveDuration(Channel channel, int minutes) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().editThread(channel.getId(), new RestAPIParams.ThreadSettings(null, null, Integer.valueOf(minutes), 3, null)), false, 1, null), this, null, 2, null), getContext(), "REST: setAutoArchiveDuration", (Function1) null, new C74821(), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2) {
        INSTANCE.show(fragmentManager, j, j2);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L), getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), WidgetThreadArchiveActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C74761(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_thread_archive_actions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
