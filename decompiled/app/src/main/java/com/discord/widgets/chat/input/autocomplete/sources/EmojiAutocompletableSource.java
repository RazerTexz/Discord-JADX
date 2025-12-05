package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.AutocompletableComparator;
import com.discord.widgets.chat.input.autocomplete.EmojiAutocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import com.discord.widgets.chat.input.emoji.EmojiAutocompletePremiumUpsellFeatureFlag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: EmojiAutocompletableSource.kt */
/* loaded from: classes2.dex */
public final class EmojiAutocompletableSource {
    private final StoreEmoji emojiStore;
    private final StoreUserSettings userSettingsStore;

    /* compiled from: EmojiAutocompletableSource.kt */
    /* renamed from: com.discord.widgets.chat.input.autocomplete.sources.EmojiAutocompletableSource$observeEmojiAutocompletables$1 */
    public static final class C78041<T1, T2, R> implements Func2<EmojiSet, Boolean, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
        public C78041() {
        }

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(EmojiSet emojiSet, Boolean bool) {
            return call2(emojiSet, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(EmojiSet emojiSet, Boolean bool) {
            EmojiAutocompletableSource emojiAutocompletableSource = EmojiAutocompletableSource.this;
            Intrinsics3.checkNotNullExpressionValue(emojiSet, "emojiSet");
            Intrinsics3.checkNotNullExpressionValue(bool, "animationsEnabled");
            return EmojiAutocompletableSource.access$createFromEmojiSet(emojiAutocompletableSource, emojiSet, bool.booleanValue());
        }
    }

    public EmojiAutocompletableSource(StoreEmoji storeEmoji, StoreUserSettings storeUserSettings) {
        Intrinsics3.checkNotNullParameter(storeEmoji, "emojiStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        this.emojiStore = storeEmoji;
        this.userSettingsStore = storeUserSettings;
    }

    public static final /* synthetic */ Map access$createFromEmojiSet(EmojiAutocompletableSource emojiAutocompletableSource, EmojiSet emojiSet, boolean z2) {
        return emojiAutocompletableSource.createFromEmojiSet(emojiSet, z2);
    }

    private final Map<LeadingIdentifier, TreeSet<Autocompletable>> createFromEmojiSet(EmojiSet emojiSet, boolean animationsEnabled) {
        TreeSet treeSet = new TreeSet(new AutocompletableComparator());
        Iterator<T> it = emojiSet.unicodeEmojis.values().iterator();
        while (it.hasNext()) {
            List<Emoji> list = (List) it.next();
            Intrinsics3.checkNotNullExpressionValue(list, "categoryEmojis");
            for (Emoji emoji : list) {
                Intrinsics3.checkNotNullExpressionValue(emoji, "emoji");
                treeSet.add(new EmojiAutocompletable(emoji, animationsEnabled));
            }
        }
        Iterator<T> it2 = emojiSet.customEmojis.values().iterator();
        while (it2.hasNext()) {
            List list2 = (List) it2.next();
            ArrayList<Emoji> arrayListM840a0 = outline.m840a0(list2, "guildEmojis");
            for (Object obj : list2) {
                Emoji emoji2 = (Emoji) obj;
                Intrinsics3.checkNotNullExpressionValue(emoji2, "it");
                if (emoji2.isAvailable()) {
                    arrayListM840a0.add(obj);
                }
            }
            for (Emoji emoji3 : arrayListM840a0) {
                Intrinsics3.checkNotNullExpressionValue(emoji3, "emoji");
                treeSet.add(new EmojiAutocompletable(emoji3, animationsEnabled));
            }
        }
        return MapsJVM.mapOf(Tuples.m10073to(LeadingIdentifier.EMOJI_AND_STICKERS, treeSet));
    }

    public final Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observeEmojiAutocompletables(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Observable observableM11076j = Observable.m11076j(ObservableExtensionsKt.computationLatest(this.emojiStore.getEmojiSet(channel.getGuildId(), channel.getId(), EmojiAutocompletePremiumUpsellFeatureFlag.INSTANCE.getINSTANCE().isEnabled(), false)), ObservableExtensionsKt.computationLatest(this.userSettingsStore.observeIsAnimatedEmojisEnabled(true)), new C78041());
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest… animationsEnabled)\n    }");
        Observable<Map<LeadingIdentifier, TreeSet<Autocompletable>>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11076j).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableM11112r;
    }
}
