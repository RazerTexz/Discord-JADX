package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreUserSettings;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.LinkedHashMap;
import java.util.Set;
import rx.Observable;
import rx.functions.Func6;
import rx.subjects.BehaviorSubject;

/* compiled from: EmojiPickerViewModel.kt */
/* loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$observeStoreState$1<T, R> implements Func1<StoreEmoji.EmojiContext, Observable<? extends EmojiPickerViewModel.StoreState>> {
    public final /* synthetic */ BehaviorSubject $searchSubject;
    public final /* synthetic */ BehaviorSubject $selectedCategoryItemIdSubject;
    public final /* synthetic */ StoreAccessibility $storeAccessibility;
    public final /* synthetic */ StoreEmoji $storeEmoji;
    public final /* synthetic */ StoreGuildsSorted $storeGuildsSorted;
    public final /* synthetic */ StoreUserSettings $storeUserSettings;

    /* compiled from: EmojiPickerViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.emoji.EmojiPickerViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, R> implements Func6<EmojiSet, LinkedHashMap<Long, Guild>, String, Boolean, Boolean, Long, EmojiPickerViewModel.StoreState> {
        public final /* synthetic */ StoreEmoji.EmojiContext $emojiContext;

        public AnonymousClass1(StoreEmoji.EmojiContext emojiContext) {
            this.$emojiContext = emojiContext;
        }

        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ EmojiPickerViewModel.StoreState call(EmojiSet emojiSet, LinkedHashMap<Long, Guild> linkedHashMap, String str, Boolean bool, Boolean bool2, Long l) {
            return call(emojiSet, linkedHashMap, str, bool.booleanValue(), bool2.booleanValue(), l.longValue());
        }

        public final EmojiPickerViewModel.StoreState call(EmojiSet emojiSet, LinkedHashMap<Long, Guild> linkedHashMap, String str, boolean z2, boolean z3, long j) {
            Intrinsics3.checkNotNullParameter(linkedHashMap, "allGuilds");
            Intrinsics3.checkNotNullParameter(str, "searchInputString");
            if (emojiSet == null) {
                return EmojiPickerViewModel.StoreState.Uninitialized.INSTANCE;
            }
            StoreEmoji.EmojiContext emojiContext = this.$emojiContext;
            boolean z4 = z2 && !z3;
            Set<Emoji> set = emojiSet.favoriteEmoji;
            Intrinsics3.checkNotNullExpressionValue(set, "emojiSet.favoriteEmoji");
            return new EmojiPickerViewModel.StoreState.Emoji(emojiSet, emojiContext, linkedHashMap, str, z4, j, set);
        }
    }

    public EmojiPickerViewModel$Companion$observeStoreState$1(StoreEmoji storeEmoji, StoreGuildsSorted storeGuildsSorted, BehaviorSubject behaviorSubject, StoreUserSettings storeUserSettings, StoreAccessibility storeAccessibility, BehaviorSubject behaviorSubject2) {
        this.$storeEmoji = storeEmoji;
        this.$storeGuildsSorted = storeGuildsSorted;
        this.$searchSubject = behaviorSubject;
        this.$storeUserSettings = storeUserSettings;
        this.$storeAccessibility = storeAccessibility;
        this.$selectedCategoryItemIdSubject = behaviorSubject2;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends EmojiPickerViewModel.StoreState> call(StoreEmoji.EmojiContext emojiContext) {
        return call2(emojiContext);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EmojiPickerViewModel.StoreState> call2(StoreEmoji.EmojiContext emojiContext) {
        return emojiContext == null ? new ScalarSynchronousObservable(EmojiPickerViewModel.StoreState.Uninitialized.INSTANCE) : Observable.f(this.$storeEmoji.getEmojiSet(emojiContext, true, true), this.$storeGuildsSorted.observeOrderedGuilds(), this.$searchSubject, StoreUserSettings.observeIsAnimatedEmojisEnabled$default(this.$storeUserSettings, false, 1, null), this.$storeAccessibility.observeReducedMotionEnabled(), this.$selectedCategoryItemIdSubject, new AnonymousClass1(emojiContext));
    }
}
