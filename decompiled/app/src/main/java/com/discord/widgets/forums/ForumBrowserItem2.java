package com.discord.widgets.forums;

import com.discord.widgets.forums.ForumBrowserItem;
import d0.z.d.Lambda;
import java.util.Comparator;
import kotlin.jvm.functions.Function0;

/* compiled from: ForumBrowserItem.kt */
/* renamed from: com.discord.widgets.forums.ForumBrowserItem$Companion$postItemComparatorByMostRecent$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ForumBrowserItem2 extends Lambda implements Function0<Comparator<ForumBrowserItem.PostItem>> {
    public static final ForumBrowserItem2 INSTANCE = new ForumBrowserItem2();

    /* compiled from: ForumBrowserItem.kt */
    /* renamed from: com.discord.widgets.forums.ForumBrowserItem$Companion$postItemComparatorByMostRecent$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Comparator<ForumBrowserItem.PostItem> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ForumBrowserItem.PostItem postItem, ForumBrowserItem.PostItem postItem2) {
            return compare2(postItem, postItem2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public final int compare2(ForumBrowserItem.PostItem postItem, ForumBrowserItem.PostItem postItem2) {
            Long mostRecentMessageTimestamp = postItem.getPost().getMostRecentMessageTimestamp();
            Long mostRecentMessageTimestamp2 = postItem2.getPost().getMostRecentMessageTimestamp();
            if (mostRecentMessageTimestamp == null || mostRecentMessageTimestamp2 == null) {
                if (mostRecentMessageTimestamp != null || mostRecentMessageTimestamp2 == null) {
                    return (mostRecentMessageTimestamp == null || mostRecentMessageTimestamp2 != null) ? 0 : -1;
                }
            } else if (mostRecentMessageTimestamp2.longValue() <= mostRecentMessageTimestamp.longValue()) {
                return -1;
            }
            return 1;
        }
    }

    public ForumBrowserItem2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Comparator<ForumBrowserItem.PostItem> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparator<ForumBrowserItem.PostItem> invoke2() {
        return AnonymousClass1.INSTANCE;
    }
}
