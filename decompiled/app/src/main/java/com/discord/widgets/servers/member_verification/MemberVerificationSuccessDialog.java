package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetMemberVerificationSuccessBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(MemberVerificationSuccessDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationSuccessBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue(long guildId) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String strM877t = outline.m877t("GUILD_JOIN_REQUEST_SUCCESS_", guildId);
            notices.requestToShow(new StoreNotices.Notice(strM877t, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new MemberVerificationSuccessDialog2(guildId, notices, strM877t), 150, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$configureLoadedUI$1 */
    /* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
    public static final class ViewOnClickListenerC95521 implements View.OnClickListener {
        public ViewOnClickListenerC95521() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), MemberVerificationSuccessDialog.access$getViewModel$p(MemberVerificationSuccessDialog.this).getGuildId(), 0L, null, null, 12, null);
            MemberVerificationSuccessDialog.access$getViewModel$p(MemberVerificationSuccessDialog.this).ackGuildJoinRequest();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
    public static final /* synthetic */ class C95531 extends FunctionReferenceImpl implements Function1<MemberVerificationSuccessViewModel.ViewState, Unit> {
        public C95531(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
            super(1, memberVerificationSuccessDialog, MemberVerificationSuccessDialog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/MemberVerificationSuccessViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationSuccessViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationSuccessViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            MemberVerificationSuccessDialog.access$configureUI((MemberVerificationSuccessDialog) this.receiver, viewState);
        }
    }

    public MemberVerificationSuccessDialog() {
        super(C5419R.layout.widget_member_verification_success);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, MemberVerificationSuccessDialog3.INSTANCE, null, 2, null);
        MemberVerificationSuccessDialog4 memberVerificationSuccessDialog4 = new MemberVerificationSuccessDialog4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MemberVerificationSuccessViewModel.class), new C9551x5c97b9d7(appViewModelDelegates3), new AppViewModelDelegates5(memberVerificationSuccessDialog4));
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
        TextView textView = getBinding().f17264c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationGuildName");
        textView.setText(FormatUtils.m219k(this, C5419R.string.lurker_mode_popout_success_header, new Object[]{viewState.getGuildName()}, null, 4));
        getBinding().f17263b.setOnClickListener(new ViewOnClickListenerC95521());
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
        Observable<MemberVerificationSuccessViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), MemberVerificationSuccessDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95531(this), 62, (Object) null);
    }
}
