package com.discord.stores;

import com.discord.models.domain.spotify.ModelSpotifyArtist;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreSpotify.kt */
/* renamed from: com.discord.stores.StoreSpotify$publishState$activity$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreSpotify2 extends Lambda implements Function1<ModelSpotifyArtist, CharSequence> {
    public static final StoreSpotify2 INSTANCE = new StoreSpotify2();

    public StoreSpotify2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ModelSpotifyArtist modelSpotifyArtist) {
        return invoke2(modelSpotifyArtist);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ModelSpotifyArtist modelSpotifyArtist) {
        Intrinsics3.checkNotNullParameter(modelSpotifyArtist, "it");
        return modelSpotifyArtist.getName();
    }
}
