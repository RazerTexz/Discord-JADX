package com.discord.restapi;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p600f0.OkHttpClient;

/* JADX INFO: renamed from: com.discord.restapi.RestAPIBuilder$Companion$clientCallback$1, reason: use source file name */
/* JADX INFO: compiled from: RestAPIBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIBuilder2 extends Lambda implements Function2<String, OkHttpClient, Unit> {
    public static final RestAPIBuilder2 INSTANCE = new RestAPIBuilder2();

    public RestAPIBuilder2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, OkHttpClient okHttpClient) {
        invoke2(str, okHttpClient);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, OkHttpClient okHttpClient) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(okHttpClient, "<anonymous parameter 1>");
    }
}
