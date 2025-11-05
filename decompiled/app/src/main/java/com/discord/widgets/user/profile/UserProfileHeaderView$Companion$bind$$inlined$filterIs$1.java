package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import j0.k.b;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes.dex */
public final class UserProfileHeaderView$Companion$bind$$inlined$filterIs$1<T, R> implements b<Object, Boolean> {
    public static final UserProfileHeaderView$Companion$bind$$inlined$filterIs$1 INSTANCE = new UserProfileHeaderView$Companion$bind$$inlined$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // j0.k.b
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof UserProfileHeaderViewModel.ViewState.Loaded);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
