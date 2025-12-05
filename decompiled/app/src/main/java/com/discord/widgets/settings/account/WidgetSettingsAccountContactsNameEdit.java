package com.discord.widgets.settings.account;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserConnectionsUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsAccountContactsNameEditBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsAccountContactsNameEdit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsAccountContactsNameEdit.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$configureUI$1 */
    public static final class ViewOnClickListenerC97491 implements View.OnClickListener {
        public ViewOnClickListenerC97491() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountContactsNameEdit.access$submitName(WidgetSettingsAccountContactsNameEdit.this, "");
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$onViewBound$1 */
    public static final class C97501 extends Lambda implements Function1<TextView, Unit> {
        public C97501() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit = WidgetSettingsAccountContactsNameEdit.this;
            TextInputLayout textInputLayout = WidgetSettingsAccountContactsNameEdit.access$getBinding$p(widgetSettingsAccountContactsNameEdit).f17827b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Objects.requireNonNull(textOrEmpty, "null cannot be cast to non-null type kotlin.CharSequence");
            WidgetSettingsAccountContactsNameEdit.access$submitName(widgetSettingsAccountContactsNameEdit, Strings4.trim(textOrEmpty).toString());
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$onViewBound$2 */
    public static final class ViewOnClickListenerC97512 implements View.OnClickListener {
        public ViewOnClickListenerC97512() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit = WidgetSettingsAccountContactsNameEdit.this;
            TextInputLayout textInputLayout = WidgetSettingsAccountContactsNameEdit.access$getBinding$p(widgetSettingsAccountContactsNameEdit).f17827b;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Objects.requireNonNull(textOrEmpty, "null cannot be cast to non-null type kotlin.CharSequence");
            WidgetSettingsAccountContactsNameEdit.access$submitName(widgetSettingsAccountContactsNameEdit, Strings4.trim(textOrEmpty).toString());
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$onViewBoundOrOnResume$1 */
    public static final class C97521 extends Lambda implements Function1<StoreUserConnections.State, Unit> {
        public C97521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreUserConnections.State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreUserConnections.State state) {
            Intrinsics3.checkNotNullParameter(state, "it");
            WidgetSettingsAccountContactsNameEdit.access$configureUI(WidgetSettingsAccountContactsNameEdit.this, state);
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$1 */
    public static final class C97531 extends Lambda implements Function1<ConnectedAccount, TrackNetworkMetadata2> {
        public final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C97531(String str) {
            super(1);
            this.$name = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ConnectedAccount connectedAccount) {
            return invoke2(connectedAccount);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(ConnectedAccount connectedAccount) {
            return new TrackNetworkActionUserConnectionsUpdate(this.$name, null, null, null, 14);
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$2 */
    public static final class C97542 extends Lambda implements Function1<ConnectedAccount, Unit> {
        public C97542() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConnectedAccount connectedAccount) {
            invoke2(connectedAccount);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "it");
            FragmentActivity activity = WidgetSettingsAccountContactsNameEdit.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$submitName$3 */
    public static final class C97553 extends Lambda implements Function1<Error, Unit> {
        public static final C97553 INSTANCE = new C97553();

        public C97553() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
        }
    }

    public WidgetSettingsAccountContactsNameEdit() {
        super(C5419R.layout.widget_settings_account_contacts_name_edit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccountContactsNameEdit2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit, List list) {
        widgetSettingsAccountContactsNameEdit.configureUI(list);
    }

    public static final /* synthetic */ WidgetSettingsAccountContactsNameEditBinding access$getBinding$p(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit) {
        return widgetSettingsAccountContactsNameEdit.getBinding();
    }

    public static final /* synthetic */ void access$submitName(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit, String str) {
        widgetSettingsAccountContactsNameEdit.submitName(str);
    }

    private final void configureUI(List<ConnectedAccount> connections) {
        ConnectedAccount connectedAccountPrevious;
        String name;
        ListIterator<ConnectedAccount> listIterator = connections.listIterator(connections.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                connectedAccountPrevious = null;
                break;
            } else {
                connectedAccountPrevious = listIterator.previous();
                if (Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                    break;
                }
            }
        }
        ConnectedAccount connectedAccount = connectedAccountPrevious;
        TextInputLayout textInputLayout = getBinding().f17827b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        if (connectedAccount == null || (name = connectedAccount.getName()) == null) {
            name = "";
        }
        ViewExtensions.setText(textInputLayout, name);
        getBinding().f17828c.setOnClickListener(new ViewOnClickListenerC97491());
    }

    private final WidgetSettingsAccountContactsNameEditBinding getBinding() {
        return (WidgetSettingsAccountContactsNameEditBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void submitName(String name) {
        String string;
        AppFragment.hideKeyboard$default(this, null, 1, null);
        boolean z2 = name == null || StringsJVM.isBlank(name);
        if (z2) {
            string = null;
        } else {
            if (z2) {
                throw new NoWhenBranchMatchedException();
            }
            Objects.requireNonNull(name, "null cannot be cast to non-null type kotlin.CharSequence");
            string = Strings4.trim(name).toString();
        }
        AnalyticsTracker.INSTANCE.nameSubmitted(Strings4.split$default((CharSequence) name, new String[]{" "}, false, 0, 6, (Object) null).size(), name.length());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().updateConnectionName("contacts", "@me", new RestAPIParams.ConnectedAccountNameOnly(string)), false, 1, null), new C97531(name)), this, null, 2, null), WidgetSettingsAccountContactsNameEdit.class, (Context) null, (Function1) null, C97553.INSTANCE, (Function0) null, (Function0) null, new C97542(), 54, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.contact_sync_update_name_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f17827b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C97501(), 1, null);
        getBinding().f17829d.setOnClickListener(new ViewOnClickListenerC97512());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getUserConnections().observeConnectedAccounts(), this, null, 2, null), WidgetSettingsAccountContactsNameEdit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C97521(), 62, (Object) null);
    }
}
