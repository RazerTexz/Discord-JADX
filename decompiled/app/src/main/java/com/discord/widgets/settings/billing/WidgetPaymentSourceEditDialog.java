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
import b.a.a.n;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetPaymentSourceEditDialogBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.PatchPaymentSourceRaw;
import com.discord.models.domain.billing.ModelBillingAddress;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.billing.PaymentSourceAdapter;
import com.discord.widgets.settings.billing.SettingsBillingViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
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
import rx.Observable;

/* compiled from: WidgetPaymentSourceEditDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog extends AppDialog {
    private static final String ARG_PAYMENT_SOURCE_ID = "ARG_PAYMENT_SOURCE_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: caProvinces$delegate, reason: from kotlin metadata */
    private final Lazy caProvinces;

    /* renamed from: paymentSourceId$delegate, reason: from kotlin metadata */
    private final Lazy paymentSourceId;

    /* renamed from: usStates$delegate, reason: from kotlin metadata */
    private final Lazy usStates;
    private ValidationManager validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetPaymentSourceEditDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPaymentSourceEditDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
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
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(paymentSourceId, "paymentSourceId");
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

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    public static final /* data */ class StateEntry {
        private final String label;
        private final String value;

        public StateEntry(String str, String str2) {
            m.checkNotNullParameter(str, "label");
            m.checkNotNullParameter(str2, "value");
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

        /* renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component2, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final StateEntry copy(String label, String value) {
            m.checkNotNullParameter(label, "label");
            m.checkNotNullParameter(value, "value");
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
            return m.areEqual(this.label, stateEntry.label) && m.areEqual(this.value, stateEntry.value);
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
            StringBuilder sbU = a.U("StateEntry(label=");
            sbU.append(this.label);
            sbU.append(", value=");
            return a.J(sbU, this.value, ")");
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            b.a.d.m.i(WidgetPaymentSourceEditDialog.this, R.string.payment_source_deleted, 0, 4);
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).d.setIsLoading(false);
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$deletePaymentSource$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).d.setIsLoading(false);
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetPaymentSourceEditDialog.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, b.k(WidgetPaymentSourceEditDialog.this, R.string.payment_source_delete, new Object[0], null, 4), b.k(WidgetPaymentSourceEditDialog.this, R.string.payment_source_delete_disabled_tooltip, new Object[0], null, 4), b.k(WidgetPaymentSourceEditDialog.this, R.string.okay, new Object[0], null, 4), "", null, null, null, null, null, null, null, 0, null, 16352, null);
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ ModelPaymentSource $paymentSource;

        public AnonymousClass3(ModelPaymentSource modelPaymentSource) {
            this.$paymentSource = modelPaymentSource;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPaymentSourceEditDialog.access$deletePaymentSource(WidgetPaymentSourceEditDialog.this, this.$paymentSource);
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ModelPaymentSource $paymentSource;

        public AnonymousClass4(ModelPaymentSource modelPaymentSource) {
            this.$paymentSource = modelPaymentSource;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPaymentSourceEditDialog.access$updatePaymentSource(WidgetPaymentSourceEditDialog.this, this.$paymentSource);
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<View, Unit> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(StateEntry[] stateEntryArr) {
            super(1);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "it");
            WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = WidgetPaymentSourceEditDialog.this;
            StateEntry[] stateEntryArr = this.$states;
            m.checkNotNullExpressionValue(stateEntryArr, "states");
            WidgetPaymentSourceEditDialog.access$selectState(widgetPaymentSourceEditDialog, stateEntryArr);
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$initPaymentSourceInfo$6, reason: invalid class name */
    public static final class AnonymousClass6 extends o implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(StateEntry[] stateEntryArr) {
            super(3);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            m.checkNotNullParameter(textView, "<anonymous parameter 0>");
            if (i != 2 && i != 6) {
                return false;
            }
            WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = WidgetPaymentSourceEditDialog.this;
            StateEntry[] stateEntryArr = this.$states;
            m.checkNotNullExpressionValue(stateEntryArr, "states");
            WidgetPaymentSourceEditDialog.access$selectState(widgetPaymentSourceEditDialog, stateEntryArr);
            return true;
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<SettingsBillingViewModel.ViewState.Loaded, List<? extends PaymentSourceAdapter.PaymentSourceItem>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends PaymentSourceAdapter.PaymentSourceItem> call(SettingsBillingViewModel.ViewState.Loaded loaded) {
            return call2(loaded);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
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

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements j0.k.b<List<? extends PaymentSourceAdapter.PaymentSourceItem>, PaymentSourceAdapter.PaymentSourceItem> {
        public AnonymousClass2() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ PaymentSourceAdapter.PaymentSourceItem call(List<? extends PaymentSourceAdapter.PaymentSourceItem> list) {
            return call2((List<PaymentSourceAdapter.PaymentSourceItem>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final PaymentSourceAdapter.PaymentSourceItem call2(List<PaymentSourceAdapter.PaymentSourceItem> list) {
            T next;
            m.checkNotNullExpressionValue(list, "paymentSources");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = (T) null;
                    break;
                }
                next = it.next();
                if (m.areEqual(((PaymentSourceAdapter.PaymentSourceItem) next).getPaymentSource().getId(), WidgetPaymentSourceEditDialog.access$getPaymentSourceId$p(WidgetPaymentSourceEditDialog.this))) {
                    break;
                }
            }
            return next;
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<PaymentSourceAdapter.PaymentSourceItem, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
            invoke2(paymentSourceItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
            if (paymentSourceItem == null) {
                WidgetPaymentSourceEditDialog.this.dismiss();
            } else {
                WidgetPaymentSourceEditDialog.access$initPaymentSourceInfo(WidgetPaymentSourceEditDialog.this, paymentSourceItem);
            }
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$selectState$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Integer, Unit> {
        public final /* synthetic */ StateEntry[] $states;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StateEntry[] stateEntryArr) {
            super(1);
            this.$states = stateEntryArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            TextInputLayout textInputLayout = WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).n;
            m.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditState");
            ViewExtensions.setText(textInputLayout, this.$states[i].getLabel());
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            b.a.d.m.i(WidgetPaymentSourceEditDialog.this, R.string.payment_source_edit_saved, 0, 4);
            WidgetPaymentSourceEditDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetPaymentSourceEditDialog.this.handleError(error);
            WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).d.setIsLoading(false);
        }
    }

    /* compiled from: WidgetPaymentSourceEditDialog.kt */
    /* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$updatePaymentSource$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetPaymentSourceEditDialog.access$getBinding$p(WidgetPaymentSourceEditDialog.this).d.setIsLoading(false);
        }
    }

    public WidgetPaymentSourceEditDialog() {
        super(R.layout.widget_payment_source_edit_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetPaymentSourceEditDialog$binding$2.INSTANCE, null, 2, null);
        this.paymentSourceId = g.lazy(new WidgetPaymentSourceEditDialog$paymentSourceId$2(this));
        WidgetPaymentSourceEditDialog$viewModel$2 widgetPaymentSourceEditDialog$viewModel$2 = WidgetPaymentSourceEditDialog$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SettingsBillingViewModel.class), new WidgetPaymentSourceEditDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetPaymentSourceEditDialog$viewModel$2));
        this.usStates = g.lazy(new WidgetPaymentSourceEditDialog$usStates$2(this));
        this.caProvinces = g.lazy(new WidgetPaymentSourceEditDialog$caProvinces$2(this));
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
        getBinding().d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deletePaymentSource(paymentSource.getId()), false, 1, null), this, null, 2, null), WidgetPaymentSourceEditDialog.class, requireContext(), (Function1) null, new AnonymousClass2(), new AnonymousClass3(), (Function0) null, new AnonymousClass1(), 36, (Object) null);
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
        getBinding().o.bind(paymentSource, isPremium);
        TextView textView = getBinding().k;
        m.checkNotNullExpressionValue(textView, "binding.paymentSourceEditHelp");
        textView.setText(paymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal ? b.k(this, R.string.payment_source_edit_help_paypal, new Object[]{"https://www.paypal.com"}, null, 4) : b.k(this, R.string.payment_source_edit_help_card, new Object[0], null, 4));
        StateEntry[] statesFor = getStatesFor(paymentSource);
        ModelBillingAddress billingAddress = paymentSource.getBillingAddress();
        TextInputLayout textInputLayout = getBinding().l;
        m.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditName");
        ViewExtensions.setText(textInputLayout, billingAddress.getName());
        TextInputLayout textInputLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditAddress1");
        ViewExtensions.setText(textInputLayout2, billingAddress.getLine_1());
        TextInputLayout textInputLayout3 = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditAddress2");
        ViewExtensions.setText(textInputLayout3, billingAddress.getLine_2());
        TextInputLayout textInputLayout4 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditCity");
        ViewExtensions.setText(textInputLayout4, billingAddress.getCity());
        TextInputLayout textInputLayout5 = getBinding().m;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditPostalCode");
        ViewExtensions.setText(textInputLayout5, billingAddress.getPostalCode());
        TextInputLayout textInputLayout6 = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout6, "binding.paymentSourceEditState");
        m.checkNotNullExpressionValue(statesFor, "states");
        int length = statesFor.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stateEntry = null;
                break;
            }
            stateEntry = statesFor[i];
            if (m.areEqual(stateEntry.getValue(), billingAddress.getState())) {
                break;
            } else {
                i++;
            }
        }
        if (stateEntry == null || (state = stateEntry.getLabel()) == null) {
            state = billingAddress.getState();
        }
        ViewExtensions.setText(textInputLayout6, state);
        TextInputLayout textInputLayout7 = getBinding().h;
        m.checkNotNullExpressionValue(textInputLayout7, "binding.paymentSourceEditCountry");
        ViewExtensions.setText(textInputLayout7, billingAddress.getCountry());
        CheckBox checkBox = getBinding().i;
        m.checkNotNullExpressionValue(checkBox, "binding.paymentSourceEditDefault");
        checkBox.setChecked(paymentSource.getDefault());
        getBinding().d.setIsLoading(false);
        if (isPremium) {
            getBinding().c.setOnClickListener(new AnonymousClass2());
            MaterialButton materialButton = getBinding().c;
            m.checkNotNullExpressionValue(materialButton, "binding.dialogDelete");
            materialButton.setAlpha(0.3f);
        } else {
            getBinding().c.setOnClickListener(new AnonymousClass3(paymentSource));
        }
        getBinding().d.setOnClickListener(new AnonymousClass4(paymentSource));
        if (m.areEqual(paymentSource.getBillingAddress().getCountry(), "CA")) {
            TextInputLayout textInputLayout8 = getBinding().n;
            m.checkNotNullExpressionValue(textInputLayout8, "binding.paymentSourceEditState");
            textInputLayout8.setHint(b.k(this, R.string.billing_address_province, new Object[0], null, 4));
            TextInputLayout textInputLayout9 = getBinding().m;
            m.checkNotNullExpressionValue(textInputLayout9, "binding.paymentSourceEditPostalCode");
            textInputLayout9.setHint(b.k(this, R.string.billing_address_postal_code, new Object[0], null, 4));
        }
        if (!(statesFor.length == 0)) {
            TextInputLayout textInputLayout10 = getBinding().n;
            m.checkNotNullExpressionValue(textInputLayout10, "binding.paymentSourceEditState");
            ViewExtensions.setOnEditTextClickListener(textInputLayout10, new AnonymousClass5(statesFor));
            TextInputLayout textInputLayout11 = getBinding().n;
            m.checkNotNullExpressionValue(textInputLayout11, "binding.paymentSourceEditState");
            ViewExtensions.setOnEditorActionListener(textInputLayout11, new AnonymousClass6(statesFor));
            return;
        }
        TextInputLayout textInputLayout12 = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout12, "binding.paymentSourceEditState");
        EditText editText = textInputLayout12.getEditText();
        if (editText != null) {
            editText.setInputType(1);
        }
        TextInputLayout textInputLayout13 = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout13, "binding.paymentSourceEditState");
        EditText editText2 = textInputLayout13.getEditText();
        if (editText2 != null) {
            editText2.setFocusableInTouchMode(true);
        }
    }

    private final void initValidator(PaymentSourceAdapter.PaymentSourceItem paymentSourceItem) {
        ModelPaymentSource paymentSource = paymentSourceItem.getPaymentSource();
        Input[] inputArr = new Input[5];
        TextInputLayout textInputLayout = getBinding().l;
        m.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditName");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        inputArr[0] = new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, companion.createRequiredInputValidator(R.string.billing_address_name_error_required));
        TextInputLayout textInputLayout2 = getBinding().e;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditAddress1");
        inputArr[1] = new Input.TextInputLayoutInput("line_1", textInputLayout2, companion.createRequiredInputValidator(R.string.billing_address_address_error_required));
        TextInputLayout textInputLayout3 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditCity");
        inputArr[2] = new Input.TextInputLayoutInput("city", textInputLayout3, companion.createRequiredInputValidator(R.string.billing_address_city_error_required));
        TextInputLayout textInputLayout4 = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditState");
        InputValidator[] inputValidatorArr = new InputValidator[1];
        inputValidatorArr[0] = companion.createRequiredInputValidator(m.areEqual(paymentSource.getBillingAddress().getCountry(), "CA") ? R.string.billing_address_province_error_required : R.string.billing_address_state_error_required);
        inputArr[3] = new Input.TextInputLayoutInput("state", textInputLayout4, inputValidatorArr);
        TextInputLayout textInputLayout5 = getBinding().m;
        m.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditPostalCode");
        inputArr[4] = new Input.TextInputLayoutInput("postal_code", textInputLayout5, companion.createRequiredInputValidator(R.string.billing_address_postal_code_error_required));
        this.validationManager = new ValidationManager(inputArr);
    }

    private final void selectState(StateEntry[] states) {
        n.Companion companion = n.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        CharSequence charSequenceK = b.k(this, R.string.payment_source_edit_select_state, new Object[0], null, 4);
        ArrayList arrayList = new ArrayList(states.length);
        for (StateEntry stateEntry : states) {
            arrayList.add(stateEntry.getLabel());
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        companion.a(parentFragmentManager, charSequenceK, (CharSequence[]) array, new AnonymousClass2(states));
        getBinding().m.requestFocus();
    }

    private final void updatePaymentSource(ModelPaymentSource paymentSource) {
        StateEntry stateEntry;
        String value;
        Companion companion = INSTANCE;
        TextInputLayout textInputLayout = getBinding().n;
        m.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditState");
        String strAccess$getTextOrEmpty = Companion.access$getTextOrEmpty(companion, textInputLayout);
        StateEntry[] statesFor = getStatesFor(paymentSource);
        m.checkNotNullExpressionValue(statesFor, "getStatesFor(paymentSource)");
        int length = statesFor.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stateEntry = null;
                break;
            }
            stateEntry = statesFor[i];
            if (t.equals(stateEntry.getLabel(), strAccess$getTextOrEmpty, true)) {
                break;
            } else {
                i++;
            }
        }
        String str = (stateEntry == null || (value = stateEntry.getValue()) == null) ? strAccess$getTextOrEmpty : value;
        ValidationManager validationManager = this.validationManager;
        if (validationManager == null) {
            m.throwUninitializedPropertyAccessException("validationManager");
        }
        if (ValidationManager.validate$default(validationManager, false, 1, null)) {
            Companion companion2 = INSTANCE;
            TextInputLayout textInputLayout2 = getBinding().l;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.paymentSourceEditName");
            String strAccess$getTextOrEmpty2 = Companion.access$getTextOrEmpty(companion2, textInputLayout2);
            TextInputLayout textInputLayout3 = getBinding().e;
            m.checkNotNullExpressionValue(textInputLayout3, "binding.paymentSourceEditAddress1");
            String strAccess$getTextOrEmpty3 = Companion.access$getTextOrEmpty(companion2, textInputLayout3);
            TextInputLayout textInputLayout4 = getBinding().f;
            m.checkNotNullExpressionValue(textInputLayout4, "binding.paymentSourceEditAddress2");
            String strAccess$getTextOrEmpty4 = Companion.access$getTextOrEmpty(companion2, textInputLayout4);
            TextInputLayout textInputLayout5 = getBinding().g;
            m.checkNotNullExpressionValue(textInputLayout5, "binding.paymentSourceEditCity");
            String strAccess$getTextOrEmpty5 = Companion.access$getTextOrEmpty(companion2, textInputLayout5);
            TextInputLayout textInputLayout6 = getBinding().m;
            m.checkNotNullExpressionValue(textInputLayout6, "binding.paymentSourceEditPostalCode");
            String strAccess$getTextOrEmpty6 = Companion.access$getTextOrEmpty(companion2, textInputLayout6);
            TextInputLayout textInputLayout7 = getBinding().h;
            m.checkNotNullExpressionValue(textInputLayout7, "binding.paymentSourceEditCountry");
            ModelBillingAddress modelBillingAddress = new ModelBillingAddress(strAccess$getTextOrEmpty2, strAccess$getTextOrEmpty3, strAccess$getTextOrEmpty4, strAccess$getTextOrEmpty5, str, Companion.access$getTextOrEmpty(companion2, textInputLayout7), strAccess$getTextOrEmpty6);
            CheckBox checkBox = getBinding().i;
            m.checkNotNullExpressionValue(checkBox, "binding.paymentSourceEditDefault");
            PatchPaymentSourceRaw patchPaymentSourceRaw = new PatchPaymentSourceRaw(modelBillingAddress, checkBox.isChecked());
            TextView textView = getBinding().j;
            m.checkNotNullExpressionValue(textView, "binding.paymentSourceEditError");
            textView.setVisibility(8);
            getBinding().d.setIsLoading(true);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePaymentSource(paymentSource.getId(), patchPaymentSourceRaw), false, 1, null), this, null, 2, null), WidgetPaymentSourceEditDialog.class, (Context) null, (Function1) null, new AnonymousClass2(), new AnonymousClass3(), (Function0) null, new AnonymousClass1(), 38, (Object) null);
        }
    }

    @MainThread
    public final void handleError(Error error) {
        m.checkNotNullParameter(error, "error");
        TextView textView = getBinding().j;
        m.checkNotNullExpressionValue(textView, "binding.paymentSourceEditError");
        Error.Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        ViewExtensions.setTextAndVisibilityBy(textView, response.getMessage());
        ValidationManager validationManager = this.validationManager;
        if (validationManager == null) {
            m.throwUninitializedPropertyAccessException("validationManager");
        }
        Error.Response response2 = error.getResponse();
        m.checkNotNullExpressionValue(response2, "error.response");
        Map<String, List<String>> messages = response2.getMessages();
        m.checkNotNullExpressionValue(messages, "error.response.messages");
        validationManager.setErrors(messages);
        Error.Response response3 = error.getResponse();
        m.checkNotNullExpressionValue(response3, "error.response");
        String message = response3.getMessage();
        if (message != null) {
            if (message.length() > 0) {
                b.a.d.m.h(getContext(), message, 0, null, 8);
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Observable<R> observableG = getViewModel().observeViewState().y(WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$1.INSTANCE).G(WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable observableZ = observableG.G(AnonymousClass1.INSTANCE).G(new AnonymousClass2()).Z(1);
        m.checkNotNullExpressionValue(observableZ, "viewModel\n        .obser…       }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableZ, this, null, 2, null), WidgetPaymentSourceEditDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        getBinding().f2508b.setNavigationOnClickListener(new AnonymousClass4());
        getBinding().d.setOnClickListener(new AnonymousClass5());
    }
}
