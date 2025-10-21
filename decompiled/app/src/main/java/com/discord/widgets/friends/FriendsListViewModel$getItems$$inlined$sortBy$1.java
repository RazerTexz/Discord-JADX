package com.discord.widgets.friends;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.friends.FriendsListViewModel;
import d0.u.a;
import java.util.Comparator;

/* compiled from: Comparisons.kt */
/* loaded from: classes2.dex */
public final class FriendsListViewModel$getItems$$inlined$sortBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Long.valueOf(((FriendsListViewModel.Item.SuggestedFriend) t).getSuggestion().getUser().getId()), Long.valueOf(((FriendsListViewModel.Item.SuggestedFriend) t2).getSuggestion().getUser().getId()));
    }
}
