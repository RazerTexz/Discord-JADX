package com.discord.utilities.intent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.content.p004pm.ShortcutManagerCompat;
import com.adjust.sdk.Constants;
import com.discord.C5419R;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIBuilder;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AppStartAnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.RouteHandlers;
import com.discord.utilities.logging.Logger;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.firebase.appindexing.internal.zza;
import com.google.firebase.appindexing.internal.zzc;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p007b.p008a.p018d.p019m0.RoutingPatterns;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p365k.AbstractC4561b;
import p007b.p225i.p361c.p365k.p366c.C4562a;
import p007b.p225i.p361c.p365k.p367d.C4564b;
import p507d0.Tuples;
import p507d0.p579g0.Regex5;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: IntentUtils.kt */
/* loaded from: classes2.dex */
public final class IntentUtils {
    public static final IntentUtils INSTANCE = new IntentUtils();
    private static final Map<Regex, Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata>> pathRouterMap;

    /* compiled from: IntentUtils.kt */
    public static final class RouteBuilders {
        public static final RouteBuilders INSTANCE = new RouteBuilders();

        /* compiled from: IntentUtils.kt */
        public static final class SDK {
            public static final SDK INSTANCE = new SDK();

            private SDK() {
            }

            public static final Intent join(String deeplink, long applicationId, String secret) {
                Intrinsics3.checkNotNullParameter(deeplink, Constants.DEEPLINK);
                return new Intent("com.discord.intent.action.SDK", Uri.parse(deeplink).buildUpon().appendPath("join").appendQueryParameter(ModelAuditLogEntry.CHANGE_KEY_APPLICATION_ID, String.valueOf(applicationId)).appendQueryParameter("secret", secret).build());
            }
        }

        /* compiled from: IntentUtils.kt */
        public static final class Uris {
            public static final Uris INSTANCE = new Uris();

            private Uris() {
            }

            public final Uri getApp() {
                Uri uri = Uri.parse("discord://app");
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app\")");
                return uri;
            }

            public final Uri getOauth2Authorize() {
                Uri uri = Uri.parse("discord://action/oauth2/authorize");
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://action/oauth2/authorize\")");
                return uri;
            }

            public final Uri getSelectSettingsVoice() {
                Uri uri = Uri.parse("discord://app/settings/voice");
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(\"discord://app/settings/voice\")");
                return uri;
            }
        }

        private RouteBuilders() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.StringBuilder] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Long] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.String] */
        public static final Intent selectChannel(long channelId, long guildId, Long messageId) {
            Object objValueOf = (guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId);
            if (messageId == 0) {
                messageId = "";
            }
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + objValueOf + MentionUtils.SLASH_CHAR + channelId + MentionUtils.SLASH_CHAR + messageId));
        }

        public static /* synthetic */ Intent selectChannel$default(long j, long j2, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            if ((i & 4) != 0) {
                l = null;
            }
            return selectChannel(j, j2, l);
        }

        public static final Intent selectExternalEvent(long guildId, Long eventId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/events/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId)) + MentionUtils.SLASH_CHAR + eventId));
        }

        public static final Intent selectGuild(long guildId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/" + ((guildId == 0 || guildId == -1) ? "@me" : Long.valueOf(guildId))));
        }

        public static final Intent selectUserProfile(long userId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/users/" + userId));
        }

        public final Intent connectVoice(long voiceChannelId) {
            return new Intent("com.discord.intent.action.CONNECT", Uri.parse("discord://app/connect/" + voiceChannelId));
        }

        public final Intent selectDirectMessage(long userId) {
            return new Intent("android.intent.action.VIEW", Uri.parse("discord://app/channels/@me/user/" + userId));
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Intent selectGuildTemplate(String guildTemplateText, String source) {
            Uri uri = Uri.parse(guildTemplateText);
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (uri.getScheme() == null) {
                if (guildTemplateText != null) {
                    RoutingPatterns routingPatterns = RoutingPatterns.f538G;
                    if (StringsJVM.startsWith$default(guildTemplateText, RoutingPatterns.f543e, false, 2, null)) {
                        uri = Uri.parse("https://" + guildTemplateText);
                    } else {
                        uri = Uri.parse("discord://app/template/" + guildTemplateText + "?source=" + source);
                    }
                }
            }
            Intent data = new Intent().setData(uri);
            Intrinsics3.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
            return data;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Intent selectInvite(String inviteText, String source) {
            Uri uri = Uri.parse(inviteText);
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (uri.getScheme() == null) {
                if (inviteText != null) {
                    RoutingPatterns routingPatterns = RoutingPatterns.f538G;
                    if (StringsJVM.startsWith$default(inviteText, RoutingPatterns.f542d, false, 2, null)) {
                        uri = Uri.parse("https://" + inviteText);
                    } else {
                        uri = Uri.parse("discord://app/invite/" + inviteText + "?source=" + source);
                    }
                }
            }
            Intent data = new Intent().setData(uri);
            Intrinsics3.checkNotNullExpressionValue(data, "Intent().setData(uriMerged)");
            return data;
        }
    }

    /* compiled from: IntentUtils.kt */
    /* renamed from: com.discord.utilities.intent.IntentUtils$consumeExternalRoutingIntent$1 */
    public static final class C67831 extends Lambda implements Function2<Uri, Boolean, Unit> {
        public final /* synthetic */ Intent $intent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67831(Intent intent) {
            super(2);
            this.$intent = intent;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
            invoke(uri, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(Uri uri, boolean z2) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Map<String, Object> mapBuildTrackingData = NotificationClient.INSTANCE.buildTrackingData(this.$intent);
            Iterator<T> it = mapBuildTrackingData.keySet().iterator();
            while (it.hasNext()) {
                this.$intent.removeExtra((String) it.next());
            }
            AnalyticsTracker.appNotificationClicked(mapBuildTrackingData);
            AppStartAnalyticsTracker.INSTANCE.getInstance().appOpen(uri, z2, !mapBuildTrackingData.isEmpty());
        }
    }

    /* compiled from: IntentUtils.kt */
    /* renamed from: com.discord.utilities.intent.IntentUtils$consumeRoutingIntent$1 */
    public static final class C67841 extends Lambda implements Function2<Uri, Boolean, Unit> {
        public static final C67841 INSTANCE = new C67841();

        public C67841() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Uri uri, Boolean bool) {
            invoke(uri, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(Uri uri, boolean z2) {
            Intrinsics3.checkNotNullParameter(uri, "<anonymous parameter 0>");
        }
    }

    static {
        RoutingPatterns routingPatterns = RoutingPatterns.f538G;
        Regex regex = RoutingPatterns.f537F;
        RouteHandlers routeHandlers = RouteHandlers.INSTANCE;
        pathRouterMap = Maps6.mapOf(Tuples.m10073to(RoutingPatterns.f558t, IntentUtils$pathRouterMap$1.INSTANCE), Tuples.m10073to(RoutingPatterns.f559u, IntentUtils$pathRouterMap$2.INSTANCE), Tuples.m10073to(regex, new IntentUtils$pathRouterMap$3(routeHandlers)), Tuples.m10073to(RoutingPatterns.f560v, new IntentUtils$pathRouterMap$4(routeHandlers)), Tuples.m10073to(RoutingPatterns.f562x, new IntentUtils$pathRouterMap$5(routeHandlers)), Tuples.m10073to(RoutingPatterns.f563y, new IntentUtils$pathRouterMap$6(routeHandlers)), Tuples.m10073to(RoutingPatterns.f564z, new IntentUtils$pathRouterMap$7(routeHandlers)), Tuples.m10073to(RoutingPatterns.f532A, new IntentUtils$pathRouterMap$8(routeHandlers)), Tuples.m10073to(RoutingPatterns.f557s, new IntentUtils$pathRouterMap$9(routeHandlers)), Tuples.m10073to(RoutingPatterns.f561w, new IntentUtils$pathRouterMap$10(routeHandlers)), Tuples.m10073to(RoutingPatterns.f534C, new IntentUtils$pathRouterMap$11(routeHandlers)), Tuples.m10073to(RoutingPatterns.f535D, new IntentUtils$pathRouterMap$12(routeHandlers)), Tuples.m10073to(RoutingPatterns.f536E, new IntentUtils$pathRouterMap$13(routeHandlers)), Tuples.m10073to(RoutingPatterns.f533B, new IntentUtils$pathRouterMap$14(routeHandlers)), Tuples.m10073to(RoutingPatterns.f551m, new IntentUtils$pathRouterMap$15(routeHandlers)));
    }

    private IntentUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean consumeRoutingIntent$default(IntentUtils intentUtils, Intent intent, Context context, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = C67841.INSTANCE;
        }
        return intentUtils.consumeRoutingIntent(intent, context, function2);
    }

    private final Uri externalize(Uri uri) {
        Uri.Builder builderScheme = uri.buildUpon().scheme(Constants.SCHEME);
        RoutingPatterns routingPatterns = RoutingPatterns.f538G;
        return builderScheme.authority(RoutingPatterns.f539a).build();
    }

    private final void notifyFirebaseUserActionStatus(Intent intent, boolean isHandledSuccessfully) {
        String stringExtra = intent.getStringExtra("actions.fulfillment.extra.ACTION_TOKEN");
        if (stringExtra != null) {
            Intrinsics3.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(In…A_VOICE_ACTION) ?: return");
            String str = isHandledSuccessfully ? "http://schema.org/CompletedActionStatus" : "http://schema.org/FailedActionStatus";
            C4562a c4562a = new C4562a();
            c4562a.f12169f = stringExtra;
            c4562a.f12167e = str;
            AnimatableValueParser.m595z(stringExtra, "setActionToken is required before calling build().");
            AnimatableValueParser.m595z(new String(c4562a.f12167e), "setActionStatus is required before calling build().");
            c4562a.m6344a("actionToken", c4562a.f12169f);
            AbstractC4561b c4564b = null;
            if ((c4562a.f12165c == null ? null : new String(c4562a.f12165c)) == null) {
                c4562a.f12165c = "AssistAction";
                c4562a.m6344a(ModelAuditLogEntry.CHANGE_KEY_NAME, "AssistAction");
            }
            if ((c4562a.f12166d == null ? null : new String(c4562a.f12166d)) == null) {
                String strValueOf = String.valueOf(c4562a.f12169f);
                String strConcat = strValueOf.length() != 0 ? "https://developers.google.com/actions?invocation=".concat(strValueOf) : new String("https://developers.google.com/actions?invocation=");
                Objects.requireNonNull(strConcat, "null reference");
                c4562a.f12166d = strConcat;
                c4562a.m6344a("url", strConcat);
            }
            AnimatableValueParser.m595z(c4562a.f12165c, "setObject is required before calling build().");
            AnimatableValueParser.m595z(c4562a.f12166d, "setObject is required before calling build().");
            zza zzaVar = new zza(c4562a.f12164b, c4562a.f12165c, c4562a.f12166d, null, new zzc(true), c4562a.f12167e, c4562a.f12163a);
            synchronized (AbstractC4561b.class) {
                WeakReference<AbstractC4561b> weakReference = AbstractC4561b.f12168a;
                if (weakReference != null) {
                    c4564b = weakReference.get();
                }
                if (c4564b == null) {
                    FirebaseApp2 firebaseApp2M6327b = FirebaseApp2.m6327b();
                    firebaseApp2M6327b.m6330a();
                    c4564b = new C4564b(firebaseApp2M6327b.f12118d);
                    AbstractC4561b.f12168a = new WeakReference<>(c4564b);
                }
            }
            c4564b.mo6345a(zzaVar);
        }
    }

    public static final void performChooserSendIntent(Context context, String str) {
        performChooserSendIntent$default(context, str, null, 4, null);
    }

    public static final void performChooserSendIntent(Context context, String text, CharSequence chooserText) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(chooserText, "chooserText");
        context.startActivity(Intent.createChooser(INSTANCE.sendText(new Intent("android.intent.action.SEND"), text), chooserText));
    }

    public static /* synthetic */ void performChooserSendIntent$default(Context context, String str, CharSequence charSequence, int i, Object obj) {
        if ((i & 4) != 0) {
            charSequence = context.getString(C5419R.string.share);
            Intrinsics3.checkNotNullExpressionValue(charSequence, "context.getString(R.string.share)");
        }
        performChooserSendIntent(context, str, charSequence);
    }

    private final Intent sendText(Intent intent, String str) {
        intent.setAction("android.intent.action.SEND");
        intent.setType(RestAPIBuilder.CONTENT_TYPE_TEXT);
        if (str == null) {
            str = "";
        }
        intent.putExtra("android.intent.extra.TEXT", str);
        return intent;
    }

    public final boolean consumeExternalRoutingIntent(Intent intent, Context context) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        StoreStream.INSTANCE.getDynamicLinkCache().storeLinkIfExists(intent, context);
        return consumeRoutingIntent(intent, context, new C67831(intent));
    }

    public final boolean consumeRoutingIntent(Intent intent, Context context, Function2<? super Uri, ? super Boolean, Unit> callback) {
        MatchResult matchResultMatchEntire;
        RouteHandlers.AnalyticsMetadata unknown;
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(callback, "callback");
        Uri data = intent.getData();
        if (data == null) {
            data = Uri.EMPTY;
        }
        Intrinsics3.checkNotNullExpressionValue(data, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        boolean z2 = isDiscordAppUri(data) || isHttpDomainUrl(data);
        callback.invoke(data, Boolean.valueOf(z2));
        if (z2) {
            AppLog appLog = AppLog.f14950g;
            String simpleName = IntentUtils.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
            String string = data.toString();
            if (string == null) {
                string = "<null>";
            }
            Intrinsics3.checkNotNullExpressionValue(string, "uri?.toString() ?: \"<null>\"");
            appLog.m8365f(simpleName, string);
            for (Map.Entry<Regex, Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata>> entry : pathRouterMap.entrySet()) {
                Regex key = entry.getKey();
                Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> value = entry.getValue();
                String path = data.getPath();
                if (path != null) {
                    Intrinsics3.checkNotNullExpressionValue(path, "it");
                    matchResultMatchEntire = key.matchEntire(path);
                } else {
                    matchResultMatchEntire = null;
                }
                if (matchResultMatchEntire != null) {
                    try {
                        unknown = value.invoke(data, matchResultMatchEntire, context);
                    } catch (Exception unused) {
                        unknown = RouteHandlers.AnalyticsMetadata.INSTANCE.getUNKNOWN();
                    }
                    intent.setData(Uri.EMPTY);
                    boolean z3 = !Intrinsics3.areEqual(unknown, RouteHandlers.AnalyticsMetadata.INSTANCE.getUNKNOWN());
                    Logger.d$default(AppLog.f14950g, "Intent handler activated for " + data + ", consumed: " + z3, null, 2, null);
                    notifyFirebaseUserActionStatus(intent, z3);
                    StoreStream.INSTANCE.getAnalytics().deepLinkReceived(intent, unknown);
                    return z3;
                }
            }
        }
        notifyFirebaseUserActionStatus(intent, false);
        return false;
    }

    public final Long getDirectShareId(Intent intent) {
        Intrinsics3.checkNotNullParameter(intent, "$this$getDirectShareId");
        String stringExtra = intent.getStringExtra(ShortcutManagerCompat.EXTRA_SHORTCUT_ID);
        if (stringExtra != null) {
            return StringNumberConversions.toLongOrNull(stringExtra);
        }
        return null;
    }

    public final boolean isDiscordAppUri(Uri uri) {
        String lowerCase;
        int iHashCode;
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        if (StringsJVM.equals(uri.getScheme(), "discord", true)) {
            String host = uri.getHost();
            if (host != null) {
                Locale locale = Locale.ENGLISH;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                lowerCase = host.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            if (lowerCase != null && ((iHashCode = lowerCase.hashCode()) == -1422950858 ? lowerCase.equals("action") : iHashCode == 96801 && lowerCase.equals("app"))) {
                return true;
            }
        }
        return false;
    }

    public final boolean isHttpDomainUrl(Uri uri) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Regex regex = new Regex("https?", Regex5.IGNORE_CASE);
        String scheme = uri.getScheme();
        if (scheme == null) {
            scheme = "";
        }
        Intrinsics3.checkNotNullExpressionValue(scheme, "uri.scheme ?: \"\"");
        if (regex.matches(scheme)) {
            return RoutingPatterns.f538G.m173a(uri.getHost());
        }
        return false;
    }

    public final Intent toExternalizedSend(Intent intent) {
        Uri uriExternalize;
        Intrinsics3.checkNotNullParameter(intent, "$this$toExternalizedSend");
        Uri data = intent.getData();
        if (data == null || (uriExternalize = INSTANCE.externalize(data)) == null) {
            uriExternalize = Uri.EMPTY;
        }
        intent.setData(uriExternalize);
        IntentUtils intentUtils = INSTANCE;
        Uri data2 = intent.getData();
        intentUtils.sendText(intent, data2 != null ? data2.toString() : null);
        return intent;
    }
}
