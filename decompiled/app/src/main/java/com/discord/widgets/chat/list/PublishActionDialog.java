package com.discord.widgets.chat.list;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.PublishMessageDialogBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.list.PublishActionDialogViewModel;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PublishActionDialog extends AppDialog {
    private static final String ARG_THEME_ID = "theme_id";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onSuccess;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(PublishActionDialog.class, "binding", "getBinding()Lcom/discord/databinding/PublishMessageDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, long j2, Function0 function0, Integer num, int i, Object obj) {
            companion.show(fragmentManager, j, j2, function0, (i & 16) != 0 ? null : num);
        }

        public final void show(FragmentManager fragmentManager, long messageId, long channelId, Function0<Unit> onSuccess, Integer dialogTheme) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            PublishActionDialog publishActionDialog = new PublishActionDialog();
            if (onSuccess != null) {
                PublishActionDialog.access$setOnSuccess$p(publishActionDialog, onSuccess);
            }
            Bundle bundleM832T = outline.m832T("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            bundleM832T.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            if (dialogTheme != null) {
                bundleM832T.putInt(PublishActionDialog.ARG_THEME_ID, dialogTheme.intValue());
            }
            publishActionDialog.setArguments(bundleM832T);
            publishActionDialog.show(fragmentManager, PublishActionDialog.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$1 */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final class C79411 extends Lambda implements Function0<Unit> {
        public C79411() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PublishActionDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$2 */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final class ViewOnClickListenerC79422 implements View.OnClickListener {
        public ViewOnClickListenerC79422() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PublishActionDialog.access$getViewModel$p(PublishActionDialog.this).publishMessage();
            Function0 function0Access$getOnSuccess$p = PublishActionDialog.access$getOnSuccess$p(PublishActionDialog.this);
            if (function0Access$getOnSuccess$p != null) {
                function0Access$getOnSuccess$p.invoke();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$3 */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final class ViewOnClickListenerC79433 implements View.OnClickListener {
        public ViewOnClickListenerC79433() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PublishActionDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final /* synthetic */ class C79441 extends FunctionReferenceImpl implements Function1<PublishActionDialogViewModel.ViewState, Unit> {
        public C79441(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "updateView", "updateView(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            PublishActionDialog.access$updateView((PublishActionDialog) this.receiver, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: PublishActionDialog.kt */
    public static final /* synthetic */ class C79452 extends FunctionReferenceImpl implements Function1<PublishActionDialogViewModel.Event, Unit> {
        public C79452(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            PublishActionDialog.access$handleEvent((PublishActionDialog) this.receiver, event);
        }
    }

    public PublishActionDialog() {
        super(C5419R.layout.publish_message_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, PublishActionDialog2.INSTANCE, null, 2, null);
        PublishActionDialog3 publishActionDialog3 = new PublishActionDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(PublishActionDialogViewModel.class), new PublishActionDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(publishActionDialog3));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ Function0 access$getOnSuccess$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.onSuccess;
    }

    public static final /* synthetic */ PublishActionDialogViewModel access$getViewModel$p(PublishActionDialog publishActionDialog) {
        return publishActionDialog.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(PublishActionDialog publishActionDialog, PublishActionDialogViewModel.Event event) {
        publishActionDialog.handleEvent(event);
    }

    public static final /* synthetic */ void access$setOnSuccess$p(PublishActionDialog publishActionDialog, Function0 function0) {
        publishActionDialog.onSuccess = function0;
    }

    public static final /* synthetic */ void access$updateView(PublishActionDialog publishActionDialog, PublishActionDialogViewModel.ViewState viewState) {
        publishActionDialog.updateView(viewState);
    }

    private final PublishMessageDialogBinding getBinding() {
        return (PublishMessageDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PublishActionDialogViewModel getViewModel() {
        return (PublishActionDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(PublishActionDialogViewModel.Event event) {
        if (event instanceof PublishActionDialogViewModel.Event.Success) {
            AppToast.m171i(this, C5419R.string.message_published, 0, 4);
        } else if (event instanceof PublishActionDialogViewModel.Event.Failure) {
            AppToast.m171i(this, C5419R.string.publish_followed_news_generic_body, 0, 4);
        }
        dismiss();
    }

    private final void renderHasFollowers(PublishActionDialogViewModel.ViewState.LoadedHasFollowers viewState) {
        TextView textView = getBinding().f15220b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.m222n(textView, C5419R.string.publish_followed_news_body_reach, new Object[]{String.valueOf(viewState.getFollowerStats().getGuildsFollowing())}, null, 4);
    }

    private final void renderLoading() {
        TextView textView = getBinding().f15220b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.m222n(textView, C5419R.string.loading, new Object[0], null, 4);
    }

    private final void renderNoFollowers() {
        TextView textView = getBinding().f15220b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.m222n(textView, C5419R.string.publish_followed_news_body, new Object[0], null, 4);
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2, Function0<Unit> function0, Integer num) {
        INSTANCE.show(fragmentManager, j, j2, function0, num);
    }

    private final void updateView(PublishActionDialogViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, PublishActionDialogViewModel.ViewState.Loading.INSTANCE)) {
            renderLoading();
        } else if (Intrinsics3.areEqual(viewState, PublishActionDialogViewModel.ViewState.LoadedNoFollowers.INSTANCE)) {
            renderNoFollowers();
        } else if (viewState instanceof PublishActionDialogViewModel.ViewState.LoadedHasFollowers) {
            renderHasFollowers((PublishActionDialogViewModel.ViewState.LoadedHasFollowers) viewState);
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Resources.Theme theme;
        Bundle arguments = getArguments();
        if (arguments != null) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context != null && (theme = context.getTheme()) != null) {
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, C5419R.attr.dialogTheme), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f15222d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        FormatUtils.m222n(textView, C5419R.string.news_channel_publish_bump, new Object[0], null, 4);
        LinearLayout linearLayout = getBinding().f15223e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility(0);
        TextView textView2 = getBinding().f15220b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noticeBodyText");
        textView2.setTextAlignment(2);
        TextView textView3 = getBinding().f15220b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.noticeBodyText");
        textView3.setMovementMethod(new WidgetNoticeDialog.ActionLinkMovementMethod(new C79411()));
        MaterialButton materialButton = getBinding().f15224f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        ViewExtensions.setTextAndVisibilityBy(materialButton, FormatUtils.m219k(this, C5419R.string.news_channel_publish, new Object[0], null, 4));
        getBinding().f15224f.setOnClickListener(new ViewOnClickListenerC79422());
        MaterialButton materialButton2 = getBinding().f15221c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, FormatUtils.m219k(this, C5419R.string.cancel, new Object[0], null, 4));
        getBinding().f15221c.setOnClickListener(new ViewOnClickListenerC79433());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), PublishActionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C79441(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), PublishActionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C79452(this), 62, (Object) null);
    }
}
