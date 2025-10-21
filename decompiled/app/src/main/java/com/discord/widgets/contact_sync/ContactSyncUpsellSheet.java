package com.discord.widgets.contact_sync;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.ContactSyncUpsellSheetBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.contact_sync.ContactSyncPermissionsSheet;
import com.discord.widgets.contact_sync.WidgetContactSync;
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

/* compiled from: ContactSyncUpsellSheet.kt */
/* loaded from: classes2.dex */
public final class ContactSyncUpsellSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(ContactSyncUpsellSheet.class, "binding", "getBinding()Lcom/discord/databinding/ContactSyncUpsellSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: ContactSyncUpsellSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ContactSyncUpsellSheet show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            ContactSyncUpsellSheet contactSyncUpsellSheet = new ContactSyncUpsellSheet();
            contactSyncUpsellSheet.show(fragmentManager, ContactSyncUpsellSheet.class.getSimpleName());
            return contactSyncUpsellSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ContactSyncUpsellSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ boolean $discoverable;

        public AnonymousClass1(boolean z2) {
            this.$discoverable = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetContactSyncViewModel widgetContactSyncViewModelAccess$getViewModel$p = ContactSyncUpsellSheet.access$getViewModel$p(ContactSyncUpsellSheet.this);
            boolean z2 = this.$discoverable;
            widgetContactSyncViewModelAccess$getViewModel$p.onPermissionsToggle(!z2, !z2);
        }
    }

    /* compiled from: ContactSyncUpsellSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* compiled from: ContactSyncUpsellSheet.kt */
        /* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

            /* compiled from: ContactSyncUpsellSheet.kt */
            /* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02861 extends Lambda implements Function1<View, Unit> {
                public C02861() {
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
                    AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Contact Sync Learn More", null, null, null, null, 30, null));
                    ContactSyncPermissionsSheet.Companion companion = ContactSyncPermissionsSheet.INSTANCE;
                    FragmentManager parentFragmentManager = ContactSyncUpsellSheet.this.getParentFragmentManager();
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
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(ContactSyncUpsellSheet.this.getContext(), R.color.link)), false, null, new C02861(), 4, null));
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
            renderContext.a("learnMoreHook", new AnonymousClass1());
        }
    }

    /* compiled from: ContactSyncUpsellSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ContactSyncUpsellSheet.access$getViewModel$p(ContactSyncUpsellSheet.this).skip();
            ContactSyncUpsellSheet.this.dismiss();
        }
    }

    /* compiled from: ContactSyncUpsellSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ WidgetContactSyncViewModel.ViewState $viewState;

        public AnonymousClass4(WidgetContactSyncViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ContactSyncUpsellSheet.this.dismiss();
            WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, outline.x(view, "it", "it.context"), null, true, this.$viewState.getAllowPhone(), this.$viewState.getAllowEmail(), 2, null);
        }
    }

    /* compiled from: ContactSyncUpsellSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$onResume$1, reason: invalid class name */
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
            ContactSyncUpsellSheet.access$configureUI(ContactSyncUpsellSheet.this, viewState);
        }
    }

    public ContactSyncUpsellSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, ContactSyncUpsellSheet2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new ContactSyncUpsellSheet$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(ContactSyncUpsellSheet3.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(ContactSyncUpsellSheet contactSyncUpsellSheet, WidgetContactSyncViewModel.ViewState viewState) {
        contactSyncUpsellSheet.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetContactSyncViewModel access$getViewModel$p(ContactSyncUpsellSheet contactSyncUpsellSheet) {
        return contactSyncUpsellSheet.getViewModel();
    }

    private final void configureUI(WidgetContactSyncViewModel.ViewState viewState) {
        boolean z2 = viewState.getAllowPhone() || viewState.getAllowEmail();
        CheckedSetting checkedSetting = getBinding().d.c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncUpsel…ontactSyncDiscoveryToggle");
        checkedSetting.setChecked(z2);
        getBinding().d.c.e(new AnonymousClass1(z2));
        LinkifiedTextView linkifiedTextView = getBinding().d.f171b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncUpsel…contactSyncDiscoveryInfo2");
        FormatUtils.m(linkifiedTextView, R.string.contact_sync_learn_more, new Object[0], new AnonymousClass2());
        getBinding().c.setOnClickListener(new AnonymousClass3());
        getBinding().f2093b.setOnClickListener(new AnonymousClass4(viewState));
    }

    private final ContactSyncUpsellSheetBinding getBinding() {
        return (ContactSyncUpsellSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.contact_sync_upsell_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        getViewModel().dismissUpsell();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), ContactSyncUpsellSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
    }
}
