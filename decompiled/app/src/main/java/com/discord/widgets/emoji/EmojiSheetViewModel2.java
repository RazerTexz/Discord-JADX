package com.discord.widgets.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.utilities.textprocessing.node.EmojiNode;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: EmojiSheetViewModel.kt */
/* renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiSheetViewModel2<V> implements Callable<Guild> {
    public final /* synthetic */ EmojiNode.EmojiIdAndType.Custom $emoji;
    public final /* synthetic */ StoreEmojiCustom $storeEmojiCustom;
    public final /* synthetic */ StoreGuilds $storeGuilds;

    public EmojiSheetViewModel2(StoreEmojiCustom storeEmojiCustom, EmojiNode.EmojiIdAndType.Custom custom, StoreGuilds storeGuilds) {
        this.$storeEmojiCustom = storeEmojiCustom;
        this.$emoji = custom;
        this.$storeGuilds = storeGuilds;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Guild call() {
        return call();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public final Guild call() {
        Object next;
        Iterator<T> it = this.$storeEmojiCustom.getAllGuildEmoji().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Map.Entry entry = (Map.Entry) next;
            ((Number) entry.getKey()).longValue();
            if (((Map) entry.getValue()).keySet().contains(Long.valueOf(this.$emoji.getId()))) {
                break;
            }
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 == null) {
            return null;
        }
        long jLongValue = ((Number) entry2.getKey()).longValue();
        return this.$storeGuilds.getGuilds().get(Long.valueOf(jLongValue));
    }
}
