package com.discord.widgets.phone;

import android.content.Context;
import android.text.Editable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.discord.models.phone.PhoneCountryCode;
import com.discord.stores.StorePhone;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.phone.PhoneUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetPhoneCountryCodeBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetPhoneCountryCodeBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PhoneCountryCodeAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> nameFilterSubject;

    /* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            new WidgetPhoneCountryCodeBottomSheet().show(context, WidgetPhoneCountryCodeBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    /* renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$configureUI$1 */
    public static final class C91161 implements PhoneCountryCodeAdapter2 {
        public final /* synthetic */ StorePhone $phoneStore;

        public C91161(StorePhone storePhone) {
            this.$phoneStore = storePhone;
        }

        @Override // com.discord.widgets.phone.PhoneCountryCodeAdapter2
        public final void onCountryCodeSelected(PhoneCountryCode phoneCountryCode) {
            Intrinsics3.checkNotNullParameter(phoneCountryCode, "it");
            this.$phoneStore.updateSelectedCountryCode(phoneCountryCode);
            WidgetPhoneCountryCodeBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    /* renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$onResume$1 */
    public static final class C91171 extends Lambda implements Function1<Editable, Unit> {
        public C91171() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetPhoneCountryCodeBottomSheet.access$getNameFilterSubject$p(WidgetPhoneCountryCodeBottomSheet.this).onNext(editable.toString());
        }
    }

    /* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
    /* renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$onResume$2 */
    public static final class C91182 extends Lambda implements Function1<String, Unit> {
        public C91182() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet = WidgetPhoneCountryCodeBottomSheet.this;
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            WidgetPhoneCountryCodeBottomSheet.access$configureUI(widgetPhoneCountryCodeBottomSheet, str);
        }
    }

    public WidgetPhoneCountryCodeBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetPhoneCountryCodeBottomSheet2.INSTANCE, null, 2, null);
        BehaviorSubject<String> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0("");
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(\"\")");
        this.nameFilterSubject = behaviorSubjectM11130l0;
        this.adapter = new PhoneCountryCodeAdapter();
    }

    public static final /* synthetic */ void access$configureUI(WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet, String str) {
        widgetPhoneCountryCodeBottomSheet.configureUI(str);
    }

    public static final /* synthetic */ BehaviorSubject access$getNameFilterSubject$p(WidgetPhoneCountryCodeBottomSheet widgetPhoneCountryCodeBottomSheet) {
        return widgetPhoneCountryCodeBottomSheet.nameFilterSubject;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(String filter) {
        boolean z2;
        StorePhone phone = StoreStream.INSTANCE.getPhone();
        List<PhoneCountryCode> countryCodes = phone.getCountryCodes();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = countryCodes.iterator();
        while (true) {
            if (!it.hasNext()) {
                getBinding().f17364b.setHasFixedSize(false);
                RecyclerView recyclerView = getBinding().f17364b;
                Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.phoneCountryCodeRecycler");
                recyclerView.setAdapter(this.adapter);
                this.adapter.configure(arrayList, new C91161(phone));
                return;
            }
            Object next = it.next();
            PhoneCountryCode phoneCountryCode = (PhoneCountryCode) next;
            if (!Strings4.contains((CharSequence) phoneCountryCode.getName(), (CharSequence) filter, true)) {
                PhoneUtils phoneUtils = PhoneUtils.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                z2 = Strings4.contains((CharSequence) phoneUtils.getTranslatedStringForCountry(phoneCountryCode, contextRequireContext), (CharSequence) filter, true);
            }
            if (z2) {
                arrayList.add(next);
            }
        }
    }

    private final WidgetPhoneCountryCodeBottomSheetBinding getBinding() {
        return (WidgetPhoneCountryCodeBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_phone_country_code_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TextInputLayout textInputLayout = getBinding().f17365c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.phoneCountryCodeSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C91171());
        Observable<String> observableM11110p = this.nameFilterSubject.m11110p(200L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11110p, "nameFilterSubject.deboun…0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11110p, this, null, 2, null), WidgetPhoneCountryCodeBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91182(), 62, (Object) null);
        configureUI("");
    }
}
