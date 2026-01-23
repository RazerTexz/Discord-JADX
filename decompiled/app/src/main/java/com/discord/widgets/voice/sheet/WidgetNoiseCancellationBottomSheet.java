package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceNoiseCancellationBottomSheetBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheetViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetNoiseCancellationBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceNoiseCancellationBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet = new WidgetNoiseCancellationBottomSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetNoiseCancellationBottomSheet.show(parentFragmentManager, WidgetNoiseCancellationBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$configureUI$1 */
    /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
    public static final class ViewOnClickListenerC105731 implements View.OnClickListener {
        public ViewOnClickListenerC105731() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoiseCancellationBottomSheet.access$getViewModel$p(WidgetNoiseCancellationBottomSheet.this).onNoiseCancellationButtonPressed();
            WidgetNoiseCancellationBottomSheet.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.sheet.WidgetNoiseCancellationBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetNoiseCancellationBottomSheet.kt */
    public static final class C105741 extends Lambda implements Function1<WidgetNoiseCancellationBottomSheetViewModel.Event, Unit> {
        public C105741() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetNoiseCancellationBottomSheet.access$handleEvent(WidgetNoiseCancellationBottomSheet.this, event);
        }
    }

    public WidgetNoiseCancellationBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNoiseCancellationBottomSheet2.INSTANCE, null, 2, null);
        WidgetNoiseCancellationBottomSheet3 widgetNoiseCancellationBottomSheet3 = WidgetNoiseCancellationBottomSheet3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetNoiseCancellationBottomSheetViewModel.class), new C10572xfbbb891c(appViewModelDelegates3), new AppViewModelDelegates5(widgetNoiseCancellationBottomSheet3));
    }

    public static final /* synthetic */ WidgetNoiseCancellationBottomSheetViewModel access$getViewModel$p(WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet) {
        return widgetNoiseCancellationBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetNoiseCancellationBottomSheet widgetNoiseCancellationBottomSheet, WidgetNoiseCancellationBottomSheetViewModel.Event event) {
        widgetNoiseCancellationBottomSheet.handleEvent(event);
    }

    private final void configureUI() {
        TextView textView = getBinding().f18481c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noiseCancellationLearnMore");
        FormatUtils.m222n(textView, C5419R.string.learn_more_link, new Object[]{AppHelpDesk.f507a.m149a(360040843952L, null)}, null, 4);
        TextView textView2 = getBinding().f18481c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noiseCancellationLearnMore");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        getBinding().f18480b.setOnClickListener(new ViewOnClickListenerC105731());
    }

    private final WidgetVoiceNoiseCancellationBottomSheetBinding getBinding() {
        return (WidgetVoiceNoiseCancellationBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetNoiseCancellationBottomSheetViewModel getViewModel() {
        return (WidgetNoiseCancellationBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetNoiseCancellationBottomSheetViewModel.Event event) {
        if (event instanceof WidgetNoiseCancellationBottomSheetViewModel.Event.ShowToast) {
            AppToast.m169g(requireContext(), ((WidgetNoiseCancellationBottomSheetViewModel.Event.ShowToast) event).getToastResId(), 0, null, 12);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_voice_noise_cancellation_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetNoiseCancellationBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C105741(), 62, (Object) null);
        configureUI();
    }
}
