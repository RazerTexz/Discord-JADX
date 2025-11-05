package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetMemberVerificationPendingDialogBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel;
import com.google.android.material.button.MaterialButton;
import d0.t.m;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: MemberVerificationPendingDialog.kt */
/* loaded from: classes2.dex */
public final class MemberVerificationPendingDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(MemberVerificationPendingDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationPendingDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_DIALOG_STATE = "INTENT_EXTRA_DIALOG_STATE";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: MemberVerificationPendingDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void enqueue$default(Companion companion, long j, MemberVerificationPendingViewModel.DialogState dialogState, int i, Object obj) {
            if ((i & 2) != 0) {
                dialogState = null;
            }
            companion.enqueue(j, dialogState);
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, MemberVerificationPendingViewModel.DialogState dialogState, int i, Object obj) {
            if ((i & 4) != 0) {
                dialogState = null;
            }
            companion.show(fragmentManager, j, dialogState);
        }

        public final void enqueue(long guildId, MemberVerificationPendingViewModel.DialogState dialogState) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String strT = a.t("MEMBERVERIFICATION-", guildId);
            notices.requestToShow(new StoreNotices.Notice(strT, null, 0L, 0, false, m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new MemberVerificationPendingDialog$Companion$enqueue$memberVerificationPendingDialogNotice$1(guildId, dialogState, notices, strT), 150, null));
        }

        public final void show(FragmentManager supportFragmentManager, long guildId, MemberVerificationPendingViewModel.DialogState dialogState) {
            d0.z.d.m.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
            MemberVerificationPendingDialog memberVerificationPendingDialog = new MemberVerificationPendingDialog();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            bundle.putSerializable(MemberVerificationPendingDialog.INTENT_EXTRA_DIALOG_STATE, dialogState);
            memberVerificationPendingDialog.setArguments(bundle);
            memberVerificationPendingDialog.show(supportFragmentManager, MemberVerificationPendingDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            MemberVerificationPendingViewModel.DialogState.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            MemberVerificationPendingViewModel.DialogState dialogState = MemberVerificationPendingViewModel.DialogState.CANCEL;
            iArr[dialogState.ordinal()] = 1;
            MemberVerificationPendingViewModel.DialogState dialogState2 = MemberVerificationPendingViewModel.DialogState.LEAVE;
            iArr[dialogState2.ordinal()] = 2;
            MemberVerificationPendingViewModel.DialogState.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MemberVerificationPendingViewModel.DialogState.PENDING.ordinal()] = 1;
            iArr2[dialogState.ordinal()] = 2;
            iArr2[MemberVerificationPendingViewModel.DialogState.REJECTED.ordinal()] = 3;
            iArr2[dialogState2.ordinal()] = 4;
            iArr2[MemberVerificationPendingViewModel.DialogState.UPGRADE.ordinal()] = 5;
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = MemberVerificationPendingDialog.this.requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UriHandler.directToPlayStore$default(contextRequireContext, null, null, 6, null);
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$12, reason: invalid class name */
    public static final class AnonymousClass12 implements View.OnClickListener {
        public AnonymousClass12() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).updateDialogState(MemberVerificationPendingViewModel.DialogState.CANCEL);
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).updateDialogState(MemberVerificationPendingViewModel.DialogState.LEAVE);
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).resetGuildJoinRequest();
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).resetGuildJoinRequest();
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public final /* synthetic */ MemberVerificationPendingViewModel.ViewState.Loaded $viewState;

        public AnonymousClass9(MemberVerificationPendingViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.isPreviewEnabled()) {
                MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).deleteGuildJoinRequest();
            } else {
                MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).leaveGuild();
            }
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<MemberVerificationPendingViewModel.ViewState, Unit> {
        public AnonymousClass1(MemberVerificationPendingDialog memberVerificationPendingDialog) {
            super(1, memberVerificationPendingDialog, MemberVerificationPendingDialog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationPendingViewModel.ViewState viewState) {
            d0.z.d.m.checkNotNullParameter(viewState, "p1");
            MemberVerificationPendingDialog.access$configureUI((MemberVerificationPendingDialog) this.receiver, viewState);
        }
    }

    /* compiled from: MemberVerificationPendingDialog.kt */
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<MemberVerificationPendingViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationPendingViewModel.Event event) {
            d0.z.d.m.checkNotNullParameter(event, "event");
            if (!(event instanceof MemberVerificationPendingViewModel.Event.Success) && (event instanceof MemberVerificationPendingViewModel.Event.Error)) {
                b.a.d.m.i(MemberVerificationPendingDialog.this, R.string.guild_settings_public_update_failed, 0, 4);
            }
        }
    }

    public MemberVerificationPendingDialog() {
        super(R.layout.widget_member_verification_pending_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, MemberVerificationPendingDialog$binding$2.INSTANCE, null, 2, null);
        MemberVerificationPendingDialog$viewModel$2 memberVerificationPendingDialog$viewModel$2 = new MemberVerificationPendingDialog$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(MemberVerificationPendingViewModel.class), new MemberVerificationPendingDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(memberVerificationPendingDialog$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(MemberVerificationPendingDialog memberVerificationPendingDialog, MemberVerificationPendingViewModel.ViewState viewState) {
        memberVerificationPendingDialog.configureUI(viewState);
    }

    public static final /* synthetic */ MemberVerificationPendingViewModel access$getViewModel$p(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        return memberVerificationPendingDialog.getViewModel();
    }

    private final void configureLoadedUI(MemberVerificationPendingViewModel.ViewState.Loaded viewState) {
        ImageView imageView = getBinding().f2492b;
        d0.z.d.m.checkNotNullExpressionValue(imageView, "binding.memberVerificationPendingImg");
        imageView.setVisibility(viewState.getShowPendingImage() ? 0 : 8);
        TextView textView = getBinding().e;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.memberVerificationTertiaryBtn");
        textView.setVisibility(viewState.getShowTertiaryButton() ? 0 : 8);
        int iOrdinal = viewState.getDialogState().ordinal();
        int color = (iOrdinal == 2 || iOrdinal == 4) ? ColorCompat.getColor(getContext(), R.color.status_red_500) : ColorCompat.getThemedColor(getContext(), R.attr.color_brand_500);
        MaterialButton materialButton = getBinding().c;
        d0.z.d.m.checkNotNullExpressionValue(materialButton, "binding.memberVerificationPrimaryBtn");
        materialButton.setBackgroundTintList(ColorStateList.valueOf(color));
        int iOrdinal2 = viewState.getDialogState().ordinal();
        if (iOrdinal2 == 0) {
            getBinding().f2492b.setImageResource(R.drawable.ic_community_update);
            TextView textView2 = getBinding().g;
            d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.pendingDialogTitle");
            textView2.setText(getString(R.string.member_verification_warning_update_modal_title));
            TextView textView3 = getBinding().f;
            d0.z.d.m.checkNotNullExpressionValue(textView3, "binding.pendingDialogDesc");
            textView3.setText(getString(R.string.member_verification_warning_update_modal_desc));
            MaterialButton materialButton2 = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(materialButton2, "binding.memberVerificationPrimaryBtn");
            materialButton2.setText(getString(R.string.member_verification_warning_update));
            MaterialButton materialButton3 = getBinding().d;
            d0.z.d.m.checkNotNullExpressionValue(materialButton3, "binding.memberVerificationSecondaryBtn");
            materialButton3.setText(getString(R.string.cancel));
            getBinding().c.setOnClickListener(new AnonymousClass11());
            getBinding().d.setOnClickListener(new AnonymousClass12());
            return;
        }
        if (iOrdinal2 == 1) {
            getBinding().f2492b.setImageResource(R.drawable.ic_member_verification_pending);
            TextView textView4 = getBinding().g;
            d0.z.d.m.checkNotNullExpressionValue(textView4, "binding.pendingDialogTitle");
            textView4.setText(getString(R.string.member_verification_pending_application_modal_title));
            TextView textView5 = getBinding().f;
            d0.z.d.m.checkNotNullExpressionValue(textView5, "binding.pendingDialogDesc");
            textView5.setText(getString(R.string.member_verification_pending_application_modal_desc));
            MaterialButton materialButton4 = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(materialButton4, "binding.memberVerificationPrimaryBtn");
            materialButton4.setText(getString(R.string.got_it));
            getBinding().c.setOnClickListener(new AnonymousClass1());
            if (viewState.isPreviewEnabled()) {
                MaterialButton materialButton5 = getBinding().d;
                d0.z.d.m.checkNotNullExpressionValue(materialButton5, "binding.memberVerificationSecondaryBtn");
                materialButton5.setVisibility(8);
                TextView textView6 = getBinding().e;
                d0.z.d.m.checkNotNullExpressionValue(textView6, "binding.memberVerificationTertiaryBtn");
                textView6.setVisibility(8);
                return;
            }
            MaterialButton materialButton6 = getBinding().d;
            d0.z.d.m.checkNotNullExpressionValue(materialButton6, "binding.memberVerificationSecondaryBtn");
            materialButton6.setVisibility(0);
            MaterialButton materialButton7 = getBinding().d;
            d0.z.d.m.checkNotNullExpressionValue(materialButton7, "binding.memberVerificationSecondaryBtn");
            materialButton7.setText(getString(R.string.member_verification_cancel_application));
            getBinding().d.setOnClickListener(new AnonymousClass2());
            TextView textView7 = getBinding().e;
            d0.z.d.m.checkNotNullExpressionValue(textView7, "binding.memberVerificationTertiaryBtn");
            textView7.setVisibility(0);
            TextView textView8 = getBinding().e;
            d0.z.d.m.checkNotNullExpressionValue(textView8, "binding.memberVerificationTertiaryBtn");
            textView8.setText(getString(R.string.leave_server));
            getBinding().e.setOnClickListener(new AnonymousClass3());
            return;
        }
        if (iOrdinal2 == 2) {
            TextView textView9 = getBinding().g;
            d0.z.d.m.checkNotNullExpressionValue(textView9, "binding.pendingDialogTitle");
            textView9.setText(getString(R.string.member_verification_pending_application_cancel_modal_title));
            TextView textView10 = getBinding().f;
            d0.z.d.m.checkNotNullExpressionValue(textView10, "binding.pendingDialogDesc");
            textView10.setText(getString(R.string.member_verification_pending_application_leave_server_modal_desc));
            MaterialButton materialButton8 = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(materialButton8, "binding.memberVerificationPrimaryBtn");
            materialButton8.setText(getString(R.string.member_verification_pending_application_modal_cancel));
            MaterialButton materialButton9 = getBinding().d;
            d0.z.d.m.checkNotNullExpressionValue(materialButton9, "binding.memberVerificationSecondaryBtn");
            materialButton9.setText(getString(R.string.member_verification_pending_application_modal_dismiss));
            getBinding().c.setOnClickListener(new AnonymousClass4());
            getBinding().d.setOnClickListener(new AnonymousClass5());
            return;
        }
        if (iOrdinal2 != 3) {
            if (iOrdinal2 != 4) {
                return;
            }
            TextView textView11 = getBinding().g;
            d0.z.d.m.checkNotNullExpressionValue(textView11, "binding.pendingDialogTitle");
            textView11.setText(getString(R.string.member_verification_pending_application_leave_server_modal_title));
            TextView textView12 = getBinding().f;
            d0.z.d.m.checkNotNullExpressionValue(textView12, "binding.pendingDialogDesc");
            textView12.setText(getString(R.string.member_verification_pending_application_leave_server_modal_desc));
            MaterialButton materialButton10 = getBinding().c;
            d0.z.d.m.checkNotNullExpressionValue(materialButton10, "binding.memberVerificationPrimaryBtn");
            materialButton10.setText(getString(R.string.member_verification_pending_application_modal_leave));
            MaterialButton materialButton11 = getBinding().d;
            d0.z.d.m.checkNotNullExpressionValue(materialButton11, "binding.memberVerificationSecondaryBtn");
            materialButton11.setText(getString(R.string.member_verification_pending_application_modal_dismiss));
            getBinding().c.setOnClickListener(new AnonymousClass9(viewState));
            getBinding().d.setOnClickListener(new AnonymousClass10());
            return;
        }
        TextView textView13 = getBinding().g;
        d0.z.d.m.checkNotNullExpressionValue(textView13, "binding.pendingDialogTitle");
        textView13.setText(getString(R.string.member_verification_application_rejected_title));
        if (viewState.getRejectionReason() != null) {
            String rejectionReason = viewState.getRejectionReason();
            if (!(rejectionReason == null || rejectionReason.length() == 0)) {
                String str = getString(R.string.member_verification_application_rejected_reason) + " " + viewState.getRejectionReason();
                TextView textView14 = getBinding().f;
                d0.z.d.m.checkNotNullExpressionValue(textView14, "binding.pendingDialogDesc");
                textView14.setText(str);
            }
        }
        MaterialButton materialButton12 = getBinding().c;
        d0.z.d.m.checkNotNullExpressionValue(materialButton12, "binding.memberVerificationPrimaryBtn");
        materialButton12.setText(getString(R.string.okay));
        MaterialButton materialButton13 = getBinding().d;
        d0.z.d.m.checkNotNullExpressionValue(materialButton13, "binding.memberVerificationSecondaryBtn");
        materialButton13.setText(getString(R.string.member_verification_application_reapply));
        getBinding().c.setOnClickListener(new AnonymousClass7());
        getBinding().d.setOnClickListener(new AnonymousClass8());
    }

    private final void configureUI(MemberVerificationPendingViewModel.ViewState viewState) {
        if (!(viewState instanceof MemberVerificationPendingViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        configureLoadedUI((MemberVerificationPendingViewModel.ViewState.Loaded) viewState);
    }

    private final WidgetMemberVerificationPendingDialogBinding getBinding() {
        return (WidgetMemberVerificationPendingDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MemberVerificationPendingViewModel getViewModel() {
        return (MemberVerificationPendingViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, long j, MemberVerificationPendingViewModel.DialogState dialogState) {
        INSTANCE.show(fragmentManager, j, dialogState);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<MemberVerificationPendingViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        d0.z.d.m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), MemberVerificationPendingDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), MemberVerificationPendingDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
