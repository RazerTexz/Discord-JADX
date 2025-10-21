package com.discord.utilities.integrations;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: SpotifyHelper.kt */
/* renamed from: com.discord.utilities.integrations.SpotifyHelper$launchTrack$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SpotifyHelper2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ String $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpotifyHelper2(String str, Context context) {
        super(0);
        this.$it = str;
        this.$context$inlined = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SpotifyHelper.access$launchSpotifyIntent(SpotifyHelper.INSTANCE, this.$context$inlined, new Intent("android.intent.action.VIEW", Uri.parse("spotify:track:" + Uri.encode(this.$it) + "?utm_source=discord&utm_medium=mobile")));
    }
}
