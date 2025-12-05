package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p007b.p008a.p018d.p019m0.RoutingPatterns;
import p007b.p008a.p020e.Backgrounded4;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: StoreDynamicLink.kt */
/* loaded from: classes2.dex */
public final class StoreDynamicLink {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long DYNAMIC_LINK_TIMEOUT_MS = 1000;
    private final Dispatcher dispatcher;
    private final StoreStream stream;

    /* compiled from: StoreDynamicLink.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    public static final /* data */ class DynamicLinkData {
        private final String attemptId;
        private final String authToken;
        private final String fingerprint;
        private final String guildTemplateCode;
        private final String inviteCode;
        private final Uri uri;

        public DynamicLinkData(Uri uri, String str, String str2, String str3, String str4, String str5) {
            this.uri = uri;
            this.fingerprint = str;
            this.attemptId = str2;
            this.inviteCode = str3;
            this.guildTemplateCode = str4;
            this.authToken = str5;
        }

        public static /* synthetic */ DynamicLinkData copy$default(DynamicLinkData dynamicLinkData, Uri uri, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = dynamicLinkData.uri;
            }
            if ((i & 2) != 0) {
                str = dynamicLinkData.fingerprint;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = dynamicLinkData.attemptId;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = dynamicLinkData.inviteCode;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = dynamicLinkData.guildTemplateCode;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = dynamicLinkData.authToken;
            }
            return dynamicLinkData.copy(uri, str6, str7, str8, str9, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFingerprint() {
            return this.fingerprint;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAttemptId() {
            return this.attemptId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getInviteCode() {
            return this.inviteCode;
        }

        /* renamed from: component5, reason: from getter */
        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        /* renamed from: component6, reason: from getter */
        public final String getAuthToken() {
            return this.authToken;
        }

        public final DynamicLinkData copy(Uri uri, String fingerprint, String attemptId, String inviteCode, String guildTemplateCode, String authToken) {
            return new DynamicLinkData(uri, fingerprint, attemptId, inviteCode, guildTemplateCode, authToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DynamicLinkData)) {
                return false;
            }
            DynamicLinkData dynamicLinkData = (DynamicLinkData) other;
            return Intrinsics3.areEqual(this.uri, dynamicLinkData.uri) && Intrinsics3.areEqual(this.fingerprint, dynamicLinkData.fingerprint) && Intrinsics3.areEqual(this.attemptId, dynamicLinkData.attemptId) && Intrinsics3.areEqual(this.inviteCode, dynamicLinkData.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, dynamicLinkData.guildTemplateCode) && Intrinsics3.areEqual(this.authToken, dynamicLinkData.authToken);
        }

        public final String getAttemptId() {
            return this.attemptId;
        }

        public final String getAuthToken() {
            return this.authToken;
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final String getInviteCode() {
            return this.inviteCode;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            Uri uri = this.uri;
            int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
            String str = this.fingerprint;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.attemptId;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.inviteCode;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.guildTemplateCode;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.authToken;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("DynamicLinkData(uri=");
            sbM833U.append(this.uri);
            sbM833U.append(", fingerprint=");
            sbM833U.append(this.fingerprint);
            sbM833U.append(", attemptId=");
            sbM833U.append(this.attemptId);
            sbM833U.append(", inviteCode=");
            sbM833U.append(this.inviteCode);
            sbM833U.append(", guildTemplateCode=");
            sbM833U.append(this.guildTemplateCode);
            sbM833U.append(", authToken=");
            return outline.m822J(sbM833U, this.authToken, ")");
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    /* renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$1 */
    public static final class C58781<T, R> implements Func1<Throwable, Uri> {
        public static final C58781 INSTANCE = new C58781();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Uri call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Uri call2(Throwable th) {
            return Uri.EMPTY;
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    /* renamed from: com.discord.stores.StoreDynamicLink$handleDataReceived$1 */
    public static final class C58811 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DynamicLinkData $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58811(DynamicLinkData dynamicLinkData) {
            super(0);
            this.$data = dynamicLinkData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication authentication = StoreDynamicLink.access$getStream$p(StoreDynamicLink.this).getAuthentication();
            DynamicLinkData dynamicLinkData = this.$data;
            authentication.setFingerprint(dynamicLinkData != null ? dynamicLinkData.getFingerprint() : null, false);
            DynamicLinkData dynamicLinkData2 = this.$data;
            if ((dynamicLinkData2 != null ? dynamicLinkData2.getAuthToken() : null) != null) {
                StoreDynamicLink.access$getStream$p(StoreDynamicLink.this).getAuthentication().setAuthed(this.$data.getAuthToken());
            }
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$1 */
    public static final class C58831<T, R> implements Func1<Uri, DynamicLinkData> {
        public static final C58831 INSTANCE = new C58831();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ DynamicLinkData call(Uri uri) {
            return call2(uri);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0112  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DynamicLinkData call2(Uri uri) {
            String str;
            String str2;
            String queryParameter;
            String queryParameter2;
            List<String> groupValues;
            String strPrevious;
            String path;
            List<String> groupValues2;
            String strPrevious2;
            String path2;
            String queryParameter3 = null;
            if (Intrinsics3.areEqual(uri, Uri.EMPTY)) {
                return null;
            }
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Uri uri2 = intentUtils.isHttpDomainUrl(uri) ? uri : null;
            RoutingPatterns routingPatterns = RoutingPatterns.f538G;
            Intrinsics3.checkNotNullParameter(uri, "$this$isInviteLink");
            boolean z2 = false;
            if (StringsJVM.equals(uri.getHost(), RoutingPatterns.f542d, true) || ((StringsJVM.equals(uri.getHost(), RoutingPatterns.f539a, true) || StringsJVM.equals(uri.getHost(), RoutingPatterns.f540b, true)) && (path2 = uri.getPath()) != null && RoutingPatterns.f552n.matches(path2))) {
                Regex regex = RoutingPatterns.f552n;
                String path3 = uri.getPath();
                if (path3 == null) {
                    path3 = "";
                }
                Intrinsics3.checkNotNullExpressionValue(path3, "uri.path ?: \"\"");
                MatchResult matchResultMatchEntire = regex.matchEntire(path3);
                if (matchResultMatchEntire == null || (groupValues2 = matchResultMatchEntire.getGroupValues()) == null) {
                    str = null;
                } else {
                    ListIterator<String> listIterator = groupValues2.listIterator(groupValues2.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            strPrevious2 = null;
                            break;
                        }
                        strPrevious2 = listIterator.previous();
                        if (!StringsJVM.isBlank(strPrevious2)) {
                            break;
                        }
                    }
                    str = strPrevious2;
                }
            }
            RoutingPatterns routingPatterns2 = RoutingPatterns.f538G;
            Intrinsics3.checkNotNullParameter(uri, "$this$isGuildTemplateLink");
            if (StringsJVM.equals(uri.getHost(), RoutingPatterns.f543e, true) || ((StringsJVM.equals(uri.getHost(), RoutingPatterns.f539a, true) || StringsJVM.equals(uri.getHost(), RoutingPatterns.f540b, true)) && (path = uri.getPath()) != null && RoutingPatterns.f554p.matches(path))) {
                z2 = true;
            }
            if (z2) {
                Regex regex2 = RoutingPatterns.f554p;
                String path4 = uri.getPath();
                String str3 = path4 != null ? path4 : "";
                Intrinsics3.checkNotNullExpressionValue(str3, "uri.path ?: \"\"");
                MatchResult matchResultMatchEntire2 = regex2.matchEntire(str3);
                if (matchResultMatchEntire2 == null || (groupValues = matchResultMatchEntire2.getGroupValues()) == null) {
                    str2 = null;
                } else {
                    ListIterator<String> listIterator2 = groupValues.listIterator(groupValues.size());
                    while (true) {
                        if (!listIterator2.hasPrevious()) {
                            strPrevious = null;
                            break;
                        }
                        strPrevious = listIterator2.previous();
                        if (!StringsJVM.isBlank(strPrevious)) {
                            break;
                        }
                    }
                    str2 = strPrevious;
                }
            }
            try {
                queryParameter = uri.getQueryParameter("fingerprint");
            } catch (Exception unused) {
                queryParameter = null;
            }
            try {
                queryParameter2 = uri.getQueryParameter("attemptId");
            } catch (Exception unused2) {
                queryParameter2 = null;
            }
            try {
                queryParameter3 = uri.getQueryParameter("auth_token");
            } catch (Exception unused3) {
            }
            return new DynamicLinkData(uri2, queryParameter, queryParameter2, str, str2, queryParameter3);
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$2 */
    public static final class C58842<T> implements Action1<DynamicLinkData> {
        public static final C58842 INSTANCE = new C58842();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(DynamicLinkData dynamicLinkData) {
            call2(dynamicLinkData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(DynamicLinkData dynamicLinkData) {
            if (dynamicLinkData != null) {
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                String fingerprint = dynamicLinkData.getFingerprint();
                String attemptId = dynamicLinkData.getAttemptId();
                String inviteCode = dynamicLinkData.getInviteCode();
                String guildTemplateCode = dynamicLinkData.getGuildTemplateCode();
                String authToken = dynamicLinkData.getAuthToken();
                Backgrounded4 backgrounded4 = Backgrounded4.f600d;
                analyticsTracker.externalDynamicLinkReceived(fingerprint, attemptId, inviteCode, guildTemplateCode, authToken, Backgrounded4.f597a);
            }
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$3 */
    public static final class C58853 extends Lambda implements Function1<DynamicLinkData, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58853(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DynamicLinkData dynamicLinkData) {
            invoke2(dynamicLinkData);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DynamicLinkData dynamicLinkData) {
            StoreDynamicLink.access$handleDataReceived(StoreDynamicLink.this, dynamicLinkData, this.$context);
        }
    }

    public StoreDynamicLink(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreDynamicLink storeDynamicLink) {
        return storeDynamicLink.stream;
    }

    public static final /* synthetic */ void access$handleDataReceived(StoreDynamicLink storeDynamicLink, DynamicLinkData dynamicLinkData, Context context) {
        storeDynamicLink.handleDataReceived(dynamicLinkData, context);
    }

    private final Observable<Uri> getDynamicLinkObservable(Intent intent) {
        Observable observableM11080o = Observable.m11080o(new StoreDynamicLink2(intent), Emitter.BackpressureMode.BUFFER);
        Intrinsics3.checkNotNullExpressionValue(observableM11080o, "Observable.create({\n    ….BackpressureMode.BUFFER)");
        Observable<Uri> observableM11087M = Observable.m11064I(new ScalarSynchronousObservable(Uri.EMPTY).m11111q(1000L, TimeUnit.MILLISECONDS), observableM11080o).m11087M(C58781.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11087M, "Observable\n        .merg…ErrorReturn { Uri.EMPTY }");
        return observableM11087M;
    }

    private final void handleDataReceived(DynamicLinkData data, Context context) {
        String guildTemplateCode;
        String inviteCode;
        this.dispatcher.schedule(new C58811(data));
        if (data != null && (inviteCode = data.getInviteCode()) != null && (!StringsJVM.isBlank(inviteCode))) {
            IntentUtils.RouteBuilders routeBuilders = IntentUtils.RouteBuilders.INSTANCE;
            String inviteCode2 = data.getInviteCode();
            Objects.requireNonNull(inviteCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders.selectInvite(Strings4.trim(inviteCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if (data != null && (guildTemplateCode = data.getGuildTemplateCode()) != null && (!StringsJVM.isBlank(guildTemplateCode))) {
            IntentUtils.RouteBuilders routeBuilders2 = IntentUtils.RouteBuilders.INSTANCE;
            String guildTemplateCode2 = data.getGuildTemplateCode();
            Objects.requireNonNull(guildTemplateCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders2.selectGuildTemplate(Strings4.trim(guildTemplateCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if ((data != null ? data.getUri() : null) != null) {
            Intent data2 = new Intent().setData(data.getUri());
            Intrinsics3.checkNotNullExpressionValue(data2, "Intent().setData(data.uri)");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, data2, context, null, 4, null);
        }
    }

    public final void storeLinkIfExists(Intent intent, Context context) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Observable<R> observableM11083G = getDynamicLinkObservable(intent).m11083G(C58831.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "getDynamicLinkObservable…ode, authToken)\n        }");
        Observable observableM11115u = ObservableExtensionsKt.computationBuffered(observableM11083G).m11112r().m11115u(C58842.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11115u, "getDynamicLinkObservable…  )\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableM11115u, StoreDynamicLink.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C58853(context), 62, (Object) null);
    }
}
