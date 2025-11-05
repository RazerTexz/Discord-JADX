package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.guild.VanityUrlResponse;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsVanityUrlBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsVanityUrl.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl extends AppFragment {
    private static final long ANIMATION_DURATION = 250;
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsVanityUrl.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsVanityUrlBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$translateLeft(Companion companion, View view, int i) {
            companion.translateLeft(view, i);
        }

        public static final /* synthetic */ void access$translateToOriginX(Companion companion, View view) {
            companion.translateToOriginX(view);
        }

        private final void translateLeft(View view, int i) {
            view.animate().translationXBy(-i).setDuration(WidgetServerSettingsVanityUrl.ANIMATION_DURATION).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        }

        private final void translateToOriginX(View view) {
            view.animate().translationX(0.0f).setDuration(WidgetServerSettingsVanityUrl.ANIMATION_DURATION).setInterpolator(new AccelerateDecelerateInterpolator()).start();
        }

        public final void create(Context context, long guildId) {
            m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("VANITY_URL", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            j.d(context, WidgetServerSettingsVanityUrl.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final String guildName;
        private final String vanityUrl;
        private final int vanityUrlUses;

        /* compiled from: WidgetServerSettingsVanityUrl.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableH = Observable.h(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getVanityUrl(guildId), false, 1, null), new WidgetServerSettingsVanityUrl$Model$Companion$get$1(guildId));
                m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…ull\n          }\n        }");
                return observableH;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(long j, String str, String str2, int i) {
            this.guildId = j;
            this.guildName = str;
            this.vanityUrl = str2;
            this.vanityUrlUses = i;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = model.guildId;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                str = model.guildName;
            }
            String str3 = str;
            if ((i2 & 4) != 0) {
                str2 = model.vanityUrl;
            }
            String str4 = str2;
            if ((i2 & 8) != 0) {
                i = model.vanityUrlUses;
            }
            return model.copy(j2, str3, str4, i);
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
        public final String getVanityUrl() {
            return this.vanityUrl;
        }

        /* renamed from: component4, reason: from getter */
        public final int getVanityUrlUses() {
            return this.vanityUrlUses;
        }

        public final Model copy(long guildId, String guildName, String vanityUrl, int vanityUrlUses) {
            return new Model(guildId, guildName, vanityUrl, vanityUrlUses);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && m.areEqual(this.guildName, model.guildName) && m.areEqual(this.vanityUrl, model.vanityUrl) && this.vanityUrlUses == model.vanityUrlUses;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final String getVanityUrl() {
            return this.vanityUrl;
        }

        public final int getVanityUrlUses() {
            return this.vanityUrlUses;
        }

        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.vanityUrl;
            return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.vanityUrlUses;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(guildId=");
            sbU.append(this.guildId);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", vanityUrl=");
            sbU.append(this.vanityUrl);
            sbU.append(", vanityUrlUses=");
            return a.B(sbU, this.vanityUrlUses, ")");
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl = WidgetServerSettingsVanityUrl.this;
            long guildId = this.$model.getGuildId();
            TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).f2588b;
            m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            int length = textOrEmpty.length() - 1;
            int i = 0;
            boolean z2 = false;
            while (i <= length) {
                boolean z3 = m.compare(textOrEmpty.charAt(!z2 ? i : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i++;
                } else {
                    z2 = true;
                }
            }
            WidgetServerSettingsVanityUrl.access$updateVanityUrl(widgetServerSettingsVanityUrl, guildId, textOrEmpty.subSequence(i, length + 1).toString());
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsVanityUrl.access$updateVanityUrl(WidgetServerSettingsVanityUrl.this, this.$model.getGuildId(), "");
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
            super(1, widgetServerSettingsVanityUrl, WidgetServerSettingsVanityUrl.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsVanityUrl$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsVanityUrl.access$configureUI((WidgetServerSettingsVanityUrl) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnFocusChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z2) {
            if (!z2) {
                Companion companion = WidgetServerSettingsVanityUrl.INSTANCE;
                TextView textView = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).h;
                m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlPrefix");
                Companion.access$translateToOriginX(companion, textView);
                TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).f2588b;
                m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
                Companion.access$translateToOriginX(companion, textInputLayout);
                return;
            }
            TextView textView2 = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).h;
            m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlPrefix");
            int width = textView2.getWidth();
            Companion companion2 = WidgetServerSettingsVanityUrl.INSTANCE;
            TextView textView3 = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).h;
            m.checkNotNullExpressionValue(textView3, "binding.serverSettingsVanityUrlPrefix");
            Companion.access$translateLeft(companion2, textView3, width);
            TextInputLayout textInputLayout2 = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).f2588b;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
            Companion.access$translateLeft(companion2, textInputLayout2, width);
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl = WidgetServerSettingsVanityUrl.this;
            TextInputLayout textInputLayout = WidgetServerSettingsVanityUrl.access$getBinding$p(widgetServerSettingsVanityUrl).f2588b;
            m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
            widgetServerSettingsVanityUrl.showKeyboard(textInputLayout);
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$updateVanityUrl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<VanityUrlResponse, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VanityUrlResponse vanityUrlResponse) {
            invoke2(vanityUrlResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VanityUrlResponse vanityUrlResponse) {
            m.checkNotNullParameter(vanityUrlResponse, "<name for destructuring parameter 0>");
            String code = vanityUrlResponse.getCode();
            int uses = vanityUrlResponse.getUses();
            WidgetServerSettingsVanityUrl.access$showLoadingUI(WidgetServerSettingsVanityUrl.this, false);
            AppFragment.hideKeyboard$default(WidgetServerSettingsVanityUrl.this, null, 1, null);
            WidgetServerSettingsVanityUrl.access$configureInviteCode(WidgetServerSettingsVanityUrl.this, code, uses);
            StatefulViews.clear$default(WidgetServerSettingsVanityUrl.access$getState$p(WidgetServerSettingsVanityUrl.this), false, 1, null);
        }
    }

    /* compiled from: WidgetServerSettingsVanityUrl.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$updateVanityUrl$2, reason: invalid class name */
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
            m.checkNotNullParameter(error, "error");
            WidgetServerSettingsVanityUrl.access$showLoadingUI(WidgetServerSettingsVanityUrl.this, false);
            Error.Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "error.response");
            if (response.getCode() == 50020) {
                error.setShowErrorToasts(false);
                TextView textView = WidgetServerSettingsVanityUrl.access$getBinding$p(WidgetServerSettingsVanityUrl.this).d;
                m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlErrorText");
                textView.setVisibility(0);
            }
        }
    }

    public WidgetServerSettingsVanityUrl() {
        super(R.layout.widget_server_settings_vanity_url);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsVanityUrl$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R.id.server_settings_vanity_input);
        this.guildId = g.lazy(new WidgetServerSettingsVanityUrl$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsVanityUrl$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureInviteCode(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, String str, int i) {
        widgetServerSettingsVanityUrl.configureInviteCode(str, i);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, Model model) {
        widgetServerSettingsVanityUrl.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerSettingsVanityUrlBinding access$getBinding$p(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        return widgetServerSettingsVanityUrl.getBinding();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl) {
        return widgetServerSettingsVanityUrl.state;
    }

    public static final /* synthetic */ void access$showLoadingUI(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, boolean z2) {
        widgetServerSettingsVanityUrl.showLoadingUI(z2);
    }

    public static final /* synthetic */ void access$updateVanityUrl(WidgetServerSettingsVanityUrl widgetServerSettingsVanityUrl, long j, String str) {
        widgetServerSettingsVanityUrl.updateVanityUrl(j, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureInviteCode(String code, int uses) {
        boolean z2;
        boolean z3;
        TextInputLayout textInputLayout = getBinding().f2588b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f2588b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), code));
        getBinding().f2588b.clearFocus();
        if (code != null) {
            if (code.length() > 0) {
                String strW = a.w("https://discord.gg/", code);
                TextView textView = getBinding().c;
                m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlCurrentUrl");
                b.a.k.b.n(textView, R.string.vanity_url_help_extended, new Object[]{strW}, null, 4);
            }
        }
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlCurrentUrl");
        if (code == null) {
            z2 = false;
        } else {
            if (code.length() > 0) {
                z2 = true;
            }
        }
        textView2.setVisibility(z2 ? 0 : 8);
        TextView textView3 = getBinding().i;
        m.checkNotNullExpressionValue(textView3, "binding.serverSettingsVanityUrlRemove");
        if (code == null) {
            z3 = false;
        } else {
            if (code.length() > 0) {
                z3 = true;
            }
        }
        textView3.setVisibility(z3 ? 0 : 8);
        if (code == null) {
            getBinding().e.setText(R.string.vanity_url);
            return;
        }
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(requireContext(), R.plurals.vanity_url_header_uses_uses, uses, Integer.valueOf(uses));
        TextView textView4 = getBinding().e;
        m.checkNotNullExpressionValue(textView4, "binding.serverSettingsVanityUrlHeader");
        b.a.k.b.n(textView4, R.string.vanity_url_header_uses, new Object[]{i18nPluralString}, null, 4);
    }

    private final void configureUI(Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        showLoadingUI(false);
        setActionBarTitle(R.string.vanity_url);
        setActionBarSubtitle(model.getGuildName());
        configureInviteCode(model.getVanityUrl(), model.getVanityUrlUses());
        this.state.configureSaveActionView(getBinding().j);
        getBinding().j.setOnClickListener(new AnonymousClass1(model));
        getBinding().i.setOnClickListener(new AnonymousClass2(model));
    }

    private final WidgetServerSettingsVanityUrlBinding getBinding() {
        return (WidgetServerSettingsVanityUrlBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void showLoadingUI(boolean loading) {
        ProgressBar progressBar = getBinding().g;
        m.checkNotNullExpressionValue(progressBar, "binding.serverSettingsVanityUrlLoadingIndicator");
        progressBar.setVisibility(loading ? 0 : 8);
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsVanityUrlErrorText");
        textView.setVisibility(8);
        TextView textView2 = getBinding().i;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsVanityUrlRemove");
        textView2.setEnabled(!loading);
    }

    private final void updateVanityUrl(long guildId, String code) {
        showLoadingUI(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateVanityUrl(guildId, new RestAPIParams.VanityUrl(code)), false, 1, null), this, null, 2, null), WidgetServerSettingsVanityUrl.class, getContext(), (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 52, (Object) null);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        showLoadingUI(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), WidgetServerSettingsVanityUrl.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextInputLayout textInputLayout = getBinding().f2588b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsVanityInput");
        ViewExtensions.setOnEditTextFocusChangeListener(textInputLayout, new AnonymousClass1());
        getBinding().f.setOnClickListener(new AnonymousClass2());
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().j;
        TextInputLayout textInputLayout2 = getBinding().f2588b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsVanityInput");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout2);
    }
}
