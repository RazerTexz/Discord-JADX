package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.airbnb.lottie.LottieAnimationView;
import com.discord.R;
import com.discord.api.auth.mfa.DisableMfaRequestBody;
import com.discord.api.auth.mfa.DisableMfaResponse;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsAccountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMFA;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog;
import com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit;
import com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit;
import com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsers;
import com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.google.android.material.button.MaterialButton;
import d0.l;
import d0.t.n;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;

/* compiled from: WidgetSettingsAccount.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccount extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccount.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_HINT_DATA_MANAGEMENT = "com.discord.extra.HINT_DATA_MANAGEMENT";
    private static final String EXTRA_REDIRECT = "extra_redirect";
    private static final int MFA_DISABLED_VIEW_INDEX = 1;
    private static final int MFA_ENABLED_VIEW_INDEX = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsAccount.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, boolean z2, Redirect redirect, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            if ((i & 4) != 0) {
                redirect = null;
            }
            companion.launch(context, z2, redirect);
        }

        public final void launch(Context context) {
            launch$default(this, context, false, null, 6, null);
        }

        public final void launch(Context context, boolean z2) {
            launch$default(this, context, z2, null, 4, null);
        }

        public final void launch(Context context, boolean hintDataManagement, Redirect redirect) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccount.EXTRA_HINT_DATA_MANAGEMENT, hintDataManagement);
            intent.putExtra(WidgetSettingsAccount.EXTRA_REDIRECT, redirect);
            if (redirect != null) {
                intent.addFlags(268435456);
                intent.addFlags(67108864);
            }
            j.d(context, WidgetSettingsAccount.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ConnectedAccount contactSyncConnection;
        private final MeUser meUser;
        private final boolean ownsAnyGuilds;
        private final StoreMFA.State pendingMFAState;

        /* compiled from: WidgetSettingsAccount.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableG = Observable.g(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getMFA().observeState(), companion.getGuilds().observeGuilds(), companion.getUserConnections().observeConnectedAccounts(), companion.getExperiments().observeUserExperiment("2021-04_contact_sync_android_main", true), WidgetSettingsAccount$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…            )\n          }");
                return observableG;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, StoreMFA.State state, boolean z2, ConnectedAccount connectedAccount) {
            m.checkNotNullParameter(meUser, "meUser");
            m.checkNotNullParameter(state, "pendingMFAState");
            this.meUser = meUser;
            this.pendingMFAState = state;
            this.ownsAnyGuilds = z2;
            this.contactSyncConnection = connectedAccount;
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, StoreMFA.State state, boolean z2, ConnectedAccount connectedAccount, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = model.meUser;
            }
            if ((i & 2) != 0) {
                state = model.pendingMFAState;
            }
            if ((i & 4) != 0) {
                z2 = model.ownsAnyGuilds;
            }
            if ((i & 8) != 0) {
                connectedAccount = model.contactSyncConnection;
            }
            return model.copy(meUser, state, z2, connectedAccount);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreMFA.State getPendingMFAState() {
            return this.pendingMFAState;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getOwnsAnyGuilds() {
            return this.ownsAnyGuilds;
        }

        /* renamed from: component4, reason: from getter */
        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        public final Model copy(MeUser meUser, StoreMFA.State pendingMFAState, boolean ownsAnyGuilds, ConnectedAccount contactSyncConnection) {
            m.checkNotNullParameter(meUser, "meUser");
            m.checkNotNullParameter(pendingMFAState, "pendingMFAState");
            return new Model(meUser, pendingMFAState, ownsAnyGuilds, contactSyncConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.meUser, model.meUser) && m.areEqual(this.pendingMFAState, model.pendingMFAState) && this.ownsAnyGuilds == model.ownsAnyGuilds && m.areEqual(this.contactSyncConnection, model.contactSyncConnection);
        }

        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final boolean getOwnsAnyGuilds() {
            return this.ownsAnyGuilds;
        }

        public final StoreMFA.State getPendingMFAState() {
            return this.pendingMFAState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            StoreMFA.State state = this.pendingMFAState;
            int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
            boolean z2 = this.ownsAnyGuilds;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            ConnectedAccount connectedAccount = this.contactSyncConnection;
            return i2 + (connectedAccount != null ? connectedAccount.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(meUser=");
            sbU.append(this.meUser);
            sbU.append(", pendingMFAState=");
            sbU.append(this.pendingMFAState);
            sbU.append(", ownsAnyGuilds=");
            sbU.append(this.ownsAnyGuilds);
            sbU.append(", contactSyncConnection=");
            sbU.append(this.contactSyncConnection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    public enum Redirect {
        SMS_BACKUP
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureAccountVerificationBanner$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserEmailVerify.INSTANCE.launch(a.x(view, "v", "v.context"), WidgetUserAccountVerifyBase.Mode.UNFORCED);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountChangePassword.Companion companion = WidgetSettingsAccountChangePassword.INSTANCE;
            TextView textView = WidgetSettingsAccount.access$getBinding$p(WidgetSettingsAccount.this).d;
            m.checkNotNullExpressionValue(textView, "binding.settingsAccountChangePassword");
            Context context = textView.getContext();
            m.checkNotNullExpressionValue(context, "binding.settingsAccountChangePassword.context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass10(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$model.getOwnsAnyGuilds()) {
                WidgetSettingsAccount.access$showOwnsGuildModal(WidgetSettingsAccount.this);
                return;
            }
            WidgetDisableDeleteAccountDialog.Companion companion = WidgetDisableDeleteAccountDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetDisableDeleteAccountDialog.Mode.DISABLE);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass11(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$model.getOwnsAnyGuilds()) {
                WidgetSettingsAccount.access$showOwnsGuildModal(WidgetSettingsAccount.this);
                return;
            }
            WidgetDisableDeleteAccountDialog.Companion companion = WidgetDisableDeleteAccountDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetDisableDeleteAccountDialog.Mode.DELETE);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$12, reason: invalid class name */
    public static final class AnonymousClass12 implements View.OnClickListener {
        public final /* synthetic */ MeUser $user;

        public AnonymousClass12(MeUser meUser) {
            this.$user = meUser;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UserUtils userUtils = UserUtils.INSTANCE;
            if (userUtils.isMfaSMSEnabled(this.$user)) {
                WidgetEnableSMSBackupDialog.Companion companion = WidgetEnableSMSBackupDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, false);
                return;
            }
            if (userUtils.isMfaSMSEnabled(this.$user) || !userUtils.getHasPhone(this.$user)) {
                WidgetUserPhoneManage.INSTANCE.launch(a.x(view, "it", "it.context"), WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS, WidgetUserPhoneManage.Companion.Source.MFA_PHONE_UPDATE);
                return;
            }
            WidgetEnableSMSBackupDialog.Companion companion2 = WidgetEnableSMSBackupDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetSettingsAccount.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion2.show(parentFragmentManager2, true);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountUsernameEdit.Companion companion = WidgetSettingsAccountUsernameEdit.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountContactsNameEdit.Companion companion = WidgetSettingsAccountContactsNameEdit.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ MeUser $user;

        public AnonymousClass4(MeUser meUser) {
            this.$user = meUser;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean zIsVerified = this.$user.isVerified();
            Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2022-01_email_change_confirmation", zIsVerified);
            boolean z2 = userExperiment != null && userExperiment.getBucket() == 1 && zIsVerified;
            WidgetSettingsAccountEmailEdit.Companion companion = WidgetSettingsAccountEmailEdit.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            companion.launch(context, z2);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserPhoneManage.INSTANCE.launch(a.x(view, "it", "it.context"), WidgetUserAccountVerifyBase.Mode.UNFORCED, WidgetUserPhoneManage.Companion.Source.USER_SETTINGS_UPDATE);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableMFASteps.Companion companion = WidgetEnableMFASteps.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountBackupCodes.Companion companion = WidgetSettingsAccountBackupCodes.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccount.access$showRemove2FAModal(WidgetSettingsAccount.this);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$configureUI$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public static final AnonymousClass9 INSTANCE = new AnonymousClass9();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsBlockedUsers.Companion companion = WidgetSettingsBlockedUsers.INSTANCE;
            m.checkNotNullExpressionValue(view, "view");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "view.context");
            companion.launch(context);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    @e(c = "com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBound$1", f = "WidgetSettingsAccount.kt", l = {65}, m = "invokeSuspend")
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return WidgetSettingsAccount.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                this.label = 1;
                if (f.P(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            NestedScrollView nestedScrollView = WidgetSettingsAccount.access$getBinding$p(WidgetSettingsAccount.this).f2593x;
            LinearLayout linearLayout = WidgetSettingsAccount.access$getBinding$p(WidgetSettingsAccount.this).v;
            m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountPrivateDataWrap");
            nestedScrollView.smoothScrollTo(0, linearLayout.getBottom());
            TextView textView = WidgetSettingsAccount.access$getBinding$p(WidgetSettingsAccount.this).u;
            m.checkNotNullExpressionValue(textView, "binding.settingsAccountPrivateDataDisable");
            ViewExtensions.hintWithRipple$default(textView, 0L, 1, null);
            return Unit.a;
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetSettingsAccount widgetSettingsAccount = WidgetSettingsAccount.this;
            m.checkNotNullExpressionValue(model, "it");
            WidgetSettingsAccount.access$configureUI(widgetSettingsAccount, model);
        }
    }

    /* compiled from: WidgetSettingsAccount.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$showRemove2FAModal$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<Context, String, Unit> {

        /* compiled from: WidgetSettingsAccount.kt */
        /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$showRemove2FAModal$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04541 extends o implements Function1<DisableMfaResponse, Unit> {
            public C04541() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DisableMfaResponse disableMfaResponse) {
                invoke2(disableMfaResponse);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DisableMfaResponse disableMfaResponse) {
                m.checkNotNullParameter(disableMfaResponse, "it");
                b.a.d.m.h(WidgetSettingsAccount.this.requireContext(), WidgetSettingsAccount.this.requireContext().getString(R.string.user_settings_mfa_removed), 0, null, 12);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                companion.getAuthentication().setAuthed(disableMfaResponse.getToken());
                companion.getMFA().updatePendingMFAState(StoreMFA.MFAActivationState.PENDING_DISABLED);
            }
        }

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
            invoke2(context, str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str) {
            m.checkNotNullParameter(context, "<anonymous parameter 0>");
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().disableMFA(new DisableMfaRequestBody(str)), WidgetSettingsAccount.this, null, 2, null), WidgetSettingsAccount.access$getBinding$p(WidgetSettingsAccount.this).f2591b, 0L, 2, null), false, 1, null), WidgetSettingsAccount.class, WidgetSettingsAccount.this.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C04541(), 60, (Object) null);
        }
    }

    public WidgetSettingsAccount() {
        super(R.layout.widget_settings_account);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccount$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccount widgetSettingsAccount, Model model) {
        widgetSettingsAccount.configureUI(model);
    }

    public static final /* synthetic */ WidgetSettingsAccountBinding access$getBinding$p(WidgetSettingsAccount widgetSettingsAccount) {
        return widgetSettingsAccount.getBinding();
    }

    public static final /* synthetic */ void access$showOwnsGuildModal(WidgetSettingsAccount widgetSettingsAccount) {
        widgetSettingsAccount.showOwnsGuildModal();
    }

    public static final /* synthetic */ void access$showRemove2FAModal(WidgetSettingsAccount widgetSettingsAccount) {
        widgetSettingsAccount.showRemove2FAModal();
    }

    private final void configureAccountVerificationBanner(MeUser user) {
        RelativeLayout relativeLayout = getBinding().C;
        m.checkNotNullExpressionValue(relativeLayout, "binding.settingsAccountVerification");
        relativeLayout.setVisibility(user.isVerified() ^ true ? 0 : 8);
        if (user.getEmail() == null) {
            TextView textView = getBinding().E;
            m.checkNotNullExpressionValue(textView, "binding.settingsAccountVerificationTitle");
            textView.setText(getString(R.string.add_email_banner_title));
            MaterialButton materialButton = getBinding().D;
            m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountVerificationButton");
            materialButton.setText(getString(R.string.add_email_short));
        } else {
            TextView textView2 = getBinding().E;
            m.checkNotNullExpressionValue(textView2, "binding.settingsAccountVerificationTitle");
            textView2.setText(getString(R.string.verify_your_email));
            MaterialButton materialButton2 = getBinding().D;
            m.checkNotNullExpressionValue(materialButton2, "binding.settingsAccountVerificationButton");
            materialButton2.setText(getString(R.string.verify));
        }
        getBinding().D.setOnClickListener(AnonymousClass1.INSTANCE);
    }

    private final void configureMFA(boolean enabled, boolean pending) {
        TextView textView = getBinding().l;
        m.checkNotNullExpressionValue(textView, "binding.settingsAccountMfaEnabledHeader");
        textView.setVisibility(enabled ? 0 : 8);
        AppViewFlipper appViewFlipper = getBinding().m;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsAccountMfaFlipper");
        appViewFlipper.setDisplayedChild(!enabled ? 1 : 0);
        LottieAnimationView lottieAnimationView = getBinding().n;
        m.checkNotNullExpressionValue(lottieAnimationView, "binding.settingsAccountMfaLottie");
        lottieAnimationView.setVisibility((!enabled ? 1 : 0) != 0 ? 0 : 8);
        TextView textView2 = getBinding().o;
        m.checkNotNullExpressionValue(textView2, "binding.settingsAccountMfaSalesPitch");
        textView2.setVisibility((!enabled ? 1 : 0) != 0 ? 0 : 8);
        MaterialButton materialButton = getBinding().j;
        m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountMfaEnable");
        materialButton.setVisibility((!enabled ? 1 : 0) == 0 ? 8 : 0);
        MaterialButton materialButton2 = getBinding().j;
        m.checkNotNullExpressionValue(materialButton2, "binding.settingsAccountMfaEnable");
        materialButton2.setEnabled(!pending);
        TextView textView3 = getBinding().F;
        m.checkNotNullExpressionValue(textView3, "binding.settingsAccountViewBackupCodes");
        textView3.setEnabled(!pending);
        TextView textView4 = getBinding().w;
        m.checkNotNullExpressionValue(textView4, "binding.settingsAccountRemoveTwoFa");
        textView4.setEnabled(!pending);
        LinearLayout linearLayout = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountMfaDisabledContainer");
        ViewExtensions.setEnabledAlpha$default(linearLayout, !pending, 0.0f, 2, null);
        LinearLayout linearLayout2 = getBinding().k;
        m.checkNotNullExpressionValue(linearLayout2, "binding.settingsAccountMfaEnabledContainer");
        ViewExtensions.setEnabledAlpha$default(linearLayout2, !pending, 0.0f, 2, null);
    }

    private final void configureUI(Model model) {
        String name;
        MeUser meUser = model.getMeUser();
        StoreMFA.State pendingMFAState = model.getPendingMFAState();
        ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
        configureAccountVerificationBanner(meUser);
        LinearLayout linearLayout = getBinding().p;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountNameContainer");
        linearLayout.setVisibility(contactSyncConnection != null ? 0 : 8);
        TextView textView = getBinding().q;
        m.checkNotNullExpressionValue(textView, "binding.settingsAccountNameText");
        if (contactSyncConnection == null || (name = contactSyncConnection.getName()) == null) {
            name = "";
        }
        textView.setText(name);
        TextView textView2 = getBinding().B;
        m.checkNotNullExpressionValue(textView2, "binding.settingsAccountTagText");
        UserUtils userUtils = UserUtils.INSTANCE;
        textView2.setText(UserUtils.getUserNameWithDiscriminator$default(userUtils, meUser, null, null, 3, null));
        TextView textView3 = getBinding().f;
        m.checkNotNullExpressionValue(textView3, "binding.settingsAccountEmailText");
        textView3.setText(meUser.getEmail());
        TextView textView4 = getBinding().f2592s;
        m.checkNotNullExpressionValue(textView4, "binding.settingsAccountPhoneText");
        textView4.setText(meUser.getPhoneNumber());
        getBinding().d.setOnClickListener(new AnonymousClass1());
        getBinding().A.setOnClickListener(AnonymousClass2.INSTANCE);
        getBinding().p.setOnClickListener(AnonymousClass3.INSTANCE);
        getBinding().e.setOnClickListener(new AnonymousClass4(meUser));
        getBinding().r.setOnClickListener(AnonymousClass5.INSTANCE);
        TextView textView5 = getBinding().l;
        m.checkNotNullExpressionValue(textView5, "binding.settingsAccountMfaEnabledHeader");
        textView5.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        AppViewFlipper appViewFlipper = getBinding().m;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsAccountMfaFlipper");
        appViewFlipper.setDisplayedChild(!meUser.getMfaEnabled() ? 1 : 0);
        LottieAnimationView lottieAnimationView = getBinding().n;
        m.checkNotNullExpressionValue(lottieAnimationView, "binding.settingsAccountMfaLottie");
        lottieAnimationView.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        TextView textView6 = getBinding().o;
        m.checkNotNullExpressionValue(textView6, "binding.settingsAccountMfaSalesPitch");
        textView6.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        MaterialButton materialButton = getBinding().j;
        m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountMfaEnable");
        materialButton.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        if (pendingMFAState.getActivationState() != StoreMFA.MFAActivationState.NONE) {
            configureMFA(pendingMFAState.getActivationState() == StoreMFA.MFAActivationState.PENDING_ENABLED, true);
        } else {
            configureMFA(meUser.getMfaEnabled(), false);
        }
        getBinding().j.setOnClickListener(AnonymousClass6.INSTANCE);
        getBinding().F.setOnClickListener(AnonymousClass7.INSTANCE);
        getBinding().w.setOnClickListener(new AnonymousClass8());
        getBinding().G.setOnClickListener(AnonymousClass9.INSTANCE);
        getBinding().u.setOnClickListener(new AnonymousClass10(model));
        getBinding().t.setOnClickListener(new AnonymousClass11(model));
        String sMSBackupDisabledMessage = getSMSBackupDisabledMessage(meUser);
        if (sMSBackupDisabledMessage != null || pendingMFAState.isTogglingSMSBackup()) {
            CheckedSetting.d(getBinding().f2594y, null, 1);
            TextView textView7 = getBinding().f2595z;
            m.checkNotNullExpressionValue(textView7, "binding.settingsAccountSmsPhone");
            ViewExtensions.setEnabledAlpha$default(textView7, false, 0.0f, 2, null);
        } else {
            TextView textView8 = getBinding().f2595z;
            m.checkNotNullExpressionValue(textView8, "binding.settingsAccountSmsPhone");
            ViewExtensions.setEnabledAlpha$default(textView8, true, 0.0f, 2, null);
            getBinding().f2594y.e(new AnonymousClass12(meUser));
        }
        TextView textView9 = getBinding().f2595z;
        m.checkNotNullExpressionValue(textView9, "binding.settingsAccountSmsPhone");
        ViewExtensions.setTextAndVisibilityBy(textView9, meUser.getPhoneNumber() != null ? b.h(a.I(getBinding().f2595z, "binding.settingsAccountSmsPhone", "binding.settingsAccountSmsPhone.context"), R.string.mfa_sms_auth_current_phone, new Object[]{meUser.getPhoneNumber()}, null, 4) : null);
        CheckedSetting checkedSetting = getBinding().f2594y;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccountSmsBackup");
        checkedSetting.setChecked(userUtils.isMfaSMSEnabled(meUser));
        CheckedSetting checkedSetting2 = getBinding().f2594y;
        if (sMSBackupDisabledMessage == null) {
            sMSBackupDisabledMessage = getString(R.string.mfa_sms_auth_sales_pitch);
            m.checkNotNullExpressionValue(sMSBackupDisabledMessage, "getString(R.string.mfa_sms_auth_sales_pitch)");
        }
        CheckedSetting.i(checkedSetting2, sMSBackupDisabledMessage, false, 2);
        if (getMostRecentIntent().getSerializableExtra(EXTRA_REDIRECT) == Redirect.SMS_BACKUP) {
            getMostRecentIntent().removeExtra(EXTRA_REDIRECT);
            WidgetEnableSMSBackupDialog.Companion companion = WidgetEnableSMSBackupDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, true);
        }
        for (TextView textView10 : n.listOf((Object[]) new TextView[]{getBinding().g, getBinding().c, getBinding().h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView10, "header");
            accessibilityUtils.setViewIsHeading(textView10);
        }
    }

    private final WidgetSettingsAccountBinding getBinding() {
        return (WidgetSettingsAccountBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSMSBackupDisabledMessage(MeUser user) {
        UserUtils userUtils = UserUtils.INSTANCE;
        if (userUtils.isPartner(user) || userUtils.isStaff(user)) {
            return getString(R.string.mfa_sms_disabled_partner);
        }
        if (user.getEmail() == null) {
            return getString(R.string.mfa_sms_disabled_no_email);
        }
        return null;
    }

    public static final void launch(Context context) {
        Companion.launch$default(INSTANCE, context, false, null, 6, null);
    }

    public static final void launch(Context context, boolean z2) {
        Companion.launch$default(INSTANCE, context, z2, null, 4, null);
    }

    public static final void launch(Context context, boolean z2, Redirect redirect) {
        INSTANCE.launch(context, z2, redirect);
    }

    private final void showOwnsGuildModal() {
        WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(requireContext()).setTitle(R.string.delete_account_transfer_ownership).setMessage(R.string.delete_account_transfer_ownership_body), R.string.okay, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton$default.show(parentFragmentManager);
    }

    private final void showRemove2FAModal() {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            String string = requireContext().getString(R.string.two_fa_remove);
            m.checkNotNullExpressionValue(string, "requireContext().getString(R.string.two_fa_remove)");
            String string2 = requireContext().getString(R.string.user_settings_mfa_enable_code_body);
            m.checkNotNullExpressionValue(string2, "requireContext().getStri…ngs_mfa_enable_code_body)");
            String string3 = requireContext().getString(R.string.two_fa_auth_code);
            m.checkNotNullExpressionValue(string3, "requireContext().getStri….string.two_fa_auth_code)");
            WidgetNoticeDialog.Companion.showInputModal$default(companion, appActivity, string, string2, string3, new AnonymousClass1(), null, null, null, null, false, 992, null);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4008) {
            GoogleSmartLockManager.INSTANCE.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_my_account);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setRetainInstance(true);
        if (getMostRecentIntent().getBooleanExtra(EXTRA_HINT_DATA_MANAGEMENT, false)) {
            LinearLayout linearLayout = getBinding().v;
            m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountPrivateDataWrap");
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(linearLayout);
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableR = Model.INSTANCE.get().r();
        m.checkNotNullExpressionValue(observableR, "Model\n        .get()\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetSettingsAccount.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
