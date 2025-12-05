package com.discord.widgets.status;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadStatusBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.status.WidgetThreadStatusViewModel;
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
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetThreadStatus.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetThreadStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadStatusBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetThreadStatus.kt */
    public static abstract class Event {

        /* compiled from: WidgetThreadStatus.kt */
        public static final /* data */ class Error extends Event {
            private final int code;

            public Error(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Error copy$default(Error error, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.code;
                }
                return error.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Error copy(int code) {
                return new Error(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && this.code == ((Error) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return outline.m814B(outline.m833U("Error(code="), this.code, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadStatus.kt */
    /* renamed from: com.discord.widgets.status.WidgetThreadStatus$onViewBoundOrOnResume$1 */
    public static final class C101111 extends Lambda implements Function1<WidgetThreadStatusViewModel.ViewState, Unit> {
        public C101111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadStatusViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadStatus.access$updateView(WidgetThreadStatus.this, viewState);
        }
    }

    /* compiled from: WidgetThreadStatus.kt */
    /* renamed from: com.discord.widgets.status.WidgetThreadStatus$onViewBoundOrOnResume$2 */
    public static final /* synthetic */ class C101122 extends FunctionReferenceImpl implements Function1<Event, Unit> {
        public C101122(WidgetThreadStatus widgetThreadStatus) {
            super(1, widgetThreadStatus, WidgetThreadStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/status/WidgetThreadStatus$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetThreadStatus.access$handleEvent((WidgetThreadStatus) this.receiver, event);
        }
    }

    /* compiled from: WidgetThreadStatus.kt */
    /* renamed from: com.discord.widgets.status.WidgetThreadStatus$updateView$1 */
    public static final class ViewOnClickListenerC101131 implements View.OnClickListener {
        public ViewOnClickListenerC101131() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadStatus.access$getViewModel$p(WidgetThreadStatus.this).onUnarchiveTapped();
        }
    }

    /* compiled from: WidgetThreadStatus.kt */
    /* renamed from: com.discord.widgets.status.WidgetThreadStatus$updateView$2 */
    public static final class ViewOnClickListenerC101142 implements View.OnClickListener {
        public ViewOnClickListenerC101142() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadStatus.access$getViewModel$p(WidgetThreadStatus.this).onJoinTapped();
        }
    }

    public WidgetThreadStatus() {
        super(C5419R.layout.widget_thread_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadStatus2.INSTANCE, null, 2, null);
        WidgetThreadStatus3 widgetThreadStatus3 = WidgetThreadStatus3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadStatusViewModel.class), new WidgetThreadStatus$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetThreadStatus3));
    }

    public static final /* synthetic */ WidgetThreadStatusViewModel access$getViewModel$p(WidgetThreadStatus widgetThreadStatus) {
        return widgetThreadStatus.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetThreadStatus widgetThreadStatus, Event event) {
        widgetThreadStatus.handleEvent(event);
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadStatus widgetThreadStatus, WidgetThreadStatusViewModel.ViewState viewState) {
        widgetThreadStatus.updateView(viewState);
    }

    private final WidgetThreadStatusBinding getBinding() {
        return (WidgetThreadStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadStatusViewModel getViewModel() {
        return (WidgetThreadStatusViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(Event event) {
        if (event instanceof Event.Error) {
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(((Event.Error) event).getCode());
            AppToast.m171i(this, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : C5419R.string.network_error_bad_request, 0, 4);
        }
    }

    @MainThread
    private final void updateView(WidgetThreadStatusViewModel.ViewState viewState) {
        getBinding().f18291c.setIsLoading(viewState.isLoading());
        WidgetThreadStatusViewModel.Status threadStatus = viewState.getThreadStatus();
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Hide) {
            ConstraintLayout constraintLayout = getBinding().f18290b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.threadStatus");
            constraintLayout.setVisibility(8);
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Archived) {
            ConstraintLayout constraintLayout2 = getBinding().f18290b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.threadStatus");
            constraintLayout2.setVisibility(0);
            LoadingButton loadingButton = getBinding().f18291c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.threadStatusButton");
            WidgetThreadStatusViewModel.Status.Archived archived = (WidgetThreadStatusViewModel.Status.Archived) threadStatus;
            loadingButton.setVisibility(archived.getCanArchive() ? 0 : 8);
            LinkifiedTextView linkifiedTextView = getBinding().f18292d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.threadStatusText");
            linkifiedTextView.setText(archived.isLocked() ? getResources().getString(C5419R.string.thread_header_notice_locked) : getResources().getString(C5419R.string.thread_header_notice_archived));
            getBinding().f18291c.setText(getResources().getString(C5419R.string.unarchive));
            LoadingButton loadingButton2 = getBinding().f18291c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.threadStatusButton");
            loadingButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundAccent)));
            getBinding().f18291c.setOnClickListener(new ViewOnClickListenerC101131());
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Unjoined) {
            ConstraintLayout constraintLayout3 = getBinding().f18290b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.threadStatus");
            constraintLayout3.setVisibility(0);
            LoadingButton loadingButton3 = getBinding().f18291c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton3, "binding.threadStatusButton");
            loadingButton3.setVisibility(0);
            LinkifiedTextView linkifiedTextView2 = getBinding().f18292d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.threadStatusText");
            linkifiedTextView2.setText(getResources().getString(C5419R.string.thread_header_notice_join));
            getBinding().f18291c.setText(getResources().getString(C5419R.string.join));
            LoadingButton loadingButton4 = getBinding().f18291c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton4, "binding.threadStatusButton");
            loadingButton4.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand_500)));
            getBinding().f18291c.setOnClickListener(new ViewOnClickListenerC101142());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101111(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetThreadStatus.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101122(this), 62, (Object) null);
    }
}
