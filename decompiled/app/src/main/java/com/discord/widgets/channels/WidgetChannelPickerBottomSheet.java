package com.discord.widgets.channels;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelPickerSheetBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheetViewModel;
import com.discord.widgets.chat.AutocompleteUtils;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPickerBottomSheet extends AppBottomSheet {
    private static final String ARG_CHANNEL_PICKER_GUILD_ID = "ARG_CHANNEL_PICKER_GUILD_ID";
    private static final String ARG_HIDE_ANNOUNCEMENT_CHANNELS = "ARG_HIDE_ANNOUNCEMENT_CHANNELS";
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String ARG_SELECTED_CHANNEL_ID = "ARG_SELECTED_CHANNEL_ID";
    private static final int CHANNEL_PICKER_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int CHANNEL_PICKER_VIEW_FLIPPER_RESULT = 1;
    private static final String RESULT_EXTRA_CHANNEL_ICON_RES_ID = "RESULT_EXTRA_CHANNEL_ICON_RES_ID";
    private static final String RESULT_EXTRA_CHANNEL_ID = "RESULT_EXTRA_CHANNEL_ID";
    private static final String RESULT_EXTRA_CHANNEL_NAME = "RESULT_EXTRA_CHANNEL_NAME";
    private static final String RESULT_EXTRA_SELECTION_TYPE = "RESULT_EXTRA_SELECTION_TYPE";
    private WidgetChannelPickerAdapter3 adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: hideAnnouncementChannels$delegate, reason: from kotlin metadata */
    private final Lazy hideAnnouncementChannels;
    private final WidgetChannelPickerBottomSheet6 itemClickListener;
    private Function0<Unit> onCancel;

    /* JADX INFO: renamed from: selectedChannelId$delegate, reason: from kotlin metadata */
    private final Lazy selectedChannelId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChannelPickerBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelPickerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                SelectionType.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[SelectionType.CREATE_CHANNEL.ordinal()] = 1;
                iArr[SelectionType.CHANNEL.ordinal()] = 2;
                iArr[SelectionType.UNKNOWN.ordinal()] = 3;
            }
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void launch$default(Companion companion, Fragment fragment, String str, long j, Long l, Function0 function0, boolean z2, int i, Object obj) {
            companion.launch(fragment, str, j, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : function0, (i & 32) != 0 ? false : z2);
        }

        public final void launch(Fragment fragment, String requestKey, long guildId, Long selectedChannelId, Function0<Unit> onCancel, boolean hideAnnouncementChannels) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet = new WidgetChannelPickerBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetChannelPickerBottomSheet.ARG_REQUEST_KEY, requestKey);
            bundle.putLong(WidgetChannelPickerBottomSheet.ARG_CHANNEL_PICKER_GUILD_ID, guildId);
            bundle.putBoolean(WidgetChannelPickerBottomSheet.ARG_HIDE_ANNOUNCEMENT_CHANNELS, hideAnnouncementChannels);
            if (selectedChannelId != null) {
                bundle.putLong(WidgetChannelPickerBottomSheet.ARG_SELECTED_CHANNEL_ID, selectedChannelId.longValue());
            }
            widgetChannelPickerBottomSheet.setArguments(bundle);
            widgetChannelPickerBottomSheet.setOnCancel(onCancel);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetChannelPickerBottomSheet.show(parentFragmentManager, WidgetChannelPickerBottomSheet.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function3<? super Long, ? super String, ? super Integer, Unit> onChannelSelected, Function0<Unit> onCreateChannelSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onChannelSelected, "onChannelSelected");
            Intrinsics3.checkNotNullParameter(onCreateChannelSelected, "onCreateChannelSelected");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetChannelPickerBottomSheet2(requestKey, onCreateChannelSelected, onChannelSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
    public enum SelectionType {
        UNKNOWN,
        CREATE_CHANNEL,
        CHANNEL;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
        public static final class Companion {
            private Companion() {
            }

            public final SelectionType fromInt(int value) {
                SelectionType selectionType = (SelectionType) _Arrays.getOrNull(SelectionType.values(), value);
                return selectionType != null ? selectionType : SelectionType.UNKNOWN;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
    public static final class C73321 extends Lambda implements Function1<WidgetChannelPickerBottomSheetViewModel.ViewState, Unit> {
        public C73321() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetChannelPickerBottomSheet.access$configureUI(WidgetChannelPickerBottomSheet.this, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelPickerBottomSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetChannelPickerBottomSheet.kt */
    public static final class C73331 extends Lambda implements Function1<String, Unit> {
        public C73331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetChannelPickerBottomSheet.access$getViewModel$p(WidgetChannelPickerBottomSheet.this).updateSearchQuery(str);
        }
    }

    public WidgetChannelPickerBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelPickerBottomSheet3.INSTANCE, null, 2, null);
        this.selectedChannelId = LazyJVM.lazy(new WidgetChannelPickerBottomSheet7(this));
        this.guildId = LazyJVM.lazy(new WidgetChannelPickerBottomSheet4(this));
        this.hideAnnouncementChannels = LazyJVM.lazy(new WidgetChannelPickerBottomSheet5(this));
        WidgetChannelPickerBottomSheet8 widgetChannelPickerBottomSheet8 = new WidgetChannelPickerBottomSheet8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelPickerBottomSheetViewModel.class), new C7331xa50f5668(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelPickerBottomSheet8));
        this.itemClickListener = new WidgetChannelPickerBottomSheet6(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet, WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
        widgetChannelPickerBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getGuildId();
    }

    public static final /* synthetic */ boolean access$getHideAnnouncementChannels$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getHideAnnouncementChannels();
    }

    public static final /* synthetic */ long access$getSelectedChannelId$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getSelectedChannelId();
    }

    public static final /* synthetic */ WidgetChannelPickerBottomSheetViewModel access$getViewModel$p(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet) {
        return widgetChannelPickerBottomSheet.getViewModel();
    }

    private final void configureUI(WidgetChannelPickerBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetChannelPickerBottomSheetViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f15884b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.channelPickerAppFlipper");
            appViewFlipper.setDisplayedChild(0);
            SearchInputView searchInputView = getBinding().f15886d;
            Intrinsics3.checkNotNullExpressionValue(searchInputView, "binding.channelPickerSearchInput");
            searchInputView.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetChannelPickerBottomSheetViewModel.ViewState.Loaded) {
            SearchInputView searchInputView2 = getBinding().f15886d;
            Intrinsics3.checkNotNullExpressionValue(searchInputView2, "binding.channelPickerSearchInput");
            searchInputView2.setVisibility(0);
            AppViewFlipper appViewFlipper2 = getBinding().f15884b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.channelPickerAppFlipper");
            appViewFlipper2.setDisplayedChild(1);
            WidgetChannelPickerAdapter3 widgetChannelPickerAdapter3 = this.adapter;
            if (widgetChannelPickerAdapter3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            widgetChannelPickerAdapter3.setItems(((WidgetChannelPickerBottomSheetViewModel.ViewState.Loaded) viewState).getAdapterItems());
        }
    }

    private final WidgetChannelPickerSheetBinding getBinding() {
        return (WidgetChannelPickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final boolean getHideAnnouncementChannels() {
        return ((Boolean) this.hideAnnouncementChannels.getValue()).booleanValue();
    }

    private final long getSelectedChannelId() {
        return ((Number) this.selectedChannelId.getValue()).longValue();
    }

    private final WidgetChannelPickerBottomSheetViewModel getViewModel() {
        return (WidgetChannelPickerBottomSheetViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCancel$default(WidgetChannelPickerBottomSheet widgetChannelPickerBottomSheet, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        widgetChannelPickerBottomSheet.setOnCancel(function0);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelPickerBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C73321(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_channel_picker_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.adapter = new WidgetChannelPickerAdapter3(this.itemClickListener, this, null, 4, null);
        RecyclerView recyclerView = getBinding().f15885c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.channelPickerRecycler");
        WidgetChannelPickerAdapter3 widgetChannelPickerAdapter3 = this.adapter;
        if (widgetChannelPickerAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(widgetChannelPickerAdapter3);
        getBinding().f15886d.m8553a(this, new C73331());
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }
}
