package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.commands.Application;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$handleApplicationCommandsUpdate$$inlined$sortedBy$1 */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C5705x3d14edc6<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return C12169a.compareValues(((Application) t).getName(), ((Application) t2).getName());
    }
}
