package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.a.e.d;
import b.d.b.a.a;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
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
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;

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
            return m.areEqual(this.uri, dynamicLinkData.uri) && m.areEqual(this.fingerprint, dynamicLinkData.fingerprint) && m.areEqual(this.attemptId, dynamicLinkData.attemptId) && m.areEqual(this.inviteCode, dynamicLinkData.inviteCode) && m.areEqual(this.guildTemplateCode, dynamicLinkData.guildTemplateCode) && m.areEqual(this.authToken, dynamicLinkData.authToken);
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
            StringBuilder sbU = a.U("DynamicLinkData(uri=");
            sbU.append(this.uri);
            sbU.append(", fingerprint=");
            sbU.append(this.fingerprint);
            sbU.append(", attemptId=");
            sbU.append(this.attemptId);
            sbU.append(", inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", guildTemplateCode=");
            sbU.append(this.guildTemplateCode);
            sbU.append(", authToken=");
            return a.J(sbU, this.authToken, ")");
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    /* renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Throwable, Uri> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Uri call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Uri call2(Throwable th) {
            return Uri.EMPTY;
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    /* renamed from: com.discord.stores.StoreDynamicLink$handleDataReceived$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ DynamicLinkData $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DynamicLinkData dynamicLinkData) {
            super(0);
            this.$data = dynamicLinkData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Uri, DynamicLinkData> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
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
            if (m.areEqual(uri, Uri.EMPTY)) {
                return null;
            }
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Uri uri2 = intentUtils.isHttpDomainUrl(uri) ? uri : null;
            b.a.d.m0.a aVar = b.a.d.m0.a.G;
            m.checkNotNullParameter(uri, "$this$isInviteLink");
            boolean z2 = false;
            if (t.equals(uri.getHost(), b.a.d.m0.a.d, true) || ((t.equals(uri.getHost(), b.a.d.m0.a.a, true) || t.equals(uri.getHost(), b.a.d.m0.a.f60b, true)) && (path2 = uri.getPath()) != null && b.a.d.m0.a.n.matches(path2))) {
                Regex regex = b.a.d.m0.a.n;
                String path3 = uri.getPath();
                if (path3 == null) {
                    path3 = "";
                }
                m.checkNotNullExpressionValue(path3, "uri.path ?: \"\"");
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
                        if (!t.isBlank(strPrevious2)) {
                            break;
                        }
                    }
                    str = strPrevious2;
                }
            }
            b.a.d.m0.a aVar2 = b.a.d.m0.a.G;
            m.checkNotNullParameter(uri, "$this$isGuildTemplateLink");
            if (t.equals(uri.getHost(), b.a.d.m0.a.e, true) || ((t.equals(uri.getHost(), b.a.d.m0.a.a, true) || t.equals(uri.getHost(), b.a.d.m0.a.f60b, true)) && (path = uri.getPath()) != null && b.a.d.m0.a.p.matches(path))) {
                z2 = true;
            }
            if (z2) {
                Regex regex2 = b.a.d.m0.a.p;
                String path4 = uri.getPath();
                String str3 = path4 != null ? path4 : "";
                m.checkNotNullExpressionValue(str3, "uri.path ?: \"\"");
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
                        if (!t.isBlank(strPrevious)) {
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
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<DynamicLinkData> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
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
                d dVar = d.d;
                analyticsTracker.externalDynamicLinkReceived(fingerprint, attemptId, inviteCode, guildTemplateCode, authToken, d.a);
            }
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<DynamicLinkData, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DynamicLinkData dynamicLinkData) {
            invoke2(dynamicLinkData);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DynamicLinkData dynamicLinkData) {
            StoreDynamicLink.access$handleDataReceived(StoreDynamicLink.this, dynamicLinkData, this.$context);
        }
    }

    public StoreDynamicLink(StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
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
        Observable observableO = Observable.o(new StoreDynamicLink$getDynamicLinkObservable$firebaseDynamicLinks$1(intent), Emitter.BackpressureMode.BUFFER);
        m.checkNotNullExpressionValue(observableO, "Observable.create({\n    ….BackpressureMode.BUFFER)");
        Observable<Uri> observableM = Observable.I(new k(Uri.EMPTY).q(1000L, TimeUnit.MILLISECONDS), observableO).M(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableM, "Observable\n        .merg…ErrorReturn { Uri.EMPTY }");
        return observableM;
    }

    private final void handleDataReceived(DynamicLinkData data, Context context) {
        String guildTemplateCode;
        String inviteCode;
        this.dispatcher.schedule(new AnonymousClass1(data));
        if (data != null && (inviteCode = data.getInviteCode()) != null && (!t.isBlank(inviteCode))) {
            IntentUtils.RouteBuilders routeBuilders = IntentUtils.RouteBuilders.INSTANCE;
            String inviteCode2 = data.getInviteCode();
            Objects.requireNonNull(inviteCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders.selectInvite(w.trim(inviteCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if (data != null && (guildTemplateCode = data.getGuildTemplateCode()) != null && (!t.isBlank(guildTemplateCode))) {
            IntentUtils.RouteBuilders routeBuilders2 = IntentUtils.RouteBuilders.INSTANCE;
            String guildTemplateCode2 = data.getGuildTemplateCode();
            Objects.requireNonNull(guildTemplateCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders2.selectGuildTemplate(w.trim(guildTemplateCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if ((data != null ? data.getUri() : null) != null) {
            Intent data2 = new Intent().setData(data.getUri());
            m.checkNotNullExpressionValue(data2, "Intent().setData(data.uri)");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, data2, context, null, 4, null);
        }
    }

    public final void storeLinkIfExists(Intent intent, Context context) {
        m.checkNotNullParameter(intent, "intent");
        m.checkNotNullParameter(context, "context");
        Observable<R> observableG = getDynamicLinkObservable(intent).G(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "getDynamicLinkObservable…ode, authToken)\n        }");
        Observable observableU = ObservableExtensionsKt.computationBuffered(observableG).r().u(AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableU, "getDynamicLinkObservable…  )\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableU, StoreDynamicLink.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(context), 62, (Object) null);
    }
}
