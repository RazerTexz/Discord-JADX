package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.models.gifpicker.dto.GifCategoryDto;
import com.discord.models.gifpicker.dto.GifDto;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.models.gifpicker.dto.TrendingGifCategoriesResponseDto;
import com.discord.models.gifpicker.dto.TrendingGifPreviewDto;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.t.n;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreGifPicker.kt */
/* loaded from: classes2.dex */
public final class StoreGifPicker extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<ModelGif> searchResultsLoadingList = n.emptyList();
    private static final List<String> searchTermsLoadingList = n.emptyList();
    private final Dispatcher dispatcher;
    private final List<ModelGifCategory> gifCategories;
    private List<ModelGifCategory> gifCategoriesSnapshot;
    private final CacheHistory<String, List<ModelGif>> gifSearchHistory;
    private Map<String, ? extends List<ModelGif>> gifSearchHistorySnapshot;
    private final CacheHistory<String, List<String>> gifSuggestedSearchTermsHistory;
    private final List<String> gifTrendingSearchTerms;
    private List<String> gifTrendingSearchTermsSnapshot;
    private boolean isFetchingGifCategories;
    private boolean isFetchingTrendingCategoryGifs;
    private boolean isFetchingTrendingSearchTerms;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private Map<String, ? extends List<String>> suggestedSearchTermsSnapshot;
    private final List<ModelGif> trendingCategoryGifs;
    private List<ModelGif> trendingCategoryGifsSnapshot;
    private String trendingGifCategoryPreviewUrl;

    /* compiled from: StoreGifPicker.kt */
    public static final class CacheHistory<K, V> extends LinkedHashMap<K, V> {
        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
            return getEntries();
        }

        public /* bridge */ Set getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set getKeys() {
            return super.keySet();
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<K> keySet() {
            return getKeys();
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > 20;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<V> values() {
            return getValues();
        }
    }

    /* compiled from: StoreGifPicker.kt */
    public static final class Companion {
        private Companion() {
        }

        public final List<ModelGif> getSearchResultsLoadingList() {
            return StoreGifPicker.access$getSearchResultsLoadingList$cp();
        }

        public final List<String> getSearchTermsLoadingList() {
            return StoreGifPicker.access$getSearchTermsLoadingList$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchGifCategories$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreGifPicker.access$handleFetchGifCategoriesError(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchGifCategories$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<TrendingGifCategoriesResponseDto, Unit> {
        public AnonymousClass2(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchGifCategoriesOnNext", "handleFetchGifCategoriesOnNext(Lcom/discord/models/gifpicker/dto/TrendingGifCategoriesResponseDto;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            invoke2(trendingGifCategoriesResponseDto);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            m.checkNotNullParameter(trendingGifCategoriesResponseDto, "p1");
            StoreGifPicker.access$handleFetchGifCategoriesOnNext((StoreGifPicker) this.receiver, trendingGifCategoriesResponseDto);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchGifTrendingSearchTerms$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreGifPicker.access$handleFetchTrendingSearchTermsError(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchGifTrendingSearchTerms$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<List<? extends String>, Unit> {
        public AnonymousClass2(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchTrendingSearchTermsOnNext", "handleFetchTrendingSearchTermsOnNext(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            m.checkNotNullParameter(list, "p1");
            StoreGifPicker.access$handleFetchTrendingSearchTermsOnNext((StoreGifPicker) this.receiver, list);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<List<? extends GifDto>, List<? extends ModelGif>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends ModelGif> call(List<? extends GifDto> list) {
            return call2((List<GifDto>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ModelGif> call2(List<GifDto> list) {
            m.checkNotNullExpressionValue(list, "gifDtos");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ModelGif.INSTANCE.createFromGifDto((GifDto) it.next()));
            }
            return arrayList;
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $query;

        /* compiled from: StoreGifPicker.kt */
        /* renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGifPicker.access$handleGifSearchResults(StoreGifPicker.this, anonymousClass2.$query, n.emptyList());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreGifPicker.access$getDispatcher$p(StoreGifPicker.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<List<? extends ModelGif>, Unit> {
        public final /* synthetic */ String $query;

        /* compiled from: StoreGifPicker.kt */
        /* renamed from: com.discord.stores.StoreGifPicker$fetchGifsForSearchQuery$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ List $gifs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$gifs = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGifPicker storeGifPicker = StoreGifPicker.this;
                String str = anonymousClass3.$query;
                List list = this.$gifs;
                m.checkNotNullExpressionValue(list, "gifs");
                StoreGifPicker.access$handleGifSearchResults(storeGifPicker, str, list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGif> list) {
            invoke2((List<ModelGif>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGif> list) {
            StoreGifPicker.access$getDispatcher$p(StoreGifPicker.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $query;

        /* compiled from: StoreGifPicker.kt */
        /* renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02311 extends o implements Function0<Unit> {
            public C02311() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGifPicker.access$handleSuggestedSearchTerms(StoreGifPicker.this, anonymousClass1.$query, n.emptyList());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreGifPicker.access$getDispatcher$p(StoreGifPicker.this).schedule(new C02311());
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<List<? extends String>, Unit> {
        public final /* synthetic */ String $query;

        /* compiled from: StoreGifPicker.kt */
        /* renamed from: com.discord.stores.StoreGifPicker$fetchSuggestedSearchTerms$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ List $suggestedSearchTerms;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$suggestedSearchTerms = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGifPicker.access$handleSuggestedSearchTerms(StoreGifPicker.this, anonymousClass2.$query, this.$suggestedSearchTerms);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            m.checkNotNullParameter(list, "suggestedSearchTerms");
            StoreGifPicker.access$getDispatcher$p(StoreGifPicker.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchTrendingCategoryGifs$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<List<? extends GifDto>, List<? extends ModelGif>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends ModelGif> call(List<? extends GifDto> list) {
            return call2((List<GifDto>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ModelGif> call2(List<GifDto> list) {
            m.checkNotNullExpressionValue(list, "gifDtos");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(ModelGif.INSTANCE.createFromGifDto((GifDto) it.next()));
            }
            return arrayList;
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchTrendingCategoryGifs$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreGifPicker.access$handleFetchTrendingGifsError(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$fetchTrendingCategoryGifs$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<List<? extends ModelGif>, Unit> {
        public AnonymousClass3(StoreGifPicker storeGifPicker) {
            super(1, storeGifPicker, StoreGifPicker.class, "handleFetchTrendingGifsOnNext", "handleFetchTrendingGifsOnNext(Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGif> list) {
            invoke2((List<ModelGif>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelGif> list) {
            m.checkNotNullParameter(list, "p1");
            StoreGifPicker.access$handleFetchTrendingGifsOnNext((StoreGifPicker) this.receiver, list);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$handleFetchGifCategoriesError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$setFetchingGifCategories$p(StoreGifPicker.this, false);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$handleFetchGifCategoriesOnNext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ TrendingGifCategoriesResponseDto $trendingGifsResponseRaw;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
            super(0);
            this.$trendingGifsResponseRaw = trendingGifCategoriesResponseDto;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$handleTrendingCategoriesResponse(StoreGifPicker.this, this.$trendingGifsResponseRaw);
            StoreGifPicker.access$setFetchingGifCategories$p(StoreGifPicker.this, false);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingGifsError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$setFetchingTrendingCategoryGifs$p(StoreGifPicker.this, false);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingGifsOnNext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ List $gifs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$gifs = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$updateTrendingCategoryGifs(StoreGifPicker.this, this.$gifs);
            StoreGifPicker.access$setFetchingTrendingCategoryGifs$p(StoreGifPicker.this, false);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingSearchTermsError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$setFetchingTrendingSearchTerms$p(StoreGifPicker.this, false);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$handleFetchTrendingSearchTermsOnNext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ List $trendingSearchTerms;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$trendingSearchTerms = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGifPicker.access$updateTrendingSearchTerms(StoreGifPicker.this, this.$trendingSearchTerms);
            StoreGifPicker.access$setFetchingTrendingSearchTerms$p(StoreGifPicker.this, false);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeGifCategories$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.access$getGifCategories$p(StoreGifPicker.this).isEmpty() || StoreGifPicker.access$isFetchingGifCategories$p(StoreGifPicker.this)) {
                return;
            }
            StoreGifPicker.this.fetchGifCategories();
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeGifCategories$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<List<? extends ModelGifCategory>> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelGifCategory> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelGifCategory> invoke2() {
            return StoreGifPicker.access$getGifCategories(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeGifTrendingSearchTerms$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.access$getGifTrendingSearchTerms$p(StoreGifPicker.this).isEmpty() || StoreGifPicker.access$isFetchingTrendingSearchTerms$p(StoreGifPicker.this)) {
                return;
            }
            StoreGifPicker.access$fetchGifTrendingSearchTerms(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeGifTrendingSearchTerms$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<List<? extends String>> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends String> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends String> invoke2() {
            return StoreGifPicker.access$getGifTrendingSearchTerms(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeGifsForSearchQuery$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGifPicker.access$getGifSearchHistory$p(StoreGifPicker.this).containsKey(this.$query)) {
                return;
            }
            StoreGifPicker.access$getGifSearchHistory$p(StoreGifPicker.this).put(this.$query, StoreGifPicker.INSTANCE.getSearchResultsLoadingList());
            StoreGifPicker.access$fetchGifsForSearchQuery(StoreGifPicker.this, this.$query);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeGifsForSearchQuery$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<String, ? extends List<? extends ModelGif>>, List<? extends ModelGif>> {
        public final /* synthetic */ String $query;

        public AnonymousClass2(String str) {
            this.$query = str;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends ModelGif> call(Map<String, ? extends List<? extends ModelGif>> map) {
            return call2((Map<String, ? extends List<ModelGif>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<ModelGif> call2(Map<String, ? extends List<ModelGif>> map) {
            return map.get(this.$query);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeSearchHistory$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<String, ? extends List<? extends ModelGif>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends List<? extends ModelGif>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends List<? extends ModelGif>> invoke2() {
            return StoreGifPicker.access$getSearchHistory(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeSuggestedSearchTerms$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<String, ? extends List<? extends String>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends List<? extends String>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends List<? extends String>> invoke2() {
            return StoreGifPicker.access$getSuggestedSearchTermsHistory(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeSuggestedSearchTerms$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public final /* synthetic */ String $query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(0);
            this.$query = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGifPicker.access$getGifSuggestedSearchTermsHistory$p(StoreGifPicker.this).containsKey(this.$query)) {
                return;
            }
            StoreGifPicker.access$getGifSuggestedSearchTermsHistory$p(StoreGifPicker.this).put(this.$query, StoreGifPicker.INSTANCE.getSearchTermsLoadingList());
            StoreGifPicker.access$fetchSuggestedSearchTerms(StoreGifPicker.this, this.$query);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeSuggestedSearchTerms$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements b<Map<String, ? extends List<? extends String>>, List<? extends String>> {
        public final /* synthetic */ String $query;

        public AnonymousClass3(String str) {
            this.$query = str;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends String> call(Map<String, ? extends List<? extends String>> map) {
            return call2((Map<String, ? extends List<String>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<String> call2(Map<String, ? extends List<String>> map) {
            return map.get(this.$query);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeTrendingCategoryGifs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreGifPicker.access$getTrendingCategoryGifs$p(StoreGifPicker.this).isEmpty() || StoreGifPicker.access$isFetchingTrendingCategoryGifs$p(StoreGifPicker.this)) {
                return;
            }
            StoreGifPicker.access$fetchTrendingCategoryGifs(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeTrendingCategoryGifs$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<List<? extends ModelGif>> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelGif> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelGif> invoke2() {
            return StoreGifPicker.access$getTrendingCategoryGifs(StoreGifPicker.this);
        }
    }

    /* compiled from: StoreGifPicker.kt */
    /* renamed from: com.discord.stores.StoreGifPicker$observeTrendingGifCategoryPreviewUrl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<String> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            return StoreGifPicker.access$getTrendingGifCategoryPreviewUrl(StoreGifPicker.this);
        }
    }

    public /* synthetic */ StoreGifPicker(Dispatcher dispatcher, StoreUserSettingsSystem storeUserSettingsSystem, RestAPI restAPI, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUserSettingsSystem, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchGifTrendingSearchTerms(StoreGifPicker storeGifPicker) {
        storeGifPicker.fetchGifTrendingSearchTerms();
    }

    public static final /* synthetic */ void access$fetchGifsForSearchQuery(StoreGifPicker storeGifPicker, String str) {
        storeGifPicker.fetchGifsForSearchQuery(str);
    }

    public static final /* synthetic */ void access$fetchSuggestedSearchTerms(StoreGifPicker storeGifPicker, String str) {
        storeGifPicker.fetchSuggestedSearchTerms(str);
    }

    public static final /* synthetic */ void access$fetchTrendingCategoryGifs(StoreGifPicker storeGifPicker) {
        storeGifPicker.fetchTrendingCategoryGifs();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.dispatcher;
    }

    public static final /* synthetic */ List access$getGifCategories(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getGifCategories();
    }

    public static final /* synthetic */ List access$getGifCategories$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifCategories;
    }

    public static final /* synthetic */ CacheHistory access$getGifSearchHistory$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifSearchHistory;
    }

    public static final /* synthetic */ CacheHistory access$getGifSuggestedSearchTermsHistory$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifSuggestedSearchTermsHistory;
    }

    public static final /* synthetic */ List access$getGifTrendingSearchTerms(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getGifTrendingSearchTerms();
    }

    public static final /* synthetic */ List access$getGifTrendingSearchTerms$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.gifTrendingSearchTerms;
    }

    public static final /* synthetic */ Map access$getSearchHistory(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getSearchHistory();
    }

    public static final /* synthetic */ List access$getSearchResultsLoadingList$cp() {
        return searchResultsLoadingList;
    }

    public static final /* synthetic */ List access$getSearchTermsLoadingList$cp() {
        return searchTermsLoadingList;
    }

    public static final /* synthetic */ Map access$getSuggestedSearchTermsHistory(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getSuggestedSearchTermsHistory();
    }

    public static final /* synthetic */ List access$getTrendingCategoryGifs(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getTrendingCategoryGifs();
    }

    public static final /* synthetic */ List access$getTrendingCategoryGifs$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.trendingCategoryGifs;
    }

    public static final /* synthetic */ String access$getTrendingGifCategoryPreviewUrl(StoreGifPicker storeGifPicker) {
        return storeGifPicker.getTrendingGifCategoryPreviewUrl();
    }

    public static final /* synthetic */ void access$handleFetchGifCategoriesError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchGifCategoriesError();
    }

    public static final /* synthetic */ void access$handleFetchGifCategoriesOnNext(StoreGifPicker storeGifPicker, TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        storeGifPicker.handleFetchGifCategoriesOnNext(trendingGifCategoriesResponseDto);
    }

    public static final /* synthetic */ void access$handleFetchTrendingGifsError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchTrendingGifsError();
    }

    public static final /* synthetic */ void access$handleFetchTrendingGifsOnNext(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.handleFetchTrendingGifsOnNext(list);
    }

    public static final /* synthetic */ void access$handleFetchTrendingSearchTermsError(StoreGifPicker storeGifPicker) {
        storeGifPicker.handleFetchTrendingSearchTermsError();
    }

    public static final /* synthetic */ void access$handleFetchTrendingSearchTermsOnNext(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.handleFetchTrendingSearchTermsOnNext(list);
    }

    public static final /* synthetic */ void access$handleGifSearchResults(StoreGifPicker storeGifPicker, String str, List list) {
        storeGifPicker.handleGifSearchResults(str, list);
    }

    public static final /* synthetic */ void access$handleSuggestedSearchTerms(StoreGifPicker storeGifPicker, String str, List list) {
        storeGifPicker.handleSuggestedSearchTerms(str, list);
    }

    public static final /* synthetic */ void access$handleTrendingCategoriesResponse(StoreGifPicker storeGifPicker, TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        storeGifPicker.handleTrendingCategoriesResponse(trendingGifCategoriesResponseDto);
    }

    public static final /* synthetic */ boolean access$isFetchingGifCategories$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingGifCategories;
    }

    public static final /* synthetic */ boolean access$isFetchingTrendingCategoryGifs$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingTrendingCategoryGifs;
    }

    public static final /* synthetic */ boolean access$isFetchingTrendingSearchTerms$p(StoreGifPicker storeGifPicker) {
        return storeGifPicker.isFetchingTrendingSearchTerms;
    }

    public static final /* synthetic */ void access$setFetchingGifCategories$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingGifCategories = z2;
    }

    public static final /* synthetic */ void access$setFetchingTrendingCategoryGifs$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingTrendingCategoryGifs = z2;
    }

    public static final /* synthetic */ void access$setFetchingTrendingSearchTerms$p(StoreGifPicker storeGifPicker, boolean z2) {
        storeGifPicker.isFetchingTrendingSearchTerms = z2;
    }

    public static final /* synthetic */ void access$updateTrendingCategoryGifs(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.updateTrendingCategoryGifs(list);
    }

    public static final /* synthetic */ void access$updateTrendingSearchTerms(StoreGifPicker storeGifPicker, List list) {
        storeGifPicker.updateTrendingSearchTerms(list);
    }

    private final void fetchGifTrendingSearchTerms() {
        this.isFetchingTrendingSearchTerms = true;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifTrendingSearchTerms("tenor", this.storeUserSettingsSystem.getLocale(), 5), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(this), 54, (Object) null);
    }

    private final void fetchGifsForSearchQuery(String query) {
        Observable<R> observableG = this.restAPI.getGifSearchResults(query, "tenor", this.storeUserSettingsSystem.getLocale(), "tinygif", 50).G(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "restAPI.getGifSearchResu…to)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableG, false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new AnonymousClass2(query), (Function0) null, (Function0) null, new AnonymousClass3(query), 54, (Object) null);
    }

    private final void fetchSuggestedSearchTerms(String query) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGifSuggestedSearchTerms("tenor", query, this.storeUserSettingsSystem.getLocale(), 5), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new AnonymousClass1(query), (Function0) null, (Function0) null, new AnonymousClass2(query), 54, (Object) null);
    }

    private final void fetchTrendingCategoryGifs() {
        this.isFetchingTrendingCategoryGifs = true;
        Observable<R> observableG = this.restAPI.getTrendingGifCategory("tenor", this.storeUserSettingsSystem.getLocale(), "tinygif", 50).G(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "restAPI.getTrendingGifCa…to)\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observableG, false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass3(this), 54, (Object) null);
    }

    private final List<ModelGifCategory> getGifCategories() {
        return this.gifCategoriesSnapshot;
    }

    private final List<String> getGifTrendingSearchTerms() {
        return this.gifTrendingSearchTermsSnapshot;
    }

    private final Map<String, List<ModelGif>> getSearchHistory() {
        return this.gifSearchHistorySnapshot;
    }

    private final Map<String, List<String>> getSuggestedSearchTermsHistory() {
        return this.gifSuggestedSearchTermsHistory;
    }

    private final List<ModelGif> getTrendingCategoryGifs() {
        return this.trendingCategoryGifsSnapshot;
    }

    private final String getTrendingGifCategoryPreviewUrl() {
        return this.trendingGifCategoryPreviewUrl;
    }

    private final void handleFetchGifCategoriesError() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    private final void handleFetchGifCategoriesOnNext(TrendingGifCategoriesResponseDto trendingGifsResponseRaw) {
        this.dispatcher.schedule(new AnonymousClass1(trendingGifsResponseRaw));
    }

    private final void handleFetchTrendingGifsError() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    private final void handleFetchTrendingGifsOnNext(List<ModelGif> gifs) {
        this.dispatcher.schedule(new AnonymousClass1(gifs));
    }

    private final void handleFetchTrendingSearchTermsError() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    private final void handleFetchTrendingSearchTermsOnNext(List<String> trendingSearchTerms) {
        this.dispatcher.schedule(new AnonymousClass1(trendingSearchTerms));
    }

    @StoreThread
    private final void handleGifSearchResults(String query, List<ModelGif> gifs) {
        this.gifSearchHistory.put(query, gifs);
        markChanged();
    }

    @StoreThread
    private final void handleSuggestedSearchTerms(String query, List<String> suggestedSearchTerms) {
        this.gifSuggestedSearchTermsHistory.put(query, suggestedSearchTerms);
        markChanged();
    }

    @StoreThread
    private final void handleTrendingCategoriesResponse(TrendingGifCategoriesResponseDto trendingGifCategoriesResponseDto) {
        List<GifCategoryDto> categories = trendingGifCategoriesResponseDto.getCategories();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(categories, 10));
        for (GifCategoryDto gifCategoryDto : categories) {
            arrayList.add(new ModelGifCategory(gifCategoryDto.getName(), gifCategoryDto.getSrc()));
        }
        updateGifCategories(arrayList);
        List<TrendingGifPreviewDto> gifs = trendingGifCategoriesResponseDto.getGifs();
        this.trendingGifCategoryPreviewUrl = gifs.isEmpty() ^ true ? gifs.get(0).getSrc() : "";
        markChanged();
    }

    private final Observable<Map<String, List<ModelGif>>> observeSearchHistory() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new AnonymousClass1(), 12, null);
    }

    private final Observable<Map<String, List<String>>> observeSuggestedSearchTerms() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new AnonymousClass1(), 12, null);
    }

    @StoreThread
    private final void updateGifCategories(List<ModelGifCategory> categories) {
        this.gifCategories.clear();
        this.gifCategories.addAll(categories);
        markChanged();
    }

    @StoreThread
    private final void updateTrendingCategoryGifs(List<ModelGif> gifs) {
        this.trendingCategoryGifs.clear();
        this.trendingCategoryGifs.addAll(gifs);
        markChanged();
    }

    @StoreThread
    private final void updateTrendingSearchTerms(List<String> trendingGifSearchTerms) {
        this.gifTrendingSearchTerms.clear();
        this.gifTrendingSearchTerms.addAll(trendingGifSearchTerms);
        markChanged();
    }

    public final void fetchGifCategories() {
        this.isFetchingGifCategories = true;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getTrendingGifCategories("tenor", this.storeUserSettingsSystem.getLocale(), "tinygif"), false, 1, null), StoreGifPicker.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(this), 54, (Object) null);
    }

    public final Observable<List<ModelGifCategory>> observeGifCategories() {
        this.dispatcher.schedule(new AnonymousClass1());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new AnonymousClass2(), 12, null);
    }

    public final Observable<List<String>> observeGifTrendingSearchTerms() {
        this.dispatcher.schedule(new AnonymousClass1());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new AnonymousClass2(), 12, null);
    }

    public final Observable<List<ModelGif>> observeGifsForSearchQuery(String query) {
        m.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new AnonymousClass1(query));
        Observable<R> observableG = observeSearchHistory().G(new AnonymousClass2(query));
        m.checkNotNullExpressionValue(observableG, "observeSearchHistory().m…gifSearchHistory[query] }");
        Observable<List<ModelGif>> observableG2 = observableG.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG2, "filter { it != null }.map { it!! }");
        return observableG2;
    }

    public final Observable<List<ModelGif>> observeTrendingCategoryGifs() {
        this.dispatcher.schedule(new AnonymousClass1());
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new AnonymousClass2(), 12, null);
    }

    public final Observable<String> observeTrendingGifCategoryPreviewUrl() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, true, null, null, new AnonymousClass1(), 12, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.gifCategoriesSnapshot = new ArrayList(this.gifCategories);
        this.gifTrendingSearchTermsSnapshot = new ArrayList(this.gifTrendingSearchTerms);
        this.gifSearchHistorySnapshot = new HashMap(this.gifSearchHistory);
        this.suggestedSearchTermsSnapshot = new HashMap(this.gifSuggestedSearchTermsHistory);
        this.trendingCategoryGifsSnapshot = new ArrayList(this.trendingCategoryGifs);
    }

    public final Observable<List<String>> observeSuggestedSearchTerms(String query) {
        m.checkNotNullParameter(query, "query");
        this.dispatcher.schedule(new AnonymousClass2(query));
        Observable<R> observableG = observeSuggestedSearchTerms().G(new AnonymousClass3(query));
        m.checkNotNullExpressionValue(observableG, "observeSuggestedSearchTe…archTermsHistory[query] }");
        Observable<List<String>> observableG2 = observableG.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG2, "filter { it != null }.map { it!! }");
        return observableG2;
    }

    public StoreGifPicker(Dispatcher dispatcher, StoreUserSettingsSystem storeUserSettingsSystem, RestAPI restAPI, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        this.restAPI = restAPI;
        this.observationDeck = observationDeck;
        this.gifCategoriesSnapshot = n.emptyList();
        this.gifTrendingSearchTermsSnapshot = n.emptyList();
        this.gifSearchHistorySnapshot = h0.emptyMap();
        this.suggestedSearchTermsSnapshot = h0.emptyMap();
        this.trendingCategoryGifsSnapshot = n.emptyList();
        this.gifCategories = new ArrayList();
        this.gifTrendingSearchTerms = new ArrayList();
        this.trendingCategoryGifs = new ArrayList();
        this.trendingGifCategoryPreviewUrl = "";
        this.gifSearchHistory = new CacheHistory<>();
        this.gifSuggestedSearchTermsHistory = new CacheHistory<>();
    }
}
