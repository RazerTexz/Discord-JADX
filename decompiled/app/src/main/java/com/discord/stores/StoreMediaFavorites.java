package com.discord.stores;

import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.textprocessing.node.EmojiNode;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p513e0.KClass;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreMediaFavorites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMediaFavorites extends StoreV2 {
    public static final String FAVORITES_CACHE_KEY = "STORE_FAVORITES";
    private final Dispatcher dispatcher;
    private final Set<Favorite> favorites;
    private Set<? extends Favorite> favoritesSnapshot;
    private final ObservationDeck observationDeck;
    private final Persister<Set<Favorite>> persister;

    /* JADX INFO: compiled from: StoreMediaFavorites.kt */
    public static abstract class Favorite {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy AllTypes$delegate = LazyJVM.lazy(StoreMediaFavorites2.INSTANCE);
        private static final Set<KClass<? extends Favorite>> EmojiTypes = Sets5.setOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(FavCustomEmoji.class), Reflection2.getOrCreateKotlinClass(FavUnicodeEmoji.class)});

        /* JADX INFO: compiled from: StoreMediaFavorites.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Set<KClass<? extends Favorite>> getAllTypes() {
                Lazy lazyAccess$getAllTypes$cp = Favorite.access$getAllTypes$cp();
                Companion companion = Favorite.INSTANCE;
                return (Set) lazyAccess$getAllTypes$cp.getValue();
            }

            public final Set<KClass<? extends Favorite>> getEmojiTypes() {
                return Favorite.access$getEmojiTypes$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: StoreMediaFavorites.kt */
        public static final /* data */ class FavCustomEmoji extends Favorite implements FavoriteEmoji {
            private final String emojiUniqueId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FavCustomEmoji(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "emojiUniqueId");
                this.emojiUniqueId = str;
            }

            public static /* synthetic */ FavCustomEmoji copy$default(FavCustomEmoji favCustomEmoji, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = favCustomEmoji.getEmojiUniqueId();
                }
                return favCustomEmoji.copy(str);
            }

            public final String component1() {
                return getEmojiUniqueId();
            }

            public final FavCustomEmoji copy(String emojiUniqueId) {
                Intrinsics3.checkNotNullParameter(emojiUniqueId, "emojiUniqueId");
                return new FavCustomEmoji(emojiUniqueId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FavCustomEmoji) && Intrinsics3.areEqual(getEmojiUniqueId(), ((FavCustomEmoji) other).getEmojiUniqueId());
                }
                return true;
            }

            @Override // com.discord.stores.StoreMediaFavorites.FavoriteEmoji
            public String getEmojiUniqueId() {
                return this.emojiUniqueId;
            }

            public int hashCode() {
                String emojiUniqueId = getEmojiUniqueId();
                if (emojiUniqueId != null) {
                    return emojiUniqueId.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("FavCustomEmoji(emojiUniqueId=");
                sbM833U.append(getEmojiUniqueId());
                sbM833U.append(")");
                return sbM833U.toString();
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public FavCustomEmoji(EmojiNode.EmojiIdAndType.Custom custom) {
                this(String.valueOf(custom.getId()));
                Intrinsics3.checkNotNullParameter(custom, "custom");
            }
        }

        /* JADX INFO: compiled from: StoreMediaFavorites.kt */
        public static final /* data */ class FavUnicodeEmoji extends Favorite implements FavoriteEmoji {
            private final String emojiUniqueId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FavUnicodeEmoji(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "emojiUniqueId");
                this.emojiUniqueId = str;
            }

            public static /* synthetic */ FavUnicodeEmoji copy$default(FavUnicodeEmoji favUnicodeEmoji, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = favUnicodeEmoji.getEmojiUniqueId();
                }
                return favUnicodeEmoji.copy(str);
            }

            public final String component1() {
                return getEmojiUniqueId();
            }

            public final FavUnicodeEmoji copy(String emojiUniqueId) {
                Intrinsics3.checkNotNullParameter(emojiUniqueId, "emojiUniqueId");
                return new FavUnicodeEmoji(emojiUniqueId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FavUnicodeEmoji) && Intrinsics3.areEqual(getEmojiUniqueId(), ((FavUnicodeEmoji) other).getEmojiUniqueId());
                }
                return true;
            }

            @Override // com.discord.stores.StoreMediaFavorites.FavoriteEmoji
            public String getEmojiUniqueId() {
                return this.emojiUniqueId;
            }

            public int hashCode() {
                String emojiUniqueId = getEmojiUniqueId();
                if (emojiUniqueId != null) {
                    return emojiUniqueId.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("FavUnicodeEmoji(emojiUniqueId=");
                sbM833U.append(getEmojiUniqueId());
                sbM833U.append(")");
                return sbM833U.toString();
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public FavUnicodeEmoji(ModelEmojiUnicode modelEmojiUnicode) {
                Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "unicode");
                String uniqueId = modelEmojiUnicode.getUniqueId();
                Intrinsics3.checkNotNullExpressionValue(uniqueId, "unicode.uniqueId");
                this(uniqueId);
            }
        }

        private Favorite() {
        }

        public static final /* synthetic */ Lazy access$getAllTypes$cp() {
            return AllTypes$delegate;
        }

        public static final /* synthetic */ Set access$getEmojiTypes$cp() {
            return EmojiTypes;
        }

        public /* synthetic */ Favorite(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreMediaFavorites.kt */
    public interface FavoriteEmoji {
        String getEmojiUniqueId();
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaFavorites$addFavorite$1 */
    /* JADX INFO: compiled from: StoreMediaFavorites.kt */
    public static final class C61811 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Favorite $favorite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61811(Favorite favorite) {
            super(0);
            this.$favorite = favorite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreMediaFavorites.access$getFavorites$p(StoreMediaFavorites.this).add(this.$favorite)) {
                StoreMediaFavorites.this.markChanged();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaFavorites$observeFavorites$1 */
    /* JADX INFO: compiled from: StoreMediaFavorites.kt */
    public static final class C61821 extends Lambda implements Function0<Set<? extends Favorite>> {
        public final /* synthetic */ Set $types;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61821(Set set) {
            super(0);
            this.$types = set;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Favorite> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Favorite> invoke2() {
            return StoreMediaFavorites.this.getFavorites(this.$types);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMediaFavorites$removeFavorite$1 */
    /* JADX INFO: compiled from: StoreMediaFavorites.kt */
    public static final class C61831 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Favorite $favorite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61831(Favorite favorite) {
            super(0);
            this.$favorite = favorite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreMediaFavorites.access$getFavorites$p(StoreMediaFavorites.this).remove(this.$favorite)) {
                StoreMediaFavorites.this.markChanged();
            }
        }
    }

    public /* synthetic */ StoreMediaFavorites(ObservationDeck observationDeck, Dispatcher dispatcher, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(observationDeck, dispatcher, (i & 4) != 0 ? new Persister(FAVORITES_CACHE_KEY, Sets5.emptySet()) : persister);
    }

    public static final /* synthetic */ Set access$getFavorites$p(StoreMediaFavorites storeMediaFavorites) {
        return storeMediaFavorites.favorites;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set getFavorites$default(StoreMediaFavorites storeMediaFavorites, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = Favorite.INSTANCE.getAllTypes();
        }
        return storeMediaFavorites.getFavorites(set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable observeFavorites$default(StoreMediaFavorites storeMediaFavorites, Set set, int i, Object obj) {
        if ((i & 1) != 0) {
            set = Favorite.INSTANCE.getAllTypes();
        }
        return storeMediaFavorites.observeFavorites(set);
    }

    public final void addFavorite(Favorite favorite) {
        Intrinsics3.checkNotNullParameter(favorite, "favorite");
        this.dispatcher.schedule(new C61811(favorite));
    }

    public final Set<Favorite> getFavorites(Set<? extends KClass<? extends Favorite>> types) {
        Intrinsics3.checkNotNullParameter(types, "types");
        Set<? extends Favorite> set = this.favoritesSnapshot;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (types.contains(Reflection2.getOrCreateKotlinClass(((Favorite) obj).getClass()))) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public final Observable<Set<Favorite>> observeFavorites(Set<? extends KClass<? extends Favorite>> types) {
        Intrinsics3.checkNotNullParameter(types, "types");
        Observable<Set<Favorite>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61821(types), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void removeFavorite(Favorite favorite) {
        Intrinsics3.checkNotNullParameter(favorite, "favorite");
        this.dispatcher.schedule(new C61831(favorite));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashSet hashSet = new HashSet(this.favorites);
        this.favoritesSnapshot = hashSet;
        this.persister.set(hashSet, true);
    }

    public StoreMediaFavorites(ObservationDeck observationDeck, Dispatcher dispatcher, Persister<Set<Favorite>> persister) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(persister, "persister");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.persister = persister;
        Set<Favorite> set = persister.get();
        this.favoritesSnapshot = set;
        this.favorites = _Collections.toMutableSet(set);
    }
}
