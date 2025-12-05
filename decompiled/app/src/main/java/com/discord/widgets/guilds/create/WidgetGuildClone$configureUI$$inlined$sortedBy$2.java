package com.discord.widgets.guilds.create;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.role.GuildRole;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildClone$configureUI$$inlined$sortedBy$2<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(Long.valueOf(-((GuildRole) t).getId()), Long.valueOf(-((GuildRole) t2).getId()));
    }
}
