package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import j0.k.Func1;
import java.util.Objects;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes.dex */
public final class UserProfileHeaderView$Companion$bind$$inlined$filterIs$2<T, R> implements Func1<Object, T> {
    public static final UserProfileHeaderView$Companion$bind$$inlined$filterIs$2 INSTANCE = new UserProfileHeaderView$Companion$bind$$inlined$filterIs$2();

    @Override // j0.k.Func1
    public final T call(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.user.profile.UserProfileHeaderViewModel.ViewState.Loaded");
        return (T) ((UserProfileHeaderViewModel.ViewState.Loaded) obj);
    }
}
