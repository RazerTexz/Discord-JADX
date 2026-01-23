package com.discord.utilities;

import androidx.core.content.p004pm.ShortcutInfoCompat;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$1 */
/* JADX INFO: compiled from: ShareUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6653x626dc25a extends Lambda implements Function1<ShortcutInfoCompat, Boolean> {
    public static final C6653x626dc25a INSTANCE = new C6653x626dc25a();

    public C6653x626dc25a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ShortcutInfoCompat shortcutInfoCompat) {
        return Boolean.valueOf(invoke2(shortcutInfoCompat));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(ShortcutInfoCompat shortcutInfoCompat) {
        Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "it");
        return shortcutInfoCompat.isPinned();
    }
}
