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
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetMemberVerificationPendingDialogBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(MemberVerificationPendingDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationPendingDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_DIALOG_STATE = "INTENT_EXTRA_DIALOG_STATE";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
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
            String strM877t = outline.m877t("MEMBERVERIFICATION-", guildId);
            notices.requestToShow(new StoreNotices.Notice(strM877t, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new MemberVerificationPendingDialog2(guildId, dialogState, notices, strM877t), 150, null));
        }

        public final void show(FragmentManager supportFragmentManager, long guildId, MemberVerificationPendingViewModel.DialogState dialogState) {
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$1 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC95251 implements View.OnClickListener {
        public ViewOnClickListenerC95251() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$10 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC952610 implements View.OnClickListener {
        public ViewOnClickListenerC952610() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$11 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC952711 implements View.OnClickListener {
        public ViewOnClickListenerC952711() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context contextRequireContext = MemberVerificationPendingDialog.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UriHandler.directToPlayStore$default(contextRequireContext, null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$12 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC952812 implements View.OnClickListener {
        public ViewOnClickListenerC952812() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$2 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC95292 implements View.OnClickListener {
        public ViewOnClickListenerC95292() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).updateDialogState(MemberVerificationPendingViewModel.DialogState.CANCEL);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$3 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC95303 implements View.OnClickListener {
        public ViewOnClickListenerC95303() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).updateDialogState(MemberVerificationPendingViewModel.DialogState.LEAVE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$4 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC95314 implements View.OnClickListener {
        public ViewOnClickListenerC95314() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).resetGuildJoinRequest();
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$5 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC95325 implements View.OnClickListener {
        public ViewOnClickListenerC95325() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$7 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC95337 implements View.OnClickListener {
        public ViewOnClickListenerC95337() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$8 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC95348 implements View.OnClickListener {
        public ViewOnClickListenerC95348() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MemberVerificationPendingDialog.access$getViewModel$p(MemberVerificationPendingDialog.this).resetGuildJoinRequest();
            MemberVerificationPendingDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$configureLoadedUI$9 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class ViewOnClickListenerC95359 implements View.OnClickListener {
        public final /* synthetic */ MemberVerificationPendingViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC95359(MemberVerificationPendingViewModel.ViewState.Loaded loaded) {
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final /* synthetic */ class C95361 extends FunctionReferenceImpl implements Function1<MemberVerificationPendingViewModel.ViewState, Unit> {
        public C95361(MemberVerificationPendingDialog memberVerificationPendingDialog) {
            super(1, memberVerificationPendingDialog, MemberVerificationPendingDialog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationPendingViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            MemberVerificationPendingDialog.access$configureUI((MemberVerificationPendingDialog) this.receiver, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingDialog$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
    public static final class C95372 extends Lambda implements Function1<MemberVerificationPendingViewModel.Event, Unit> {
        public C95372() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationPendingViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationPendingViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (!(event instanceof MemberVerificationPendingViewModel.Event.Success) && (event instanceof MemberVerificationPendingViewModel.Event.Error)) {
                AppToast.m171i(MemberVerificationPendingDialog.this, C5419R.string.guild_settings_public_update_failed, 0, 4);
            }
        }
    }

    public MemberVerificationPendingDialog() {
        super(C5419R.layout.widget_member_verification_pending_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, MemberVerificationPendingDialog3.INSTANCE, null, 2, null);
        MemberVerificationPendingDialog4 memberVerificationPendingDialog4 = new MemberVerificationPendingDialog4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MemberVerificationPendingViewModel.class), new C9524x63dbca6b(appViewModelDelegates3), new AppViewModelDelegates5(memberVerificationPendingDialog4));
    }

    public static final /* synthetic */ void access$configureUI(MemberVerificationPendingDialog memberVerificationPendingDialog, MemberVerificationPendingViewModel.ViewState viewState) {
        memberVerificationPendingDialog.configureUI(viewState);
    }

    public static final /* synthetic */ MemberVerificationPendingViewModel access$getViewModel$p(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        return memberVerificationPendingDialog.getViewModel();
    }

    private final void configureLoadedUI(MemberVerificationPendingViewModel.ViewState.Loaded viewState) {
        ImageView imageView = getBinding().f17251b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.memberVerificationPendingImg");
        imageView.setVisibility(viewState.getShowPendingImage() ? 0 : 8);
        TextView textView = getBinding().f17254e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationTertiaryBtn");
        textView.setVisibility(viewState.getShowTertiaryButton() ? 0 : 8);
        int iOrdinal = viewState.getDialogState().ordinal();
        int color = (iOrdinal == 2 || iOrdinal == 4) ? ColorCompat.getColor(getContext(), C5419R.color.status_red_500) : ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand_500);
        MaterialButton materialButton = getBinding().f17252c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.memberVerificationPrimaryBtn");
        materialButton.setBackgroundTintList(ColorStateList.valueOf(color));
        int iOrdinal2 = viewState.getDialogState().ordinal();
        if (iOrdinal2 == 0) {
            getBinding().f17251b.setImageResource(C5419R.drawable.ic_community_update);
            TextView textView2 = getBinding().f17256g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.pendingDialogTitle");
            textView2.setText(getString(C5419R.string.member_verification_warning_update_modal_title));
            TextView textView3 = getBinding().f17255f;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.pendingDialogDesc");
            textView3.setText(getString(C5419R.string.member_verification_warning_update_modal_desc));
            MaterialButton materialButton2 = getBinding().f17252c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.memberVerificationPrimaryBtn");
            materialButton2.setText(getString(C5419R.string.member_verification_warning_update));
            MaterialButton materialButton3 = getBinding().f17253d;
            Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.memberVerificationSecondaryBtn");
            materialButton3.setText(getString(C5419R.string.cancel));
            getBinding().f17252c.setOnClickListener(new ViewOnClickListenerC952711());
            getBinding().f17253d.setOnClickListener(new ViewOnClickListenerC952812());
            return;
        }
        if (iOrdinal2 == 1) {
            getBinding().f17251b.setImageResource(C5419R.drawable.ic_member_verification_pending);
            TextView textView4 = getBinding().f17256g;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.pendingDialogTitle");
            textView4.setText(getString(C5419R.string.member_verification_pending_application_modal_title));
            TextView textView5 = getBinding().f17255f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.pendingDialogDesc");
            textView5.setText(getString(C5419R.string.member_verification_pending_application_modal_desc));
            MaterialButton materialButton4 = getBinding().f17252c;
            Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.memberVerificationPrimaryBtn");
            materialButton4.setText(getString(C5419R.string.got_it));
            getBinding().f17252c.setOnClickListener(new ViewOnClickListenerC95251());
            if (viewState.isPreviewEnabled()) {
                MaterialButton materialButton5 = getBinding().f17253d;
                Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.memberVerificationSecondaryBtn");
                materialButton5.setVisibility(8);
                TextView textView6 = getBinding().f17254e;
                Intrinsics3.checkNotNullExpressionValue(textView6, "binding.memberVerificationTertiaryBtn");
                textView6.setVisibility(8);
                return;
            }
            MaterialButton materialButton6 = getBinding().f17253d;
            Intrinsics3.checkNotNullExpressionValue(materialButton6, "binding.memberVerificationSecondaryBtn");
            materialButton6.setVisibility(0);
            MaterialButton materialButton7 = getBinding().f17253d;
            Intrinsics3.checkNotNullExpressionValue(materialButton7, "binding.memberVerificationSecondaryBtn");
            materialButton7.setText(getString(C5419R.string.member_verification_cancel_application));
            getBinding().f17253d.setOnClickListener(new ViewOnClickListenerC95292());
            TextView textView7 = getBinding().f17254e;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.memberVerificationTertiaryBtn");
            textView7.setVisibility(0);
            TextView textView8 = getBinding().f17254e;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.memberVerificationTertiaryBtn");
            textView8.setText(getString(C5419R.string.leave_server));
            getBinding().f17254e.setOnClickListener(new ViewOnClickListenerC95303());
            return;
        }
        if (iOrdinal2 == 2) {
            TextView textView9 = getBinding().f17256g;
            Intrinsics3.checkNotNullExpressionValue(textView9, "binding.pendingDialogTitle");
            textView9.setText(getString(C5419R.string.member_verification_pending_application_cancel_modal_title));
            TextView textView10 = getBinding().f17255f;
            Intrinsics3.checkNotNullExpressionValue(textView10, "binding.pendingDialogDesc");
            textView10.setText(getString(C5419R.string.member_verification_pending_application_leave_server_modal_desc));
            MaterialButton materialButton8 = getBinding().f17252c;
            Intrinsics3.checkNotNullExpressionValue(materialButton8, "binding.memberVerificationPrimaryBtn");
            materialButton8.setText(getString(C5419R.string.member_verification_pending_application_modal_cancel));
            MaterialButton materialButton9 = getBinding().f17253d;
            Intrinsics3.checkNotNullExpressionValue(materialButton9, "binding.memberVerificationSecondaryBtn");
            materialButton9.setText(getString(C5419R.string.member_verification_pending_application_modal_dismiss));
            getBinding().f17252c.setOnClickListener(new ViewOnClickListenerC95314());
            getBinding().f17253d.setOnClickListener(new ViewOnClickListenerC95325());
            return;
        }
        if (iOrdinal2 != 3) {
            if (iOrdinal2 != 4) {
                return;
            }
            TextView textView11 = getBinding().f17256g;
            Intrinsics3.checkNotNullExpressionValue(textView11, "binding.pendingDialogTitle");
            textView11.setText(getString(C5419R.string.member_verification_pending_application_leave_server_modal_title));
            TextView textView12 = getBinding().f17255f;
            Intrinsics3.checkNotNullExpressionValue(textView12, "binding.pendingDialogDesc");
            textView12.setText(getString(C5419R.string.member_verification_pending_application_leave_server_modal_desc));
            MaterialButton materialButton10 = getBinding().f17252c;
            Intrinsics3.checkNotNullExpressionValue(materialButton10, "binding.memberVerificationPrimaryBtn");
            materialButton10.setText(getString(C5419R.string.member_verification_pending_application_modal_leave));
            MaterialButton materialButton11 = getBinding().f17253d;
            Intrinsics3.checkNotNullExpressionValue(materialButton11, "binding.memberVerificationSecondaryBtn");
            materialButton11.setText(getString(C5419R.string.member_verification_pending_application_modal_dismiss));
            getBinding().f17252c.setOnClickListener(new ViewOnClickListenerC95359(viewState));
            getBinding().f17253d.setOnClickListener(new ViewOnClickListenerC952610());
            return;
        }
        TextView textView13 = getBinding().f17256g;
        Intrinsics3.checkNotNullExpressionValue(textView13, "binding.pendingDialogTitle");
        textView13.setText(getString(C5419R.string.member_verification_application_rejected_title));
        if (viewState.getRejectionReason() != null) {
            String rejectionReason = viewState.getRejectionReason();
            if (!(rejectionReason == null || rejectionReason.length() == 0)) {
                String str = getString(C5419R.string.member_verification_application_rejected_reason) + " " + viewState.getRejectionReason();
                TextView textView14 = getBinding().f17255f;
                Intrinsics3.checkNotNullExpressionValue(textView14, "binding.pendingDialogDesc");
                textView14.setText(str);
            }
        }
        MaterialButton materialButton12 = getBinding().f17252c;
        Intrinsics3.checkNotNullExpressionValue(materialButton12, "binding.memberVerificationPrimaryBtn");
        materialButton12.setText(getString(C5419R.string.okay));
        MaterialButton materialButton13 = getBinding().f17253d;
        Intrinsics3.checkNotNullExpressionValue(materialButton13, "binding.memberVerificationSecondaryBtn");
        materialButton13.setText(getString(C5419R.string.member_verification_application_reapply));
        getBinding().f17252c.setOnClickListener(new ViewOnClickListenerC95337());
        getBinding().f17253d.setOnClickListener(new ViewOnClickListenerC95348());
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
        Observable<MemberVerificationPendingViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), MemberVerificationPendingDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95361(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), MemberVerificationPendingDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95372(), 62, (Object) null);
    }
}
