package com.discord.stores;

import com.discord.stores.StoreMediaFavorites;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import p507d0.p513e0.KClass;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: StoreMediaFavorites.kt */
/* renamed from: com.discord.stores.StoreMediaFavorites$Favorite$Companion$AllTypes$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreMediaFavorites2 extends Lambda implements Function0<Set<? extends KClass<? extends StoreMediaFavorites.Favorite>>> {
    public static final StoreMediaFavorites2 INSTANCE = new StoreMediaFavorites2();

    public StoreMediaFavorites2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends KClass<? extends StoreMediaFavorites.Favorite>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends KClass<? extends StoreMediaFavorites.Favorite>> invoke2() {
        return _Collections.toSet(Reflection2.getOrCreateKotlinClass(StoreMediaFavorites.Favorite.class).getSealedSubclasses());
    }
}
