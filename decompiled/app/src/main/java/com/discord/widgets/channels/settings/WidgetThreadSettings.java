package com.discord.widgets.channels.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.i.s4;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadSettingsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetThreadSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetThreadSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long channelId, Context context) {
            m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            j.d(context, WidgetThreadSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public AnonymousClass1(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
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
            WidgetThreadSettings.access$confirmDelete(WidgetThreadSettings.this, ((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getChannel());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public AnonymousClass2(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_channel_settings_delete);
            m.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
            menuItemFindItem.setVisible(((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getCanManageThread());
            menu.findItem(R.id.menu_channel_settings_delete).setTitle(R.string.delete_thread);
            MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_channel_settings_reset);
            m.checkNotNullExpressionValue(menuItemFindItem2, "it.findItem(R.id.menu_channel_settings_reset)");
            menuItemFindItem2.setVisible(false);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public AnonymousClass3(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPinnedMessages.INSTANCE.show(a.x(view, "it", "it.context"), ((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getChannel().getId());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            m.checkNotNullExpressionValue(view, "it");
            b.a.d.m.g(view.getContext(), R.string.pins_disabled_nsfw, 0, null, 12);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).saveThread();
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$confirmDelete$1, reason: invalid class name */
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

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$confirmDelete$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onThreadDeleted(this.$channel.getId());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            m.checkNotNullParameter(editable, "editable");
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onChannelNameInputChanged(editable.toString());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends b.a.y.j {
        public AnonymousClass2() {
        }

        @Override // b.a.y.j, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            m.checkNotNullParameter(seekBar, "seekBar");
            super.onProgressChanged(seekBar, progress, fromUser);
            if (fromUser) {
                int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                WidgetThreadSettings.access$setSlowmodeLabel(WidgetThreadSettings.this, iIntValue);
                WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onSlowModeInputChanged(iIntValue);
                TextView textView = WidgetThreadSettings.access$getBinding$p(WidgetThreadSettings.this).h;
                m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
                seekBar.setContentDescription(textView.getText());
            }
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetThreadSettingsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetThreadSettings.access$configureUI((WidgetThreadSettings) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<WidgetThreadSettingsViewModel.Event, Unit> {
        public AnonymousClass2(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetThreadSettings.access$handleEvent((WidgetThreadSettings) this.receiver, event);
        }
    }

    public WidgetThreadSettings() {
        super(R.layout.widget_thread_settings);
        WidgetThreadSettings$viewModel$2 widgetThreadSettings$viewModel$2 = new WidgetThreadSettings$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadSettingsViewModel.class), new WidgetThreadSettings$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetThreadSettings$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadSettings$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadSettings widgetThreadSettings, WidgetThreadSettingsViewModel.ViewState viewState) {
        widgetThreadSettings.configureUI(viewState);
    }

    public static final /* synthetic */ void access$confirmDelete(WidgetThreadSettings widgetThreadSettings, Channel channel) {
        widgetThreadSettings.confirmDelete(channel);
    }

    public static final /* synthetic */ WidgetThreadSettingsBinding access$getBinding$p(WidgetThreadSettings widgetThreadSettings) {
        return widgetThreadSettings.getBinding();
    }

    public static final /* synthetic */ WidgetThreadSettingsViewModel access$getViewModel$p(WidgetThreadSettings widgetThreadSettings) {
        return widgetThreadSettings.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetThreadSettings widgetThreadSettings, WidgetThreadSettingsViewModel.Event event) {
        widgetThreadSettings.handleEvent(event);
    }

    public static final /* synthetic */ void access$setSlowmodeLabel(WidgetThreadSettings widgetThreadSettings, int i) {
        widgetThreadSettings.setSlowmodeLabel(i);
    }

    private final void configureUI(WidgetThreadSettingsViewModel.ViewState viewState) {
        if (!(viewState instanceof WidgetThreadSettingsViewModel.ViewState.Valid)) {
            requireActivity().finish();
            return;
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.thread_settings);
        WidgetThreadSettingsViewModel.ViewState.Valid valid = (WidgetThreadSettingsViewModel.ViewState.Valid) viewState;
        setActionBarSubtitle(ChannelUtils.e(valid.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(R.menu.menu_text_channel_settings, new AnonymousClass1(viewState), new AnonymousClass2(viewState));
        LinearLayout linearLayout = getBinding().e;
        m.checkNotNullExpressionValue(linearLayout, "binding.threadSettingsEditWrap");
        linearLayout.setVisibility(valid.getCanManageThread() ? 0 : 8);
        String channelNameDraft = valid.getChannelNameDraft();
        m.checkNotNullExpressionValue(getBinding().d, "binding.threadSettingsEditName");
        if (!m.areEqual(channelNameDraft, ViewExtensions.getTextOrEmpty(r4))) {
            TextInputLayout textInputLayout = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
            ViewExtensions.setText(textInputLayout, valid.getChannelNameDraft());
        }
        LinearLayout linearLayout2 = getBinding().g;
        m.checkNotNullExpressionValue(linearLayout2, "binding.threadSettingsSectionSlowMode");
        linearLayout2.setVisibility(valid.getCanManageThread() ? 0 : 8);
        int slowModeCooldownDraft = valid.getSlowModeCooldownDraft();
        setSlowmodeLabel(slowModeCooldownDraft);
        Iterator<Integer> it = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else {
                if (it.next().intValue() >= slowModeCooldownDraft) {
                    break;
                } else {
                    i++;
                }
            }
        }
        SeekBar seekBar = getBinding().i;
        m.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        SeekBar seekBar2 = getBinding().i;
        m.checkNotNullExpressionValue(seekBar2, "binding.threadSettingsSlowModeCooldownSlider");
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView.getText());
        TextView textView2 = getBinding().f2672b;
        m.checkNotNullExpressionValue(textView2, "binding.channelSettingsPinnedMessages");
        textView2.setEnabled(valid.isPinsEnabled());
        getBinding().f2672b.setOnClickListener(new AnonymousClass3(viewState));
        View view = getBinding().c;
        m.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(true ^ valid.isPinsEnabled() ? 0 : 8);
        getBinding().c.setOnClickListener(AnonymousClass4.INSTANCE);
        FloatingActionButton floatingActionButton = getBinding().f;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.threadSettingsSave");
        floatingActionButton.setVisibility(valid.getHasUnsavedChanges() ? 0 : 8);
        getBinding().f.setOnClickListener(new AnonymousClass5());
    }

    private final void confirmDelete(Channel channel) {
        s4 s4VarA = s4.a(LayoutInflater.from(getContext()), null, false);
        m.checkNotNullExpressionValue(s4VarA, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = s4VarA.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(s4VarA.a).create();
        s4VarA.e.setText(R.string.delete_thread);
        s4VarA.c.setOnClickListener(new AnonymousClass1(alertDialogCreate));
        s4VarA.d.setOnClickListener(new AnonymousClass2(channel));
        TextView textView = s4VarA.f199b;
        m.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        b.n(textView, R.string.delete_channel_body, new Object[]{ChannelUtils.e(channel, requireContext(), false, 2)}, null, 4);
        alertDialogCreate.show();
    }

    private final WidgetThreadSettingsBinding getBinding() {
        return (WidgetThreadSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadSettingsViewModel getViewModel() {
        return (WidgetThreadSettingsViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetThreadSettingsViewModel.Event event) {
        if (event instanceof WidgetThreadSettingsViewModel.Event.ShowToast) {
            b.a.d.m.i(this, ((WidgetThreadSettingsViewModel.Event.ShowToast) event).getMessageStringRes(), 0, 4);
        }
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        WidgetTextChannelSettings.Companion companion = WidgetTextChannelSettings.INSTANCE;
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), R.string.form_label_slowmode_off);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        SeekBar seekBar = getBinding().i;
        m.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setMax(n.getLastIndex(WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES()));
        getBinding().i.setOnSeekBarChangeListener(new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetThreadSettingsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetThreadSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), WidgetThreadSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
