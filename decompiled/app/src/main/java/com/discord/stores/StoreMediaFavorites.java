package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.textprocessing.node.EmojiNode;
import d0.e0.c;
import d0.g;
import d0.t.n0;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreMediaFavorites.kt */
/* loaded from: classes2.dex */
public final class StoreMediaFavorites extends StoreV2 {
    public static final String FAVORITES_CACHE_KEY = "STORE_FAVORITES";
    private final Dispatcher dispatcher;
    private final Set<Favorite> favorites;
    private Set<? extends Favorite> favoritesSnapshot;
    private final ObservationDeck observationDeck;
    private final Persister<Set<Favorite>> persister;

    /* compiled from: StoreMediaFavorites.kt */
    public static abstract class Favorite {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy AllTypes$delegate = g.lazy(StoreMediaFavorites$Favorite$Companion$AllTypes$2.INSTANCE);
        private static final Set<c<? extends Favorite>> EmojiTypes = n0.setOf((Object[]) new c[]{a0.getOrCreateKotlinClass(FavCustomEmoji.class), a0.getOrCreateKotlinClass(FavUnicodeEmoji.class)});

        /* compiled from: StoreMediaFavorites.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Set<c<? extends Favorite>> getAllTypes() {
                Lazy lazyAccess$getAllTypes$cp = Favorite.access$getAllTypes$cp();
                Companion companion = Favorite.INSTANCE;
                return (Set) lazyAccess$getAllTypes$cp.getValue();
            }

            public final Set<c<? extends Favorite>> getEmojiTypes() {
                return Favorite.access$getEmojiTypes$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: StoreMediaFavorites.kt */
        public static final /* data */ class FavCustomEmoji extends Favorite implements FavoriteEmoji {
            private final String emojiUniqueId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FavCustomEmoji(String str) {
                super(null);
                m.checkNotNullParameter(str, "emojiUniqueId");
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
                m.checkNotNullParameter(emojiUniqueId, "emojiUniqueId");
                return new FavCustomEmoji(emojiUniqueId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FavCustomEmoji) && m.areEqual(getEmojiUniqueId(), ((FavCustomEmoji) other).getEmojiUniqueId());
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
                StringBuilder sbU = a.U("FavCustomEmoji(emojiUniqueId=");
                sbU.append(getEmojiUniqueId());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public FavCustomEmoji(EmojiNode.EmojiIdAndType.Custom custom) {
                this(String.valueOf(custom.getId()));
                m.checkNotNullParameter(custom, "custom");
            }
        }

        /* compiled from: StoreMediaFavorites.kt */
        public static final /* data */ class FavUnicodeEmoji extends Favorite implements FavoriteEmoji {
            private final String emojiUniqueId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FavUnicodeEmoji(String str) {
                super(null);
                m.checkNotNullParameter(str, "emojiUniqueId");
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
                m.checkNotNullParameter(emojiUniqueId, "emojiUniqueId");
                return new FavUnicodeEmoji(emojiUniqueId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FavUnicodeEmoji) && m.areEqual(getEmojiUniqueId(), ((FavUnicodeEmoji) other).getEmojiUniqueId());
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
                StringBuilder sbU = a.U("FavUnicodeEmoji(emojiUniqueId=");
                sbU.append(getEmojiUniqueId());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public FavUnicodeEmoji(ModelEmojiUnicode modelEmojiUnicode) {
                m.checkNotNullParameter(modelEmojiUnicode, "unicode");
                String uniqueId = modelEmojiUnicode.getUniqueId();
                m.checkNotNullExpressionValue(uniqueId, "unicode.uniqueId");
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

    /* compiled from: StoreMediaFavorites.kt */
    public interface FavoriteEmoji {
        String getEmojiUniqueId();
    }

    /* compiled from: StoreMediaFavorites.kt */
    /* renamed from: com.discord.stores.StoreMediaFavorites$addFavorite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Favorite $favorite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Favorite favorite) {
            super(0);
            this.$favorite = favorite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreMediaFavorites.access$getFavorites$p(StoreMediaFavorites.this).add(this.$favorite)) {
                StoreMediaFavorites.this.markChanged();
            }
        }
    }

    /* compiled from: StoreMediaFavorites.kt */
    /* renamed from: com.discord.stores.StoreMediaFavorites$observeFavorites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Set<? extends Favorite>> {
        public final /* synthetic */ Set $types;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Set set) {
            super(0);
            this.$types = set;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Favorite> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Favorite> invoke2() {
            return StoreMediaFavorites.this.getFavorites(this.$types);
        }
    }

    /* compiled from: StoreMediaFavorites.kt */
    /* renamed from: com.discord.stores.StoreMediaFavorites$removeFavorite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Favorite $favorite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Favorite favorite) {
            super(0);
            this.$favorite = favorite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreMediaFavorites.access$getFavorites$p(StoreMediaFavorites.this).remove(this.$favorite)) {
                StoreMediaFavorites.this.markChanged();
            }
        }
    }

    public /* synthetic */ StoreMediaFavorites(ObservationDeck observationDeck, Dispatcher dispatcher, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(observationDeck, dispatcher, (i & 4) != 0 ? new Persister(FAVORITES_CACHE_KEY, n0.emptySet()) : persister);
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
        m.checkNotNullParameter(favorite, "favorite");
        this.dispatcher.schedule(new AnonymousClass1(favorite));
    }

    public final Set<Favorite> getFavorites(Set<? extends c<? extends Favorite>> types) {
        m.checkNotNullParameter(types, "types");
        Set<? extends Favorite> set = this.favoritesSnapshot;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (types.contains(a0.getOrCreateKotlinClass(((Favorite) obj).getClass()))) {
                linkedHashSet.add(obj);
            }
        }
        return linkedHashSet;
    }

    public final Observable<Set<Favorite>> observeFavorites(Set<? extends c<? extends Favorite>> types) {
        m.checkNotNullParameter(types, "types");
        Observable<Set<Favorite>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(types), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void removeFavorite(Favorite favorite) {
        m.checkNotNullParameter(favorite, "favorite");
        this.dispatcher.schedule(new AnonymousClass1(favorite));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashSet hashSet = new HashSet(this.favorites);
        this.favoritesSnapshot = hashSet;
        this.persister.set(hashSet, true);
    }

    public StoreMediaFavorites(ObservationDeck observationDeck, Dispatcher dispatcher, Persister<Set<Favorite>> persister) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(persister, "persister");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.persister = persister;
        Set<Favorite> set = persister.get();
        this.favoritesSnapshot = set;
        this.favorites = u.toMutableSet(set);
    }
}
