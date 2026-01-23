package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageAudienceBlockedBottomSheetBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetStageAudienceBlockedBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_LAUNCH_FULL_SCREEN = "LAUNCH_FULL_SCREEN";
    private StageAudienceBlockedBottomSheetAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: launchStageFullScreen$delegate, reason: from kotlin metadata */
    private final Lazy launchStageFullScreen;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, boolean launchStageFullScreen) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet = new WidgetStageAudienceBlockedBottomSheet();
            widgetStageAudienceBlockedBottomSheet.setArguments(Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), Tuples.m10073to(WidgetStageAudienceBlockedBottomSheet.EXTRA_LAUNCH_FULL_SCREEN, Boolean.valueOf(launchStageFullScreen))));
            widgetStageAudienceBlockedBottomSheet.show(fragmentManager, WidgetStageAudienceBlockedBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$configureUI$1 */
    /* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    public static final class ViewOnClickListenerC100221 implements View.OnClickListener {
        public final /* synthetic */ StageAudienceBlockedBottomSheetViewModel.ViewState $viewState;

        /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
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
                WidgetStageAudienceBlockedBottomSheet.this.dismiss();
            }
        }

        public ViewOnClickListenerC100221(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
            Context contextRequireContext = WidgetStageAudienceBlockedBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            FragmentManager parentFragmentManager = WidgetStageAudienceBlockedBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            StageChannelJoinHelper.connectToStage$default(stageChannelJoinHelper, contextRequireContext, parentFragmentManager, ((StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded) this.$viewState).getChannel().getId(), true, WidgetStageAudienceBlockedBottomSheet.access$getLaunchStageFullScreen$p(WidgetStageAudienceBlockedBottomSheet.this), null, null, null, null, new AnonymousClass1(), 480, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$configureUI$2 */
    /* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    public static final class ViewOnClickListenerC100232 implements View.OnClickListener {
        public ViewOnClickListenerC100232() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStageAudienceBlockedBottomSheet.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    public static final /* synthetic */ class C100241 extends FunctionReferenceImpl implements Function1<StageAudienceBlockedBottomSheetViewModel.ViewState, Unit> {
        public C100241(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
            super(1, widgetStageAudienceBlockedBottomSheet, WidgetStageAudienceBlockedBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetStageAudienceBlockedBottomSheet.access$configureUI((WidgetStageAudienceBlockedBottomSheet) this.receiver, viewState);
        }
    }

    public WidgetStageAudienceBlockedBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageAudienceBlockedBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetStageAudienceBlockedBottomSheet3(this));
        this.launchStageFullScreen = LazyJVM.lazy(new WidgetStageAudienceBlockedBottomSheet4(this));
        WidgetStageAudienceBlockedBottomSheet5 widgetStageAudienceBlockedBottomSheet5 = new WidgetStageAudienceBlockedBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(StageAudienceBlockedBottomSheetViewModel.class), new C10021xd168dac7(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageAudienceBlockedBottomSheet5));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet, StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
        widgetStageAudienceBlockedBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getChannelId();
    }

    public static final /* synthetic */ boolean access$getLaunchStageFullScreen$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getLaunchStageFullScreen();
    }

    private final void configureUI(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof StageAudienceBlockedBottomSheetViewModel.ViewState.Invalid) {
            dismiss();
            return;
        }
        if (!(viewState instanceof StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        getBinding().f18125b.setOnClickListener(new ViewOnClickListenerC100221(viewState));
        getBinding().f18127d.setOnClickListener(new ViewOnClickListenerC100232());
        StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter = this.adapter;
        if (stageAudienceBlockedBottomSheetAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        stageAudienceBlockedBottomSheetAdapter.setData(((StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded) viewState).getListItems());
    }

    private final WidgetStageAudienceBlockedBottomSheetBinding getBinding() {
        return (WidgetStageAudienceBlockedBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final boolean getLaunchStageFullScreen() {
        return ((Boolean) this.launchStageFullScreen.getValue()).booleanValue();
    }

    private final StageAudienceBlockedBottomSheetViewModel getViewModel() {
        return (StageAudienceBlockedBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_stage_audience_blocked_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageAudienceBlockedBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C100241(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WidgetStageAudienceBlockedBottomSheetBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        setPeekHeightBottomView(binding.f18124a);
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().f18126c;
        Intrinsics3.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.blockedUsers");
        this.adapter = new StageAudienceBlockedBottomSheetAdapter(maxHeightRecyclerView);
    }
}
