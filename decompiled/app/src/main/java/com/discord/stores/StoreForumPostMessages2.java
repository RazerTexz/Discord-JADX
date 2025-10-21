package com.discord.stores;

import com.discord.api.forum.ForumPostFirstMessages2;
import com.discord.api.message.Message;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreForumPostMessages.kt */
/* renamed from: com.discord.stores.StoreForumPostMessages$fetchForumPosts$2$1$firstMessages$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreForumPostMessages2 extends Lambda implements Function1<ForumPostFirstMessages2, Message> {
    public static final StoreForumPostMessages2 INSTANCE = new StoreForumPostMessages2();

    public StoreForumPostMessages2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Message invoke(ForumPostFirstMessages2 forumPostFirstMessages2) {
        return invoke2(forumPostFirstMessages2);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Message invoke2(ForumPostFirstMessages2 forumPostFirstMessages2) {
        Intrinsics3.checkNotNullParameter(forumPostFirstMessages2, "it");
        return forumPostFirstMessages2.getFirstMessage();
    }
}
