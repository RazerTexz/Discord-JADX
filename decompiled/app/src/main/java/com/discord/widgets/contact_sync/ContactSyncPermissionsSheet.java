package com.discord.widgets.contact_sync;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.ContactSyncPermissionsSheetBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: ContactSyncPermissionsSheet.kt */
/* loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(ContactSyncPermissionsSheet.class, "binding", "getBinding()Lcom/discord/databinding/ContactSyncPermissionsSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: ContactSyncPermissionsSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ContactSyncPermissionsSheet show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            ContactSyncPermissionsSheet contactSyncPermissionsSheet = new ContactSyncPermissionsSheet();
            contactSyncPermissionsSheet.show(fragmentManager, ContactSyncPermissionsSheet.class.getSimpleName());
            return contactSyncPermissionsSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* compiled from: ContactSyncPermissionsSheet.kt */
        /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02841 extends Lambda implements Function1<Hook, Unit> {

            /* compiled from: ContactSyncPermissionsSheet.kt */
            /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02851 extends Lambda implements Function1<View, Unit> {
                public static final C02851 INSTANCE = new C02851();

                public C02851() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics3.checkNotNullParameter(view, "it");
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context = view.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                    UriHandler.handle$default(uriHandler, context, AppHelpDesk.a.a(360061878534L, null), false, false, null, 28, null);
                }
            }

            public C02841() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(ContactSyncPermissionsSheet.this.getContext(), R.color.link)), false, null, C02851.INSTANCE, 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("learnMoreHook", new C02841());
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ boolean $discoverable;

        public AnonymousClass2(boolean z2) {
            this.$discoverable = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSyncViewModel widgetContactSyncViewModelAccess$getViewModel$p = ContactSyncPermissionsSheet.access$getViewModel$p(ContactSyncPermissionsSheet.this);
            boolean z2 = this.$discoverable;
            widgetContactSyncViewModelAccess$getViewModel$p.onPermissionsToggle(!z2, !z2);
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ WidgetContactSyncViewModel.ViewState $viewState;

        public AnonymousClass3(WidgetContactSyncViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ContactSyncPermissionsSheet.access$getViewModel$p(ContactSyncPermissionsSheet.this).onPermissionsToggle(!this.$viewState.getAllowPhone(), this.$viewState.getAllowEmail());
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ WidgetContactSyncViewModel.ViewState $viewState;

        public AnonymousClass4(WidgetContactSyncViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ContactSyncPermissionsSheet.access$getViewModel$p(ContactSyncPermissionsSheet.this).onPermissionsToggle(this.$viewState.getAllowPhone(), !this.$viewState.getAllowEmail());
        }
    }

    /* compiled from: ContactSyncPermissionsSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetContactSyncViewModel.ViewState, Unit> {
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
            Intrinsics3.checkNotNullParameter(viewState, "it");
            ContactSyncPermissionsSheet.access$configureUI(ContactSyncPermissionsSheet.this, viewState);
        }
    }

    public ContactSyncPermissionsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, ContactSyncPermissionsSheet2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new ContactSyncPermissionsSheet$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new ContactSyncPermissionsSheet3(this)));
    }

    public static final /* synthetic */ void access$configureUI(ContactSyncPermissionsSheet contactSyncPermissionsSheet, WidgetContactSyncViewModel.ViewState viewState) {
        contactSyncPermissionsSheet.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetContactSyncViewModel access$getViewModel$p(ContactSyncPermissionsSheet contactSyncPermissionsSheet) {
        return contactSyncPermissionsSheet.getViewModel();
    }

    private final void configureUI(WidgetContactSyncViewModel.ViewState viewState) {
        boolean z2 = viewState.getAllowPhone() || viewState.getAllowEmail();
        CheckedSetting checkedSetting = getBinding().f2092b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncPermissionsDiscoverableToggle");
        checkedSetting.setChecked(z2);
        CheckedSetting checkedSetting2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncPermissionsPhoneToggle");
        checkedSetting2.setChecked(viewState.getAllowPhone());
        CheckedSetting checkedSetting3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncPermissionsEmailToggle");
        checkedSetting3.setChecked(viewState.getAllowEmail());
        LinkifiedTextView linkifiedTextView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncPermissionsLearnMore");
        FormatUtils.m(linkifiedTextView, R.string.contact_sync_learn_more, new Object[0], new AnonymousClass1());
        getBinding().f2092b.e(new AnonymousClass2(z2));
        getBinding().e.e(new AnonymousClass3(viewState));
        getBinding().c.e(new AnonymousClass4(viewState));
    }

    private final ContactSyncPermissionsSheetBinding getBinding() {
        return (ContactSyncPermissionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.contact_sync_permissions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), ContactSyncPermissionsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
