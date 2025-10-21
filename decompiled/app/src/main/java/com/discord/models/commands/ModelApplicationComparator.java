package com.discord.models.commands;

import d0.z.d.Intrinsics3;
import java.util.Comparator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelApplicationComparator.kt */
/* loaded from: classes.dex */
public final class ModelApplicationComparator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ModelApplicationComparator.kt */
    public static final class Companion implements Comparator<Application> {
        private Companion() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Application application, Application application2) {
            return compare2(application, application2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Application a, Application b2) {
            Intrinsics3.checkNotNullParameter(a, "a");
            Intrinsics3.checkNotNullParameter(b2, "b");
            int i = (a.getBuiltIn() ? 1 : 0) - (b2.getBuiltIn() ? 1 : 0);
            return i != 0 ? i : a.getName().compareTo(b2.getName());
        }
    }
}
