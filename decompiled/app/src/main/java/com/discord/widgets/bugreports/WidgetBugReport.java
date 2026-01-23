package com.discord.widgets.bugreports;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.bugreport.BugReportConfig2;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetBugReportBinding;
import com.discord.screenshot_detection.ScreenshotDetector;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.bugreports.BugReportViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.io.InputStream;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p062y.SelectorBottomSheet;
import p007b.p008a.p062y.SelectorBottomSheet2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p591y.IOStreams;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport extends AppFragment {
    public static final String INTENT_EXTRA_SCREENSHOT_FILENAME = "extra_screenshot_filename";
    public static final String INTENT_EXTRA_SCREENSHOT_URI = "extra_screenshot_uri";
    public static final int VIEW_INDEX_FEATURE_AREA = 2;
    public static final int VIEW_INDEX_REPORT = 0;
    public static final int VIEW_INDEX_STATUS = 1;
    private boolean backHandlerAdded;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BugReportFeatureAdapter featuresAdapter;
    private final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: items$delegate, reason: from kotlin metadata */
    private final Lazy items;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetBugReport.class, "binding", "getBinding()Lcom/discord/databinding/WidgetBugReportBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<Priority> priorityLevels = Collections2.listOf((Object[]) new Priority[]{new Priority(C5419R.string.bug_report_priority_critical_title, C5419R.string.bug_report_priority_critical_description, 801497159479722084L), new Priority(C5419R.string.bug_report_priority_high_title, C5419R.string.bug_report_priority_high_description, 410336837563973632L), new Priority(C5419R.string.bug_report_priority_low_title, C5419R.string.bug_report_priority_low_description, 841420679643529296L), new Priority(C5419R.string.bug_report_priority_very_low_title, C5419R.string.bug_report_priority_very_low_description, 827645852352512021L)});

    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<Priority> getPriorityLevels() {
            return WidgetBugReport.access$getPriorityLevels$cp();
        }

        public final void launch(Context context, ScreenshotDetector.Screenshot screenshot) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(screenshot, "screenshot");
            Intent intent = new Intent();
            intent.putExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_URI, screenshot.androidx.core.app.NotificationCompat.MessagingStyle.Message.KEY_DATA_URI java.lang.String.toString());
            intent.putExtra(WidgetBugReport.INTENT_EXTRA_SCREENSHOT_FILENAME, screenshot.filename);
            AppScreen2.m156d(context, WidgetBugReport.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class ViewOnClickListenerC72891 implements View.OnClickListener {
        public ViewOnClickListenerC72891() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).useScreenshot(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72902 extends Lambda implements Function1<Editable, Unit> {
        public C72902() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).updateReportName(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72913 extends Lambda implements Function1<Editable, Unit> {
        public C72913() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).updateReportDescription(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72924 extends Lambda implements Function1<String, Unit> {
        public C72924() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).m11400filterFeatures(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class ViewOnClickListenerC72935 implements View.OnClickListener {
        public ViewOnClickListenerC72935() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).useScreenshot(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$6 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class ViewOnClickListenerC72946 implements View.OnClickListener {

        /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$6$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetBugReport.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f27425a;
            }

            public final void invoke(int i) {
                WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).updatePriority(i);
            }
        }

        public ViewOnClickListenerC72946() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppFragment.hideKeyboard$default(WidgetBugReport.this, null, 1, null);
            SelectorBottomSheet.Companion companion = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetBugReport.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetBugReport.this.getString(C5419R.string.bug_report_priority);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.bug_report_priority)");
            SelectorBottomSheet.Companion.m378b(companion, childFragmentManager, string, WidgetBugReport.this.getItems(), false, new AnonymousClass1(), 8);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$7 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class ViewOnClickListenerC72957 implements View.OnClickListener {
        public ViewOnClickListenerC72957() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBugReport.access$getViewModel$p(WidgetBugReport.this).showFeatureAreas();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBound$8 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class ViewOnClickListenerC72968 implements View.OnClickListener {
        public ViewOnClickListenerC72968() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetBugReport.access$submit(WidgetBugReport.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72971 extends Lambda implements Function1<BugReportViewModel.ViewState, Unit> {
        public C72971() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BugReportViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BugReportViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetBugReport.this.updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final /* synthetic */ class C72982 extends FunctionReferenceImpl implements Function1<BugReportViewModel.Event, Unit> {
        public C72982(WidgetBugReport widgetBugReport) {
            super(1, widgetBugReport, WidgetBugReport.class, "handleEvent", "handleEvent(Lcom/discord/widgets/bugreports/BugReportViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BugReportViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BugReportViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetBugReport.access$handleEvent((WidgetBugReport) this.receiver, event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$updateView$4 */
    /* JADX INFO: compiled from: WidgetBugReport.kt */
    public static final class C72994<R> implements Func0<Boolean> {

        /* JADX INFO: renamed from: com.discord.widgets.bugreports.WidgetBugReport$updateView$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetBugReport.kt */
        public static final class AnonymousClass1<R> implements Func0<Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }

            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                return Boolean.FALSE;
            }
        }

        public C72994() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetBugReport.access$setBackHandlerAdded$p(WidgetBugReport.this, false);
            BugReportViewModel.showReport$default(WidgetBugReport.access$getViewModel$p(WidgetBugReport.this), null, 1, null);
            AppFragment.setOnBackPressed$default(WidgetBugReport.this, AnonymousClass1.INSTANCE, 0, 2, null);
            return Boolean.TRUE;
        }
    }

    public WidgetBugReport() {
        super(C5419R.layout.widget_bug_report);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetBugReport$binding$2.INSTANCE, null, 2, null);
        WidgetBugReport$viewModel$2 widgetBugReport$viewModel$2 = new WidgetBugReport$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(BugReportViewModel.class), new WidgetBugReport$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetBugReport$viewModel$2));
        this.featuresAdapter = new BugReportFeatureAdapter(new WidgetBugReport$featuresAdapter$1(this));
        this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
        this.items = LazyJVM.lazy(new WidgetBugReport$items$2(this));
        this.validationManager = LazyJVM.lazy(new WidgetBugReport$validationManager$2(this));
    }

    public static final /* synthetic */ boolean access$getBackHandlerAdded$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.backHandlerAdded;
    }

    public static final /* synthetic */ WidgetBugReportBinding access$getBinding$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.getBinding();
    }

    public static final /* synthetic */ List access$getPriorityLevels$cp() {
        return priorityLevels;
    }

    public static final /* synthetic */ BugReportViewModel access$getViewModel$p(WidgetBugReport widgetBugReport) {
        return widgetBugReport.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetBugReport widgetBugReport, BugReportViewModel.Event event) {
        widgetBugReport.handleEvent(event);
    }

    public static final /* synthetic */ void access$setBackHandlerAdded$p(WidgetBugReport widgetBugReport, boolean z2) {
        widgetBugReport.backHandlerAdded = z2;
    }

    public static final /* synthetic */ void access$submit(WidgetBugReport widgetBugReport) {
        widgetBugReport.submit();
    }

    private final WidgetBugReportBinding getBinding() {
        return (WidgetBugReportBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final BugReportViewModel getViewModel() {
        return (BugReportViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(BugReportViewModel.Event event) {
        AppActivity appActivity;
        if (!Intrinsics3.areEqual(event, BugReportViewModel.Event.CloseReport.INSTANCE) || (appActivity = getAppActivity()) == null) {
            return;
        }
        appActivity.finish();
    }

    private final void submit() {
        InputStream inputStreamOpenInputStream;
        byte[] bytes;
        RequestBody requestBodyM10986d = null;
        MediaType mediaTypeM10967a = null;
        requestBodyM10986d = null;
        requestBodyM10986d = null;
        requestBodyM10986d = null;
        if (ValidationManager.validate$default(getValidationManager(), false, 1, null)) {
            Uri screenshotUri = getViewModel().getScreenshotUri();
            if (getViewModel().getUseScreenshot() && screenshotUri.getPath() != null && (inputStreamOpenInputStream = requireContext().getContentResolver().openInputStream(screenshotUri)) != null && (bytes = IOStreams.readBytes(inputStreamOpenInputStream)) != null) {
                RequestBody.Companion companion = RequestBody.INSTANCE;
                String type = requireContext().getContentResolver().getType(screenshotUri);
                if (type != null) {
                    MediaType.Companion companion2 = MediaType.INSTANCE;
                    mediaTypeM10967a = MediaType.Companion.m10967a(type);
                }
                requestBodyM10986d = RequestBody.Companion.m10986d(companion, bytes, mediaTypeM10967a, 0, 0, 6);
            }
            getViewModel().sendReport(requestBodyM10986d);
        }
    }

    public final BugReportFeatureAdapter getFeaturesAdapter() {
        return this.featuresAdapter;
    }

    public final List<SelectorBottomSheet2> getItems() {
        return (List) this.items.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().prefetchStickers(requireContext());
    }

    public final void onFeatureClickListener(BugReportConfig2 feature) {
        Intrinsics3.checkNotNullParameter(feature, "feature");
        getViewModel().selectFeatureArea(feature);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(C5419R.string.submit_bug);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Uri uri = Uri.parse(getMostRecentIntent().getStringExtra(INTENT_EXTRA_SCREENSHOT_URI));
        RecyclerView recyclerView = getBinding().f15737f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.bugReportFeatureRecycler");
        recyclerView.setAdapter(this.featuresAdapter);
        getBinding().f15743l.setImageURI(uri);
        getBinding().f15733b.setOnClickListener(new ViewOnClickListenerC72891());
        TextInputLayout textInputLayout = getBinding().f15739h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bugReportName");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C72902());
        TextInputLayout textInputLayout2 = getBinding().f15734c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C72913());
        getBinding().f15738g.m8553a(this, new C72924());
        getBinding().f15748q.setOnClickListener(new ViewOnClickListenerC72935());
        getBinding().f15751t.setOnClickListener(new ViewOnClickListenerC72946());
        getBinding().f15750s.setOnClickListener(new ViewOnClickListenerC72957());
        getBinding().f15746o.setOnClickListener(new ViewOnClickListenerC72968());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetBugReport.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C72971(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetBugReport.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C72982(this), 62, (Object) null);
    }

    public final void updateView(BugReportViewModel.ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (!(viewState instanceof BugReportViewModel.ViewState.Report)) {
            if (viewState instanceof BugReportViewModel.ViewState.Sending) {
                AppViewFlipper appViewFlipper = getBinding().f15747p;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.bugReportSwitchFlipper");
                appViewFlipper.setDisplayedChild(1);
                StickerView.m8613e(getBinding().f15744m, getViewModel().getSendingSticker(), null, 2);
                getBinding().f15745n.setText(C5419R.string.bug_report_status_sending);
                return;
            }
            if (viewState instanceof BugReportViewModel.ViewState.Success) {
                AppViewFlipper appViewFlipper2 = getBinding().f15747p;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.bugReportSwitchFlipper");
                appViewFlipper2.setDisplayedChild(1);
                StickerView.m8613e(getBinding().f15744m, getViewModel().getSuccessSticker(), null, 2);
                getBinding().f15745n.setText(C5419R.string.bug_report_status_sent);
                return;
            }
            if (viewState instanceof BugReportViewModel.ViewState.SelectFeature) {
                setActionBarTitle(C5419R.string.bug_report_select_feature_area);
                setActionBarSubtitle(C5419R.string.submit_bug);
                AppViewFlipper appViewFlipper3 = getBinding().f15747p;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.bugReportSwitchFlipper");
                appViewFlipper3.setDisplayedChild(2);
                ProgressBar progressBar = getBinding().f15736e;
                Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.bugReportFeatureLoader");
                BugReportViewModel.ViewState.SelectFeature selectFeature = (BugReportViewModel.ViewState.SelectFeature) viewState;
                progressBar.setVisibility(selectFeature.getLoadingFeatures() ? 0 : 8);
                RecyclerView recyclerView = getBinding().f15737f;
                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.bugReportFeatureRecycler");
                recyclerView.setVisibility(selectFeature.getLoadingFeatures() ^ true ? 0 : 8);
                View editText = getBinding().f15738g.getEditText();
                if (!(editText instanceof TextInputLayout)) {
                    editText = null;
                }
                TextInputLayout textInputLayout = (TextInputLayout) editText;
                if (textInputLayout != null) {
                    EditText editText2 = textInputLayout.getEditText();
                    String strValueOf = String.valueOf(editText2 != null ? editText2.getText() : null);
                    String query = selectFeature.getQuery();
                    if (query == null) {
                        query = "";
                    }
                    if (!Intrinsics3.areEqual(strValueOf, query)) {
                        SearchInputView searchInputView = getBinding().f15738g;
                        String query2 = selectFeature.getQuery();
                        searchInputView.setText(query2 != null ? query2 : "");
                    }
                }
                this.featuresAdapter.setData(selectFeature.getFeatures());
                if (this.backHandlerAdded) {
                    return;
                }
                this.backHandlerAdded = true;
                AppFragment.setOnBackPressed$default(this, new C72994(), 0, 2, null);
                return;
            }
            return;
        }
        setActionBarTitle(C5419R.string.submit_bug);
        setActionBarSubtitle("");
        AppViewFlipper appViewFlipper4 = getBinding().f15747p;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.bugReportSwitchFlipper");
        appViewFlipper4.setDisplayedChild(0);
        MaterialTextView materialTextView = getBinding().f15749r;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.submitReportError");
        BugReportViewModel.ViewState.Report report = (BugReportViewModel.ViewState.Report) viewState;
        materialTextView.setVisibility(report.getError() != null ? 0 : 8);
        if (report.getError() != null) {
            MaterialTextView materialTextView2 = getBinding().f15749r;
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.submitReportError");
            Error.Response response = report.getError().getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "viewState.error.response");
            materialTextView2.setText(response.getMessage());
        }
        TextInputLayout textInputLayout2 = getBinding().f15739h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportName");
        ViewExtensions.setTextIfDifferent(textInputLayout2, report.getReportName());
        TextInputLayout textInputLayout3 = getBinding().f15734c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.bugReportDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout3, report.getReportDescription());
        AppCompatImageView appCompatImageView = getBinding().f15743l;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.bugReportScreenshot");
        appCompatImageView.setVisibility(report.getUseScreenshot() ^ true ? 4 : 0);
        AppCompatImageView appCompatImageView2 = getBinding().f15733b;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.bugReportClearScreenshot");
        appCompatImageView2.setVisibility(report.getUseScreenshot() ? 0 : 8);
        MaterialTextView materialTextView3 = getBinding().f15740i;
        Intrinsics3.checkNotNullExpressionValue(materialTextView3, "binding.bugReportNoScreenshotLabel");
        materialTextView3.setVisibility(report.getUseScreenshot() ^ true ? 0 : 8);
        MaterialButton materialButton = getBinding().f15748q;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.bugReportUndoScreenshotRemove");
        materialButton.setVisibility(report.getUseScreenshot() ^ true ? 0 : 8);
        BugReportConfig2 feature = report.getFeature();
        if (feature != null) {
            TextInputLayout textInputLayout4 = getBinding().f15735d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.bugReportFeatureArea");
            ViewExtensions.setTextIfDifferent(textInputLayout4, feature.getName());
        }
        Integer priority = report.getPriority();
        if (priority != null) {
            int iIntValue = priority.intValue();
            TextInputLayout textInputLayout5 = getBinding().f15741j;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.bugReportPriority");
            ViewExtensions.setText(textInputLayout5, priorityLevels.get(iIntValue).getTitle());
            SimpleDraweeView simpleDraweeView = getBinding().f15742k;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.bugReportPriorityIcon");
            MGImages.setImage$default(simpleDraweeView, getItems().get(iIntValue).m383d(), C5419R.dimen.emoji_size, C5419R.dimen.emoji_size, true, null, this.imagesChangeDetector, 32, null);
        }
    }
}
