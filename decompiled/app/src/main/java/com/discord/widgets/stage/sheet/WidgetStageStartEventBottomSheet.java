package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageStartEventBottomSheetBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheetViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageStartEventBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetStageStartEventBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WidgetStageStartEventBottomSheet show$default(Companion companion, FragmentManager fragmentManager, long j, Function0 function0, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = null;
            }
            return companion.show(fragmentManager, j, function0);
        }

        public final WidgetStageStartEventBottomSheet show(FragmentManager fragmentManager, long channelId, Function0<Unit> onDismiss) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet = new WidgetStageStartEventBottomSheet();
            widgetStageStartEventBottomSheet.setOnDismiss(onDismiss);
            widgetStageStartEventBottomSheet.setArguments(Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetStageStartEventBottomSheet.show(fragmentManager, WidgetStageStartEventBottomSheet.class.getSimpleName());
            return widgetStageStartEventBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
    public static final class C100551 extends Lambda implements Function1<WidgetStageStartEventBottomSheetViewModel.Event, Unit> {
        public C100551() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageStartEventBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageStartEventBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetStageStartEventBottomSheet.access$handleEvent(WidgetStageStartEventBottomSheet.this, event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onResume$2 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
    public static final class C100562 extends Lambda implements Function1<WidgetStageStartEventBottomSheetViewModel.ViewState, Unit> {
        public C100562() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageStartEventBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageStartEventBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetStageStartEventBottomSheet.access$configureUI(WidgetStageStartEventBottomSheet.this, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
    public static final class C100571 extends Lambda implements Function1<Editable, Unit> {
        public C100571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            TextInputLayout textInputLayout = WidgetStageStartEventBottomSheet.access$getBinding$p(WidgetStageStartEventBottomSheet.this).f18179g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.topicLayout");
            textInputLayout.setError(null);
            WidgetStageStartEventBottomSheet.access$getViewModel$p(WidgetStageStartEventBottomSheet.this).setTopic(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
    public static final class ViewOnClickListenerC100582 implements View.OnClickListener {

        /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onViewCreated$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetStageStartEventBottomSheet.access$getViewModel$p(WidgetStageStartEventBottomSheet.this).openStage(false);
                Function0<Unit> onDismiss = WidgetStageStartEventBottomSheet.this.getOnDismiss();
                if (onDismiss != null) {
                    onDismiss.invoke();
                }
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$onViewCreated$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetStageStartEventBottomSheet.access$getViewModel$p(WidgetStageStartEventBottomSheet.this).openStage(true);
                Function0<Unit> onDismiss = WidgetStageStartEventBottomSheet.this.getOnDismiss();
                if (onDismiss != null) {
                    onDismiss.invoke();
                }
            }
        }

        public ViewOnClickListenerC100582() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStageStartEventBottomSheet.this.requestMicrophone(new AnonymousClass1(), new AnonymousClass2());
        }
    }

    public WidgetStageStartEventBottomSheet() {
        super(true);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageStartEventBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetStageStartEventBottomSheet3(this));
        WidgetStageStartEventBottomSheet4 widgetStageStartEventBottomSheet4 = new WidgetStageStartEventBottomSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetStageStartEventBottomSheetViewModel.class), new C10054x3bfafd43(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageStartEventBottomSheet4));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet, WidgetStageStartEventBottomSheetViewModel.ViewState viewState) {
        widgetStageStartEventBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetStageStartEventBottomSheetBinding access$getBinding$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetStageStartEventBottomSheetViewModel access$getViewModel$p(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet) {
        return widgetStageStartEventBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetStageStartEventBottomSheet widgetStageStartEventBottomSheet, WidgetStageStartEventBottomSheetViewModel.Event event) {
        widgetStageStartEventBottomSheet.handleEvent(event);
    }

    private final void configureUI(WidgetStageStartEventBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageStartEventBottomSheetViewModel.ViewState.Loaded) {
            MaterialButton materialButton = getBinding().f18175c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.startStageButton");
            WidgetStageStartEventBottomSheetViewModel.ViewState.Loaded loaded = (WidgetStageStartEventBottomSheetViewModel.ViewState.Loaded) viewState;
            ViewExtensions.setEnabledAndAlpha$default(materialButton, loaded.getTopic().length() > 0, 0.0f, 2, null);
            String topic = loaded.getTopic();
            Intrinsics3.checkNotNullExpressionValue(getBinding().f18179g, "binding.topicLayout");
            if (!Intrinsics3.areEqual(topic, ViewExtensions.getTextOrEmpty(r2))) {
                getBinding().f18178f.setText(loaded.getTopic());
            }
            TextView textView = getBinding().f18177e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
            textView.setText(getString(loaded.getStageInstance() == null ? C5419R.string.start_stage_channel_event_modal_title : C5419R.string.edit_stage_title));
            TextView textView2 = getBinding().f18176d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitle");
            textView2.setText(getString(loaded.getStageInstance() == null ? C5419R.string.start_stage_channel_event_modal_subtitle : C5419R.string.edit_stage_subtitle));
            MaterialButton materialButton2 = getBinding().f18175c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.startStageButton");
            materialButton2.setText(getString(loaded.getStageInstance() == null ? C5419R.string.start_stage_channel_event_modal_button : C5419R.string.save_changes));
            TextView textView3 = getBinding().f18174b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.speakerHint");
            textView3.setVisibility(loaded.getStageInstance() == null ? 0 : 8);
        }
    }

    private final WidgetStageStartEventBottomSheetBinding getBinding() {
        return (WidgetStageStartEventBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageStartEventBottomSheetViewModel getViewModel() {
        return (WidgetStageStartEventBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetStageStartEventBottomSheetViewModel.Event event) {
        if (event instanceof WidgetStageStartEventBottomSheetViewModel.Event.SetTopicSuccess) {
            AppBottomSheet.hideKeyboard$default(this, null, 1, null);
            dismiss();
        } else if (event instanceof WidgetStageStartEventBottomSheetViewModel.Event.SetTopicFailure) {
            AppToast.m171i(this, ((WidgetStageStartEventBottomSheetViewModel.Event.SetTopicFailure) event).getFailureMessageStringRes(), 0, 4);
        } else if (event instanceof WidgetStageStartEventBottomSheetViewModel.Event.InvalidTopic) {
            TextInputLayout textInputLayout = getBinding().f18179g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.topicLayout");
            textInputLayout.setError(getString(((WidgetStageStartEventBottomSheetViewModel.Event.InvalidTopic) event).getFailureMessageStringRes()));
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_stage_start_event_bottom_sheet;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetStageStartEventBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C100551(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageStartEventBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C100562(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextInputEditText textInputEditText = getBinding().f18178f;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.topicInput");
        TextWatcher4.addBindedTextWatcher(textInputEditText, this, new C100571());
        getBinding().f18175c.setOnClickListener(new ViewOnClickListenerC100582());
    }

    public final void setOnDismiss(Function0<Unit> function0) {
        this.onDismiss = function0;
    }
}
