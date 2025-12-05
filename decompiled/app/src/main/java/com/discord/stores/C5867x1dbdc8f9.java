package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.directory.DirectoryEntryGuild;
import java.util.Comparator;
import p507d0.p582u.C12169a;

/* compiled from: Comparisons.kt */
/* renamed from: com.discord.stores.StoreDirectories$fetchDirectoriesForChannel$1$$special$$inlined$sortedByDescending$1 */
/* loaded from: classes2.dex */
public final class C5867x1dbdc8f9<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Integer approximateMemberCount = ((DirectoryEntryGuild) t2).getGuild().getApproximateMemberCount();
        Integer numValueOf = Integer.valueOf(approximateMemberCount != null ? approximateMemberCount.intValue() : 0);
        Integer approximateMemberCount2 = ((DirectoryEntryGuild) t).getGuild().getApproximateMemberCount();
        return C12169a.compareValues(numValueOf, Integer.valueOf(approximateMemberCount2 != null ? approximateMemberCount2.intValue() : 0));
    }
}
