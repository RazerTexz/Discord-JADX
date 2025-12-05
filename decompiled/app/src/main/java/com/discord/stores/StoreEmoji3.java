package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import p637j0.p641k.Func1;

/* compiled from: StoreEmoji.kt */
/* renamed from: com.discord.stores.StoreEmoji$getEmojiSet$hasExternalEmojiPermissionObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreEmoji3<T, R> implements Func1<Long, Boolean> {
    public static final StoreEmoji3 INSTANCE = new StoreEmoji3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l) {
        return Boolean.valueOf(PermissionUtils.can(Permission.USE_EXTERNAL_EMOJIS, l));
    }
}
