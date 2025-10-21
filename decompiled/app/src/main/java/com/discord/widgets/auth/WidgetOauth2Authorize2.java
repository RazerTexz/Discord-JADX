package com.discord.widgets.auth;

import android.net.Uri;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetOauth2Authorize.kt */
/* renamed from: com.discord.widgets.auth.WidgetOauth2Authorize$Companion$createOauthAuthorize$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetOauth2Authorize2 extends Lambda implements Function2<Uri, String, String> {
    public static final WidgetOauth2Authorize2 INSTANCE = new WidgetOauth2Authorize2();

    public WidgetOauth2Authorize2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ String invoke(Uri uri, String str) {
        return invoke2(uri, str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Uri uri, String str) {
        Intrinsics3.checkNotNullParameter(uri, "$this$getQueryParameterOrThrow");
        Intrinsics3.checkNotNullParameter(str, "parameterName");
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter != null) {
            return queryParameter;
        }
        throw new IllegalArgumentException(str);
    }
}
