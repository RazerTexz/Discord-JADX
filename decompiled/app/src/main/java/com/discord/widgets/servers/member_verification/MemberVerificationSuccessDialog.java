package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetMemberVerificationSuccessBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel;
import d0.t.CollectionsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: MemberVerificationSuccessDialog.kt */
/* loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(MemberVerificationSuccessDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationSuccessBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: MemberVerificationSuccessDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue(long guildId) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String strT = outline.t("GUILD_JOIN_REQUEST_SUCCESS_", guildId);
            notices.requestToShow(new StoreNotices.Notice(strT, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new MemberVerificationSuccessDialog2(guildId, notices, strT), 150, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MemberVerificationSuccessDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$configureLoadedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), MemberVerificationSuccessDialog.access$getViewModel$p(MemberVerificationSuccessDialog.this).getGuildId(), 0L, null, null, 12, null);
            MemberVerificationSuccessDialog.access$getViewModel$p(MemberVerificationSuccessDialog.this).ackGuildJoinRequest();
        }
    }

    /* compiled from: MemberVerificationSuccessDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<MemberVerificationSuccessViewModel.ViewState, Unit> {
        public AnonymousClass1(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
            super(1, memberVerificationSuccessDialog, MemberVerificationSuccessDialog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/MemberVerificationSuccessViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationSuccessViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationSuccessViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            MemberVerificationSuccessDialog.access$configureUI((MemberVerificationSuccessDialog) this.receiver, viewState);
        }
    }

    public MemberVerificationSuccessDialog() {
        super(R.layout.widget_member_verification_success);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, MemberVerificationSuccessDialog3.INSTANCE, null, 2, null);
        MemberVerificationSuccessDialog4 memberVerificationSuccessDialog4 = new MemberVerificationSuccessDialog4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MemberVerificationSuccessViewModel.class), new MemberVerificationSuccessDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(memberVerificationSuccessDialog4));
    }

    public static final /* synthetic */ void access$configureUI(MemberVerificationSuccessDialog memberVerificationSuccessDialog, MemberVerificationSuccessViewModel.ViewState viewState) {
        memberVerificationSuccessDialog.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
        return memberVerificationSuccessDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ MemberVerificationSuccessViewModel access$getViewModel$p(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
        return memberVerificationSuccessDialog.getViewModel();
    }

    private final void configureLoadedUI(MemberVerificationSuccessViewModel.ViewState.Loaded viewState) {
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationGuildName");
        textView.setText(FormatUtils.k(this, R.string.lurker_mode_popout_success_header, new Object[]{viewState.getGuildName()}, null, 4));
        getBinding().f2494b.setOnClickListener(new AnonymousClass1());
    }

    private final void configureUI(MemberVerificationSuccessViewModel.ViewState viewState) {
        if (viewState instanceof MemberVerificationSuccessViewModel.ViewState.Loaded) {
            configureLoadedUI((MemberVerificationSuccessViewModel.ViewState.Loaded) viewState);
        } else {
            if (!(viewState instanceof MemberVerificationSuccessViewModel.ViewState.Acked)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
        }
    }

    private final WidgetMemberVerificationSuccessBinding getBinding() {
        return (WidgetMemberVerificationSuccessBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MemberVerificationSuccessViewModel getViewModel() {
        return (MemberVerificationSuccessViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<MemberVerificationSuccessViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), MemberVerificationSuccessDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
