package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventSettingsBinding;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ENTITY_TYPE = "EXTRA_ENTITY_TYPE";
    private static final String EXTRA_EXTERNAL_LOCATION = "EXTRA_EXTERNAL_LOCATION";
    private static final int RESULT_QUIT = 2;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private GuildScheduledEventSettingsViewModel.ViewState.Initialized currentViewState;

    /* renamed from: existingGuildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy existingGuildScheduledEventId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: hubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hubViewModel;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, GuildScheduledEventEntityType entityType, Long channelId, String externalLocation, Long existingGuildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(entityType, "entityType");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildScheduledEventSettings.EXTRA_ENTITY_TYPE, entityType);
            if (channelId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            if (externalLocation != null) {
                intent.putExtra(WidgetGuildScheduledEventSettings.EXTRA_EXTERNAL_LOCATION, externalLocation);
            }
            if (existingGuildScheduledEventId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", existingGuildScheduledEventId.longValue());
            }
            AppScreen2.g.f(context, launcher, WidgetGuildScheduledEventSettings.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(Fragment fragment, Function0<Unit> onFinished, Function0<Unit> onQuit) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onFinished, "onFinished");
            Intrinsics3.checkNotNullParameter(onQuit, "onQuit");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetGuildScheduledEventSettings$Companion$registerForResult$1(onFinished, onQuit));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildScheduledEventSettingsViewModel.DateError.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventSettingsViewModel.DateError.INVALID_VIEW_STATE.ordinal()] = 1;
            iArr[GuildScheduledEventSettingsViewModel.DateError.START_DATE_IN_PAST.ordinal()] = 2;
            iArr[GuildScheduledEventSettingsViewModel.DateError.END_DATE_IN_PAST.ordinal()] = 3;
            iArr[GuildScheduledEventSettingsViewModel.DateError.END_DATE_BEFORE_START_DATE.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
            super(1, widgetGuildScheduledEventSettings, WidgetGuildScheduledEventSettings.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventSettings.access$configureUi((WidgetGuildScheduledEventSettings) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationViewModel2, Tuples2<? extends GuildScheduledEventSettingsViewModel.ViewState, ? extends GuildScheduledEventDirectoryAssociationViewModel2>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends GuildScheduledEventSettingsViewModel.ViewState, ? extends GuildScheduledEventDirectoryAssociationViewModel2> call(GuildScheduledEventSettingsViewModel.ViewState viewState, GuildScheduledEventDirectoryAssociationViewModel2 guildScheduledEventDirectoryAssociationViewModel2) {
            return call2(viewState, guildScheduledEventDirectoryAssociationViewModel2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationViewModel2> call2(GuildScheduledEventSettingsViewModel.ViewState viewState, GuildScheduledEventDirectoryAssociationViewModel2 guildScheduledEventDirectoryAssociationViewModel2) {
            return Tuples.to(viewState, guildScheduledEventDirectoryAssociationViewModel2);
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onResume$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<Tuples2<? extends GuildScheduledEventSettingsViewModel.ViewState, ? extends GuildScheduledEventDirectoryAssociationViewModel2>, Unit> {
        public AnonymousClass3(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
            super(1, widgetGuildScheduledEventSettings, WidgetGuildScheduledEventSettings.class, "configureVisibilitySettings", "configureVisibilitySettings(Lkotlin/Pair;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends GuildScheduledEventSettingsViewModel.ViewState, ? extends GuildScheduledEventDirectoryAssociationViewModel2> tuples2) {
            invoke2((Tuples2<? extends GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationViewModel2>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationViewModel2> tuples2) {
            Intrinsics3.checkNotNullParameter(tuples2, "p1");
            WidgetGuildScheduledEventSettings.access$configureVisibilitySettings((WidgetGuildScheduledEventSettings) this.receiver, tuples2);
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetGuildScheduledEventSettings.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventSettingsViewModel guildScheduledEventSettingsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this);
            Intrinsics3.checkNotNullExpressionValue(WidgetGuildScheduledEventSettings.access$getBinding$p(WidgetGuildScheduledEventSettings.this).p, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
            guildScheduledEventSettingsViewModelAccess$getViewModel$p.toggleBroadcastToDirectoryChannel(!r0.isChecked());
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventSettingsViewModel guildScheduledEventSettingsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this);
            MaterialCheckBox materialCheckBox = WidgetGuildScheduledEventSettings.access$getBinding$p(WidgetGuildScheduledEventSettings.this).p;
            Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
            guildScheduledEventSettingsViewModelAccess$getViewModel$p.toggleBroadcastToDirectoryChannel(materialCheckBox.isChecked());
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetGuildScheduledEventSettings.this.getActivity();
            if (activity != null) {
                activity.setResult(2);
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventModel eventModel;
            GuildScheduledEventPickerDateTime3 startTime;
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(WidgetGuildScheduledEventSettings.this);
            if (initializedAccess$getCurrentViewState$p == null || (eventModel = initializedAccess$getCurrentViewState$p.getEventModel()) == null || (startTime = eventModel.getStartTime()) == null) {
                return;
            }
            new TimePickerDialog(WidgetGuildScheduledEventSettings.this.requireContext(), new WidgetGuildScheduledEventSettings$onViewBound$5$$special$$inlined$let$lambda$1(this), startTime.getHourOfDay(), startTime.getMinute(), DateFormat.is24HourFormat(WidgetGuildScheduledEventSettings.this.requireContext())).show();
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventModel eventModel;
            GuildScheduledEventPickerDateTime2 startDate;
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(WidgetGuildScheduledEventSettings.this);
            if (initializedAccess$getCurrentViewState$p == null || (eventModel = initializedAccess$getCurrentViewState$p.getEventModel()) == null || (startDate = eventModel.getStartDate()) == null) {
                return;
            }
            DatePickerDialog datePickerDialog = new DatePickerDialog(WidgetGuildScheduledEventSettings.this.requireContext(), new WidgetGuildScheduledEventSettings$onViewBound$6$$special$$inlined$let$lambda$1(this), startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
            DatePicker datePicker = datePickerDialog.getDatePicker();
            Intrinsics3.checkNotNullExpressionValue(datePicker, "datePicker");
            datePicker.setMinDate(ClockFactory.get().currentTimeMillis());
            datePickerDialog.show();
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventModel eventModel;
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(WidgetGuildScheduledEventSettings.this);
            if (initializedAccess$getCurrentViewState$p == null || (eventModel = initializedAccess$getCurrentViewState$p.getEventModel()) == null) {
                return;
            }
            GuildScheduledEventPickerDateTime3 second = GuildScheduledEventPickerDateTime.INSTANCE.generateDefaultEndDateTime(eventModel.getStartDate(), eventModel.getStartTime()).getSecond();
            Context contextRequireContext = WidgetGuildScheduledEventSettings.this.requireContext();
            WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1 widgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1 = new WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1(this);
            GuildScheduledEventPickerDateTime3 endTime = eventModel.getEndTime();
            int hourOfDay = endTime != null ? endTime.getHourOfDay() : second.getHourOfDay();
            GuildScheduledEventPickerDateTime3 endTime2 = eventModel.getEndTime();
            new TimePickerDialog(contextRequireContext, widgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1, hourOfDay, endTime2 != null ? endTime2.getMinute() : second.getMinute(), false).show();
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventModel eventModel;
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(WidgetGuildScheduledEventSettings.this);
            if (initializedAccess$getCurrentViewState$p == null || (eventModel = initializedAccess$getCurrentViewState$p.getEventModel()) == null) {
                return;
            }
            GuildScheduledEventPickerDateTime2 first = GuildScheduledEventPickerDateTime.INSTANCE.generateDefaultEndDateTime(eventModel.getStartDate(), eventModel.getStartTime()).getFirst();
            Context contextRequireContext = WidgetGuildScheduledEventSettings.this.requireContext();
            WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1 widgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1 = new WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1(this);
            GuildScheduledEventPickerDateTime2 endDate = eventModel.getEndDate();
            int year = endDate != null ? endDate.getYear() : first.getYear();
            GuildScheduledEventPickerDateTime2 endDate2 = eventModel.getEndDate();
            int month = endDate2 != null ? endDate2.getMonth() : first.getMonth();
            GuildScheduledEventPickerDateTime2 endDate3 = eventModel.getEndDate();
            DatePickerDialog datePickerDialog = new DatePickerDialog(contextRequireContext, widgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1, year, month, endDate3 != null ? endDate3.getDayOfMonth() : first.getDayOfMonth());
            DatePicker datePicker = datePickerDialog.getDatePicker();
            Intrinsics3.checkNotNullExpressionValue(datePicker, "datePicker");
            datePicker.setMinDate(Math.max(eventModel.getStartDate().toMillis(), ClockFactory.get().currentTimeMillis()));
            datePickerDialog.show();
        }
    }

    /* compiled from: WidgetGuildScheduledEventSettings.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventSettingsViewModel.ViewState.Initialized initializedAccess$getCurrentViewState$p = WidgetGuildScheduledEventSettings.access$getCurrentViewState$p(WidgetGuildScheduledEventSettings.this);
            if (initializedAccess$getCurrentViewState$p != null) {
                if (WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).hasStartTimeChanged(initializedAccess$getCurrentViewState$p) && !WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).isDateInFuture(initializedAccess$getCurrentViewState$p.getEventModel().getStartDate(), initializedAccess$getCurrentViewState$p.getEventModel().getStartTime())) {
                    WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, GuildScheduledEventSettingsViewModel.DateError.START_DATE_IN_PAST);
                    return;
                }
                if (WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).hasEndTimeChanged(initializedAccess$getCurrentViewState$p) && !WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).isDateInFuture(initializedAccess$getCurrentViewState$p.getEventModel().getEndDate(), initializedAccess$getCurrentViewState$p.getEventModel().getEndTime())) {
                    WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, GuildScheduledEventSettingsViewModel.DateError.END_DATE_IN_PAST);
                    return;
                }
                if (!WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).isStartDateBeforeEndDate(initializedAccess$getCurrentViewState$p)) {
                    WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, GuildScheduledEventSettingsViewModel.DateError.END_DATE_BEFORE_START_DATE);
                    return;
                }
                WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
                Context contextRequireContext = WidgetGuildScheduledEventSettings.this.requireContext();
                GuildScheduledEventModel eventModel = initializedAccess$getCurrentViewState$p.getEventModel();
                Long lAccess$getExistingGuildScheduledEventId$p = WidgetGuildScheduledEventSettings.access$getExistingGuildScheduledEventId$p(WidgetGuildScheduledEventSettings.this);
                companion.launch(contextRequireContext, eventModel, lAccess$getExistingGuildScheduledEventId$p != null ? new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(lAccess$getExistingGuildScheduledEventId$p.longValue(), WidgetPreviewGuildScheduledEvent.Companion.Action.EDIT_EVENT) : null, WidgetGuildScheduledEventSettings.access$getPreviewLauncher$p(WidgetGuildScheduledEventSettings.this), true);
            }
        }
    }

    public WidgetGuildScheduledEventSettings() {
        super(R.layout.widget_guild_scheduled_event_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventSettings$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildScheduledEventSettings$guildId$2(this));
        this.existingGuildScheduledEventId = LazyJVM.lazy(new WidgetGuildScheduledEventSettings$existingGuildScheduledEventId$2(this));
        this.hubViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventDirectoryAssociationViewModel.class), new WidgetGuildScheduledEventSettings$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetGuildScheduledEventSettings$hubViewModel$2(this)));
        WidgetGuildScheduledEventSettings$viewModel$2 widgetGuildScheduledEventSettings$viewModel$2 = new WidgetGuildScheduledEventSettings$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventSettingsViewModel.class), new WidgetGuildScheduledEventSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventSettings$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.registerForResult(this, new WidgetGuildScheduledEventSettings$previewLauncher$1(this), new WidgetGuildScheduledEventSettings$previewLauncher$2(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings, GuildScheduledEventSettingsViewModel.ViewState viewState) {
        widgetGuildScheduledEventSettings.configureUi(viewState);
    }

    public static final /* synthetic */ void access$configureVisibilitySettings(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings, Tuples2 tuples2) {
        widgetGuildScheduledEventSettings.configureVisibilitySettings(tuples2);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventSettingsBinding access$getBinding$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.getBinding();
    }

    public static final /* synthetic */ GuildScheduledEventSettingsViewModel.ViewState.Initialized access$getCurrentViewState$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.currentViewState;
    }

    public static final /* synthetic */ Long access$getExistingGuildScheduledEventId$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.getExistingGuildScheduledEventId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.getGuildId();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPreviewLauncher$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.previewLauncher;
    }

    public static final /* synthetic */ GuildScheduledEventSettingsViewModel access$getViewModel$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings) {
        return widgetGuildScheduledEventSettings.getViewModel();
    }

    public static final /* synthetic */ void access$setCurrentViewState$p(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings, GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized) {
        widgetGuildScheduledEventSettings.currentViewState = initialized;
    }

    public static final /* synthetic */ void access$showDateErrorToast(WidgetGuildScheduledEventSettings widgetGuildScheduledEventSettings, GuildScheduledEventSettingsViewModel.DateError dateError) {
        widgetGuildScheduledEventSettings.showDateErrorToast(dateError);
    }

    private final void configureEndDateTime(GuildScheduledEventSettingsViewModel.ViewState.Initialized viewState) {
        String dateTime;
        if (viewState.getEventModel().getEntityType() != GuildScheduledEventEntityType.EXTERNAL) {
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.endDateHeader");
            textView.setVisibility(8);
            TextView textView2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.endTimeHeader");
            textView2.setVisibility(8);
            TextInputLayout textInputLayout = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.endDateLayout");
            textInputLayout.setVisibility(8);
            TextInputLayout textInputLayout2 = getBinding().i;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.endTimeLayout");
            textInputLayout2.setVisibility(8);
            return;
        }
        TextView textView3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.endDateHeader");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.endTimeHeader");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.endDateLayout");
        textInputLayout3.setVisibility(0);
        TextInputLayout textInputLayout4 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.endTimeLayout");
        textInputLayout4.setVisibility(0);
        GuildScheduledEventPickerDateTime2 endDate = viewState.getEventModel().getEndDate();
        GuildScheduledEventPickerDateTime3 endTime = viewState.getEventModel().getEndTime();
        String str = "";
        if (endDate == null || (dateTime = DateUtils.formatDateTime(getContext(), endDate.toMillis(), 524292)) == null) {
            dateTime = "";
        }
        if (endTime != null) {
            GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
            if (endDate == null) {
                endDate = GuildScheduledEventPickerDateTime2.INSTANCE.now();
            }
            String dateTime2 = DateUtils.formatDateTime(getContext(), guildScheduledEventPickerDateTime.toMillis(endDate, endTime), 257);
            if (dateTime2 != null) {
                str = dateTime2;
            }
        }
        getBinding().e.setText(dateTime);
        getBinding().h.setText(str);
    }

    private final void configureStartDateTime(GuildScheduledEventSettingsViewModel.ViewState.Initialized viewState) {
        long millis = GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime());
        GuildScheduledEvent existingEvent = viewState.getExistingEvent();
        boolean z2 = (existingEvent != null ? GuildScheduledEventUtilities5.getEventTiming(existingEvent) : null) == GuildScheduledEventUtilities2.LIVE;
        TextInputEditText textInputEditText = getBinding().l;
        ViewExtensions.setEnabledAndAlpha$default(textInputEditText, !z2, 0.0f, 2, null);
        textInputEditText.setText(DateUtils.formatDateTime(textInputEditText.getContext(), millis, 524292));
        TextInputEditText textInputEditText2 = getBinding().m;
        ViewExtensions.setEnabledAndAlpha$default(textInputEditText2, !z2, 0.0f, 2, null);
        textInputEditText2.setText(DateUtils.formatDateTime(textInputEditText2.getContext(), millis, 1));
    }

    private final void configureUi(GuildScheduledEventSettingsViewModel.ViewState viewState) {
        if (viewState instanceof GuildScheduledEventSettingsViewModel.ViewState.Invalid) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel.ViewState.Initialized");
        GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = (GuildScheduledEventSettingsViewModel.ViewState.Initialized) viewState;
        this.currentViewState = initialized;
        GuildScheduledEventModel eventModel = initialized.getEventModel();
        TextInputEditText textInputEditText = getBinding().o;
        if (!Intrinsics3.areEqual(textInputEditText.getText() != null ? r2.toString() : null, eventModel.getName())) {
            textInputEditText.setText(eventModel.getName());
        }
        TextInputEditText textInputEditText2 = getBinding().j;
        if (!Intrinsics3.areEqual(textInputEditText2.getText() != null ? r2.toString() : null, eventModel.getDescription())) {
            textInputEditText2.setText(eventModel.getDescription());
        }
        configureStartDateTime(initialized);
        configureEndDateTime(initialized);
        MaterialButton materialButton = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildScheduledEventSettingsNextButton");
        materialButton.setEnabled(getViewModel().isNextButtonEnabled());
    }

    private final void configureVisibilitySettings(Tuples2<? extends GuildScheduledEventSettingsViewModel.ViewState, GuildScheduledEventDirectoryAssociationViewModel2> states) {
        GuildScheduledEventSettingsViewModel.ViewState viewStateComponent1 = states.component1();
        GuildScheduledEventBroadcast guildScheduledEventBroadcastInvoke = states.component2().getEnabledAsync().invoke();
        if (guildScheduledEventBroadcastInvoke == null || !(viewStateComponent1 instanceof GuildScheduledEventSettingsViewModel.ViewState.Initialized)) {
            return;
        }
        toggleVisibilityOptions(guildScheduledEventBroadcastInvoke.getCanBroadcast());
        GuildScheduledEventSettingsViewModel.ViewState.Initialized initialized = (GuildScheduledEventSettingsViewModel.ViewState.Initialized) viewStateComponent1;
        boolean zIsEventViewableByEveryone = GuildScheduledEventUtilities.INSTANCE.isEventViewableByEveryone(initialized.getEventModel().getChannelId());
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guildScheduledEv…ttingsVisibilityContainer");
        linearLayout.setClickable(zIsEventViewableByEveryone);
        View view = getBinding().r;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.guildScheduledEv…sibilityContainerDisabled");
        boolean zBooleanValue = false;
        view.setVisibility(zIsEventViewableByEveryone ^ true ? 0 : 8);
        MaterialCheckBox materialCheckBox = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
        materialCheckBox.setClickable(zIsEventViewableByEveryone);
        MaterialCheckBox materialCheckBox2 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(materialCheckBox2, "binding.guildScheduledEv…ettingsVisibilityCheckbox");
        materialCheckBox2.setChecked(Intrinsics3.areEqual(initialized.getEventModel().getBroadcastToDirectoryChannels(), Boolean.TRUE));
        if (guildScheduledEventBroadcastInvoke.getCanBroadcast() && initialized.getEventModel().getBroadcastToDirectoryChannels() == null) {
            if (zIsEventViewableByEveryone) {
                Boolean hasBroadcast = guildScheduledEventBroadcastInvoke.getHasBroadcast();
                zBooleanValue = hasBroadcast != null ? hasBroadcast.booleanValue() : true;
            }
            getViewModel().toggleBroadcastToDirectoryChannel(zBooleanValue);
        }
    }

    private final WidgetGuildScheduledEventSettingsBinding getBinding() {
        return (WidgetGuildScheduledEventSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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

    private final GuildScheduledEventSettingsViewModel getViewModel() {
        return (GuildScheduledEventSettingsViewModel) this.viewModel.getValue();
    }

    private final void showDateErrorToast(GuildScheduledEventSettingsViewModel.DateError error) {
        int iOrdinal = error.ordinal();
        if (iOrdinal == 1) {
            AppToast.g(requireContext(), R.string.guild_event_past_start_date, 0, null, 12);
        } else if (iOrdinal == 2) {
            AppToast.g(requireContext(), R.string.guild_event_past_end_date_1, 0, null, 12);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            AppToast.g(requireContext(), R.string.guild_event_end_date_before_start_date, 0, null, 12);
        }
    }

    private final void toggleVisibilityOptions(boolean show) {
        TextView textView = getBinding().t;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEv…tSettingsVisibilityHeader");
        textView.setVisibility(show ? 0 : 8);
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.guildScheduledEv…ttingsVisibilityContainer");
        linearLayout.setVisibility(show ? 0 : 8);
        TextView textView2 = getBinding().f2449s;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildScheduledEv…ingsVisibilityDescription");
        textView2.setVisibility(show ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        Observable observableJ = Observable.j(getViewModel().observeViewState(), getHubViewModel().observeViewState(), AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ttingsState to hubState }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(ObservableExtensionsKt.ui(observableJ), this, null, 2, null), WidgetGuildScheduledEventSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventSettingsStepText");
        FormatUtils.n(textView, R.string.guild_event_step_label, new Object[]{2, 3}, null, 4);
        getBinding().f2448b.setOnClickListener(new AnonymousClass1());
        getBinding().c.setOnClickListener(new AnonymousClass2());
        TextInputEditText textInputEditText = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.guildScheduledEventSettingsTopicInput");
        textInputEditText.addTextChangedListener(new WidgetGuildScheduledEventSettings$onViewBound$$inlined$addTextChangedListener$1(this));
        TextInputEditText textInputEditText2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText2, "binding.guildScheduledEv…tSettingsDescriptionInput");
        textInputEditText2.addTextChangedListener(new WidgetGuildScheduledEventSettings$onViewBound$$inlined$addTextChangedListener$2(this));
        getBinding().m.setOnClickListener(new AnonymousClass5());
        getBinding().l.setOnClickListener(new AnonymousClass6());
        getBinding().h.setOnClickListener(new AnonymousClass7());
        getBinding().e.setOnClickListener(new AnonymousClass8());
        getBinding().k.setOnClickListener(new AnonymousClass9());
        getBinding().q.setOnClickListener(new AnonymousClass10());
        getBinding().p.setOnClickListener(new AnonymousClass11());
    }
}
