package com.discord.utilities;

import androidx.core.content.p004pm.ShortcutInfoCompat;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ShareUtils.kt */
/* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2 */
/* loaded from: classes2.dex */
public final class C6654x626dc25b extends Lambda implements Function1<ShortcutInfoCompat, Long> {
    public static final C6654x626dc25b INSTANCE = new C6654x626dc25b();

    public C6654x626dc25b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(ShortcutInfoCompat shortcutInfoCompat) {
        return Long.valueOf(invoke2(shortcutInfoCompat));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(ShortcutInfoCompat shortcutInfoCompat) {
        Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "shortcutInfoCompat");
        String id2 = shortcutInfoCompat.getId();
        Intrinsics3.checkNotNullExpressionValue(id2, "shortcutInfoCompat.id");
        return Long.parseLong(id2);
    }
}
