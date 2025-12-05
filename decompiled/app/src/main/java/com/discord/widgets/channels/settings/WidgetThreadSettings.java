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
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadSettingsBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettingsViewModel;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.WidgetChannelSettingsDeleteBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.OnSeekBarChangeListenerAdapter;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* compiled from: WidgetThreadSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetThreadSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadSettingsBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…RA_CHANNEL_ID, channelId)");
            AppScreen2.m156d(context, WidgetThreadSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$1 */
    public static final class C76091<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public C76091(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
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
            WidgetThreadSettings.access$confirmDelete(WidgetThreadSettings.this, ((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getChannel());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$2 */
    public static final class C76102<T> implements Action1<Menu> {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public C76102(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_channel_settings_delete);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "it.findItem(R.id.menu_channel_settings_delete)");
            menuItemFindItem.setVisible(((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getCanManageThread());
            menu.findItem(C5419R.id.menu_channel_settings_delete).setTitle(C5419R.string.delete_thread);
            MenuItem menuItemFindItem2 = menu.findItem(C5419R.id.menu_channel_settings_reset);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "it.findItem(R.id.menu_channel_settings_reset)");
            menuItemFindItem2.setVisible(false);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$3 */
    public static final class ViewOnClickListenerC76113 implements View.OnClickListener {
        public final /* synthetic */ WidgetThreadSettingsViewModel.ViewState $viewState;

        public ViewOnClickListenerC76113(WidgetThreadSettingsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelPinnedMessages.INSTANCE.show(outline.m885x(view, "it", "it.context"), ((WidgetThreadSettingsViewModel.ViewState.Valid) this.$viewState).getChannel().getId());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$4 */
    public static final class ViewOnClickListenerC76124 implements View.OnClickListener {
        public static final ViewOnClickListenerC76124 INSTANCE = new ViewOnClickListenerC76124();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            AppToast.m169g(view.getContext(), C5419R.string.pins_disabled_nsfw, 0, null, 12);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$configureUI$5 */
    public static final class ViewOnClickListenerC76135 implements View.OnClickListener {
        public ViewOnClickListenerC76135() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).saveThread();
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$confirmDelete$1 */
    public static final class ViewOnClickListenerC76141 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public ViewOnClickListenerC76141(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$confirmDelete$2 */
    public static final class ViewOnClickListenerC76152 implements View.OnClickListener {
        public final /* synthetic */ Channel $channel;

        public ViewOnClickListenerC76152(Channel channel) {
            this.$channel = channel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onThreadDeleted(this.$channel.getId());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBound$1 */
    public static final class C76161 extends Lambda implements Function1<Editable, Unit> {
        public C76161() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onChannelNameInputChanged(editable.toString());
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBound$2 */
    public static final class C76172 extends OnSeekBarChangeListenerAdapter {
        public C76172() {
        }

        @Override // p007b.p008a.p062y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            super.onProgressChanged(seekBar, progress, fromUser);
            if (fromUser) {
                int iIntValue = WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES().get(progress).intValue();
                WidgetThreadSettings.access$setSlowmodeLabel(WidgetThreadSettings.this, iIntValue);
                WidgetThreadSettings.access$getViewModel$p(WidgetThreadSettings.this).onSlowModeInputChanged(iIntValue);
                TextView textView = WidgetThreadSettings.access$getBinding$p(WidgetThreadSettings.this).f18287h;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
                seekBar.setContentDescription(textView.getText());
            }
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C76181 extends FunctionReferenceImpl implements Function1<WidgetThreadSettingsViewModel.ViewState, Unit> {
        public C76181(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetThreadSettings.access$configureUI((WidgetThreadSettings) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetThreadSettings.kt */
    /* renamed from: com.discord.widgets.channels.settings.WidgetThreadSettings$onViewBoundOrOnResume$2 */
    public static final /* synthetic */ class C76192 extends FunctionReferenceImpl implements Function1<WidgetThreadSettingsViewModel.Event, Unit> {
        public C76192(WidgetThreadSettings widgetThreadSettings) {
            super(1, widgetThreadSettings, WidgetThreadSettings.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/settings/WidgetThreadSettingsViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadSettingsViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadSettingsViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetThreadSettings.access$handleEvent((WidgetThreadSettings) this.receiver, event);
        }
    }

    public WidgetThreadSettings() {
        super(C5419R.layout.widget_thread_settings);
        WidgetThreadSettings3 widgetThreadSettings3 = new WidgetThreadSettings3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadSettingsViewModel.class), new WidgetThreadSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetThreadSettings3));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadSettings2.INSTANCE, null, 2, null);
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
        setActionBarTitle(C5419R.string.thread_settings);
        WidgetThreadSettingsViewModel.ViewState.Valid valid = (WidgetThreadSettingsViewModel.ViewState.Valid) viewState;
        setActionBarSubtitle(ChannelUtils.m7681e(valid.getChannel(), requireContext(), false, 2));
        setActionBarOptionsMenu(C5419R.menu.menu_text_channel_settings, new C76091(viewState), new C76102(viewState));
        LinearLayout linearLayout = getBinding().f18284e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.threadSettingsEditWrap");
        linearLayout.setVisibility(valid.getCanManageThread() ? 0 : 8);
        String channelNameDraft = valid.getChannelNameDraft();
        Intrinsics3.checkNotNullExpressionValue(getBinding().f18283d, "binding.threadSettingsEditName");
        if (!Intrinsics3.areEqual(channelNameDraft, ViewExtensions.getTextOrEmpty(r4))) {
            TextInputLayout textInputLayout = getBinding().f18283d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
            ViewExtensions.setText(textInputLayout, valid.getChannelNameDraft());
        }
        LinearLayout linearLayout2 = getBinding().f18286g;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.threadSettingsSectionSlowMode");
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
        SeekBar seekBar = getBinding().f18288i;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setProgress(i);
        SeekBar seekBar2 = getBinding().f18288i;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.threadSettingsSlowModeCooldownSlider");
        TextView textView = getBinding().f18287h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        seekBar2.setContentDescription(textView.getText());
        TextView textView2 = getBinding().f18281b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelSettingsPinnedMessages");
        textView2.setEnabled(valid.isPinsEnabled());
        getBinding().f18281b.setOnClickListener(new ViewOnClickListenerC76113(viewState));
        View view = getBinding().f18282c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.channelSettingsP…edMessagesDisabledOverlay");
        view.setVisibility(true ^ valid.isPinsEnabled() ? 0 : 8);
        getBinding().f18282c.setOnClickListener(ViewOnClickListenerC76124.INSTANCE);
        FloatingActionButton floatingActionButton = getBinding().f18285f;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.threadSettingsSave");
        floatingActionButton.setVisibility(valid.getHasUnsavedChanges() ? 0 : 8);
        getBinding().f18285f.setOnClickListener(new ViewOnClickListenerC76135());
    }

    private final void confirmDelete(Channel channel) {
        WidgetChannelSettingsDeleteBinding widgetChannelSettingsDeleteBindingM206a = WidgetChannelSettingsDeleteBinding.m206a(LayoutInflater.from(getContext()), null, false);
        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsDeleteBindingM206a, "WidgetChannelSettingsDel…om(context), null, false)");
        LinearLayout linearLayout = widgetChannelSettingsDeleteBindingM206a.f1214a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(widgetChannelSettingsDeleteBindingM206a.f1214a).create();
        widgetChannelSettingsDeleteBindingM206a.f1218e.setText(C5419R.string.delete_thread);
        widgetChannelSettingsDeleteBindingM206a.f1216c.setOnClickListener(new ViewOnClickListenerC76141(alertDialogCreate));
        widgetChannelSettingsDeleteBindingM206a.f1217d.setOnClickListener(new ViewOnClickListenerC76152(channel));
        TextView textView = widgetChannelSettingsDeleteBindingM206a.f1215b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelSettingsDeleteBody");
        FormatUtils.m222n(textView, C5419R.string.delete_channel_body, new Object[]{ChannelUtils.m7681e(channel, requireContext(), false, 2)}, null, 4);
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
            AppToast.m171i(this, ((WidgetThreadSettingsViewModel.Event.ShowToast) event).getMessageStringRes(), 0, 4);
        }
    }

    private final void setSlowmodeLabel(int cooldownSecs) {
        WidgetTextChannelSettings.Companion companion = WidgetTextChannelSettings.INSTANCE;
        TextView textView = getBinding().f18287h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadSettingsSlowModeCooldownLabel");
        companion.setDurationSecondsLabel(textView, cooldownSecs, requireContext(), C5419R.string.form_label_slowmode_off);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().f18283d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.threadSettingsEditName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C76161());
        SeekBar seekBar = getBinding().f18288i;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.threadSettingsSlowModeCooldownSlider");
        seekBar.setMax(Collections2.getLastIndex(WidgetTextChannelSettings.INSTANCE.getSLOWMODE_COOLDOWN_VALUES()));
        getBinding().f18288i.setOnSeekBarChangeListener(new C76172());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetThreadSettingsViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetThreadSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C76181(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), WidgetThreadSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C76192(this), 62, (Object) null);
    }
}
