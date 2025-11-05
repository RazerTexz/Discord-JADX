package com.discord.widgets.contact_sync;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetContactSyncBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.contacts.ContactsProviderUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.LoadingButton;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.contact_sync.AddFriendsFailed;
import com.discord.widgets.contact_sync.ContactSyncPermissionsSheet;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

/* compiled from: WidgetContactSync.kt */
/* loaded from: classes2.dex */
public final class WidgetContactSync extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetContactSync.class, "binding", "getBinding()Lcom/discord/databinding/WidgetContactSyncBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL = "INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL";
    private static final String INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE = "INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE";
    private static final String INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED = "INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED";
    private static final String INTENT_EXTRA_CONTACT_SYNC_MODE = "INTENT_EXTRA_CONTACT_SYNC_MODE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private final TrackImpressionMetadata contactSyncFlowMetadata;
    private int displayedChildIndex;
    private ContactSyncFriendSuggestionListAdapter friendSuggestionsAdapter;
    private final LoggingConfig loggingConfig;
    private String phoneNumber;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetContactSync.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ContactSyncMode contactSyncMode, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 2) != 0) {
                contactSyncMode = ContactSyncMode.DEFAULT;
            }
            companion.launch(context, contactSyncMode, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4);
        }

        public final ContactSyncMode getContactSyncModeFromIntent(AppActivity appActivity) {
            m.checkNotNullParameter(appActivity, "appActivity");
            Serializable serializableExtra = appActivity.c().getSerializableExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_MODE);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.contact_sync.ContactSyncMode");
            return (ContactSyncMode) serializableExtra;
        }

        public final boolean getEmailDiscoverableFromIntent(AppActivity appActivity) {
            m.checkNotNullParameter(appActivity, "appActivity");
            return appActivity.c().getBooleanExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL, true);
        }

        public final boolean getPhoneDiscoverableFromIntent(AppActivity appActivity) {
            m.checkNotNullParameter(appActivity, "appActivity");
            return appActivity.c().getBooleanExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE, true);
        }

        public final void launch(Context context, ContactSyncMode mode, boolean immediatelyProceed, boolean discoverByPhone, boolean discoverByEmail) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent();
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_MODE, mode);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, immediatelyProceed);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE, discoverByPhone);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL, discoverByEmail);
            j.d(context, WidgetContactSync.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureToolbar$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            m.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_contact_sync_skip) {
                return;
            }
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).skip();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureToolbar$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public final /* synthetic */ WidgetContactSyncViewModel.ToolbarConfig $toolbarConfig;

        public AnonymousClass2(WidgetContactSyncViewModel.ToolbarConfig toolbarConfig) {
            this.$toolbarConfig = toolbarConfig;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_contact_sync_skip);
            m.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_contact_sync_skip)");
            menuItemFindItem.setVisible(this.$toolbarConfig.getShowSkip());
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureToolbar$3, reason: invalid class name */
    public static final class AnonymousClass3<R> implements Func0<Boolean> {
        public final /* synthetic */ WidgetContactSyncViewModel.ToolbarConfig $toolbarConfig;

        public AnonymousClass3(WidgetContactSyncViewModel.ToolbarConfig toolbarConfig) {
            this.$toolbarConfig = toolbarConfig;
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            if (!this.$toolbarConfig.getShowBackButton()) {
                return Boolean.FALSE;
            }
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).skip();
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            m.checkNotNullExpressionValue(view, "view");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "view.context");
            Uri uriFromParts = Uri.fromParts("package", context.getPackageName(), null);
            m.checkNotNullExpressionValue(uriFromParts, "Uri.fromParts(\"package\",…ontext.packageName, null)");
            intent.setData(uriFromParts);
            view.getContext().startActivity(intent);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {
        public final /* synthetic */ WidgetContactSyncViewModel.ViewState $viewState;

        public AnonymousClass10(WidgetContactSyncViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnalyticsTracker.INSTANCE.friendAddViewed("Invite");
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            IntentUtils.performChooserSendIntent(context, b.k(WidgetContactSync.this, R.string.friends_share_tabbar_title, new Object[]{BuildConfig.HOST, this.$viewState.getUsername()}, null, 4).toString(), b.k(WidgetContactSync.this, R.string.tip_instant_invite_title3, new Object[0], null, 4));
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$11, reason: invalid class name */
    public static final class AnonymousClass11 implements View.OnClickListener {
        public AnonymousClass11() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).skip();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).onLandingNext();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetContactSync.access$getBinding$p(WidgetContactSync.this).e.e.c;
            m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
            boolean zIsChecked = checkedSetting.isChecked();
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).onPermissionsToggle(!zIsChecked, !zIsChecked);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<RenderContext, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* compiled from: WidgetContactSync.kt */
        /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<Hook, Unit> {

            /* compiled from: WidgetContactSync.kt */
            /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C04071 extends o implements Function1<View, Unit> {
                public C04071() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    m.checkNotNullParameter(view, "it");
                    AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Contact Sync Learn More", null, null, null, null, 30, null));
                    ContactSyncPermissionsSheet.Companion companion = ContactSyncPermissionsSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetContactSync.this.getParentFragmentManager();
                    m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(WidgetContactSync.this.getContext(), R.color.link)), false, null, new C04071(), 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("learnMoreHook", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSyncViewModel widgetContactSyncViewModelAccess$getViewModel$p = WidgetContactSync.access$getViewModel$p(WidgetContactSync.this);
            TextInputLayout textInputLayout = WidgetContactSync.access$getBinding$p(WidgetContactSync.this).f.c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.contactSyncName.contactSyncNameInputWrap");
            widgetContactSyncViewModelAccess$getViewModel$p.onNameSubmitted(ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).onBulkAddFriends();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSync.submitPhoneNumber$default(WidgetContactSync.this, null, 1, null);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 extends o implements Function0<Unit> {
        public AnonymousClass8() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.access$handlePhoneNumberTextChanged(WidgetContactSync.this);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$9, reason: invalid class name */
    public static final class AnonymousClass9 extends o implements Function1<String, Unit> {
        public AnonymousClass9() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).onVerifyPhone(str);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function2<Long, Boolean, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).handleToggleFriendSuggestionSelected(j, z2);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetContactSyncViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "it");
            WidgetContactSync.access$configureUI(WidgetContactSync.this, viewState);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<WidgetContactSyncViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.Event event) {
            m.checkNotNullParameter(event, "it");
            WidgetContactSync.access$handleEvent(WidgetContactSync.this, event);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$requestContactsPermissions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
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
            WidgetContactSync.access$onPermissionsGranted(WidgetContactSync.this);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$requestContactsPermissions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.access$onPermissionsDenied(WidgetContactSync.this);
        }
    }

    public WidgetContactSync() {
        super(R.layout.widget_contact_sync);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetContactSync$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new WidgetContactSync$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetContactSync$viewModel$2(this)));
        this.contactSyncFlowMetadata = new TrackImpressionMetadata(null, null, null, ImpressionGroups.CONTACT_SYNC_FLOW, 7);
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetContactSync$captchaLauncher$1(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetContactSync$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetContactSync widgetContactSync, WidgetContactSyncViewModel.ViewState viewState) {
        widgetContactSync.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetContactSyncBinding access$getBinding$p(WidgetContactSync widgetContactSync) {
        return widgetContactSync.getBinding();
    }

    public static final /* synthetic */ TrackImpressionMetadata access$getContactSyncFlowMetadata$p(WidgetContactSync widgetContactSync) {
        return widgetContactSync.contactSyncFlowMetadata;
    }

    public static final /* synthetic */ int access$getDisplayedChildIndex$p(WidgetContactSync widgetContactSync) {
        return widgetContactSync.displayedChildIndex;
    }

    public static final /* synthetic */ WidgetContactSyncViewModel access$getViewModel$p(WidgetContactSync widgetContactSync) {
        return widgetContactSync.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetContactSync widgetContactSync, WidgetContactSyncViewModel.Event event) {
        widgetContactSync.handleEvent(event);
    }

    public static final /* synthetic */ void access$handlePhoneNumberTextChanged(WidgetContactSync widgetContactSync) {
        widgetContactSync.handlePhoneNumberTextChanged();
    }

    public static final /* synthetic */ void access$launchCaptchaFlow(WidgetContactSync widgetContactSync, Error error) {
        widgetContactSync.launchCaptchaFlow(error);
    }

    public static final /* synthetic */ void access$onPermissionsDenied(WidgetContactSync widgetContactSync) {
        widgetContactSync.onPermissionsDenied();
    }

    public static final /* synthetic */ void access$onPermissionsGranted(WidgetContactSync widgetContactSync) {
        widgetContactSync.onPermissionsGranted();
    }

    public static final /* synthetic */ void access$setDisplayedChildIndex$p(WidgetContactSync widgetContactSync, int i) {
        widgetContactSync.displayedChildIndex = i;
    }

    public static final /* synthetic */ void access$submitPhoneNumber(WidgetContactSync widgetContactSync, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetContactSync.submitPhoneNumber(captchaPayload);
    }

    private final void configureToolbar(WidgetContactSyncViewModel.ToolbarConfig toolbarConfig) {
        setActionBarDisplayHomeAsUpEnabled(toolbarConfig.getShowBackButton());
        setActionBarOptionsMenu(R.menu.menu_contact_sync, new AnonymousClass1(), new AnonymousClass2(toolbarConfig));
        AppFragment.setOnBackPressed$default(this, new AnonymousClass3(toolbarConfig), 0, 2, null);
    }

    private final void configureUI(WidgetContactSyncViewModel.ViewState viewState) {
        this.phoneNumber = viewState.getPhoneNumber();
        configureViewFlipper(viewState.getDisplayedChild());
        configureToolbar(viewState.getToolbarConfig());
        LoadingButton loadingButton = getBinding().e.c;
        m.checkNotNullExpressionValue(loadingButton, "binding.contactSyncLandi…tactSyncLandingNextButton");
        loadingButton.setEnabled(viewState.getLandingNextEnabled());
        getBinding().e.c.setIsLoading(viewState.isSubmitting());
        getBinding().f.d.setIsLoading(viewState.isSubmitting());
        getBinding().c.c.setIsLoading(viewState.isSubmitting());
        if (viewState.getPermissionsDenied()) {
            TextView textView = getBinding().e.f144b;
            m.checkNotNullExpressionValue(textView, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView.setVisibility(0);
            View view = getBinding().e.d;
            m.checkNotNullExpressionValue(view, "binding.contactSyncLandi…LandingPermissionsDivider");
            view.setVisibility(0);
            getBinding().e.c.setText(b.k(this, R.string.password_manager_open_settings, new Object[0], null, 4));
            getBinding().e.c.setOnClickListener(AnonymousClass1.INSTANCE);
        } else {
            TextView textView2 = getBinding().e.f144b;
            m.checkNotNullExpressionValue(textView2, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView2.setVisibility(8);
            View view2 = getBinding().e.d;
            m.checkNotNullExpressionValue(view2, "binding.contactSyncLandi…LandingPermissionsDivider");
            view2.setVisibility(8);
            getBinding().e.c.setText(b.k(this, R.string.get_started, new Object[0], null, 4));
            getBinding().e.c.setOnClickListener(new AnonymousClass2());
        }
        CheckedSetting checkedSetting = getBinding().e.e.c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
        checkedSetting.setChecked(viewState.getAllowPhone() || viewState.getAllowEmail());
        getBinding().e.e.c.e(new AnonymousClass3());
        LinkifiedTextView linkifiedTextView = getBinding().e.e.f171b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncLandi…contactSyncDiscoveryInfo2");
        b.m(linkifiedTextView, R.string.contact_sync_permissions_description_android, new Object[0], new AnonymousClass4());
        getBinding().f.d.setOnClickListener(new AnonymousClass5());
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = this.friendSuggestionsAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setData(viewState.getFriendSuggestions());
        }
        getBinding().c.c.setText(b.k(this, R.string.next, new Object[0], null, 4));
        getBinding().c.c.setOnClickListener(new AnonymousClass6());
        getBinding().f2355b.f138b.b(this);
        getBinding().f2355b.f138b.setCountryCode(viewState.getCountryCode());
        getBinding().f2355b.c.setOnClickListener(new AnonymousClass7());
        getBinding().f2355b.f138b.a(this, new AnonymousClass8());
        getBinding().g.f177b.setOnCodeEntered(new AnonymousClass9());
        getBinding().d.f164b.setOnClickListener(new AnonymousClass10(viewState));
        getBinding().d.c.setOnClickListener(new AnonymousClass11());
    }

    private final void configureViewFlipper(WidgetContactSyncViewModel.Views displayedChild) {
        int i;
        int iOrdinal = displayedChild.ordinal();
        boolean z2 = true;
        if (iOrdinal != this.displayedChildIndex) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
        }
        if (displayedChild != WidgetContactSyncViewModel.Views.VIEW_LANDING || ((i = this.displayedChildIndex) != 2 && i != 3)) {
            z2 = false;
        }
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            AppViewFlipper appViewFlipper = getBinding().h;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.contactSyncViewFlipper");
            appViewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_fade_in_fast));
            AppViewFlipper appViewFlipper2 = getBinding().h;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.contactSyncViewFlipper");
            appViewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_fade_out_fast));
        } else {
            int i2 = this.displayedChildIndex;
            if (iOrdinal > i2 || z2) {
                AppViewFlipper appViewFlipper3 = getBinding().h;
                m.checkNotNullExpressionValue(appViewFlipper3, "binding.contactSyncViewFlipper");
                appViewFlipper3.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_open_in));
                AppViewFlipper appViewFlipper4 = getBinding().h;
                m.checkNotNullExpressionValue(appViewFlipper4, "binding.contactSyncViewFlipper");
                appViewFlipper4.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_open_out));
            } else if (iOrdinal < i2) {
                AppViewFlipper appViewFlipper5 = getBinding().h;
                m.checkNotNullExpressionValue(appViewFlipper5, "binding.contactSyncViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().h;
                m.checkNotNullExpressionValue(appViewFlipper6, "binding.contactSyncViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().h;
        m.checkNotNullExpressionValue(appViewFlipper7, "binding.contactSyncViewFlipper");
        appViewFlipper7.setDisplayedChild(iOrdinal);
        this.displayedChildIndex = iOrdinal;
        getAppLogger().a(null);
    }

    private final WidgetContactSyncBinding getBinding() {
        return (WidgetContactSyncBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetContactSyncViewModel.Event event) {
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.MaybeProceedFromLanding.INSTANCE)) {
            if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, false)) {
                getViewModel().onLandingNext();
                return;
            }
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.PermissionsNeeded.INSTANCE)) {
            requestContactsPermissions();
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.ContactsEnabled.INSTANCE)) {
            getViewModel().onContactsFetched(ContactsProviderUtils.INSTANCE.getAllContactPhoneNumbers(requireContext()));
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.RateLimited.INSTANCE)) {
            b.a.d.m.f(this, b.k(this, R.string.contact_sync_failed_alert_title, new Object[0], null, 4), 1);
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.UploadFailed.INSTANCE)) {
            b.a.d.m.f(this, b.k(this, R.string.contact_sync_failed_alert_message, new Object[0], null, 4), 1);
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.ContactsEnableFailed.INSTANCE)) {
            b.a.d.m.f(this, b.k(this, R.string.contact_sync_failed_alert_title, new Object[0], null, 4), 1);
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.AddFriendsFailed.INSTANCE)) {
            AddFriendsFailed.Companion companion = AddFriendsFailed.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager).setOnClose(new WidgetContactSync$handleEvent$$inlined$apply$lambda$1(this));
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.AddFriendsFailedPartial.INSTANCE)) {
            AddFriendsFailed.Companion companion2 = AddFriendsFailed.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion2.show(parentFragmentManager2).setOnClose(new WidgetContactSync$handleEvent$$inlined$apply$lambda$2(this));
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.PhoneInvalid.INSTANCE)) {
            b.a.d.m.j(this, b.k(this, R.string.phone_invalid, new Object[0], null, 4), 0, 4);
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel.Event.VerificationCodeInvalid.INSTANCE)) {
            b.a.d.m.j(this, b.k(this, R.string.application_entitlement_code_redemption_invalid, new Object[0], null, 4), 0, 4);
        } else if (m.areEqual(event, WidgetContactSyncViewModel.Event.VerificationFailed.INSTANCE)) {
            b.a.d.m.j(this, b.k(this, R.string.phone_failed_to_add, new Object[0], null, 4), 0, 4);
        } else if (m.areEqual(event, WidgetContactSyncViewModel.Event.Completed.INSTANCE)) {
            requireAppActivity().finish();
        }
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f2355b.f138b.getTextOrEmpty();
        MaterialButton materialButton = getBinding().f2355b.c;
        m.checkNotNullExpressionValue(materialButton, "binding.contactSyncAddPh…e.contactSyncAddPhoneNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && t.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.Companion companion = WidgetCaptcha.INSTANCE;
        Context contextRequireContext = requireContext();
        ActivityResultLauncher<Intent> activityResultLauncher = this.captchaLauncher;
        Error.Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncher, u.toMutableList((Collection) response.getMessages().keySet()), error);
    }

    private final void onPermissionsDenied() {
        getViewModel().onPermissionsDenied();
    }

    private final void onPermissionsGranted() {
        getViewModel().onPermissionsGranted();
        if (this.phoneNumber != null) {
            ContactsProviderUtils contactsProviderUtils = ContactsProviderUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            String str = this.phoneNumber;
            m.checkNotNull(str);
            String ownName = contactsProviderUtils.getOwnName(contextRequireContext, str);
            if (ownName != null) {
                getBinding().f.f150b.setText(ownName);
                TextView textView = getBinding().f.e;
                m.checkNotNullExpressionValue(textView, "binding.contactSyncName.contactSyncNamePrefillHint");
                textView.setVisibility(0);
            }
        }
    }

    private final void requestContactsPermissions() {
        if (!ContactsProviderUtils.INSTANCE.hasContactPermissions(requireContext())) {
            AnalyticsTracker.INSTANCE.permissionsRequested("contacts");
            getViewModel().requestingPermissions();
        }
        requestContacts(new AnonymousClass1(), new AnonymousClass2());
    }

    private final void submitPhoneNumber(CaptchaHelper.CaptchaPayload captchaPayload) {
        getViewModel().onPhoneNumberSubmitted(getBinding().f2355b.f138b.getTextOrEmpty(), captchaPayload);
    }

    public static /* synthetic */ void submitPhoneNumber$default(WidgetContactSync widgetContactSync, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetContactSync.submitPhoneNumber(captchaPayload);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (ContactsProviderUtils.INSTANCE.hasContactPermissions(requireContext())) {
            getViewModel().onPermissionsBecameAvailable();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().c.f157b;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        m.checkNotNullExpressionValue(recyclerView, "it");
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = (ContactSyncFriendSuggestionListAdapter) companion.configure(new ContactSyncFriendSuggestionListAdapter(recyclerView));
        this.friendSuggestionsAdapter = contactSyncFriendSuggestionListAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setOnClickFriendSuggestion(new AnonymousClass2());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetContactSync.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetContactSync.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
