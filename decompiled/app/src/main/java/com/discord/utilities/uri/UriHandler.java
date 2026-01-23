package com.discord.utilities.uri;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.discord.C5419R;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.LayoutUnhandledUriBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.color.ColorCompat;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.guild_role_subscriptions.RoleSubscriptionsLinkingUtil;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.media.WidgetMedia;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.user.WidgetUserMentions;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p009a.p016g.WidgetMaskedLinksDialog;
import p007b.p008a.p024h.CustomTabs;
import p007b.p008a.p024h.CustomTabsPackages;
import p007b.p008a.p024h.CustomTabsPackages2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.KClass;
import p507d0.p578f0._Sequences2;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler {
    private static final String APP_PACKAGE = "com.discord";
    public static final UriHandler INSTANCE = new UriHandler();
    private static final String URL_PLAY_STORE_ALT = "https://play.google.com/store/apps/details";
    private static final String URL_PLAY_STORE_DIRECT = "market://details";

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$directToPlayStore$1 */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class C69791 extends Lambda implements Function1<String, String> {
        public final /* synthetic */ String $packageName;
        public final /* synthetic */ String $source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69791(String str, String str2) {
            super(1);
            this.$packageName = str;
            this.$source = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String str) {
            return invoke2(str);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_ID, this.$packageName);
            StringBuilder sbM833U = outline.m833U("utm_source=");
            sbM833U.append(this.$source);
            String string = builderAppendQueryParameter.appendQueryParameter(Constants.REFERRER, sbM833U.toString()).build().toString();
            Intrinsics3.checkNotNullExpressionValue(string, "Uri.parse(uri).buildUpon…ild()\n        .toString()");
            return string;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$directToPlayStore$2 */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class C69802 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ C69791 $createFullUriString$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69802(Context context, C69791 c69791) {
            super(0);
            this.$context = context;
            this.$createFullUriString$1 = c69791;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            UriHandler.handle$default(UriHandler.INSTANCE, this.$context, this.$createFullUriString$1.invoke2(UriHandler.URL_PLAY_STORE_ALT), false, false, null, 28, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$openUrlExternally$1 */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class C69821 extends Lambda implements Function1<ResolveInfo, String> {
        public static final C69821 INSTANCE = new C69821();

        public C69821() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(ResolveInfo resolveInfo) {
            return invoke2(resolveInfo);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(ResolveInfo resolveInfo) {
            return resolveInfo.activityInfo.packageName;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$openUrlExternally$2 */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class C69832 extends Lambda implements Function1<String, Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69832(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return !Intrinsics3.areEqual(str, this.$context.getPackageName());
        }
    }

    private UriHandler() {
    }

    public static final /* synthetic */ void access$openUrlExternally(UriHandler uriHandler, Context context, Uri uri, String str, boolean z2, Function0 function0) {
        uriHandler.openUrlExternally(context, uri, str, z2, function0);
    }

    public static final void directToPlayStore(Context context) {
        directToPlayStore$default(context, null, null, 6, null);
    }

    public static final void directToPlayStore(Context context, String str) {
        directToPlayStore$default(context, str, null, 4, null);
    }

    public static final void directToPlayStore(Context context, String packageName, String source) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(packageName, "packageName");
        Intrinsics3.checkNotNullParameter(source, "source");
        C69791 c69791 = new C69791(packageName, source);
        handle$default(INSTANCE, context, c69791.invoke2(URL_PLAY_STORE_DIRECT), false, false, new C69802(context, c69791), 12, null);
    }

    public static /* synthetic */ void directToPlayStore$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "com.discord";
        }
        if ((i & 4) != 0) {
            str2 = "discord";
        }
        directToPlayStore(context, str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handle$default(UriHandler uriHandler, Context context, String str, boolean z2, boolean z3, Function0 function0, int i, Object obj) {
        boolean z4 = (i & 4) != 0 ? false : z2;
        boolean z5 = (i & 8) != 0 ? false : z3;
        if ((i & 16) != 0) {
            function0 = null;
        }
        uriHandler.handle(context, str, z4, z5, function0);
    }

    public static final void handleOrUntrusted(Context context, String url, String mask) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(url, "url");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (companion.getMaskedLinks().isTrustedDomain(url, mask)) {
            handle$default(INSTANCE, context, url, false, false, null, 28, null);
        } else {
            Objects.requireNonNull(WidgetMaskedLinksDialog.INSTANCE);
            companion.getNotices().requestToShow(new StoreNotices.Notice("WIDGET_SPOOPY_LINKS_DIALOG", null, 0L, 0, false, Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetHome.class), Reflection2.getOrCreateKotlinClass(WidgetUserMentions.class), Reflection2.getOrCreateKotlinClass(WidgetSearch.class), Reflection2.getOrCreateKotlinClass(WidgetChannelPinnedMessages.class), Reflection2.getOrCreateKotlinClass(WidgetMedia.class)}), 0L, false, 0L, new UriHandler2(url), Opcodes.I2F, null));
        }
    }

    public static /* synthetic */ void handleOrUntrusted$default(Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        handleOrUntrusted(context, str, str2);
    }

    private final boolean handleUriSpecialCase(Context context, Uri uri) {
        return RoleSubscriptionsLinkingUtil.INSTANCE.tryPerformHandoff(context, uri);
    }

    private final void openUrl(Context context, Uri uri, String url, boolean forceExternal, boolean preventCustomTab, Function0<Unit> onFailure) {
        if (!(!preventCustomTab && StoreStream.INSTANCE.getUserSettings().getIsChromeCustomTabsEnabled())) {
            openUrlExternally(context, uri, url, forceExternal, onFailure);
            return;
        }
        AppTransitionActivity.f14963j = true;
        int themedColor = ColorCompat.getThemedColor(context, C5419R.attr.colorPrimary);
        C69811 c69811 = new C69811(context, uri, url, forceExternal, onFailure);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(c69811, "onFailure");
        String strM194a = forceExternal ? CustomTabsPackages2.f652a.m194a(context, new CustomTabs(context)) : CustomTabsPackages2.f652a.m194a(context, CustomTabsPackages.f651j);
        if (strM194a == null) {
            c69811.invoke();
            return;
        }
        CustomTabColorSchemeParams customTabColorSchemeParamsBuild = new CustomTabColorSchemeParams.Builder().setNavigationBarColor(themedColor).setToolbarColor(themedColor).setSecondaryToolbarColor(themedColor).build();
        Intrinsics3.checkNotNullExpressionValue(customTabColorSchemeParamsBuild, "CustomTabColorSchemePara…Color)\n          .build()");
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().setDefaultColorSchemeParams(customTabColorSchemeParamsBuild).setShowTitle(false).setStartAnimations(context, C5419R.anim.activity_slide_horizontal_open_in, C5419R.anim.activity_slide_horizontal_open_out).setExitAnimations(context, C5419R.anim.activity_slide_horizontal_close_in, C5419R.anim.activity_slide_horizontal_close_out).build();
        Intrinsics3.checkNotNullExpressionValue(customTabsIntentBuild, "CustomTabsIntent.Builder…ResId)\n          .build()");
        if (forceExternal) {
            try {
                Intent intent = customTabsIntentBuild.intent;
                Intrinsics3.checkNotNullExpressionValue(intent, "customTabsIntent.intent");
                intent.setPackage(strM194a);
            } catch (ActivityNotFoundException unused) {
                c69811.invoke();
                return;
            }
        }
        Intent intent2 = customTabsIntentBuild.intent;
        Intrinsics3.checkNotNullExpressionValue(intent2, "customTabsIntent.intent");
        intent2.setData(uri);
        customTabsIntentBuild.launchUrl(context, uri);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openUrl$default(UriHandler uriHandler, Context context, Uri uri, String str, boolean z2, boolean z3, Function0 function0, int i, Object obj) {
        uriHandler.openUrl(context, uri, str, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? null : function0);
    }

    private final void openUrlExternally(Context context, Uri uri, String url, boolean forceExternal, Function0<Unit> onFailure) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (forceExternal) {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                Intrinsics3.checkNotNullExpressionValue(listQueryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
                intent.setPackage((String) _Sequences2.firstOrNull(_Sequences2.filter(_Sequences2.mapNotNull(_Collections.asSequence(listQueryIntentActivities), C69821.INSTANCE), new C69832(context))));
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            if ((onFailure == null || onFailure.invoke() == null) && url != null) {
                INSTANCE.showUnhandledUrlDialog(context, url);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openUrlExternally$default(UriHandler uriHandler, Context context, Uri uri, String str, boolean z2, Function0 function0, int i, Object obj) {
        uriHandler.openUrlExternally(context, uri, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : function0);
    }

    private final void showUnhandledUrlDialog(Context context, String url) {
        AnalyticsTracker.INSTANCE.unhandledUrl(url);
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.layout_unhandled_uri, (ViewGroup) null, false);
        int i = C5419R.id.unhandled_uri_display;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.unhandled_uri_display);
        if (textView != null) {
            i = C5419R.id.unhandled_uri_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.unhandled_uri_okay);
            if (materialButton != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                LayoutUnhandledUriBinding layoutUnhandledUriBinding = new LayoutUnhandledUriBinding(linearLayout, textView, materialButton);
                Intrinsics3.checkNotNullExpressionValue(layoutUnhandledUriBinding, "LayoutUnhandledUriBindin…utInflater.from(context))");
                AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(linearLayout).create();
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.unhandledUriDisplay");
                textView.setText(url);
                textView.setOnClickListener(new UriHandler3(layoutUnhandledUriBinding, url));
                materialButton.setOnClickListener(new UriHandler4(alertDialogCreate));
                alertDialogCreate.show();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void handle(Context context, String url, boolean forceExternal, boolean preventCustomTab, Function0<Unit> onFailure) {
        Uri uri;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (url != null) {
            try {
                uri = Uri.parse(url);
            } catch (Exception unused) {
                uri = null;
            }
            Uri uri2 = uri;
            if (uri2 != null) {
                if (forceExternal || !handleUriSpecialCase(context, uri2)) {
                    openUrl(context, uri2, url, forceExternal, preventCustomTab, onFailure);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$openUrl$1 */
    /* JADX INFO: compiled from: UriHandler.kt */
    public static final class C69811 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $forceExternal;
        public final /* synthetic */ Function0 $onFailure;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69811(Context context, Uri uri, String str, boolean z2, Function0 function0) {
            super(0);
            this.$context = context;
            this.$uri = uri;
            this.$url = str;
            this.$forceExternal = z2;
            this.$onFailure = function0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppTransitionActivity.f14963j = false;
            UriHandler.access$openUrlExternally(UriHandler.INSTANCE, this.$context, this.$uri, this.$url, this.$forceExternal, this.$onFailure);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }
    }
}
