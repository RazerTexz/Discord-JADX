package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.d0;
import b.a.d.i0;
import b.a.d.j;
import b.a.d.m;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.application.Application;
import com.discord.api.auth.OAuthScope;
import com.discord.api.auth.OAuthScopeTypeAdapter;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.OauthTokenPermissionDetailedListItemBinding;
import com.discord.databinding.WidgetOauthAuthorizeBinding;
import com.discord.i18n.RenderContext;
import com.discord.nullserializable.NullSerializable;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.OAuthPermissionViews;
import com.discord.widgets.auth.WidgetAuthCaptcha;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.c0.c;
import d0.g;
import d0.g0.t;
import d0.g0.w;
import d0.o;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Func0;

/* compiled from: WidgetOauth2Authorize.kt */
/* loaded from: classes2.dex */
public class WidgetOauth2Authorize extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetOauth2Authorize.class, "binding", "getBinding()Lcom/discord/databinding/WidgetOauthAuthorizeBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_PARAM_URI = "REQ_URI";
    private static final String QUERY_INTERNAL_REFERRER = "internal_referrer";
    private static final String QUERY_PARAM_CLIENT_ID = "client_id";
    private static final String QUERY_PARAM_CODE_CHALLENGE = "code_challenge";
    private static final String QUERY_PARAM_CODE_CHALLENGE_METHOD = "code_challenge_method";
    private static final String QUERY_PARAM_PERMISSIONS = "permissions";
    private static final String QUERY_PARAM_REDIRECT = "redirect_uri";
    private static final String QUERY_PARAM_RESPONSE_TYPE = "response_type";
    private static final String QUERY_PARAM_SCOPE = "scope";
    private static final String QUERY_PARAM_STATE = "state";
    private static final String ROOT_ERROR_KEY = "_root";
    private final SimpleRecyclerAdapter<PermissionModel, OAuthPermissionViewHolder> adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;

    /* renamed from: oauth2ViewModel$delegate, reason: from kotlin metadata */
    private final Lazy oauth2ViewModel;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* compiled from: WidgetOauth2Authorize.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ OAuth2Authorize access$createOauthAuthorize(Companion companion, Uri uri) {
            return companion.createOauthAuthorize(uri);
        }

        public static final /* synthetic */ void access$handleError(Companion companion, Context context, Exception exc, Function0 function0) {
            companion.handleError(context, exc, function0);
        }

        private final Intent createLaunchIntent(Uri requestUri, OAuth2Authorize oAuth2Authorize) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra(WidgetOauth2Authorize.INTENT_PARAM_URI, requestUri);
            String internalReferrer = oAuth2Authorize.getInternalReferrer();
            if ((internalReferrer == null || !Boolean.parseBoolean(internalReferrer)) && !oAuth2Authorize.isUnsupported()) {
                intent.addFlags(268468224);
            }
            return intent;
        }

        private final OAuth2Authorize createOauthAuthorize(Uri requestUrl) throws NumberFormatException {
            WidgetOauth2Authorize$Companion$createOauthAuthorize$1 widgetOauth2Authorize$Companion$createOauthAuthorize$1 = WidgetOauth2Authorize$Companion$createOauthAuthorize$1.INSTANCE;
            long j = Long.parseLong(widgetOauth2Authorize$Companion$createOauthAuthorize$1.invoke2(requestUrl, WidgetOauth2Authorize.QUERY_PARAM_CLIENT_ID));
            String queryParameter = requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_REDIRECT);
            return new OAuth2Authorize(j, requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_STATE), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_RESPONSE_TYPE), queryParameter, null, widgetOauth2Authorize$Companion$createOauthAuthorize$1.invoke2(requestUrl, WidgetOauth2Authorize.QUERY_PARAM_SCOPE), requestUrl.getQueryParameter("permissions"), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_CODE_CHALLENGE), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_PARAM_CODE_CHALLENGE_METHOD), requestUrl.getQueryParameter(WidgetOauth2Authorize.QUERY_INTERNAL_REFERRER), 16, null);
        }

        private final void handleError(Context context, Exception e, Function0<Unit> onComplete) {
            String string = b.h(context, R.string.oauth2_request_missing_param, new Object[]{e.getMessage()}, null, 4).toString();
            AppLog.g.w(string, e);
            m.h(context, string, 1, null, 8);
            onComplete.invoke();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void handleError$default(Companion companion, Context context, Exception exc, Function0 function0, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = WidgetOauth2Authorize$Companion$handleError$1.INSTANCE;
            }
            companion.handleError(context, exc, function0);
        }

        public final String getNoticeName(long clientId) {
            return a.t("OAUTH_REQUEST:", clientId);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void launch(Context context, Uri requestUri) {
            OAuth2Authorize oAuth2AuthorizeCreateOauthAuthorize;
            d0.z.d.m.checkNotNullParameter(context, "context");
            d0.z.d.m.checkNotNullParameter(requestUri, "requestUri");
            try {
                oAuth2AuthorizeCreateOauthAuthorize = createOauthAuthorize(requestUri);
            } catch (Exception e) {
                handleError$default(this, context, e, null, 4, null);
                oAuth2AuthorizeCreateOauthAuthorize = null;
            }
            if (oAuth2AuthorizeCreateOauthAuthorize != null) {
                long clientId = oAuth2AuthorizeCreateOauthAuthorize.getClientId();
                AnalyticsTracker.INSTANCE.oauth2AuthorizedViewed(clientId);
                boolean z2 = true;
                if (d0.z.d.m.areEqual(String.valueOf(clientId), "591317049637339146")) {
                    if (!(Build.VERSION.SDK_INT >= 28 && t.equals(Build.MANUFACTURER, "samsung", true))) {
                    }
                } else {
                    z2 = false;
                }
                j.d(context, z2 ? WidgetOauth2AuthorizeSamsung.class : WidgetOauth2Authorize.class, createLaunchIntent(requestUri, oAuth2AuthorizeCreateOauthAuthorize));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    public static final /* data */ class OAuth2Authorize {
        private final long clientId;
        private final String codeChallenge;
        private final String codeChallengeMethod;
        private final String internalReferrer;
        private final String permissions;
        private final String prompt;
        private final String redirectUrl;
        private final String responseType;
        private final String scope;
        private final String state;

        public OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            d0.z.d.m.checkNotNullParameter(str4, "prompt");
            d0.z.d.m.checkNotNullParameter(str5, WidgetOauth2Authorize.QUERY_PARAM_SCOPE);
            this.clientId = j;
            this.state = str;
            this.responseType = str2;
            this.redirectUrl = str3;
            this.prompt = str4;
            this.scope = str5;
            this.permissions = str6;
            this.codeChallenge = str7;
            this.codeChallengeMethod = str8;
            this.internalReferrer = str9;
        }

        public static /* synthetic */ OAuth2Authorize copy$default(OAuth2Authorize oAuth2Authorize, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
            return oAuth2Authorize.copy((i & 1) != 0 ? oAuth2Authorize.clientId : j, (i & 2) != 0 ? oAuth2Authorize.state : str, (i & 4) != 0 ? oAuth2Authorize.responseType : str2, (i & 8) != 0 ? oAuth2Authorize.redirectUrl : str3, (i & 16) != 0 ? oAuth2Authorize.prompt : str4, (i & 32) != 0 ? oAuth2Authorize.scope : str5, (i & 64) != 0 ? oAuth2Authorize.permissions : str6, (i & 128) != 0 ? oAuth2Authorize.codeChallenge : str7, (i & 256) != 0 ? oAuth2Authorize.codeChallengeMethod : str8, (i & 512) != 0 ? oAuth2Authorize.internalReferrer : str9);
        }

        private final boolean getHasBotPermission() {
            List<String> listSplit$default = w.split$default((CharSequence) this.scope, new String[]{" "}, false, 0, 6, (Object) null);
            if ((listSplit$default instanceof Collection) && listSplit$default.isEmpty()) {
                return false;
            }
            for (String str : listSplit$default) {
                if (t.equals(str, OAuthScope.Bot.INSTANCE.getScopeName(), true) || t.equals(str, OAuthScope.WebhookIncoming.INSTANCE.getScopeName(), true)) {
                    return true;
                }
            }
            return false;
        }

        public static /* synthetic */ Observable post$default(OAuth2Authorize oAuth2Authorize, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            return oAuth2Authorize.post(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getClientId() {
            return this.clientId;
        }

        /* renamed from: component10, reason: from getter */
        public final String getInternalReferrer() {
            return this.internalReferrer;
        }

        /* renamed from: component2, reason: from getter */
        public final String getState() {
            return this.state;
        }

        /* renamed from: component3, reason: from getter */
        public final String getResponseType() {
            return this.responseType;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        /* renamed from: component5, reason: from getter */
        public final String getPrompt() {
            return this.prompt;
        }

        /* renamed from: component6, reason: from getter */
        public final String getScope() {
            return this.scope;
        }

        /* renamed from: component7, reason: from getter */
        public final String getPermissions() {
            return this.permissions;
        }

        /* renamed from: component8, reason: from getter */
        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        /* renamed from: component9, reason: from getter */
        public final String getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        public final OAuth2Authorize copy(long clientId, String state, String responseType, String redirectUrl, String prompt, String scope, String permissions, String codeChallenge, String codeChallengeMethod, String internalReferrer) {
            d0.z.d.m.checkNotNullParameter(prompt, "prompt");
            d0.z.d.m.checkNotNullParameter(scope, WidgetOauth2Authorize.QUERY_PARAM_SCOPE);
            return new OAuth2Authorize(clientId, state, responseType, redirectUrl, prompt, scope, permissions, codeChallenge, codeChallengeMethod, internalReferrer);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OAuth2Authorize)) {
                return false;
            }
            OAuth2Authorize oAuth2Authorize = (OAuth2Authorize) other;
            return this.clientId == oAuth2Authorize.clientId && d0.z.d.m.areEqual(this.state, oAuth2Authorize.state) && d0.z.d.m.areEqual(this.responseType, oAuth2Authorize.responseType) && d0.z.d.m.areEqual(this.redirectUrl, oAuth2Authorize.redirectUrl) && d0.z.d.m.areEqual(this.prompt, oAuth2Authorize.prompt) && d0.z.d.m.areEqual(this.scope, oAuth2Authorize.scope) && d0.z.d.m.areEqual(this.permissions, oAuth2Authorize.permissions) && d0.z.d.m.areEqual(this.codeChallenge, oAuth2Authorize.codeChallenge) && d0.z.d.m.areEqual(this.codeChallengeMethod, oAuth2Authorize.codeChallengeMethod) && d0.z.d.m.areEqual(this.internalReferrer, oAuth2Authorize.internalReferrer);
        }

        public final Observable<RestAPIParams.OAuth2Authorize.ResponseGet> get() {
            return RestAPI.INSTANCE.getApi().getOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions);
        }

        public final long getClientId() {
            return this.clientId;
        }

        public final String getCodeChallenge() {
            return this.codeChallenge;
        }

        public final String getCodeChallengeMethod() {
            return this.codeChallengeMethod;
        }

        public final String getInternalReferrer() {
            return this.internalReferrer;
        }

        public final String getPermissions() {
            return this.permissions;
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final String getRedirectUrl() {
            return this.redirectUrl;
        }

        public final String getResponseType() {
            return this.responseType;
        }

        public final String getScope() {
            return this.scope;
        }

        public final String getState() {
            return this.state;
        }

        public int hashCode() {
            int iA = a0.a.a.b.a(this.clientId) * 31;
            String str = this.state;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.responseType;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.redirectUrl;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.prompt;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.scope;
            int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.permissions;
            int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
            String str7 = this.codeChallenge;
            int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
            String str8 = this.codeChallengeMethod;
            int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
            String str9 = this.internalReferrer;
            return iHashCode8 + (str9 != null ? str9.hashCode() : 0);
        }

        public final boolean isUnsupported() {
            return getHasBotPermission();
        }

        public final Observable<RestAPIParams.OAuth2Authorize.ResponsePost> post(String captchaKey, String captchaRqtoken) {
            return RestAPI.INSTANCE.getApi().postOauth2Authorize(String.valueOf(this.clientId), this.state, this.responseType, this.redirectUrl, this.prompt, this.scope, this.permissions, this.codeChallenge, this.codeChallengeMethod, h0.plus(h0.plus(g0.mapOf(o.to("authorize", "true")), captchaKey != null ? g0.mapOf(o.to(CaptchaHelper.CAPTCHA_KEY, captchaKey)) : h0.emptyMap()), captchaRqtoken != null ? g0.mapOf(o.to("captcha_rqtoken", captchaRqtoken)) : h0.emptyMap()));
        }

        public String toString() {
            StringBuilder sbU = a.U("OAuth2Authorize(clientId=");
            sbU.append(this.clientId);
            sbU.append(", state=");
            sbU.append(this.state);
            sbU.append(", responseType=");
            sbU.append(this.responseType);
            sbU.append(", redirectUrl=");
            sbU.append(this.redirectUrl);
            sbU.append(", prompt=");
            sbU.append(this.prompt);
            sbU.append(", scope=");
            sbU.append(this.scope);
            sbU.append(", permissions=");
            sbU.append(this.permissions);
            sbU.append(", codeChallenge=");
            sbU.append(this.codeChallenge);
            sbU.append(", codeChallengeMethod=");
            sbU.append(this.codeChallengeMethod);
            sbU.append(", internalReferrer=");
            return a.J(sbU, this.internalReferrer, ")");
        }

        public /* synthetic */ OAuth2Authorize(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? "consent" : str4, str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9);
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    public static final class OAuth2ViewModel extends d0<Unit> {
        public OAuth2Authorize oauthAuthorize;
        private RestAPIParams.OAuth2Authorize.ResponseGet oauthGetResponse;

        public OAuth2ViewModel() {
            super(null, 1, null);
        }

        public final OAuth2Authorize getOauthAuthorize() {
            OAuth2Authorize oAuth2Authorize = this.oauthAuthorize;
            if (oAuth2Authorize == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("oauthAuthorize");
            }
            return oAuth2Authorize;
        }

        public final RestAPIParams.OAuth2Authorize.ResponseGet getOauthGetResponse() {
            return this.oauthGetResponse;
        }

        public final void setOauthAuthorize(OAuth2Authorize oAuth2Authorize) {
            d0.z.d.m.checkNotNullParameter(oAuth2Authorize, "<set-?>");
            this.oauthAuthorize = oAuth2Authorize;
        }

        public final void setOauthGetResponse(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            this.oauthGetResponse = responseGet;
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    public static final class OAuthPermissionViewHolder extends SimpleRecyclerAdapter.ViewHolder<PermissionModel> {
        private final OauthTokenPermissionDetailedListItemBinding binding;

        /* JADX WARN: Illegal instructions before constructor call */
        public OAuthPermissionViewHolder(OauthTokenPermissionDetailedListItemBinding oauthTokenPermissionDetailedListItemBinding) {
            d0.z.d.m.checkNotNullParameter(oauthTokenPermissionDetailedListItemBinding, "binding");
            ConstraintLayout constraintLayout = oauthTokenPermissionDetailedListItemBinding.a;
            d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            super(constraintLayout);
            this.binding = oauthTokenPermissionDetailedListItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public /* bridge */ /* synthetic */ void bind(PermissionModel permissionModel) throws OAuthPermissionViews.InvalidScopeException {
            bind2(permissionModel);
        }

        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(PermissionModel data) throws OAuthPermissionViews.InvalidScopeException {
            d0.z.d.m.checkNotNullParameter(data, "data");
            if (data.getScope() != null) {
                this.binding.f2133b.setImageResource(R.drawable.ic_check_circle_green_24dp);
                TextView textView = this.binding.c;
                d0.z.d.m.checkNotNullExpressionValue(textView, "binding.oauthTokenPermissionDetailedName");
                OAuthPermissionViews.a(textView, data.getScope());
                return;
            }
            if (data.getFakeText() != null) {
                this.binding.f2133b.setImageResource(R.drawable.ic_close_circle_grey_24dp);
                this.binding.c.setText(data.getFakeText().intValue());
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    public static final class PermissionModel {
        private final Integer fakeText;
        private final OAuthScope scope;

        public PermissionModel(OAuthScope oAuthScope, Integer num) {
            this.scope = oAuthScope;
            this.fakeText = num;
        }

        public final Integer getFakeText() {
            return this.fakeText;
        }

        public final OAuthScope getScope() {
            return this.scope;
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$authorizeApplication$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            d0.z.d.m.checkNotNullParameter(error, "error");
            WidgetAuthCaptcha.Companion companion = WidgetAuthCaptcha.INSTANCE;
            Context contextRequireContext = WidgetOauth2Authorize.this.requireContext();
            ActivityResultLauncher<Intent> captchaLauncher = WidgetOauth2Authorize.this.getCaptchaLauncher();
            ValidationManager validationManagerAccess$getValidationManager$p = WidgetOauth2Authorize.access$getValidationManager$p(WidgetOauth2Authorize.this);
            Error.Response response = error.getResponse();
            d0.z.d.m.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            d0.z.d.m.checkNotNullExpressionValue(messages, "error.response.messages");
            companion.processErrorsForCaptcha(contextRequireContext, captchaLauncher, u.toMutableList((Collection) validationManagerAccess$getValidationManager$p.setErrors(messages)), error);
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$authorizeApplication$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function1<RestAPIParams.OAuth2Authorize.ResponsePost, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) throws Exception {
            invoke2(responsePost);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponsePost responsePost) throws Exception {
            d0.z.d.m.checkNotNullParameter(responsePost, "it");
            Uri uri = Uri.parse(responsePost.getLocation());
            Logger.d$default(AppLog.g, "Redirect OAuth flow to: " + uri, null, 2, null);
            Intent intentAddFlags = new Intent("android.intent.action.VIEW", uri).addFlags(268435456);
            d0.z.d.m.checkNotNullExpressionValue(intentAddFlags, "Intent(Intent.ACTION_VIE…t.FLAG_ACTIVITY_NEW_TASK)");
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.startActivity(intentAddFlags);
            }
            AppActivity appActivity2 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.setResult(-1);
            }
            AppActivity appActivity3 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity3 != null) {
                appActivity3.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$configureNotSupportedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Uri $uri;

        public AnonymousClass1(Uri uri) {
            this.$uri = uri;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws Exception {
            m.c(a.x(view, "it", "it.context"), String.valueOf(this.$uri), 0, 4);
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$configureSecurityNoticeUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            d0.z.d.m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetOauth2Authorize.this.requireContext(), R.attr.colorHeaderPrimary));
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetOauth2Authorize.access$authorizeApplication(WidgetOauth2Authorize.this, null);
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.setResult(0);
            }
            AppActivity appActivity2 = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity2 != null) {
                appActivity2.finish();
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3<R> implements Func0<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.finishAndRemoveTask();
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            d0.z.d.m.checkNotNullParameter(error, "error");
            Error.Response response = error.getResponse();
            d0.z.d.m.checkNotNullExpressionValue(response, "error.response");
            Map<String, List<String>> messages = response.getMessages();
            d0.z.d.m.checkNotNullExpressionValue(messages, "it");
            if (!(!messages.isEmpty())) {
                messages = null;
            }
            if (messages == null) {
                Error.Response response2 = error.getResponse();
                d0.z.d.m.checkNotNullExpressionValue(response2, "error.response");
                messages = g0.mapOf(o.to(WidgetOauth2Authorize.ROOT_ERROR_KEY, d0.t.m.listOf(response2.getMessage())));
            }
            error.setShowErrorToasts(!WidgetOauth2Authorize.access$getValidationManager$p(WidgetOauth2Authorize.this).setErrors(messages).isEmpty());
            AppActivity appActivity = WidgetOauth2Authorize.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetOauth2Authorize.kt */
    /* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function1<RestAPIParams.OAuth2Authorize.ResponseGet, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            invoke2(responseGet);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestAPIParams.OAuth2Authorize.ResponseGet responseGet) {
            d0.z.d.m.checkNotNullParameter(responseGet, "response");
            WidgetOauth2Authorize.this.getOauth2ViewModel().setOauthGetResponse(responseGet);
            WidgetOauth2Authorize.this.configureUI(responseGet);
        }
    }

    public WidgetOauth2Authorize() {
        super(R.layout.widget_oauth_authorize);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetOauth2Authorize$binding$2.INSTANCE, null, 2, null);
        this.captchaLauncher = WidgetAuthCaptcha.INSTANCE.registerForResult(this, new WidgetOauth2Authorize$captchaLauncher$1(this));
        WidgetOauth2Authorize$oauth2ViewModel$2 widgetOauth2Authorize$oauth2ViewModel$2 = WidgetOauth2Authorize$oauth2ViewModel$2.INSTANCE;
        b.a.d.g0 g0Var = new b.a.d.g0(this);
        this.oauth2ViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(OAuth2ViewModel.class), new WidgetOauth2Authorize$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetOauth2Authorize$oauth2ViewModel$2));
        this.validationManager = g.lazy(new WidgetOauth2Authorize$validationManager$2(this));
        this.adapter = new SimpleRecyclerAdapter<>(null, WidgetOauth2Authorize$adapter$1.INSTANCE, 1, null);
    }

    public static final /* synthetic */ void access$authorizeApplication(WidgetOauth2Authorize widgetOauth2Authorize, CaptchaHelper.CaptchaPayload captchaPayload) {
        widgetOauth2Authorize.authorizeApplication(captchaPayload);
    }

    public static final /* synthetic */ ValidationManager access$getValidationManager$p(WidgetOauth2Authorize widgetOauth2Authorize) {
        return widgetOauth2Authorize.getValidationManager();
    }

    private final void authorizeApplication(CaptchaHelper.CaptchaPayload captchaPayload) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().post(captchaPayload != null ? captchaPayload.getCaptchaKey() : null, captchaPayload != null ? captchaPayload.getCaptchaRqtoken() : null), false, 1, null), this, null, 2, null), getClass(), (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    private final void configureAgeNoticeUI(long clientId) {
        long snowflake = TimeUtils.parseSnowflake(Long.valueOf(clientId));
        TextView textView = getBinding().f2506b;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeAgeNotice");
        b.n(textView, R.string.oauth2_details_creation_date, new Object[]{DateUtils.formatDateTime(requireContext(), snowflake, 65536)}, null, 4);
    }

    private final void configureNotSupportedUI(Uri uri) {
        LinearLayout linearLayout = getBinding().j;
        d0.z.d.m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(0);
        LinearLayout linearLayout2 = getBinding().h;
        d0.z.d.m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().e;
        d0.z.d.m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(8);
        getBinding().n.setOnClickListener(new AnonymousClass1(uri));
    }

    private final void configureSecurityNoticeUI(List<String> scopeNames) {
        int i = scopeNames.contains(OAuthScope.MessagesRead.INSTANCE.getScopeName()) ? R.string.oauth2_can_read_notice : R.string.oauth2_cannot_read_send_notice;
        TextView textView = getBinding().m;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeSecurityNotice");
        b.m(textView, i, new Object[0], new AnonymousClass1());
    }

    public static /* synthetic */ void getCaptchaLauncher$annotations() {
    }

    private final int getRandomFakeScopeText() {
        switch (c.k.nextInt(8)) {
            case 0:
                return R.string.oauth2_fake_scope_1;
            case 1:
                return R.string.oauth2_fake_scope_2;
            case 2:
                return R.string.oauth2_fake_scope_3;
            case 3:
                return R.string.oauth2_fake_scope_4;
            case 4:
                return R.string.oauth2_fake_scope_5;
            case 5:
                return R.string.oauth2_fake_scope_6;
            case 6:
                return R.string.oauth2_fake_scope_7;
            default:
                return R.string.oauth2_fake_scope_8;
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void onUnknownScope(OAuthPermissionViews.InvalidScopeException e) {
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("invalid scope ");
        sbU.append(e.getScope());
        sbU.append(" in ");
        sbU.append(getClass().getSimpleName());
        Logger.e$default(appLog, sbU.toString(), e, null, 4, null);
        m.h(requireContext(), b.h(requireContext(), R.string.oauth2_request_invalid_scope, new Object[]{e.getScope()}, null, 4), 1, null, 8);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.setResult(0);
            appActivity.finish();
        }
    }

    public void configureUI(RestAPIParams.OAuth2Authorize.ResponseGet data) {
        d0.z.d.m.checkNotNullParameter(data, "data");
        LinearLayout linearLayout = getBinding().j;
        d0.z.d.m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = getBinding().h;
        d0.z.d.m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeLoading");
        linearLayout2.setVisibility(8);
        LinearLayout linearLayout3 = getBinding().e;
        d0.z.d.m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeContent");
        linearLayout3.setVisibility(0);
        User user = data.getUser();
        SimpleDraweeView simpleDraweeView = getBinding().p;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "binding.oauthAuthorizeUserIcon");
        Long lValueOf = Long.valueOf(user.getId());
        NullSerializable<String> nullSerializableA = user.a();
        MGImages.setImage$default(simpleDraweeView, IconUtils.getForUser$default(lValueOf, nullSerializableA != null ? nullSerializableA.a() : null, null, false, null, 28, null), 0, 0, false, null, null, 124, null);
        Application application = data.getApplication();
        TextView textView = getBinding().d;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.oauthAuthorizeApplicationName");
        textView.setText(application.getName());
        TextView textView2 = getBinding().k;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.oauthAuthorizePermissionsLabelTv");
        b.n(textView2, R.string.oauth2_scopes_label, new Object[]{application.getName()}, null, 4);
        SimpleDraweeView simpleDraweeView2 = getBinding().c;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView2, "binding.oauthAuthorizeApplicationIcon");
        String icon = application.getIcon();
        MGImages.setImage$default(simpleDraweeView2, icon != null ? IconUtils.getApplicationIcon$default(application.getId(), icon, 0, 4, (Object) null) : null, 0, 0, false, null, null, 124, null);
        try {
            List listSplit$default = w.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null);
            ArrayList<String> arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
            for (String str : arrayList) {
                Objects.requireNonNull(OAuthScopeTypeAdapter.INSTANCE);
                arrayList2.add(new PermissionModel((OAuthScope) OAuthScopeTypeAdapter.a().get(str), null));
            }
            List mutableList = u.toMutableList((Collection) arrayList2);
            this.adapter.setData(u.plus((Collection) mutableList, (Iterable) (mutableList.isEmpty() ^ true ? d0.t.m.listOf(new PermissionModel(null, Integer.valueOf(getRandomFakeScopeText()))) : n.emptyList())));
            getBinding().g.setOnClickListener(new AnonymousClass3());
        } catch (OAuthPermissionViews.InvalidScopeException e) {
            onUnknownScope(e);
        }
    }

    public OAuth2Authorize createOauthAuthorize(Uri requestUrl) {
        d0.z.d.m.checkNotNullParameter(requestUrl, "requestUrl");
        return Companion.access$createOauthAuthorize(INSTANCE, requestUrl);
    }

    public final WidgetOauthAuthorizeBinding getBinding() {
        return (WidgetOauthAuthorizeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public ActivityResultLauncher<Intent> getCaptchaLauncher() {
        return this.captchaLauncher;
    }

    public final OAuth2ViewModel getOauth2ViewModel() {
        return (OAuth2ViewModel) this.oauth2ViewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().l;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.oauthAuthorizePermissionsList");
        recyclerView.setAdapter(this.adapter);
        Uri uri = (Uri) getMostRecentIntent().getParcelableExtra(INTENT_PARAM_URI);
        if (uri == null) {
            uri = Uri.EMPTY;
        }
        try {
            OAuth2ViewModel oauth2ViewModel = getOauth2ViewModel();
            d0.z.d.m.checkNotNullExpressionValue(uri, "requestUrl");
            oauth2ViewModel.setOauthAuthorize(createOauthAuthorize(uri));
            Iterator it = n.listOf((Object[]) new MaterialButton[]{getBinding().f, getBinding().i, getBinding().o}).iterator();
            while (it.hasNext()) {
                ((MaterialButton) it.next()).setOnClickListener(new WidgetOauth2Authorize$onViewBound$$inlined$forEach$lambda$1(this));
            }
            AppFragment.setOnBackPressed$default(this, new AnonymousClass3(), 0, 2, null);
            configureAgeNoticeUI(getOauth2ViewModel().getOauthAuthorize().getClientId());
            configureSecurityNoticeUI(w.split$default((CharSequence) getOauth2ViewModel().getOauthAuthorize().getScope(), new String[]{" "}, false, 0, 6, (Object) null));
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), INSTANCE.getNoticeName(getOauth2ViewModel().getOauthAuthorize().getClientId()), 0L, 2, null);
        } catch (IllegalArgumentException e) {
            Companion.access$handleError(INSTANCE, requireContext(), e, new AnonymousClass1());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppActivity appActivity = getAppActivity();
        if (appActivity == null || !appActivity.isFinishing()) {
            if (getOauth2ViewModel().getOauthAuthorize().isUnsupported()) {
                Uri uri = (Uri) getMostRecentIntent().getParcelableExtra(INTENT_PARAM_URI);
                if (uri == null) {
                    uri = Uri.EMPTY;
                }
                d0.z.d.m.checkNotNullExpressionValue(uri, "requestUrl");
                configureNotSupportedUI(uri);
                return;
            }
            RestAPIParams.OAuth2Authorize.ResponseGet oauthGetResponse = getOauth2ViewModel().getOauthGetResponse();
            if (oauthGetResponse != null) {
                configureUI(oauthGetResponse);
                return;
            }
            LinearLayout linearLayout = getBinding().j;
            d0.z.d.m.checkNotNullExpressionValue(linearLayout, "binding.oauthAuthorizeNotSupported");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().e;
            d0.z.d.m.checkNotNullExpressionValue(linearLayout2, "binding.oauthAuthorizeContent");
            linearLayout2.setVisibility(8);
            LinearLayout linearLayout3 = getBinding().h;
            d0.z.d.m.checkNotNullExpressionValue(linearLayout3, "binding.oauthAuthorizeLoading");
            linearLayout3.setVisibility(0);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(getOauth2ViewModel().getOauthAuthorize().get(), false, 1, null), this, null, 2, null), getClass(), requireContext(), (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 52, (Object) null);
        }
    }
}
