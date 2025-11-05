package com.discord.utilities.intent;

import android.content.Context;
import android.net.Uri;
import com.discord.utilities.intent.RouteHandlers;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function3;
import kotlin.text.MatchResult;

/* compiled from: IntentUtils.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class IntentUtils$pathRouterMap$12 extends FunctionReferenceImpl implements Function3<Uri, MatchResult, Context, RouteHandlers.AnalyticsMetadata> {
    public IntentUtils$pathRouterMap$12(RouteHandlers routeHandlers) {
        super(3, routeHandlers, RouteHandlers.class, "remoteAuth", "remoteAuth(Landroid/net/Uri;Lkotlin/text/MatchResult;Landroid/content/Context;)Lcom/discord/utilities/intent/RouteHandlers$AnalyticsMetadata;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ RouteHandlers.AnalyticsMetadata invoke(Uri uri, MatchResult matchResult, Context context) {
        return invoke2(uri, matchResult, context);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final RouteHandlers.AnalyticsMetadata invoke2(Uri uri, MatchResult matchResult, Context context) {
        Intrinsics3.checkNotNullParameter(uri, "p1");
        Intrinsics3.checkNotNullParameter(context, "p3");
        return ((RouteHandlers) this.receiver).remoteAuth(uri, matchResult, context);
    }
}
