package com.discord.widgets.servers;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppDialog;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsSecurityBinding;
import com.discord.databinding.WidgetServerSettingsSecurityDialogBinding;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsSecurity.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsSecurity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsSecurity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String TAG_TOGGLE_MFA_DIALOG = "TAG_TOGGLE_MFA_DIALOG";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsSecurity.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("SECURITY", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.m156d(context, WidgetServerSettingsSecurity.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsSecurity.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final String guildName;
        private final boolean isMfaEnabled;

        /* compiled from: WidgetServerSettingsSecurity.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11076j = Observable.m11076j(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), WidgetServerSettingsSecurity$Model$Companion$get$1.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable\n             …        )\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11076j).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n             …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(long j, String str, boolean z2) {
            this.guildId = j;
            this.guildName = str;
            this.isMfaEnabled = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = model.guildId;
            }
            if ((i & 2) != 0) {
                str = model.guildName;
            }
            if ((i & 4) != 0) {
                z2 = model.isMfaEnabled;
            }
            return model.copy(j, str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMfaEnabled() {
            return this.isMfaEnabled;
        }

        public final Model copy(long guildId, String guildName, boolean isMfaEnabled) {
            return new Model(guildId, guildName, isMfaEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && this.isMfaEnabled == model.isMfaEnabled;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.isMfaEnabled;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isMfaEnabled() {
            return this.isMfaEnabled;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", guildName=");
            sbM833U.append(this.guildName);
            sbM833U.append(", isMfaEnabled=");
            return outline.m827O(sbM833U, this.isMfaEnabled, ")");
        }
    }

    /* compiled from: WidgetServerSettingsSecurity.kt */
    public static final class ToggleMfaDialog extends AppDialog {
        private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
        private static final String ARG_MFA_ENABLED = "ARG_MFA_ENABLED";

        /* renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        /* renamed from: guildId$delegate, reason: from kotlin metadata */
        private final Lazy guildId;

        /* renamed from: mfaEnabled$delegate, reason: from kotlin metadata */
        private final Lazy mfaEnabled;
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(ToggleMfaDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsSecurityDialogBinding;", 0)};

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* compiled from: WidgetServerSettingsSecurity.kt */
        public static final class Companion {
            private Companion() {
            }

            public final void show(FragmentManager fragmentManager, long guildId, boolean mfaEnabled) {
                Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
                ToggleMfaDialog toggleMfaDialog = new ToggleMfaDialog();
                Bundle bundle = new Bundle();
                bundle.putLong(ToggleMfaDialog.ARG_GUILD_ID, guildId);
                bundle.putBoolean(ToggleMfaDialog.ARG_MFA_ENABLED, mfaEnabled);
                toggleMfaDialog.setArguments(bundle);
                toggleMfaDialog.show(fragmentManager, WidgetServerSettingsSecurity.TAG_TOGGLE_MFA_DIALOG);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ToggleMfaDialog() {
            super(C5419R.layout.widget_server_settings_security_dialog);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsSecurity$ToggleMfaDialog$binding$2.INSTANCE, null, 2, null);
            this.guildId = LazyJVM.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$guildId$2(this));
            this.mfaEnabled = LazyJVM.lazy(new WidgetServerSettingsSecurity$ToggleMfaDialog$mfaEnabled$2(this));
        }

        public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(ToggleMfaDialog toggleMfaDialog) {
            return toggleMfaDialog.getArgumentsOrDefault();
        }

        public static final /* synthetic */ WidgetServerSettingsSecurityDialogBinding access$getBinding$p(ToggleMfaDialog toggleMfaDialog) {
            return toggleMfaDialog.getBinding();
        }

        private final WidgetServerSettingsSecurityDialogBinding getBinding() {
            return (WidgetServerSettingsSecurityDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final long getGuildId() {
            return ((Number) this.guildId.getValue()).longValue();
        }

        private final boolean getMfaEnabled() {
            return ((Boolean) this.mfaEnabled.getValue()).booleanValue();
        }

        public final void configure(long guildId, boolean mfaEnabled) {
            if (guildId <= 0) {
                dismiss();
            }
            getBinding().f17757c.setText(mfaEnabled ? C5419R.string.disable : C5419R.string.enable);
            MaterialButton materialButton = getBinding().f17757c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityDialogConfirm");
            WidgetServerSettingsSecurityDialogBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            LinearLayout linearLayout = binding.f17755a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(linearLayout.getContext(), mfaEnabled ? C5419R.color.status_red_500 : C5419R.color.status_green_600)));
            getBinding().f17757c.setOnClickListener(new WidgetServerSettingsSecurity$ToggleMfaDialog$configure$1(this, mfaEnabled, guildId));
            getBinding().f17756b.setOnClickListener(new WidgetServerSettingsSecurity$ToggleMfaDialog$configure$2(this));
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialog) {
            Intrinsics3.checkNotNullParameter(dialog, "dialog");
            super.onDismiss(dialog);
            AppDialog.hideKeyboard$default(this, null, 1, null);
        }

        @Override // com.discord.app.AppDialog
        public void onViewBoundOrOnResume() {
            super.onViewBoundOrOnResume();
            configure(getGuildId(), getMfaEnabled());
        }
    }

    /* compiled from: WidgetServerSettingsSecurity.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$configureUI$1 */
    public static final class ViewOnClickListenerC93101 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC93101(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ToggleMfaDialog.Companion companion = ToggleMfaDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettingsSecurity.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$model.getGuildId(), this.$model.isMfaEnabled());
        }
    }

    /* compiled from: WidgetServerSettingsSecurity.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsSecurity$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C93111 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C93111(WidgetServerSettingsSecurity widgetServerSettingsSecurity) {
            super(1, widgetServerSettingsSecurity, WidgetServerSettingsSecurity.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsSecurity$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsSecurity.access$configureUI((WidgetServerSettingsSecurity) this.receiver, model);
        }
    }

    public WidgetServerSettingsSecurity() {
        super(C5419R.layout.widget_server_settings_security);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsSecurity$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsSecurity$guildId$2(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsSecurity$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsSecurity widgetServerSettingsSecurity, Model model) throws Exception {
        widgetServerSettingsSecurity.configureUI(model);
    }

    private final void configureUI(Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarTitle(C5419R.string.security);
        setActionBarSubtitle(model.getGuildName());
        if (model.isMfaEnabled()) {
            getBinding().f17754c.setText(C5419R.string.guild_security_req_mfa_turn_off);
            MaterialButton materialButton = getBinding().f17754c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsSecurityToggleMfaButton");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), C5419R.color.status_red_500)));
        } else {
            getBinding().f17754c.setText(C5419R.string.guild_security_req_mfa_turn_on);
            MaterialButton materialButton2 = getBinding().f17754c;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.serverSettingsSecurityToggleMfaButton");
            materialButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(requireContext(), C5419R.color.status_green_600)));
        }
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(TAG_TOGGLE_MFA_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            ((ToggleMfaDialog) fragmentFindFragmentByTag).configure(model.getGuildId(), model.isMfaEnabled());
        }
        getBinding().f17754c.setOnClickListener(new ViewOnClickListenerC93101(model));
    }

    private final WidgetServerSettingsSecurityBinding getBinding() {
        return (WidgetServerSettingsSecurityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        Fragment fragmentFindFragmentByTag = getParentFragmentManager().findFragmentByTag(TAG_TOGGLE_MFA_DIALOG);
        if (fragmentFindFragmentByTag != null) {
            getParentFragmentManager().beginTransaction().remove(fragmentFindFragmentByTag).commitAllowingStateLoss();
        }
        TextView textView = getBinding().f17753b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mfaDescriptionText");
        FormatUtils.m222n(textView, C5419R.string.guild_security_req_mfa_body, new Object[0], null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), WidgetServerSettingsSecurity.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93111(this), 62, (Object) null);
    }
}
