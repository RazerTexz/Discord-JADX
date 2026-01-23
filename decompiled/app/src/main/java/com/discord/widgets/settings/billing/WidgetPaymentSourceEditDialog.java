package com.discord.widgets.settings.billing;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetPaymentSourceEditDialogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelPaymentSource2;
import com.discord.models.domain.billing.ModelBillingAddress;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.billing.PaymentSourceAdapter;
import com.discord.widgets.settings.billing.SettingsBillingViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.SelectorDialog;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog extends AppDialog {
    private static final String ARG_PAYMENT_SOURCE_ID = "ARG_PAYMENT_SOURCE_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: caProvinces$delegate, reason: from kotlin metadata */
    private final Lazy caProvinces;

    /* JADX INFO: renamed from: paymentSourceId$delegate, reason: from kotlin metadata */
    private final Lazy paymentSourceId;

    /* JADX INFO: renamed from: usStates$delegate, reason: from kotlin metadata */
    private final Lazy usStates;
    private ValidationManager validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetPaymentSourceEditDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPaymentSourceEditDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getTextOrEmpty(Companion companion, TextInputLayout textInputLayout) {
            return companion.getTextOrEmpty(textInputLayout);
        }

        private final String getTextOrEmpty(TextInputLayout textInputLayout) {
            Editable text;
            EditText editText = textInputLayout.getEditText();
            String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
            return string != null ? string : "";
        }

        public final void launch(FragmentManager fragmentManager, String paymentSourceId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(paymentSourceId, "paymentSourceId");
            WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = new WidgetPaymentSourceEditDialog();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetPaymentSourceEditDialog.ARG_PAYMENT_SOURCE_ID, paymentSourceId);
            widgetPaymentSourceEditDialog.setArguments(bundle);
            widgetPaymentSourceEditDialog.show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final /* data */ class StateEntry {
        private final String label;
        private final String value;

        public StateEntry(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str, "label");
            Intrinsics3.checkNotNullParameter(str2, "value");
            this.label = str;
            this.value = str2;
        }

        public static /* synthetic */ StateEntry copy$default(StateEntry stateEntry, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stateEntry.label;
            }
            if ((i & 2) != 0) {
                str2 = stateEntry.value;
            }
            return stateEntry.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final StateEntry copy(String label, String value) {
            Intrinsics3.checkNotNullParameter(label, "label");
            Intrinsics3.checkNotNullParameter(value, "value");
            return new StateEntry(label, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StateEntry)) {
                return false;
            }
            StateEntry stateEntry = (StateEntry) other;
            return Intrinsics3.areEqual(this.label, stateEntry.label) && Intrinsics3.areEqual(this.value, stateEntry.value);
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getValue() {
            return this.value;
        }

        public int hashCode() {
            String str = this.label;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.value;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StateEntry(label=");
            sbM833U.append(this.label);
            sbM833U.append(", value=");
            return outline.m822J(sbM833U, this.value, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$1 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98071 extends Lambda implements Function1<Void, Unit> {
        public C98071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.m171i(WidgetPaymentSourceEditDialog.this, C5419R.string.payment_source_deleted, 0, 4);
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$2 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98082 extends Lambda implements Function1<Error, Unit> {
        public C98082() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).f17351d.setIsLoading(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$3 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98093 extends Lambda implements Function0<Unit> {
        public C98093() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).f17351d.setIsLoading(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$2 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class ViewOnClickListenerC98102 implements View.OnClickListener {
        public ViewOnClickListenerC98102() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetPaymentSourceEditDialog.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.m219k(WidgetPaymentSourceEditDialog.this, C5419R.string.payment_source_delete, new Object[0], null, 4), FormatUtils.m219k(WidgetPaymentSourceEditDialog.this, C5419R.string.payment_source_delete_disabled_tooltip, new Object[0], null, 4), FormatUtils.m219k(WidgetPaymentSourceEditDialog.this, C5419R.string.okay, new Object[0], null, 4), "", null, null, null, null, null, null, null, 0, null, 16352, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$3 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class ViewOnClickListenerC98113 implements View.OnClickListener {
        public final /* synthetic */ ModelPaymentSource $paymentSource;

        public ViewOnClickListenerC98113(ModelPaymentSource modelPaymentSource) {
            this.$paymentSource = modelPaymentSource;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPaymentSourceEditDialog.access$deletePaymentSource(WidgetPaymentSourceEditDialog.this, this.$paymentSource);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$4 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class ViewOnClickListenerC98124 implements View.OnClickListener {
        public final /* synthetic */ ModelPaymentSource $paymentSource;

        public ViewOnClickListenerC98124(ModelPaymentSource modelPaymentSource) {
            this.$paymentSource = modelPaymentSource;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPaymentSourceEditDialog.access$updatePaymentSource(WidgetPaymentSourceEditDialog.this, this.$paymentSource);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$5 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98135 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C98135(StateEntry[] stateEntryArr) {
            super(1);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = WidgetPaymentSourceEditDialog.this;
            StateEntry[] stateEntryArr = this.$states;
            Intrinsics3.checkNotNullExpressionValue(stateEntryArr, "states");
            WidgetPaymentSourceEditDialog.access$selectState(widgetPaymentSourceEditDialog, stateEntryArr);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$6 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98146 extends Lambda implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C98146(StateEntry[] stateEntryArr) {
            super(3);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(textView, "<anonymous parameter 0>");
            if (i != 2 && i != 6) {
                return false;
            }
            WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = WidgetPaymentSourceEditDialog.this;
            StateEntry[] stateEntryArr = this.$states;
            Intrinsics3.checkNotNullExpressionValue(stateEntryArr, "states");
            WidgetPaymentSourceEditDialog.access$selectState(widgetPaymentSourceEditDialog, stateEntryArr);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98151<T, R> implements Func1<SettingsBillingViewModel.ViewState.Loaded, List<? extends PaymentSourceAdapter.PaymentSourceItem>> {
        public static final C98151 INSTANCE = new C98151();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<? extends PaymentSourceAdapter.PaymentSourceItem> call(SettingsBillingViewModel.ViewState.Loaded loaded) {
            return call2(loaded);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final List<PaymentSourceAdapter.PaymentSourceItem> call2(SettingsBillingViewModel.ViewState.Loaded loaded) {
            List<PaymentSourceAdapter.Item> paymentSourceItems = loaded.getPaymentSourceItems();
            ArrayList arrayList = new ArrayList();
            for (PaymentSourceAdapter.Item item : paymentSourceItems) {
                if (!(item instanceof PaymentSourceAdapter.PaymentSourceItem)) {
                    item = null;
                }
                PaymentSourceAdapter.PaymentSourceItem paymentSourceItem = (PaymentSourceAdapter.PaymentSourceItem) item;
                if (paymentSourceItem != null) {
                    arrayList.add(paymentSourceItem);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98162<T, R> implements Func1<List<? extends PaymentSourceAdapter.PaymentSourceItem>, PaymentSourceAdapter.PaymentSourceItem> {
        public C98162() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ PaymentSourceAdapter.PaymentSourceItem call(List<? extends PaymentSourceAdapter.PaymentSourceItem> list) {
            return call2((List<PaymentSourceAdapter.PaymentSourceItem>) list);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final PaymentSourceAdapter.PaymentSourceItem call2(List<PaymentSourceAdapter.PaymentSourceItem> list) {
            T next;
            Intrinsics3.checkNotNullExpressionValue(list, "paymentSources");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                if (Intrinsics3.areEqual(((PaymentSourceAdapter.PaymentSourceItem) next).getPaymentSource().getId(), WidgetPaymentSourceEditDialog.access$getPaymentSourceId$p(WidgetPaymentSourceEditDialog.this))) {
                    break;
                }
            }
            return next;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98173 extends Lambda implements Function1<PaymentSourceAdapter.PaymentSourceItem, Unit> {
        public C98173() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
            invoke2(paymentSourceItem);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
            if (paymentSourceItem == null) {
                WidgetPaymentSourceEditDialog.this.dismiss();
            } else {
                WidgetPaymentSourceEditDialog.access$initPaymentSourceInfo(WidgetPaymentSourceEditDialog.this, paymentSourceItem);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class ViewOnClickListenerC98184 implements View.OnClickListener {
        public ViewOnClickListenerC98184() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class ViewOnClickListenerC98195 implements View.OnClickListener {
        public ViewOnClickListenerC98195() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$selectState$2 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98202 extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C98202(StateEntry[] stateEntryArr) {
            super(1);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            TextInputLayout textInputLayout = WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).f17361n;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditState");
            ViewExtensions.setText(textInputLayout, this.$states[i].getLabel());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$1 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98211 extends Lambda implements Function1<Void, Unit> {
        public C98211() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.m171i(WidgetPaymentSourceEditDialog.this, C5419R.string.payment_source_edit_saved, 0, 4);
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$2 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98222 extends Lambda implements Function1<Error, Unit> {
        public C98222() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetPaymentSourceEditDialog.this.handleError(error);
            WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).f17351d.setIsLoading(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$3 */
    /* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final class C98233 extends Lambda implements Function0<Unit> {
        public C98233() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).f17351d.setIsLoading(false);
        }
    }

    public WidgetPaymentSourceEditDialog() {
        super(C5419R.layout.widget_payment_source_edit_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPaymentSourceEditDialog2.INSTANCE, null, 2, null);
        this.paymentSourceId = LazyJVM.lazy(new WidgetPaymentSourceEditDialog4(this));
        WidgetPaymentSourceEditDialog6 widgetPaymentSourceEditDialog6 = WidgetPaymentSourceEditDialog6.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsBillingViewModel.class), new C9806x57d38bb0(appViewModelDelegates3), new AppViewModelDelegates5(widgetPaymentSourceEditDialog6));
        this.usStates = LazyJVM.lazy(new WidgetPaymentSourceEditDialog5(this));
        this.caProvinces = LazyJVM.lazy(new WidgetPaymentSourceEditDialog3(this));
    }

    public static final /* synthetic */ void access$deletePaymentSource(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, ModelPaymentSource modelPaymentSource) {
        widgetPaymentSourceEditDialog.deletePaymentSource(modelPaymentSource);
    }

    public static final /* synthetic */ WidgetPaymentSourceEditDialogBinding access$getBinding$p(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        return widgetPaymentSourceEditDialog.getBinding();
    }

    public static final /* synthetic */ String access$getPaymentSourceId$p(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        return widgetPaymentSourceEditDialog.getPaymentSourceId();
    }

    public static final /* synthetic */ void access$initPaymentSourceInfo(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
        widgetPaymentSourceEditDialog.initPaymentSourceInfo(paymentSourceItem);
    }

    public static final /* synthetic */ void access$selectState(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, StateEntry[] stateEntryArr) {
        widgetPaymentSourceEditDialog.selectState(stateEntryArr);
    }

    public static final /* synthetic */ void access$updatePaymentSource(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, ModelPaymentSource modelPaymentSource) {
        widgetPaymentSourceEditDialog.updatePaymentSource(modelPaymentSource);
    }

    private final void deletePaymentSource(ModelPaymentSource paymentSource) {
        getBinding().f17351d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deletePaymentSource(paymentSource.getId()), false, 1, null), this, null, 2, null), WidgetPaymentSourceEditDialog.class, requireContext(), (Function1) null, new C98082(), new C98093(), (Function0) null, new C98071(), 36, (Object) null);
    }

    private final WidgetPaymentSourceEditDialogBinding getBinding() {
        return (WidgetPaymentSourceEditDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final StateEntry[] getCaProvinces() {
        return (StateEntry[]) this.caProvinces.getValue();
    }

    private static /* synthetic */ void getCaProvinces$annotations() {
    }

    private final String getPaymentSourceId() {
        return (String) this.paymentSourceId.getValue();
    }

    private final StateEntry[] getStatesFor(ModelPaymentSource paymentSource) {
        String country = paymentSource.getBillingAddress().getCountry();
        int iHashCode = country.hashCode();
        if (iHashCode != 2142) {
            if (iHashCode == 2718 && country.equals("US")) {
                return getUsStates();
            }
        } else if (country.equals("CA")) {
            return getCaProvinces();
        }
        return new StateEntry[0];
    }

    private final StateEntry[] getUsStates() {
        return (StateEntry[]) this.usStates.getValue();
    }

    private static /* synthetic */ void getUsStates$annotations() {
    }

    private final SettingsBillingViewModel getViewModel() {
        return (SettingsBillingViewModel) this.viewModel.getValue();
    }

    private final void initPaymentSourceInfo(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
        StateEntry stateEntry;
        String state;
        initValidator(paymentSourceItem);
        ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
        boolean isPremium = paymentSourceItem.getIsPremium();
        getBinding().f17362o.bind(paymentSource, isPremium);
        TextView textView = getBinding().f17358k;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceEditHelp");
        textView.setText(paymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal ? FormatUtils.m219k(this, C5419R.string.payment_source_edit_help_paypal, new Object[]{"https://www.paypal.com"}, null, 4) : FormatUtils.m219k(this, C5419R.string.payment_source_edit_help_card, new Object[0], null, 4));
        StateEntry[] statesFor = getStatesFor(paymentSource);
        ModelBillingAddress billingAddress = paymentSource.getBillingAddress();
        TextInputLayout textInputLayout = getBinding().f17359l;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditName");
        ViewExtensions.setText(textInputLayout, billingAddress.getName());
        TextInputLayout textInputLayout2 = getBinding().f17352e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditAddress1");
        ViewExtensions.setText(textInputLayout2, billingAddress.getLine_1());
        TextInputLayout textInputLayout3 = getBinding().f17353f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditAddress2");
        ViewExtensions.setText(textInputLayout3, billingAddress.getLine_2());
        TextInputLayout textInputLayout4 = getBinding().f17354g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditCity");
        ViewExtensions.setText(textInputLayout4, billingAddress.getCity());
        TextInputLayout textInputLayout5 = getBinding().f17360m;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditPostalCode");
        ViewExtensions.setText(textInputLayout5, billingAddress.getPostalCode());
        TextInputLayout textInputLayout6 = getBinding().f17361n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.paymentSourceEditState");
        Intrinsics3.checkNotNullExpressionValue(statesFor, "states");
        int length = statesFor.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stateEntry = null;
                break;
            }
            stateEntry = statesFor[i];
            if (Intrinsics3.areEqual(stateEntry.getValue(), billingAddress.getState())) {
                break;
            } else {
                i++;
            }
        }
        if (stateEntry == null || (state = stateEntry.getLabel()) == null) {
            state = billingAddress.getState();
        }
        ViewExtensions.setText(textInputLayout6, state);
        TextInputLayout textInputLayout7 = getBinding().f17355h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.paymentSourceEditCountry");
        ViewExtensions.setText(textInputLayout7, billingAddress.getCountry());
        CheckBox checkBox = getBinding().f17356i;
        Intrinsics3.checkNotNullExpressionValue(checkBox, "binding.paymentSourceEditDefault");
        checkBox.setChecked(paymentSource.getDefault());
        getBinding().f17351d.setIsLoading(false);
        if (isPremium) {
            getBinding().f17350c.setOnClickListener(new ViewOnClickListenerC98102());
            MaterialButton materialButton = getBinding().f17350c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.dialogDelete");
            materialButton.setAlpha(0.3f);
        } else {
            getBinding().f17350c.setOnClickListener(new ViewOnClickListenerC98113(paymentSource));
        }
        getBinding().f17351d.setOnClickListener(new ViewOnClickListenerC98124(paymentSource));
        if (Intrinsics3.areEqual(paymentSource.getBillingAddress().getCountry(), "CA")) {
            TextInputLayout textInputLayout8 = getBinding().f17361n;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout8, "binding.paymentSourceEditState");
            textInputLayout8.setHint(FormatUtils.m219k(this, C5419R.string.billing_address_province, new Object[0], null, 4));
            TextInputLayout textInputLayout9 = getBinding().f17360m;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout9, "binding.paymentSourceEditPostalCode");
            textInputLayout9.setHint(FormatUtils.m219k(this, C5419R.string.billing_address_postal_code, new Object[0], null, 4));
        }
        if (!(statesFor.length == 0)) {
            TextInputLayout textInputLayout10 = getBinding().f17361n;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout10, "binding.paymentSourceEditState");
            ViewExtensions.setOnEditTextClickListener(textInputLayout10, new C98135(statesFor));
            TextInputLayout textInputLayout11 = getBinding().f17361n;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout11, "binding.paymentSourceEditState");
            ViewExtensions.setOnEditorActionListener(textInputLayout11, new C98146(statesFor));
            return;
        }
        TextInputLayout textInputLayout12 = getBinding().f17361n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout12, "binding.paymentSourceEditState");
        EditText editText = textInputLayout12.getEditText();
        if (editText != null) {
            editText.setInputType(1);
        }
        TextInputLayout textInputLayout13 = getBinding().f17361n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout13, "binding.paymentSourceEditState");
        EditText editText2 = textInputLayout13.getEditText();
        if (editText2 != null) {
            editText2.setFocusableInTouchMode(true);
        }
    }

    private final void initValidator(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
        ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
        Input[] inputArr = new Input[5];
        TextInputLayout textInputLayout = getBinding().f17359l;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditName");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        inputArr[0] = new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, companion.createRequiredInputValidator(C5419R.string.billing_address_name_error_required));
        TextInputLayout textInputLayout2 = getBinding().f17352e;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditAddress1");
        inputArr[1] = new Input.TextInputLayoutInput("line_1", textInputLayout2, companion.createRequiredInputValidator(C5419R.string.billing_address_address_error_required));
        TextInputLayout textInputLayout3 = getBinding().f17354g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditCity");
        inputArr[2] = new Input.TextInputLayoutInput("city", textInputLayout3, companion.createRequiredInputValidator(C5419R.string.billing_address_city_error_required));
        TextInputLayout textInputLayout4 = getBinding().f17361n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditState");
        InputValidator[] inputValidatorArr = new InputValidator[1];
        inputValidatorArr[0] = companion.createRequiredInputValidator(Intrinsics3.areEqual(paymentSource.getBillingAddress().getCountry(), "CA") ? C5419R.string.billing_address_province_error_required : C5419R.string.billing_address_state_error_required);
        inputArr[3] = new Input.TextInputLayoutInput("state", textInputLayout4, inputValidatorArr);
        TextInputLayout textInputLayout5 = getBinding().f17360m;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditPostalCode");
        inputArr[4] = new Input.TextInputLayoutInput("postal_code", textInputLayout5, companion.createRequiredInputValidator(C5419R.string.billing_address_postal_code_error_required));
        this.validationManager = new ValidationManager(inputArr);
    }

    private final void selectState(StateEntry[] states) {
        SelectorDialog.Companion companion = SelectorDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceM219k = FormatUtils.m219k(this, C5419R.string.payment_source_edit_select_state, new Object[0], null, 4);
        ArrayList arrayList = new ArrayList(states.length);
        for (StateEntry stateEntry : states) {
            arrayList.add(stateEntry.getLabel());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        companion.m142a(parentFragmentManager, charSequenceM219k, (CharSequence[]) array, new C98202(states));
        getBinding().f17360m.requestFocus();
    }

    private final void updatePaymentSource(ModelPaymentSource paymentSource) {
        StateEntry stateEntry;
        String value;
        Companion companion = INSTANCE;
        TextInputLayout textInputLayout = getBinding().f17361n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditState");
        String strAccess$getTextOrEmpty = Companion.access$getTextOrEmpty(companion, textInputLayout);
        StateEntry[] statesFor = getStatesFor(paymentSource);
        Intrinsics3.checkNotNullExpressionValue(statesFor, "getStatesFor(paymentSource)");
        int length = statesFor.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stateEntry = null;
                break;
            }
            stateEntry = statesFor[i];
            if (StringsJVM.equals(stateEntry.getLabel(), strAccess$getTextOrEmpty, true)) {
                break;
            } else {
                i++;
            }
        }
        String str = (stateEntry == null || (value = stateEntry.getValue()) == null) ? strAccess$getTextOrEmpty : value;
        ValidationManager validationManager = this.validationManager;
        if (validationManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("validationManager");
        }
        if (ValidationManager.validate$default(validationManager, false, 1, null)) {
            Companion companion2 = INSTANCE;
            TextInputLayout textInputLayout2 = getBinding().f17359l;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditName");
            String strAccess$getTextOrEmpty2 = Companion.access$getTextOrEmpty(companion2, textInputLayout2);
            TextInputLayout textInputLayout3 = getBinding().f17352e;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditAddress1");
            String strAccess$getTextOrEmpty3 = Companion.access$getTextOrEmpty(companion2, textInputLayout3);
            TextInputLayout textInputLayout4 = getBinding().f17353f;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditAddress2");
            String strAccess$getTextOrEmpty4 = Companion.access$getTextOrEmpty(companion2, textInputLayout4);
            TextInputLayout textInputLayout5 = getBinding().f17354g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditCity");
            String strAccess$getTextOrEmpty5 = Companion.access$getTextOrEmpty(companion2, textInputLayout5);
            TextInputLayout textInputLayout6 = getBinding().f17360m;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout6, "binding.paymentSourceEditPostalCode");
            String strAccess$getTextOrEmpty6 = Companion.access$getTextOrEmpty(companion2, textInputLayout6);
            TextInputLayout textInputLayout7 = getBinding().f17355h;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout7, "binding.paymentSourceEditCountry");
            ModelBillingAddress modelBillingAddress = new ModelBillingAddress(strAccess$getTextOrEmpty2, strAccess$getTextOrEmpty3, strAccess$getTextOrEmpty4, strAccess$getTextOrEmpty5, str, Companion.access$getTextOrEmpty(companion2, textInputLayout7), strAccess$getTextOrEmpty6);
            CheckBox checkBox = getBinding().f17356i;
            Intrinsics3.checkNotNullExpressionValue(checkBox, "binding.paymentSourceEditDefault");
            ModelPaymentSource2 modelPaymentSource2 = new ModelPaymentSource2(modelBillingAddress, checkBox.isChecked());
            TextView textView = getBinding().f17357j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceEditError");
            textView.setVisibility(8);
            getBinding().f17351d.setIsLoading(true);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePaymentSource(paymentSource.getId(), modelPaymentSource2), false, 1, null), this, null, 2, null), WidgetPaymentSourceEditDialog.class, (Context) null, (Function1) null, new C98222(), new C98233(), (Function0) null, new C98211(), 38, (Object) null);
        }
    }

    @MainThread
    public final void handleError(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        TextView textView = getBinding().f17357j;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceEditError");
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        ViewExtensions.setTextAndVisibilityBy(textView, response.getMessage());
        ValidationManager validationManager = this.validationManager;
        if (validationManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("validationManager");
        }
        Error.Response response2 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
        Map<String, List<String>> messages = response2.getMessages();
        Intrinsics3.checkNotNullExpressionValue(messages, "error.response.messages");
        validationManager.setErrors(messages);
        Error.Response response3 = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response3, "error.response");
        String message = response3.getMessage();
        if (message != null) {
            if (message.length() > 0) {
                AppToast.m170h(getContext(), message, 0, null, 8);
            }
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        if (!AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            window.getAttributes().windowAnimations = 2131952425;
        }
        window.setLayout(-1, -1);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setSoftInputMode(16);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<R> observableM11083G = getViewModel().observeViewState().m11118y(WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$1.INSTANCE).m11083G(WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        Observable observableM11100Z = observableM11083G.m11083G(C98151.INSTANCE).m11083G(new C98162()).m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "viewModel\n        .obser…       }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11100Z, this, null, 2, null), WidgetPaymentSourceEditDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C98173(), 62, (Object) null);
        getBinding().f17349b.setNavigationOnClickListener(new ViewOnClickListenerC98184());
        getBinding().f17351d.setOnClickListener(new ViewOnClickListenerC98195());
    }
}
