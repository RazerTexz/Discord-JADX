package com.discord.utilities.handoff;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.LifecycleOwnerKt;
import com.discord.BuildConfig;
import com.discord.analytics.generated.events.TrackMobileWebHandoffFailure;
import com.discord.api.handoff.HandoffToken;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.context.ContextExtensionsKt;
import com.discord.utilities.coroutines.CoroutineProgressDialog;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.uri.UriHandler;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.d;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import java.util.UUID;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MobileWebHandoff.kt */
/* loaded from: classes2.dex */
public final class MobileWebHandoff {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnalyticsUtils.Tracker analytics;
    private final StoreAuthentication authStore;
    private final Context context;
    private final RestAPI restAPI;

    /* compiled from: MobileWebHandoff.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String generateNonce() {
            String string = UUID.randomUUID().toString();
            m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
            return string;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MobileWebHandoff.kt */
    @e(c = "com.discord.utilities.handoff.MobileWebHandoff", f = "MobileWebHandoff.kt", l = {44}, m = "redirectWithHandoffToken")
    /* renamed from: com.discord.utilities.handoff.MobileWebHandoff$redirectWithHandoffToken$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public boolean Z$0;
        public boolean Z$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MobileWebHandoff.this.redirectWithHandoffToken(null, false, false, this);
        }
    }

    /* compiled from: MobileWebHandoff.kt */
    @e(c = "com.discord.utilities.handoff.MobileWebHandoff$tryLaunchRedirectTo$1", f = "MobileWebHandoff.kt", l = {36}, m = "invokeSuspend")
    /* renamed from: com.discord.utilities.handoff.MobileWebHandoff$tryLaunchRedirectTo$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $preventCustomTab;
        public final /* synthetic */ boolean $skipLoginRedirect;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, boolean z2, boolean z3, Continuation continuation) {
            super(2, continuation);
            this.$url = str;
            this.$skipLoginRedirect = z2;
            this.$preventCustomTab = z3;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return MobileWebHandoff.this.new AnonymousClass1(this.$url, this.$skipLoginRedirect, this.$preventCustomTab, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                MobileWebHandoff mobileWebHandoff = MobileWebHandoff.this;
                String str = this.$url;
                boolean z2 = this.$skipLoginRedirect;
                boolean z3 = this.$preventCustomTab;
                this.label = 1;
                if (mobileWebHandoff.redirectWithHandoffToken(str, z2, z3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    public MobileWebHandoff(Context context, RestAPI restAPI, AnalyticsUtils.Tracker tracker, StoreAuthentication storeAuthentication) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(tracker, "analytics");
        m.checkNotNullParameter(storeAuthentication, "authStore");
        this.context = context;
        this.restAPI = restAPI;
        this.analytics = tracker;
        this.authStore = storeAuthentication;
    }

    public static final /* synthetic */ AnalyticsUtils.Tracker access$getAnalytics$p(MobileWebHandoff mobileWebHandoff) {
        return mobileWebHandoff.analytics;
    }

    public static final /* synthetic */ Context access$getContext$p(MobileWebHandoff mobileWebHandoff) {
        return mobileWebHandoff.context;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(MobileWebHandoff mobileWebHandoff) {
        return mobileWebHandoff.restAPI;
    }

    public static /* synthetic */ boolean tryLaunchRedirectTo$default(MobileWebHandoff mobileWebHandoff, String str, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            z3 = false;
        }
        return mobileWebHandoff.tryLaunchRedirectTo(str, z2, z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object redirectWithHandoffToken(String str, boolean z2, boolean z3, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Ref$ObjectRef ref$ObjectRef;
        Object objWithCancellableProgressDialog;
        boolean z4;
        MobileWebHandoff mobileWebHandoff;
        Uri uriBuild;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            l.throwOnFailure(obj);
            ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = INSTANCE.generateNonce();
            CoroutineProgressDialog coroutineProgressDialog = CoroutineProgressDialog.INSTANCE;
            Context context = this.context;
            MobileWebHandoff$redirectWithHandoffToken$token$1 mobileWebHandoff$redirectWithHandoffToken$token$1 = new MobileWebHandoff$redirectWithHandoffToken$token$1(this, ref$ObjectRef, null);
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = str;
            anonymousClass1.L$2 = ref$ObjectRef;
            anonymousClass1.Z$0 = z2;
            anonymousClass1.Z$1 = z3;
            anonymousClass1.label = 1;
            objWithCancellableProgressDialog = coroutineProgressDialog.withCancellableProgressDialog(context, mobileWebHandoff$redirectWithHandoffToken$token$1, anonymousClass1);
            if (objWithCancellableProgressDialog == coroutine_suspended) {
                return coroutine_suspended;
            }
            z4 = z3;
            mobileWebHandoff = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z5 = anonymousClass1.Z$1;
            z2 = anonymousClass1.Z$0;
            Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) anonymousClass1.L$2;
            String str2 = (String) anonymousClass1.L$1;
            MobileWebHandoff mobileWebHandoff2 = (MobileWebHandoff) anonymousClass1.L$0;
            l.throwOnFailure(obj);
            z4 = z5;
            mobileWebHandoff = mobileWebHandoff2;
            objWithCancellableProgressDialog = obj;
            ref$ObjectRef = ref$ObjectRef2;
            str = str2;
        }
        HandoffToken handoffToken = (HandoffToken) objWithCancellableProgressDialog;
        if (z2) {
            uriBuild = Uri.parse(str).buildUpon().appendQueryParameter("handoff_token", handoffToken.getHandoffToken()).build();
        } else {
            Uri uri = Uri.parse(str);
            m.checkNotNullExpressionValue(uri, "targetUri");
            String path = uri.getPath();
            if (path == null) {
                path = uri.toString();
            }
            m.checkNotNullExpressionValue(path, "targetUri.path ?: targetUri.toString()");
            uriBuild = Uri.parse(BuildConfig.HOST).buildUpon().path("login/handoff").appendQueryParameter("redirect_to", path).appendQueryParameter("handoff_key", (String) ref$ObjectRef.element).appendQueryParameter("handoff_token", handoffToken.getHandoffToken()).build();
        }
        UriHandler.handle$default(UriHandler.INSTANCE, mobileWebHandoff.context, uriBuild.toString(), true, z4, null, 16, null);
        return Unit.a;
    }

    public final boolean tryLaunchRedirectTo(String url, boolean skipLoginRedirect, boolean preventCustomTab) {
        LifecycleCoroutineScope lifecycleScope;
        m.checkNotNullParameter(url, "url");
        if (!this.authStore.isAuthed()) {
            this.analytics.track(new TrackMobileWebHandoffFailure("user_not_authenticated_in_app", null, 2));
            return false;
        }
        AppCompatActivity appCompatActivityFindActivity = ContextExtensionsKt.findActivity(this.context);
        if (appCompatActivityFindActivity == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(appCompatActivityFindActivity)) == null) {
            return false;
        }
        lifecycleScope.launchWhenStarted(new AnonymousClass1(url, skipLoginRedirect, preventCustomTab, null));
        return true;
    }

    public /* synthetic */ MobileWebHandoff(Context context, RestAPI restAPI, AnalyticsUtils.Tracker tracker, StoreAuthentication storeAuthentication, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? AnalyticsUtils.Tracker.INSTANCE.getInstance() : tracker, (i & 8) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication);
    }
}
