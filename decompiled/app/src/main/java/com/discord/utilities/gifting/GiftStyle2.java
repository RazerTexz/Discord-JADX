package com.discord.utilities.gifting;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.gifting.GiftStyle$Companion$values$2, reason: use source file name */
/* JADX INFO: compiled from: GiftStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GiftStyle2 extends Lambda implements Function0<GiftStyle[]> {
    public static final GiftStyle2 INSTANCE = new GiftStyle2();

    public GiftStyle2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GiftStyle[] invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final GiftStyle[] invoke2() {
        return GiftStyle.values();
    }
}
