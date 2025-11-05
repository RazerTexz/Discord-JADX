package com.discord.utilities.images;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.c.a.a0.d;
import b.f.j.e.h;
import b.f.j.f.c;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.g0.t;
import d0.g0.w;
import d0.o;
import d0.t.h0;
import d0.z.d.g0.a;
import d0.z.d.m;
import j0.k.b;
import j0.l.a.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscriber;

/* compiled from: MGImagesBitmap.kt */
/* loaded from: classes2.dex */
public final class MGImagesBitmap {
    public static final MGImagesBitmap INSTANCE = new MGImagesBitmap();

    /* compiled from: MGImagesBitmap.kt */
    public static final class CloseableBitmaps implements Map<String, Bitmap>, Closeable, a {
        private final boolean recycleBitmaps;
        private final Map<String, Bitmap> underlyingMap;

        public CloseableBitmaps(Map<String, Bitmap> map, boolean z2) {
            m.checkNotNullParameter(map, "underlyingMap");
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
            m.checkNotNullParameter(key, "key");
            return this.underlyingMap.containsKey(key);
        }

        public boolean containsValue(Bitmap value) {
            m.checkNotNullParameter(value, "value");
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
            m.checkNotNullParameter(key, "key");
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
            m.checkNotNullParameter(other, "other");
            return new CloseableBitmaps(h0.plus(this.underlyingMap, other.underlyingMap), this.recycleBitmaps && other.recycleBitmaps);
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
            m.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    public static final class ImageNotFoundException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ImageNotFoundException(String str) {
            super("404 image not found: " + str);
            m.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    public static final /* data */ class ImageRequest {
        private final String imageUri;
        private final boolean roundAsCircle;

        public ImageRequest(String str, boolean z2) {
            m.checkNotNullParameter(str, "imageUri");
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
            m.checkNotNullParameter(imageUri, "imageUri");
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
            return m.areEqual(this.imageUri, imageRequest.imageUri) && this.roundAsCircle == imageRequest.roundAsCircle;
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
            StringBuilder sbU = b.d.b.a.a.U("ImageRequest(imageUri=");
            sbU.append(this.imageUri);
            sbU.append(", roundAsCircle=");
            return b.d.b.a.a.O(sbU, this.roundAsCircle, ")");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    public static final class MissingBitmapException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingBitmapException(String str) {
            super("Unable to decode image as bitmap: " + str);
            m.checkNotNullParameter(str, "imageUri");
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmap$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Observable.a<Bitmap> {
        public final /* synthetic */ DataSource $dataSource;
        public final /* synthetic */ String $imageUri;

        /* compiled from: MGImagesBitmap.kt */
        /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmap$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03341 extends c {
            public final /* synthetic */ Subscriber $emitter;

            public C03341(Subscriber subscriber) {
                this.$emitter = subscriber;
            }

            @Override // b.f.e.d
            public void onFailureImpl(DataSource<CloseableReference<b.f.j.j.c>> dataSource) {
                String message;
                m.checkNotNullParameter(dataSource, "dataSource");
                Throwable thD = dataSource.d();
                if (thD != null && (message = thD.getMessage()) != null && w.contains$default((CharSequence) message, (CharSequence) "404", false, 2, (Object) null)) {
                    this.$emitter.onError(new ImageNotFoundException(AnonymousClass1.this.$imageUri));
                    return;
                }
                Subscriber subscriber = this.$emitter;
                Throwable thD2 = dataSource.d();
                if (thD2 == null) {
                    thD2 = new DecodeException(AnonymousClass1.this.$imageUri);
                }
                subscriber.onError(thD2);
            }

            @Override // b.f.j.f.c
            public void onNewResultImpl(Bitmap bitmap) {
                if (bitmap == null) {
                    this.$emitter.onError(new MissingBitmapException(AnonymousClass1.this.$imageUri));
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

        public AnonymousClass1(DataSource dataSource, String str) {
            this.$dataSource = dataSource;
            this.$imageUri = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber<? super Bitmap>) obj);
        }

        public final void call(Subscriber<? super Bitmap> subscriber) {
            this.$dataSource.f(new C03341(subscriber), AnonymousClass2.INSTANCE);
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<ImageRequest, Observable<? extends Pair<? extends String, ? extends Bitmap>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: MGImagesBitmap.kt */
        /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03351<T, R> implements b<Bitmap, Pair<? extends String, ? extends Bitmap>> {
            public final /* synthetic */ ImageRequest $imageRequest;

            public C03351(ImageRequest imageRequest) {
                this.$imageRequest = imageRequest;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Pair<? extends String, ? extends Bitmap> call(Bitmap bitmap) {
                return call2(bitmap);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair<String, Bitmap> call2(Bitmap bitmap) {
                return o.to(this.$imageRequest.getImageUri(), bitmap);
            }
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Pair<? extends String, ? extends Bitmap>> call(ImageRequest imageRequest) {
            return call2(imageRequest);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Pair<String, Bitmap>> call2(ImageRequest imageRequest) {
            return MGImagesBitmap.INSTANCE.getBitmap(imageRequest.getImageUri(), imageRequest.getRoundAsCircle()).G(new C03351(imageRequest));
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Pair<? extends String, ? extends Bitmap>, String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ String call(Pair<? extends String, ? extends Bitmap> pair) {
            return call2((Pair<String, Bitmap>) pair);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(Pair<String, Bitmap> pair) {
            return pair.getFirst();
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements b<Pair<? extends String, ? extends Bitmap>, Bitmap> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Bitmap call(Pair<? extends String, ? extends Bitmap> pair) {
            return call2((Pair<String, Bitmap>) pair);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Bitmap call2(Pair<String, Bitmap> pair) {
            return pair.getSecond();
        }
    }

    /* compiled from: MGImagesBitmap.kt */
    /* renamed from: com.discord.utilities.images.MGImagesBitmap$getBitmaps$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements b<Map<String, Bitmap>, CloseableBitmaps> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ CloseableBitmaps call(Map<String, Bitmap> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final CloseableBitmaps call2(Map<String, Bitmap> map) {
            m.checkNotNullExpressionValue(map, "it");
            return new CloseableBitmaps(map, false, 2, null);
        }
    }

    private MGImagesBitmap() {
    }

    public static final Observable<CloseableBitmaps> getBitmaps(Set<ImageRequest> imageRequests) {
        m.checkNotNullParameter(imageRequests, "imageRequests");
        ArrayList arrayList = new ArrayList();
        for (Object obj : imageRequests) {
            if (!t.isBlank(((ImageRequest) obj).getImageUri())) {
                arrayList.add(obj);
            }
        }
        Observable<CloseableBitmaps> observableX = Observable.h0(new q(arrayList)).A(AnonymousClass1.INSTANCE).g0(AnonymousClass2.INSTANCE, AnonymousClass3.INSTANCE).G(AnonymousClass4.INSTANCE).X(j0.p.a.a());
        m.checkNotNullExpressionValue(observableX, "Observable\n        .from…Schedulers.computation())");
        return observableX;
    }

    private final boolean isValidUri(String imageUri) {
        Uri uri = Uri.parse(imageUri);
        m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        String scheme = uri.getScheme();
        if (scheme == null || t.isBlank(scheme)) {
            return false;
        }
        String host = uri.getHost();
        if (host == null || t.isBlank(host)) {
            return false;
        }
        String path = uri.getPath();
        return !(path == null || t.isBlank(path));
    }

    public final Observable<Bitmap> getBitmap(String imageUri, boolean imageIsCircle) {
        m.checkNotNullParameter(imageUri, "imageUri");
        if (!isValidUri(imageUri)) {
            Observable<Bitmap> observableX = Observable.x(new IllegalArgumentException(b.d.b.a.a.w("invalid uri: ", imageUri)));
            m.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…invalid uri: $imageUri\"))");
            return observableX;
        }
        b.f.j.e.m mVar = b.f.j.e.m.a;
        d.y(mVar, "ImagePipelineFactory was not initialized!");
        if (mVar.l == null) {
            mVar.l = mVar.a();
        }
        h hVar = mVar.l;
        ImageRequestBuilder imageRequest = MGImages.getImageRequest(imageUri, 0, 0, false);
        if (imageIsCircle) {
            imageRequest.l = new RoundAsCirclePostprocessor(imageUri);
        }
        Observable<Bitmap> observableH0 = Observable.h0(new AnonymousClass1(hVar.a(imageRequest.a(), null, ImageRequest.c.FULL_FETCH, null, null), imageUri));
        m.checkNotNullExpressionValue(observableH0, "Observable.unsafeCreate …y emits the bitmap.\n    }");
        return observableH0;
    }
}
