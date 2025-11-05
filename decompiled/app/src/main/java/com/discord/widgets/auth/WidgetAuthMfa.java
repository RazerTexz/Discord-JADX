package com.discord.widgets.auth;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.a.i.n4;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthMfaBackupCodesBinding;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CodeVerificationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetAuthMfa.kt */
/* loaded from: classes2.dex */
public final class WidgetAuthMfa extends AppFragment {
    private static final int BACKUP_CODE_DIGITS = 8;
    private static final String INTENT_TICKET = "INTENT_TICKET";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private String ticket;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthMfa.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthMfaBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetAuthMfa.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void start(Context context, String ticket) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(ticket, "ticket");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthMfa.INTENT_TICKET, ticket);
            j.d(context, WidgetAuthMfa.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$evaluateCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelLoginResult, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
            invoke2(modelLoginResult);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLoginResult modelLoginResult) {
            AnalyticsTracker.INSTANCE.loginAttempt(true);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$evaluateCode$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetAuthMfa.access$getBinding$p(WidgetAuthMfa.this).f2234b.b();
            AnalyticsTracker.INSTANCE.loginAttempt(false);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthMfa.access$tryPasteCodeFromClipboard(WidgetAuthMfa.this);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$onViewBound$1, reason: invalid class name */
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
            switch (menuItem.getItemId()) {
                case R.id.menu_auth_mfa_backup_codes /* 2131364363 */:
                    WidgetAuthMfa.access$showBackupCodesDialog(WidgetAuthMfa.this);
                    break;
                case R.id.menu_auth_mfa_info /* 2131364364 */:
                    WidgetAuthMfa.access$showInfoDialog(WidgetAuthMfa.this);
                    break;
            }
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthMfa widgetAuthMfa) {
            super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "p1");
            WidgetAuthMfa.access$evaluateCode((WidgetAuthMfa) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$showBackupCodesDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetAuthMfaBackupCodesBinding $binding;
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog, WidgetAuthMfaBackupCodesBinding widgetAuthMfaBackupCodesBinding) {
            this.$dialog = alertDialog;
            this.$binding = widgetAuthMfaBackupCodesBinding;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAuthMfa widgetAuthMfa = WidgetAuthMfa.this;
            AlertDialog alertDialog = this.$dialog;
            m.checkNotNullExpressionValue(alertDialog, "dialog");
            TextInputLayout textInputLayout = this.$binding.c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.widgetAuthMfaBackupCodesEdittext");
            WidgetAuthMfa.access$evaluateBackupCode(widgetAuthMfa, alertDialog, ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$showBackupCodesDialog$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass2(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.hide();
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$showInfoDialog$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ AlertDialog $dialog;

        public AnonymousClass1(AlertDialog alertDialog) {
            this.$dialog = alertDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$dialog.dismiss();
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "it");
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthMfa widgetAuthMfa) {
            super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "p1");
            WidgetAuthMfa.access$evaluateCode((WidgetAuthMfa) this.receiver, str);
        }
    }

    /* compiled from: WidgetAuthMfa.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthMfa widgetAuthMfa = WidgetAuthMfa.this;
            WidgetAuthMfa.access$evaluateCode(widgetAuthMfa, WidgetAuthMfa.access$getBinding$p(widgetAuthMfa).f2234b.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    public WidgetAuthMfa() {
        super(R.layout.widget_auth_mfa);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthMfa$binding$2.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    public static final /* synthetic */ void access$evaluateBackupCode(WidgetAuthMfa widgetAuthMfa, AlertDialog alertDialog, String str) {
        widgetAuthMfa.evaluateBackupCode(alertDialog, str);
    }

    public static final /* synthetic */ void access$evaluateCode(WidgetAuthMfa widgetAuthMfa, String str) {
        widgetAuthMfa.evaluateCode(str);
    }

    public static final /* synthetic */ WidgetAuthMfaBinding access$getBinding$p(WidgetAuthMfa widgetAuthMfa) {
        return widgetAuthMfa.getBinding();
    }

    public static final /* synthetic */ void access$showBackupCodesDialog(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.showBackupCodesDialog();
    }

    public static final /* synthetic */ void access$showInfoDialog(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.showInfoDialog();
    }

    public static final /* synthetic */ void access$tryPasteCodeFromClipboard(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.tryPasteCodeFromClipboard();
    }

    private final void evaluateBackupCode(AlertDialog dialog, String code) {
        if (code.length() < 8) {
            b.a.d.m.i(this, R.string.two_fa_backup_code_enter_wrong, 0, 4);
        } else {
            dialog.hide();
            evaluateCode(code);
        }
    }

    private final void evaluateCode(String code) {
        if (TextUtils.isEmpty(code)) {
            b.a.d.m.i(this, R.string.two_fa_token_required, 0, 4);
            return;
        }
        StoreAuthentication authentication = StoreStream.INSTANCE.getAuthentication();
        String str = this.ticket;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("ticket");
        }
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(authentication.authMFA(code, str), this, null, 2, null), getBinding().c, 0L).k(b.a.d.o.a.g(getContext(), AnonymousClass1.INSTANCE, new AnonymousClass2()));
    }

    private final WidgetAuthMfaBinding getBinding() {
        return (WidgetAuthMfaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void showBackupCodesDialog() {
        View viewInflate = getLayoutInflater().inflate(R.layout.widget_auth_mfa_backup_codes, (ViewGroup) null, false);
        int i = R.id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(R.id.server_settings_delete_server_header);
        if (textView != null) {
            i = R.id.widget_auth_mfa_backup_codes_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_cancel);
            if (materialButton != null) {
                i = R.id.widget_auth_mfa_backup_codes_edittext;
                TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_edittext);
                if (textInputLayout != null) {
                    i = R.id.widget_auth_mfa_backup_codes_send;
                    MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_send);
                    if (materialButton2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        WidgetAuthMfaBackupCodesBinding widgetAuthMfaBackupCodesBinding = new WidgetAuthMfaBackupCodesBinding(linearLayout, textView, materialButton, textInputLayout, materialButton2);
                        m.checkNotNullExpressionValue(widgetAuthMfaBackupCodesBinding, "WidgetAuthMfaBackupCodes…outInflater, null, false)");
                        m.checkNotNullExpressionValue(linearLayout, "binding.root");
                        AlertDialog alertDialogShow = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).show();
                        materialButton2.setOnClickListener(new AnonymousClass1(alertDialogShow, widgetAuthMfaBackupCodesBinding));
                        materialButton.setOnClickListener(new AnonymousClass2(alertDialogShow));
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @MainThread
    private final void showInfoDialog() {
        View viewInflate = getLayoutInflater().inflate(R.layout.widget_auth_mfa_info, (ViewGroup) null, false);
        int i = R.id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(R.id.server_settings_delete_server_header);
        if (textView != null) {
            i = R.id.widget_auth_mfa_info_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_info_okay);
            if (materialButton != null) {
                i = R.id.widget_auth_mfa_info_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.widget_auth_mfa_info_text);
                if (linkifiedTextView != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    m.checkNotNullExpressionValue(new n4(linearLayout, textView, materialButton, linkifiedTextView), "WidgetAuthMfaInfoBinding…outInflater, null, false)");
                    m.checkNotNullExpressionValue(linearLayout, "binding.root");
                    AlertDialog alertDialogShow = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).show();
                    m.checkNotNullExpressionValue(linkifiedTextView, "binding.widgetAuthMfaInfoText");
                    b.n(linkifiedTextView, R.string.two_fa_download_app_body, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, null, 4);
                    materialButton.setOnClickListener(new AnonymousClass1(alertDialogShow));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            m.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                if (charSequenceCoerceToText.length() == 6 && TextUtils.isDigitsOnly(charSequenceCoerceToText)) {
                    getBinding().f2234b.setOnCodeEntered(AnonymousClass1.INSTANCE);
                    CodeVerificationView codeVerificationView = getBinding().f2234b;
                    m.checkNotNullExpressionValue(charSequenceCoerceToText, "clipboardText");
                    codeVerificationView.setCode(charSequenceCoerceToText);
                    getBinding().f2234b.setOnCodeEntered(new AnonymousClass2(this));
                    Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
                    m.checkNotNullExpressionValue(observableD0, "Observable\n            .…L, TimeUnit.MILLISECONDS)");
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthMfa.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        m.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        m.checkNotNullParameter(menu, "menu");
        m.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(R.menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        Observable<Long> observableD0 = Observable.d0(250L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…L, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthMfa.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        AppActivity appActivity;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_auth_mfa, new AnonymousClass1(), null, 4, null);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_TICKET);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.ticket = stringExtra;
        if (stringExtra == null) {
            m.throwUninitializedPropertyAccessException("ticket");
        }
        if ((stringExtra.length() == 0) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        getBinding().f2234b.setOnCodeEntered(new AnonymousClass2(this));
        registerForContextMenu(getBinding().f2234b);
    }
}
