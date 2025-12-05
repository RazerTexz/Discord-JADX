package com.discord.widgets.chat.input.autocomplete;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: InputAutocompletables.kt */
/* renamed from: com.discord.widgets.chat.input.autocomplete.InputAutocompletablesKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class InputAutocompletables6 {
    public static final /* synthetic */ void access$merge(Map map, Map map2) {
        merge(map, map2);
    }

    public static final List<Autocompletable> flatten(Map<LeadingIdentifier, ? extends List<? extends Autocompletable>> map) {
        Intrinsics3.checkNotNullParameter(map, "$this$flatten");
        return Iterables2.flatten(map.values());
    }

    private static final void merge(Map<LeadingIdentifier, TreeSet<Autocompletable>> map, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> map2) {
        for (LeadingIdentifier leadingIdentifier : map2.keySet()) {
            TreeSet<Autocompletable> treeSet = map.get(leadingIdentifier);
            if (treeSet == null) {
                treeSet = new TreeSet<>(new AutocompletableComparator());
                map.put(leadingIdentifier, treeSet);
            }
            TreeSet<Autocompletable> treeSet2 = treeSet;
            TreeSet<Autocompletable> treeSetEmptySet = map2.get(leadingIdentifier);
            if (treeSetEmptySet == null) {
                treeSetEmptySet = Sets5.emptySet();
            }
            treeSet2.addAll(treeSetEmptySet);
        }
    }
}
