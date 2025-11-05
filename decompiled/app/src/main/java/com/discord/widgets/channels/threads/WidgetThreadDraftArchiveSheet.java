package com.discord.widgets.channels.threads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetThreadDraftArchiveSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadDraftArchiveSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadDraftArchiveSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet = new WidgetThreadDraftArchiveSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetThreadDraftArchiveSheet.setArguments(bundle);
            widgetThreadDraftArchiveSheet.show(fragmentManager, WidgetThreadDraftArchiveSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final StoreThreadDraft.ThreadDraftState draftState;
        private final Guild guild;

        /* compiled from: WidgetThreadDraftArchiveSheet.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getThreadDraft().observeDraftState(), companion.getGuilds().observeGuild(guildId), companion.getChannelsSelected().observeSelectedChannel(), WidgetThreadDraftArchiveSheet$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…, guild, channel)\n      }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel) {
            m.checkNotNullParameter(threadDraftState, "draftState");
            this.draftState = threadDraftState;
            this.guild = guild;
            this.channel = channel;
        }

        public static /* synthetic */ Model copy$default(Model model, StoreThreadDraft.ThreadDraftState threadDraftState, Guild guild, Channel channel, int i, Object obj) {
            if ((i & 1) != 0) {
                threadDraftState = model.draftState;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                channel = model.channel;
            }
            return model.copy(threadDraftState, guild, channel);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreThreadDraft.ThreadDraftState getDraftState() {
            return this.draftState;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Model copy(StoreThreadDraft.ThreadDraftState draftState, Guild guild, Channel channel) {
            m.checkNotNullParameter(draftState, "draftState");
            return new Model(draftState, guild, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.draftState, model.draftState) && m.areEqual(this.guild, model.guild) && m.areEqual(this.channel, model.channel);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreThreadDraft.ThreadDraftState getDraftState() {
            return this.draftState;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public int hashCode() {
            StoreThreadDraft.ThreadDraftState threadDraftState = this.draftState;
            int iHashCode = (threadDraftState != null ? threadDraftState.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            return iHashCode2 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(draftState=");
            sbU.append(this.draftState);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$bindSubscriptions$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet) {
            super(1, widgetThreadDraftArchiveSheet, WidgetThreadDraftArchiveSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            m.checkNotNullParameter(model, "p1");
            WidgetThreadDraftArchiveSheet.access$configureUI((WidgetThreadDraftArchiveSheet) this.receiver, model);
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        public AnonymousClass1(StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet.this, this.$draftState, 60);
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        public AnonymousClass2(StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet.this, this.$draftState, 1440);
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        public AnonymousClass3(StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet.this, this.$draftState, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
        }
    }

    /* compiled from: WidgetThreadDraftArchiveSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ StoreThreadDraft.ThreadDraftState $draftState;

        public AnonymousClass4(StoreThreadDraft.ThreadDraftState threadDraftState) {
            this.$draftState = threadDraftState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadDraftArchiveSheet.access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet.this, this.$draftState, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
        }
    }

    public WidgetThreadDraftArchiveSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadDraftArchiveSheet$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet, Model model) {
        widgetThreadDraftArchiveSheet.configureUI(model);
    }

    public static final /* synthetic */ void access$setAutoArchiveDuration(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet, StoreThreadDraft.ThreadDraftState threadDraftState, int i) {
        widgetThreadDraftArchiveSheet.setAutoArchiveDuration(threadDraftState, i);
    }

    private final void configureUI(Model model) {
        StoreThreadDraft.ThreadDraftState draftState = model.getDraftState();
        model.getGuild();
        model.getChannel();
        Integer autoArchiveDuration = draftState.getAutoArchiveDuration();
        int iIntValue = autoArchiveDuration != null ? autoArchiveDuration.intValue() : 1440;
        new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_ARCHIVAL_DURATION_SHEET, Traits.Location.Obj.LIST_ITEM, null, null, 24, null);
        getBinding().d.setOnClickListener(new AnonymousClass1(draftState));
        MaterialRadioButton materialRadioButton = getBinding().e;
        m.checkNotNullExpressionValue(materialRadioButton, "binding.optionOneHourRadio");
        materialRadioButton.setChecked(iIntValue == 60);
        getBinding().j.setOnClickListener(new AnonymousClass2(draftState));
        MaterialRadioButton materialRadioButton2 = getBinding().k;
        m.checkNotNullExpressionValue(materialRadioButton2, "binding.optionTwentyFourHoursRadio");
        materialRadioButton2.setChecked(iIntValue == 1440);
        getBinding().h.setOnClickListener(new AnonymousClass3(draftState));
        MaterialRadioButton materialRadioButton3 = getBinding().i;
        m.checkNotNullExpressionValue(materialRadioButton3, "binding.optionThreeDaysRadio");
        materialRadioButton3.setChecked(iIntValue == 4320);
        getBinding().f.setOnClickListener(new AnonymousClass4(draftState));
        MaterialRadioButton materialRadioButton4 = getBinding().g;
        m.checkNotNullExpressionValue(materialRadioButton4, "binding.optionSevenDaysRadio");
        materialRadioButton4.setChecked(iIntValue == 10080);
    }

    private final WidgetThreadArchiveActionsSheetBinding getBinding() {
        return (WidgetThreadArchiveActionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void setAutoArchiveDuration(StoreThreadDraft.ThreadDraftState draftState, int minutes) {
        StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(draftState, false, Integer.valueOf(minutes), null, false, false, 29, null));
        dismiss();
    }

    public static final void show(FragmentManager fragmentManager, long j) {
        INSTANCE.show(fragmentManager, j);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), WidgetThreadDraftArchiveSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
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
