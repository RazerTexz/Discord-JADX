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
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.LoadingButton;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.contact_sync.AddFriendsFailed;
import com.discord.widgets.contact_sync.ContactSyncPermissionsSheet;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
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
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.functions.Func0;

/* compiled from: WidgetContactSync.kt */
/* loaded from: classes2.dex */
public final class WidgetContactSync extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetContactSync.class, "binding", "getBinding()Lcom/discord/databinding/WidgetContactSyncBinding;", 0)};

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
    private final AppLogger2 loggingConfig;
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
            Intrinsics3.checkNotNullParameter(appActivity, "appActivity");
            Serializable serializableExtra = appActivity.m8343c().getSerializableExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_MODE);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.contact_sync.ContactSyncMode");
            return (ContactSyncMode) serializableExtra;
        }

        public final boolean getEmailDiscoverableFromIntent(AppActivity appActivity) {
            Intrinsics3.checkNotNullParameter(appActivity, "appActivity");
            return appActivity.m8343c().getBooleanExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL, true);
        }

        public final boolean getPhoneDiscoverableFromIntent(AppActivity appActivity) {
            Intrinsics3.checkNotNullParameter(appActivity, "appActivity");
            return appActivity.m8343c().getBooleanExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE, true);
        }

        public final void launch(Context context, ContactSyncMode mode, boolean immediatelyProceed, boolean discoverByPhone, boolean discoverByEmail) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent();
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_MODE, mode);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, immediatelyProceed);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE, discoverByPhone);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL, discoverByEmail);
            AppScreen2.m156d(context, WidgetContactSync.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureToolbar$1 */
    public static final class C82251<T1, T2> implements Action2<MenuItem, Context> {
        public C82251() {
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != C5419R.id.menu_contact_sync_skip) {
                return;
            }
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).skip();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureToolbar$2 */
    public static final class C82262<T> implements Action1<Menu> {
        public final /* synthetic */ WidgetContactSyncViewModel.ToolbarConfig $toolbarConfig;

        public C82262(WidgetContactSyncViewModel.ToolbarConfig toolbarConfig) {
            this.$toolbarConfig = toolbarConfig;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_contact_sync_skip);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_contact_sync_skip)");
            menuItemFindItem.setVisible(this.$toolbarConfig.getShowSkip());
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureToolbar$3 */
    public static final class C82273<R> implements Func0<Boolean> {
        public final /* synthetic */ WidgetContactSyncViewModel.ToolbarConfig $toolbarConfig;

        public C82273(WidgetContactSyncViewModel.ToolbarConfig toolbarConfig) {
            this.$toolbarConfig = toolbarConfig;
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            if (!this.$toolbarConfig.getShowBackButton()) {
                return Boolean.FALSE;
            }
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).skip();
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$1 */
    public static final class ViewOnClickListenerC82281 implements View.OnClickListener {
        public static final ViewOnClickListenerC82281 INSTANCE = new ViewOnClickListenerC82281();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            Uri uriFromParts = Uri.fromParts("package", context.getPackageName(), null);
            Intrinsics3.checkNotNullExpressionValue(uriFromParts, "Uri.fromParts(\"package\",…ontext.packageName, null)");
            intent.setData(uriFromParts);
            view.getContext().startActivity(intent);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$10 */
    public static final class ViewOnClickListenerC822910 implements View.OnClickListener {
        public final /* synthetic */ WidgetContactSyncViewModel.ViewState $viewState;

        public ViewOnClickListenerC822910(WidgetContactSyncViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnalyticsTracker.INSTANCE.friendAddViewed("Invite");
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            IntentUtils.performChooserSendIntent(context, FormatUtils.m219k(WidgetContactSync.this, C5419R.string.friends_share_tabbar_title, new Object[]{BuildConfig.HOST, this.$viewState.getUsername()}, null, 4).toString(), FormatUtils.m219k(WidgetContactSync.this, C5419R.string.tip_instant_invite_title3, new Object[0], null, 4));
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$11 */
    public static final class ViewOnClickListenerC823011 implements View.OnClickListener {
        public ViewOnClickListenerC823011() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).skip();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$2 */
    public static final class ViewOnClickListenerC82312 implements View.OnClickListener {
        public ViewOnClickListenerC82312() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).onLandingNext();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$3 */
    public static final class ViewOnClickListenerC82323 implements View.OnClickListener {
        public ViewOnClickListenerC82323() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetContactSync.access$getBinding$p(WidgetContactSync.this).f16413e.f995e.f1096c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
            boolean zIsChecked = checkedSetting.isChecked();
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).onPermissionsToggle(!zIsChecked, !zIsChecked);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4 */
    public static final class C82334 extends Lambda implements Function1<RenderContext, Unit> {
        public C82334() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* compiled from: WidgetContactSync.kt */
        /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

            /* compiled from: WidgetContactSync.kt */
            /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132851 extends Lambda implements Function1<View, Unit> {
                public C132851() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics3.checkNotNullParameter(view, "it");
                    AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Contact Sync Learn More", null, null, null, null, 30, null));
                    ContactSyncPermissionsSheet.Companion companion = ContactSyncPermissionsSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetContactSync.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(WidgetContactSync.this.getContext(), C5419R.color.link)), false, null, new C132851(), 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("learnMoreHook", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$5 */
    public static final class ViewOnClickListenerC82345 implements View.OnClickListener {
        public ViewOnClickListenerC82345() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSyncViewModel widgetContactSyncViewModelAccess$getViewModel$p = WidgetContactSync.access$getViewModel$p(WidgetContactSync.this);
            TextInputLayout textInputLayout = WidgetContactSync.access$getBinding$p(WidgetContactSync.this).f16414f.f1014c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.contactSyncName.contactSyncNameInputWrap");
            widgetContactSyncViewModelAccess$getViewModel$p.onNameSubmitted(ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$6 */
    public static final class ViewOnClickListenerC82356 implements View.OnClickListener {
        public ViewOnClickListenerC82356() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).onBulkAddFriends();
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$7 */
    public static final class ViewOnClickListenerC82367 implements View.OnClickListener {
        public ViewOnClickListenerC82367() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSync.submitPhoneNumber$default(WidgetContactSync.this, null, 1, null);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$8 */
    public static final class C82378 extends Lambda implements Function0<Unit> {
        public C82378() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.access$handlePhoneNumberTextChanged(WidgetContactSync.this);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$9 */
    public static final class C82389 extends Lambda implements Function1<String, Unit> {
        public C82389() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).onVerifyPhone(str);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBound$2 */
    public static final class C82392 extends Lambda implements Function2<Long, Boolean, Unit> {
        public C82392() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetContactSync.access$getViewModel$p(WidgetContactSync.this).handleToggleFriendSuggestionSelected(j, z2);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBoundOrOnResume$1 */
    public static final class C82401 extends Lambda implements Function1<WidgetContactSyncViewModel.ViewState, Unit> {
        public C82401() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetContactSync.access$configureUI(WidgetContactSync.this, viewState);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBoundOrOnResume$2 */
    public static final class C82412 extends Lambda implements Function1<WidgetContactSyncViewModel.Event, Unit> {
        public C82412() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetContactSync.access$handleEvent(WidgetContactSync.this, event);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$requestContactsPermissions$1 */
    public static final class C82421 extends Lambda implements Function0<Unit> {
        public C82421() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.access$onPermissionsGranted(WidgetContactSync.this);
        }
    }

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$requestContactsPermissions$2 */
    public static final class C82432 extends Lambda implements Function0<Unit> {
        public C82432() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.access$onPermissionsDenied(WidgetContactSync.this);
        }
    }

    public WidgetContactSync() {
        super(C5419R.layout.widget_contact_sync);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetContactSync2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new C8223x884328d6(this), new AppViewModelDelegates2(new WidgetContactSync7(this)));
        this.contactSyncFlowMetadata = new TrackImpressionMetadata(null, null, null, ImpressionGroups.CONTACT_SYNC_FLOW, 7);
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetContactSync3(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetContactSync6(this), 3);
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
        setActionBarOptionsMenu(C5419R.menu.menu_contact_sync, new C82251(), new C82262(toolbarConfig));
        AppFragment.setOnBackPressed$default(this, new C82273(toolbarConfig), 0, 2, null);
    }

    private final void configureUI(WidgetContactSyncViewModel.ViewState viewState) {
        this.phoneNumber = viewState.getPhoneNumber();
        configureViewFlipper(viewState.getDisplayedChild());
        configureToolbar(viewState.getToolbarConfig());
        LoadingButton loadingButton = getBinding().f16413e.f993c;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.contactSyncLandi…tactSyncLandingNextButton");
        loadingButton.setEnabled(viewState.getLandingNextEnabled());
        getBinding().f16413e.f993c.setIsLoading(viewState.isSubmitting());
        getBinding().f16414f.f1015d.setIsLoading(viewState.isSubmitting());
        getBinding().f16411c.f1042c.setIsLoading(viewState.isSubmitting());
        if (viewState.getPermissionsDenied()) {
            TextView textView = getBinding().f16413e.f992b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView.setVisibility(0);
            View view = getBinding().f16413e.f994d;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.contactSyncLandi…LandingPermissionsDivider");
            view.setVisibility(0);
            getBinding().f16413e.f993c.setText(FormatUtils.m219k(this, C5419R.string.password_manager_open_settings, new Object[0], null, 4));
            getBinding().f16413e.f993c.setOnClickListener(ViewOnClickListenerC82281.INSTANCE);
        } else {
            TextView textView2 = getBinding().f16413e.f992b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView2.setVisibility(8);
            View view2 = getBinding().f16413e.f994d;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.contactSyncLandi…LandingPermissionsDivider");
            view2.setVisibility(8);
            getBinding().f16413e.f993c.setText(FormatUtils.m219k(this, C5419R.string.get_started, new Object[0], null, 4));
            getBinding().f16413e.f993c.setOnClickListener(new ViewOnClickListenerC82312());
        }
        CheckedSetting checkedSetting = getBinding().f16413e.f995e.f1096c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
        checkedSetting.setChecked(viewState.getAllowPhone() || viewState.getAllowEmail());
        getBinding().f16413e.f995e.f1096c.m8527e(new ViewOnClickListenerC82323());
        LinkifiedTextView linkifiedTextView = getBinding().f16413e.f995e.f1095b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncLandi…contactSyncDiscoveryInfo2");
        FormatUtils.m221m(linkifiedTextView, C5419R.string.contact_sync_permissions_description_android, new Object[0], new C82334());
        getBinding().f16414f.f1015d.setOnClickListener(new ViewOnClickListenerC82345());
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = this.friendSuggestionsAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setData(viewState.getFriendSuggestions());
        }
        getBinding().f16411c.f1042c.setText(FormatUtils.m219k(this, C5419R.string.next, new Object[0], null, 4));
        getBinding().f16411c.f1042c.setOnClickListener(new ViewOnClickListenerC82356());
        getBinding().f16410b.f967b.m8600b(this);
        getBinding().f16410b.f967b.setCountryCode(viewState.getCountryCode());
        getBinding().f16410b.f968c.setOnClickListener(new ViewOnClickListenerC82367());
        getBinding().f16410b.f967b.m8599a(this, new C82378());
        getBinding().f16415g.f1123b.setOnCodeEntered(new C82389());
        getBinding().f16412d.f1068b.setOnClickListener(new ViewOnClickListenerC822910(viewState));
        getBinding().f16412d.f1069c.setOnClickListener(new ViewOnClickListenerC823011());
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
            AppViewFlipper appViewFlipper = getBinding().f16416h;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.contactSyncViewFlipper");
            appViewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.anim_fade_in_fast));
            AppViewFlipper appViewFlipper2 = getBinding().f16416h;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.contactSyncViewFlipper");
            appViewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.anim_fade_out_fast));
        } else {
            int i2 = this.displayedChildIndex;
            if (iOrdinal > i2 || z2) {
                AppViewFlipper appViewFlipper3 = getBinding().f16416h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.contactSyncViewFlipper");
                appViewFlipper3.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_open_in));
                AppViewFlipper appViewFlipper4 = getBinding().f16416h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.contactSyncViewFlipper");
                appViewFlipper4.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_open_out));
            } else if (iOrdinal < i2) {
                AppViewFlipper appViewFlipper5 = getBinding().f16416h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper5, "binding.contactSyncViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().f16416h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper6, "binding.contactSyncViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().f16416h;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper7, "binding.contactSyncViewFlipper");
        appViewFlipper7.setDisplayedChild(iOrdinal);
        this.displayedChildIndex = iOrdinal;
        getAppLogger().m8371a(null);
    }

    private final WidgetContactSyncBinding getBinding() {
        return (WidgetContactSyncBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetContactSyncViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.MaybeProceedFromLanding.INSTANCE)) {
            if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, false)) {
                getViewModel().onLandingNext();
                return;
            }
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.PermissionsNeeded.INSTANCE)) {
            requestContactsPermissions();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.ContactsEnabled.INSTANCE)) {
            getViewModel().onContactsFetched(ContactsProviderUtils.INSTANCE.getAllContactPhoneNumbers(requireContext()));
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.RateLimited.INSTANCE)) {
            AppToast.m168f(this, FormatUtils.m219k(this, C5419R.string.contact_sync_failed_alert_title, new Object[0], null, 4), 1);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.UploadFailed.INSTANCE)) {
            AppToast.m168f(this, FormatUtils.m219k(this, C5419R.string.contact_sync_failed_alert_message, new Object[0], null, 4), 1);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.ContactsEnableFailed.INSTANCE)) {
            AppToast.m168f(this, FormatUtils.m219k(this, C5419R.string.contact_sync_failed_alert_title, new Object[0], null, 4), 1);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.AddFriendsFailed.INSTANCE)) {
            AddFriendsFailed.Companion companion = AddFriendsFailed.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager).setOnClose(new WidgetContactSync4(this));
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.AddFriendsFailedPartial.INSTANCE)) {
            AddFriendsFailed.Companion companion2 = AddFriendsFailed.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion2.show(parentFragmentManager2).setOnClose(new WidgetContactSync5(this));
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.PhoneInvalid.INSTANCE)) {
            AppToast.m172j(this, FormatUtils.m219k(this, C5419R.string.phone_invalid, new Object[0], null, 4), 0, 4);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.VerificationCodeInvalid.INSTANCE)) {
            AppToast.m172j(this, FormatUtils.m219k(this, C5419R.string.application_entitlement_code_redemption_invalid, new Object[0], null, 4), 0, 4);
        } else if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.VerificationFailed.INSTANCE)) {
            AppToast.m172j(this, FormatUtils.m219k(this, C5419R.string.phone_failed_to_add, new Object[0], null, 4), 0, 4);
        } else if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.Completed.INSTANCE)) {
            requireAppActivity().finish();
        }
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f16410b.f967b.getTextOrEmpty();
        MaterialButton materialButton = getBinding().f16410b.f968c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.contactSyncAddPh…e.contactSyncAddPhoneNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && StringsJVM.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.Companion companion = WidgetCaptcha.INSTANCE;
        Context contextRequireContext = requireContext();
        ActivityResultLauncher<Intent> activityResultLauncher = this.captchaLauncher;
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncher, _Collections.toMutableList((Collection) response.getMessages().keySet()), error);
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
            Intrinsics3.checkNotNull(str);
            String ownName = contactsProviderUtils.getOwnName(contextRequireContext, str);
            if (ownName != null) {
                getBinding().f16414f.f1013b.setText(ownName);
                TextView textView = getBinding().f16414f.f1016e;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.contactSyncName.contactSyncNamePrefillHint");
                textView.setVisibility(0);
            }
        }
    }

    private final void requestContactsPermissions() {
        if (!ContactsProviderUtils.INSTANCE.hasContactPermissions(requireContext())) {
            AnalyticsTracker.INSTANCE.permissionsRequested("contacts");
            getViewModel().requestingPermissions();
        }
        requestContacts(new C82421(), new C82432());
    }

    private final void submitPhoneNumber(CaptchaHelper.CaptchaPayload captchaPayload) {
        getViewModel().onPhoneNumberSubmitted(getBinding().f16410b.f967b.getTextOrEmpty(), captchaPayload);
    }

    public static /* synthetic */ void submitPhoneNumber$default(WidgetContactSync widgetContactSync, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetContactSync.submitPhoneNumber(captchaPayload);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f16411c.f1041b;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "it");
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = (ContactSyncFriendSuggestionListAdapter) companion.configure(new ContactSyncFriendSuggestionListAdapter(recyclerView));
        this.friendSuggestionsAdapter = contactSyncFriendSuggestionListAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setOnClickFriendSuggestion(new C82392());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetContactSync.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C82401(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetContactSync.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C82412(), 62, (Object) null);
    }
}
