package com.discord.utilities.images;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p161j.p170e.ImagePipeline2;
import p007b.p109f.p161j.p170e.ImagePipelineFactory;
import p007b.p109f.p161j.p171f.BaseBitmapDataSubscriber;
import p007b.p109f.p161j.p175j.CloseableImage;
import p507d0.Tuples;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.p595g0.KMarkers;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeFromIterable;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Subscriber;

/* compiled from: MGImagesBitmap.kt */
/* loaded from: classes2.dex */
public final class MGImagesBitmap {
    public static final MGImagesBitmap INSTANCE = new MGImagesBitmap();

    /* compiled from: MGImagesBitmap.kt */
    public static final class CloseableBitmaps implements Map<String, Bitmap>, Closeable, KMarkers {
        private final boolean recycleBitmaps;
        private final Map<String, Bitmap> underlyingMap;

        public CloseableBitmaps(Map<String, Bitmap> map, boolean z2) {
            Intrinsics3.checkNotNullParameter(map, "underlyingMap");
            this.underlyingMap = map;
            this.recycleBitmaps = z2;
        }

        @Override // java.util.Map
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.recycleBitmaps) {
                Iterator<Map.Entry<String, Bitmap>> it = this.underlyingMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().recycle();
                }
            }
        }

        /* renamed from: compute, reason: avoid collision after fix types in other method */
        public Bitmap compute2(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap compute(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
        public Bitmap computeIfAbsent2(String str, Function<? super String, ? extends Bitmap> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap computeIfAbsent(String str, Function<? super String, ? extends Bitmap> function) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
        public Bitmap computeIfPresent2(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap computeIfPresent(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public boolean containsKey(String key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return this.underlyingMap.containsKey(key);
        }

        public boolean containsValue(Bitmap value) {
            Intrinsics3.checkNotNullParameter(value, "value");
            return this.underlyingMap.containsValue(value);
        }

        @Override // java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Bitmap) {
                return containsValue((Bitmap) obj);
            }
            return false;
        }

        @Override // java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Bitmap>> entrySet() {
            return getEntries();
        }

        public Bitmap get(String key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return this.underlyingMap.get(key);
        }

        @Override // java.util.Map
        public final /* bridge */ Bitmap get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public Set<Map.Entry<String, Bitmap>> getEntries() {
            return this.underlyingMap.entrySet();
        }

        public Set<String> getKeys() {
            return this.underlyingMap.keySet();
        }

        public int getSize() {
            return this.underlyingMap.size();
        }

        public Collection<Bitmap> getValues() {
            return this.underlyingMap.values();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.underlyingMap.isEmpty();
        }

        @Override // java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        /* renamed from: merge, reason: avoid collision after fix types in other method */
        public Bitmap merge2(String str, Bitmap bitmap, BiFunction<? super Bitmap, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap merge(String str, Bitmap bitmap, BiFunction<? super Bitmap, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final CloseableBitmaps plus(CloseableBitmaps other) {
            Intrinsics3.checkNotNullParameter(other, "other");
            return new CloseableBitmaps(Maps6.plus(this.underlyingMap, other.underlyingMap), this.recycleBitmaps && other.recycleBitmaps);
        }

        /* renamed from: put, reason: avoid collision after fix types in other method */
        public Bitmap put2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap put(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void putAll(Map<? extends String, ? extends Bitmap> map) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
        public Bitmap putIfAbsent2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap putIfAbsent(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public Bitmap remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: replace, reason: avoid collision after fix types in other method */
        public Bitmap replace2(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ Bitmap replace(String str, Bitmap bitmap) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public /* synthetic */ boolean replace(String str, Bitmap bitmap, Bitmap bitmap2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* renamed from: replace, reason: avoid collision after fix types in other method */
        public boolean replace2(String str, Bitmap bitmap, Bitmap bitmap2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.Map
        public final /* bridge */ Collection<Bitmap> values() {
            return getValues();
        }

        public /* synthetic */ CloseableBitmaps(Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(map, (i & 2) != 0 ? true : z2);
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    public static final class DecodeException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DecodeException(String str) {
            super("Unable to decode image: " + str + '.');
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    public static final class ImageNotFoundException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageNotFoundException(String str) {
            super("404 image not found: " + str);
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    public static final /* data */ class ImageRequest {
        private final String imageUri;
        private final boolean roundAsCircle;

        public ImageRequest(String str, boolean z2) {
            Intrinsics3.checkNotNullParameter(str, "imageUri");
            this.imageUri = str;
            this.roundAsCircle = z2;
        }

        public static /* synthetic */ ImageRequest copy$default(ImageRequest imageRequest, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = imageRequest.imageUri;
            }
            if ((i & 2) != 0) {
                z2 = imageRequest.roundAsCircle;
            }
            return imageRequest.copy(str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getImageUri() {
            return this.imageUri;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getRoundAsCircle() {
            return this.roundAsCircle;
        }

        public final ImageRequest copy(String imageUri, boolean roundAsCircle) {
            Intrinsics3.checkNotNullParameter(imageUri, "imageUri");
            return new ImageRequest(imageUri, roundAsCircle);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ImageRequest)) {
                return false;
            }
            ImageRequest imageRequest = (ImageRequest) other;
            return Intrinsics3.areEqual(this.imageUri, imageRequest.imageUri) && this.roundAsCircle == imageRequest.roundAsCircle;
        }

        public final String getImageUri() {
            return this.imageUri;
        }

        public final boolean getRoundAsCircle() {
            return this.roundAsCircle;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.imageUri;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.roundAsCircle;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ImageRequest(imageUri=");
            sbM833U.append(this.imageUri);
            sbM833U.append(", roundAsCircle=");
            return outline.m827O(sbM833U, this.roundAsCircle, ")");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    public static final class MissingBitmapException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingBitmapException(String str) {
            super("Unable to decode image as bitmap: " + str);
            Intrinsics3.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmap$1 */
    public static final class C67751<T> implements Observable.InterfaceC13005a<Bitmap> {
        public final /* synthetic */ DataSource $dataSource;
        public final /* synthetic */ String $imageUri;

        /* compiled from: MGImagesBitmap.kt */
        /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmap$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends BaseBitmapDataSubscriber {
            public final /* synthetic */ Subscriber $emitter;

            public AnonymousClass1(Subscriber subscriber) {
                this.$emitter = subscriber;
            }

            @Override // p007b.p109f.p129e.BaseDataSubscriber
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                String message;
                Intrinsics3.checkNotNullParameter(dataSource, "dataSource");
                Throwable thMo1020d = dataSource.mo1020d();
                if (thMo1020d != null && (message = thMo1020d.getMessage()) != null && Strings4.contains$default((CharSequence) message, (CharSequence) "404", false, 2, (Object) null)) {
                    this.$emitter.onError(new ImageNotFoundException(C67751.this.$imageUri));
                    return;
                }
                Subscriber subscriber = this.$emitter;
                Throwable thMo1020d2 = dataSource.mo1020d();
                if (thMo1020d2 == null) {
                    thMo1020d2 = new DecodeException(C67751.this.$imageUri);
                }
                subscriber.onError(thMo1020d2);
            }

            @Override // p007b.p109f.p161j.p171f.BaseBitmapDataSubscriber
            public void onNewResultImpl(Bitmap bitmap) {
                if (bitmap == null) {
                    this.$emitter.onError(new MissingBitmapException(C67751.this.$imageUri));
                } else {
                    this.$emitter.onNext(Bitmap.createBitmap(bitmap));
                    this.$emitter.onCompleted();
                }
            }
        }

        /* compiled from: MGImagesBitmap.kt */
        /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmap$1$2, reason: invalid class name */
        public static final class AnonymousClass2 implements Executor {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        }

        public C67751(DataSource dataSource, String str) {
            this.$dataSource = dataSource;
            this.$imageUri = str;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber<? super Bitmap>) obj);
        }

        public final void call(Subscriber<? super Bitmap> subscriber) {
            this.$dataSource.mo1022f(new AnonymousClass1(subscriber), AnonymousClass2.INSTANCE);
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$1 */
    public static final class C67761<T, R> implements Func1<ImageRequest, Observable<? extends Tuples2<? extends String, ? extends Bitmap>>> {
        public static final C67761 INSTANCE = new C67761();

        /* compiled from: MGImagesBitmap.kt */
        /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Bitmap, Tuples2<? extends String, ? extends Bitmap>> {
            public final /* synthetic */ ImageRequest $imageRequest;

            public AnonymousClass1(ImageRequest imageRequest) {
                this.$imageRequest = imageRequest;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Tuples2<? extends String, ? extends Bitmap> call(Bitmap bitmap) {
                return call2(bitmap);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<String, Bitmap> call2(Bitmap bitmap) {
                return Tuples.m10073to(this.$imageRequest.getImageUri(), bitmap);
            }
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends String, ? extends Bitmap>> call(ImageRequest imageRequest) {
            return call2(imageRequest);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Tuples2<String, Bitmap>> call2(ImageRequest imageRequest) {
            return MGImagesBitmap.INSTANCE.getBitmap(imageRequest.getImageUri(), imageRequest.getRoundAsCircle()).m11083G(new AnonymousClass1(imageRequest));
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$2 */
    public static final class C67772<T, R> implements Func1<Tuples2<? extends String, ? extends Bitmap>, String> {
        public static final C67772 INSTANCE = new C67772();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ String call(Tuples2<? extends String, ? extends Bitmap> tuples2) {
            return call2((Tuples2<String, Bitmap>) tuples2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(Tuples2<String, Bitmap> tuples2) {
            return tuples2.getFirst();
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$3 */
    public static final class C67783<T, R> implements Func1<Tuples2<? extends String, ? extends Bitmap>, Bitmap> {
        public static final C67783 INSTANCE = new C67783();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Bitmap call(Tuples2<? extends String, ? extends Bitmap> tuples2) {
            return call2((Tuples2<String, Bitmap>) tuples2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Bitmap call2(Tuples2<String, Bitmap> tuples2) {
            return tuples2.getSecond();
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$4 */
    public static final class C67794<T, R> implements Func1<Map<String, Bitmap>, CloseableBitmaps> {
        public static final C67794 INSTANCE = new C67794();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ CloseableBitmaps call(Map<String, Bitmap> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final CloseableBitmaps call2(Map<String, Bitmap> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "it");
            return new CloseableBitmaps(map, false, 2, null);
        }
    }

    private MGImagesBitmap() {
    }

    public static final Observable<CloseableBitmaps> getBitmaps(Set<ImageRequest> imageRequests) {
        Intrinsics3.checkNotNullParameter(imageRequests, "imageRequests");
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageRequests) {
            if (!StringsJVM.isBlank(((ImageRequest) obj).getImageUri())) {
                arrayList.add(obj);
            }
        }
        Observable<CloseableBitmaps> observableM11098X = Observable.m11074h0(new OnSubscribeFromIterable(arrayList)).m11082A(C67761.INSTANCE).m11106g0(C67772.INSTANCE, C67783.INSTANCE).m11083G(C67794.INSTANCE).m11098X(Schedulers2.m10873a());
        Intrinsics3.checkNotNullExpressionValue(observableM11098X, "Observable\n        .from…Schedulers.computation())");
        return observableM11098X;
    }

    private final boolean isValidUri(String imageUri) {
        Uri uri = Uri.parse(imageUri);
        Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        String scheme = uri.getScheme();
        if (scheme == null || StringsJVM.isBlank(scheme)) {
            return false;
        }
        String host = uri.getHost();
        if (host == null || StringsJVM.isBlank(host)) {
            return false;
        }
        String path = uri.getPath();
        return !(path == null || StringsJVM.isBlank(path));
    }

    public final Observable<Bitmap> getBitmap(String imageUri, boolean imageIsCircle) {
        Intrinsics3.checkNotNullParameter(imageUri, "imageUri");
        if (!isValidUri(imageUri)) {
            Observable<Bitmap> observableM11081x = Observable.m11081x(new IllegalArgumentException(outline.m883w("invalid uri: ", imageUri)));
            Intrinsics3.checkNotNullExpressionValue(observableM11081x, "Observable.error(Illegal…invalid uri: $imageUri\"))");
            return observableM11081x;
        }
        ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.f3788a;
        AnimatableValueParser.m591y(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        if (imagePipelineFactory.f3799l == null) {
            imagePipelineFactory.f3799l = imagePipelineFactory.m1295a();
        }
        ImagePipeline2 imagePipeline2 = imagePipelineFactory.f3799l;
        ImageRequestBuilder imageRequest = MGImages.getImageRequest(imageUri, 0, 0, false);
        if (imageIsCircle) {
            imageRequest.f19623l = new RoundAsCirclePostProcessor2(imageUri);
        }
        Observable<Bitmap> observableM11074h0 = Observable.m11074h0(new C67751(imagePipeline2.m1262a(imageRequest.m8724a(), null, ImageRequest.EnumC10667c.FULL_FETCH, null, null), imageUri));
        Intrinsics3.checkNotNullExpressionValue(observableM11074h0, "Observable.unsafeCreate …y emits the bitmap.\n    }");
        return observableM11074h0;
    }
}
