package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import j0.k.Func1;
import java.util.List;

/* compiled from: WidgetGuildProfileSheetViewModel.kt */
/* renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel$Companion$observeStores$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetViewModel3<T, R> implements Func1<EmojiSet, List<Emoji>> {
    public final /* synthetic */ long $guildId;

    public WidgetGuildProfileSheetViewModel3(long j) {
        this.$guildId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<Emoji> call(EmojiSet emojiSet) {
        return call2(emojiSet);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<Emoji> call2(EmojiSet emojiSet) {
        return emojiSet.customEmojis.get(Long.valueOf(this.$guildId));
    }
}
