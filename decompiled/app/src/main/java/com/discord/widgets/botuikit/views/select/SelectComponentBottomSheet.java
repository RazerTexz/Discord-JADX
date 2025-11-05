package com.discord.widgets.botuikit.views.select;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.botuikit.SelectItem;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.botuikit.views.select.SelectComponentBottomSheetViewModel;
import d0.o;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: SelectComponentBottomSheet.kt */
/* loaded from: classes2.dex */
public final class SelectComponentBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(SelectComponentBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_COMPONENT_CONTEXT = "extra_component_context";
    public static final String EXTRA_COMPONENT_INDEX = "extra_component_index";
    public static final String EXTRA_CUSTOM_ID = "extra_custom_id";
    public static final String EXTRA_EMOJI_ANIMATIONS_ENABLED = "extra_emoji_animations_enabled";
    public static final String EXTRA_MAX = "extra_max";
    public static final String EXTRA_MIN = "extra_min";
    public static final String EXTRA_OPTIONS = "extra_options";
    public static final String EXTRA_PLACEHOLDER = "extra_placeholder";
    public static final String EXTRA_SELECTED = "extra_selected";
    private final SelectComponentBottomSheetAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: SelectComponentBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, ComponentContext componentContext, int componentIndex, String customId, String placeholder, int min, int max, List<SelectItem> options, List<SelectItem> selectedItems, boolean emojiAnimationsEnabled) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(componentContext, "componentContext");
            m.checkNotNullParameter(customId, "customId");
            m.checkNotNullParameter(options, "options");
            m.checkNotNullParameter(selectedItems, "selectedItems");
            SelectComponentBottomSheet selectComponentBottomSheet = new SelectComponentBottomSheet();
            selectComponentBottomSheet.setArguments(BundleKt.bundleOf(o.to(SelectComponentBottomSheet.EXTRA_COMPONENT_CONTEXT, componentContext), o.to(SelectComponentBottomSheet.EXTRA_COMPONENT_INDEX, Integer.valueOf(componentIndex)), o.to(SelectComponentBottomSheet.EXTRA_CUSTOM_ID, customId), o.to(SelectComponentBottomSheet.EXTRA_PLACEHOLDER, placeholder), o.to(SelectComponentBottomSheet.EXTRA_MIN, Integer.valueOf(min)), o.to(SelectComponentBottomSheet.EXTRA_MAX, Integer.valueOf(max)), o.to(SelectComponentBottomSheet.EXTRA_OPTIONS, options), o.to(SelectComponentBottomSheet.EXTRA_SELECTED, selectedItems), o.to(SelectComponentBottomSheet.EXTRA_EMOJI_ANIMATIONS_ENABLED, Boolean.valueOf(emojiAnimationsEnabled))));
            selectComponentBottomSheet.show(fragmentManager, SelectComponentBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SelectComponentBottomSheet.kt */
    /* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SelectComponentBottomSheet.access$getViewModel$p(SelectComponentBottomSheet.this).onClickSelect();
        }
    }

    /* compiled from: SelectComponentBottomSheet.kt */
    /* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<SelectComponentBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(SelectComponentBottomSheet selectComponentBottomSheet) {
            super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SelectComponentBottomSheetViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            SelectComponentBottomSheet.access$configureUI((SelectComponentBottomSheet) this.receiver, viewState);
        }
    }

    /* compiled from: SelectComponentBottomSheet.kt */
    /* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$onResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<SelectComponentBottomSheetViewModel.Event, Unit> {
        public AnonymousClass2(SelectComponentBottomSheet selectComponentBottomSheet) {
            super(1, selectComponentBottomSheet, SelectComponentBottomSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SelectComponentBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SelectComponentBottomSheetViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            SelectComponentBottomSheet.access$handleEvent((SelectComponentBottomSheet) this.receiver, event);
        }
    }

    public SelectComponentBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, SelectComponentBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.adapter = new SelectComponentBottomSheetAdapter(new SelectComponentBottomSheet$adapter$1(this));
        SelectComponentBottomSheet$viewModel$2 selectComponentBottomSheet$viewModel$2 = new SelectComponentBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SelectComponentBottomSheetViewModel.class), new SelectComponentBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(selectComponentBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(SelectComponentBottomSheet selectComponentBottomSheet, SelectComponentBottomSheetViewModel.ViewState viewState) {
        selectComponentBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(SelectComponentBottomSheet selectComponentBottomSheet) {
        return selectComponentBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ SelectComponentBottomSheetViewModel access$getViewModel$p(SelectComponentBottomSheet selectComponentBottomSheet) {
        return selectComponentBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(SelectComponentBottomSheet selectComponentBottomSheet, SelectComponentBottomSheetViewModel.Event event) {
        selectComponentBottomSheet.handleEvent(event);
    }

    private final void configureUI(SelectComponentBottomSheetViewModel.ViewState viewState) {
        TextView textView = getBinding().f2532b;
        m.checkNotNullExpressionValue(textView, "binding.widgetSheetComponentBottomSheetPlaceholder");
        textView.setText(viewState.getTitle());
        TextView textView2 = getBinding().e;
        m.checkNotNullExpressionValue(textView2, "binding.widgetSheetComponentBottomSheetSubtitle");
        textView2.setVisibility(viewState.getIsMultiSelect() ? 0 : 8);
        if (viewState.getIsMultiSelect()) {
            TextView textView3 = getBinding().e;
            m.checkNotNullExpressionValue(textView3, "binding.widgetSheetComponentBottomSheetSubtitle");
            textView3.setText(b.k(this, R.string.message_select_component_select_requirement, new Object[]{Integer.valueOf(viewState.getMinSelections())}, null, 4));
        }
        TextView textView4 = getBinding().d;
        m.checkNotNullExpressionValue(textView4, "binding.widgetSheetComponentBottomSheetSelect");
        textView4.setVisibility(true ^ viewState.getShowSelectButton() ? 4 : 0);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        TextView textView5 = getBinding().d;
        m.checkNotNullExpressionValue(textView5, "binding.widgetSheetComponentBottomSheetSelect");
        ViewExtensions.setEnabledAlpha(textView5, viewState.getIsValidSelection(), 0.3f);
        TextView textView6 = getBinding().d;
        m.checkNotNullExpressionValue(textView6, "binding.widgetSheetComponentBottomSheetSelect");
        textView6.setClickable(viewState.getIsValidSelection());
        this.adapter.setItems(viewState.getItems(), viewState.getMaxSelections(), viewState.getEmojiAnimationsEnabled());
    }

    private final WidgetSelectComponentBottomSheetBinding getBinding() {
        return (WidgetSelectComponentBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SelectComponentBottomSheetViewModel getViewModel() {
        return (SelectComponentBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SelectComponentBottomSheetViewModel.Event event) {
        if (m.areEqual(event, SelectComponentBottomSheetViewModel.Event.CloseSheet.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_select_component_bottom_sheet;
    }

    public final void onItemSelected(SelectItem item, boolean isSelected) {
        m.checkNotNullParameter(item, "item");
        getViewModel().selectItem(item, isSelected);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), SelectComponentBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), SelectComponentBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().c;
        m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.widgetSheetComponentBottomSheetRecycler");
        maxHeightRecyclerView.setAdapter(this.adapter);
    }
}
