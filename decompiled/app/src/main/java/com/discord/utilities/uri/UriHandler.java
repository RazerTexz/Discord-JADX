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
import b.a.h.b;
import b.d.b.a.a;
import com.adjust.sdk.Constants;
import com.discord.R;
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
import d0.e0.c;
import d0.f0.q;
import d0.t.n;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* compiled from: UriHandler.kt */
/* loaded from: classes2.dex */
public final class UriHandler {
    private static final String APP_PACKAGE = "com.discord";
    public static final UriHandler INSTANCE = new UriHandler();
    private static final String URL_PLAY_STORE_ALT = "https://play.google.com/store/apps/details";
    private static final String URL_PLAY_STORE_DIRECT = "market://details";

    /* compiled from: UriHandler.kt */
    /* renamed from: com.discord.utilities.uri.UriHandler$directToPlayStore$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, String> {
        public final /* synthetic */ String $packageName;
        public final /* synthetic */ String $source;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2) {
            super(1);
            this.$packageName = str;
            this.$source = str2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String str) {
            return invoke2(str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String str) {
            m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Uri.Builder builderAppendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_ID, this.$packageName);
            StringBuilder sbU = a.U("utm_source=");
            sbU.append(this.$source);
            String string = builderAppendQueryParameter.appendQueryParameter(Constants.REFERRER, sbU.toString()).build().toString();
            m.checkNotNullExpressionValue(string, "Uri.parse(uri).buildUpon…ild()\n        .toString()");
            return string;
        }
    }

    /* compiled from: UriHandler.kt */
    /* renamed from: com.discord.utilities.uri.UriHandler$directToPlayStore$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass1 $createFullUriString$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, AnonymousClass1 anonymousClass1) {
            super(0);
            this.$context = context;
            this.$createFullUriString$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            UriHandler.handle$default(UriHandler.INSTANCE, this.$context, this.$createFullUriString$1.invoke2(UriHandler.URL_PLAY_STORE_ALT), false, false, null, 28, null);
        }
    }

    /* compiled from: UriHandler.kt */
    /* renamed from: com.discord.utilities.uri.UriHandler$openUrlExternally$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ResolveInfo, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(ResolveInfo resolveInfo) {
            return invoke2(resolveInfo);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(ResolveInfo resolveInfo) {
            return resolveInfo.activityInfo.packageName;
        }
    }

    /* compiled from: UriHandler.kt */
    /* renamed from: com.discord.utilities.uri.UriHandler$openUrlExternally$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<String, Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(String str) {
            return Boolean.valueOf(invoke2(str));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(String str) {
            m.checkNotNullParameter(str, "it");
            return !m.areEqual(str, this.$context.getPackageName());
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
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(packageName, "packageName");
        m.checkNotNullParameter(source, "source");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(packageName, source);
        handle$default(INSTANCE, context, anonymousClass1.invoke2(URL_PLAY_STORE_DIRECT), false, false, new AnonymousClass2(context, anonymousClass1), 12, null);
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

    public static /* synthetic */ void handle$default(UriHandler uriHandler, Context context, String str, boolean z2, boolean z3, Function0 function0, int i, Object obj) {
        boolean z4 = (i & 4) != 0 ? false : z2;
        boolean z5 = (i & 8) != 0 ? false : z3;
        if ((i & 16) != 0) {
            function0 = null;
        }
        uriHandler.handle(context, str, z4, z5, function0);
    }

    public static final void handleOrUntrusted(Context context, String url, String mask) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(url, "url");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (companion.getMaskedLinks().isTrustedDomain(url, mask)) {
            handle$default(INSTANCE, context, url, false, false, null, 28, null);
        } else {
            Objects.requireNonNull(b.a.a.g.a.INSTANCE);
            companion.getNotices().requestToShow(new StoreNotices.Notice("WIDGET_SPOOPY_LINKS_DIALOG", null, 0L, 0, false, n.listOf((Object[]) new c[]{a0.getOrCreateKotlinClass(WidgetHome.class), a0.getOrCreateKotlinClass(WidgetUserMentions.class), a0.getOrCreateKotlinClass(WidgetSearch.class), a0.getOrCreateKotlinClass(WidgetChannelPinnedMessages.class), a0.getOrCreateKotlinClass(WidgetMedia.class)}), 0L, false, 0L, new UriHandler$handleOrUntrusted$notice$1(url), Opcodes.I2F, null));
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
        AppTransitionActivity.j = true;
        int themedColor = ColorCompat.getThemedColor(context, R.attr.colorPrimary);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(context, uri, url, forceExternal, onFailure);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        m.checkNotNullParameter(anonymousClass1, "onFailure");
        String strA = forceExternal ? b.a.h.c.a.a(context, new b.a.h.a(context)) : b.a.h.c.a.a(context, b.j);
        if (strA == null) {
            anonymousClass1.invoke();
            return;
        }
        CustomTabColorSchemeParams customTabColorSchemeParamsBuild = new CustomTabColorSchemeParams.Builder().setNavigationBarColor(themedColor).setToolbarColor(themedColor).setSecondaryToolbarColor(themedColor).build();
        m.checkNotNullExpressionValue(customTabColorSchemeParamsBuild, "CustomTabColorSchemePara…Color)\n          .build()");
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().setDefaultColorSchemeParams(customTabColorSchemeParamsBuild).setShowTitle(false).setStartAnimations(context, R.anim.activity_slide_horizontal_open_in, R.anim.activity_slide_horizontal_open_out).setExitAnimations(context, R.anim.activity_slide_horizontal_close_in, R.anim.activity_slide_horizontal_close_out).build();
        m.checkNotNullExpressionValue(customTabsIntentBuild, "CustomTabsIntent.Builder…ResId)\n          .build()");
        if (forceExternal) {
            try {
                Intent intent = customTabsIntentBuild.intent;
                m.checkNotNullExpressionValue(intent, "customTabsIntent.intent");
                intent.setPackage(strA);
            } catch (ActivityNotFoundException unused) {
                anonymousClass1.invoke();
                return;
            }
        }
        Intent intent2 = customTabsIntentBuild.intent;
        m.checkNotNullExpressionValue(intent2, "customTabsIntent.intent");
        intent2.setData(uri);
        customTabsIntentBuild.launchUrl(context, uri);
    }

    public static /* synthetic */ void openUrl$default(UriHandler uriHandler, Context context, Uri uri, String str, boolean z2, boolean z3, Function0 function0, int i, Object obj) {
        uriHandler.openUrl(context, uri, str, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? null : function0);
    }

    private final void openUrlExternally(Context context, Uri uri, String url, boolean forceExternal, Function0<Unit> onFailure) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (forceExternal) {
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                m.checkNotNullExpressionValue(listQueryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
                intent.setPackage((String) q.firstOrNull(q.filter(q.mapNotNull(u.asSequence(listQueryIntentActivities), AnonymousClass1.INSTANCE), new AnonymousClass2(context))));
            }
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            if ((onFailure == null || onFailure.invoke() == null) && url != null) {
                INSTANCE.showUnhandledUrlDialog(context, url);
            }
        }
    }

    public static /* synthetic */ void openUrlExternally$default(UriHandler uriHandler, Context context, Uri uri, String str, boolean z2, Function0 function0, int i, Object obj) {
        uriHandler.openUrlExternally(context, uri, (i & 4) != 0 ? null : str, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : function0);
    }

    private final void showUnhandledUrlDialog(Context context, String url) {
        AnalyticsTracker.INSTANCE.unhandledUrl(url);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_unhandled_uri, (ViewGroup) null, false);
        int i = R.id.unhandled_uri_display;
        TextView textView = (TextView) viewInflate.findViewById(R.id.unhandled_uri_display);
        if (textView != null) {
            i = R.id.unhandled_uri_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.unhandled_uri_okay);
            if (materialButton != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                LayoutUnhandledUriBinding layoutUnhandledUriBinding = new LayoutUnhandledUriBinding(linearLayout, textView, materialButton);
                m.checkNotNullExpressionValue(layoutUnhandledUriBinding, "LayoutUnhandledUriBindin…utInflater.from(context))");
                AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(linearLayout).create();
                m.checkNotNullExpressionValue(textView, "binding.unhandledUriDisplay");
                textView.setText(url);
                textView.setOnClickListener(new UriHandler$showUnhandledUrlDialog$$inlined$apply$lambda$1(layoutUnhandledUriBinding, url));
                materialButton.setOnClickListener(new UriHandler$showUnhandledUrlDialog$1$2(alertDialogCreate));
                alertDialogCreate.show();
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void handle(Context context, String url, boolean forceExternal, boolean preventCustomTab, Function0<Unit> onFailure) {
        Uri uri;
        m.checkNotNullParameter(context, "context");
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

    /* compiled from: UriHandler.kt */
    /* renamed from: com.discord.utilities.uri.UriHandler$openUrl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ boolean $forceExternal;
        public final /* synthetic */ Function0 $onFailure;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, Uri uri, String str, boolean z2, Function0 function0) {
            super(0);
            this.$context = context;
            this.$uri = uri;
            this.$url = str;
            this.$forceExternal = z2;
            this.$onFailure = function0;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppTransitionActivity.j = false;
            UriHandler.access$openUrlExternally(UriHandler.INSTANCE, this.$context, this.$uri, this.$url, this.$forceExternal, this.$onFailure);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }
    }
}
