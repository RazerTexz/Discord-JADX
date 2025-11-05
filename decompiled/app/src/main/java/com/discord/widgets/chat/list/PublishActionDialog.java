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
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.PublishMessageDialogBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.list.PublishActionDialogViewModel;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: PublishActionDialog.kt */
/* loaded from: classes2.dex */
public final class PublishActionDialog extends AppDialog {
    private static final String ARG_THEME_ID = "theme_id";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onSuccess;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(PublishActionDialog.class, "binding", "getBinding()Lcom/discord/databinding/PublishMessageDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: PublishActionDialog.kt */
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
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_MESSAGE_ID", messageId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            if (dialogTheme != null) {
                bundleT.putInt(PublishActionDialog.ARG_THEME_ID, dialogTheme.intValue());
            }
            publishActionDialog.setArguments(bundleT);
            publishActionDialog.show(fragmentManager, PublishActionDialog.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PublishActionDialog.kt */
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PublishActionDialog.this.dismiss();
        }
    }

    /* compiled from: PublishActionDialog.kt */
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
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

    /* compiled from: PublishActionDialog.kt */
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PublishActionDialog.this.dismiss();
        }
    }

    /* compiled from: PublishActionDialog.kt */
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<PublishActionDialogViewModel.ViewState, Unit> {
        public AnonymousClass1(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "updateView", "updateView(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            PublishActionDialog.access$updateView((PublishActionDialog) this.receiver, viewState);
        }
    }

    /* compiled from: PublishActionDialog.kt */
    /* renamed from: com.discord.widgets.chat.list.PublishActionDialog$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<PublishActionDialogViewModel.Event, Unit> {
        public AnonymousClass2(PublishActionDialog publishActionDialog) {
            super(1, publishActionDialog, PublishActionDialog.class, "handleEvent", "handleEvent(Lcom/discord/widgets/chat/list/PublishActionDialogViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PublishActionDialogViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PublishActionDialogViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            PublishActionDialog.access$handleEvent((PublishActionDialog) this.receiver, event);
        }
    }

    public PublishActionDialog() {
        super(R.layout.publish_message_dialog);
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
            AppToast.i(this, R.string.message_published, 0, 4);
        } else if (event instanceof PublishActionDialogViewModel.Event.Failure) {
            AppToast.i(this, R.string.publish_followed_news_generic_body, 0, 4);
        }
        dismiss();
    }

    private final void renderHasFollowers(PublishActionDialogViewModel.ViewState.LoadedHasFollowers viewState) {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.n(textView, R.string.publish_followed_news_body_reach, new Object[]{String.valueOf(viewState.getFollowerStats().getGuildsFollowing())}, null, 4);
    }

    private final void renderLoading() {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.n(textView, R.string.loading, new Object[0], null, 4);
    }

    private final void renderNoFollowers() {
        TextView textView = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeBodyText");
        FormatUtils.n(textView, R.string.publish_followed_news_body, new Object[0], null, 4);
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
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, R.attr.dialogTheme), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        FormatUtils.n(textView, R.string.news_channel_publish_bump, new Object[0], null, 4);
        LinearLayout linearLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility(0);
        TextView textView2 = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noticeBodyText");
        textView2.setTextAlignment(2);
        TextView textView3 = getBinding().f2137b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.noticeBodyText");
        textView3.setMovementMethod(new WidgetNoticeDialog.ActionLinkMovementMethod(new AnonymousClass1()));
        MaterialButton materialButton = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        ViewExtensions.setTextAndVisibilityBy(materialButton, FormatUtils.k(this, R.string.news_channel_publish, new Object[0], null, 4));
        getBinding().f.setOnClickListener(new AnonymousClass2());
        MaterialButton materialButton2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, FormatUtils.k(this, R.string.cancel, new Object[0], null, 4));
        getBinding().c.setOnClickListener(new AnonymousClass3());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), PublishActionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), PublishActionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
