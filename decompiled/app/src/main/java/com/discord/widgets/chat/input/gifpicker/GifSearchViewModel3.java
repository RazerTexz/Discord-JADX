package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.stores.StoreGifPicker;
import com.discord.widgets.chat.input.gifpicker.GifSearchViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: GifSearchViewModel.kt */
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifSearchViewModel3<T, R> implements Func1<String, Observable<? extends GifSearchViewModel.StoreState>> {
    public final /* synthetic */ StoreGifPicker $storeGifPicker;
    public final /* synthetic */ List $trendingSearchTerms;

    /* compiled from: GifSearchViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends ModelGif>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(List<? extends ModelGif> list) {
            return call2((List<ModelGif>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<ModelGif> list) {
            return Boolean.valueOf(list != StoreGifPicker.INSTANCE.getSearchResultsLoadingList());
        }
    }

    /* compiled from: GifSearchViewModel.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.GifSearchViewModel$Companion$observeQueryState$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<? extends ModelGif>, List<? extends String>, GifSearchViewModel.StoreState.SearchResults> {
        public final /* synthetic */ String $query;

        public AnonymousClass2(String str) {
            this.$query = str;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ GifSearchViewModel.StoreState.SearchResults call(List<? extends ModelGif> list, List<? extends String> list2) {
            return call2((List<ModelGif>) list, (List<String>) list2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GifSearchViewModel.StoreState.SearchResults call2(List<ModelGif> list, List<String> list2) {
            Intrinsics3.checkNotNullExpressionValue(list, "gifResults");
            Intrinsics3.checkNotNullExpressionValue(list2, "searchTerms");
            return new GifSearchViewModel.StoreState.SearchResults(list, list2, GifSearchViewModel3.this.$trendingSearchTerms, this.$query);
        }
    }

    public GifSearchViewModel3(List list, StoreGifPicker storeGifPicker) {
        this.$trendingSearchTerms = list;
        this.$storeGifPicker = storeGifPicker;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends GifSearchViewModel.StoreState> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends GifSearchViewModel.StoreState> call2(String str) {
        Intrinsics3.checkNotNullExpressionValue(str, "query");
        return str.length() == 0 ? new ScalarSynchronousObservable(new GifSearchViewModel.StoreState.TrendingSearchTermsResults(this.$trendingSearchTerms)) : Observable.j(this.$storeGifPicker.observeGifsForSearchQuery(str).y(AnonymousClass1.INSTANCE), this.$storeGifPicker.observeSuggestedSearchTerms(str), new AnonymousClass2(str));
    }
}
