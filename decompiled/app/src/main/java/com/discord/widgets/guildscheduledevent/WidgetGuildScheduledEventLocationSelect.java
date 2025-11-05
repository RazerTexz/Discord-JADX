package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventLocationSelectBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelectViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelect extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventLocationSelect.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventLocationSelectBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY = "GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid currentViewState;

    /* renamed from: existingGuildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy existingGuildScheduledEventId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: hubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hubViewModel;
    private final ActivityResultLauncher<Intent> nextStepLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            companion.launch(context, j, l);
        }

        public final void launch(Context context, long guildId, Long channelId) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            if (channelId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            j.d(context, WidgetGuildScheduledEventLocationSelect.class, intent);
        }

        public final void launchForEdit(Context context, long guildId, long guildScheduledEventId) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            j.d(context, WidgetGuildScheduledEventLocationSelect.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            GuildScheduledEventEntityType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.VOICE;
            iArr[guildScheduledEventEntityType.ordinal()] = 1;
            GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.STAGE_INSTANCE;
            iArr[guildScheduledEventEntityType2.ordinal()] = 2;
            GuildScheduledEventEntityType.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[guildScheduledEventEntityType2.ordinal()] = 1;
            iArr2[guildScheduledEventEntityType.ordinal()] = 2;
            GuildScheduledEventEntityType guildScheduledEventEntityType3 = GuildScheduledEventEntityType.EXTERNAL;
            iArr2[guildScheduledEventEntityType3.ordinal()] = 3;
            GuildScheduledEventEntityType.values();
            int[] iArr3 = new int[5];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[guildScheduledEventEntityType2.ordinal()] = 1;
            iArr3[guildScheduledEventEntityType.ordinal()] = 2;
            iArr3[guildScheduledEventEntityType3.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$configureLocationOption$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventEntityType $settingValue;

        public AnonymousClass1(GuildScheduledEventEntityType guildScheduledEventEntityType) {
            this.$settingValue = guildScheduledEventEntityType;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventLocationSelect.access$getViewModel$p(WidgetGuildScheduledEventLocationSelect.this).selectLocationOption(this.$settingValue);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetGuildScheduledEventLocationSelectViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
            super(1, widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelect.class, "configureUI", "configureUI(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventLocationSelectViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventLocationSelect.access$configureUI((WidgetGuildScheduledEventLocationSelect) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetGuildScheduledEventLocationSelect.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid validAccess$getCurrentViewState$p = WidgetGuildScheduledEventLocationSelect.access$getCurrentViewState$p(WidgetGuildScheduledEventLocationSelect.this);
            if (validAccess$getCurrentViewState$p != null) {
                int iOrdinal = validAccess$getCurrentViewState$p.getSelectedLocationOption().ordinal();
                if (iOrdinal == 1) {
                    WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
                    WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect = WidgetGuildScheduledEventLocationSelect.this;
                    WidgetChannelSelector.Companion.launch$default(companion, widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelect.access$getGuildId$p(widgetGuildScheduledEventLocationSelect), WidgetGuildScheduledEventLocationSelect.GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, false, 0, new WidgetChannelSelector.SetFilterFunction(validAccess$getCurrentViewState$p.getAvailableStageChannelIds()), 24, null);
                } else {
                    if (iOrdinal != 2) {
                        return;
                    }
                    WidgetChannelSelector.Companion companion2 = WidgetChannelSelector.INSTANCE;
                    WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect2 = WidgetGuildScheduledEventLocationSelect.this;
                    WidgetChannelSelector.Companion.launch$default(companion2, widgetGuildScheduledEventLocationSelect2, WidgetGuildScheduledEventLocationSelect.access$getGuildId$p(widgetGuildScheduledEventLocationSelect2), WidgetGuildScheduledEventLocationSelect.GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, false, 0, new WidgetChannelSelector.SetFilterFunction(validAccess$getCurrentViewState$p.getAvailableVoiceChannelIds()), 24, null);
                }
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function2<Long, String, Unit> {
        public AnonymousClass4() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetGuildScheduledEventLocationSelect.access$getViewModel$p(WidgetGuildScheduledEventLocationSelect.this).selectChannel(j);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<TextView, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            m.checkNotNullParameter(textView, "it");
            WidgetGuildScheduledEventLocationSelect.access$navigateNext(WidgetGuildScheduledEventLocationSelect.this);
        }
    }

    /* compiled from: WidgetGuildScheduledEventLocationSelect.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventLocationSelect.access$navigateNext(WidgetGuildScheduledEventLocationSelect.this);
        }
    }

    public WidgetGuildScheduledEventLocationSelect() {
        super(R.layout.widget_guild_scheduled_event_location_select);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventLocationSelect$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildScheduledEventLocationSelect$guildId$2(this));
        this.existingGuildScheduledEventId = g.lazy(new WidgetGuildScheduledEventLocationSelect$existingGuildScheduledEventId$2(this));
        this.hubViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildScheduledEventDirectoryAssociationViewModel.class), new WidgetGuildScheduledEventLocationSelect$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetGuildScheduledEventLocationSelect$hubViewModel$2(this)));
        WidgetGuildScheduledEventLocationSelect$viewModel$2 widgetGuildScheduledEventLocationSelect$viewModel$2 = new WidgetGuildScheduledEventLocationSelect$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildScheduledEventLocationSelectViewModel.class), new WidgetGuildScheduledEventLocationSelect$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventLocationSelect$viewModel$2));
        this.nextStepLauncher = WidgetGuildScheduledEventSettings.INSTANCE.registerForResult(this, new WidgetGuildScheduledEventLocationSelect$nextStepLauncher$1(this), new WidgetGuildScheduledEventLocationSelect$nextStepLauncher$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
        widgetGuildScheduledEventLocationSelect.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid access$getCurrentViewState$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.currentViewState;
    }

    public static final /* synthetic */ Long access$getExistingGuildScheduledEventId$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getExistingGuildScheduledEventId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getGuildId();
    }

    public static final /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel access$getViewModel$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        return widgetGuildScheduledEventLocationSelect.getViewModel();
    }

    public static final /* synthetic */ void access$navigateNext(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        widgetGuildScheduledEventLocationSelect.navigateNext();
    }

    public static final /* synthetic */ void access$setCurrentViewState$p(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect, WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid) {
        widgetGuildScheduledEventLocationSelect.currentViewState = valid;
    }

    private final void configureLocationOption(WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid viewState, CheckedSetting setting, GuildScheduledEventEntityType settingValue, CharSequence disabledMessage) {
        setting.setChecked(viewState.getSelectedLocationOption() == settingValue);
        if (disabledMessage != null) {
            setting.c(disabledMessage);
        } else {
            setting.e(new AnonymousClass1(settingValue));
        }
    }

    private final void configureUI(WidgetGuildScheduledEventLocationSelectViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid) {
            WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid = (WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid) viewState;
            this.currentViewState = valid;
            CheckedSetting checkedSetting = getBinding().j;
            m.checkNotNullExpressionValue(checkedSetting, "binding.stageChannelOption");
            configureLocationOption(valid, checkedSetting, GuildScheduledEventEntityType.STAGE_INSTANCE, getDisabledMessageForChannelOption(valid.getAvailableStageChannelIds(), valid.getCanChangeChannel()));
            CheckedSetting checkedSetting2 = getBinding().m;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.voiceChannelOption");
            configureLocationOption(valid, checkedSetting2, GuildScheduledEventEntityType.VOICE, getDisabledMessageForChannelOption(valid.getAvailableVoiceChannelIds(), valid.getCanChangeChannel()));
            CheckedSetting checkedSetting3 = getBinding().g;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.externalOption");
            configureLocationOption(valid, checkedSetting3, GuildScheduledEventEntityType.EXTERNAL, getDisabledMessageForExternalOption(valid.getCanCreateExternalEvent(), valid.getCanChangeChannel()));
            boolean z2 = (valid.getAvailableStageChannelIds().isEmpty() ^ true) || valid.getShowStageOptionIfUnavailable();
            CheckedSetting checkedSetting4 = getBinding().j;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.stageChannelOption");
            checkedSetting4.setVisibility(z2 ? 0 : 8);
            View view = getBinding().l;
            m.checkNotNullExpressionValue(view, "binding.voiceChannelDivider");
            view.setVisibility(z2 ? 0 : 8);
            int iOrdinal = valid.getSelectedLocationOption().ordinal();
            if (iOrdinal == 1 || iOrdinal == 2) {
                TextView textView = getBinding().h;
                m.checkNotNullExpressionValue(textView, "binding.locationHeader");
                ViewExtensions.setTextAndVisibilityBy(textView, getString(R.string.guild_event_location_voice_field_label));
                TextInputLayout textInputLayout = getBinding().c;
                m.checkNotNullExpressionValue(textInputLayout, "binding.channelLocationLayout");
                textInputLayout.setVisibility(0);
                TextInputLayout textInputLayout2 = getBinding().f;
                m.checkNotNullExpressionValue(textInputLayout2, "binding.externalLocationLayout");
                textInputLayout2.setVisibility(8);
            } else if (iOrdinal != 3) {
                TextView textView2 = getBinding().h;
                m.checkNotNullExpressionValue(textView2, "binding.locationHeader");
                textView2.setVisibility(8);
                TextInputLayout textInputLayout3 = getBinding().c;
                m.checkNotNullExpressionValue(textInputLayout3, "binding.channelLocationLayout");
                textInputLayout3.setVisibility(8);
                TextInputLayout textInputLayout4 = getBinding().f;
                m.checkNotNullExpressionValue(textInputLayout4, "binding.externalLocationLayout");
                textInputLayout4.setVisibility(8);
            } else {
                TextView textView3 = getBinding().h;
                m.checkNotNullExpressionValue(textView3, "binding.locationHeader");
                ViewExtensions.setTextAndVisibilityBy(textView3, getString(R.string.guild_event_location_elsewhere_field_label));
                TextInputLayout textInputLayout5 = getBinding().c;
                m.checkNotNullExpressionValue(textInputLayout5, "binding.channelLocationLayout");
                textInputLayout5.setVisibility(8);
                TextInputLayout textInputLayout6 = getBinding().f;
                m.checkNotNullExpressionValue(textInputLayout6, "binding.externalLocationLayout");
                textInputLayout6.setVisibility(0);
            }
            TextInputEditText textInputEditText = getBinding().f2447b;
            ViewExtensions.setEnabledAndAlpha$default(textInputEditText, valid.getCanChangeChannel(), 0.0f, 2, null);
            Editable text = textInputEditText.getText();
            String string = text != null ? text.toString() : null;
            if (!m.areEqual(string, valid.getSelectedChannel() != null ? r3.getName() : null)) {
                Channel selectedChannel = valid.getSelectedChannel();
                textInputEditText.setText(selectedChannel != null ? selectedChannel.getName() : null);
            }
            TextInputEditText textInputEditText2 = getBinding().e;
            if (!m.areEqual(textInputEditText2.getText() != null ? r1.toString() : null, valid.getExternalLocation())) {
                textInputEditText2.setText(valid.getExternalLocation());
            }
            MaterialButton materialButton = getBinding().i;
            m.checkNotNullExpressionValue(materialButton, "binding.nextButton");
            materialButton.setEnabled(isNextEnabled(valid));
        }
    }

    private final WidgetGuildScheduledEventLocationSelectBinding getBinding() {
        return (WidgetGuildScheduledEventLocationSelectBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getDisabledMessageForChannelOption(Set<Long> channelIds, boolean canChangeEntityType) {
        if (!canChangeEntityType) {
            return getString(R.string.guild_event_location_disabled_cannot_edit);
        }
        if (channelIds.isEmpty()) {
            return getString(R.string.guild_event_location_disabled_no_available_channel);
        }
        return null;
    }

    private final CharSequence getDisabledMessageForExternalOption(boolean canCreateExternalEvent, boolean canChangeEntityType) {
        if (!canChangeEntityType) {
            return getString(R.string.guild_event_location_disabled_cannot_edit);
        }
        if (canCreateExternalEvent) {
            return null;
        }
        return getString(R.string.guild_event_location_disabled_external_no_permission);
    }

    private final Long getExistingGuildScheduledEventId() {
        return (Long) this.existingGuildScheduledEventId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildScheduledEventDirectoryAssociationViewModel getHubViewModel() {
        return (GuildScheduledEventDirectoryAssociationViewModel) this.hubViewModel.getValue();
    }

    private static /* synthetic */ void getHubViewModel$annotations() {
    }

    private final WidgetGuildScheduledEventLocationSelectViewModel getViewModel() {
        return (WidgetGuildScheduledEventLocationSelectViewModel) this.viewModel.getValue();
    }

    private final boolean isNextEnabled(WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid viewState) {
        int iOrdinal = viewState.getSelectedLocationOption().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            if (viewState.getSelectedChannel() == null) {
                return false;
            }
        } else if (iOrdinal != 3 || viewState.getExternalLocation().length() <= 0) {
            return false;
        }
        return true;
    }

    private final void navigateNext() {
        WidgetGuildScheduledEventLocationSelectViewModel.ViewState.Valid valid = this.currentViewState;
        if (valid != null) {
            WidgetGuildScheduledEventSettings.Companion companion = WidgetGuildScheduledEventSettings.INSTANCE;
            Context contextRequireContext = requireContext();
            ActivityResultLauncher<Intent> activityResultLauncher = this.nextStepLauncher;
            long guildId = getGuildId();
            GuildScheduledEventEntityType selectedLocationOption = valid.getSelectedLocationOption();
            Channel selectedChannel = valid.getSelectedChannel();
            companion.launch(contextRequireContext, activityResultLauncher, guildId, selectedLocationOption, selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, valid.getExternalLocation(), getExistingGuildScheduledEventId());
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventLocationSelect.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().k;
        m.checkNotNullExpressionValue(textView, "binding.stepText");
        b.n(textView, R.string.guild_event_step_label, new Object[]{1, 3}, null, 4);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        TextInputEditText textInputEditText = getBinding().e;
        m.checkNotNullExpressionValue(textInputEditText, "binding.externalLocationInput");
        textInputEditText.addTextChangedListener(new WidgetGuildScheduledEventLocationSelect$onViewBound$$inlined$addTextChangedListener$1(this));
        getBinding().f2447b.setOnClickListener(new AnonymousClass3());
        WidgetChannelSelector.INSTANCE.registerForResult(this, GUILD_SCHEDULED_EVENT_LOCATION_SELECT_REQUEST_KEY, false, new AnonymousClass4());
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.externalLocationLayout");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass5(), 1, null);
        getBinding().i.setOnClickListener(new AnonymousClass6());
    }
}
