package com.discord.widgets.forums;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import java.util.Comparator;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ForumBrowserItem.kt */
/* loaded from: classes2.dex */
public abstract class ForumBrowserItem implements MGRecyclerDataPayload {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_LOADING = 2;
    public static final int TYPE_POST = 1;
    private final String key;
    private final int type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy postItemComparatorByMostRecent$delegate = LazyJVM.lazy(ForumBrowserItem2.INSTANCE);

    /* compiled from: ForumBrowserItem.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Comparator<PostItem> getPostItemComparatorByMostRecent() {
            Lazy lazyAccess$getPostItemComparatorByMostRecent$cp = ForumBrowserItem.access$getPostItemComparatorByMostRecent$cp();
            Companion companion = ForumBrowserItem.INSTANCE;
            return (Comparator) lazyAccess$getPostItemComparatorByMostRecent$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ForumBrowserItem.kt */
    public static final /* data */ class HeaderItem extends ForumBrowserItem {
        private final int stringResId;

        public HeaderItem(int i) {
            super(String.valueOf(i), 0, null);
            this.stringResId = i;
        }

        public static /* synthetic */ HeaderItem copy$default(HeaderItem headerItem, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = headerItem.stringResId;
            }
            return headerItem.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStringResId() {
            return this.stringResId;
        }

        public final HeaderItem copy(int stringResId) {
            return new HeaderItem(stringResId);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof HeaderItem) && this.stringResId == ((HeaderItem) other).stringResId;
            }
            return true;
        }

        public final int getStringResId() {
            return this.stringResId;
        }

        public int hashCode() {
            return this.stringResId;
        }

        public String toString() {
            return outline.m814B(outline.m833U("HeaderItem(stringResId="), this.stringResId, ")");
        }
    }

    /* compiled from: ForumBrowserItem.kt */
    public static final class LoadingItem extends ForumBrowserItem {
        public static final LoadingItem INSTANCE = new LoadingItem();

        private LoadingItem() {
            super("loading-indicator", 2, null);
        }
    }

    /* compiled from: ForumBrowserItem.kt */
    public static final /* data */ class PostItem extends ForumBrowserItem {
        private final PostData post;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostItem(PostData postData) {
            super(String.valueOf(postData.getChannel().getId()), 1, null);
            Intrinsics3.checkNotNullParameter(postData, "post");
            this.post = postData;
        }

        public static /* synthetic */ PostItem copy$default(PostItem postItem, PostData postData, int i, Object obj) {
            if ((i & 1) != 0) {
                postData = postItem.post;
            }
            return postItem.copy(postData);
        }

        /* renamed from: component1, reason: from getter */
        public final PostData getPost() {
            return this.post;
        }

        public final PostItem copy(PostData post) {
            Intrinsics3.checkNotNullParameter(post, "post");
            return new PostItem(post);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof PostItem) && Intrinsics3.areEqual(this.post, ((PostItem) other).post);
            }
            return true;
        }

        public final PostData getPost() {
            return this.post;
        }

        public int hashCode() {
            PostData postData = this.post;
            if (postData != null) {
                return postData.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("PostItem(post=");
            sbM833U.append(this.post);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    private ForumBrowserItem(String str, int i) {
        this.key = str;
        this.type = i;
    }

    public static final /* synthetic */ Lazy access$getPostItemComparatorByMostRecent$cp() {
        return postItemComparatorByMostRecent$delegate;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ ForumBrowserItem(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
